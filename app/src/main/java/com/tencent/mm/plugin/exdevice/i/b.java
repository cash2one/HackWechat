package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a implements d {
    private final d lQW;

    public b(c cVar, d dVar) {
        super(cVar, dVar);
        a(this);
        this.lQW = dVar;
    }

    public final void a(long j, int i, int i2, String str) {
        x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (2 == ((h) this.lQT).aDK()) {
            x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
            com.tencent.mm.plugin.exdevice.h.b zf = ad.aEk().zf(this.lQT.kAq);
            if (zf != null) {
                switch (zf.field_closeStrategy) {
                    case 1:
                        x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", new Object[]{Integer.valueOf(zf.field_closeStrategy), Long.valueOf(this.lQT.kAq)});
                        if (u.aEM().lKw != null) {
                            u.aEM().lKw.cF(this.lQT.kAq);
                            break;
                        }
                        break;
                    case 2:
                        x.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", new Object[]{Integer.valueOf(zf.field_closeStrategy), Long.valueOf(this.lQT.kAq)});
                        if (!a.y("shut_down_device", this.lQT.kAq)) {
                            x.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
                            break;
                        }
                        break;
                    default:
                        x.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", new Object[]{Integer.valueOf(zf.field_closeStrategy)});
                        break;
                }
            }
            x.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", new Object[]{Long.valueOf(this.lQT.kAq)});
            if (this.lQW != null) {
                this.lQW.a(j, i, i2, str);
                return;
            }
            return;
        }
        if (this.lQW != null) {
            this.lQW.a(j, i, i2, str);
        }
    }
}
