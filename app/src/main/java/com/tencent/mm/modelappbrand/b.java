package com.tencent.mm.modelappbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static String hjx;
    public static String hjy;

    public static String IU() {
        StringBuilder stringBuilder = new StringBuilder("sid_");
        g.Dh();
        hjx = stringBuilder.append(a.Cg()).append("_").append(bh.Wp()).toString();
        x.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", new Object[]{hjx});
        return hjx;
    }

    public static void iu(String str) {
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "pref_appbrand_process", 4);
        String str2 = str + ":start_time";
        Editor edit = sharedPreferences.edit();
        edit.remove(str2);
        edit.commit();
        d.pPH.a(365, 5, 1, false);
        x.v("MicroMsg.AppBrandReporter", "onProcessExit");
    }
}
