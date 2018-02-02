package com.tencent.mm.compatible.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;

public final class b {
    private static Boolean gHe = null;

    public static boolean yY() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            return true;
        }
        int i = 0;
        if (VERSION.SDK_INT == 17) {
            i = 36;
        } else if (VERSION.SDK_INT >= 19) {
            i = 27;
        }
        return fL(i);
    }

    public static boolean aK(Context context) {
        if (gHe == null) {
            gHe = Boolean.valueOf(context == null ? false : context.getPackageManager().hasSystemFeature("org.chromium.arc.device_management"));
        }
        return gHe.booleanValue();
    }

    public static boolean yZ() {
        return bh.az(VERSION.INCREMENTAL, "").toLowerCase().contains("flyme") || bh.az(Build.DISPLAY, "").toLowerCase().contains("flyme");
    }

    public static boolean za() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            return true;
        }
        int i = 0;
        if (VERSION.SDK_INT == 17) {
            i = 35;
        } else if (VERSION.SDK_INT >= 19) {
            i = 26;
        }
        return fL(i);
    }

    public static void aL(Context context) {
        Intent intent;
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            try {
                intent = new Intent();
                intent.setClassName("com.android.settings", "com.android.settings.applications.AppsCheckReadPermission");
                context.startActivity(intent);
            } catch (Exception e) {
                x.e("MicroMsg.PermissionUtil", "unable start activity AppsCheckReadPermission");
                try {
                    intent = new Intent("android.settings.APP_OPS_SETTINGS");
                    intent.addCategory("android.intent.category.DEFAULT");
                    context.startActivity(intent);
                } catch (Exception e2) {
                    x.e("MicroMsg.PermissionUtil", "unable start activity APP_OPS_SETTINGS");
                    try {
                        intent = new Intent();
                        intent.setClassName("com.android.settings", "com.android.settings.Settings$AppControlSettingsActivity");
                        context.startActivity(intent);
                    } catch (Exception e3) {
                        x.e("MicroMsg.PermissionUtil", "unable start activity AppControlSettingsActivity");
                    }
                }
            }
        }
    }

    private static boolean fL(int i) {
        if (i == 0) {
            return true;
        }
        Method method;
        int intValue;
        Object systemService = ac.getContext().getSystemService("appops");
        if (systemService != null) {
            try {
                method = Class.forName("android.app.AppOpsManager").getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            } catch (NoSuchMethodException e) {
                x.e("MicroMsg.PermissionUtil", "onVoiceRcdStartRequest meizu NoSuchMethodException method:checkOpNoThrow! Error:%s", e.getMessage());
                method = null;
            } catch (ClassNotFoundException e2) {
                x.e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", e2.getMessage());
            }
            if (method != null) {
                try {
                    intValue = ((Integer) method.invoke(systemService, new Object[]{Integer.valueOf(i), Integer.valueOf(ac.getContext().getApplicationInfo().uid), ac.getPackageName()})).intValue();
                } catch (Exception e3) {
                    x.e("MicroMsg.PermissionUtil", "invoke checkOpNoThrow Exception! Error:%s", e3.getMessage());
                    intValue = -1;
                }
                if (intValue != 0) {
                    x.e("MicroMsg.PermissionUtil", "ret:%d showAlert to ask for record permission for wechat!", Integer.valueOf(intValue));
                    return false;
                }
            }
            return true;
        }
        method = null;
        if (method != null) {
            intValue = ((Integer) method.invoke(systemService, new Object[]{Integer.valueOf(i), Integer.valueOf(ac.getContext().getApplicationInfo().uid), ac.getPackageName()})).intValue();
            if (intValue != 0) {
                x.e("MicroMsg.PermissionUtil", "ret:%d showAlert to ask for record permission for wechat!", Integer.valueOf(intValue));
                return false;
            }
        }
        return true;
    }

    @TargetApi(19)
    public static boolean aM(Context context) {
        boolean z = true;
        int i = VERSION.SDK_INT;
        boolean booleanValue;
        if (i >= 23) {
            try {
                booleanValue = ((Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", new Class[]{Context.class}).invoke(null, new Object[]{context})).booleanValue();
                x.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: " + booleanValue);
                return booleanValue;
            } catch (Exception e) {
                x.e("MicroMsg.PermissionUtil", "getDeclaredMethod:canDrawOverlays! Error:%s, etype:%s", e.getMessage(), e.getClass().getCanonicalName());
                return true;
            }
        } else if (i < 19) {
            return true;
        } else {
            Method method;
            Object systemService = ac.getContext().getSystemService("appops");
            try {
                method = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            } catch (NoSuchMethodException e2) {
                x.e("MicroMsg.PermissionUtil", "NoSuchMethodException method:checkOp! Error:%s", e2.getMessage());
                method = null;
            } catch (ClassNotFoundException e3) {
                x.e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", e3.getMessage());
                method = null;
            }
            if (method != null) {
                try {
                    if (((Integer) method.invoke(systemService, new Object[]{Integer.valueOf(24), Integer.valueOf(ac.getContext().getApplicationInfo().uid), ac.getPackageName()})).intValue() == 0) {
                        booleanValue = true;
                    } else {
                        booleanValue = false;
                    }
                    z = booleanValue;
                } catch (Exception e4) {
                    x.e("MicroMsg.PermissionUtil", "call checkOp failed: %s etype:%s", e4.getMessage(), e4.getClass().getCanonicalName());
                }
            }
            x.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: " + z);
            return z;
        }
    }
}
