package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PayUMallOrderRecordListUI extends MallOrderRecordListUI {
    protected final void biH() {
        ji(1519);
        ji(1544);
    }

    protected final void biI() {
        jj(1519);
        jj(1544);
    }

    protected final void dG(String str, String str2) {
        l(new b(str));
    }

    protected final void biJ() {
        l(new a(this.wn));
    }

    protected final String uz(int i) {
        return e.a(i, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        Iterator it;
        if (kVar instanceof a) {
            if (this.mzP != null) {
                this.mzP.dismiss();
                this.mzP = null;
            }
            a aVar = (a) kVar;
            LinkedList linkedList = ((awn) aVar.gJQ.hmh.hmo).wEh;
            List linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                awx com_tencent_mm_protocal_c_awx = (awx) it.next();
                i iVar = new i();
                iVar.niZ = com_tencent_mm_protocal_c_awx.niZ;
                iVar.pbs = com_tencent_mm_protocal_c_awx.pbs;
                iVar.pbt = com_tencent_mm_protocal_c_awx.pbt;
                iVar.pbl = com_tencent_mm_protocal_c_awx.pbl;
                iVar.pbo = com_tencent_mm_protocal_c_awx.pbo;
                iVar.pbk = com_tencent_mm_protocal_c_awx.pbk;
                iVar.pbr = "0";
                iVar.pbn = com_tencent_mm_protocal_c_awx.pbn;
                iVar.pbq = com_tencent_mm_protocal_c_awx.pbq;
                iVar.pbw = 1;
                iVar.pbv = com_tencent_mm_protocal_c_awx.pbv;
                iVar.pbu = com_tencent_mm_protocal_c_awx.pbu;
                iVar.pbp = com_tencent_mm_protocal_c_awx.pbp;
                iVar.pbj = (double) com_tencent_mm_protocal_c_awx.wEa;
                iVar.pbm = com_tencent_mm_protocal_c_awx.pbm;
                iVar.pbi = com_tencent_mm_protocal_c_awx.pbi;
                linkedList2.add(iVar);
            }
            bl(linkedList2);
            bm(null);
            this.mCount = this.pcq.size();
            this.ogC = aVar.bNu() > this.mCount;
            this.pcp.notifyDataSetChanged();
            x.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
            x.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + aVar.bNu());
            x.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.ogC);
            this.mHandler.post(new 1(this));
            this.acS = false;
        } else if (kVar instanceof g) {
            if (this.mzP != null) {
                this.mzP.dismiss();
                this.mzP = null;
            }
            g gVar = (g) kVar;
            if (gVar.biC() == 2) {
                if (this.pcq != null) {
                    this.pcq.clear();
                }
                this.mCount = 0;
                this.ogC = false;
                this.ldB.cpq();
            } else {
                String biD = gVar.biD();
                x.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:" + biD);
                if (!bh.ov(biD)) {
                    for (i iVar2 : this.pcq) {
                        if (biD.equals(iVar2.pbi)) {
                            this.pcq.remove(iVar2);
                            this.mCount = this.pcq.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ PayUMallOrderRecordListUI tcJ;

                {
                    this.tcJ = r1;
                }

                public final void run() {
                    this.tcJ.pcp.notifyDataSetChanged();
                }
            });
        }
        if (this.mCount > 0 || this.pcq.size() != 0) {
            showOptionMenu(true);
            findViewById(f.ujY).setVisibility(8);
        } else {
            showOptionMenu(false);
            findViewById(f.ujY).setVisibility(0);
        }
        return true;
    }
}
