package name.ipetrushin.weathercitydb;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {
    SQLiteDatabase db;
    DBHelper dbHelper;
    ListView citiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citiesList = findViewById(R.id.citiesList);
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM cities;", null);
        String[] fields = {"_id", "name", "country"};
        int[] resIds = {R.id.id, R.id.city_name, R.id.country};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item, c, fields, resIds,0);
        citiesList.setAdapter(adapter);

    }
}
