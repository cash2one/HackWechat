package com.tencent.mm.z;

import com.tencent.mm.a.g;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class o {
    public static String k(String str, long j) {
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(j));
        if (str == null || str.length() <= 1) {
            format = format + "fffffff";
        } else {
            format = format + g.s(str.getBytes()).substring(0, 7);
        }
        return (format + String.format("%04x", new Object[]{Long.valueOf(j % 65535)})) + ((j % 7) + 100);
    }
}
