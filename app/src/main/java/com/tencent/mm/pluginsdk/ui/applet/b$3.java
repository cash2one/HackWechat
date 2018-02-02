package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.sdk.platformtools.d;

class b$3 implements Runnable {
    final /* synthetic */ b vnd;

    b$3(b bVar) {
        this.vnd = bVar;
    }

    public final void run() {
        ImageView imageView = (ImageView) this.vnd.vna.getContentView().findViewById(R.h.bWV);
        if (imageView != null) {
            Bitmap a = b.a(this.vnd.lFr.field_username, false, -1);
            if (a != null && this.vnd.lFr.cia()) {
                a = d.a(a, false, (float) (a.getWidth() / 2));
            }
            if (a != null && !a.isRecycled()) {
                imageView.setImageBitmap(a);
                imageView.setVisibility(0);
            }
        }
    }
}
