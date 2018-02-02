package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;

class AttachDownloadPage$8 implements OnClickListener {
    final /* synthetic */ AttachDownloadPage pqt;

    AttachDownloadPage$8(AttachDownloadPage attachDownloadPage) {
        this.pqt = attachDownloadPage;
    }

    public final void onClick(View view) {
        if (AttachDownloadPage.i(this.pqt) == 3) {
            AttachDownloadPage.b(this.pqt, AttachDownloadPage.a(this.pqt));
            return;
        }
        AttachDownloadPage.h(this.pqt);
        AttachDownloadPage.e(this.pqt);
        AttachDownloadPage.f(this.pqt);
    }
}
