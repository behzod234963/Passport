package uz.datatalim.password.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.datatalim.password.model.Citizens

@Database(entities = [Citizens::class], version = 1)
abstract class CitizensDBCore :RoomDatabase(){

    abstract fun getDao():PassportDao

    companion object{

        var DB_INSTANCE:CitizensDBCore?=null

        fun citizensDataBase(ctx:Context):CitizensDBCore{

            if (DB_INSTANCE==null){

                DB_INSTANCE= Room.databaseBuilder(ctx.applicationContext,CitizensDBCore::class.java,"passport").allowMainThreadQueries().build()

            }

            return DB_INSTANCE!!

        }

    }

}