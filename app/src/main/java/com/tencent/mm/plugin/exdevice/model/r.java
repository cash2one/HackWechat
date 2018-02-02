package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.ajt;
import com.tencent.mm.protocal.c.aju;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends k implements com.tencent.mm.network.k {
    private String frn;
    private b gJQ = null;
    private e gJT = null;
    String lNd;

    public r(String str, String str2, String str3, int i, byte[] bArr) {
        a aVar = new a();
        aVar.hmj = new ajt();
        aVar.hmk = new aju();
        aVar.uri = "/cgi-bin/micromsg-bin/harddeviceauth";
        aVar.hmi = 541;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ajt com_tencent_mm_protocal_c_ajt = (ajt) this.gJQ.hmg.hmo;
        ajr com_tencent_mm_protocal_c_ajr = new ajr();
        com_tencent_mm_protocal_c_ajr.vJA = str2;
        com_tencent_mm_protocal_c_ajr.ksX = str3;
        com_tencent_mm_protocal_c_ajt.vLR = com_tencent_mm_protocal_c_ajr;
        com_tencent_mm_protocal_c_ajt.wqU = i;
        com_tencent_mm_protocal_c_ajt.wqV = new bdn().bj(bArr);
        this.lNd = str3;
        this.frn = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        c zg = ad.aEk().zg(this.lNd);
        if (i2 == 0 && i3 == 0) {
            aju com_tencent_mm_protocal_c_aju = (aju) this.gJQ.hmh.hmo;
            if (zg != null) {
                byte[] aEe = aEe();
                if (aEe != null) {
                    zg.field_authBuf = aEe;
                }
                zg.gfK = com_tencent_mm_protocal_c_aju.wqZ;
                zg.gfw = true;
                zg.gfJ = com_tencent_mm_protocal_c_aju.wqY;
                zg.gfw = true;
                byte[] CF = CF();
                if (CF != null) {
                    u.aEL().b(zg.field_mac, CF, 2);
                    if (u.aEM().lKw != null) {
                        u.aEM().lKw.setChannelSessionKey(zg.field_mac, CF);
                    }
                    zg.field_sessionKey = CF;
                }
                CF = aEf();
                if (CF != null) {
                    u.aEL().b(zg.field_mac, CF, 3);
                    zg.field_sessionBuf = CF;
                }
                CF = aEe();
                if (aEe != null) {
                    u.aEL().b(zg.field_mac, CF, 1);
                    zg.field_authBuf = aEe;
                }
                zg.gfL = System.currentTimeMillis() / 1000;
                zg.gfw = true;
                if (2 == u.aEL().cy(zg.field_mac)) {
                    ad.aEv();
                    e.c(this.frn, zg.field_url, 2, zg.field_deviceID);
                }
                u.aEL().cB(zg.field_mac);
                boolean c = ad.aEk().c(zg, new String[0]);
                x.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[]{Boolean.valueOf(c)});
            } else {
                x.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
            }
        } else {
            if (zg != null) {
                u.aEL().cC(zg.field_mac);
                ad.aEv();
                e.c(this.frn, zg.field_url, 4, zg.field_deviceID);
            }
            ad.aEv();
            e.bg(this.frn, 3);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 541;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    private byte[] CF() {
        try {
            return ((aju) this.gJQ.hmh.hmo).vIZ.wJD.oz;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }

    public final byte[] aEe() {
        try {
            return ((aju) this.gJQ.hmh.hmo).wqX.wJD.oz;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }

    private byte[] aEf() {
        try {
            return ((aju) this.gJQ.hmh.hmo).wqW.wJD.oz;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }
}
