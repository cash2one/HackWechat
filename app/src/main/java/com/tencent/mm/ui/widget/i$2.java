package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.cb.a.e;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements OnLongClickListener {
    final /* synthetic */ OnCreateContextMenuListener zup;
    final /* synthetic */ i zuq;

    i$2(i iVar, OnCreateContextMenuListener onCreateContextMenuListener) {
        this.zuq = iVar;
        this.zup = onCreateContextMenuListener;
    }

    public final boolean onLongClick(View view) {
        x.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click");
        i.a(this.zuq).clear();
        i.a(this.zuq, view);
        this.zup.onCreateContextMenu(i.a(this.zuq), view, null);
        if (view.getTag(e.cSF) instanceof int[]) {
            int[] iArr = (int[]) view.getTag(e.cSF);
            this.zuq.bQ(iArr[0], iArr[1]);
        } else {
            this.zuq.bQ(0, 0);
        }
        return true;
    }
}
