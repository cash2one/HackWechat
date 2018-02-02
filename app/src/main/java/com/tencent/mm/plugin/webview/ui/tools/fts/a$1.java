package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

class a$1 implements Runnable {
    final /* synthetic */ View tEA;
    final /* synthetic */ a tEB;

    a$1(a aVar, View view) {
        this.tEB = aVar;
        this.tEA = view;
    }

    public final void run() {
        this.tEB.tEt[0][0] = this.tEA.getY();
        this.tEB.tEt[0][1] = 0.0f;
        this.tEB.tEt[1][0] = this.tEA.getX();
        this.tEB.tEt[1][1] = 0.0f;
        this.tEB.tEt[2][0] = (float) this.tEA.getMeasuredWidth();
        this.tEB.tEt[2][1] = (float) (this.tEA.getMeasuredWidth() + (this.tEB.tEh * 2));
        x.i("MicroMsg.FTS.SosAnimatorBaseController", "searchBarData %s", new Object[]{Arrays.toString(this.tEB.tEt)});
    }
}
