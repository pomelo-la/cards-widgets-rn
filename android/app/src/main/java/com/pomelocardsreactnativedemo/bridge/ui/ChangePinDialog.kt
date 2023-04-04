package com.pomelocardsreactnativedemo.bridge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.DialogFragment
import com.pomelo.cards.widgets.OnResultListener
import com.pomelo.cards.widgets.ui.changepin.PomeloChangePinComposable

class ChangePinDialog(private val cardId: String, private val onResultListener: OnResultListener): DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                PomeloChangePinComposable(cardId, onResultListener)
            }
        }
    }

    fun show(activity: AppCompatActivity) {
        show(activity.supportFragmentManager, "changePin")
    }
}