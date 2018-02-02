package com.tencent.mm.plugin.photoedit.ui;

import com.tencent.mm.sdk.platformtools.x;

class MMNewPhotoEditUI$1 implements Runnable {
    final /* synthetic */ MMNewPhotoEditUI pdv;

    MMNewPhotoEditUI$1(MMNewPhotoEditUI mMNewPhotoEditUI) {
        this.pdv = mMNewPhotoEditUI;
    }

    public final void run() {
        x.i("MicroMsg.MMNewPhotoEditUI", "connected!!!");
        MMNewPhotoEditUI.a(this.pdv);
        this.pdv.initView();
    }
}
