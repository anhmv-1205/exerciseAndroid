package vn.edu.vananh.quanlythoigian.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JobInWeek {
    private String title;
    private String description;
    private Date dateFinish;
    private Date hourFinish;

    public JobInWeek() {
        super();
    }

    public JobInWeek(String title, String description, Date dateFinish, Date hourFinish) {
        super();
        this.title = title;
        this.description = description;
        this.dateFinish = dateFinish;
        this.hourFinish = hourFinish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Date getHourFinish() {
        return hourFinish;
    }

    public void setHourFinish(Date hourFinish) {
        this.hourFinish = hourFinish;
    }

    public String getDateFormat(Date date){
        String strFormat = "dd/MM/yyyy";
        SimpleDateFormat dft = new SimpleDateFormat(strFormat, Locale.getDefault());
        return dft.format(date);
    }

    public String getHourFormat(Date time){
        String strFormat = "hh:mm a";
        SimpleDateFormat dft = new SimpleDateFormat(strFormat, Locale.getDefault());
        return dft.format(time);
    }

    @Override
    public String toString() {
        return this.title + " - " + getDateFormat(this.dateFinish) + " - " + getHourFormat(this.hourFinish);
    }
}
