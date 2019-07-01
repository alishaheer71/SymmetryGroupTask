package task.symmetrygroup.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import task.symmetrygroup.Models.GetCategoryModel.Datum;
import task.symmetrygroup.R;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.ViewHolder> {

    public void setmCategoryList(List<Datum> mCategoryList) {
        this.mCategoryList = mCategoryList;
        notifyDataSetChanged();
    }

    List<Datum> mCategoryList;
    LayoutInflater inflater;
    Context context;
    OnItemClickListener itemClickListener;

    public AdapterCategory(List<Datum> mCategoryList, Context context, OnItemClickListener itemClickListener) {
        this.mCategoryList = mCategoryList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterCategory.ViewHolder(inflater.inflate(R.layout.adapter_categories, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.mTvCategoryName.setText(mCategoryList.get(position).getCategoryName() + "");
        holder.mTvCategoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClicked(mCategoryList.get(position).getCategoryID());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvCategoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvCategoryName = itemView.findViewById(R.id.text_category);

        }
    }

    public interface OnItemClickListener {
        void onItemClicked(String categoryId);
    }

}
