package com.omar_zuniga.proyectointegrador.ui.main.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omar_zuniga.proyectointegrador.MyApplication
import com.omar_zuniga.proyectointegrador.R
import com.omar_zuniga.proyectointegrador.databinding.FragmentTicketsBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TicketsFragment : Fragment() {

    private var _binding: FragmentTicketsBinding? = null
    private lateinit var _adapter: TicketAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val ticketsViewModel: TicketsViewModel by viewModels {
        TicketsViewModelFactory((requireActivity().application as MyApplication).ticketsRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeRecyclerView()
        observeTicketsSaved()

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun initializeRecyclerView() {
        with(binding.rcvTickets) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            _adapter = TicketAdapter()
            adapter = _adapter
        }
    }

    private fun observeTicketsSaved() =
        ticketsViewModel.allTickets.observe(viewLifecycleOwner) { tickets ->
            tickets?.let {
                if (it.isNotEmpty()) binding.txtTitle.text = getString(R.string.my_tickets_upload)
                else binding.txtTitle.text = getString(R.string.without_tickets_upload)
                _adapter.submitList(it)
            } ?: run {
                binding.txtTitle.text = getString(R.string.without_tickets_upload)
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}