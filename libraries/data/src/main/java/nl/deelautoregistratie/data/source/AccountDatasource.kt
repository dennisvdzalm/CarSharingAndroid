package nl.deelautoregistratie.data.source

import io.reactivex.Completable

interface AccountDatasource {

    fun login(username: String, password: String): Completable
}