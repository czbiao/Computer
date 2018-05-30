package com.biao.computer.health.videolist.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.biao.computer.R;
import com.biao.computer.health.videolist.VideoItemData;

/**
 * Author  wangchenchen
 * Description video列表adapter
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<VideoItemData> list;
    public VideoAdapter(Context context){
        list=new ArrayList<>();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        VideoViewHolder holder = new VideoViewHolder(view);
        view.setTag(holder);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.update(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refresh(List<VideoItemData> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        private FrameLayout videoLayout;
        private int position;
        private RelativeLayout showView;
        private TextView title,from;
        private ImageView image_bg;
        private Bitmap bitmap;


        public VideoViewHolder(View itemView) {
            super(itemView);
            videoLayout = (FrameLayout) itemView.findViewById(R.id.layout_video);
            showView= (RelativeLayout) itemView.findViewById(R.id.showview);
            title= (TextView) itemView.findViewById(R.id.title);
            from= (TextView) itemView.findViewById(R.id.from);
            image_bg = (ImageView) itemView.findViewById(R.id.image_bg);
        }

        public void update(final int position) {
            this.position = position;
            title.setText(list.get(position).getTitle());
            from.setText(list.get(position).getVideosource());

            Runnable networkImg = new Runnable() {
                @Override
                public void run() {
                    try {
                        URL conn = new URL(list.get(position).getCover());
                        InputStream in = conn.openConnection().getInputStream();
                        bitmap = BitmapFactory.decodeStream(in);
                        in.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(networkImg).start();

            image_bg.setImageBitmap(bitmap);
            showView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showView.setVisibility(View.GONE);
                    if (click != null)
                        click.onclick(position);
                }
            });
        }
    }

    private onClick click;

    public void setClick(onClick click){
        this.click=click;
    }

    public static interface onClick{
        void onclick(int position);
    }

}
