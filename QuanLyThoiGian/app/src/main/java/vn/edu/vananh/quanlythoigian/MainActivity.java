package vn.edu.vananh.quanlythoigian;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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
        btnDate.setOnClickListener(new MyButtonEvent());
        btnTime.setOnClickListener(new MyButtonEvent());
        btnThemCV.setOnClickListener(new MyButtonEvent());

        lvCongViec.setOnItemClickListener(new MyListViewEvent());
    }

    private class MyButtonEvent implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnDate:
                    showDatePickerDialog();
                    break;
                case R.id.btnTime:
                    showTimePickerDialog();
                    break;
                case R.id.btnThemCV:
                    processAddJob();
                    break;
            }
        }
    }

    private void processAddJob() {
        String congViec = editCongViec.getText().toString();
        String description = editNoiDung.getText().toString();

        JobInWeek job  = new JobInWeek(congViec, description, dateFinish, hourFinish);
        arrJob.add(0, job);
        adapter.notifyDataSetChanged();

        editCongViec.setText("");
        editNoiDung.setText("");
        editCongViec.requestFocus();
    }

    private void showTimePickerDialog() {
        TimePickerDialog.OnTimeSetListener callback = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String s = hourOfDay + ":" + minute;
                int hourTam = hourOfDay;
                if (hourTam > 12) {
                    hourTam = hourTam - 12;
                }
                txtTime.setText(hourTam + ":" + minute + (hourOfDay>12? " PM" : " AM"));

                txtTime.setTag(s);

                cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                cal.set(Calendar.MINUTE, minute);

                hourFinish = cal.getTime();
            }
        };

        String s = txtTime.getTag().toString();
        String strArr[] = s.split(":");
        int gio = Integer.parseInt(strArr[0]);
        int phut = Integer.parseInt(strArr[1]);

        TimePickerDialog time = new TimePickerDialog(MainActivity.this, callback, gio, phut, true);
        time.setTitle("Chọn giờ hoàn thành");
        time.show();

    }

    private void showDatePickerDialog() {
        DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtDate.setText((dayOfMonth) + "/" + (month + 1) + "/" + year );
                cal.set(year, month, dayOfMonth);
                dateFinish = cal.getTime();
            }
        };

        String s = txtDate.getText().toString();
        String strArrtmp[] = s.split("/");
        int ngay = Integer.parseInt(strArrtmp[0]);
        int thang = Integer.parseInt(strArrtmp[1]) - 1;
        int nam = Integer.parseInt(strArrtmp[2]);
        DatePickerDialog pic = new DatePickerDialog(MainActivity.this, callback, nam, thang, ngay);
        pic.setTitle("Chon ngay hoan thanh");
        pic.show();

    }

    private class MyListViewEvent implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, arrJob.get(position).getDescription(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            arrJob.remove(position);
            adapter.notifyDataSetChanged();
            return false;
        }
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
