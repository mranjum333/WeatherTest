package com.lowes.weathertest

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.lowes.weathertest.model.Response

/**
 * A fragment representing a list of Items.
 */
class ResponseFragment : Fragment(), MyResponseRecyclerViewAdapter.onRowClickListener {

    private var responseList: List<Response> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                adapter = MyResponseRecyclerViewAdapter(responseList,this@ResponseFragment)
                addItemDecoration(DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL))
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(responseList: List<Response>) =
            ResponseFragment().apply {
                this.responseList = responseList
            }
    }

    override fun onItemClick(response: Response) {
        val fragment = WeatherDetailFragment.newInstance(response)
        if(fragmentManager?.findFragmentByTag(WeatherDetailFragment::class.java.simpleName) == null){
            fragmentManager?.beginTransaction()
                ?.add(R.id.weather_list_holder,fragment,WeatherDetailFragment::class.java.simpleName)
                ?.hide(this)
                ?.addToBackStack(WeatherDetailFragment::class.java.simpleName)
                ?.commit()
        }
    }
}