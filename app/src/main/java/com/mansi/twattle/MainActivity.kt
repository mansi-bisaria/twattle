package com.mansi.twattle

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mansi.twattle.model.Student
import io.realm.DynamicRealm
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject


class MainActivity : AppCompatActivity() {

    lateinit var recyclerMain: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var btnAdd: Button
    lateinit var recyclerAdapter: MainRecyclerAdapter
    lateinit var realm: Realm
    val subList = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .name("tasky.realm")
            .schemaVersion(0)
            .build()
        Realm.setDefaultConfiguration(realmConfig)



        recyclerMain = findViewById(R.id.recyclerMain)
        layoutManager = LinearLayoutManager(this)
        recyclerAdapter = MainRecyclerAdapter(this as Context, subList)

        recyclerMain.adapter = recyclerAdapter
        recyclerMain.layoutManager = layoutManager

        btnAdd = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)

        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }


}