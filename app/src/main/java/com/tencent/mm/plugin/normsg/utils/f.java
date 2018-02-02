package com.tencent.mm.plugin.normsg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.List;

public final class f {
    public static boolean oTI;

    static {
        oTI = false;
        long nanoTime = System.nanoTime();
        try {
            oTI = false;
            if (VERSION.SDK_INT < 21) {
                oTI = false;
            } else {
                Field declaredField = RecentTaskInfo.class.getDeclaredField("instanceId");
                declaredField.setAccessible(true);
                List recentTasks = ((ActivityManager) ac.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
                if (recentTasks == null || recentTasks.size() == 0) {
                    oTI = false;
                } else if (declaredField.getInt((RecentTaskInfo) recentTasks.get(0)) > 0) {
                    oTI = true;
                }
            }
            x.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[]{Boolean.valueOf(oTI), Long.valueOf(System.nanoTime() - nanoTime)});
        } catch (Throwable th) {
            x.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[]{Boolean.valueOf(oTI), Long.valueOf(System.nanoTime() - nanoTime)});
        }
    }
}
