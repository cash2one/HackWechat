package com.tencent.mm.aq.a;

import android.view.View;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public final class c {
    public WeakReference<ImageView> hDa;
    public int height = 0;
    private String url = "";
    public int width = 0;

    public c(ImageView imageView, String str) {
        this.hDa = new WeakReference(imageView);
        this.url = str;
    }

    public final ImageView Jr() {
        if (this.hDa != null) {
            ImageView imageView = (ImageView) this.hDa.get();
            if (imageView != null) {
                return imageView;
            }
        }
        return null;
    }

    public final int PI() {
        Object obj = null;
        if (this.hDa != null) {
            obj = (View) this.hDa.get();
        }
        return obj == null ? super.hashCode() : obj.hashCode();
    }
}
