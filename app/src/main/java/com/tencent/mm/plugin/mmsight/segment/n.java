package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.mmsight.segment.k.b;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class n extends View {
    a oyS;
    private boolean oyT;
    boolean oyU;
    private int oyV;
    private int oyW;
    Drawable oyX;
    Drawable oyY;
    private int oyZ;
    private float oza;
    private int ozb;
    float ozc;
    private int ozd;
    private Paint oze;
    private Paint ozf;
    private int ozg;
    private float ozh;
    private Paint ozi;
    private Paint ozj;
    private int ozk;
    private float ozl;
    private float ozm;
    private float ozn;
    private int ozo;
    Rect ozp;
    Rect ozq;
    private OnTouchListener ozr;
    private int padding;

    static /* synthetic */ void a(n nVar, boolean z, float f) {
        if (nVar.oyT && nVar.oyX != null && nVar.oyY != null && nVar.oyX.getBounds().width() > 0 && nVar.oyY.getBounds().width() > 0) {
            float f2;
            float max;
            if (z) {
                f2 = nVar.oza + ((float) (nVar.oyY.getBounds().right - nVar.oyW));
                max = Math.max(((float) nVar.padding) + nVar.oza, ((float) (nVar.oyY.getBounds().right - nVar.oyV)) + nVar.oza);
            } else {
                max = ((float) (nVar.oyX.getBounds().left + nVar.oyW)) - nVar.oza;
                f2 = Math.min(((float) (nVar.getWidth() - nVar.padding)) - nVar.oza, ((float) (nVar.oyX.getBounds().left + nVar.oyV)) - nVar.oza);
            }
            max = Math.max(max, Math.min(f, f2));
            Rect bounds;
            if (z) {
                bounds = nVar.oyX.getBounds();
                bounds.offsetTo((int) Math.ceil((double) (max - nVar.oza)), 0);
                nVar.oyX.setBounds(bounds);
            } else {
                bounds = nVar.oyY.getBounds();
                bounds.offsetTo((int) Math.floor((double) (max - nVar.oza)), 0);
                nVar.oyY.setBounds(bounds);
            }
            nVar.postInvalidate();
        }
    }

    static /* synthetic */ void a(n nVar, boolean z, boolean z2) {
        if (nVar.oyT && nVar.oyX != null && nVar.oyY != null && nVar.oyX.getBounds().width() > 0 && nVar.oyY.getBounds().width() > 0) {
            b bVar = z ? (b) nVar.oyX : (b) nVar.oyY;
            if (bVar.ozA != z2) {
                bVar.ozA = z2;
                bVar.ozv.invalidate();
            }
            nVar.postInvalidate();
        }
    }

    static /* synthetic */ boolean a(n nVar, Drawable drawable, float f, float f2) {
        if (!nVar.oyT || drawable == null) {
            return false;
        }
        Rect bounds = drawable.getBounds();
        return f2 <= ((float) (bounds.bottom + nVar.ozo)) && f2 >= ((float) (bounds.top - nVar.ozo)) && f >= ((float) (bounds.left - nVar.ozo)) && f <= ((float) (bounds.right + nVar.ozo));
    }

    public n(Context context) {
        super(context);
        this.oyT = false;
        this.oyU = false;
        this.ozc = -1.0f;
        this.ozm = -1.0f;
        this.ozn = -1.0f;
        this.padding = 0;
        this.ozr = new 2(this);
        this.oyZ = a.fromDPToPix(getContext(), 8);
        this.oza = ((float) this.oyZ) * 0.5f;
        this.ozo = a.fromDPToPix(getContext(), 8);
        this.oyX = new b(this, a.b(getContext(), k$e.oyt), a.b(getContext(), k$e.oys));
        this.oyY = new b(this, a.b(getContext(), k$e.oyt), a.b(getContext(), k$e.oys));
        this.ozb = a.fromDPToPix(getContext(), 1);
        this.ozd = a.aa(getContext(), b.oyo);
        this.ozc = -1.0f;
        this.oze = new Paint();
        this.oze.setColor(a.c(getContext(), k.a.white));
        this.oze.setAlpha(102);
        this.ozi = new Paint();
        this.ozi.setColor(a.c(getContext(), k.a.black));
        this.ozi.setAlpha(102);
        this.ozf = new Paint();
        this.ozf.setColor(a.c(getContext(), k.a.white));
        this.ozf.setStyle(Style.STROKE);
        this.ozg = dd(getContext());
        this.ozf.setStrokeWidth((float) this.ozg);
        this.ozh = ((float) this.ozg) * 0.5f;
        this.ozj = new Paint();
        this.ozj.setColor(a.c(getContext(), k.a.white));
        this.ozj.setStyle(Style.STROKE);
        this.ozk = dd(getContext());
        this.ozl = ((float) this.ozk) * 0.5f;
        this.ozj.setStrokeWidth((float) this.ozk);
        this.ozj.setAlpha(178);
        setOnTouchListener(this.ozr);
    }

    private static int dd(Context context) {
        return Math.round(TypedValue.applyDimension(1, DownloadHelper.SAVE_FATOR, context.getResources().getDisplayMetrics()));
    }

    protected final void onDraw(Canvas canvas) {
        if (this.ozc > 0.0f) {
            float width = ((float) getWidth()) * this.ozc;
            canvas.drawRect(width - (((float) this.ozb) * 0.5f), 0.0f, (((float) this.ozb) * 0.5f) + width, (float) this.ozd, this.oze);
        }
        if (this.oyT) {
            int centerX = this.oyX.getBounds().centerX();
            int centerX2 = this.oyY.getBounds().centerX();
            if (gH(true) || gH(false)) {
                canvas.drawRect(((float) this.padding) + this.ozl, this.ozl, ((float) (getWidth() - this.padding)) - this.ozl, ((float) getBottom()) - this.ozl, this.ozj);
            }
            if (this.oyX.getBounds().left > 0) {
                canvas.drawRect(0.0f, 0.0f, (float) centerX, (float) getHeight(), this.ozi);
            }
            if (this.oyY.getBounds().right < getWidth()) {
                canvas.drawRect((float) centerX2, 0.0f, (float) getWidth(), (float) getHeight(), this.ozi);
            }
            canvas.drawLine((float) centerX, this.ozh, (float) centerX2, this.ozh, this.ozf);
            canvas.drawLine((float) centerX, ((float) getHeight()) - this.ozh, (float) centerX2, ((float) getHeight()) - this.ozh, this.ozf);
            this.oyX.draw(canvas);
            this.oyY.draw(canvas);
        }
    }

    public final void am(float f) {
        if (this.oyT) {
            this.ozc = f;
            invalidate();
        }
    }

    private boolean gH(boolean z) {
        if (z) {
            return b.a((b) this.oyX);
        }
        return b.a((b) this.oyY);
    }

    public final int bbo() {
        return this.oyX.getBounds().left;
    }

    public final int bbp() {
        return this.oyY.getBounds().right;
    }
}
