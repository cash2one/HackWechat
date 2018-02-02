package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.service.y.c;
import com.tencent.mm.plugin.exdevice.service.y.f;
import com.tencent.mm.plugin.exdevice.service.y.g;
import com.tencent.mm.plugin.exdevice.service.y.h;
import com.tencent.mm.plugin.g.a.b.e.a;
import com.tencent.mm.sdk.platformtools.x;

class y$1 extends a {
    final /* synthetic */ y lQK;

    y$1(y yVar) {
        this.lQK = yVar;
    }

    public final void a(long j, boolean z, long j2) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onConnected. seesionId=%d, connected=%s, profileType=%d";
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(j);
        objArr[1] = z ? "true" : "false";
        objArr[2] = Long.valueOf(j2);
        x.d(str, str2, objArr);
        c cVar = new c((byte) 0);
        cVar.kAq = j;
        cVar.lPL = z ? 2 : 4;
        cVar.lPK = 1;
        cVar.lJY = 0;
        cVar.kxJ = j2;
        if (!y.a(this.lQK).sendMessage(y.a(this.lQK).obtainMessage(9, cVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(9)});
        }
    }

    public final void b(long j, byte[] bArr) {
        f fVar = new f((byte) 0);
        fVar.lMZ = j;
        fVar.kwG = bArr;
        if (!y.a(this.lQK).sendMessage(y.a(this.lQK).obtainMessage(12, fVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(12)});
        }
    }

    public final void h(long j, boolean z) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onSend. sessionId=%d, success=%s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = z ? "true" : "false";
        x.d(str, str2, objArr);
        h hVar = new h((byte) 0);
        hVar.lMZ = j;
        if (z) {
            hVar.lKk = 0;
            hVar.lJY = 0;
        } else {
            hVar.lKk = -1;
            hVar.lJY = -1;
        }
        hVar.jcD = "";
        if (!y.a(this.lQK).sendMessage(y.a(this.lQK).obtainMessage(11, hVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(11)});
        }
    }

    public final void a(String str, String str2, int i, byte[] bArr) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", new Object[]{str, str2});
        g gVar = new g((byte) 0);
        gVar.lQO = false;
        gVar.kAu = str;
        gVar.kAv = str2;
        gVar.kAw = i;
        gVar.lQP = bArr;
        if (!y.a(this.lQK).sendMessage(y.a(this.lQK).obtainMessage(13, gVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(13)});
        }
    }

    public final void arl() {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
        g gVar = new g((byte) 0);
        gVar.lQO = true;
        gVar.kAu = null;
        gVar.kAv = null;
        gVar.kAw = 0;
        gVar.lQP = null;
        if (!y.a(this.lQK).sendMessage(y.a(this.lQK).obtainMessage(13, gVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(13)});
        }
    }
}
