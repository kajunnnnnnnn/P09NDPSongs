package sg.edu.rp.c346.id20026955.p09_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etSinger;
    EditText etYear;
    RatingBar rbStars;
    Button btnInsert;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        rbStars = findViewById(R.id.rbStars);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etTitle.getText().toString().isEmpty() || etSinger.getText().toString().isEmpty() || etYear.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all field", Toast.LENGTH_SHORT).show();
                } else {
                    String title = etTitle.getText().toString();
                    String singers = etSinger.getText().toString();
                    int year = Integer.parseInt(etYear.getText().toString());
                    int stars = (int) rbStars.getRating();
                    DBHelper dbh = new DBHelper(MainActivity.this);
                    long inserted_id = dbh.insertSong(title, singers, year, stars);
                    if (inserted_id != -1) {
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}

