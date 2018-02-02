package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ToolsProfile$a {
    private static final AtomicInteger ffP = new AtomicInteger(0);

    public static boolean isLocked() {
        if (ffP.get() <= 0) {
            Object obj;
            ActivityManager activityManager = (ActivityManager) ac.getContext().getSystemService("activity");
            if (activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (((h) g.Dg().CN()).gOs.equals(runningAppProcessInfo.processName)) {
                            if (runningAppProcessInfo.importance == 300) {
                                obj = 1;
                                if (obj == null) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    static void ua() {
        x.i("MicroMsg.ToolsProcessLocker", "clearLock, beforeReset %d", new Object[]{Integer.valueOf(ffP.getAndSet(0))});
    }
}
