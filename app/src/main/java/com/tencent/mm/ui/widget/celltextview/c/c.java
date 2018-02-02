package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.RectF;
import java.util.ArrayList;

public final class c {
    public ArrayList<d> zxi;
    public ArrayList<RectF> zxj;
    public float zxk;
    public float zxl;
    public int zxm;
    public int zxn;
    public float zxo;
    public float zxp;

    public final void a(d dVar, RectF rectF) {
        if (this.zxi == null) {
            this.zxi = new ArrayList(1);
        }
        if (this.zxj == null) {
            this.zxj = new ArrayList(1);
        }
        this.zxi.add(dVar);
        this.zxj.add(rectF);
        this.zxk = (rectF.width() < 0.0f ? 0.0f : rectF.width()) + this.zxk;
        if (dVar.getType() == 0) {
            this.zxl = (float) ((int) rectF.height());
        } else if (dVar.getType() == 2 && this.zxl == 0.0f) {
            this.zxl = (float) ((int) rectF.height());
        }
    }

    public final void fp(int i, int i2) {
        this.zxm = i;
        this.zxn = i2;
    }

    public final d Hf(int i) {
        if (i >= 0 && this.zxi != null) {
            return (d) this.zxi.get(i);
        }
        return null;
    }

    public final RectF Hg(int i) {
        if (i >= 0 && this.zxj != null) {
            return (RectF) this.zxj.get(i);
        }
        return null;
    }

    public final int getSize() {
        if (this.zxi == null || this.zxj == null) {
            return 0;
        }
        int size = this.zxi.size();
        int size2 = this.zxj.size();
        return size >= size2 ? size2 : size;
    }
}
