package nl.deelautoregistratie.deelautoapp.data.datasource

import android.arch.paging.PositionalDataSource
import nl.deelautoregistratie.deelautoapp.data.model.CarSession

class CarSessionDataSource : PositionalDataSource<CarSession>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<CarSession>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<CarSession>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}