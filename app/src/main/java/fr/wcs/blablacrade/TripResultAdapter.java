package fr.wcs.blablacrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wilder on 13/09/17.
 */

// This is the adapter
public class TripResultAdapter extends BaseAdapter {
    //context
    private Context context;
    //data source of the list adapter
    private ArrayList<TripResultModel> items;

    //public constructor 
    public TripResultAdapter(Context context, ArrayList<TripResultModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        //returns total of items in the list
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        //returns list item at the specified position
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.trip_item, parent, false);
        }

        // get current item to be displayed
        TripResultModel currentItem = (TripResultModel) getItem(position);

        // get the TextView for item name and item description
        TextView departure = (TextView) convertView.findViewById(R.id.textDep);
        TextView firstname = (TextView) convertView.findViewById(R.id.textFirstName);
        TextView price = (TextView) convertView.findViewById(R.id.textPrice);

        //sets the text for item name and item description from the current item object
        departure.setText(currentItem.getDepart().toString());
        firstname.setText(currentItem.getFirstName());
        price.setText(String.valueOf(currentItem.getPrix()));

        // returns the view for the current row
        return convertView;
    }
}