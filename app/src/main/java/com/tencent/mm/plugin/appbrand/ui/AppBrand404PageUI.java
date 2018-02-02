package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

@a(19)
public final class AppBrand404PageUI extends DrawStatusBarActivity {
    public static void show(int i) {
        ag.y(new 1(ac.getContext().getString(i), null));
    }

    protected final int getLayoutId() {
        return h.iwF;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getStatusBarColor(), false);
        setMMTitle(j.iyV);
        setBackBtn(new 2(this));
        TextView textView = (TextView) findViewById(g.itF);
        CharSequence stringExtra = getIntent().getStringExtra("key_wording");
        bh.ov(stringExtra);
        if (textView != null) {
            textView.setText(stringExtra);
        }
    }

    public final void finish() {
        super.finish();
    }

    protected final void onDestroy() {
        super.onDestroy();
    }
}
