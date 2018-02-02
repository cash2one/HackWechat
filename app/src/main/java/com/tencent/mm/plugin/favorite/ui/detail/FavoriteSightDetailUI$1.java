package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.favorite.a.h;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FavoriteSightDetailUI$1 implements OnClickListener {
    final /* synthetic */ FavoriteSightDetailUI mxe;

    FavoriteSightDetailUI$1(FavoriteSightDetailUI favoriteSightDetailUI) {
        this.mxe = favoriteSightDetailUI;
    }

    public final void onClick(View view) {
        if (!a.aW(view.getContext()) && !a.aU(view.getContext())) {
            x.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(FavoriteSightDetailUI.a(this.mxe).field_id), Long.valueOf(FavoriteSightDetailUI.a(this.mxe).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(this.mxe).field_itemStatus)});
            if (FavoriteSightDetailUI.a(this.mxe).isDone()) {
                if (j.e(FavoriteSightDetailUI.b(this.mxe))) {
                    h.a(h.a.mpQ, FavoriteSightDetailUI.a(this.mxe));
                    FavoriteSightDetailUI.a(this.mxe, true, view.getContext());
                    return;
                } else if (bh.ov(FavoriteSightDetailUI.b(this.mxe).wcJ)) {
                    FavoriteSightDetailUI.a(this.mxe, false, view.getContext());
                    return;
                } else {
                    x.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                }
            } else if (FavoriteSightDetailUI.a(this.mxe).aHN()) {
                if (bh.ov(FavoriteSightDetailUI.b(this.mxe).wcJ)) {
                    FavoriteSightDetailUI.a(this.mxe, false, view.getContext());
                    return;
                }
            } else if (FavoriteSightDetailUI.a(this.mxe).isDownloading() || FavoriteSightDetailUI.a(this.mxe).aHL()) {
                if (FavoriteSightDetailUI.c(this.mxe).getVisibility() == 8) {
                    FavoriteSightDetailUI.a(this.mxe, false);
                    return;
                }
                return;
            }
            if (FavoriteSightDetailUI.a(this.mxe).aHM()) {
                j.n(FavoriteSightDetailUI.a(this.mxe));
            } else {
                j.o(FavoriteSightDetailUI.a(this.mxe));
            }
            FavoriteSightDetailUI.a(this.mxe, false);
        }
    }
}
