package com.pissiphany.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.pissiphany.home.domain.model.Matter

/**
 * Created by kierse on 2016-09-03.
 */
class MatterAdapter(context: Context, layout: Int) : ArrayAdapter<Matter>(context, layout) {
    private data class ViewHolder(
            val displayNumber: TextView, val updatedAt: TextView, val description: TextView
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val matter = getItem(position)

        val view:  View?
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.matter_list_item, parent, false)

            holder = ViewHolder(
                    view.findViewById(R.id.displayNumber) as TextView,
                    view.findViewById(R.id.updatedAt) as TextView,
                    view.findViewById(R.id.description) as TextView
            )
            view.setTag(holder)
        } else {
            view = convertView
            holder = view.getTag() as ViewHolder
        }

        holder.displayNumber.text = matter.displayNumber.toString()
        holder.updatedAt.text = matter.updatedAt.toString()
        holder.description.text = matter.description

        return view
    }
}