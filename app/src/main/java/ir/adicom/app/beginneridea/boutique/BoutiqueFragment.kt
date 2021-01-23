package ir.adicom.app.beginneridea.boutique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.news.DataFakeGenerator

class BoutiqueFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var fragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.fragment_boutique, container, false)
        recyclerView = fragmentView.findViewById(R.id.rv_boutique)

        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = BoutiqueAdapter(DataFakeGenerator.getClothes(context!!))
        return fragmentView
    }

    companion object {
        fun newInstance(): BoutiqueFragment? {
            val args = Bundle()
            val fragment = BoutiqueFragment()
            fragment.setArguments(args)
            return fragment
        }
    }
}