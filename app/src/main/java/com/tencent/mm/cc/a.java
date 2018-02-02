package com.tencent.mm.cc;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class a {
    public static int aJ(float f) {
        return (int) ((ac.getContext().getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = 1;
        while (options.outWidth / i4 > i) {
            i4++;
        }
        while (i3 / i4 > i2) {
            i4++;
        }
        return i4;
    }

    public static void aam(String str) {
        int i = 0;
        x.i("MicroMsg.MMPhotoEditUtil", "[deleteDirAllFile] dir:%s", str);
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isFile() && !bh.ov(file2.getName()) && file2.getName().startsWith("wx_photo_edit_")) {
                        file2.delete();
                    }
                    i++;
                }
            }
        }
    }
}
