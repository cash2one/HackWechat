package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class a {
    View mView = null;
    TextView tgs = null;
    FrameLayout tgt = null;
    PatternLockView tgu = null;
    TextView tgv = null;

    public a(Activity activity) {
        this.mView = View.inflate(activity, e.ten, null);
        this.tgs = (TextView) this.mView.findViewById(d.dtk);
        this.tgt = (FrameLayout) this.mView.findViewById(d.tej);
        this.tgu = (PatternLockView) this.mView.findViewById(d.tei);
        this.tgv = (TextView) this.mView.findViewById(d.tel);
    }
}
