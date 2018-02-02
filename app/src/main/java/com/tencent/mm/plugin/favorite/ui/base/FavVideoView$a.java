package com.tencent.mm.plugin.favorite.ui.base;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.platformtools.ag;

class FavVideoView$a implements i, c {
    final /* synthetic */ FavVideoView mvJ;

    private FavVideoView$a(FavVideoView favVideoView) {
        this.mvJ = favVideoView;
    }

    public final void a(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar != null && cVar.field_dataId.equals(FavVideoView.f(this.mvJ))) {
            a(cVar.field_status, cVar.field_path, cVar.field_offset, cVar.field_totalLen);
        }
    }

    public final void a(int i, f fVar) {
        if (fVar != null && fVar.field_dataId.equals(FavVideoView.f(this.mvJ))) {
            a(fVar.field_status, fVar.field_path, fVar.field_offset, fVar.field_totalLen);
        }
    }

    private void a(int i, String str, int i2, int i3) {
        if ((i == 3 || i == 2) && e.bO(str)) {
            FavVideoView.a(this.mvJ).stop();
            FavVideoView.g(this.mvJ);
            FavVideoView.a(this.mvJ, str);
            ag.y(new 1(this));
            return;
        }
        FavVideoView.a(this.mvJ, i2, i3);
    }
}
