package com.omar_zuniga.proyectointegrador.ui.main.add_ticket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.omar_zuniga.proyectointegrador.data.tickets.TicketsRepository

/**
 * ViewModel provider factory to instantiate AddTicketViewModel.
 * Required given AddTicketViewModel has a non-empty constructor
 */
class AddTicketViewModelFactory(private val repository: TicketsRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddTicketViewModel::class.java)) {
            return AddTicketViewModel(ticketsRepository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}