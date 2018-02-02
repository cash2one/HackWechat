package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.g.a;
import com.tencent.mm.plugin.favorite.a.e.2;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.s;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI.13;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

class FavoriteFileDetailUI$13$2 implements d {
    final /* synthetic */ 13 mwv;

    FavoriteFileDetailUI$13$2(13 13) {
        this.mwv = 13;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        a k;
        switch (menuItem.getItemId()) {
            case 0:
                if (FavoriteFileDetailUI.c(this.mwv.mwo) == 8) {
                    String h = j.h(FavoriteFileDetailUI.a(this.mwv.mwo));
                    if (!e.bO(h)) {
                        x.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                        Toast.makeText(this.mwv.mwo, this.mwv.mwo.getString(R.l.egx), 1).show();
                        return;
                    } else if (new File(h).length() > 10485760) {
                        x.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                        Toast.makeText(this.mwv.mwo, this.mwv.mwo.getString(R.l.egy), 1).show();
                        return;
                    }
                }
                k = FavoriteFileDetailUI.k(this.mwv.mwo);
                k.mod++;
                FavoriteFileDetailUI favoriteFileDetailUI = this.mwv.mwo;
                FavoriteFileDetailUI.b(this.mwv.mwo);
                FavoriteFileDetailUI.l(favoriteFileDetailUI);
                return;
            case 1:
                k = FavoriteFileDetailUI.m(this.mwv.mwo);
                k.moe++;
                final Dialog a = h.a(this.mwv.mwo.mController.xIM, this.mwv.mwo.getString(R.l.efz), false, null);
                Context context = this.mwv.mwo.mController.xIM;
                f b = FavoriteFileDetailUI.b(this.mwv.mwo);
                Runnable anonymousClass1 = new Runnable(this) {
                    final /* synthetic */ FavoriteFileDetailUI$13$2 mww;

                    public final void run() {
                        a.dismiss();
                    }
                };
                List linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(b.field_id));
                ar.CG().a(new s("", linkedList, new 2(b, context, anonymousClass1)), 0);
                return;
            case 2:
                h.a(this.mwv.mwo.mController.xIM, this.mwv.mwo.getString(R.l.dEx), "", new OnClickListener(this) {
                    final /* synthetic */ FavoriteFileDetailUI$13$2 mww;

                    {
                        this.mww = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        j.a(FavoriteFileDetailUI.b(this.mww.mwv.mwo).field_localId, new 1(this, h.a(this.mww.mwv.mwo.mController.xIM, this.mww.mwv.mwo.getString(R.l.dEx), false, null)));
                    }
                }, null);
                return;
            case 3:
                k = FavoriteFileDetailUI.o(this.mwv.mwo);
                k.mog++;
                Intent intent = new Intent(this.mwv.mwo.mController.xIM, FavTagEditUI.class);
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(this.mwv.mwo).field_localId);
                this.mwv.mwo.mController.xIM.startActivity(intent);
                return;
            case 4:
                FavoriteFileDetailUI.p(this.mwv.mwo);
                return;
            default:
                return;
        }
    }
}
