package com.tencent.mm.plugin.base.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static final String kuC = ac.getPackageName();
    private static String kuD = "";
    private static char[] kuE = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean L(Context context, String str) {
        kuD = q.FS();
        Intent a = a(context, str, true, kuD);
        Intent intent = (Intent) a.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        if (intent == null) {
            return false;
        }
        a(context, a, intent.getStringExtra("app_shortcut_custom_id"), true);
        return true;
    }

    public static void n(Context context, Intent intent) {
        a(context, intent, null, true);
    }

    public static void a(Context context, Intent intent, String str, boolean z) {
        if (context == null) {
            x.e("MicroMsg.ShortcutManager", "context is null");
        } else if (intent == null) {
            x.e("MicroMsg.ShortcutManager", "intent is null");
        } else {
            Object obj;
            if (VERSION.SDK_INT < 26) {
                context.sendBroadcast(intent);
                b(context, true, true);
            } else {
                ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
                if (shortcutManager == null) {
                    x.e("MicroMsg.ShortcutManager", "shortcut manager is null");
                    obj = null;
                } else if (!shortcutManager.isRequestPinShortcutSupported()) {
                    x.e("MicroMsg.ShortcutManager", "alvinluo not support pin shortcuts");
                    obj = null;
                } else if (intent.getBooleanExtra("is_main_shortcut", false)) {
                    x.i("MicroMsg.ShortcutManager", "alvinluo main icon, do not create shortcut");
                    obj = null;
                } else {
                    Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
                    if (intent2 == null) {
                        x.e("MicroMsg.ShortcutManager", "alvinluo shortcut intent is null");
                        obj = null;
                    } else {
                        Object obj2;
                        int intExtra;
                        if (bh.ov(str)) {
                            str = intent2.getStringExtra("app_shortcut_custom_id");
                        }
                        if (bh.ov(str)) {
                            x.i("MicroMsg.ShortcutManager", "alvinluo shortcutId is null, then use short name as shortcutId");
                            str = intent.getStringExtra("android.intent.extra.shortcut.NAME");
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        x.i("MicroMsg.ShortcutManager", "alvinluo shortcutId: %s", new Object[]{str});
                        String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
                        if (((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")) != null) {
                            x.i("MicroMsg.ShortcutManager", "alvinluo icon resource name: %s, %s", new Object[]{((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")).resourceName, ((ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")).packageName});
                        }
                        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
                        if (bitmap == null) {
                            x.i("MicroMsg.ShortcutManager", "extra_shortcut_icon is null, use icon resource id");
                            intExtra = intent.getIntExtra("shortcut_icon_resource_id", -1);
                            if (intExtra == -1) {
                                x.e("MicroMsg.ShortcutManager", "icon resource id is null");
                                obj = null;
                            } else {
                                bitmap = BitmapFactory.decodeResource(context.getResources(), intExtra);
                            }
                        }
                        if (bitmap == null) {
                            x.e("MicroMsg.ShortcutManager", "icon bitmap is null");
                            obj = null;
                        } else {
                            boolean booleanExtra = intent.getBooleanExtra("shortcut_is_adaptive_icon", false);
                            Builder intent3 = new Builder(context, str).setShortLabel(intent.getStringExtra("android.intent.extra.shortcut.NAME")).setLongLabel(intent.getStringExtra("android.intent.extra.shortcut.NAME")).setIntent(intent2);
                            if (booleanExtra) {
                                intent3.setIcon(Icon.createWithBitmap(bitmap));
                            } else {
                                intent3.setIcon(Icon.createWithAdaptiveBitmap(bitmap));
                            }
                            ShortcutInfo build = intent3.build();
                            x.i("MicroMsg.ShortcutManager", "alvinluo add shortcut above android o, duplicate: %b", new Object[]{Boolean.valueOf(intent.getBooleanExtra("duplicate", false))});
                            if (intent.getBooleanExtra("duplicate", false)) {
                                shortcutManager.requestPinShortcut(build, null);
                                b(context, true, true);
                            } else {
                                boolean z2;
                                List pinnedShortcuts = shortcutManager.getPinnedShortcuts();
                                for (intExtra = 0; intExtra < pinnedShortcuts.size(); intExtra++) {
                                    ShortcutInfo shortcutInfo = (ShortcutInfo) pinnedShortcuts.get(intExtra);
                                    if (obj2 == null) {
                                        if (shortcutInfo != null && shortcutInfo.getId().equals(str)) {
                                            z2 = true;
                                            break;
                                        }
                                    } else if (!(shortcutInfo == null || shortcutInfo.getShortLabel() == null || !shortcutInfo.getShortLabel().equals(stringExtra))) {
                                        z2 = true;
                                        break;
                                    }
                                }
                                z2 = false;
                                x.i("MicroMsg.ShortcutManager", "alvinluo shortcut exist: %b, shortcutName: %s", new Object[]{Boolean.valueOf(z2), stringExtra});
                                if (z2) {
                                    List arrayList = new ArrayList();
                                    arrayList.add(build);
                                    boolean updateShortcuts = shortcutManager.updateShortcuts(arrayList);
                                    x.i("MicroMsg.ShortcutManager", "alvinluo update shortcuts result: %b", new Object[]{Boolean.valueOf(updateShortcuts)});
                                    b(context, true, true);
                                } else if (z) {
                                    intent2 = shortcutManager.createShortcutResultIntent(build);
                                    intent2.setClass(context, ShortcutBroadCastReceiver.class);
                                    shortcutManager.requestPinShortcut(build, PendingIntent.getBroadcast(context, 0, intent2, 134217728).getIntentSender());
                                } else {
                                    shortcutManager.requestPinShortcut(build, null);
                                }
                            }
                        }
                    }
                }
                if (obj == null && z) {
                    b(context, false, z);
                    return;
                }
            }
            obj = 1;
            if (obj == null) {
            }
        }
    }

    public static void o(Context context, Intent intent) {
        a(context, intent, null, false);
    }

    private static void b(Context context, boolean z, boolean z2) {
        if (z2) {
            h.bu(context, z ? context.getString(a.h.dDL) : context.getString(a.h.los));
        }
    }

    public static boolean M(Context context, String str) {
        kuD = q.FS();
        p(context, a(context, str, false, kuD));
        return true;
    }

    public static boolean p(Context context, Intent intent) {
        if (context == null) {
            x.e("MicroMsg.ShortcutManager", "context is null");
            return false;
        } else if (intent == null) {
            x.e("MicroMsg.ShortcutManager", "intent is null");
            return false;
        } else if (VERSION.SDK_INT >= 26) {
            return true;
        } else {
            context.sendBroadcast(intent);
            return true;
        }
    }

    private static Intent a(Context context, String str, boolean z, String str2) {
        if (str == null || context == null) {
            x.e("MicroMsg.ShortcutManager", "getIntent, wrong parameters");
            return null;
        }
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        Bitmap a = com.tencent.mm.ad.b.a(str, false, -1);
        if (a == null) {
            x.e("MicroMsg.ShortcutManager", "getScaledBitmap fail, bmp is null");
            a = d.CZ(a.d.bBB);
        }
        if (a == null) {
            x.e("MicroMsg.ShortcutManager", "use default avatar, bmp is null");
            Parcelable parcelable = null;
        } else {
            Object createScaledBitmap = Bitmap.createScaledBitmap(a, i, i, false);
        }
        if (parcelable == null) {
            x.e("MicroMsg.ShortcutManager", "no bmp");
            return null;
        }
        com.tencent.mm.l.a WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(str);
        if (WO == null || ((int) WO.gJd) <= 0) {
            x.e("MicroMsg.ShortcutManager", "no such user");
            return null;
        }
        String vE = vE(str);
        x.i("MicroMsg.ShortcutManager", "alvinluo encryptShortcutUser: %s", new Object[]{vE});
        if (bh.ov(vE)) {
            return null;
        }
        Parcelable intent = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent.putExtra("LauncherUI.Shortcut.Username", vE);
        intent.putExtra("LauncherUI.From.Biz.Shortcut", true);
        intent.putExtra("app_shortcut_custom_id", vE);
        intent.setPackage(context.getPackageName());
        intent.addFlags(67108864);
        Intent intent2 = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.NAME", s.a(WO, str));
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON", parcelable);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_SOURCE_KEY", kuC);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_OWNER_ID", vE(str2));
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_UNIQUE_ID", vE);
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_TYPE", y(WO));
        intent2.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_CONTAINER", 0);
        return intent2;
    }

    public static int y(com.tencent.mm.storage.x xVar) {
        if (xVar.cia()) {
            return 2;
        }
        if (s.ho(xVar.field_username)) {
            return 0;
        }
        return 1;
    }

    public static String bI(String str, String str2) {
        try {
            int i;
            int[] iArr = new int[256];
            byte[] bArr = new byte[256];
            for (i = 0; i < 256; i++) {
                iArr[i] = i;
            }
            for (i = 0; i < 256; i = (short) (i + 1)) {
                bArr[i] = (byte) str2.charAt(i % str2.length());
            }
            int i2 = 0;
            for (i = 0; i < 255; i++) {
                i2 = ((i2 + iArr[i]) + bArr[i]) % 256;
                int i3 = iArr[i];
                iArr[i] = iArr[i2];
                iArr[i2] = i3;
            }
            char[] toCharArray = str.toCharArray();
            char[] cArr = new char[toCharArray.length];
            i2 = 0;
            int i4 = 0;
            for (i = 0; i < toCharArray.length; i = (short) (i + 1)) {
                i2 = (i2 + 1) % 256;
                i4 = (i4 + iArr[i2]) % 256;
                int i5 = iArr[i2];
                iArr[i2] = iArr[i4];
                iArr[i4] = i5;
                cArr[i] = (char) (((char) iArr[(iArr[i2] + (iArr[i4] % 256)) % 256]) ^ toCharArray[i]);
            }
            return new String(cArr);
        } catch (Throwable e) {
            x.e("MicroMsg.ShortcutManager", "Exception in rc4, %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.ShortcutManager", e, "", new Object[0]);
            return null;
        }
    }

    public static String vD(String str) {
        String str2 = null;
        if (str == null || str.length() <= 0) {
            return str2;
        }
        String r = bh.r(ac.getContext(), Process.myPid());
        String packageName = ac.getPackageName();
        x.i("MicroMsg.ShortcutManager", "process name: %s", new Object[]{r});
        try {
            int Cg;
            if (!packageName.equals(r)) {
                Cg = aa.VQ().hZK.Cg();
            } else if (!g.Dh().Cy()) {
                return str2;
            } else {
                g.Dh();
                Cg = com.tencent.mm.kernel.a.Cg();
            }
            if (str.startsWith("shortcut_")) {
                return bI(new String(vF(str.substring(9))), String.valueOf(Cg));
            }
            return str;
        } catch (Exception e) {
            x.printErrStackTrace("MicroMsg.ShortcutManager", str2, "exception: %s", new Object[]{e.getMessage()});
            return str2;
        }
    }

    public static String vE(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String r = bh.r(ac.getContext(), Process.myPid());
        String packageName = ac.getPackageName();
        if (packageName.equals(r) && !g.Dh().Cy()) {
            return null;
        }
        x.i("MicroMsg.ShortcutManager", "process name: %s", new Object[]{r});
        try {
            if (packageName.equals(r)) {
                StringBuilder stringBuilder = new StringBuilder();
                g.Dh();
                r = bI(str, stringBuilder.append(com.tencent.mm.kernel.a.Cg()).toString());
            } else {
                r = bI(str, aa.VQ().hZK.Cg());
            }
            if (bh.ov(r)) {
                return null;
            }
            return "shortcut_" + aa(r.getBytes());
        } catch (Exception e) {
            x.printErrStackTrace("MicroMsg.ShortcutManager", null, "exception: %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static String aa(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(kuE[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(kuE[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }

    public static final byte[] vF(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }
}
