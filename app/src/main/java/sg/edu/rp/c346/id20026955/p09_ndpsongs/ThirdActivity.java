package sg.edu.rp.c346.id20026955.p09_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class ThirdActivity extends AppCompatActivity {

    EditText  etID,etSongTitle, etSinger, etYear;
    RatingBar rbStar;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        etID = findViewById(R.id.etId);
        etSongTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSingers2);
        etYear = findViewById(R.id.etYear);
        rbStar = findViewById(R.id.rbStars2);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent i = getIntent();

        etID.setText(data.getId());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                data.setTitle(etSongTitle.getText().toString());
                data.setSingers(etSinger.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                data.setStars((int) rbStar.getRating());
                dbh.updateSong(data);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                dbh.deleteSong(data.getId());

                Intent i = new Intent(ThirdActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish();


            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ThirdActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish();

            }
        });

    }
}