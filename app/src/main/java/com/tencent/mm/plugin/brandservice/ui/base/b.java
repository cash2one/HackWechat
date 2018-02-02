package com.tencent.mm.plugin.brandservice.ui.base;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.m.a.a;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class b extends BitmapDrawable implements a {
    private static Bitmap feJ;
    private static af haq = new af(Looper.getMainLooper());
    private static int kHd = 200;
    private Runnable has;
    private String jKk;
    private Bitmap kHc;
    private Runnable kHe;
    private String mUrl;

    private b(String str, String str2) {
        if (feJ == null || feJ.isRecycled()) {
            feJ = Bitmap.createBitmap(200, 200, Config.ARGB_8888);
        }
        this(str, str2, feJ);
    }

    private b(String str, String str2, Bitmap bitmap) {
        super(bitmap);
        this.has = new 1(this);
        this.kHe = new Runnable(this) {
            final /* synthetic */ b kHf;

            {
                this.kHf = r1;
            }

            public final void run() {
                Bitmap d = m.d(this.kHf.jKk, this.kHf.mUrl, 0);
                if (d != null && !d.isRecycled()) {
                    b.haq.post(this.kHf.has);
                }
            }
        };
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        y.Mn().a(this);
        bM(str, str2);
    }

    public final void ki(String str) {
        if (this.jKk != null && this.jKk.equals(str)) {
            haq.postDelayed(this.has, (long) kHd);
        }
    }

    public final void draw(Canvas canvas) {
        this.kHc = m.kg(this.jKk);
        if (this.kHc == null || this.kHc.isRecycled()) {
            ar.Dm().g(this.kHe, (long) kHd);
            super.draw(canvas);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.kHc, new Rect(0, 0, this.kHc.getWidth(), this.kHc.getHeight()), bounds, getPaint());
    }

    public final void bM(String str, String str2) {
        if (bh.ov(str)) {
            x.w("MicroMsg.BrandAvatarDrawable", "The username is null or nil.");
        }
        this.jKk = str;
        if (str2 == this.mUrl) {
            return;
        }
        if (str2 == null || !(str2 == null || str2.equals(this.mUrl))) {
            x.i("MicroMsg.BrandAvatarDrawable", "set a new url for the drawable, url:[%s]", new Object[]{str2});
            this.mUrl = str2;
            haq.post(this.has);
        }
    }
}
