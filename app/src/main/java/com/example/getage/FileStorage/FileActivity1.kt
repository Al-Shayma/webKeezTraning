package com.example.getage.FileStorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import com.example.getage.R
import com.example.getage.databinding.ActivityFile1Binding
import com.example.getage.databinding.ActivityMainBinding
import java.io.File
import java.io.IOException

class FileActivity1 : AppCompatActivity() {
    lateinit var binding: ActivityFile1Binding
    lateinit var photoPath: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFile1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnTakeImage.setOnClickListener {
            btnTakeImage()
        }
    }
    private fun btnTakeImage(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(intent.resolveActivity(packageManager) !=null){
            var photoFile: File? =null
            try {
                photoFile = createImageFile()
            }catch (e:IOException){}
            if (photoFile != null) {
                val photoUri = FileProvider.getUriForFile(
                    this,
                    "com.example.android.fileprovider",
                    photoFile
                )

            }
        }
    }

    private fun createImageFile(): File? {
        val fileName = "MyPicture"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image =File.createTempFile(
            fileName,
            ".jpg",
            storageDir
        )
        photoPath = image.absolutePath
        return image

    }
}