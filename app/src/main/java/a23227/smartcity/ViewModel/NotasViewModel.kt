package a23227.smartcity.ViewModel

import a23227.smartcity.Entities.Nota
import a23227.smartcity.db.NotasDB
import a23227.smartcity.db.NotasRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotasViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NotasRepository
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allNotas: LiveData<List<Nota>>

    init {
        val notasDao = NotasDB.getDatabase(application, viewModelScope).NotasDAO()
        repository = NotasRepository(notasDao)
        allNotas = repository.allNotes
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(nota: Nota) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(nota)
    }

    // delete all
    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }

    // delete by city
    /*fun deleteByCity(city: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteByCity(city)
    }

    fun getCitiesByCountry(country: String): LiveData<List<City>> {
        return repository.getCitiesByCountry(country)
    }

    fun getCountryFromCity(city: String): LiveData<City> {
        return repository.getCountryFromCity(city)
    }*/

    fun updateNota(nota: Nota) = viewModelScope.launch {
        repository.updateNota(nota)
    }
    /*
    fun updateCountryFromCity(city: String, country: String) = viewModelScope.launch {
        repository.updateCountryFromCity(city, country)
    }*/
}