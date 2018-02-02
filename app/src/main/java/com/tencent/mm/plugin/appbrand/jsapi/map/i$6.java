package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.hardware.SensorManager;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.q.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.z.u$b;

class i$6 implements e {
    final /* synthetic */ u$b jeN;
    final /* synthetic */ p jfB;
    final /* synthetic */ b jmc;
    final /* synthetic */ i jmd;
    final /* synthetic */ SensorManager jmj;
    final /* synthetic */ i$b jmk;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.q.b.b jml;

    i$6(i iVar, p pVar, b bVar, SensorManager sensorManager, i$b com_tencent_mm_plugin_appbrand_jsapi_map_i_b, com.tencent.mm.plugin.appbrand.q.b.b bVar2, u$b com_tencent_mm_z_u_b) {
        this.jmd = iVar;
        this.jfB = pVar;
        this.jmc = bVar;
        this.jmj = sensorManager;
        this.jmk = com_tencent_mm_plugin_appbrand_jsapi_map_i_b;
        this.jml = bVar2;
        this.jeN = com_tencent_mm_z_u_b;
    }

    public final void onDestroy() {
        this.jfB.b(this);
        ag.y(new Runnable(this) {
            final /* synthetic */ i$6 jmm;

            {
                this.jmm = r1;
            }

            public final void run() {
                if (this.jmm.jmc != null) {
                    this.jmm.jmc.getView().setVisibility(8);
                    this.jmm.jmc.clean();
                }
            }
        });
        if (this.jmj != null) {
            this.jmj.unregisterListener(this.jmk);
        }
        a.b.alN().b(this.jml);
        this.jeN.recycle();
    }
}
