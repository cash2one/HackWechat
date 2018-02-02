package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.os.Parcelable;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public final class k {
    public static boolean d(Context context, String str, int i) {
        if (context == null || str == null) {
            x.e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
            return false;
        }
        b bqVar = new bq();
        bqVar.fpJ.username = str;
        a.xef.m(bqVar);
        if (bqVar.fpK.fpM == null) {
            x.e("MicroMsg.AppBrandShortcutManager", "no such user");
            return false;
        }
        Bitmap a = a(bqVar);
        if (a == null) {
            x.i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
            return true;
        }
        Intent a2 = a(context, bqVar, i, a(context, a, i), true);
        if (a2 == null) {
            x.e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
            return false;
        }
        String bI;
        if (((Intent) a2.getParcelableExtra("android.intent.extra.shortcut.INTENT")) != null) {
            bI = com.tencent.mm.plugin.base.model.b.bI(bqVar.fpK.appId + String.valueOf(i), q.yE());
            if (bI != null) {
                bI = com.tencent.mm.plugin.base.model.b.aa(bI.getBytes());
            } else {
                bI = null;
            }
            x.i("MicroMsg.AppBrandShortcutManager", "alvinluo appId: %s, shortcutId: %s", new Object[]{r4, bI});
        } else {
            bI = null;
        }
        com.tencent.mm.plugin.base.model.b.a(context, a2, bI, true);
        x.i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", new Object[]{str});
        return true;
    }

    public static Intent a(Context context, bq bqVar, int i, Bitmap bitmap, boolean z) {
        if (context == null || bqVar.fpJ.username == null) {
            x.e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
            return null;
        } else if (bitmap == null && z) {
            x.e("MicroMsg.AppBrandShortcutManager", "no bmp");
            return null;
        } else {
            String str = bqVar.fpJ.username;
            String str2 = TextUtils.isEmpty(bqVar.fpK.fpL) ? str : bqVar.fpK.fpL;
            String str3 = bqVar.fpK.appId;
            String vH = c.vH(str);
            if (bh.ov(vH)) {
                return null;
            }
            str = z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT";
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : bqVar.fpK.fpM) {
                stringBuilder.append(append);
            }
            String s = g.s((str2 + stringBuilder.toString()).getBytes());
            Intent intent = new Intent(str);
            intent.putExtra("android.intent.extra.shortcut.NAME", str2);
            intent.putExtra("duplicate", false);
            Parcelable intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
            intent2.putExtra(DownloadSettingTable$Columns.TYPE, 1);
            intent2.putExtra(SlookAirButtonFrequentContactAdapter.ID, vH);
            intent2.putExtra("ext_info", c.vH(str3));
            StringBuilder stringBuilder2 = new StringBuilder();
            com.tencent.mm.kernel.g.Dh();
            intent2.putExtra("token", c.bJ(str3, stringBuilder2.append(com.tencent.mm.kernel.a.Cg()).toString()));
            intent2.putExtra("digest", s);
            intent2.putExtra("ext_info_1", i);
            intent2.setPackage(context.getPackageName());
            intent2.addFlags(67108864);
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            return intent;
        }
    }

    public static Bitmap a(bq bqVar) {
        Bitmap bitmap = null;
        for (String str : bqVar.fpK.fpM) {
            if (!bh.ov(str)) {
                bitmap = com.tencent.mm.modelappbrand.a.b.Jj().a(str, null);
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                }
            }
        }
        return bitmap;
    }

    public static Bitmap a(Context context, Bitmap bitmap, int i) {
        Bitmap bitmap2 = null;
        if (!(context == null || bitmap == null || bitmap.isRecycled())) {
            int density = (int) (com.tencent.mm.bv.a.getDensity(context) * 48.0f);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, density, density, false);
            if (createScaledBitmap != null) {
                bitmap2 = createScaledBitmap.copy(Config.ARGB_8888, true);
                createScaledBitmap.recycle();
            }
            if (i == 2) {
                a(context, bitmap2, com.tencent.mm.bv.a.ac(context, j.iBo));
            } else if (i == 1) {
                a(context, bitmap2, com.tencent.mm.bv.a.ac(context, j.iBp));
            }
        }
        return bitmap2;
    }

    private static void a(Context context, Bitmap bitmap, String str) {
        if (context != null && bitmap != null && !bitmap.isRecycled() && !bh.ov(str)) {
            int width = bitmap.getWidth();
            float density = com.tencent.mm.bv.a.getDensity(context);
            float f = 4.0f * density;
            float f2 = density * 2.0f;
            density *= 6.0f;
            Paint paint = new Paint();
            paint.setTextSize(density);
            paint.setFakeBoldText(true);
            paint.setAntiAlias(true);
            density = paint.measureText(str);
            FontMetrics fontMetrics = paint.getFontMetrics();
            float f3 = fontMetrics.bottom - fontMetrics.top;
            paint.setColor(Color.parseColor("#459AE9"));
            Canvas canvas = new Canvas(bitmap);
            Rect rect = new Rect((int) ((((float) width) - density) - (f * 2.0f)), (width * 2) / 3, width, (int) ((f3 + ((float) ((width * 2) / 3))) + (f2 * 2.0f)));
            canvas.drawRect(rect, paint);
            paint.setColor(-1);
            canvas.drawText(str, ((float) rect.left) + f, (((float) rect.top) + f2) - fontMetrics.ascent, paint);
        }
    }
}
