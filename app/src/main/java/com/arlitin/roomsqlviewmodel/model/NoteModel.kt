package com.arlitin.roomsqlviewmodel.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_table")

class NoteModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    var title: String = "dd",

    @ColumnInfo
    var desc: String = "dd"

) : Serializable