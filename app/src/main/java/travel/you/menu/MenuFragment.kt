package travel.you.menu

import android.R
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import travel.you.databinding.FragmentMenuBinding
import android.widget.Toast

import androidx.core.view.MenuItemCompat

import androidx.core.content.ContextCompat.getSystemService

import android.app.SearchManager

import android.R.menu

import android.view.MenuInflater
import androidx.core.content.ContextCompat


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater)
        val toolbar = binding.toolbar
        (activity as AppCompatActivity)
            .setSupportActionBar(toolbar)
        toolbar.setTitle("")

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.chat_screen_menu, menu)

        val searchManager = getSystemService<Any>(Context.SEARCH_SERVICE) as SearchManager?
        mSearchView =
            MenuItemCompat.getActionView(menu.findItem(R.id.action_menu_search)) as SearchView
        val toast = Toast(mApp)

        if (mSearchView != null) {
            mSearchView.setSearchableInfo(searchManager!!.getSearchableInfo(getComponentName()))
            mSearchView.setIconifiedByDefault(false)
            val queryTextListener: SearchView.OnQueryTextListener = object : OnQueryTextListener() {
                fun onQueryTextChange(newText: String): Boolean {
                    mSearchString = newText
                    //doFilterAsync(mSearchString);
                    toast.makeText(getApplicationContext(), "Test1", Toast.LENGTH_LONG).show()
                    return true
                }

                fun onQueryTextSubmit(query: String): Boolean {
                    mSearchString = query
                    //doFilterAsync(mSearchString);
                    toast.makeText(getApplicationContext(), "Test2", Toast.LENGTH_LONG).show()
                    return true
                }
            }
            mSearchView.setOnQueryTextListener(queryTextListener)
        }

        return true
    }

}