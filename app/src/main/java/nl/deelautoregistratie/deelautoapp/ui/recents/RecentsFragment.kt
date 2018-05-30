package nl.deelautoregistratie.deelautoapp.ui.recents

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_recents.*
import nl.deelautoregistratie.deelautoapp.R
import nl.deelautoregistratie.deelautoapp.data.NetworkState
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(RecentsViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recents, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RecentsAdapter()

        car_session_recyclerview.layoutManager = LinearLayoutManager(context)
        car_session_recyclerview.adapter = adapter

        viewModel.carSessions.observe(this, Observer {
            adapter.submitList(it)
        })

        viewModel.refreshState.observe(this, Observer {
            swipe_refresh_layout.isRefreshing = it == NetworkState.LOADING
        })

        swipe_refresh_layout.setOnRefreshListener {
            viewModel.refresh()
        }
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