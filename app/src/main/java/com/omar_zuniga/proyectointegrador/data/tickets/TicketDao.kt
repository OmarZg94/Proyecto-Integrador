package com.omar_zuniga.proyectointegrador.data.tickets

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TicketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTicket(vararg ticket: TicketEntity)

    @Delete
    fun deleteTicket(ticketEntity: TicketEntity)

    @Query("SELECT * from ticket")
    fun selectAllTickets(): Flow<List<TicketEntity>>
}