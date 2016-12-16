package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grability.gerardosuarez.grability.R;

import java.util.ArrayList;

import api.models.AttributesCategory;
import api.models.Category;
import api.models.Entry;

/**
 * Created by gerardosuarez
 * Adapter to manage the App Category List
 */
public class ActivityMainAdapter extends RecyclerView.Adapter <ActivityMainAdapter.ViewHolder>
{
    private ArrayList<AttributesCategory> categoryList;

    public ActivityMainAdapter(ArrayList <AttributesCategory> categoryList)
    {
        this.categoryList = categoryList;
    }

    @Override
    public ActivityMainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        //Relacionar los elementos graficos del cardview con la clase itemView
        View itemView = LayoutInflater.from( parent.getContext( ) )
                .inflate( R.layout.category_item, parent, false );
        //Asignar el view que tiene los cardview a nuestra clase ViewHolder
        ViewHolder viewHolder = new ViewHolder( itemView );
        //retornar nuestro viewHolder
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ActivityMainAdapter.ViewHolder holder, int position)
    {
        holder.textCategory.setText( categoryList.get(position).getLabel() );

    }

    @Override
    public int getItemCount()
    {
        return categoryList.size();
    }

    /**
     * The ViewHolder pattern improve the code performance decreasing the number of findViwById executions
     */
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textCategory;

        public ViewHolder(View itemView)
        {
            super(itemView);

            textCategory = (TextView)itemView.findViewById(R.id.text_category_name);
        }
    }
}
