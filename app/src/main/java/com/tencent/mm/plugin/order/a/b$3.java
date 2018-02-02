package com.tencent.mm.plugin.order.a;

import android.text.TextUtils;
import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.c.awj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class b$3 implements a {
    final /* synthetic */ b oZS;

    b$3(b bVar) {
        this.oZS = bVar;
    }

    public final void a(final d.a aVar) {
        final String a = n.a(aVar.hmq.vGZ);
        x.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:" + a);
        b.a(this.oZS).post(new Runnable(this) {
            final /* synthetic */ b$3 oZU;

            public final void run() {
                c biw = b.biw();
                String str = a;
                String str2 = aVar.hmq.vGW;
                if (!TextUtils.isEmpty(str)) {
                    j Hi = c.Hi(str);
                    if (Hi == null) {
                        x.i("MicroMsg.MallPayMsgManager", "payMsg == null");
                    } else if (!TextUtils.isEmpty(Hi.pbs) || !TextUtils.isEmpty(Hi.pbJ) || !TextUtils.isEmpty(Hi.pbI) || !TextUtils.isEmpty(Hi.fDP) || !TextUtils.isEmpty(Hi.pbE) || !TextUtils.isEmpty(Hi.pbF) || !TextUtils.isEmpty(Hi.pbD) || !TextUtils.isEmpty(Hi.pbH) || !TextUtils.isEmpty(Hi.pbG) || !TextUtils.isEmpty(Hi.pbC)) {
                        if (Hi.pbC != null && com.tencent.mm.plugin.order.c.c.wP(Hi.pbC)) {
                            int intValue = Integer.valueOf(Hi.pbC).intValue();
                            if (!(intValue == 2 || intValue == 1)) {
                                return;
                            }
                        }
                        if (TextUtils.isEmpty(Hi.pbE)) {
                            Hi.fDJ = str2;
                        } else {
                            Hi.fDJ = str2 + Hi.pbE;
                        }
                        x.i("MicroMsg.MallPayMsgManager", "msgid: " + Hi.fDJ);
                        x.i("MicroMsg.MallPayMsgManager", "msgType: " + Hi.pbC);
                        if (biw.Hk(Hi.fDJ)) {
                            x.e("MicroMsg.MallPayMsgManager", "msg for id " + Hi.fDJ + " is exist!!");
                            com.tencent.mm.plugin.order.b.a Hm = biw.Hm(Hi.fDJ);
                            biw.Hj(Hi.fDJ);
                            biw.kJF.add(Hi);
                            biw.a(Hi, str, Hm.field_isRead);
                        } else {
                            biw.kJF.add(Hi);
                            biw.a(Hi, str, "0");
                        }
                        biw.biA();
                        b bit = b.bit();
                        if (Hi != null) {
                            awj com_tencent_mm_protocal_c_awj = new awj();
                            if (TextUtils.isEmpty(Hi.pbE) || !com.tencent.mm.plugin.order.c.c.wP(Hi.pbE)) {
                                com_tencent_mm_protocal_c_awj.pbl = (int) (System.currentTimeMillis() / 1000);
                                com_tencent_mm_protocal_c_awj.pbn = (int) (System.currentTimeMillis() / 1000);
                            } else {
                                com_tencent_mm_protocal_c_awj.pbl = Integer.valueOf(Hi.pbE).intValue();
                                com_tencent_mm_protocal_c_awj.pbn = Integer.valueOf(Hi.pbE).intValue();
                            }
                            com_tencent_mm_protocal_c_awj.pbq = 100000;
                            com_tencent_mm_protocal_c_awj.pbs = Hi.pbs;
                            com_tencent_mm_protocal_c_awj.pbi = Hi.fDJ;
                            com_tencent_mm_protocal_c_awj.pbm = Hi.pbG;
                            com_tencent_mm_protocal_c_awj.wEa = -1;
                            com_tencent_mm_protocal_c_awj.pbt = Hi.pbD;
                            com_tencent_mm_protocal_c_awj.pbu = Hi.pbG;
                            com_tencent_mm_protocal_c_awj.pbv = Hi.fDP;
                        }
                        bit.biu();
                    }
                }
            }
        });
    }
}
