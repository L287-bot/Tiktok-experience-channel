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
import androidx.viewpager2.widget.ViewPager2;

import com.example.experiencechannel.R;
import com.example.experiencechannel.adapter.VideoVoAdapter;
import com.example.experiencechannel.model.entity.VideoVo;

import java.util.ArrayList;
import java.util.List;

// Instances of this class are fragments representing a single
// object in the collection.
public class HotkeyFragment extends Fragment {
    private ViewPager2 viewPager2;
    private List<VideoVo> mVideoVoList;

    public  static HotkeyFragment createFragment(){
        HotkeyFragment fragment = new HotkeyFragment();

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
        View view = inflater.inflate(R.layout.hotkey, container, false);
        return view;
    }

    // 在此阶段应该执行：
    // - 查找并初始化视图组件
    // - 设置点击事件监听器
    // - 执行初始数据展示
    // - 启动网络请求或数据库查询
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mVideoVoList = new ArrayList<>();
        mVideoVoList.add(new VideoVo(R.drawable.avatar1, 125, "今天天气真不错，出去走走", 45, 89, "旅行者小王", R.drawable.handsome, 23));
        mVideoVoList.add(new VideoVo(R.drawable.avatar2, 256, "美食制作教程分享", 78, 156, "美食达人", R.drawable.handsome2, 67));
        mVideoVoList.add(new VideoVo(R.drawable.avatar3, 89, "健身日常打卡", 34, 67, "健身教练", R.drawable.handsome3, 12));
        mVideoVoList.add(new VideoVo(R.drawable.avatar4, 345, "山水风景欣赏", 123, 234, "摄影师", R.drawable.handsome4, 89));
        mVideoVoList.add(new VideoVo(R.drawable.chao, 123,  "宠物日常记录", 23, 45, "宠物爱好者", R.drawable.tang, 15));
        mVideoVoList.add(new VideoVo(R.drawable.tang, 178, "科技产品评测", 56, 134, "数码博主", R.drawable.avatar2, 45));
        mVideoVoList.add(new VideoVo(R.drawable.handsome, 98, "家居装饰灵感", 39, 76, "室内设计师", R.drawable.avatar3, 28));
        mVideoVoList.add(new VideoVo(R.drawable.handsome2, 234, "音乐创作分享", 87, 167, "音乐人", R.drawable.avatar4, 56));
        mVideoVoList.add(new VideoVo(R.drawable.logotext, 56, "读书笔记分享", 18, 39, "书虫", R.drawable.logotext, 9));
        mVideoVoList.add(new VideoVo(R.drawable.friend, 145, "游戏精彩瞬间", 67, 112, "游戏主播", R.drawable.friend, 34));
        mVideoVoList.add(new VideoVo(R.drawable.fengjing, 78, "手工制作教程", 29, 58, "手工艺人", R.drawable.fengjing, 17));
        mVideoVoList.add(new VideoVo(R.drawable.profile, 201, "美妆技巧分享", 92, 156, "美妆博主", R.drawable.profile, 67));
        mVideoVoList.add(new VideoVo(R.drawable.publish, 112, "汽车试驾体验", 45, 89, "汽车评测师", R.drawable.publish, 31));
        mVideoVoList.add(new VideoVo(R.drawable.hometext, 67, "育儿经验分享", 26, 48, "宝妈日记", R.drawable.hometext, 14));
        mVideoVoList.add(new VideoVo(R.drawable.logo, 189, "编程学习心得", 73, 134, "程序员", R.drawable.logo, 42));
        mVideoVoList.add(new VideoVo(R.drawable.logotext, 95, "舞蹈教学视频", 38, 72, "舞蹈老师", R.drawable.logotext, 25));
        mVideoVoList.add(new VideoVo(R.drawable.friend, 167, "篮球技巧训练", 59, 123, "体育爱好者", R.drawable.friend, 38));
        mVideoVoList.add(new VideoVo(R.drawable.fengjing, 223, "海边度假vlog", 84, 156, "旅游博主", R.drawable.fengjing, 67));
        mVideoVoList.add(new VideoVo(R.drawable.profile, 78, "烘焙甜品制作", 31, 59, "烘焙师", R.drawable.profile, 19));
        mVideoVoList.add(new VideoVo(R.drawable.publish, 134, "摄影技巧分享", 47, 98, "摄影爱好者", R.drawable.publish, 29));

        // 在 onViewCreated 方法中替换 RecyclerView 为 ViewPager2
       viewPager2 = view.findViewById(R.id.viewpager2_id);
        VideoVoAdapter adapter = new VideoVoAdapter(mVideoVoList);
        viewPager2.setAdapter(adapter);//创建一个Fragment数据绑定
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL); // 设置垂直滑动
        }


}