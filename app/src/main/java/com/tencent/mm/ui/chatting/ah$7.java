package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.z.ar;

class ah$7 implements d {
    final /* synthetic */ Context val$context;
    final /* synthetic */ String yxI;

    public ah$7(String str, Context context) {
        this.yxI = str;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[]{menuItem.getTitle(), this.yxI});
        ar.CG().a(new j(r0, this.yxI, 48), 0);
        g.pQN.h(10424, new Object[]{Integer.valueOf(48), Integer.valueOf(16), r0});
        h.bu(this.val$context, this.val$context.getString(R.l.dGy));
    }
}
