package com.example.experiencechannel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.experiencechannel.R;
import com.example.experiencechannel.model.entity.PostVo;
import com.example.experiencechannel.model.entity.User;
import com.example.experiencechannel.service.ItemOnClickInterface;
import com.example.experiencechannel.viewholder.PostVoViewHolder;
import com.example.experiencechannel.viewholder.UserViewHolder;

import java.util.List;


public class PostVoAdapter extends RecyclerView.Adapter<PostVoViewHolder> {

    private List<PostVo> postVoList;


    private ItemOnClickInterface itemOnClickInterface;
public void setItemOnClickInterface(ItemOnClickInterface itemOnClickInterface) {
        this.itemOnClickInterface = itemOnClickInterface;
    }

    // 构造方法：接收数据集
    public PostVoAdapter(List<PostVo> postVoList) {
        this.postVoList = postVoList;
    }
    /**
     * 加载Item布局，创建ViewHolder绑定视图
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public PostVoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        //创建返回的ViewHolder
        return new PostVoViewHolder(itemRootView);
    }

    /**PostVoViewHolder已经绑定了item视图
     * item数据绑定
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull PostVoViewHolder holder, int position) {
        // 获取数据
        PostVo postVo = postVoList.get(position);
        //数据绑定到item视图上
        holder.bindData(postVo);
        //监听点赞按钮点击
        holder.itemView.setOnClickListener(view-> itemOnClickInterface.itemOnClick(view,position)
        );
    }

    @Override
    public int getItemCount() {
        return postVoList!=null?postVoList.size():0;
    }
    // 数据更新（后续刷新列表用）
    public void updateData(List<PostVo> newPostVoList) {
        this.postVoList = newPostVoList;
        // 通知RecyclerView数据已变更
        //重新渲染所有可见的列表项
        notifyDataSetChanged();
    }

}
