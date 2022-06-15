package kpfu.itis.petproject.xml

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import kpfu.itis.petproject.R
import kpfu.itis.petproject.databinding.DetailsFragmentBinding

class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val binding: DetailsFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
