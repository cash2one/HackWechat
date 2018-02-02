package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.File;

final class m {
    static String h(String... strArr) {
        File file;
        StringBuilder stringBuilder = new StringBuilder(";");
        for (String ou : strArr) {
            stringBuilder.append(bh.ou(ou)).append(';');
        }
        String s = g.s(stringBuilder.toString().getBytes());
        if (f.ze()) {
            String str = e.bnF;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            file = new File(str + "wxanewfiles/");
        } else {
            file = null;
        }
        if (file == null) {
            return "[INVALID]";
        }
        return new File(file.getPath() + "/" + s).getPath();
    }

    static boolean c(File file, File file2) {
        while (file2 != null) {
            if (file.equals(file2)) {
                return true;
            }
            file2 = file2.getParentFile();
        }
        return false;
    }
}
