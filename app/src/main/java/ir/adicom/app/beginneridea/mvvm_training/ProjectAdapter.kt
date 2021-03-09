package ir.adicom.app.beginneridea.mvvm_training;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.beginneridea.R
import kotlinx.android.synthetic.main.project_item_layout.view.*

class ProjectAdapter(val onClick: OnClickItemListenerInterface) : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {
    var projectModelList: List<ProjectModel> = mutableListOf()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.project_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return projectModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val projectModel = projectModelList[position]
        holder.itemView.txtPName.text = projectModel.title
        holder.itemView.txt_watcher.text = projectModel.watcher.toString()
        holder.itemView.imgDelete.setOnClickListener {
            onClick.onClickItem(projectModel, false)
        }
        holder.itemView.imgEdit.setOnClickListener {
            onClick.onClickItem(projectModel, true)
        }
    }

    fun setProjects(projects: List<ProjectModel>) {
        projectModelList = projects
        notifyDataSetChanged()
    }
}
