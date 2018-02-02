package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

final class i {
    static boolean aP(String str, String str2) {
        if (VERSION.SDK_INT >= 21) {
            try {
                long Wp = bh.Wp();
                a aVar = new a();
                Os.rename(str, str2);
                x.d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", new Object[]{Long.valueOf(bh.Wp() - Wp)});
                return true;
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", new Object[]{bh.i(e)});
            }
        }
        return new File(str).renameTo(new File(str2));
    }
}
