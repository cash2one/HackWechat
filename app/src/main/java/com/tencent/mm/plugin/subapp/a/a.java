package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahj;
import com.tencent.mm.protocal.c.ahk;
import com.tencent.mm.protocal.c.bru;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.FileOutputStream;

public final class a extends k implements com.tencent.mm.network.k {
    final b gJQ;
    private e gJT;
    private ak hkO = new ak(new 1(this), true);
    int rWb = 0;

    public a() {
        int i = 0;
        ar.Hg();
        int e = bh.e((Integer) c.CU().get(66052, null));
        if (com.tencent.mm.z.ak.a.hfN.gQ(e)) {
            ar.Hg();
            i = bh.e((Integer) c.CU().get(66053, null));
        }
        StringBuilder append = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(e)).append(" inver:");
        ar.Hg();
        x.d("MicroMsg.NetSceneGetVUserInfo", append.append(bh.e((Integer) c.CU().get(66053, null))).append(" reqver:").append(i).toString());
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new ahj();
        aVar.hmk = new ahk();
        aVar.uri = "/cgi-bin/micromsg-bin/getvuserinfo";
        aVar.hmi = 167;
        aVar.hml = 60;
        aVar.hmm = 1000000060;
        this.gJQ = aVar.JZ();
        ((ahj) this.gJQ.hmg.hmo).ktM = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 167;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ahk com_tencent_mm_protocal_c_ahk = (ahk) ((b) qVar).hmh.hmo;
            StringBuilder append = new StringBuilder("onGYNetEnd new version:").append(com_tencent_mm_protocal_c_ahk.ktM).append(" old version:");
            ar.Hg();
            x.d("MicroMsg.NetSceneGetVUserInfo", append.append(bh.e((Integer) c.CU().get(66053, null))).append(" Count:").append(com_tencent_mm_protocal_c_ahk.woV.size()).toString());
            ar.Hg();
            c.CU().set(66053, Integer.valueOf(com_tencent_mm_protocal_c_ahk.ktM));
            if (com_tencent_mm_protocal_c_ahk.woV.size() <= 0) {
                this.gJT.a(i2, i3, str, this);
                return;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < com_tencent_mm_protocal_c_ahk.woV.size(); i5++) {
                i4 |= ((bru) com_tencent_mm_protocal_c_ahk.woV.get(i5)).fgt;
            }
            ar.Hg();
            c.CU().set(66052, Integer.valueOf(i4));
            this.gJT.a(i2, i3, str, this);
            this.rWb = com_tencent_mm_protocal_c_ahk.woV.size() - 1;
            this.hkO.J(50, 50);
            return;
        }
        x.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }

    static boolean a(int i, boolean z, byte[] bArr) {
        Throwable e;
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(com.tencent.mm.z.ak.a.hfN.q(i, z));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception e4) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.NetSceneGetVUserInfo", e, "", new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
