package com.omar_zuniga.proyectointegrador.data.tickets

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ticket")
data class TicketEntity(
    @PrimaryKey val id: Long,
    val date: String,
    val img: String
)
