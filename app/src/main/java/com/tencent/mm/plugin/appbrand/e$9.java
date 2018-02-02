package com.tencent.mm.plugin.appbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class e$9 extends a {
    final /* synthetic */ e irf;
    private boolean irh = false;

    e$9(e eVar) {
        this.irf = eVar;
    }

    public final void YH() {
        if (this.irh) {
            e eVar = this.irf;
            x.i("MicroMsg.AppBrandRuntime", "onReconnected: %s", new Object[]{eVar.mAppId});
            eVar.iqI.aI(eVar.mAppId, eVar.iqw.iGA);
            MMToClientEvent.sa(eVar.mAppId);
            c.pb(eVar.mAppId);
            if (!(eVar.gSX || eVar.iqW)) {
                x.e("MicroMsg.AppBrandRuntime", "Main Process Restarted, start prepare again");
                eVar.YB();
            }
        }
        this.irh = false;
    }

    public final void onDisconnected(String str) {
        this.irh = true;
        long j = this.irf.iqI.jJH;
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "pref_appbrand_process", 4);
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.getLong("on_wxa_process_connected_time", 0) == j) {
            edit.remove("on_wxa_process_connected_time");
            edit.commit();
            d.pPH.a(365, 1, 1, false);
            x.v("MicroMsg.AppBrandReporter", "delete timestamp(%s) and report(%d)", new Object[]{Long.valueOf(j), Integer.valueOf(365)});
            return;
        }
        x.v("MicroMsg.AppBrandReporter", "do not need to report(%d), timestamp(cur : %s, sp : %s)", new Object[]{Long.valueOf(j), Integer.valueOf(365), Long.valueOf(j), Long.valueOf(sharedPreferences.getLong("on_wxa_process_connected_time", 0))});
    }
}
