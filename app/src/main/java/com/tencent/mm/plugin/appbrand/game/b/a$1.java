package com.tencent.mm.plugin.appbrand.game.b;

import android.graphics.Typeface;
import com.tencent.magicbrush.handler.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class a$1 implements b {
    final /* synthetic */ e iYe;

    public a$1(e eVar) {
        this.iYe = eVar;
    }

    public final Typeface bA(String str) {
        Typeface typeface = null;
        x.i("MBFontManagerRegistry", "loadFont at path[%s]", new Object[]{str});
        if (!(str == null || str.length() == 0)) {
            String g;
            if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                g = g(this.iYe, str);
            } else {
                g = h(this.iYe, str);
            }
            if (g != null) {
                try {
                    typeface = Typeface.createFromFile(g);
                } catch (Exception e) {
                    x.e("MBFontManagerRegistry", "Create typeface from file failed. pkgPath = [%s], filePath = [%s]", new Object[]{str, g});
                }
            }
        }
        return typeface;
    }

    private static String g(e eVar, String str) {
        try {
            File pQ = eVar.iqz.pQ(str);
            if (pQ != null) {
                return pQ.getAbsolutePath();
            }
            x.e("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", new Object[]{str});
            return null;
        } catch (Exception e) {
            x.e("MBFontManagerRegistry", "Read [%s] from filesystem failed", new Object[]{str});
            return null;
        }
    }

    private static String h(e eVar, String str) {
        String str2 = null;
        try {
            str2 = ah.f(eVar, str);
        } catch (Exception e) {
            x.e("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", new Object[]{str});
        }
        return str2;
    }
}
