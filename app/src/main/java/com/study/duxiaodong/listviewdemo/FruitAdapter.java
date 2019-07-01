package com.study.duxiaodong.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;

/**
 * author : gavin_du
 * email : 1033784386@qq.com
 * date : 2019/7/1 16:54
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {

    private Context context;

    private int resourceId;

    private List<Fruit> fruits;

    public FruitAdapter(@NonNull @android.support.annotation.NonNull Context context, int resource, @NonNull @android.support.annotation.NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }


    @androidx.annotation.NonNull
    @android.support.annotation.NonNull
    @Override
    public View getView(int position, @androidx.annotation.Nullable @android.support.annotation.Nullable View convertView, @androidx.annotation.NonNull @android.support.annotation.NonNull ViewGroup parent) {
        Fruit fruit = getItem(position); // 获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById (R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById (R.id.fruit_name);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHolder{
        ImageView fruitImage;

        TextView fruitName;
    }
}
