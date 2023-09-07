package com.example.android_beginner_submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_beginner_submission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroMarksman: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<HeroMarksman>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvHeroMarksman = findViewById(R.id.rv_heroes_marksman)
        rvHeroMarksman.setHasFixedSize(true)

        list.addAll(getListHeroesMarksman())
        showRecyclerList()

    }

    private fun getListHeroesMarksman(): ArrayList<HeroMarksman> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHeroMarksman = ArrayList<HeroMarksman>()
        for (i in dataName.indices) {
            val heroMarksman =
                HeroMarksman(dataName[i], dataDesc[i], dataPhoto.getResourceId(i, -1))
            listHeroMarksman.add(heroMarksman)
        }
        return listHeroMarksman
    }

    private fun showRecyclerList() {
        rvHeroMarksman.layoutManager = LinearLayoutManager(this)
        val listHeroMarksmanAdapter = ListHeroMarksmanAdapter(list)
        rvHeroMarksman.adapter = listHeroMarksmanAdapter



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
