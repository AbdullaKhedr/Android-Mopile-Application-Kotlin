package qu.cmps312.countryvisit.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import qu.cmps312.countryvisit.db.VisitsDB
import qu.cmps312.countryvisit.model.Country
import qu.cmps312.countryvisit.model.Visit

class Repository(private val context: Context) {

    private val visitsDB by lazy {
        VisitsDB.getDatabase(context)
    }
    private val visitsDao by lazy {
        visitsDB.getVisitsDao()
    }
    private val continentsDao by lazy {
        visitsDB.getContinentsDao()
    }
    private val countriesDao by lazy {
        visitsDB.getCountriesDao()
    }

    fun initDB() {
        GlobalScope.launch {
            VisitsDB.initDB(visitsDB, context)
        }
    }

    suspend fun getCountries() = countriesDao.getCountries()
    suspend fun getCountriesByContinent(continentName: String) =
        countriesDao.getCountriesByContinent(continentName)

    fun getContinents() = continentsDao.getContinents()
    fun getVisits() = visitsDao.getVisits()
    suspend fun insertVisit(visit: Visit) = visitsDao.insertVisit(visit)
    suspend fun deleteVisit(visit: Visit) = visitsDao.deleteVisit(visit)
    suspend fun updateVisit(visit: Visit) = visitsDao.updateVisit(visit)

}