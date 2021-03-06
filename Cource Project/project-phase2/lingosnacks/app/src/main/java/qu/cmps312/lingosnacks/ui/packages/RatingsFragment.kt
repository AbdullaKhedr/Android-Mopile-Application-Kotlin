package qu.cmps312.lingosnacks.ui.packages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.package_ratings_fragment.*
import qu.cmps312.lingosnacks.R
import qu.cmps312.lingosnacks.ui.packages.adapter.RatingAdapter
import qu.cmps312.lingosnacks.ui.viewmodel.PackageViewModel


class RatingsFragment : Fragment(R.layout.package_ratings_fragment) {
    private val packageViewModel by activityViewModels<PackageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        definitionsRv.apply {
            adapter= RatingAdapter(packageViewModel.getRatings())
            layoutManager = LinearLayoutManager(context)
        }
    }
}