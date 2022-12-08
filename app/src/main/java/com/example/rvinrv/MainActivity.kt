package com.example.rvinrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.rvinrv.databinding.ActivityMainBinding
import com.example.rvinrv.databinding.ItemRvBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val rvAdapter = RVAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMockdata()
        binding.recyclerView.adapter = rvAdapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        )
    }

    private fun setMockdata(){
        var i = 0
        val data = mutableListOf<RVItem>()
        repeat(20){
            val innerData = mutableListOf<Person>()
            repeat(30){
                    innerData.add(
                        Person(i,R.drawable.newyork,R.drawable.newyork,"name $i")
                    )
                i++
            }
            data.add(RVItem(it,innerData))
        }

        rvAdapter.models = data
    }
}