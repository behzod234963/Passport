package uz.datatalim.password.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.datatalim.password.R
import uz.datatalim.password.databinding.FragmentMenuBinding

class Menu : Fragment() {

    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMenuBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

        binding.btnAllcitizens.setOnClickListener {

            findNavController().navigate(R.id.action_menu_to_all)

        }

        binding.btnAddPassport.setOnClickListener {

            findNavController().navigate(R.id.action_menu_to_add2)

        }

    }

}