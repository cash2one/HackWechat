package com.tencent.mm.bp;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<String, Integer> et(Context context) {
        Map<String, Integer> hashMap = new HashMap();
        if (context != null) {
            try {
                for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    hashMap.put(runningAppProcessInfo.processName, Integer.valueOf(runningAppProcessInfo.pid));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ProcessOperator", e, "", new Object[0]);
            }
        }
        return hashMap;
    }

    public static boolean e(Context context, String... strArr) {
        if (context == null) {
            return false;
        }
        Map et = et(context);
        for (int i = 0; i < 8; i++) {
            Integer num = (Integer) et.get(strArr[i]);
            if (num != null) {
                x.i("MicroMsg.ProcessOperator", "killProcess(pid : %s, process : %s)", new Object[]{num, r5});
                Process.killProcess(num.intValue());
            }
        }
        return true;
    }
}
