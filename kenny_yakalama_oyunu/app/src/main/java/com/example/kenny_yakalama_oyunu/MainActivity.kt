package com.example.kenny_yakalama_oyunu

import android.content.DialogInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kenny_yakalama_oyunu.databinding.ActivityMainBinding
import kotlinx.coroutines.Runnable
import kotlin.random.Random

private lateinit var binding: ActivityMainBinding
var skor=0
var imageArray = ArrayList<ImageView>()
var runnable = Runnable{}
val handler = Handler(Looper.getMainLooper())

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        object: CountDownTimer(15000,1000){
            override fun onTick(p0: Long) {
                binding.textViewTime.text="Time: ${p0/1000}"
            }

            override fun onFinish() {
              binding.textViewTime.text="Finish"
                handler.removeCallbacks(runnable)
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Skor: ${skor}")
                alert.setMessage("Play Again")
                alert.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        val intent = intent
                        finish()
                        startActivity(intent)
                    }

                })
                alert.setNegativeButton("No"){ p0, p1 ->
                    Toast.makeText(this@MainActivity,"Çıkış Yapılıyor",Toast.LENGTH_SHORT).show()
                }
                alert.show()
            }

        }.start()

        //imageArray
        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)
        imageArray.add(binding.imageView11)
        imageArray.add(binding.imageView12)
        imageArray.add(binding.imageView13)
        imageArray.add(binding.imageView14)
        imageArray.add(binding.imageView15)
        imageArray.add(binding.imageView16)
        imageArray.add(binding.imageView17)
        imageArray.add(binding.imageView18)
        imageArray.add(binding.imageView19)
        imageArray.add(binding.imageView20)
        imageArray.add(binding.imageView21)
        imageArray.add(binding.imageView22)
        imageArray.add(binding.imageView23)
        imageArray.add(binding.imageView24)

        hide()

    }
    fun hide(){
     runnable = object : Runnable{
         override fun run() {
             for (image in imageArray){
                 image.visibility= View.INVISIBLE
             }
             val random = Random
             val randomIndex = random.nextInt(0,24)
             imageArray[randomIndex].visibility = View.VISIBLE

             handler.postDelayed(runnable,500)
         }

     }

        handler.post(runnable)
    }

    fun click(view: View){
        skor = skor+1;
        binding.textViewScore.text= "Score: ${skor}"
    }
}