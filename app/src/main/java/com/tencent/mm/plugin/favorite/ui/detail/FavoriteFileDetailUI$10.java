package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.sdk.platformtools.x;

class FavoriteFileDetailUI$10 implements OnClickListener {
    final /* synthetic */ FavoriteFileDetailUI mwo;
    final /* synthetic */ String mws;

    FavoriteFileDetailUI$10(FavoriteFileDetailUI favoriteFileDetailUI, String str) {
        this.mwo = favoriteFileDetailUI;
        this.mws = str;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[]{Integer.valueOf(FavoriteFileDetailUI.b(this.mwo).field_id), Long.valueOf(FavoriteFileDetailUI.b(this.mwo).field_localId)});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mws);
        intent.putExtra("is_favorite_item", true);
        intent.putExtra("fav_local_id", FavoriteFileDetailUI.b(this.mwo).field_localId);
        intent.putExtra("geta8key_scene", 14);
        d.j(intent, this.mwo.mController.xIM);
    }
}
