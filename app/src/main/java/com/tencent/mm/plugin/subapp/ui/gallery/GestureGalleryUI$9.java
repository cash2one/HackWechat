package com.tencent.mm.plugin.subapp.ui.gallery;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class GestureGalleryUI$9 implements OnItemSelectedListener {
    final /* synthetic */ GestureGalleryUI rXs;

    GestureGalleryUI$9(GestureGalleryUI gestureGalleryUI) {
        this.rXs = gestureGalleryUI;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        GestureGalleryUI.a(this.rXs, i);
        this.rXs.setMMTitle((GestureGalleryUI.j(this.rXs) + 1) + " / " + GestureGalleryUI.k(this.rXs).size());
        x.d("MicroMsg.GestureGalleryUI", "pos:" + i);
        GestureGalleryUI.c(this.rXs, GestureGalleryUI.n(this.rXs).c((String) GestureGalleryUI.k(this.rXs).get(i), GestureGalleryUI.l(this.rXs), i, GestureGalleryUI.m(this.rXs)));
        if (bh.ov(GestureGalleryUI.b(this.rXs))) {
            GestureGalleryUI.c(this.rXs, (String) GestureGalleryUI.k(this.rXs).get(i));
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
