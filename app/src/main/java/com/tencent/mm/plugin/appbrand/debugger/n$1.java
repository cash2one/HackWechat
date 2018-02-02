package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.j.j;
import com.tencent.mm.plugin.appbrand.r.a.a;
import com.tencent.mm.plugin.appbrand.r.d.d;
import com.tencent.mm.plugin.appbrand.r.d.d$a;
import com.tencent.mm.plugin.appbrand.r.e.h;
import com.tencent.mm.plugin.appbrand.r.f.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

class n$1 extends a {
    private d iRa = null;
    final /* synthetic */ j.a iRb;
    final /* synthetic */ n iRc;

    n$1(n nVar, URI uri, com.tencent.mm.plugin.appbrand.r.b.a aVar, Map map, j.a aVar2) {
        this.iRc = nVar;
        this.iRb = aVar2;
        super(uri, aVar, map, 60000);
    }

    public final void b(h hVar) {
        x.d("MicroMsg.RemoteDebugSocket", "onSocketOpen");
        this.iRb.a(hVar);
    }

    public final void ri(String str) {
        this.iRc.iQY.uI(str);
        x.d("MicroMsg.RemoteDebugSocket", "onSocketMessage, message: %s", new Object[]{str});
        this.iRb.rf(str);
    }

    public final void F(int i, String str) {
        x.i("MicroMsg.RemoteDebugSocket", "onClose,reason: %s, errCode = %d", new Object[]{str, Integer.valueOf(i)});
        if (i == -1 || i == -2 || i == -3) {
            if (an.isConnected(ac.getContext())) {
                this.iRb.re(str);
            } else {
                this.iRb.re("network is down");
                i = 1006;
            }
            this.iRb.C(i, str);
            return;
        }
        this.iRb.C(i, str);
    }

    public final void b(Exception exception) {
        x.e("MicroMsg.RemoteDebugSocket", "onSocketError, ex: " + exception.toString());
    }

    public final void f(ByteBuffer byteBuffer) {
        this.iRb.e(byteBuffer);
    }

    public final void a(d dVar) {
        if (dVar.alY() != d$a.CONTINUOUS && !dVar.alW()) {
            this.iRa = dVar;
        } else if (dVar.alY() == d$a.CONTINUOUS && this.iRa != null) {
            if (this.iRa.alV().position() > 10485760) {
                x.e("MicroMsg.RemoteDebugSocket", "Pending Frame exploded");
                this.iRa = null;
                return;
            }
            try {
                this.iRa.e(dVar);
            } catch (Exception e) {
                x.e("MicroMsg.RemoteDebugSocket", e.getMessage());
            }
            if (dVar.alW()) {
                if (this.iRa.alY() == d$a.BINARY) {
                    f(this.iRa.alV());
                } else if (this.iRa.alY() == d$a.TEXT) {
                    try {
                        ri(bh.ou(b.v(this.iRa.alV())));
                    } catch (Exception e2) {
                        x.e("MicroMsg.RemoteDebugSocket", e2.getMessage());
                    }
                }
                this.iRa = null;
            }
        }
    }
}
