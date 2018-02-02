package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements e {
    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.exdevice.ExDeviceMessageService", "onScenend, errType = %d, errCode = %d, errMsg = ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }
}
