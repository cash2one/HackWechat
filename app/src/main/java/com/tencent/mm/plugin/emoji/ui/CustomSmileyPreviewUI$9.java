package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.sdk.platformtools.bh;

class CustomSmileyPreviewUI$9 implements Runnable {
    final /* synthetic */ CustomSmileyPreviewUI lBm;

    CustomSmileyPreviewUI$9(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.lBm = customSmileyPreviewUI;
    }

    public final void run() {
        if (CustomSmileyPreviewUI.h(this.lBm) != null && CustomSmileyPreviewUI.h(this.lBm).wkz != null) {
            CustomSmileyPreviewUI.i(this.lBm).setVisibility(0);
            CustomSmileyPreviewUI.j(this.lBm).setText(CustomSmileyPreviewUI.h(this.lBm).wkz.nfp);
            if (bh.ov(CustomSmileyPreviewUI.h(this.lBm).wkz.nfT)) {
                CustomSmileyPreviewUI.k(this.lBm).setVisibility(8);
            } else {
                CustomSmileyPreviewUI.k(this.lBm).setVisibility(0);
                o.PA().a(CustomSmileyPreviewUI.h(this.lBm).wkz.nfT, CustomSmileyPreviewUI.k(this.lBm), f.ci(CustomSmileyPreviewUI.b(this.lBm).field_groupId, CustomSmileyPreviewUI.h(this.lBm).wkz.nfT));
            }
            CustomSmileyPreviewUI.l(this.lBm).setText(R.l.dZu);
            CustomSmileyPreviewUI.i(this.lBm).setOnClickListener(new 1(this));
            CustomSmileyPreviewUI.m(this.lBm).setVisibility(8);
        } else if (CustomSmileyPreviewUI.g(this.lBm) == null || CustomSmileyPreviewUI.g(this.lBm).wkv == null) {
            CustomSmileyPreviewUI.i(this.lBm).setVisibility(8);
        } else {
            CustomSmileyPreviewUI.i(this.lBm).setVisibility(0);
            CustomSmileyPreviewUI.j(this.lBm).setText(CustomSmileyPreviewUI.g(this.lBm).wkv.nfp);
            o.PA().a(CustomSmileyPreviewUI.g(this.lBm).wkv.waN, CustomSmileyPreviewUI.k(this.lBm), f.ch(CustomSmileyPreviewUI.b(this.lBm).field_groupId, CustomSmileyPreviewUI.g(this.lBm).wkv.waN));
            CustomSmileyPreviewUI.m(this.lBm).setVisibility(8);
        }
    }
}
