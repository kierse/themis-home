package com.pissiphany.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.pissiphany.home.di.component.DaggerHomeActivityComponent
import com.pissiphany.home.di.module.repository.RepositoryServiceModule
import com.pissiphany.home.domain.model.Matter
import com.pissiphany.home.presenter.HomePresenter
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomePresenter.HomeView {
    @Inject
    lateinit var presenter: HomePresenter

    lateinit var matterListView: ListView
    lateinit var matterAdapter: MatterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerHomeActivityComponent.builder()
                .appComponent((applicationContext as HomeApp).component())
                .repositoryServiceModule(RepositoryServiceModule())
                .build()
                .inject(this)

        setContentView(R.layout.activity_home)

        initMatters()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume(this)
    }

    override fun matters(matters: List<Matter>) {
        matterAdapter.addAll(matters)
    }

    private fun initMatters() {
        matterAdapter = MatterAdapter(this, R.layout.matter_list_item)
        matterListView = findViewById(R.id.matterList) as ListView
        matterListView.adapter = matterAdapter
    }
}
