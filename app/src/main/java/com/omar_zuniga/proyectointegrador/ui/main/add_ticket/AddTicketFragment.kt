package com.omar_zuniga.proyectointegrador.ui.main.add_ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.omar_zuniga.proyectointegrador.R
import com.omar_zuniga.proyectointegrador.databinding.FragmentAddTicketsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddTicketFragment : Fragment() {

    private var _binding: FragmentAddTicketsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddTicketsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}