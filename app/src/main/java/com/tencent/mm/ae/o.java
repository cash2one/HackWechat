package com.tencent.mm.ae;

import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class o implements c {
    private final d hnl;

    public o(d dVar) {
        this.hnl = dVar;
    }

    public final byte[] Ks() {
        try {
            return this.hnl.Ks();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final byte[] CF() {
        try {
            return this.hnl.CF();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final int Cg() {
        int i = 0;
        try {
            i = this.hnl.Cg();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
        }
        return i;
    }

    private String getUsername() {
        try {
            return this.hnl.getUsername();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final boolean Kt() {
        boolean z = false;
        try {
            z = this.hnl.Kt();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
        }
        return z;
    }

    public final void setUsername(String str) {
        try {
            this.hnl.setUsername(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void v(byte[] bArr, int i) {
        try {
            this.hnl.v(bArr, i);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void reset() {
        try {
            this.hnl.reset();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final String toString() {
        return (((("RAccInfo:\n" + "|-uin     =" + Cg() + "\n") + "|-user    =" + getUsername() + "\n") + "|-session =" + CF() + "\n") + "|-ecdhkey =" + bh.bv(Ku()) + "\n") + "`-cookie  =" + bh.bv(Ks());
    }

    public final void g(String str, byte[] bArr) {
        try {
            this.hnl.g(str, bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final byte[] jp(String str) {
        try {
            return this.hnl.jp(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final byte[] Ku() {
        try {
            return this.hnl.Ku();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final void bD(boolean z) {
        try {
            this.hnl.bD(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final boolean Kv() {
        boolean z = true;
        try {
            z = this.hnl.Kv();
        } catch (Throwable e) {
            Object[] objArr = new Object[z];
            objArr[0] = bh.i(e);
            x.e("MicroMsg.RAccInfo", "exception:%s", objArr);
        }
        return z;
    }

    public final byte[] Kw() {
        try {
            return this.hnl.Kw();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final int G(byte[] bArr) {
        try {
            return this.hnl.G(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[]{bh.i(e)});
            return -6;
        }
    }

    public final void eE(int i) {
        try {
            this.hnl.eE(i);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", new Object[]{bh.i(e)});
        }
    }
}
