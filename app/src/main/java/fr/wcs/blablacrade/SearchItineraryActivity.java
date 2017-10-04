package fr.wcs.blablacrade;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText searchDep = (EditText) findViewById(R.id.searchDep);
        final EditText searchDest = (EditText) findViewById(R.id.searchDest);
        final EditText searchDate = (EditText) findViewById(R.id.searchDate);
        Button buttonSearch = (Button) findViewById(R.id.search);

        // clique action
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departure = searchDep.getText().toString();
                String destination = searchDest.getText().toString();
                String date = searchDate.getText().toString();

                if (departure.isEmpty() || destination.isEmpty()
                        ) {
                    Toast painGrillé = Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.form_error), Toast.LENGTH_SHORT);
                    painGrillé.show();
                }else {
                    Intent intent = new Intent(SearchItineraryActivity.this,
                            ViewSearchItineraryResultsListActivity.class);
                    SearchRequestModel searchRequest=new SearchRequestModel(departure, destination, date);
                    intent.putExtra("searchRequest", searchRequest);
                    SearchItineraryActivity.this.startActivity(intent);
                }
            }
        });

        final Calendar calendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view,int année,int mois,int jours){
                calendar.set(Calendar.YEAR, année);
                calendar.set(Calendar.MONTH, mois);
                calendar.set(Calendar.DAY_OF_MONTH, jours);
                UpdateLabel(searchDate, calendar);
            }};

        searchDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SearchItineraryActivity.this,
                        dateListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }
    private void UpdateLabel(EditText editText, Calendar myCalendar) {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        editText.setText(sdf.format(myCalendar.getTime()));
    }
}
