package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.bf.l;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q$c;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.s.a.a;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.UUID;

public class y extends a implements b {
    private f ilB;
    private a qlA = new 1(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ar.Hj() || ar.Cs()) {
            x.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[]{Boolean.valueOf(ar.Hj()), Boolean.valueOf(ar.Cs())});
        }
    }

    public final int XB() {
        return R.o.fbS;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onActivityCreated(Bundle bundle) {
        x.i("MicroMsg.MoreTabUI", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.ilB = this.yjd;
        this.ilB.bk("more_setting", true);
        this.ilB.bk("settings_emoji_store", true);
        this.ilB.bk("settings_mm_wallet", true);
        this.ilB.bk("settings_mm_cardpackage", true);
        this.ilB.bk("settings_mm_favorite", true);
        this.ilB.bk("settings_my_album", true);
        this.ilB.bk("settings_my_address", true);
        this.ilB.bk("more_tab_setting_personal_info", true);
        this.ilB.bk("more_uishow", true);
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.ibD.equals("more_tab_setting_personal_info")) {
            d.b(getContext(), "setting", ".ui.setting.SettingsPersonalInfoUI", new Intent());
            return true;
        } else if (preference.ibD.equals("settings_my_address")) {
            r0 = new Intent(getContext(), AddressUI.class);
            r0.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            startActivity(r0);
            return true;
        } else if (preference.ibD.equals("settings_my_add_contact")) {
            d.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
            return true;
        } else if (preference.ibD.equals("settings_mm_wallet")) {
            boolean aQ = c.Bq().aQ(262156, 266248);
            r3 = c.Bq().aR(262156, 266248);
            g.pQN.k(10958, "9");
            g gVar = g.pQN;
            Object[] objArr = new Object[1];
            r0 = (aQ || r3) ? 1 : 0;
            objArr[0] = Integer.valueOf(r0);
            gVar.h(13341, objArr);
            g.pQN.h(14419, new Object[]{UUID.randomUUID().toString(), Integer.valueOf(0)});
            com.tencent.mm.sdk.b.b nkVar = new nk();
            nkVar.fFu.context = getContext();
            Intent intent = new Intent();
            intent.putExtra("key_wallet_has_red", r3);
            intent.putExtra("key_uuid", r0);
            nkVar.fFu.intent = intent;
            com.tencent.mm.sdk.b.a.xef.m(nkVar);
            c.Bq().aS(262156, 266248);
            c.Bq().c(w.a.xwe, w.a.xwg);
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xvQ, "");
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xvR, Integer.valueOf(-1));
            gVar = g.pQN;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            if (r3) {
                r0 = 1;
            } else {
                r0 = 0;
            }
            objArr[1] = Integer.valueOf(r0);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(0);
            gVar.h(14872, objArr);
            return true;
        } else if (preference.ibD.equals("settings_mm_cardpackage")) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xoi, "");
            r0 = new Intent();
            r0.putExtra("key_from_scene", 22);
            x.i("MicroMsg.MoreTabUI", "enter to cardhome");
            d.b(getContext(), "card", ".ui.CardHomePageUI", r0);
            return true;
        } else if (preference.ibD.equals("settings_my_album")) {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                ar.Hg();
                r0 = (String) com.tencent.mm.z.c.CU().get(2, null);
                Intent intent2 = new Intent();
                intent2.putExtra("sns_userName", r0);
                intent2.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent2.addFlags(67108864);
                ar.Hg();
                r0 = t.f((Integer) com.tencent.mm.z.c.CU().get(68389, null));
                ar.Hg();
                com.tencent.mm.z.c.CU().set(68389, Integer.valueOf(r0 + 1));
                d.b(getContext(), "sns", ".ui.SnsUserUI", intent2);
                return true;
            }
            u.fI(getContext());
            return true;
        } else if (preference.ibD.equals("settings_mm_favorite")) {
            g.pQN.k(10958, "8");
            g.pQN.h(14103, new Object[]{Integer.valueOf(0)});
            d.y(getContext(), "favorite", ".ui.FavoriteIndexUI");
            r0 = new Intent();
            r0.setComponent(new ComponentName(e$h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            r0.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(r0);
            return true;
        } else if (preference.ibD.equals("settings_emoji_store")) {
            g.pQN.k(10958, "7");
            c.Bq().aS(262147, 266244);
            c.Bq().aS(262149, 266244);
            r0 = new Intent();
            r0.putExtra("preceding_scence", 2);
            d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", r0);
            g.pQN.h(12065, new Object[]{Integer.valueOf(1)});
            return true;
        } else if (preference.ibD.equals("more_setting")) {
            r3 = c.Bq().aQ(262145, 266242);
            c.Bq().aS(262145, 266242);
            c.Bq().aS(262157, 266261);
            c.Bq().aS(262158, 266264);
            c.Bq().b(w.a.xxB, 266264);
            d.b(getContext(), "setting", ".ui.setting.SettingsUI", new Intent());
            ar.Hg();
            int intValue = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xuk, Integer.valueOf(0))).intValue();
            ar.Hg();
            r0 = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xul, Integer.valueOf(0))).intValue();
            if (r3 || intValue <= r0) {
                return true;
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xul, Integer.valueOf(intValue));
            IconPreference iconPreference = (IconPreference) fVar.YN("more_setting");
            if (iconPreference != null) {
                iconPreference.EZ(8);
            }
            c.Bq().aS(266260, 266241);
            return true;
        } else if (!preference.ibD.equals("more_uishow")) {
            return false;
        } else {
            com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.ai.a.a.a.class);
            getContext();
            r0 = new Intent();
            return true;
        }
    }

    private void cnp() {
        if (d.OQ("sns")) {
            this.ilB.bk("settings_my_album", false);
        } else {
            this.ilB.bk("settings_my_album", true);
        }
    }

    private void cnq() {
        q$c com_tencent_mm_pluginsdk_q_c = q.a.vct;
        if (com_tencent_mm_pluginsdk_q_c == null || !((com_tencent_mm_pluginsdk_q_c.auj() || com_tencent_mm_pluginsdk_q_c.auk()) && d.OQ("card"))) {
            this.ilB.bk("settings_mm_cardpackage", true);
            return;
        }
        String str = "";
        if (com_tencent_mm_pluginsdk_q_c != null) {
            CharSequence aul = com_tencent_mm_pluginsdk_q_c.aul();
        } else {
            Object obj = str;
        }
        boolean aR = c.Bq().aR(262152, 266256);
        boolean aQ = c.Bq().aQ(262152, 266256);
        boolean a = c.Bq().a(w.a.xoc, w.a.xoe);
        boolean a2 = c.Bq().a(w.a.xod, w.a.xof);
        this.ilB.bk("settings_mm_cardpackage", false);
        IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_mm_cardpackage");
        if (iconPreference != null) {
            iconPreference.setTitle(R.l.eLK);
            if (aQ) {
                iconPreference.EX(0);
                iconPreference.dh(getString(R.l.dFP), R.g.bEf);
                iconPreference.EZ(8);
                iconPreference.setSummary(null);
                iconPreference.V(null);
                iconPreference.Fb(8);
                iconPreference.di("", -1);
                iconPreference.EY(8);
                return;
            }
            ar.Hg();
            String str2 = (String) com.tencent.mm.z.c.CU().get(w.a.xol, "");
            if (!a2 || TextUtils.isEmpty(str2)) {
                iconPreference.V(null);
                iconPreference.Fb(8);
            } else {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.f.bwn);
                c$a com_tencent_mm_aq_a_a_c_a = new c$a();
                com_tencent_mm_aq_a_a_c_a.hDD = e.bnF;
                o.PB();
                com_tencent_mm_aq_a_a_c_a.hDW = null;
                com_tencent_mm_aq_a_a_c_a.hDC = m.wk(str2);
                com_tencent_mm_aq_a_a_c_a.hDA = true;
                com_tencent_mm_aq_a_a_c_a.hDY = true;
                com_tencent_mm_aq_a_a_c_a.hDy = true;
                com_tencent_mm_aq_a_a_c_a.hDH = dimensionPixelOffset;
                com_tencent_mm_aq_a_a_c_a.hDG = dimensionPixelOffset;
                o.PA().a(str2, iconPreference.olD, com_tencent_mm_aq_a_a_c_a.PK(), new 2(this, iconPreference));
            }
            if (aR) {
                iconPreference.EZ(0);
            } else {
                iconPreference.EZ(8);
            }
            if (a) {
                iconPreference.dh("", -1);
                iconPreference.EX(8);
                if (a2) {
                    iconPreference.setSummary(null);
                    if (t.ov(aul)) {
                        iconPreference.di("", -1);
                        iconPreference.EY(8);
                        return;
                    }
                    iconPreference.ac(aul, -1, getResources().getColor(R.e.bsO));
                    iconPreference.EY(0);
                    return;
                }
                iconPreference.di("", -1);
                iconPreference.EY(8);
                if (t.ov(aul)) {
                    iconPreference.setSummary(null);
                    return;
                } else {
                    iconPreference.setSummary(aul);
                    return;
                }
            }
            iconPreference.EY(8);
            iconPreference.EX(8);
            iconPreference.setSummary(null);
        }
    }

    private void cnr() {
        this.ilB.bk("more_setting", false);
        IconPreference iconPreference = (IconPreference) this.ilB.YN("more_setting");
        if (iconPreference != null) {
            iconPreference.Fc(8);
            boolean aQ = c.Bq().aQ(262145, 266242);
            if (aQ) {
                iconPreference.EX(0);
                iconPreference.dh(getString(R.l.dFP), R.g.bEf);
            } else {
                iconPreference.EX(8);
                iconPreference.dh("", -1);
            }
            ar.Hg();
            if (((Integer) com.tencent.mm.z.c.CU().get(9, Integer.valueOf(0))).intValue() != 0) {
                if (com.tencent.mm.z.q.Ga()) {
                    iconPreference.setSummary("");
                } else {
                    iconPreference.setSummary(R.l.eGD);
                }
            }
            iconPreference.EZ(8);
            if (!aQ) {
                ar.Hg();
                int intValue = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xuk, Integer.valueOf(0))).intValue();
                ar.Hg();
                int intValue2 = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xul, Integer.valueOf(0))).intValue();
                if ((((com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.c.class)).bVz() || ((com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.c.class)).bVA() || intValue > intValue2) && !aQ) {
                    iconPreference.EZ(0);
                    iconPreference.EX(8);
                    iconPreference.dh("", -1);
                    return;
                }
                iconPreference.EZ(8);
                if (c.Bq().aR(262157, 266261)) {
                    iconPreference.EZ(0);
                    iconPreference.EX(8);
                    iconPreference.dh("", -1);
                    return;
                }
                iconPreference.EZ(8);
                if (c.Bq().aR(262158, 266264)) {
                    iconPreference.EZ(0);
                    iconPreference.EX(8);
                    iconPreference.dh("", -1);
                } else if (c.Bq().a(w.a.xxB, 266264)) {
                    iconPreference.EZ(0);
                } else {
                    boolean booleanValue;
                    iconPreference.EZ(8);
                    ar.Hg();
                    if ((com.tencent.mm.z.c.CU().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                        aQ = true;
                    } else {
                        aQ = false;
                    }
                    if (bh.getInt(com.tencent.mm.k.g.zY().getValue("VoiceprintEntry"), 0) == 1) {
                        ar.Hg();
                        booleanValue = ((Boolean) com.tencent.mm.z.c.CU().get(w.a.xnF, Boolean.valueOf(true))).booleanValue();
                    } else {
                        booleanValue = false;
                    }
                    if (booleanValue && r2) {
                        x.i("MicroMsg.MoreTabUI", "show voiceprint dot");
                        iconPreference.EZ(0);
                        return;
                    }
                    iconPreference.EZ(8);
                    ay Dr = com.tencent.mm.plugin.x.a.bfn().Dr(com.tencent.mm.aw.b.hId);
                    if (Dr != null && !Dr.field_isExit) {
                        com.tencent.mm.plugin.x.a.bfm().hIq = new 3(this, iconPreference);
                    } else if (com.tencent.mm.plugin.x.a.bfo().ig(com.tencent.mm.aw.b.hId)) {
                        iconPreference.EZ(0);
                        iconPreference.EX(8);
                        iconPreference.dh("", -1);
                    }
                }
            }
        }
    }

    private void cns() {
        if (d.OQ("emoji")) {
            d.ccW();
            this.ilB.bk("settings_emoji_store", false);
            boolean aQ = c.Bq().aQ(262147, 266244);
            boolean aQ2 = c.Bq().aQ(262149, 266244);
            final IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_emoji_store");
            if (iconPreference != null) {
                if (aQ) {
                    iconPreference.EX(0);
                    iconPreference.dh(getString(R.l.dFP), R.g.bEf);
                } else if (aQ2) {
                    iconPreference.EX(0);
                    iconPreference.dh(getString(R.l.dFm), R.g.bEf);
                } else {
                    iconPreference.EX(8);
                    iconPreference.dh("", -1);
                }
                if (aQ2 || aQ) {
                    ar.Hg();
                    o.PA().a((String) com.tencent.mm.z.c.CU().get(229633, null), iconPreference.olD, new com.tencent.mm.aq.a.c.g(this) {
                        final /* synthetic */ y xKX;

                        public final void lC(String str) {
                        }

                        public final Bitmap a(String str, com.tencent.mm.aq.a.d.b bVar) {
                            return null;
                        }

                        public final void a(String str, View view, com.tencent.mm.aq.a.d.b bVar) {
                            if (bVar.status != 0 || bVar.bitmap == null) {
                                ag.y(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass5 xLc;

                                    {
                                        this.xLc = r1;
                                    }

                                    public final void run() {
                                        iconPreference.Fb(8);
                                    }
                                });
                                return;
                            }
                            final Bitmap bitmap = bVar.bitmap;
                            ag.y(new Runnable(this) {
                                final /* synthetic */ AnonymousClass5 xLc;

                                public final void run() {
                                    iconPreference.V(bitmap);
                                    iconPreference.Fb(0);
                                }
                            });
                        }
                    });
                    return;
                }
                iconPreference.Fb(8);
                return;
            }
            return;
        }
        this.ilB.bk("settings_emoji_store", false);
    }

    private void cnt() {
        boolean Gb = com.tencent.mm.z.q.Gb();
        x.d("MicroMsg.MoreTabUI", "wallet status: is open" + Gb);
        this.ilB.bk("settings_mm_wallet", !Gb);
        this.yjd.notifyDataSetChanged();
    }

    private void cnu() {
        ar.Hg();
        int f = t.f((Integer) com.tencent.mm.z.c.CU().get(204820, null));
        ar.Hg();
        int f2 = f + t.f((Integer) com.tencent.mm.z.c.CU().get(204817, null));
        boolean aQ = c.Bq().aQ(262156, 266248);
        boolean aR = c.Bq().aR(262156, 266248);
        boolean b = c.Bq().b(w.a.xwe, w.a.xwg);
        ar.Hg();
        String str = (String) com.tencent.mm.z.c.CU().get(w.a.xwh, "");
        IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_mm_wallet");
        if (iconPreference != null) {
            boolean z;
            g gVar;
            Object[] objArr;
            int i;
            x.d("MicroMsg.MoreTabUI", "isShowNew : " + aQ);
            x.d("MicroMsg.MoreTabUI", "isShowDot : " + aR);
            ar.Hg();
            String str2 = (String) com.tencent.mm.z.c.CU().get(w.a.xvQ, "");
            ar.Hg();
            int intValue = ((Integer) com.tencent.mm.z.c.CU().get(w.a.xvR, Integer.valueOf(-1))).intValue();
            if (aQ || aR) {
                ar.Hg();
                long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xvO, Long.valueOf(-1))).longValue();
                long ow = t.ow(com.tencent.mm.k.g.zY().getValue("PayWalletRedDotExpire"));
                long j = 86400000 * ow;
                x.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[]{Long.valueOf(longValue), Long.valueOf(ow), Long.valueOf(j), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d)});
                if (longValue > 0 && ow > 0 && r20 >= ((double) ow)) {
                    aR = false;
                    z = false;
                    c.Bq().o(262156, false);
                    x.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s", new Object[]{Boolean.valueOf(aR), Boolean.valueOf(z)});
                    x.d("MicroMsg.MoreTabUI", "bankcardDot : " + b);
                    if (b) {
                        if (aR) {
                            iconPreference.EX(0);
                            iconPreference.dh(getString(R.l.dFP), R.g.bEf);
                            iconPreference.EZ(8);
                        } else if (f2 > 99) {
                            iconPreference.EX(0);
                            iconPreference.dh(getString(R.l.eQs), s.gd(getContext()));
                            iconPreference.EZ(8);
                        } else if (f2 > 0) {
                            iconPreference.EX(0);
                            iconPreference.dh(String.valueOf(f2), s.gd(getContext()));
                            iconPreference.EZ(8);
                        } else if (z) {
                            iconPreference.dh("", -1);
                            iconPreference.EX(8);
                            iconPreference.EZ(0);
                        } else if (intValue != 1) {
                            iconPreference.dh("", -1);
                            iconPreference.EX(8);
                            iconPreference.EY(0);
                            iconPreference.mw(true);
                            if (!t.ov(str2)) {
                                iconPreference.ac(str2, -1, Color.parseColor("#888888"));
                            }
                            iconPreference.Fc(8);
                        } else {
                            iconPreference.dh("", -1);
                            iconPreference.EX(8);
                            iconPreference.EZ(8);
                            iconPreference.EY(8);
                            iconPreference.di("", -1);
                        }
                    } else if (bh.ov(str)) {
                        iconPreference.EY(0);
                        iconPreference.ac(str, -1, -7566196);
                        iconPreference.mw(true);
                        iconPreference.EZ(8);
                    } else {
                        iconPreference.di("", -1);
                        iconPreference.EY(8);
                        iconPreference.EZ(0);
                    }
                    gVar = g.pQN;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(6);
                    if (z) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    objArr[1] = Integer.valueOf(i);
                    objArr[2] = "";
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(1);
                    gVar.h(14872, objArr);
                }
            }
            z = aR;
            aR = aQ;
            x.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s", new Object[]{Boolean.valueOf(aR), Boolean.valueOf(z)});
            x.d("MicroMsg.MoreTabUI", "bankcardDot : " + b);
            if (b) {
                if (aR) {
                    iconPreference.EX(0);
                    iconPreference.dh(getString(R.l.dFP), R.g.bEf);
                    iconPreference.EZ(8);
                } else if (f2 > 99) {
                    iconPreference.EX(0);
                    iconPreference.dh(getString(R.l.eQs), s.gd(getContext()));
                    iconPreference.EZ(8);
                } else if (f2 > 0) {
                    iconPreference.EX(0);
                    iconPreference.dh(String.valueOf(f2), s.gd(getContext()));
                    iconPreference.EZ(8);
                } else if (z) {
                    iconPreference.dh("", -1);
                    iconPreference.EX(8);
                    iconPreference.EZ(0);
                } else if (intValue != 1) {
                    iconPreference.dh("", -1);
                    iconPreference.EX(8);
                    iconPreference.EZ(8);
                    iconPreference.EY(8);
                    iconPreference.di("", -1);
                } else {
                    iconPreference.dh("", -1);
                    iconPreference.EX(8);
                    iconPreference.EY(0);
                    iconPreference.mw(true);
                    if (t.ov(str2)) {
                        iconPreference.ac(str2, -1, Color.parseColor("#888888"));
                    }
                    iconPreference.Fc(8);
                }
            } else if (bh.ov(str)) {
                iconPreference.di("", -1);
                iconPreference.EY(8);
                iconPreference.EZ(0);
            } else {
                iconPreference.EY(0);
                iconPreference.ac(str, -1, -7566196);
                iconPreference.mw(true);
                iconPreference.EZ(8);
            }
            gVar = g.pQN;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            if (z) {
                i = 0;
            } else {
                i = 1;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(1);
            gVar.h(14872, objArr);
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int aV = t.aV(obj);
        x.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(aV), mVar});
        ar.Hg();
        if (mVar != com.tencent.mm.z.c.CU() || aV <= 0) {
            x.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(aV), mVar});
        } else if (204817 == aV || 204820 == aV) {
            cnu();
        } else if (40 == aV) {
            cnt();
        } else if ("208899".equals(Integer.valueOf(i))) {
            cns();
        }
    }

    protected final void clt() {
        this.ilB = this.yjd;
    }

    protected final void clu() {
        this.ilB = this.yjd;
        ar.Hg();
        com.tencent.mm.z.c.CU().a(this);
        c.Bq().a(this.qlA);
        this.ilB.bk("more_tab_setting_personal_info", false);
        AccountInfoPreference accountInfoPreference = (AccountInfoPreference) this.yjd.YN("more_tab_setting_personal_info");
        String FT = com.tencent.mm.z.q.FT();
        if (t.ov(FT)) {
            FT = com.tencent.mm.z.q.FS();
            if (com.tencent.mm.storage.x.WB(FT)) {
                accountInfoPreference.vsT = null;
            } else {
                accountInfoPreference.vsT = FT;
            }
        } else {
            accountInfoPreference.vsT = FT;
        }
        accountInfoPreference.userName = com.tencent.mm.z.q.FS();
        CharSequence FU = com.tencent.mm.z.q.FU();
        if (t.ov(FU)) {
            FU = com.tencent.mm.z.q.FS();
        }
        accountInfoPreference.vsS = i.a(getContext(), FU);
        ((AccountInfoPreference) this.ilB.YN("more_tab_setting_personal_info")).vsV = new 4(this);
        IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_my_address");
        if (iconPreference != null) {
            int Tl = l.Tx().Tl();
            if (Tl > 0) {
                iconPreference.EX(0);
                iconPreference.dh(String.valueOf(Tl), R.g.bEf);
            } else {
                iconPreference.EX(8);
                iconPreference.dh("", -1);
            }
        }
        cnp();
        cns();
        cnr();
        if (d.OQ("favorite")) {
            this.ilB.bk("settings_mm_favorite", false);
        } else {
            this.ilB.bk("settings_mm_favorite", true);
        }
        cnu();
        cnt();
        cnq();
        if (com.tencent.mm.kernel.g.Df().g(com.tencent.mm.plugin.ai.a.a.class)) {
            this.ilB.bk("more_uishow", false);
        } else {
            this.ilB.bk("more_uishow", true);
        }
        this.ilB.notifyDataSetChanged();
        View findViewById = findViewById(R.h.ctC);
        if (findViewById != null && findViewById.getVisibility() != 8) {
            new af(Looper.getMainLooper()).post(new 6(this, findViewById));
        }
    }

    protected final void clv() {
    }

    protected final void clw() {
        c.Bq().b(this.qlA);
        ar.Hg();
        com.tencent.mm.z.c.CU().b(this);
    }

    protected final void clx() {
    }

    protected final void cly() {
    }

    public final void clA() {
    }

    public final void clB() {
    }

    public final void clD() {
    }

    public final void cmr() {
    }

    public final void cms() {
    }
}
