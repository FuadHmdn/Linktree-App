package com.fuad.linktreeapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fuad.linktreeapp.adapter.LinkAdapter
import com.fuad.linktreeapp.model.LinktreeModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
    }

    fun initComponent(){
        val image = findViewById<ImageView>(R.id.imageView)
        val title = findViewById<TextView>(R.id.title)
        val subtitle = findViewById<TextView>(R.id.subTitle)
        val list = findViewById<RecyclerView>(R.id.list)

        list.adapter = LinkAdapter
        image.setImageResource(R.drawable.fuad2)
        title.text = "Fuad Hamidan"
        subtitle.text = "Android Developer"
    }

    private val LinkAdapter by lazy {
        val items = listOf(
            LinktreeModel("Instagram", R.drawable.instagram, "https://www.instagram.com/fuad.hmdn/"),
            LinktreeModel("YoutTube", R.drawable.youtube, "https://youtu.be/6zDYMLtVJ4g?si=NURTpBbKnkPcaBr6&t=46"),
            LinktreeModel("Whatsapp", R.drawable.whatsapp, "https://web.whatsapp.com/"),
            LinktreeModel("LinkedIn", R.drawable.linkedin, "https://www.linkedin.com/in/fuad-hamidan-295007286/"),
            LinktreeModel("GitHub", R.drawable.github, "https://github.com/FuadHmdn")
        )

        LinkAdapter(items, object: LinkAdapter.AdapterListener{
            override fun onClick(linktree: LinktreeModel) {
                openUrl(linktree.url)
            }

        })
    }

    private fun openUrl(url: String){
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        startActivity(openUrl)
    }

}