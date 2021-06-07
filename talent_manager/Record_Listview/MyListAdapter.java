package com.example.talent_manager.Record_Listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.talent_manager.R;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends BaseAdapter {

    private List<Record> list = new ArrayList<>();
    private Context context;
    private FilterListener listener = null;// 接口对象

    public MyListAdapter(List<Record> list, Context context, FilterListener filterListener) {


        this.list = list;
        this.context = context;
        this.listener = filterListener;
    }

    public void change(int position, Record record){
        list.get(position).setName(record.getName());
        list.get(position).setSex(record.getSex());
        list.get(position).setDate(record.getDate());
        list.get(position).setContent(record.getContent());
        list.get(position).setApartment(record.getApartment());
        Log.e("jsjsj", record.getSex());
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub

        Log.e("TAfffffffffffffffG", String.valueOf(list.size()));
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_evaluate_list_cell, null);
            holder = new ViewHolder();
            //holder.imageView = convertView.findViewById(R.id.search_imageView);
            holder.tvName = convertView.findViewById(R.id.eva_name);
            holder.tvSex = convertView.findViewById(R.id.eva_sex);
            holder.tvDate = convertView.findViewById(R.id.eva_date);
            holder.tvApartment = convertView.findViewById(R.id.eva_apartment);
            //holder.dName = convertView.findViewById(R.id.evaluate_name);
            //holder.dSex = convertView.findViewById(R.id.evaluate_sex);
            //holder.dDate = convertView.findViewById(R.id.evaluate_date);
            //holder.dApartment = convertView.findViewById(R.id.evaluate_apartment);

            //tvName.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/SourceHanSansCN-Bold.otf"));
            holder.imageView = convertView.findViewById(R.id.eva_image);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }





        holder = (ViewHolder) convertView.getTag();
        holder.tvName.setText(list.get(position).getName());
        //holder.tvTime.setText(list[1].get(position));
        holder.tvSex.setText(list.get(position).getSex());
        holder.tvDate.setText(list.get(position).getDate());
        holder.tvApartment.setText(list.get(position).getApartment());
        //holder.imageView.setImageURI(Uri.parse(list.get(position).getImage()));
        byte[] in = list.get(position).getBitmap();
        Bitmap bmp = BitmapFactory.decodeByteArray(in, 0, in.length );
        holder.imageView.setImageBitmap(bmp);
        //holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.first));



        Log.e("TAG", "xianshia???????????");
        return convertView;
    }

    class ViewHolder {
        private ImageView imageView;
        //private TextView tvTitle,tvContent,tvNumber;
        private TextView tvName,tvSex,tvDate,tvApartment,tvContent;
        private TextView dName,dSex,dDate,dApartment;
    }

}