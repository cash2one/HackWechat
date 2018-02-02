package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import com.tencent.mm.R;
import com.tencent.mm.ui.snackbar.a;

class FavImgGalleryUI$10 implements Runnable {
    final /* synthetic */ Dialog msk;
    final /* synthetic */ FavImgGalleryUI msr;

    FavImgGalleryUI$10(FavImgGalleryUI favImgGalleryUI, Dialog dialog) {
        this.msr = favImgGalleryUI;
        this.msk = dialog;
    }

    public final void run() {
        this.msk.dismiss();
        a.h(this.msr, this.msr.getString(R.l.eic));
    }
}
