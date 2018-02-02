package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView extends View {
    Paint iYm;
    private final int lXD;
    private final int lXE;
    private final int lXF;
    private final float lXG;
    private final float lXH;
    private final float lXI;
    private final float lXJ;
    private final float lXK;
    private final int lXL;
    private final int lXM;
    private final int lXN;
    private final int lXO;
    private int lXP;
    private int lXQ;
    private int lXR;
    private final float lXS;
    private final float lXT;
    private final int lXU;
    private final float lXV;
    private final int lXW;
    private final float lXX;
    private final int lXY;
    private final float lXZ;
    private final int lYA;
    private final float lYB;
    private final int lYC;
    private final float lYD;
    private final int lYE;
    private final float lYF;
    private final int lYG;
    private final float lYH;
    private final int lYI;
    private final int lYJ;
    private final int lYK;
    private final int lYL;
    private final int lYM;
    private final int lYN;
    private final int lYO;
    private final int lYP;
    private final int lYQ;
    private int lYR;
    private final Typeface lYS;
    private final Typeface lYT;
    private int lYU;
    private int lYV;
    private int[] lYW;
    private final int lYX;
    private float[] lYY;
    private float[] lYZ;
    private final int lYa;
    private final float lYb;
    private final int lYc;
    private final float lYd;
    private final int lYe;
    private final float lYf;
    private final int lYg;
    private final float lYh;
    private final int lYi;
    private final float lYj;
    private final int lYk;
    private final float lYl;
    private final int lYm;
    private final float lYn;
    private final int lYo;
    private final float lYp;
    private final int lYq;
    private final float lYr;
    private final float lYs;
    private final float lYt;
    private final float lYu;
    private final int lYv;
    private final int lYw;
    private final int lYx;
    private final int lYy;
    private final float lYz;
    private boolean[] lZa;
    Path lZb;
    Path lZc;
    List<String> lZd;
    private boolean lZe;
    PathEffect lZf;
    private int lZg;
    private int lZh;
    private boolean lZi;
    List<Point> points;

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lXD = -1;
        this.lXE = -1;
        this.lXF = getResources().getColor(R.e.bse);
        this.lXG = 12.0f;
        this.lXH = 28.0f;
        this.lXI = 33.0f;
        this.lXJ = 12.0f;
        this.lXK = 12.0f;
        this.lXL = getResources().getColor(R.e.bsf);
        this.lXM = -1;
        this.lXN = getResources().getColor(R.e.bsf);
        this.lXO = -1;
        this.lXP = Integer.MAX_VALUE;
        this.lXQ = 0;
        this.lXR = 0;
        this.lXS = 10.0f;
        this.lXT = 2.5f;
        this.lXU = (int) i(1, 2.5f);
        this.lXV = 4.0f;
        this.lXW = (int) i(1, 4.0f);
        this.lXX = 1.8f;
        this.lXY = (int) i(1, 1.8f);
        this.lXZ = 1.0f;
        this.lYa = (int) i(1, 1.0f);
        this.lYb = 8.0f;
        this.lYc = (int) i(1, 8.0f);
        this.lYd = 22.0f;
        this.lYe = (int) i(1, 22.0f);
        this.lYf = 67.0f;
        this.lYg = (int) i(1, 67.0f);
        this.lYh = 40.0f;
        this.lYi = (int) i(1, 40.0f);
        this.lYj = 22.0f;
        this.lYk = (int) i(1, 22.0f);
        this.lYl = 55.0f;
        this.lYm = (int) i(1, 55.0f);
        this.lYn = 35.0f;
        this.lYo = (int) i(1, 35.0f);
        this.lYp = 45.0f;
        this.lYq = (int) i(1, 45.0f);
        this.lYr = 8.0f;
        this.lYs = (float) ((int) i(1, 8.0f));
        this.lYt = 8.0f;
        this.lYu = (float) ((int) i(1, 8.0f));
        this.lYv = 2;
        this.lYw = (int) i(1, 2.0f);
        this.lYx = 15;
        this.lYy = (int) i(1, 15.0f);
        this.lYz = 33.0f;
        this.lYA = (int) i(1, 33.0f);
        this.lYB = 8.0f;
        this.lYC = (int) i(1, 8.0f);
        this.lYD = 35.0f;
        this.lYE = (int) i(1, 35.0f);
        this.lYF = 10.0f;
        this.lYG = (int) i(1, 10.0f);
        this.lYH = 58.0f;
        this.lYI = (int) i(1, 58.0f);
        this.lYJ = (int) i(1, 1.0f);
        this.lYK = 102;
        this.lYL = 102;
        this.lYM = 153;
        this.lYN = 102;
        this.lYO = 102;
        this.lYP = 102;
        this.lYQ = d.CTRL_INDEX;
        this.lYR = 0;
        this.lYS = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.lYT = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.lYU = 0;
        this.lYV = 0;
        this.lYW = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.lYX = 7;
        this.lYY = new float[7];
        this.lYZ = new float[7];
        this.lZa = new boolean[7];
        this.lZe = false;
        this.lZf = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        aFt();
    }

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lXD = -1;
        this.lXE = -1;
        this.lXF = getResources().getColor(R.e.bse);
        this.lXG = 12.0f;
        this.lXH = 28.0f;
        this.lXI = 33.0f;
        this.lXJ = 12.0f;
        this.lXK = 12.0f;
        this.lXL = getResources().getColor(R.e.bsf);
        this.lXM = -1;
        this.lXN = getResources().getColor(R.e.bsf);
        this.lXO = -1;
        this.lXP = Integer.MAX_VALUE;
        this.lXQ = 0;
        this.lXR = 0;
        this.lXS = 10.0f;
        this.lXT = 2.5f;
        this.lXU = (int) i(1, 2.5f);
        this.lXV = 4.0f;
        this.lXW = (int) i(1, 4.0f);
        this.lXX = 1.8f;
        this.lXY = (int) i(1, 1.8f);
        this.lXZ = 1.0f;
        this.lYa = (int) i(1, 1.0f);
        this.lYb = 8.0f;
        this.lYc = (int) i(1, 8.0f);
        this.lYd = 22.0f;
        this.lYe = (int) i(1, 22.0f);
        this.lYf = 67.0f;
        this.lYg = (int) i(1, 67.0f);
        this.lYh = 40.0f;
        this.lYi = (int) i(1, 40.0f);
        this.lYj = 22.0f;
        this.lYk = (int) i(1, 22.0f);
        this.lYl = 55.0f;
        this.lYm = (int) i(1, 55.0f);
        this.lYn = 35.0f;
        this.lYo = (int) i(1, 35.0f);
        this.lYp = 45.0f;
        this.lYq = (int) i(1, 45.0f);
        this.lYr = 8.0f;
        this.lYs = (float) ((int) i(1, 8.0f));
        this.lYt = 8.0f;
        this.lYu = (float) ((int) i(1, 8.0f));
        this.lYv = 2;
        this.lYw = (int) i(1, 2.0f);
        this.lYx = 15;
        this.lYy = (int) i(1, 15.0f);
        this.lYz = 33.0f;
        this.lYA = (int) i(1, 33.0f);
        this.lYB = 8.0f;
        this.lYC = (int) i(1, 8.0f);
        this.lYD = 35.0f;
        this.lYE = (int) i(1, 35.0f);
        this.lYF = 10.0f;
        this.lYG = (int) i(1, 10.0f);
        this.lYH = 58.0f;
        this.lYI = (int) i(1, 58.0f);
        this.lYJ = (int) i(1, 1.0f);
        this.lYK = 102;
        this.lYL = 102;
        this.lYM = 153;
        this.lYN = 102;
        this.lYO = 102;
        this.lYP = 102;
        this.lYQ = d.CTRL_INDEX;
        this.lYR = 0;
        this.lYS = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.lYT = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.lYU = 0;
        this.lYV = 0;
        this.lYW = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.lYX = 7;
        this.lYY = new float[7];
        this.lYZ = new float[7];
        this.lZa = new boolean[7];
        this.lZe = false;
        this.lZf = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        aFt();
    }

    private void c(Canvas canvas, boolean z) {
        int i = 0;
        if (z) {
            this.lZc.reset();
            this.lZc.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
            for (int i2 = 0; i2 < this.points.size(); i2++) {
                this.lZc.lineTo((float) ((Point) this.points.get(i2)).x, (float) ((Point) this.points.get(i2)).y);
            }
            this.lZc.lineTo(this.lYY[this.lYY.length - 1], (float) ((this.lXR - this.lYo) - 1));
            this.lZc.lineTo((float) this.lYc, (float) ((this.lXR - this.lYo) - 1));
            this.lZc.lineTo((float) this.lYc, this.lYZ[0]);
            canvas.drawPath(this.lZc, this.iYm);
            return;
        }
        this.lZc.reset();
        this.lZc.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
        while (i < this.points.size()) {
            if (i <= 0) {
                aFv();
            } else if (((Point) this.points.get(i - 1)).y == this.lXR - this.lYi) {
                this.iYm.reset();
                this.iYm.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.iYm.setAntiAlias(true);
                this.iYm.setStrokeWidth((float) this.lXY);
                this.iYm.setStyle(Style.STROKE);
                this.iYm.setColor(-1);
            } else {
                aFv();
            }
            this.lZc.lineTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            canvas.drawPath(this.lZc, this.iYm);
            this.lZc.reset();
            this.lZc.moveTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            i++;
        }
    }

    private void g(Canvas canvas) {
        this.iYm.reset();
        this.iYm.setAntiAlias(true);
        this.iYm.setColor(-1);
        this.iYm.setStrokeWidth(0.0f);
        this.iYm.setStyle(Style.FILL);
        for (int i = 0; i < this.points.size(); i++) {
            Point point = (Point) this.points.get(i);
            if (i == this.points.size() - 1) {
                canvas.drawCircle((float) point.x, (float) point.y, (float) this.lXW, this.iYm);
            } else {
                canvas.drawCircle((float) point.x, (float) point.y, (float) this.lXU, this.iYm);
            }
        }
    }

    private float i(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        return TypedValue.applyDimension(i, f, system.getDisplayMetrics());
    }

    private void b(Canvas canvas, List<String> list) {
        if (list != null && list.size() == 7) {
            this.iYm.reset();
            this.iYm.setAntiAlias(true);
            this.iYm.setStrokeWidth(0.0f);
            this.iYm.setTextSize(i(2, 12.0f));
            this.iYm.setAlpha(153);
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    this.iYm.setTextAlign(Align.LEFT);
                } else {
                    this.iYm.setTextAlign(Align.CENTER);
                }
                if (this.lZa[i]) {
                    this.iYm.setColor(-1);
                } else {
                    this.iYm.setColor(this.lXL);
                }
                canvas.drawText((String) list.get(i), (float) ((Point) this.points.get(i)).x, (float) (this.lXR - this.lYy), this.iYm);
            }
        }
    }

    private void aFt() {
        this.iYm = new Paint();
        this.lZb = new Path();
        this.lZc = new Path();
        this.points = new LinkedList();
        this.lZd = new LinkedList();
        aFu();
    }

    private void aFu() {
        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                this.lZa[i] = true;
            } else {
                this.lZa[i] = false;
            }
        }
    }

    private void aFv() {
        this.iYm.reset();
        this.iYm.setAntiAlias(true);
        this.iYm.setStrokeWidth((float) this.lXY);
        this.iYm.setStyle(Style.STROKE);
        this.iYm.setColor(-1);
    }

    protected void onDraw(Canvas canvas) {
        int i;
        this.points.clear();
        View findViewById = findViewById(R.h.cfv);
        this.lXQ = findViewById.getWidth();
        this.lXR = findViewById.getHeight();
        this.lYU = ((this.lXQ - this.lYc) - this.lYe) / 6;
        this.lYV = ((this.lXR - this.lYg) - this.lYi) / 2;
        for (i = 0; i < this.lYY.length; i++) {
            this.lYY[i] = (float) (this.lYc + (this.lYU * i));
        }
        i = this.lYW.length;
        if (i > 7) {
            i = 7;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.lYW[i3] > 100000) {
                this.lYW[i3] = 100000;
            }
            if (this.lYW[i3] < 0) {
                this.lYW[i3] = 0;
            }
            if (this.lYW[i3] > i2) {
                i2 = this.lYW[i3];
            }
        }
        if (i2 <= 15000 && i2 >= 0) {
            i2 = 15000;
        } else if (i2 <= 15000 || i2 > 100000) {
            i2 = 0;
        } else if (((double) i2) / 5000.0d > ((double) (((float) i2) / 5000.0f))) {
            i2 = ((i2 / 5000) + 1) * 5000;
        }
        this.lYR = (((this.lXR - this.lYg) - this.lYi) * 10000) / i2;
        this.lYR = (this.lXR - this.lYi) - this.lYR;
        for (int i4 = 0; i4 < i; i4++) {
            this.lYZ[i4] = ((float) (this.lXR - this.lYi)) - ((((float) this.lYW[i4]) / ((float) i2)) * ((float) ((this.lXR - this.lYg) - this.lYi)));
            this.points.add(new Point((int) this.lYY[i4], (int) this.lYZ[i4]));
        }
        super.onDraw(canvas);
        if (!this.lZe) {
            g(canvas);
            if (this.lXP != Integer.MAX_VALUE) {
                i2 = this.lXP;
                this.iYm.reset();
                this.iYm.setColor(this.lXL);
                this.iYm.setAntiAlias(true);
                this.iYm.setStrokeWidth(0.0f);
                this.iYm.setTextSize(i(2, 12.0f));
                this.iYm.setTextAlign(Align.CENTER);
                if (i2 >= 0 && i2 <= 6) {
                    if (i2 == 0) {
                        this.iYm.setTextAlign(Align.LEFT);
                    }
                    if (i2 == 6) {
                        this.iYm.setTextAlign(Align.RIGHT);
                    }
                    if (!this.lZi) {
                        this.lZg = ((Point) this.points.get(i2)).y - this.lYI;
                        this.lZh = this.lZg;
                        this.lZi = true;
                    }
                    if (this.lZi) {
                        float f = (float) (((double) this.lZh) / 8.0d);
                        if (this.lZg > 0) {
                            this.iYm.setAlpha(((this.lZh - this.lZg) * 255) / this.lZh);
                        }
                        canvas.drawText(this.lYW[i2], (float) ((Point) this.points.get(i2)).x, (float) (this.lZg + this.lYI), this.iYm);
                        if (this.lZg > 0) {
                            if (((float) this.lZg) / ((float) this.lZh) <= 1.0f / f) {
                                this.lZg--;
                            } else {
                                this.lZg = (int) (((float) this.lZg) - ((((float) this.lZg) / ((float) this.lZh)) * f));
                            }
                            invalidate();
                        } else {
                            this.lZi = false;
                        }
                    }
                }
                i = this.lXP;
                if (i >= 0 && i <= 6) {
                    this.lZa[i] = true;
                }
            }
        }
        this.iYm.reset();
        this.lZb.reset();
        this.iYm.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        this.iYm.setColor(this.lXF);
        this.iYm.setStrokeWidth((float) this.lYa);
        this.iYm.setAlpha(102);
        this.iYm.setStyle(Style.STROKE);
        if (!(this.lYR == 0 || this.lZe)) {
            this.lZb.moveTo((float) this.lYc, (float) this.lYR);
            this.lZb.lineTo((float) (this.lXQ - this.lYk), (float) this.lYR);
            canvas.drawPath(this.lZb, this.iYm);
        }
        this.iYm.reset();
        this.lZb.reset();
        this.iYm.setColor(this.lXF);
        this.iYm.setStrokeWidth((float) this.lYa);
        this.iYm.setStyle(Style.STROKE);
        this.iYm.setAlpha(102);
        this.lZb.reset();
        this.lZb.moveTo(this.lYs, (float) (this.lXR - this.lYo));
        this.lZb.lineTo(((float) this.lXQ) - this.lYu, (float) (this.lXR - this.lYo));
        this.lZb.moveTo(this.lYs, (float) this.lYq);
        this.lZb.lineTo(((float) this.lXQ) - this.lYu, (float) this.lYq);
        canvas.drawPath(this.lZb, this.iYm);
        if (!this.lZe) {
            this.iYm.reset();
            this.iYm.setColor(this.lXN);
            this.iYm.setAntiAlias(true);
            this.iYm.setAlpha(102);
            this.iYm.setStrokeWidth(0.0f);
            this.iYm.setTextSize(i(2, 12.0f));
            this.iYm.setTextAlign(Align.RIGHT);
            canvas.drawText(getResources().getString(R.l.edC), (float) (this.lXQ - this.lYw), (float) (((double) this.lYR) + (((double) this.iYm.getTextSize()) * 0.34d)), this.iYm);
        }
        this.iYm.reset();
        this.iYm.setColor(-1);
        this.iYm.setAntiAlias(true);
        this.iYm.setStrokeWidth(0.0f);
        this.iYm.setTypeface(this.lYS);
        this.iYm.setTextSize(i(2, 28.0f));
        canvas.drawText(getResources().getString(R.l.edD), (float) this.lYC, (float) this.lYA, this.iYm);
        this.iYm.setTextAlign(Align.RIGHT);
        this.iYm.setTextSize(i(2, 33.0f));
        canvas.drawText(this.lYW[this.lYW.length - 1], (float) (this.lXQ - this.lYG), (float) this.lYE, this.iYm);
        if (this.points.size() > 2) {
            this.iYm.reset();
            this.iYm.setAntiAlias(true);
            this.iYm.setStrokeWidth(0.0f);
            this.iYm.setAlpha(102);
            this.iYm.setStyle(Style.FILL_AND_STROKE);
            this.iYm.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.lXR - this.lYo), -1, 16777215, TileMode.REPEAT));
            this.iYm.setColor(-1);
            c(canvas, true);
            aFv();
            if (!this.lZe) {
                c(canvas, false);
            }
        }
        b(canvas, this.lZd);
    }

    private int ag(float f) {
        this.lXP = Integer.MAX_VALUE;
        if (this.points.size() > 0) {
            int i = 0;
            while (i < this.points.size()) {
                if (i != 0) {
                    if (i > 0 && i < this.points.size() - 1) {
                        if (f < ((float) (((Point) this.points.get(i)).x + (this.lYU / 2))) && f > ((float) (((Point) this.points.get(i)).x - (this.lYU / 2)))) {
                            this.lXP = i;
                            invalidate();
                            break;
                        }
                    } else if (i == this.points.size() - 1) {
                        if (f < ((float) this.lXQ) && f > ((float) (((Point) this.points.get(i)).x - (this.lYU / 2)))) {
                            this.lXP = i;
                            invalidate();
                            break;
                        }
                    } else {
                        this.lXP = Integer.MAX_VALUE;
                        break;
                    }
                } else if (f < ((float) (((Point) this.points.get(i)).x + (this.lYU / 2))) && f > 0.0f) {
                    this.lXP = i;
                    invalidate();
                    break;
                }
                i++;
            }
        }
        return this.lXP;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        motionEvent.getY();
        x.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.lXP);
        switch (motionEvent.getAction()) {
            case 0:
                x.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
                return true;
            case 1:
                x.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
                this.lXP = ag(x);
                aFu();
                this.lZi = false;
                invalidate();
                return false;
            default:
                x.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
                return false;
        }
    }
}
