package task.symmetrygroup.Utils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import task.symmetrygroup.Models.GetCategoryModel.GetCategoryModel;
import task.symmetrygroup.Models.GetProductModel.GetProductModel;

public interface DetailerDelegates {

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET(DetailerConstants.BASE_URL + DetailerConstants.GET_ALL_PRODUCTS)
    Call<GetProductModel> getAllProducts(@Query(value = "access_token", encoded = true) String accessToken, @Query(value = "categoryID") int catId);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET(DetailerConstants.BASE_URL + DetailerConstants.GET_ALL_CATEGORIES)
    Call<GetCategoryModel> getAllCategories(@Query(value = "access_token", encoded = true) String accessToken, @Query(value = "language") String language);


}
