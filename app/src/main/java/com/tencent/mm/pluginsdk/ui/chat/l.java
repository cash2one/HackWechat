package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class l implements OnClickListener {
    private Context context;

    public l(Context context) {
        this.context = context;
    }

    public final void onClick(View view) {
        boolean z = true;
        Object tag = view.getTag();
        b qvVar;
        if (tag instanceof b) {
            String f;
            b bVar = (b) tag;
            if (bVar == null || view == null) {
                x.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
            } else {
                Intent intent;
                if ("wx7fa037cc7dfabad5".equals(bVar.appId)) {
                    d.pY(33);
                    ar.Hg();
                    if (a.fZ(c.EY().WO("gh_43f2581f6fd6").field_type)) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        com.tencent.mm.bm.d.a(this.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                        com.tencent.mm.bm.d.b(this.context, "profile", ".ui.ContactInfoUI", intent);
                    }
                } else if ("wx485a97c844086dc9".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_music", true);
                    com.tencent.mm.bm.d.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                } else if ("wxfbc915ff7c30e335".equals(bVar.appId)) {
                    if (!com.tencent.mm.ar.b.PS()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 1);
                        if (!(com.tencent.mm.p.a.aV(this.context) || com.tencent.mm.au.a.Qj())) {
                            com.tencent.mm.bm.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx482a4001c37e2b74".equals(bVar.appId)) {
                    if (!com.tencent.mm.ar.b.PS()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 2);
                        if (!(com.tencent.mm.p.a.aV(this.context) || com.tencent.mm.au.a.Qj())) {
                            com.tencent.mm.bm.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx751a1acca5688ba3".equals(bVar.appId)) {
                    if (!com.tencent.mm.ar.b.PS()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 5);
                        if (!(com.tencent.mm.p.a.aV(this.context) || com.tencent.mm.au.a.Qj())) {
                            com.tencent.mm.bm.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wxaf060266bfa9a35c".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    com.tencent.mm.bm.d.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                }
                if (!z) {
                    f = p.f(this.context, bVar.appId, bVar.fEL);
                    qvVar = new qv();
                    qvVar.fIF.fIG = f;
                    qvVar.fIF.context = this.context;
                    com.tencent.mm.sdk.b.a.xef.m(qvVar);
                }
            }
            z = false;
            if (!z) {
                f = p.f(this.context, bVar.appId, bVar.fEL);
                qvVar = new qv();
                qvVar.fIF.fIG = f;
                qvVar.fIF.context = this.context;
                com.tencent.mm.sdk.b.a.xef.m(qvVar);
            }
        } else if (tag instanceof a) {
            a aVar = (a) tag;
            qvVar = new gm();
            qvVar.fwC.actionCode = 2;
            qvVar.fwC.scene = aVar.scene;
            qvVar.fwC.extMsg = "chatting_src=" + aVar.scene;
            qvVar.fwC.appId = aVar.appId;
            qvVar.fwC.context = this.context;
            com.tencent.mm.sdk.b.a.xef.m(qvVar);
            qvVar = new nh();
            qvVar.fFl.context = this.context;
            qvVar.fFl.scene = aVar.scene;
            qvVar.fFl.fFm = aVar.appId;
            qvVar.fFl.packageName = aVar.ffw;
            qvVar.fFl.msgType = aVar.vrA;
            qvVar.fFl.fzO = aVar.fFh;
            qvVar.fFl.fFn = 5;
            qvVar.fFl.mediaTagName = aVar.vrB;
            qvVar.fFl.fFo = aVar.fFo;
            qvVar.fFl.fFp = "";
            com.tencent.mm.sdk.b.a.xef.m(qvVar);
        }
    }
}
