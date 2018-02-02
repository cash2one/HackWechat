package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.d.a;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

public final class b extends View {
    protected static int ldW = 32;
    protected static int ldX;
    protected static int ldY = 1;
    protected static int ldZ;
    protected static int lea = 10;
    protected static int leb;
    protected static int lec;
    protected static int led;
    protected int kyN;
    protected int kyO;
    public Collection<a> laK = new ArrayList();
    protected int leA = -1;
    protected int leB = -1;
    protected int leC = -1;
    protected int leD = 1;
    protected int leE = 7;
    protected int leF = this.leE;
    private int leG = 0;
    protected Boolean leH;
    protected int leI = ldW;
    protected int leJ = 0;
    final Time leK;
    private final Calendar leL;
    private final Calendar leM;
    private final Boolean leN;
    public int leO = 6;
    private DateFormatSymbols leP = new DateFormatSymbols();
    public a leQ;
    protected int lee = 80;
    protected Paint lef;
    protected Paint leg;
    protected Paint leh;
    protected Paint lei;
    protected Paint lej;
    protected int lek;
    protected int lel;
    protected int lem;
    protected int len;
    protected int leo;
    protected int lep;
    protected int leq;
    protected int ler;
    protected int les;
    private final StringBuilder let;
    protected boolean leu = false;
    protected boolean lev = false;
    protected int lew = -1;
    protected int lex = -1;
    protected int ley = -1;
    protected int lez = -1;
    private Context mContext;
    protected int mWidth;

    public b(Context context, TypedArray typedArray) {
        super(context);
        this.mContext = context;
        Resources resources = context.getResources();
        this.leM = Calendar.getInstance();
        this.leL = Calendar.getInstance();
        this.leK = new Time(Time.getCurrentTimezone());
        this.leK.setToNow();
        this.lek = typedArray.getColor(R.n.eZG, resources.getColor(R.e.btt));
        this.lel = typedArray.getColor(R.n.eZM, resources.getColor(R.e.btt));
        this.lem = typedArray.getColor(R.n.eZN, resources.getColor(R.e.btt));
        this.len = typedArray.getColor(R.n.eZN, resources.getColor(R.e.btu));
        this.leo = typedArray.getColor(R.n.eZL, resources.getColor(R.e.btt));
        this.leq = typedArray.getColor(R.n.eZJ, resources.getColor(R.e.btt));
        this.ler = typedArray.getColor(R.n.eZK, resources.getColor(R.e.btf));
        this.les = typedArray.getColor(R.n.eZH, resources.getColor(R.e.btI));
        this.lep = typedArray.getColor(R.n.eZI, resources.getColor(R.e.btJ));
        this.leH = Boolean.valueOf(typedArray.getBoolean(R.n.eZX, false));
        this.let = new StringBuilder(50);
        ldZ = typedArray.getDimensionPixelSize(R.n.eZO, resources.getDimensionPixelSize(R.f.byd));
        led = typedArray.getDimensionPixelSize(R.n.eZP, resources.getDimensionPixelSize(R.f.byf));
        leb = typedArray.getDimensionPixelSize(R.n.eZQ, resources.getDimensionPixelSize(R.f.bye));
        lec = typedArray.getDimensionPixelOffset(R.n.eZR, resources.getDimensionPixelOffset(R.f.bxC));
        ldX = typedArray.getDimensionPixelSize(R.n.eZS, resources.getDimensionPixelOffset(R.f.bxS));
        this.leI = (typedArray.getDimensionPixelSize(R.n.eZT, resources.getDimensionPixelOffset(R.f.bwd)) - lec) / 6;
        this.leJ = typedArray.getDimensionPixelSize(R.n.eZU, resources.getDimensionPixelOffset(R.f.bwH));
        this.leN = Boolean.valueOf(typedArray.getBoolean(R.n.eZV, true));
        this.lei = new Paint();
        this.lei.setAntiAlias(true);
        this.lei.setTextSize((float) led);
        this.lei.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.lei.setColor(this.len);
        this.lei.setTextAlign(Align.LEFT);
        this.lei.setStyle(Style.FILL);
        this.leh = new Paint();
        this.leh.setFakeBoldText(true);
        this.leh.setAntiAlias(true);
        this.leh.setColor(this.lep);
        this.leh.setTextAlign(Align.CENTER);
        this.leh.setStyle(Style.FILL);
        this.lej = new Paint();
        this.lej.setFakeBoldText(true);
        this.lej.setAntiAlias(true);
        this.lej.setColor(this.les);
        this.lej.setTextAlign(Align.CENTER);
        this.lej.setStyle(Style.FILL);
        this.lef = new Paint();
        this.lef.setAntiAlias(true);
        this.lef.setTextSize((float) leb);
        this.lef.setColor(this.len);
        this.lef.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.lef.setStyle(Style.FILL);
        this.lef.setTextAlign(Align.CENTER);
        this.lef.setFakeBoldText(true);
        this.leg = new Paint();
        this.leg.setAntiAlias(true);
        this.leg.setTextSize((float) ldZ);
        this.leg.setStyle(Style.FILL);
        this.leg.setTextAlign(Align.CENTER);
        this.leg.setFakeBoldText(false);
    }

