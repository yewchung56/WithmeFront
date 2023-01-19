package com.oneg.maplocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.oneg.maplocation.databinding.ActivityNaviBinding

private const val TAG_HOME = "home_fragment"
private const val TAG_HISTORY = "history_fragment"
private const val TAG_NOTE = "note_fragment"
private const val TAG_MYPG = "mypg_fragement"

class NaviActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.historyFragment -> setFragment(TAG_HISTORY, HistoryFragment())
                R.id.noteFragment -> setFragment(TAG_NOTE, NoteFragment())
                R.id.mypgFragment -> setFragment(TAG_MYPG, MypgFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null) {
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }
        val home = manager.findFragmentByTag(TAG_HOME)
        val history = manager.findFragmentByTag(TAG_HISTORY)
        val note = manager.findFragmentByTag(TAG_NOTE)
        val mypg = manager.findFragmentByTag(TAG_MYPG)

        if (home != null) {
            fragTransaction.hide(home)
        }
        if (history != null) {
            fragTransaction.hide(history)
        }
        if (note != null) {
            fragTransaction.hide(note)
        }
        if (mypg != null) {
            fragTransaction.hide(mypg)
        }
        if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        } else if (tag == TAG_HISTORY) {
            if (history != null) {
                fragTransaction.show(history)
            }
        } else if (tag == TAG_NOTE) {
            if (note != null) {
                fragTransaction.show(note)
            }
        } else if (tag == TAG_MYPG) {
            if (mypg != null) {
                fragTransaction.show(mypg)
            }
        }
        fragTransaction.commitAllowingStateLoss()
    }
}