package com.tencent.mm.plugin.profile.ui;

import android.os.Message;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

class n$2 extends af {
    final /* synthetic */ boolean kCv;
    final /* synthetic */ o kCw = null;

    n$2(boolean z, o oVar) {
        this.kCv = z;
    }

    public final void handleMessage(Message message) {
        int Gd = q.Gd();
        if (this.kCv) {
            Gd &= -33554433;
        } else {
            Gd |= 33554432;
        }
        ar.Hg();
        c.CU().set(34, Integer.valueOf(Gd));
        a com_tencent_mm_protocal_c_axg = new axg();
        com_tencent_mm_protocal_c_axg.vFu = 33554432;
        com_tencent_mm_protocal_c_axg.wEy = this.kCv ? 0 : 1;
        ar.Hg();
        c.EX().b(new e.a(39, com_tencent_mm_protocal_c_axg));
        if (this.kCw != null) {
            this.kCw.a(null, null);
        }
    }
}
