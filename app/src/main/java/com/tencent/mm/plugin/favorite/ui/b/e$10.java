package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteVideoPlayUI;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i.a.a;

class e$10 implements a {
    final /* synthetic */ f mxX;
    final /* synthetic */ Context val$context;

    e$10(f fVar, Context context) {
        this.mxX = fVar;
        this.val$context = context;
    }

    public final void aJL() {
        uq p = j.p(this.mxX);
        if (p == null) {
            x.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
        } else if (p.wdJ == null || (bh.ov(p.wdJ.hdo) && bh.ov(p.wdJ.hds))) {
            r1 = new Intent(this.val$context, FavoriteVideoPlayUI.class);
            r1.putExtra("key_detail_fav_path", j.h(p));
            r1.putExtra("key_detail_fav_thumb_path", j.i(p));
            r1.putExtra("key_detail_fav_video_duration", p.duration);
            r1.putExtra("key_detail_statExtStr", p.fGG);
            r1.putExtra("show_share", false);
            this.val$context.startActivity(r1);
        } else {
            x.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
            r1 = new Intent(this.val$context, FavoriteFileDetailUI.class);
            r1.putExtra("key_detail_info_id", this.mxX.field_localId);
            r1.putExtra("key_detail_data_id", p.mvG);
            r1.putExtra("key_detail_can_delete", false);
            this.val$context.startActivity(r1);
        }
    }
}
