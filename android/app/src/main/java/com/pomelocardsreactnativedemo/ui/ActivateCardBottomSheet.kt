package com.pomelocardsreactnativedemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ScaffoldState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pomelo.cards.widgets.CardsResult
import com.pomelo.cards.widgets.OnResultListener
import com.pomelo.cards.widgets.ui.activatecard.PomeloActivateCardView

class ActivateCardBottomSheet(val onResultListener: OnResultListener): BottomSheetDialogFragment() {
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