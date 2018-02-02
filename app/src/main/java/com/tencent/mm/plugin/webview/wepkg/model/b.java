package com.tencent.mm.plugin.webview.wepkg.model;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgProcessPreloadService;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class b {
    private static b tMz = null;

    static /* synthetic */ void a(b bVar, String str) {
        if (!bh.ov(str)) {
            c 2 = new 2(bVar, str);
            Bundle bundle = new Bundle(1);
            bundle.putInt("call_cmd_type", 1);
            bundle.putString("call_pkg_id", str);
            WepkgProcessPreloadService.a(2, bundle);
        }
    }

    public static synchronized b bVi() {
        b bVar;
        synchronized (b.class) {
            if (tMz == null) {
                synchronized (b.class) {
                    if (tMz == null) {
                        tMz = new b();
                    }
                }
            }
            bVar = tMz;
        }
        return bVar;
    }

    public final synchronized void bVj() {
        boolean z = true;
        synchronized (this) {
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("we_pkg_sp", 0);
            if (System.currentTimeMillis() - sharedPreferences.getLong("clean_wepkg_time", 0) <= 86400000) {
                z = false;
            }
            x.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg, allowClean:%b", Boolean.valueOf(z));
            if (z) {
                sharedPreferences.edit().putLong("clean_wepkg_time", System.currentTimeMillis()).commit();
                e.post(new 1(this), "clean_wepkg");
            }
        }
    }
}
