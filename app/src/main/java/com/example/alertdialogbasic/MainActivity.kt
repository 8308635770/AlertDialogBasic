package com.example.alertdialogbasic

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(),ExampleFragDialog.ExampleFragDialogListener {

    lateinit var button: Button;
    lateinit var tv_counter:TextView
    var counter=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn);
        tv_counter=findViewById(R.id.tv_counter)

        button.setOnClickListener(View.OnClickListener {
//            showAlertDialog()
            openAlertDialogFromFragment()
        })

    }

    fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Title")
            .setMessage("Hello please presses yes or no")
//            builder.setPositiveButton("Next Activity",DialogInterface.OnClickListener(){
//                dialogInterface, i ->
//                Toast.makeText(this,"Yes clicked"+i.toString(),Toast.LENGTH_SHORT).show()
//            })
//            .setPositiveButton("Next Activity",null)
            .setPositiveButton("yes",DialogInterface.OnClickListener(){
                dialogInterface, i ->

            })
            .setNegativeButton("No",DialogInterface.OnClickListener(){
                dialogInterface, i ->
                Toast.makeText(this@MainActivity,"No clicked"+i.toString(),Toast.LENGTH_SHORT).show()

            })

        val dialog=builder.create()
        dialog.show()

        val btn=dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        btn.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Next Activity clicked",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity,MainActivity2::class.java))
        })


    }

    fun openAlertDialogFromFragment(){
        val exampleFragDialog=ExampleFragDialog()
        exampleFragDialog.show(supportFragmentManager,"example dialog")
    }

    override fun onYesClicked() {
        counter++
        tv_counter.setText(counter.toString())
    }
}