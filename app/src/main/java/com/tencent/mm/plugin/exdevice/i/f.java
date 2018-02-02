package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.e;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends ae {
    private e lQZ;
    private a lRa;
    private int mErrorCode;

    public f(int i, long j, int i2, int i3, byte[] bArr) {
        this.lQZ = new e(j, i2, i3, bArr);
        this.mErrorCode = i;
    }

    public final boolean a(m mVar, d dVar) {
        if (!u.aEL().cD(this.lQZ.kAq)) {
            x.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[]{Long.valueOf(this.lQZ.kAq)});
            this.lQZ.a(-2, "", new byte[0], new byte[0], 0, 0);
            this.lRa = new a(this.lQZ, dVar);
            x.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.lRa.b(mVar))});
            return this.lRa.b(mVar);
        } else if (-5 == this.mErrorCode || -3 == this.mErrorCode || -4 == this.mErrorCode) {
            x.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[]{Integer.valueOf(this.mErrorCode)});
            this.lQZ.a(-1, "", new byte[0], new byte[0], 0, 0);
            this.lRa = new a(this.lQZ, dVar);
            x.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.lRa.b(mVar))});
            return this.lRa.b(mVar);
        } else {
            com.tencent.mm.plugin.exdevice.e.f fVar = (com.tencent.mm.plugin.exdevice.e.f) this.lQZ.aDJ();
            if (fVar == null) {
                x.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
                this.lQZ.a(-4, "", new byte[0], new byte[0], 0, 0);
                this.lRa = new a(this.lQZ, dVar);
                x.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.lRa.b(mVar))});
                return this.lRa.b(mVar);
            }
            byte[] toByteArray;
            byte[] toByteArray2;
            if (fVar.lOu != null) {
                toByteArray = fVar.lOu.toByteArray();
            } else {
                toByteArray = null;
            }
            if (fVar.lOt != null) {
                toByteArray2 = fVar.lOt.toByteArray();
            } else {
                toByteArray2 = null;
            }
            ad.aEr();
            int aDS = d.aDS();
            switch (aDS) {
                case 1:
                case 2:
                    break;
                default:
                    x.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[]{Integer.valueOf(aDS)});
                    break;
            }
            this.lQZ.a(0, null, toByteArray2, toByteArray, aDS, (int) (b.aFy() / 1000));
            this.lRa = new a(this.lQZ, dVar);
            return this.lRa.b(mVar);
        }
    }
}
