package uz.datatalim.password.fragment

import android.os.Bundle
import android.telecom.Call.Details
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import uz.datatalim.password.R
import uz.datatalim.password.database.CitizensRepository
import uz.datatalim.password.databinding.FragmentInfoBinding

class Info : Fragment() {

    val args:InfoArgs by navArgs()
    lateinit var binding: FragmentInfoBinding
    var userId=1
    lateinit var repository: CitizensRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentInfoBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

        userId=args.id
        repository=CitizensRepository(requireActivity().application)
        val showInfo=repository.getPassById(userId)
        binding.tvTextInfo.text=showInfo.toString()

    }

}