package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsPrivacyUI extends MMPreference {
    private String gze = "";
    private f ilB;
    private HashMap<Integer, Integer> kCm = new HashMap();
    boolean kZX = false;
    private boolean qiy = false;
    private boolean qkA = true;
    private int qkB = e.xEl;
    private boolean qkw = true;
    private boolean qkx = false;
    private boolean qky = false;
    private boolean qkz = false;
    private int status;

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int XB() {
        return R.o.eKO;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.ilB = this.yjd;
        this.status = q.FW();
        this.gze = q.FS();
        ar.Hg();
        this.qkA = bh.a((Boolean) c.CU().get(68384, null), true);
        this.qkB = getIntent().getIntExtra("enter_scene", e.xEl);
        x.d("MicroMsg.SettingPrivacy", "sns Notify " + this.qkA);
        initView();
        g.pQN.h(14098, new Object[]{Integer.valueOf(9)});
        if (this.qkB == e.xEm || this.qkB == e.xEn) {
            bla com_tencent_mm_protocal_c_bla = new bla();
            if (n.qQz != null) {
                com_tencent_mm_protocal_c_bla = n.qQz.Jz(this.gze);
            }
            if (com_tencent_mm_protocal_c_bla != null) {
                boolean z2;
                int i = com_tencent_mm_protocal_c_bla.wOs;
                this.qkx = (i & WXMediaMessage.TITLE_LENGTH_LIMIT) > 0;
                if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.qky = z2;
                if ((i & 2048) <= 0) {
                    z = false;
                }
                this.qkz = z;
            }
            bqT();
        }
    }

    protected void onResume() {
        super.onResume();
        this.status = q.FW();
        bqU();
        if (!this.kZX) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!bh.ov(stringExtra)) {
                int YP = this.ilB.YP(stringExtra);
                setSelection(YP - 3);
                new af().postDelayed(new 1(this, YP), 10);
            }
            this.kZX = true;
        }
    }

    public void onPause() {
        super.onPause();
        ar.Hg();
        c.CU().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.kCm.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            com.tencent.mm.bq.a wlVar = new wl();
            wlVar.wgL = intValue;
            wlVar.wgM = intValue2;
            ar.Hg();
            c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wlVar));
            x.d("MicroMsg.SettingPrivacy", "switch  " + intValue + " " + intValue2);
        }
        this.kCm.clear();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        boolean z2 = false;
        String str = preference.ibD;
        x.i("MicroMsg.SettingPrivacy", str + " item has been clicked!");
        if (str.equals("settings_need_verify")) {
            return c(((CheckBoxPreference) fVar.YN("settings_need_verify")).isChecked(), 32, 4);
        }
        if (str.equals("settings_recommend_mobilefriends_to_me")) {
            boolean z3;
            if (((CheckBoxPreference) fVar.YN("settings_recommend_mobilefriends_to_me")).isChecked()) {
                z3 = false;
            } else {
                z3 = true;
            }
            return c(z3, 256, 7);
        } else if (str.equals("settings_about_blacklist")) {
            aq hB = com.tencent.mm.z.x.hB(getString(R.l.enF));
            Intent intent = new Intent();
            intent.putExtra("filter_type", hB.getType());
            intent.putExtra("titile", getString(R.l.eMI));
            intent.putExtra("list_attr", WXMediaMessage.THUMB_LENGTH_LIMIT);
            com.tencent.mm.plugin.setting.a.ifs.h(this, intent);
            return true;
        } else {
            Intent intent2;
            if (str.equals("timline_outside_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 4);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                d.b(this, "sns", ".ui.SnsBlackDetailUI", intent2);
            } else if (str.equals("edit_timeline_group")) {
                d.y(this, "sns", ".ui.SnsTagPartlyUI");
            } else if (str.equals("timeline_black_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 5);
                intent2.putExtra("k_sns_from_settings_about_sns", 2);
                intent2.putExtra("k_tag_detail_sns_block_scene", 8);
                d.b(this, "sns", ".ui.SnsTagDetailUI", intent2);
            } else if (str.equals("timeline_stranger_show")) {
                if (this.qiy) {
                    z = false;
                }
                this.qiy = z;
                if (n.qQz != null) {
                    n.qQz.aC(this.gze, this.qiy);
                }
                if (n.qQz != null) {
                    com.tencent.mm.bq.a aD = n.qQz.aD(this.gze, this.qiy);
                    n.qQz.a(this.gze, aD);
                    if (aD == null) {
                        x.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                        return false;
                    }
                    x.d("MicroMsg.SettingPrivacy", "dancy userinfo " + aD.toString());
                    ar.Hg();
                    c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(51, aD));
                }
            } else if (str.equals("settings_find_google_contact")) {
                if (!((CheckBoxPreference) fVar.YN("settings_find_google_contact")).isChecked()) {
                    z2 = true;
                }
                c(z2, 1048576, 29);
                return true;
            } else if (str.equals("settings_add_me_way")) {
                startActivity(new Intent(this, SettingsAddMeUI.class));
                return true;
            } else if (str.equals("timeline_recent_show_select")) {
                bqT();
            } else if (str.equals("settings_sns_notify")) {
                this.qkA = !this.qkA;
                if (this.qkA) {
                    g.pQN.h(14098, new Object[]{Integer.valueOf(3)});
                } else {
                    g.pQN.h(14098, new Object[]{Integer.valueOf(4)});
                }
                ar.Hg();
                c.CU().set(68384, Boolean.valueOf(this.qkA));
                bqU();
                return true;
            } else if (str.equals("settings_unfamiliar_contact")) {
                startActivity(new Intent(this, UnfamiliarContactUI.class));
            } else if (str.equals("settings_privacy_agreements")) {
                str = com.tencent.mm.kernel.g.Dj().CU().get(274436, "").toString();
                if (bh.ov(str)) {
                    str = w.cfh();
                }
                str = getString(R.l.esR, new Object[]{w.cfi(), str});
                Intent intent3 = new Intent();
                intent3.putExtra("rawUrl", str);
                intent3.putExtra("showShare", false);
                intent3.putExtra("show_bottom", false);
                intent3.putExtra("needRedirect", false);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent3);
            } else if (str.equals("settings_auth_manage")) {
                startActivity(new Intent(this, SettingsManageAuthUI.class));
            }
            return false;
        }
    }

    private void bqT() {
        bla Jz;
        bla com_tencent_mm_protocal_c_bla = new bla();
        if (n.qQz != null) {
            Jz = n.qQz.Jz(this.gze);
        } else {
            Jz = com_tencent_mm_protocal_c_bla;
        }
        if (Jz == null) {
            x.e("MicroMsg.SettingPrivacy", "userinfo is null");
            return;
        }
        ar.Hg();
        int intValue = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xuo, Integer.valueOf(0))).intValue();
        ar.Hg();
        if (intValue > ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xup, Integer.valueOf(0))).intValue()) {
            ar.Hg();
            c.CU().a(com.tencent.mm.storage.w.a.xup, Integer.valueOf(intValue));
            bqU();
        }
        i$a com_tencent_mm_ui_base_i_a = new i$a(this.mController.xIM);
        com_tencent_mm_ui_base_i_a.ED(R.l.dEn);
        com_tencent_mm_ui_base_i_a.Ez(R.l.dUZ);
        View inflate = View.inflate(this.mController.xIM, R.i.dno, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.h.cPW);
        OnClickListener 2 = new 2(this, linearLayout);
        int i = Jz.wOs;
        a(linearLayout, R.l.dVb, 1, this.qkx, 2);
        a(linearLayout, R.l.dVc, 0, this.qky, 2);
        int i2 = R.l.dVa;
        boolean z = (this.qkx || this.qky) ? false : true;
        a(linearLayout, i2, 2, z, 2);
        com_tencent_mm_ui_base_i_a.dk(inflate);
        Dialog akx = com_tencent_mm_ui_base_i_a.akx();
        linearLayout.setTag(akx);
        akx.show();
        addDialog(akx);
    }

    private void a(LinearLayout linearLayout, int i, int i2, boolean z, OnClickListener onClickListener) {
        TextView textView = (TextView) View.inflate(this.mController.xIM, R.i.dpW, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dAr, 0, 0, 0);
        }
    }

    protected final void initView() {
        boolean z = false;
        setMMTitle(R.l.eKO);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPrivacyUI qkC;

            {
                this.qkC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qkC.aWs();
                this.qkC.finish();
                return true;
            }
        });
        x.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_need_verify");
        checkBoxPreference.yjI = false;
        checkBoxPreference.tSw = uR(32);
        ar.Hg();
        String str = (String) c.CU().get(6, null);
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("settings_recommend_mobilefriends_to_me");
        checkBoxPreference2.yjI = false;
        if (str == null || str.length() <= 0) {
            this.ilB.c(checkBoxPreference2);
        } else {
            checkBoxPreference2.tSw = !uR(256);
        }
        checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_find_google_contact");
        checkBoxPreference.yjI = false;
        if (!uR(1048576)) {
            z = true;
        }
        checkBoxPreference.tSw = z;
        ar.Hg();
        String str2 = (String) c.CU().get(208903, null);
        if (!bh.PT() || TextUtils.isEmpty(str2)) {
            this.ilB.c(checkBoxPreference);
        }
        ar.Hg();
        if (!(((Boolean) c.CU().get(335873, Boolean.valueOf(true))).booleanValue() && n.qQB.bui())) {
            this.ilB.bk("edit_timeline_group", true);
        }
        this.ilB.bk("settings_unfamiliar_contact", true);
        Preference YN = this.ilB.YN("settings_privacy_agreements");
        str2 = getString(R.l.eAW);
        CharSequence newSpannable = Factory.getInstance().newSpannable(getString(R.l.eAX) + str2);
        newSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.e.btd)), newSpannable.length() - str2.length(), newSpannable.length(), 33);
        YN.setTitle(newSpannable);
        this.ilB.notifyDataSetChanged();
    }

    private boolean uR(int i) {
        return (this.status & i) != 0;
    }

    private boolean c(boolean z, int i, int i2) {
        x.d("MicroMsg.SettingPrivacy", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.kCm.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        return true;
    }

    private void bqU() {
        bla com_tencent_mm_protocal_c_bla = new bla();
        if (n.qQz != null) {
            com_tencent_mm_protocal_c_bla = n.qQz.Jz(this.gze);
        }
        if (com_tencent_mm_protocal_c_bla == null) {
            x.e("MicroMsg.SettingPrivacy", "userinfo is null");
            return;
        }
        boolean z;
        int i = com_tencent_mm_protocal_c_bla.wOs;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("timeline_stranger_show");
        if (checkBoxPreference != null) {
            checkBoxPreference.yjI = false;
            this.qiy = (i & 1) > 0;
            if (this.qiy) {
                checkBoxPreference.tSw = false;
            } else {
                checkBoxPreference.tSw = true;
            }
        }
        IconPreference iconPreference = (IconPreference) this.ilB.YN("timeline_recent_show_select");
        if (iconPreference != null) {
            boolean z2;
            iconPreference.yjI = false;
            if ((i & WXMediaMessage.TITLE_LENGTH_LIMIT) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.qkx = z2;
            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.qky = z2;
            if ((i & 2048) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.qkz = z2;
            if (this.qkx) {
                iconPreference.setSummary(R.l.dVb);
            } else if (this.qky) {
                iconPreference.setSummary(R.l.dVc);
            } else {
                iconPreference.setSummary(R.l.dVa);
            }
            ar.Hg();
            i = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xuo, Integer.valueOf(0))).intValue();
            ar.Hg();
            x.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[]{Integer.valueOf(i), Integer.valueOf(((Integer) c.CU().get(com.tencent.mm.storage.w.a.xup, Integer.valueOf(0))).intValue())});
            if (i > ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xup, Integer.valueOf(0))).intValue()) {
                iconPreference.EZ(0);
            } else {
                iconPreference.EZ(8);
            }
        }
        if (d.OQ("sns") && (q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            z = true;
        } else {
            z = false;
        }
        this.qkw = z;
        String str = "MicroMsg.SettingPrivacy";
        StringBuilder append = new StringBuilder("isSnsOpenEntrance ").append(this.qkw).append(", install ").append(d.OQ("sns")).append(", flag ");
        if ((q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            z = true;
        } else {
            z = false;
        }
        x.i(str, append.append(z).toString());
        if (this.qkw) {
            this.ilB.bk("settings_sns_notify", false);
        } else {
            this.ilB.bk("settings_sns_notify", true);
        }
        if (this.qkw) {
            checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_sns_notify");
            if (checkBoxPreference != null) {
                checkBoxPreference.yjI = false;
                ar.Hg();
                this.qkA = bh.a((Boolean) c.CU().get(68384, null), true);
                if (this.qkA) {
                    checkBoxPreference.tSw = true;
                } else {
                    checkBoxPreference.tSw = false;
                }
            }
        }
        this.ilB.notifyDataSetChanged();
    }
}
