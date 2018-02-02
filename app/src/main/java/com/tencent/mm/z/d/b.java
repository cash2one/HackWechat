package com.tencent.mm.z.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.tencent.mm.a.o;
import com.tencent.mm.az.m;
import com.tencent.mm.az.r;
import com.tencent.mm.by.h;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.d.c.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class b implements a {
    private static final String ffq;
    private static final String ffr;
    private static b hjc;
    public static final String hjd = (e.bnD + "/tencent/MicroMsg/SQLTrace/");
    public static List<String> hjm = Arrays.asList(new String[]{"FTS5IndexMicroMsg.db"});
    long[] ffu = new long[]{0, 0, 0};
    private SharedPreferences gZO = ac.cft();
    private long hiI = 0;
    public volatile boolean hiJ = false;
    public long hje;
    public long hjf;
    public long hjg;
    public long hjh;
    long hji;
    private long hjj;
    private long hjk;
    private long hjl;

    static {
        String yF = q.yF();
        ffq = yF;
        ffr = o.getString(yF.hashCode());
    }

    public static b IP() {
        if (hjc == null) {
            hjc = new b();
        }
        return hjc;
    }

    public b() {
        IQ();
    }

    private void IQ() {
        this.hje = this.gZO.getLong("sql_trace_main_thread_select_interval_time", 300);
        this.hjf = this.gZO.getLong("sql_trace_main_thread_update_interval_time", 500);
        this.hjg = this.gZO.getLong("sql_trace_child_thread_interval_time", 1500);
        long bd = bd(ac.getContext());
        if (bd > 0) {
            this.hje += bd;
            this.hjf += bd;
            this.hjg += bd;
            x.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", Long.valueOf(bd));
        }
        this.hjh = this.gZO.getLong("sql_trace_child_transaction_interval_time", 5000);
        this.hjl = this.gZO.getLong("sql_trace_file_full_size", 30720);
        this.hji = this.gZO.getLong("sql_trace_log_file_max_size", 35840);
        this.hjj = this.gZO.getLong("sql_trace_upload_file_min_size", 10240);
        this.hjk = this.gZO.getLong("sql_upload_time_interval", 21600000);
        l(new File(hjd, "MMSQL.trace"));
        x.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", Long.valueOf(this.hje), Long.valueOf(this.hjf), Long.valueOf(this.hjg), Long.valueOf(this.hjh), Long.valueOf(this.hjl), Long.valueOf(this.hji), Long.valueOf(this.hjj), Long.valueOf(this.hjk));
    }

    public static void setup() {
        if (ac.xft) {
            x.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: " + com.tencent.mm.loader.stub.b.deleteFile(hjd + "MMSQL.trace"));
        }
    }

    void l(File file) {
        boolean z = true;
        if (file.exists()) {
            this.hiJ = file.length() > this.hjl;
            if (this.hiJ) {
                long bc = bc(ac.getContext());
                String str = "MicroMsg.SQLTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (bc == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                if (bc == 0) {
                    d(ac.getContext(), System.currentTimeMillis());
                    return;
                }
                return;
            }
            return;
        }
        this.hiJ = false;
    }

    public static String ip(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable e;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str2 = new String(com.tencent.mm.ca.e.bz(bArr));
                try {
                    fileInputStream.close();
                    return str2;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SQLTraceManager", e2, "", new Object[0]);
                    return str2;
                }
            } catch (IOException e3) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable e4) {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e4, "", new Object[0]);
                    }
                }
                return null;
            } catch (Throwable th) {
                e4 = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e22, "", new Object[0]);
                    }
                }
                throw e4;
            }
        } catch (IOException e5) {
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return null;
        } catch (Throwable th2) {
            e4 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e4;
        }
    }

    private static long a(String str, h hVar) {
        Cursor a = hVar.a("select count(*) from " + str, null, 2);
        long j = 0;
        if (a.moveToFirst()) {
            j = a.getLong(0);
        }
        a.close();
        return j;
    }

    private String IJ() {
        String format;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("#client.version=" + d.vAz);
        printStream.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
        printStream.println("#accinfo.uin=" + aq.hfP.H("last_login_uin", ffr));
        printStream.println("#accinfo.dev=" + ffq);
        printStream.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + f.fdS);
        String str = "";
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.h.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.bnD);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) ac.getContext().getSystemService("activity")).getMemoryClass()), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), e.bnD, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            x.e("MicroMsg.SQLTraceManager", "check data size failed :%s", e.getMessage());
            format = str;
        }
        printStream.println("#accinfo.data=" + format);
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        long bd = bd(ac.getContext());
        if (bd > 0) {
            printStream.println("#logfile.autoAdapteTime :" + bd);
        }
        if (bc(ac.getContext()) != 0) {
            long bc = bc(ac.getContext()) - bb(ac.getContext());
            printStream.println("#logfile.fulllast :" + bc);
            if (bc > 0 && bc < 28800000) {
                PreferenceManager.getDefaultSharedPreferences(ac.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", bd + 100).commit();
                x.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", Long.valueOf(bd));
                IQ();
            }
        } else {
            printStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - bb(ac.getContext())));
        }
        m[] ik = r.QH().ik(21);
        if (ik == null || ik.length == 0 || ik[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + ik[0].id + " version=" + ik[0].version);
        }
        if (this.ffu[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.ffu[0] + " data size= " + this.ffu[1] + " code size =" + this.ffu[2]);
        }
        StringBuilder stringBuilder = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        ar.Hg();
        printStream.println(stringBuilder.append(new File(c.CS()).length()).toString());
        stringBuilder = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        StringBuilder stringBuilder2 = new StringBuilder();
        ar.Hg();
        printStream.println(stringBuilder.append(new File(stringBuilder2.append(c.FB()).append("SnsMicroMsg.db").toString()).length()).toString());
        ar.Hg();
        a(c.EW(), printStream, Arrays.asList(new String[]{"message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo"}));
        printStream.println("#sql.content:");
        format = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        return format;
    }

    private static void a(h hVar, PrintStream printStream, List<String> list) {
        if (hVar == null || !hVar.isOpen()) {
            x.i("MicroMsg.SQLTraceManager", "db is not open!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            Cursor a = hVar.a("select name from sqlite_master where type='table' ", null, 2);
            while (a.moveToNext()) {
                String string = a.getString(0);
                printStream.println("#table : " + string + " count=" + a(string, hVar));
            }
            a.close();
        } else {
            for (String str : list) {
                printStream.println("#table : " + str + " count=" + a(str, hVar));
            }
        }
        x.i("MicroMsg.SQLTraceManager", "dump all table count last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void a(String str, String str2, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(":").append(str2).append(" ");
    }

    public final void ir(String str) {
        if (str == null) {
            str = "";
        }
        Intent intent = new Intent();
        intent.setClassName(ac.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionPid", Process.myPid());
        String str2 = "userName";
        String H = aq.hfP.H("login_weixin_username", "");
        if (bh.ov(H)) {
            H = aq.hfP.H("login_user_name", "never_login_crash");
        }
        intent.putExtra(str2, H);
        intent.putExtra("tag", "SqlTrace");
        intent.putExtra("exceptionMsg", Base64.encodeToString((IJ() + str).getBytes(), 2));
        ac.getContext().startService(intent);
    }

    void a(File file, boolean z) {
        x.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            l(file);
        }
        try {
            file.createNewFile();
            Context context = ac.getContext();
            PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_create_time", System.currentTimeMillis()).commit();
            d(ac.getContext(), 0);
        } catch (IOException e) {
            x.e("MicroMsg.SQLTraceManager", "recreate log file fail");
        }
        l(file);
    }

    public static void c(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_report_lastUploadTime", j).commit();
    }

    public static long ba(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_report_lastUploadTime", 0);
    }

    private static long bb(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_create_time", 0);
    }

    private static void d(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_full_time", j).commit();
    }

    private static long bc(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_full_time", 0);
    }

    private static long bd(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_autoAdaptaTime", 0);
    }

    public final void IK() {
        x.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
        IQ();
    }
}
