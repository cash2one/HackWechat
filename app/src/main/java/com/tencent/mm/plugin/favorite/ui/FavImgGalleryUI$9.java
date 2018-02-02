package com.tencent.mm.plugin.favorite.ui;

import android.view.View;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.favorite.ui.FavImgGalleryUI.b;

class FavImgGalleryUI$9 implements Runnable {
    final /* synthetic */ FavImgGalleryUI msr;
    final /* synthetic */ c mst;

    FavImgGalleryUI$9(FavImgGalleryUI favImgGalleryUI, c cVar) {
        this.msr = favImgGalleryUI;
        this.mst = cVar;
    }

    public final void run() {
        int i = 0;
        View selectedView = FavImgGalleryUI.f(this.msr).getSelectedView();
        if (selectedView != null) {
            b bVar = (b) selectedView.getTag();
            int i2 = this.mst.field_totalLen > 0 ? ((this.mst.field_offset * 100) / this.mst.field_totalLen) - 1 : 0;
            if (i2 >= 0) {
                i = i2;
            }
            bVar.lAk.setProgress(i);
            bVar.msy.setText(i + "%");
            if (i >= 100 || this.mst.isFinished()) {
                FavImgGalleryUI.d(this.msr).notifyDataSetChanged();
            }
        }
    }
}
