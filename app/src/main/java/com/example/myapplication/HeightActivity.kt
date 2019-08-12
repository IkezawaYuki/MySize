package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_height.*

class HeightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_height)

        spinner_height.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val spinner_height = parent as? Spinner
                    val item = spinner_height?.selectedItem as? String
                    item?.let {
                        if(it.isNotEmpty()) height.text = it
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

        spinner_weight.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val spinner_weight = parent as? Spinner
                    val item = spinner_weight?.selectedItem as? String
                    item?.let {
                        if(it.isNotEmpty()) weight.text = it
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }

        
    }
}
