package com.tencent.recovery;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.recovery.handler.RecoveryMessageHandler;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class Recovery {
    private static Application application;
    private static Context context;
    private static RecoveryMessageHandler zRd;
    private static long zRe;
    private static String zRf;
    private static boolean zRg = false;
    private static boolean zRh = false;
    private static int zRi = 0;
    private static ActivityLifecycleCallbacks zRj = new ActivityLifecycleCallbacks() {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (!Recovery.zRh && !Recovery.zRd.hasMessages(3)) {
                Recovery.zRd.removeCallbacksAndMessages(null);
                String gl = Util.gl(Recovery.context);
                Editor edit = Recovery.context.getSharedPreferences(Recovery.zRf, 0).edit();
                edit.putInt("KeyComponentOnCreateForeground", 1);
                edit.putInt("KeyComponentOnCreateExceptionType", Downloads.RECV_BUFFER_SIZE);
                edit.apply();
                Recovery.zRd.sendEmptyMessageDelayed(3, (long) OptionFactory.dF(gl, 1).gKi);
                RecoveryLog.i("Recovery", "%s markActivityOnCreated %s", gl, Long.valueOf(System.currentTimeMillis() - Recovery.zRe));
            }
        }

        public final void onActivityStarted(Activity activity) {
            Recovery.cDh();
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
            Recovery.cDi();
            if (Recovery.zRi == 0) {
                RecoveryLog.i("Recovery", "%s onActivityStopped: activityForegroundCount is 0", Util.gl(Recovery.context));
                Recovery.HL(16);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };

    static /* synthetic */ int cDh() {
        int i = zRi;
        zRi = i + 1;
        return i;
    }

    static /* synthetic */ int cDi() {
        int i = zRi;
        zRi = i - 1;
        return i;
    }

    public static void cDb() {
        if (!zRh && !zRg) {
            zRg = true;
            String gl = Util.gl(context);
            int bA = RecoveryLogic.bA(context, gl);
            RecoveryLog.i("Recovery", "%s markApplicationOnCreateNormal %d", gl, Long.valueOf(System.currentTimeMillis() - zRe));
            Editor edit = context.getSharedPreferences(zRf, 0).edit();
            edit.remove("KeyAppOnCreateExceptionType");
            edit.putInt("KeyAppOnCreateNormalType", 256);
            if (RecoveryLogic.bA(context, gl) == 16) {
                edit.putInt("KeyComponentOnCreateForeground", bA);
                edit.putInt("KeyComponentOnCreateExceptionType", Downloads.RECV_BUFFER_SIZE);
                zRd.sendEmptyMessageDelayed(2, (long) OptionFactory.dF(gl, bA).gKi);
            }
            edit.apply();
        }
    }

    private static void destroy() {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(zRj);
        }
    }

    public static void cDc() {
        if (context != null && !zRh) {
            cDe();
            RecoveryLog.i("Recovery", "%s Recovery.crash %d", Util.gl(context), Long.valueOf(System.currentTimeMillis() - zRe));
            Editor edit = context.getSharedPreferences(zRf, 0).edit();
            if (zRg) {
                edit.putInt("KeyComponentOnCreateExceptionType", 65536);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 65536);
            }
            edit.apply();
            destroy();
        }
    }

    public static void cDd() {
        if (context != null && !zRh) {
            cDe();
            RecoveryLog.i("Recovery", "%s Recovery.anr %d", Util.gl(context), Long.valueOf(System.currentTimeMillis() - zRe));
            Editor edit = context.getSharedPreferences(zRf, 0).edit();
            if (zRg) {
                edit.putInt("KeyComponentOnCreateExceptionType", 1048576);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 1048576);
            }
            edit.apply();
            destroy();
        }
    }

    public static void HL(int i) {
        if (context != null && !zRh) {
            cDe();
            String gl = Util.gl(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(zRf, 0);
            RecoveryLog.i("Recovery", "%s Recovery.normal %s %d", gl, Integer.toHexString(i), Long.valueOf(System.currentTimeMillis() - zRe));
            zRd.removeCallbacksAndMessages(null);
            Editor edit = sharedPreferences.edit();
            edit.remove("KeyComponentOnCreateExceptionType");
            edit.putInt("KeyComponentOnCreateNormalType", i);
            edit.apply();
            destroy();
        }
    }

    public static Context getContext() {
        return context;
    }

    private static void cDe() {
        if (context != null && !zRh) {
            RecoveryLog.i("Recovery", "%s markFinalStatus", Util.gl(context));
            zRh = true;
        }
    }
}
