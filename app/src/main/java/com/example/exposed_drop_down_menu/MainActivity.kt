package com.example.exposed_drop_down_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.exposed_drop_down_menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val countries = resources.getStringArray(R.array.country_location)
        val adapter = ArrayAdapter(
            this,
            R.layout.list_item,
            countries
        )

        with(mBinding.autoCompleteTextView){
            setAdapter(adapter)
            onItemClickListener = this@MainActivity
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item  = parent?.getItemAtPosition(position).toString()
        setDataInView(item)
        //Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
    }

    fun setDataInView(item: String){
        mBinding.tvCountry.text = item
    }

}