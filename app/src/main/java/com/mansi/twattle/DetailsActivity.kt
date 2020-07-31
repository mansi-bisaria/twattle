package com.mansi.twattle


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mansi.twattle.R.id
import com.mansi.twattle.model.Student
import com.mansi.twattle.model.StudentStructure
import io.realm.Realm
import io.realm.kotlin.createObject

class DetailsActivity : AppCompatActivity() {

    lateinit var SubName: EditText
    lateinit var SubDetails: EditText
    lateinit var SubSyllabus: EditText
    lateinit var StartDate: EditText
    lateinit var EndDate: EditText
    lateinit var btnAdd: Button
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {


        supportActionBar?.title = "Subject Details"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        SubName = findViewById(id.etSubName)
        SubDetails = findViewById(id.etSubDetalis)
        SubSyllabus = findViewById(id.etSubSyllabus)
        StartDate = findViewById(id.etStartDate)
        EndDate = findViewById(id.etEndDate)
        btnAdd = findViewById(id.btnAdd)

        btnAdd.setOnClickListener {
            realm = Realm.getDefaultInstance()


            realm.executeTransaction { realm ->
                // Add a person
                val student = realm.createObject<StudentStructure>()
                student.SubName = SubName.text.toString()
                student.SubDetails = SubDetails.text.toString()
                student.SubSyllabus = SubSyllabus.text.toString()
                student.StartDate = StartDate.text.toString()
                student.EndDate = EndDate.text.toString()
            }

            realm.close()
            onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id=item.itemId
        if(id==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }



        }
