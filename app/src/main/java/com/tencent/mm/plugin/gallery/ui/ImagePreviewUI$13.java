package com.tencent.mm.plugin.gallery.ui;

import android.support.v4.view.ViewPager.e;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.x;

class ImagePreviewUI$13 implements e {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$13(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final void ae(int i) {
        c.qi(i);
        String kC = ImagePreviewUI.h(this.mUl).kC(i);
        ImagePreviewUI.a(this.mUl, i, kC);
        boolean contains = ImagePreviewUI.d(this.mUl).contains(kC);
        ImagePreviewUI.a(this.mUl, Integer.valueOf(i));
        ImagePreviewUI.e(this.mUl).setImageResource(contains ? R.k.dxO : R.k.dxP);
        if (ImagePreviewUI.b(this.mUl)) {
            ImagePreviewUI.c(this.mUl).setImageResource(R.k.dAr);
        } else {
            ImagePreviewUI.c(this.mUl).setImageResource(R.k.dAq);
        }
        this.mUl.setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(ImagePreviewUI.h(this.mUl).getCount())}));
        e eVar = ImagePreviewUI.h(this.mUl).mTo;
        if (eVar.mTL == -1) {
            int i2 = 0;
            while (true) {
                if (i2 != 0) {
                    if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                        break;
                    }
                    if (i + i2 <= i + 3) {
                        eVar.qA(i + i2);
                    }
                    if (i - i2 >= Math.max(i - 3, 0)) {
                        eVar.qA(i - i2);
                    }
                } else {
                    eVar.qA(i);
                }
                i2++;
            }
        } else if (eVar.mTL > i) {
            eVar.qA(Math.max(i - 3, 0));
        } else if (eVar.mTL < i) {
            eVar.qA(i + 3);
        }
        eVar.mTL = i;
        x.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = " + i);
        MediaItem Bt = c.Bt(kC);
        if (ImagePreviewUI.t(this.mUl).getVisibility() == 0 || ImagePreviewUI.u(this.mUl).getVisibility() == 0) {
            ImagePreviewUI.a(this.mUl, kC, Bt);
            ImagePreviewUI.a(this.mUl, Bt);
        }
    }

    public final void a(int i, float f, int i2) {
    }

    public final void af(int i) {
        if (ImagePreviewUI.h(this.mUl) != null) {
            ImagePreviewUI.h(this.mUl).mTp.af(i);
        }
    }
}
