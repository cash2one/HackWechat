package com.tencent.mm.plugin.readerapp.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView.g;

class ReaderAppUI$4 implements g {
    final /* synthetic */ ReaderAppUI pAY;

    ReaderAppUI$4(ReaderAppUI readerAppUI) {
        this.pAY = readerAppUI;
    }

    public final boolean azn() {
        if (ReaderAppUI.b(this.pAY).awe()) {
            ReaderAppUI.e(this.pAY).setSelectionFromTop(0, ReaderAppUI.d(this.pAY).ycr);
        } else {
            int awf = ReaderAppUI.b(this.pAY).awf();
            x.v("MicroMsg.ReaderAppUI", "onLoadData add count:" + awf);
            ReaderAppUI.b(this.pAY).a(null, null);
            ReaderAppUI.e(this.pAY).setSelectionFromTop(awf, ReaderAppUI.d(this.pAY).ycr);
        }
        return true;
    }
}
