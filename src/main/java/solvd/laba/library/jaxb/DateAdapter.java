package solvd.laba.library.jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.sql.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    @Override
    public Date unmarshal(String s) throws Exception {
        return Date.valueOf(s);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return date.toString();
    }
}
