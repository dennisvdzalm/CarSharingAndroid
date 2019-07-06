package nl.deelautoregistratie.deelautoapp.utils.rx

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
interface Scheduler {
    fun mainThread():io.reactivex.Scheduler
    fun io():io.reactivex.Scheduler
}