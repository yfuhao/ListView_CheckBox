package com.bawei.listview_checkbox;

/**
 * Created by yufuhao on 2017/6/7.
 */

public class Bean {
    public String str;
    public boolean boo;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean isBoo() {
        return boo;
    }

    public void setBoo(boolean boo) {
        this.boo = boo;
    }

    public Bean(String str, boolean boo) {
        this.str = str;
        this.boo = boo;
    }
}
