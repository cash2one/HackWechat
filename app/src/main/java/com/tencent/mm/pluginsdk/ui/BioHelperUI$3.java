package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

class BioHelperUI$3 implements OnClickListener {
    final /* synthetic */ BioHelperUI vjs;

    BioHelperUI$3(BioHelperUI bioHelperUI) {
        this.vjs = bioHelperUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", new StringBuilder(BioHelperUI.b(this.vjs)).toString());
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        d.b(this.vjs, "webview", ".ui.tools.WebViewUI", intent);
        this.vjs.finish();
    }
}
