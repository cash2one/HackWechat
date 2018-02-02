package com.tencent.mm.pluginsdk.g;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class a {
    public static boolean a(Activity activity, String str, int i, String str2, String str3) {
        if (VERSION.SDK_INT < 23 && !"MNC".equals(VERSION.CODENAME)) {
            return true;
        }
        try {
            if (android.support.v4.content.a.b(activity, str) == 0) {
                return true;
            }
            if (bh.ov(str3)) {
                android.support.v4.app.a.a(activity, new String[]{str}, i);
            } else {
                h.a(activity, str3, str2, false, new 1(activity, str, i));
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[]{e});
            return true;
        }
    }

    public static boolean f(Activity activity, String str) {
        if (VERSION.SDK_INT < 23 && !"MNC".equals(VERSION.CODENAME)) {
            return true;
        }
        try {
            if (android.support.v4.content.a.b(activity, str) != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[]{e});
            return true;
        }
    }

    public static boolean aZ(Context context, String str) {
        try {
            int b = android.support.v4.content.a.b(context, str);
            if (b != 0) {
                return false;
            }
            int i;
            String str2 = null;
            if (str.equals("android.permission.READ_CONTACTS")) {
                str2 = "android.permission.WRITE_CONTACTS";
            } else if (str.equals("android.permission.WRITE_CONTACTS")) {
                str2 = "android.permission.READ_CONTACTS";
            }
            if (bh.ov(str2)) {
                i = b;
            } else {
                try {
                    i = android.support.v4.content.a.b(context, str2);
                } catch (Exception e) {
                    x.e("MicroMsg.MPermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[]{e});
                    return false;
                }
            }
            if (i == 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            x.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[]{e2});
            return false;
        }
    }

    public static void g(Activity activity, String str) {
        android.support.v4.app.a.a(activity, new String[]{str}, 80);
    }
}
