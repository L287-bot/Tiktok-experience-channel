# 🎯 抖音“经验”频道仿写项目
> 项目名称：ExperienceChannel  
开发工具：Android Studio  
编程语言：Java  
目标平台：Android  
项目类型：高仿抖音“经验”频道，实现双列瀑布流内容展示与交互功能
>

---

## 一、📋 项目概述
使用 **Android Studio + Java** 实现一个高仿抖音“经验”频道的移动端页面。核心功能包括：

+ 双列瀑布流布局展示经验卡片
+ 卡片包含图文信息与用户信息
+ 支持点赞交互、下拉刷新、上拉加载更多
+ 使用 Mock 数据模拟网络请求
+ 加入性能优化策略（图片缓存、预加载等）

---

## 二、✅ 功能实现
| 功能模块 | 描述 |
| :--- | :--- |
| **双列瀑布流布局** | 使用 `RecyclerView`+`StaggeredGridLayoutManager` 实现两列不规则高度排列 |
| **页面布局动态切换** | 1. `ViewPager2`+`TabLayout`实现页面切换 <br/>2. `Fragment`集中管理，根据不同页面需求动态切换`Fragment`布局 |
| **经验卡片 UI 组件** | 包含封面图、标题、头像、用户名、点赞数等元素 |
| **点赞交互** | 点击点赞图标切换状态（红心/灰心），实时更新点赞数量 |
| **下拉刷新** | 使用 `SwipeRefreshLayout` 刷新最新数据 |
| **上拉加载更多** | 滚动到底部自动加载下一页数据->监听 |
| **Mock 数据管理** | 本地模拟 JSON 数据，支持配置网络图片和文本内容 |
| **图片缓存** | 使用 Glide 实现图片下载与内存/磁盘缓存 |


---

