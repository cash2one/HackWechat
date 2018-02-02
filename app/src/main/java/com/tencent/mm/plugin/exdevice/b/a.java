package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.plugin.exdevice.i.e;
import com.tencent.mm.plugin.exdevice.i.f;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.plugin.exdevice.service.i.a {
    private static a lJV = null;

    private static class a implements Runnable {
        private long kAq = -1;
        private int lJW = -1;
        private int lJX = -1;
        private int lJY;
        private byte[] lJZ = null;

        public a(int i, long j, int i2, int i3, byte[] bArr) {
            this.kAq = j;
            this.lJW = i2;
            this.lJX = i3;
            this.lJZ = bArr;
            this.lJY = i;
        }

        public final void aDF() {
            if (this.kAq == -1 || this.lJW == -1 || this.lJX == -1) {
                x.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
                return;
            }
            switch (this.lJX) {
                case 10001:
                    u.aEM().a(new e(this.lJY, this.kAq, this.lJW, this.lJX, this.lJZ));
                    return;
                case 10002:
                    k aDL = k.aDL();
                    aDL.mHandler.obtainMessage(1, this.lJY, 0, new f(this.kAq, this.lJW, this.lJX, this.lJZ)).sendToTarget();
                    return;
                case 10003:
                    u.aEM().a(new f(this.lJY, this.kAq, this.lJW, this.lJX, this.lJZ));
                    return;
                default:
                    x.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", new Object[]{Integer.valueOf(this.lJX)});
                    return;
            }
        }

        public final void run() {
            aDF();
        }
    }

    private a() {
    }

    public static a aDE() {
        if (lJV != null) {
            return lJV;
        }
        a aVar = new a();
        lJV = aVar;
        return aVar;
    }

    public final void a(int i, long j, int i2, int i3, byte[] bArr) {
        int i4;
        String str = "MicroMsg.exdevice.DeviceRequestManager";
        String str2 = "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.i(str, str2, objArr);
        if (i == 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        com.tencent.mm.plugin.exdevice.g.a.k(j, i4);
        if (b.ap(bArr) == null) {
            x.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
            return;
        }
        x.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", new Object[]{b.ap(bArr)});
        new a(i, j, i2, i3, bArr).aDF();
    }
}
