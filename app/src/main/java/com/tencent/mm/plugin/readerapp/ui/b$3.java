package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.wcdb.database.SQLiteGlobal;

class b$3 extends af {
    final /* synthetic */ boolean kCv;
    final /* synthetic */ o kCw = null;
    final /* synthetic */ Context val$context;

    b$3(boolean z, Context context, o oVar) {
        this.kCv = z;
        this.val$context = context;
    }

    public final void handleMessage(Message message) {
        if (this.kCv) {
            b.hw(true);
        }
        int Gd = q.Gd();
        if (this.kCv) {
            Gd &= -524289;
        } else {
            Gd |= SQLiteGlobal.journalSizeLimit;
        }
        ar.Hg();
        c.CU().set(34, Integer.valueOf(Gd));
        a com_tencent_mm_protocal_c_axg = new axg();
        com_tencent_mm_protocal_c_axg.vFu = SQLiteGlobal.journalSizeLimit;
        if (this.kCv) {
            Gd = 0;
        } else {
            Gd = 1;
        }
        com_tencent_mm_protocal_c_axg.wEy = Gd;
        ar.Hg();
        c.EX().b(new e.a(39, com_tencent_mm_protocal_c_axg));
        if (!this.kCv) {
            g.a(new 1(this, h.a(this.val$context, this.val$context.getString(R.l.eBO), false, null)));
            b.hw(false);
        }
        if (this.kCw != null) {
            this.kCw.a(null, null);
        }
    }
}
