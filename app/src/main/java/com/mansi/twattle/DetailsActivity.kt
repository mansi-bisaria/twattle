package com.mansi.twattle


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import com.mansi.twattle.R.id
import com.mansi.twattle.model.Student
import io.realm.Realm
import io.realm.kotlin.createObject

class DetailsActivity : AppCompatActivity() {

    lateinit var etSubName: EditText
    lateinit var etSubDetails: EditText
    lateinit var etSubSyllabus: EditText
    lateinit var etStartDate: EditText
    lateinit var etEndDate: EditText
    lateinit var btnAdd: Button
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {

        realm = Realm.getDefaultInstance()

        supportActionBar?.title="Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)




        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        etSubName=findViewById(id.etSubName)
        etSubDetails=findViewById(id.etSubDetalis)
        etSubSyllabus=findViewById(id.etSubSyllabus)
        etStartDate=findViewById(id.etStartDate)
        etEndDate=findViewById(id.etEndDate)
        btnAdd=findViewById(id.btnAdd)

        btnAdd.setOnClickListener {
            basicCRUD(realm)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id=item.itemId
        if(id==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    @Suppress("NAME_SHADOWING")
    private fun basicCRUD(realm: Realm) {

        // All writes must be wrapped in a transaction to facilitate safe multi threading
        realm.executeTransaction { realm ->
            // Add a person
            val student = realm.createObject<Student>(0)
            student.SubName = "English"
            student.SubDetails = "Language"
            student.SubSyllabus = "chapter 14"
            student.StartDate = "1st January"
            student.EndDate = "4th January"


        }
    }
}