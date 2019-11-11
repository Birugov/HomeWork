package com.example.androidcourse.ui.halloffame

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.androidcourse.R
import kotlinx.android.synthetic.main.fragment_hall.*

class HallFragment : Fragment() {

    private var listener: OnButtonClick?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hall, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_words.setOnClickListener {
            listener?.onHallButtonClick()
        }
    }
    interface OnButtonClick{
        fun onHallButtonClick()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnButtonClick) {
            listener = context
        } else {
            throw RuntimeException("$context must implement onHallButtonClick")
        }
    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}