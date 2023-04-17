package com.omar_zuniga.proyectointegrador.data.tickets

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TicketsRepository(private val ticketDao: TicketDao) {

    val tickets: Flow<List<TicketEntity>> = ticketDao.selectAllTickets()

    @WorkerThread
    suspend fun insertTicket(ticket: TicketEntity) {
        ticketDao.insertTicket(ticket)
    }
}