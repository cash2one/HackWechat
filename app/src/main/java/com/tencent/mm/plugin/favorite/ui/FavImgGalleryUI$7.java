package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class FavImgGalleryUI$7 implements d {
    final /* synthetic */ FavImgGalleryUI msr;

    FavImgGalleryUI$7(FavImgGalleryUI favImgGalleryUI) {
        this.msr = favImgGalleryUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        com.tencent.mm.plugin.favorite.ui.base.d pK = FavImgGalleryUI.d(this.msr).pK(FavImgGalleryUI.c(this.msr));
        if (pK != null) {
            String h = j.h(pK.fve);
            if (e.bO(h)) {
                switch (menuItem.getItemId()) {
                    case 0:
                        g.pQN.h(10651, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0)});
                        if (p.UR(h)) {
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            com.tencent.mm.bm.d.a(this.msr, ".ui.transmit.SelectConversationUI", intent, 1);
                            return;
                        }
                        com.tencent.mm.plugin.favorite.d.d(h, this.msr);
                        return;
                    case 1:
                        com.tencent.mm.plugin.favorite.d.c(h, this.msr);
                        g.pQN.h(10651, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
                        return;
                    case 2:
                        com.tencent.mm.plugin.favorite.d.a(h, this.msr.getString(R.l.egt), this.msr);
                        return;
                    case 3:
                        mr mrVar = (mr) FavImgGalleryUI.e(this.msr).get(h);
                        if (mrVar != null) {
                            b bzVar = new bz();
                            bzVar.fqa.activity = this.msr;
                            bzVar.fqa.fov = mrVar.fED.result;
                            bzVar.fqa.fqb = mrVar.fED.fqb;
                            bzVar.fqa.fqd = 7;
                            if (!(pK == null || pK.fve == null)) {
                                bzVar.fqa.imagePath = pK.fve.wcJ;
                                bzVar.fqa.fqg = pK.fve.wcL;
                            }
                            bzVar.fqa.fqc = mrVar.fED.fqc;
                            Bundle bundle = new Bundle(1);
                            bundle.putInt("stat_scene", 5);
                            bzVar.fqa.fqh = bundle;
                            a.xef.m(bzVar);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            x.w("MicroMsg.FavImgGalleryUI", "file not exists");
        }
    }
}
