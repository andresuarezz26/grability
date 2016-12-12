
package api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("attributes")
    @Expose
    private Attributes______ attributes;

    /**
     * 
     * @return
     *     The attributes
     */
    public Attributes______ getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(Attributes______ attributes) {
        this.attributes = attributes;
    }

}
