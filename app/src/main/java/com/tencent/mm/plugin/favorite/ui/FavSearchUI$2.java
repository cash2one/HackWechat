package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.plugin.favorite.ui.b.e;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.pluginsdk.ui.applet.o$a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class FavSearchUI$2 implements OnItemClickListener {
    final /* synthetic */ FavSearchUI mth;

    FavSearchUI$2(FavSearchUI favSearchUI) {
        this.mth = favSearchUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        final b bVar = (b) view.getTag();
        if (1 == FavSearchUI.f(this.mth)) {
            if (bVar == null) {
                x.w("MicroMsg.FavSearchUI", "on item click, holder is null");
            } else if (bVar.mqC == null) {
                x.w("MicroMsg.FavSearchUI", "on item click, info is null");
            } else {
                a aVar = new a(this.mth.mController.xIM);
                aVar.bS(FavSearchUI.g(this.mth));
                e.a(aVar, this.mth.mController.xIM, bVar.mqC);
                e.b(aVar, this.mth.mController.xIM, bVar.mqC);
                aVar.f(Boolean.valueOf(true)).BW(R.l.dGA).a(new o$a(this) {
                    final /* synthetic */ FavSearchUI$2 mtj;

                    public final void a(boolean z, String str, int i) {
                        this.mtj.mth.aWs();
                        if (z) {
                            com.tencent.mm.plugin.favorite.a.e.a(this.mtj.mth.mController.xIM, FavSearchUI.g(this.mtj.mth), str, bVar.mqC, new 1(this, h.a(this.mtj.mth.mController.xIM, this.mtj.mth.getString(R.l.efz), false, null)));
                        }
                    }
                }).pyk.show();
            }
        } else if (2 != FavSearchUI.f(this.mth)) {
            FavSearchUI.e(this.mth).onItemClick(adapterView, view, i, j);
            if (bVar.mqC != null) {
                ar.Dm().F(new 2(this, bVar, i));
            }
        } else if (bVar == null) {
            x.w("MicroMsg.FavSearchUI", "on item click, holder is null");
        } else if (bVar.mqC == null) {
            x.w("MicroMsg.FavSearchUI", "on item click, info is null");
        } else {
            Intent intent = new Intent();
            intent.putExtra("key_fav_result_local_id", bVar.mqC.field_localId);
            this.mth.setResult(-1, intent);
            this.mth.finish();
        }
    }
}
