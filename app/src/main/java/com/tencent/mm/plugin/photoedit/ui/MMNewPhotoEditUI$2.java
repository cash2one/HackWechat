package com.tencent.mm.plugin.photoedit.ui;

import com.tencent.mm.api.d;
import com.tencent.mm.api.l;
import com.tencent.mm.sdk.platformtools.x;

class MMNewPhotoEditUI$2 implements l {
    final /* synthetic */ MMNewPhotoEditUI pdv;

    MMNewPhotoEditUI$2(MMNewPhotoEditUI mMNewPhotoEditUI) {
        this.pdv = mMNewPhotoEditUI;
    }

    public final void a(d dVar) {
        x.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedFeature] features:%s", new Object[]{dVar.name()});
    }

    public final void a(d dVar, int i) {
        x.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[]{dVar.name(), Integer.valueOf(i)});
    }

    public final void aD(boolean z) {
        if (z) {
            this.pdv.showVKB();
        } else {
            this.pdv.df(MMNewPhotoEditUI.b(this.pdv));
        }
    }
}
