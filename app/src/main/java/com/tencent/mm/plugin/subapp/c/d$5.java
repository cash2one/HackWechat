package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.g.a.nu;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class d$5 extends c<nu> {
    final /* synthetic */ d rWp;

    d$5(d dVar) {
        this.rWp = dVar;
        this.xen = nu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = (int) ((nu) bVar).fFN.fnB.field_msgId;
        ar.Hg();
        cf dH = com.tencent.mm.z.c.Fa().dH((long) i);
        if (!(dH.field_msgId == 0 || dH.field_imgPath == null || bh.ov(dH.field_imgPath))) {
            g Mk = h.Mk(dH.field_imgPath);
            if (!(Mk == null || bh.ov(Mk.field_filename))) {
                Mk.field_status = 3;
                Mk.field_offset = 0;
                Mk.field_createtime = System.currentTimeMillis() / 1000;
                Mk.field_lastmodifytime = System.currentTimeMillis() / 1000;
                Mk.fDt = 16840;
                h.a(Mk);
                x.d("MicroMsg.VoiceRemindLogic", " file:" + Mk.field_filename + " msgid:" + Mk.field_msglocalid + "  stat:" + Mk.field_status);
                if (Mk.field_msglocalid == 0 || bh.ov(Mk.field_user)) {
                    x.e("MicroMsg.VoiceRemindLogic", " failed msg id:" + Mk.field_msglocalid + " user:" + Mk.field_user);
                } else {
                    dH.eQ(1);
                    ar.Hg();
                    com.tencent.mm.z.c.Fa().a(dH.field_msgId, dH);
                    d.bEc().run();
                }
            }
        }
        return false;
    }
}
