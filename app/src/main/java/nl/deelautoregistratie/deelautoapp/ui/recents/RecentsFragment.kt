package nl.deelautoregistratie.deelautoapp.ui.recents

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import nl.deelautoregistratie.deelautoapp.R
import nl.deelautoregistratie.deelautoapp.model.CarSession
import nl.deelautoregistratie.deelautoapp.networking.DataResponse
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

        recentsViewModel.recentCarSessions.observe(this, Observer<DataResponse<List<CarSession>>> { dataResponse ->
            when (dataResponse) {
                is DataResponse.Progress -> {

                }

                is DataResponse.Success -> {

                }

                is DataResponse.Failure -> {

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