package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.pb.talkroom.sdk.b;
import com.tencent.pb.talkroom.sdk.d;

public final class c implements e {
    a flb = new a(this) {
        final /* synthetic */ c oFW;

        {
            this.oFW = r1;
        }

        public final void q(byte[] bArr, int i) {
            if (i <= 0) {
                x.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
            } else if (this.oFW.oFT != null) {
                this.oFW.oFT.Q(bArr, i);
            }
        }

        public final void aK(int i, int i2) {
            x.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    };
    public d oFQ;
    b oFR;
    com.tencent.mm.e.b.c oFS;
    com.tencent.pb.talkroom.sdk.c oFT;
    b oFU;
    com.tencent.mm.plugin.voip.model.a oFV = new 3(this);

    static /* synthetic */ void a(c cVar) {
        byte[] bArr = new byte[]{(byte) 0};
        byte[] bArr2 = new byte[2];
        if (q.gFV.gDq >= 0) {
            bArr2[0] = (byte) q.gFV.gDq;
            cVar.oFQ.setAppCmd(au.CTRL_INDEX, bArr2, 1);
        } else if (q.gFV.gDq == -2) {
            cVar.oFQ.setAppCmd(JsApiPrivateAddContact.CTRL_INDEX, bArr, 1);
        }
        if (q.gFV.gDt >= 0) {
            byte[] bArr3 = new byte[5];
            if (q.gFV.gDu >= 0 && q.gFV.gDv >= 0) {
                bArr3[0] = (byte) q.gFV.gDu;
                bArr3[1] = (byte) q.gFV.gDv;
                if (q.gFV.gDw >= 0) {
                    bArr3[2] = (byte) q.gFV.gDw;
                    bArr3[3] = (byte) q.gFV.gDt;
                    bArr3[4] = (byte) q.gFV.gDx;
                    cVar.oFQ.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr3, 5);
                } else {
                    cVar.oFQ.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr3, 2);
                }
            }
        } else if (q.gFV.gDt == -2) {
            cVar.oFQ.setAppCmd(405, bArr, 1);
        }
        if (q.gFV.gDr >= 0) {
            bArr2[0] = (byte) q.gFV.gDr;
            cVar.oFQ.setAppCmd(av.CTRL_INDEX, bArr2, 1);
        } else if (q.gFV.gDr == -2) {
            cVar.oFQ.setAppCmd(409, bArr, 1);
        }
        if (q.gFV.gDC[0] > (short) 0 || q.gFV.gDC[1] > (short) 0) {
            bArr2[0] = (byte) 0;
            bArr2[1] = (byte) 0;
            if (q.gFV.gDC[0] > (short) 0 && q.gFV.gDC[0] < (short) 10000) {
                bArr2[0] = (byte) q.gFV.gDC[0];
            }
            if (q.gFV.gDC[1] > (short) 0 && q.gFV.gDC[1] < (short) 10000) {
                bArr2[1] = (byte) q.gFV.gDC[1];
            }
            cVar.oFQ.setAppCmd(423, bArr2, 2);
        }
        if (q.gFV.gCT >= 0 || q.gFV.gCV >= 0) {
            bArr2[0] = (byte) -1;
            bArr2[1] = (byte) -1;
            if (q.gFV.gCT >= 0) {
                bArr2[0] = (byte) q.gFV.gCT;
            }
            if (q.gFV.gCV >= 0) {
                bArr2[1] = (byte) q.gFV.gCV;
            }
            cVar.oFQ.setAppCmd(com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, bArr2, 2);
        }
        if (q.gFV.gCU >= 0 || q.gFV.gCW >= 0) {
            bArr2[0] = (byte) -1;
            bArr2[1] = (byte) -1;
            if (q.gFV.gCU >= 0) {
                bArr2[0] = (byte) q.gFV.gCU;
            }
            if (q.gFV.gCW >= 0) {
                bArr2[1] = (byte) q.gFV.gCW;
            }
            cVar.oFQ.setAppCmd(415, bArr2, 2);
        }
        if (q.gFV.gCX >= 0 || q.gFV.gCY >= 0) {
            bArr2[0] = (byte) -1;
            bArr2[1] = (byte) -1;
            if (q.gFV.gCX >= 0) {
                bArr2[0] = (byte) q.gFV.gCX;
            }
            if (q.gFV.gCY >= 0) {
                bArr2[1] = (byte) q.gFV.gCY;
            }
            cVar.oFQ.setAppCmd(422, bArr2, 2);
        }
        if (q.gFV.gCZ >= 0) {
            bArr2[0] = (byte) q.gFV.gCZ;
            cVar.oFQ.setAppCmd(416, bArr2, 1);
        }
        if (q.gFV.gDa >= 0 && q.gFV.gDa != 5) {
            bArr2[0] = (byte) q.gFV.gDa;
            cVar.oFQ.setAppCmd(417, bArr2, 1);
        }
        if (q.gFV.gDb >= 0 && q.gFV.gDb != 5) {
            bArr2[0] = (byte) q.gFV.gDb;
            cVar.oFQ.setAppCmd(418, bArr2, 1);
        }
        if (q.gFV.gDc >= 0) {
            bArr2[0] = (byte) q.gFV.gDc;
            cVar.oFQ.setAppCmd(419, bArr2, 1);
        }
        if (1 == q.gFV.gDA) {
            byte[] bArr4 = new byte[30];
            for (int i = 0; i < 15; i++) {
                bArr4[i * 2] = (byte) (q.gFV.gDB[i] & 255);
                bArr4[(i * 2) + 1] = (byte) ((q.gFV.gDB[i] >> 8) & 255);
            }
            cVar.oFQ.setAppCmd(420, bArr4, 30);
        }
        if (q.gFV.gDA == 0) {
            cVar.oFQ.setAppCmd(421, bArr, 1);
        }
        if (q.gFV.gDE > 0) {
            bArr2[0] = (byte) q.gFV.gDE;
            cVar.oFQ.setAppCmd(424, bArr2, 1);
        }
        if (q.gFV.gDd > 0) {
            bArr2[0] = (byte) q.gFV.gDd;
            cVar.oFQ.setAppCmd(com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, bArr2, 4);
        }
        if (q.gFV.gDM >= 0) {
            cVar.oFQ.setAppCmd(426, new byte[]{(byte) q.gFV.gDM, (byte) q.gFV.gDN, (byte) q.gFV.gDO, (byte) q.gFV.gDP}, 4);
        }
    }

    public c() {
        x.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
        Context context = ac.getContext();
        d cHM = com.tencent.wecall.talkroom.model.e.cHM();
        com.tencent.wecall.talkroom.model.e.iL(context);
        this.oFQ = cHM;
        this.oFQ.cCX();
        this.oFR = new b();
        int e = bh.e((Integer) ar.He().get(1));
        this.oFQ.a(o.bcV(), new 1(this));
        this.oFQ.ba(e, com.tencent.mm.z.q.FS());
        ar.CG().a(1918, this);
        ar.CG().a(1919, this);
        ar.CG().a(1927, this);
        ar.CG().a(1928, this);
        ar.CG().a(1929, this);
        ar.CG().a(1931, this);
        ar.CG().a(1932, this);
        ar.CG().a(1933, this);
        ar.CG().a(1935, this);
        ar.CG().a(1937, this);
        ar.CG().a(1938, this);
        ar.CG().a(1939, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        n nVar = (n) kVar;
        x.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + i + " errCode " + i2 + " cmdid " + nVar.lJX);
        this.oFQ.c(i2, nVar.lJW, nVar.lJX, nVar.fKk);
    }
}
