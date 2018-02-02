package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.d.y;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q$u;
import com.tencent.mm.pluginsdk.q.x;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.a.c;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.by;
import com.tencent.recovery.Recovery;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.xweb.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.AssertionFailedError;

public class i implements c, d {
    public static final long ffi = bh.Wp();
    private static final String ffq;
    private static final String ffr;
    private static String ffs = "";
    private static final String fft = ("version:" + com.tencent.mm.protocal.d.vAz);
    private static long[] ffu = new long[]{0, 0, 0};
    private aj ffj = null;
    private a ffk;
    private volatile long ffl = 0;
    HashSet<String> ffm;
    String ffn;
    String ffo;
    ConditionVariable ffp;
    volatile b ffv;

    static {
        String yF = q.yF();
        ffq = yF;
        ffr = o.getString(yF.hashCode());
    }

    private static String tT() {
        String H = aq.hfP.H("login_weixin_username", "");
        if (bh.ov(H)) {
            return aq.hfP.H("login_user_name", "never_login_crash");
        }
        return H;
    }

    public static boolean cq(String str) {
        Object obj = null;
        ffs = str;
        if (x.bYd() == null) {
            Object cls;
            try {
                cls = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "setup sanbox Failed printing stack trace1.", new Object[0]);
                cls = obj;
            }
            try {
                obj = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, ac.getContext().getClassLoader());
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "setup sanbox Failed printing stack trace2.", new Object[0]);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + cls + " thisProcName: " + ffs);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + obj + " thisProcName: " + ffs);
            Class fk = com.tencent.mm.bm.d.fk("sandbox", ".SubCoreSandBox");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + fk + " thisProcName: " + ffs);
            if (fk != null) {
                try {
                    q$u com_tencent_mm_pluginsdk_q_u = (q$u) fk.newInstance();
                    x.a(com_tencent_mm_pluginsdk_q_u);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + com_tencent_mm_pluginsdk_q_u + " thisProcName: " + ffs);
                } catch (Throwable e3) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "", new Object[0]);
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", e3.getClass().getSimpleName(), e3.getMessage());
                }
            }
        }
        c cVar;
        try {
            cVar = (c) Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
            cVar.ap(ac.getContext());
            aq.hfP.H("last_login_uin", ffr);
            b.a(cVar);
            AnonymousClass1 anonymousClass1 = new Object() {
            };
            return true;
        } catch (Exception e4) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
            cVar = new i();
            cVar.ap(ac.getContext());
            b.a(cVar);
            String str2 = y.get("ro.product.cpu.abi");
            if (str2 == null || str2.length() == 0 || !(str2.equals("x86") || str2.equals("x86-64"))) {
                k.b("wechatCrashForJni", i.class.getClassLoader());
                CrashMonitorForJni.setClientVersionMsg(fft);
            }
            by.ic(e.gZK);
            return false;
        }
    }

    public static void a(aj.c cVar) {
        aj.a(cVar);
    }

    private static void cr(String str) {
        while (str.length() > 896) {
            try {
                int lastIndexOf = str.substring(0, 896).lastIndexOf("\n");
                if (-1 == lastIndexOf) {
                    break;
                }
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMCrashReporter", str.substring(0, lastIndexOf));
                str = str.substring(lastIndexOf + 1);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed printing stack trace.", new Object[0]);
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMCrashReporter", str);
    }

    public final void ap(Context context) {
        Throwable e;
        BufferedReader bufferedReader;
        aj.a((d) this);
        if (ffs.endsWith(":push")) {
            String str;
            try {
                str = y.get("dalvik.vm.stack-trace-file");
                if (str == null || str.length() == 0) {
                    str = "/data/anr/traces.txt";
                }
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed finding out ANR trace file path, using default.", new Object[0]);
                str = "/data/anr/traces.txt";
            }
            File file = new File(str);
            this.ffn = file.getParent();
            if (this.ffn == null || this.ffn.length() == 0) {
                this.ffn = "/";
            }
            this.ffo = file.getName();
            this.ffp = new ConditionVariable();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: " + str);
            this.ffm = new HashSet();
            this.ffk = new a(this, this.ffn);
            this.ffk.startWatching();
            File[] listFiles = new File(context.getFilesDir(), "crash").listFiles(new 2(this, context));
            if (listFiles != null) {
                StringBuilder stringBuilder = new StringBuilder(16384);
                Pattern compile = Pattern.compile("^signal (\\d+) \\([A-Z]+\\), code ");
                for (File file2 : listFiles) {
                    int i = -1;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCrashReporter", "Uploading previous crash: " + file2);
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file2));
                        try {
                            stringBuilder.setLength(0);
                            while (true) {
                                Object readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (i < 0) {
                                    Matcher matcher = compile.matcher(readLine);
                                    if (matcher.matches()) {
                                        i = bh.getInt(matcher.group(1), 0);
                                    }
                                }
                                stringBuilder.append(readLine).append('\n');
                            }
                            if (stringBuilder.toString().startsWith(fft)) {
                                String substring = stringBuilder.toString().substring(stringBuilder.toString().indexOf(fft) + fft.length());
                                if (substring != null && substring.trim().length() > 0) {
                                    b(i, substring, true);
                                }
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                            }
                        } catch (IOException e4) {
                            e2 = e4;
                            try {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed uploading previous crash: " + file2, new Object[0]);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                file2.delete();
                            } catch (Throwable th) {
                                e2 = th;
                            }
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        bufferedReader = null;
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed uploading previous crash: " + file2, new Object[0]);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        file2.delete();
                    } catch (Throwable th2) {
                        e2 = th2;
                        bufferedReader = null;
                    }
                    file2.delete();
                }
                return;
            }
            return;
        }
        return;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e7) {
            }
        }
        throw e2;
        throw e2;
    }

    public final void z(String str, String str2) {
        if (x.bYd() != null) {
            Intent intent = new Intent();
            intent.setAction("custom_exception");
            intent.putExtra("userName", tT());
            intent.putExtra("tag", str2);
            intent.putExtra("exceptionMsg", str);
            x.bYd().r(ac.getContext(), intent);
        }
    }

    public final void a(a aVar) {
        aj.a(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(aj ajVar, String str, Throwable th) {
        String IO;
        String str2 = "";
        if (th instanceof AssertionFailedError) {
            Object message = th.getMessage();
            if (!bh.ov(message)) {
                Iterator it = ajVar.xfL.entrySet().iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        String str3 = (String) entry.getKey();
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(message) && message.startsWith(str3)) {
                            IO = ((aj.b) entry.getValue()).IO();
                            break;
                        }
                    }
                }
                IO = "";
            }
        }
        IO = str2;
        n.b(th);
        b(cs(IO) + str, 0, false);
    }

    private static void b(String str, int i, boolean z) {
        cr(str);
        g.pQN.a(11338, true, true, Integer.valueOf(2));
        g.pQN.a(25, 0, 1, true);
        if (ac.Br().endsWith(":push")) {
            g.pQN.a(25, 2, 1, true);
        } else if (ac.Br().endsWith(":tools")) {
            g.pQN.a(25, 3, 1, true);
        } else if (ac.Br().endsWith(":exdevice")) {
            g.pQN.a(25, 4, 1, true);
        } else if (ac.cfw()) {
            g.pQN.a(25, 1, 1, true);
        }
        g gVar = g.pQN;
        g.bon();
        if (e.an(ac.getContext()) == 1) {
            int ao = e.ao(ac.getContext());
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCrashReporter", "google play crash size limit %s", Integer.valueOf(ao));
            if (str.length() > ao) {
                str = str.substring(0, ao);
            }
        }
        e.e(ac.getContext(), ac.Br(), z ? "jni" : "java");
        if (i > 0 && str.length() > i) {
            str = str.substring(0, i);
        }
        if (x.bYd() != null) {
            Intent intent = new Intent();
            intent.setAction("uncatch_exception");
            intent.putExtra("exceptionPid", Process.myPid());
            intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
            intent.putExtra("userName", tT());
            intent.putExtra("exceptionMsg", Base64.encodeToString(str.getBytes(), 2));
            x.bYd().r(ac.getContext(), intent);
        }
    }

    public final void l(int i, String str) {
        b(i, str, false);
    }

    private static void b(int i, String str, boolean z) {
        String str2 = null;
        if (i == 6) {
            try {
                String tU = tU();
                if (tU != null) {
                    str2 = a(tU, Process.myPid(), System.currentTimeMillis(), null);
                }
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed reporting JNI crash.", new Object[0]);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        stringBuilder.append("#[jin_crash]sig=").append(i).append('\n');
        stringBuilder.append("#crash.previous=").append(z).append('\n');
        stringBuilder.append(cs(""));
        stringBuilder.append(str).append('\n');
        if (str2 != null) {
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str2);
        }
        b(stringBuilder.toString(), i == 6 ? 0 : 8192, true);
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMCrashReporter", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        if (!z) {
            com.tencent.mm.sdk.platformtools.x.appenderClose();
        }
    }

    private static String tU() {
        String str;
        try {
            str = y.get("dalvik.vm.stack-trace-file");
            if (str == null || str.length() == 0) {
                str = "/data/anr/traces.txt";
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed finding out ANR trace file path, using default.", new Object[0]);
            str = "/data/anr/traces.txt";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            String Br = ac.Br();
            if (Br == null || Br.length() == 0) {
                Br = "com.tencent.mm";
            }
            Br = str.substring(0, lastIndexOf) + '_' + Br + str.substring(lastIndexOf);
            if (new File(Br).isFile()) {
                return Br;
            }
        }
        return !new File(str).isFile() ? null : str;
    }

    static String a(String str, int i, long j, ProcessErrorStateInfo processErrorStateInfo) {
        Throwable e;
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder(Downloads.RECV_BUFFER_SIZE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str2 = "----- pid " + i + " at ";
        if (processErrorStateInfo != null) {
            stringBuilder.append(processErrorStateInfo.longMsg).append('\n');
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    switch (obj) {
                        case null:
                            if (!readLine.startsWith(str2)) {
                                break;
                            }
                            int length = str2.length();
                            long time = simpleDateFormat.parse(readLine.substring(length, length + 19)).getTime() - j;
                            if (time >= -60000 && time <= 60000) {
                                obj = 1;
                                break;
                            }
                        case 1:
                            stringBuilder.append(readLine).append('\n');
                            if (!readLine.startsWith("DALVIK THREADS")) {
                                if (!readLine.startsWith("-----")) {
                                    break;
                                }
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                }
                                return null;
                            }
                            obj = 2;
                            break;
                        case 2:
                            try {
                                if (!readLine.startsWith("----- end ")) {
                                    stringBuilder.append(readLine).append('\n');
                                    break;
                                }
                                String stringBuilder2 = stringBuilder.toString();
                                try {
                                    bufferedReader.close();
                                    return stringBuilder2;
                                } catch (IOException e3) {
                                    return stringBuilder2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                break;
                            }
                        default:
                            break;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            try {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed parsing ANR trace file.", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                    }
                }
                return null;
            } catch (Throwable th) {
                e = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    final void r(String str, int i) {
        Recovery.cDd();
        g.pQN.a(11339, true, true, Integer.valueOf(5000), Integer.valueOf(0));
        g.pQN.a(26, 0, 1, true);
        cr(str);
        g gVar = g.pQN;
        g.bon();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ffl >= 120000) {
            this.ffl = currentTimeMillis;
            e.e(ac.getContext(), ac.Br(), "anr");
            StringBuilder stringBuilder = new StringBuilder(Downloads.RECV_BUFFER_SIZE);
            stringBuilder.append(cs(""));
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str);
            if (x.bYd() != null) {
                Intent intent = new Intent();
                intent.setAction("uncatch_exception");
                intent.putExtra("tag", "anr");
                intent.putExtra("exceptionPid", i);
                intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
                intent.putExtra("userName", aq.hfP.H("login_user_name", "never_login_crash"));
                intent.putExtra("exceptionMsg", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                x.bYd().r(ac.getContext(), intent);
            }
        }
    }

    private static String cs(String str) {
        String crashExtraMessage;
        RandomAccessFile randomAccessFile;
        Throwable e;
        int[] iArr;
        MemoryInfo[] processMemoryInfo;
        StringBuilder stringBuilder = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ac.getContext();
        stringBuilderPrinter.println("#client.version=" + com.tencent.mm.protocal.d.vAz);
        stringBuilderPrinter.println("#client.verhistory=" + by.Ig());
        stringBuilderPrinter.println("#client.imei=" + q.yE());
        stringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
        stringBuilderPrinter.println("#accinfo.uin=" + aq.hfP.H("last_login_uin", ffr));
        stringBuilderPrinter.println("#accinfo.dev=" + ffq);
        stringBuilderPrinter.println("#accinfo.runtime=" + (bh.Wp() - ffi) + "(" + bh.ou(ffs) + ")");
        stringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + f.fdS);
        stringBuilderPrinter.println("#qbrwoser.corever=" + WebView.getTbsCoreVersion(context));
        stringBuilderPrinter.println("#qbrowser.ver=" + WebView.getTbsSDKVersion(context));
        stringBuilderPrinter.println("#qbmin.ver=" + com.tencent.xweb.x5.sdk.d.getMiniQBVersion(context));
        if (ffs.contains(":tools") || ffs.contains(":appbrand")) {
            crashExtraMessage = WebView.getCrashExtraMessage(context);
            if (crashExtraMessage != null && crashExtraMessage.length() > 0) {
                if (crashExtraMessage.length() > 8192) {
                    crashExtraMessage = crashExtraMessage.substring(crashExtraMessage.length() - 8192);
                }
                stringBuilderPrinter.println("#qbrowser.crashmsg=" + Base64.encodeToString(crashExtraMessage.getBytes(), 2));
                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.MMCrashReporter", "header #qbrowser.crashmsg=%s", crashExtraMessage);
            }
        }
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + b.xdY);
        String str2 = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.bnD);
            int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
            int largeMemoryClass = ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass();
            Context context2 = ac.getContext();
            String packageName = ac.getContext().getPackageName();
            synchronized (ffu) {
                try {
                    PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context2.getPackageManager(), new Object[]{packageName, new Stub() {
                        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                            if (packageStats != null) {
                                try {
                                    i.ffu[0] = packageStats.cacheSize;
                                    i.ffu[1] = packageStats.dataSize;
                                    i.ffu[2] = packageStats.codeSize;
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCrashReporter", "onGetStatsCompleted succeeded[%b] cacheSize :%d ,dataSize :%d ,codeSize :%d ", Boolean.valueOf(z), Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                } catch (Throwable th) {
                                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", th, "onGetStatsCompleted", new Object[0]);
                                    return;
                                }
                            }
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCrashReporter", "onGetStatsCompleted pStats is null succeeded[%b]", Boolean.valueOf(z));
                            synchronized (i.ffu) {
                                i.ffu.notify();
                            }
                        }
                    }});
                    ffu.wait(500);
                } catch (Throwable e2) {
                    Throwable e22;
                    ffu[0] = -1;
                    ffu[1] = -1;
                    ffu[2] = -1;
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e22, "crash e:", new Object[0]);
                    synchronized (ffu) {
                        ffu.notify();
                    }
                }
            }
            crashExtraMessage = String.format("%dMB %dMB %s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), Long.valueOf(ffu[0]), Long.valueOf(ffu[1]), Long.valueOf(ffu[2]), e.bnD, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e3) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMCrashReporter", "check data size failed :%s", e3.getMessage());
            crashExtraMessage = str2;
        }
        stringBuilderPrinter.println("#accinfo.data=" + crashExtraMessage);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        String str3 = "";
        ActivityManager activityManager = (ActivityManager) ac.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j = 0;
        if (com.tencent.mm.compatible.util.d.fM(16)) {
            j = memoryInfo.totalMem;
        } else {
            try {
                randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    char[] toCharArray = randomAccessFile.readLine().toCharArray();
                    int length = toCharArray.length;
                    int i = 0;
                    while (i < length) {
                        if (toCharArray[i] <= '9' && toCharArray[i] >= '0') {
                            stringBuffer.append(toCharArray[i]);
                        }
                        i++;
                    }
                    long j2 = bh.getLong(stringBuffer.toString(), -1);
                    if (j2 > 0) {
                        j = j2 << 10;
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Exception e4) {
                    }
                } catch (Exception e5) {
                    e = e5;
                    try {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e6) {
                            }
                        }
                        str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
                        iArr = new int[]{Process.myPid()};
                        processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                        if (processMemoryInfo != null) {
                        }
                        crashExtraMessage = str2;
                        stringBuilderPrinter.println("#accinfo.memory=" + crashExtraMessage);
                        if (!bh.ov(str)) {
                            stringBuilderPrinter.println("#" + str);
                        }
                        stringBuilderPrinter.println("#crashContent=");
                        return stringBuilder.toString();
                    } catch (Throwable th) {
                        e22 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e7) {
                            }
                        }
                        throw e22;
                    }
                }
            } catch (Exception e8) {
                e = e8;
                randomAccessFile = null;
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "", new Object[0]);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
                iArr = new int[]{Process.myPid()};
                processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                if (processMemoryInfo != null) {
                }
                crashExtraMessage = str2;
                stringBuilderPrinter.println("#accinfo.memory=" + crashExtraMessage);
                if (bh.ov(str)) {
                    stringBuilderPrinter.println("#" + str);
                }
                stringBuilderPrinter.println("#crashContent=");
                return stringBuilder.toString();
            } catch (Throwable th2) {
                e22 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e22;
            }
        }
        str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
        iArr = new int[]{Process.myPid()};
        processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
        if (processMemoryInfo != null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) {
            crashExtraMessage = str2;
        } else {
            MemoryInfo memoryInfo2 = processMemoryInfo[0];
            crashExtraMessage = str2 + "[pid(" + iArr[0] + "):" + (memoryInfo2.getTotalPss() << 10) + " " + (memoryInfo2.getTotalPrivateDirty() << 10) + " " + (memoryInfo2.getTotalSharedDirty() << 10) + "]";
        }
        stringBuilderPrinter.println("#accinfo.memory=" + crashExtraMessage);
        if (bh.ov(str)) {
            stringBuilderPrinter.println("#" + str);
        }
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }
}
