package com.tencent.mm.kernel;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    public static void e(Context context, boolean z) {
        if (context == null) {
            x.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
            return;
        }
        context.getSharedPreferences("system_config_prefs", 4).edit().putBoolean("settings_fully_exit", z).commit();
        x.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to " + z);
    }

    public static boolean aX(Context context) {
        if (context != null) {
            return context.getSharedPreferences("system_config_prefs", 4).getBoolean("settings_fully_exit", true);
        }
        x.e("MicroMsg.WeChatAppStatus", "getFullExitStatus context == null");
        return false;
    }

    public static void f(Context context, boolean z) {
        if (context == null) {
            x.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
            return;
        }
        context.getSharedPreferences("system_config_prefs_showdown", 4).edit().putBoolean("shut_down_weixin", z).commit();
        x.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to " + z);
    }

    public static boolean aY(Context context) {
        if (context != null) {
            return context.getSharedPreferences("system_config_prefs_showdown", 4).getBoolean("shut_down_weixin", false);
        }
        x.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
        return false;
    }
}
