package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.Map;

class ReadMailUI$a$1 implements Runnable {
    final /* synthetic */ Map puP;
    final /* synthetic */ a puQ;

    ReadMailUI$a$1(a aVar, Map map) {
        this.puQ = aVar;
        this.puP = map;
    }

    public final void run() {
        if (this.puQ.puG.ptU.equals(this.puQ.puG.pod)) {
            if (this.puQ.puG.pub.psU.size() == 0) {
                this.puQ.puG.pub.a(ReadMailUI.a(this.puP, ".Response.result.tolist", bh.getInt((String) this.puP.get(".Response.result.tolistlen"), 0)), true);
            }
            if (this.puQ.puG.pua.psU.size() == 0) {
                String[] b = ReadMailUI.a(this.puP, ".Response.result.cclist", bh.getInt((String) this.puP.get(".Response.result.cclistlen"), 0));
                LinearLayout e = this.puQ.puG.pue;
                int i = (b == null || b.length == 0) ? 8 : 0;
                e.setVisibility(i);
                this.puQ.puG.pua.a(b, true);
            }
            String str = (String) this.puP.get(".Response.result.content");
            ReadMailUI.a(this.puQ.puG, this.puP);
            String str2 = (String) this.puP.get(".Response.result.tips.wording");
            if (!bh.ov(str2)) {
                if ("1".equals((String) this.puP.get(".Response.result.tips.color"))) {
                    this.puQ.puG.ptY.setBackgroundColor(-13627);
                    this.puQ.puG.ptY.setTextColor(-7515315);
                }
                this.puQ.puG.ptY.setText(str2);
                ((View) this.puQ.puG.ptY.getParent()).setVisibility(0);
            }
            this.puQ.puG.ptV.loadDataWithBaseURL(p.bkn() + "?pageWidth=" + ReadMailUI.puB, "<html style=\"margin-top:" + ReadMailUI.puC + "px\">" + str + "</html>", "text/html", ProtocolPackage.ServerEncoding, null);
        }
    }
}
