package vn.edu.vananh.doancosomang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConnectActivity extends AppCompatActivity {

    private EditText tvAddressIP;
    private Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        addControls();
        addEvents();
    }

    private void addEvents() {

        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ip = tvAddressIP.getText().toString().trim();
                if(!ip.isEmpty()) {
                    Intent intent = new Intent(ConnectActivity.this, MainActivity.class);
                    intent.putExtra("IP", ip);
                    startActivity(intent);
                } else {
                    tvAddressIP.requestFocus();
                }

            }
        });

    }

    private void addControls() {
        tvAddressIP = findViewById(R.id.tvAddressIP);
        btnConnect= findViewById(R.id.btnConnect);
    }
}
