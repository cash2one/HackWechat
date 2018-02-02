package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class MMSightRecordView extends FrameLayout {
    public static b oqY;
    public d oqX;

    public interface f {
        void cJ(boolean z);
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MMSightRecordView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.oqX = oqY.Ya();
        this.oqX.b(context, this);
    }

    public final void R(float f) {
        this.oqX.R(f);
    }

    public final void jp(int i) {
        this.oqX.jp(i);
    }

    public final void sK(int i) {
        this.oqX.h(i, 4800000, 30, 64000, 44100);
    }

    public final void oP(String str) {
        this.oqX.oP(str);
    }

    public final void a(f fVar) {
        this.oqX.a(fVar);
    }

    public final void a(e eVar, boolean z) {
        this.oqX.a(eVar, z);
    }

    public final void a(a aVar) {
        this.oqX.a(aVar);
    }

    public final void aZR() {
        this.oqX.cl(true);
    }

    public final void aZS() {
        this.oqX.cm(true);
    }

    public final void jq(int i) {
        this.oqX.jq(i);
    }
}
