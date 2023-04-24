package com.omar_zuniga.proyectointegrador.ui.main.tickets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.omar_zuniga.proyectointegrador.MyApplication
import com.omar_zuniga.proyectointegrador.data.AppDatabase
import com.omar_zuniga.proyectointegrador.data.login.LoginDataSource
import com.omar_zuniga.proyectointegrador.data.login.LoginRepository
import com.omar_zuniga.proyectointegrador.data.tickets.TicketsRepository

/**
 * ViewModel provider factory to instantiate TicketsViewModel.
 * Required given TicketsViewModel has a non-empty constructor
 */
class TicketsViewModelFactory(private val repository: TicketsRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TicketsViewModel::class.java)) {
            return TicketsViewModel(ticketsRepository = repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}