package com.example.krakg.ui.fragments.bots_expanded

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import com.example.krakg.R

class ConditionMakerDialog: DialogFragment() {


    lateinit var customView: View
    private val buySellList = listOf("Title One", "Title Two", "Title Three", "Title Four")

   /* private val buySellAdapter: ArrayAdapter<String> = ArrayAdapter(context, R.layout.textview_autocomplete_menu_item,buySellList)
    private val _ifAdapter: ArrayAdapter<String> = ArrayAdapter(context, R.layout.textview_autocomplete_menu_item,buySellList)
    private val interval1Adapter: ArrayAdapter<String> = ArrayAdapter(context, R.layout.textview_autocomplete_menu_item,buySellList)
    private val indicator1Adapter: ArrayAdapter<String> = ArrayAdapter(context, R.layout.textview_autocomplete_menu_item,buySellList)
    private val operatorAdapter: ArrayAdapter<String> = ArrayAdapter(context, R.layout.textview_autocomplete_menu_item,buySellList)
    private val interval2Adapter: ArrayAdapter<String> = ArrayAdapter(context, R.layout.textview_autocomplete_menu_item,buySellList)
    private val indicator2Adapter: ArrayAdapter<String> = ArrayAdapter(context, R.layout.textview_autocomplete_menu_item,buySellList)*/



    /*buySell.setAdapter(buySellAdapter)
    _if.setAdapter(_ifAdapter)
    interval1.setAdapter(interval1Adapter)
    indicator1.setAdapter(indicator1Adapter)
    operator.setAdapter(operatorAdapter)
    interval2.setAdapter(interval2Adapter)
    indicator2.setAdapter(indicator2Adapter)
*/

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //customView = LayoutInflater.inflate(context!!, R.layout.viewgroup_dialog_condition)
        return AlertDialog.Builder(context!!)
            .setTitle("weee")
            .create()

    }
}