package com.tencent.mm.plugin.g.a.d;

import com.tencent.mm.plugin.g.a.b.b$a;
import com.tencent.mm.plugin.g.a.d.b.d;
import com.tencent.mm.plugin.g.a.d.b.f;
import com.tencent.mm.plugin.g.a.d.b.h;
import com.tencent.mm.plugin.g.a.d.b.j;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class b$b extends b$a {
    final /* synthetic */ b kAp;

    b$b(b bVar) {
        this.kAp = bVar;
    }

    public final void b(long j, long j2, long j3) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
        Assert.assertTrue(b.a(this.kAp, 6, 0, new d(j, j2, j3)));
    }

    public final void arl() {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
        this.kAp.kAo.clear();
        Assert.assertTrue(b.a(this.kAp, 2, 0, null));
    }

    public final void a(String str, String str2, int i, byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", new Object[]{str, str2});
        Assert.assertTrue(b.a(this.kAp, 3, 0, new b$i(str, str2, i, bArr)));
    }

    public final void g(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + j + " Connected = " + z);
        Assert.assertTrue(b.a(this.kAp, 4, 0, new f(j, z)));
    }

    public final void b(long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = " + j);
        Assert.assertTrue(b.a(this.kAp, 1, 0, new h(j, bArr)));
    }

    public final void h(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + j + " success = " + z);
        Assert.assertTrue(b.a(this.kAp, 0, 0, new j(j, z)));
    }
}
