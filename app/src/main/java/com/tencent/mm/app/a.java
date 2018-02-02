package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import android.util.Pair;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static String feA = "";
    private static int fem = 0;
    private static int fen = 0;
    private static p feo = new p((long) Process.myPid());
    private static final b fep = new b() {
        public final void c(a aVar) {
            int i = ac.getContext().getSharedPreferences("system_config_prefs", 4).getInt("main_thread_watch_report", 0);
            String str = "MicroMsg.ANRWatchDog.summeranr";
            String str2 = "summeranr onAppNotResponding error reportFlag[%b]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i > 0);
            x.w(str, str2, objArr);
            try {
                String b = a.a(aVar);
                if (i > 0) {
                    b.z(Base64.encodeToString(b.getBytes(), 2), "main_thread_watch");
                } else {
                    g.pQN.a(510, 14, 1, true);
                }
            } catch (OutOfMemoryError e) {
                x.e("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport OutOfMemory %s", e.getMessage());
                System.gc();
                g.pQN.a(510, 15, 1, true);
            }
        }
    };
    private static final d feq = new d() {
        public final void a(InterruptedException interruptedException) {
            x.w("MicroMsg.ANRWatchDog.summeranr", "summeranr DEFAULT_INTERRUPTION_LISTENER onInterrupted exception.getMessage[%s]", interruptedException.getMessage());
        }
    };
    private static b fer = fep;
    private static d fes = feq;
    private static Handler fet;
    private static int feu = 4500;
    private static int fev = 500;
    private static String few = "";
    private static boolean fex = true;
    private static boolean fey = false;
    private static Thread fez;

    static /* synthetic */ int em(int i) {
        int i2 = 0;
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        }
        int i3 = 1;
        int i4 = 3;
        int i5 = 1;
        while (i4 <= i) {
            i3 += i5;
            i4++;
            i2 = i3;
            int i6 = i5;
            i5 = i3;
            i3 = i6;
        }
        return i2;
    }

    static /* synthetic */ int tE() {
        int i = fen;
        fen = i + 1;
        return i;
    }

    private static boolean p(String str, int i) {
        if (bh.ov(str)) {
            return false;
        }
        if (str.equals(ac.getPackageName())) {
            fem = 1;
            if ((i & 1) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":push")) {
            fem = 2;
            if ((i & 2) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":tools")) {
            fem = 4;
            if ((i & 4) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":sandbox")) {
            fem = 8;
            if ((i & 8) != 0) {
                return true;
            }
            return false;
        } else if (str.endsWith(":exdevice")) {
            fem = 16;
            if ((i & 16) != 0) {
                return true;
            }
            return false;
        } else if (!str.contains(":appbrand")) {
            return false;
        } else {
            fem = 32;
            if ((i & 32) != 0) {
                return true;
            }
            return false;
        }
    }

    public static void cl(String str) {
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("system_config_prefs", 4);
        int i = sharedPreferences.getInt("main_thread_watch_enable", 65535);
        int i2 = sharedPreferences.getInt("main_thread_watch_timeout", 0);
        int i3 = sharedPreferences.getInt("main_thread_watch_log_loop", 0);
        int i4 = sharedPreferences.getInt("main_thread_watch_report", 0);
        if (p(str, i)) {
            if (i2 <= 0) {
                i2 = 4500;
            }
            if (i3 <= 0) {
                i3 = 500;
            }
            if (fez != null) {
                fez.interrupt();
            }
            feA = str;
            if (i2 > 0) {
                feu = i2;
            }
            if (i3 > 0) {
                fev = i3;
            }
            fez = e.b(new c(), str + "_ANRWatchDog");
            if (fet == null) {
                fet = new Handler(Looper.getMainLooper());
            }
            fez.start();
            x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch sProcessName[%s], sTimeoutInterval[%d], logLoop[%d], sWatchThread[%s], stack[%s]", feA, Integer.valueOf(feu), Integer.valueOf(fev), fez.getName(), bh.cgy());
        }
        x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch processName[%s] enable[%d], timeout[%d], loop[%d], report[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private static String a(a aVar) {
        String substring;
        JSONObject jSONObject = new JSONObject();
        try {
            int i;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("head", jSONObject2);
            jSONObject2.put("protocol_ver", new Integer(1));
            jSONObject2.put("phone", new String(Build.MODEL));
            jSONObject2.put("os_ver", new String("android-" + VERSION.SDK_INT));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject.put("items", jSONObject3);
            jSONObject3.put("tag", "main_thread_watch");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject4 = new JSONObject();
            jSONArray.put(jSONObject4);
            jSONObject3.put("info", jSONArray);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject4.put("traces", jSONObject5);
            Object obj = aVar.feB;
            if (!bh.cA(obj)) {
                Iterator it = obj.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    Thread thread = (Thread) pair.first;
                    StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) pair.second;
                    if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
                        String str = thread.getName() + " (prio:" + thread.getPriority() + " tid:" + thread.getId() + " state:" + thread.getState() + ")";
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                            if (stackTraceElement != null) {
                                jSONArray2.put(stackTraceElement.toString());
                            }
                        }
                        jSONObject5.put(str, jSONArray2);
                    }
                }
            }
            try {
                x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport CpuUsage [%d, %d, %d]", Integer.valueOf(feo.yC()), Integer.valueOf(feo.yD()), Integer.valueOf(feo.yB()));
                jSONObject4.put("cpu_usage_total", r0);
                jSONObject4.put("cpu_usage_pid", i);
                jSONObject4.put("cpu_count", r2);
                ActivityManager activityManager = (ActivityManager) ac.getContext().getSystemService("activity");
                MemoryInfo memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long j = 0;
                if (d.fM(16)) {
                    j = memoryInfo.totalMem;
                } else {
                    RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        char[] toCharArray = randomAccessFile.readLine().toCharArray();
                        int length = toCharArray.length;
                        i = 0;
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
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e, "summeranr", new Object[0]);
                    } finally {
                        randomAccessFile.close();
                    }
                }
                x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport MemoryInfo[%d, %d, %d, %b]", Long.valueOf(j), Long.valueOf(memoryInfo.availMem), Long.valueOf(memoryInfo.threshold), Boolean.valueOf(memoryInfo.lowMemory));
                jSONObject4.put("mem_sys_total", j);
                jSONObject4.put("mem_sys_avail", memoryInfo.availMem);
                jSONObject4.put("mem_sys_threshold", memoryInfo.threshold);
                jSONObject4.put("mem_sys_low", memoryInfo.lowMemory);
                jSONObject4.put("mem_native_heap_size", Debug.getNativeHeapSize());
                jSONObject4.put("mem_native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
                jSONObject4.put("mem_native_heap_free_size", Debug.getNativeHeapFreeSize());
                Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
                if (!(processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null)) {
                    Debug.MemoryInfo memoryInfo2 = processMemoryInfo[0];
                    jSONObject4.put("mem_private_dirty", memoryInfo2.getTotalPrivateDirty() << 10);
                    jSONObject4.put("mem_shared_dirty", memoryInfo2.getTotalSharedDirty() << 10);
                    jSONObject4.put("mem_pss", memoryInfo2.getTotalPss() << 10);
                }
                if (fem == 1 && ar.Hj() && com.tencent.mm.kernel.g.Dh().gPy) {
                    com.tencent.mm.storage.w.a[] aVarArr = new com.tencent.mm.storage.w.a[]{com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG, com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG};
                    i = 0;
                    String str2 = "";
                    while (i < 7) {
                        com.tencent.mm.storage.w.a aVar2 = aVarArr[i];
                        StringBuilder append = new StringBuilder().append(str2);
                        ar.Hg();
                        i++;
                        str2 = append.append(c.CU().get(aVar2, Long.valueOf(0))).append(":").toString();
                    }
                    x.i("MicroMsg.ANRWatchDog.summeranr", "summeranr sProcessName[%s] storage_usage[%s]", feA, str2);
                    jSONObject4.put("storage_usage", str2);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e2, "summeranr buildReport storage_usage:", new Object[0]);
                g.pQN.a(510, 9, 1, true);
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e22, "summeranr buildReport JSONException:", new Object[0]);
                g.pQN.a(510, 10, 1, true);
            }
            jSONObject4.put("time", new Integer(feu));
            int i2 = 0;
            if (new File(w.gZK).exists()) {
                i2 = ac.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0);
            }
            jSONObject3.put(OpenSDKTool4Assistant.EXTRA_UIN, new Long((long) i2));
            jSONObject3.put("process_name", feA);
            jSONObject3.put("time", new Long(System.currentTimeMillis()));
            jSONObject3.put("cver", new Integer(com.tencent.mm.protocal.d.vAz));
            jSONObject3.put("revision", BaseBuildInfo.codeRevision());
            g.pQN.a(510, 8, 1, true);
        } catch (Throwable e222) {
            x.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e222, "summeranr buildReport JSONException:", new Object[0]);
            g.pQN.a(510, 10, 1, true);
        } catch (Throwable e2222) {
            x.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e2222, "summeranr buildReport Exception:", new Object[0]);
            g.pQN.a(510, 11, 1, true);
        }
        String jSONObject6 = jSONObject.toString();
        String str3 = "MicroMsg.ANRWatchDog.summeranr";
        String str4 = "summeranr buildReport packer len[%d][%d][%s]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(jSONObject.length());
        objArr[1] = Integer.valueOf(jSONObject6.length());
        if (jSONObject6.length() > 51200) {
            substring = jSONObject6.substring(0, 51200);
        } else {
            substring = jSONObject6;
        }
        objArr[2] = substring;
        x.i(str3, str4, objArr);
        return jSONObject6;
    }
}
