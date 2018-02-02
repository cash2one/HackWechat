package com.tencent.mm.ui.chatting;

import android.app.Dialog;
import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import com.tencent.mm.z.bo;

class ah$6 implements p$d {
    final /* synthetic */ au heR;
    final /* synthetic */ Context val$context;

    ah$6(au auVar, Context context) {
        this.heR = auVar;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String str = menuItem.getTitle();
        r nF = t.nF(this.heR.field_imgPath);
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", new Object[]{str, this.heR.field_imgPath});
        a aVar = new a();
        Context context = this.val$context;
        this.val$context.getResources().getString(R.l.dGO);
        Dialog a = h.a(context, this.val$context.getResources().getString(R.l.dGB), true, new 1(this, aVar));
        aVar.context = this.val$context;
        aVar.fileName = this.heR.field_imgPath;
        aVar.ilS = a;
        aVar.userName = str;
        aVar.zol = nF.hVL;
        aVar.hVH = nF.hVH;
        aVar.execute(new Object[0]);
        bo.HS().c(bo.hhF, null);
        h.bu(this.val$context, this.val$context.getString(R.l.dGy));
    }
}
