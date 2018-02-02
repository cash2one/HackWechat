package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class FavoriteImgDetailUI$7 implements d {
    final /* synthetic */ FavoriteImgDetailUI mwK;
    final /* synthetic */ a mwO;

    FavoriteImgDetailUI$7(FavoriteImgDetailUI favoriteImgDetailUI, a aVar) {
        this.mwK = favoriteImgDetailUI;
        this.mwO = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String h = j.h(this.mwO.fve);
        if (e.bO(h)) {
            switch (menuItem.getItemId()) {
                case 1:
                    com.tencent.mm.plugin.favorite.d.c(h, this.mwK.mController.xIM);
                    g.pQN.h(10651, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
                    return;
                case 2:
                    if (p.UR(h)) {
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("select_is_ret", true);
                        com.tencent.mm.bm.d.a(this.mwK, ".ui.transmit.SelectConversationUI", intent, 1);
                    } else {
                        com.tencent.mm.plugin.favorite.d.d(h, this.mwK.mController.xIM);
                    }
                    g.pQN.h(10651, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0)});
                    return;
                case 3:
                    com.tencent.mm.plugin.favorite.d.a(h, this.mwK.getString(R.l.egt), this.mwK.mController.xIM);
                    return;
                case 4:
                    x.i("MicroMsg.FavoriteImgDetailUI", "request deal QBAR string");
                    b bzVar = new bz();
                    bzVar.fqa.activity = this.mwK;
                    bzVar.fqa.fov = this.mwO.mwS;
                    bzVar.fqa.fqb = this.mwO.fqb;
                    bzVar.fqa.fqd = 7;
                    if (this.mwO.fve != null) {
                        bzVar.fqa.imagePath = this.mwO.fve.wcJ;
                        bzVar.fqa.fqg = this.mwO.fve.wcL;
                    }
                    bzVar.fqa.fqc = this.mwO.fqc;
                    Bundle bundle = new Bundle(1);
                    bundle.putInt("stat_scene", 5);
                    bzVar.fqa.fqh = bundle;
                    com.tencent.mm.sdk.b.a.xef.m(bzVar);
                    return;
                default:
                    return;
            }
        }
        x.w("MicroMsg.FavoriteImgDetailUI", "file not exists");
    }
}
