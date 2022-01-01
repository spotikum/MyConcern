package com.wicaksana.retrofit.coroutines.ui.finance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.wicaksana.retrofit.coroutines.R
import com.wicaksana.retrofit.coroutines.data.api.ApiHelper
import com.wicaksana.retrofit.coroutines.data.api.RetrofitBuilder
import com.wicaksana.retrofit.coroutines.databinding.ActivityInputBinding
import com.wicaksana.retrofit.coroutines.ui.base.ViewModelFactory

class InputActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityInputBinding
    private lateinit var viewModel: FinanceViewModel
    private lateinit var category: String
    private lateinit var type: String
    private lateinit var rb: RadioButton
    private var selectedId: Int = 0
    private var value: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory(RetrofitBuilder.apiService)
        viewModel = ViewModelProviders.of(this, factory).get(FinanceViewModel::class.java)

        populateUI()

        binding.btnSubmit.setOnClickListener {
            value = Integer.parseInt(binding.etValue.text.toString())
            selectedId = binding.radioType.checkedRadioButtonId
            rb = findViewById(selectedId)
            when (rb.text) {
                "Smaller Than" -> type = "<="
                "Bigger Than" -> type = ">="
                else -> type = "=="
            }

            viewModel.postYahooStatis(category, type, value!!)

            viewModel.data.observe(this, {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(ResultActivity.MSG, viewModel.msg.value)
                intent.putExtra(ResultActivity.EXTRA_DATA, it)
                startActivity(intent)
            })
        }
    }

    private fun populateUI() {
        ArrayAdapter.createFromResource(
            this,
            R.array.category_name,
            android.R.layout.simple_spinner_item
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.categorySpin.adapter = arrayAdapter
        }

        binding.categorySpin.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        category = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}