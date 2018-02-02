package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.mm.w.a.k;
import java.util.Calendar;
import java.util.Date;

public class a {
    private static a zeA;
    private long zex = Calendar.getInstance().getTimeInMillis();
    private long zey;
    private long zez;

    public static a cxk() {
        if (zeA == null) {
            synchronized (a.class) {
                zeA = new a();
            }
        }
        return zeA;
    }

    private a() {
        Calendar instance = Calendar.getInstance();
        instance.set(7, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.zey = instance.getTimeInMillis();
        instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.zez = instance.getTimeInMillis();
    }

    public final long b(Date date) {
        if (date.getTime() >= this.zey) {
            return Long.MAX_VALUE;
        }
        if (date.getTime() >= this.zez) {
            return 9223372036854775806L;
        }
        return (long) ((date.getYear() * 100) + date.getMonth());
    }

    public static long gr(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public final String a(Date date, Context context) {
        if (date.getTime() >= this.zey) {
            return context.getString(k.gYL);
        }
        if (date.getTime() >= this.zez) {
            return context.getString(k.gYK);
        }
        return String.format("%d/%d", new Object[]{Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1)});
    }
}
