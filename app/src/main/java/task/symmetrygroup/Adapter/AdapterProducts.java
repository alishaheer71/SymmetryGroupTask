package task.symmetrygroup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import task.symmetrygroup.Models.GetProductModel.Datum;
import task.symmetrygroup.R;


public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ViewHolder> {

    public void setmProducts(List<Datum> mProducts) {
        this.mProducts = mProducts;
        notifyDataSetChanged();
    }

    List<Datum> mProducts;
    LayoutInflater inflater;
    Context context;

    public AdapterProducts(List<Datum> mProducts, Context context) {
        this.mProducts = mProducts;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterProducts.ViewHolder(inflater.inflate(R.layout.adapter_products, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.with(context).load(mProducts.get(position).getProductImage()).resize(150 , 150).into(holder.mIvProduct);


        holder.mTvProductName.setText(mProducts.get(position).getProductName());
        holder.mTvCustName.setText(mProducts.get(position).getProductOwner());
        holder.mTvProductPrice.setText(mProducts.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvProduct;
        private TextView mTvProductName;
        private TextView mTvCustName;
        private TextView mTvProductPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIvProduct = itemView.findViewById(R.id.iv_dp_product);
            mTvProductName = itemView.findViewById(R.id.tv_product_name);
            mTvCustName = itemView.findViewById(R.id.tv_name);
            mTvProductPrice = itemView.findViewById(R.id.tv_product_price);
        }
    }
}
