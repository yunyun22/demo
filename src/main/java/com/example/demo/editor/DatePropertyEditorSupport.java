package com.example.demo.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wang, jinqiao
 * @date 02/03/2021
 */
public class DatePropertyEditorSupport extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date s = simpleDateFormat.parse(text);
            System.out.println("---------转换后的时间：" + s);
            setValue(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
