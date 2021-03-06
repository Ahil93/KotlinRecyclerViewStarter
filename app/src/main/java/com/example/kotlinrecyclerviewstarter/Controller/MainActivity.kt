package com.example.kotlinrecyclerviewstarter.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.kotlinrecyclerviewstarter.Adapters.TechnologyRecycleAdapter
import com.example.kotlinrecyclerviewstarter.R
import com.example.kotlinrecyclerviewstarter.Services.DataService
import com.example.kotlinrecyclerviewstarter.Utils.EXTRA_TECH
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: TechnologyRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TechnologyRecycleAdapter(this,DataService.technologies){ technology ->

            val langIntent = Intent(this, LanguageActivity::class.java)
            langIntent.putExtra(EXTRA_TECH,technology.title)
            startActivity(langIntent)
        }
        technologyRecycleView.adapter = adapter

        var layoutManager = LinearLayoutManager(this)
        technologyRecycleView.layoutManager = layoutManager
        technologyRecycleView.setHasFixedSize(true)

    }
}
