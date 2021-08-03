package com.rarited.timescorer.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.rarited.timescorer.databinding.NewSwDialogBinding

class SWNewDialog : DialogFragment() {

    private lateinit var b: NewSwDialogBinding
    private lateinit var caseName: String
    private lateinit var amountOfTime: String
    private lateinit var listener: SWNewDialogListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            b = NewSwDialogBinding.inflate(layoutInflater)
            builder.setView(b.root)
                .setPositiveButton(
                    "Create"
                ) { _, _ ->
                    if (b.editCase.editableText.isNotEmpty()) {
                        caseName = b.editCase.editableText.toString()
                        amountOfTime = b.editTextTime.editableText.toString()
                        println("Added case with name \"$caseName\" and $amountOfTime hours per (day/week/month)")
                        listener.sendData(caseName, amountOfTime)
                    } else {
                        Toast.makeText(context, "Case name is empty", Toast.LENGTH_SHORT).show()
                    }
                }
                .setNegativeButton("Cancel") { _, _ -> dialog?.cancel() }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as SWNewDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString())
        }
    }

    interface SWNewDialogListener {
        fun sendData(caseName: String, amountOfTime: String)
    }
    //Блять треба розібратись шо воно робить
}