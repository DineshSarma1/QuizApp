package com.dinesh.quizappassignment7.ui.radioButtonQuestions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.dinesh.quizappassignment7.R
import com.dinesh.quizappassignment7.util.RadioClickInterface


class RBQuestionAdapter(
    private val options: MutableList<String> = mutableListOf(),
    private val listener: RadioClickInterface
) : RecyclerView.Adapter<RBQuestionAdapter.RBQuestionViewHolder>(){

    var selectedPosition = -1

    inner class RBQuestionViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val optionRB: RadioButton = view.findViewById(R.id.optionRB)
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

        //to achieve radio behaviour these operations are performed(only one option can select)
        holder.optionRB.isChecked = position == selectedPosition;
        holder.optionRB.setOnClickListener {
            selectedPosition=  position
            notifyDataSetChanged()
            listener.onRadioButtonClicked(position, holder.optionRB.text.toString())
        }
    }

    override fun getItemCount(): Int = options.size
}