package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bf.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.Serializable;

class OpenBottleUI$4 implements OnClickListener {
    final /* synthetic */ OpenBottleUI kDa;

    OpenBottleUI$4(OpenBottleUI openBottleUI) {
        this.kDa = openBottleUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        String substring = bh.ov(OpenBottleUI.e(this.kDa)) ? "" : OpenBottleUI.e(this.kDa).substring(0, OpenBottleUI.e(this.kDa).indexOf(58));
        String substring2 = bh.ov(OpenBottleUI.e(this.kDa)) ? "" : OpenBottleUI.e(this.kDa).substring(OpenBottleUI.e(this.kDa).indexOf(58) + 1);
        intent.putExtra("k_username", substring);
        Serializable mR = a.mR(OpenBottleUI.e(this.kDa));
        substring = "";
        if (mR.size() > 0) {
            substring = (String) mR.get(0);
        }
        mR.clear();
        mR.add(String.format("<exposecontent><bottleid>%s</bottleid><hellomsg>%s</hellomsg></exposecontent>", new Object[]{substring2, substring}));
        intent.putExtra("k_outside_expose_proof_item_list", mR);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(37)}));
        d.b(OpenBottleUI.b(this.kDa), "webview", ".ui.tools.WebViewUI", intent);
    }
}
