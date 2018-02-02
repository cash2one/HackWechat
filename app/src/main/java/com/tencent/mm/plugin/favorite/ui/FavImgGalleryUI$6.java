package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class FavImgGalleryUI$6 implements OnCancelListener {
    final /* synthetic */ FavImgGalleryUI msr;

    FavImgGalleryUI$6(FavImgGalleryUI favImgGalleryUI) {
        this.msr = favImgGalleryUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        FavImgGalleryUI.b(this.msr);
    }
}
