package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class i {
    private final ImageView PE;
    private final h Pc;

    public i(ImageView imageView, h hVar) {
        this.PE = imageView;
        this.Pc = hVar;
    }

    public final void b(AttributeSet attributeSet, int i) {
        ap a = ap.a(this.PE.getContext(), attributeSet, k.AppCompatImageView, i);
        try {
            Drawable bN = a.bN(k.AppCompatImageView_android_src);
            if (bN != null) {
                this.PE.setImageDrawable(bN);
            }
            int resourceId = a.getResourceId(k.AppCompatImageView_srcCompat, -1);
            if (resourceId != -1) {
                bN = this.Pc.a(this.PE.getContext(), resourceId, false);
                if (bN != null) {
                    this.PE.setImageDrawable(bN);
                }
            }
            bN = this.PE.getDrawable();
            if (bN != null) {
                w.o(bN);
            }
            a.Zu.recycle();
        } catch (Throwable th) {
            a.Zu.recycle();
        }
    }

    public final void setImageResource(int i) {
        if (i != 0) {
            Drawable a = this.Pc != null ? this.Pc.a(this.PE.getContext(), i, false) : a.b(this.PE.getContext(), i);
            if (a != null) {
                w.o(a);
            }
            this.PE.setImageDrawable(a);
            return;
        }
        this.PE.setImageDrawable(null);
    }
}
