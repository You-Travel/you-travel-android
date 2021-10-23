package travel.you.trip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import travel.you.databinding.FragmentTripBinding

class TripFragment : Fragment() {

    private lateinit var binding: FragmentTripBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTripBinding.inflate(inflater)
        return binding.root
    }

}