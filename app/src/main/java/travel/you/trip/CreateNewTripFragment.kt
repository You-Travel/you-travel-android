package travel.you.trip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import travel.you.databinding.FragmentCreateNewTripBinding
import org.koin.android.viewmodel.ext.android.viewModel
import travel.you.R

class CreateNewTripFragment : Fragment() {

    private lateinit var binding: FragmentCreateNewTripBinding
    private val viewModel: CreateNewTripViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNewTripBinding.inflate(inflater)
        initObserverViewModel()
        return binding.root
    }

    private fun initObserverViewModel() {
        viewModel.createTrip.observe(viewLifecycleOwner, Observer {
            openVariantsFragment();
        })
    }

    private fun openVariantsFragment() {
        val budget = binding.inputBudget.text.toString().toInt()
        val countPeople = binding.inputCountPeople.text.toString().toInt()

        val bundle = Bundle()
        bundle.putInt("budget", budget)
        bundle.putInt("countPeople", countPeople)

        findNavController().navigate(R.id.action_createNewTripFragment_to_variantsFragment, bundle)
    }

}