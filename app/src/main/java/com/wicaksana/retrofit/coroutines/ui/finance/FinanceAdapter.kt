package com.wicaksana.retrofit.coroutines.ui.finance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wicaksana.retrofit.coroutines.data.model.YahooStatis
import com.wicaksana.retrofit.coroutines.databinding.ItemFinanceBinding

class FinanceAdapter: RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder>() {
    private var items: ArrayList<YahooStatis> = ArrayList()

    fun postData(items: ArrayList<YahooStatis>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class FinanceViewHolder(private val binding: ItemFinanceBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: YahooStatis) {
            binding.tvSymbol.text = item.relationSymbol
            binding.tvDate.text = item.date
            binding.tvPer.text = item.per.toString()
            binding.tvEps.text = item.eps.toString()
            binding.tvRoa.text = item.roa.toString()
            binding.tvRoe.text = item.roe.toString()
            binding.tvDer.text = item.der.toString()
            binding.tvPbv.text = item.pbv.toString()
            binding.tvDy.text = item.dy.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ItemFinanceBinding.inflate(view, parent, false)
        return FinanceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}