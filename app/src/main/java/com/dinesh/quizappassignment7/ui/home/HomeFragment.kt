package com.dinesh.quizappassignment7.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.dinesh.quizappassignment7.R
import com.dinesh.quizappassignment7.data.Quiz
import com.dinesh.quizappassignment7.data.QuizFakeData

class HomeFragment : Fragment(R.layout.fragment_home), OnClickListener{

    private lateinit var viewPager: ViewPager2
    private lateinit var _context: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this._context = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextButton = view.findViewById<Button>(R.id.next_button)
        nextButton.setOnClickListener(this)

        initViewPager(view)

    }

    private fun initViewPager(view: View) {
        viewPager = view.findViewById(R.id.view_pager)

        val viewPagerAdapter = ViewPagerAdapter(this, QuizFakeData.getQuizQuestions())//get data from data base
        viewPager.adapter = viewPagerAdapter

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.next_button -> {
                viewPager.setCurrentItem(viewPager.currentItem + 1, true)
            }
        }
    }


}