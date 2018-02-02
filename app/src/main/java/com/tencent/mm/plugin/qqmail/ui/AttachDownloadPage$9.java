package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class AttachDownloadPage$9 extends a {
    final /* synthetic */ AttachDownloadPage pqt;

    AttachDownloadPage$9(AttachDownloadPage attachDownloadPage) {
        this.pqt = attachDownloadPage;
    }

    public final void onProgress(int i) {
        x.d("MicroMsg.AttachDownloadPage", "download progress : " + i);
        AttachDownloadPage.j(this.pqt);
        AttachDownloadPage.a(this.pqt, 1);
    }

    public final void onSuccess(String str, Map<String, String> map) {
        e.g(AttachDownloadPage.k(this.pqt), AttachDownloadPage.l(this.pqt) + ".temp", AttachDownloadPage.l(this.pqt));
        AttachDownloadPage.a(this.pqt, 3);
        Toast.makeText(this.pqt, this.pqt.getString(R.l.dZh) + " : " + AttachDownloadPage.a(this.pqt), 5000).show();
        AttachDownloadPage.d(this.pqt);
    }

    public final void onError(int i, String str) {
        AttachDownloadPage.a(this.pqt, 4);
        if (AttachDownloadPage.m(this.pqt) < 5) {
            AttachDownloadPage.n(this.pqt);
            AttachDownloadPage.f(this.pqt);
            return;
        }
        AttachDownloadPage.d(this.pqt);
    }

    public final void onComplete() {
    }
}
