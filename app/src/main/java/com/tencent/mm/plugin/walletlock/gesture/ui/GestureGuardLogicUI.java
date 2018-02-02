package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.b.h;
import com.tencent.mm.plugin.walletlock.b.i;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.protocal.c.aug;
import com.tencent.mm.protocal.c.auh;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.protocal.c.bbv;
import com.tencent.mm.protocal.c.bbw;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI extends MMActivity implements OnClickListener, com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a {
    private String hzj = null;
    private af mHandler = new af(Looper.getMainLooper());
    private int mStatus;
    private int mVR = 0;
    private int tfN = -1;
    private int tfW = 0;
    private int tfX = 0;
    private a[] tfY = null;
    private Animation tfZ = null;
    private List<f> tga = null;
    private List<f> tgb = null;
    private boolean tgc = false;
    private int tgd = 0;
    private k tge = null;
    private k tgf = null;
    private String tgg = null;
    private ViewFlipper tgh = null;
    private Dialog tgi = null;
    private boolean tgj = true;
    private boolean tgk = false;
    private String tgl;

    private interface a {
        void onDone();
    }

    static /* synthetic */ void bOb() {
        aj.a(q.FS(), 9, "PatternLockUpdate", "");
        g.pQN.h(11473, new Object[0]);
    }

    static /* synthetic */ int k(GestureGuardLogicUI gestureGuardLogicUI) {
        int i = gestureGuardLogicUI.tgd + 1;
        gestureGuardLogicUI.tgd = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!ac.getPackageName().equals(intent.getPackage()) || bh.ov(intent.getStringExtra("action")) || bh.ov(intent.getStringExtra("next_action"))) {
            x.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
            finish();
            return;
        }
        this.tgh = new ViewFlipper(this);
        this.tfY = new a[]{new a(this), new a(this), new a(this)};
        a[] aVarArr = this.tfY;
        int length = aVarArr.length;
        while (i < length) {
            a aVar = aVarArr[i];
            this.tgh.addView(aVar.mView);
            aVar.tgu.tgW = this;
            aVar.tgv.setOnClickListener(this);
            i++;
        }
        setContentView(this.tgh);
        this.hzj = getIntent().getStringExtra("token");
        this.tgg = getIntent().getStringExtra(DownloadSettingTable$Columns.TYPE);
        this.tgl = getIntent().getStringExtra("verify_title");
        this.tfN = getIntent().getIntExtra("scene", -1);
        if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            h.bOm();
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.mStatus == 0) {
            int i;
            com.tencent.mm.plugin.walletlock.gesture.a.g bNR = d.bNR();
            if (bNR.tfU != -1) {
                e.a(bNR);
                if (bNR.tfV / 1000 < 600) {
                    d.H(bNR.tfU, bNR.tfV);
                    i = 1;
                    if (i != 0) {
                        this.tgd = d.bNV();
                        if (this.tgd != -1) {
                            return;
                        }
                    }
                    this.tgd = 0;
                }
                d.bNS();
            }
            i = 0;
            if (i != 0) {
                this.tgd = d.bNV();
                if (this.tgd != -1) {
                    return;
                }
            }
            this.tgd = 0;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tge != null) {
            com.tencent.mm.kernel.g.CG().c(this.tge);
            this.tge = null;
        }
        if (this.tgf != null) {
            com.tencent.mm.kernel.g.CG().c(this.tgf);
            this.tgf = null;
        }
        if (this.tgi != null && this.tgi.isShowing()) {
            this.tgi.dismiss();
        }
        if (this.tgh != null) {
            this.tgh.removeAllViews();
            this.tgh = null;
        }
        for (int i = 0; i < this.tfY.length; i++) {
            a aVar = this.tfY[i];
            aVar.tgu.setOnClickListener(null);
            aVar.tgv.setOnClickListener(null);
            aVar.mView = null;
            aVar.tgs = null;
            aVar.tgt = null;
            aVar.tgu = null;
            aVar.tgv = null;
            this.tfY[i] = null;
        }
        this.tfY = null;
    }

    protected final void initView() {
        aWs();
        setMMSubTitle(com.tencent.mm.plugin.walletlock.a.g.eXs);
        this.tfZ = AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.walletlock.a.a.tdY);
        this.tfW = getResources().getColor(b.tea);
        this.tfX = getResources().getColor(b.teb);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("action");
        intent.getStringExtra("next_action");
        if ("action.switch_on_pattern".equals(stringExtra)) {
            this.mStatus = 16;
            R(1, false);
        } else if ("action.verify_pattern".equals(stringExtra)) {
            if (com.tencent.mm.plugin.walletlock.gesture.a.b.bNO()) {
                this.tgc = true;
                this.mStatus = 20;
            } else {
                this.tgc = false;
                this.mStatus = 0;
            }
            R(0, false);
        }
        setBackBtn(new 1(this));
        x.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[]{Integer.valueOf(this.mStatus)}));
        bNY();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.walletlock.a.e.ten;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (intent == null) {
            x.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", 0);
        if (intExtra == 0) {
            this.hzj = intent.getStringExtra("key_token");
            this.tgg = intent.getStringExtra("key_type");
            String stringExtra = getIntent().getStringExtra("next_action");
            if ("next_action.goto_protected_page".equals(stringExtra) || "next_action.modify_pattern".equals(stringExtra)) {
                if ("next_action.modify_pattern".equals(stringExtra)) {
                    this.tgk = true;
                }
                this.tgj = false;
                setBackBtn(null);
                lV(false);
                this.mStatus = 16;
                R(1, false);
            } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                String str = this.hzj;
                com.tencent.mm.ae.u.a 12 = new 12(this);
                b(new 13(this));
                if (str == null) {
                    bJB();
                    12.a(3, -6, getString(com.tencent.mm.plugin.walletlock.a.g.teA), null, null);
                } else {
                    com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
                    aVar.hmj = new bbv();
                    aVar.hmk = new bbw();
                    aVar.hmi = 688;
                    aVar.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
                    com.tencent.mm.ae.b JZ = aVar.JZ();
                    bbv com_tencent_mm_protocal_c_bbv = (bbv) JZ.hmg.hmo;
                    com_tencent_mm_protocal_c_bbv.wIf = new bdn().bj(str.getBytes());
                    com_tencent_mm_protocal_c_bbv.pK = 3;
                    u.a(JZ, new 14(this, 12), false);
                }
            } else {
                this.mStatus = 1;
            }
            bNY();
        } else if (intExtra == -1) {
            Toast.makeText(this, getString(com.tencent.mm.plugin.walletlock.a.g.tey), 0).show();
        }
    }

    public void onClick(View view) {
        if (view.getId() == com.tencent.mm.plugin.walletlock.a.d.tel) {
            Intent intent = new Intent();
            intent.putExtra("action", "action.verify_paypwd");
            intent.putExtra("key_wallet_lock_type", 1);
            com.tencent.mm.bm.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, 1001);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (bNX()) {
            return false;
        }
        q(0, 4, "user cancel when setting gesture");
        return false;
    }

    private void q(int i, int i2, String str) {
        x.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        setResult(i, intent);
        finish();
    }

    private boolean bNX() {
        if (this.mStatus == 20 || this.mStatus == 0 || this.mStatus == 2 || this.mStatus == 1) {
            bOa();
            return false;
        }
        if (this.tgj) {
            String stringExtra = getIntent().getStringExtra("next_action");
            stringExtra = ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) ? getString(com.tencent.mm.plugin.walletlock.a.g.tev) : getString(com.tencent.mm.plugin.walletlock.a.g.tew);
            new com.tencent.mm.ui.base.i.a(this).mi(false).YG(stringExtra).EC(com.tencent.mm.plugin.walletlock.a.g.tet).a(new 20(this)).ED(com.tencent.mm.plugin.walletlock.a.g.ter).b(new 19(this)).akx().show();
        } else {
            new com.tencent.mm.ui.base.i.a(this).mi(true).EA(com.tencent.mm.plugin.walletlock.a.g.tex).EC(com.tencent.mm.plugin.walletlock.a.g.tes).a(new DialogInterface.OnClickListener(this) {
                final /* synthetic */ GestureGuardLogicUI tgm;

                {
                    this.tgm = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).akx().show();
        }
        return true;
    }

    private void bNY() {
        while (true) {
            a aVar = this.tfY[this.mVR];
            String stringExtra;
            List list;
            com.tencent.mm.ae.b.a aVar2;
            aug com_tencent_mm_protocal_c_aug;
            long elapsedRealtime;
            switch (this.mStatus) {
                case 0:
                    setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.teK));
                    this.tgc = false;
                    aVar.tgu.tgK = true;
                    aVar.tgu.tgW = this;
                    if (!"next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        aVar.tgs.setText(getString(com.tencent.mm.plugin.walletlock.a.g.teI));
                    } else if (bh.ov(this.tgl)) {
                        aVar.tgs.setText(getString(com.tencent.mm.plugin.walletlock.a.g.teJ));
                    } else {
                        aVar.tgs.setText(this.tgl);
                    }
                    aVar.tgs.setTextColor(this.tfW);
                    if (aVar.tgv.getVisibility() != 0) {
                        aVar.tgv.setVisibility(0);
                        return;
                    }
                    return;
                case 1:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        aVar.tgu.bOe();
                        R(1, true);
                        this.mStatus = 16;
                    } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                        list = this.tgb;
                        com.tencent.mm.ae.u.a 26 = new 26(this);
                        b(new OnCancelListener(this) {
                            final /* synthetic */ GestureGuardLogicUI tgm;

                            {
                                this.tgm = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.tgm.tfY[this.tgm.mVR].tgu.bOe();
                                if (this.tgm.tgf != null && !this.tgm.tgf.aBT) {
                                    com.tencent.mm.kernel.g.CG().c(this.tgm.tgf);
                                }
                            }
                        });
                        aVar2 = new com.tencent.mm.ae.b.a();
                        aVar2.hmj = new aug();
                        aVar2.hmk = new auh();
                        aVar2.hmi = 689;
                        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                        com.tencent.mm.ae.b JZ = aVar2.JZ();
                        com_tencent_mm_protocal_c_aug = (aug) JZ.hmg.hmo;
                        com_tencent_mm_protocal_c_aug.pK = 3;
                        com_tencent_mm_protocal_c_aug.wCk = new bdn().bj(e.ci(list));
                        u.a(JZ, new 11(this, 26), false);
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra)) {
                        d.fh(SystemClock.elapsedRealtime());
                        bNZ();
                        h.aa(this.tfN, 1, 0);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    d.H(elapsedRealtime, 0);
                    d.zw(this.tgd);
                    d.bNE();
                    if (this.tgd == 5) {
                        this.tgc = true;
                        d.G(elapsedRealtime, 0);
                        aVar.tgu.bOe();
                        aVar.tgu.tgK = false;
                        this.mStatus = 20;
                        bNY();
                        com.tencent.mm.ui.base.i.a aVar3 = new com.tencent.mm.ui.base.i.a(this);
                        aVar3.mi(false).YG(String.format(getString(com.tencent.mm.plugin.walletlock.a.g.teu), new Object[]{Long.valueOf(10)}));
                        aVar3.EC(com.tencent.mm.plugin.walletlock.a.g.teq).a(new 16(this));
                        aVar3.ED(com.tencent.mm.plugin.walletlock.a.g.tep).b(new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ GestureGuardLogicUI tgm;

                            {
                                this.tgm = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.tgm.bOa();
                                this.tgm.finish();
                            }
                        });
                        aVar3.akx().show();
                    } else {
                        aVar.tgu.tgK = false;
                        aVar.tgu.a(PatternLockView.b.tgZ);
                        a(String.format(getResources().getString(com.tencent.mm.plugin.walletlock.a.g.teB), new Object[]{Integer.valueOf(5 - this.tgd)}), new 27(this, aVar));
                    }
                    x.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", new Object[]{getIntent().getStringExtra("next_action")});
                    if (!"next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        return;
                    }
                    if (this.tgd == 5) {
                        h.aa(this.tfN, 1, 2);
                        return;
                    } else {
                        h.aa(this.tfN, 1, 1);
                        return;
                    }
                case 16:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) {
                        setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.teL));
                    } else {
                        setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.teM));
                    }
                    this.tgc = false;
                    aVar.tgu.tgK = true;
                    aVar.tgu.tgW = this;
                    aVar.tgs.setText(getString(com.tencent.mm.plugin.walletlock.a.g.teH));
                    aVar.tgs.setTextColor(getResources().getColor(b.tea));
                    if (aVar.tgv.getVisibility() != 8) {
                        aVar.tgv.setVisibility(8);
                        return;
                    }
                    return;
                case 17:
                    aVar.tgs.setText(getResources().getString(com.tencent.mm.plugin.walletlock.a.g.teF));
                    aVar.tgs.setTextColor(this.tfW);
                    aVar.tgu.bOe();
                    aVar.tgu.tgK = true;
                    if (aVar.tgv.getVisibility() != 8) {
                        aVar.tgv.setVisibility(8);
                        return;
                    }
                    return;
                case 18:
                    String stringExtra2 = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra2)) {
                        if (this.tgk) {
                            this.tgk = false;
                            a(this.hzj, this.tga, new com.tencent.mm.ae.u.a(this) {
                                final /* synthetic */ GestureGuardLogicUI tgm;

                                {
                                    this.tgm = r1;
                                }

                                public final int a(int i, int i2, String str, com.tencent.mm.ae.b bVar, k kVar) {
                                    if (i2 == 0) {
                                        Toast.makeText(this.tgm, this.tgm.getString(com.tencent.mm.plugin.walletlock.a.g.teP), 0).show();
                                        g.pQN.h(11474, new Object[0]);
                                    } else {
                                        Toast.makeText(this.tgm, this.tgm.getString(com.tencent.mm.plugin.walletlock.a.g.tey), 0).show();
                                    }
                                    this.tgm.hzj = null;
                                    this.tgm.tga = null;
                                    this.tgm.finish();
                                    return 0;
                                }
                            });
                            return;
                        }
                        list = this.tgb;
                        List list2 = this.tga;
                        com.tencent.mm.ae.u.a anonymousClass22 = new com.tencent.mm.ae.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI tgm;

                            {
                                this.tgm = r1;
                            }

                            public final int a(int i, int i2, String str, com.tencent.mm.ae.b bVar, k kVar) {
                                if (i2 == 0) {
                                    Toast.makeText(this.tgm, this.tgm.getString(com.tencent.mm.plugin.walletlock.a.g.teP), 0).show();
                                } else {
                                    Toast.makeText(this.tgm, this.tgm.getString(com.tencent.mm.plugin.walletlock.a.g.tey), 0).show();
                                }
                                this.tgm.tgb = null;
                                this.tgm.tga = null;
                                this.tgm.finish();
                                return 0;
                            }
                        };
                        aVar2 = new com.tencent.mm.ae.b.a();
                        b(new OnCancelListener(this) {
                            final /* synthetic */ GestureGuardLogicUI tgm;

                            {
                                this.tgm = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.tgm.tfY[this.tgm.mVR].tgu.bOe();
                                if (this.tgm.tgf != null && !this.tgm.tgf.aBT) {
                                    com.tencent.mm.kernel.g.CG().c(this.tgm.tgf);
                                }
                            }
                        });
                        aVar2.hmj = new aug();
                        aVar2.hmk = new auh();
                        aVar2.hmi = 689;
                        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                        com.tencent.mm.ae.b JZ2 = aVar2.JZ();
                        com_tencent_mm_protocal_c_aug = (aug) JZ2.hmg.hmo;
                        com_tencent_mm_protocal_c_aug.pK = 1;
                        com_tencent_mm_protocal_c_aug.wCk = new bdn().bj(e.ci(list));
                        com_tencent_mm_protocal_c_aug.wCl = new bdn().bj(e.ci(list2));
                        u.a(JZ2, new 9(this, anonymousClass22), false);
                        return;
                    } else if ("next_action.switch_on_pattern".equals(stringExtra2)) {
                        a(this.hzj, this.tga, new 23(this));
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra2)) {
                        a(this.hzj, this.tga, new 24(this));
                        return;
                    } else {
                        return;
                    }
                case 19:
                    aVar.tgu.tgK = false;
                    aVar.tgu.a(PatternLockView.b.tgZ);
                    a(getResources().getString(com.tencent.mm.plugin.walletlock.a.g.teG), new 25(this, aVar));
                    return;
                case 20:
                    setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.teK));
                    this.tgc = true;
                    aVar.tgu.tgK = false;
                    aVar.tgu.tgW = null;
                    elapsedRealtime = (long) Math.ceil(((double) (600 - (d.bNP().tfV / 1000))) / 60.0d);
                    aVar.tgs.setText(String.format(getString(com.tencent.mm.plugin.walletlock.a.g.teE), new Object[]{Long.valueOf(elapsedRealtime)}));
                    aVar.tgs.setTextColor(getResources().getColor(b.teb));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(PatternLockView patternLockView, List<f> list) {
        boolean z = true;
        if (this.mStatus == 16) {
            if (list.size() < 4) {
                patternLockView.tgK = false;
                patternLockView.a(PatternLockView.b.tgZ);
                a(String.format(getString(com.tencent.mm.plugin.walletlock.a.g.teC), new Object[]{Integer.valueOf(4)}), new 2(this, patternLockView));
                return;
            }
            this.tga = list;
            patternLockView.bOe();
            this.mStatus = 17;
            R(2, true);
        } else if (this.mStatus == 0) {
            com.tencent.mm.ae.u.a 3 = new 3(this, list);
            avl bNU = d.bNU();
            avk bNT = d.bNT();
            g.pQN.h(11453, new Object[0]);
            b(new OnCancelListener(this) {
                final /* synthetic */ GestureGuardLogicUI tgm;

                {
                    this.tgm = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.tgm.tfY[this.tgm.mVR].tgu.bOe();
                    if (this.tgm.tgf != null && !this.tgm.tgf.aBT) {
                        com.tencent.mm.kernel.g.CG().c(this.tgm.tgf);
                    }
                }
            });
            boolean z2 = e.b(bNT) ? e.b(bNU) ? bNT.version < bNU.wDd : false : true;
            x.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[]{Boolean.valueOf(e.b(bNU)), Boolean.valueOf(e.b(bNT)), Boolean.valueOf(z2)}));
            if (z2) {
                com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
                aVar.hmj = new aug();
                aVar.hmk = new auh();
                aVar.hmi = 689;
                aVar.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                com.tencent.mm.ae.b JZ = aVar.JZ();
                aug com_tencent_mm_protocal_c_aug = (aug) JZ.hmg.hmo;
                com_tencent_mm_protocal_c_aug.pK = 2;
                com_tencent_mm_protocal_c_aug.wCk = new bdn().bj(e.ci(list));
                u.a(JZ, new 7(this, 3), false);
                return;
            }
            bJB();
            avk bNT2 = d.bNT();
            if (bNT2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.Dh();
                stringBuilder.append(new o(com.tencent.mm.kernel.a.Cg()).longValue());
                stringBuilder.append('_');
                stringBuilder.append(new String(e.ci(list)));
                z = new String(bNT2.wDa.wJD.oz).equals(com.tencent.mm.a.g.s(stringBuilder.toString().getBytes()));
            }
            if (z) {
                3.a(3, 0, null, null, null);
                return;
            } else {
                3.a(3, -3, null, null, null);
                return;
            }
        } else if (this.mStatus != 17) {
            return;
        } else {
            if (this.tga.equals(list)) {
                patternLockView.bOe();
                this.tgc = false;
                this.tgd = 0;
                d.bNW();
                d.bNQ();
                d.bNS();
                d.bNE();
                this.mStatus = 18;
            } else {
                this.mStatus = 19;
            }
        }
        bNY();
    }

    private void a(String str, List<f> list, final com.tencent.mm.ae.u.a aVar) {
        b(new 4(this));
        if (str == null) {
            bJB();
            aVar.a(3, -6, getString(com.tencent.mm.plugin.walletlock.a.g.teA), null, null);
            return;
        }
        com.tencent.mm.ae.b.a aVar2 = new com.tencent.mm.ae.b.a();
        aVar2.hmj = new bbv();
        aVar2.hmk = new bbw();
        aVar2.hmi = 688;
        aVar2.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
        com.tencent.mm.ae.b JZ = aVar2.JZ();
        bbv com_tencent_mm_protocal_c_bbv = (bbv) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bbv.wIf = new bdn().bj(str.getBytes());
        com_tencent_mm_protocal_c_bbv.wIg = new bdn().bj(e.ci(list));
        u.a(JZ, new com.tencent.mm.ae.u.a(this) {
            final /* synthetic */ GestureGuardLogicUI tgm;

            public final int a(int i, int i2, String str, com.tencent.mm.ae.b bVar, k kVar) {
                x.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                this.tgm.bJB();
                if (i == 0 && i2 == 0) {
                    d.a(((bbw) bVar.hmh.hmo).wCm);
                    GestureGuardLogicUI.bOb();
                    ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).zu(1);
                }
                i.ths.bOp();
                if (aVar != null) {
                    return aVar.a(i, i2, str, bVar, kVar);
                }
                return 0;
            }
        }, false);
    }

    private void bNZ() {
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            i.ths.kb(true);
            i.ths.kc(true);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            startActivity(intent);
        } else {
            x.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
        }
        finish();
    }

    private void bOa() {
        String stringExtra = getIntent().getStringExtra("next_action");
        if (this.mStatus == 20 || "next_action.goto_protected_page".equals(stringExtra)) {
            i.ths.bOq();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.tfY[this.mVR];
        if (motionEvent.getAction() != 2 && motionEvent.getAction() != 7) {
            return super.dispatchTouchEvent(motionEvent);
        }
        motionEvent.offsetLocation((float) (-aVar.tgt.getLeft()), (float) ((-aVar.tgt.getTop()) - getWindow().findViewById(16908290).getTop()));
        return aVar.tgt.dispatchTouchEvent(motionEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        a aVar = this.tfY[this.mVR];
        if (aVar.tgu != null) {
            PatternLockView patternLockView = aVar.tgu;
            boolean z2 = z && !this.tgc;
            patternLockView.tgK = z2;
        }
    }

    public final void a(PatternLockView patternLockView) {
        patternLockView.a(PatternLockView.b.tgY);
    }

    private void R(int i, boolean z) {
        int i2 = i - this.mVR;
        if (i2 != 0) {
            this.mVR = i;
            if (!z) {
                this.tgh.setInAnimation(null);
                this.tgh.setOutAnimation(null);
            } else if (i2 > 0) {
                this.tgh.setInAnimation(this, com.tencent.mm.plugin.walletlock.a.a.bqB);
                this.tgh.setOutAnimation(this, com.tencent.mm.plugin.walletlock.a.a.bqA);
            } else {
                this.tgh.setInAnimation(this, com.tencent.mm.plugin.walletlock.a.a.bqz);
                this.tgh.setOutAnimation(this, com.tencent.mm.plugin.walletlock.a.a.bqC);
            }
            if (i2 > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.tgh.showNext();
                }
                return;
            }
            while (i2 < 0) {
                this.tgh.showPrevious();
                i2++;
            }
        }
    }

    private void a(String str, a aVar) {
        TextView textView = this.tfY[this.mVR].tgs;
        textView.getText().toString();
        textView.setText(str);
        textView.setTextColor(this.tfX);
        textView.startAnimation(this.tfZ);
        this.tfZ.setAnimationListener(new 15(this, aVar));
    }

    private void b(OnCancelListener onCancelListener) {
        if (this.tgi == null) {
            this.tgi = com.tencent.mm.ui.base.h.a(this, getString(com.tencent.mm.plugin.walletlock.a.g.teD), false, onCancelListener);
        } else {
            this.tgi.show();
        }
    }

    private void bJB() {
        if (this.tgi != null && this.tgi.isShowing()) {
            this.tgi.dismiss();
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
