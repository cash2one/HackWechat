package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ay.p;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.preference.RoomCardPreference;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.aok;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ChatroomInfoUI extends MMPreference implements e, l, a, b {
    private static boolean lai = false;
    private boolean fzz;
    private SharedPreferences gZO = null;
    private af handler = new af(this, Looper.getMainLooper()) {
        final /* synthetic */ ChatroomInfoUI lal;

        public final void handleMessage(Message message) {
            ChatroomInfoUI.a(this.lal);
        }
    };
    private String iQs;
    private f ilB;
    private r ilH = null;
    private ProgressDialog iln = null;
    private boolean isDeleteCancel = false;
    private x jLe;
    private boolean kTc;
    private boolean kZA;
    private RoomCardPreference kZB;
    private SignaturePreference kZC;
    private Preference kZD;
    private NormalIconPreference kZE;
    private NormalIconPreference kZF;
    private ContactListExpandPreference kZG;
    private CheckBoxPreference kZH;
    private CheckBoxPreference kZI;
    private CheckBoxPreference kZJ;
    private SignaturePreference kZK;
    private CheckBoxPreference kZL;
    private AppBrandLoadIconPreference kZM;
    private boolean kZN;
    private boolean kZO;
    private boolean kZP = false;
    private int kZQ;
    private boolean kZR = false;
    private q kZS = null;
    private int kZT = -1;
    private boolean kZU = true;
    private boolean kZV = false;
    private d kZW = new d(new 11(this));
    boolean kZX = false;
    private c kZY = new 33(this);
    int kZZ = -1;
    private boolean laa = false;
    private com.tencent.mm.plugin.messenger.foundation.a.a.e.a lab;
    int lac;
    String lad;
    private c lae = new 8(this);
    private String laf = "";
    private com.tencent.mm.plugin.messenger.foundation.a.a.e.a lag;
    private String lah;
    private String laj = null;
    private com.tencent.mm.pluginsdk.d.b lak = new 26(this);

    class AnonymousClass17 implements OnClickListener {
        final /* synthetic */ ChatroomInfoUI lal;
        final /* synthetic */ ProgressDialog lao;
        final /* synthetic */ boolean laq = true;

        AnonymousClass17(ChatroomInfoUI chatroomInfoUI, ProgressDialog progressDialog, boolean z) {
            this.lal = chatroomInfoUI;
            this.lao = progressDialog;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            g.pQN.h(14553, new Object[]{Integer.valueOf(4), Integer.valueOf(3), this.lal.iQs});
            this.lao.show();
            this.lal.isDeleteCancel = false;
            this.lal.eh(this.laq);
        }
    }

    static /* synthetic */ void a(jz jzVar) {
        jzVar.fBk.fAJ = true;
        com.tencent.mm.sdk.b.a.xef.m(jzVar);
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI) {
        chatroomInfoUI.updateTitle();
        ar.Hg();
        String hG = com.tencent.mm.z.c.Fh().hG(chatroomInfoUI.iQs);
        if (chatroomInfoUI.laj != null && !chatroomInfoUI.laj.equals(hG)) {
            chatroomInfoUI.axK();
        }
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI, String str) {
        g.pQN.a(219, 4, 1, true);
        chatroomInfoUI.lah = str;
        String FS = com.tencent.mm.z.q.FS();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_arl = new arl();
        com_tencent_mm_protocal_c_arl.vYJ = chatroomInfoUI.iQs;
        com_tencent_mm_protocal_c_arl.ksU = FS;
        com_tencent_mm_protocal_c_arl.vUT = bh.ou(str);
        chatroomInfoUI.lag = new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(48, com_tencent_mm_protocal_c_arl);
        chatroomInfoUI.lac = 48;
        Context context = chatroomInfoUI.mController.xIM;
        chatroomInfoUI.getString(R.l.dGO);
        chatroomInfoUI.ilH = h.a(context, chatroomInfoUI.getString(R.l.dUD), false, null);
        chatroomInfoUI.laa = true;
        ar.Hg();
        com.tencent.mm.z.c.EX().b(chatroomInfoUI.lag);
    }

    static /* synthetic */ boolean a(ChatroomInfoUI chatroomInfoUI, int i, int i2, String str) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "pre is " + chatroomInfoUI.kZQ);
        chatroomInfoUI.kZQ = m.gl(chatroomInfoUI.iQs);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "now is " + chatroomInfoUI.kZQ);
        if (chatroomInfoUI.iln != null) {
            chatroomInfoUI.iln.dismiss();
        }
        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
        if (eA == null) {
            return false;
        }
        eA.a(chatroomInfoUI, null, null);
        return true;
    }

    static /* synthetic */ void y(ChatroomInfoUI chatroomInfoUI) {
        g.pQN.h(14553, new Object[]{Integer.valueOf(4), Integer.valueOf(2), chatroomInfoUI.iQs});
        ar.Hg();
        long j = com.tencent.mm.z.c.Fa().Ew(chatroomInfoUI.iQs).field_msgSvrId;
        ar.Hg();
        com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.d(chatroomInfoUI.iQs, j));
        chatroomInfoUI.isDeleteCancel = false;
        chatroomInfoUI.getString(R.l.dGO);
        ProgressDialog a = h.a(chatroomInfoUI, chatroomInfoUI.getString(R.l.dHc), true, new 15(chatroomInfoUI));
        if (bh.ov(!chatroomInfoUI.isDeleteCancel ? com.tencent.mm.pluginsdk.wallet.e.SZ(chatroomInfoUI.jLe.field_username) : null)) {
            chatroomInfoUI.eh(true);
            return;
        }
        a.dismiss();
        Object[] objArr = new Object[]{r0};
        h.a(chatroomInfoUI, false, chatroomInfoUI.getString(R.l.eWg, objArr), null, chatroomInfoUI.getString(R.l.enD), chatroomInfoUI.getString(R.l.eEZ), new OnClickListener(chatroomInfoUI) {
            final /* synthetic */ ChatroomInfoUI lal;

            {
                this.lal = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                g.pQN.h(14553, new Object[]{Integer.valueOf(4), Integer.valueOf(4), this.lal.iQs});
                this.lal.isDeleteCancel = true;
                if (this.lal.kZV) {
                    this.lal.finish();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Chat_User", this.lal.jLe.field_username);
                intent.addFlags(67108864);
                com.tencent.mm.bm.d.a(this.lal, ".ui.chatting.ChattingUI", intent);
            }
        }, new AnonymousClass17(chatroomInfoUI, a, true), -1, R.e.brm);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(223, this);
        ar.CG().a(179, this);
        ar.CG().a(480, this);
        ar.CG().a(610, this);
        com.tencent.mm.pluginsdk.d.b.a(jz.class.getName(), this.lak);
        this.kZY.ceO().a(this);
        this.lae.ceO().a(this);
        ar.Hg();
        com.tencent.mm.z.c.EY().a(this);
        ar.Hg();
        com.tencent.mm.z.c.Fh().c(this);
        if (com.tencent.mm.pluginsdk.q.a.vcp != null) {
            com.tencent.mm.pluginsdk.q.a.vcp.a(this);
        }
        this.iQs = getIntent().getStringExtra("RoomInfo_Id");
        ar.Hg();
        this.jLe = com.tencent.mm.z.c.EY().WO(this.iQs);
        this.kZU = true;
        this.fzz = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.kZA = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.kZV = getIntent().getBooleanExtra("fromChatting", false);
        this.laf = getPackageName() + "_preferences";
        if (this.fzz) {
            ar.Hg();
            this.kZS = com.tencent.mm.z.c.Fh().hD(this.iQs);
        }
        initView();
        if (this.fzz) {
            ak.b.a 22 = new 22(this);
            if (this.kZS == null) {
                ak.a.hfL.a(this.iQs, "", 22);
            } else if (System.currentTimeMillis() - this.kZS.field_modifytime >= 86400000) {
                ar.Dm().F(new 30(this, 22));
            }
        }
    }

    private void axy() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[]{this.iQs});
        new com.tencent.mm.plugin.chatroom.d.c(this.iQs).JV().c((com.tencent.mm.vending.e.b) this).f(new 32(this)).h(new 31(this));
    }

    public void onResume() {
        boolean E;
        String stringExtra;
        super.onResume();
        ar.CG().a(120, this);
        this.ilB.notifyDataSetChanged();
        if (this.kZS != null) {
            com.tencent.mm.i.a.a.a chW = this.kZS.chW();
            if (chW != null) {
                E = m.E(this.kZS.field_chatroomname, chW.gBK);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[]{this.kZS.field_chatroomname, Integer.valueOf(chW.gBK), Integer.valueOf(this.kZS.field_chatroomVersion), this.kZS.field_roomowner});
                if (m.ge(this.iQs) || r0) {
                    axy();
                }
                axH();
                updateTitle();
                axG();
                if (this.fzz) {
                    axI();
                    axF();
                }
                if (this.kZU) {
                    axE();
                    this.kZU = false;
                }
                stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
                if (!this.kZX) {
                    if (!bh.ov(stringExtra)) {
                        xc(stringExtra);
                    }
                    this.kZX = true;
                }
                if (!bh.ov(stringExtra) && stringExtra.equals("room_notify_new_notice") && !this.kZX) {
                    xc("room_card");
                    this.kZX = true;
                    return;
                }
                return;
            }
        }
        E = false;
        axy();
        axH();
        updateTitle();
        axG();
        if (this.fzz) {
            axI();
            axF();
        }
        if (this.kZU) {
            axE();
            this.kZU = false;
        }
        stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
        if (this.kZX) {
            if (bh.ov(stringExtra)) {
                xc(stringExtra);
            }
            this.kZX = true;
        }
        if (!bh.ov(stringExtra)) {
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kZG.notifyChanged();
    }

    private void xc(String str) {
        int YP = this.ilB.YP(str);
        this.nKG.smoothScrollToPosition(YP);
        new af().postDelayed(new 34(this, YP), 10);
    }

    public void onPause() {
        super.onPause();
        ar.CG().b(120, this);
        if (this.kZR && this.fzz && this.kZS != null) {
            m.a(this.iQs, this.kZS, this.kZN);
        }
    }

    public void onDestroy() {
        if (com.tencent.mm.pluginsdk.q.a.vcp != null) {
            com.tencent.mm.pluginsdk.q.a.vcp.a(this);
        }
        com.tencent.mm.ui.g.a.dismiss();
        ar.CG().b(223, this);
        ar.CG().b(179, this);
        ar.CG().b(480, this);
        ar.CG().b(610, this);
        com.tencent.mm.sdk.b.a.xef.c(this.lae);
        com.tencent.mm.sdk.b.a.xef.c(this.kZY);
        com.tencent.mm.pluginsdk.d.b.b(jz.class.getName(), this.lak);
        if (ar.Hj()) {
            ar.Hg();
            com.tencent.mm.z.c.EY().b(this);
            ar.Hg();
            com.tencent.mm.z.c.Fh().j(this);
        }
        if (com.tencent.mm.pluginsdk.q.a.vcp != null) {
            com.tencent.mm.pluginsdk.q.a.vcp.b(this);
        }
        if (this.kZM != null) {
            AppBrandLoadIconPreference.onDestroy();
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        switch (i) {
            case 1:
                if (intent != null) {
                    stringExtra = intent.getStringExtra("Select_Contact");
                    ar.Hg();
                    q hD = com.tencent.mm.z.c.Fh().hD(this.iQs);
                    if (hD == null) {
                        return;
                    }
                    if (hD.chT() != 2 || this.kZP) {
                        n(stringExtra, null, R.l.dCE);
                        return;
                    } else {
                        com.tencent.mm.pluginsdk.ui.applet.e.b(this.mController, getString(R.l.eEB), getString(R.l.eCm), getString(R.l.dGA), new 35(this, stringExtra));
                        return;
                    }
                }
                return;
            case 2:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            case 4:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("room_name");
                    if (!bh.ov(stringExtra)) {
                        com.tencent.mm.sdk.b.a.xef.m(new sc());
                        this.jLe.dc(stringExtra);
                        ar.Hg();
                        com.tencent.mm.z.c.EY().Q(this.jLe);
                        axI();
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (i2 == 0) {
                    this.kZZ = -1;
                    return;
                }
                return;
            case 7:
                if (intent != null) {
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (stringExtra != null && !stringExtra.equals("")) {
                        k gVar = new com.tencent.mm.plugin.chatroom.d.g(this.iQs, bh.F(stringExtra.split(",")));
                        getString(R.l.dGO);
                        this.iln = h.a(this, getString(R.l.eEY), true, new 19(this, gVar));
                        ar.CG().a(gVar, 0);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int XB() {
        return R.o.fbY;
    }

    protected final void initView() {
        this.ilB = this.yjd;
        String str;
        if (this.fzz) {
            com.tencent.mm.g.b.af WO;
            q hD;
            if (this.kZQ == 0) {
                setMMTitle(getString(R.l.eGz));
            } else {
                if (this.kZS != null) {
                    this.kZQ = this.kZS.Ms().size();
                }
                setMMTitle(getString(R.l.eiu, new Object[]{getString(R.l.eGz), Integer.valueOf(this.kZQ)}));
            }
            str = null;
            if (this.kZS != null) {
                str = this.kZS.field_roomowner;
                this.kZQ = this.kZS.Ms().size();
            }
            if (bh.ov(str)) {
                this.kZO = false;
                this.kZP = false;
            } else {
                this.kZO = true;
                this.kZP = str.equals(com.tencent.mm.z.q.FS());
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
            this.kZG = (ContactListExpandPreference) this.ilB.YN("roominfo_contact_anchor");
            this.kZG.a(this.ilB, this.kZG.ibD);
            this.kZF = (NormalIconPreference) this.ilB.YN("del_selector_btn");
            this.kZE = (NormalIconPreference) this.ilB.YN("add_selector_btn");
            this.kZC = (SignaturePreference) this.ilB.YN("room_name");
            this.kZB = (RoomCardPreference) this.ilB.YN("room_card");
            this.kZD = this.ilB.YN("see_room_member");
            this.kZH = (CheckBoxPreference) this.ilB.YN("room_notify_new_msg");
            this.kZI = (CheckBoxPreference) this.ilB.YN("room_save_to_contact");
            this.kZJ = (CheckBoxPreference) this.ilB.YN("room_placed_to_the_top");
            this.kZK = (SignaturePreference) this.ilB.YN("room_nickname");
            this.kZG.la(true).lb(true).cba();
            if (!this.kZP) {
                this.ilB.bk("del_selector_btn", true);
            } else if (m.gl(this.iQs) > 2) {
                this.ilB.bk("manage_room", false);
                if (this.kZS != null) {
                    this.kZG.St(this.kZS.field_roomowner);
                    if (!bh.ov(this.kZS.field_roomowner)) {
                        this.kZG.vol.vnx.vob = true;
                    }
                }
                this.kZG.caY();
                this.kZG.cbb();
                this.ilB.bk("add_selector_btn", true);
                this.ilB.bk("del_selector_btn", true);
                this.ilB.bk("room_name", false);
                this.ilB.bk("room_qr_code", false);
                this.ilB.bk("chatroom_info_chexboxes", true);
                this.ilB.bk("room_card", false);
                this.ilB.bk("room_upgrade_entry", true);
                if ((!this.kZP || this.kZQ < com.tencent.mm.pluginsdk.ui.applet.h.vnG) && (!this.kZP || this.kZQ < com.tencent.mm.pluginsdk.ui.applet.h.vnG - 1)) {
                    this.ilB.bk("see_room_member", true);
                } else {
                    this.ilB.bk("see_room_member", false);
                    this.kZD.setTitle(getString(R.l.eJe, new Object[]{Integer.valueOf(this.kZQ)}));
                }
                this.kZM = (AppBrandLoadIconPreference) this.ilB.YN("chat_room_app_brand");
                this.kZM.jRw = this.iQs;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
                if (this.gZO == null) {
                    this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                if (this.kZJ != null) {
                    if (this.jLe == null) {
                        ar.Hg();
                        this.gZO.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.z.c.Fd().Xf(this.jLe.field_username)).commit();
                    } else {
                        this.gZO.edit().putBoolean("room_placed_to_the_top", false).commit();
                    }
                }
                this.ilB.notifyDataSetChanged();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
                if (this.gZO == null) {
                    this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                if (this.kZI != null) {
                    ar.Hg();
                    WO = com.tencent.mm.z.c.EY().WO(this.iQs);
                    if (WO != null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                        if (this.gZO == null) {
                            this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
                        }
                        ar.Hg();
                        hD = com.tencent.mm.z.c.Fh().hD(this.iQs);
                        if (hD != null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                        } else {
                            this.kZN = hD.chV();
                            this.kZL = (CheckBoxPreference) this.ilB.YN("room_msg_show_username");
                            if (this.kZL != null) {
                                this.gZO.edit().putBoolean("room_msg_show_username", this.kZN).commit();
                            }
                            this.ilB.notifyDataSetChanged();
                        }
                        ar.Hg();
                        this.kZT = com.tencent.mm.z.c.Fa().EP(this.iQs);
                    } else {
                        this.gZO.edit().putBoolean("room_save_to_contact", com.tencent.mm.l.a.fZ(WO.field_type)).commit();
                    }
                }
                this.ilB.notifyDataSetChanged();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                if (this.gZO == null) {
                    this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                ar.Hg();
                hD = com.tencent.mm.z.c.Fh().hD(this.iQs);
                if (hD != null) {
                    this.kZN = hD.chV();
                    this.kZL = (CheckBoxPreference) this.ilB.YN("room_msg_show_username");
                    if (this.kZL != null) {
                        this.gZO.edit().putBoolean("room_msg_show_username", this.kZN).commit();
                    }
                    this.ilB.notifyDataSetChanged();
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                }
                ar.Hg();
                this.kZT = com.tencent.mm.z.c.Fa().EP(this.iQs);
            }
            this.ilB.bk("manage_room", true);
            if (this.kZS != null) {
                this.kZG.St(this.kZS.field_roomowner);
                if (bh.ov(this.kZS.field_roomowner)) {
                    this.kZG.vol.vnx.vob = true;
                }
            }
            this.kZG.caY();
            this.kZG.cbb();
            this.ilB.bk("add_selector_btn", true);
            this.ilB.bk("del_selector_btn", true);
            this.ilB.bk("room_name", false);
            this.ilB.bk("room_qr_code", false);
            this.ilB.bk("chatroom_info_chexboxes", true);
            this.ilB.bk("room_card", false);
            this.ilB.bk("room_upgrade_entry", true);
            if (this.kZP) {
            }
            this.ilB.bk("see_room_member", true);
            this.kZM = (AppBrandLoadIconPreference) this.ilB.YN("chat_room_app_brand");
            this.kZM.jRw = this.iQs;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
            if (this.gZO == null) {
                this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.kZJ != null) {
                if (this.jLe == null) {
                    this.gZO.edit().putBoolean("room_placed_to_the_top", false).commit();
                } else {
                    ar.Hg();
                    this.gZO.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.z.c.Fd().Xf(this.jLe.field_username)).commit();
                }
            }
            this.ilB.notifyDataSetChanged();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
            if (this.gZO == null) {
                this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.kZI != null) {
                ar.Hg();
                WO = com.tencent.mm.z.c.EY().WO(this.iQs);
                if (WO != null) {
                    this.gZO.edit().putBoolean("room_save_to_contact", com.tencent.mm.l.a.fZ(WO.field_type)).commit();
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                    if (this.gZO == null) {
                        this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
                    }
                    ar.Hg();
                    hD = com.tencent.mm.z.c.Fh().hD(this.iQs);
                    if (hD != null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                    } else {
                        this.kZN = hD.chV();
                        this.kZL = (CheckBoxPreference) this.ilB.YN("room_msg_show_username");
                        if (this.kZL != null) {
                            this.gZO.edit().putBoolean("room_msg_show_username", this.kZN).commit();
                        }
                        this.ilB.notifyDataSetChanged();
                    }
                    ar.Hg();
                    this.kZT = com.tencent.mm.z.c.Fa().EP(this.iQs);
                }
            }
            this.ilB.notifyDataSetChanged();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
            if (this.gZO == null) {
                this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            ar.Hg();
            hD = com.tencent.mm.z.c.Fh().hD(this.iQs);
            if (hD != null) {
                this.kZN = hD.chV();
                this.kZL = (CheckBoxPreference) this.ilB.YN("room_msg_show_username");
                if (this.kZL != null) {
                    this.gZO.edit().putBoolean("room_msg_show_username", this.kZN).commit();
                }
                this.ilB.notifyDataSetChanged();
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
            }
            ar.Hg();
            this.kZT = com.tencent.mm.z.c.Fa().EP(this.iQs);
        } else if (this.kZA) {
            this.kZP = false;
            setMMTitle(getString(R.l.eFC));
            this.kZG = (ContactListExpandPreference) this.ilB.YN("roominfo_contact_anchor");
            this.kZG.a(this.ilB, this.kZG.ibD);
            this.kZG.la(false).lb(false);
            this.kZG.a(new 6(this));
            this.ilB.removeAll();
            this.ilB.a(new PreferenceCategory(this));
            this.ilB.a(this.kZG);
            str = this.iQs;
            final com.tencent.mm.sdk.b.b jzVar = new jz();
            jzVar.fBk.fzn = str;
            com.tencent.mm.sdk.b.a.xef.m(jzVar);
            getString(R.l.dGO);
            this.iln = h.a(this, getString(R.l.eFA), true, new OnCancelListener(this) {
                final /* synthetic */ ChatroomInfoUI lal;

                public final void onCancel(DialogInterface dialogInterface) {
                    ChatroomInfoUI.a(jzVar);
                }
            });
            this.ilB.notifyDataSetChanged();
        }
        if (this.kZG != null) {
            if (!this.fzz && this.kZA) {
                this.kZG.ad(new ArrayList());
            }
            this.nKG.setOnScrollListener(this.kZW);
            this.kZG.a(this.kZW);
            this.kZG.a(new 2(this));
            ContactListExpandPreference contactListExpandPreference = this.kZG;
            View.OnClickListener anonymousClass3 = new View.OnClickListener(this) {
                final /* synthetic */ ChatroomInfoUI lal;

                {
                    this.lal = r1;
                }

                public final void onClick(View view) {
                }
            };
            if (contactListExpandPreference.vol != null) {
                contactListExpandPreference.vol.pGO = anonymousClass3;
            }
            this.kZG.a(new ContactListExpandPreference.a(this) {
                final /* synthetic */ ChatroomInfoUI lal;

                {
                    this.lal = r1;
                }

                public final void od(int i) {
                    this.lal.axB();
                }

                public final void oe(int i) {
                    String Cb = this.lal.kZG.Cb(i);
                    String ou = bh.ou(this.lal.kZG.Cd(i));
                    if (bh.ov(ou)) {
                        ar.Hg();
                        bf EZ = com.tencent.mm.z.c.EZ().EZ(Cb);
                        if (!(EZ == null || bh.ov(EZ.field_encryptUsername))) {
                            ou = EZ.field_conRemark;
                        }
                    }
                    if (!bh.ov(Cb)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", Cb);
                        intent.putExtra("Contact_RemarkName", ou);
                        if (this.lal.fzz && this.lal.kZS != null) {
                            intent.putExtra("Contact_RoomNickname", this.lal.kZS.gu(Cb));
                        }
                        intent.putExtra("Contact_Nick", bh.ou(this.lal.kZG.Cc(i)));
                        intent.putExtra("Contact_RoomMember", true);
                        intent.putExtra("room_name", this.lal.jLe.field_username);
                        ar.Hg();
                        com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(Cb);
                        if (WO != null && ((int) WO.gJd) > 0 && com.tencent.mm.l.a.fZ(WO.field_type)) {
                            com.tencent.mm.sdk.b.b oxVar = new ox();
                            oxVar.fGO.intent = intent;
                            oxVar.fGO.username = Cb;
                            com.tencent.mm.sdk.b.a.xef.m(oxVar);
                        }
                        if (this.lal.fzz) {
                            g.pQN.a(219, 9, 1, true);
                            if (WO != null && WO.cia()) {
                                g.pQN.k(10298, WO.field_username + ",14");
                            }
                            intent.putExtra("Contact_Scene", 14);
                        } else if (this.lal.kZA) {
                            intent.putExtra("Contact_Scene", 44);
                            if (!com.tencent.mm.z.q.gr(WO.field_username)) {
                                intent.putExtra("Contact_IsLBSFriend", true);
                            }
                        }
                        intent.putExtra("Is_RoomOwner", this.lal.kZP);
                        intent.putExtra("Contact_ChatRoomId", this.lal.iQs);
                        com.tencent.mm.plugin.chatroom.a.ifs.d(intent, this.lal);
                    }
                }

                public final void axM() {
                    if (this.lal.kZG != null) {
                        this.lal.kZG.caZ();
                    }
                }

                public final void of(int i) {
                    this.lal.axA();
                }
            });
        }
        setBackBtn(new 5(this));
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 1;
        String str = preference.ibD;
        int i2;
        Intent intent;
        if (str.equals("room_name")) {
            str = com.tencent.mm.k.g.zY().getValue("ChatRoomOwnerModTopic");
            if (bh.ov(str)) {
                i2 = 0;
            } else {
                i2 = bh.VI(str);
            }
            if (bh.ov(this.kZS.field_roomowner) || r0 <= 0 || this.kZP || r0 >= this.kZQ) {
                str = "";
                if (axJ()) {
                    str = this.jLe.AQ();
                }
                intent = new Intent();
                intent.setClass(this, ModRemarkRoomNameUI.class);
                intent.putExtra("room_name", str);
                intent.putExtra("RoomInfo_Id", this.iQs);
                startActivityForResult(intent, 4);
                g.pQN.a(219, 3, 1, true);
            } else {
                h.a(this, getString(R.l.eGg, new Object[]{axC()}), null, getString(R.l.dFs), new 7(this));
            }
        } else if (str.equals("room_upgrade_entry")) {
            cp(this);
        } else if (str.equals("room_qr_code")) {
            g.pQN.a(219, 5, 1, true);
            r0 = new Intent();
            r0.putExtra("from_userName", this.iQs);
            com.tencent.mm.bm.d.b(this, "setting", ".ui.setting.SelfQRCodeUI", r0);
        } else if (str.equals("room_card")) {
            if (!bh.ov(m.gn(this.iQs)) || this.kZP) {
                r0 = new Intent();
                r0.setClass(this, RoomCardUI.class);
                r0.putExtra("RoomInfo_Id", this.iQs);
                r0.putExtra("room_name", this.kZB.iVW.toString());
                this.kZQ = m.gj(this.iQs).size();
                r0.putExtra("room_member_count", this.kZQ);
                r0.putExtra("room_owner_name", axC());
                r0.putExtra("room_notice", m.gn(this.iQs));
                r0.putExtra("room_notice_publish_time", m.gp(this.iQs));
                r0.putExtra("room_notice_editor", m.go(this.iQs));
                r0.putExtra("Is_RoomOwner", this.kZP);
                startActivityForResult(r0, 6);
            } else {
                h.a(this, getString(R.l.eEQ), null, getString(R.l.eER), null, null, null);
            }
        } else if (str.equals("room_notify_new_msg")) {
            this.kTc = !this.kTc;
            if (this.fzz) {
                i2 = this.kTc ? 0 : 1;
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.k(this.iQs, i2));
                ar.Hg();
                this.jLe = com.tencent.mm.z.c.EY().WO(this.iQs);
                this.jLe.eH(i2);
                ar.Hg();
                com.tencent.mm.z.c.EY().a(this.iQs, this.jLe);
            }
            r0 = com.tencent.mm.modelstat.b.hPA;
            r2 = this.iQs;
            boolean z = this.kTc;
            if (r0.SN() && r0.ch(r2)) {
                IMBehavior iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                if (!z) {
                    i = 2;
                }
                iMBehaviorChattingOP.changeNotifyStatus = i;
                synchronized (r0.lock) {
                    r0.hPz.oplist_.add(iMBehavior);
                }
            }
            axG();
        } else if (str.equals("room_save_to_contact")) {
            if (this.gZO == null) {
                this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            ar.Hg();
            com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(this.iQs);
            if (WO != null) {
                boolean fZ = com.tencent.mm.l.a.fZ(WO.field_type);
                this.gZO.edit().putBoolean("room_save_to_contact", !fZ).commit();
                if (fZ) {
                    WO.Ah();
                    s.t(WO);
                    h.bu(this, getString(R.l.eFR));
                    com.tencent.mm.modelstat.b.hPA.J(this.iQs, false);
                } else {
                    s.q(WO);
                    h.bu(this, getString(R.l.eFZ));
                    com.tencent.mm.modelstat.b.hPA.J(this.iQs, true);
                }
                this.ilB.notifyDataSetChanged();
            }
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.laf, 0);
            if (this.jLe != null) {
                ar.Hg();
                if (com.tencent.mm.z.c.Fd().Xf(this.jLe.field_username)) {
                    s.s(this.jLe.field_username, true);
                    com.tencent.mm.modelstat.b.hPA.c(false, this.iQs, false);
                } else {
                    s.r(this.jLe.field_username, true);
                    com.tencent.mm.modelstat.b.hPA.c(false, this.iQs, true);
                }
                ar.Hg();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.z.c.Fd().Xf(this.jLe.field_username)).commit();
            }
        } else if (str.equals("room_nickname")) {
            r2 = axz();
            if (bh.ov(r2)) {
                r2 = com.tencent.mm.z.q.FU();
            }
            h.a(this.mController.xIM, getString(R.l.eFL), r2, getString(R.l.eFr), 32, new 9(this, r2));
        } else if (str.equals("room_msg_show_username")) {
            getSharedPreferences(this.laf, 0).edit().putBoolean("room_msg_show_username", !this.kZN).commit();
            this.kZN = !this.kZN;
            this.kZR = true;
        } else if (str.equals("room_set_chatting_background")) {
            r0 = new Intent();
            r0.putExtra("isApplyToAll", false);
            r0.putExtra("username", this.jLe.field_username);
            com.tencent.mm.bm.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", r0, 2);
        } else if (str.equals("room_search_chatting_content")) {
            r0 = new Intent();
            r0.putExtra("detail_username", this.iQs);
            com.tencent.mm.bm.d.b(this, "search", ".ui.FTSChattingConvUI", r0);
            if (this.kZS == null || this.kZS.Ms() == null) {
                i2 = 0;
            } else {
                i2 = this.kZS.Ms().size();
            }
            g.pQN.h(14569, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1)});
        } else if (str.equals("room_clear_chatting_history")) {
            h.a(this.mController.xIM, getString(R.l.eiz), "", getString(R.l.dEo), getString(R.l.dEn), new OnClickListener(this) {
                final /* synthetic */ ChatroomInfoUI lal;

                {
                    this.lal = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    String str;
                    g.pQN.h(14553, new Object[]{Integer.valueOf(3), Integer.valueOf(2), this.lal.iQs});
                    ChatroomInfoUI.lai = false;
                    Context context = this.lal;
                    this.lal.getString(R.l.dGO);
                    ProgressDialog a = h.a(context, this.lal.getString(R.l.dHc), true, new a());
                    if (com.tencent.mm.z.l.ga(this.lal.jLe.field_username)) {
                        com.tencent.mm.plugin.chatroom.a.ift.cB(this.lal.jLe.field_username);
                    }
                    if (ChatroomInfoUI.lai) {
                        str = null;
                    } else {
                        str = com.tencent.mm.pluginsdk.wallet.e.SZ(this.lal.jLe.field_username);
                    }
                    if (bh.ov(str)) {
                        ba.a(this.lal.jLe.field_username, new ba.a(this.lal, a) {
                            final /* synthetic */ ChatroomInfoUI lal;

                            public final boolean HB() {
                                return ChatroomInfoUI.lai;
                            }

                            public final void HA() {
                                if (r3 != null) {
                                    r3.dismiss();
                                }
                            }
                        });
                        return;
                    }
                    a.dismiss();
                    h.a(this.lal, false, this.lal.getString(R.l.eWf, new Object[]{str}), null, this.lal.getString(R.l.enD), this.lal.getString(R.l.dTR), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass10 lan;

                        {
                            this.lan = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.pQN.h(14553, new Object[]{Integer.valueOf(3), Integer.valueOf(4), this.lan.lal.iQs});
                            this.lan.lal.isDeleteCancel = true;
                            if (this.lan.lal.kZV) {
                                this.lan.lal.finish();
                                return;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("Chat_User", this.lan.lal.jLe.field_username);
                            intent.addFlags(67108864);
                            com.tencent.mm.bm.d.a(this.lan.lal, ".ui.chatting.ChattingUI", intent);
                        }
                    }, new 2(this, a), -1, R.e.brm);
                }
            }, null, R.e.brm);
        } else if (str.equals("room_report_it")) {
            r0 = new Intent();
            r0.putExtra("k_username", this.iQs);
            r0.putExtra("showShare", false);
            r0.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(36)}));
            com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", r0);
            r0 = com.tencent.mm.modelstat.b.hPA;
            String str2 = this.iQs;
            if (r0.SN() && r0.ch(str2)) {
                IMBehavior iMBehavior2 = new IMBehavior();
                iMBehavior2.opType = 1;
                iMBehavior2.chattingOp = new IMBehaviorChattingOP();
                iMBehavior2.chattingOp.expose = 1;
                synchronized (r0.lock) {
                    r0.hPz.oplist_.add(iMBehavior2);
                }
            }
        } else if (str.equals("room_del_quit")) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", " quit " + this.iQs);
            com.tencent.mm.sdk.b.b riVar = new ri();
            riVar.fJc.fJe = true;
            com.tencent.mm.sdk.b.a.xef.m(riVar);
            boolean z2 = !bh.ov(this.iQs) && this.iQs.equals(riVar.fJd.fJg);
            if (z2) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.iQs);
            } else if (this.kZP && this.kZS.Ms().size() > 2) {
                h.a(this, "", new String[]{getString(R.l.eFP)}, getString(R.l.dEn), new 13(this));
            }
            h.a(this.mController.xIM, getString(R.l.dYn), "", getString(R.l.dFU), getString(R.l.dEn), new 14(this, z2), null, R.e.brm);
        } else if (str.equals("add_selector_btn")) {
            axA();
        } else if (str.equals("del_selector_btn")) {
            axB();
        } else if (str.equals("see_room_member")) {
            intent = new Intent();
            intent.setClass(this.mController.xIM, SeeRoomMemberUI.class);
            intent.putExtra("Block_list", com.tencent.mm.z.q.FS());
            List gj = m.gj(this.iQs);
            if (gj != null) {
                this.kZQ = gj.size();
            }
            intent.putExtra("Chatroom_member_list", bh.d(gj, ","));
            intent.putExtra("RoomInfo_Id", this.iQs);
            intent.putExtra("room_owner_name", this.kZS.field_roomowner);
            intent.putExtra("Is_RoomOwner", this.kZP);
            intent.putExtra("room_member_count", this.kZQ);
            intent.putExtra("Add_address_titile", getString(R.l.eGc));
            if (this.fzz) {
                intent.putExtra("Contact_Scene", 14);
            } else if (this.kZA) {
                intent.putExtra("Contact_Scene", 44);
                if (!com.tencent.mm.z.q.gr(this.jLe.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            r2 = "offset";
            View childAt = this.nKG.getChildAt(0);
            intent.putExtra(r2, childAt == null ? 0 : -childAt.getTop());
            intent.putExtra("first_pos", this.nKG.getFirstVisiblePosition());
            intent.putExtra("room_name", this.jLe.field_username);
            startActivityForResult(intent, 5);
            this.kZZ = 5;
        } else if (str.equals("manage_room")) {
            r0 = new Intent();
            r0.setClass(this.mController.xIM, ManageChatroomUI.class);
            r0.putExtra("RoomInfo_Id", this.iQs);
            r0.putExtra("room_owner_name", this.kZS.field_roomowner);
            startActivity(r0);
        } else if (str.equals("chat_room_app_brand")) {
            r0 = new Intent();
            r0.putExtra("Chat_User", this.iQs);
            com.tencent.mm.bm.d.a(this, ".ui.chatting.gallery.AppBrandHistoryListUI", r0);
            g.pQN.a(219, 25, 1, true);
        }
        return false;
    }

    private String axz() {
        if (this.kZS == null) {
            return "";
        }
        return this.kZS.field_selfDisplayName;
    }

    private void eh(boolean z) {
        if (com.tencent.mm.z.l.ga(this.iQs)) {
            com.tencent.mm.plugin.chatroom.a.ift.cB(this.iQs);
        }
        ba.a(this.iQs, new ba.a(this) {
            final /* synthetic */ ChatroomInfoUI lal;

            {
                this.lal = r1;
            }

            public final boolean HB() {
                return this.lal.isDeleteCancel;
            }

            public final void HA() {
                if (this.lal.iln != null) {
                    this.lal.iln.dismiss();
                }
            }
        });
        ar.Hg();
        com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.b(this.iQs));
        ar.Hg();
        com.tencent.mm.z.c.Fd().WX(this.iQs);
        ar.Hg();
        com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.c(this.iQs));
        if (z) {
            ar.Hg();
            com.tencent.mm.plugin.messenger.foundation.a.a.d EX = com.tencent.mm.z.c.EX();
            ar.Hg();
            EX.b(new p((String) com.tencent.mm.z.c.CU().get(2, null), this.iQs));
        }
        m.gh(this.iQs);
        if (!z) {
            this.handler.post(new 28(this));
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.chatroom.a.ifs.s(intent, this.mController.xIM);
        finish();
    }

    private void axA() {
        List gj;
        if (this.fzz) {
            g.pQN.a(219, 7, 1, true);
            gj = m.gj(this.iQs);
            String d = bh.d(gj, ",");
            if (gj != null) {
                this.kZQ = gj.size();
            }
            Intent intent = new Intent();
            intent.putExtra("titile", getString(R.l.dDo));
            intent.putExtra("list_type", 1);
            intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.yTE);
            intent.putExtra("always_select_contact", d);
            intent.putExtra("scene", 3);
            com.tencent.mm.bm.d.a(this, ".ui.contact.SelectContactUI", intent, 1);
            return;
        }
        g.pQN.k(10170, "1");
        gj = new LinkedList();
        gj.add(this.iQs);
        gj.add(com.tencent.mm.z.q.FS());
        String d2 = bh.d(gj, ",");
        Intent intent2 = new Intent();
        intent2.putExtra("titile", getString(R.l.dDn));
        intent2.putExtra("list_type", 0);
        intent2.putExtra("list_attr", com.tencent.mm.ui.contact.s.yTF);
        intent2.putExtra("always_select_contact", d2);
        com.tencent.mm.bm.d.a(this, ".ui.contact.SelectContactUI", intent2);
    }

    private void axB() {
        g.pQN.a(219, 8, 1, true);
        List gj = m.gj(this.iQs);
        String d = bh.d(gj, ",");
        this.kZQ = gj.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", this.iQs);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", d);
        intent.putExtra("room_member_count", this.kZQ);
        intent.putExtra("Is_RoomOwner", this.kZP);
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.yTE);
        intent.putExtra("room_name", this.jLe.field_username);
        intent.putExtra("room_owner_name", this.kZS.field_roomowner);
        intent.setClass(this, SelectDelRoomMemberUI.class);
        startActivityForResult(intent, 7);
    }

    private void n(String str, String str2, int i) {
        if (s.gx(str)) {
            boolean z;
            if (bh.ou(com.tencent.mm.z.q.FS()).equals(str)) {
                z = true;
            } else {
                List<String> gj = m.gj(this.iQs);
                if (gj == null) {
                    z = false;
                } else {
                    z = false;
                    for (String equals : gj) {
                        boolean z2;
                        if (equals.equals(str)) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        z = z2;
                    }
                }
            }
            if (z) {
                h.b(this, getString(R.l.dCA), getString(R.l.dGO), true);
                return;
            }
            List F = bh.F(str.split(","));
            if (F != null) {
                k dVar = new com.tencent.mm.plugin.chatroom.d.d(this.iQs, F, str2);
                getString(R.l.dGO);
                this.iln = h.a(this, getString(i), true, new 20(this, dVar));
                ar.CG().a(dVar, 0);
                return;
            }
            return;
        }
        h.b(this, getString(R.l.eFH), getString(R.l.dGO), true);
    }

    private void a(int i, com.tencent.mm.plugin.chatroom.d.d dVar) {
        String str = "";
        String str2 = "";
        String string = ac.getContext().getString(R.l.dQz);
        List list = dVar.kZl;
        List list2 = dVar.kZn;
        List list3 = dVar.fAT;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            boolean z;
            ar.Hg();
            q hE = com.tencent.mm.z.c.Fh().hE(this.iQs);
            if (i == -116 && axD() && !bh.ov(hE.field_roomowner)) {
                str = getString(R.l.eFE);
                str2 = getString(R.l.eFD);
                z = true;
            } else {
                z = false;
            }
            if (i == -23) {
                str = getString(R.l.eFK);
                str2 = getString(R.l.eFJ);
            }
            if (i == -109) {
                str = getString(R.l.eFG);
                str2 = getString(R.l.eFF);
            }
            if (i == -122) {
                str = getString(R.l.eFK);
                str2 = getString(R.l.eFI, new Object[]{axC(), Integer.valueOf(hE.chU())});
            }
            list2 = dVar.kZm;
            if (list3 == null || list3.size() <= 0 || (list3.size() != dVar.fzQ && (list2 == null || list2.size() <= 0 || dVar.fzQ != list3.size() + list2.size()))) {
                list2 = dVar.kZm;
                if (list2 != null && list2.size() > 0) {
                    str2 = str2 + getString(R.l.eiF, new Object[]{bh.d(ar(list2), string)});
                }
                list2 = dVar.fAS;
                if (list2 != null && list2.size() > 0) {
                    str = getString(R.l.dCy);
                    str2 = str2 + getString(R.l.eiP, new Object[]{bh.d(ar(list2), string)});
                }
                list2 = dVar.fAQ;
                if (list2 != null && list2.size() > 0) {
                    str = getString(R.l.dCy);
                    str2 = str2 + getString(R.l.eiI, new Object[]{bh.d(ar(list2), string)});
                }
                Collection collection = dVar.kZn;
                List arrayList = new ArrayList();
                if (!(list3 == null || list3.isEmpty())) {
                    arrayList.addAll(list3);
                }
                if (collection != null && collection.size() > 0) {
                    arrayList.addAll(collection);
                }
                if (i != -2028) {
                    d(dVar.chatroomName, list3);
                }
                str2 = str2 + getString(R.l.eit, new Object[]{bh.d(ar(arrayList), string)});
                if (list3 != null && list3.isEmpty()) {
                    str2 = null;
                }
                if (str2 != null && str2.length() > 0) {
                    if (z) {
                        h.a(this, str2, str, new 24(this), null);
                        return;
                    } else {
                        h.b(this, str2, str, true);
                        return;
                    }
                }
                return;
            }
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < list3.size(); i2++) {
                linkedList.add(list3.get(i2));
            }
            str2 = "";
            String string2 = ac.getContext().getString(R.l.dQz);
            if (!(list2 == null || list2.isEmpty())) {
                str2 = getString(R.l.eis, new Object[]{bh.d(ar(list2), string2)}) + "\n";
            }
            if (!linkedList.isEmpty()) {
                str2 = str2 + getString(R.l.eit, new Object[]{bh.d(ar(linkedList), string2)});
            }
            h.a(this, str2, "", getString(R.l.ein), new 25(this));
            d(dVar.chatroomName, linkedList);
            return;
        }
        string = getString(R.l.dCz);
        String string3 = getString(R.l.epF);
        String string4 = getString(R.l.dEn);
        21 21 = new 21(this, dVar, list3, list, list2);
        h.a(this, string, null, string3, string4, 21, new 23(this));
    }

    private String axC() {
        String str;
        String str2 = null;
        ar.Hg();
        com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(this.kZS.field_roomowner);
        if (WO == null || ((int) WO.gJd) <= 0) {
            str = null;
        } else {
            str = WO.field_conRemark;
        }
        if (bh.ov(str)) {
            str = this.kZS.field_roomowner;
            if (this.kZS != null) {
                str2 = this.kZS.gu(str);
            }
        } else {
            str2 = str;
        }
        if (bh.ov(str2) && WO != null && ((int) WO.gJd) > 0) {
            str2 = WO.AP();
        }
        if (bh.ov(str2)) {
            return this.kZS.field_roomowner;
        }
        return str2;
    }

    private static boolean axD() {
        return bh.getInt(com.tencent.mm.k.g.zY().getValue("ChatroomGlobalSwitch"), 1) == 1;
    }

    private void cp(Context context) {
        if (context != null && axD()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", getString(R.l.dQv, new Object[]{w.cfi()}));
            intent.putExtra("geta8key_username", com.tencent.mm.z.q.FS());
            intent.putExtra("showShare", false);
            com.tencent.mm.bm.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    private void d(String str, List<String> list) {
        if (list != null && list.size() > 0) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            com.tencent.mm.z.l.a(str, linkedList, getString(R.l.dQy), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
    }

    private void updateTitle() {
        if (this.fzz) {
            this.kZQ = m.gl(this.iQs);
            if (this.kZQ == 0) {
                setMMTitle(getString(R.l.eGz));
                return;
            }
            setMMTitle(getString(R.l.eiu, new Object[]{getString(R.l.eGz), Integer.valueOf(this.kZQ)}));
        }
    }

    private void axE() {
        if (this.kZG == null) {
            return;
        }
        List gj;
        if (this.fzz) {
            ar.Hg();
            this.laj = com.tencent.mm.z.c.Fh().hG(this.iQs);
            gj = m.gj(this.iQs);
            if (gj != null) {
                this.kZQ = gj.size();
            } else {
                this.kZQ = 0;
            }
            if (this.kZQ > com.tencent.mm.pluginsdk.ui.applet.h.vnG + 1 && gj != null) {
                gj = gj.subList(0, com.tencent.mm.pluginsdk.ui.applet.h.vnG + 1);
                if (!(this.kZS == null || gj.contains(this.kZS.field_roomowner))) {
                    gj.add(0, this.kZS.field_roomowner);
                }
            }
            if (this.kZQ <= 1) {
                this.ilB.bk("del_selector_btn", true);
                this.kZG.la(true).lb(false).cba();
            } else {
                this.kZG.la(true).lb(this.kZP).cba();
            }
            this.kZG.n(this.iQs, gj);
            return;
        }
        gj = new LinkedList();
        gj.add(this.iQs);
        this.kZG.n(this.iQs, gj);
    }

    private void axF() {
        if (this.jLe != null) {
            CharSequence axz = axz();
            if (bh.ov(axz)) {
                axz = com.tencent.mm.z.q.FU();
            }
            if (bh.ov(axz)) {
                this.kZK.setSummary("");
            } else {
                SignaturePreference signaturePreference = this.kZK;
                if (axz.length() <= 0) {
                    axz = getString(R.l.eMZ);
                }
                signaturePreference.setSummary(i.a(this, axz));
            }
            if (this.ilB != null) {
                this.ilB.notifyDataSetChanged();
            }
        }
    }

    private void axG() {
        if (this.gZO == null) {
            this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.fzz) {
            this.kTc = this.jLe.fWn == 0;
        } else if (!this.kZA) {
            this.kTc = this.jLe.AI();
        }
        if (this.kTc) {
            setTitleMuteIconVisibility(0);
            if (this.kZH != null) {
                this.gZO.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            setTitleMuteIconVisibility(8);
            if (this.kZH != null) {
                this.gZO.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.ilB.notifyDataSetChanged();
    }

    private void axH() {
        if (this.jLe != null && this.kZB != null) {
            CharSequence gn = m.gn(this.iQs);
            if (gn == null || gn.length() <= 0) {
                this.kZB.fpa = false;
            } else {
                this.kZB.fpa = true;
                this.kZB.vub = i.a(this, gn);
            }
            ar.Hg();
            this.jLe = com.tencent.mm.z.c.EY().WO(this.iQs);
            if (axJ()) {
                gn = this.jLe.AQ();
                RoomCardPreference roomCardPreference = this.kZB;
                if (gn.length() <= 0) {
                    gn = getString(R.l.eMZ);
                }
                roomCardPreference.iVW = i.a(this, gn);
            } else {
                this.kZB.iVW = getString(R.l.eFw);
            }
            this.ilB.notifyDataSetChanged();
        }
    }

    private void axI() {
        if (this.jLe != null && this.kZC != null) {
            ar.Hg();
            this.jLe = com.tencent.mm.z.c.EY().WO(this.iQs);
            if (axJ()) {
                CharSequence AQ = this.jLe.AQ();
                SignaturePreference signaturePreference = this.kZC;
                if (AQ.length() <= 0) {
                    AQ = getString(R.l.eMZ);
                }
                signaturePreference.setSummary(i.a(this, AQ));
                if (this.ilB != null) {
                    this.ilB.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.kZC.setSummary(getString(R.l.eFw));
        }
    }

    private boolean axJ() {
        String str = this.jLe.field_nickname;
        return !bh.ov(str) && str.length() <= 50;
    }

    public static ArrayList<x> aq(List<aok> list) {
        ArrayList<x> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (aok com_tencent_mm_protocal_c_aok : list) {
            x xVar = new x();
            xVar.setUsername(com_tencent_mm_protocal_c_aok.ksU);
            xVar.dc(com_tencent_mm_protocal_c_aok.kub);
            arrayList.add(xVar);
        }
        return arrayList;
    }

    private static List<String> ar(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ar.Hj()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ar.Hg();
            com.tencent.mm.l.a WO = com.tencent.mm.z.c.EY().WO(obj2);
            if (!(WO == null || ((int) WO.gJd) == 0)) {
                obj2 = WO.AQ();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "pre is " + this.kZQ);
        this.kZQ = m.gl(this.iQs);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "now is " + this.kZQ);
        if (this.iln != null) {
            this.iln.dismiss();
        }
        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
        if (eA != null) {
            eA.a(this, null, null);
        } else if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0) {
                switch (kVar.getType()) {
                    case 120:
                        a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
                        axK();
                        break;
                    case 179:
                        axK();
                        break;
                    case 610:
                        if (this.kZZ != 5) {
                            h.b(this, getString(R.l.epR), null, true);
                            break;
                        }
                        break;
                }
                if (this.kZS != null) {
                    this.kZQ = this.kZS.Ms().size();
                }
                if ((!this.kZP && this.kZQ >= com.tencent.mm.pluginsdk.ui.applet.h.vnG) || (this.kZP && this.kZQ >= com.tencent.mm.pluginsdk.ui.applet.h.vnG - 1)) {
                    this.ilB.bk("see_room_member", false);
                    this.kZD.setTitle(getString(R.l.eJe));
                }
            }
            updateTitle();
        } else {
            if (kVar.getType() == 120 && this.kZZ != 5) {
                a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
                axK();
            }
            if (kVar.getType() == 179 && this.kZZ != 5 && i2 == -66) {
                h.b(this, getString(R.l.dYo), getString(R.l.dGO), true);
                axK();
            }
            if (kVar.getType() == 610 && this.kZZ != 5) {
                h.b(this, getString(R.l.epQ), getString(R.l.dGO), true);
            }
        }
    }

    private void axK() {
        if (this.kZG != null) {
            if (this.fzz) {
                axE();
            } else if (!this.kZA) {
                List linkedList = new LinkedList();
                linkedList.add(this.iQs);
                this.kZG.n(this.iQs, linkedList);
            }
            this.kZG.notifyChanged();
        }
        if (!this.kZP || m.gl(this.iQs) <= 2) {
            this.ilB.bk("manage_room", true);
        } else {
            this.ilB.bk("manage_room", false);
        }
        if ((this.kZP || this.kZQ < com.tencent.mm.pluginsdk.ui.applet.h.vnG) && (!this.kZP || this.kZQ < com.tencent.mm.pluginsdk.ui.applet.h.vnG - 1)) {
            this.ilB.bk("see_room_member", true);
        } else {
            this.ilB.bk("see_room_member", false);
            this.kZD.setTitle(getString(R.l.eJe, new Object[]{Integer.valueOf(this.kZQ)}));
        }
        this.ilB.notifyDataSetChanged();
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (!bh.ov(str)) {
            if (str.endsWith("@chatroom")) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "event:" + str);
                if (this.fzz && str.equals(this.iQs)) {
                    ar.Dm().F(new 29(this));
                }
                axK();
                return;
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "event:" + str + " cancel");
        }
    }

    public final void F(String str, String str2, String str3) {
        if (str.equals(this.iQs) && this.kZG != null) {
            this.kZG.notifyChanged();
        }
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
