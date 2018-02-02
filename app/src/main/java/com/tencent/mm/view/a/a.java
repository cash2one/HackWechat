package com.tencent.mm.view.a;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class a extends BaseAdapter {
    public int kFr;
    public Context mContext;
    public int nrU;
    public int zDl;
    public int zDn;
    public com.tencent.mm.view.f.a zDu;
    public int zEl;
    public int zEm;
    public String zEn;
    public int zEo;

    public a(Context context, com.tencent.mm.view.f.a aVar) {
        this.mContext = context;
        this.zDu = aVar;
    }

    public final void c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zDl = i;
        this.kFr = i2;
        this.zEl = i3;
        this.zDn = i4;
        this.zEm = i5;
        this.zEo = i6;
        this.nrU = i7;
    }
}
