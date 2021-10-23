package travel.you.trip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.findNavController
import travel.you.R
import travel.you.databinding.FragmentPlanningTripBinding

class PlanningTripFragment : Fragment() {

    private lateinit var binding: FragmentPlanningTripBinding

    private lateinit var tripPagerAdapter: TripPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlanningTripBinding.inflate(inflater)
        tripPagerAdapter = TripPagerAdapter(childFragmentManager)
        if (binding.pager.adapter == null) {
            binding.pager.adapter = tripPagerAdapter
        }
        binding.tabLayout.setupWithViewPager(binding.pager)

        binding.btnCreateTrip.setOnClickListener {
            //Toast.makeText(context, "Когда - нибудь потом...", Toast.LENGTH_LONG)
            findNavController().navigate(R.id.action_planningTripFragment_to_createNewTripFragment)
        }

        return binding.root
    }

    class TripPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {



        override fun getCount(): Int  = 2

        override fun getItem(i: Int): Fragment {
            when(i) {
                0 -> {

                    return TripsFragment()
                }
                1 -> return BookmarkFragment()
            }
            return Fragment()
        }

        override fun getPageTitle(position: Int): CharSequence {
            when(position) {
                0 -> return "Поездки"
                1 -> return "Закладки"
            }
            return ""
        }
    }

}