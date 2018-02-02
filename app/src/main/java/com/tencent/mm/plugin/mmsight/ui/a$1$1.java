package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import com.tencent.mm.api.j;
import com.tencent.mm.plugin.mmsight.ui.a.1;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class a$1$1 implements j {
    final /* synthetic */ 1 oBV;

    a$1$1(1 1) {
        this.oBV = 1;
    }

    public final void b(Exception exception) {
        x.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", new Object[]{exception});
    }

    public final void a(Bitmap bitmap, boolean z) {
        x.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", new Object[]{bitmap, Boolean.valueOf(z)});
        if (z) {
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
            if (this.oBV.oBU.oBM == null || this.oBV.oBU.oBO) {
                if (this.oBV.oBU.oBO) {
                    ag.y(new 3(this));
                }
            } else if (this.oBV.oBU.oBG <= 0 || this.oBV.oBU.oBE <= 0 || this.oBV.oBU.oBG > this.oBV.oBU.oBE) {
                ag.y(new 2(this));
            } else {
                ag.y(new 1(this));
            }
        } else if (bitmap != null) {
            ag.y(new 4(this, bitmap));
        }
    }
}
