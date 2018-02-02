package com.tencent.mm.plugin.biz;

import android.text.TextUtils;
import com.tencent.mm.ag.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.i;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import com.tencent.mm.z.s;
import java.util.Iterator;
import java.util.Map;

public final class a implements com.tencent.mm.plugin.biz.a.a {
    public final String bK(String str, String str2) {
        String str3;
        Map y = bi.y(str, "msg");
        if (y == null) {
            x.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
            str3 = null;
        } else {
            str3 = (String) y.get(".msg.fromusername");
        }
        if (!bh.ov(str3) || s.hd(str2)) {
            str2 = str3;
        }
        if (bh.ov(str2)) {
            return "";
        }
        if (i.fV(str2)) {
            WxaAttributes qK = ((b) g.h(b.class)).qK(str2);
            if (!(qK == null || TextUtils.isEmpty(qK.field_nickname))) {
                return qK.field_nickname;
            }
        }
        return ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gu(str2);
    }

    public final boolean fV(String str) {
        return i.fV(str);
    }

    public final String vJ(String str) {
        Map y = bi.y(str, "msg");
        if (y == null) {
            x.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
            return " ";
        }
        int i = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        String az = bh.az((String) y.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        String str2 = null;
        if (az.equals("wx_f2f") || az.equals("wx_md")) {
            str2 = bh.ou((String) y.get(".msg.appmsg.title"));
        } else if (i != 0) {
            str2 = bh.ou((String) y.get(".msg.appmsg.mmreader.template_header.title"));
        }
        if (bh.ov(str2)) {
            str2 = (String) y.get(".msg.appmsg.mmreader.category.item.title");
        }
        return bh.ov(str2) ? " " : str2;
    }

    public final String vK(String str) {
        Map Vo = ax.Vo(str);
        if (Vo == null) {
            l fW = i.fW(str);
            StringBuilder stringBuilder = new StringBuilder("");
            Iterator it = fW.hdX.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (!bh.ov(mVar.title)) {
                    stringBuilder.append(mVar.title);
                    break;
                }
            }
            return stringBuilder.toString();
        }
        String str2 = (String) Vo.get(".msg.appmsg.mmreader.category.item.title");
        return str2 == null ? "" : str2;
    }

    public final l vL(String str) {
        Map Vo = ax.Vo(str);
        if (Vo == null) {
            return i.fW(str);
        }
        int i = bh.getInt((String) Vo.get(".msg.appmsg.mmreader.category.$type"), 0);
        String ou = bh.ou((String) Vo.get(".msg.appmsg.mmreader.name"));
        int i2 = bh.getInt((String) Vo.get(".msg.appmsg.mmreader.forbid_forward"), 0);
        int i3 = bh.getInt((String) Vo.get(".msg.appmsg.mmreader.category.$count"), 0);
        String str2 = (String) Vo.get(".msg.commenturl");
        l lVar = new l();
        lVar.type = i;
        lVar.name = ou;
        lVar.gjD = str2;
        lVar.hdY = i2;
        i = 0;
        while (i < i3) {
            m mVar = new m();
            String str3 = ".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i));
            mVar.title = (String) Vo.get(str3 + ".title");
            mVar.url = (String) Vo.get(str3 + ".url");
            mVar.heb = (String) Vo.get(str3 + ".shorturl");
            mVar.hec = (String) Vo.get(str3 + ".longurl");
            mVar.time = bh.getLong((String) Vo.get(str3 + ".pub_time"), 0);
            mVar.hee = (String) Vo.get(str3 + ".tweetid");
            mVar.hef = (String) Vo.get(str3 + ".digest");
            mVar.type = bh.getInt((String) Vo.get(str3 + ".itemshowtype"), 0);
            mVar.heh = bh.getInt((String) Vo.get(str3 + ".play_length"), 0);
            mVar.hed = (String) Vo.get(str3 + ".cover");
            mVar.heg = bh.getInt((String) Vo.get(str3 + ".del_flag"), 0);
            mVar.hei = (String) Vo.get(str3 + ".weapp_username");
            mVar.hej = (String) Vo.get(str3 + ".weapp_path");
            mVar.hek = bh.getInt((String) Vo.get(str3 + ".weapp_version"), 0);
            mVar.hel = bh.getInt((String) Vo.get(str3 + ".weapp_state"), 0);
            mVar.hem = (String) Vo.get(str3 + ".weapp_appid");
            mVar.hen = (String) Vo.get(str3 + ".weapp_image_url");
            mVar.heo = (String) Vo.get(str3 + ".weapp_icon");
            mVar.hep = (String) Vo.get(str3 + ".weapp_nickname");
            mVar.heq = (String) Vo.get(str3 + ".play_url");
            mVar.her = (String) Vo.get(str3 + ".player");
            mVar.hes = bh.getInt((String) Vo.get(str3 + ".music_source"), 1);
            mVar.het = bh.getInt((String) Vo.get(str3 + ".pic_num"), 1);
            lVar.hdX.add(mVar);
            i++;
        }
        lVar.haX = j.q(Vo);
        String ou2 = bh.ou((String) Vo.get(".msg.fromusername"));
        if (!bh.ov(ou2)) {
            str2 = ((h) g.h(h.class)).EY().WO(ou2).AP();
            lVar.fGz = ou2;
            lVar.fGA = str2;
        }
        return lVar;
    }
}
