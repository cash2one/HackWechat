package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.pluginsdk.q$x;
import com.tencent.mm.pluginsdk.q.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.agw;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteDatabase;

public class SettingsAboutMicroMsgUI extends MMPreference implements e {
    private f ilB;
    private boolean qhX = false;
    private agw qhY;
    private int qhZ = 0;
    Intent qia = null;
    private ProgressDialog qib;
    private ak qic;
    private e qid = null;

    static /* synthetic */ void b(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        n CG = ar.CG();
        e 3 = new 3(settingsAboutMicroMsgUI);
        settingsAboutMicroMsgUI.qid = 3;
        CG.a(255, 3);
        k xVar = new x(2);
        xVar.hNL = 1;
        ar.CG().a(xVar, 0);
        settingsAboutMicroMsgUI.qic = new ak(Looper.getMainLooper(), new 4(settingsAboutMicroMsgUI, xVar), false);
        settingsAboutMicroMsgUI.qic.J(3000, 3000);
        Context context = settingsAboutMicroMsgUI.mController.xIM;
        settingsAboutMicroMsgUI.getString(R.l.dGO);
        settingsAboutMicroMsgUI.qib = h.a(context, settingsAboutMicroMsgUI.getString(R.l.eYG), false, new 5(settingsAboutMicroMsgUI, xVar));
    }

    static /* synthetic */ void g(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        ae.Vd("welcome_page_show");
        com.tencent.mm.kernel.k.e(settingsAboutMicroMsgUI, true);
        a.ift.up();
        ar.getNotification().wY();
        q$a.vcr.ar(settingsAboutMicroMsgUI.mController.xIM);
        settingsAboutMicroMsgUI.finish();
    }

    public final int XB() {
        return R.o.fci;
    }

    public final View bqw() {
        LinearLayout linearLayout = (LinearLayout) v.fv(this.mController.xIM).inflate(R.i.drW, null);
        TextView textView = (TextView) linearLayout.findViewById(R.h.cQA);
        TextView textView2 = (TextView) linearLayout.findViewById(R.h.cQz);
        String obj = g.Dj().CU().get(274436, "").toString();
        if (bh.ov(obj)) {
            obj = w.cfh();
        }
        obj = getString(R.l.esR, new Object[]{w.cfi(), obj});
        textView.setText(String.format("<a href='%s'>%s</a>", new Object[]{getString(R.l.eSl), getString(R.l.esM)}));
        textView2.setText(String.format("<a href='%s'>%s</a>", new Object[]{obj, getString(R.l.eAW)}));
        i.f(textView, 1);
        i.f(textView2, 1);
        ((TextView) linearLayout.findViewById(R.h.bYY)).setText(linearLayout.getResources().getString(R.l.dEu, new Object[]{Integer.valueOf(2017)}));
        return linearLayout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        ar.CG().a(11, this);
        if (q$x.bYd() != null) {
            ar.CG().a((k) q$x.bYd().box(), 0);
            com.tencent.mm.plugin.report.service.g.pQN.a(405, 15, 1, true);
        }
    }

    public void onResume() {
        super.onResume();
        bqx();
    }

    public void onDestroy() {
        ar.CG().b(11, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eNV);
        setBackBtn(new 1(this));
        bqx();
    }

