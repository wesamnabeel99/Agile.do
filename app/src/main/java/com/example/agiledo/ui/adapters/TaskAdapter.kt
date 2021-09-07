package com.example.agiledo.ui.adapters

import android.app.Dialog
import android.text.Editable
import android.text.InputType
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.aghajari.emojiview.AXEmojiUtils
import com.aghajari.emojiview.view.*
import com.example.agiledo.R
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.ItemTaskBinding


class TaskAdapter(var list: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return TaskHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        var currentItem = list[position]
        holder.binding.apply {
            taskTitle.text = currentItem.taskName
            taskDescription.text = currentItem.taskDescription
            taskStartDate.text = currentItem.taskStartDate
            taskDueDate.text = currentItem.taskDueDate
            taskAssignedTo.text= currentItem.taskAssignedTo
            personFirstLetter.text = currentItem.taskAssignedTo.first().toString()

            //Place Holder For Emoji
            //TODO: Get the emoji code from Database
            val emojiUnicode = AXEmojiUtils.getEmojiUnicode(0x1f60d)
            taskImage.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode,20F)
            taskImage.inputType = InputType.TYPE_NULL
            taskImage.setOnClickListener(View.OnClickListener {


                (taskImage.text as SpannableStringBuilder?)?.clear()
                //Create dialog object and initialize its attribute
                val dialog = Dialog(holder.binding.root.context)
                dialog.setContentView(R.layout.emoji_dialog)
                //Create emoji popup layout to select emoji from
                val emojiPopUp = dialog.findViewById<AXEmojiPopupLayout>(R.id.emoji_layout)
                //Create emoji view to store the emoji selected
                val selected = dialog.findViewById<AXEmojiEditText>(R.id.selected_emoji)

                val okBtn = dialog.findViewById<AppCompatButton>(R.id.ok_btn)
                val cancelBtn = dialog.findViewById<AppCompatButton>(R.id.cancel_btn)

                val emojiView = AXSingleEmojiView(holder.binding.root.context)
                selected.inputType = InputType.TYPE_NULL

                cancelBtn.setOnClickListener{
                    dialog.dismiss()
                    taskImage.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode,20F)
                }
                emojiView.editText = selected
                emojiPopUp.initPopupView(emojiView)
                emojiPopUp.show()
                dialog.show()
                okBtn.setOnClickListener{
                    //TODO: Store the new emoji code in sql database.
                    val x = selected.text
                    taskImage.text = x
                    dialog.dismiss()
                }
                selected.setOnClickListener { selected.text?.clear() }
            })
        }
    }

    class TaskHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemTaskBinding.bind(itemView)
    }
}


