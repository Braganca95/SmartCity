package a23227.smartcity.dao

import a23227.smartcity.Entities.Nota
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotasDAO{

    @Query("Select * From notas Order By id")
    fun getNotas(): LiveData<List<Nota>>

    @Query("Select * From notas Where id =:id")
    fun getNota(id:Int): LiveData<Nota>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(nota: Nota)

    @Query("Delete From notas")
    suspend fun deleteAll()

    @Query("Delete From notas Where id = :id")
    suspend fun deleteByID(id: Int?)

    @Update
    suspend fun updateNota(nota: Nota)

}