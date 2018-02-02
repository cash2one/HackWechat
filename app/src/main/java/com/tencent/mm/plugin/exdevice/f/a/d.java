package com.tencent.mm.plugin.exdevice.f.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.File;

public final class d {
    private static final String lOO = (e.gHC + "uploaded_photos/");
    private static final String lOP = (e.gHC + "temp/");

    public static String yX(String str) {
        String str2;
        if (bh.ov(str)) {
            str2 = "";
        } else {
            str2 = new File(aEx(), ab.UZ(str) + "_t").getAbsolutePath();
        }
        com.tencent.mm.sdk.platformtools.d.b(str, 640, 640, CompressFormat.JPEG, 100, str2);
        System.currentTimeMillis();
        return str2;
    }

    public static File aEx() {
        File file = new File(lOO);
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }
}
