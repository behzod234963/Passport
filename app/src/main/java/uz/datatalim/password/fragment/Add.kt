package uz.datatalim.password.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.datatalim.password.R
import uz.datatalim.password.database.CitizensRepository
import uz.datatalim.password.databinding.FragmentAddBinding
import uz.datatalim.password.model.Citizens


class Add : Fragment() {

    lateinit var binding: FragmentAddBinding
    lateinit var repository: CitizensRepository
    lateinit var list:ArrayList<Citizens>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAddBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        list=ArrayList()
        repository=CitizensRepository(requireActivity().application)
        binding.btnSaveAdd.setOnClickListener{

            repository.savePassport(Citizens(null,
                binding.etNameAdd.text.toString(),
                binding.etLastNameAdd.text.toString(),
                binding.etVichAdd.text.toString(),
                binding.etViloyatAdd.text.toString(),
                binding.etCityAdd.text.toString(),
                binding.etPassNumAdd.text.toString(),
                binding.etGetDataAdd.text.toString(),
                binding.etPassDataAdd.text.toString(),
                binding.etSexAdd.text.toString()))
            findNavController().navigate(R.id.action_add2_to_menu)

        }

    }

}