package com.tencent.mm.plugin.appbrand.j;

import com.tencent.mm.plugin.appbrand.r.a.a;
import com.tencent.mm.plugin.appbrand.r.d.d;
import com.tencent.mm.plugin.appbrand.r.e.h;
import com.tencent.mm.plugin.appbrand.r.f.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

class j$1 extends a {
    private d iRa = null;
    final /* synthetic */ j.a jBT;
    final /* synthetic */ j jBU;
    final /* synthetic */ String val$url;

    j$1(j jVar, URI uri, com.tencent.mm.plugin.appbrand.r.b.a aVar, Map map, int i, String str, j.a aVar2) {
        this.jBU = jVar;
        this.val$url = str;
        this.jBT = aVar2;
        super(uri, aVar, map, i);
    }

    public final void b(h hVar) {
        x.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened", this.val$url);
        j.c(this);
        this.jBT.a(hVar);
    }

    public final void ri(String str) {
        String str2 = "MicroMsg.AppBrandNetworkWebSocket";
        String str3 = "url is %s ,socket onmessage length :%d";
        Object[] objArr = new Object[2];
        objArr[0] = this.val$url;
        objArr[1] = Integer.valueOf(str != null ? str.length() : -1);
        x.i(str2, str3, objArr);
        this.jBT.rf(str);
    }

    public final void F(int i, String str) {
        x.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d", this.val$url, str, Integer.valueOf(i));
        j.c(this);
        if (i == -1 || i == -2 || i == -3) {
            j.a aVar;
            String str2;
            if (an.isConnected(ac.getContext())) {
                aVar = this.jBT;
                str2 = bh.ov(str) ? "abnormal closure" : str;
            } else {
                aVar = this.jBT;
                str2 = "network is down";
            }
            aVar.re(str2);
            this.jBT.C(1006, str);
        } else {
            this.jBT.C(i, str);
        }
        this.jBU.b(this);
    }

    public final void b(Exception exception) {
        x.e("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,error is %s", this.val$url, exception.toString());
        this.jBT.re("exception " + exception.getMessage());
        this.jBU.b(this);
    }

    public final void f(ByteBuffer byteBuffer) {
        String str = "MicroMsg.AppBrandNetworkWebSocket";
        String str2 = "url is %s , socket onMessage buffer length : %d";
        Object[] objArr = new Object[2];
        objArr[0] = this.val$url;
        objArr[1] = Integer.valueOf(byteBuffer != null ? byteBuffer.capacity() : -1);
        x.i(str, str2, objArr);
        this.jBT.e(byteBuffer);
    }

    public final void a(d dVar) {
        if (dVar.alY() != d.a.jTW && !dVar.alW()) {
            this.iRa = dVar;
        } else if (dVar.alY() == d.a.jTW && this.iRa != null) {
            if (this.iRa.alV().position() > 10485760) {
                x.e("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
                this.iRa = null;
                return;
            }
            try {
                this.iRa.e(dVar);
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandNetworkWebSocket", e.getMessage());
            }
            if (dVar.alW()) {
                if (this.iRa.alY() == d.a.jTY) {
                    f(this.iRa.alV());
                } else if (this.iRa.alY() == d.a.jTX) {
                    try {
                        ri(bh.ou(b.v(this.iRa.alV())));
                    } catch (Exception e2) {
                        x.e("MicroMsg.AppBrandNetworkWebSocket", e2.getMessage());
                    }
                }
                this.iRa = null;
            }
        }
    }
}
