package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.z.ar;

class ah$8 implements p$d {
    final /* synthetic */ Context val$context;
    final /* synthetic */ String yxJ;

    public ah$8(String str, Context context) {
        this.yxJ = str;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", new Object[]{menuItem.getTitle(), this.yxJ});
        ar.CG().a(new j(r0, this.yxJ, 42), 0);
        g.pQN.h(10424, new Object[]{Integer.valueOf(42), Integer.valueOf(32), r0});
        h.bu(this.val$context, this.val$context.getString(R.l.dGy));
    }
}
