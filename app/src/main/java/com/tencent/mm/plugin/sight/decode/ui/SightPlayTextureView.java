package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class SightPlayTextureView extends MMTextureView implements com.tencent.mm.plugin.sight.decode.a.a {
    private Surface mSurface;
    private com.tencent.mm.plugin.sight.decode.a.b quA;
    private int quC;
    private boolean quI;
    private int quN;
    private int videoHeight;
    private int videoWidth;

    private static final class a implements Runnable {
        Surface quP;

        private a() {
            this.quP = null;
        }

        public final void run() {
            if (this.quP != null) {
                this.quP.release();
            }
        }
    }

    private static final class b extends com.tencent.mm.plugin.sight.decode.a.b {
        private WeakReference<SightPlayTextureView> quQ;

        protected final int bsJ() {
            return R.a.bqx;
        }

        public b(SightPlayTextureView sightPlayTextureView) {
            super(1, sightPlayTextureView);
            this.quQ = new WeakReference(sightPlayTextureView);
        }

        public final void cg(int i, int i2) {
            if (this.quQ.get() == null) {
                x.e("MicroMsg.SightPlayTextureView", "onGetVideoSizeEnd, textureView is null, do clear");
                clear();
                return;
            }
            ((SightPlayTextureView) this.quQ.get()).videoWidth = i;
            ((SightPlayTextureView) this.quQ.get()).videoHeight = i2;
            x.d("MicroMsg.SightPlayTextureView", "on get video size %d*%d, needAutoResizeChatting: %s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(((SightPlayTextureView) this.quQ.get()).quI));
            final LayoutParams layoutParams = ((SightPlayTextureView) this.quQ.get()).getLayoutParams();
            if (((SightPlayTextureView) this.quQ.get()).quI && i > 0 && i2 > 0) {
                if (i >= i2) {
                    ((SightPlayTextureView) this.quQ.get()).quC = com.tencent.mm.bv.a.fromDPToPix(((SightPlayTextureView) this.quQ.get()).getContext(), 150);
                } else {
                    ((SightPlayTextureView) this.quQ.get()).quC = com.tencent.mm.bv.a.fromDPToPix(((SightPlayTextureView) this.quQ.get()).getContext(), 85);
                }
            }
            if (layoutParams.height != (((SightPlayTextureView) this.quQ.get()).quC * i2) / i) {
                layoutParams.width = ((SightPlayTextureView) this.quQ.get()).quC;
                layoutParams.height = (((SightPlayTextureView) this.quQ.get()).quC * i2) / i;
                if (((SightPlayTextureView) this.quQ.get()).quI && layoutParams.height < com.tencent.mm.bv.a.fromDPToPix(((SightPlayTextureView) this.quQ.get()).getContext(), 50)) {
                    layoutParams.height = com.tencent.mm.bv.a.fromDPToPix(((SightPlayTextureView) this.quQ.get()).getContext(), 50);
                }
                x.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                if (ag.isMainThread()) {
                    ((SightPlayTextureView) this.quQ.get()).setLayoutParams(layoutParams);
                } else {
                    ag.y(new Runnable(this) {
                        final /* synthetic */ b quR;

                        public final void run() {
                            ((SightPlayTextureView) this.quR.quQ.get()).setLayoutParams(layoutParams);
                        }
                    });
                }
            }
            this.qtq = com.tencent.mm.plugin.sight.decode.a.b.b(((SightPlayTextureView) this.quQ.get()).getContext(), ((SightPlayTextureView) this.quQ.get()).quN, ((SightPlayTextureView) this.quQ.get()).quC, i, i2);
        }

        public final void D(Bitmap bitmap) {
        }
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.quI = false;
        setOpaque(false);
        this.quA = new b(this);
        setSurfaceTextureListener(new 1(this));
    }

    public SightPlayTextureView(Context context, AttributeSet attributeSet) {
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
        x.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.quA.clear();
        com.tencent.mm.sdk.b.a.xef.c(this.quA.bsN());
    }

    protected void onAttachedToWindow() {
        x.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xef.b(this.quA.bsN());
    }

    public final void wj(int i) {
        this.quC = i;
        p(0.75d);
    }

    private void p(double d) {
        final LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != ((int) (((double) this.quC) * d))) {
            layoutParams.width = this.quC;
            layoutParams.height = (int) (((double) this.quC) * d);
            if (this.quI && layoutParams.height < com.tencent.mm.bv.a.fromDPToPix(getContext(), 50)) {
                layoutParams.height = com.tencent.mm.bv.a.fromDPToPix(getContext(), 50);
            }
            x.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
            if (ag.isMainThread()) {
                setLayoutParams(layoutParams);
            } else {
                ag.y(new Runnable(this) {
                    final /* synthetic */ SightPlayTextureView quO;

                    public final void run() {
                        this.quO.setLayoutParams(layoutParams);
                    }
                });
            }
        }
    }

    public final void B(Bitmap bitmap) {
        String str = "MicroMsg.SightPlayTextureView";
        String str2 = "thumb is null? %B, surface is null? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bitmap == null);
        objArr[1] = Boolean.valueOf(this.mSurface == null);
        x.d(str, str2, objArr);
        if (bitmap != null) {
            x.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            if (this.quI) {
                if (bitmap.getWidth() >= bitmap.getHeight()) {
                    this.quC = com.tencent.mm.bv.a.fromDPToPix(getContext(), 150);
                } else {
                    this.quC = com.tencent.mm.bv.a.fromDPToPix(getContext(), 85);
                }
            }
            Bitmap b = com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), this.quN, this.quC, bitmap.getWidth(), bitmap.getHeight());
            p(((double) bitmap.getHeight()) / ((double) bitmap.getWidth()));
            this.quA.qtq = b;
            this.quA.C(bitmap);
            return;
        }
        this.quA.C(null);
    }

    public final void bsD() {
        SightVideoJNI.drawSurfaceThumb(this.mSurface, com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), R.g.bEi, this.quC, 320, 240), com.tencent.mm.plugin.sight.decode.a.b.b(getContext(), this.quN, this.quC, 320, 240));
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
        LayoutParams layoutParams = getLayoutParams();
        this.quC = i;
        layoutParams.width = this.quC;
        layoutParams.height = (this.quC * i2) / i;
        x.i("MicroMsg.SightPlayTextureView", "params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        if (ag.isMainThread()) {
            setLayoutParams(layoutParams);
        } else {
            ag.y(new 3(this, layoutParams));
        }
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
    }

    public final void a(f fVar) {
        this.quA.qtS = fVar;
    }
}
