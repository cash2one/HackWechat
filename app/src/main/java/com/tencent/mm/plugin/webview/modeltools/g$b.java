package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.Locale;

final class g$b implements Runnable {
    private Bitmap mBitmap;
    final /* synthetic */ g tvg;

    public g$b(g gVar, Bitmap bitmap) {
        this.tvg = gVar;
        this.mBitmap = bitmap;
    }

    public final void run() {
        this.tvg.tvd = String.format(Locale.US, "%s%s_%08x.jpg", new Object[]{e.bnF, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode())});
        try {
            d.a(this.mBitmap, 100, CompressFormat.JPEG, this.tvg.tvd, true);
        } catch (IOException e) {
            x.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + e.getMessage());
            this.tvg.tvd = null;
        }
        this.mBitmap.recycle();
        this.tvg.jKT.sendEmptyMessage(2);
    }
}
