package com.omar_zuniga.proyectointegrador

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.omar_zuniga.proyectointegrador.data.AppDatabase
import com.omar_zuniga.proyectointegrador.data.tickets.TicketDao
import com.omar_zuniga.proyectointegrador.data.tickets.TicketEntity
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.concurrent.Executors

@RunWith(AndroidJUnit4::class)
class RoomUnitTest {
    private lateinit var userDao: TicketDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).setTransactionExecutor(Executors.newSingleThreadExecutor())
            .build()
        userDao = db.ticketDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeTicketAndReadInList_Success() {
        val ticket = TicketEntity(0, "${System.currentTimeMillis()}", "Image 1")
        userDao.insertTicket(ticket)
        val tickets = userDao.test_selectAllTickets()
        println(ticket)
        println(tickets)
        assertThat(tickets.first(), equalTo(ticket))
    }
}