package com.tencent.mm.plugin.webview.ui.tools;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.sdk.platformtools.x;

class WebViewDownloadUI$4 implements o {
    final /* synthetic */ WebViewDownloadUI txr;

    WebViewDownloadUI$4(WebViewDownloadUI webViewDownloadUI) {
        this.txr = webViewDownloadUI;
    }

    public final void onTaskStarted(long j, String str) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", Long.valueOf(j), str);
    }

    public final void c(long j, String str, boolean z) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", Long.valueOf(j), str, Boolean.valueOf(z));
        Toast.makeText(this.txr.mController.xIM, this.txr.getString(R.l.eWD), 1).show();
        this.txr.finish();
    }

    public final void c(long j, int i, boolean z) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z));
        Toast.makeText(this.txr.mController.xIM, this.txr.getString(R.l.eWA), 1).show();
        this.txr.finish();
    }

    public final void onTaskRemoved(long j) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", Long.valueOf(j));
        this.txr.finish();
    }

    public final void onTaskPaused(long j) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", Long.valueOf(j));
    }

    public final void ck(long j) {
    }

    public final void k(long j, String str) {
        x.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", Long.valueOf(j), str);
    }
}
