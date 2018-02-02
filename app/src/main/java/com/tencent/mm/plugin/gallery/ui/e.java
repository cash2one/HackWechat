package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bh;

final class e {
    int mTL = -1;
    private c mTM;

    public e(c cVar) {
        this.mTM = cVar;
    }

    final void qA(int i) {
        c cVar = this.mTM;
        if (cVar.mRK != null && cVar.mRK.size() > i && i >= 0) {
            long j = ((GalleryItem$MediaItem) cVar.mRK.get(i)).mRf;
            String str = ((GalleryItem$MediaItem) cVar.mRK.get(i)).mld;
            String str2 = ((GalleryItem$MediaItem) cVar.mRK.get(i)).hOo;
            if (bh.ov(str)) {
                str = str2;
            }
            c.aND().b(str, ((GalleryItem$MediaItem) cVar.mRK.get(i)).getType(), str2, j);
        }
    }
}
