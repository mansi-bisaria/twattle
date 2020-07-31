package com.mansi.twattle.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class StudentStructure( var SubName:String="l",
                            var SubDetails:String="m", var SubSyllabus:String="o", var StartDate:String="p", var EndDate:String="k"): RealmObject(){


}