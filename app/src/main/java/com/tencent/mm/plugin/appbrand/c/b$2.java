package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.modelcdntran.j.a;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b iLE;

    b$2(b bVar) {
        this.iLE = bVar;
    }

    public final void onMoovReady(String str, int i, int i2) {
        x.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on moov ready [%s %d %d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        c cVar = (c) this.iLE.iLC.get(str);
        if (cVar != null) {
            cVar.bx(i, i2);
        }
    }

    public final void onDataAvailable(String str, int i, int i2) {
        x.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on data available [%s %d %d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        c cVar = (c) this.iLE.iLC.get(str);
        if (cVar != null) {
            cVar.by(i, i2);
        }
    }

    public final void g(String str, int i, int i2) {
        x.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on progress [%s %d %d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        c cVar = (c) this.iLE.iLC.get(str);
        if (cVar != null) {
            cVar.bz(i, i2);
        }
    }

    public final void K(String str, int i) {
        x.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on finish [%s %d]", new Object[]{str, Integer.valueOf(i)});
        c cVar = (c) this.iLE.iLC.get(str);
        if (cVar != null) {
            cVar.K(str, i);
        }
    }
}
