package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.AllRemindMsgUI.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.z.ar;

class AllRemindMsgUI$c$3 implements OnLongClickListener {
    final /* synthetic */ AllRemindMsgUI xDJ;
    final /* synthetic */ c xDK;

    AllRemindMsgUI$c$3(c cVar, AllRemindMsgUI allRemindMsgUI) {
        this.xDK = cVar;
        this.xDJ = allRemindMsgUI;
    }

    public final boolean onLongClick(final View view) {
        i iVar = new i(this.xDK.xDG.mController.xIM);
        int[] iArr = new int[2];
        if (view.getTag(R.h.cSF) instanceof int[]) {
            iArr = (int[]) view.getTag(R.h.cSF);
        }
        iVar.a(view, new 1(this), new d(this) {
            final /* synthetic */ AllRemindMsgUI$c$3 xDL;

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                x.i("MicroMsg.emoji.AllRemindMsgUI", "[onMMMenuItemSelected] delete item:%s", new Object[]{(AllRemindMsgUI.d) view.getTag()});
                ar.CG().a(new ah(2, r0.xDM), 0);
            }
        }, iArr[0], iArr[1]);
        return true;
    }
}
