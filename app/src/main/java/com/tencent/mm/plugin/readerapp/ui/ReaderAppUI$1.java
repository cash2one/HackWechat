package com.tencent.mm.plugin.readerapp.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;

class ReaderAppUI$1 implements OnCreateContextMenuListener {
    final /* synthetic */ boolean pAX;
    final /* synthetic */ ReaderAppUI pAY;

    ReaderAppUI$1(ReaderAppUI readerAppUI, boolean z) {
        this.pAY = readerAppUI;
        this.pAX = z;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int intValue = ((Integer) view.getTag()).intValue();
        contextMenu.clear();
        if (ReaderAppUI.a(this.pAY) == 20) {
            contextMenu.setHeaderTitle(R.l.eoI);
        } else {
            contextMenu.setHeaderTitle(R.l.eoL);
        }
        if (20 == ReaderAppUI.a(this.pAY)) {
            if (this.pAX) {
                contextMenu.add(intValue, 0, 1, R.l.eBU);
            }
            if (d.OQ("favorite")) {
                contextMenu.add(intValue, 1, 2, R.l.eAd);
            }
            ReaderAppUI.a(this.pAY, ((Integer) view.getTag(R.h.cFJ)).intValue());
        }
        contextMenu.add(intValue, 2, 3, R.l.eBT);
    }
}
