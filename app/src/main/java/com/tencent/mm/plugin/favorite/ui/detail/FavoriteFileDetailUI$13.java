package com.tencent.mm.plugin.favorite.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.ui.widget.g;

class FavoriteFileDetailUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ FavoriteFileDetailUI mwo;
    final /* synthetic */ boolean mwt;
    final /* synthetic */ boolean mwu;

    FavoriteFileDetailUI$13(FavoriteFileDetailUI favoriteFileDetailUI, boolean z, boolean z2, int i) {
        this.mwo = favoriteFileDetailUI;
        this.mwt = z;
        this.mwu = z2;
        this.iGh = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (this.mwt) {
            FavoriteFileDetailUI.j(this.mwo);
            if (!d.c(FavoriteFileDetailUI.a(this.mwo))) {
            }
        }
        if (!this.mwu) {
            return false;
        }
        g gVar = new g(this.mwo.mController.xIM, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new 2(this);
        gVar.bUk();
        return true;
    }
}
