package uz.datatalim.password.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uz.datatalim.password.R
import uz.datatalim.password.adapter.CitizensAdapter
import uz.datatalim.password.database.CitizensRepository
import uz.datatalim.password.databinding.FragmentAllBinding
import uz.datatalim.password.model.Citizens

class All : Fragment() {

    lateinit var binding: FragmentAllBinding
    private lateinit var list: ArrayList<Citizens>
    private lateinit var adapter: CitizensAdapter
    private lateinit var repository: CitizensRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAllBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadList()

    }

    private fun loadList() {

        list= ArrayList()
        repository= CitizensRepository(requireActivity().application)
        list=repository.getAllData() as ArrayList<Citizens>
        initView()

    }

    private fun initView() {

        binding.rvListAll.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = CitizensAdapter(list,requireContext())
        binding.rvListAll.adapter = adapter
        repository = CitizensRepository(requireActivity().application)
        adapter.submitList(list)

        adapter.onClick={position->

            findNavController().navigate(R.id.action_all_to_info2, bundleOf("id" to list[position].id))

        }

    }

}