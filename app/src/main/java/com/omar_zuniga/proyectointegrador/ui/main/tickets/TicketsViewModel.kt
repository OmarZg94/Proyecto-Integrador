package com.omar_zuniga.proyectointegrador.ui.main.tickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.omar_zuniga.proyectointegrador.data.tickets.TicketEntity
import com.omar_zuniga.proyectointegrador.data.tickets.TicketsRepository
import kotlinx.coroutines.launch

class TicketsViewModel(private val ticketsRepository: TicketsRepository) : ViewModel() {

    val allTickets: LiveData<List<TicketEntity>> = ticketsRepository.tickets.asLiveData()

}