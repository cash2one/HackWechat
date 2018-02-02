package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.i;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class AdlandingSightPlayImageView extends QPictureView {
    private int quC;
    private int quD;
    private int quE;
    private int quF;
    public a quG;
    public boolean quH;
    private boolean quI;
    private boolean quJ;
    a rmq;

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.quH = true;
        this.quI = false;
        this.quJ = false;
        this.rmq = new a(this);
        x.i("MicroMsg.SightPlayImageView", "mController %s", new Object[]{new ai().toString()});
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String Ur() {
        return this.rmq.qtl;
    }

    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (!this.quJ) {
            int height = bitmap == null ? this.quD == 0 ? 240 : this.quD : bitmap.getHeight();
            int width = bitmap == null ? this.quC == 0 ? 320 : this.quC : bitmap.getWidth();
            LayoutParams layoutParams = getLayoutParams();
            if (((float) layoutParams.height) != ((float) (this.quC * height)) / ((float) width)) {
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
                if (((float) layoutParams.height) != (((float) this.quC) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)) {
                    layoutParams.width = this.quC;
                    layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.quC)) / ((float) intrinsicWidth));
                    setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void aA(String str, boolean z) {
        a aVar = this.rmq;
        x.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[]{Integer.valueOf(aVar.hashCode()), str, aVar.qtl, Boolean.valueOf(z), Integer.valueOf(aVar.qtn), Boolean.valueOf(aVar.qtP), Boolean.valueOf(aVar.qtG)});
        if (aVar.qtP) {
            aVar.hZ(false);
        } else if (aVar.bsL()) {
            x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            aVar.clear();
        } else if (!aVar.qtG) {
            aVar.clear();
        } else if (z) {
            aVar.qtm = str;
            aVar.hZ(false);
        } else if (aVar.qtl.equals(str)) {
            aVar.qtm = "ERROR#PATH";
            aVar.hZ(false);
            aVar.restart();
        } else {
            aVar.clear();
            if (str == null) {
                str = "";
            }
            aVar.qtl = str;
            if (bh.ov(aVar.qtl)) {
                x.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                aVar.bxx();
            } else if (a.Jt(aVar.qtl)) {
                aVar.rlZ = new a$h(aVar);
                o.c(aVar.rlZ, 0);
            } else {
                x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                aVar.clear();
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[]{Integer.valueOf(hashCode())});
        this.rmq.clear();
        com.tencent.mm.sdk.b.a.xef.c(this.rmq.bsN());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[]{Integer.valueOf(hashCode())});
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xef.b(this.rmq.bsN());
    }

    public final void wj(int i) {
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

    public final void a(a$f com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_component_widget_a_f) {
        this.rmq.rmi = com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_component_widget_a_f;
    }

    public final void ia(boolean z) {
        a aVar = this.rmq;
        x.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            if (aVar.rmb != null) {
                aVar.rmb.type = 0;
                o.c(aVar.rmb, 0);
            }
            aVar.rmb = null;
        } else if (aVar.rmb == null) {
            aVar.rmb = new i(aVar, (byte) 0);
        }
    }

    public int getDuration() {
        if (this.rmq == null) {
            return 0;
        }
        a aVar = this.rmq;
        return (int) (aVar.qtn == -1 ? 0.0d : SightVideoJNI.getVideoDuration(aVar.qtn));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
