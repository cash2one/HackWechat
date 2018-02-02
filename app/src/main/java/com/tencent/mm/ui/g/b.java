package com.tencent.mm.ui.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.l;

public final class b extends q {
    public long mDuration = 3000;
    @SuppressLint({"HandlerLeak"})
    private af mHandler = new 1(this);

    private b(View view) {
        super(view);
    }

    public static b fZ(Context context) {
        View inflate = LayoutInflater.from(context).inflate(h.gYh, null);
        ((TextView) inflate.findViewById(g.gWS)).setVisibility(8);
        b bVar = new b(inflate);
        bVar.setFocusable(false);
        bVar.setContentView(inflate);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        bVar.setAnimationStyle(l.gYP);
        bVar.mDuration = 1200;
        return bVar;
    }

    public final void showAsDropDown(View view, int i, int i2) {
        super.showAsDropDown(view, i, i2);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    }

    public final void showAsDropDown(View view) {
        super.showAsDropDown(view);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    }

    public final void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        this.mHandler.removeMessages(256);
        this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    }
}
