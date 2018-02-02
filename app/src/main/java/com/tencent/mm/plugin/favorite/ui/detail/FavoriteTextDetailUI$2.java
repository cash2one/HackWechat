package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g.a;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.FavTextEditUI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;

class FavoriteTextDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteTextDetailUI mxo;

    FavoriteTextDetailUI$2(FavoriteTextDetailUI favoriteTextDetailUI) {
        this.mxo = favoriteTextDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.mxo.mController.xIM, g.ztp, false);
        gVar.rKC = new c(this) {
            final /* synthetic */ FavoriteTextDetailUI$2 mxp;

            {
                this.mxp = r1;
            }

            public final void a(n nVar) {
                if (this.mxp.mxo.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
                    nVar.f(2, this.mxp.mxo.getString(R.l.egz));
                }
                nVar.f(0, this.mxp.mxo.getString(R.l.eeW));
                nVar.f(3, this.mxp.mxo.getString(R.l.eeY));
                nVar.f(4, this.mxp.mxo.getString(R.l.dEw));
            }
        };
        gVar.rKD = new d(this) {
            final /* synthetic */ FavoriteTextDetailUI$2 mxp;

            {
                this.mxp = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                Intent intent;
                a b;
                switch (menuItem.getItemId()) {
                    case 0:
                        if (FavoriteTextDetailUI.a(this.mxp.mxo) != null && FavoriteTextDetailUI.a(this.mxp.mxo).field_favProto != null) {
                            intent = new Intent(this.mxp.mxo, FavTextEditUI.class);
                            intent.putExtra("key_value", FavoriteTextDetailUI.a(this.mxp.mxo).field_favProto.desc);
                            intent.putExtra("key_max_count", FavoriteTextDetailUI.JM());
                            intent.putExtra("key_show_confirm", true);
                            intent.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(this.mxp.mxo).field_id);
                            this.mxp.mxo.startActivityForResult(intent, 1);
                            b = FavoriteTextDetailUI.b(this.mxp.mxo);
                            b.mof++;
                            return;
                        }
                        return;
                    case 2:
                        if (FavoriteTextDetailUI.a(this.mxp.mxo) != null && FavoriteTextDetailUI.a(this.mxp.mxo).field_favProto != null) {
                            b = FavoriteTextDetailUI.c(this.mxp.mxo);
                            b.mod++;
                            String str = FavoriteTextDetailUI.a(this.mxp.mxo).field_favProto.desc;
                            Context context = this.mxp.mxo;
                            if (bh.ov(str)) {
                                x.e("MicroMsg.FavApplication", "shareTextToFriend content null");
                            } else {
                                Intent intent2 = new Intent();
                                intent2.putExtra("Retr_Msg_content", str);
                                intent2.putExtra("Retr_Msg_Type", 4);
                                intent2.putExtra("mutil_select_is_ret", true);
                                com.tencent.mm.plugin.favorite.d.ifs.l(intent2, context);
                            }
                            com.tencent.mm.plugin.report.service.g.pQN.h(10651, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)});
                            return;
                        }
                        return;
                    case 3:
                        intent = new Intent(this.mxp.mxo.mController.xIM, FavTagEditUI.class);
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(this.mxp.mxo).field_localId);
                        this.mxp.mxo.mController.xIM.startActivity(intent);
                        b = FavoriteTextDetailUI.d(this.mxp.mxo);
                        b.mog++;
                        return;
                    case 4:
                        h.a(this.mxp.mxo.mController.xIM, this.mxp.mxo.getString(R.l.dEx), "", new 1(this), null);
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUk();
        return true;
    }
}
