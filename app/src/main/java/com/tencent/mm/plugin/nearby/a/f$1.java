package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.R;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;

class f$1 extends c<it> {
    final /* synthetic */ f oOg;

    f$1(f fVar) {
        this.oOg = fVar;
        this.xen = it.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 3;
        it itVar = (it) bVar;
        ba.b bVar2 = itVar.fzj.fzk;
        cf cfVar = itVar.fzj.fnB;
        if (bVar2.hgI != null && bVar2.scene == 1) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(73729, Integer.valueOf(1));
            h hVar = new h();
            hVar.field_content = cfVar.field_content;
            hVar.field_createtime = bh.Wo();
            hVar.field_imgpath = "";
            hVar.field_sayhicontent = ac.getContext().getString(R.l.exz);
            hVar.field_sayhiuser = cfVar.field_talker;
            hVar.field_scene = 18;
            if (cfVar.field_status > 3) {
                i = cfVar.field_status;
            }
            hVar.field_status = i;
            hVar.field_svrid = cfVar.field_msgSvrId;
            hVar.field_talker = cfVar.field_talker;
            hVar.field_type = 34;
            hVar.field_isSend = 0;
            hVar.field_sayhiencryptuser = cfVar.field_talker;
            hVar.field_ticket = bVar2.hgI;
            l.Ty().a(hVar);
            b isVar = new is();
            isVar.fzh.fzi = cfVar.field_talker;
            a.xef.m(isVar);
        }
        return false;
    }
}
