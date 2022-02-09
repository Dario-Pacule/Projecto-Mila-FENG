package com.dariopacule.mila.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dariopacule.mila.R
import com.dariopacule.mila.adapter.CondicionedConfigAdapter
import com.dariopacule.mila.adapter.ItemAdapter
import com.dariopacule.mila.data.DataSource
import com.dariopacule.mila.databinding.LogicConfigFragmentBinding
import com.dariopacule.mila.databinding.MainFragmentBinding

class LogicConfigFragment : Fragment() {
    private var _binding: LogicConfigFragmentBinding? = null
    private val binding get() = _binding
    private lateinit var recyclerViewCondicioned: RecyclerView
    private lateinit var recyclerViewPadr: RecyclerView


    private var clicked = false
    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.rotate_open_anim
        )
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.rotate_close_anim
        )
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.to_bottom_anim
        )
    }
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.from_bottom_anim
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = LogicConfigFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataset = DataSource().loadCondicionedConfig()
        recyclerViewCondicioned = binding!!.recyclerViewCondicionais
        recyclerViewCondicioned.adapter = CondicionedConfigAdapter(requireContext(), dataset)



        binding!!.floatingAddButton.setOnClickListener {
            onAddButtonClicked()
        }
        binding!!.floatingPadraoButton.setOnClickListener {
            Toast.makeText(context, "Butao Padrao clicado", Toast.LENGTH_SHORT).show()
        }
        binding!!.floatingCondButton.setOnClickListener {
            Toast.makeText(context, "Butao Condicionais clicado", Toast.LENGTH_SHORT).show()
        }


    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding!!.floatingPadraoButton.visibility = View.VISIBLE
            binding!!.floatingCondButton.visibility = View.VISIBLE

        } else {
            binding!!.floatingPadraoButton.visibility = View.INVISIBLE
            binding!!.floatingCondButton.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            binding!!.floatingPadraoButton.startAnimation(fromBottom)
            binding!!.floatingCondButton.startAnimation(fromBottom)
            binding!!.floatingAddButton.startAnimation(rotateOpen)
        } else {
            binding!!.floatingPadraoButton.startAnimation(toBottom)
            binding!!.floatingCondButton.startAnimation(toBottom)
            binding!!.floatingAddButton.startAnimation(rotateClose)
        }
    }


}