package com.example.experiencechannel.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.experiencechannel.R;
import com.example.experiencechannel.adapter.PostVoAdapter;
import com.example.experiencechannel.adapter.UserAdapter;
import com.example.experiencechannel.constant.resourceConstant;
import com.example.experiencechannel.model.entity.PostVo;
import com.example.experiencechannel.model.entity.User;
import com.example.experiencechannel.service.ItemOnClickInterface;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;

// Instances of this class are fragments representing a single
// object in the collection.
public class ObjectFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<PostVo> postVoList;
    private SwipeRefreshLayout swipeRefresh;

//private List<PostVo> initData() {
//    postVoList = new ArrayList<>();
//    postVoList.add(new PostVo(R.drawable.chao,R.drawable.handsome,31,"深大脱单","我很忙",false));
//    postVoList.add(new PostVo(R.drawable.avatar3,R.drawable.handsome2,367,"一点日常","tango",true));
//    postVoList.add(new PostVo(R.drawable.avatar1,R.drawable.handsome3,2251,"我会一直接","怪物人",true));
//    postVoList.add(new PostVo(R.drawable.avatar2,R.drawable.handsome4,121,"希望你的眼睛一直笑","四季静",false));
//    postVoList.add(new PostVo(R.drawable.avatar3,R.drawable.curry,168,"这是小猪","Whoae",false));
//    postVoList.add(new PostVo(R.drawable.avatar4,R.drawable.kun,3219,"这还是小猪","小皇帝",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.fengjing,321,"这是标题1","这是用户7",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.message,3216,"这是标题1","这是用户8",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.profile,3215,"这是标题1","这是用户9",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.search,3213,"这是标题1","这是用户10",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,3211,"这是标题1","这是用户11",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,3212,"这是标题1","这是用户12",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,3214,"这是标题1","这是用户13",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,3213,"这是标题1","这是用户14",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,3212,"这是标题1","这是用户15",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,321,"这是标题1","这是用户16",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,321,"这是标题1","这是用户17",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,321,"这是标题1","这是用户18",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,321,"这是标题1","这是用户19",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,321,"这是标题1","这是用户20",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,321,"这是标题1","这是用户1",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,321,"这是标题1","这是用户1",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,321,"这是标题1","这是用户1",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,321,"这是标题1","这是用户1",false));
//    postVoList.add(new PostVo(R.drawable.logo,R.drawable.logo,321,"这是标题1","这是用户1",false));
//return postVoList;
//}

    public static ObjectFragment createFragment() {
        ObjectFragment fragment = new ObjectFragment();
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

    // - 查找并初始化视图组件
    // - 设置点击事件监听器
    // - 执行初始数据展示
    // - 启动网络请求或数据库查询
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recyclerview_id);
        //缓存多少个已经移出屏幕的 ViewHolder
        mRecyclerView.setItemViewCacheSize(4);
        PostVoAdapter postVoAdapter = new PostVoAdapter(initData());
       // 设置Item点击事件监听器
        postVoAdapter.setItemOnClickInterface((view1, position) -> {
            view1.findViewById(R.id.user_thumb).setOnClickListener(v -> {
                PostVo updatepostVo = postVoList.get(position);
                updatepostVo.setThumbNum(updatepostVo.isLike() ? updatepostVo.getThumbNum() - 1 : updatepostVo.getThumbNum() + 1);
                updatepostVo.setLike(!updatepostVo.isLike());
                postVoAdapter.updateData(postVoList);
            });

        });
        //设置下拉刷新监听
        //监听更新后的数据
        swipeRefresh = view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(() -> {
            postVoAdapter.updateData(postVoList);
            System.out.println("刷新");
            swipeRefresh.setRefreshing(false);
        });
        //2列垂直瀑布流
        StaggeredGridLayoutManager staggeredLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //StaggeredGridLayoutManager 预取机制（Prefetch） —— 提前为即将滑入屏幕的 item 做测量和绑定。
        staggeredLayoutManager.setItemPrefetchEnabled(true);
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(staggeredLayoutManager);
            mRecyclerView.setAdapter(postVoAdapter);
            //上拉刷新监听
            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    //多少列
                    int spanCount = staggeredLayoutManager.getSpanCount();
                    int[] lastVisibleItemPositions = staggeredLayoutManager.findLastVisibleItemPositions(new int[spanCount]);
                    //每一列最后一个可见 Item 的最大的位置
                        int asInt = Arrays.stream(lastVisibleItemPositions).max().orElse(-1);
                    if (dy > 0&&asInt >= postVoAdapter.getItemCount() - 1) {
                        // 显示加载提示
                        Toast.makeText(getContext(), "加载中...", Toast.LENGTH_SHORT).show();
                        //上拉加载更多
                        loadMoreData();
                        postVoAdapter.updateData(postVoList);
                    }

                }
            });
        }

    }

    /**
     * 初始化30条数据
     *
     */
    private List<PostVo> initData() {
        postVoList = new ArrayList<>();
        Random random = new Random();
        // 随机的用户昵称池
        String[] nicknames = {
                "小明", "小红", "阿杰", "Lisa", "Tom", "考研人", "深大摄影社",
                "爱吃螺蛳粉", "深夜码农", "大三不摆烂", "深大表白墙", "搬砖中"
        };

// 随机的帖子内容池（校园生活风格）
        String[] contents = {
                "今天食堂新开了家麻辣烫，巨好吃！",
                "图书馆靠窗位置真的抢手...",
                "求问：微积分谁有笔记可以借一下？",
                "天气太好了，去荔园散步晒太阳～",
                "实验报告写到凌晨两点，我还能抢救一下",
                "在文山湖边看到一对天鹅！有人知道是野生的吗？",
                "共享单车又被堆成山了，绕了十分钟才出校门",
                "深大周边新开了一家猫咖，吸猫治愈一天疲惫",
                "体测要来了，现在开始突击跑步还来得及吗",
                "听说最近教务系统要更新，选课会变容易吗？",
                "下雨天教学楼漏水，带伞的同学帮忙撑个伞吧",
                "有没有一起准备四六级的？组个学习搭子！"
        };
// 开始添加数据
        for (int i = 0; i < 30; i++) {
            String imageUrl = resourceConstant.imageResUrls[i % resourceConstant.imageResUrls.length];
            String avatarUrl = resourceConstant.avatarResUrls[i % resourceConstant.avatarResUrls.length];

            boolean isLike = random.nextBoolean(); // ✅ 随机 true/false

            String nickname = nicknames[random.nextInt(nicknames.length)]; // 随机昵称
            String content = contents[random.nextInt(contents.length)];   // 随机内容

            int thumbNum = random.nextInt(350) + 1; // 点赞数 1~3500（也可以保留原来的）

            postVoList.add(new PostVo(
                    imageUrl,
                    isLike,
                    avatarUrl,
                    thumbNum,
                    nickname,
                    content
            ));
        }
        return postVoList;

    }

    /**
     * 新增30条数据
     */
    private void loadMoreData() {
        // 模拟加载更多数据（这里简单地复制现有数据）
        int currentSize = postVoList.size();
        Random random = new Random();

        String[] nicknames = {
                "小明", "小红", "阿杰", "Lisa", "Tom", "考研人", "深大摄影社",
                "爱吃螺蛳粉", "深夜码农", "大三不摆烂", "深大表白墙", "搬砖中"
        };

        String[] contents = {
                "今天食堂新开了家麻辣烫，巨好吃！",
                "图书馆靠窗位置真的抢手...",
                "求问：微积分谁有笔记可以借一下？",
                "天气太好了，去荔园散步晒太阳～",
                "实验报告写到凌晨两点，我还能抢救一下",
                "在文山湖边看到一对天鹅！有人知道是野生的吗？",
                "共享单车又被堆成山了，绕了十分钟才出校门",
                "深大周边新开了一家猫咖，吸猫治愈一天疲惫",
                "体测要来了，现在开始突击跑步还来得及吗",
                "听说最近教务系统要更新，选课会变容易吗？",
                "下雨天教学楼漏水，带伞的同学帮忙撑个伞吧",
                "有没有一起准备四六级的？组个学习搭子！"
        };

        // 添加10条新数据
        for (int i = 0; i < 30; i++) {
            String imageUrl = resourceConstant.imageResUrls[(currentSize + i) % resourceConstant.imageResUrls.length];
            String avatarUrl = resourceConstant.avatarResUrls[(currentSize + i) % resourceConstant.avatarResUrls.length];

            boolean isLike = random.nextBoolean();
            String nickname = nicknames[random.nextInt(nicknames.length)];
            String content = contents[random.nextInt(contents.length)];
            int thumbNum = random.nextInt(350) + 1;

            postVoList.add(new PostVo(
                    imageUrl,
                    isLike,
                    avatarUrl,
                    thumbNum,
                    nickname,
                    content
            ));
        }
    }
}