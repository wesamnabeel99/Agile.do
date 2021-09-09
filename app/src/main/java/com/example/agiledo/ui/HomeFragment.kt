package com.example.agiledo.ui

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.agiledo.R
import com.example.agiledo.data.DataManager
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.FragmentAddDialogBinding
import com.example.agiledo.databinding.FragmentHomeBinding
import com.example.agiledo.ui.adapters.TaskAdapter
import com.google.android.material.textfield.TextInputEditText

class HomeFragment : BaseFragment<FragmentHomeBinding>() , TaskInteractionListener {
    //region initilize variables
    override val LOG_TAG: String = "HOME_FRAGMENT"
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = FragmentHomeBinding::inflate
    lateinit var adapter : TaskAdapter

    //endregion

    //region setup
    override fun setup() {
        adapter = TaskAdapter(DataManager.listOfTasks, this)
        binding?.taskRecyclerView?.adapter =adapter

          /**
           * @param thisIteman an val to bind this item
           * @param itemTouchHelper an val to add swipe to dismiss *
           * @author Akram
           **/
          val thisItem = binding?.taskRecyclerView
          val itemTouchHelper = ItemTouchHelper (SwipeToDelete(adapter))
          itemTouchHelper.attachToRecyclerView(thisItem)

          val cardView = binding?.taskRecyclerView


        }


    //endregion
    //region  addCallbacks
    override fun addCallbacks() {

        binding?.addTask?.setOnClickListener {
           openAddDialog()
        }
    }

    private fun openAddDialog() {
        val addDialogView = LayoutInflater.from(context).inflate(R.layout.fragment_add_dialog, null) //Inflate the dialog with add view
        var dialogBinding = FragmentAddDialogBinding.bind(addDialogView)
        val mBuilder = AlertDialog.Builder(context)
            .setView(addDialogView)
            .setTitle("Add New Task")
        val mAlertDialog = mBuilder.show()  //show dialog


        //confirm add button of add layout ,
        dialogBinding.confirmAdd.setOnClickListener{
            mAlertDialog.dismiss()
            val newTask = Task(
                taskName=  dialogBinding.taskNameInputEdittext.text.toString(),
                taskDescription = dialogBinding.taskDescriptionInputEdittext.text.toString(),
                taskStartDate = dialogBinding.startDateInputEdittext.text.toString(),
                taskDueDate = dialogBinding.dueDateInputEdittext.text.toString(),
                taskAssignedTo = dialogBinding.assignToInputEdittext.text.toString()
            )
            DataManager.addTask(newTask)
            adapter.setData(DataManager.tasks)
        }
    }
    //endregion


    //region deleteTaskAt
    /**
     * this function delete a task from the list of task
     * @param index an Int representing the position of the deleted task
     * @return nothing
     * @author Anwar
     */
    override fun deleteTaskAt(index: Int) {
        DataManager.deleteTaskAt(index)
        adapter.setData(DataManager.tasks)
    }
    //endregion
}
