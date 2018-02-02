package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.z.ar;

class ah$4 implements p$d {
    final /* synthetic */ au heR;
    final /* synthetic */ Context val$context;

    public ah$4(au auVar, Context context) {
        this.heR = auVar;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String str = menuItem.getTitle();
        if (bh.ov(this.heR.field_imgPath)) {
            x.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
            return;
        }
        p oc = q.oc(this.heR.field_imgPath);
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", new Object[]{str, q.e(str, this.heR.field_imgPath, oc == null ? 0 : oc.hXC)});
        ar.CG().a(new f(r0, 1), 0);
        g.pQN.h(10424, new Object[]{Integer.valueOf(34), Integer.valueOf(2), str});
        h.bu(this.val$context, this.val$context.getString(R.l.dGy));
    }
}
