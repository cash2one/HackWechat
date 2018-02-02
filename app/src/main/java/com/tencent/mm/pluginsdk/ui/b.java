package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends j implements a {
    Bitmap kHs;
    private float vjl;

    private b(String str) {
        super(com.tencent.mm.pluginsdk.ui.a.b.bZV(), str);
        this.vjl = 0.5f;
        this.kHs = null;
    }

    public b(String str, float f) {
        this(str);
        this.vjl = f;
    }

    public final void jh(String str) {
        super.jh(str);
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap = null;
        com.tencent.mm.br.a.a aVar = com.tencent.mm.br.a.a.a.xaZ;
        if (aVar != null) {
            bitmap = com.tencent.mm.br.a.a.a.xaZ.Dy(this.tag);
        }
        if (bitmap != null) {
            a(canvas, bitmap);
            return;
        }
        if (this.vkd) {
            bitmap = this.plt.b(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else {
            bitmap = this.plt.cm(this.tag);
        }
        if (bitmap != null) {
            bitmap = d.a(bitmap, false, this.vjl * ((float) bitmap.getWidth()));
            if (aVar != null) {
                aVar.p(this.tag, bitmap);
            }
            a(canvas, bitmap);
        } else if (bitmap == null || bitmap.isRecycled()) {
            if (this.kHs == null) {
                try {
                    this.kHs = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ac.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bv.a.getDensity(null));
                    this.kHs = d.a(this.kHs, false, this.vjl * ((float) this.kHs.getWidth()));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AvatarRoundDrawable", e, "", new Object[0]);
                }
            }
            a(canvas, this.kHs);
        }
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.vki > 1.0f || this.oxd) {
            int height = (bitmap.getHeight() / 15) / 2;
            int width = (bitmap.getWidth() / 15) / 2;
            rect = new Rect(width, height, bitmap.getWidth() - width, bitmap.getHeight() - height);
        }
        canvas.drawBitmap(bitmap, rect, bounds, hap);
    }
}
