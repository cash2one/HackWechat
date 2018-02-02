package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.jsapi.contact.d;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView extends View {
    private static SoftReference<Bitmap> qmK = null;
    private int hXU = 0;
    private float kCe = 0.0f;
    private float nlE = 0.0f;
    private int oNc = 0;
    private List<b> qmL = new ArrayList(4);
    private int qmM = 0;
    private int qmN = 0;
    private int qmO = 0;
    private int qmP = 0;
    public int qmR = 0;
    private boolean qmU = false;
    private boolean qmV = false;
    public a tJY = null;
    private int topOffset = 0;

    public FontChooserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        brl();
        this.qmL.clear();
        setClickable(true);
        this.qmM = a.fromDPToPix(getContext(), 50);
        this.topOffset = a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.oNc = (getHeight() / 2) + this.topOffset;
        this.hXU = (width - (this.qmM * 2)) / 3;
        Bitmap bitmap = (Bitmap) qmK.get();
        for (int i5 = 0; i5 < 4; i5++) {
            b bVar = new b((byte) 0);
            bVar.left = (this.qmM + (this.hXU * i5)) - (bitmap.getWidth() / 2);
            bVar.top = this.oNc - (bitmap.getHeight() / 2);
            bVar.right = (this.qmM + (this.hXU * i5)) + (bitmap.getWidth() / 2);
            bVar.bottom = this.oNc + (bitmap.getHeight() / 2);
            this.qmL.add(bVar);
        }
        this.qmN = this.qmR;
        this.qmO = ((b) this.qmL.get(this.qmN)).left;
        this.qmP = ((b) this.qmL.get(this.qmN)).top;
        invalidate();
    }

    private void brl() {
        if (qmK == null || qmK.get() == null) {
            qmK = new SoftReference(BitmapFactory.decodeResource(getResources(), R.g.bCh));
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        brl();
        Paint paint = new Paint();
        paint.setARGB(255, d.CTRL_INDEX, d.CTRL_INDEX, d.CTRL_INDEX);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.qmM, (float) this.oNc, (float) (width - this.qmM), (float) this.oNc, paint);
        for (int i = 0; i < 4; i++) {
            canvas.drawLine((float) (this.qmM + (this.hXU * i)), (float) (this.oNc - fromDPToPix), (float) (this.qmM + (this.hXU * i)), (float) (this.oNc + fromDPToPix), paint);
        }
        Bitmap bitmap = (Bitmap) qmK.get();
        canvas.drawBitmap(bitmap, (float) this.qmO, (float) this.qmP, null);
        String string = getResources().getString(R.l.eWI);
        String string2 = getResources().getString(R.l.eWJ);
        String string3 = getResources().getString(R.l.eWG);
        String string4 = getResources().getString(R.l.eWH);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bxm);
        Paint paint2 = new Paint();
        paint2.setTextSize((float) dimensionPixelSize);
        fromDPToPix = (int) paint2.measureText(string);
        dimensionPixelSize = Bf(dimensionPixelSize);
        paint2.setColor(getResources().getColor(R.e.bue));
        paint2.setAntiAlias(true);
        canvas.drawText(string, (float) (this.qmM - (fromDPToPix / 2)), (float) ((this.oNc - dimensionPixelSize) - (bitmap.getHeight() / 3)), paint2);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.bxn);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string2, (float) ((this.qmM + (this.hXU * 1)) - (((int) paint2.measureText(string2)) / 2)), (float) ((this.oNc - Bf(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.bxk);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string3, (float) ((this.qmM + (this.hXU * 2)) - (((int) paint2.measureText(string3)) / 2)), (float) ((this.oNc - Bf(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.bxl);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string4, (float) ((this.qmM + (this.hXU * 3)) - (((int) paint2.measureText(string4)) / 2)), (float) ((this.oNc - Bf(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        b bVar;
        b bVar2;
        float y;
        switch (motionEvent.getAction()) {
            case 0:
                this.nlE = motionEvent.getX();
                this.kCe = motionEvent.getY();
                bVar = (b) this.qmL.get(this.qmN);
                if (this.nlE >= ((float) bVar.left) && this.nlE <= ((float) bVar.right) && this.kCe >= ((float) bVar.top) && this.kCe <= ((float) bVar.bottom)) {
                    i = 1;
                }
                if (i == 0) {
                    this.qmV = true;
                    break;
                }
                this.qmU = true;
                return true;
            case 1:
                if (this.qmU) {
                    int i2 = 0;
                    while (i2 < 3) {
                        bVar = (b) this.qmL.get(i2);
                        bVar2 = (b) this.qmL.get(i2 + 1);
                        if (this.qmO <= bVar.left + (this.hXU / 2) && this.qmO >= bVar.left) {
                            this.qmN = i2;
                            this.qmO = bVar.left;
                            this.qmR = this.qmN;
                            if (this.tJY != null) {
                                this.tJY.vS(this.qmN);
                            }
                            invalidate();
                            this.qmU = false;
                            return true;
                        } else if (this.qmO < bVar2.left - (this.hXU / 2) || this.qmO > bVar2.left) {
                            i2++;
                        } else {
                            this.qmN = i2 + 1;
                            this.qmO = bVar2.left;
                            this.qmR = this.qmN;
                            if (this.tJY != null) {
                                this.tJY.vS(this.qmN);
                            }
                            invalidate();
                            this.qmU = false;
                            return true;
                        }
                    }
                    this.qmR = this.qmN;
                    if (this.tJY != null) {
                        this.tJY.vS(this.qmN);
                    }
                    invalidate();
                    this.qmU = false;
                    return true;
                } else if (this.qmV) {
                    float x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (Math.abs(x - this.nlE) <= 10.0f && Math.abs(y - this.kCe) <= 10.0f) {
                        int i3 = 0;
                        while (i3 < 4) {
                            bVar = (b) this.qmL.get(i3);
                            if (x < ((float) (bVar.left - 5)) || x > ((float) (bVar.right + 5))) {
                                i3++;
                            } else {
                                this.qmN = i3;
                                this.qmR = this.qmN;
                                this.qmO = bVar.left;
                                if (this.tJY != null) {
                                    this.tJY.vS(this.qmN);
                                }
                            }
                        }
                    }
                    this.qmV = false;
                    invalidate();
                    return true;
                }
                break;
            case 2:
                if (!this.qmU) {
                    return super.onTouchEvent(motionEvent);
                }
                y = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.qmO += (int) (y - this.nlE);
                this.nlE = y;
                this.kCe = y2;
                bVar = (b) this.qmL.get(0);
                bVar2 = (b) this.qmL.get(3);
                if (this.qmO <= bVar.left) {
                    this.qmO = bVar.left;
                } else if (this.qmO >= bVar2.left) {
                    this.qmO = bVar2.left;
                } else {
                    while (i < 4) {
                        bVar = (b) this.qmL.get(i);
                        if (this.qmO < bVar.left - 5 || this.qmO > bVar.right + 5) {
                            i++;
                        } else {
                            this.qmN = i;
                            this.qmR = this.qmN;
                            if (this.tJY != null) {
                                this.tJY.vS(this.qmN);
                            }
                        }
                    }
                }
                invalidate();
                return true;
            default:
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private static int Bf(int i) {
        Paint paint = new Paint();
        paint.setTextSize((float) i);
        paint.setAntiAlias(true);
        return (int) Math.ceil((double) paint.getFontMetrics().bottom);
    }
}
