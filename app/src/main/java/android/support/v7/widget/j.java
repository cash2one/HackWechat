package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v4.b.a.c;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class j {
    private static final int[] KP = new int[]{16843067, 16843068};
    private final ProgressBar PK;
    Bitmap PL;
    final h Pc;

    j(ProgressBar progressBar, h hVar) {
        this.PK = progressBar;
        this.Pc = hVar;
    }

    void b(AttributeSet attributeSet, int i) {
        ap a = ap.a(this.PK.getContext(), attributeSet, KP, i);
        Drawable bN = a.bN(0);
        if (bN != null) {
            ProgressBar progressBar = this.PK;
            if (bN instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) bN;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                Drawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable b = b(animationDrawable.getFrame(i2), true);
                    b.setLevel(10000);
                    animationDrawable2.addFrame(b, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(10000);
                bN = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(bN);
        }
        bN = a.bN(1);
        if (bN != null) {
            this.PK.setProgressDrawable(b(bN, false));
        }
        a.Zu.recycle();
    }

    private Drawable b(Drawable drawable, boolean z) {
        int i = 0;
        Drawable bn;
        if (drawable instanceof c) {
            bn = ((c) drawable).bn();
            if (bn == null) {
                return drawable;
            }
            ((c) drawable).k(b(bn, z));
            return drawable;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                boolean z2;
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i2] = b(drawable2, z2);
            }
            bn = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                bn.setId(i, layerDrawable.getId(i));
                i++;
            }
            return bn;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.PL == null) {
                this.PL = bitmap;
            }
            bn = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            bn.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            bn.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(bn, 3, 1) : bn;
        }
    }
}
