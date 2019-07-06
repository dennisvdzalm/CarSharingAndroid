package nl.deelautoregistratie.deelautoapp.recents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import nl.deelautoregistratie.deelautoapp.R
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
//
//        viewModel = ViewModelProviders
//                .of(this, viewModelFactory)
//                .get(RecentsViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recents, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RecentsAdapter()
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