package com.example.alertdialogbasic

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.lang.Exception

class ExampleFragDialog : DialogFragment() {

     var exampleFragDialogListener:ExampleFragDialogListener?=null


    interface ExampleFragDialogListener{
        fun onYesClicked()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder=AlertDialog.Builder(activity)
        builder.setTitle("Alert Dialog")
            .setMessage("This is alert dialog using Dialog fragment")
            .setPositiveButton("YES",DialogInterface.OnClickListener(){
                dialogInterface, i ->
                exampleFragDialogListener?.onYesClicked()
            })

        val alertDialog=builder.create()
        return alertDialog

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ExampleFragDialogListener){
            exampleFragDialogListener=context
        }else{
            throw Exception(context.toString()+" listener is not Attached")
        }
    }

    override fun onDetach() {
        super.onDetach()
        exampleFragDialogListener=null;
    }
}