package com.example.agiledo.utils

import android.content.Context
import com.example.agiledo.data.TaskDbHelper
import com.aghajari.emojiview.AXEmojiUtils
import com.aghajari.emojiview.view.AXEmojiTextView

object Constants {


object Constants {
    lateinit var dbHelper:TaskDbHelper
    fun createTable(context:Context){
        dbHelper=TaskDbHelper(context)
    }
    object Database {
        const val TABLE_NAME = "TASKS"
        const val TASK_ID = "id"
        const val TASK_NAME = "taskName"
        const val TASK_DESCRIPTION = "taskDescription"
        const val TASK_START_DATE = "startDate"
        const val TASK_DUE_DATE = "dueDate"
        const val TASK_ASSIGNED_TO = "assignedTo"


    }
    object CursorIndexes{
        const val TASK_ID=0

        const val TASK_NAME = 1
        const val TASK_DESCRIPTION = 2
        const val TASK_START_DATE = 3
        const val TASK_DUE_DATE = 4
        const val TASK_ASSIGNED_TO=5

    }
    object Emoji {
         val PENCIL_EMOJI = AXEmojiUtils.getEmojiUnicode(0x270F)
         val GAMING_EMOJI = AXEmojiUtils.getEmojiUnicode(0x1F3AE)
         val VACCINE_EMOJI = AXEmojiUtils.getEmojiUnicode(0x1F489)
         val CHAT_EMOJI = AXEmojiUtils.getEmojiUnicode(0x1F4AC)
         val DVD_EMOJI = AXEmojiUtils.getEmojiUnicode(0x1F4BF)
         val PAPER_EMOJI = AXEmojiUtils.getEmojiUnicode(0x1F4C3)
         val PIN_EMOJI = AXEmojiUtils.getEmojiUnicode(0x1F4CC)
         val ATTACHMENT_EMOJI = AXEmojiUtils.getEmojiUnicode(0x1F4CE)
         val BOOK_EMOJI = AXEmojiUtils.getEmojiUnicode(0x1F4D7)
         val CALL_EMOJI = AXEmojiUtils.getEmojiUnicode(0x1F4DE)

    }
    }
