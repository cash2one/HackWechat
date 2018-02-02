package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import junit.framework.Assert;

public class a implements c {
    private long lPM = -1;
    protected c lQT = null;
    protected d lQU = null;
    private m lQV = null;

    public a(c cVar, d dVar) {
        this.lQT = cVar;
        this.lQU = dVar;
    }

    public final void a(d dVar) {
        this.lQU = dVar;
    }

    public final boolean b(m mVar) {
        if (mVar == null) {
            x.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
            return false;
        } else if (this.lQV != null) {
            x.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
            return false;
        } else {
            x.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[]{Short.valueOf(this.lQT.aDG()), Short.valueOf(this.lQT.lKa), Long.valueOf(this.lQT.kAq)});
            Object mVar2 = new m(this.lQT, this);
            long a = mVar.a(mVar2);
            if (-1 == a) {
                x.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
                return false;
            }
            this.lQV = mVar2;
            this.lPM = a;
            m mVar3 = this.lQV;
            Assert.assertNotNull(mVar3.lRq);
            l lVar = mVar3.lRq;
            lVar.lRj = false;
            lVar.lRk = false;
            ar.Dm().cfF().postDelayed(lVar.lRl, 15000);
            return true;
        }
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        int i3 = 1;
        x.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(this.lQT.kAq), Short.valueOf(this.lQT.aDG()), Short.valueOf(this.lQT.lKa)});
        com.tencent.mm.plugin.exdevice.g.a.k(this.lQT.kAq, i == 0 ? 1 : 0);
        if (pVar == null || pVar == this.lQV) {
            if (-1 == i && -2 == i2) {
                x.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
            }
            int i4 = this.lQT.lKb != null ? this.lQT.lKb.lOr : 0;
            if (-5 == i4 || -3 == i4 || -4 == i4) {
                x.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[]{Integer.valueOf(this.lQT.lKb.lOr), Long.valueOf(this.lQT.kAq)});
                if (u.aEM().lKw == null || !u.aEM().lKw.cF(this.lQT.kAq)) {
                    i3 = 0;
                }
                if (i3 == 0) {
                    x.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
                }
            }
            if (this.lQU != null) {
                this.lQU.a(j, i, i2, str);
            }
            this.lQV = null;
            return;
        }
        x.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
    }
}
