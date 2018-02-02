package com.tencent.mm.plugin.sport.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.plugin.sport.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SportChartView extends View {
    Paint iYm;
    private GestureDetector lVX;
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
    private int lXQ;
    private int lXR;
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
    Path lZb;
    Path lZc;
    private int lZg;
    private int lZh;
    private boolean lZi;
    private int oaX;
    private SimpleDateFormat rUA;
    private boolean rUB;
    private int rUC;
    private int rUD;
    private int rUE;
    private int rUF;
    private List<e> rUG;
    private b[] rUH;
    public int rUI;
    public boolean rUJ;
    private OnGestureListener rUK;
    private SimpleDateFormat rUz;

    public enum a {
        ;

        static {
            rUN = 1;
            rUO = 2;
            rUP = new int[]{rUN, rUO};
        }
    }

    static /* synthetic */ int a(SportChartView sportChartView, float f) {
        sportChartView.oaX = Integer.MAX_VALUE;
        if (sportChartView.rUH.length > 0) {
            int i = 0;
            while (i < sportChartView.rUH.length) {
                if (i != 0) {
                    if (i > 0 && i < sportChartView.rUH.length - 1) {
                        if (f < sportChartView.rUH[i].x + ((float) (sportChartView.lYU / 2)) && f > sportChartView.rUH[i].x - ((float) (sportChartView.lYU / 2))) {
                            sportChartView.oaX = i;
                            sportChartView.invalidate();
                            break;
                        }
                    } else if (i == sportChartView.rUH.length - 1) {
                        if (f < ((float) sportChartView.lXQ) && f > sportChartView.rUH[i].x - ((float) (sportChartView.lYU / 2))) {
                            sportChartView.oaX = i;
                            sportChartView.invalidate();
                            break;
                        }
                    } else {
                        sportChartView.oaX = Integer.MAX_VALUE;
                        break;
                    }
                } else if (f < sportChartView.rUH[i].x + ((float) (sportChartView.lYU / 2)) && f > 0.0f) {
                    sportChartView.oaX = i;
                    sportChartView.invalidate();
                    break;
                }
                i++;
            }
        }
        return sportChartView.oaX;
    }

    public final void ye(int i) {
        this.rUE = i;
        if (i == a.rUN) {
            this.rUF = 7;
        } else {
            this.rUF = 30;
        }
        this.rUH = new b[this.rUF];
        bDC();
    }

    private void bDC() {
        for (int i = 0; i < this.rUH.length; i++) {
            this.rUH[i] = new b(this, (byte) 0);
        }
    }

    public SportChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rUz = new SimpleDateFormat(getResources().getString(b.rUt));
        this.rUA = new SimpleDateFormat("d");
        this.lXD = -1;
        this.lXE = -1;
        this.lXF = getResources().getColor(com.tencent.mm.plugin.sport.ui.a.a.rUq);
        this.lXG = 12.0f;
        this.lXH = 24.0f;
        this.lXI = 28.0f;
        this.lXJ = 12.0f;
        this.lXK = 12.0f;
        this.lXL = getResources().getColor(com.tencent.mm.plugin.sport.ui.a.a.rUr);
        this.lXM = -1;
        this.lXN = getResources().getColor(com.tencent.mm.plugin.sport.ui.a.a.rUr);
        this.lXO = -1;
        this.oaX = Integer.MAX_VALUE;
        this.lXQ = 0;
        this.lXR = 0;
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
        this.rUC = -1;
        this.rUD = -1;
        this.rUE = a.rUN;
        this.rUF = 7;
        this.rUH = new b[this.rUF];
        this.rUK = new 1(this);
        aFt();
    }

    public SportChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rUz = new SimpleDateFormat(getResources().getString(b.rUt));
        this.rUA = new SimpleDateFormat("d");
        this.lXD = -1;
        this.lXE = -1;
        this.lXF = getResources().getColor(com.tencent.mm.plugin.sport.ui.a.a.rUq);
        this.lXG = 12.0f;
        this.lXH = 24.0f;
        this.lXI = 28.0f;
        this.lXJ = 12.0f;
        this.lXK = 12.0f;
        this.lXL = getResources().getColor(com.tencent.mm.plugin.sport.ui.a.a.rUr);
        this.lXM = -1;
        this.lXN = getResources().getColor(com.tencent.mm.plugin.sport.ui.a.a.rUr);
        this.lXO = -1;
        this.oaX = Integer.MAX_VALUE;
        this.lXQ = 0;
        this.lXR = 0;
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
        this.rUC = -1;
        this.rUD = -1;
        this.rUE = a.rUN;
        this.rUF = 7;
        this.rUH = new b[this.rUF];
        this.rUK = new 1(this);
        aFt();
    }

    private void c(Canvas canvas, boolean z) {
        int i = 0;
        if (z) {
            this.lZc.reset();
            this.lZc.moveTo(this.rUH[0].x, this.rUH[0].y);
            for (int i2 = 0; i2 < this.rUH.length; i2++) {
                this.lZc.lineTo(this.rUH[i2].x, this.rUH[i2].y);
            }
            this.lZc.lineTo(this.rUH[this.rUH.length - 1].x, (float) ((this.lXR - this.lYo) - 1));
            this.lZc.lineTo((float) this.lYc, (float) ((this.lXR - this.lYo) - 1));
            this.lZc.lineTo((float) this.lYc, this.rUH[0].y);
            canvas.drawPath(this.lZc, this.iYm);
            return;
        }
        this.lZc.reset();
        this.lZc.moveTo(this.rUH[0].x, this.rUH[0].y);
        while (i < this.rUH.length) {
            if (i <= 0) {
                aFv();
            } else if (this.rUH[i - 1].y == ((float) (this.lXR - this.lYi))) {
                this.iYm.reset();
                this.iYm.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.iYm.setAntiAlias(true);
                this.iYm.setStrokeWidth((float) this.lXY);
                this.iYm.setStyle(Style.STROKE);
                this.iYm.setColor(-1);
            } else {
                aFv();
            }
            this.lZc.lineTo(this.rUH[i].x, this.rUH[i].y);
            canvas.drawPath(this.lZc, this.iYm);
            this.lZc.reset();
            this.lZc.moveTo(this.rUH[i].x, this.rUH[i].y);
            i++;
        }
    }

    private void g(Canvas canvas) {
        this.iYm.reset();
        this.iYm.setAntiAlias(true);
        this.iYm.setColor(-1);
        this.iYm.setStrokeWidth(0.0f);
        this.iYm.setStyle(Style.FILL);
        for (int i = 0; i < this.rUH.length; i++) {
            if (i == this.rUH.length - 1) {
                canvas.drawCircle(this.rUH[i].x, this.rUH[i].y, (float) this.lXW, this.iYm);
            } else {
                canvas.drawCircle(this.rUH[i].x, this.rUH[i].y, (float) this.lXU, this.iYm);
            }
        }
    }

    public final void cc(List<e> list) {
        this.rUG = list;
        iQ(true);
        invalidate();
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

    private void h(Canvas canvas) {
        this.iYm.reset();
        this.iYm.setAntiAlias(true);
        this.iYm.setStrokeWidth(0.0f);
        this.iYm.setTextSize(i(2, 12.0f));
        this.iYm.setAlpha(153);
        for (int i = 0; i < this.rUH.length; i++) {
            if (i == 0) {
                this.iYm.setTextAlign(Align.LEFT);
            } else {
                this.iYm.setTextAlign(Align.CENTER);
            }
            if (this.rUH[i].rUQ) {
                this.iYm.setColor(-1);
            } else {
                this.iYm.setColor(this.lXL);
            }
            canvas.drawText(this.rUH[i].rUR, this.rUH[i].x, (float) (this.lXR - this.lYy), this.iYm);
        }
    }

    private void aFt() {
        this.iYm = new Paint();
        this.lZb = new Path();
        this.lZc = new Path();
        this.rUH = new b[this.rUF];
        bDC();
        bDD();
        this.lVX = new GestureDetector(getContext(), this.rUK);
    }

    private void bDD() {
        for (int i = 0; i < this.rUF; i++) {
            if (i == this.rUF - 1) {
                this.rUH[i].rUQ = true;
            } else {
                this.rUH[i].rUQ = false;
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
        this.lXQ = getWidth();
        this.lXR = getHeight();
        this.lYU = ((this.lXQ - this.lYc) - this.lYe) / (this.rUF - 1);
        this.lYV = ((this.lXR - this.lYg) - this.lYi) / 2;
        for (i = 0; i < this.rUH.length; i++) {
            this.rUH[i].x = (float) (this.lYc + (this.lYU * i));
        }
        i = this.rUH.length;
        if (i > this.rUF) {
            i = this.rUF;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.rUH[i3].jer > 100000) {
                this.rUH[i3].jer = 100000;
            }
            if (this.rUH[i3].jer < 0) {
                this.rUH[i3].jer = 0;
            }
            if (this.rUH[i3].jer > i2) {
                i2 = this.rUH[i3].jer;
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
            this.rUH[i4].y = ((float) (this.lXR - this.lYi)) - ((((float) this.rUH[i4].jer) / ((float) i2)) * ((float) ((this.lXR - this.lYg) - this.lYi)));
        }
        for (i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                this.rUH[i2].rUR = this.rUz.format(new Date(this.rUH[i2].timestamp));
            } else if (this.rUE != a.rUO) {
                this.rUH[i2].rUR = this.rUA.format(new Date(this.rUH[i2].timestamp));
            } else if (i2 % 6 == 5) {
                this.rUH[i2].rUR = this.rUA.format(new Date(this.rUH[i2].timestamp));
            } else {
                this.rUH[i2].rUR = "";
            }
        }
        super.onDraw(canvas);
        if (!this.rUB) {
            g(canvas);
            if (this.oaX != Integer.MAX_VALUE) {
                i = this.oaX;
                if (i >= 0 && i <= this.rUF - 1) {
                    this.iYm.reset();
                    this.iYm.setColor(this.lXL);
                    this.iYm.setAntiAlias(true);
                    this.iYm.setStrokeWidth(0.0f);
                    this.iYm.setTextSize(i(2, 12.0f));
                    this.iYm.setTextAlign(Align.CENTER);
                    if (i == 0) {
                        this.iYm.setTextAlign(Align.LEFT);
                    }
                    if (i == this.rUF - 1) {
                        this.iYm.setTextAlign(Align.RIGHT);
                    }
                    if (!this.lZi) {
                        this.lZg = ((int) this.rUH[i].y) - this.lYI;
                        this.lZh = this.lZg;
                        this.lZi = true;
                    }
                    if (this.lZi) {
                        float f = (float) (((double) this.lZh) / 8.0d);
                        if (this.lZg > 0) {
                            this.iYm.setAlpha(((this.lZh - this.lZg) * 255) / this.lZh);
                        }
                        canvas.drawText(this.rUH[i].jer, this.rUH[i].x, (float) (this.lZg + this.lYI), this.iYm);
                        if (this.rUE == a.rUO) {
                            this.iYm.reset();
                            this.lZb.reset();
                            this.iYm.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                            this.iYm.setColor(this.lXF);
                            this.iYm.setStrokeWidth((float) this.lYa);
                            this.iYm.setStyle(Style.STROKE);
                            this.iYm.setAlpha(102);
                            this.lZb.moveTo(this.rUH[i].x, (float) (this.lXR - this.lYo));
                            this.lZb.lineTo(this.rUH[i].x, (float) ((this.lZg + this.lYI) + this.lXW));
                            canvas.drawPath(this.lZb, this.iYm);
                        }
                        if (this.lZg > 0) {
                            if (((float) this.lZg) / ((float) this.lZh) <= 1.0f / f) {
                                this.lZg--;
                            } else {
                                this.lZg = (int) (((float) this.lZg) - (f * (((float) this.lZg) / ((float) this.lZh))));
                            }
                            invalidate();
                        } else {
                            this.lZi = false;
                        }
                    }
                }
                i = this.oaX;
                if (i >= 0 && i <= this.rUF - 1) {
                    this.rUH[i].rUQ = true;
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
        if (!(this.lYR == 0 || this.rUB)) {
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
        if (!this.rUB) {
            this.iYm.reset();
            this.iYm.setColor(this.lXN);
            this.iYm.setAntiAlias(true);
            this.iYm.setAlpha(102);
            this.iYm.setStrokeWidth(0.0f);
            this.iYm.setTextSize(i(2, 12.0f));
            this.iYm.setTextAlign(Align.RIGHT);
            canvas.drawText(getResources().getString(b.rUs), (float) (this.lXQ - this.lYw), (float) (((double) this.lYR) + (((double) this.iYm.getTextSize()) * 0.34d)), this.iYm);
        }
        if (this.rUJ) {
            this.iYm.reset();
            this.iYm.setColor(-1);
            this.iYm.setAntiAlias(true);
            this.iYm.setStrokeWidth(0.0f);
            this.iYm.setTypeface(this.lYS);
            this.iYm.setTextAlign(Align.RIGHT);
            this.iYm.setTextSize(i(2, 28.0f));
            String valueOf = String.valueOf(this.rUI);
            canvas.drawText(valueOf, (float) (this.lXQ - this.lYG), (float) this.lYE, this.iYm);
            float measureText = this.iYm.measureText(valueOf);
            this.iYm.setTextSize(i(2, 24.0f));
            canvas.drawText(getResources().getString(b.rUv), ((float) (this.lXQ - this.lYG)) - measureText, (float) this.lYA, this.iYm);
        } else {
            this.iYm.reset();
            this.iYm.setColor(-1);
            this.iYm.setAntiAlias(true);
            this.iYm.setStrokeWidth(0.0f);
            this.iYm.setTypeface(this.lYS);
            this.iYm.setTextSize(i(2, 24.0f));
            canvas.drawText(getResources().getString(b.rUu), (float) this.lYC, (float) this.lYA, this.iYm);
            this.iYm.setTextAlign(Align.RIGHT);
            this.iYm.setTextSize(i(2, 28.0f));
            canvas.drawText(this.rUI, (float) (this.lXQ - this.lYG), (float) this.lYE, this.iYm);
        }
        if (this.rUH.length > 2) {
            this.iYm.reset();
            this.iYm.setAntiAlias(true);
            this.iYm.setStrokeWidth(0.0f);
            this.iYm.setAlpha(102);
            this.iYm.setStyle(Style.FILL_AND_STROKE);
            this.iYm.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.lXR - this.lYo), -1, 16777215, TileMode.REPEAT));
            this.iYm.setColor(-1);
            c(canvas, true);
            aFv();
            if (!this.rUB) {
                c(canvas, false);
            }
        }
        h(canvas);
    }

    private void iQ(boolean z) {
        int i = 0;
        this.oaX = Integer.MAX_VALUE;
        Calendar instance = Calendar.getInstance();
        this.rUH = new b[this.rUF];
        bDC();
        int i2;
        if (this.rUG == null || this.rUG.size() <= 0) {
            this.rUB = true;
            instance.add(5, -this.rUF);
            for (i2 = 0; i2 < this.rUH.length; i2++) {
                instance.add(5, 1);
                this.rUH[i2].timestamp = instance.getTimeInMillis();
                this.rUH[i2].jer = 0;
            }
            return;
        }
        this.rUB = false;
        List arrayList = new ArrayList();
        arrayList.addAll(this.rUG);
        Collections.sort(arrayList);
        int size = arrayList.size();
        if (z || this.rUD == -1) {
            i2 = size / this.rUF;
            if (size % this.rUF != 0) {
                this.rUD = i2 + 1;
            } else {
                this.rUD = i2;
            }
            if (this.rUD > 4) {
                this.rUD = 4;
            }
            this.rUC = this.rUD;
        }
        i2 = size - (this.rUF * ((this.rUD - this.rUC) + 1));
        if (i2 < 0) {
            i2 = 0;
        }
        x.i("MicroMsg.Sport.SportChartView", "updateViewItems beginIndex:%d endIndex:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(size - (this.rUF * (this.rUD - this.rUC)))});
        arrayList = arrayList.subList(i2, size);
        size = arrayList.size();
        if (size < this.rUF) {
            instance.setTimeInMillis(((e) arrayList.get(0)).field_timestamp);
            for (i2 = 0; i2 < this.rUF - size; i2++) {
                instance.add(5, -1);
                e eVar = new e();
                eVar.field_timestamp = instance.getTimeInMillis();
                eVar.field_step = 0;
                arrayList.add(0, eVar);
            }
        }
        while (i < this.rUF) {
            e eVar2 = (e) arrayList.get(i);
            this.rUH[i].jer = eVar2.field_step;
            this.rUH[i].timestamp = eVar2.field_timestamp;
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.lVX.onTouchEvent(motionEvent);
        return true;
    }
}
