package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.m.a$d;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.f.a;

public class SmileyPanelScrollView extends View {
    private static boolean DEBUG = false;
    private int STATE_NONE = 0;
    private int Wu;
    private int Wv;
    private Context mContext;
    private int mHeight;
    int mState = this.STATE_NONE;
    private int mWidth;
    private int zDA;
    private Paint zDB;
    private int zDC;
    private int zDD;
    private int zDE;
    private int zDF;
    private int zDG;
    private int zDH;
    private int zDI;
    private boolean zDJ = false;
    private boolean zDK = false;
    public int zDL = -1;
    public int zDM = -1;
    public float zDN;
    public boolean zDO = false;
    private int zDP = 1;
    private a zDQ = new a(this);
    public b zDt;
    public a zDu;
    private Drawable zDv;
    private Drawable zDw;
    private Drawable zDx;
    public int zDy;
    public int zDz;

    public interface b {
        void Hp(int i);
    }

    public SmileyPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SmileyPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.zDw = this.mContext.getResources().getDrawable(a$d.lJj);
        this.zDv = this.mContext.getResources().getDrawable(a$d.lJi);
        this.zDx = this.mContext.getResources().getDrawable(a$d.lJk);
        this.zDC = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 12);
        this.zDD = this.zDv.getIntrinsicHeight();
        this.zDE = this.zDv.getIntrinsicWidth();
        this.zDF = this.zDx.getIntrinsicHeight();
        this.zDH = this.zDw.getIntrinsicHeight();
        this.zDI = this.zDw.getIntrinsicWidth();
        x.d("MicroMsg.SmileyPanelScrollView", "init mDotPadding:%d mDotHeight:%d mDotWidth:%d", new Object[]{Integer.valueOf(this.zDC), Integer.valueOf(this.zDD), Integer.valueOf(this.zDE)});
        this.zDB = new Paint();
        this.zDB.setColor(-65536);
        this.zDB.setAntiAlias(true);
        this.zDB.setTextAlign(Align.CENTER);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.zDA = this.zDG / (this.zDE + this.zDC);
        x.d("MicroMsg.SmileyPanelScrollView", "init mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.zDG), Integer.valueOf(this.zDA)});
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        super.draw(canvas);
        a aVar = this.zDQ;
        if (aVar.zDS.mState != aVar.zDS.zDP) {
            i = 102;
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis > aVar.mStartTime + aVar.zDR) {
                i2 = 255;
            } else {
                i2 = ((int) (((uptimeMillis - aVar.mStartTime) * 153) / aVar.zDR)) + 102;
                if (i2 < 102) {
                    i2 = 102;
                }
            }
            i = i2;
        }
        int i3;
        int i4;
        int i5;
        if (this.zDy > this.zDA) {
            this.zDJ = true;
            i3 = (this.mHeight - this.zDF) / 2;
            i4 = (this.mWidth - this.zDG) / 2;
            this.Wu = i4 - (this.zDI / 2);
            this.Wv = (this.Wu + this.zDG) + this.zDI;
            if (DEBUG) {
                canvas.drawLine((float) this.Wu, 0.0f, (float) this.Wu, (float) this.mHeight, this.zDB);
                canvas.drawLine((float) this.Wv, 0.0f, (float) this.Wv, (float) this.mHeight, this.zDB);
            }
            this.zDx.setBounds(i4, i3, this.zDG + i4, this.zDF + i3);
            this.zDx.setAlpha(i);
            this.zDx.draw(canvas);
            i5 = (this.mHeight - this.zDH) / 2;
            if (this.zDK || this.zDO) {
                i2 = (((this.zDG / (this.zDy - 1)) * this.zDz) + i4) - (this.zDI / 2);
            } else if (this.zDM == this.zDL) {
                i2 = ((((this.zDG / (this.zDy - 1)) * this.zDL) + i4) - (this.zDI / 2)) + ((int) (((float) (this.zDG / (this.zDy - 1))) * this.zDN));
            } else {
                i2 = ((((this.zDG / (this.zDy - 1)) * this.zDL) + i4) - (this.zDI / 2)) - ((int) (((float) (this.zDG / (this.zDy - 1))) * (1.0f - this.zDN)));
            }
            this.zDw.setBounds(i2, i5, this.zDI + i2, this.zDH + i5);
            this.zDw.draw(canvas);
        } else {
            this.zDJ = false;
            i3 = (this.mHeight - this.zDD) / 2;
            i4 = (this.mWidth - (((this.zDC + this.zDE) * (this.zDy - 1)) + this.zDE)) / 2;
            this.Wu = i4 - ((this.zDI - this.zDE) / 2);
            this.Wv = ((this.Wu + (this.zDE * this.zDy)) + (this.zDC * (this.zDy - 1))) + (this.zDI - this.zDE);
            if (DEBUG) {
                canvas.drawLine((float) this.Wu, 0.0f, (float) this.Wu, (float) this.mHeight, this.zDB);
                canvas.drawLine((float) this.Wv, 0.0f, (float) this.Wv, (float) this.mHeight, this.zDB);
            }
            this.zDv.setBounds(i4, i3, this.zDE + i4, this.zDD + i3);
            i5 = (this.mHeight - this.zDH) / 2;
            if (this.zDK || this.zDO) {
                i2 = i4 - ((this.zDI - this.zDE) / 2);
            } else if (this.zDM == this.zDL) {
                i2 = (i4 - ((this.zDI - this.zDE) / 2)) + ((int) (((float) (this.zDE + this.zDC)) * this.zDN));
            } else {
                i2 = (i4 - ((this.zDI - this.zDE) / 2)) - ((int) (((float) (this.zDE + this.zDC)) * (1.0f - this.zDN)));
            }
            this.zDw.setBounds(i2, i5, this.zDI + i2, this.zDH + i5);
            for (i5 = 0; i5 < this.zDy; i5++) {
                canvas.save();
                if (i5 > 0) {
                    canvas.translate((float) ((this.zDE + this.zDC) * i5), 0.0f);
                }
                this.zDv.setAlpha(i);
                this.zDv.draw(canvas);
                canvas.restore();
            }
            if (this.zDL > this.zDy - 1) {
                this.zDL = this.zDy - 1;
            }
            i5 = (this.zDE + this.zDC) * this.zDL;
            if (i2 + i5 > this.Wv) {
                i2 = 0;
                x.i("MicroMsg.SmileyPanelScrollView", "over right.");
            } else {
                i2 = i5;
            }
            canvas.save();
            canvas.translate((float) i2, 0.0f);
            this.zDw.draw(canvas);
            canvas.restore();
        }
        if (this.mState == this.zDP && i < 255) {
            invalidate();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != this.mWidth) {
            this.mWidth = getMeasuredWidth();
            this.mHeight = getMeasuredHeight();
            this.zDG = (this.mWidth - (this.zDu.getColumnWidth() - this.zDu.zGx)) - (com.tencent.mm.bv.a.aa(this.mContext, c.bvT) * 2);
            this.zDA = this.zDG / (this.zDE + this.zDC);
            x.d("MicroMsg.SmileyPanelScrollView", "onSizeChanged mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.zDG), Integer.valueOf(this.zDA)});
            if (this.mHeight == 0) {
                x.i("MicroMsg.SmileyPanelScrollView", "user default height");
                this.mHeight = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 16);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        if (x < this.Wu - this.zDC || x > this.Wv + this.zDC) {
            x.d("MicroMsg.SmileyPanelScrollView", "over x :%d mLeft:%d mRight:%d ", new Object[]{Integer.valueOf(x), Integer.valueOf(this.Wu), Integer.valueOf(this.Wv)});
            if (action == 0) {
                return super.onTouchEvent(motionEvent);
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (x < this.Wu) {
                x = this.Wu;
            }
            if (x > this.Wv) {
                x = this.Wv;
            }
            if (this.zDJ) {
                x = (x - this.Wu) / (this.zDG / (this.zDy - 1));
            } else {
                x = ((x - this.Wu) + this.zDC) / (this.zDE + this.zDC);
            }
            if (x > this.zDy - 1) {
                x = this.zDy - 1;
            }
            this.zDt.Hp(x);
            this.zDL = x;
            this.zDM = x;
        }
        switch (action) {
            case 0:
                if (!z) {
                    this.zDK = true;
                    this.zDO = true;
                    this.mState = this.zDP;
                    this.zDQ.cAp();
                    invalidate();
                    break;
                }
                break;
            case 1:
            case 3:
                this.mState = this.STATE_NONE;
                this.zDK = false;
                invalidate();
                break;
            case 2:
                if (!(z || this.mState == this.zDP)) {
                    this.mState = this.zDP;
                    this.zDQ.cAp();
                    invalidate();
                    break;
                }
        }
        return true;
    }
}
