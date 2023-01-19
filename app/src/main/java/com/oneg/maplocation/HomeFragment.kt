package com.oneg.maplocation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.oneg.maplocation.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val recruitmentDetailActivity= inflater.inflate(R.layout.fragment_home, container, false)
        return recruitmentDetailActivity
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }
    private fun setOnClickListener() {
        val btnSequence = btn.setOnClickListener(this)
    }

    companion object {
        private const val TAG = "HomeFragment"
        fun instance() = HomeFragment()
    }

    override fun onClick(p0: View?) {
        val intent = Intent(activity, RecruitmentDetailActivity::class.java)
        startActivity(intent)
    }
}