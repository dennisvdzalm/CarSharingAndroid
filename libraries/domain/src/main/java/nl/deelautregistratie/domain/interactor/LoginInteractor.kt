package nl.deelautregistratie.domain.interactor

import io.reactivex.Completable
import nl.deelautregistratie.domain.repository.AccountRepository
import javax.inject.Inject

class LoginInteractor @Inject constructor(private val accountRepository: AccountRepository) {

    fun get(requestValues: RequestValues): Completable {
        return accountRepository.login(requestValues.username, requestValues.password)
    }

    class RequestValues(val username: String, val password: String)
}