package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.FileUtils;
import java.util.LinkedHashMap;
import java.util.List;

class e {
    final String jKc;
    final Class jKd;
    private final Class jKe;
    final LinkedHashMap<String, Integer> jKf = new LinkedHashMap();
    final LinkedHashMap<String, AppBrandRemoteTaskController> jKg = new LinkedHashMap();

    e(Class cls, Class cls2) {
        this.jKc = cls.getName();
        this.jKd = cls;
        this.jKe = cls2;
    }

    final void Eu() {
        if (this.jKe != null) {
            Intent intent = new Intent();
            intent.setClass(ac.getContext(), this.jKe);
            ac.getContext().sendBroadcast(intent);
        }
    }

    final void a(String str, int i, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        this.jKf.put(str, Integer.valueOf(i));
        this.jKg.put(str, appBrandRemoteTaskController);
    }

    void akh() {
        if (this.jKf.isEmpty()) {
            ActivityManager activityManager = (ActivityManager) ac.getContext().getSystemService("activity");
            PackageManager packageManager = ac.getContext().getPackageManager();
            if (activityManager != null && packageManager != null) {
                try {
                    String str = packageManager.getActivityInfo(new ComponentName(ac.getContext(), this.jKd), FileUtils.S_IWUSR).processName;
                    List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.equals(str)) {
                                Process.killProcess(runningAppProcessInfo.pid);
                                return;
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    final AppBrandRemoteTaskController up(String str) {
        return (AppBrandRemoteTaskController) this.jKg.get(str);
    }
}
