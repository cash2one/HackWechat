package com.tencent.mm.plugin.g.a.d;

import com.tencent.mm.plugin.g.a.c.a.a;
import com.tencent.mm.plugin.g.a.d.b.d;
import com.tencent.mm.plugin.g.a.d.b.f;
import com.tencent.mm.plugin.g.a.d.b.g;
import com.tencent.mm.plugin.g.a.d.b.h;
import com.tencent.mm.plugin.g.a.d.b.i;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class b$a extends a {
    final /* synthetic */ b kAp;

    b$a(b bVar) {
        this.kAp = bVar;
    }

    public final void b(long j, long j2, long j3) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
        Assert.assertTrue(b.a(this.kAp, 6, 1, new d(j, j2, j3)));
    }

    public final void arl() {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
        this.kAp.kAo.clear();
        Assert.assertTrue(b.a(this.kAp, 2, 1, null));
    }

    public final void bL(String str, String str2) {
        int i;
        b bVar = this.kAp;
        if (str == null) {
            x.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
            i = 0;
        } else if (bVar.kAo.contains(str)) {
            i = 0;
        } else {
            bVar.kAo.add(str);
            i = 1;
        }
        if (i != 0) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + str + "deviceName = " + str2);
            Assert.assertTrue(b.a(this.kAp, 3, 1, new i(str, str2, 0, null)));
        }
    }

    public final void g(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + j + " Connected = " + z);
        Assert.assertTrue(b.a(this.kAp, 4, 1, new f(j, z)));
    }

    public final void b(long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = " + j);
        Assert.assertTrue(b.a(this.kAp, 1, 1, new h(j, bArr)));
    }

    public final void h(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + j + " success = " + z);
        Assert.assertTrue(b.a(this.kAp, 0, 1, new b$j(j, z)));
    }

    public final void b(long j, int i, String str) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + j + " errorCode = " + i + " errorInfo = " + str);
        Assert.assertTrue(b.a(this.kAp, 5, 1, new g(j, i, str)));
    }
}
