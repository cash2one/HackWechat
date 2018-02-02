package com.tencent.mm.plugin.exdevice.g;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static void k(long j, int i) {
        b zf = ad.aEk().zf(String.valueOf(j));
        if (zf == null) {
            x.e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(zf.field_deviceType).append(',');
        stringBuilder.append(zf.field_deviceID).append(',');
        stringBuilder.append(i);
        g.pQN.k(11232, stringBuilder.toString());
    }
}
