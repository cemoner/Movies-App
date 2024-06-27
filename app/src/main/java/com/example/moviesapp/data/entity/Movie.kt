package com.example.moviesapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "filmler")
data class Movie(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") @NotNull val movie_id:Int,
    @ColumnInfo(name="ad") @NotNull var movie_name:String,
    @ColumnInfo(name="resim") @NotNull var movie_image:String,
    @ColumnInfo(name="fiyat") @NotNull var movie_price:Int)
    :Serializable
