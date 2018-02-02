package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.x;

class SnsGalleryUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SnsGalleryUI rBD;
    final /* synthetic */ boolean rBE;

    SnsGalleryUI$3(SnsGalleryUI snsGalleryUI, boolean z) {
        this.rBD = snsGalleryUI;
        this.rBE = z;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String str;
        String str2;
        SnsInfoFlip snsInfoFlip = this.rBD.ryY;
        if (snsInfoFlip.rBU == null) {
            str = "";
        } else {
            b bVar = (b) snsInfoFlip.rBU.getSelectedItem();
            str = bVar == null ? "" : bVar.raG;
        }
        snsInfoFlip = this.rBD.ryY;
        if (snsInfoFlip.rBU == null) {
            str2 = null;
        } else {
            bVar = (b) snsInfoFlip.rBU.getSelectedItem();
            str2 = bVar == null ? null : bVar.fHC.nGJ;
        }
        b bAW = this.rBD.ryY.bAW();
        x.d("MicroMsg.SnsGalleryUI", "click selectLocalId " + str);
        x.d("MicroMsg.SnsGalleryUI", "click position " + str2);
        m Lm = ae.bvv().Lm(str);
        try {
            int i;
            int i2 = this.rBD.ryY.rCl;
            int size = Lm.bxV().wQo.vYd.size();
            if (size <= 1 || i2 <= 1 || i2 > size) {
                i = 0;
            } else {
                i = i2 - 1;
            }
            this.rBD.ryV.a(this.rBE, Lm, bAW.fHC, true, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsGalleryUI", e, "", new Object[0]);
        }
        return true;
    }
}
