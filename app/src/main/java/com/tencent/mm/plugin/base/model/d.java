package com.tencent.mm.plugin.base.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private static List<a> kuF = new LinkedList();

    private static class b implements ak.a {
        private Runnable hXj;

        b(Runnable runnable) {
            this.hXj = runnable;
        }

        public final boolean uF() {
            if (this.hXj != null) {
                this.hXj.run();
            }
            return false;
        }
    }

    public static void a(Context context, String str, String str2, a aVar) {
        if (context == null || bh.ov(str)) {
            x.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
            if (aVar != null) {
                aVar.dO(false);
                return;
            }
            return;
        }
        x.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", new Object[]{str});
        if (!ar.Hj() || ar.Cs()) {
            x.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
            if (aVar != null) {
                aVar.dO(false);
                return;
            }
            return;
        }
        ar.Hg();
        com.tencent.mm.storage.x WO = c.EY().WO(str);
        String str3 = "";
        if (WO != null) {
            str3 = WO.AP();
        }
        if (bh.ov(str3)) {
            x.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
            com.tencent.mm.z.ak.a.hfL.a(str, "", new 1(aVar, str, context, str2));
            return;
        }
        a(context, str, str2, str3, aVar);
    }

    public static void a(Context context, String str, String str2, String str3, a aVar) {
        if (O(context, str3)) {
            x.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
            if (aVar != null) {
                aVar.dO(true);
                return;
            }
            return;
        }
        final String str4 = str;
        final Context context2 = context;
        final a aVar2 = aVar;
        final String str5 = str2;
        final String str6 = str3;
        a anonymousClass2 = new a() {
            public final void jh(String str) {
                if (str4.equals(str)) {
                    x.i("MicroMsg.WebviewShrotcutManager", "notifyChanged avatar(%s).", new Object[]{str});
                    d.kuF.remove(this);
                    n.Jz().b(this);
                    Bitmap P = d.N(context2, str4);
                    if (P != null && !P.isRecycled()) {
                        Intent a = d.a(context2, str4, str5, str6, P, true);
                        if (a == null) {
                            x.e("MicroMsg.WebviewShrotcutManager", "intent is null");
                            if (aVar2 != null) {
                                aVar2.dO(false);
                                return;
                            }
                            return;
                        }
                        b.o(context2, a);
                        if (aVar2 != null) {
                            aVar2.dO(true);
                        }
                    } else if (aVar2 != null) {
                        aVar2.dO(false);
                    }
                }
            }
        };
        kuF.add(anonymousClass2);
        n.Jz().a(anonymousClass2);
        Bitmap N = N(context, str);
        if (N == null || N.isRecycled()) {
            x.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
            new ak(new b(new 3(anonymousClass2, aVar, str)), false).J(5000, 5000);
            return;
        }
        kuF.remove(anonymousClass2);
        n.Jz().b(anonymousClass2);
        Intent a = a(context, str, str2, str3, N, true);
        if (a == null) {
            x.e("MicroMsg.WebviewShrotcutManager", "intent is null");
            if (aVar != null) {
                aVar.dO(false);
                return;
            }
            return;
        }
        b.o(context, a);
        if (aVar != null) {
            aVar.dO(true);
        }
    }

    private static Bitmap N(Context context, String str) {
        Bitmap a = com.tencent.mm.ad.b.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            return a;
        }
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        return Bitmap.createScaledBitmap(a, i, i, false);
    }

    public static void c(Context context, String str, String str2, String str3) {
        if (context == null || bh.ov(str3)) {
            x.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
        }
        Intent a = a(context, str, str2, str3, null, false);
        if (a == null) {
            x.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
        } else {
            b.p(context, a);
        }
    }

    public static Intent a(Context context, String str, String str2, String str3, Bitmap bitmap, boolean z) {
        x.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", new Object[]{Boolean.valueOf(z)});
        if (bitmap == null && z) {
            x.e("MicroMsg.WebviewShrotcutManager", "no bmp");
            return null;
        }
        String vH = vH(str);
        if (bh.ov(vH)) {
            return null;
        }
        Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", str3);
        intent.putExtra("duplicate", false);
        String str4 = "";
        h jm = n.JQ().jm(str);
        if (jm != null) {
            str4 = g.s((str3 + jm.JH()).getBytes());
        }
        Parcelable intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
        intent2.putExtra(DownloadSettingTable$Columns.TYPE, 2);
        intent2.putExtra(SlookAirButtonFrequentContactAdapter.ID, vH);
        intent2.putExtra("ext_info", vH(str2));
        intent2.putExtra("ext_info_1", vH(str3));
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        intent2.putExtra("token", bJ(str2, stringBuilder.append(c.Cg()).toString()));
        intent2.putExtra("digest", str4);
        intent2.setPackage(context.getPackageName());
        intent2.addFlags(67108864);
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        return intent;
    }

    private static String vH(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String bI = b.bI(str, q.yE());
        if (bh.ov(bI)) {
            return null;
        }
        return "shortcut_" + b.aa(bI.getBytes());
    }

    public static String bJ(String str, String str2) {
        return g.s((g.s(str.getBytes()) + b.bI(str2, str)).getBytes());
    }

    private static boolean O(Context context, String str) {
        try {
            String str2;
            ContentResolver contentResolver = context.getContentResolver();
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(8);
            if (installedPackages != null) {
                loop0:
                for (PackageInfo packageInfo : installedPackages) {
                    ProviderInfo[] providerInfoArr = packageInfo.providers;
                    if (providerInfoArr != null) {
                        int length = providerInfoArr.length;
                        int i = 0;
                        while (i < length) {
                            ProviderInfo providerInfo = providerInfoArr[i];
                            if ("com.android.launcher.permission.READ_SETTINGS".equals(providerInfo.readPermission)) {
                                str2 = providerInfo.authority;
                                break loop0;
                            } else if ("com.android.launcher.permission.READ_SETTINGS".equals(providerInfo.writePermission)) {
                                str2 = providerInfo.authority;
                                break loop0;
                            } else {
                                i++;
                            }
                        }
                        continue;
                    }
                }
            }
            str2 = null;
            Cursor query = contentResolver.query(Uri.parse("content://" + str2 + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{str}, null);
            if (query == null) {
                return false;
            }
            boolean z;
            if (query.getCount() > 0) {
                z = true;
            } else {
                z = false;
            }
            query.close();
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
