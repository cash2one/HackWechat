package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class e {

    public interface a {
        void eo(int i);
    }

    public static int an(Context context) {
        int i = 0;
        if (context != null) {
            try {
                i = context.getSharedPreferences("crash_status_file", 4).getInt("channel", -1);
            } catch (Throwable th) {
            }
        }
        return i;
    }

    public static int ao(Context context) {
        int i = 0;
        if (context != null) {
            try {
                i = context.getSharedPreferences("crash_status_file", 4).getInt("googleplaysizelimit", 3072);
            } catch (Throwable th) {
            }
        }
        return i;
    }

    public static void e(Context context, String str, String str2) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
            String string = sharedPreferences.getString("crashlist", "");
            Editor edit = sharedPreferences.edit();
            edit.putString("crashlist", string + ";" + str + "," + str2);
            edit.commit();
        } catch (Throwable th) {
        }
    }
}
