package com.example.agiledo.ui

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.agiledo.data.DataManager
import com.example.agiledo.data.TaskDbHelper
import com.example.agiledo.data.domain.Task
import com.example.agiledo.databinding.FragmentHomeBinding
import com.example.agiledo.ui.adapters.TaskAdapter
import com.example.agiledo.utils.Constants

class HomeFragment : BaseFragment<FragmentHomeBinding>() , TaskInteractionListener{
    //region initilize variables
    override val LOG_TAG: String = "HOME_FRAGMENT"
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = FragmentHomeBinding::inflate
    lateinit var adapter : TaskAdapter
    //endregion

    override fun setup() {
        adapter = TaskAdapter(DataManager.tasksFromTable, this)
        binding?.taskRecyclerView?.adapter =adapter


          /**
           * @param thisIteman an val to bind this item
           * @param itemTouchHelper an val to add swipe to dismiss *
           * @author Akram
           **/
          val thisItem = binding?.taskRecyclerView
          val itemTouchHelper = ItemTouchHelper (SwipeToDelete(adapter,Constants.dbHelper))
          itemTouchHelper.attachToRecyclerView(thisItem)

          val cardView = binding?.taskRecyclerView



      }

    //endregion
    //region  addCallbacks
    override fun addCallbacks() {
        binding?.addTask?.setOnClickListener {
            addNewTask()
        }
    }
    //endregion

    //region addNewTask
    /**
     * this function add new task of type object of class Task to the list of task
     * @param nothing
     * @return nothing
     * @author Anwar
     */
    private fun addNewTask() {
        val newTask = Task(
            taskName = binding?.taskName?.text.toString(),
            taskDescription = binding?.taskDescription?.text.toString(),
            taskStartDate = binding?.startDate?.text.toString(),
            taskDueDate = binding?.dueDate?.text.toString(),
            taskAssignedTo = binding?.personName?.text.toString()
        )
        DataManager.addTask(newTask)
        adapter.setData(DataManager.tasksFromTable)
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
        adapter.setData(DataManager.tasksFromTable)
    }
    //endregion
}