## 三、🛠️ 技术选型
| 技术 | 工具/库 |
| --- | --- |
| 双列瀑布流布局 | `RecyclerView`+`StaggeredGridLayoutManager` |
| 页面布局动态切换 | `ViewPager2`+`TabLayout`+`Fragment` |
| UI 布局 | XML  |
| 图片加载 | [Glide](https://github.com/bumptech/glide) |
| 下拉刷新控件 | `SwipeRefreshLayout` |
| 上拉加载更多 | `RecyclerView`滚动监听 + 底部检测 |
| Mock数据 | 本地写死资源Url，随机加载 |
| 缓存策略 | `RecyclerView`缓存配置<br/>`RecyclerView`预取机制 |


---

## 四、🗂️ 项目结构设计
```plain
app/
├── build/                 # 构建输出目录
│   └── intermediates/    # 中间构建文件
└── src/                  # 源代码目录
    ├── main/             # 主源码目录
    │   ├── java/         # Java源代码
    │   │   └── com/example/experiencechannel/
    │   │       ├── adapter/      # 适配器类
    │   │       ├── constant/     # 常量定义[Fragment Url资源]
    │   │       ├── fragment/     # Fragment组件
    │   │       ├── model/entity/ # 数据实体类
    │   │       ├── service/      # 服务类
    │   │       ├── viewholder/   # ViewHolder类
    │   │       ├── MainActivity.java  # 主页
    │   │       └── SplashActivity.java # 启动页
    │   └── res/          # 资源文件
    │       ├── drawable/   # 图片资源 形状资源
    │       ├── layout/    # 布局文件
    │       ├── values/    # 配置资源
    │       └── xml/       # XML配置
    ├── androidTest/      # Android测试代码
    └── test/            # 单元测试代码

```

---

## 五、🔧 关键代码实现思路
### (一)基本布局静态搭建
#### 1.动画页
![](https://cdn.nlark.com/yuque/0/2025/png/56028206/1764430222774-42171cc3-649d-4fad-9262-fd28f7b016c6.png)

#### 2.主页
![](https://cdn.nlark.com/yuque/0/2025/png/56028206/1764430202973-d50a9208-a4cb-4f6f-96d3-ebc125a91cec.png)

#### 3.经验频道Fragment
![](https://cdn.nlark.com/yuque/0/2025/png/56028206/1764430280586-585f653d-f3b2-4bf7-92f2-8ae00d96f11a.png)

### (二)`ViewPager2`+`TabLayout`+`Fragment`滑动切换标签页
#### 1.使用ViewPager2
```java
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
```

> 找到MainActivity中的viewpager2组件，设置Adapter，实现对应的两个方法。
>

#### 2.使用TabLayout
```java
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
        //为每个标签页设置文本
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, i) -> {
            tab.setText(tabConstant.TAB_LIST[i]);
        }
        );
        tabLayoutMediator.attach();

    }
```

#### 3.Fragment集合
```java
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
```

> 配合ViewPager中的`createFragment()`方法动态创建不同的Fragment应用不同的布局
>

### (三)RecycleView瀑布流布局展示数据
#### 1.数据准备
```java
public class PostVo implements Serializable {
    /**
     * 标题
     */
    private String title;
    /**
     * 点赞数
     */
    private Integer thumbNum;
    /**
     * // 用户头像网络地址
     */
    private String avatarUrl;
    /**
     *  //帖子图片网络地址
     */
    private String postImageUrl;
    /**
     *用户是否点赞
     */
    private boolean isLike;
    /**
     *用户昵称
     */
    private String userNickName;
```

#### 2.PostVoAdapter
> 1. 通过构造函数获取数据列表
> 2. `onCreateViewHolder()`方法中加载对应Fragment的布局，并返回`ViewHolder`，`ViewHolder`中就会对布局中的UI控件进行绑定
> 3.  `onBindViewHolder()`方法中`ViewHolder`对数据绑定到具体的UI控件中
>

#### 3.PostVoViewHolder
> 1. UI控件绑定
> 2. 数据绑定到UI控件中
>

#### 4.经验频道的Fragment中使用RecycleView瀑布流展示数据
```java
//.ObjectFragment
@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recyclerview_id);
        PostVoAdapter postVoAdapter = new PostVoAdapter(initData());
        //2列垂直瀑布流
        StaggeredGridLayoutManager staggeredLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(staggeredLayoutManager);
            mRecyclerView.setAdapter(postVoAdapter);
        }
```

> 1. 找到RecyclerView控件
> 2. 传递数据列表设置Adapter
> 3. 设置布局管理器
>

### (四)RecycleViewItem交互
1. 定义item点击接口

```java
/**
 * item点击接口
 */
public interface ItemOnClickInterface {
    public  void itemOnClick(View view, int position);
}
```

2. 接口声明为成员变量，提供Set方法并在Adapter中的`onBindViewHolder()`中进行监听

```java
//.PostVoAdapter
@Override
    public void onBindViewHolder(@NonNull PostVoViewHolder holder, int position) {
····
        //监听点赞按钮点击
        holder.itemView.setOnClickListener(view-> itemOnClickInterface.itemOnClick(view,position)
        );
    }
```

3. 外层手动设置接口拿到`view` 跟`position`执行对应操作

```java
//.ObjectFragment
PostVoAdapter postVoAdapter = new PostVoAdapter(initData());
       // 设置Item点击事件监听器
        postVoAdapter.setItemOnClickInterface((view1, position) -> {
            view1.findViewById(R.id.user_thumb).setOnClickListener(v -> {
                PostVo updatepostVo = postVoList.get(position);
                updatepostVo.setThumbNum(updatepostVo.isLike() ? updatepostVo.getThumbNum() - 1 : updatepostVo.getThumbNum() + 1);
                updatepostVo.setLike(!updatepostVo.isLike());
                postVoAdapter.updateData(postVoList);
            });
```

> 1. 外层监听item，内层再监听item中的点赞UI控件
> 2. 点击点赞UI控件，修改该位置数据的点赞标志以及点赞数量
> 3. 更数数据重新渲染所有可见的列表项，PostVoViewHolder根据点赞标志位重新设置点赞图片资源
>

### (五)下拉刷新
```java
      swipeRefresh = view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(() -> {
            postVoAdapter.updateData(postVoList);
            System.out.println("刷新");
            swipeRefresh.setRefreshing(false);
        });
```

> 找到刷新控件，进行监听，下拉的时候重新渲染数据
>

### (六)上拉加载更多
```java
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
```

> 对RecyclerView滑动事件监听，通过布局管理器获取每一列可见item的位置，找到其中位置最大的跟总item数进行比较来判断是否达到了底部，达到底部多加载30条数据
>

### (七)Glide加载图片
```kotlin
// 添加 Glide 依赖
implementation("com.github.bumptech.glide:glide:4.11.0")
annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")
```

```java
//数据绑定的时候使用
//.PostVoViewHolder
public void bindData(PostVo postVo){

·····

// 使用 Glide 加载用户头像
Glide.with(itemView.getContext())
.load(postVo.getAvatarUrl())
.placeholder(R.drawable.logo)
.error(R.drawable.logotext)
.circleCrop()
.into(ivAvatar);

// 使用 Glide 加载帖子主图
Glide.with(itemView.getContext())
.load(postVo.getPostImageUrl())
.placeholder(R.drawable.logo)
.error(R.drawable.logotext)
.fitCenter()
.into(postImage);

·····

}
```

> PostVoViewHolder数据绑定的时候使用
>

### (八)缓存策略
`RecyclerView` 默认支持预加载

```java
recyclerView.setItemViewCacheSize(4);
```

 启用 `RecyclerView `的预取（Prefetch）机制

```java
    staggeredLayoutManager.setItemPrefetchEnabled(true);
```

##  六、问题
## 🔧 问题 1：使用`ViewPager2`+`TabLayout`+`Fragment`加载不同的Fragment，但是没做到动态的布局切换
+ **解决**：创建多个Fragment使用不同的布局，并集中管理，ViewPager2根据position创建出不同布局的Fragment

## 🔧 问题 2：RecycleView中Item交互无论点哪里都会触发点赞改变
+ **解决**：监听器外层中监听Item，内层监听Item中的点赞控件

## 🔧 问题 3：上拉加载的时候会有图像的重叠以及会偶尔会有图像掉落下来的抖动，以及卡顿
![](https://cdn.nlark.com/yuque/0/2025/png/56028206/1764239677760-2c4b3d34-0790-4c76-9fb3-e129b427f0f9.png)

+ **解决**：Glide 加载图片，RecycleView 预取设置，RecycleView缓存配置

## 🔧 问题 4：监听点赞控件的点击时间，点击之后连续点击无效，不能丝滑修改点赞状态以及点赞数量
---

## 七、参考资料
<font style="color:rgba(38, 36, 76, 0.88);background-color:rgb(242, 240, 255);"></font>[Android入门教程 | RecyclerView响应子项点击 - 哔哩哔哩](https://www.bilibili.com/opus/590727263573938839?from=search&spm_id_from=333.337.0.0)

[Android Fragment 全解析-CSDN博客](https://blog.csdn.net/weixin_37794278/article/details/149660227)

[RecyclerView的Item点击事件实现总结-CSDN博客](https://blog.csdn.net/u014651216/article/details/53256985?ops_request_misc=%257B%2522request%255Fid%2522%253A%252262c87319eba45fb4004d35ba7a833f14%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=62c87319eba45fb4004d35ba7a833f14&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-53256985-null-null.142^v102^pc_search_result_base8&utm_term=recycleview%E7%9A%84item%E7%82%B9%E5%87%BB%E4%BA%8B%E4%BB%B6&spm=1018.2226.3001.4187)

[Android中RecyclerView的Item点击事件（总结）_recycleview的item点击监听-CSDN博客](https://blog.csdn.net/lpCrazyBoy/article/details/82350338?ops_request_misc=%257B%2522request%255Fid%2522%253A%252262c87319eba45fb4004d35ba7a833f14%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=62c87319eba45fb4004d35ba7a833f14&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-4-82350338-null-null.142^v102^pc_search_result_base8&utm_term=recycleview%E7%9A%84item%E7%82%B9%E5%87%BB%E4%BA%8B%E4%BB%B6&spm=1018.2226.3001.4187)

![](https://cdn.nlark.com/yuque/0/2025/png/56028206/1764326801284-71c00323-620d-4ad2-99f1-8f3e881651d9.png)

[Android下拉刷新实战：SwipeRefreshLayout全解析-CSDN博客](https://blog.csdn.net/Si15166622538/article/details/154262035?ops_request_misc=%257B%2522request%255Fid%2522%253A%252296960a6004bf3fa5c8c0b784058388ba%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=96960a6004bf3fa5c8c0b784058388ba&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-154262035-null-null.142^v102^pc_search_result_base8&utm_term=swiperefreshlayout%E4%B8%8B%E6%8B%89%E5%88%B7%E6%96%B0&spm=1018.2226.3001.4187)

[RecycleView实现上拉加载更多_recyclerview 上拉加载更多-CSDN博客](https://blog.csdn.net/weixin_37730482/article/details/72846693?ops_request_misc=%257B%2522request%255Fid%2522%253A%252205b526ce53a76c3fc8b6e3d94d8b6345%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=05b526ce53a76c3fc8b6e3d94d8b6345&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-72846693-null-null.142^v102^pc_search_result_base8&utm_term=recycleview%E6%95%B0%E6%8D%AE%E5%8A%A0%E8%BD%BD&spm=1018.2226.3001.4187)

[【EasyMock入门】简单使用_easymock使用教程-CSDN博客](https://blog.csdn.net/qq_38225558/article/details/86483310?ops_request_misc=%257B%2522request%255Fid%2522%253A%25226a44d94780d71a4499c4b7d986f8c85f%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=6a44d94780d71a4499c4b7d986f8c85f&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-86483310-null-null.142^v102^pc_search_result_base8&utm_term=easymock%E6%95%99%E5%AD%A6&spm=1018.2226.3001.4187)

[https://muyangmin.github.io/glide-docs-cn/doc/getting-started.html#%E5%9F%BA%E6%9C%AC%E7%94%A8%E6%B3%95](https://muyangmin.github.io/glide-docs-cn/doc/getting-started.html#%E5%9F%BA%E6%9C%AC%E7%94%A8%E6%B3%95)

<font style="color:rgba(38, 36, 76, 0.88);">StaggeredGridLayoutManager 的 </font>**<font style="color:rgba(38, 36, 76, 0.88);">预取机制（</font>**Prefetch**<font style="color:rgba(38, 36, 76, 0.88);">）</font>**<font style="color:rgba(38, 36, 76, 0.88);"> —— 提前为即将滑入屏幕的 item 做测量和绑定。</font>

<font style="color:rgba(38, 36, 76, 0.88);"></font>`<font style="color:rgba(38, 36, 76, 0.88);background-color:rgba(205, 208, 220, 0.1);">mRecyclerView.setItemViewCacheSize(4);</font>`

<font style="color:rgba(38, 36, 76, 0.88);">设置 RecyclerView 缓存多少个已经移出屏幕的 </font>`<font style="color:rgba(38, 36, 76, 0.88);background-color:rgba(205, 208, 220, 0.1);">ViewHolder</font>`<font style="color:rgba(38, 36, 76, 0.88);"></font>

<font style="color:rgba(38, 36, 76, 0.88);"></font>

