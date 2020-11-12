package com.khoofiya.realnews.home.views.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.khoofiya.realnews.R
import com.khoofiya.realnews.home.views.fragments.AllNewsTabFragment
import com.khoofiya.realnews.home.views.fragments.SourcesTabFragment

private val TAB_TITLES = arrayOf(
    R.string.sources_header,
    R.string.all_news_header
)

class HomeTabsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            SourcesTabFragment()
        } else {
            AllNewsTabFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}