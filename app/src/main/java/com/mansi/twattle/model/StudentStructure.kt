package com.mansi.twattle.model

import io.realm.RealmObject

open class StudentStructure(var SubName:String="n",
                            var SubDetails:String="m", var SubSyllabus:String="o", var StartDate:String="p", var EndDate:String="k"): RealmObject()