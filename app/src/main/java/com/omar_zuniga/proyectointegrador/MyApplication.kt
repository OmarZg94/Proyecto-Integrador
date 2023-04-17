package com.omar_zuniga.proyectointegrador

import android.app.Application
import com.omar_zuniga.proyectointegrador.data.AppDatabase
import com.omar_zuniga.proyectointegrador.data.tickets.TicketsRepository

class MyApplication : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val ticketsRepository by lazy { TicketsRepository(database.ticketDao()) }
}