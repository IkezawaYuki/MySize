package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Spinner
import androidx.core.content.edit
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

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val heightVal = pref.getInt("HEIGHT", 160)
        height.text = heightVal.toString()
        seekBar_height.progress = heightVal
        
        seekBar_height.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    height.text = progress.toString()
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }

            }
        )

        spinner_weight.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val spinner_weight = parent as? Spinner
                    val item = spinner_weight?.selectedItem as? String
                    item?.let {
                        if(it.isNotEmpty()) weight.text = it
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }

        val weightVal = pref.getInt("WEIGHT", 60)
        weight.text = weightVal.toString()
        seekBar_weight.progress = weightVal

        seekBar_weight.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    weight.text = progress.toString()
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }
            }
        )

        radioGroup.setOnCheckedChangeListener{
            group, checkedId -> height.text = findViewById<RadioButton>(checkedId).text
        }
    }

    override fun onPause() {
        super.onPause()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            putInt("HEIGHT", height.text.toString().toInt())
            putInt("WEIGHT", weight.text.toString().toInt())
        }
    }
}
