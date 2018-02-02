package com.tencent.mm.z.d;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mm.a.o;
import com.tencent.mm.az.m;
import com.tencent.mm.az.r;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.aq;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class a implements com.tencent.mm.z.d.c.a {
    private static final String ffq;
    private static final String ffr;
    public static String ffs = "";
    private static a hiF;
    private static final String hiG = (e.bnD + "/tencent/MicroMsg/Handler/");
    public static final String hiH = (hiG + "Handler.trace");
    private static final long hiK = Looper.getMainLooper().getThread().getId();
    private static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    long[] ffu;
    private SharedPreferences gZO;
    private long hiI;
    private volatile boolean hiJ;
    private long hiL;
    private long hiM;
    private long hiN;
    private long hiO;
    private long hiP;
    private long hiQ;
    private long hiR;
    private int hiS;
    private int hiT;
    private int hiU;
    private Long[] hiV;
    public long hiW;
    private String hiX;
    private LinkedList<a> hiY;

    static class a implements Comparable<a> {
        long hjb;
        String info;

        a() {
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (((a) obj).hjb - this.hjb);
        }
    }

    static /* synthetic */ void a(a aVar, String str, String str2) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        if (f.ze()) {
            File file;
            try {
                file = new File(hiG);
                if (!file.exists()) {
                    file.mkdirs();
                }
                aVar.a(new File(hiG, "Handler.trace"), false);
            } catch (Exception e2) {
            }
            file = new File(str);
            if (file.length() > aVar.hiO) {
                x.e("MicroMsg.HandlerTraceManager", "summer log file invaild foramt, recreate");
                aVar.a(file, true);
            }
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write(com.tencent.mm.ca.e.bz(str2.getBytes()));
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                    }
                } catch (IOException e4) {
                    e = e4;
                    try {
                        x.printErrStackTrace("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        aVar.l(new File(hiH));
                        return;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e7) {
                e = e7;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                aVar.l(new File(hiH));
                return;
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e;
            }
            aVar.l(new File(hiH));
            return;
        }
        x.i("MicroMsg.HandlerTraceManager", "summer sdcard is not Available, appendToFile fail ");
    }

    static {
        String yF = q.yF();
        ffq = yF;
        ffr = o.getString(yF.hashCode());
    }

    private a() {
        this.ffu = new long[]{0, 0, 0};
        this.hiI = 0;
        this.hiJ = false;
        this.hiL = 8000;
        this.hiM = 800;
        this.hiN = 25600;
        this.hiO = 35840;
        this.hiP = 86400000;
        this.hiQ = 180000;
        this.hiR = 5000;
        this.hiS = 120;
        this.hiT = 50;
        this.hiU = 1800000;
        this.gZO = ac.cft();
        this.hiV = new Long[18];
        this.hiW = 0;
        this.hiX = "";
        this.hiY = new LinkedList();
        this.hiL = this.gZO.getLong("handler_debug_log_time", 8000);
        this.hiM = this.gZO.getLong("handler_debug_log_time_main", 800);
        this.hiN = this.gZO.getLong("handler_trace_file_full_size", 25600);
        this.hiO = this.gZO.getLong("handler_log_file_max_size", 35840);
        this.hiP = this.gZO.getLong("handler_upload_time_interval", 86400000);
        Arrays.fill(this.hiV, Long.valueOf(0));
    }

    public static a II() {
        if (hiF == null) {
            synchronized (a.class) {
                if (hiF == null) {
                    hiF = new a();
                }
            }
        }
        return hiF;
    }

    private void l(File file) {
        boolean z = true;
        if (file.exists()) {
            this.hiJ = file.length() > this.hiN;
            if (this.hiJ) {
                long j = this.gZO.getLong("handler_trace_log_file_full_time", 0);
                String str = "MicroMsg.HandlerTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (j == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                if (j == 0) {
                    this.gZO.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
                    return;
                }
                return;
            }
            return;
        }
        this.hiJ = false;
    }

    final String IJ() {
        String format;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("#client.version=" + d.vAz);
        printStream.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
        printStream.println("#accinfo.uin=" + aq.hfP.H("last_login_uin", ffr));
        printStream.println("#accinfo.dev=" + ffq);
        printStream.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.f.fdS);
        String str = "";
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.bnD);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) ac.getContext().getSystemService("activity")).getMemoryClass()), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), e.bnD, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            x.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", e.getMessage());
            format = str;
        }
        printStream.println("#accinfo.data=" + format);
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        printStream.println("#logfile.fulllast :" + (this.gZO.getLong("handler_trace_log_file_full_time", 0) - this.gZO.getLong("handler_trace_log_file_create_time", 0)));
        if (this.ffu[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.ffu[0] + " data size=" + this.ffu[1] + " code size=" + this.ffu[2]);
        }
        m[] ik = r.QH().ik(21);
        if (ik == null || ik.length == 0 || ik[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + ik[0].id + " version=" + ik[0].version);
        }
        printStream.println("#handler.content:");
        format = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        return format;
    }

    private static String ip(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str2 = new String(com.tencent.mm.ca.e.bz(bArr));
                try {
                    fileInputStream2.close();
                    return str2;
                } catch (Exception e) {
                    return str2;
                }
            } catch (IOException e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    private void a(File file, boolean z) {
        x.i("MicroMsg.HandlerTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            l(file);
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            x.e("MicroMsg.HandlerTraceManager", "recreate log file fail");
        }
        Editor edit = this.gZO.edit();
        edit.putLong("handler_trace_log_file_create_time", System.currentTimeMillis());
        edit.putLong("handler_trace_log_file_full_time", 0).commit();
        l(file);
    }

    public final void IK() {
        x.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
        this.hiL = this.gZO.getLong("handler_debug_log_time", 8000);
        this.hiM = this.gZO.getLong("handler_debug_log_time_main", 800);
        this.hiN = this.gZO.getLong("handler_trace_file_full_size", 25600);
        this.hiO = this.gZO.getLong("handler_log_file_max_size", 35840);
        this.hiP = this.gZO.getLong("handler_upload_time_interval", 86400000);
        this.hiQ = this.gZO.getLong("handler_worker_assert_time", 180000);
        this.hiR = this.gZO.getLong("handler_worker_warn_time", 5000);
        this.hiS = (int) this.gZO.getLong("handler_worker_warn_task_max_size", 120);
        this.hiT = (int) this.gZO.getLong("handler_worker_warn_task_keep_size", 50);
        this.hiU = (int) this.gZO.getLong("handler_worker_warn_task_keep_size", 1800000);
        l(new File(hiH));
    }
}
