package com.joyner.dogcatalog.data.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.joyner.dogcatalog.data.db.converters.DogBreedsTypeConverter

@TypeConverters(DogBreedsTypeConverter::class)
@Entity(tableName = "dog_breeds")
data class DogBreed(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo(name = "breed")
    val breed: String,
    @ColumnInfo(name = "sub_breed")
    val subBreed: List<String>
)
