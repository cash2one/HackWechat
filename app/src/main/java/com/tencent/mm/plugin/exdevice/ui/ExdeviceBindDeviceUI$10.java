package com.tencent.mm.plugin.exdevice.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class ExdeviceBindDeviceUI$10 extends ClickableSpan {
    final /* synthetic */ ExdeviceBindDeviceUI lSF;

    ExdeviceBindDeviceUI$10(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
        this.lSF = exdeviceBindDeviceUI;
    }

    public final void onClick(View view) {
        this.lSF.finish();
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }
}
