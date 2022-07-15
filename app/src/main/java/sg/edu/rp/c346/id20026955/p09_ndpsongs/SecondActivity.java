package sg.edu.rp.c346.id20026955.p09_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    Button btnToggle;
    Song data;
    ListView lv;
    ArrayAdapter<String> aa;
    ArrayList<Song> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnToggle = findViewById(R.id.btnToggle);
        lv = findViewById(R.id.lv);

        al = new ArrayList<>();
        aa = new ArrayAdapter(SecondActivity.this, android.R.layout.simple_expandable_list_item_1, al);
        lv.setAdapter(aa);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        DBHelper db1 = new DBHelper(SecondActivity.this);
        al.clear();
        al.addAll(db1.getAllSongs());
        aa.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(SecondActivity.this,
                        ThirdActivity.class);
                startActivity(i);

            }
        });

    }
}