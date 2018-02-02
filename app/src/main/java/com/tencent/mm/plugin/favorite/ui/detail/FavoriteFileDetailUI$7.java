package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.favorite.a.h;
import com.tencent.mm.plugin.favorite.a.h.a;
import com.tencent.mm.plugin.favorite.a.h.b;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.protocal.c.ut;

class FavoriteFileDetailUI$7 implements OnClickListener {
    final /* synthetic */ FavoriteFileDetailUI mwo;

    FavoriteFileDetailUI$7(FavoriteFileDetailUI favoriteFileDetailUI) {
        this.mwo = favoriteFileDetailUI;
    }

    public final void onClick(View view) {
        h.a(a.mpR, FavoriteFileDetailUI.b(this.mwo));
        ut utVar = FavoriteFileDetailUI.a(this.mwo).wdJ;
        String i = j.i(FavoriteFileDetailUI.a(this.mwo));
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", utVar.hdo);
        intent.putExtra("StreamWording", utVar.hdr);
        intent.putExtra("StremWebUrl", utVar.hds);
        intent.putExtra("KBlockFav", true);
        intent.putExtra("KThumUrl", utVar.hdt);
        intent.putExtra("KThumbPath", i);
        intent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(this.mwo).field_id);
        intent.putExtra("KMediaVideoTime", utVar.weC);
        intent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(this.mwo).title);
        intent.putExtra("KSta_StremVideoAduxInfo", utVar.hdu);
        intent.putExtra("KSta_StremVideoPublishId", utVar.hdv);
        intent.putExtra("KSta_SourceType", 1);
        intent.putExtra("KSta_Scene", b.mqb.value);
        intent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(this.mwo).field_fromUser);
        intent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(this.mwo).field_id);
        intent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(this.mwo).fGG);
        d.b(this.mwo, "sns", ".ui.VideoAdPlayerUI", intent);
    }
}
