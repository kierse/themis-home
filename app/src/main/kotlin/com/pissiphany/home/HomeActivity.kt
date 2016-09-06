package com.pissiphany.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.pissiphany.home.di.component.DaggerHomeActivityComponent
import com.pissiphany.home.di.module.repository.DataServiceModule
import com.pissiphany.home.domain.model.CalendarEntry
import com.pissiphany.home.domain.model.Matter
import com.pissiphany.home.domain.model.Task
import com.pissiphany.home.presenter.HomePresenter
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomePresenter.HomeView {
    @Inject
    lateinit var presenter: HomePresenter

    lateinit var matterListView: ListView
    lateinit var matterAdapter: MatterAdapter

    lateinit var taskListView: ListView
    lateinit var taskAdapter: TaskAdapter

    lateinit var calendarEntryListView: ListView
    lateinit var calendarEntryAdapter: CalendarEntryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerHomeActivityComponent.builder()
                .appComponent((applicationContext as HomeApp).component())
                .dataServiceModule(DataServiceModule())
                .build()
                .inject(this)

        setContentView(R.layout.activity_home)

        initMatters()
        initTasks()
        initCalendarEntries()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume(this)
    }

    override fun matters(matters: List<Matter>) {
        matterAdapter.addAll(matters)
    }

    override fun tasks(tasks: List<Task>) {
        taskAdapter.addAll(tasks)
    }

    override fun calendarEntries(entries: List<CalendarEntry>) {
        calendarEntryAdapter.addAll(entries)
    }

    private fun initMatters() {
        matterAdapter = MatterAdapter(this, R.layout.matter_list_item)
        matterListView = findViewById(R.id.matterList) as ListView
        matterListView.adapter = matterAdapter
    }

    private fun initTasks() {
        taskAdapter = TaskAdapter(this, R.layout.task_list_item)
        taskListView = findViewById(R.id.taskList) as ListView
        taskListView.adapter = taskAdapter
    }

    private fun initCalendarEntries() {
        calendarEntryAdapter = CalendarEntryAdapter(this, R.layout.calendar_entry_list_item)
        calendarEntryListView = findViewById(R.id.calendarEntryList) as ListView
        calendarEntryListView.adapter = calendarEntryAdapter
    }
}
