package com.google.android.exoplayer2.f;

import android.graphics.Bitmap;
import android.text.Layout.Alignment;
import com.tencent.smtt.sdk.WebView;

public class a {
    public final Alignment avT;
    public final float avU;
    public final int avV;
    public final int avW;
    public final float avX;
    public final int avY;
    public final float avZ;
    public final boolean awa;
    public final Bitmap bitmap;
    public final float size;
    public final CharSequence text;
    public final int windowColor;

    public a(Bitmap bitmap, float f, float f2, float f3, float f4) {
        this(null, null, bitmap, f2, 0, 0, f, 0, f3, f4, false, WebView.NIGHT_MODE_COLOR);
    }

    public a(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public a(CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f, i, i2, f2, i3, f3, false, WebView.NIGHT_MODE_COLOR);
    }

    public a(CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, f3, Float.MIN_VALUE, z, i4);
    }

    private a(CharSequence charSequence, Alignment alignment, Bitmap bitmap, float f, int i, int i2, float f2, int i3, float f3, float f4, boolean z, int i4) {
        this.text = charSequence;
        this.avT = alignment;
        this.bitmap = bitmap;
        this.avU = f;
        this.avV = i;
        this.avW = i2;
        this.avX = f2;
        this.avY = i3;
        this.size = f3;
        this.avZ = f4;
        this.awa = z;
        this.windowColor = i4;
    }
}
