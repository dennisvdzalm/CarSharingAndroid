package nl.deelautoregistratie.data


sealed class NetworkState {

    object Loading : NetworkState()

    class Error(val message: String) : NetworkState()

    object Loaded : NetworkState()

    object Empty : NetworkState()
}