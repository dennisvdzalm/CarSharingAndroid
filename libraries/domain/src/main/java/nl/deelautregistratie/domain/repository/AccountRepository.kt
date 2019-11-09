package nl.deelautregistratie.domain.repository

import io.reactivex.Completable

interface AccountRepository {

    fun login(username: String, password: String): Completable
}