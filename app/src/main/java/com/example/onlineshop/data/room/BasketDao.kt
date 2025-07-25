package com.example.onlineshop.data.room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import com.example.onlineshop.domain.model.BasketItem
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketDao {
    @Query("SELECT * FROM basket")
    fun getAllItems(): Flow<List<BasketItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: BasketItem)

    @Delete
    suspend fun delete(item: BasketItem)

    @Update
    suspend fun update(item: BasketItem)

    @Query("DELETE FROM basket")
    suspend fun clearBasket()
}

@Database(entities = [BasketItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun basketDao(): BasketDao
}
