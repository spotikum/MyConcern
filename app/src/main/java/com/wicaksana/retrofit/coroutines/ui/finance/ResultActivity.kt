package com.wicaksana.retrofit.coroutines.ui.finance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.wicaksana.retrofit.coroutines.data.model.YahooStatis
import com.wicaksana.retrofit.coroutines.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var msg: String
    private lateinit var data: ArrayList<YahooStatis>
    private lateinit var adapterFinance: FinanceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        msg = intent.getStringExtra(MSG)!!
        data = intent.getParcelableArrayListExtra(EXTRA_DATA)

        populateAdapter()
    }

    private fun populateAdapter() {
        adapterFinance = FinanceAdapter()
        with(binding.rv) {
            layoutManager = LinearLayoutManager(this@ResultActivity)
            setHasFixedSize(true)
            adapter = adapterFinance
        }
        adapterFinance.postData(data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val MSG = "msg"
        const val EXTRA_DATA = "data"
    }
}