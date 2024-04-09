package com.bbk.multilanguagetest

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat


class MainActivity : AppCompatActivity() {

    private lateinit var messageView: TextView
    private lateinit var btnArabic: Button
    private lateinit var btnEnglish: Button
    private lateinit var imgView: ImageView
    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // referencing the text and button views
        messageView = findViewById(R.id.textView)
        btnArabic = findViewById(R.id.btnArabic)
        btnEnglish = findViewById(R.id.btnEnglish)
        imgView = findViewById(R.id.imageView)

        context = LocaleHelper.getLocale(this)

        if (context == null) {
            messageView.text = resources.getString(R.string.hello_world)
            imgView.setImageDrawable(resources.getDrawable(R.drawable.country_flag, null))
        } else {
            messageView.text = context!!.resources.getString(R.string.hello_world)
            imgView.setImageDrawable(context!!.resources.getDrawable(R.drawable.country_flag, null))
        }

        // setting up on click listener event over the button
        // in order to change the language with the help of
        // LocaleHelper class
        btnEnglish.setOnClickListener {
            context = LocaleHelper.setLocale(this, "en")
            messageView.text = context!!.resources.getString(R.string.hello_world)
            imgView.setImageDrawable(context!!.resources.getDrawable(R.drawable.country_flag, null))
            ViewCompat.setLayoutDirection(findViewById(R.id.layout), ViewCompat.LAYOUT_DIRECTION_LTR)
        }

        btnArabic.setOnClickListener {
            context = LocaleHelper.setLocale(this, "ar")
            messageView.text = context!!.resources.getString(R.string.hello_world)
            imgView.setImageDrawable(context!!.resources.getDrawable(R.drawable.country_flag, null))
            ViewCompat.setLayoutDirection(findViewById(R.id.layout), ViewCompat.LAYOUT_DIRECTION_RTL)
        }
    }
}