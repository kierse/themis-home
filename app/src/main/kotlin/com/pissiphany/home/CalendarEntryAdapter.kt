package com.pissiphany.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.pissiphany.home.domain.model.CalendarEntry

/**
 * Created by kierse on 2016-09-05.
 */
class CalendarEntryAdapter(context: Context, layout: Int) : ArrayAdapter<CalendarEntry>(context, layout) {
    private data class ViewHolder(
            val summary: TextView, val location: TextView, val startDate: TextView
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val entry = getItem(position)

        val view:  View?
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.calendar_entry_list_item, parent, false)

            holder = ViewHolder(
                    view.findViewById(R.id.summary) as TextView,
                    view.findViewById(R.id.location) as TextView,
                    view.findViewById(R.id.startDate) as TextView
            )
            view.setTag(holder)
        } else {
            view = convertView
            holder = view.getTag() as ViewHolder
        }

        holder.summary.text = entry.summary.toString()
        holder.location.text = entry.startDate.toString()
        holder.startDate.text = entry.startDate.toString()

        return view
    }
}