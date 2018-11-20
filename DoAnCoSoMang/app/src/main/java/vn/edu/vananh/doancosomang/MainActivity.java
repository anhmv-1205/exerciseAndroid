package vn.edu.vananh.doancosomang;

import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private EditText txtContent;
    private Button btnSend;
    private String ip = "";
    private Intent intent;

    Socket mSocket = null;
    BufferedWriter os = null;
    BufferedReader is = null;

    private static final String IP = "192.168.0.107";
    private static final int PORT = 3333;
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect();
        addControls();
        addEvents();
    }

    private void connect() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    // request connect to server
                    mSocket = new Socket(ip,9000);

                    // create output thread
                    os = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));

                    // create input thread
                    is = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

                    //Toast.makeText(MainActivity.this, "Connected to server!", Toast.LENGTH_SHORT).show();

                }
                catch (UnknownHostException e) {
                    System.err.println("Don't know about host " + ip);
                    return;
                }
                catch (IOException e) {
                    System.err.println("Couldn't get I/O for the connection to " + ip+"\n" + e.getMessage());
                    finish();
                    return;
                }
                finally {
                    System.out.println("Alo Alo");
                }

                try {
                    // Đọc dữ liệu trả lời từ phía server
                    // Bằng cách đọc luồng đầu vào của Socket tại Client.
                    String responseLine;
                    while ((responseLine = is.readLine()) != null) {
                        final String res = responseLine;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtResult.setText(res);
                            }
                        });
                        if (responseLine.contains("QUIT")) {
                            break;
                        }
                    }

                    os.close();
                    is.close();
                    mSocket.close();
                } catch (UnknownHostException e) {
                    System.err.println("Trying to connect to unknown host: " + e);
                } catch (IOException e) {
                    System.err.println("IOException:  " + e);
                }
            }
        }).start();
    }

    private void addEvents() {

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendContent();
            }
        });
    }

    private void sendContent() {

        final String content = txtContent.getText().toString().trim();

        if (!content.isEmpty()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        os.write(content);
                        os.newLine();
                        os.flush();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private void addControls() {
        txtContent = findViewById(R.id.txtContent);
        txtResult = findViewById(R.id.txtResult);
        btnSend = findViewById(R.id.btnSend);

        intent = getIntent();
        ip = intent.getStringExtra("IP");

    }
}
