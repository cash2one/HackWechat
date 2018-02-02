package com.tencent.mm.plugin.game.d;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.lang.ref.WeakReference;

public class e {
    private static final String nxe = (a.bnF + "Game/Image/");
    private static e nxf;
    private f<String, Bitmap> nkX = new f(6);
    private f<String, Bitmap> nte = new f(15);
    private ColorDrawable nxg = new ColorDrawable(android.support.v4.content.a.c(ac.getContext(), R.e.bsq));
    private Bitmap nxh;
    private Bitmap nxi;

    public static abstract class b {
        public abstract void a(View view, Bitmap bitmap);
    }

    static /* synthetic */ Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i && height == i2) {
            return bitmap;
        }
        int i3;
        Bitmap createBitmap;
        int i4;
        float f = ((float) height) / ((float) i2);
        float f2 = ((float) width) / ((float) i);
        if (f < f2) {
            i3 = (int) (f * ((float) i));
            createBitmap = Bitmap.createBitmap(bitmap, (width - i3) / 2, 0, i3, height);
            i4 = i3;
            i3 = height;
        } else {
            i3 = (int) (((float) i2) * f2);
            createBitmap = Bitmap.createBitmap(bitmap, 0, (height - i3) / 2, width, i3);
            i4 = width;
        }
        x.d("MicroMsg.GameImageUtil", "resizeBitmap, bitmapW = %d, bitmapH = %d, newWidth = %d, newHeight = %d", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(i4), Integer.valueOf(i3)});
        return createBitmap;
    }

    static /* synthetic */ Bitmap x(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getHeight() > bitmap.getWidth() ? bitmap.getWidth() : bitmap.getHeight();
        return d.a(bitmap, width, width, false);
    }

    public static e aRV() {
        if (nxf == null) {
            synchronized (e.class) {
                if (nxf == null) {
                    nxf = new e();
                }
            }
        }
        return nxf;
    }

    private e() {
        try {
            this.nxh = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ac.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bv.a.getDensity(null));
            if (!(this.nxh == null || this.nxh.isRecycled())) {
                this.nxi = d.a(this.nxh, false, 0.5f * ((float) this.nxh.getWidth()));
            }
        } catch (Exception e) {
            x.i("MicroMsg.GameImageUtil", e.getMessage());
        }
        an.bin().c(new 1(this));
    }

    public final void h(ImageView imageView, String str) {
        a(imageView, str, null, null);
    }

    public final void a(ImageView imageView, String str, a aVar) {
        a(imageView, str, aVar, null);
    }

    public final void a(ImageView imageView, String str, a aVar, b bVar) {
        if (!bh.ov(str)) {
            Object obj;
            if (aVar == null) {
                aVar = new a().aRW();
            }
            if (!aVar.hDy || aVar.nxv) {
                obj = null;
            } else {
                if (this.nte.bt(str)) {
                    Bitmap bitmap = (Bitmap) this.nte.get(str);
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        if (imageView != null) {
                            imageView.setImageBitmap(bitmap);
                        }
                        if (bVar != null) {
                            bVar.a(imageView, bitmap);
                        }
                        obj = 1;
                    }
                }
                obj = null;
            }
            if (obj == null) {
                b(imageView, str, aVar, bVar);
            }
        }
    }

    private void b(ImageView imageView, String str, a aVar, b bVar) {
        c.a aVar2 = new c.a();
        aVar2.hDy = !aVar.nxv;
        File file = new File(nxe);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdir()) {
                    file2.renameTo(parentFile);
                } else {
                    x.e("MicroMsg.GameImageUtil", "mkdir error, %s", new Object[]{parentFile.getAbsolutePath()});
                }
            }
            if (!(file.mkdir() && file.isDirectory())) {
                x.e("MicroMsg.GameImageUtil", "mkdir error. %s", new Object[]{r0});
            }
        }
        String str2 = nxe + g.s(str.getBytes());
        aVar2.hDA = aVar.hDA;
        if (aVar.nxv) {
            aVar2.hDA = false;
            com.tencent.mm.pluginsdk.i.a.e.a.Sa(str2);
        } else {
            aVar2.hDC = str2;
        }
        aVar2.hDY = aVar.hDY;
        aVar2.hDX = false;
        if (imageView != null && aVar.nxu) {
            if (aVar.nxw == 0) {
                imageView.setImageDrawable(this.nxg);
            } else {
                imageView.setImageResource(aVar.nxw);
            }
        }
        o.PA().a(str, null, aVar2.PK(), new 2(this, bVar, aVar, imageView));
    }

    public final void a(ImageView imageView, String str, int i, int i2, int i3) {
        b 3 = new 3(this, imageView, i2, i, i3);
        x.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
        Bitmap bitmap = (Bitmap) this.nte.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            b(null, str, new a().aRW(), new 4(this, 3, i, i2, 0, str));
        } else {
            3.a(null, bitmap);
        }
    }

    public final Bitmap i(ImageView imageView, String str) {
        Bitmap a = com.tencent.mm.ad.b.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            if (this.nxh == null || this.nxh.isRecycled()) {
                try {
                    this.nxh = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ac.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bv.a.getDensity(null));
                } catch (Exception e) {
                }
            }
            if (!(this.nxh == null || this.nxh.isRecycled() || imageView == null)) {
                imageView.setImageBitmap(this.nxh);
            }
            return this.nxh;
        } else if (imageView == null) {
            return a;
        } else {
            imageView.setImageBitmap(a);
            return a;
        }
    }

    public final Bitmap j(ImageView imageView, String str) {
        Bitmap a = com.tencent.mm.ad.b.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            a = this.nxi;
        } else {
            a = d.a(a, false, 0.5f * ((float) a.getWidth()));
        }
        if (!(a == null || a.isRecycled() || imageView == null)) {
            imageView.setImageBitmap(a);
        }
        return a;
    }

    public final void a(ImageView imageView, String str, float f) {
        if (imageView != null && !bh.ov(str)) {
            Bitmap bitmap;
            if (this.nkX.bt(str)) {
                bitmap = (Bitmap) this.nkX.get(str);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                    return;
                }
            }
            bitmap = com.tencent.mm.pluginsdk.model.app.g.b(str, 1, f);
            if (bitmap == null || bitmap.isRecycled()) {
                imageView.setImageResource(R.g.bCC);
                an.bin().c(new 5(this, str, f, new WeakReference(imageView)));
                return;
            }
            imageView.setImageBitmap(bitmap);
            this.nkX.put(str, bitmap);
        }
    }
}
