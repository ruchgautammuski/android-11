package com.ruchi

import Card
import Section
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsList = mutableListOf<Section>(
            Section(listOf(), 2, "SubTitle1", "Title1", 2 ),
            Section(listOf(), 8, "SubTitle", "Title2", 1 ),
            Section(listOf(), 4, "SubTitle", "Title3", 3 ),
            Section(listOf(), 8, "SubTitle9", "Title4", 1 ),
            Section(listOf(), 8, "SubTitle9", "Title5", 3 ),
            Section(listOf(), 8, "SubTitle9", "Title6", 2 )
        )
        val homeRV : RecyclerView = findViewById(R.id.homeRV)
        val adapter = SectionsAdapter(sectionsList)
        homeRV.adapter = adapter
        homeRV.layoutManager = LinearLayoutManager(this)
    }
}
