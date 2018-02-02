package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.4;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.5;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.6;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.LoginPasswordUI;
import com.tencent.mm.ui.account.LoginVoiceUI;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bq;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@a(19)
public class SettingsSwitchAccountUI extends MMActivity implements e {
    private SwitchAccountGridView qgU;
    private String qgX;
    private Map<String, SwitchAccountModel> qgZ = new HashMap();
    private boolean qjD;
    private TextView qld;
    private TextView qle;
    private View qlf;
    private View qlg;
    private TextView qlh;
    private ValueAnimator qli;
    private ak qlj;
    private boolean qlk;
    private boolean qll;
    private int scene;
    private TextView titleView;

    static /* synthetic */ void a(SettingsSwitchAccountUI settingsSwitchAccountUI, String str) {
        x.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s, current %s", new Object[]{str, settingsSwitchAccountUI.qgX});
        if (str.equals(settingsSwitchAccountUI.qgX)) {
            settingsSwitchAccountUI.finish();
            return;
        }
        logout();
        ac.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", str).commit();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle("");
        cmW();
        getSupportActionBar().hide();
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.qlf = findViewById(R.h.cPP);
        this.qlg = findViewById(R.h.cPN);
        this.titleView = (TextView) findViewById(R.h.cPO);
        this.qlh = (TextView) findViewById(R.h.cPK);
        this.qld = (TextView) findViewById(R.h.cPL);
        this.qle = (TextView) findViewById(R.h.cPJ);
        this.qgU = (SwitchAccountGridView) findViewById(R.h.cPM);
        this.qgU.setRowCount(1);
        this.qgU.qng = new b(this) {
            final /* synthetic */ SettingsSwitchAccountUI qlm;

            {
                this.qlm = r1;
            }

            public final void Jb(String str) {
                if (bh.ov(str)) {
                    ac.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
                    if (this.qlm.scene == 0) {
                        SettingsSwitchAccountUI.logout();
                        return;
                    }
                    Intent intent = new Intent(this.qlm, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 1);
                    intent.putExtra("from_switch_account", true);
                    this.qlm.startActivity(intent);
                    com.tencent.mm.ui.base.b.fE(this.qlm);
                } else if (this.qlm.scene == 0) {
                    SettingsSwitchAccountUI.a(this.qlm, str);
                } else {
                    this.qlm.Ja(str);
                }
            }
        };
        if (this.scene == 0) {
            this.qle.setOnClickListener(new 3(this));
        } else {
            this.qle.setVisibility(8);
        }
        Set<String> HV = bq.hhK.HV();
        this.qgX = aq.hfP.H("login_weixin_username", "");
        x.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[]{Integer.valueOf(this.scene), this.qgX});
        if (bh.ov(this.qgX) || HV.contains(this.qgX)) {
            if (!HV.isEmpty()) {
                for (String str : HV) {
                    this.qgZ.put(str, new SwitchAccountModel(str, bq.hhK.getString(str, "login_user_name"), bq.hhK.getString(str, "last_avatar_path"), bq.hhK.getString(str, "last_logout_no_pwd_ticket"), bh.VI(bq.hhK.getString(str, "last_login_use_voice"))));
                }
            }
        } else if (this.scene != 2 || bq.hhK.ib(this.qgX)) {
            this.qgZ.put(this.qgX, new SwitchAccountModel(this.qgX, aq.hfP.H("login_user_name", ""), aq.hfP.GY(), "", bh.VI(aq.hfP.H("last_login_use_voice", ""))));
        }
        if (this.qgZ.size() == 0) {
            Intent intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            intent.putExtra("can_finish", true);
            startActivity(intent);
            finish();
            com.tencent.mm.ui.base.b.fH(this);
        }
        N(this.qgZ);
        this.qgU.O(this.qgZ);
        if (this.scene == 1) {
            String string = ac.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "");
            x.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", new Object[]{string});
            if (bh.ov(string)) {
                this.qlk = false;
                intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("from_switch_account", true);
                startActivity(intent);
                com.tencent.mm.ui.base.b.fE(this);
            } else {
                g.Dh();
                if (com.tencent.mm.kernel.a.Cx()) {
                    x.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
                    finish();
                } else {
                    Ja(string);
                }
            }
        } else if (this.scene == 0) {
            this.qgU.qgX = this.qgX;
        }
        this.qgU.brm();
        bqV();
        this.qgU.qni = new 4(this);
        this.qli = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.qli.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ SettingsSwitchAccountUI qlm;

            {
                this.qlm = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.qlm.qgU.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) this.qlm.qgU.getHeight()));
            }
        });
        this.qli.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ SettingsSwitchAccountUI qlm;

            {
                this.qlm = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                x.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
                Intent at = com.tencent.mm.plugin.c.a.ifs.at(this.qlm);
                at.addFlags(67108864);
                this.qlm.startActivity(at);
                this.qlm.finish();
                com.tencent.mm.ui.base.b.fG(this.qlm);
            }
        });
        this.qli.setDuration(500);
    }

    private static void N(Map<String, SwitchAccountModel> map) {
        if (map.size() == 2) {
            String[] strArr = new String[2];
            int i = 0;
            for (SwitchAccountModel switchAccountModel : map.values()) {
                int i2 = i + 1;
                strArr[i] = switchAccountModel.username;
                i = i2;
            }
            if (!bh.G(new String[]{strArr[0], strArr[1]}) && strArr[0].equals(strArr[1])) {
                for (String hZ : map.keySet()) {
                    bq.hhK.hZ(hZ);
                }
                throw new NullPointerException(String.format("tow accounts have the same username!!! , %s, %s", new Object[]{strArr[0], strArr[1]}));
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void Ja(String str) {
        SwitchAccountModel switchAccountModel = (SwitchAccountModel) this.qgZ.get(str);
        if (switchAccountModel != null && !this.qlk) {
            this.qlk = true;
            g.CG().a(new v(str, switchAccountModel.username, switchAccountModel.qgf, ""), 0);
            this.qgU.qna = str;
            this.qgU.brm();
            bqV();
        }
    }

    private void bqV() {
        if (this.qlk) {
            this.qld.setVisibility(8);
        } else if (this.qgZ.size() <= 1 && this.scene == 0) {
            this.qld.setVisibility(8);
            this.qjD = false;
            this.qgU.qmX = false;
        } else if (this.qjD) {
            this.titleView.setText(R.l.eNn);
            this.qlh.setVisibility(0);
            if (this.qll) {
                this.qld.setText(getString(R.l.dFl));
                this.qld.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SettingsSwitchAccountUI qlm;

                    {
                        this.qlm = r1;
                    }

                    public final void onClick(View view) {
                        this.qlm.qjD = false;
                        this.qlm.qll = false;
                        this.qlm.qgU.qmX = false;
                        this.qlm.qgU.brm();
                        this.qlm.bqV();
                        if (this.qlm.qgU.qnd.size() == 0) {
                            if (bq.hhK.HV().size() > 1) {
                                com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(11)});
                            } else {
                                com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(11)});
                            }
                            Intent at = com.tencent.mm.plugin.c.a.ifs.at(this.qlm);
                            at.addFlags(67108864);
                            this.qlm.startActivity(at);
                            this.qlm.finish();
                            com.tencent.mm.ui.base.b.fG(this.qlm);
                            this.qlm.qlk = false;
                        }
                    }
                });
                return;
            }
            this.qld.setText(getString(R.l.dEn));
            this.qld.setOnClickListener(new 9(this));
        } else {
            this.titleView.setText(R.l.eNp);
            this.qlh.setVisibility(8);
            this.qld.setText(getString(R.l.eNn));
            this.qld.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsSwitchAccountUI qlm;

                {
                    this.qlm = r1;
                }

                public final void onClick(View view) {
                    if (!this.qlm.qjD) {
                        this.qlm.qjD = true;
                        this.qlm.qgU.qmX = this.qlm.qjD;
                        this.qlm.qgU.brm();
                        this.qlm.bqV();
                        if (bq.hhK.HV().size() > 1) {
                            com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(3)});
                            return;
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(3)});
                    }
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.scene == 1 || this.scene == 2) {
            g.CG().a(701, this);
        }
        if (this.scene == 0) {
            g.CG().a(281, this);
            g.CG().a(282, this);
            g.CG().a(255, this);
        }
        this.qgU.brm();
        bqV();
        if (this.scene == 1 || this.scene == 2) {
            g.Dh();
            if (com.tencent.mm.kernel.a.Cx()) {
                this.qlk = true;
                Intent at = com.tencent.mm.plugin.c.a.ifs.at(this);
                at.addFlags(67108864);
                startActivity(at);
                finish();
                com.tencent.mm.ui.base.b.fG(this);
            }
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.scene == 1) {
            SwitchAccountGridView switchAccountGridView = this.qgU;
            if (switchAccountGridView.qnb) {
                switchAccountGridView.qnb = false;
                if (switchAccountGridView.qnc != null) {
                    switchAccountGridView.qnc.end();
                }
            }
        }
        g.CG().b(701, this);
        g.CG().b(281, this);
        g.CG().b(282, this);
        g.CG().b(255, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, this %s", new Object[]{Integer.valueOf(i2), str, kVar, this});
        if (kVar.getType() == 701) {
            if (i == 0 && i2 == 0) {
                this.qlf.setVisibility(4);
                this.qlg.setVisibility(4);
                SwitchAccountGridView switchAccountGridView = this.qgU;
                if (!switchAccountGridView.qnb) {
                    if (switchAccountGridView.qnc == null && !bh.ov(switchAccountGridView.qna)) {
                        int min = Math.min(2, switchAccountGridView.qnd.size());
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new 4(switchAccountGridView, min));
                        ofFloat.setDuration(200);
                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new 5(switchAccountGridView, min));
                        ofFloat2.setDuration(300);
                        switchAccountGridView.qnc = new AnimatorSet();
                        switchAccountGridView.qnc.addListener(new 6(switchAccountGridView));
                        switchAccountGridView.qnc.playSequentially(new Animator[]{ofFloat, ofFloat2});
                    }
                    if (switchAccountGridView.qnc != null) {
                        switchAccountGridView.qnb = true;
                        switchAccountGridView.qnc.start();
                    }
                }
                ar.unhold();
                d.bq(this);
                if (bq.hhK.HV().size() > 1) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
                }
                this.qgU.qnh = new SwitchAccountGridView.a(this) {
                    final /* synthetic */ SettingsSwitchAccountUI qlm;

                    {
                        this.qlm = r1;
                    }

                    public final void bqZ() {
                        this.qlm.qgU.qgX = aq.hfP.H("login_weixin_username", "");
                        this.qlm.qgU.qna = "";
                        this.qlm.qgU.brm();
                        this.qlm.qli.start();
                    }
                };
            } else {
                this.qgU.qna = "";
                this.qlk = false;
                h.bu(this, getString(R.l.eNo));
                String str2 = ((v) kVar).hNC;
                if (!bh.ov(str2) && this.qgZ.containsKey(str2)) {
                    Intent intent = new Intent();
                    x.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[]{str2, Integer.valueOf(((SwitchAccountModel) this.qgZ.get(str2)).qgg)});
                    if ((((SwitchAccountModel) this.qgZ.get(str2)).qgg & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                        intent.setClass(this, LoginVoiceUI.class);
                    } else {
                        intent.setClass(this, LoginPasswordUI.class);
                    }
                    intent.putExtra("switch_login_wx_id", str2);
                    startActivity(intent);
                    finish();
                    com.tencent.mm.ui.base.b.fH(this);
                }
                if (bq.hhK.HV().size() > 1) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
                }
            }
        }
        if (kVar.getType() == 255) {
            if (((com.tencent.mm.modelsimple.x) kVar).hNM != 2) {
                return;
            }
            if (i == 0 && i2 == 0) {
                bqW();
            } else if (i2 == -3 && i == 4) {
                if (bq.hhK.HV().size() > 1) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(7)});
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(7)});
                }
                Intent intent2 = new Intent(this.mController.xIM, RegByMobileSetPwdUI.class);
                intent2.putExtra("kintent_hint", getString(R.l.eDT));
                startActivityForResult(intent2, 701);
            } else if (!com.tencent.mm.plugin.setting.a.ift.a(this, i, i2, str)) {
            }
        } else if (kVar.getType() == 282) {
            g.Dh();
            if (com.tencent.mm.kernel.a.Cx()) {
                String RW = ((u) kVar).RW();
                x.i("MicroMsg.SettingsSwitchAccountUI", "logout return");
                if (bh.ov(RW)) {
                    x.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
                }
                bq.hhK.j(aq.hfP.H("login_weixin_username", ""), "last_logout_no_pwd_ticket", RW);
                if (this.qlj != null && !this.qlj.cfK()) {
                    this.qlj.TG();
                    bqX();
                }
            }
        }
    }

    private void goBack() {
        if (this.scene == 2 || this.scene == 1) {
            Intent at = com.tencent.mm.plugin.c.a.ifs.at(this);
            at.addFlags(67108864);
            at.putExtra("can_finish", true);
            startActivity(at);
            finish();
            com.tencent.mm.ui.base.b.fG(this);
            this.qlk = false;
            return;
        }
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dsj;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 701 && i2 == -1) {
            bqW();
        }
    }

    private static void logout() {
        if (!(ar.CG() == null || ar.CG().hmV == null)) {
            ar.CG().hmV.bF(false);
        }
        Object[] objArr = new Object[1];
        ar.Hg();
        objArr[0] = Integer.valueOf(c.Cg());
        x.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        com.tencent.mm.modelstat.c.SO().SP();
        k xVar = new com.tencent.mm.modelsimple.x(2);
        xVar.hNL = 1;
        ar.CG().a(xVar, 0);
    }

    private void bqW() {
        ar.Hg();
        if (c.ET()) {
            ar.CG().a(new am(2), 0);
        }
        ar.CG().a(new u(), 0);
        this.qgU.qmY = true;
        this.qgU.brm();
        if (this.qlj == null) {
            this.qlj = new ak(Looper.getMainLooper(), new 2(this), false);
            this.qlj.J(8000, 8000);
        }
    }

    private void bqX() {
        x.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
        com.tencent.mm.plugin.setting.a.ift.us();
        com.tencent.mm.sdk.b.b izVar = new iz();
        izVar.fzC.status = 0;
        izVar.fzC.aAk = 0;
        com.tencent.mm.sdk.b.a.xef.m(izVar);
        izVar = new y();
        izVar.fnQ.fnR = true;
        com.tencent.mm.sdk.b.a.xef.m(izVar);
        ae.Vd("show_whatsnew");
        com.tencent.mm.kernel.k.e(this, true);
        d.B(this, null);
        if (g.Dh().Cy()) {
            String iW = com.tencent.mm.ad.b.iW(q.FS());
            aq.hfP.hM(iW);
            g.Dj().CU().a(w.a.xxN, iW);
        }
        x.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[]{aq.hfP.H("login_user_name", "")});
        Map GB = q.GB();
        if (bh.ov((String) GB.get("login_user_name"))) {
            GB.put("login_user_name", aq.hfP.H("login_user_name", ""));
        }
        bq.hhK.c(q.FS(), GB);
        ac.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        intent.putExtra("key_transit_to_switch_account", true);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.qgZ.values());
        intent.putParcelableArrayListExtra("key_switch_account_users", arrayList);
        com.tencent.mm.plugin.setting.a.ifs.s(intent, this);
        finish();
        com.tencent.mm.ui.base.b.fH(this);
    }
}
