package com.tencent.mm.modelsimple;

import android.net.Uri;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.protocal.c.xh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class l$a {
    static b a(a aVar) {
        a aVar2 = new a();
        aVar2.hmj = new xg();
        aVar2.hmk = new xh();
        switch (l$1.hMN[aVar.ordinal()]) {
            case 1:
                aVar2.uri = "/cgi-bin/micromsg-bin/geta8key";
                aVar2.hmi = 233;
                aVar2.hml = 155;
                aVar2.hmm = 1000000155;
                break;
            case 2:
                aVar2.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
                aVar2.hmi = bc.CTRL_BYTE;
                aVar2.hml = 345;
                aVar2.hmm = 1000000345;
                break;
            case 3:
                aVar2.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
                aVar2.hmi = 835;
                aVar2.hml = d.CTRL_INDEX;
                aVar2.hmm = 1000000346;
                break;
            case 4:
                aVar2.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
                aVar2.hmi = 812;
                aVar2.hml = 387;
                aVar2.hmm = 1000000387;
                break;
            case 5:
                aVar2.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                aVar2.hmi = com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX;
                aVar2.hml = bb.CTRL_INDEX;
                aVar2.hmm = 1000000388;
                break;
            default:
                aVar2.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
                aVar2.hmi = com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX;
                aVar2.hml = bb.CTRL_INDEX;
                aVar2.hmm = 1000000388;
                break;
        }
        return aVar2.JZ();
    }

    static a R(String str, int i) {
        if (i == 5) {
            return a.hMS;
        }
        if (bh.ov(str)) {
            x.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
            return a.hMP;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return a.hMT;
            }
            String toLowerCase = bh.ou(parse.getHost()).toLowerCase();
            x.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", new Object[]{toLowerCase, bh.ov(parse.getFragment()) ? "" : "#" + parse.getFragment()});
            if (toLowerCase.equals("open.weixin.qq.com") || toLowerCase.equals("mp.weixin.qq.com") || toLowerCase.equals("mp.weixinbridge.com")) {
                return a.hMQ;
            }
            if (r0.contains("wechat_pay")) {
                return a.hMR;
            }
            if (toLowerCase.contains(".qq.com") || toLowerCase.equals("qq.com") || toLowerCase.contains(".wechat.com") || toLowerCase.equals("wechat.com") || toLowerCase.contains(".tenpay.com") || toLowerCase.equals("tenpay.com") || toLowerCase.contains(".url.cn") || toLowerCase.equals("url.com") || (!str.startsWith("http://") && !str.startsWith("https://"))) {
                return a.hMP;
            }
            return a.hMT;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[]{e.getMessage()});
            return a.hMP;
        }
    }

    static b b(b bVar) {
        xg xgVar = (xg) bVar.hmg.hmo;
        g.Dk();
        String ou = bh.ou((String) g.Dj().CU().get(46, null));
        xgVar.vJi = new bdn().bj(bh.VD(ou));
        g.Dk();
        String ou2 = bh.ou((String) g.Dj().CU().get(72, null));
        xgVar.whC = new bdn().bj(bh.VD(ou2));
        x.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + ou + " newa2=" + ou2);
        return bVar;
    }
}
