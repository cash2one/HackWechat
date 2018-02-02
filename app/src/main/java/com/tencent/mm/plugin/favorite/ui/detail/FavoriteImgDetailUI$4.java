package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.g$a;
import com.tencent.mm.plugin.favorite.ui.FavImgGalleryUI;
import com.tencent.mm.protocal.c.uq;

class FavoriteImgDetailUI$4 implements OnClickListener {
    final /* synthetic */ FavoriteImgDetailUI mwK;

    FavoriteImgDetailUI$4(FavoriteImgDetailUI favoriteImgDetailUI) {
        this.mwK = favoriteImgDetailUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.mwK.mController.xIM, FavImgGalleryUI.class);
        intent.putExtra("key_detail_info_id", FavoriteImgDetailUI.b(this.mwK).field_localId);
        intent.putExtra("key_detail_data_id", ((uq) view.getTag()).mvG);
        this.mwK.startActivity(intent);
        g$a f = FavoriteImgDetailUI.f(this.mwK);
        f.moc++;
    }
}
