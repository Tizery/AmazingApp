package com.example.amazingapp.ui.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amazingapp.databinding.FragmentRecyclerItemEarthBinding
import com.example.amazingapp.databinding.FragmentRecyclerItemHeaderBinding
import com.example.amazingapp.databinding.FragmentRecyclerItemMarsBinding

class RecyclerFragmentAdapter(
    private val data: MutableList<Pair<Data, Boolean>>,
    private val callbackListener: MyCallback
) : RecyclerView.Adapter<BaseViewHolder>(), ItemTouchHelperAdapter {

    fun appendItem() {
        data.add(generateItem())
        notifyItemInserted(itemCount - 1)
    }

    private fun generateItem(): Pair<Data, Boolean> {
        return Data(someText = "Mars") to false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            TYPE_EARTH -> {
                val bindingViewHolder = FragmentRecyclerItemEarthBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                EarthViewHolder(bindingViewHolder.root)
            }
            TYPE_HEADER -> {
                val bindingViewHolder = FragmentRecyclerItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HeaderViewHolder(bindingViewHolder.root)
            }
            else -> {
                val bindingViewHolder = FragmentRecyclerItemMarsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                MarsViewHolder(bindingViewHolder.root)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].first.type
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class EarthViewHolder(view: View) : BaseViewHolder(view) {
        override fun bind(data: Pair<Data, Boolean>) {
            FragmentRecyclerItemEarthBinding.bind(itemView).apply {
                someTextTextView.text = data.first.someText
                descriptionTextView.text = data.first.someDescription
                earthImageView.setOnClickListener {
                    callbackListener.onClick(layoutPosition)
                }
            }
        }
    }

    inner class MarsViewHolder(view: View) : BaseViewHolder(view), ItemTouchHelperViewHolder {
        override fun bind(data: Pair<Data, Boolean>) {
            FragmentRecyclerItemMarsBinding.bind(itemView).apply {
                someTextTextView.text = data.first.someText
                marsImageView.setOnClickListener {
                    callbackListener.onClick(layoutPosition)
                }
                addItemImageView.setOnClickListener {
                    addItemToPosition()
                }
                removeItemImageView.setOnClickListener {
                    removeItem()
                }
                moveItemDown.setOnClickListener {
                    moveDown()
                }
                moveItemUp.setOnClickListener {
                    moveUp()
                }
                marsDescriptionTextView.visibility = if (data.second) View.VISIBLE else View.GONE
                someTextTextView.setOnClickListener {
                    toggleDescription()
                }

            }
        }

        private fun toggleDescription() {
            data[layoutPosition] = data[layoutPosition].run {
                first to !second
            }
            notifyItemChanged(layoutPosition)
        }

        private fun moveUp() {
            layoutPosition.takeIf { it > 1 }?.also { currentPosition ->
                data.removeAt(layoutPosition).apply {
                    data.add(layoutPosition - 1, this)
                }
                notifyItemMoved(layoutPosition, layoutPosition - 1)
            }
        }

        private fun moveDown() {
            layoutPosition.takeIf { it < data.size - 1 }?.also { currentPosition ->
                data.removeAt(layoutPosition).apply {
                    data.add(layoutPosition + 1, this)
                }
                notifyItemMoved(layoutPosition, layoutPosition + 1)
            }
        }

        private fun addItemToPosition() {
            data.add(layoutPosition, generateItem())
            notifyItemInserted(layoutPosition)
        }

        private fun removeItem() {
            data.removeAt(layoutPosition)
            notifyItemRemoved(layoutPosition)
        }

        override fun onItemSelected() {
            itemView.setBackgroundColor(Color.YELLOW)
        }

        override fun onItemClear() {
            itemView.setBackgroundColor(0)
        }
    }

    inner class HeaderViewHolder(view: View) : BaseViewHolder(view) {
        override fun bind(data: Pair<Data, Boolean>) {
            FragmentRecyclerItemHeaderBinding.bind(itemView).apply {
                header.text = data.first.someText
                root.setOnClickListener {
                    callbackListener.onClick(layoutPosition)
                }
            }
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        data.removeAt(fromPosition).apply {
            data.add(toPosition, this)
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }
}