package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.content.d;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.net.URI;

public final class ac {
    private static Typeface rlK = null;

    public static Bitmap getBitmap(String str) {
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str2 + "/" + ("adId" + "_image_" + ab.UZ(str));
        if (FileOp.bO(str3)) {
            return b.b(str3, 1.0f);
        }
        return null;
    }

    public static int aw(float f) {
        int i = (int) f;
        if (((double) (f - ((float) i))) > 0.001d) {
            return i + 1;
        }
        return i;
    }

    public static int[] dv(Context context) {
        int i;
        int i2;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            Point point = new Point();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
                i = point.x;
                i2 = point.y;
            } else {
                defaultDisplay.getSize(point);
                i = point.x;
                i2 = point.y;
            }
        } else {
            i = defaultDisplay.getWidth();
            i2 = defaultDisplay.getHeight();
        }
        return new int[]{i, i2};
    }

    public static void dw(Context context) {
        d.m(context).a(new Intent("com.tencent.mm.adlanding.set_uioption"));
    }

    public static String l(String str, String... strArr) {
        try {
            URI uri = new URI(str);
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : strArr) {
                stringBuilder.append(append).append("&");
            }
            if (stringBuilder.length() <= 1) {
                return str;
            }
            String stringBuilder2;
            StringBuilder deleteCharAt = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String query = uri.getQuery();
            if (query == null) {
                stringBuilder2 = deleteCharAt.toString();
            } else {
                stringBuilder2 = query + "&" + deleteCharAt.toString();
            }
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder2, uri.getFragment()).toString();
        } catch (Throwable e) {
            x.printErrStackTrace("LandingPageUtil", e, "", new Object[0]);
            return str;
        }
    }

    public static String Lb(String str) {
        if (bh.ov(str)) {
            return "";
        }
        if (!str.contains("_")) {
            return str;
        }
        String[] split = str.split("_");
        if (split.length > 0) {
            return split[split.length - 1];
        }
        return str;
    }

    public static Typeface dx(Context context) {
        if (rlK == null) {
            rlK = Typeface.createFromAsset(context.getAssets(), "fonts/WeChatNum.ttf");
        }
        return rlK;
    }

    public static boolean Lc(String str) {
        return str != null && str.length() >= 102400;
    }

    public static String Ld(String str) {
        if (bh.ov(str)) {
            return "";
        }
        File file = new File(a.gZL.replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            String absolutePath = new File(file, System.currentTimeMillis()).getAbsolutePath();
            if (e.b(absolutePath, bytes, bytes.length) == 0) {
                return absolutePath;
            }
        } catch (Exception e) {
            x.e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
        }
        return "";
    }

    public static String Le(String str) {
        if (bh.ov(str)) {
            return "";
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            String bT = e.bT(str);
            file.delete();
            return bT;
        } catch (Exception e) {
            x.e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
            return "";
        }
    }
}
