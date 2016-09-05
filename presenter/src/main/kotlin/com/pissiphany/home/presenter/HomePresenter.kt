package com.pissiphany.home.presenter

import com.pissiphany.home.domain.MatterRepository
import com.pissiphany.home.domain.model.Matter
import rx.Scheduler
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by kierse on 2016-08-31.
 */
class HomePresenter @Inject constructor(
        val matterRepository: MatterRepository, val scheduler: Scheduler
) {
    var view: HomeView? = null

    interface HomeView {
        fun matters(matters: List<Matter>)
    }

    fun onResume(view: HomeView) {
        this.view = view

        matterRepository.matters(mapOf())
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .subscribe { list -> view.matters(list) }
    }

    fun onPause() {
        view = null
    }
}