package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ay.k;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h$c;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.d;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

@Deprecated
public class RoomInfoDetailUI extends MMPreference implements a {
    private boolean fzz;
    private String iQs;
    private f ilB;
    private boolean isDeleteCancel = false;
    private x jLe;
    private SignaturePreference kZC;
    private CheckBoxPreference kZH;
    private boolean kZR = false;
    private String laf;
    private int lbU;
    private CheckBoxPreference lbV;
    private CheckBoxPreference lbW;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        axG();
        axQ();
        if (!(this.jLe == null || this.lbV == null)) {
            ar.Hg();
            q hE = c.Fh().hE(this.iQs);
            SharedPreferences sharedPreferences = getSharedPreferences(this.laf, 0);
            if (hE.chV()) {
                this.lbV.tSw = true;
                sharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
            } else {
                this.lbV.tSw = false;
                sharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
            }
        }
        this.ilB.notifyDataSetChanged();
    }

    protected final void initView() {
        setMMTitle(R.l.eGy);
        this.ilB = this.yjd;
        this.laf = getPackageName() + "_preferences";
        this.fzz = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.iQs = getIntent().getStringExtra("RoomInfo_Id");
        if (this.iQs == null) {
            this.iQs = getIntent().getStringExtra("Single_Chat_Talker");
        }
        ar.Hg();
        this.jLe = c.EY().WO(this.iQs);
        if (this.fzz) {
            this.lbU = this.jLe.fWn;
            this.kZC = (SignaturePreference) this.ilB.YN("room_name");
            this.kZH = (CheckBoxPreference) this.ilB.YN("room_msg_notify");
            this.lbW = (CheckBoxPreference) this.ilB.YN("room_show_msg_count");
            this.lbV = (CheckBoxPreference) this.ilB.YN("room_msg_show_username");
            this.lbW.yjI = false;
        } else {
            this.lbU = 1;
        }
        setBackBtn(new 1(this));
    }

    public final void a(String str, l lVar) {
    }

    public final int XB() {
        return R.o.fbX;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.ibD;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.RoomInfoDetailUI", "click key : %s", new Object[]{str});
        if (str.equals("room_name")) {
            Intent intent = new Intent();
            intent.setClass(this, d.class);
            intent.putExtra("Contact_mode_name_type", 4);
            String FS = com.tencent.mm.z.q.FS();
            intent.putExtra("Contact_Nick", axz());
            intent.putExtra("Contact_User", FS);
            intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
            intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
            this.mController.xIM.startActivityForResult(intent, 2);
        }
        if (str.equals("room_msg_show_username")) {
            ar.Hg();
            q hD = c.Fh().hD(this.iQs);
            hD.lG(!hD.chV());
            this.kZR = true;
        }
        if (str.equals("room_msg_notify")) {
            int i;
            if (this.lbU == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.lbU = i;
            ar.Hg();
            c.EX().b(new k(this.iQs, this.lbU));
            ar.Hg();
            this.jLe = c.EY().WO(this.iQs);
            this.jLe.eH(this.lbU);
            ar.Hg();
            c.EY().a(this.iQs, this.jLe);
            axG();
            ar.Hg();
            this.jLe = c.EY().WO(this.iQs);
            this.ilB.notifyDataSetChanged();
        }
        if (str.equals("room_set_chatting_background")) {
            intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra("username", this.jLe.field_username);
            com.tencent.mm.bm.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 1);
        }
        if (str.equals("room_clear_chatting_history")) {
            h.a(this, this.fzz ? getString(R.l.eiz) : getString(R.l.eiy, new Object[]{this.jLe.AQ()}), new String[]{getString(R.l.eEW)}, null, new h$c(this) {
                final /* synthetic */ RoomInfoDetailUI lbX;

                {
                    this.lbX = r1;
                }

                public final void jl(int i) {
                    switch (i) {
                        case 0:
                            String str;
                            this.lbX.isDeleteCancel = false;
                            Context context = this.lbX;
                            this.lbX.getString(R.l.dGO);
                            ProgressDialog a = h.a(context, this.lbX.getString(R.l.dHc), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass2 lbY;

                                {
                                    this.lbY = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.lbY.lbX.isDeleteCancel = true;
                                }
                            });
                            if (com.tencent.mm.z.l.ga(this.lbX.jLe.field_username)) {
                                com.tencent.mm.plugin.chatroom.a.ift.cB(this.lbX.jLe.field_username);
                            }
                            if (this.lbX.isDeleteCancel) {
                                str = null;
                            } else {
                                str = e.SZ(this.lbX.jLe.field_username);
                            }
                            if (bh.ov(str)) {
                                ba.a(this.lbX.jLe.field_username, new 3(this.lbX, a));
                                return;
                            }
                            a.dismiss();
                            h.a(this.lbX, false, this.lbX.getString(R.l.eWf, new Object[]{str}), null, this.lbX.getString(R.l.enD), this.lbX.getString(R.l.dTR), new 2(this), new 3(this, a), -1, R.e.brm);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
        if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.laf, 0);
            if (this.jLe != null) {
                ar.Hg();
                if (c.Fd().Xf(this.jLe.field_username)) {
                    s.s(this.jLe.field_username, true);
                } else {
                    s.r(this.jLe.field_username, true);
                }
                ar.Hg();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", c.Fd().Xf(this.jLe.field_username)).commit();
            }
        }
        if ("room_show_msg_count".equals(str)) {
            boolean z2;
            boolean AJ = AJ();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[]{Boolean.valueOf(AJ), Boolean.valueOf(AJ)});
            if (AJ) {
                z2 = false;
            } else {
                z2 = true;
            }
            ar.Hg();
            com.tencent.mm.sdk.e.c hD2 = c.Fh().hD(this.iQs);
            if (z2) {
                hD2.ga(0);
            } else {
                hD2.ga(2);
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[]{Boolean.valueOf(z2)});
            ar.Hg();
            c.Fh().c(hD2, new String[0]);
            FS = com.tencent.mm.z.q.FS();
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_arm = new arm();
            com_tencent_mm_protocal_c_arm.vYJ = this.iQs;
            com_tencent_mm_protocal_c_arm.ksU = FS;
            com_tencent_mm_protocal_c_arm.wza = 2;
            com_tencent_mm_protocal_c_arm.pQk = z2 ? 2 : 1;
            ar.Hg();
            c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(49, com_tencent_mm_protocal_c_arm));
            if (this.lbW != null) {
                CheckBoxPreference checkBoxPreference = this.lbW;
                if (AJ) {
                    z = false;
                }
                checkBoxPreference.tSw = z;
            }
            this.ilB.notifyDataSetChanged();
        }
        return false;
    }

    public void onPause() {
        int i = 1;
        super.onPause();
        if (this.kZR) {
            ar.Hg();
            com.tencent.mm.sdk.e.c hD = c.Fh().hD(this.iQs);
            ar.Hg();
            c.Fh().c(hD, new String[0]);
            String FS = com.tencent.mm.z.q.FS();
            boolean chV = hD.chV();
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_arm = new arm();
            com_tencent_mm_protocal_c_arm.vYJ = this.iQs;
            com_tencent_mm_protocal_c_arm.ksU = FS;
            com_tencent_mm_protocal_c_arm.wza = 1;
            if (!chV) {
                i = 0;
            }
            com_tencent_mm_protocal_c_arm.pQk = i;
            ar.Hg();
            c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(49, com_tencent_mm_protocal_c_arm));
        }
    }

    private boolean AJ() {
        ar.Hg();
        return (c.Fh().hD(this.iQs).field_chatroomdataflag & 2) == 0;
    }

    private String axz() {
        ar.Hg();
        q hD = c.Fh().hD(this.iQs);
        if (hD == null) {
            return "";
        }
        return hD.field_selfDisplayName;
    }

    private void axQ() {
        if (this.jLe != null && this.kZC != null) {
            CharSequence axz = axz();
            if (bh.ov(axz)) {
                axz = com.tencent.mm.z.q.FU();
            }
            if (bh.ov(axz)) {
                this.kZC.setSummary("");
                return;
            }
            SignaturePreference signaturePreference = this.kZC;
            if (axz.length() <= 0) {
                axz = getString(R.l.eMZ);
            }
            signaturePreference.setSummary(i.a(this, axz));
        }
    }

    private void axG() {
        boolean z = true;
        if (this.fzz) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.laf, 0);
            if (this.lbU == 0) {
                setTitleMuteIconVisibility(0);
                if (this.kZH != null) {
                    this.kZH.tSw = true;
                    sharedPreferences.edit().putBoolean("room_msg_notify", true).commit();
                }
                if (this.lbW != null) {
                    this.lbW.tSw = AJ();
                }
            } else if (this.lbU == 1) {
                setTitleMuteIconVisibility(8);
                if (this.kZH != null) {
                    this.kZH.tSw = false;
                    sharedPreferences.edit().putBoolean("room_msg_notify", false).commit();
                }
            }
            f fVar = this.ilB;
            String str = "room_show_msg_count";
            if (this.lbU != 1) {
                z = false;
            }
            fVar.bk(str, z);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        setResult(-1);
                        finish();
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String az = bh.az(intent.getStringExtra("Contact_Nick"), "");
                        if (!bh.ov(az)) {
                            String FS = com.tencent.mm.z.q.FS();
                            ar.Hg();
                            com.tencent.mm.sdk.e.c hD = c.Fh().hD(this.iQs);
                            if (hD == null) {
                                hD = new q();
                            }
                            hD.field_chatroomname = this.iQs;
                            hD.field_selfDisplayName = az;
                            ar.Hg();
                            c.Fh().c(hD, new String[0]);
                            com.tencent.mm.bq.a com_tencent_mm_protocal_c_arl = new arl();
                            com_tencent_mm_protocal_c_arl.vYJ = this.iQs;
                            com_tencent_mm_protocal_c_arl.ksU = FS;
                            com_tencent_mm_protocal_c_arl.vUT = bh.ou(az);
                            ar.Hg();
                            c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(48, com_tencent_mm_protocal_c_arl));
                            axQ();
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
}
