package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.service.y.b;
import com.tencent.mm.plugin.exdevice.service.y.c;
import com.tencent.mm.plugin.exdevice.service.y.d;
import com.tencent.mm.plugin.exdevice.service.y.e;
import com.tencent.mm.plugin.exdevice.service.y.f;
import com.tencent.mm.plugin.exdevice.service.y.g;
import com.tencent.mm.plugin.exdevice.service.y.h;
import com.tencent.mm.plugin.exdevice.service.y.i;
import com.tencent.mm.plugin.exdevice.service.y.k;
import com.tencent.mm.plugin.g.a.b.e.5;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

final class y$a extends af {
    final /* synthetic */ y lQK;

    public y$a(y yVar, Looper looper) {
        this.lQK = yVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                k kVar = (k) message.obj;
                if (!y.a(this.lQK, kVar.lPM, kVar.lQS)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
                    return;
                }
                return;
            case 1:
                if (!y.a(this.lQK, ((Long) message.obj).longValue())) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
                    return;
                }
                return;
            case 2:
                d dVar = (d) message.obj;
                y.a(this.lQK, dVar.lPM, dVar.lKk, dVar.lJY, dVar.jcD);
                return;
            case 3:
                y$j com_tencent_mm_plugin_exdevice_service_y_j = (y$j) message.obj;
                if (!y.a(this.lQK, com_tencent_mm_plugin_exdevice_service_y_j.kAq, com_tencent_mm_plugin_exdevice_service_y_j.lQR, com_tencent_mm_plugin_exdevice_service_y_j.lQN)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
                    return;
                }
                return;
            case 4:
                if (!y.b(this.lQK, ((Long) message.obj).longValue())) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
                    return;
                }
                return;
            case 5:
                c cVar = (c) message.obj;
                y.a(this.lQK, cVar.kAq, cVar.lPK, cVar.lPL, cVar.lJY);
                return;
            case 6:
                b bVar = (b) message.obj;
                y.a(this.lQK, bVar.mErrorCode, bVar.kAq, bVar.lKf, bVar.lPJ, bVar.lJZ);
                return;
            case 7:
                e eVar = (e) message.obj;
                if (!this.lQK.c(eVar.lMZ, eVar.lQM, eVar.lQN)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
                    return;
                }
                return;
            case 8:
                long longValue = ((Long) message.obj).longValue();
                y yVar = this.lQK;
                x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", new Object[]{Long.valueOf(longValue)});
                if (yVar.lQI != null) {
                    com.tencent.mm.plugin.g.a.b.e eVar2 = yVar.lQI;
                    x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", new Object[]{Long.valueOf(longValue)});
                    if (eVar2.ark()) {
                        eVar2.t(new 5(eVar2, longValue));
                        return;
                    } else {
                        x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                        return;
                    }
                }
                return;
            case 9:
                c cVar2 = (c) message.obj;
                if (!this.lQK.b(cVar2.kAq, cVar2.lPK, cVar2.lPL, cVar2.lJY, cVar2.kxJ)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl error");
                    return;
                }
                return;
            case 10:
                i iVar = (i) message.obj;
                if (!this.lQK.c(iVar.lMZ, iVar.kwG, iVar.lQQ)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl error");
                    return;
                }
                return;
            case 11:
                h hVar = (h) message.obj;
                if (!this.lQK.e(hVar.lMZ, hVar.lKk, hVar.lJY, hVar.jcD)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl error");
                    return;
                }
                return;
            case 12:
                f fVar = (f) message.obj;
                this.lQK.d(fVar.lMZ, fVar.kwG);
                return;
            case 13:
                y.a(this.lQK, (g) message.obj);
                return;
            default:
                return;
        }
    }
}
