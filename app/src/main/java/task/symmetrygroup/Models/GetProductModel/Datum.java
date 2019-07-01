
package task.symmetrygroup.Models.GetProductModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("productID")
    @Expose
    private String productID;
    @SerializedName("categoryID")
    @Expose
    private String categoryID;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("accountID")
    @Expose
    private String accountID;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("product_owner")
    @Expose
    private String productOwner;
    @SerializedName("product_owner_wallet")
    @Expose
    private String productOwnerWallet;
    @SerializedName("is_favorite")
    @Expose
    private Integer isFavorite;
    @SerializedName("product_image")
    @Expose
    private String productImage;
    @SerializedName("img_names")
    @Expose
    private List<ImgName> imgNames = null;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

    public String getProductOwnerWallet() {
        return productOwnerWallet;
    }

    public void setProductOwnerWallet(String productOwnerWallet) {
        this.productOwnerWallet = productOwnerWallet;
    }

    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public List<ImgName> getImgNames() {
        return imgNames;
    }

    public void setImgNames(List<ImgName> imgNames) {
        this.imgNames = imgNames;
    }

}
