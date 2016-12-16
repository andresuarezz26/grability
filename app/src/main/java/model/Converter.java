package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import api.models.*;

/**
 * Created by gerardosuarez on 14/12/16.
 */
public class Converter
{
    private List<Entry> entryList;

    public Converter(List<Entry> entryList)
    {
        this.entryList = entryList;
    }

    /**
     * Return the category List from an entry List
     * @return
     */
    public ArrayList <AttributesCategory> getCategories()
    {
        //HashSet to prevent repeated categories
        HashSet<AttributesCategory> listCategory = new HashSet<AttributesCategory>();

        for (int i = 0; i < getEntryList().size(); i++)
        {
            listCategory.add(getEntryList().get(i).getCategory().getAttributes());
        }

        return new ArrayList<>(listCategory);
    }

    //Getter and setters

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }
}
