package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;

class e$8 implements OnDismissListener {
    final /* synthetic */ Bitmap val$bmp;

    e$8(Bitmap bitmap) {
        this.val$bmp = bitmap;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.val$bmp != null && !this.val$bmp.isRecycled()) {
            this.val$bmp.recycle();
        }
    }
}
