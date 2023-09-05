package uz.datatalim.password.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.datatalim.password.R
import uz.datatalim.password.model.Citizens

class CitizensAdapter(list: ArrayList<Citizens>, requireContext: Context) :RecyclerView.Adapter<CitizensAdapter.CitizensViewHolder>(){

    var onClick:((Int)->Unit)? =null

    var list: ArrayList<Citizens> =ArrayList()

        set(value){
            field=value
            notifyDataSetChanged()
        }

    fun submitList(list:ArrayList<Citizens>){

        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitizensViewHolder {
        return CitizensViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false))
    }

    override fun getItemCount(): Int {

        return list.size

    }

    override fun onBindViewHolder(holder: CitizensViewHolder, position: Int) {
        holder.apply {

            tvName.text=list[position].lastName
            tvName.text=list[position].name
            tvPassNum.text=list[position].passNum

            tvLLList.setOnClickListener {

                onClick?.invoke(position)

            }

        }
    }

    class CitizensViewHolder (view:View):RecyclerView.ViewHolder(view){

        val tvName:TextView=view.findViewById(R.id.tvName_item)
        val tvPassNum:TextView=view.findViewById(R.id.tvPassNum_item)
        val tvLLList: LinearLayout =view.findViewById(R.id.llTitle)

    }

}