package uz.datatalim.password.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pass")
data class Citizens(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val name:String,
    val lastName:String,
    val fatherName:String,
    val location:String,
    val city:String,
    val passNum:String,
    val passgetData:String,
    val passData:String,
    val sex:String)
