package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.plugin.gallery.model.g.c;
import com.tencent.mm.plugin.gallery.model.l.2;
import java.util.ArrayList;

class l$2$1 implements c {
    final /* synthetic */ 2 mRA;

    l$2$1(2 2) {
        this.mRA = 2;
    }

    public final void a(ArrayList<MediaItem> arrayList, long j) {
        l lVar = this.mRA.mRy;
        b[] bVarArr = new b[lVar.mRv.size()];
        lVar.mRv.toArray(bVarArr);
        for (b a : bVarArr) {
            a.a(arrayList, j);
        }
    }
}
