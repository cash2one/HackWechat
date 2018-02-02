package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Iterator;

class SelectContactUI$18 implements Runnable {
    final /* synthetic */ ArrayList yUC;
    final /* synthetic */ SelectContactUI yUy;

    SelectContactUI$18(SelectContactUI selectContactUI, ArrayList arrayList) {
        this.yUy = selectContactUI;
        this.yUC = arrayList;
    }

    public final void run() {
        String FS = q.FS();
        Iterator it = this.yUC.iterator();
        int i = 0;
        String str = null;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            x.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[]{str2});
            int i2 = i + (s.eV(str2) ? 1 : 0);
            k lVar = new l(4, FS, str2, this.yUy.getIntent().getStringExtra("shareImagePath"), 0, null, 0, "", str, true, R.g.bAH);
            ar.CG().a(lVar, 0);
            if (lVar.fnB != null) {
                str = lVar.fnB.field_imgPath;
            }
            i = i2;
        }
        SelectContactUI.e(this.yUy).dismiss();
        Intent intent = new Intent();
        intent.putStringArrayListExtra("Select_Contact", this.yUC);
        this.yUy.setResult(-1, intent);
        g.pQN.h(11048, new Object[]{Integer.valueOf(1), Integer.valueOf(this.yUC.size() - i), Integer.valueOf(i)});
        this.yUy.finish();
    }
}
