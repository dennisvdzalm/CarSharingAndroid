package nl.deelautoregistratie.data.repository

import io.reactivex.Completable
import nl.deelautoregistratie.data.source.AccountDatasource
import nl.deelautregistratie.domain.repository.AccountRepository
import javax.inject.Inject

class AppAccountRepository @Inject constructor(private val accountDatasource: AccountDatasource) : AccountRepository {

    override fun login(username: String, password: String): Completable =
            accountDatasource.login(username, password)

}