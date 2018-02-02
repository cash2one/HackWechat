package com.tencent.mm.plugin.qqmail.ui;

import android.widget.ImageView;
import com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.c;

class ComposeUI$c extends c {
    private ImageView prE;
    final /* synthetic */ ComposeUI prr;
    private int tag;

    public ComposeUI$c(ComposeUI composeUI, ImageView imageView, int i) {
        this.prr = composeUI;
        this.prE = imageView;
        this.tag = i;
    }

    public final void ho(boolean z) {
        ImageView imageView;
        int i = 0;
        ComposeUI.y(this.prr);
        if (this.prr.pqW) {
            imageView = this.prE;
        } else {
            imageView = this.prE;
            if (!z) {
                i = 4;
            }
        }
        imageView.setVisibility(i);
        if ((this.tag == 1 || this.tag == 2) && !z) {
            ComposeUI.z(this.prr).postDelayed(new 1(this), 10);
        }
    }
}
