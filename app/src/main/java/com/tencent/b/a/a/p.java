package com.tencent.b.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import java.lang.reflect.Method;

public class p {
    private static volatile p bpH = null;
    private boolean bpI = false;
    private Context context = null;

    public final boolean t(String str, String str2) {
        if (this.bpI) {
            try {
                return System.putString(this.context.getContentResolver(), str, str2);
            } catch (Exception e) {
            }
        }
        return false;
    }

    private p(Context context) {
        this.context = context.getApplicationContext();
        this.bpI = s.j(this.context, "android.permission.WRITE_SETTINGS");
        if (VERSION.SDK_INT >= 23) {
            try {
                Method declaredMethod = System.class.getDeclaredMethod("canWrite", new Class[]{Context.class});
                declaredMethod.setAccessible(true);
                this.bpI = ((Boolean) declaredMethod.invoke(null, new Object[]{this.context})).booleanValue();
            } catch (Exception e) {
            }
        }
    }

    public static p Y(Context context) {
        if (bpH == null) {
            synchronized (p.class) {
                if (bpH == null) {
                    bpH = new p(context);
                }
            }
        }
        return bpH;
    }
}
