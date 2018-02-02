package com.tencent.mm.plugin.sport.ui.a;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;
import java.util.LinkedList;
import java.util.List;

public final class a implements e, com.tencent.mm.pluginsdk.c.a {
    Context context;
    private f ilB;
    x jLe;
    private r jLf;
    private CheckBoxPreference rUS;
    private CheckBoxPreference rUT;

    public a(Context context) {
        this.context = context;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        this.ilB = fVar;
        this.jLe = xVar;
        fVar.addPreferencesFromResource(R.o.fbD);
        this.rUS = (CheckBoxPreference) fVar.YN("contact_info_top_sport");
        this.rUT = (CheckBoxPreference) fVar.YN("contact_info_not_disturb");
        arR();
        return true;
    }

    public final boolean arS() {
        return true;
    }

    public final boolean vQ(String str) {
        if ("contact_info_record_data".equals(str)) {
            this.context.startActivity(new Intent(this.context, ExdeviceRankDataSourceUI.class));
        } else if ("contact_info_top_sport".equals(str)) {
            if (this.rUS.isChecked()) {
                d.pY(20);
                s.r(this.jLe.field_username, true);
            } else {
                d.pY(21);
                s.s(this.jLe.field_username, true);
            }
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.rUT.isChecked()) {
                d.pY(22);
                s.n(this.jLe);
            } else {
                d.pY(23);
                s.o(this.jLe);
            }
        } else if ("contact_info_go_to_sport".equals(str)) {
            r0 = new Intent();
            r0.putExtra("Chat_User", this.jLe.field_username);
            r0.putExtra("finish_direct", true);
            com.tencent.mm.bm.d.a(this.context, ".ui.chatting.ChattingUI", r0);
            d.pY(19);
        } else if ("contact_info_go_to_my_profile".equals(str)) {
            String FS = q.FS();
            if (bh.ov(FS)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
            } else {
                Intent intent = new Intent();
                intent.putExtra("username", FS);
                com.tencent.mm.bm.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", intent);
                d.pY(3);
            }
        } else if ("contact_info_invite_friend".equals(str)) {
            r0 = new Intent();
            r0.putExtra("Select_Talker_Name", this.jLe.field_username);
            r0.putExtra("Select_block_List", this.jLe.field_username);
            r0.putExtra("Select_Conv_Type", 3);
            r0.putExtra("Select_Send_Card", true);
            r0.putExtra("mutil_select_is_ret", true);
            com.tencent.mm.bm.d.a(this.context, ".ui.transmit.SelectConversationUI", r0, 1);
            d.pY(4);
        } else if ("contact_info_common_problem".equals(str)) {
            r0 = new Intent();
            r0.putExtra("KPublisherId", "custom_menu");
            r0.putExtra("pre_username", this.jLe.field_username);
            r0.putExtra("prePublishId", "custom_menu");
            r0.putExtra("preUsername", this.jLe.field_username);
            r0.putExtra("preChatName", this.jLe.field_username);
            r0.putExtra("preChatTYPE", t.N(this.jLe.field_username, this.jLe.field_username));
            r0.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
            r0.putExtra("geta8key_username", this.jLe.field_username);
            r0.putExtra("from_scence", 1);
            com.tencent.mm.bm.d.b(this.context, "webview", ".ui.tools.WebViewUI", r0);
            d.pY(5);
        } else if ("contact_info_privacy_and_notification".equals(str)) {
            com.tencent.mm.bm.d.y(this.context, "exdevice", ".ui.ExdeviceSettingUI");
        } else if ("contact_info_sport_install".equals(str)) {
            d.pY(13);
            Context context = this.context;
            this.context.getString(R.l.dGO);
            this.jLf = h.a(context, this.context.getString(R.l.eMA), true, null);
            this.jLf.show();
            ar.CG().a(30, (e) this);
            List linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            List linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            ar.CG().a(new o(1, linkedList, linkedList2, "", ""), 0);
        } else if ("contact_info_sport_uninstall".equals(str)) {
            d.pY(14);
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 2(this), null);
        } else if ("contact_info_clear_data".equals(str)) {
            h.a(this.context, this.context.getString(R.l.dUG), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 1(this), null);
        }
        return false;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        List<String> F = bh.F(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra = intent.getStringExtra("custom_send_text");
                        for (String str : F) {
                            com.tencent.mm.plugin.messenger.a.f.aZh().k("gh_43f2581f6fd6", str, s.eV(str));
                            if (!bh.ov(stringExtra)) {
                                b orVar = new or();
                                orVar.fGI.fGJ = str;
                                orVar.fGI.content = stringExtra;
                                orVar.fGI.type = s.hp(str);
                                orVar.fGI.flags = 0;
                                com.tencent.mm.sdk.b.a.xef.m(orVar);
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    final void arR() {
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
        helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dXa));
        if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
            helperHeaderPreference.nx(1);
            this.ilB.bk("contact_info_sport_install", true);
            this.ilB.bk("contact_info_sport_uninstall", false);
            this.ilB.bk("contact_info_go_to_sport", false);
            this.ilB.bk("contact_info_go_to_my_profile", false);
            this.ilB.bk("contact_info_invite_friend", false);
            this.ilB.bk("contact_info_common_problem", false);
            this.ilB.bk("contact_info_record_data", false);
            this.ilB.bk("contact_info_privacy_and_notification", false);
            this.ilB.bk("contact_info_top_sport", false);
            this.ilB.bk("contact_info_not_disturb", false);
            ar.Hg();
            if (c.Fd().Xf(this.jLe.field_username)) {
                this.rUS.tSw = true;
            } else {
                this.rUS.tSw = false;
            }
            if (this.jLe.AI()) {
                this.rUT.tSw = true;
                return;
            } else {
                this.rUT.tSw = false;
                return;
            }
        }
        helperHeaderPreference.nx(0);
        this.ilB.bk("contact_info_sport_install", false);
        this.ilB.bk("contact_info_sport_uninstall", true);
        this.ilB.bk("contact_info_go_to_sport", true);
        this.ilB.bk("contact_info_go_to_my_profile", true);
        this.ilB.bk("contact_info_invite_friend", true);
        this.ilB.bk("contact_info_common_problem", true);
        this.ilB.bk("contact_info_record_data", true);
        this.ilB.bk("contact_info_privacy_and_notification", true);
        this.ilB.bk("contact_info_top_sport", true);
        this.ilB.bk("contact_info_not_disturb", true);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof o) {
            ar.CG().b(30, (e) this);
            if (i == 0 && i2 == 0) {
                String bYs = ((o) kVar).bYs();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", bYs);
                ar.Hg();
                af WO = c.EY().WO("gh_43f2581f6fd6");
                if (WO == null || bh.ov(bYs)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + bYs + ", contact = " + WO);
                } else {
                    com.tencent.mm.ag.d jS;
                    if (s.gD(WO.field_username)) {
                        String ou = bh.ou(WO.field_username);
                        jS = com.tencent.mm.ag.f.jS(ou);
                        if (jS != null) {
                            jS.field_username = bYs;
                        }
                        y.Mf().jL(ou);
                        WO.di(ou);
                    } else {
                        jS = null;
                    }
                    WO.setUsername(bYs);
                    if (((int) WO.gJd) == 0) {
                        ar.Hg();
                        c.EY().S(WO);
                    }
                    if (((int) WO.gJd) <= 0) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
                    } else {
                        s.p(WO);
                        ar.Hg();
                        af WO2 = c.EY().WO(WO.field_username);
                        if (jS != null) {
                            y.Mf().d(jS);
                        } else {
                            jS = com.tencent.mm.ag.f.jS(WO2.field_username);
                            if (jS == null || jS.KY()) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
                                com.tencent.mm.z.ak.a.hfL.Q(WO2.field_username, "");
                                com.tencent.mm.ad.b.iX(WO2.field_username);
                            } else if (WO2.cid()) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", Integer.valueOf(WO2.fWw));
                                com.tencent.mm.z.ak.a.hfL.Q(WO2.field_username, "");
                                com.tencent.mm.ad.b.iX(WO2.field_username);
                            }
                        }
                    }
                }
                y.Mf().e(y.Mf().jK(WO.field_username));
                ar.Hg();
                c.CU().set(327825, Boolean.valueOf(true));
                com.tencent.mm.plugin.x.a.bfm();
                com.tencent.mm.aw.d.a(com.tencent.mm.aw.b.hIf, 1, com.tencent.mm.aw.b.hIb, "", null);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", Integer.valueOf(r0), Integer.valueOf(1), "");
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4 && i2 == -24 && !bh.ov(str)) {
                    Toast.makeText(ac.getContext(), str, 1).show();
                }
            }
            if (this.jLf != null) {
                this.jLf.dismiss();
            }
            arR();
        }
    }
}
