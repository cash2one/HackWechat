package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.x;

public class SightPlayAutoSizeImageView extends ImageView implements a {
    private b quA;

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.quA = new a(this);
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String Ur() {
        return this.quA.qtl;
    }

    public final void clear() {
        this.quA.clear();
    }

    public final void aA(String str, boolean z) {
        this.quA.aA(str, z);
    }

    public final boolean bsG() {
        return this.quA.bsL();
    }

    public final void cR(int i) {
        this.quA.position = i;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.quA.clear();
        com.tencent.mm.sdk.b.a.xef.c(this.quA.bsN());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xef.b(this.quA.bsN());
    }

    public final void wj(int i) {
    }

    public final void B(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public final void bsD() {
        setImageBitmap(null);
        setImageResource(R.g.bEi);
    }

    public final void bH(Object obj) {
        setTag(obj);
    }

    public final Object bsE() {
        return getTag();
    }

    public final Context bsF() {
        return getContext();
    }

    public final void dt(int i, int i2) {
    }

    public final void hY(boolean z) {
        this.quA.qtG = z;
    }

    public final void a(e eVar) {
        this.quA.qtR = eVar;
    }

    public final void bsI() {
    }

    public final void h(TextView textView) {
        this.quA.h(textView);
    }

    public final void bsH() {
        this.quA.qtP = false;
    }

    public final void a(f fVar) {
        this.quA.qtS = fVar;
    }
}
