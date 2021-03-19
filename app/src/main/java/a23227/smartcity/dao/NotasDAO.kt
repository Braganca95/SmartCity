package a23227.smartcity.dao

import a23227.smartcity.Entities.Nota
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotasDAO{

    @Query("Select * From notas Order By data")
    fun getNotas(): LiveData<List<Nota>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(nota: Nota)

    @Query("Delete From notas")
    suspend fun deleteAll()

    @Update
    suspend fun updateNota(nota: Nota)
}