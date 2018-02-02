package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bc.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout$a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class FTSSOSHomeWebViewUI$17 implements OnClickListener {
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;

    FTSSOSHomeWebViewUI$17(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.tDo = fTSSOSHomeWebViewUI;
    }

    public final void onClick(View view) {
        FTSMainUIHotWordLayout$a fTSMainUIHotWordLayout$a = (FTSMainUIHotWordLayout$a) view.getTag();
        switch (fTSMainUIHotWordLayout$a.fFn) {
            case 1:
                if (this.tDo.tCl) {
                    FTSSOSHomeWebViewUI.o(this.tDo);
                    FTSSOSHomeWebViewUI.e(this.tDo, 0);
                    this.tDo.bTy().clearText();
                    this.tDo.bTy().t(fTSMainUIHotWordLayout$a.zer, null);
                    this.tDo.bTy().cxd();
                    FTSSOSHomeWebViewUI.a(this.tDo).Dh(13);
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt(DownloadSettingTable$Columns.TYPE, 0);
                        bundle.putBoolean("isHomePage", true);
                        bundle.putInt("scene", 20);
                        bundle = FTSSOSHomeWebViewUI.p(this.tDo).o(4, bundle);
                        Map hashMap = new HashMap();
                        hashMap.put("sceneActionType", "2");
                        hashMap.put("recommendId", FTSSOSHomeWebViewUI.q(this.tDo).cxi());
                        FTSSOSHomeWebViewUI.t(this.tDo).post(new 1(this, bundle, hashMap));
                        break;
                    } catch (Exception e) {
                        break;
                    }
                }
                return;
            case 4:
                Intent intent = new Intent();
                intent.putExtra("rawUrl", fTSMainUIHotWordLayout$a.jumpUrl);
                intent.putExtra("convertActivityFromTranslucent", false);
                d.b(ac.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                break;
        }
        try {
            hashMap = new HashMap();
            hashMap.put("isclick", Integer.valueOf(1));
            hashMap.put("scene", Integer.valueOf(20));
            hashMap.put("recommendid", FTSSOSHomeWebViewUI.q(this.tDo).cxi());
            hashMap.put("businesstype", Integer.valueOf(0));
            hashMap.put("docid", fTSMainUIHotWordLayout$a.zer != null ? Uri.encode(fTSMainUIHotWordLayout$a.zer) : "");
            hashMap.put("docpos", Integer.valueOf(fTSMainUIHotWordLayout$a.zes + 1));
            hashMap.put("ishomepage", Integer.valueOf(1));
            hashMap.put("typepos", Integer.valueOf(1));
            hashMap.put("jumpurl", Uri.encode(fTSMainUIHotWordLayout$a.jumpUrl));
            String s = b.s(hashMap);
            bundle = new Bundle();
            bundle.putString("logString", s);
            FTSSOSHomeWebViewUI.u(this.tDo).e(131, bundle);
        } catch (Exception e2) {
            x.w("MicroMsg.FTS.FTSSOSHomeWebViewUI", "onHotwordCellClickListener cgi report fail for %s", new Object[]{e2.toString()});
        }
    }
}
