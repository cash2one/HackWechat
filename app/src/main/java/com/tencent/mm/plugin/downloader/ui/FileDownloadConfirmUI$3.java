package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class FileDownloadConfirmUI$3 implements OnDismissListener {
    final /* synthetic */ FileDownloadConfirmUI lsV;

    FileDownloadConfirmUI$3(FileDownloadConfirmUI fileDownloadConfirmUI) {
        this.lsV = fileDownloadConfirmUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.lsV.finish();
    }
}
