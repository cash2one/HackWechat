package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.ah.a.d;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;

public class SightPlayImageView extends QPictureView implements a {
    public b quA;
    private int quC;
    private int quD;
    private int quE;
    private int quF;
    public f.a quG;
    public boolean quH;
    private boolean quI;
    public boolean quJ;

    public final void btb() {
        this.quJ = true;
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.quH = true;
        this.quI = false;
        this.quJ = false;
        this.quA = new a(this);
        x.i("MicroMsg.SightPlayImageView", "mController %s", new ai().toString());
    }

    public SightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SightPlayImageView(Context context) {
        this(context, null, 0);
    }

    public final String Ur() {
        return this.quA.qtl;
    }

    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (!this.quJ) {
            int height = bitmap == null ? this.quD == 0 ? 240 : this.quD : bitmap.getHeight();
            int width = bitmap == null ? this.quC == 0 ? 320 : this.quC : bitmap.getWidth();
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.height != ((int) (((float) (this.quC * height)) / ((float) width)))) {
                layoutParams.width = this.quC;
                layoutParams.height = (int) ((((float) height) * ((float) this.quC)) / ((float) width));
                setLayoutParams(layoutParams);
            }
        }
    }

    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (!this.quJ) {
            int intrinsicHeight = drawable == null ? this.quD == 0 ? 240 : this.quD : drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable == null ? this.quC == 0 ? 320 : this.quC : drawable.getIntrinsicWidth();
            if (intrinsicHeight != 0 && intrinsicWidth != 0) {
                LayoutParams layoutParams = getLayoutParams();
                if (layoutParams.height != ((int) ((((float) this.quC) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)))) {
                    layoutParams.width = this.quC;
                    layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.quC)) / ((float) intrinsicWidth));
                    setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void E(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
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
        x.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.quA.clear();
        com.tencent.mm.sdk.b.a.xef.c(this.quA.bsN());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xef.b(this.quA.bsN());
    }

    public void wj(int i) {
        this.quH = false;
        this.quC = i;
        if (this.quE > 0 && this.quF > 0) {
            LayoutParams layoutParams = getLayoutParams();
            this.quD = (this.quC * this.quF) / this.quE;
            if (layoutParams.width != this.quC || layoutParams.height != this.quD) {
                layoutParams.width = this.quC;
                layoutParams.height = this.quD;
                setLayoutParams(layoutParams);
            }
        }
    }

    public final void B(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    public final void bsD() {
        setImageBitmap(null);
        setImageResource(d.bEi);
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

    public void dt(int i, int i2) {
        this.quH = false;
        LayoutParams layoutParams = getLayoutParams();
        this.quC = i;
        this.quD = (this.quC * i2) / i;
        layoutParams.width = this.quC;
        layoutParams.height = this.quD;
        setLayoutParams(layoutParams);
        postInvalidate();
    }

    public final void hY(boolean z) {
        this.quA.qtG = z;
    }

    public final void a(e eVar) {
        this.quA.qtR = eVar;
    }

    public final void bsI() {
        this.quA.qtT = null;
    }

    public final void a(b.f fVar) {
        this.quA.qtS = fVar;
    }

    public final void h(TextView textView) {
        this.quA.h(textView);
    }

    public final void ia(boolean z) {
        b bVar = this.quA;
        x.i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (bVar.qtA != null) {
                bVar.qtA.type = 0;
                o.c(bVar.qtA, 0);
            }
            bVar.qtA = null;
        } else if (bVar.qtA == null) {
            bVar.qtA = new i(bVar, (byte) 0);
        }
    }

    public final void bsH() {
    }

    public int getDuration() {
        if (this.quA == null) {
            return 0;
        }
        return (int) this.quA.bsO();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
