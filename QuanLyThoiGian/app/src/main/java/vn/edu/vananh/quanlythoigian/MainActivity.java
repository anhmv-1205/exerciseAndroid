package vn.edu.vananh.quanlythoigian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import vn.edu.vananh.quanlythoigian.model.JobInWeek;

public class MainActivity extends AppCompatActivity {

    private EditText editCongViec, editNoiDung;
    private TextView txtDate, txtTime;
    private Button btnTime, btnDate, btnThemCV;
    private ListView lvCongViec;

    ArrayList<JobInWeek> arrJob = new ArrayList<JobInWeek>();
    ArrayAdapter<JobInWeek> adapter = null;

    Calendar cal;

    Date dateFinish, hourFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        setDefaultInfor();
        addEvents();
}

    private void setDefaultInfor() {
        cal = Calendar.getInstance();

        SimpleDateFormat sdf = null;

        sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate = sdf.format(cal.getTime());

        txtDate.setText(strDate);

        sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());

        String strTime = sdf.format(cal.getTime());

        txtTime.setText(strTime);

        sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        txtTime.setTag(sdf.format(cal.getTime()));

        editCongViec.requestFocus();

        dateFinish = cal.getTime();
        hourFinish = cal.getTime();
    }

    private void addEvents() {

    }

    private void addControls() {
        editCongViec = findViewById(R.id.editCongViec);
        editNoiDung = findViewById(R.id.editNoiDung);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);
        btnTime = findViewById(R.id.btnTime);
        btnDate = findViewById(R.id.btnDate);
        btnThemCV = findViewById(R.id.btnThemCV);
        lvCongViec = findViewById(R.id.lvCongViec);

        adapter = new ArrayAdapter<JobInWeek>(this, android.R.layout.simple_list_item_1, arrJob);

        lvCongViec.setAdapter(adapter);
    }
}
