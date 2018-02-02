package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;

public class SingleChatInfoUI extends MMPreference implements l {
    private static boolean isDeleteCancel = false;
    private SharedPreferences gZO = null;
    private af handler = new af(Looper.getMainLooper());
    private f ilB;
    private x jLe;
    private boolean kTc;
    private ContactListExpandPreference kZG;
    private CheckBoxPreference kZH;
    private CheckBoxPreference kZJ;
    private AppBrandLoadIconPreference kZM;
    private int kZT = -1;
    private boolean kZV = false;
    private d kZW = new d(new 1(this));
    boolean kZX = false;
    private String laf = "";
    private String talker;

    static /* synthetic */ void c(SingleChatInfoUI singleChatInfoUI) {
        g.pQN.k(10170, "1");
        List linkedList = new LinkedList();
        linkedList.add(singleChatInfoUI.talker);
        linkedList.add(q.FS());
        String d = t.d(linkedList, ",");
        Intent intent = new Intent();
        intent.setClass(singleChatInfoUI, SelectContactUI.class);
        intent.putExtra("titile", singleChatInfoUI.getString(R.l.dDn));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", s.yTF);
        intent.putExtra("always_select_contact", d);
        intent.putExtra("scene", 2);
        singleChatInfoUI.startActivity(intent);
    }

