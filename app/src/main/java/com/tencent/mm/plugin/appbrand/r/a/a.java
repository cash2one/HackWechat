package com.tencent.mm.plugin.appbrand.r.a;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.e.d;
import com.tencent.mm.plugin.appbrand.r.e.f;
import com.tencent.mm.plugin.appbrand.r.e.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;

public abstract class a extends b implements com.tencent.mm.plugin.appbrand.r.a, Runnable {
    public Timer bnp = null;
    private int jTA = 0;
    private com.tencent.mm.plugin.appbrand.r.b.a jTh;
    protected URI jTq = null;
    public c jTr = null;
    private Socket jTs = null;
    private InputStream jTt;
    OutputStream jTu;
    private Proxy jTv = Proxy.NO_PROXY;
    public Runnable jTw;
    private Map<String, String> jTx;
    private CountDownLatch jTy = new CountDownLatch(1);
    private CountDownLatch jTz = new CountDownLatch(1);
    public String jbo;

    public abstract void F(int i, String str);

    public abstract void b(h hVar);

    public abstract void b(Exception exception);

    public abstract void ri(String str);

    static /* synthetic */ void d(a aVar) {
        try {
            if (aVar.jTs != null) {
                aVar.jTs.close();
            }
        } catch (Exception e) {
            aVar.b(e);
        }
    }

    public a(URI uri, com.tencent.mm.plugin.appbrand.r.b.a aVar, Map<String, String> map, int i) {
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (aVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.jTq = uri;
            this.jTh = aVar;
            this.jTx = map;
            this.jTA = i;
            this.jTr = new c(this, aVar);
        }
    }

    public final void connect() {
        if (this.jTw != null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
            return;
        }
        this.jTw = this;
        e.post(this.jTw, "WebsocketWriteThread");
    }

    public final void close() {
        if (this.jTw != null) {
            this.jTr.d(1000, "", false);
        }
    }

    public final void uI(String str) {
        c cVar = this.jTr;
        if (str == null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
        } else {
            cVar.d(cVar.jTh.Z(str, cVar.jTi == com.tencent.mm.plugin.appbrand.r.a.b.jSU));
        }
    }

    public void run() {
        try {
            if (this.jTs == null) {
                this.jTs = new Socket(this.jTv);
            } else if (this.jTs.isClosed()) {
                throw new IOException();
            }
            if (!this.jTs.isBound()) {
                this.jTs.connect(new InetSocketAddress(this.jTq.getHost(), getPort()), this.jTA);
            }
            this.jTt = this.jTs.getInputStream();
            this.jTu = this.jTs.getOutputStream();
            alR();
            this.jTw = new a(this, (byte) 0);
            e.post(this.jTw, "WebsocketWriteThread");
            byte[] bArr = new byte[c.jSX];
            while (!this.jTr.alQ() && !this.jTr.isClosed()) {
                try {
                    int read = this.jTt.read(bArr);
                    if (read != -1) {
                        this.jTr.k(ByteBuffer.wrap(bArr, 0, read));
                    }
                } catch (IOException e) {
                    this.jTr.alP();
                    return;
                } catch (Exception e2) {
                    b(e2);
                    this.jTr.e(1006, e2.getMessage(), false);
                    return;
                }
            }
            this.jTr.alP();
        } catch (Exception e22) {
            this.jTr.e(-1, e22.getMessage(), false);
        }
    }

    private int getPort() {
        int port = this.jTq.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.jTq.getScheme();
        if (scheme.equals("wss")) {
            return JsApiPauseDownloadTask.CTRL_INDEX;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme" + scheme);
    }

    private void alR() {
        String path = this.jTq.getPath();
        String query = this.jTq.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            path = path + "?" + query;
        }
        int port = getPort();
        query = this.jTq.getHost() + (port != 80 ? ":" + port : "");
        com.tencent.mm.plugin.appbrand.r.e.b dVar = new d();
        dVar.uK(path);
        dVar.put("Host", query);
        if (this.jTx != null) {
            for (Entry entry : this.jTx.entrySet()) {
                dVar.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        c cVar = this.jTr;
        cVar.jTl = cVar.jTh.a(dVar);
        cVar.jTp = dVar.alZ();
        if (cVar.jTp != null) {
            com.tencent.mm.plugin.appbrand.r.b.a aVar = cVar.jTh;
            f fVar = cVar.jTl;
            int i = cVar.jTi;
            cVar.ae(com.tencent.mm.plugin.appbrand.r.b.a.c(fVar));
        }
    }

    public final void uH(String str) {
        ri(str);
    }

    public final void o(ByteBuffer byteBuffer) {
        f(byteBuffer);
    }

    public final void c(com.tencent.mm.plugin.appbrand.r.d.d dVar) {
        a(dVar);
    }

    public final void b(f fVar) {
        this.jTy.countDown();
        b((h) fVar);
    }

    public final void O(int i, String str) {
        this.jTy.countDown();
        this.jTz.countDown();
        if (this.jTw != null) {
            e.Q(this.jTw);
        }
        try {
            if (this.jTs != null) {
                this.jTs.close();
            }
        } catch (Exception e) {
            b(e);
        }
        F(i, str);
    }

    public final void d(Exception exception) {
        b(exception);
    }

    public void f(ByteBuffer byteBuffer) {
    }

    public void a(com.tencent.mm.plugin.appbrand.r.d.d dVar) {
    }

    public final void a(Socket socket) {
        if (this.jTs != null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
        } else {
            this.jTs = socket;
        }
    }

    public final void P(int i, String str) {
        this.jTr.d(i, str, false);
    }

    public final void p(ByteBuffer byteBuffer) {
        c cVar = this.jTr;
        if (byteBuffer == null) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
        } else {
            cVar.d(cVar.jTh.a(byteBuffer, cVar.jTi == com.tencent.mm.plugin.appbrand.r.a.b.jSU));
        }
    }

    public final void b(com.tencent.mm.plugin.appbrand.r.d.d dVar) {
        this.jTr.b(dVar);
    }
}
