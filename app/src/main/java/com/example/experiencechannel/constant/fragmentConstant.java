package com.example.experiencechannel.constant;

import androidx.fragment.app.Fragment;

import com.example.experiencechannel.fragment.CityFragment;
import com.example.experiencechannel.fragment.FollowFragment;
import com.example.experiencechannel.fragment.GoodSelectedFragment;
import com.example.experiencechannel.fragment.GroupbuyFragment;
import com.example.experiencechannel.fragment.HotkeyFragment;
import com.example.experiencechannel.fragment.LiveFragment;
import com.example.experiencechannel.fragment.ObjectFragment;
import com.example.experiencechannel.fragment.RecommendFragment;

public interface fragmentConstant {
    /**
     * Fragment集合
     */
     Fragment[] FRAGMENT_LIST = {ObjectFragment.createFragment(),
            HotkeyFragment.createFragment(),
            GroupbuyFragment.createFragment(),
            LiveFragment.createFragment(),
            CityFragment.createFragment(),
            FollowFragment.createFragment(),
            GoodSelectedFragment.createFragment(),
            RecommendFragment.createFragment(),
            HotkeyFragment.createFragment()};

}
