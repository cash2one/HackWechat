package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsUploadUI$4 implements OnTouchListener {
    final /* synthetic */ SnsUploadUI rLR;

    SnsUploadUI$4(SnsUploadUI snsUploadUI) {
        this.rLR = snsUploadUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        x.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
        if (SnsUploadUI.b(this.rLR)) {
            return true;
        }
        return false;
    }
}
