package com.tencent.mm.plugin.luckymoney.a;

import android.text.TextUtils;
import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import java.net.URLDecoder;
import java.util.Map;

class a$1 implements a {
    final /* synthetic */ a nYP;

    a$1(a aVar) {
        this.nYP = aVar;
    }

    public final void a(d.a aVar) {
        Map y = bi.y(n.a(aVar.hmq.vGZ), "sysmsg");
        x.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
        if (y == null) {
            x.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
            return;
        }
        if ("14".equals((String) y.get(".sysmsg.paymsg.PayMsgType"))) {
            String decode = URLDecoder.decode((String) y.get(".sysmsg.paymsg.appmsgcontent"));
            if (TextUtils.isEmpty(decode)) {
                x.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
                return;
            }
            Map y2 = bi.y(decode, "msg");
            if (y2 == null) {
                x.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
                return;
            }
            String str = (String) y2.get(".msg.appmsg.wcpayinfo.paymsgid");
            if (bh.ov(str)) {
                x.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
                return;
            }
            String str2 = (String) y.get(".sysmsg.paymsg.tousername");
            if (bh.ov(decode) || bh.ov(str2)) {
                x.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            } else if (this.nYP.aWS().DT(str)) {
                x.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
                if (!com.tencent.mm.plugin.luckymoney.b.n.z(decode, str2, 1)) {
                    this.nYP.aWS().DU(str);
                }
            }
        }
    }
}
