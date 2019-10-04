package me.alhaz.tutorial.architecturecomponent.views.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import me.alhaz.tutorial.architecturecomponent.R
import me.alhaz.tutorial.architecturecomponent.views.movies.list.MovieListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openNextPage()
    }

    fun openNextPage() {
        Handler().postDelayed({
            val intent = Intent(this, MovieListActivity::class.java)
            startActivity(intent);
            finish();
        },1500)
    }
}
