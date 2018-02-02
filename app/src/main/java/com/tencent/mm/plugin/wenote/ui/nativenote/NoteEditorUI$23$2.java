package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.fav.a.g$a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class NoteEditorUI$23$2 implements d {
    final /* synthetic */ 23 tXl;

    NoteEditorUI$23$2(23 23) {
        this.tXl = 23;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        boolean z = false;
        int i2 = 1;
        b fvVar;
        boolean z2;
        Intent intent;
        g$a h;
        switch (menuItem.getItemId()) {
            case 0:
                if (NoteEditorUI.e(this.tXl.tXd) != null) {
                    NoteEditorUI.e(this.tXl.tXd).a(null);
                }
                NoteEditorUI.f(this.tXl.tXd).bXb();
                fvVar = new fv();
                fvVar.fvq.type = 32;
                fvVar.fvq.fqk = NoteEditorUI.g(this.tXl.tXd);
                a.xef.m(fvVar);
                z2 = fvVar.fvr.fvI;
                if (fvVar.fvr.path == null) {
                    h.bu(this.tXl.tXd.mController.xIM, this.tXl.tXd.getString(R.l.egs));
                    return;
                } else if (z2) {
                    h.bu(this.tXl.tXd.mController.xIM, this.tXl.tXd.getString(R.l.dBN));
                    return;
                } else {
                    intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("scene_from", 1);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("select_fav_local_id", NoteEditorUI.g(this.tXl.tXd));
                    com.tencent.mm.bm.d.a(this.tXl.tXd, ".ui.transmit.SelectConversationUI", intent, 4101);
                    g.pQN.h(10651, new Object[]{Integer.valueOf(18), Integer.valueOf(1), Integer.valueOf(0)});
                    h = NoteEditorUI.h(this.tXl.tXd);
                    h.mod++;
                    return;
                }
            case 1:
                if (NoteEditorUI.e(this.tXl.tXd) != null) {
                    NoteEditorUI.e(this.tXl.tXd).a(null);
                }
                NoteEditorUI.f(this.tXl.tXd).bXb();
                intent = new Intent();
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", NoteEditorUI.g(this.tXl.tXd));
                com.tencent.mm.bm.d.b(this.tXl.tXd.mController.xIM, "favorite", ".ui.FavTagEditUI", intent);
                h = NoteEditorUI.i(this.tXl.tXd);
                h.mog++;
                return;
            case 2:
                h.a(this.tXl.tXd.mController.xIM, this.tXl.tXd.getString(R.l.dEx), "", new 1(this), null);
                return;
            case 3:
                cf cfVar = new cf();
                f.a(cfVar, NoteEditorUI.k(this.tXl.tXd));
                a.xef.m(cfVar);
                c.a(cfVar.fqq.ret, 37, this.tXl.tXd, this.tXl.tXd.nah);
                return;
            case 4:
                intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", NoteEditorUI.k(this.tXl.tXd));
                com.tencent.mm.bm.d.a(this.tXl.tXd, ".ui.transmit.SelectConversationUI", intent, (int) Downloads.RECV_BUFFER_SIZE);
                h = NoteEditorUI.l(this.tXl.tXd);
                h.mod++;
                return;
            case 5:
                NoteEditorUI.f(this.tXl.tXd).bXb();
                p pVar = new p();
                pVar.tRS = NoteEditorUI.d(this.tXl.tXd) == 1;
                pVar.tRX = NoteEditorUI.m(this.tXl.tXd);
                pVar.tRW = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().QQ(this.tXl.tXd.getString(R.l.eXI));
                pVar.tRY = NoteEditorUI.n(this.tXl.tXd);
                pVar.tRZ = NoteEditorUI.o(this.tXl.tXd);
                if (NoteEditorUI.d(this.tXl.tXd) == 1) {
                    pVar.tRU = NoteEditorUI.k(this.tXl.tXd);
                    if (NoteEditorUI.p(this.tXl.tXd)) {
                        pVar.tRV = true;
                        g.pQN.h(14790, new Object[]{Integer.valueOf(3)});
                    } else {
                        pVar.tRV = false;
                        g.pQN.h(14790, new Object[]{Integer.valueOf(2)});
                    }
                } else {
                    g.pQN.h(14790, new Object[]{Integer.valueOf(1)});
                    pVar.tRT = NoteEditorUI.g(this.tXl.tXd);
                }
                com.tencent.mm.plugin.wenote.model.nativenote.manager.h.bWJ().a(pVar);
                com.tencent.mm.ui.snackbar.a.h(this.tXl.tXd, this.tXl.tXd.getString(R.l.eXJ));
                return;
            case 6:
                com.tencent.mm.plugin.wenote.model.nativenote.manager.h.bWJ().a(null);
                com.tencent.mm.ui.snackbar.a.h(this.tXl.tXd, this.tXl.tXd.getString(R.l.eXG));
                return;
            case 7:
                g.pQN.h(10651, new Object[]{Integer.valueOf(18), Integer.valueOf(0), Integer.valueOf(0)});
                if (NoteEditorUI.q(this.tXl.tXd)) {
                    z = true;
                } else if (NoteEditorUI.r(this.tXl.tXd) && !com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWw().equals(NoteEditorUI.s(this.tXl.tXd))) {
                    z = true;
                }
                if (z) {
                    NoteEditorUI.f(this.tXl.tXd).bXb();
                    this.tXl.tXd.bXF();
                    NoteEditorUI.t(this.tXl.tXd);
                }
                if (NoteEditorUI.q(this.tXl.tXd)) {
                    NoteEditorUI.u(this.tXl.tXd);
                    NoteEditorUI.v(this.tXl.tXd);
                }
                fvVar = new fv();
                fvVar.fvq.type = 30;
                fvVar.fvq.fvx = 1;
                fvVar.fvq.fqk = NoteEditorUI.g(this.tXl.tXd);
                a.xef.m(fvVar);
                String str = fvVar.fvr.path;
                NoteEditorUI.a(this.tXl.tXd, fvVar.fvr.fvC);
                if (bh.ov(str)) {
                    NoteEditorUI.w(this.tXl.tXd).post(new 2(this));
                    return;
                }
                NoteEditorUI.b(this.tXl.tXd, str);
                h = NoteEditorUI.x(this.tXl.tXd);
                h.moe++;
                return;
            case 8:
                NoteEditorUI.a(this.tXl.tXd, h.a(this.tXl.tXd.mController.xIM, this.tXl.tXd.getString(R.l.eYu), true, new 3(this)));
                fvVar = new fv();
                fvVar.fvq.type = 32;
                fvVar.fvq.fqk = NoteEditorUI.g(this.tXl.tXd);
                fvVar.fvq.fqr = com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQz;
                a.xef.m(fvVar);
                z2 = fvVar.fvr.fvI;
                g gVar;
                Object[] objArr;
                if (fvVar.fvr.path == null) {
                    NoteEditorUI.y(this.tXl.tXd);
                    Toast.makeText(this.tXl.tXd.mController.xIM, this.tXl.tXd.mController.xIM.getString(R.l.eyn), 1).show();
                    gVar = g.pQN;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(0);
                    objArr[1] = Integer.valueOf(0);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(5);
                    if (!NoteEditorUI.z(this.tXl.tXd)) {
                        i2 = 0;
                    }
                    objArr[4] = Integer.valueOf(i2);
                    gVar.h(14811, objArr);
                    return;
                } else if (z2) {
                    NoteEditorUI.y(this.tXl.tXd);
                    Toast.makeText(this.tXl.tXd.mController.xIM, this.tXl.tXd.mController.xIM.getString(R.l.eyn), 1).show();
                    gVar = g.pQN;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(0);
                    objArr[1] = Integer.valueOf(0);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(5);
                    if (!NoteEditorUI.z(this.tXl.tXd)) {
                        i2 = 0;
                    }
                    objArr[4] = Integer.valueOf(i2);
                    gVar.h(14811, objArr);
                    return;
                } else {
                    NoteEditorUI.w(this.tXl.tXd).post(new 4(this));
                    return;
                }
            case 9:
                fvVar = new fv();
                fvVar.fvq.type = 32;
                fvVar.fvq.fqk = NoteEditorUI.g(this.tXl.tXd);
                fvVar.fvq.fqr = com.tencent.mm.plugin.wenote.model.c.bVN().tQn.tQz;
                a.xef.m(fvVar);
                z = fvVar.fvr.fvI;
                if (fvVar.fvr.path == null) {
                    h.bu(this.tXl.tXd.mController.xIM, this.tXl.tXd.getString(R.l.egs));
                    return;
                } else if (z) {
                    h.bu(this.tXl.tXd.mController.xIM, this.tXl.tXd.getString(R.l.dBQ));
                    return;
                } else {
                    intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("scene_from", 1);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("select_fav_local_id", NoteEditorUI.g(this.tXl.tXd));
                    intent.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.bVN().tQn.bVO());
                    com.tencent.mm.bm.d.a(this.tXl.tXd, ".ui.transmit.SelectConversationUI", intent, 4355);
                    h = NoteEditorUI.A(this.tXl.tXd);
                    h.mod++;
                    return;
                }
            case 10:
                com.tencent.mm.plugin.wenote.model.h.aR(this.tXl.tXd.mController.xIM, NoteEditorUI.B(this.tXl.tXd));
                return;
            case 12:
                if (bh.ov(NoteEditorUI.C(this.tXl.tXd))) {
                    NoteEditorUI.w(this.tXl.tXd).post(new 5(this));
                    return;
                }
                h = NoteEditorUI.D(this.tXl.tXd);
                h.moe++;
                NoteEditorUI.b(this.tXl.tXd, NoteEditorUI.C(this.tXl.tXd));
                return;
            case 13:
                intent = new Intent();
                intent.putExtra("k_expose_msg_id", NoteEditorUI.B(this.tXl.tXd));
                if (NoteEditorUI.E(this.tXl.tXd) != null && NoteEditorUI.E(this.tXl.tXd).length > 1) {
                    intent.putExtra("k_username", NoteEditorUI.E(this.tXl.tXd)[1]);
                }
                intent.putExtra("showShare", NoteEditorUI.F(this.tXl.tXd));
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                com.tencent.mm.bm.d.b(this.tXl.tXd.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                return;
            default:
                return;
        }
    }
}
