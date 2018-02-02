package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;

class IPCallShareCouponUI$5 extends ClickableSpan {
    final /* synthetic */ IPCallShareCouponUI nMZ;

    IPCallShareCouponUI$5(IPCallShareCouponUI iPCallShareCouponUI) {
        this.nMZ = iPCallShareCouponUI;
    }

    public final void onClick(View view) {
        ((TextView) view).setHighlightColor(this.nMZ.getResources().getColor(R.e.transparent));
        String str = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice";
        String eL = w.eL(ac.getContext());
        if (!bh.ov(eL)) {
            str = str + "&wechat_real_lang=" + eL;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this.nMZ, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.nMZ.getResources().getColor(R.e.btd));
        textPaint.setUnderlineText(false);
    }
}
