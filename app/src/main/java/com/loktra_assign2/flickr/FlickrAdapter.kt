package com.loktra_assign2.flickr

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.transition.TransitionManager
import android.util.Log
import kotlinx.android.synthetic.main.single_image.view.*


/**
 * Created by user on 4/24/2018.
 */
class FlickrAdapter(var context: Context, var recyclerView: RecyclerView, var list: ArrayList<ImagePOJO>)
    : RecyclerView.Adapter<FlickrAdapter.FilckrViewHolder>() {
    var mExpandedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FilckrViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.single_image, parent, false)
        var holder = FilckrViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FilckrViewHolder?, position: Int) {

        var item = list.get(position)
        var isExpanded = position === mExpandedPosition
        var prevPositon = 0

        holder?.itemView?.image2?.setImageDrawable(item.drawable1)
        holder?.itemView?.image?.setImageDrawable(item.drawable2)

        holder?.detail?.setVisibility(if (isExpanded) View.VISIBLE else View.GONE)
        holder?.itemView?.isActivated = isExpanded
        holder?.itemView?.image?.setOnClickListener {
            Log.e("value", item.detail1)
            if (prevPositon == 0) {
                mExpandedPosition = if (isExpanded) -1 else position
                TransitionManager.beginDelayedTransition(recyclerView)
                notifyDataSetChanged()
                holder.itemView.detail.text = item.detail2
                prevPositon = 1
            } else {
                holder.itemView.detail.text = item.detail2
                prevPositon = 0
            }

        }

        holder?.itemView?.image2?.setOnClickListener {
            if (prevPositon == 0) {
                mExpandedPosition = if (isExpanded) -1 else position
                TransitionManager.beginDelayedTransition(recyclerView)
                notifyDataSetChanged()
                holder.itemView.detail.text = item.detail1
                prevPositon = 1
            } else {
                holder.itemView.detail.text = item.detail1
                prevPositon = 0
            }
        }
    }


    class FilckrViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var detail = view.detail
    }
}