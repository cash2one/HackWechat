package com.tencent.c.e.a;

import android.content.Context;
import com.tencent.c.e.a.a.f;

public final class d$a {
    int action;
    Context context;
    int requestType;
    long xfZ;
    int zTC;
    public long zTD;

    private d$a(Context context, int i, int i2) {
        this.requestType = 0;
        this.zTC = 0;
        this.action = 0;
        this.zTD = f.zTV * 12;
        this.xfZ = 0;
        if (i < 0) {
            throw new IllegalArgumentException("scenes invalid: " + i);
        }
        this.context = context.getApplicationContext();
        this.zTC = i;
        this.action = i2;
    }
}
