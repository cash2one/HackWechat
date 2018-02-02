package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.g.a;
import java.util.ArrayList;

class l$1 implements Runnable {
    final /* synthetic */ l mRy;

    l$1(l lVar) {
        this.mRy = lVar;
    }

    public final void run() {
        ArrayList aNY = this.mRy.mRw.aNY();
        l lVar = this.mRy;
        a[] aVarArr = new a[lVar.mRu.size()];
        lVar.mRu.toArray(aVarArr);
        for (a x : aVarArr) {
            x.x(aNY);
        }
    }

    public final String toString() {
        return super.toString() + "|queryAlbums";
    }
}
