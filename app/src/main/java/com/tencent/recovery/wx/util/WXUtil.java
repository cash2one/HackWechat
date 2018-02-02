package com.tencent.recovery.wx.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.recovery.util.Util;
import java.util.UUID;

public class WXUtil {
    public static String go(Context context) {
        return context.getSharedPreferences(context.getPackageName() + "_preferences", 0).getString("last_login_uin", "0");
    }

    public static String gp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        String string = sharedPreferences.getString("login_weixin_username", "");
        if (Util.ov(string)) {
            string = sharedPreferences.getString("login_user_name", "");
        }
        if (Util.ov(string)) {
            return String.valueOf(Util.gk(context));
        }
        return string;
    }

    public static final String aaO(String str) {
        if (str.contains("?")) {
            return str + "uuid=" + UUID.randomUUID().toString();
        }
        return str + "?uuid=" + UUID.randomUUID().toString();
    }

    public static final String HM(int i) {
        return "KeyConfigHttpCode[" + i + "]";
    }

    public static final String HN(int i) {
        return "KeyPatchHttpCode[" + i + "]";
    }
}
