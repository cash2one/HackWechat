package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends ae {
    private f lKn;
    private a lRd;

    public h(f fVar) {
        this.lKn = fVar;
    }

    public final boolean a(m mVar, d dVar) {
        this.lRd = new a(this.lKn, dVar);
        x.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", new Object[]{Boolean.valueOf(this.lRd.b(mVar))});
        return this.lRd.b(mVar);
    }
}
