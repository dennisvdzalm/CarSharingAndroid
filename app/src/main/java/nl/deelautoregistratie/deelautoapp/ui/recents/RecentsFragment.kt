package nl.deelautoregistratie.deelautoapp.ui.recents

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_recents.*
import nl.deelautoregistratie.deelautoapp.R
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import nl.deelautoregistratie.deelautoapp.data.networking.DataResponse
import nl.deelautoregistratie.deelautoapp.utils.arch.ViewModelFactory
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
class RecentsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<RecentsViewModel>

    lateinit var viewModel: RecentsViewModel
        private set

    lateinit var recentsViewModel: RecentsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recentsViewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(RecentsViewModel::class.java)

        val adapter = RecentsAdapter()

        car_session_recyclerview.layoutManager = LinearLayoutManager(context)
        car_session_recyclerview.adapter = adapter

        recentsViewModel.recentCarSessions.observe(this, Observer<DataResponse<PagedList<CarSession>>> { dataResponse ->
            when (dataResponse) {
                is DataResponse.Success -> {
                    adapter.submitList(dataResponse.data)
                }
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recents, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        fun newInstance(): RecentsFragment {
            val args: Bundle = Bundle()
            val fragment = RecentsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}