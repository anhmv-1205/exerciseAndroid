package vn.edu.vananh.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.BaseInputConnection;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtA, txtB;
    private Button btnCong, btnTru, btnNhan, btnChia;
    private TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
        txtA.requestFocus();
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
    }

    private void addControls() {
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtKetQua = findViewById(R.id.txtKetQua);

        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCong:
                xuLyCong();
                break;
            case R.id.btnTru:
                xuLyTru();
                break;
            case R.id.btnNhan:
                xuLyNhan();
                break;
            case R.id.btnChia:
                xuLyChia();
                break;
        }
    }

    private void xuLyChia() {
        String strA = txtA.getText().toString();
        String strB = txtB.getText().toString();

        if (!strA.isEmpty() && !strB.isEmpty()) {
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);

            if (a != 0 ){
                int c = a / b;
                txtKetQua.setText("" + c);
            } else {
                txtKetQua.setText("Cannot divide by zero");
            }
        } else {
            txtKetQua.setText("You haven't enough inputed  the number");
        }
    }

    private void xuLyTru() {
        String strA = txtA.getText().toString();
        String strB = txtB.getText().toString();

        if (!strA.isEmpty() && !strB.isEmpty()) {
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);

            int c = a - b;
            txtKetQua.setText("" + c);

        } else {
            txtKetQua.setText("You haven't enough inputed  the number");
        }
    }

    private void xuLyNhan() {
        String strA = txtA.getText().toString();
        String strB = txtB.getText().toString();

        if (!strA.isEmpty() && !strB.isEmpty()) {
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);

            int c = a * b;
            txtKetQua.setText("" + c);

        } else {
            txtKetQua.setText("You haven't enough inputed  the number");
        }
    }

    private void xuLyCong() {
        String strA = txtA.getText().toString();
        String strB = txtB.getText().toString();

        if (!strA.isEmpty() && !strB.isEmpty()) {
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);

            int c = a + b;
            txtKetQua.setText("" + c);

        } else {
            txtKetQua.setText("You haven't enough inputed  the number");
        }
    }

}
