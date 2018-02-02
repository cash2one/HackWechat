package com.tencent.mm.plugin.gcm;

import com.tencent.mm.g.a.gu;
import com.tencent.mm.plugin.gcm.modelgcm.GcmBroadcastReceiver;
import com.tencent.mm.plugin.gcm.modelgcm.a;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    com.tencent.mm.sdk.b.c nyc = new 1(this);
    com.tencent.mm.sdk.b.c nyd = new com.tencent.mm.sdk.b.c<gu>(this) {
        final /* synthetic */ Plugin nye;

        {
            this.nye = r2;
            this.xen = gu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a aSa = a.aSa();
            if (aSa == null) {
                return false;
            }
            x.i("GcmRegister", "GCM onLogout. isRegToSvr:" + aSa.aSi());
            GcmBroadcastReceiver.aRZ();
            if (aSa.aSi()) {
                aSa.aSh();
            }
            return true;
        }
    };

    public Plugin() {
        com.tencent.mm.sdk.b.a.xef.b(this.nyc);
        com.tencent.mm.sdk.b.a.xef.b(this.nyd);
    }

    public p createApplication() {
        return new com.tencent.mm.plugin.gcm.a.a();
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new com.tencent.mm.plugin.gcm.modelgcm.b();
    }
}
