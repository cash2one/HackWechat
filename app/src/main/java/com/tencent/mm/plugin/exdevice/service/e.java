package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.g.a.dk;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.model.d.4;
import com.tencent.mm.plugin.exdevice.service.q.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends a {
    private static e lQg = new e();

    private e() {
    }

    public static e aEC() {
        return lQg;
    }

    public final boolean ai(String str, boolean z) {
        x.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        if (str == null) {
            x.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
            return false;
        } else if (u.aEM().lKw != null) {
            return u.aEM().lKw.a(str, z, this);
        } else {
            x.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
            d aEr = ad.aEr();
            Runnable 1 = new 1(this, str, z);
            x.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
            if (aEr.lKB == null) {
                aEr.lKB = new c();
                aEr.lKB.lQd = new 4(aEr, 1);
                aEr.lKB.cx(ac.getContext());
                return false;
            }
            aEr.lKB.v(1);
            return false;
        }
    }

    public final void a(double d, int i, int i2, byte[] bArr, double d2, int i3, String str) {
        x.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", Double.valueOf(d), Integer.valueOf(i), Integer.valueOf(i2), b.ap(bArr), Double.valueOf(d2), str, Integer.valueOf(i3));
        com.tencent.mm.sdk.b.b dkVar = new dk();
        String ap = b.ap(bArr);
        if (ap.length() >= 32) {
            ap = ap.substring(0, 8) + "-" + ap.substring(8, 12) + "-" + ap.substring(12, 16) + "-" + ap.substring(16, 20) + "-" + ap.substring(20);
        }
        dkVar.frY.frW = ap;
        dkVar.frY.fsb = d;
        dkVar.frY.frZ = i;
        dkVar.frY.fsa = i2;
        dkVar.frY.fsc = d2;
        dkVar.frY.fsd = str;
        dkVar.frY.fse = i3;
        com.tencent.mm.sdk.b.a.xef.m(dkVar);
    }
}
