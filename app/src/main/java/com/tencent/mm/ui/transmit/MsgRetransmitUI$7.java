package com.tencent.mm.ui.transmit;

import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.d.a;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.Map.Entry;

class MsgRetransmitUI$7 implements a {
    final /* synthetic */ f hBy;
    final /* synthetic */ String hpU;
    final /* synthetic */ int pvf;
    final /* synthetic */ MsgRetransmitUI zoG;
    final /* synthetic */ String zoI;
    final /* synthetic */ String zoJ;

    MsgRetransmitUI$7(MsgRetransmitUI msgRetransmitUI, String str, int i, String str2, String str3, f fVar) {
        this.zoG = msgRetransmitUI;
        this.hpU = str;
        this.pvf = i;
        this.zoI = str2;
        this.zoJ = str3;
        this.hBy = fVar;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        Object obj2;
        if (i3 == 0 && i4 == 0) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj instanceof HashMap) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap != null) {
                for (Entry entry : hashMap.entrySet()) {
                    Long l = (Long) entry.getKey();
                    e eVar = (e) entry.getValue();
                    this.zoG.fileName = o.Pw().m(com.tencent.mm.aq.f.c(eVar), "", "");
                    if (obj2 != null) {
                        ar.Hg();
                        c.Fa().dI(l.longValue());
                        MsgRetransmitUI.a(this.zoG, this.hpU, this.pvf, this.zoI, this.zoJ, this.hBy);
                    }
                }
            }
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }
}