    private void e(Canvas canvas) {
        int i = lec - (leb / 2);
        int i2 = (this.mWidth - (this.lee * 2)) / (this.leE * 2);
        for (int i3 = 0; i3 < this.leE; i3++) {
            int i4 = (((i3 * 2) + 1) * i2) + this.lee;
            this.leM.set(7, (this.leD + i3) % this.leE);
            canvas.drawText(this.leP.getShortWeekdays()[this.leM.get(7)].toUpperCase(Locale.getDefault()), (float) i4, (float) i, this.lef);
        }
    }

    private int axY() {
        return (this.leG < this.leD ? this.leG + this.leE : this.leG) - this.leD;
    }

    private boolean a(int i, Time time) {
        return this.kyN < time.year || ((this.kyN == time.year && this.kyO < time.month) || (this.kyO == time.month && i < time.monthDay));
    }

    private void f(Canvas canvas) {
        int i = (this.mWidth - (this.lee * 2)) / (this.leE * 2);
        int i2 = (((this.leI + ldZ) / 2) - ldY) + lec;
        int axY = axY();
        int i3 = 1;
        while (i3 <= this.leF) {
            if (i3 <= this.leC || -1 == this.leC) {
                int i4 = this.lee + (((axY * 2) + 1) * i);
                if ((this.kyO == this.ley && this.lew == i3 && this.leA == this.kyN) || ((this.kyO == this.lez && this.lex == i3 && this.leB == this.kyN) || (this.leu && this.leC == i3 && this.lew == -1))) {
                    if (this.leH.booleanValue()) {
                        canvas.drawRoundRect(new RectF((float) (i4 - ldX), (float) ((i2 - (ldZ / 3)) - ldX), (float) (ldX + i4), (float) ((i2 - (ldZ / 3)) + ldX)), 10.0f, 10.0f, this.lej);
                    } else {
                        canvas.drawCircle((float) i4, (float) (i2 - (ldZ / 3)), (float) ldX, this.lej);
                    }
                    if (this.leu && this.leC == i3 && this.lew == -1) {
                        this.leg.setColor(this.les);
                        this.leg.setTypeface(Typeface.defaultFromStyle(0));
                        this.leg.setTextSize(30.0f);
                        canvas.drawText(this.mContext.getResources().getString(R.l.eRh), (float) i4, (float) ((i2 + 12) + ldX), this.leg);
                    }
                }
                this.leg.setTextSize((float) ldZ);
                if (!(this.leu && this.leC == i3)) {
                    this.leg.setColor(this.leo);
                    this.leg.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.lew != -1 && this.lex != -1 && this.leA == this.leB && this.ley == this.lez && this.lew == this.lex && i3 == this.lew && this.kyO == this.ley && this.kyN == this.leA) {
                    this.leg.setColor(this.les);
                }
                if (this.lew != -1 && this.lex != -1 && this.leA == this.leB && this.leA == this.kyN && ((this.kyO == this.ley && this.lez == this.ley && ((this.lew < this.lex && i3 > this.lew && i3 < this.lex) || (this.lew > this.lex && i3 < this.lew && i3 > this.lex))) || ((this.ley < this.lez && this.kyO == this.ley && i3 > this.lew) || ((this.ley < this.lez && this.kyO == this.lez && i3 < this.lex) || ((this.ley > this.lez && this.kyO == this.ley && i3 < this.lew) || (this.ley > this.lez && this.kyO == this.lez && i3 > this.lex)))))) {
                    this.leg.setColor(this.les);
                }
                if (!(this.lew == -1 || this.lex == -1 || this.leA == this.leB || (((this.leA != this.kyN || this.kyO != this.ley) && (this.leB != this.kyN || this.kyO != this.lez)) || ((this.ley >= this.lez || this.kyO != this.ley || i3 >= this.lew) && ((this.ley >= this.lez || this.kyO != this.lez || i3 <= this.lex) && ((this.ley <= this.lez || this.kyO != this.ley || i3 <= this.lew) && (this.ley <= this.lez || this.kyO != this.lez || i3 >= this.lex))))))) {
                    this.leg.setColor(this.les);
                }
                if (this.lew != -1 && this.lex != -1 && this.leA == this.leB && this.kyN == this.leA && ((this.kyO > this.ley && this.kyO < this.lez && this.ley < this.lez) || (this.kyO < this.ley && this.kyO > this.lez && this.ley > this.lez))) {
                    this.leg.setColor(this.les);
                }
                if (!(this.lew == -1 || this.lex == -1 || this.leA == this.leB || ((this.leA >= this.leB || ((this.kyO <= this.ley || this.kyN != this.leA) && (this.kyO >= this.lez || this.kyN != this.leB))) && (this.leA <= this.leB || ((this.kyO >= this.ley || this.kyN != this.leA) && (this.kyO <= this.lez || this.kyN != this.leB)))))) {
                    this.leg.setColor(this.les);
                }
                if (!this.leN.booleanValue() && a(i3, this.leK) && this.leK.month == this.kyO && this.leK.year == this.kyN) {
                    this.leg.setColor(this.leq);
                    this.leg.setTypeface(Typeface.defaultFromStyle(2));
                }
                for (a aVar : this.laK) {
                    if (aVar.kCC == i3 && aVar.month == this.kyO && aVar.year == this.kyN) {
                        this.leg.setColor(this.ler);
                        this.leg.setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
                if ((this.kyO == this.ley && this.lew == i3 && this.leA == this.kyN) || ((this.kyO == this.lez && this.lex == i3 && this.leB == this.kyN) || (this.leu && this.leC == i3 && this.lew == -1))) {
                    this.leg.setTypeface(Typeface.defaultFromStyle(0));
                    this.leg.setColor(-1);
                }
                canvas.drawText(String.format("%d", new Object[]{Integer.valueOf(i3)}), (float) i4, (float) i2, this.leg);
                axY++;
                if (axY == this.leE) {
                    axY = 0;
                    i2 += this.leI;
                }
                i3++;
            } else {
                return;
            }
        }
    }

    protected final void onDraw(Canvas canvas) {
        int i = (((this.mWidth - (this.lee * 2)) / (this.leE * 2)) + this.lee) - (led / 2);
        int i2 = ((lec - led) / 2) + led;
        this.let.setLength(0);
        long timeInMillis = this.leL.getTimeInMillis();
        StringBuilder stringBuilder = new StringBuilder(DateUtils.formatDateRange(getContext(), timeInMillis, timeInMillis, 52).toLowerCase());
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
        canvas.drawText(stringBuilder.toString(), (float) i, (float) i2, this.lei);
        canvas.drawLine(0.0f, (float) lec, (float) this.mWidth, (float) (lec + 1), this.lei);
        e(canvas);
        f(canvas);
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), ((this.leI * this.leO) + lec) + this.leJ);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            a aVar;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i = this.lee;
            if (x < ((float) i) || x > ((float) (this.mWidth - this.lee))) {
                aVar = null;
            } else {
                int axY = ((((int) (((x - ((float) i)) * ((float) this.leE)) / ((float) ((this.mWidth - i) - this.lee)))) - axY()) + 1) + ((((int) (y - ((float) lec))) / this.leI) * this.leE);
                if (this.kyO > 11 || this.kyO < 0 || com.tencent.mm.plugin.chatroom.f.a.ci(this.kyO, this.kyN) < axY || axY <= 0) {
                    aVar = null;
                } else {
                    a aVar2 = new a(this.kyN, this.kyO, axY);
                    for (a aVar3 : this.laK) {
                        if (aVar3.equals(aVar2)) {
                            break;
                        }
                    }
                    aVar3 = null;
                }
            }
            if (!(aVar3 == null || this.leQ == null || (!this.leN.booleanValue() && aVar3.month == this.leK.month && aVar3.year == this.leK.year && aVar3.kCC < this.leK.monthDay))) {
                this.leQ.b(aVar3);
            }
        }
        return true;
    }

    public final void l(HashMap<String, Integer> hashMap) {
        int i = 0;
        if (hashMap.containsKey("month") || hashMap.containsKey("year")) {
            int i2;
            setTag(hashMap);
            if (hashMap.containsKey("height")) {
                this.leI = ((Integer) hashMap.get("height")).intValue();
                if (this.leI < lea) {
                    this.leI = lea;
                }
            }
            if (hashMap.containsKey("selected_begin_day")) {
                this.lew = ((Integer) hashMap.get("selected_begin_day")).intValue();
            }
            if (hashMap.containsKey("selected_last_day")) {
                this.lex = ((Integer) hashMap.get("selected_last_day")).intValue();
            }
            if (hashMap.containsKey("selected_begin_month")) {
                this.ley = ((Integer) hashMap.get("selected_begin_month")).intValue();
            }
            if (hashMap.containsKey("selected_last_month")) {
                this.lez = ((Integer) hashMap.get("selected_last_month")).intValue();
            }
            if (hashMap.containsKey("selected_begin_year")) {
                this.leA = ((Integer) hashMap.get("selected_begin_year")).intValue();
            }
            if (hashMap.containsKey("selected_last_year")) {
                this.leB = ((Integer) hashMap.get("selected_last_year")).intValue();
            }
            this.kyO = ((Integer) hashMap.get("month")).intValue();
            this.kyN = ((Integer) hashMap.get("year")).intValue();
            this.leu = false;
            this.leC = -1;
            this.leL.set(2, this.kyO);
            this.leL.set(1, this.kyN);
            this.leL.set(5, 1);
            this.leG = this.leL.get(7);
            if (hashMap.containsKey("week_start")) {
                this.leD = ((Integer) hashMap.get("week_start")).intValue();
            } else {
                this.leD = this.leL.getFirstDayOfWeek();
            }
            this.leF = com.tencent.mm.plugin.chatroom.f.a.ci(this.kyO, this.kyN);
            for (i2 = 0; i2 < this.leF; i2++) {
                boolean z;
                int i3 = i2 + 1;
                Time time = this.leK;
                if (this.kyN == time.year && this.kyO == time.month && i3 == time.monthDay) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.leu = true;
                    this.leC = i3;
                }
                this.lev = a(i3, this.leK);
            }
            i2 = axY();
            int i4 = (this.leF + i2) / this.leE;
            if ((i2 + this.leF) % this.leE > 0) {
                i = 1;
            }
            this.leO = i4 + i;
            return;
        }
        throw new InvalidParameterException("You must specify month and year for this view");
    }
}
