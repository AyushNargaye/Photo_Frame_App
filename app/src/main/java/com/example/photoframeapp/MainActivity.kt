package com.example.photoframeapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    private lateinit var images: Array<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hiding the action bar
        supportActionBar?.hide()

        // Initialize ImageViews into an array
        images = arrayOf(
            findViewById(R.id.image0),
            findViewById(R.id.image1),
            findViewById(R.id.image2)
        )

        // Initialize buttons
        val prevButton = findViewById<ImageButton>(R.id.imageButton4)
        val nextButton = findViewById<ImageButton>(R.id.imageButton3)

        // Set onClickListener for previous button
        prevButton.setOnClickListener {
            images[currentImage].alpha = 0f // Hide the current image
            currentImage = (currentImage - 1 + images.size) % images.size // Get previous image index
            images[currentImage].alpha = 1f // Show the new image
        }

        // Set onClickListener for next button
        nextButton.setOnClickListener {
            images[currentImage].alpha = 0f // Hide the current image
            currentImage = (currentImage + 1) % images.size // Get next image index
            images[currentImage].alpha = 1f // Show the new image
        }
    }
}
