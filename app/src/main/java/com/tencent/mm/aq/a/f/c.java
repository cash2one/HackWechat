package com.tencent.mm.aq.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.aq.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements Runnable {
    private String aAM;
    private Bitmap bitmap;
    private b hEi;
    private com.tencent.mm.aq.a.c hEk;
    private String url;

    public c(String str, com.tencent.mm.aq.a.c cVar, Bitmap bitmap, b bVar, String str2) {
        this.url = str;
        this.hEk = cVar;
        this.bitmap = bitmap;
        this.hEi = bVar;
        this.aAM = str2;
    }

    public final void run() {
        if (bh.ov(this.url) || this.hEk == null || this.bitmap == null || this.bitmap.isRecycled() || this.hEi == null) {
            x.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
            return;
        }
        if (this.url.equals((String) this.hEi.hCY.get(Integer.valueOf(this.hEk.PI())))) {
            com.tencent.mm.aq.a.c cVar = this.hEk;
            Bitmap bitmap = this.bitmap;
            if (Looper.myLooper() == Looper.getMainLooper() && cVar.hDa != null) {
                ImageView imageView = (ImageView) cVar.hDa.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
            this.hEi.a(this.hEk);
            return;
        }
        x.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
    }
}
