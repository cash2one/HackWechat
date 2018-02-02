package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.k;

class a$k$1 implements Runnable {
    final /* synthetic */ View quh;
    final /* synthetic */ Bitmap qui;
    final /* synthetic */ k rmp;

    a$k$1(k kVar, View view, Bitmap bitmap) {
        this.rmp = kVar;
        this.quh = view;
        this.qui = bitmap;
    }

    public final void run() {
        this.quh.setBackgroundDrawable(new BitmapDrawable(this.qui));
    }
}
