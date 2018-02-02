package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gif.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class a$2 implements OnClickListener {
    final /* synthetic */ a mRS;

    a$2(a aVar) {
        this.mRS = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(View view) {
        Integer num = (Integer) view.getTag(R.h.cvw);
        GalleryItem$MediaItem galleryItem$MediaItem = (GalleryItem$MediaItem) a.a(this.mRS).get(num.intValue());
        if (galleryItem$MediaItem == null) {
            x.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
            return;
        }
        int i;
        boolean z;
        x.i("MicroMsg.AlbumAdapter", "click Image path:" + galleryItem$MediaItem.hOo);
        if (a.b(this.mRS).contains(galleryItem$MediaItem)) {
            a.b(this.mRS).indexOf(galleryItem$MediaItem);
            a.b(this.mRS).remove(galleryItem$MediaItem);
            i = 1;
            z = false;
        } else {
            if (c.aNE().aOh() == 3 && galleryItem$MediaItem != null && galleryItem$MediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                e eVar = new e(galleryItem$MediaItem.hOo);
                int bN = com.tencent.mm.a.e.bN(galleryItem$MediaItem.hOo);
                if (bN != 0) {
                    try {
                    } catch (Throwable e) {
                        x.e("MicroMsg.AlbumAdapter", bh.i(e));
                        return;
                    }
                }
                if (eVar.nyI[0] <= a.c(this.mRS).zE()) {
                }
                a.c(this.mRS).aj(13459, bN + ",1,,0");
                h.bu(a.d(this.mRS), a.d(this.mRS).getString(R.l.elv));
                return;
            }
            if (a.b(this.mRS).size() < a.e(this.mRS)) {
                a.b(this.mRS).add(galleryItem$MediaItem);
                a.b(this.mRS).size();
                i = 0;
                z = false;
            } else {
                i = 1;
                z = true;
            }
        }
        if (z) {
            if (a.g(this.mRS) == 1) {
                h.bu(a.d(this.mRS), a.d(this.mRS).getResources().getQuantityString(R.j.duw, a.e(this.mRS), new Object[]{Integer.valueOf(a.e(this.mRS))}));
            } else if (a.g(this.mRS) == 2) {
                h.bu(a.d(this.mRS), a.d(this.mRS).getResources().getQuantityString(R.j.duy, a.e(this.mRS), new Object[]{Integer.valueOf(a.e(this.mRS))}));
            } else {
                h.bu(a.d(this.mRS), a.d(this.mRS).getResources().getQuantityString(R.j.dux, a.e(this.mRS), new Object[]{Integer.valueOf(a.e(this.mRS))}));
            }
        } else if (a.f(this.mRS) != null) {
            a.f(this.mRS).K(this.mRS.mRL.size(), num.intValue(), i);
        }
        if (1 == i) {
            ((CheckBox) view.getTag(R.h.cvv)).setChecked(false);
            ((View) view.getTag(R.h.cvA)).setVisibility(0);
            ((View) view.getTag(R.h.cvA)).setBackgroundResource(R.e.bsQ);
            return;
        }
        ((CheckBox) view.getTag(R.h.cvv)).setChecked(true);
        ((View) view.getTag(R.h.cvA)).setVisibility(0);
        ((View) view.getTag(R.h.cvA)).setBackgroundResource(R.e.bsK);
    }
}
