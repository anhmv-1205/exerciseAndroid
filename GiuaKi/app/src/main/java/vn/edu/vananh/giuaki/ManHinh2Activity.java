package vn.edu.vananh.giuaki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ManHinh2Activity extends AppCompatActivity {

    private TextView txtA, txtB, txtKetQua;
    private Button btnCong, btnGoiLai;
    Intent intent;

    int a, b;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);

        addControls();
        addEvents();
    }

    private void addEvents() {
        txtA.setText(a + "");
        txtB.setText(b + "");

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c = a + b;
                result = a + " + " + b + " = " + c;
                txtKetQua.setText(result);
            }
        });

        btnGoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = txtKetQua.getText().toString();
                if (!str.isEmpty()) {
                    intent.putExtra("RESULT", str);
                    setResult(9696, intent);

                    finish();
                }
                else {
                    Toast.makeText(ManHinh2Activity.this, "Chưa thực hiện tính toán", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addControls() {
        intent = getIntent();
        a = intent.getIntExtra("soA", 0);
        b = intent.getIntExtra("soB", 0);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtKetQua = findViewById(R.id.txtKetQua);

        btnCong = findViewById(R.id.btnCong);
        btnGoiLai = findViewById(R.id.btnGoiLai);
    }
}
