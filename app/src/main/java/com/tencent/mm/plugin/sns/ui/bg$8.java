package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.av.c;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

class bg$8 implements OnClickListener {
    final /* synthetic */ bg rMH;

    bg$8(bg bgVar) {
        this.rMH = bgVar;
    }

    public final void onClick(View view) {
        boolean z;
        String str;
        String str2 = null;
        bg bgVar = this.rMH;
        if (view == null || !(view.getTag() instanceof bnp)) {
            z = true;
        } else {
            str = ((bnp) view.getTag()).wQn.nGJ;
            if ("wx485a97c844086dc9".equals(str)) {
                d.b(view.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
                z = true;
            } else if ("wx7fa037cc7dfabad5".equals(str)) {
                com.tencent.mm.plugin.sport.b.d.pY(34);
                g.Dk();
                if (a.fZ(((h) g.h(h.class)).EY().WO("gh_43f2581f6fd6").field_type)) {
                    r0 = new Intent();
                    r0.putExtra("Chat_User", "gh_43f2581f6fd6");
                    r0.putExtra("finish_direct", true);
                    d.a(bgVar.context, ".ui.chatting.ChattingUI", r0);
                } else {
                    r0 = new Intent();
                    r0.putExtra("Contact_User", "gh_43f2581f6fd6");
                    d.b(bgVar.context, "profile", ".ui.ContactInfoUI", r0);
                }
                z = true;
            } else if ("wx9181ed3f223e6d76".equals(str) || "wx2fe12a395c426fcf".equals(str)) {
                x.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
                r0 = new Intent();
                r0.putExtra("shake_tv", true);
                d.b(view.getContext(), "shake", ".ui.ShakeReportUI", r0);
                z = true;
            } else if ("wx751a1acca5688ba3".equals(str)) {
                r0 = new Intent();
                r0.putExtra("BaseScanUI_select_scan_mode", 5);
                if (!(com.tencent.mm.p.a.aV(bgVar.context) || com.tencent.mm.p.a.aU(bgVar.context))) {
                    d.b(bgVar.context, "scanner", ".ui.BaseScanUI", r0);
                }
                z = true;
            } else if ("wxfbc915ff7c30e335".equals(str)) {
                r0 = new Intent();
                r0.putExtra("BaseScanUI_select_scan_mode", 1);
                if (!(com.tencent.mm.p.a.aV(bgVar.context) || com.tencent.mm.p.a.aU(bgVar.context))) {
                    d.b(bgVar.context, "scanner", ".ui.BaseScanUI", r0);
                }
                z = true;
            } else if ("wx482a4001c37e2b74".equals(str)) {
                r0 = new Intent();
                r0.putExtra("BaseScanUI_select_scan_mode", 2);
                if (!(com.tencent.mm.p.a.aV(bgVar.context) || com.tencent.mm.p.a.aU(bgVar.context))) {
                    d.b(bgVar.context, "scanner", ".ui.BaseScanUI", r0);
                }
                z = true;
            } else if (!"wxaf060266bfa9a35c".equals(str)) {
                z = false;
            } else if (c.Qx()) {
                r0 = new Intent();
                r0.putExtra("shake_tv", true);
                d.b(bgVar.context, "shake", ".ui.ShakeReportUI", r0);
                z = true;
            } else {
                z = true;
            }
        }
        if (!z && view != null && (view.getTag() instanceof bnp)) {
            bnp com_tencent_mm_protocal_c_bnp = (bnp) view.getTag();
            if (com_tencent_mm_protocal_c_bnp == null || com_tencent_mm_protocal_c_bnp.wQn == null) {
                x.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
                return;
            }
            String str3 = com_tencent_mm_protocal_c_bnp.wQn.nGJ;
            String cy = com.tencent.mm.plugin.sns.c.a.ift.cy(str3);
            if (bh.ov(cy) || !com.tencent.mm.plugin.sns.c.a.ift.cA(str3)) {
                str = com.tencent.mm.plugin.sns.c.a.ift.f(this.rMH.context, str3, "timeline");
                if (str != null && str.length() != 0) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("shortUrl", str);
                    intent.putExtra("useJs", true);
                    intent.putExtra(DownloadSettingTable$Columns.TYPE, -255);
                    intent.putExtra("geta8key_scene", 2);
                    com.tencent.mm.plugin.sns.c.a.ifs.j(intent, this.rMH.context);
                    return;
                }
                return;
            }
            int i;
            String str4 = com_tencent_mm_protocal_c_bnp == null ? null : com_tencent_mm_protocal_c_bnp.ksU;
            if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 1) {
                i = 2;
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 3) {
                i = 5;
            } else {
                i = 2;
            }
            if (!(com_tencent_mm_protocal_c_bnp.qYu == null || com_tencent_mm_protocal_c_bnp.qYu.vFI == null)) {
                str2 = com_tencent_mm_protocal_c_bnp.qYu.vFI.vFC;
            }
            b nhVar = new nh();
            nhVar.fFl.context = this.rMH.context;
            nhVar.fFl.scene = 4;
            nhVar.fFl.fFm = str3;
            nhVar.fFl.packageName = cy;
            nhVar.fFl.msgType = i;
            nhVar.fFl.fzO = str4;
            nhVar.fFl.mediaTagName = str2;
            nhVar.fFl.fFn = 5;
            nhVar.fFl.fFo = 0;
            nhVar.fFl.fFp = com_tencent_mm_protocal_c_bnp.nGJ;
            com.tencent.mm.sdk.b.a.xef.m(nhVar);
            b gmVar = new gm();
            gmVar.fwC.actionCode = 2;
            gmVar.fwC.scene = 3;
            gmVar.fwC.extMsg = "timeline_src=3";
            gmVar.fwC.appId = str3;
            gmVar.fwC.context = this.rMH.context;
            com.tencent.mm.sdk.b.a.xef.m(gmVar);
        }
    }
}
