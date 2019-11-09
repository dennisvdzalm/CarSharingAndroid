package nl.deelautoregistratie.deelautoapp.overview.recents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import nl.deelautoregistratie.deelautoapp.overview.databinding.FragmentRecentsBinding
import nl.deelautoregistratie.deelautoapp.utils.arch.ViewModelFactory
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
class RecentsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<RecentsViewModel>

    private lateinit var binding: FragmentRecentsBinding

    lateinit var viewModel: RecentsViewModel
        private set

    lateinit var adapter: RecentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(RecentsViewModel::class.java)

        adapter = RecentsAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecentsBinding.inflate(inflater, container, false)
        binding.carSessionRecyclerview.adapter = adapter
        binding.carSessionRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.getCarSessions() }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.carSessions.observe(viewLifecycleOwner, Observer { adapter.submitList(it) })
        viewModel.getCarSessions()
    }

    companion object {
        fun newInstance(): RecentsFragment = RecentsFragment()
    }
}