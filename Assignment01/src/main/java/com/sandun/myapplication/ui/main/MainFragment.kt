package com.sandun.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sandun.myapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding =FragmentMainBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding!!.viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding!!.TextNotifier?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding!!.TextObserver.text =p0.toString()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               binding!!.viewModel!!.getData(p0.toString())?.observe(viewLifecycleOwner) {
                   binding!!.TextObserver.text =it
               }
            }

            override fun afterTextChanged(p0: Editable?) {
                binding!!.TextObserver.text =p0.toString()
            }

        })


    }

}


