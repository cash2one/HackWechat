package com.google.android.gms.analytics.internal;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.c.aa;
import com.google.android.gms.common.internal.w;
import java.util.HashSet;
import java.util.Set;

public final class ac {
    private final q aHf;
    private volatile Boolean aHg;
    private String aHh;
    private Set<Integer> aHi;

    protected ac(q qVar) {
        w.ag(qVar);
        this.aHf = qVar;
    }

    public static int nA() {
        return ((Integer) aj.aHH.get()).intValue();
    }

    public static String nB() {
        return (String) aj.aHJ.get();
    }

    public static String nC() {
        return (String) aj.aHI.get();
    }

    public static String nD() {
        return (String) aj.aHK.get();
    }

    public static long nF() {
        return ((Long) aj.aHY.get()).longValue();
    }

    public static boolean nv() {
        return ((Boolean) aj.aHt.get()).booleanValue();
    }

    public static int nw() {
        return ((Integer) aj.aHQ.get()).intValue();
    }

    public static long nx() {
        return ((Long) aj.aHB.get()).longValue();
    }

    public static long ny() {
        return ((Long) aj.aHE.get()).longValue();
    }

    public static int nz() {
        return ((Integer) aj.aHG.get()).intValue();
    }

    public final Set<Integer> nE() {
        String str = (String) aj.aHT.get();
        if (this.aHi == null || this.aHh == null || !this.aHh.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.aHh = str;
            this.aHi = hashSet;
        }
        return this.aHi;
    }

    public final boolean nu() {
        if (this.aHg == null) {
            synchronized (this) {
                if (this.aHg == null) {
                    ApplicationInfo applicationInfo = this.aHf.mContext.getApplicationInfo();
                    String n = aa.n(this.aHf.mContext, Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(n);
                        this.aHg = Boolean.valueOf(z);
                    }
                    if ((this.aHg == null || !this.aHg.booleanValue()) && "com.google.android.gms.analytics".equals(n)) {
                        this.aHg = Boolean.TRUE;
                    }
                    if (this.aHg == null) {
                        this.aHg = Boolean.TRUE;
                        this.aHf.mS().ay("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.aHg.booleanValue();
    }
}
