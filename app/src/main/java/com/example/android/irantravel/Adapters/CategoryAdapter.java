package com.example.android.irantravel.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.irantravel.Classes.Category;
import com.example.android.irantravel.R;

import java.util.List;

/**
 * Created by meno on 11/22/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    DataSelectListener listener;
    List<Category> categories_list;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
        public ViewHolder(View itemView){
            super(itemView);
            tv1 = (TextView)itemView.findViewById(R.id.a_category_view);
            tv2 = (TextView)itemView.findViewById(R.id.f_category_view);
            tv3 = (TextView)itemView.findViewById(R.id.p_category_view);
        }
    }

    public CategoryAdapter(List<Category> list, DataSelectListener listener){
        this.categories_list = list;
        this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, final int position) {
        final Category category = categories_list.get(position);
        holder.tv1.setText(category.getA_Category());
        holder.tv2.setText(category.getF_Category());
        holder.tv3.setText(category.getP_Category());
        final String token = category.getA_Category();
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.selectData(category,token);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories_list.size();
    }

    public interface DataSelectListener{
        void selectData(Category model,String token);

    }

}
