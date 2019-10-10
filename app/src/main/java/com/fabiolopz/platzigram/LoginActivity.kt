package com.fabiolopz.platzigram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fabiolopz.platzigram.view.ContainerActivity
import com.fabiolopz.platzigram.view.CreateAccountActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun goContainer(view:View){
        val intent:Intent = Intent(this,  ContainerActivity::class.java)
        startActivity(intent)
    }

    fun goCreateAccount(view:View){
        val intent:Intent = Intent(this, CreateAccountActivity::class.java)
        startActivity(intent)
    }

    fun goBrowser(view:View){
        val url = "platzi.com/"
        if (url != null && !url!!.isEmpty()) {
            val intentWeb = Intent()
            intentWeb.action = Intent.ACTION_VIEW
            intentWeb.data = Uri.parse("http://" + url!!)
            startActivity(intentWeb)
        }
    }
}
