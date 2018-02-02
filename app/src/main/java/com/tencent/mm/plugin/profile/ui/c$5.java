package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteDatabase;

class c$5 implements a {
    final /* synthetic */ c piX;

    c$5(c cVar) {
        this.piX = cVar;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        if (z) {
            d jS;
            h.bu(this.piX.fmM, this.piX.fmM.getString(R.l.dUu));
            this.piX.ilB.bk("contact_info_time_expired", true);
            af afVar = this.piX.jLe;
            if (afVar == null || bh.ov(str)) {
                x.e("MicroMsg.ContactWidgetBizInfo", "respUsername == " + str + ", contact = " + afVar);
            } else {
                if (s.gD(afVar.field_username)) {
                    String ou = bh.ou(afVar.field_username);
                    jS = f.jS(ou);
                    if (jS != null) {
                        jS.field_username = str;
                    }
                    y.Mf().jL(ou);
                    afVar.di(ou);
                } else {
                    jS = null;
                }
                afVar.setUsername(str);
                if (((int) afVar.gJd) == 0) {
                    ar.Hg();
                    c.EY().S(afVar);
                }
                if (((int) afVar.gJd) <= 0) {
                    x.e("MicroMsg.ContactWidgetBizInfo", "addContact : insert contact failed");
                } else {
                    s.p(afVar);
                    ar.Hg();
                    afVar = c.EY().WO(afVar.field_username);
                    if (jS != null) {
                        y.Mf().d(jS);
                    } else {
                        d jS2 = f.jS(afVar.field_username);
                        boolean z3 = afVar.cia() && com.tencent.mm.ag.a.KV();
                        if (jS2 == null || (jS2.KY() && !z3)) {
                            x.d("MicroMsg.ContactWidgetBizInfo", "shouldUpdate");
                            ak.a.hfL.Q(afVar.field_username, "");
                            b.iX(afVar.field_username);
                        } else if (afVar.cid() && !z3) {
                            x.d("MicroMsg.ContactWidgetBizInfo", "update contact, last check time=%d", new Object[]{Integer.valueOf(afVar.fWw)});
                            ak.a.hfL.Q(afVar.field_username, "");
                            b.iX(afVar.field_username);
                        }
                    }
                }
            }
            this.piX.piP = true;
            if (this.piX.piV != null) {
                com.tencent.mm.sdk.b.b ndVar = new nd();
                this.piX.piV.hOx = 4;
                ndVar.fFd.fFe = this.piX.piV;
                com.tencent.mm.sdk.b.a.xef.m(ndVar);
            }
            jS = y.Mf().jK(this.piX.jLe.field_username);
            jS.field_status = 1;
            if (!bh.ov(jS.field_extInfo) || bh.ov(jS.field_username) || this.piX.kEC == null || !jS.field_username.equals(bh.ou(this.piX.kEC.field_username))) {
                y.Mf().e(jS);
            } else {
                y.Mf().e(this.piX.kEC);
            }
            boolean booleanExtra = this.piX.fmM.getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
            boolean booleanExtra2 = this.piX.fmM.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
            Intent intent;
            if (jS.Le()) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", this.piX.jLe.field_username);
                intent.putExtra("enterprise_biz_display_name", r.gu(this.piX.jLe.field_username));
                intent.putExtra("enterprise_from_scene", 7);
                intent.addFlags(67108864);
                com.tencent.mm.bm.d.a(this.piX.fmM, ".ui.conversation.EnterpriseConversationUI", intent);
            } else {
                intent = new Intent();
                intent.putExtra("Chat_User", this.piX.jLe.field_username);
                intent.putExtra("key_has_add_contact", true);
                intent.putExtra("finish_direct", true);
                if (booleanExtra2) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                com.tencent.mm.plugin.profile.a.ifs.e(intent, this.piX.fmM);
                if (!booleanExtra) {
                    if (booleanExtra2) {
                    }
                    this.piX.aw(3, null);
                }
            }
            this.piX.fmM.finish();
            this.piX.aw(3, null);
        }
    }
}
