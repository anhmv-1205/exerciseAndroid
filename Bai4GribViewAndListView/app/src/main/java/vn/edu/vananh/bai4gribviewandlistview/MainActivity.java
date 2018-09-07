package vn.edu.vananh.bai4gribviewandlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnChon;

    ListView lvMonHoc;

    GridView gvMonHoc;

    String []arrMonHoc;

    ArrayAdapter<String> adapterMonHoc;

    Boolean isListView = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChon();
            }
        });

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Bạn chon:" + arrMonHoc[position], Toast.LENGTH_SHORT).show();
            }
        });

        gvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Bạn chon:" + arrMonHoc[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void xuLyChon() {
        // chuyen doi 2 loai list controls
        if (isListView) {
            btnChon.setText("ListView");
            lvMonHoc.setVisibility(View.GONE);
            gvMonHoc.setVisibility(View.VISIBLE);
            isListView = false;
        } else {
            btnChon.setText("GridView");
            gvMonHoc.setVisibility(View.GONE);
            lvMonHoc.setVisibility(View.VISIBLE);
            isListView = true;
        }
    }

    private void addControls() {
        btnChon = findViewById(R.id.btnChon);
        lvMonHoc = findViewById(R.id.lvMonHoc);
        gvMonHoc = findViewById(R.id.gvMonHoc);

        arrMonHoc = getResources().getStringArray(R.array.arrMonHoc);

        adapterMonHoc = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrMonHoc);

        lvMonHoc.setAdapter(adapterMonHoc);
        gvMonHoc.setAdapter(adapterMonHoc);
    }
}
