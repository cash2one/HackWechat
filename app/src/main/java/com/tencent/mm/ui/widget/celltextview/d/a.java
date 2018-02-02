package com.tencent.mm.ui.widget.celltextview.d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.celltextview.c.b;
import com.tencent.mm.ui.widget.celltextview.c.c;
import com.tencent.mm.ui.widget.celltextview.c.d;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.ui.widget.celltextview.b.a.a {
    private int KD;
    private int et;
    private int eu;
    private int iX;
    private TextPaint jZQ;
    private Context mContext;
    private float nxC;
    private int vqO;
    private int yg = WebView.NIGHT_MODE_COLOR;
    private int ygD;
    private ArrayList<d> zwT;
    private LinkedList<b> zwU;
    private ArrayList<c> zwZ;
    private CharSequence zxA;
    private int zxB;
    private int zxC;
    private int zxD;
    private int zxE;
    private int zxF = -16776961;
    private boolean zxG = true;
    private Drawable zxH;
    private int zxI;
    private LinkedList<a> zxJ;
    private LinkedList<a> zxK;
    private b zxL;
    int zxM = 0;
    private int zxN;
    private float zxa;
    private com.tencent.mm.ui.widget.celltextview.b.a.b zxt;
    private com.tencent.mm.ui.widget.celltextview.f.a zxu;
    private int zxv = Integer.MAX_VALUE;
    private int zxw;
    private int zxx;
    private float zxy;
    private boolean zxz = true;

    public final /* bridge */ /* synthetic */ Paint getPaint() {
        return this.jZQ;
    }

    public a(Context context, TextPaint textPaint) {
        this.mContext = context;
        this.zwZ = new ArrayList();
        this.zxu = new com.tencent.mm.ui.widget.celltextview.f.b();
        this.nxC = com.tencent.mm.ui.widget.celltextview.g.b.i(context, 14.0f);
        this.zxE = (int) com.tencent.mm.ui.widget.celltextview.g.b.i(context, 6.0f);
        this.jZQ = textPaint;
        this.jZQ.setColor(this.yg);
        this.jZQ.setTextSize(this.nxC);
    }

    public final void onMeasure(int i, int i2) {
        if (this.zxz) {
            Object obj;
            c cVar;
            float f;
            float f2;
            this.zxz = false;
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            if (size <= 0) {
                Context context = this.mContext;
                size = context == null ? 0 : context.getResources().getDisplayMetrics().widthPixels;
            }
            if (this.iX > 0 && this.iX < r2) {
                size = this.iX;
            }
            int i3 = (this.KD <= 0 || this.KD <= size) ? size : this.KD;
            size = (this.vqO <= 0 || this.vqO >= size2) ? size2 : this.vqO;
            int i4 = (this.zxw <= 0 || this.zxw <= size) ? size : this.zxw;
            int aC = aC(this.zxJ) + aC(this.zxK);
            int i5 = ((i3 - aC) - this.zxB) - this.zxC;
            if (this.zxG) {
                com.tencent.mm.ui.widget.celltextview.a.b czi = com.tencent.mm.ui.widget.celltextview.a.b.czi();
                ArrayList arrayList = this.zwT;
                CharSequence charSequence = this.zxA;
                com.tencent.mm.ui.widget.celltextview.a.a aVar = new com.tencent.mm.ui.widget.celltextview.a.a(charSequence == null ? "" : charSequence.toString(), this.nxC, (float) i5);
                aVar.am(arrayList);
                com.tencent.mm.ui.widget.celltextview.a.a aVar2 = (com.tencent.mm.ui.widget.celltextview.a.a) czi.zxd.get(aVar);
                if (aVar2 != null) {
                    ArrayList arrayList2 = this.zwT;
                    if (!(aVar2.zwT == null || arrayList2 == null)) {
                        arrayList2.clear();
                        arrayList2.addAll(aVar2.zwT);
                    }
                    arrayList2 = this.zwZ;
                    if (!(aVar2.zwZ == null || arrayList2 == null)) {
                        arrayList2.clear();
                        arrayList2.addAll(aVar2.zwZ);
                    }
                    obj = 1;
                    czs();
                } else {
                    obj = null;
                    Hi(i5);
                    com.tencent.mm.ui.widget.celltextview.a.b.czi().a(this.zxA, this.nxC, (float) i5, this.zwZ, this.zwT);
                }
            } else {
                obj = null;
                Hi(i5);
                com.tencent.mm.ui.widget.celltextview.a.b.czi().a(this.zxA, this.nxC, (float) i5, this.zwZ, this.zwT);
            }
            this.zxx = this.zwZ.size();
            if (obj == null) {
                float f3 = (float) i5;
                float b = this.zxu.b(this.jZQ);
                Iterator it = this.zwZ.iterator();
                size2 = -1;
                while (it.hasNext()) {
                    cVar = (c) it.next();
                    size2++;
                    int size3 = cVar.getSize();
                    RectF Hg = cVar.Hg(size3 - 1);
                    float f4 = f3 - (Hg == null ? 0.0f : Hg.right);
                    if (f4 != 0.0f && Math.abs(f4) <= b) {
                        int i6;
                        int i7 = -1;
                        for (i6 = 0; i6 < size3; i6++) {
                            d Hf = cVar.Hf(i6);
                            i7 = Hf.getType() == 2 ? i7 + 1 : i7 + Hf.getLength();
                        }
                        f = i7 == 0 ? 0.0f : f4 / ((float) i7);
                        int i8 = 0;
                        f4 = 0.0f;
                        while (i8 < size3) {
                            RectF Hg2 = cVar.Hg(i8);
                            d Hf2 = cVar.Hf(i8);
                            i6 = Hf2.getLength();
                            if (Hf2.getType() == 2) {
                                i6 = 1;
                            }
                            float width = Hg2.width();
                            Hg2.left = f4;
                            Hg2.right = (((float) i6) * f) + (width + f4);
                            i8++;
                            f4 = Hg2.width() + f4;
                        }
                        cVar.zxk = f4;
                        cVar.zxo = f;
                        String str = "CellLayout";
                        String str2 = "[adaptLetterSpacing] line:%s size:%s letterSpacing:%s textSize:%s lineRight:%s";
                        Object[] objArr = new Object[5];
                        objArr[0] = Integer.valueOf(size2);
                        objArr[1] = Integer.valueOf(size3);
                        objArr[2] = Float.valueOf(f);
                        objArr[3] = Float.valueOf(b);
                        objArr[4] = Float.valueOf(Hg == null ? 0.0f : Hg.right);
                        x.i(str, str2, objArr);
                    }
                }
                czs();
            }
            f = (float) i5;
            float czp = (float) czp();
            Iterator it2 = this.zwZ.iterator();
            float f5 = 0.0f;
            while (it2.hasNext()) {
                cVar = (c) it2.next();
                if (cVar.zxk > f5) {
                    x.i("CellLayout", "[getEdgeWidth] MeasuredLine:%s", new Object[]{Float.valueOf(cVar.zxk)});
                    f2 = cVar.zxk;
                } else {
                    f2 = f5;
                }
                f5 = f2;
            }
            if (mode == 1073741824) {
                this.zxa = (float) i3;
                f2 = f;
            } else {
                f2 = Math.min((float) i5, f5);
                this.zxa = ((((float) this.zxB) + f2) + ((float) this.zxC)) + ((float) aC);
            }
            if (mode2 == 1073741824) {
                this.zxy = (float) i4;
            } else {
                this.zxy = Math.max((float) this.zxI, ((float) (this.et + this.eu)) + czp);
            }
            this.zxa = Math.max(this.zxa, (float) this.KD);
            this.zxy = Math.max(this.zxy, (float) this.zxw);
            if (this.iX > 0) {
                this.zxa = Math.min(this.zxa, (float) this.iX);
            }
            if (this.vqO > 0) {
                this.zxy = Math.min(this.zxy, (float) this.vqO);
            }
            x.i("CellLayout", String.format("[measureImpl] adaptWidth:%s mMeasuredWidth:%s mMeasuredHeight:%s", new Object[]{Float.valueOf(f2), Float.valueOf(this.zxa), Float.valueOf(this.zxy)}));
        }
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        float czp = (float) czp();
        if (this.zxD == 80) {
            canvas.translate((float) aC(this.zxJ), this.zxy - czp);
        } else if (this.zxD == 3) {
            canvas.translate((float) (this.zxB + aC(this.zxJ)), (this.zxy - czp) / 2.0f);
        } else if (this.zxD == 16) {
            canvas.translate((float) (this.zxB + aC(this.zxJ)), (this.zxy - czp) / 2.0f);
        }
        if (this.zxL != null) {
            b bVar = this.zxL;
            Iterator it = bVar.zxh.iterator();
            while (it.hasNext()) {
                RectF rectF = (RectF) it.next();
                canvas.save();
                canvas.clipRect(rectF);
                canvas.drawColor(bVar.jjf);
                canvas.restore();
            }
        }
        int size = this.zwZ.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) this.zwZ.get(i);
            int size2 = cVar.getSize();
            canvas.save();
            if (this.zxD == 1 || this.zxD == 17) {
                float f = (this.zxa - cVar.zxk) / 2.0f;
                cVar.zxp = f;
                canvas.translate(f, 0.0f);
            }
            for (int i2 = 0; i2 < size2; i2++) {
                cVar.Hf(i2).a(canvas, cVar.Hg(i2), cVar.zxo, this.zxu.b(this.jZQ));
            }
            canvas.restore();
        }
        canvas.restore();
    }

    public final void requestLayout() {
        this.zxz = true;
    }

    public final void setTextColor(int i) {
        this.yg = i;
        this.jZQ.setColor(i);
    }

    public final void Hb(int i) {
        this.zxv = i;
    }

    public final void setTextSize(float f) {
        this.nxC = f;
        this.jZQ.setTextSize(f);
    }

    public final void setMaxWidth(int i) {
        this.iX = i;
    }

    public final void setMaxHeight(int i) {
        this.vqO = i;
    }

    public final void setMinWidth(int i) {
        this.KD = i;
    }

    public final void a(ArrayList<d> arrayList, CharSequence charSequence) {
        this.zwT = arrayList;
        this.zxA = charSequence;
    }

    public final void a(b bVar) {
        this.zxL = bVar;
    }

    public final List<b> czj() {
        return this.zwU;
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        this.zxB = i;
        this.et = i2;
        this.eu = i4;
        this.zxC = i3;
        if (this.zxH != null) {
            Rect rect = new Rect();
            this.zxH.getPadding(rect);
            x.i("CellLayout", "[setPadding] drawableRect:%s", new Object[]{rect});
            this.zxB = rect.left;
            this.zxC = rect.right;
            this.et = rect.top;
            this.eu = rect.bottom;
            this.KD = this.zxH.getMinimumWidth();
            this.zxw = this.zxH.getMinimumHeight();
        }
    }

    public final void Hc(int i) {
        this.zxD = i;
    }

    public final void Hd(int i) {
        this.zxE = i;
    }

    public final void setMinHeight(int i) {
        this.zxw = i;
    }

    public final void He(int i) {
        this.zxF = i;
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.zxH = drawable;
    }

    public final String czk() {
        if (this.zwT == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.zwT.iterator();
        while (it.hasNext()) {
            String text = ((d) it.next()).getText();
            if (text != null) {
                stringBuilder.append(text);
            }
        }
        return stringBuilder.toString();
    }

    public final String getText() {
        if (this.zxA == null) {
            return "";
        }
        return this.zxA.toString();
    }

    public final int getMaxLines() {
        return this.zxv;
    }

    public final float getTextSize() {
        return this.nxC;
    }

    public final int getMeasuredWidth() {
        return (int) this.zxa;
    }

    public final int getMeasuredHeight() {
        return (int) this.zxy;
    }

    public final int getPaddingLeft() {
        return this.zxB;
    }

    public final int getPaddingRight() {
        return this.zxC;
    }

    public final int getPaddingTop() {
        return this.et;
    }

    public final int getPaddingBottom() {
        return this.eu;
    }

    private void Hi(int i) {
        if (this.zwT != null && this.zwT.size() != 0) {
            Object obj;
            this.zwZ.clear();
            c czq = czq();
            int i2 = 0;
            loop0:
            while (i2 < this.zwT.size()) {
                d dVar = (d) this.zwT.get(i2);
                dVar.czo();
                c cVar = czq;
                d dVar2 = dVar;
                while (dVar2 != null && !TextUtils.isEmpty(dVar2.getText())) {
                    if (this.zxv > 0 && this.zxv < this.zwZ.size()) {
                        obj = 1;
                        break loop0;
                    }
                    d dVar3;
                    com.tencent.mm.ui.widget.celltextview.c.a a = this.zxu.a(dVar2, this.jZQ, i - this.zxN, i, i2 < this.zwT.size() + -1);
                    this.zxu.b(this.jZQ);
                    int i3 = a.zxf;
                    float f = a.width;
                    if (i3 > 0) {
                        d.czl();
                        d czn = dVar2.czn();
                        czn.v(0, i3, null);
                        float f2 = 0.0f;
                        for (int i4 = 0; i4 < this.zwZ.size() - 1; i4++) {
                            f2 += ((c) this.zwZ.get(i4)).zxl;
                        }
                        cVar.a(czn, new RectF((float) this.zxN, f2, ((float) this.zxN) + f, czn.Hh(this.zxE) + f2));
                        this.zxN = (int) (((float) this.zxN) + f);
                        if (i3 >= dVar2.getLength()) {
                            dVar3 = null;
                        } else {
                            dVar3 = dVar2.czn();
                            dVar3.v(i3, -1, null);
                        }
                    } else if (this.zxM == 0) {
                        x.e("CellLayout", "lastBreakAt == 0 and nowBreakAt == 0");
                        throw new Exception("lastBreakAt == 0 and nowBreakAt == 0");
                    } else {
                        dVar3 = dVar2;
                    }
                    this.zxM = i3;
                    if (dVar3 != null || (dv(dVar.getText(), dVar.getText().length() - 1) != '\n' && (i2 + 1 >= this.zwT.size() || i - this.zxN > 0))) {
                        if (dVar3 != null) {
                            cVar = czq();
                        }
                        dVar2 = dVar3;
                    } else {
                        cVar = czq();
                        dVar2 = dVar3;
                    }
                }
                i2++;
                czq = cVar;
            }
            czr();
            obj = null;
            if (obj != null) {
                Hj(i);
            }
        }
    }

    private int czp() {
        Iterator it = this.zwZ.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = (int) (((c) it.next()).zxl + ((float) i));
        }
        return i;
    }

    private void Hj(int i) {
        d dVar;
        Object obj;
        if (this.zwZ.size() < 2) {
            czq();
        }
        c cVar = (c) this.zwZ.get(this.zwZ.size() - 2);
        float measureText = this.jZQ.measureText("...", 0, 3);
        this.zxN = 0;
        int size = cVar.getSize();
        int i2 = 0;
        while (i2 < size) {
            d Hf = cVar.Hf(i2);
            int i3 = (int) ((((float) i) - measureText) - ((float) this.zxN));
            RectF rectF;
            if (i3 > 0) {
                com.tencent.mm.ui.widget.celltextview.c.a a = this.zxu.a(Hf, this.jZQ, i3, i, i2 < size + -1);
                int i4 = a.zxf;
                float width = cVar.Hg(i2).width();
                if (width <= ((float) i3)) {
                    this.zxN = (int) (((float) this.zxN) + width);
                    i2++;
                } else {
                    d.czl();
                    if (dv(Hf.getText(), i4 - 1) == '\n') {
                        i4--;
                    }
                    Hf.v(0, i4, "...");
                    int i5 = i2 + 1;
                    if (cVar.zxi != null) {
                        int size2 = cVar.zxi.size();
                        if (i5 < size2) {
                            for (i3 = 0; i3 < size2 - i5; i3++) {
                                cVar.zxi.remove((size2 - i3) - 1);
                                rectF = (RectF) cVar.zxj.remove((size2 - i3) - 1);
                                if (rectF != null) {
                                    cVar.zxk -= rectF.width();
                                    if (cVar.zxl >= rectF.height()) {
                                        cVar.zxl = 0.0f;
                                        Iterator it = cVar.zxi.iterator();
                                        int i6 = 0;
                                        while (it.hasNext()) {
                                            dVar = (d) it.next();
                                            RectF rectF2 = (RectF) cVar.zxj.get(i6);
                                            if (dVar.getType() == 0) {
                                                cVar.zxl = (float) ((int) rectF2.height());
                                            } else if (dVar.getType() == 2 && cVar.zxl == 0.0f) {
                                                cVar.zxl = (float) ((int) rectF2.height());
                                            }
                                            i6++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.zxN = (int) (((float) this.zxN) + a.width);
                    obj = 1;
                    this.zxN += (int) measureText;
                    if (this.zwZ.size() == 2 && r1 == null && ((c) this.zwZ.get(1)).Hf(0) == null) {
                        dVar = cVar.Hf(cVar.getSize() - 1);
                        if (dVar != null) {
                            d.czl();
                            dVar.v(0, -1, "...");
                            obj = 1;
                        }
                    }
                    this.zxa = ((float) this.zxN) <= this.zxa ? (float) this.zxN : this.zxa;
                    if (obj == null) {
                        rectF = new RectF(cVar.Hg(cVar.getSize() - 1));
                        Hf = cVar.Hf(cVar.getSize() - 1);
                        d.czl();
                        if (Hf.getText().endsWith("\n")) {
                            Hf.v(0, Hf.getText().length() - 1, null);
                        }
                        rectF.left = rectF.right;
                        rectF.right = (float) this.zxN;
                        cVar.a(new d(this.jZQ, "...", this.nxC), rectF);
                    }
                }
            }
            return;
        }
        obj = null;
        this.zxN += (int) measureText;
        dVar = cVar.Hf(cVar.getSize() - 1);
        if (dVar != null) {
            d.czl();
            dVar.v(0, -1, "...");
            obj = 1;
        }
        if (((float) this.zxN) <= this.zxa) {
        }
        this.zxa = ((float) this.zxN) <= this.zxa ? (float) this.zxN : this.zxa;
        if (obj == null) {
            rectF = new RectF(cVar.Hg(cVar.getSize() - 1));
            Hf = cVar.Hf(cVar.getSize() - 1);
            d.czl();
            if (Hf.getText().endsWith("\n")) {
                Hf.v(0, Hf.getText().length() - 1, null);
            }
            rectF.left = rectF.right;
            rectF.right = (float) this.zxN;
            cVar.a(new d(this.jZQ, "...", this.nxC), rectF);
        }
    }

    private c czq() {
        czr();
        this.zxN = 0;
        c cVar = new c();
        cVar.zxl = 0.0f;
        this.zwZ.add(cVar);
        return cVar;
    }

    private void czr() {
        int size = this.zwZ.size() - 1;
        if (size >= 0) {
            int i;
            c cVar = (c) this.zwZ.get(size);
            int i2 = 0;
            for (i = 0; i < cVar.getSize(); i++) {
                i2 += cVar.Hf(i).getLength();
            }
            if (size == 0) {
                cVar.fp(0, i2);
                return;
            }
            i = ((c) this.zwZ.get(size - 1)).zxn;
            cVar.fp(i, i + i2);
        }
    }

    private void czs() {
        if (this.zwU != null) {
            Iterator it = this.zwU.iterator();
            while (it.hasNext()) {
                c cVar;
                b bVar = (b) it.next();
                int i = bVar.Ww;
                int i2 = bVar.wq;
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                Iterator it2 = this.zwZ.iterator();
                while (it2.hasNext()) {
                    cVar = (c) it2.next();
                    if (cVar.zxm <= i && i <= cVar.zxn) {
                        if (cVar.zxm <= i2 && i2 <= cVar.zxn) {
                            linkedList.add(cVar);
                            break;
                        }
                        linkedList.add(cVar);
                    } else if (cVar.zxm <= i2 && i2 <= cVar.zxn) {
                        linkedList.add(cVar);
                        break;
                    } else if (linkedList.size() > 0) {
                        linkedList.add(cVar);
                    }
                }
                Iterator it3 = linkedList.iterator();
                while (it3.hasNext()) {
                    cVar = (c) it3.next();
                    x.i("CellLayout", "[getLineIndex] line:[%s:%s]", new Object[]{Integer.valueOf(cVar.zxm), Integer.valueOf(cVar.zxn)});
                    int i3 = cVar.zxm;
                    float f = -1.0f;
                    float f2 = -1.0f;
                    for (int i4 = 0; i4 < cVar.getSize(); i4++) {
                        int length = cVar.Hf(i4).getLength();
                        if (i3 <= i && i <= i3 + length) {
                            f = (float) ((int) (cVar.Hg(i4).left + cVar.Hf(i4).l(i - i3, cVar.zxo)));
                        }
                        if (i3 <= i2 && i2 < i3 + length) {
                            f2 = (float) ((int) (cVar.Hg(i4).left + cVar.Hf(i4).l(i2 - i3, cVar.zxo)));
                        }
                        i3 += length;
                    }
                    if (f >= 0.0f && r3 < 0.0f) {
                        f2 = cVar.zxk;
                    } else if (f < 0.0f && r3 >= 0.0f) {
                        f = 0.0f;
                    } else if (f < 0.0f && r3 < 0.0f) {
                        f = 0.0f;
                        f2 = cVar.zxk;
                    }
                    if (f >= 0.0f && f2 >= 0.0f && f < f2) {
                        x.i("CellLayout", "[getLineIndex] rect:[%s:%s]", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
                        linkedList2.add(new RectF(f, cVar.Hg(0).top, f2, cVar.Hg(0).bottom));
                    }
                }
                bVar.zxh = linkedList2;
            }
        }
    }

    private static char dv(String str, int i) {
        if (i < 0 || str == null || i >= str.length()) {
            return '\u0000';
        }
        return str.charAt(i);
    }

    private int aC(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.isEmpty()) {
            return 0;
        }
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = (((a) it.next()).zxP.width() + this.ygD) + i;
        }
        return i;
    }
}
