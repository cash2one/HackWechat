package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.2;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

class ShakeTvHistoryListUI$2$1 implements OnClickListener {
    final /* synthetic */ 2 qsw;

    ShakeTvHistoryListUI$2$1(2 2) {
        this.qsw = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g gVar = g.pQN;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(2);
        o brE = m.brE();
        List<n> arrayList = new ArrayList();
        Cursor bsi = brE.bsi();
        if (bsi != null) {
            while (bsi.moveToNext()) {
                n nVar = new n();
                nVar.b(bsi);
                arrayList.add(nVar);
            }
            bsi.close();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (n nVar2 : arrayList) {
            stringBuilder.append(nVar2.field_username);
            stringBuilder.append("|");
        }
        objArr[1] = stringBuilder.toString();
        gVar.h(12662, objArr);
        m.brE().gJP.delete("shaketvhistory", null, null);
        ar.CG().a(new c(2, null), 0);
        ShakeTvHistoryListUI.a(this.qsw.qsv).Xy();
        this.qsw.qsv.enableOptionMenu(false);
    }
}
