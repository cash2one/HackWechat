package com.tencent.mm.plugin.gallery.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class AlbumPreviewUI$9 implements OnClickListener {
    final /* synthetic */ AlbumPreviewUI mSQ;

    AlbumPreviewUI$9(AlbumPreviewUI albumPreviewUI) {
        this.mSQ = albumPreviewUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mSQ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
