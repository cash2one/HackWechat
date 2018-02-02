package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;

class FavoriteVideoPlayUI$2 implements OnLongClickListener {
    final /* synthetic */ FavoriteVideoPlayUI mxB;

    FavoriteVideoPlayUI$2(FavoriteVideoPlayUI favoriteVideoPlayUI) {
        this.mxB = favoriteVideoPlayUI;
    }

    public final boolean onLongClick(View view) {
        view.getTag();
        l lVar = new l(this.mxB.mController.xIM);
        lVar.rKC = new c(this) {
            final /* synthetic */ FavoriteVideoPlayUI$2 mxC;

            {
                this.mxC = r1;
            }

            public final void a(n nVar) {
                if (FavoriteVideoPlayUI.a(this.mxC.mxB)) {
                    if (e.bO(FavoriteVideoPlayUI.b(this.mxC.mxB))) {
                        nVar.add(0, 1, 0, this.mxC.mxB.getString(R.l.egz));
                    }
                    nVar.add(0, 2, 0, this.mxC.mxB.getString(R.l.dRS));
                }
            }
        };
        lVar.rKD = new d(this) {
            final /* synthetic */ FavoriteVideoPlayUI$2 mxC;

            {
                this.mxC = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        Intent intent = new Intent();
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("select_is_ret", true);
                        intent.putExtra("mutil_select_is_ret", true);
                        if (e.bO(FavoriteVideoPlayUI.b(this.mxC.mxB))) {
                            intent.putExtra("image_path", FavoriteVideoPlayUI.b(this.mxC.mxB));
                        } else {
                            intent.putExtra("image_path", FavoriteVideoPlayUI.c(this.mxC.mxB));
                        }
                        intent.putExtra("Retr_Msg_Type", 1);
                        com.tencent.mm.bm.d.a(this.mxC.mxB.mController.xIM, ".ui.transmit.SelectConversationUI", intent, 1);
                        if (FavoriteVideoPlayUI.d(this.mxC.mxB) == 0) {
                            g.pQN.h(10651, new Object[]{Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0)});
                            return;
                        }
                        return;
                    case 2:
                        j.e(FavoriteVideoPlayUI.c(this.mxC.mxB), this.mxC.mxB);
                        return;
                    default:
                        return;
                }
            }
        };
        lVar.bBX();
        return true;
    }
}
