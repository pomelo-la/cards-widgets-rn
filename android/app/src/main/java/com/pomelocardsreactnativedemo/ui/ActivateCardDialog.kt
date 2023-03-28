package com.pomelocardsreactnativedemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.DialogFragment
import com.pomelo.cards.widgets.OnResultListener
import com.pomelo.cards.widgets.ui.activatecard.PomeloActivateCardView

class ActivateCardDialog(val onResultListener: OnResultListener): DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                PomeloActivateCardView(onResultListener)
            }
        }
    }

    fun show(activity: AppCompatActivity) {
        show(activity.supportFragmentManager, "activate")
    }
}