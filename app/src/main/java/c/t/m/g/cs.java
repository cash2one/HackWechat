package c.t.m.g;

import android.text.TextUtils;

public final class cs {
    public int a;
    String b;
    String c;
    public String d;
    String e;
    public String f;
    public String g;
    public String h;
    public String i;
    int j;
    int k;
    public long l;
    public volatile long m = 0;
    public volatile long n = 0;
    public volatile long o = 0;
    public volatile String p = "";
    public String q = "6.3.0.5";
    private String r;
    private String s = "6.3.0.5";
    private String t = "180103";

    cs() {
    }

    public final String a() {
        if (TextUtils.isEmpty(this.b)) {
            return "0123456789ABCDEF";
        }
        return this.b;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.c)) {
            return "0123456789ABCDEF";
        }
        return this.c;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.e) || this.e.contains("0000")) {
            return "0123456789ABCDEF";
        }
        return this.e;
    }

    public final String d() {
        if (this.s == null) {
            return "None";
        }
        return this.s;
    }

    public final String e() {
        if (this.t == null) {
            return "None";
        }
        return this.t;
    }

    public final String f() {
        if (this.r == null) {
            StringBuilder stringBuilder = new StringBuilder(100);
            stringBuilder.append(a()).append("_").append(b()).append("_").append(c()).append("_QQGeoLocation");
            this.r = j.c(stringBuilder.toString());
        }
        return this.r;
    }
}
