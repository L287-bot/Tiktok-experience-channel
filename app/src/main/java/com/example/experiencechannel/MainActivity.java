package com.example.experiencechannel;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.experiencechannel.adapter.PostVoAdapter;
import com.example.experiencechannel.adapter.UserAdapter;
import com.example.experiencechannel.constant.fragmentConstant;
import com.example.experiencechannel.model.entity.User;
import com.example.experiencechannel.constant.tabConstant;
import com.example.experiencechannel.fragment.ObjectFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //处理系统窗口边距（insets）的适配，确保内容不会被系统UI元素（如状态栏、导航栏）遮挡。
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViewPager();
        initTabLayout();

    }
    private void initViewPager() {
        //滑动组件
        viewPager = findViewById(R.id.pager);


        //参照官网写法
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragmentConstant.FRAGMENT_LIST[position];
            }

            @Override
            public int getItemCount() {
                return tabConstant.TAB_LIST.length;
            }
        });
    }

    private void initTabLayout() {
        //1.初始化组件
        //标签栏
        tabLayout = findViewById(R.id.tab_layout);
        //tab_layout点击事件
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //设置viewPager选中当前页
                viewPager.setCurrentItem(tab.getPosition(), false);

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //viewPager和tab_layout关联在一起
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, i) -> {
            tab.setText(tabConstant.TAB_LIST[i]);
        }
        );
        tabLayoutMediator.attach();

    }
}