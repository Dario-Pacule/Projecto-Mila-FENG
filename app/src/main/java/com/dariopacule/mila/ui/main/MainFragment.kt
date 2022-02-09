package com.dariopacule.mila.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dariopacule.mila.adapter.ItemAdapter
import com.dariopacule.mila.data.DataSource
import com.dariopacule.mila.databinding.MainFragmentBinding
import com.dariopacule.mila.model.ControlerData

class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding
    private lateinit var recyclerView: RecyclerView
    private var nivelTanque: Int = 0
    private var nivelHumidade: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myDataset = DataSource().loadRelatory()
        recyclerView = binding!!.recyclerViewRelatorio
        recyclerView.adapter = ItemAdapter(requireContext(), myDataset)
        recyclerView.hasFixedSize()

        val controlerData = DataSource().loadControlerData()

        binding!!.tanqueLevel.text = controlerData.watterLevel.toString() + "%"
        binding!!.humidadeLevel.text = controlerData.humidityLevel.toString() + "%"
        binding!!.nextOperationTime.text = controlerData.nexOperatioTime

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}