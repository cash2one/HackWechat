package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.d.2;
import com.tencent.mm.plugin.exdevice.model.d.3;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.s$a;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public class h extends s$a {
    protected static final String TAG = h.class.getName();
    private boolean lMx = false;
    f lMy = new f();
    private a lMz = new a(this) {
        final /* synthetic */ h lMA;

        {
            this.lMA = r1;
        }

        public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
            x.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, Integer.valueOf(i3), b.ap(bArr)});
            if (1 == i) {
                ad.aEv().h(str3, str2, false);
            } else if (2 == i) {
                ad.aEv().h(str3, str2, true);
            } else {
                x.e(h.TAG, "unknown message type %d", new Object[]{Integer.valueOf(i)});
            }
            if (ad.aEk().cJ(b.zu(str2)) != null) {
                x.d(h.TAG, "the founded device hasn't been binded");
            }
        }
    };

    public final void aEa() {
        if (this.lMx) {
            x.d(TAG, "still scanning. return");
            return;
        }
        d aEr = ad.aEr();
        j jVar = this.lMz;
        x.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
        if (aEr.lKB == null) {
            aEr.lKB = new c();
            aEr.lKB.lQd = new 2(aEr, jVar);
            aEr.lKB.cx(ac.getContext());
        } else if (u.aEM().lKw == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
            if (!u.aEM().lKw.a(jVar)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
        }
        this.lMx = true;
    }

    public final void arf() {
        if (this.lMx) {
            d aEr = ad.aEr();
            j jVar = this.lMz;
            x.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
            if (aEr.lKB == null) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (u.aEM().lKw == null) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!u.aEM().lKw.b(jVar)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.lMx = false;
            return;
        }
        x.d(TAG, "not yet scan. return");
    }

    public final void a(long j, a aVar) {
        f.a cA = this.lMy.cA(j);
        if (cA == null || 2 != cA.fsg) {
            d aEr = ad.aEr();
            k 2 = new 2(this, aVar);
            x.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
            if (aEr.lKB == null) {
                aEr.lKB = new c();
                aEr.lKB.lQd = new 3(aEr, j, 2);
                aEr.lKB.cx(ac.getContext());
                return;
            }
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
            m mVar = u.aEM().lKw;
            if (mVar == null || !mVar.a(j, 2)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
                return;
            }
            return;
        }
        x.d(TAG, "device(" + j + ") has been connected");
        aVar.a(j, 2, 2, 0, cA.kxJ);
    }

    public static void cn(long j) {
        d aEr = ad.aEr();
        x.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
        if (aEr.lKB == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
        } else if (u.aEM().lKw == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else if (!u.aEM().lKw.cI(j)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
        }
    }

    public static boolean a(long j, byte[] bArr, t tVar) {
        boolean z = false;
        if (bArr == null || bArr.length <= 0) {
            x.e(TAG, "no data for transmit");
        } else if (u.aEM().lKw == null) {
            x.e(TAG, "can not send data");
        } else {
            z = u.aEM().lKw.b(j, bArr, tVar);
            if (!z) {
                x.e(TAG, "simpleBluetoothSendData error");
            }
        }
        return z;
    }

    public final void c(long j, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            x.e(TAG, "data is null or nil");
            return;
        }
        List<e.b> linkedList;
        x.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[]{Long.valueOf(j), b.ap(bArr)});
        e aEv = ad.aEv();
        String cK = b.cK(j);
        synchronized (aEv.lKU) {
            linkedList = new LinkedList(aEv.lKU);
        }
        for (e.b b : linkedList) {
            b.b(cK, bArr, true);
        }
        linkedList.clear();
        for (e.b b2 : aEv.lKV.values()) {
            b2.b(cK, bArr, true);
        }
        com.tencent.mm.sdk.b.b ehVar = new eh();
        ehVar.fsV.mac = cK;
        ehVar.fsV.data = bArr;
        com.tencent.mm.sdk.b.a.xef.a(ehVar, Looper.getMainLooper());
    }
}
