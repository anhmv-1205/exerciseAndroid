package vn.edu.vananh.eventonclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtA, txtB;
    private TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtKetQua = findViewById(R.id.txtKetQua);
    }

    public void tinhTong(View view) {
        int a = Integer.parseInt(txtA.getText().toString()); // chuyen doi tu tring qua kieu int
        int b = Integer.parseInt(txtB.getText().toString()); // chuyen doi tu tring qua kieu int

        int c = a + b;

        Toast.makeText(MainActivity.this,"Ket Qua = " + c, Toast.LENGTH_SHORT).show();
        txtKetQua.setText(a + " + " + b + " = " + c); // ep kieu tu int qua string

        txtA.getText().clear(); // xoa so da nhap
        txtB.getText().clear(); // xoa so da nhap
        txtA.requestFocus();    // focus vao o nhap a
    }
}
