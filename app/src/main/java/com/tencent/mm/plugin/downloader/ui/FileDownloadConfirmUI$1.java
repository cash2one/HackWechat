package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.x;

class FileDownloadConfirmUI$1 implements OnClickListener {
    final /* synthetic */ long lrL;
    final /* synthetic */ FileDownloadConfirmUI lsV;

    FileDownloadConfirmUI$1(FileDownloadConfirmUI fileDownloadConfirmUI, long j) {
        this.lsV = fileDownloadConfirmUI;
        this.lrL = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f.aAd().bX(this.lrL);
        x.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", new Object[]{Long.valueOf(this.lrL)});
    }
}
