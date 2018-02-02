package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r$d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;

public final class y {

    public static class c extends r$d {
        public c(a aVar) {
            super(aVar);
        }

        public final void a(View view, a aVar, au auVar) {
            boolean z;
            String trim;
            b EL;
            com.tencent.mm.sdk.b.b ixVar;
            String str;
            Intent intent;
            cf cfVar = ((ar) view.getTag()).fEJ;
            String str2 = cfVar.field_content;
            if (cfVar.field_isSend == 0) {
                z = true;
            } else {
                z = false;
            }
            String str3 = "";
            if (z) {
                str3 = cfVar.field_talker;
            }
            if (s.eV(cfVar.field_talker) && z && !this.yqa.ywd.vnK) {
                int hO = ba.hO(str2);
                if (hO != -1) {
                    str3 = str2.substring(0, hO).trim();
                    trim = str2.substring(hO + 1).trim();
                    ar.Hg();
                    EL = com.tencent.mm.z.c.Fa().EL(trim);
                    if (!t.ov(str3) && s.eV(str3)) {
                        str3 = "";
                    }
                    ixVar = new ix();
                    ixVar.fzx.fzr = 1;
                    ixVar.fzx.fnB = cfVar;
                    com.tencent.mm.sdk.b.a.xef.m(ixVar);
                    str = ixVar.fzy.fwv;
                    if ((t.ov(ixVar.fzy.fzA) || !t.ov(str)) && !"err_not_started".equals(str)) {
                        intent = new Intent();
                        intent.putExtra("kMsgId", cfVar.field_msgId);
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", EL.nQx);
                        intent.putExtra("kwebmap_lng", EL.nQy);
                        intent.putExtra("kwebmap_scale", EL.fzv);
                        intent.putExtra("kPoiName", EL.nTe);
                        intent.putExtra("kisUsername", r.gu(str3));
                        intent.putExtra("Kwebmap_locaion", str);
                        ar.Hg();
                        intent.putExtra("kimg_path", com.tencent.mm.z.c.Fi());
                        intent.putExtra("map_talker_name", cfVar.field_talker);
                        intent.putExtra("view_type_key", 0);
                        intent.putExtra("kwebmap_from_to", true);
                        intent.putExtra("kPoi_url", EL.vcT);
                        intent.putExtra("soso_street_view_url", t.az(cfVar.field_reserved, ""));
                        g.pQN.h(12809, new Object[]{Integer.valueOf(2), ""});
                        d.a(this.yqa, "location", ".ui.RedirectUI", intent, 2002);
                    }
                    x.e("MicroMsg.LocationClickListener", "location not valid or subcore not started");
                    return;
                }
            }
            trim = str2;
            ar.Hg();
            EL = com.tencent.mm.z.c.Fa().EL(trim);
            str3 = "";
            ixVar = new ix();
            ixVar.fzx.fzr = 1;
            ixVar.fzx.fnB = cfVar;
            com.tencent.mm.sdk.b.a.xef.m(ixVar);
            str = ixVar.fzy.fwv;
            if (t.ov(ixVar.fzy.fzA)) {
            }
            intent = new Intent();
            intent.putExtra("kMsgId", cfVar.field_msgId);
            intent.putExtra("map_view_type", 1);
            intent.putExtra("kwebmap_slat", EL.nQx);
            intent.putExtra("kwebmap_lng", EL.nQy);
            intent.putExtra("kwebmap_scale", EL.fzv);
            intent.putExtra("kPoiName", EL.nTe);
            intent.putExtra("kisUsername", r.gu(str3));
            intent.putExtra("Kwebmap_locaion", str);
            ar.Hg();
            intent.putExtra("kimg_path", com.tencent.mm.z.c.Fi());
            intent.putExtra("map_talker_name", cfVar.field_talker);
            intent.putExtra("view_type_key", 0);
            intent.putExtra("kwebmap_from_to", true);
            intent.putExtra("kPoi_url", EL.vcT);
            intent.putExtra("soso_street_view_url", t.az(cfVar.field_reserved, ""));
            g.pQN.h(12809, new Object[]{Integer.valueOf(2), ""});
            d.a(this.yqa, "location", ".ui.RedirectUI", intent, 2002);
        }
    }
}
