package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.ViewGroup;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;

public abstract class MMSightRecordView$d {
    public abstract void R(float f);

    public abstract String Yb();

    public abstract void Yc();

    public abstract Point Ye();

    public abstract Point Yf();

    public abstract int Yj();

    public abstract void Yk();

    public abstract void Yl();

    public abstract Bitmap Ym();

    public abstract void a(MMSightRecordView$a mMSightRecordView$a);

    public abstract void a(c cVar);

    public abstract void a(e eVar, boolean z);

    public abstract void a(f fVar);

    public abstract void b(Context context, ViewGroup viewGroup);

    public abstract void ck(boolean z);

    public abstract void cl(boolean z);

    public abstract void cm(boolean z);

    public abstract void h(int i, int i2, int i3, int i4, int i5);

    public abstract void jp(int i);

    public abstract void jq(int i);

    public abstract void oP(String str);

    public abstract void release();

    public abstract void startPreview();

    public abstract void switchCamera();

    public abstract boolean vr();
}
