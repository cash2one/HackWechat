package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

class ReaderAppSubscribeUI$3 implements OnClickListener {
    final /* synthetic */ ReaderAppSubscribeUI pAO;

    ReaderAppSubscribeUI$3(ReaderAppSubscribeUI readerAppSubscribeUI) {
        this.pAO = readerAppSubscribeUI;
    }

    public final void onClick(View view) {
        c.a(ReaderAppSubscribeUI.b(this.pAO));
    }
}
