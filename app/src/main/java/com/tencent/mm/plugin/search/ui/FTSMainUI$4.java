package com.tencent.mm.plugin.search.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

class FTSMainUI$4 implements OnClickListener {
    final /* synthetic */ FTSMainUI qdk;

    FTSMainUI$4(FTSMainUI fTSMainUI) {
        this.qdk = fTSMainUI;
    }

    public final void onClick(View view) {
        int optInt;
        String charSequence;
        FTSMainUI fTSMainUI;
        try {
            if (view.getTag() != null) {
                optInt = ((JSONObject) view.getTag()).optInt("businessType");
                if (optInt == 0) {
                    charSequence = ((TextView) view).getText().toString();
                    if (charSequence.equals(this.qdk.getString(R.l.eIP))) {
                        optInt = 2;
                    } else if (charSequence.equals(this.qdk.getString(R.l.eIR))) {
                        optInt = 8;
                    } else if (charSequence.equals(this.qdk.getString(R.l.eIQ))) {
                        optInt = 1;
                    }
                }
                if (optInt != 0) {
                    fTSMainUI = this.qdk;
                    if (System.currentTimeMillis() - fTSMainUI.jzh > 1000) {
                        fTSMainUI.jzh = System.currentTimeMillis();
                        if (g.zM(0)) {
                            x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
                        }
                        com.tencent.mm.bc.g.b(optInt, 14, h.NU("searchID"));
                        x.i("MicroMsg.FTS.FTSMainUI", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", new Object[]{Integer.valueOf(optInt), r5});
                        fTSMainUI.aWs();
                        Intent QM = b.QM();
                        QM.putExtra("ftsneedkeyboard", true);
                        QM.putExtra("ftsbizscene", 14);
                        QM.putExtra("ftsType", optInt);
                        Map b = b.b(14, true, optInt);
                        b.put("sessionId", e.hKF);
                        b.put("subSessionId", e.hKF);
                        QM.putExtra("sessionId", e.hKF);
                        QM.putExtra("subSessionId", e.hKF);
                        QM.putExtra("rawUrl", b.r(b));
                        QM.putExtra("key_load_js_without_delay", true);
                        d.b(ac.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QM);
                        return;
                    }
                }
            }
        } catch (Exception e) {
        }
        optInt = 0;
        if (optInt == 0) {
            charSequence = ((TextView) view).getText().toString();
            if (charSequence.equals(this.qdk.getString(R.l.eIP))) {
                optInt = 2;
            } else if (charSequence.equals(this.qdk.getString(R.l.eIR))) {
                optInt = 8;
            } else if (charSequence.equals(this.qdk.getString(R.l.eIQ))) {
                optInt = 1;
            }
        }
        if (optInt != 0) {
            fTSMainUI = this.qdk;
            if (System.currentTimeMillis() - fTSMainUI.jzh > 1000) {
                fTSMainUI.jzh = System.currentTimeMillis();
                if (g.zM(0)) {
                    com.tencent.mm.bc.g.b(optInt, 14, h.NU("searchID"));
                    x.i("MicroMsg.FTS.FTSMainUI", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", new Object[]{Integer.valueOf(optInt), r5});
                    fTSMainUI.aWs();
                    Intent QM2 = b.QM();
                    QM2.putExtra("ftsneedkeyboard", true);
                    QM2.putExtra("ftsbizscene", 14);
                    QM2.putExtra("ftsType", optInt);
                    Map b2 = b.b(14, true, optInt);
                    b2.put("sessionId", e.hKF);
                    b2.put("subSessionId", e.hKF);
                    QM2.putExtra("sessionId", e.hKF);
                    QM2.putExtra("subSessionId", e.hKF);
                    QM2.putExtra("rawUrl", b.r(b2));
                    QM2.putExtra("key_load_js_without_delay", true);
                    d.b(ac.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QM2);
                    return;
                }
                x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
            }
        }
    }
}
