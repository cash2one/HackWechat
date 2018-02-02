package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.bg.9;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ak.b.a;
import com.tencent.wcdb.database.SQLiteDatabase;

class bg$9$1 implements a {
    final /* synthetic */ 9 rMI;

    bg$9$1(9 9) {
        this.rMI = 9;
    }

    public final void v(String str, boolean z) {
        if (this.rMI.rMH.tipDialog != null) {
            this.rMI.rMH.tipDialog.dismiss();
        }
        if (z) {
            b.I(str, 3);
            n.JS().iY(str);
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_Scene", 37);
            g.Dk();
            x WO = ((h) g.h(h.class)).EY().WO(str);
            if (WO != null && WO.cia()) {
                com.tencent.mm.plugin.report.service.g.pQN.k(10298, str + ",37");
                intent.putExtra("Contact_Scene", 37);
            }
            com.tencent.mm.plugin.sns.c.a.ifs.d(intent, this.rMI.rMH.context);
            return;
        }
        Toast.makeText(this.rMI.rMH.context, this.rMI.rMH.context.getString(j.ejg, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
    }
}
