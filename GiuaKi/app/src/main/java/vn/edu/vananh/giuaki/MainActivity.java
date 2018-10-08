package vn.edu.vananh.giuaki;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtA, txtB;
    private Button btnGoi;


    private ListView lvKetQua;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrKetQua;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goiThongTin();
            }
        });
    }

    private void goiThongTin() {
        String strA = txtA.getText().toString();
        String strB = txtB.getText().toString();

        if (!strA.isEmpty() && !strB.isEmpty()) {
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);

            intent = new Intent(MainActivity.this, ManHinh2Activity.class);
            intent.putExtra("soA", a);
            intent.putExtra("soB", b);

            startActivityForResult(intent,6969);



        } else {
            if (strA.isEmpty()) {
                Toast.makeText(MainActivity.this, "Chưa nhập a", Toast.LENGTH_SHORT).show();
                txtA.requestFocus();
            } else {
                Toast.makeText(MainActivity.this, "Chưa nhập b", Toast.LENGTH_SHORT).show();
                txtB.requestFocus();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 6969 && resultCode == 9696) {
            String result = data.getStringExtra("RESULT");
            arrKetQua.add(0, result);
            adapter.notifyDataSetChanged();
            txtA.setText("");
            txtA.requestFocus();
            txtB.setText("");
        }
    }

    private void addControls() {
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);

        btnGoi = findViewById(R.id.btnGoi);
        lvKetQua = findViewById(R.id.lvKetQua);

        arrKetQua = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrKetQua);
        lvKetQua.setAdapter(adapter);
    }
}
