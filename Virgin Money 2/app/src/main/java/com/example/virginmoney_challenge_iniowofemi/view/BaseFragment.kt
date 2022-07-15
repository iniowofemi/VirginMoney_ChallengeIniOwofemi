package com.example.virginmoney_challenge_iniowofemi.view

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.virginmoney_challenge_iniowofemi.viewmodel.VirginMoneyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {

    protected  val virginMoneyViewModel by lazy{
        ViewModelProvider(requireActivity())[VirginMoneyViewModel::class.java]
    }

    protected fun showError(message: String, action: () -> Unit) {
        AlertDialog.Builder(requireContext())
            .setTitle("Error")
            .setMessage(message)
            .setNegativeButton("DISMISS") { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("RETRY",) { _, _ ->
                action.invoke()
            }
    }
}