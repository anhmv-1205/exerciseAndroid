package vn.edu.vananh.doancosomang;

import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private EditText txtContent;
    private Button btnSend;


    private static final String IP = "192.168.0.107";
    private static final int PORT = 3333;
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToServer();
            }
        });
    }

    private void sendToServer() {
        message = txtContent.getText().toString().trim();

        if(!message.isEmpty()){
            sendData(message);
        } else {
            txtResult.requestFocus();
        }
    }

    private void sendData(String m) {

    }

    class MyTask extends AsyncTask<String, Void, String> {


        public String connectServer(String ip, int port, String a) {

            String output = "";

            Socket socket;
            DataInputStream dis;
            DataOutputStream dos;

            try {
                socket = new Socket(ip, port); // ket noi server
                dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(message);

                dis = new DataInputStream(socket.getInputStream());
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            catch (UnknownHostException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }


            return output;
        }

        @Override
        protected String doInBackground(String... strings) {
            String a = strings[0];
            String s = connectServer(IP, PORT, a);
            return s;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }

    private void addControls() {
        txtContent = findViewById(R.id.txtContent);
        txtResult = findViewById(R.id.txtResult);
        btnSend = findViewById(R.id.btnSend);
    }
}
