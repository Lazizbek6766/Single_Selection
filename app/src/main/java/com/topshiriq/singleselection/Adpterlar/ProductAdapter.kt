package com.topshiriq.singleselection.Adpterlar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.topshiriq.singleselection.Shablon.ProduktShablaon
import com.topshiriq.singleselection.databinding.NamunaBinding

class ProductAdapter(
    val context: Context,
    val arrayList: ArrayList<ProduktShablaon>
):RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = NamunaBinding.inflate(LayoutInflater.from(context), parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            if (arrayList.get(position).selection) {
                cheket1.visibility = View.VISIBLE

            } else {
                cheket1.visibility = View.INVISIBLE
            }

            imageViewCatygory.setImageResource(arrayList[position].image)
            textViewCatygory.text = arrayList[position].catygoryname
            textViewName.text = arrayList[position].productname
            textViewNarx.text = "${arrayList[position].narx} $"

            btnProdukt.setOnClickListener {

                var a = arrayList.get(position).selection

                for (element in arrayList){
                    element.selection = false
                }
                notifyDataSetChanged()
                // bu yerda arrayList.get(position).selection = true
                // a edsa true yoki false bolishi mumkin

                arrayList.get(position).selection = !arrayList.get(position).selection

                if(a){  //bu bilan oldin belgilagan ekenimizni tekshiramiz

                    for (element in arrayList){
                        element.selection = false
                    }
                    notifyDataSetChanged()
                }else {
                    if (arrayList.get(position).selection) {
                        cheket1.visibility = View.VISIBLE
                    }
                }

            }

        }
    }

    override fun getItemCount(): Int = arrayList.size

    class MyViewHolder(val binding:NamunaBinding):RecyclerView.ViewHolder(binding.root)
}