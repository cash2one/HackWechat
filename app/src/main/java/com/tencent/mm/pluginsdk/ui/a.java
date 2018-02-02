package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class a extends j implements com.tencent.mm.ad.d.a {

    public interface a {
        void doInvalidate();

        Drawable getDrawable();

        void setImageDrawable(Drawable drawable);
    }

    public static class b {
        public static com.tencent.mm.pluginsdk.ui.j.a plt;

        public static com.tencent.mm.pluginsdk.ui.j.a bZV() {
            Assert.assertTrue(plt != null);
            return plt;
        }

        public static void a(ImageView imageView, String str) {
            if (imageView == null) {
                x.e("MicroMsg.AvatarDrawable", "imageView is null");
                return;
            }
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str);
            } else {
                drawable = (a) drawable;
            }
            drawable.qw(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void o(ImageView imageView, String str) {
            a(imageView, str, 0.5f, false);
        }

        public static void p(ImageView imageView, String str) {
            a(imageView, str, 0.5f, true);
        }

        public static void a(ImageView imageView, String str, float f, boolean z) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                drawable = new b(str, f);
                drawable.kT(z);
            } else {
                drawable = (b) drawable;
            }
            drawable.qw(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void b(ImageView imageView, String str, boolean z) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str);
            } else {
                drawable = (a) drawable;
            }
            drawable.qw(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void a(a aVar, String str) {
            Drawable drawable = aVar.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str);
            } else {
                drawable = (a) drawable;
            }
            drawable.qw(str);
            aVar.setImageDrawable(drawable);
            aVar.doInvalidate();
        }

        public static void g(ImageView imageView, String str, int i) {
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable == null || !(drawable instanceof c)) {
                    drawable = new c(str);
                } else {
                    drawable = (c) drawable;
                }
                if (drawable.vjn != i || drawable.vjm == null || drawable.vjm.kHs == null || drawable.vjm.kHs.isRecycled()) {
                    drawable.vjn = i;
                    Bitmap CZ = d.CZ(i);
                    if (drawable.vjm != null) {
                        drawable.vjm.kHs = CZ;
                    }
                }
                drawable.qw(str);
                imageView.setImageDrawable(drawable);
                imageView.invalidate();
            }
        }
    }

    private a(String str) {
        super(b.plt, str);
    }

    private a(String str, byte b) {
        super(b.plt, str, false);
    }

    public final void jh(String str) {
        super.jh(str);
    }
}
