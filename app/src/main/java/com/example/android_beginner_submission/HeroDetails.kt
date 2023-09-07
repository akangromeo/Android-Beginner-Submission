package com.example.android_beginner_submission

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.android_beginner_submission.databinding.ActivityHeroDetailsBinding

class HeroDetails : AppCompatActivity() {

    companion object {
        const val key_heroMM = "key_heroMM"
    }

    private lateinit var binding: ActivityHeroDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataHeroMarksman = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<HeroMarksman>(key_heroMM, HeroMarksman::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<HeroMarksman>(key_heroMM)
        }
        if (dataHeroMarksman != null) {
            binding.imgItemPhotoDetail.setImageResource(dataHeroMarksman.photo)
            binding.tvItemNameDetail.text = dataHeroMarksman.name
            binding.tvDescDetail.text = dataHeroMarksman.description
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_share -> {
            val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this Mobile Legend Hero History App!")
                intent.putExtra(Intent.EXTRA_TEXT, "link here")
                startActivity(Intent.createChooser(intent, "Share VIa"))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
