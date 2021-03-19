package a23227.smartcity.db

import a23227.smartcity.Entities.Nota
import a23227.smartcity.dao.NotasDAO
import androidx.lifecycle.LiveData


class NotasRepository(private val NotasDAO: NotasDAO) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allNotes: LiveData<List<Nota>> = NotasDAO.getNotas()

    /*fun getCitiesByCountry(country: String): LiveData<List<Nota>> {
        return cityDao.getCitiesByCountry(country)
    }

    fun getCountryFromCity(city: String): LiveData<City> {
        return cityDao.getCountryFromCity(city)
    }*/

    suspend fun insert(nota: Nota) {
        NotasDAO.insert(nota)
    }

    suspend fun deleteAll() {
        NotasDAO.deleteAll()
    }

    /*suspend fun deleteByNote(city: String) {
        NotasDAO.deleteByCity(city)
    }*/

    suspend fun updateNota(nota: Nota) {
        NotasDAO.updateNota(nota)
    }

    /*suspend fun updateCountryFromCity(city: String, country: String) {
        NotasDAO.updateCountryFromCity(city, country)
    }*/
}
