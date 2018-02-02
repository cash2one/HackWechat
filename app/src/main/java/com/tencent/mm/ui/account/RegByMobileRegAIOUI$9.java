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

class RegByMobileRegAIOUI$9 implements a {
    Bitmap bitmap;
    String fpL;
    final /* synthetic */ RegByMobileRegAIOUI xQK;

    RegByMobileRegAIOUI$9(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.xQK = regByMobileRegAIOUI;
    }

    public final boolean JC() {
        if (!bh.ov(this.fpL) && bh.ov((RegByMobileRegAIOUI.h(this.xQK).getText()).trim())) {
            RegByMobileRegAIOUI.h(this.xQK).setText(this.fpL);
        }
        if (f.ze()) {
            if (!(this.bitmap == null || this.bitmap.isRecycled() || RegByMobileRegAIOUI.k(this.xQK))) {
                RegByMobileRegAIOUI.l(this.xQK).setImageBitmap(this.bitmap);
                RegByMobileRegAIOUI.m(this.xQK).setVisibility(8);
                RegByMobileRegAIOUI.n(this.xQK);
            }
            return true;
        }
        x.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
        return false;
    }

    public final boolean JB() {
        this.fpL = c.bo(this.xQK);
        this.bitmap = c.bp(this.xQK);
        if (!(this.bitmap == null || this.bitmap.isRecycled())) {
            try {
                d.a(this.bitmap, 100, CompressFormat.PNG, e.gHB + "temp.avatar", false);
            } catch (Throwable e) {
                x.e("MicroMsg.RegByMobileRegAIOUI", "save avatar fail." + e.getMessage());
                x.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", e, "", new Object[0]);
            }
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|initView2";
    }
}
