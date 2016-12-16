
package api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("attributes")
    @Expose
    private AttributesCategory attributes;

    /**
     * 
     * @return
     *     The attributes
     */
    public AttributesCategory getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(AttributesCategory attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return attributes != null ? attributes.equals(category.attributes) : category.attributes == null;

    }

    @Override
    public int hashCode() {
        return attributes != null ? attributes.hashCode() : 0;
    }
}
