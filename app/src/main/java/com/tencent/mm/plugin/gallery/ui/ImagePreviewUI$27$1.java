package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.27;

class ImagePreviewUI$27$1 implements Runnable {
    final /* synthetic */ boolean mUr;
    final /* synthetic */ boolean mUs;
    final /* synthetic */ 27 mUt;
    final /* synthetic */ Intent val$intent;

    ImagePreviewUI$27$1(27 27, Intent intent, boolean z, boolean z2) {
        this.mUt = 27;
        this.val$intent = intent;
        this.mUr = z;
        this.mUs = z2;
    }

    public final void run() {
        ImagePreviewUI.a(this.mUt.mUl, this.val$intent, this.mUr, this.mUs);
    }

    public final String toString() {
        return super.toString() + "|addTextOptionMenu";
    }
}
