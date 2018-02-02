package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.a.g;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.bq;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.e.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.r;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class e extends ae implements com.tencent.mm.ae.e {
    private m lKw;
    private d lQW;
    private b lQX = null;
    private a lQY;
    private int mErrorCode;

    public e(int i, long j, int i2, int i3, byte[] bArr) {
        this.lQX = new b(j, i2, i3, bArr);
        this.mErrorCode = i;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(541, this);
        x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        r rVar = (r) kVar;
        bq zf = ad.aEk().zf(this.lQX.kAq);
        if (zf == null) {
            x.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            return;
        }
        if (System.currentTimeMillis() / 1000 < ((long) zf.gfK)) {
            x.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
            this.lQX.a(-5, "", new byte[0]);
            this.lQY = new a(this.lQX, this.lQW);
            boolean b = this.lQY.b(this.lKw);
            x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(b)});
            return;
        }
        this.lQX.a(i2, str, rVar.aEe());
        this.lQY = new a(this.lQX, this.lQW);
        b = this.lQY.b(this.lKw);
        x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(b)});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(m mVar, d dVar) {
        if (-5 == this.mErrorCode || -3 == this.mErrorCode || -4 == this.mErrorCode) {
            x.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[]{Integer.valueOf(this.mErrorCode)});
            this.lQX.a(-1, "", new byte[0]);
            this.lQY = new a(this.lQX, dVar);
            x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(this.lQY.b(mVar))});
            return this.lQY.b(mVar);
        }
        bq zf = ad.aEk().zf(this.lQX.kAq);
        if (zf == null) {
            x.e("MicroMsg.exdevice.MMAuthTaskExcuter", "get device info failed : %d", new Object[]{Long.valueOf(this.lQX.kAq)});
            return false;
        }
        a aVar = (a) this.lQX.aDJ();
        if (aVar == null) {
            x.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse failed!!!, Tell device before stop this task");
            this.lQX.a(-4, "", new byte[0]);
            this.lQY = new a(this.lQX, dVar);
            x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(this.lQY.b(mVar))});
            return this.lQY.b(mVar);
        }
        long j;
        if (aVar.lOk == 2) {
            if (aVar.lOm != null) {
                Object obj = aVar.lOm.oz;
                if (bh.bw(obj)) {
                    j = -1;
                } else {
                    Object obj2 = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
                    System.arraycopy(obj, 0, obj2, 2, 6);
                    j = com.tencent.mm.plugin.exdevice.j.b.aq(obj2);
                }
            }
            x.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid MacAddress");
            this.lQX.a(-1, "", new byte[0]);
            this.lQY = new a(this.lQX, dVar);
            x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(this.lQY.b(mVar))});
            return this.lQY.b(mVar);
        } else if (aVar.lOk != 1 && aVar.lOk != 1) {
            x.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid AuthMethod");
            this.lQX.a(-8, "", new byte[0]);
            this.lQY = new a(this.lQX, dVar);
            x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(this.lQY.b(mVar))});
            return this.lQY.b(mVar);
        } else if (aVar.lOh == null || !com.tencent.mm.plugin.exdevice.j.b.a(aVar.lOh.oz, 0, g.t((zf.field_deviceType + zf.field_deviceID).getBytes()))) {
            x.e("MicroMsg.exdevice.MMAuthTaskExcuter", "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId");
            this.lQX.a(-1, "", new byte[0]);
            this.lQY = new a(this.lQX, dVar);
            x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(this.lQY.b(mVar))});
            return this.lQY.b(mVar);
        }
        if (zf != null) {
            if (System.currentTimeMillis() / 1000 < ((long) zf.gfK)) {
                x.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
                this.lQX.a(-5, "", new byte[0]);
                this.lQY = new a(this.lQX, dVar);
                x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(this.lQY.b(mVar))});
                return this.lQY.b(mVar);
            }
            j = zf.gfL;
            int i = zf.gfJ;
            if (((long) i) + j > 0 && j + ((long) i) < System.currentTimeMillis() / 1000) {
                int i2;
                byte[] l = u.aEL().l(this.lQX.kAq, 1);
                byte[] l2 = u.aEL().l(this.lQX.kAq, 2);
                String str = "MicroMsg.exdevice.MMAuthTaskExcuter";
                String str2 = "has not reach time out, just set back sessionkey, get auth buf from local, auth buf length = %d, session key buf lenght = %d";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(l == null ? -1 : l.length);
                if (l2 == null) {
                    i2 = -1;
                } else {
                    i2 = l2.length;
                }
                objArr[1] = Integer.valueOf(i2);
                x.i(str, str2, objArr);
                if (l == null || l2 == null) {
                    x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "has not reach time out, but local authbuf is null, do auth from server");
                } else {
                    u.aEL().cB(zf.field_mac);
                    if (2 == u.aEL().cy(zf.field_mac)) {
                        ad.aEv();
                        com.tencent.mm.plugin.exdevice.model.e.c(zf.field_brandName, zf.field_url, 2, zf.field_deviceID);
                    }
                    this.lQX.a(0, "", u.aEL().l(this.lQX.kAq, 1));
                    this.lQY = new a(this.lQX, this.lQW);
                    mVar.setChannelSessionKey(zf.field_mac, l2);
                    x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(this.lQY.b(mVar))});
                    return this.lQY.b(mVar);
                }
            }
        }
        x.i("MicroMsg.exdevice.MMAuthTaskExcuter", "now do really auth from server");
        this.lKw = mVar;
        this.lQW = dVar;
        byte[] bArr = null;
        if (!(aVar == null || aVar.lOl == null)) {
            bArr = aVar.lOl.toByteArray();
        }
        ar.CG().a(541, this);
        ar.CG().a(new r(zf.field_brandName, zf.field_deviceType, zf.field_deviceID, aVar.lOj, bArr), 0);
        return true;
    }
}
