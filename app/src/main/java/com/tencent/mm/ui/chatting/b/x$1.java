package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;

class x$1 implements Runnable {
    final /* synthetic */ au heR;
    final /* synthetic */ boolean yBI = false;
    final /* synthetic */ x yBJ;

    x$1(x xVar, au auVar, boolean z) {
        this.yBJ = xVar;
        this.heR = auVar;
    }

    public final void run() {
        ((i) g.h(i.class)).V(this.heR);
        cf cfVar = this.heR;
        boolean z = this.yBI;
        PString pString = new PString();
        PString pString2 = new PString();
        if (a.a(cfVar, pString, pString2)) {
            String str = pString.value;
            String str2 = pString2.value;
            String str3 = cfVar.field_talker;
            boolean endsWith = str3.endsWith("@chatroom");
            String FS = cfVar.field_isSend == 1 ? q.FS() : endsWith ? ba.hP(cfVar.field_content) : str3;
            d dVar = new d();
            dVar.q("20source_publishid", str + ",");
            dVar.q("21uxinfo", str2 + ",");
            dVar.q("22clienttime", bh.Wp() + ",");
            dVar.q("23source_type", (cfVar.getType() == 62 ? 1 : 2) + ",");
            dVar.q("24scene", (endsWith ? 4 : 3) + ",");
            dVar.q("25scene_chatname", str3 + ",");
            dVar.q("26scene_username", FS + ",");
            dVar.q("27curr_publishid", ",");
            dVar.q("28curr_msgid", cfVar.field_msgSvrId + ",");
            dVar.q("29curr_favid", "0,");
            dVar.q("30isdownload", (z ? 1 : 0) + ",");
            dVar.q("31chatroom_membercount", (endsWith ? m.gl(str3) : 0) + ",");
            ((i) g.h(i.class)).b(((i) g.h(i.class)).z(cfVar), dVar);
            x.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + dVar.Sz());
            com.tencent.mm.plugin.report.service.g.pQN.h(12989, new Object[]{dVar});
        }
    }
}
