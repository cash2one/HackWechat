package com.tencent.mm.ae;

import com.tencent.mm.network.a.b;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.h;
import com.tencent.mm.network.i;
import com.tencent.mm.network.l;
import com.tencent.mm.network.o;
import com.tencent.mm.network.r;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class p implements e {
    public final f hnm;
    private o hnn;

    public p(f fVar) {
        this.hnm = fVar;
    }

    public final int a(r rVar, l lVar) {
        try {
            return this.hnm.a(rVar, lVar);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
            return -1;
        }
    }

    public final String getNetworkServerIp() {
        try {
            return this.hnm.getNetworkServerIp();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final String[] getIPsString(boolean z) {
        try {
            return this.hnm.getIPsString(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final void cancel(int i) {
        try {
            this.hnm.cancel(i);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", new Object[]{Integer.valueOf(i), e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void reset() {
        try {
            this.hnm.reset();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        try {
            this.hnm.a(z, str, str2, iArr, iArr2, i, i2, str3, str4);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final c Kx() {
        try {
            if (this.hnn == null) {
                this.hnn = new o(this.hnm.Vo());
            }
            return this.hnn;
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final void a(b bVar) {
        try {
            this.hnm.a(bVar);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void bE(boolean z) {
        try {
            this.hnm.bE(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final boolean Kn() {
        boolean z = true;
        try {
            z = this.hnm.Kn();
        } catch (Throwable e) {
            Object[] objArr = new Object[z];
            objArr[0] = e;
            x.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", objArr);
            objArr = new Object[z];
            objArr[0] = bh.i(e);
            x.e("MicroMsg.RDispatcher", "exception:%s", objArr);
        }
        return z;
    }

    public final i Ky() {
        try {
            return this.hnm.Vq();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final void a(ab abVar) {
        try {
            this.hnm.a(abVar);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void jq(String str) {
        try {
            this.hnm.jq(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", new Object[]{e});
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final int getHostByName(String str, List<String> list) {
        try {
            return this.hnm.getHostByName(str, list);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
            return -1;
        }
    }

    public final int a(String str, boolean z, List<String> list) {
        try {
            return this.hnm.a(str, z, list);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
            return -1;
        }
    }

    public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
        try {
            this.hnm.setHostInfo(strArr, strArr2, iArr);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void a(int i, String str, int i2, boolean z) {
        try {
            this.hnm.a(i, str, i2, z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final String getIspId() {
        try {
            return this.hnm.getIspId();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final void setSignallingStrategy(long j, long j2) {
        try {
            this.hnm.setSignallingStrategy(j, j2);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void keepSignalling() {
        try {
            this.hnm.keepSignalling();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void stopSignalling() {
        try {
            this.hnm.stopSignalling();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void a(o oVar) {
        try {
            this.hnm.a(oVar);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void reportFailIp(String str) {
        try {
            this.hnm.reportFailIp(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void jr(String str) {
        try {
            this.hnm.jr(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void bF(boolean z) {
        try {
            this.hnm.bF(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void bG(boolean z) {
        try {
            this.hnm.bG(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void bH(boolean z) {
        try {
            this.hnm.bH(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void Kz() {
        try {
            this.hnm.Kz();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void a(h hVar) {
        try {
            this.hnm.a(hVar);
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }

    public final void KA() {
        try {
            this.hnm.KA();
        } catch (Throwable e) {
            x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bh.i(e)});
        }
    }
}
