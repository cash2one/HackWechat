package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;

public final class j {
    public static Bitmap b(p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar.aeP();
    }

    public static String a(p pVar, String str, boolean z) {
        if (pVar == null) {
            return null;
        }
        String str2 = pVar.mAppId;
        if (bh.ov(str)) {
            if (!z) {
                return null;
            }
            pVar.a(1, null, new Object[0]);
            String genMediaFilePath = AppBrandLocalMediaObjectManager.genMediaFilePath(str2, "share_" + System.currentTimeMillis());
            c.a(str2, new 1(str2, pVar, genMediaFilePath));
            return "delayLoadFile://" + genMediaFilePath;
        } else if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            File pQ = pVar.irP.iqz.pQ(str);
            if (pQ == null || !pQ.exists()) {
                return null;
            }
            return "file://" + pQ.getAbsolutePath();
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            return null;
        } else {
            str2 = AppBrandLocalMediaObjectManager.genMediaFilePath(str2, "share_" + System.currentTimeMillis());
            Bitmap j = o.j(pVar.irP, str);
            if (j == null || j.isRecycled()) {
                return null;
            }
            try {
                d.a(j, 100, CompressFormat.PNG, str2, true);
                if (!(j == null || j.isRecycled())) {
                    j.recycle();
                }
            } catch (IOException e) {
                x.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[]{e});
                if (!(j == null || j.isRecycled())) {
                    j.recycle();
                }
            } catch (Throwable th) {
                if (!(j == null || j.isRecycled())) {
                    j.recycle();
                }
            }
            return "file://" + str2;
        }
    }

    public static boolean sJ(String str) {
        if (bh.ov(str)) {
            return true;
        }
        return false;
    }

    public static String sK(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("file://")) {
            return str.replace("file://", "");
        }
        if (str.startsWith("delayLoadFile://")) {
            return str.replace("delayLoadFile://", "");
        }
        return str;
    }
}
