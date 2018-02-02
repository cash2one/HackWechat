package com.tencent.mm.plugin.mmsight.segment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.ui.a.a;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class MMSightEditUI$2 implements a {
    final /* synthetic */ MMSightEditUI oxG;

    MMSightEditUI$2(MMSightEditUI mMSightEditUI) {
        this.oxG = mMSightEditUI;
    }

    public final void bbe() {
        x.i("MicroMsg.MMSightEditUI", "onEditFinish");
        try {
            MMSightEditUI.b(this.oxG);
            if (MMSightEditUI.c(this.oxG) != null) {
                MMSightEditUI.c(this.oxG).gJ(false);
                MMSightEditUI.c(this.oxG).release();
                MMSightEditUI.d(this.oxG);
            }
            Bitmap mz = d.mz(MMSightEditUI.e(this.oxG));
            if (mz != null) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (d.a(mz.getWidth(), mz.getHeight(), MMSightEditUI.f(this.oxG).hup, pInt, pInt2)) {
                    mz = Bitmap.createScaledBitmap(mz, pInt.value, pInt2.value, true);
                }
                x.i("MicroMsg.MMSightEditUI", "getBitmap size = [%d, %d]", new Object[]{Integer.valueOf(mz.getWidth()), Integer.valueOf(mz.getHeight())});
                com.tencent.mm.sdk.platformtools.d.a(mz, 80, CompressFormat.JPEG, MMSightEditUI.g(this.oxG), true);
                Intent intent = new Intent();
                intent.putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.e(this.oxG));
                intent.putExtra("KSEGMENTVIDEOTHUMBPATH", MMSightEditUI.g(this.oxG));
                this.oxG.setResult(-1, intent);
                this.oxG.finish();
                return;
            }
            x.e("MicroMsg.MMSightEditUI", "getVideoThumb failed!");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightEditUI", e, "save video thumb error", new Object[0]);
            Toast.makeText(this.oxG, f.oyv, 1).show();
            this.oxG.finish();
        }
    }

    public final void bbf() {
        x.i("MicroMsg.MMSightEditUI", "onExitEdit");
        if (MMSightEditUI.c(this.oxG) != null) {
            MMSightEditUI.c(this.oxG).gJ(true);
            MMSightEditUI.c(this.oxG).release();
            MMSightEditUI.d(this.oxG);
        }
        this.oxG.finish();
    }

    public final void onError() {
        if (MMSightEditUI.c(this.oxG) != null) {
            MMSightEditUI.c(this.oxG).release();
            MMSightEditUI.d(this.oxG);
        }
        ag.y(new 1(this));
    }
}
