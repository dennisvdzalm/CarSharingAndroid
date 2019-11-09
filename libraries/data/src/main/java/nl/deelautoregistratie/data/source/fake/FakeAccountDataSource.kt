package nl.deelautoregistratie.data.source.fake

import io.reactivex.Completable
import nl.deelautoregistratie.data.source.AccountDatasource
import javax.inject.Inject

class FakeAccountDataSource @Inject constructor(): AccountDatasource {

    override fun login(username: String, password: String): Completable {
        return Completable.complete()
    }

}