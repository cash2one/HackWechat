package com.tencent.mm.plugin.normsg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.mm.plugin.normsg.utils.b.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Locale;

public final class a implements g {
    public static final a<String> oSx;
    private long oSA;
    private int oSB;
    private long oSy;
    private long oSz;

    static {
        a aVar = new a((byte) 0);
        oSx = aVar;
        aVar.add("");
        oSx.add(":tools");
        oSx.add(":appbrand");
    }

    public static a bfK() {
        return b.oSC;
    }

    private a() {
        this.oSy = 0;
        this.oSz = 0;
        this.oSA = 0;
        this.oSB = 0;
        bfN();
    }

    public final synchronized void tY(int i) {
        this.oSB = i;
    }

    public final void a(int i, View view, List<AccessibilityNodeInfo> list) {
        boolean z;
        String view2 = view != null ? view.toString() : "";
        String uh = uh(i);
        String str = "MircoMsg.AEDHLP";
        String str2 = "[tomys] ae about searching, pid:%d, pname:%s, vwinfo:%s, is_found:%b";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = uh;
        objArr[2] = view2;
        if (list == null || list.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        objArr[3] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (c.bfP() && uh != null && uh.contains(c.GG(">\u0010r\u001bc\u0001xV")) && list != null) {
            list.clear();
        }
    }

    public final boolean a(int i, int i2, View view) {
        String view2 = view != null ? view.toString() : "";
        String uh = uh(i2);
        x.i("MircoMsg.AEDHLP", "[tomys] ae about action, pid:%d, pname:%s, vwinfo:%s, action:%d", new Object[]{Integer.valueOf(i2), uh, view2, Integer.valueOf(i)});
        f(i, view);
        n(i, uh, view2);
        if (c.bfP() && uh != null && uh.contains(c.GG(">\u0010r\u001bc\u0001xV"))) {
            return false;
        }
        return true;
    }

    public final void f(Throwable th) {
        x.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] unexpected error happens.", new Object[0]);
        g(th);
    }

    public final synchronized long bfL() {
        return this.oSA;
    }

    public final synchronized void bfM() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oSz >= 259200000) {
            this.oSA = 0;
            this.oSz = currentTimeMillis;
            bfO();
        }
    }

    private synchronized void bfN() {
        Closeable dataInputStream;
        Throwable th;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(ac.getContext().getCacheDir(), c.GG("ãçÜºÈ­Üòù")))));
            try {
                this.oSy = dataInputStream.readLong();
                this.oSz = dataInputStream.readLong();
                long readLong = dataInputStream.readLong();
                if (readLong > 0 && this.oSA <= 0) {
                    this.oSA = readLong;
                }
                bh.d(dataInputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to load rec.", new Object[0]);
                    this.oSy = 0;
                    this.oSz = System.currentTimeMillis();
                    this.oSA = 0;
                    bfO();
                    bh.d(dataInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    bh.d(dataInputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            bh.d(dataInputStream);
            throw th;
        }
    }

    private synchronized void bfO() {
        Throwable th;
        Closeable dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(ac.getContext().getCacheDir(), c.GG("ãçÜºÈ­Üòù")))));
            try {
                dataOutputStream.writeLong(this.oSy);
                dataOutputStream.writeLong(this.oSz);
                dataOutputStream.writeLong(this.oSA);
                bh.d(dataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to save rec.", new Object[0]);
                    bh.d(dataOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    bh.d(dataOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            bh.d(dataOutputStream);
            throw th;
        }
    }

    private synchronized void f(int i, View view) {
        if (view != null && i == 16) {
            synchronized (this) {
                if (this.oSB != 0) {
                    if ((view instanceof Button) && view.getId() == this.oSB) {
                        this.oSA++;
                        bfO();
                    }
                }
            }
        }
    }

    private synchronized void n(int i, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.oSy > 86400000) {
            com.tencent.mm.plugin.report.service.g.pQN.c("Normsg_AED", "action: " + i + ", pkg: " + str + ", view: " + str2, null);
            this.oSy = currentTimeMillis;
            bfO();
        }
    }

    public final synchronized void g(Throwable th) {
        Closeable printWriter;
        Throwable th2;
        Closeable closeable = null;
        synchronized (this) {
            if (th != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.oSy > 86400000) {
                    Writer stringWriter = new StringWriter();
                    try {
                        printWriter = new PrintWriter(stringWriter);
                        try {
                            th.printStackTrace(printWriter);
                            bh.d(printWriter);
                        } catch (Throwable th3) {
                            Throwable th4 = th3;
                            closeable = printWriter;
                            th2 = th4;
                            bh.d(closeable);
                            throw th2;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        bh.d(closeable);
                        throw th2;
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.c("Normsg_AED_Errors", "error:" + stringWriter.toString(), null);
                    this.oSy = currentTimeMillis;
                    bfO();
                }
            }
        }
    }

    private static String uh(int i) {
        ActivityManager activityManager = (ActivityManager) ac.getContext().getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Throwable th) {
            x.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure on step1.", new Object[0]);
        }
        try {
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(16384);
            if (runningServices != null) {
                for (RunningServiceInfo runningServiceInfo : runningServices) {
                    if (runningServiceInfo.pid == i) {
                        return runningServiceInfo.process;
                    }
                }
            }
        } catch (Throwable th2) {
            Throwable th22;
            x.printErrStackTrace("MircoMsg.AEDHLP", th22, "[tomys] failure on step2.", new Object[0]);
        }
        Closeable closeable = null;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(String.format(Locale.ENGLISH, c.GG("ÃìîâÍè£À­É¥Ì¢Ç"), new Object[]{Integer.valueOf(i)})));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    readLine = readLine.trim();
                    bh.d(bufferedReader);
                    return readLine;
                }
                bh.d(bufferedReader);
                return "";
            } catch (Throwable th3) {
                th22 = th3;
                try {
                    x.printErrStackTrace("MircoMsg.AEDHLP", th22, "[tomys] failure on step3.", new Object[0]);
                    bh.d(bufferedReader);
                    return "";
                } catch (Throwable th4) {
                    th22 = th4;
                    closeable = bufferedReader;
                    bh.d(closeable);
                    throw th22;
                }
            }
        } catch (Throwable th5) {
            th22 = th5;
            bh.d(closeable);
            throw th22;
        }
    }

    public static String GI(String str) {
        int indexOf = str.indexOf(58);
        return indexOf != -1 ? str.substring(indexOf) : "";
    }
}
