package ir.adicom.app.beginneridea.taskappmvvm.ui.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.taskappmvvm.data.db.Task
import kotlinx.android.synthetic.main.task_item_row.view.*

class TasksAdapter(private val callbackEvent: CallbackEvent) :
    RecyclerView.Adapter<TasksAdapter.ViewHolder>() {
    private var tasks: List<Task> = mutableListOf()

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val tvId: TextView = listItemView.tv_id
        val tvTitle: TextView = listItemView.tv_title
        val llRow: LinearLayout = listItemView.ll_row
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.task_item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        holder.tvId.text = task.id.toString()
        holder.tvTitle.text = task.title
        holder.llRow.setOnClickListener {
            callbackEvent.editTaskClick(task.id)
        }
    }

    fun setItems(tasks: List<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }
}