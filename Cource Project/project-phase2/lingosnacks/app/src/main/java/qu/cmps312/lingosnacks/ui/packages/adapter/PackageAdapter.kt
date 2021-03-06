package qu.cmps312.lingosnacks.ui.packages.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.package_list_item.view.*
import qu.cmps312.lingosnacks.R
import qu.cmps312.lingosnacks.databinding.PackageListItemBinding
import qu.cmps312.lingosnacks.model.LearningPackage
import qu.cmps312.lingosnacks.ui.viewmodel.UserInfo

enum class PackageAction {
    View, Update, DeleteOnlinePackage, DeleteLocalPackage, Download, Ratings, Rate, MatchDefinition, UnscrambleSentence
}

class PackageAdapter(
    val packageActionListener: (LearningPackage, PackageAction) -> Unit,
) : RecyclerView.Adapter<PackageAdapter.PackageViewHolder>() {

    var learningPackages = listOf<LearningPackage>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var userInfo = UserInfo()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class PackageViewHolder(private val viewBinding: PackageListItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(learningPackage: LearningPackage) {
            viewBinding.learningPackage = learningPackage
            viewBinding.userInfo = userInfo

            viewBinding.root.viewBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.View)
            }

            viewBinding.root.updateBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.Update)
            }

            viewBinding.root.deleteOnlinePackageBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.DeleteOnlinePackage)
            }

            viewBinding.root.rateBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.Rate)
            }

            viewBinding.root.ratingsBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.Ratings)
            }

            viewBinding.root.ratingsBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.Ratings)
            }

            viewBinding.root.ratingsBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.Ratings)
            }

            viewBinding.root.unscrambleSentenceBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.UnscrambleSentence)
            }

            viewBinding.root.matchDefinitionBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.MatchDefinition)
            }

            viewBinding.root.downLoadBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.Download)
            }

            viewBinding.root.deleteLocalPackageBtn.setOnClickListener {
                packageActionListener(learningPackage, PackageAction.DeleteLocalPackage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        val viewBinding: PackageListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.package_list_item, parent, false)

        return PackageViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) =
            holder.bind(learningPackages[position])

    override fun getItemCount() = learningPackages.size
}