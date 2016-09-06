package com.pissiphany.home.presenter

import com.pissiphany.home.domain.CalendarEntryRepository
import com.pissiphany.home.domain.MatterRepository
import com.pissiphany.home.domain.TaskRepository
import com.pissiphany.home.domain.model.CalendarEntry
import com.pissiphany.home.domain.model.Matter
import com.pissiphany.home.domain.model.Task
import rx.Scheduler
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by kierse on 2016-08-31.
 */
class HomePresenter @Inject constructor(
        val matterRepository: MatterRepository,
        val taskRepository: TaskRepository,
        val calendarEntryRepository: CalendarEntryRepository,
        val mainThread: Scheduler
) {
    var view: HomeView? = null

    interface HomeView {
        fun matters(matters: List<Matter>)
        fun tasks(tasks: List<Task>)
        fun calendarEntries(entries: List<CalendarEntry>)
    }

    fun onResume(view: HomeView) {
        this.view = view

        matterRepository.matters(mapOf())
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread)
                .subscribe { list -> view.matters(list) }

        taskRepository.tasks(mapOf())
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread)
                .subscribe { list -> view.tasks(list) }

        calendarEntryRepository.calendarEntries(mapOf())
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread)
                .subscribe { list -> view.calendarEntries(list) }
    }

    fun onPause() {
        view = null
    }
}