package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Log;
import com.tencent.mm.plugin.appbrand.j.i;
import com.tencent.mm.plugin.appbrand.j.j;
import com.tencent.mm.plugin.appbrand.r.a.a;
import com.tencent.mm.plugin.appbrand.r.b.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.sdk.platformtools.x;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class n {
    a iQY;
    private SSLSocketFactory iQZ;

    public n(String str) {
        SSLContext tx = i.tx(str);
        if (tx != null) {
            this.iQZ = tx.getSocketFactory();
        }
    }

    public final void a(String str, j.a aVar) {
        x.i("MicroMsg.RemoteDebugSocket", "connectSocket url is %s", new Object[]{str});
        try {
            URI uri = new URI(str);
            Map hashMap = new HashMap();
            if (str.startsWith("ws://localhost:")) {
                hashMap.put("Sec-WebSocket-Protocol", "client");
            }
            try {
                this.iQY = new 1(this, uri, new d(), hashMap, aVar);
                if (s.eE(str, "ws://")) {
                    this.iQY.a(new Socket(Proxy.NO_PROXY));
                    this.iQY.connect();
                    return;
                }
                SSLSocketFactory sSLSocketFactory;
                if (this.iQZ != null) {
                    sSLSocketFactory = this.iQZ;
                } else {
                    sSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                }
                this.iQY.a(sSLSocketFactory.createSocket());
                this.iQY.connect();
            } catch (Throwable e) {
                x.e("MicroMsg.RemoteDebugSocket", "onSocketMessage %s", new Object[]{Log.getStackTraceString(e)});
            }
        } catch (Exception e2) {
            x.e("MicroMsg.RemoteDebugSocket", "connect fail : %s ", new Object[]{e2.toString()});
            aVar.rg("url not well format");
        }
    }

    public final boolean isOpen() {
        if (this.iQY == null) {
            return false;
        }
        return this.iQY.jTr.isOpen();
    }

    public final boolean a(bvm com_tencent_mm_protocal_c_bvm) {
        x.d("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
        if (!isOpen()) {
            x.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
            return false;
        } else if (com_tencent_mm_protocal_c_bvm == null) {
            x.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
            return false;
        } else {
            this.iQY.p(o.c(com_tencent_mm_protocal_c_bvm));
            return true;
        }
    }
}
