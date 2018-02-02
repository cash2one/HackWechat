package com.tencent.mm.plugin.shake.d.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends BitmapDrawable implements com.tencent.mm.platformtools.j.a {
    private static final Paint hap;
    private static Bitmap qqe;
    private int nxw;
    private String qqb;
    private ImageView qqc;
    private i qqd;
    private int type;
    private String username;

    private static class a implements i {
        private String qqb;

        public a(String str) {
            this.qqb = str;
        }

        public final String Wf() {
            return a.Hu(this.qqb);
        }

        public final String Wg() {
            return this.qqb;
        }

        public final String Wh() {
            return this.qqb;
        }

        public final String Wi() {
            return this.qqb;
        }

        public final boolean Wj() {
            return true;
        }

        public final boolean Wk() {
            return false;
        }

        public final Bitmap Wl() {
            return BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEi);
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar, String str) {
            if (com.tencent.mm.platformtools.i.a.ice == aVar) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, a.Hu(this.qqb), false);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                    x.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
                }
            }
            x.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", new Object[]{aVar.toString()});
            return bitmap;
        }

        public final void Wm() {
        }

        public final void N(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
        }

        public final b We() {
            return null;
        }
    }

    static {
        Paint paint = new Paint();
        hap = paint;
        paint.setAntiAlias(true);
        hap.setFilterBitmap(true);
    }

    public final void draw(Canvas canvas) {
        x.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[]{this.username, this.qqb, Integer.valueOf(this.type), toString()});
        if (4 == this.type || (k.we(this.type) && 6 != this.type)) {
            Bitmap a;
            if (4 == this.type) {
                this.qqd = new a(this.qqb);
                a = j.a(this.qqd);
            } else if (!k.we(this.type) || 6 == this.type) {
                a = null;
            } else {
                this.qqd = new com.tencent.mm.plugin.shake.e.b(this.qqb);
                a = j.a(this.qqd);
            }
            if (a == null || a.isRecycled()) {
                x.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[]{this.qqb});
                a = D(this.qqc, this.nxw);
            }
            if (a != null) {
                canvas.drawBitmap(a, null, getBounds(), hap);
            }
        }
    }

    private static Bitmap D(View view, int i) {
        if (view == null) {
            return qqe;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (qqe == null || qqe.getWidth() != measuredWidth) {
            if (i > 0) {
                try {
                    qqe = d.u(view.getResources().getDrawable(i));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                }
            } else {
                qqe = BackwardSupportUtil.b.a(ac.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bv.a.getDensity(null));
            }
            if (qqe.getWidth() != measuredWidth && measuredWidth > 0 && measuredHeight > 0) {
                qqe = Bitmap.createScaledBitmap(qqe, measuredWidth, measuredHeight, true);
            }
        }
        return qqe;
    }

    public final void l(String str, final Bitmap bitmap) {
        x.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[]{Integer.valueOf(this.type), str, this.qqb});
        if (this.qqd != null && str.equals(this.qqd.Wh())) {
            if (4 == this.type || (k.we(this.type) && 6 != this.type)) {
                this.qqc.post(new Runnable(this) {
                    final /* synthetic */ a qqf;

                    public final void run() {
                        this.qqf.qqc.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public static String Hu(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
            return null;
        }
        if (bh.ov(com.tencent.mm.plugin.shake.d.a.i.bsg())) {
            x.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{com.tencent.mm.plugin.shake.d.a.i.bsg(), g.s(str.getBytes())});
    }
}
