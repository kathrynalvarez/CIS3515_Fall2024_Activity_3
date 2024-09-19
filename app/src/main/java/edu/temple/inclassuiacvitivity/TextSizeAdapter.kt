package edu.temple.inclassuiacvitivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TextSizeAdapter(private val _context: Context, private val numbers: Array<Int>) : BaseAdapter() {

    override fun getCount(): Int {
        return  numbers.size
    }

    override fun getItem(position: Int): Any {
        return numbers[position]
    }

    override fun getItemId(position: Int): Long {
        return numbers[position].toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView: TextView


        if (convertView != null) {
            textView = convertView as TextView
        }else {
            textView = TextView(_context)
            textView.textSize = 22f
            textView.setPadding(5, 10, 0, 10)


        }
        textView.text = numbers[position].toString()
        return textView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return super.getDropDownView(position, convertView, parent).apply {
            getView(position, convertView, parent).apply {
                (this as TextView).textSize = numbers[position].toFloat()
            }
        }
    }

}
