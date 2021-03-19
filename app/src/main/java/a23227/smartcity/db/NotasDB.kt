package a23227.smartcity.db

import a23227.smartcity.Entities.Nota
import a23227.smartcity.dao.NotasDAO
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

@Database(entities = arrayOf(Nota::class), version = 8, exportSchema = false)
public abstract class NotasDB : RoomDatabase() {

    abstract fun NotasDAO(): NotasDAO

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var NotasDAO = database.NotasDAO()

                    // Delete all content here.
                    NotasDAO.deleteAll()

                    // Add sample cities.
                    var nota = Nota(0,"primeira", "info1", "Hoje")
                    NotasDAO.insert(nota)
                    nota = Nota(1,"segunda", "info2", "Hoje")
                    NotasDAO.insert(nota)
                    nota = Nota(2,"terceira", "info3","Hoje")
                    NotasDAO.insert(nota)

                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: NotasDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): NotasDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotasDB::class.java,
                    "notas"
                )
                    //estratégia de destruição
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}