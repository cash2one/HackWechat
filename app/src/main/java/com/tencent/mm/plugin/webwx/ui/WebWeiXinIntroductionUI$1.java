package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class WebWeiXinIntroductionUI$1 implements OnClickListener {
    final /* synthetic */ WebWeiXinIntroductionUI tOU;

    WebWeiXinIntroductionUI$1(WebWeiXinIntroductionUI webWeiXinIntroductionUI) {
        this.tOU = webWeiXinIntroductionUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
        intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
        intent.putExtra("from_album", false);
        intent.putExtra("show_intro", false);
        intent.setFlags(65536);
        d.b(this.tOU, "scanner", ".ui.BaseScanUI", intent);
    }
}
