package com.tencent.mm.plugin.remittance.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;

class RemittanceBusiResultUI$2 implements Runnable {
    final /* synthetic */ RemittanceBusiResultUI pNo;
    final /* synthetic */ ImageView pNp;

    RemittanceBusiResultUI$2(RemittanceBusiResultUI remittanceBusiResultUI, ImageView imageView) {
        this.pNo = remittanceBusiResultUI;
        this.pNp = imageView;
    }

    public final void run() {
        ViewGroup viewGroup = (ViewGroup) this.pNo.findViewById(f.uwr);
        LayoutParams layoutParams = this.pNp.getLayoutParams();
        layoutParams.width = viewGroup.getWidth();
        layoutParams.height = viewGroup.getHeight();
        this.pNp.setLayoutParams(layoutParams);
    }
}
