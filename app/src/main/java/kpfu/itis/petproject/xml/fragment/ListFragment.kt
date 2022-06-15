package kpfu.itis.petproject.xml

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kpfu.itis.petproject.Model
import kpfu.itis.petproject.R
import kpfu.itis.petproject.databinding.ListFragmentBinding

class ListFragment : Fragment(R.layout.list_fragment) {

    private val binding: ListFragmentBinding by viewBinding()
    private var adapter: ListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ListAdapter(Model.list) {
            findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
        }
        binding.rvUserBonuses.adapter = adapter
    }
}
