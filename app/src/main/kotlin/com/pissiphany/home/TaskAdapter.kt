package com.pissiphany.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.pissiphany.home.domain.model.Task

/**
 * Created by kierse on 2016-09-05.
 */
class TaskAdapter(context: Context, layout: Int) : ArrayAdapter<Task>(context, layout) {
    private data class ViewHolder(
            val name: TextView, val dueAt: TextView, val priority: TextView
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val task = getItem(position)

        val view:  View?
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.task_list_item, parent, false)

            holder = ViewHolder(
                    view.findViewById(R.id.name) as TextView,
                    view.findViewById(R.id.dueAt) as TextView,
                    view.findViewById(R.id.priority) as TextView
            )
            view.setTag(holder)
        } else {
            view = convertView
            holder = view.getTag() as ViewHolder
        }

        holder.name.text = task.name.toString()
        holder.dueAt.text = task.dueAt.toString()
        holder.priority.text = task.priority

        return view
    }
}