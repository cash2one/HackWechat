package com.tencent.mm.plugin.collect.b;

import android.content.Context;
import com.tencent.mm.plugin.wxpay.a.i;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class e {
    public static String a(Context context, long j, int i) {
        long j2 = 1000 * j;
        if (i == 0) {
            return new SimpleDateFormat(context.getString(i.uIi)).format(new Date(j2));
        }
        if (i == 1) {
            return new SimpleDateFormat(context.getString(i.uIj)).format(new Date(j2));
        }
        return new SimpleDateFormat(context.getString(i.uIk)).format(new Date(j2));
    }

    public static String oq(int i) {
        return String.format("%.2f", new Object[]{Double.valueOf(((double) i) / 100.0d)});
    }
}
