package com.tencent.mm.ui.account;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelsimple.c;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class RegSetInfoUI$23 implements a {
    Bitmap mBitmap;
    String nlp;
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$23(RegSetInfoUI regSetInfoUI) {
        this.xSg = regSetInfoUI;
    }

    public final boolean JC() {
        if (!bh.ov(this.nlp) && bh.ov((RegSetInfoUI.b(this.xSg).getText()).trim())) {
            RegSetInfoUI.b(this.xSg).setText(this.nlp);
        }
        if (f.ze()) {
            if (!(this.mBitmap == null || this.mBitmap.isRecycled() || RegSetInfoUI.j(this.xSg))) {
                RegSetInfoUI.i(this.xSg).setImageBitmap(this.mBitmap);
                RegSetInfoUI.k(this.xSg);
                RegSetInfoUI.l(this.xSg).setVisibility(0);
            }
            return true;
        }
        x.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
        return false;
    }

    public final boolean JB() {
        try {
            this.nlp = c.bo(this.xSg);
            this.mBitmap = c.bp(this.xSg);
        } catch (Exception e) {
            x.e("MiroMsg.RegSetInfoUI", "getName or getBitmap err : " + e.getMessage());
        }
        if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
            try {
                d.a(this.mBitmap, 100, CompressFormat.PNG, e.gHB + "temp.avatar", false);
            } catch (Throwable e2) {
                x.e("MiroMsg.RegSetInfoUI", "save avatar fail." + e2.getMessage());
                x.printErrStackTrace("MiroMsg.RegSetInfoUI", e2, "", new Object[0]);
            }
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|initView";
    }
}
