package com.tencent.mm.plugin.game.gamewebview.e;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.a.a.a.a.b;

class b$3 extends b {
    final /* synthetic */ b naI;

    b$3(b bVar) {
        this.naI = bVar;
    }

    public final Object onMiscCallBack(String str, Bundle bundle) {
        boolean z = false;
        String str2 = "MicroMsg.GameWebView";
        String str3 = "method = %s, bundler == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (bundle == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        if (str.equals("getShareUrl") && b.j(this.naI) != null) {
            return b.j(this.naI).RI();
        }
        if (b.k(this.naI) != null) {
            return b.k(this.naI).onMiscCallBack(str, bundle);
        }
        return null;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
        return b.l(this.naI).z(motionEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        return b.l(this.naI).B(motionEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        return b.l(this.naI).A(motionEvent);
    }

    public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        return b.l(this.naI).a(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        b.l(this.naI).onScrollChanged(i, i2, i3, i4, view);
    }

    public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        b.l(this.naI).b(i, i2, z, z2);
    }

    public final void computeScroll(View view) {
        b.l(this.naI).naI.cyX();
    }
}
