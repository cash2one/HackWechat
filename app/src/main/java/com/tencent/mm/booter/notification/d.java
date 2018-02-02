package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.k.f;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private static boolean gzN = true;
    private static boolean gzO = true;
    private static boolean gzP = false;
    private static int gzQ = -1;
    private static int gzR = -1;
    private static boolean gzS = true;
    private static String gzT = "samsung";
    public static boolean gzU = true;
    public static boolean gzV = false;
    private static int gzW = -1;
    private static boolean gzX = true;
    private static Uri gzY = Uri.parse("content://com.android.badge/badge");

    public static void fo(int i) {
        boolean z;
        if (ac.getContext() != null && xg()) {
            Context context = ac.getContext();
            int zU = i == -1 ? f.zU() : i;
            if (!(context == null || !xg() || gzW == zU)) {
                gzW = zU;
                Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                intent.putExtra("badge_count", zU);
                intent.putExtra("badge_count_package_name", ac.getPackageName());
                intent.putExtra("badge_count_class_name", LauncherUI.class.getName());
                x.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[]{Integer.valueOf(zU), Build.BRAND});
                context.sendBroadcast(intent);
            }
        }
        if (gzS) {
            if (VERSION.SDK_INT < 11) {
                gzS = false;
            } else if (gzR != i) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("package", ac.getPackageName());
                    bundle.putString("class", LauncherUI.class.getName());
                    bundle.putInt("badgenumber", i);
                    gzS = ac.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle) != null;
                    x.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(gzS)});
                } catch (Exception e) {
                    x.i("MicroMsg.BusinessNotification", "no huawei badge");
                    x.e("MicroMsg.BusinessNotification", "alvin: no badge" + e.toString());
                    gzS = false;
                }
            }
        }
        if (gzP) {
            z = gzO;
        } else {
            gzP = true;
            if (Build.BRAND.equals("vivo")) {
                gzO = true;
                z = true;
            } else {
                gzO = false;
                z = false;
            }
        }
        if (z && gzQ != i) {
            try {
                Intent intent2 = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                intent2.putExtra(DownloadInfoColumns.PACKAGENAME, ac.getPackageName());
                intent2.putExtra("className", LauncherUI.class.getName());
                intent2.putExtra("notificationNum", i);
                ac.getContext().sendBroadcast(intent2);
                x.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                gzO = false;
                x.printErrStackTrace("MicroMsg.BusinessNotification", e2, "", new Object[0]);
            }
        }
        x(null, i);
    }

    public static void w(String str, int i) {
        if (t.ov(str)) {
            x.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
            return;
        }
        String vE = b.vE(str);
        if (!t.ov(vE)) {
            x(vE, i);
        }
    }

    public static void aW(boolean z) {
        if (gzX) {
            Context context = ac.getContext();
            if (context != null) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    try {
                        x.i("MicroMsg.BusinessNotification", "sync all user badge");
                        Bundle call = contentResolver.call(gzY, "getShortcutList", null, null);
                        if (call == null) {
                            x.i("MicroMsg.BusinessNotification", "getShortcutList return null");
                            return;
                        }
                        String string = call.getString("shortcut_list");
                        if (string != null) {
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                string = ((JSONObject) jSONArray.get(i)).getString("app_shortcut_custom_id");
                                if (!(string == null || string.equalsIgnoreCase("null"))) {
                                    String vD = b.vD(string);
                                    w(vD, z ? 0 : f.eT(vD));
                                }
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BusinessNotification", e, "sync all user badge: no support getShortcutList", new Object[0]);
                    }
                }
            }
        }
    }

    public static int a(Notification notification, g gVar) {
        int i;
        if (notification == null || !gzN) {
            return 0;
        }
        if (gVar == null) {
            i = 0;
        } else {
            int i2 = gVar.gAM;
            NotificationQueue notificationQueue = com.tencent.mm.booter.notification.queue.b.xi().gAn;
            if (notificationQueue.gAm == null) {
                notificationQueue.restore();
            }
            Iterator it = notificationQueue.gAm.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 = ((NotificationItem) it.next()).gAg + i3;
            }
            i = i2 - i3;
        }
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, Integer.valueOf(i));
            notification.getClass().getField("extraNotification").set(notification, newInstance);
            x.i("MicroMsg.BusinessNotification", "miuiNotification: %d", new Object[]{Integer.valueOf(i)});
            return i;
        } catch (NoSuchFieldException e) {
            gzN = false;
            return i;
        } catch (IllegalArgumentException e2) {
            gzN = false;
            return i;
        } catch (IllegalAccessException e3) {
            gzN = false;
            return i;
        } catch (ClassNotFoundException e4) {
            gzN = false;
            return i;
        } catch (InstantiationException e5) {
            gzN = false;
            return i;
        } catch (Exception e6) {
            gzN = false;
            return i;
        }
    }

    private static boolean xg() {
        if (gzV) {
            return gzU;
        }
        gzV = true;
        if (Build.BRAND.equals(gzT)) {
            gzU = true;
            return true;
        }
        gzU = false;
        return false;
    }

    private static void x(String str, int i) {
        if (ac.getContext() == null) {
            x.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
            return;
        }
        Context context = ac.getContext();
        if (i < 0) {
            i = f.zU();
        }
        a(context, str, i);
    }

    private static boolean a(Context context, String str, int i) {
        boolean z = true;
        if (!gzX) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                bundle.putStringArrayList("app_shortcut_custom_id", arrayList);
            } else {
                bundle.putStringArrayList("app_shortcut_custom_id", null);
            }
            bundle.putInt("app_badge_count", i);
            bundle.putString("app_shortcut_class_name", ac.cfr() + ".ui.LauncherUI");
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null || contentResolver.call(gzY, "setAppBadgeCount", null, bundle) == null) {
                z = false;
            }
            x.i("MicroMsg.BusinessNotification", "shortcutId: %s, normalNotification badge count: %d, result: %b", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)});
            return z;
        } catch (Exception e) {
            gzX = false;
            x.i("MicroMsg.BusinessNotification", "no support normal badge");
            x.e("MicroMsg.BusinessNotification", "alvin: no support normal badge");
            return false;
        }
    }
}
