package vn.edu.vananh.activityislistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtA, txtB;
    private TextView txtKetQua;
    private Button btnTinhTong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTinhTong.setOnClickListener(this);
    }

    private void addControls() {

        txtA = findViewById(R.id.txtA);

        txtB = findViewById(R.id.txtB);

        txtKetQua = findViewById(R.id.txtKetQua);

        btnTinhTong = findViewById(R.id.btnTinhTong);

    }

    private void tinhTong() {

        int a = Integer.parseInt(txtA.getText().toString());

        int b = Integer.parseInt(txtB.getText().toString());

        int c = a + b;

        txtKetQua.setText(a + " + " + b + " = " + c);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnTinhTong) {
            tinhTong();
        }
    }
}
