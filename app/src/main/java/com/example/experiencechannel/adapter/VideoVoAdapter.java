package com.example.experiencechannel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.experiencechannel.R;
import com.example.experiencechannel.model.entity.VideoVo;
import com.example.experiencechannel.viewholder.VideoVoViewHolder;

import java.util.List;

public class VideoVoAdapter extends RecyclerView.Adapter<VideoVoViewHolder> {

    private List<VideoVo> videoVoList;

    // 构造方法：接收数据集
    public VideoVoAdapter(List<VideoVo> videoVoList) {
        this.videoVoList = videoVoList;
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
    public VideoVoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vedio, parent, false);
        //创建返回的ViewHolder
        return new VideoVoViewHolder(itemRootView);
    }

    /**VideoVoViewHolder已经绑定了item视图
     * item数据绑定
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull VideoVoViewHolder holder, int position) {
        // 获取数据
        VideoVo VideoVo = videoVoList.get(position);
        //数据绑定到item视图上
        holder.bindData(VideoVo);
    }

    @Override
    public int getItemCount() {
        return videoVoList!=null?videoVoList.size():0;
    }

    // 数据更新（后续刷新列表用）
    public void updateData(List<VideoVo> newvideoVoList) {
        this.videoVoList = newvideoVoList;
        // 通知RecyclerView数据已变更
        notifyDataSetChanged();
    }
}
