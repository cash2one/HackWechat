package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.widget.PopupWindow.OnDismissListener;

class e$6 implements OnDismissListener {
    final /* synthetic */ Bitmap val$bmp;

    e$6(Bitmap bitmap) {
        this.val$bmp = bitmap;
    }

    public final void onDismiss() {
        if (this.val$bmp != null && !this.val$bmp.isRecycled()) {
        }
    }
}
