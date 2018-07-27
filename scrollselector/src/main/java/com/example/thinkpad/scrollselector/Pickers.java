package com.example.thinkpad.scrollselector;

import java.io.Serializable;

/**
 * Created by 宋德慧
 * time: 2018/7/25-20:27.
 * email: m18201222438@163.com
 * tel: 15836320932
 */
public class Pickers implements Serializable {

    private static final long serialVersionUID = 1L;

    private String showConetnt;
    private String showId;

    public String getShowConetnt() {
        return showConetnt;
    }

    public String getShowId() {
        return showId;
    }

    public Pickers(String showConetnt, String showId) {
        super();
        this.showConetnt = showConetnt;
        this.showId = showId;
    }

    public Pickers() {
        super();
    }

}

