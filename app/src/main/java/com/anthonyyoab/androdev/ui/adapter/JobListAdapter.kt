package com.anthonyyoab.androdev.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.anthonyyoab.androdev.databinding.ItemJobBinding
import com.anthonyyoab.androdev.databinding.ItemPokemonBinding
import com.anthonyyoab.androdev.ui.model.JobListModel

class JobListAdapter(private var listJobList: ArrayList<JobListModel>): RecyclerView.Adapter<JobListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemJobBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val job = listJobList[adapterPosition]
                Toast.makeText(
                    binding.root.context, "Job Name : ${job.jobTitle}", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ItemJobBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val job = listJobList[position]
            with(holder) {
                binding.jobName.text = job.jobTitle
                // show image from asset drawable
                binding.jobImage.setImageResource(job.jobImage)
                binding.jobCompany.text = job.jobCompanyName
            }
        }

        override fun getItemCount(): Int {
            return listJobList.size
        }
    }