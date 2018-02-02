package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.b.w;

class AttachDownloadPage$3 implements OnClickListener {
    final /* synthetic */ AttachDownloadPage pqt;

    AttachDownloadPage$3(AttachDownloadPage attachDownloadPage) {
        this.pqt = attachDownloadPage;
    }

    public final void onClick(View view) {
        AttachDownloadPage.a(this.pqt, 2);
        w.bks().cancel(AttachDownloadPage.b(this.pqt));
        AttachDownloadPage.c(this.pqt);
        AttachDownloadPage.d(this.pqt);
    }
}
