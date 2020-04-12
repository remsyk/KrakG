package com.example.krakg.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.krakg.R
import com.example.krakg.ui.activities.SettingsActivity
import kotlinx.android.synthetic.main.fragment_settings.view.*
import kotlinx.android.synthetic.main.viewgroup_setting_item_textviews.view.*
import kotlinx.android.synthetic.main.viewgroup_settings_item.view.*


class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.setCustomView(R.layout.viewgroup_actionbar_settings)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.setCustomView(R.layout.viewgroup_actionbar_settings)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {

            include_notification_item.include_text_items.textview_title_settings.text = "Notifications"
            include_notification_item.include_text_items.textview_subtitle_settings.text = "Set notification settings"
            include_notification_item.imageview_settings_item.setImageDrawable(resources.getDrawable(R.drawable.ic_notifications_24px,activity!!.theme))
            include_notification_item.setOnClickListener {
                context.startActivity(Intent(context, SettingsActivity::class.java).putExtra("loadFragment", 1))
            }

            include_imports_item.include_text_items.textview_title_settings.text = "Imports/Exports"
            include_imports_item.include_text_items.textview_subtitle_settings.text = "Here you can settle the imports and exports"
            include_imports_item.imageview_settings_item.setImageDrawable(resources.getDrawable(R.drawable.ic_import_export_24px,activity!!.theme))
            include_imports_item.setOnClickListener {
                context.startActivity(Intent(context, SettingsActivity::class.java).putExtra("loadFragment", 2))
            }

            include_transfer_item.include_text_items.textview_title_settings.text = "Transfer Funds"
            include_transfer_item.include_text_items.textview_subtitle_settings.text = "Transfer funds out of the bot"
            include_transfer_item.imageview_settings_item.setImageDrawable(resources.getDrawable(R.drawable.ic_import_contacts_24px,activity!!.theme))
            include_transfer_item.setOnClickListener {
                context.startActivity(Intent(context, SettingsActivity::class.java).putExtra("loadFragment", 3))
            }

            include_controls_item.include_text_items.textview_title_settings.text = "Control Panel"
            include_controls_item.include_text_items.textview_subtitle_settings.text = "Other settings"
            include_controls_item.imageview_settings_item.setImageDrawable(resources.getDrawable(R.drawable.ic_settings_24px,activity!!.theme))
            include_controls_item.setOnClickListener {
                context.startActivity(Intent(context, SettingsActivity::class.java).putExtra("loadFragment", 4))
            }
        }
    }
}