    private void bqx() {
        IconPreference iconPreference;
        boolean z;
        this.ilB = this.yjd;
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fci);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.ilB.YN("settings_about_mm_header");
        String ag = com.tencent.mm.sdk.platformtools.f.ag(this.mController.xIM, d.vAz);
        if (d.vAC) {
            ag = ag + " " + getString(R.l.dDD);
        }
        settingsAboutMMHeaderPreference.qhU = ag;
        if (w.cff()) {
            ar.Hg();
            int e = bh.e((Integer) c.CU().get(12304, null));
            iconPreference = (IconPreference) this.ilB.YN("settings_update");
            if (e > 0) {
                iconPreference.EX(0);
                iconPreference.dh(String.valueOf(e), s.gd(this.mController.xIM));
            } else {
                iconPreference.EX(8);
                iconPreference.dh("", -1);
            }
        }
        if ((com.tencent.mm.sdk.platformtools.f.fdU & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        IconSummaryPreference iconSummaryPreference;
        if (this.qhX && !com.tencent.mm.sdk.platformtools.f.xeD) {
            iconSummaryPreference = (IconSummaryPreference) this.ilB.YN("funtion_update");
            iconSummaryPreference.qho = 0;
            CharSequence ag2 = com.tencent.mm.sdk.platformtools.f.ag(null, this.qhZ);
            iconSummaryPreference.dh(getString(R.l.dFP), R.g.bEf);
            iconSummaryPreference.setSummary(ag2);
            iconSummaryPreference.yiJ = 0;
            if (iconSummaryPreference.yiK != null) {
                iconSummaryPreference.yiK.setVisibility(iconSummaryPreference.yiJ);
            }
            this.ilB.YO("funtion_check_update");
        } else if (z || this.qhY == null || this.qhY.won == 0 || bh.ov(this.qhY.woo) || com.tencent.mm.sdk.platformtools.f.xeD) {
            this.ilB.YO("funtion_update");
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[]{this.qhY.woo, Integer.valueOf(this.qhY.wop)});
            if (this.qhY.wop != 0) {
                iconSummaryPreference = (IconSummaryPreference) this.ilB.YN("funtion_update");
                iconSummaryPreference.qho = 0;
                iconSummaryPreference.dh(getString(R.l.dFP), R.g.bEf);
                this.ilB.YO("funtion_check_update");
            } else {
                this.ilB.YO("funtion_update");
            }
        }
        if (!w.cff()) {
            this.ilB.bk("settings_report", true);
        }
        q$a.vcr.uz();
        this.ilB.bk("funtion_about_wechat", true);
        ar.Hg();
        if (bh.ov((String) c.CU().get(com.tencent.mm.storage.w.a.xvf, null))) {
            this.ilB.YO("funtion_crowdtest_update");
        } else {
            iconPreference = (IconPreference) this.ilB.YN("funtion_crowdtest_update");
            if (com.tencent.mm.s.c.Bq().aR(262157, 266263)) {
                iconPreference.EZ(0);
            }
        }
        this.ilB.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SettingsAboutMicroMsgUI", str + " item has been clicked!");
        Intent intent;
        if (str.equals("settings_update")) {
            if (w.cff()) {
                g.Dh();
                int Cg = com.tencent.mm.kernel.a.Cg();
                ar.Hg();
                int e = bh.e((Integer) c.CU().get(12304, null));
                str = getString(R.l.eNr, new Object[]{Integer.valueOf(Cg), Integer.valueOf(e)});
                if (str == null) {
                    return true;
                }
                ar.Hg();
                c.CU().set(12304, Integer.valueOf(0));
                intent = new Intent();
                intent.putExtra("title", getString(R.l.eNq));
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
            if (w.cff()) {
                str = getString(R.l.eLu, new Object[]{w.cfi(), Integer.valueOf(d.vAz)});
            } else {
                str = "http://blog.wechat.com/";
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("funtion_update")) {
            com.tencent.mm.plugin.report.service.g.pQN.a(405, 16, 1, true);
            str = "";
            if (this.qhX) {
                str = getString(R.l.eLv, new Object[]{w.cfi(), Integer.valueOf(this.qhZ)});
            } else if (!(this.qhY == null || this.qhY.won == 0 || bh.ov(this.qhY.woo))) {
                str = this.qhY.woo;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", true);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("funtion_check_update")) {
            com.tencent.mm.plugin.report.service.g.pQN.a(405, 17, 1, true);
            if (q$x.bYd() != null) {
                q$x.bYd().bow();
                if ((com.tencent.mm.sdk.platformtools.f.fdU & 1) != 0) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
                    Uri parse = Uri.parse(com.tencent.mm.sdk.platformtools.f.xez);
                    intent = new Intent("android.intent.action.VIEW", parse).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    if (parse == null || intent == null || !bh.k(this.mController.xIM, intent)) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                        com.tencent.mm.plugin.report.service.g.pQN.a(405, 18, 1, true);
                        return true;
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.pQN.a(405, 19, 1, true);
                    return true;
                } else if (this.qhY == null || this.qhY.won == 0 || bh.ov(this.qhY.woo)) {
                    ac.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bh.Wo()).commit();
                    q.s a = q$x.bYd().a(this, new 6(this));
                    if (a == null) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(405, 21, 1, true);
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.a(405, 22, 1, true);
                        a.update(3);
                        return true;
                    }
                } else {
                    str = this.qhY.woo;
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                    com.tencent.mm.plugin.report.service.g.pQN.a(405, 20, 1, true);
                    return true;
                }
            }
            return false;
        } else if (str.equals("funtion_about_wechat")) {
            return true;
        } else {
            if (str.equals("settings_report")) {
                intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("show_feedback", false);
                intent.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
                com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            } else if (str.equals("settings_quit_wechat")) {
                h.a(this.mController.xIM, R.l.euy, R.l.eux, R.l.dHd, R.l.dFR, new 2(this), null);
                return true;
            } else if (!str.equals("funtion_crowdtest_update")) {
                return false;
            } else {
                com.tencent.mm.s.c.Bq().aS(262157, 266263);
                ar.Hg();
                str = (String) c.CU().get(com.tencent.mm.storage.w.a.xvf, null);
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i2 + " errType " + i);
        t tVar = (t) kVar;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + tVar.bYb());
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + tVar.bYa());
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + d.vAz);
        if (q$x.vcC || (i == 0 && i2 == 0)) {
            this.qhZ = tVar.bYa();
            if (this.qhZ <= 0 || this.qhZ <= d.vAz) {
                this.qhX = false;
                if (g.Dh().Cy()) {
                    com.tencent.mm.s.c.Bq().o(262145, false);
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            } else {
                this.qhX = true;
                if (g.Dh().Cy()) {
                    com.tencent.mm.s.c.Bq().o(262145, true);
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            }
            this.qhY = tVar.bYc();
        }
        bqx();
    }
}
