package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class f {
    public HashMap<Long, a> lQi = new HashMap();

    public final boolean cx(long j) {
        if (cy(j) == 2) {
            return true;
        }
        return false;
    }

    public final int cy(long j) {
        if (this.lQi.containsKey(Long.valueOf(j))) {
            return ((a) this.lQi.get(Long.valueOf(j))).fsg;
        }
        return 0;
    }

    public final a cz(long j) {
        if (!this.lQi.containsKey(Long.valueOf(j))) {
            cE(j);
        }
        return (a) this.lQi.get(Long.valueOf(j));
    }

    public final a cA(long j) {
        if (this.lQi.containsKey(Long.valueOf(j))) {
            return (a) this.lQi.get(Long.valueOf(j));
        }
        a aVar = new a();
        aVar.lQj = j;
        aVar.lQl = null;
        aVar.bjP = null;
        aVar.lQk = null;
        aVar.frn = null;
        aVar.mURL = null;
        aVar.fsg = 0;
        aVar.lQm = false;
        aVar.kxJ = 0;
        this.lQi.put(Long.valueOf(j), aVar);
        return aVar;
    }

    public final boolean cB(long j) {
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[]{Long.valueOf(j)});
        a cz = cz(j);
        if (cz == null) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            return false;
        }
        cz.lQm = true;
        return true;
    }

    public final boolean cC(long j) {
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[]{Long.valueOf(j)});
        a cz = cz(j);
        if (cz == null) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            return false;
        }
        cz.lQm = false;
        return true;
    }

    public final boolean cD(long j) {
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[]{Long.valueOf(j)});
        a cz = cz(j);
        if (cz != null) {
            return cz.lQm;
        }
        x.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
        return false;
    }

    private void cE(long j) {
        b zf = ad.aEk().zf(String.valueOf(j));
        if (zf == null) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[]{Long.valueOf(j)});
            return;
        }
        a aVar = new a();
        aVar.lQj = j;
        aVar.lQl = zf.field_authBuf;
        aVar.bjP = zf.field_sessionKey;
        aVar.lQk = zf.field_sessionBuf;
        aVar.frn = zf.field_brandName;
        aVar.mURL = zf.field_url;
        aVar.fsg = 0;
        aVar.lQm = false;
        this.lQi.put(Long.valueOf(j), aVar);
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[]{Long.valueOf(j)});
    }

    public final byte[] l(long j, int i) {
        if (j < 0) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
            return null;
        }
        a aVar = (a) this.lQi.get(Long.valueOf(j));
        if (aVar == null) {
            cE(j);
            aVar = (a) this.lQi.get(Long.valueOf(j));
        }
        if (aVar == null) {
            return null;
        }
        byte[] bArr;
        switch (i) {
            case 1:
                bArr = aVar.lQl;
                break;
            case 2:
                bArr = aVar.bjP;
                break;
            case 3:
                bArr = aVar.lQk;
                break;
            default:
                bArr = null;
                break;
        }
        return bArr;
    }

    public final void b(long j, byte[] bArr, int i) {
        if (j < 0 || bArr == null || bArr.length == 0) {
            boolean z;
            int i2;
            String str = "MicroMsg.exdevice.ExdeviceInfoManager";
            String str2 = "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(j);
            if (bArr == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            if (bArr == null) {
                i2 = -1;
            } else {
                i2 = bArr.length;
            }
            objArr[2] = Integer.valueOf(i2);
            x.e(str, str2, objArr);
            return;
        }
        a aVar = (a) this.lQi.get(Long.valueOf(j));
        if (aVar == null) {
            aVar = new a();
            aVar.lQj = j;
        }
        switch (i) {
            case 1:
                aVar.lQl = bArr;
                break;
            case 2:
                aVar.bjP = bArr;
                break;
            case 3:
                aVar.lQk = bArr;
                break;
            default:
                x.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[]{Integer.valueOf(i)});
                break;
        }
        this.lQi.put(Long.valueOf(j), aVar);
    }
}
