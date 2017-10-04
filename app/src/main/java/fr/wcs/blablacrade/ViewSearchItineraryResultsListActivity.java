package fr.wcs.blablacrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        SearchRequestModel requestModel = getIntent().getParcelableExtra("searchRequest");
        String resultDep = requestModel.getDeparture();
        String resultDest = requestModel.getDestination();
        String resultDate = requestModel.getDate();

        Toast.makeText(this, resultDate, Toast.LENGTH_LONG).show();
        setTitle(resultDep + " >> " + resultDest);

        ListView résultat = (ListView) findViewById(R.id.listViewSearchResults);
        ArrayList<TripResultModel> table = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        try {
            table.add(new TripResultModel("Bernard", sdf.parse("21/02/2017-15:30"), 15));
            table.add(new TripResultModel("Jean-Jacques", sdf.parse("21/02/2017-16:00"), 20));
            table.add(new TripResultModel("Bertrand", sdf.parse("21/02/2017-16:30"), 16));
            table.add(new TripResultModel("Gertrude", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        TripResultAdapter adapteur = new TripResultAdapter(this, table);
        résultat.setAdapter(adapteur);
    }
}
