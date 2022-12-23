package com.dinesh.quizappassignment7.ui.radioButtonQuestions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.dinesh.quizappassignment7.R

class RBQuestionAdapter(
    private val options: MutableList<String> = mutableListOf()
) : RecyclerView.Adapter<RBQuestionAdapter.RBQuestionViewHolder>(){

    inner class RBQuestionViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val optionRB: RadioButton = view.findViewById(R.id.optionRB)
        fun bind(option: String) {
            optionRB.text = option
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RBQuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_radio_option, parent, false)
        return RBQuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RBQuestionViewHolder, position: Int) {
        holder.bind(options[position])
    }

    override fun getItemCount(): Int = options.size
}