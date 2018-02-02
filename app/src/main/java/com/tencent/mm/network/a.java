package com.tencent.mm.network;

import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.at;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.network.d.a implements c {
    private boolean foreground = false;
    private byte[] hZs;
    private a hZt = null;
    byte[] hZu;
    String hZv;
    private Map<String, byte[]> hZw = new HashMap();
    byte[] hnJ;
    private int uin;
    String username;

    public a(a aVar) {
        this.hZt = aVar;
        Vm();
    }

    public final void reset() {
        x.i("MicroMsg.AccInfo", "reset accinfo");
        this.username = "";
        this.hZs = null;
        Vm();
        this.uin = 0;
    }

    private void Vm() {
        this.hnJ = bh.VD(at.Hn().getString("server_id", ""));
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final void v(byte[] bArr, int i) {
        x.i("MicroMsg.AccInfo", "summerauth update session info: session:%s, uin:%d -> %d stack:[%s]", new Object[]{bh.VT(bh.bv(bArr)), Integer.valueOf(this.uin), Integer.valueOf(i), bh.cgy()});
        this.hZs = bArr;
        this.uin = i;
        if (this.hZt != null) {
            Kt();
        }
    }

    public final void L(byte[] bArr) {
        this.hnJ = bArr;
    }

    public final void M(byte[] bArr) {
        this.hZu = bArr;
    }

    public final byte[] CF() {
        return this.hZs;
    }

    public final byte[] Ku() {
        return this.hZu;
    }

    public final byte[] Ks() {
        return this.hnJ;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int Cg() {
        return this.uin;
    }

    public final boolean Kt() {
        return this.hZs != null && this.hZs.length > 0;
    }

    public final String toString() {
        return ((((("AccInfo:\n" + "|-uin     =" + Cg() + "\n") + "|-user    =" + getUsername() + "\n") + "|-wxuser  =" + KS() + "\n") + "|-session =" + bh.bv(CF()) + "\n") + "|-ecdhkey =" + bh.bv(Ku()) + "\n") + "`-cookie  =" + bh.bv(Ks());
    }

    public final void og(String str) {
        this.hZv = str;
    }

    public final String KS() {
        return this.hZv;
    }

    public final void g(String str, byte[] bArr) {
        this.hZw.put(str, bArr);
    }

    public final byte[] jp(String str) {
        return (byte[]) this.hZw.get(str);
    }

    public final boolean Kv() {
        return this.foreground;
    }

    public final void bD(boolean z) {
        this.foreground = z;
        x.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", new Object[]{Boolean.valueOf(this.foreground)});
    }

    private void clear() {
        this.username = null;
        this.hZs = null;
        this.hnJ = null;
        this.uin = 0;
        this.hZu = null;
        this.hZv = null;
    }

    private String Vn() {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(Downloads.RECV_BUFFER_SIZE);
            allocate.put(this.hZs).put(this.hZu).put(this.hnJ).putInt(this.uin).put(this.hZv.getBytes()).put(this.username.getBytes());
            return g.s(allocate.array());
        } catch (Exception e) {
            return "";
        }
    }

    public final byte[] Kw() {
        long Wp = bh.Wp();
        int i = bh.ov(this.username) ? 0 : bh.bw(this.hZs) ? 0 : bh.bw(this.hnJ) ? 0 : (this.uin == 0 || this.uin == -1) ? 0 : bh.bw(this.hZu) ? 0 : bh.ov(this.hZv) ? 0 : 1;
        if (i == 0) {
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
            return null;
        }
        try {
            u uVar = new u();
            uVar.ceX();
            uVar.UV(this.username);
            uVar.UV(this.hZv);
            uVar.Dd(this.uin);
            uVar.bs(this.hnJ);
            uVar.bs(this.hZu);
            uVar.bs(this.hZs);
            uVar.UV(Vn());
            x.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", new Object[]{Long.valueOf(bh.bz(Wp)), Integer.valueOf(uVar.ceY().length), r6});
            return uVar.ceY();
        } catch (Throwable e) {
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final int G(byte[] bArr) {
        long Wp = bh.Wp();
        if (Kt()) {
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
            return -2;
        }
        try {
            u uVar = new u();
            if (uVar.br(bArr) != 0) {
                x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[]{Integer.valueOf(uVar.br(bArr))});
                return -3;
            }
            this.username = uVar.getString();
            this.hZv = uVar.getString();
            this.uin = uVar.getInt();
            this.hnJ = uVar.getBuffer();
            this.hZu = uVar.getBuffer();
            this.hZs = uVar.getBuffer();
            String string = uVar.getString();
            if (bh.ov(string) || !string.equals(Vn())) {
                clear();
                x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
                return -4;
            }
            x.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[]{Long.valueOf(bh.bz(Wp)), string});
            return 0;
        } catch (Throwable e) {
            clear();
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[]{bh.i(e)});
            return -5;
        }
    }

    public final void eE(int i) {
        x.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", new Object[]{Integer.valueOf(this.uin), Integer.valueOf(i), bh.cgy()});
        this.uin = i;
    }
}
