package com.example.sherlocked1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            var st = ""
            if (checkBox1.isChecked) {
                st += checkBox1.text
            }
            if (checkBox2.isChecked) {
                st += checkBox2.text
            }
            if (checkBox3.isChecked) {
                st += checkBox3.text
            }
            //Toast.makeText(this,"${st}",Toast.LENGTH_SHORT).show()
            Snackbar.make(lay, st, Snackbar.LENGTH_INDEFINITE)
                .setAction("END", View.OnClickListener {
                    finish()
                })
                .setActionTextColor(ContextCompat.getColor(this, R.color.colorPrimary)).show()
        }

        bt2.setOnClickListener {
            bt2.isEnabled=true
            //var st=""
            if(radioButton3.isChecked)
            {
                Snackbar.make(lay,radioButton3.text,Snackbar.LENGTH_INDEFINITE).setAction("END",View.OnClickListener {
                    finish()
                }).show()
            }
            else if(radioButton4.isChecked)
            {
                Snackbar.make(lay,radioButton4.text,Snackbar.LENGTH_INDEFINITE).setAction("END",View.OnClickListener {
                    finish()
                }).show()
            }
            else if(radioButton5.isChecked)
            {
                Snackbar.make(lay,radioButton5.text,Snackbar.LENGTH_INDEFINITE).setAction("END") {
                    finish()
                }.show()
            }
            //bt2.isEnabled=false
        }
        radioButton3.setOnClickListener {
            Toast.makeText(this, radioButton3.text, Toast.LENGTH_SHORT).show()
        }

        radioButton4.setOnClickListener {
            Toast.makeText(this, radioButton4.text, Toast.LENGTH_SHORT).show()
        }

        radioButton5.setOnClickListener {
            Toast.makeText(this, radioButton5.text, Toast.LENGTH_SHORT).show()
        }
        rB.setOnRatingBarChangeListener { ratingBar, _, _ ->
            Toast.makeText(this,ratingBar.rating.toString(),Toast.LENGTH_LONG).show()
        }
        button.setOnClickListener{
                AlertDialog.Builder(this).setTitle("Calendar View").setMessage("Are u sure u wants to watch calendar?")
                    .setPositiveButton("Ok") { _, _ ->
                        val intent = Intent(this,Main2Activity::class.java)
                        startActivity(intent)
                    }
                    .setNegativeButton("Cancel"){ _, _ ->
                    }
                    .setCancelable(false).show()
        }
        button2.setOnClickListener{
            AlertDialog.Builder(this).setTitle("Time View").setMessage("Are u sure u want to Watch Time?")
                .setPositiveButton("OK"){_,_->
                    val intent2=Intent(this,Main3Activity::class.java)
                    startActivity(intent2)
                }
                .setNegativeButton("Cancel"){_,_->
                }.setCancelable(true).show()
        }
        imageView.setImageResource(R.drawable.b1)
        val array= arrayOf(R.drawable.b1,R.drawable.b3,R.drawable.b4,R.drawable.b5)
        var count: Int
        sb1.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar, p1: Int, p2: Boolean) {
                count=(sb1.progress)
                // Toast.makeText(this,count.toString(),Toast.LENGTH_SHORT).show()
                count %= array.size
                imageView.setImageResource(array[count])
            }

            override fun onStartTrackingTouch(p0: SeekBar) {

            }

            override fun onStopTrackingTouch(p0: SeekBar) {

            }

        })
    }
}
