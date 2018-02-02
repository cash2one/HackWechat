package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.d.a;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.a.u;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.hj;
import com.tencent.mm.protocal.c.hl;
import com.tencent.mm.protocal.c.hm;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.i;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BizChatroomInfoUI extends MMPreference implements e, n {
    private static boolean lai = false;
    private int fromScene;
    private SharedPreferences gZO = null;
    private f ilB;
    private ProgressDialog iln = null;
    private boolean isDeleteCancel = false;
    private long kGB;
    private String kGH;
    private boolean kTc;
    private SignaturePreference kZC;
    private ContactListExpandPreference kZG;
    private CheckBoxPreference kZH;
    private CheckBoxPreference kZI;
    private CheckBoxPreference kZJ;
    private boolean kZP = false;
    private int kZQ;
    private d kZW = new d(new OnScrollListener(this) {
        final /* synthetic */ BizChatroomInfoUI yoK;

        {
            this.yoK = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            o.PA().bp(i);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean kZX = false;
    private j piK = null;
    private a ynH = new 3(this);
    private c ync = null;
    private String yoE;
    private boolean yoF = false;
    private boolean yoG;
    private boolean yoH;
    private int yoI;
    private j yoJ = null;

    static /* synthetic */ void a(BizChatroomInfoUI bizChatroomInfoUI, int i) {
        boolean z = true;
        j Fm = bizChatroomInfoUI.Fm(i);
        if (Fm == null) {
            String str = "MicroMsg.BizChatroomInfoUI";
            String str2 = "onItemNormalClick userInfo == null:%s";
            Object[] objArr = new Object[1];
            if (Fm != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick field_userId:%s", Fm.field_userId);
        String str3 = Fm.field_userId;
        hm hmVar = new hm();
        hl hlVar = new hl();
        hlVar.vNr = str3;
        hmVar.vNs.add(hlVar);
        bizChatroomInfoUI.a(null, hmVar);
    }

    static /* synthetic */ boolean a(BizChatroomInfoUI bizChatroomInfoUI, String str, CharSequence charSequence) {
        String trim = charSequence == null ? "" : charSequence.toString().trim();
        if (trim.equals(str)) {
            x.d("MicroMsg.BizChatroomInfoUI", "same room name return");
            return true;
        } else if (trim.length() == 0) {
            h.bu(bizChatroomInfoUI.mController.xIM, bizChatroomInfoUI.getString(R.l.eEV));
            return false;
        } else {
            com.tencent.mm.sdk.b.a.xef.m(new sc());
            bizChatroomInfoUI.yoE = bizChatroomInfoUI.ync.field_chatName;
            bizChatroomInfoUI.yoI = bizChatroomInfoUI.ync.field_bitFlag;
            bizChatroomInfoUI.ync.field_chatName = trim;
            y.Mh().b(bizChatroomInfoUI.ync);
            hj hjVar = new hj();
            hjVar.vNk = bizChatroomInfoUI.ync.field_bizChatServId;
            hjVar.name = trim;
            hjVar.vNm = bizChatroomInfoUI.yoI;
            y.Ml();
            com.tencent.mm.ag.a.h.a(bizChatroomInfoUI.ync.field_brandUserName, hjVar, (n) bizChatroomInfoUI);
            bizChatroomInfoUI.axI();
            bizChatroomInfoUI.ilB.notifyDataSetChanged();
            return true;
        }
    }

    static /* synthetic */ void c(BizChatroomInfoUI bizChatroomInfoUI) {
        Intent intent = new Intent();
        if (bizChatroomInfoUI.yoF) {
            if (bh.ov(bizChatroomInfoUI.ync.field_addMemberUrl)) {
                x.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
                Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.dMp), 0).show();
                return;
            }
            intent.putExtra("rawUrl", bizChatroomInfoUI.ync.field_addMemberUrl);
        } else if (bizChatroomInfoUI.piK == null || bh.ov(bizChatroomInfoUI.piK.field_addMemberUrl)) {
            x.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
            Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.dMp), 0).show();
            return;
        } else {
            intent.putExtra("rawUrl", bizChatroomInfoUI.piK.field_addMemberUrl);
        }
        intent.putExtra("useJs", true);
        com.tencent.mm.bm.d.b(bizChatroomInfoUI.mController.xIM, "webview", ".ui.tools.WebViewUI", intent, 1);
    }

    static /* synthetic */ void d(BizChatroomInfoUI bizChatroomInfoUI) {
        x.i("MicroMsg.BizChatroomInfoUI", "deleteChatroom");
        y.Ml();
        g.Di().gPJ.a(new u(bizChatroomInfoUI.kGH, bizChatroomInfoUI.ync.field_bizChatServId), 0);
        bizChatroomInfoUI.isDeleteCancel = false;
        bizChatroomInfoUI.getString(R.l.dGO);
        i.a(bizChatroomInfoUI.kGH, bizChatroomInfoUI.kGB, new 2(bizChatroomInfoUI, h.a(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.dHc), true, new 11(bizChatroomInfoUI))));
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Contact_User", bizChatroomInfoUI.kGH);
        com.tencent.mm.bm.d.b(bizChatroomInfoUI.mController.xIM, "brandservice", ".ui.BizChatConversationUI", intent);
        bizChatroomInfoUI.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y.Mh().a(this.ynH, Looper.getMainLooper());
        this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
        this.kGH = getIntent().getStringExtra("Chat_User");
        this.kGB = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.ync = y.Mh().ag(this.kGB);
        this.yoE = this.ync.field_chatName;
        this.yoF = com.tencent.mm.ag.a.e.kn(this.ync.field_bizChatServId);
        if (!this.yoF) {
            this.piK = y.Mj().ca(this.ync.field_bizChatServId);
        }
        this.yoJ = y.Mj().kx(this.kGH);
        initView();
        if (this.ync != null && this.ync.field_bizChatServId != null && this.kGH != null) {
            if (this.ync.Mt()) {
                y.Ml();
                com.tencent.mm.ag.a.h.ak(this.ync.field_bizChatServId, this.kGH);
                return;
            }
            y.Ml();
            com.tencent.mm.ag.a.h.a(this.ync.field_bizChatServId, this.kGH, (n) this);
        }
    }

    public void onResume() {
        axI();
        updateTitle();
        axG();
        bjy();
        cqP();
        axE();
        this.ilB.notifyDataSetChanged();
        super.onResume();
        if (!this.kZX) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!bh.ov(stringExtra)) {
                int YP = this.ilB.YP(stringExtra);
                setSelection(YP - 3);
                new af().postDelayed(new 4(this, YP), 10);
            }
            this.kZX = true;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        com.tencent.mm.ui.g.a.dismiss();
        com.tencent.mm.ui.g.a.dismiss();
        y.Mh().a(this.ynH);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    boolean YY;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        x.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        x.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", string);
                        if (this.yoF) {
                            YY = YY(string);
                        } else {
                            wj wjVar = new wj();
                            c cVar = new c();
                            cVar.field_addMemberUrl = this.yoJ != null ? this.yoJ.field_addMemberUrl : null;
                            cVar.field_brandUserName = this.kGH;
                            if (com.tencent.mm.ag.a.e.a(cVar, string, this.piK.field_userId, wjVar)) {
                                y.Ml();
                                com.tencent.mm.ag.a.n a = com.tencent.mm.ag.a.h.a(this.kGH, wjVar, (n) this);
                                getString(R.l.dGO);
                                this.iln = h.a(this, getString(R.l.dCE), true, new 5(this, a));
                                YY = true;
                            } else {
                                YY = false;
                            }
                        }
                    } else {
                        YY = false;
                    }
                    if (!YY) {
                        Toast.makeText(this, getString(R.l.eES), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean YY(String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                hm hmVar = new hm();
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar;
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                    j ca = y.Mj().ca(string);
                    if (ca == null) {
                        ca = new j();
                        ca.field_userId = string;
                        jVar = ca;
                    } else {
                        jVar = ca;
                    }
                    jVar.field_userName = jSONObject.getString("nick_name");
                    jVar.field_brandUserName = this.kGH;
                    jVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject.getString("profile_url");
                    jVar.field_UserVersion = jSONObject.getInt("ver");
                    jVar.field_addMemberUrl = this.yoJ != null ? this.yoJ.field_addMemberUrl : null;
                    if (!y.Mj().b(jVar)) {
                        y.Mj().a(jVar);
                    }
                    hl hlVar = new hl();
                    hlVar.vNr = jVar.field_userId;
                    hmVar.vNs.add(hlVar);
                }
                a(hmVar, null);
                return true;
            } catch (Throwable e) {
                x.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", e.getMessage());
                x.printErrStackTrace("MicroMsg.BizChatroomInfoUI", e, "", new Object[0]);
            }
        }
        return false;
    }

    private void a(hm hmVar, hm hmVar2) {
        x.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
        String string = hmVar == null ? getString(R.l.eEY) : getString(R.l.dCE);
        y.Ml();
        com.tencent.mm.ag.a.x a = com.tencent.mm.ag.a.h.a(this.ync.field_brandUserName, this.ync.field_bizChatServId, hmVar, hmVar2, this);
        getString(R.l.dGO);
        this.iln = h.a(this, string, true, new 6(this, a));
    }

    public final int XB() {
        return R.o.fbi;
    }

    protected final void initView() {
        this.ilB = this.yjd;
        String str = this.ync.field_ownerUserId;
        this.kZQ = this.ync.Ms().size();
        if (bh.ov(str)) {
            this.kZP = false;
        } else {
            this.kZP = str.equals(y.Mj().cb(this.kGH));
        }
        x.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
        this.kZG = (ContactListExpandPreference) this.ilB.YN("roominfo_contact_anchor");
        this.kZG.a(this.ilB, this.kZG.ibD);
        this.kZC = (SignaturePreference) this.ilB.YN("room_name");
        this.kZH = (CheckBoxPreference) this.ilB.YN("room_notify_new_msg");
        this.kZJ = (CheckBoxPreference) this.ilB.YN("room_placed_to_the_top");
        this.kZI = (CheckBoxPreference) this.ilB.YN("room_save_to_contact");
        ContactListExpandPreference contactListExpandPreference = this.kZG;
        boolean z = this.yoF;
        if (contactListExpandPreference.vol != null) {
            contactListExpandPreference.vol.vnx.vnM = z;
        }
        contactListExpandPreference = this.kZG;
        z = this.kZP;
        if (contactListExpandPreference.vol != null) {
            contactListExpandPreference.vol.vnx.vnL = z;
        }
        if (this.kZP) {
            this.kZG.la(true).lb(true);
        } else {
            this.kZG.la(true).lb(false);
        }
        this.kZG.St(this.ync.field_ownerUserId);
        this.kZG.caY();
        this.kZG.cbb();
        if (!this.yoF) {
            this.ilB.bk("room_save_to_contact", true);
            this.ilB.bk("room_name", true);
            this.ilB.bk("room_del_quit", true);
        }
        cqP();
        bjy();
        axG();
        if (this.kZG != null) {
            this.nKG.setOnScrollListener(this.kZW);
            this.kZG.a(this.kZW);
            this.kZG.a(new 7(this));
        }
        setBackBtn(new 8(this));
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.ibD;
        if (str.equals("room_name")) {
            String str2 = "";
            if (axJ()) {
                str2 = this.ync.field_chatName;
            }
            h.a(this.mController.xIM, getString(R.l.eFM), str2, "", 32, new 9(this, str2));
        } else if (str.equals("room_notify_new_msg")) {
            this.kTc = !this.kTc;
            x(this.kTc, 1);
            axG();
        } else if (str.equals("room_placed_to_the_top")) {
            if (this.yoH) {
                z = false;
            }
            this.yoH = z;
            x(this.yoH, 16);
            if (this.yoH) {
                y.Mi().aW(this.ync.field_bizChatLocalId);
            } else {
                y.Mi().aX(this.ync.field_bizChatLocalId);
            }
        } else if (str.equals("room_del_quit")) {
            x.d("MicroMsg.BizChatroomInfoUI", " quit " + this.kGB);
            h.a(this.mController.xIM, getString(R.l.dYn), "", new 10(this), null);
        } else if (str.equals("room_save_to_contact")) {
            if (this.yoG) {
                z = false;
            }
            this.yoG = z;
            x(this.yoG, 8);
            cqP();
        }
        return false;
    }

    private void x(boolean z, int i) {
        this.yoI = this.ync.field_bitFlag;
        this.yoE = this.ync.field_chatName;
        if (this.yoF) {
            c cVar;
            if (z) {
                cVar = this.ync;
                cVar.field_bitFlag |= i;
            } else {
                cVar = this.ync;
                cVar.field_bitFlag &= i ^ -1;
            }
            x.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", Integer.valueOf(this.ync.field_bitFlag));
            y.Mh().b(this.ync);
        } else {
            j jVar;
            if (z) {
                jVar = this.piK;
                jVar.field_bitFlag |= i;
            } else {
                jVar = this.piK;
                jVar.field_bitFlag &= i ^ -1;
            }
            y.Mj().b(this.piK);
            this.ync.field_bitFlag = this.piK.field_bitFlag;
            y.Mh().b(this.ync);
        }
        hj hjVar = new hj();
        hjVar.vNk = this.ync.field_bizChatServId;
        hjVar.vNm = this.ync.field_bitFlag;
        y.Ml();
        com.tencent.mm.ag.a.h.a(this.ync.field_brandUserName, hjVar, (n) this);
    }

    public final j Fm(int i) {
        if (this.kZG.getItem(i) instanceof j) {
            return (j) this.kZG.getItem(i);
        }
        return null;
    }

    private void axE() {
        if (this.kZG != null) {
            List aZ;
            if (this.yoF) {
                aZ = com.tencent.mm.ag.a.e.aZ(this.kGB);
            } else {
                aZ = new LinkedList();
                aZ.add(this.ync.field_bizChatServId);
            }
            if (aZ != null) {
                this.kZQ = aZ.size();
            } else {
                this.kZQ = 0;
            }
            if (this.kZQ <= 1) {
                this.kZG.la(true).lb(false);
            } else {
                this.kZG.la(true).lb(this.kZP);
            }
            this.kZG.n(this.kGH, aZ);
        }
    }

    private void cqP() {
        x.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
        if (this.gZO == null) {
            this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yoF) {
            this.yoG = this.ync.ho(8);
            this.yoI = this.ync.field_bitFlag;
        } else {
            this.yoG = this.piK.ho(8);
            this.yoI = this.piK.field_bitFlag;
        }
        if (this.yoG) {
            if (this.kZI != null) {
                this.gZO.edit().putBoolean("room_save_to_contact", true).commit();
            }
        } else if (this.kZI != null) {
            this.gZO.edit().putBoolean("room_save_to_contact", false).commit();
        }
        this.ilB.notifyDataSetChanged();
    }

    private void bjy() {
        x.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
        if (this.gZO == null) {
            this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yoF) {
            this.yoH = this.ync.ho(16);
            this.yoI = this.ync.field_bitFlag;
        } else {
            this.yoH = this.piK.ho(16);
            this.yoI = this.piK.field_bitFlag;
        }
        if (this.kZJ != null) {
            this.gZO.edit().putBoolean("room_placed_to_the_top", this.yoH).commit();
        }
        this.ilB.notifyDataSetChanged();
    }

    private void axG() {
        if (this.gZO == null) {
            this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yoF) {
            this.kTc = this.ync.ho(1);
            this.yoI = this.ync.field_bitFlag;
        } else {
            this.kTc = this.piK.ho(1);
            this.yoI = this.piK.field_bitFlag;
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

    private void axI() {
        if (this.kZC == null) {
            return;
        }
        if (axJ()) {
            CharSequence charSequence = this.ync.field_chatName;
            if (charSequence != null && charSequence.length() > 50) {
                charSequence = charSequence.substring(0, 32);
            }
            x.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", charSequence);
            SignaturePreference signaturePreference = this.kZC;
            if (charSequence == null || charSequence.length() <= 0) {
                charSequence = getString(R.l.eMZ);
            }
            signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence));
            return;
        }
        this.kZC.setSummary(getString(R.l.eFw));
    }

    private void updateTitle() {
        if (this.yoF) {
            this.kZQ = com.tencent.mm.ag.a.e.aY(this.kGB);
            if (this.kZQ != 0) {
                setMMTitle(getString(R.l.eiu, new Object[]{getString(R.l.eGz), Integer.valueOf(this.kZQ)}));
                return;
            }
        }
        setMMTitle(getString(R.l.eGz));
    }

    private boolean axJ() {
        if (bh.ov(this.yoF ? this.ync.field_chatName : this.piK.field_userName)) {
            return false;
        }
        return true;
    }

    public final void a(int i, k kVar) {
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (kVar.getType() == 1355) {
            pl Mz = ((com.tencent.mm.ag.a.n) kVar).Mz();
            pk MA = ((com.tencent.mm.ag.a.n) kVar).MA();
            c kl = y.Mh().kl(Mz.vYt.wgJ.vNk);
            if (kl == null) {
                Toast.makeText(ac.getContext(), getString(R.l.eES), 0).show();
            } else if (this.fromScene == 2) {
                r2 = new Intent();
                r2.addFlags(67108864);
                r2.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                r2.putExtra("Contact_User", MA.vNq);
                r2.putExtra("biz_chat_chat_id", kl.field_bizChatLocalId);
                com.tencent.mm.bm.d.a(this, ".ui.bizchat.BizChatConversationUI", r2);
            } else {
                r2 = new Intent();
                r2.addFlags(67108864);
                r2.putExtra("Chat_User", MA.vNq);
                r2.putExtra("key_biz_chat_id", kl.field_bizChatLocalId);
                r2.putExtra("finish_direct", true);
                r2.putExtra("key_need_send_video", false);
                r2.putExtra("key_is_biz_chat", true);
                com.tencent.mm.plugin.chatroom.a.ifs.e(r2, this);
            }
        } else if (kVar.getType() == 1356) {
            if (i != 0) {
                cqR();
            }
        } else if (kVar.getType() == 1353 && i >= 0 && this.piK != null) {
            this.piK = y.Mj().ca(this.piK.field_userId);
            cqQ();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar == null) {
            x.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", Integer.valueOf(i), Integer.valueOf(i2), str);
            return;
        }
        x.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType()));
        this.kZQ = com.tencent.mm.ag.a.e.aY(this.kGB);
        x.d("MicroMsg.BizChatroomInfoUI", "now is " + this.kZQ);
        if (this.iln != null) {
            this.iln.dismiss();
        }
        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
        if (eA != null) {
            eA.a(this, null, null);
        } else if (i == 0 && i2 == 0) {
            kVar.getType();
        } else {
            x.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
            cqR();
        }
    }

    private void cqQ() {
        if (this.kZG != null) {
            axI();
            updateTitle();
            axG();
            axE();
            cqP();
            bjy();
            this.kZG.notifyChanged();
        }
        this.ilB.notifyDataSetChanged();
    }

    private void cqR() {
        x.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
        this.ync.field_chatName = this.yoE;
        this.ync.field_bitFlag = this.yoI;
        this.kTc = this.ync.ho(1);
        this.yoG = this.ync.ho(8);
        this.yoH = this.ync.ho(16);
        y.Mh().b(this.ync);
        if (this.yoH) {
            y.Mi().aW(this.ync.field_bizChatLocalId);
        } else if (!this.yoH) {
            y.Mi().aX(this.ync.field_bizChatLocalId);
        }
        this.gZO.edit().putBoolean("room_placed_to_the_top", y.Mi().aV(this.ync.field_bizChatLocalId)).commit();
        axI();
        axG();
        bjy();
        cqP();
        Toast.makeText(this, getString(R.l.eET), 0).show();
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
