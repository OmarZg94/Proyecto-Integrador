package com.omar_zuniga.proyectointegrador.ui.main.tickets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omar_zuniga.proyectointegrador.data.tickets.TicketEntity
import com.omar_zuniga.proyectointegrador.databinding.ViewHolderTicketBinding

class TicketAdapter: ListAdapter<TicketEntity, TicketAdapter.TicketViewHolder>(TicketComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        return TicketViewHolder(ViewHolderTicketBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = getItem(position)
        holder.bind(ticket)
    }

    class TicketViewHolder(private val binding: ViewHolderTicketBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ticket: TicketEntity) {
            binding
        }
    }

    class TicketComparator : DiffUtil.ItemCallback<TicketEntity>() {
        override fun areItemsTheSame(oldItem: TicketEntity, newItem: TicketEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TicketEntity, newItem: TicketEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }
}