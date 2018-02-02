package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.avs;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;
import java.util.ArrayList;
import java.util.Iterator;

public final class c extends l {
    private b gJQ;
    private e gJT;
    public Orders sIO;
    public int sJa = 0;

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        a aVar = new a();
        aVar.hmj = new awd();
        aVar.hmk = new awe();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
        aVar.hmi = 1565;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        awd com_tencent_mm_protocal_c_awd = (awd) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_awd.ngo = str;
        com_tencent_mm_protocal_c_awd.vWh = str4;
        com_tencent_mm_protocal_c_awd.vWg = str2;
        com_tencent_mm_protocal_c_awd.vWi = str5;
        com_tencent_mm_protocal_c_awd.vWj = str6;
        com_tencent_mm_protocal_c_awd.vLX = str3;
        com_tencent_mm_protocal_c_awd.vVu = str7;
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        awe com_tencent_mm_protocal_c_awe = (awe) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i == 0) {
            i2 = com_tencent_mm_protocal_c_awe.lOr;
            str = com_tencent_mm_protocal_c_awe.lOs;
        }
        x.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_awe.wDN)});
        this.sJa = com_tencent_mm_protocal_c_awe.wDN;
        this.sIO = new Orders();
        this.sIO.sIJ = 1;
        if (com_tencent_mm_protocal_c_awe == null || com_tencent_mm_protocal_c_awe.wDK == null) {
            x.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
        } else {
            Iterator it;
            this.sIO.pNX = (double) com_tencent_mm_protocal_c_awe.wDK.wDQ;
            Commodity commodity = new Commodity();
            commodity.fuI = com_tencent_mm_protocal_c_awe.wDK.pLr;
            commodity.desc = com_tencent_mm_protocal_c_awe.wDK.hCk;
            commodity.ljg = ((double) com_tencent_mm_protocal_c_awe.wDK.wDQ) / 100.0d;
            commodity.pas = String.valueOf(com_tencent_mm_protocal_c_awe.wDK.wDS);
            commodity.pat = com_tencent_mm_protocal_c_awe.wDK.wDT;
            commodity.pax = com_tencent_mm_protocal_c_awe.wDK.wDP;
            commodity.pav = com_tencent_mm_protocal_c_awe.wDK.wDO;
            commodity.paz = com_tencent_mm_protocal_c_awe.wDK.paz;
            commodity.pao = com_tencent_mm_protocal_c_awe.wDK.wDR;
            commodity.sOk = ((double) com_tencent_mm_protocal_c_awe.wDK.wDU) / 100.0d;
            if (com_tencent_mm_protocal_c_awe.wDL != null) {
                commodity.paA = com_tencent_mm_protocal_c_awe.wDL.vRF;
                Promotions promotions = new Promotions();
                promotions.name = com_tencent_mm_protocal_c_awe.wDL.wDw;
                promotions.paA = com_tencent_mm_protocal_c_awe.wDL.vRF;
                commodity.sOl = com_tencent_mm_protocal_c_awe.wDL.vRF;
                promotions.peY = com_tencent_mm_protocal_c_awe.wDL.kJP;
                commodity.sNN = com_tencent_mm_protocal_c_awe.wDL.wDu;
                if (!bh.ov(promotions.name)) {
                    commodity.sOs.add(promotions);
                }
                this.sIO.sNN = com_tencent_mm_protocal_c_awe.wDL.wDu;
            } else {
                x.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
                this.sIO.sNN = 0;
            }
            if (com_tencent_mm_protocal_c_awe.wDK.wDV != null && com_tencent_mm_protocal_c_awe.wDK.wDV.size() > 0) {
                commodity.sOn = new ArrayList();
                it = com_tencent_mm_protocal_c_awe.wDK.wDV.iterator();
                while (it.hasNext()) {
                    avw com_tencent_mm_protocal_c_avw = (avw) it.next();
                    DiscountInfo discountInfo = new DiscountInfo();
                    discountInfo.pKc = com_tencent_mm_protocal_c_avw.wDx;
                    commodity.sOn.add(discountInfo);
                }
            }
            if (com_tencent_mm_protocal_c_awe.wDM != null && com_tencent_mm_protocal_c_awe.wDM.size() > 0) {
                commodity.sOs = new ArrayList();
                it = com_tencent_mm_protocal_c_awe.wDM.iterator();
                while (it.hasNext()) {
                    avs com_tencent_mm_protocal_c_avs = (avs) it.next();
                    Promotions promotions2 = new Promotions();
                    promotions2.type = Orders.sOj;
                    promotions2.url = com_tencent_mm_protocal_c_avs.url;
                    promotions2.name = com_tencent_mm_protocal_c_avs.fyY;
                    promotions2.peY = com_tencent_mm_protocal_c_avs.fDI;
                    promotions2.sNx = com_tencent_mm_protocal_c_avs.sUr;
                    promotions2.sOA = bh.getInt(com_tencent_mm_protocal_c_avs.type, 0);
                    promotions2.title = com_tencent_mm_protocal_c_avs.title;
                    promotions2.sIr = com_tencent_mm_protocal_c_avs.sOK;
                    promotions2.sOB = (int) com_tencent_mm_protocal_c_avs.sOL;
                    promotions2.sOD = com_tencent_mm_protocal_c_avs.sNy;
                    promotions2.sOC = (int) com_tencent_mm_protocal_c_avs.sOM;
                    promotions2.sNu = com_tencent_mm_protocal_c_avs.sON;
                    promotions2.sNv = com_tencent_mm_protocal_c_avs.sOO;
                    promotions2.sOE = com_tencent_mm_protocal_c_avs.wDr;
                    promotions2.sOF = com_tencent_mm_protocal_c_avs.wDs;
                    promotions2.sNw = com_tencent_mm_protocal_c_avs.sOP;
                    promotions2.sOG = com_tencent_mm_protocal_c_avs.wDt;
                    commodity.sOs.add(promotions2);
                }
            }
            this.sIO.sNW = new ArrayList();
            this.sIO.sNW.add(commodity);
            this.sIO.sNP = com_tencent_mm_protocal_c_awe.wDK.wDT;
            x.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[]{Integer.valueOf(this.sIO.sNW.size()), this.sIO});
        }
        if (bh.ov(str)) {
            str = ac.getContext().getString(a$i.uRf);
        }
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 1565;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
