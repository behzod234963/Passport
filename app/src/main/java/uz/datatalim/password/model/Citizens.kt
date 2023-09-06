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
    val sex:String) {
    override fun toString(): String {
        val info="Ism: $name\n\n" +
                " Familiya: $lastName\n\n" +
                " Otasining ismi: $fatherName\n\n" +
                " Viloyat: $location\n\n " +
                "Shahar,tuman:" +
                " $city\n\n" +
                " Passport seriyasi: $passNum\n\n" +
                " Berilgan vaqti: $passgetData\n\n" +
                " Tugash muddati: $passData\n\n" +
                " Jinsi: $sex"
        return  info
    }
}

