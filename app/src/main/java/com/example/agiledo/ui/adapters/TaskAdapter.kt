package com.example.agiledo.ui.adapters

import android.app.Dialog
import android.text.Editable
import android.text.InputType
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aghajari.emojiview.AXEmojiUtils
import com.aghajari.emojiview.view.*
import com.example.agiledo.R
import com.example.agiledo.data.DataManager
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.ItemTaskBinding
import com.example.agiledo.utils.Constants
import com.example.agiledo.ui.TaskInteractionListener
import com.example.olympics.ui.TaskDiffUtil


class TaskAdapter(private var list: List<Task>, private val listener : TaskInteractionListener) : RecyclerView.Adapter<TaskAdapter.TaskHolder>(){
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

            fun addCallBack(){
                //Place Holder For Emoji
                val defaultEmoji = Constants.Emoji.CALL_EMOJI

                taskImage.text = AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,defaultEmoji,20F)
                taskImage.inputType = InputType.TYPE_NULL

                fun getEmoji(emojiunicodeOne: String?): CharSequence? {
                    return AXEmojiUtils.replaceWithEmojis(holder.binding.root.context,emojiunicodeOne,20F)
                }

                fun bindTheEmoji(emojiView: AXEmojiTextView, emojiCode:String) {
                    emojiView.text = getEmoji(emojiCode)
                }

                taskImage.setOnClickListener {
                    //Create dialog object and initialize its attribute
                    val dialog = Dialog(holder.binding.root.context)
                    dialog.setContentView(R.layout.emoji_dialog)



                    val emoji_one = dialog.findViewById<AXEmojiTextView>(R.id.emojiOne)
                    val emoji_two = dialog.findViewById<AXEmojiTextView>(R.id.emojiTwo)
                    val emoji_three = dialog.findViewById<AXEmojiTextView>(R.id.emojiThree)
                    val emoji_four = dialog.findViewById<AXEmojiTextView>(R.id.emojiFour)
                    val emoji_five = dialog.findViewById<AXEmojiTextView>(R.id.emojiFive)
                    val emoji_six = dialog.findViewById<AXEmojiTextView>(R.id.emojiSix)
                    val emoji_seven = dialog.findViewById<AXEmojiTextView>(R.id.emojiSeven)
                    val emoji_eight = dialog.findViewById<AXEmojiTextView>(R.id.emojiEight)
                    val emoji_nine = dialog.findViewById<AXEmojiTextView>(R.id.emojiNine)
                    val emoji_ten = dialog.findViewById<AXEmojiTextView>(R.id.emojiTen)

                    fun replaceStringWithEmoji(){
                        bindTheEmoji(emoji_one,Constants.Emoji.PENCIL_EMOJI)
                        bindTheEmoji(emoji_two,Constants.Emoji.GAMING_EMOJI)
                        bindTheEmoji(emoji_three,Constants.Emoji.VACCINE_EMOJI)
                        bindTheEmoji(emoji_four,Constants.Emoji.CHAT_EMOJI)
                        bindTheEmoji(emoji_five,Constants.Emoji.BOOK_EMOJI)
                        bindTheEmoji(emoji_six,Constants.Emoji.DVD_EMOJI)
                        bindTheEmoji(emoji_seven,Constants.Emoji.PAPER_EMOJI)
                        bindTheEmoji(emoji_eight,Constants.Emoji.PIN_EMOJI)
                        bindTheEmoji(emoji_nine,Constants.Emoji.ATTACHMENT_EMOJI)
                        bindTheEmoji(emoji_ten,Constants.Emoji.CALL_EMOJI)
                    }

                    replaceStringWithEmoji()


                    fun addEmojiListeners(emojiView:AXEmojiTextView) {
                        emojiView.setOnClickListener(View.OnClickListener {
                            taskImage.setText(emojiView.text)
                            dialog.dismiss()
                        })
                    }
                    fun addEmojiListenersCallBacks() {
                        addEmojiListeners(emoji_one)
                        addEmojiListeners(emoji_two)
                        addEmojiListeners(emoji_three)
                        addEmojiListeners(emoji_four)
                        addEmojiListeners(emoji_five)
                        addEmojiListeners(emoji_six)
                        addEmojiListeners(emoji_seven)
                        addEmojiListeners(emoji_eight)
                        addEmojiListeners(emoji_nine)
                        addEmojiListeners(emoji_ten)
                    }

                    addEmojiListenersCallBacks()
                    dialog.show()
                }
            }
            addCallBack()
        }

    }



    //region set data
    /**
     * this function will call in HomeFragment to replace the old list of task with the new list of task after addition or deletion
     * @param newList a List of objects of class Task representing the list to be replaced by
     * @return nothing
     * @author Anwar
     */
    fun setData(newList: List<Task>){
        val diffResult = DiffUtil.calculateDiff(TaskDiffUtil(list, newList))
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }
    //endregion

    class TaskHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemTaskBinding.bind(itemView)
    }
}

