package com.tencent.mm.plugin.setting.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.contact.d;
import com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView extends View {
    private static SoftReference<Bitmap> qmK = null;
    private static int qmT = 8;
    private int hXU = 0;
    private float kCe = 0.0f;
    private float nlE = 0.0f;
    private int oNc = 0;
    private List<b> qmL = new ArrayList(8);
    private int qmM = 0;
    private int qmN = 0;
    private int qmO = 0;
    private int qmP = 0;
    private int qmQ = 0;
    public int qmR = 0;
    public a qmS = null;
    private boolean qmU = false;
    private boolean qmV = false;
    private int topOffset = 0;

    public interface a {
        void vS(int i);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        brl();
        this.qmL.clear();
        setClickable(true);
        this.qmM = com.tencent.mm.bv.a.fromDPToPix(getContext(), 30);
        this.topOffset = com.tencent.mm.bv.a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.oNc = (getHeight() / 2) + this.topOffset;
        qmT = 8;
        this.hXU = (width - (this.qmM * 2)) / (qmT - 1);
        Bitmap bitmap = (Bitmap) qmK.get();
        for (int i5 = 0; i5 < qmT; i5++) {
            b bVar = new b((byte) 0);
            bVar.left = (this.qmM + (this.hXU * i5)) - (bitmap.getWidth() / 2);
            bVar.top = this.oNc - (bitmap.getHeight() / 2);
            bVar.right = (this.qmM + (this.hXU * i5)) + (bitmap.getWidth() / 2);
            bVar.bottom = this.oNc + (bitmap.getHeight() / 2);
            this.qmL.add(bVar);
        }
        this.qmN = this.qmR;
        if (this.qmQ >= 0) {
            this.qmO = ((b) this.qmL.get(this.qmN)).left;
        } else if (this.qmO <= ((b) this.qmL.get(this.qmN)).right - (this.hXU / 2)) {
            this.qmO = ((b) this.qmL.get(this.qmN)).left;
        } else {
            this.qmO = ((b) this.qmL.get(this.qmN)).right;
        }
        this.qmP = ((b) this.qmL.get(this.qmN)).top;
        invalidate();
    }

    public static void brk() {
        qmT = 8;
    }

    private void brl() {
        if (qmK == null || qmK.get() == null) {
            qmK = new SoftReference(BitmapFactory.decodeResource(getResources(), R.g.bCh));
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        brl();
        Paint paint = new Paint();
        paint.setARGB(255, d.CTRL_INDEX, d.CTRL_INDEX, d.CTRL_INDEX);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.qmM, (float) this.oNc, (float) (width - this.qmM), (float) this.oNc, paint);
        for (i = 0; i < qmT; i++) {
            canvas.drawLine((float) (this.qmM + (this.hXU * i)), (float) (this.oNc - fromDPToPix), (float) (this.qmM + (this.hXU * i)), (float) (this.oNc + fromDPToPix), paint);
        }
        Bitmap bitmap = (Bitmap) qmK.get();
        canvas.drawBitmap(bitmap, (float) this.qmO, (float) this.qmP, null);
        String str = "A";
        String string = getResources().getString(R.l.eKp);
        getResources().getString(R.l.eKo);
        getResources().getString(R.l.eKr);
        String str2 = "A";
        float aq = aq(SetTextSizeUI.ao(0.875f));
        paint = new Paint();
        paint.setTextSize(aq);
        i = (int) paint.measureText(str);
        int ar = ar(aq);
        paint.setColor(getResources().getColor(R.e.black));
        paint.setAntiAlias(true);
        canvas.drawText(str, (float) (this.qmM - (i / 2)), (float) ((this.oNc - ar) - (bitmap.getHeight() / 3)), paint);
        float aq2 = aq(SetTextSizeUI.ao(1.0f));
        paint.setTextSize(aq2);
        canvas.drawText(string, (float) ((this.qmM + (this.hXU * 1)) - (((int) paint.measureText(string)) / 2)), (float) ((this.oNc - ar(aq2)) - (bitmap.getHeight() / 3)), paint);
        aq2 = aq(SetTextSizeUI.ao(2.025f));
        paint.setTextSize(aq2);
        canvas.drawText(str2, (float) ((this.qmM + (this.hXU * (qmT - 1))) - (((int) paint.measureText(str2)) / 2)), (float) ((this.oNc - ar(aq2)) - (bitmap.getHeight() / 3)), paint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        b bVar;
        b bVar2;
        float y;
        int i;
        switch (motionEvent.getAction()) {
            case 0:
                this.nlE = motionEvent.getX();
                this.kCe = motionEvent.getY();
                bVar = (b) this.qmL.get(this.qmN);
                if (this.nlE >= ((float) bVar.left) && this.nlE <= ((float) bVar.right) && this.kCe >= ((float) bVar.top) && this.kCe <= ((float) bVar.bottom)) {
                    z = true;
                }
                if (!z) {
                    this.qmV = true;
                    break;
                }
                this.qmU = true;
                return true;
            case 1:
                if (this.qmU) {
                    int i2 = 0;
                    while (i2 < qmT - 1) {
                        bVar = (b) this.qmL.get(i2);
                        bVar2 = (b) this.qmL.get(i2 + 1);
                        if (this.qmO <= bVar.left + (this.hXU / 2) && this.qmO >= bVar.left) {
                            this.qmN = i2;
                            this.qmO = bVar.left;
                            this.qmR = this.qmN;
                            if (this.qmS != null) {
                                this.qmS.vS(this.qmN);
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
                            if (this.qmS != null) {
                                this.qmS.vS(this.qmN);
                            }
                            invalidate();
                            this.qmU = false;
                            return true;
                        }
                    }
                    this.qmR = this.qmN;
                    if (this.qmS != null) {
                        this.qmS.vS(this.qmN);
                    }
                    invalidate();
                    this.qmU = false;
                    return true;
                } else if (this.qmV) {
                    float x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (Math.abs(x - this.nlE) <= 10.0f && Math.abs(y - this.kCe) <= 10.0f) {
                        i = 0;
                        while (i < qmT) {
                            bVar = (b) this.qmL.get(i);
                            if (x < ((float) (bVar.left - 5)) || x > ((float) (bVar.right + 5))) {
                                i++;
                            } else {
                                this.qmN = i;
                                this.qmR = this.qmN;
                                this.qmO = bVar.left;
                                if (this.qmS != null) {
                                    this.qmS.vS(this.qmN);
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
                this.qmQ = (int) (y - this.nlE);
                this.qmO += this.qmQ;
                this.nlE = y;
                this.kCe = y2;
                bVar = (b) this.qmL.get(0);
                bVar2 = (b) this.qmL.get(qmT - 1);
                if (this.qmO <= bVar.left) {
                    this.qmO = bVar.left;
                } else if (this.qmO >= bVar2.left) {
                    this.qmO = bVar2.left;
                } else {
                    i = 0;
                    while (i < qmT) {
                        bVar = (b) this.qmL.get(i);
                        if (this.qmO < bVar.left - 5 || this.qmO > bVar.right + 5) {
                            i++;
                        } else {
                            this.qmN = i;
                            this.qmR = this.qmN;
                            if (this.qmS != null) {
                                this.qmS.vS(this.qmN);
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

    private float aq(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private static int ar(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        paint.setAntiAlias(true);
        return (int) Math.ceil((double) paint.getFontMetrics().bottom);
    }
}
