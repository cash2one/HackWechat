package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.f.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI.2;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.a.c.a;

class SnsCommentUI$2$1 implements a {
    final /* synthetic */ 2 rBw;

    SnsCommentUI$2$1(2 2) {
        this.rBw = 2;
    }

    public final void uY(String str) {
        String trim = SnsCommentUI.b(this.rBw.rBv).getText().toString().trim();
        SnsCommentUI.b(this.rBw.rBv).setText("");
        if (trim.length() > 0) {
            switch (SnsCommentUI.a(this.rBw.rBv)) {
                case 0:
                    this.rBw.rBv.aWs();
                    SnsCommentUI.a(this.rBw.rBv, trim);
                    return;
                case 1:
                    this.rBw.rBv.aWs();
                    SnsCommentUI.b(this.rBw.rBv, trim);
                    return;
                case 2:
                    this.rBw.rBv.aWs();
                    long longExtra = this.rBw.rBv.getIntent().getLongExtra("sns_id", 0);
                    long longExtra2 = this.rBw.rBv.getIntent().getLongExtra("action_st_time", 0);
                    String az = bh.az(this.rBw.rBv.getIntent().getStringExtra("sns_uxinfo"), "");
                    trim = bh.az(this.rBw.rBv.getIntent().getStringExtra("sns_actionresult"), "") + "|4:1:" + trim;
                    long currentTimeMillis = System.currentTimeMillis();
                    h bwo = ae.bvn().bwo();
                    if (bwo != null && bwo.bwp()) {
                        String str2 = bwo.qZQ;
                        String str3 = bwo.qZP;
                        x.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + az + " actionresult: " + trim + " " + longExtra2 + " " + currentTimeMillis);
                        g.pQN.h(11988, new Object[]{str2, str3, "", "", i.eq(longExtra), az, trim, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000)});
                        SnsCommentUI.c(this.rBw.rBv);
                        this.rBw.rBv.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void amI() {
    }

    public final void aem() {
        com.tencent.mm.ui.base.h.h(this.rBw.rBv, j.qMH, j.qMI);
    }
}
