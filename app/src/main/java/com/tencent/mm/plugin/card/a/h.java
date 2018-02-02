package com.tencent.mm.plugin.card.a;

import com.tencent.mm.a.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.y.g.a;
import java.util.Map;

public final class h {
    public int hcn;
    public String hco;
    public String hcp;
    public String hcq;
    public String hcr;
    public String hcs;
    public String hct;
    public String hcu;
    public int ver;

    public static h b(a aVar) {
        Map map = aVar.hdK;
        h hVar = new h();
        hVar.hco = bh.az((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
        hVar.hcn = o.bY((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
        hVar.hcp = bh.az((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
        hVar.hcq = bh.az((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        hVar.hcr = bh.az((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
        hVar.hcs = bh.az((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        hVar.hct = bh.az((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
        hVar.hcu = bh.az((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
        hVar.ver = o.bY((String) map.get(".msg.appmsg.giftcard_info.ver"));
        return hVar;
    }
}
