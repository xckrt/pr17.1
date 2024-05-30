package com.example.pr17

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class main : AppCompatActivity() {
    var login: EditText? = null
    var pass: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login = findViewById(R.id.login)
        pass = findViewById(R.id.pass)
    }

    fun handler(v: View) {
        if (v.id == R.id.save) {
            val ed = getPreferences(MODE_PRIVATE).edit()
            ed.putString("login", login!!.text.toString())
            ed.putString("password", pass!!.text.toString())
            ed.apply()
        }
        if (v.id == R.id.load) {
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Подтверждение загрузки")
                .setMessage("Вы действительно хотите загрузить сохраненные данные?")
                .setPositiveButton("Да") { dialog, which ->
                    login!!.setText(getPreferences(MODE_PRIVATE).getString("login", ""))
                    pass!!.setText(getPreferences(MODE_PRIVATE).getString("password", ""))
                }
                .setNegativeButton("Нет", null)
                .create()

            alertDialog.show()
        }
    }
}