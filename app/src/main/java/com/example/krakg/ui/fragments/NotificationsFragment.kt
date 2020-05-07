package com.example.krakg.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.krakg.R
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.viewgroup_notifications_item.view.*

class NotificationsFragment : Fragment() {


    //TODO build out notifications

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        include_notification_item_1.textview_title_notification.text = "Bot Notifications"
        include_notification_item_1.textview_subtitle_notification.text = "These are the notification your bots will give you"

        include_notification_item_2.textview_title_notification.text = "Market Notifications"
        include_notification_item_2.textview_subtitle_notification.text = "These are the notification for the Kraken market"

        include_notification_item_3.textview_title_notification.text = "Other Notifications"
        include_notification_item_3.textview_subtitle_notification.text = "Just another thing"
    }
}