package com.tencent.mm.z;

import android.database.Cursor;
import junit.framework.Assert;

public final class bf {
    int fDt = -1;
    public String hed = "";
    public String hef = "";
    public String hhe = "";
    public String hhf = "";
    public String hhg = "";
    public long hhh = 0;
    public String hhi = "";
    public String hhj = "";
    public int hhk = 0;
    public int hhl = 0;
    public long hhm = 0;
    public String hhn = "";
    String hho = "";
    public String name = "";
    public long time = 0;
    public String title = "";
    public int type = 0;
    public String url = "";

    public final void b(Cursor cursor) {
        this.hhe = cursor.getString(0);
        this.time = cursor.getLong(1);
        this.type = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.title = cursor.getString(4);
        this.url = cursor.getString(5);
        this.hhf = cursor.getString(6);
        this.hhg = cursor.getString(7);
        this.hhh = cursor.getLong(8);
        this.hhi = cursor.getString(9);
        this.hhj = cursor.getString(10);
        this.hhk = cursor.getInt(11);
        this.hed = cursor.getString(12);
        this.hef = cursor.getString(13);
        this.hhl = cursor.getInt(14);
        this.hhm = cursor.getLong(15);
        this.hhn = cursor.getString(16);
        this.hho = cursor.getString(17);
    }

    public static String gT(int i) {
        if (i == 20) {
            return "newsapp";
        }
        if (i == 11) {
            return "blogapp";
        }
        Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
        return null;
    }

    public final void aL(long j) {
        this.hhm = j;
    }

    public final boolean HG() {
        return this.hhl == 1;
    }

    public final String HH() {
        return this.hhe == null ? "" : this.hhe;
    }

    public final String getName() {
        return this.name == null ? "" : this.name;
    }

    public final String getTitle() {
        return this.title == null ? "" : this.title;
    }

    public final String getUrl() {
        return this.url == null ? "" : this.url;
    }

    public final String HI() {
        return this.hhf == null ? "" : this.hhf;
    }

    public final String HJ() {
        return this.hhi == null ? "" : this.hhi;
    }

    public final String HK() {
        return this.hhj == null ? "" : this.hhj;
    }

    public final String HL() {
        if (this.hed == null) {
            return "";
        }
        String[] split = this.hed.split("\\|");
        if (split == null || split.length <= 0) {
            return "";
        }
        return split[0];
    }

    public final String HM() {
        return this.hef == null ? "" : this.hef;
    }

    public final String HN() {
        return this.hhn == null ? "" : this.hhn;
    }
}
