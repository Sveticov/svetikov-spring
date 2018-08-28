package com.svetikov.svetikovspring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyVal {
    private Object mydata;
    private Object mydata2;
    private String status;

    public MyVal(Object mydata, Object mydata2,String status) {
        this.mydata = mydata;
        this.mydata2 = mydata2;
        this.status = status;
    }

    public MyVal() {
    }
}
