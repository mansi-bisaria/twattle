package com.mansi.twattle.model

import io.realm.RealmObject

open class Student(var SubName:String,
                   var SubDetails:String, var SubSyllabus:String, var StartDate:String, var EndDate:String): RealmObject()