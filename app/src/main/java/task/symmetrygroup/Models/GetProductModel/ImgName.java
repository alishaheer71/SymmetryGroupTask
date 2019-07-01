
package task.symmetrygroup.Models.GetProductModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImgName {

    @SerializedName("fileID")
    @Expose
    private String fileID;
    @SerializedName("img_name")
    @Expose
    private String imgName;

    public String getFileID() {
        return fileID;
    }

    public void setFileID(String fileID) {
        this.fileID = fileID;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

}
