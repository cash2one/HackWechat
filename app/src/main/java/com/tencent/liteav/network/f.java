package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;

public class f {
    private String a = "";
    private String b = "";
    private int c = 0;
    private String d = "";
    private Handler e;

    public f(Context context) {
        if (context != null) {
            this.e = new Handler(context.getMainLooper());
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int a(String str, int i, a aVar) {
        this.a = "";
        this.b = "";
        this.c = 0;
        this.d = "";
        if (str == null || str.isEmpty()) {
            return -1;
        }
        String a = a(str);
        if (a == null || a.isEmpty()) {
            return -2;
        }
        String a2 = a("bizid", str);
        String a3 = a("txSecret", str);
        String a4 = a("txTime", str);
        if (a2 == null || a2.isEmpty() || a3 == null || a3.isEmpty() || a4 == null || a4.isEmpty()) {
            return -3;
        }
        a(a, a2, a3, a4, i, new 1(this, a, a2, a3, a4, aVar));
        return 0;
    }

    private void a(String str, String str2, String str3, String str4, int i, a aVar) {
        new 2(this, "getRTMPAccUrl", str2, str, str3, str4, i, aVar).start();
    }

    private String a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String substring;
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            substring = str.substring(0, indexOf);
        } else {
            substring = str;
        }
        if (substring == null || substring.length() == 0) {
            return null;
        }
        int lastIndexOf = substring.lastIndexOf("/");
        if (lastIndexOf != -1) {
            substring = substring.substring(lastIndexOf + 1);
        }
        if (substring == null || substring.length() == 0) {
            return null;
        }
        lastIndexOf = substring.indexOf(".");
        if (lastIndexOf != -1) {
            substring = substring.substring(0, lastIndexOf);
        }
        if (substring == null || substring.length() == 0) {
            return null;
        }
        return substring;
    }

    private String a(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return null;
        }
        String toLowerCase = str.toLowerCase();
        for (String str3 : str2.split("[?&]")) {
            String str32;
            if (str32.indexOf("=") != -1) {
                String[] split = str32.split("[=]");
                if (split.length == 2) {
                    String str4 = split[0];
                    str32 = split[1];
                    if (str4 != null && str4.toLowerCase().equalsIgnoreCase(toLowerCase)) {
                        return str32;
                    }
                }
                continue;
            }
        }
        return null;
    }
}
