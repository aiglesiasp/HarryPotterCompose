package com.ipa.dev.harrypottercompose.framework.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ipa.dev.harrypottercompose.framework.local.model.CharacterLocal
import com.ipa.dev.harrypottercompose.framework.local.model.Converters

@Database(entities = [CharacterLocal::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}

