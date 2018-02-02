package com.tencent.mm.plugin.g.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.plugin.g.a.b.c;
import com.tencent.mm.plugin.g.a.b.g;
import com.tencent.mm.plugin.g.a.c.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import junit.framework.Assert;

public final class b {
    public com.tencent.mm.plugin.g.a.b.b kAl = null;
    public a kAm = null;
    c kAn = null;
    final HashSet<String> kAo = new HashSet();
    private af mHandler = null;

    public b(Context context, c cVar, ag agVar) {
        this.kAm = new a(agVar);
        if (VERSION.SDK_INT >= 18) {
            this.kAl = new com.tencent.mm.plugin.g.a.b.b(agVar);
            com.tencent.mm.plugin.g.a.b.b bVar = this.kAl;
            com.tencent.mm.plugin.g.a.b.b.a bVar2 = new b(this);
            x.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
            Assert.assertNotNull(context);
            Assert.assertNotNull(bVar2);
            if (!bVar.mIsInit) {
                bVar.mIsInit = true;
                bVar.tI = context;
                bVar.kwK = bVar2;
                bVar.kwN = c.arm();
                if (f.fM(21)) {
                    bVar.kwO = g.arr();
                }
                if (bVar.ark()) {
                    bVar.kwe = ((BluetoothManager) bVar.tI.getSystemService("bluetooth")).getAdapter();
                } else {
                    x.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
                }
            }
        }
        a aVar = this.kAm;
        a.a aVar2 = new a(this);
        x.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
        Assert.assertNotNull(context);
        Assert.assertNotNull(aVar2);
        if (!aVar.mIsInit) {
            aVar.mIsInit = true;
            aVar.kzP = aVar2;
            aVar.kzQ = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            aVar.kzQ.registerReceiver(aVar.jhN, intentFilter);
            aVar.kwe = BluetoothAdapter.getDefaultAdapter();
        }
        this.mHandler = new c(v.aEN().hOa.oAt.getLooper(), this);
        this.kAn = cVar;
    }

    public final boolean a(int i, int... iArr) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.kAl == null) {
                    x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    return false;
                } else if (iArr == null) {
                    return this.kAl.a(true, new int[0]);
                } else {
                    return this.kAl.a(true, iArr);
                }
            case 1:
                if (this.kAm != null) {
                    return this.kAm.dS(true);
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                return false;
            default:
                Assert.assertTrue(false);
                return false;
        }
    }

    public final void b(long j, long j2, int i) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + j + "aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.kAl == null) {
                    x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    return;
                }
                com.tencent.mm.plugin.g.a.b.b bVar = this.kAl;
                x.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", Long.valueOf(j), Long.valueOf(j2));
                Assert.assertTrue(bVar.mIsInit);
                if (bVar.ark()) {
                    Assert.assertTrue(bVar.mHandler.post(new b$b(bVar, j, j2)));
                    return;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                    return;
                }
            case 1:
                if (this.kAm == null) {
                    x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    return;
                }
                a aVar = this.kAm;
                x.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
                Assert.assertTrue(aVar.mIsInit);
                if (aVar.art()) {
                    Assert.assertTrue(aVar.mHandler.post(new com.tencent.mm.plugin.g.a.c.a.b(aVar, j, j2)));
                    return;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                    return;
                }
            default:
                Assert.assertTrue(false);
                return;
        }
    }
}
