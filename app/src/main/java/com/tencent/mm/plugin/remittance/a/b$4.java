package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.mm.ae.d;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.q;
import java.net.URLDecoder;
import java.util.Map;

class b$4 implements a {
    final /* synthetic */ b pHb;

    b$4(b bVar) {
        this.pHb = bVar;
    }

    public final void a(d.a aVar) {
        x.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
        bw bwVar = aVar.hmq;
        if (bwVar == null) {
            x.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
            return;
        }
        String a = n.a(bwVar.vGZ);
        if (bh.ov(a)) {
            x.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
            return;
        }
        Map y = bi.y(a, "sysmsg");
        if (y == null) {
            x.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
            return;
        }
        a = (String) y.get(".sysmsg.paymsg.PayMsgType");
        String str;
        if ("15".equals(a)) {
            String decode = URLDecoder.decode((String) y.get(".sysmsg.paymsg.appmsgcontent"));
            if (TextUtils.isEmpty(decode)) {
                x.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                return;
            }
            Map y2 = bi.y(decode, "msg");
            if (y2 == null) {
                x.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                return;
            }
            a = (String) y2.get(".msg.appmsg.wcpayinfo.transferid");
            if (bh.ov(a)) {
                x.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
            } else if (this.pHb.bnp().Iq(a)) {
                x.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
            } else {
                str = (String) y.get(".sysmsg.paymsg.tousername");
                if (bh.ov(decode) || bh.ov(str)) {
                    x.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                } else {
                    this.pHb.bnp().P(a, decode, str);
                }
            }
        } else if ("22".equals(a)) {
            a = (String) y.get(".sysmsg.paymsg.tousername");
            str = (String) y.get(".sysmsg.paymsg.fromusername");
            try {
                String decode2 = URLDecoder.decode((String) y.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                if (bh.ov(decode2)) {
                    x.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                    return;
                }
                Map y3 = bi.y(decode2, "msg");
                if (y3 == null) {
                    x.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                    return;
                }
                String str2 = (String) y3.get(".msg.appmsg.wcpayinfo.transferid");
                int i = bh.getInt((String) y3.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
                x.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[]{str, a, str2, Integer.valueOf(i)});
                c cVar = null;
                try {
                    b.bnm();
                    cVar = b.bnn().Io(str2);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SubCoreRemittance", e, "", new Object[0]);
                }
                if (cVar == null) {
                    x.i("MicroMsg.SubCoreRemittance", "empty record");
                    return;
                }
                cf dH = ((h) g.h(h.class)).aZi().dH(cVar.field_msgId);
                if (dH.field_msgId <= 0) {
                    x.i("MicroMsg.SubCoreRemittance", "has delete msg");
                    b.bnm();
                    b.bnn().a(cVar, new String[0]);
                    return;
                }
                x.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[]{Long.valueOf(dH.field_msgId)});
                dH.setContent(decode2);
                ((h) g.h(h.class)).aZi().a(dH.field_msgId, dH);
                com.tencent.mm.plugin.remittance.b.c Ip = b.bno().Ip(str2);
                if (Ip != null) {
                    Ip.field_receiveStatus = i;
                    b.bno().a(Ip);
                } else if (!dH.field_talker.equals(q.FS())) {
                    Ip = new com.tencent.mm.plugin.remittance.b.c();
                    Ip.field_locaMsgId = dH.field_msgId;
                    Ip.field_transferId = str2;
                    Ip.field_receiveStatus = i;
                    Ip.field_isSend = false;
                    b.bno().a(Ip);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SubCoreRemittance", e2, "", new Object[0]);
            }
        } else if ("33".equals(a)) {
            int i2 = bh.getInt((String) y.get(".sysmsg.paymsg.opentransferbankcard"), 0);
            t CU = g.Dj().CU();
            CU.a(w.a.xxn, Integer.valueOf(i2));
            x.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(((Integer) CU.get(w.a.xxo, Integer.valueOf(0))).intValue())});
            if (((Integer) CU.get(w.a.xxo, Integer.valueOf(0))).intValue() == 0) {
                com.tencent.mm.s.c.Bq().b(w.a.xxi, true);
                CU.a(w.a.xxo, Integer.valueOf(1));
                g.Dj().CU().a(w.a.xxj, Boolean.valueOf(false));
            }
        }
    }
}
