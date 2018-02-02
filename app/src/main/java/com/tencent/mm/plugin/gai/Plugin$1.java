package com.tencent.mm.plugin.gai;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.gai.Plugin.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$1 implements a {
    final /* synthetic */ Plugin mQl;

    Plugin$1(Plugin plugin) {
        this.mQl = plugin;
    }

    public final void Bq(String str) {
        ac.getContext().getSharedPreferences(ac.cfs() + "_google_aid", 4).edit().putString("getgoogleaid", str).commit();
        String deviceID = q.getDeviceID(ac.getContext());
        String androidId = q.getAndroidId();
        String yG = q.yG();
        String string = ac.getContext().getSharedPreferences(ac.cfs(), 0).getString("installreferer", "");
        x.i("MicroMsg.Plugin.gai", "Advertisement MAT rsakv logID:%d val:%s", new Object[]{Integer.valueOf(11238), String.format("%s,%s,%s,%s,%s,%s", new Object[]{"", deviceID, androidId, yG, str, string})});
        g.pQN.a(11238, r0, true, true);
        ac.getContext().getSharedPreferences(ac.cfs() + "_google_aid", 4).edit().putBoolean("already_report_googleaid", true).commit();
    }
}
