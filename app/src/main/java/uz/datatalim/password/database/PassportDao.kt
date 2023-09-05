package uz.datatalim.password.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.datatalim.password.model.Citizens

@Dao
interface PassportDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePassport(pass:Citizens)

    @Query("SELECT *FROM pass")
    fun getAll():List<Citizens>

    @Query("SELECT *FROM pass WHERE id=:id")
    fun getPassById(id:Int):List<Citizens>

    @Delete
    fun clearPass(pass:List<Citizens>)

}