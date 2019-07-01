package task.symmetrygroup;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import task.symmetrygroup.Adapter.AdapterCategory;
import task.symmetrygroup.Adapter.AdapterProducts;
import task.symmetrygroup.Models.GetCategoryModel.GetCategoryModel;
import task.symmetrygroup.Models.GetProductModel.Datum;
import task.symmetrygroup.Models.GetProductModel.GetProductModel;
import task.symmetrygroup.Utils.DetailerDelegates;
import task.symmetrygroup.Utils.GridSpacingItemDecoration;
import task.symmetrygroup.Utils.RetrofitClientInstance;

public class MainActivity extends AppCompatActivity {

    private String authToken = "ca673712338e7b964e5267a261f8abdc";
    private RecyclerView mRecyclerViewCategories, mRecyclerViewProducts;
    private AdapterProducts mAdapterProducts;
    private AdapterCategory mAdapterCategory;
    List<task.symmetrygroup.Models.GetCategoryModel.Datum> mListCategory;
    List<Datum> mListProducts;
    KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hud = KProgressHUD.create(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setCancellable(false);
        initViews();
        getAllCategories();


//        mRecyclerViewCategories.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL , false));
//        mAdapterCategory = new AdapterCategory(mListCategory, MainActivity.this);
//        mRecyclerViewCategories.setAdapter(mAdapterCategory);


//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2) {
//            @Override
//            public boolean canScrollVertically() {
//                return true;
//            }
//        };
//
//        mRecyclerViewProducts.setLayoutManager(mLayoutManager);
//        mRecyclerViewProducts.addItemDecoration(new GridSpacingItemDecoration(2, 10, true));
//        mRecyclerViewProducts.setItemAnimator(new DefaultItemAnimator());
//
//        mAdapterProducts = new AdapterProducts(mListProducts, MainActivity.this);
//        mRecyclerViewProducts.setAdapter(mAdapterProducts);

    }

    private void initViews() {
        mRecyclerViewCategories = findViewById(R.id.rv_categories);
        mRecyclerViewProducts = findViewById(R.id.rv_products);
        mRecyclerViewCategories.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false));
        mAdapterCategory = new AdapterCategory(new ArrayList<task.symmetrygroup.Models.GetCategoryModel.Datum>(), MainActivity.this, new AdapterCategory.OnItemClickListener() {
            @Override
            public void onItemClicked(String categoryId) {
                getAllProducts(categoryId);
            }
        });
        mRecyclerViewCategories.setAdapter(mAdapterCategory);


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(MainActivity.this, 2) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        mRecyclerViewProducts.setLayoutManager(mLayoutManager);
        mRecyclerViewProducts.addItemDecoration(new GridSpacingItemDecoration(2, 10, true));
        mRecyclerViewProducts.setItemAnimator(new DefaultItemAnimator());

        mAdapterProducts = new AdapterProducts(new ArrayList<Datum>(), MainActivity.this);
        mRecyclerViewProducts.setAdapter(mAdapterProducts);

    }

    private void getAllCategories() {
        hud.show();
        DetailerDelegates api = RetrofitClientInstance.getRetrofitInstance().create(DetailerDelegates.class);

        Call<GetCategoryModel> call = api.getAllCategories("ca673712338e7b964e5267a261f8abdc", "en");

        call.enqueue(new Callback<GetCategoryModel>() {
            @Override
            public void onResponse(Call<GetCategoryModel> call, Response<GetCategoryModel> response) {
                if (response.body().getStatus().equalsIgnoreCase("Success")) {

                    mListCategory = response.body().getData();
                    mAdapterCategory.setmCategoryList(mListCategory);


                    SharedPreferences s = getSharedPreferences("main", MODE_PRIVATE);
                    SharedPreferences.Editor editor = s.edit();
                    editor.putString("categorydata", mListCategory.toString());
                    Log.e("onResponse", "onResponse: " + mListCategory.toString());

                }

                Log.e("onResponse", "onResponse: " + response.body().getData());
                getAllProducts(mListCategory.get(0).getCategoryID());
            }

            @Override
            public void onFailure(Call<GetCategoryModel> call, Throwable t) {
                hud.dismiss();
                Log.e("onResponse", "onResponse: Failure");
            }
        });
    }

    private void getAllProducts(String categoryId) {
        hud.show();
        DetailerDelegates api = RetrofitClientInstance.getRetrofitInstance().create(DetailerDelegates.class);

        Call<GetProductModel> call = api.getAllProducts("ca673712338e7b964e5267a261f8abdc", Integer.valueOf(categoryId));

        call.enqueue(new Callback<GetProductModel>() {
            @Override
            public void onResponse(Call<GetProductModel> call, Response<GetProductModel> response) {
                hud.dismiss();
                if (response.body() == null) {
                    Toast.makeText(MainActivity.this, "No Product Available", Toast.LENGTH_SHORT).show();
                    return;
                }
                mListProducts = response.body().getData();
                mAdapterProducts.setmProducts(mListProducts);


                SharedPreferences s = getSharedPreferences("main", MODE_PRIVATE);
                SharedPreferences.Editor editor = s.edit();
                editor.putString("productdata", mListProducts.toString());
                Log.e("onResponse", "onResponse: " + mListProducts.toString());
            }

            @Override
            public void onFailure(Call<GetProductModel> call, Throwable t) {
                Log.e("onResponse", "onResponse: Failure");
            }
        });
    }
}
