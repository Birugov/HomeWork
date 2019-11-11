package com.example.androidcourse.ui.send

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidcourse.R
import kotlinx.android.synthetic.main.fragment_send.*

class SendFragment : Fragment() {


    private var listener: onButtonClick? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_send, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_send.setOnClickListener {
            listener?.onSendButtonClick(et_wishes.text.toString(), et_author.text.toString())
        }
    }

    interface onButtonClick {
        fun onSendButtonClick(wishes: String, author: String)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is onButtonClick) {
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