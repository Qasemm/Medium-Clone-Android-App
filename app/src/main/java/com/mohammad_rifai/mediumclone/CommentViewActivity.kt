package com.mohammad_rifai.mediumclone

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import app_networking.Activation
import kotlinx.android.synthetic.main.content_comment_view.*


class CommentViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_view)
        setSupportActionBar(findViewById(R.id.toolbar))
        var active=Activation(this,packageName)
        setTitle("Comments")
        var Anim=AnimationUtils.loadAnimation(this,R.anim.fade_in)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
          active.IsLogging {
              var result=it as Array<Any>
              if(result[0] as Boolean){
                var alert=Dialog(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar)
                  alert.setContentView(R.layout.comment_dialog)
                  alert.show()
                  alert.findViewById<LinearLayout>(R.id.layout).startAnimation(Anim)
              }else{
                  Toast.makeText(this,"you must have account to comment!",Toast.LENGTH_LONG).show()
                  var intent=Intent(this,Register::class.java)
                  startActivity(intent)
              }
          }
        }
        var data= arrayListOf<Array<String>>()
        data.add(arrayOf("3",
            "Top 5 games in 2020",
            "click here",
            "Rami Ara"
            ,"https://static.wixstatic.com/media/d4ec17_7abe04ddcab547c3a464e8ba04d8d8f3~mv2.jpeg/v1/fill/w_660,h_660,al_c,q_85,usm_0.66_1.00_0.01/d4ec17_7abe04ddcab547c3a464e8ba04d8d8f3~mv2.webp",
            "953",
            "2020/10/11"
        ))
        data.add(arrayOf("3",
            "Top 5 games in 2020",
            "click here",
            "Rami Ara"
            ,"https://static.wixstatic.com/media/d4ec17_7abe04ddcab547c3a464e8ba04d8d8f3~mv2.jpeg/v1/fill/w_660,h_660,al_c,q_85,usm_0.66_1.00_0.01/d4ec17_7abe04ddcab547c3a464e8ba04d8d8f3~mv2.webp",
            "953",
            "2020/10/11"
        ))
        data.add(arrayOf("3",
            "Top 5 games in 2020",
            "click here",
            "Rami Ara"
            ,"https://static.wixstatic.com/media/d4ec17_7abe04ddcab547c3a464e8ba04d8d8f3~mv2.jpeg/v1/fill/w_660,h_660,al_c,q_85,usm_0.66_1.00_0.01/d4ec17_7abe04ddcab547c3a464e8ba04d8d8f3~mv2.webp",
            "953",
            "2020/10/11"
        ))
        list_comments.adapter=PostAdapter(this,data)
        var anim= AnimationUtils.loadAnimation(this,R.anim.fade_in)
        list_comments.startAnimation(anim)
    }
}