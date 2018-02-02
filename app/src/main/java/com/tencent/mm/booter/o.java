package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class o {
    static long gyL = 0;

    static /* synthetic */ void ej(String str) {
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split == null || split.length <= 1) {
            x.i("MicroMsg.ProcessReport", "nothing to reprot");
            return;
        }
        for (int i = 0; i < split.length - 1; i++) {
            x.i("MicroMsg.ProcessReport", "reprot %s: %s", new Object[]{str, split[i]});
            g.pQN.k(10667, split[i]);
        }
        sharedPreferences.edit().putString("startup_info", split[split.length - 1]).commit();
    }

    public static void onCreate(boolean z) {
        if (z) {
            u("mm_proc_startup", 2);
        } else {
            u("push_proc_startup", 1);
        }
    }

    private static void u(String str, int i) {
        a aVar;
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split != null && split.length > 0) {
            aVar = new a();
            if (aVar.ek(split[split.length - 1])) {
                aVar.gyR = Process.myPid();
                split[split.length - 1] = aVar.toString();
            }
        }
        aVar = new a();
        aVar.gyN = i;
        aVar.gyP = Process.myPid();
        aVar.gyQ = (int) bh.Wo();
        String d = d(split);
        String aVar2 = aVar.toString();
        if (d.length() > 0) {
            aVar2 = d + "=" + aVar2;
        }
        x.d("MicroMsg.ProcessReport", "startProc new info %s", new Object[]{aVar2});
        sharedPreferences.edit().putString("startup_info", aVar2).commit();
    }

    public static void us() {
        ei("mm_proc_startup");
        ei("push_proc_startup");
    }

    private static void ei(String str) {
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split != null && split.length != 0) {
            a aVar = new a();
            if (aVar.ek(split[split.length - 1])) {
                aVar.gyO = 2;
                split[split.length - 1] = aVar.toString();
            }
            x.d("MicroMsg.ProcessReport", "uerExit new info %s", new Object[]{d(split)});
            sharedPreferences.edit().putString("startup_info", r1).commit();
        }
    }

    public static void wW() {
        if (gyL == 0 || bh.bA(gyL) >= 3600000) {
            int intValue = ((Integer) ar.He().get(37, Integer.valueOf(0))).intValue();
            if (d.vAz != intValue) {
                ar.He().set(37, Integer.valueOf(d.vAz));
                new af(Looper.getMainLooper()).post(new 1(intValue));
            }
            gyL = bh.Wq();
            new af(Looper.getMainLooper()).post(new 2());
        }
    }

    private static String d(String[] strArr) {
        String str = "";
        Object obj = 1;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (obj != null) {
                obj = null;
            } else {
                str = str + "=";
            }
            i++;
            str = str + str2;
        }
        return str;
    }
}
