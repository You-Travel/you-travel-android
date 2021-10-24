package travel.you.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

import androidx.appcompat.app.AlertDialog
import travel.you.App
import travel.you.databinding.DialogUrlBinding


class DialogUrl : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder =  AlertDialog.Builder(activity!!)
        val inflater = activity!!.layoutInflater
        val binding = DialogUrlBinding.inflate(inflater)
        val view = binding.root
        builder.setView(view)

        val dialog =  this

        binding.btnApply.setOnClickListener {
            App.SERVER_URL.URL = binding.etUrl.text.toString()
            dialog.dismiss()
        }

        return builder.create()
    }

}