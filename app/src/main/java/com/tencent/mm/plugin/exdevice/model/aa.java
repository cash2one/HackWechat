package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa extends com.tencent.mm.plugin.exdevice.service.j.a implements e {
    static Object hpF = new Object();
    private static final byte[] lNj = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static aa lNk;
    static LinkedList<String> lNo = new LinkedList();
    private static HashMap<String, gd> lNp = new HashMap(32);
    final ak iZb = new ak(new com.tencent.mm.sdk.platformtools.ak.a(this) {
        final /* synthetic */ aa lNq;

        {
            this.lNq = r1;
        }

        public final boolean uF() {
            x.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
            ad.aEr().a(0, this.lNq);
            return true;
        }
    }, true);
    volatile String lLR;
    boolean lMx = false;
    a lNl;
    HashMap<String, byte[]> lNm = new HashMap();
    LinkedList<k> lNn = new LinkedList();

    public interface a {
        void a(String str, byte[] bArr, boolean z);
    }

    public static aa aEh() {
        if (lNk != null) {
            return lNk;
        }
        aa aaVar = new aa();
        lNk = aaVar;
        return aaVar;
    }

    private aa() {
    }

    public final void pb(int i) {
        x.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[]{Integer.valueOf(i)});
        this.iZb.TG();
        if (this.lMx) {
            d aEr = ad.aEr();
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            if (this == null) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            } else if (aEr.lKB == null) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (u.aEM().lKw == null) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!u.aEM().lKw.c(i, aEr.lKH)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.lMx = false;
            this.lLR = null;
            this.lNm.clear();
            ar.CG().b(542, this);
            Iterator it = this.lNn.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar != null) {
                    ar.CG().c(kVar);
                }
            }
            this.lNn.clear();
            if (this.lNl != null) {
                this.lNl.a(null, null, true);
            }
            this.lNl = null;
        } else {
            x.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
        }
        synchronized (hpF) {
            lNo.clear();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
        if (!this.lNm.containsKey(str2)) {
            if (str2 == null) {
                x.w("MicroMsg.exdevice.ScanDeviceLogic", "deviceMac is null");
                return;
            }
            int i4;
            String replaceAll = str2.replaceAll(":", "");
            byte[] bArr2 = lNj;
            if (bh.bw(bArr) || bh.bw(bArr2) || bArr2.length > bArr.length) {
                i4 = -1;
            } else {
                i4 = 0;
                while (i4 < bArr.length) {
                    if (b.a(bArr, i4, bArr2)) {
                        break;
                    }
                    i4++;
                }
                i4 = -1;
            }
            if (i4 == -1) {
                this.lNm.put(replaceAll, null);
            } else if (i4 + 9 <= bArr.length) {
                Object obj = new byte[(i4 + 9)];
                System.arraycopy(bArr, 0, obj, 0, obj.length);
                x.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, scanFound mac:%s, realAd:%s", new Object[]{replaceAll, b.ap(obj)});
                this.lNm.put(replaceAll, obj);
            } else {
                this.lNm.put(replaceAll, null);
            }
            String str4 = this.lLR + "_" + str2;
            if (lNp.containsKey(str4)) {
                x.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, hit cache %s, %s", new Object[]{this.lLR, str2});
                a((gd) lNp.get(str4));
                return;
            }
            synchronized (hpF) {
                if (lNo.contains(str4)) {
                    x.d("MicroMsg.exdevice.ScanDeviceLogic", "hakon, already doing");
                    return;
                }
                lNo.add(str4);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.exdevice.ScanDeviceLogic";
        String str3 = "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s";
        Object[] objArr = new Object[4];
        objArr[0] = kVar == null ? "" : Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        x.i(str2, str3, objArr);
        this.lNn.remove(kVar);
        if (i != 0 || i2 != 0 || kVar == null) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
        } else if (542 == kVar.getType()) {
            Iterator it = ((k) kVar).aEc().vLw.iterator();
            while (it.hasNext()) {
                gd gdVar = (gd) it.next();
                if (bh.ov(gdVar.vLs)) {
                    x.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
                } else {
                    str3 = this.lLR + "_" + gdVar.vLs;
                    synchronized (hpF) {
                        if (lNo.contains(str3)) {
                            lNo.remove(str3);
                        }
                    }
                    if (!lNp.containsKey(str3)) {
                        x.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[]{str3});
                        lNp.put(str3, gdVar);
                    }
                    a(gdVar);
                }
            }
        }
    }

    private void a(gd gdVar) {
        if (gdVar == null) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
        } else if (bh.ov(gdVar.vLs)) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        } else if (gdVar.vJU != 0) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[]{gdVar.vLs});
        } else if (gdVar.vLz == null || bh.ov(gdVar.vLz.ksX)) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[]{gdVar.vLs});
        } else if (bh.ov(gdVar.vLz.vJA) || !gdVar.vLz.vJA.equals(this.lLR)) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[]{gdVar.ksY, this.lLR});
        } else {
            byte[] bArr = (byte[]) this.lNm.get(gdVar.vLs);
            String str = "MicroMsg.exdevice.ScanDeviceLogic";
            String str2 = "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s";
            Object[] objArr = new Object[5];
            objArr[0] = gdVar.vLs;
            objArr[1] = gdVar.vLz.vJA;
            objArr[2] = gdVar.vLz.ksX;
            objArr[3] = gdVar.ksY;
            objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            x.i(str, str2, objArr);
            if (this.lNl != null) {
                if (bArr != null) {
                    bArr = ao(bArr);
                } else {
                    bArr = null;
                }
                this.lNl.a(gdVar.vLz.ksX, bArr, false);
                return;
            }
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
        }
    }

    private static byte[] ao(byte[] bArr) {
        byte[] bArr2 = null;
        int i = 0;
        int i2 = 0;
        while (i < bArr.length - 2) {
            try {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b != (byte) 0) {
                    int i4 = i3 + 1;
                    switch (bArr[i3]) {
                        case (byte) -1:
                            x.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", new Object[]{Integer.valueOf(b)});
                            byte[] bArr3 = new byte[(b - 1)];
                            int i5 = b;
                            i = i4;
                            while (i5 > 1) {
                                int i6;
                                if (i2 >= 32 || i2 >= bArr3.length) {
                                    i6 = i;
                                    i = i2;
                                } else {
                                    i4 = i2 + 1;
                                    i6 = i + 1;
                                    bArr3[i2] = bArr[i];
                                    i = i4;
                                }
                                i5--;
                                i2 = i;
                                i = i6;
                            }
                            x.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.ap(bArr3));
                            bArr2 = bArr3;
                            break;
                        default:
                            i = (b - 1) + i4;
                            break;
                    }
                }
                return bArr2;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", new Object[]{e.getMessage()});
                return null;
            }
        }
        return bArr2;
    }
}
