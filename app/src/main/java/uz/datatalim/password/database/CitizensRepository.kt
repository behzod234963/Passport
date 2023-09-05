package uz.datatalim.password.database

import android.app.Application
import uz.datatalim.password.model.Citizens

class CitizensRepository(val app:Application) {

    var passDao=CitizensDBCore.citizensDataBase(app).getDao()

    fun savePassport(pass:Citizens){

        passDao.savePassport(pass)

    }

    fun getAllData():List<Citizens>{

        return passDao.getAll()

    }

    fun getPassById(id:Int):List<Citizens>{

        return passDao.getPassById(id)

    }

    fun clearData(pass:List<Citizens>){

        passDao.clearPass(pass)

    }

}