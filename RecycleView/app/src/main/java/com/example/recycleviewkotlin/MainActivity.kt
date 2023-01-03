package com.example.recycleviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewkotlin.Adapter.MyRecycleViewAdapter
import java.util.*

class MainActivity : AppCompatActivity() ,MyRecycleViewAdapter.MyItemClickListner{

    val datalist=ArrayList<ItemsViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addItemToArrayList()
        intializeRecycleView()
    }

    fun intializeRecycleView(){
        /**
         *   1)Initialize adapter.
         *   2)Set layuout manager for RecycleView.
         *   3)Set adapter for RecycleView.
         */
        val recyclerView:RecyclerView=findViewById(R.id.recycleView_main)
        val myRecycleViewAdapter:MyRecycleViewAdapter=MyRecycleViewAdapter(datalist,this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=myRecycleViewAdapter

    }


    fun addItemToArrayList(){
        datalist.add(ItemsViewModel(R.drawable.ic_baseline_account_circle_24,"Account",0))
        datalist.add(ItemsViewModel(R.drawable.ic_baseline_battery_full_24,"Battery Full",1))
        datalist.add(ItemsViewModel(R.drawable.ic_baseline_chair_24,"Chair",2))
        datalist.add(ItemsViewModel(R.drawable.ic_baseline_family_restroom_24,"Rest Room Family",3))
        datalist.add(ItemsViewModel(R.drawable.ic_baseline_touch_app_24,"Sensor Working",4))
        datalist.add(ItemsViewModel(R.drawable.ic_baseline_unsubscribe_24,"Unsubscribe",5))
        datalist.add(ItemsViewModel(R.drawable.ic_baseline_thumb_up_24,"Like",6))
        datalist.add(ItemsViewModel(R.drawable.ic_baseline_thumb_down_24,"UnLike",7))
    }

    override fun myItemClicked(poisition: Int) {
//        Toast.makeText(this, "ItemClicked ${poisition}", Toast.LENGTH_SHORT).show()
        Log.d("Mandira", "myItemClicked: ${poisition}")
    }
}