package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.neattextview.textview.layout.c;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class b<T extends CharacterStyle> implements Serializable {
    private int Ww;
    private int wq;
    protected LinkedList<RectF> zKq;
    public CharacterStyle zKr;

    public abstract void a(Canvas canvas, TextPaint textPaint, List<c> list);

    b(int i, int i2, CharacterStyle characterStyle) {
        this.Ww = i;
        this.wq = i2;
        this.zKr = characterStyle;
    }

    final void dE(List<c> list) {
        if (this.zKq == null) {
            this.zKq = new LinkedList();
            for (c cVar : list) {
                if (cVar.Ww <= this.Ww && this.wq < cVar.wq) {
                    this.zKq.add(cVar.fy(this.Ww, this.wq));
                    return;
                } else if (cVar.Ww <= this.Ww && this.Ww < cVar.wq && cVar.wq <= this.wq) {
                    this.zKq.add(cVar.fy(this.Ww, cVar.wq));
                } else if (this.Ww < cVar.Ww && this.wq < cVar.wq && this.wq >= cVar.Ww) {
                    this.zKq.add(cVar.fy(cVar.Ww, this.wq));
                    return;
                } else if (this.Ww < cVar.Ww && this.wq >= cVar.wq) {
                    this.zKq.add(cVar.fy(cVar.Ww, cVar.wq));
                }
            }
        }
    }

    public final boolean L(float f, float f2) {
        if (this.zKq == null) {
            return false;
        }
        Iterator it = this.zKq.iterator();
        while (it.hasNext()) {
            if (((RectF) it.next()).contains(f, f2)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (bVar.Ww != this.Ww || bVar.wq != this.wq) {
            return false;
        }
        for (int i = 0; i < this.zKq.size(); i++) {
            if (!((RectF) this.zKq.get(i)).equals((RectF) bVar.zKq.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.zKq.size(); i2++) {
            i += ((RectF) this.zKq.get(i2)).hashCode();
        }
        return (this.Ww + this.wq) + i;
    }

    public String toString() {
        return "CharacterBgStyle{mRectFList=" + this.zKq + ", mStart=" + this.Ww + ", mEnd=" + this.wq + '}';
    }
}
