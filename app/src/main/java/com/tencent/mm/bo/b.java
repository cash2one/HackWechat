package com.tencent.mm.bo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mm.api.e;
import com.tencent.mm.api.i;
import com.tencent.mm.api.j;
import com.tencent.mm.api.l;
import com.tencent.mm.api.m;
import com.tencent.mm.cache.d;
import com.tencent.mm.d.a;

public interface b {
    boolean H(MotionEvent motionEvent);

    d a(a aVar);

    void a(Editable editable, int i);

    void a(e eVar);

    void a(j jVar, boolean z);

    void a(m.a aVar);

    void a(com.tencent.mm.view.a aVar);

    void aA(boolean z);

    <T extends com.tencent.mm.d.b> T b(com.tencent.mm.api.d dVar);

    void c(i iVar);

    com.tencent.mm.api.d[] cde();

    l cdf();

    void cdg();

    com.tencent.mm.view.a cdh();

    m.a cdi();

    <T extends com.tencent.mm.d.b> T cdj();

    float cdk();

    float cdl();

    Bitmap cdm();

    boolean cdn();

    Context getContext();

    void onAttachedToWindow();

    void onDestroy();

    void onDraw(Canvas canvas);

    void onFinish();

    boolean sS();

    void sW();
}
