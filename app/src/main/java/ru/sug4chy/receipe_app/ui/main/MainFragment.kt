package ru.sug4chy.receipe_app.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.sug4chy.receipe_app.R
import ru.sug4chy.receipe_app.databinding.FragmentMainBinding
import ru.sug4chy.receipe_app.databinding.PopupAllergensBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val popupView = PopupAllergensBinding.inflate(layoutInflater, null, false)
        binding.root.post {
            PopupWindow(
                popupView.root,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                false
            ).showAtLocation(view, Gravity.CENTER, 0, 0)
        }
    }
}