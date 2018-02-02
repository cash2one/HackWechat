package com.tencent.mm.plugin.appbrand.r;

import com.tencent.mm.plugin.appbrand.r.b.a;
import com.tencent.mm.plugin.appbrand.r.b.b;
import com.tencent.mm.plugin.appbrand.r.d.d;
import com.tencent.mm.plugin.appbrand.r.e.f;
import com.tencent.mm.plugin.appbrand.r.e.h;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class c implements a {
    public static boolean DEBUG = false;
    public static int jSX = 16384;
    public static final List<a> jSY;
    public SelectionKey jSZ;
    public ByteChannel jTa;
    public final BlockingQueue<ByteBuffer> jTb;
    public final BlockingQueue<ByteBuffer> jTc;
    private volatile boolean jTd = false;
    private int jTe = a.a.jSO;
    public final d jTf;
    private List<a> jTg;
    public a jTh = null;
    public int jTi;
    private d.a jTj = null;
    private ByteBuffer jTk = ByteBuffer.allocate(0);
    public com.tencent.mm.plugin.appbrand.r.e.a jTl = null;
    private String jTm = null;
    private Integer jTn = null;
    private Boolean jTo = null;
    public String jTp = null;

    static {
        List arrayList = new ArrayList(4);
        jSY = arrayList;
        arrayList.add(new com.tencent.mm.plugin.appbrand.r.b.c());
        jSY.add(new b());
        jSY.add(new com.tencent.mm.plugin.appbrand.r.b.d());
    }

    public c(d dVar, a aVar) {
        if (dVar == null || (aVar == null && this.jTi == a.b.jSV)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.jTb = new LinkedBlockingQueue();
        this.jTc = new LinkedBlockingQueue();
        this.jTf = dVar;
        this.jTi = a.b.jSU;
        if (aVar != null) {
            this.jTh = aVar.alT();
        }
    }

    public final void k(ByteBuffer byteBuffer) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
        }
        if (this.jTe != a.a.jSO) {
            if (this.jTe == a.a.jSQ) {
                m(byteBuffer);
            }
        } else if (l(byteBuffer) && !alQ() && !isClosed()) {
            if (byteBuffer.hasRemaining()) {
                m(byteBuffer);
            } else if (this.jTk.hasRemaining()) {
                m(this.jTk);
            }
        }
    }

    private boolean l(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.jTk.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.jTk.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.jTk.capacity() + byteBuffer.remaining());
                this.jTk.flip();
                allocate.put(this.jTk);
                this.jTk = allocate;
            }
            this.jTk.put(byteBuffer);
            this.jTk.flip();
            byteBuffer2 = this.jTk;
        }
        byteBuffer2.mark();
        try {
            f s;
            if (this.jTi != a.b.jSV) {
                if (this.jTi == a.b.jSU) {
                    this.jTh.lM(this.jTi);
                    s = this.jTh.s(byteBuffer2);
                    if (s instanceof h) {
                        s = (h) s;
                        if (this.jTh.a(this.jTl, s) == a.b.jTK) {
                            a(s);
                            return true;
                        }
                        d(1002, "draft refuses handshake" + s.ama(), false);
                    } else {
                        f(1002, "wrong http function", false);
                        return false;
                    }
                }
                return false;
            } else if (this.jTh == null) {
                for (a alT : this.jTg) {
                    a alT2 = alT.alT();
                    try {
                        alT2.lM(this.jTi);
                        byteBuffer2.reset();
                        s = alT2.s(byteBuffer2);
                        if (s instanceof com.tencent.mm.plugin.appbrand.r.e.a) {
                            s = (com.tencent.mm.plugin.appbrand.r.e.a) s;
                            if (alT2.a(s) == a.b.jTK) {
                                this.jTp = s.alZ();
                                try {
                                    ae(a.c(alT2.a(s, this.jTf.alO())));
                                    this.jTh = alT2;
                                    a(s);
                                    return true;
                                } catch (com.tencent.mm.plugin.appbrand.r.c.b e) {
                                    f(e.jTT, e.getMessage(), false);
                                    return false;
                                } catch (Exception e2) {
                                    this.jTf.d(e2);
                                    f(-1, e2.getMessage(), false);
                                    return false;
                                }
                            }
                            continue;
                        } else {
                            f(1002, "wrong http function", false);
                            return false;
                        }
                    } catch (com.tencent.mm.plugin.appbrand.r.c.d e3) {
                        x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "InvalidHandshakeException e: " + e3.toString());
                    }
                }
                if (this.jTh == null) {
                    d(1002, "no draft matches", false);
                }
                return false;
            } else {
                s = this.jTh.s(byteBuffer2);
                if (s instanceof com.tencent.mm.plugin.appbrand.r.e.a) {
                    s = (com.tencent.mm.plugin.appbrand.r.e.a) s;
                    if (this.jTh.a(s) == a.b.jTK) {
                        a(s);
                        return true;
                    }
                    d(1002, "the handshake did finaly not match", false);
                    return false;
                }
                f(1002, "wrong http function", false);
                return false;
            }
        } catch (com.tencent.mm.plugin.appbrand.r.c.b e4) {
            try {
                x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e4.toString());
                a(e4);
            } catch (com.tencent.mm.plugin.appbrand.r.c.a e5) {
                x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e5.toString());
                if (this.jTk.capacity() == 0) {
                    byteBuffer2.reset();
                    int i = e5.jTS;
                    if (i == 0) {
                        i = byteBuffer2.capacity() + 16;
                    }
                    this.jTk = ByteBuffer.allocate(i);
                    this.jTk.put(byteBuffer);
                } else {
                    this.jTk.position(this.jTk.limit());
                    this.jTk.limit(this.jTk.capacity());
                }
            }
        }
    }

    private void m(ByteBuffer byteBuffer) {
        try {
            for (d dVar : this.jTh.r(byteBuffer)) {
                if (DEBUG) {
                    x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: " + dVar);
                }
                d.a alY = dVar.alY();
                boolean alW = dVar.alW();
                if (alY == d.a.jUb) {
                    int alU;
                    String message;
                    String str = "";
                    if (dVar instanceof com.tencent.mm.plugin.appbrand.r.d.a) {
                        com.tencent.mm.plugin.appbrand.r.d.a aVar = (com.tencent.mm.plugin.appbrand.r.d.a) dVar;
                        alU = aVar.alU();
                        message = aVar.getMessage();
                    } else {
                        message = str;
                        alU = 1005;
                    }
                    if (this.jTe == a.a.jSR) {
                        e(alU, message, true);
                    } else if (this.jTh.alS() == a.a.jTI) {
                        d(alU, message, true);
                    } else {
                        f(alU, message, false);
                    }
                } else if (alY == d.a.jTZ) {
                    this.jTf.a(this, dVar);
                } else if (alY == d.a.jUa) {
                    continue;
                } else if (!alW || alY == d.a.jTW) {
                    if (alY != d.a.jTW) {
                        if (this.jTj != null) {
                            throw new com.tencent.mm.plugin.appbrand.r.c.b("Previous continuous frame sequence not completed.");
                        }
                        this.jTj = alY;
                    } else if (alW) {
                        if (this.jTj == null) {
                            throw new com.tencent.mm.plugin.appbrand.r.c.b("Continuous frame sequence was not started.");
                        }
                        this.jTj = null;
                    } else if (this.jTj == null) {
                        throw new com.tencent.mm.plugin.appbrand.r.c.b("Continuous frame sequence was not started.");
                    }
                    try {
                        this.jTf.c(dVar);
                    } catch (Exception e) {
                        this.jTf.d(e);
                    }
                } else if (this.jTj != null) {
                    throw new com.tencent.mm.plugin.appbrand.r.c.b("Continuous frame sequence not completed.");
                } else if (alY == d.a.jTX) {
                    try {
                        this.jTf.uH(com.tencent.mm.plugin.appbrand.r.f.b.v(dVar.alV()));
                    } catch (Exception e2) {
                        this.jTf.d(e2);
                    }
                } else if (alY == d.a.jTY) {
                    try {
                        this.jTf.o(dVar.alV());
                    } catch (Exception e22) {
                        this.jTf.d(e22);
                    }
                } else {
                    throw new com.tencent.mm.plugin.appbrand.r.c.b("non control or continious frame expected");
                }
            }
        } catch (com.tencent.mm.plugin.appbrand.r.c.b e3) {
            x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + e3.toString());
            this.jTf.d(e3);
            a(e3);
        }
    }

    public void d(int i, String str, boolean z) {
        if (this.jTe != a.a.jSR && this.jTe != a.a.jSS) {
            if (this.jTe == a.a.jSQ) {
                if (i == 1006) {
                    this.jTe = a.a.jSR;
                    f(i, str, false);
                    return;
                }
                if (this.jTh.alS() != a.a.jTG) {
                    try {
                        b(new com.tencent.mm.plugin.appbrand.r.d.b(i, str));
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + e.toString());
                        this.jTf.d(e);
                        f(1006, "generated frame is invalid", false);
                    }
                }
                f(i, str, z);
            } else if (i == -3) {
                f(-3, str, true);
            } else {
                f(-1, str, false);
            }
            if (i == 1002) {
                f(i, str, z);
            }
            this.jTe = a.a.jSR;
            this.jTk = null;
        }
    }

    public synchronized void e(int i, String str, boolean z) {
        if (this.jTe != a.a.jSS) {
            if (this.jSZ != null) {
                this.jSZ.cancel();
            }
            if (this.jTa != null) {
                try {
                    this.jTa.close();
                } catch (Exception e) {
                    this.jTf.d(e);
                }
            }
            try {
                this.jTf.O(i, str);
            } catch (Exception e2) {
                this.jTf.d(e2);
            }
            if (this.jTh != null) {
                this.jTh.reset();
            }
            this.jTl = null;
            this.jTe = a.a.jSS;
            this.jTb.clear();
        }
    }

    private void lK(int i) {
        e(i, "", true);
    }

    private synchronized void f(int i, String str, boolean z) {
        if (!this.jTd) {
            this.jTn = Integer.valueOf(i);
            this.jTm = str;
            this.jTo = Boolean.valueOf(z);
            this.jTd = true;
            if (this.jTh != null) {
                this.jTh.reset();
            }
            this.jTl = null;
        }
    }

    public final void alP() {
        if (this.jTe == a.a.jSO) {
            lK(-1);
        } else if (this.jTd) {
            e(this.jTn.intValue(), this.jTm, this.jTo.booleanValue());
        } else if (this.jTh.alS() == a.a.jTG) {
            lK(1000);
        } else if (this.jTh.alS() != a.a.jTH || this.jTi == a.b.jSV) {
            lK(1006);
        } else {
            lK(1000);
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.r.c.b bVar) {
        d(bVar.jTT, bVar.getMessage(), false);
    }

    public final void d(Collection<d> collection) {
        if (isOpen()) {
            for (d b : collection) {
                b(b);
            }
            return;
        }
        throw new com.tencent.mm.plugin.appbrand.r.c.f();
    }

    public final void b(d dVar) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
        }
        n(this.jTh.d(dVar));
    }

    private void n(ByteBuffer byteBuffer) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
        }
        this.jTb.add(byteBuffer);
    }

    public final void ae(List<ByteBuffer> list) {
        for (ByteBuffer n : list) {
            n(n);
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            x.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.jTh.getClass().getSimpleName());
        }
        this.jTe = a.a.jSQ;
        try {
            this.jTf.b(fVar);
        } catch (Exception e) {
            this.jTf.d(e);
        }
    }

    public final boolean isOpen() {
        return this.jTe == a.a.jSQ;
    }

    public final boolean alQ() {
        return this.jTe == a.a.jSR;
    }

    public final boolean isClosed() {
        return this.jTe == a.a.jSS;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return super.toString();
    }
}
