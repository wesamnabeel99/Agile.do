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
                //Create emoji view to store the emoji selected
                val selected = dialog.findViewById<AXEmojiEditText>(R.id.selected_emoji)
                val okBtn = dialog.findViewById<AppCompatButton>(R.id.ok_btn)
                val cancelBtn = dialog.findViewById<AppCompatButton>(R.id.cancel_btn)


                val emoji_one = dialog.findViewById<AXEmojiTextView>(R.id.emoji1)
                val emoji_two = dialog.findViewById<AXEmojiTextView>(R.id.emoji2)
                val emoji_three = dialog.findViewById<AXEmojiTextView>(R.id.emoji3)
                val emoji_four = dialog.findViewById<AXEmojiTextView>(R.id.emoji4)
                val emoji_five = dialog.findViewById<AXEmojiTextView>(R.id.emoji5)
                val emoji_six = dialog.findViewById<AXEmojiTextView>(R.id.emoji6)
                val emoji_seven = dialog.findViewById<AXEmojiTextView>(R.id.emoji7)
                val emoji_eight = dialog.findViewById<AXEmojiTextView>(R.id.emoji8)
                val emoji_nine = dialog.findViewById<AXEmojiTextView>(R.id.emoji9)
                val emoji_ten = dialog.findViewById<AXEmojiTextView>(R.id.emoji10)

                val emojiUnicode_one = AXEmojiUtils.getEmojiUnicode(0x270F)
                val emojiUnicode_two = AXEmojiUtils.getEmojiUnicode(0x1F3AE)
                val emojiUnicode_three = AXEmojiUtils.getEmojiUnicode(0x1F489)
                val emojiUnicode_four = AXEmojiUtils.getEmojiUnicode(0x1F4AC)
                val emojiUnicode_five = AXEmojiUtils.getEmojiUnicode(0x1F4BF)
                val emojiUnicode_six = AXEmojiUtils.getEmojiUnicode(0x1F4C3)
                val emojiUnicode_seven = AXEmojiUtils.getEmojiUnicode(0x1F4CC)
                val emojiUnicode_eight = AXEmojiUtils.getEmojiUnicode(0x1F4CE)
                val emojiUnicode_nine = AXEmojiUtils.getEmojiUnicode(0x1F4D7)
                val emojiUnicode_ten = AXEmojiUtils.getEmojiUnicode(0x1F4DE)


                emoji_one.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode_one,20F)
                emoji_two.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode_two,20F)
                emoji_three.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode_three,20F)
                emoji_four.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode_four,20F)
                emoji_five.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode_five,20F)
                emoji_six.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode_six,20F)
                emoji_seven.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode_seven,20F)
                emoji_eight.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode_eight,20F)
                emoji_nine.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode_nine,20F)
                emoji_ten.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode_ten,20F)


                selected.inputType = InputType.TYPE_NULL
                cancelBtn.setOnClickListener{
                    dialog.dismiss()
                    taskImage.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiUnicode,20F)
                }

                emoji_one.setOnClickListener(View.OnClickListener {
                    selected.setText(emoji_one.text)
                })

                emoji_two.setOnClickListener(View.OnClickListener {
                    selected.setText(emoji_two.text)
                })

                emoji_three.setOnClickListener(View.OnClickListener {
                    selected.setText(emoji_three.text)
                })

                emoji_four.setOnClickListener(View.OnClickListener {
                    selected.setText(emoji_four.text)
                })

                emoji_five.setOnClickListener(View.OnClickListener {
                    selected.setText(emoji_five.text)
                })

                emoji_six.setOnClickListener(View.OnClickListener {
                    selected.setText(emoji_six.text)
                })

                emoji_seven.setOnClickListener(View.OnClickListener {
                    selected.setText(emoji_seven.text)
                })

                emoji_eight.setOnClickListener(View.OnClickListener {
                    selected.setText(emoji_eight.text)
                })

                emoji_nine.setOnClickListener(View.OnClickListener {
                    selected.setText(emoji_nine.text)
                })

                emoji_ten.setOnClickListener(View.OnClickListener {
                    selected.setText(emoji_ten.text)
                })

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