    static /* synthetic */ void g(SingleChatInfoUI singleChatInfoUI) {
        g.pQN.h(14553, new Object[]{Integer.valueOf(6), Integer.valueOf(2), singleChatInfoUI.talker});
        isDeleteCancel = false;
        singleChatInfoUI.getString(R.l.dGO);
        ProgressDialog a = h.a(singleChatInfoUI, singleChatInfoUI.getString(R.l.dHc), true, new a((byte) 0));
        if (t.ov(!isDeleteCancel ? e.SZ(singleChatInfoUI.jLe.field_username) : null)) {
            singleChatInfoUI.a(a);
            return;
        }
        a.dismiss();
        Object[] objArr = new Object[]{r0};
        h.a(singleChatInfoUI, false, singleChatInfoUI.getString(R.l.eWf, objArr), null, singleChatInfoUI.getString(R.l.enD), singleChatInfoUI.getString(R.l.dTR), new 5(singleChatInfoUI), new 6(singleChatInfoUI, a), -1, R.e.brm);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a.vcp != null) {
            a.vcp.a(this);
        }
        this.talker = getIntent().getStringExtra("Single_Chat_Talker");
        this.kZV = getIntent().getBooleanExtra("fromChatting", false);
        ar.Hg();
        this.jLe = c.EY().WO(this.talker);
        this.laf = getPackageName() + "_preferences";
        initView();
    }

    public void onResume() {
        axG();
        if (this.kZG != null) {
            List linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.kZG.n(this.talker, linkedList);
        }
        this.ilB.notifyDataSetChanged();
        super.onResume();
        if (!this.kZX) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!t.ov(stringExtra)) {
                int YP = this.ilB.YP(stringExtra);
                setSelection(YP - 3);
                new af().postDelayed(new 2(this, YP), 10);
            }
            this.kZX = true;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        com.tencent.mm.ui.g.a.dismiss();
        if (a.vcp != null) {
            a.vcp.b(this);
        }
        if (this.kZM != null) {
            AppBrandLoadIconPreference.onDestroy();
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (i2 == -1) {
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final int XB() {
        return R.o.fbZ;
    }

    protected final void initView() {
        this.ilB = this.yjd;
        setMMTitle(getString(R.l.eGz));
        this.kZG = (ContactListExpandPreference) this.ilB.YN("roominfo_contact_anchor");
        this.kZG.a(this.ilB, this.kZG.ibD);
        this.kZG.la(true).lb(false);
        if (this.jLe != null && this.jLe.field_deleteFlag == 1) {
            this.kZG.la(false);
        }
        this.kZH = (CheckBoxPreference) this.ilB.YN("room_notify_new_msg");
        this.kZJ = (CheckBoxPreference) this.ilB.YN("room_placed_to_the_top");
        if (this.gZO == null) {
            this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.jLe != null) {
            ar.Hg();
            this.gZO.edit().putBoolean("room_placed_to_the_top", c.Fd().Xf(this.jLe.field_username)).commit();
            this.kTc = this.jLe.AI();
            this.gZO.edit().putBoolean("room_notify_new_msg", this.kTc).commit();
        } else {
            this.gZO.edit().putBoolean("room_notify_new_msg", false).commit();
            this.kTc = false;
        }
        ar.Hg();
        this.kZT = c.Fa().EP(this.talker);
        this.kZM = (AppBrandLoadIconPreference) this.ilB.YN("chat_app_brand");
        this.kZM.jRw = this.talker;
        this.ilB.notifyDataSetChanged();
        if (this.kZG != null) {
            List linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.kZG.n(this.talker, linkedList);
            this.nKG.setOnScrollListener(this.kZW);
            this.kZG.a(this.kZW);
            this.kZG.a(new 3(this));
        }
        setBackBtn(new 4(this));
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.ibD;
        if (str.equals("room_notify_new_msg")) {
            if (this.kTc) {
                z = false;
            }
            this.kTc = z;
            if (this.kTc) {
                com.tencent.mm.z.s.n(this.jLe);
            } else {
                com.tencent.mm.z.s.o(this.jLe);
            }
            ar.Hg();
            this.jLe = c.EY().WO(this.talker);
            if (this.gZO == null) {
                this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            this.gZO.edit().putBoolean("room_notify_new_msg", this.kTc).commit();
            axG();
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.laf, 0);
            if (this.jLe != null) {
                ar.Hg();
                if (c.Fd().Xf(this.jLe.field_username)) {
                    com.tencent.mm.z.s.s(this.jLe.field_username, true);
                } else {
                    com.tencent.mm.z.s.r(this.jLe.field_username, true);
                }
                ar.Hg();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", c.Fd().Xf(this.jLe.field_username)).commit();
            }
        } else if (str.equals("room_set_chatting_background")) {
            r0 = new Intent();
            r0.putExtra("isApplyToAll", false);
            r0.putExtra("username", this.jLe.field_username);
            com.tencent.mm.bm.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", r0, 2);
        } else if (str.equals("room_search_chatting_content")) {
            r0 = new Intent();
            r0.putExtra("detail_username", this.talker);
            com.tencent.mm.bm.d.b(this, "search", ".ui.FTSChattingConvUI", r0);
            g.pQN.h(14569, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (str.equals("room_clear_chatting_history")) {
            h.a(this.mController.xIM, getString(R.l.eiy, new Object[]{this.jLe.AQ()}), "", getString(R.l.dEo), getString(R.l.dEn), new 8(this), null, R.e.brm);
        } else if (str.equals("room_expose")) {
            r0 = new Intent();
            r0.putExtra("k_username", this.talker);
            r0.putExtra("showShare", false);
            r0.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(39)}));
            com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", r0);
        } else if (str.equals("chat_app_brand")) {
            r0 = new Intent();
            r0.putExtra("Chat_User", this.talker);
            com.tencent.mm.bm.d.a(this, ".ui.chatting.gallery.AppBrandHistoryListUI", r0);
            g.pQN.a(219, 25, 1, true);
        }
        return false;
    }

    private void a(final ProgressDialog progressDialog) {
        ba.a(this.jLe.field_username, new ba.a(this) {
            final /* synthetic */ SingleChatInfoUI xMD;

            public final boolean HB() {
                return SingleChatInfoUI.isDeleteCancel;
            }

            public final void HA() {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }
        });
        this.handler.post(new 9(this));
    }

    private void axG() {
        if (this.gZO == null) {
            this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.kTc = this.jLe.AI();
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

    public final void F(String str, String str2, String str3) {
        if (str.equals(this.talker) && this.kZG != null) {
            this.kZG.notifyChanged();
        }
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
