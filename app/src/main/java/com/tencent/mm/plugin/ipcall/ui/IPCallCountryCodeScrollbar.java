package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.q;
import com.tencent.rtmp.sharp.jni.QLog;

public class IPCallCountryCodeScrollbar extends View {
    public static final String[] nJf = new String[]{"A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z"};
    private int atq;
    private float gUh;
    private Paint iYm;
    protected float nJg = 1.3f;
    protected int nJh = 79;
    protected String[] nJi = new String[]{"↑"};
    private float nJj = 0.0f;
    private float nJk;
    private q nJl;
    private TextView nJm;
    private int nJn;
    a nJo;

    public final void CR(String str) {
        int i = 0;
        int i2 = 0;
        for (String equals : nJf) {
            if (equals.equals(str)) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            str = "#";
        }
        int length = this.nJi.length + 1;
        String[] strArr = new String[length];
        String[] strArr2 = this.nJi;
        int length2 = strArr2.length;
        i2 = 0;
        while (i2 < length2) {
            String str2 = strArr2[i2];
            if (!str2.equals(str)) {
                strArr[i] = str2;
                i++;
                i2++;
            } else {
                return;
            }
        }
        strArr[length - 1] = str;
        this.nJi = strArr;
    }

    public IPCallCountryCodeScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.nJn = b.b(context, 3.0f);
        View inflate = inflate(context, R.i.dsC, null);
        int b = b.b(context, (float) this.nJh);
        this.nJl = new q(inflate, b, b);
        this.nJm = (TextView) inflate.findViewById(R.h.cOh);
        this.iYm = new Paint();
        this.iYm.setAntiAlias(true);
        this.iYm.setColor(-11119018);
        this.iYm.setTextAlign(Align.CENTER);
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.gUh = ((float) measuredHeight) / (((float) this.nJi.length) * this.nJg);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvK);
        if (this.gUh > ((float) dimensionPixelSize)) {
            this.gUh = (float) dimensionPixelSize;
        }
        this.iYm.setTextSize(this.gUh);
        if (this.nJj != this.gUh) {
            this.nJj = this.gUh;
            post(new 1(this, measuredWidth, measuredHeight));
        }
        if (this.gUh == ((float) dimensionPixelSize)) {
            float length = (((float) measuredHeight) - ((((float) this.nJi.length) * this.gUh) * this.nJg)) / 2.0f;
            while (i < this.nJi.length) {
                canvas.drawText(this.nJi[i], ((float) measuredWidth) / 2.0f, (this.gUh + length) + ((((float) i) * this.gUh) * this.nJg), this.iYm);
                i++;
            }
            return;
        }
        while (i < this.nJi.length) {
            canvas.drawText(this.nJi[i], ((float) measuredWidth) / 2.0f, this.gUh + ((((float) i) * this.gUh) * this.nJg), this.iYm);
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.nJk = motionEvent.getY();
            if (this.nJk < 0.0f) {
                this.nJk = 0.0f;
            }
            if (this.nJk > ((float) getMeasuredHeight())) {
                this.nJk = (float) getMeasuredHeight();
            }
            setBackgroundDrawable(a.b(getContext(), R.g.bFG));
            float f = this.gUh * this.nJg;
            int measuredHeight = (int) ((this.nJk - ((((float) getMeasuredHeight()) - (((float) this.nJi.length) * f)) / 2.0f)) / f);
            if (measuredHeight < 0) {
                measuredHeight = 0;
            }
            if (measuredHeight >= this.nJi.length) {
                measuredHeight = this.nJi.length - 1;
            }
            this.atq = measuredHeight;
            if (this.atq == -1) {
                this.nJm.setText(R.l.eIq);
            } else {
                this.nJm.setText(this.nJi[this.atq]);
            }
            this.nJl.showAtLocation(this, 17, 0, 0);
            if (this.nJo != null) {
                if (this.atq == -1) {
                    this.nJo.xh(a.ac(getContext(), R.l.eIq));
                } else {
                    this.nJo.xh(this.nJi[this.atq]);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            setBackgroundResource(0);
            this.nJl.dismiss();
        }
        return true;
    }
}
