package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.List;

class OpenFileChooserUI$6 implements Runnable {
    final /* synthetic */ String gBF;
    final /* synthetic */ OpenFileChooserUI twU;

    OpenFileChooserUI$6(OpenFileChooserUI openFileChooserUI, String str) {
        this.twU = openFileChooserUI;
        this.gBF = str;
    }

    public final void run() {
        List arrayList = new ArrayList();
        int a = OpenFileChooserUI.a(this.twU, this.gBF);
        if (a == -50002) {
            ag.y(new 1(this));
            return;
        }
        String m;
        String d;
        if (a == -50006) {
            m = OpenFileChooserUI.m(this.gBF, arrayList);
            OpenFileChooserUI.b(this.twU, this.gBF);
            d = OpenFileChooserUI.d(this.twU);
        } else if (a == 1) {
            m = OpenFileChooserUI.c(this.twU, this.gBF);
            OpenFileChooserUI.b(this.twU, this.gBF);
            d = OpenFileChooserUI.d(this.twU);
            if (bh.ov(m) && OpenFileChooserUI.b(this.twU) == 7 && OpenFileChooserUI.c(this.twU) == 2) {
                ag.y(new 2(this));
                return;
            }
        } else {
            ag.y(new 3(this));
            return;
        }
        if (bh.ov(m)) {
            ag.y(new 5(this));
        } else {
            ag.y(new 4(this, m, d));
        }
    }
}
