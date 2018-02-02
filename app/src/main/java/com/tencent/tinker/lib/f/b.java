package com.tencent.tinker.lib.f;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.util.List;

public final class b extends ShareTinkerInternals {
    private static String Ajc = null;

    public static void iq(Context context) {
        String is = is(context);
        if (is != null) {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(is)) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    public static boolean ir(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String is = is(context);
        if (is == null) {
            return false;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(is)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            new StringBuilder("isTinkerPatchServiceRunning Exception: ").append(e.toString());
            return false;
        } catch (Error e2) {
            new StringBuilder("isTinkerPatchServiceRunning Error: ").append(e2.toString());
            return false;
        }
    }

    private static String is(Context context) {
        if (Ajc != null) {
            return Ajc;
        }
        String b = b(context, TinkerPatchService.class);
        if (b == null) {
            return null;
        }
        Ajc = b;
        return b;
    }

    public static boolean it(Context context) {
        String iI = iI(context);
        String is = is(context);
        if (is == null || is.length() == 0) {
            return false;
        }
        return iI.equals(is);
    }

    private static String b(Context context, Class<? extends Service> cls) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 0).processName;
        } catch (Throwable th) {
            return null;
        }
    }
}
