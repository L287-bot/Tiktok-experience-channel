package com.example.experiencechannel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.experiencechannel.R;
import com.example.experiencechannel.adapter.UserAdapter;
import com.example.experiencechannel.model.entity.User;

import java.util.ArrayList;
import java.util.List;

// Instances of this class are fragments representing a single
// object in the collection.
public class CityFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<User> mUserList;

    public  static CityFragment createFragment(){
        CityFragment fragment = new CityFragment();

        return fragment;
    }
    // 在此阶段可以执行：
    // - 初始化非视图相关的变量
    // - 处理传入的参数
    // - 准备数据加载器
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    // 在此阶段应该执行：
    // - 加载并返回 Fragment 的 UI 布局
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 加载 Fragment 的布局
        View view = inflater.inflate(R.layout.demo, container, false);
        return view;
    }

    // 在此阶段应该执行：
    // - 查找并初始化视图组件
    // - 设置点击事件监听器
    // - 执行初始数据展示
    // - 启动网络请求或数据库查询
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mUserList = new ArrayList<>();
        mUserList.add(new User(R.drawable.logo, "张三", "张三", "123456"));
        mUserList.add(new User(R.drawable.logotext, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.friend, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.fengjing, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.profile, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.publish, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.hometext, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mUserList.add(new User(R.drawable.logo, "wagasd", "asdwe", "123456"));
        mRecyclerView =view.findViewById(R.id.recyclerview_id);
        //数据适配器
        UserAdapter userAdapter = new UserAdapter(mUserList);
        //2列垂直瀑布流
        StaggeredGridLayoutManager staggeredLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredLayoutManager);
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(staggeredLayoutManager);
            mRecyclerView.setAdapter(userAdapter);
        }
    }
}