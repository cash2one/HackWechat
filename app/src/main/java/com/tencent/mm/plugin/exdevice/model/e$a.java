package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.g.a.b.a.f;
import com.tencent.mm.sdk.platformtools.x;

public class e$a implements b {
    private String bpq;
    final /* synthetic */ e lLO;
    private String lLR;
    private String lLS;
    private String mURL;

    public e$a(e eVar, String str, String str2, String str3, String str4) {
        this.lLO = eVar;
        this.lLR = str;
        this.bpq = str2;
        this.mURL = str3;
        this.lLS = str4;
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[]{str, str2});
    }

    public final void j(String str, String str2, boolean z) {
        if (this.bpq == null || !this.bpq.equals(str2)) {
            x.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[]{this.bpq, str2, Boolean.valueOf(z)});
        }
    }

    public final void b(String str, byte[] bArr, boolean z) {
        if (this.bpq == null || !this.bpq.equals(str)) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[]{this.bpq, str, Boolean.valueOf(z)});
        } else if (z && bArr != null) {
            try {
                ad.aEv();
                if (!e.b(this.bpq, this.lLR, bArr)) {
                    x.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
                }
            } catch (Exception e) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
            }
        }
    }

    public final void c(String str, int i, long j) {
        if (this.bpq == null || !this.bpq.equals(str)) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[]{this.bpq, str, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
        switch (i) {
            case 0:
                e.c(this.lLR, this.mURL, 0, this.lLS);
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[]{str});
                return;
            case 1:
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[]{str});
                e.c(this.lLR, this.mURL, 1, this.lLS);
                return;
            case 2:
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[]{str});
                e.c(this.lLR, this.mURL, 2, this.lLS);
                f fVar = new f();
                fVar.kyq = f.kzv;
                fVar.kyr = 2;
                ad.aEv().m(this.bpq, com.tencent.mm.plugin.exdevice.j.b.bp(fVar));
                return;
            case 4:
                e.c(this.lLR, this.mURL, 4, this.lLS);
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[]{str});
                return;
            default:
                x.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
                e.c(this.lLR, this.mURL, -1, this.lLS);
                return;
        }
    }
}
