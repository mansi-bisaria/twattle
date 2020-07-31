package com.mansi.twattle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.EndElementListener
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.mansi.twattle.model.Student
import com.mansi.twattle.model.StudentStructure
import io.realm.Realm
import io.realm.kotlin.where
import java.util.jar.Attributes
import kotlin.collections.forEach as forEach1


class DisplayDetails : AppCompatActivity() {

    lateinit var SubName: TextView
    lateinit var SubDetails: TextView
    lateinit var SubSyllabus: TextView
    lateinit var StartDate: TextView
    lateinit var realm: Realm
    lateinit var EndDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_details)
        realm = Realm.getDefaultInstance()

        supportActionBar?.title="Subject Details"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        SubName = findViewById(R.id.txtSubName)
        SubDetails = findViewById(R.id.txtSubDetails)
        SubSyllabus = findViewById(R.id.txtSubSyllabus)
        StartDate = findViewById(R.id.txtStartDate)
        EndDate = findViewById(R.id.txtEndDate)


        if(intent!= null) {

            val student=realm.where<StudentStructure>().findFirst()!!
            SubName.text=student.SubName
            SubDetails.text=student.SubDetails
            SubSyllabus.text=student.SubSyllabus
            StartDate.text=student.StartDate
            EndDate.text=student.EndDate

            realm.close()
        }
        else {
            finish()
            Toast.makeText(this,"No such case exists !",Toast.LENGTH_SHORT).show()
        }






    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    }
