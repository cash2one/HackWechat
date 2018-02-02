package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class t {
    static byte[] AbB = null;
    private static boolean Abw = true;
    static t Aby = null;
    static File Abz = null;
    static String ibD = null;
    private SimpleDateFormat AbA = null;
    private StringBuffer AbC = new StringBuffer();
    TextView Qh;
    private Context mContext = null;

    public t(Context context) {
        try {
            this.mContext = context.getApplicationContext();
            this.AbA = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception e) {
            this.AbA = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    public static void setWriteLogJIT(boolean z) {
        Abw = z;
    }

    public void abr(String str) {
        if (this.Qh != null) {
            this.Qh.post(new a(this, str));
        }
    }

    public void bu(String str) {
        try {
            this.AbC.append(this.AbA.format(Long.valueOf(System.currentTimeMillis()))).append(" pid=").append(Process.myPid()).append(" tid=").append(Process.myTid()).append(str).append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || Abw) {
                writeLogToDisk();
            }
            if (this.AbC.length() > SQLiteGlobal.journalSizeLimit) {
                this.AbC.delete(0, this.AbC.length());
            }
        } catch (Exception e) {
        }
    }

    public void setLogView(TextView textView) {
        this.Qh = textView;
    }

    public void writeLogToDisk() {
        try {
            if (Abz == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    String ar = f.ar(this.mContext, 6);
                    if (ar == null) {
                        Abz = null;
                    } else {
                        Abz = new File(ar, "tbslog.txt");
                        ibD = h.cFt();
                        AbB = h.ga(Abz.getName(), ibD);
                    }
                } else {
                    Abz = null;
                }
            }
        } catch (SecurityException e) {
        } catch (NullPointerException e2) {
        }
        try {
            if (Abz != null) {
                h.a(Abz, ibD, AbB, this.AbC.toString());
                this.AbC.delete(0, this.AbC.length());
            }
        } catch (Exception e3) {
        }
    }
}
