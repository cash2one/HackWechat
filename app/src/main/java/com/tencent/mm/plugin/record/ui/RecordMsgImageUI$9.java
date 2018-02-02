package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.view.MenuItem;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.p.d;

class RecordMsgImageUI$9 implements d {
    final /* synthetic */ RecordMsgImageUI pGz;

    RecordMsgImageUI$9(RecordMsgImageUI recordMsgImageUI) {
        this.pGz = recordMsgImageUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        b cfVar;
        switch (menuItem.getItemId()) {
            case 0:
                RecordMsgImageUI.f(this.pGz);
                return;
            case 1:
                Activity activity = this.pGz;
                cfVar = new cf();
                f.a(cfVar, activity.getIntent().getIntExtra("key_favorite_source_type", 1), activity.bni());
                cfVar.fqp.fqw = 10;
                cfVar.fqp.activity = activity;
                a.xef.m(cfVar);
                return;
            case 2:
                RecordMsgImageUI.g(this.pGz);
                return;
            case 3:
                String h = RecordMsgImageUI.h(this.pGz);
                if (!bh.ov(h)) {
                    mr mrVar = (mr) RecordMsgImageUI.i(this.pGz).get(h);
                    if (mrVar != null) {
                        cfVar = new bz();
                        cfVar.fqa.activity = this.pGz;
                        cfVar.fqa.fov = mrVar.fED.result;
                        cfVar.fqa.fqb = mrVar.fED.fqb;
                        cfVar.fqa.fqd = 8;
                        RecordMsgImageUI.a(this.pGz, cfVar);
                        cfVar.fqa.fqc = mrVar.fED.fqc;
                        if (this.pGz.getIntent() != null) {
                            cfVar.fqa.fqh = this.pGz.getIntent().getBundleExtra("_stat_obj");
                        }
                        a.xef.m(cfVar);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
