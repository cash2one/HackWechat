package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.un;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMScrollGridView;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class FacingCreateChatRoomAllInOneUI extends MMActivity implements e {
    private com.tencent.mm.modelgeo.a.a gyF = new 16(this);
    private boolean kAd = false;
    private String lcJ;
    private ProgressDialog ltM;
    private af mHandler = new af(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

        {
            this.pmn = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 10001:
                    if (this.pmn.plQ != null) {
                        this.pmn.plQ.H(this.pmn.plN);
                        return;
                    }
                    return;
                case 10002:
                    FacingCreateChatRoomAllInOneUI.d(this.pmn);
                    return;
                default:
                    return;
            }
        }
    };
    private boolean plA;
    private boolean plB;
    private boolean plC = false;
    private Location plD;
    private String plE;
    private MMPwdInputView plF;
    private View plG;
    private ProgressBar plH;
    private TextView plI;
    private MMKeyBoardView plJ;
    private TextView plK;
    private boolean plL = false;
    private boolean plM = false;
    private LinkedList<un> plN = new LinkedList();
    private HashMap<String, un> plO = new HashMap();
    private LinkedList<un> plP = new LinkedList();
    private a plQ;
    private View plR;
    private TextView plS;
    private MMScrollGridView plT;
    private View plU;
    private View plV;
    private Button plW;
    private MMCallBackScrollView plX;
    private TextView plY;
    private boolean plZ = false;
    private c plx;
    private boolean ply = false;
    private boolean plz;
    private ag pma = new ag();
    private ak pmb = new ak(new 1(this), false);
    private com.tencent.mm.plugin.pwdgroup.a.a pmc;
    private com.tencent.mm.plugin.pwdgroup.a.a pmd;
    private int pme;
    private Animation pmf;
    private AnimationSet pmg;
    private Animation pmh;
    public OnMenuItemClickListener pmi = new 12(this);
    public com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a pmj = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

        {
            this.pmn = r1;
        }

        public final void h(boolean z, String str) {
            x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", new Object[]{Boolean.valueOf(z), str});
            this.pmn.plE = str;
            if (z) {
                this.pmn.plz = true;
                FacingCreateChatRoomAllInOneUI.e(this.pmn);
            }
        }
    };
    private OnClickListener pmk = new 14(this);
    public com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a pml = new 15(this);
    private ak pmm = new ak(new 17(this), false);

    private enum a {
        ;

        public static int[] bjT() {
            return (int[]) pmv.clone();
        }

        static {
            pmr = 1;
            pms = 2;
            pmt = 3;
            pmu = 4;
            pmv = new int[]{pmr, pms, pmt, pmu};
        }
    }

    static /* synthetic */ void a(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        if (facingCreateChatRoomAllInOneUI.kAd || facingCreateChatRoomAllInOneUI.plD == null) {
            x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cancel refresh chat room member.");
            return;
        }
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryDoSearchScene]-----------");
        facingCreateChatRoomAllInOneUI.pmc = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.plE, facingCreateChatRoomAllInOneUI.lcJ, facingCreateChatRoomAllInOneUI.plD.hxF, facingCreateChatRoomAllInOneUI.plD.hxG, facingCreateChatRoomAllInOneUI.plD.accuracy, facingCreateChatRoomAllInOneUI.plD.fBe, facingCreateChatRoomAllInOneUI.plD.mac, facingCreateChatRoomAllInOneUI.plD.fBg);
        ar.CG().a(facingCreateChatRoomAllInOneUI.pmc, 0);
    }

    static /* synthetic */ void d(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        facingCreateChatRoomAllInOneUI.getString(R.l.dGO);
        facingCreateChatRoomAllInOneUI.ltM = h.a((Context) facingCreateChatRoomAllInOneUI, facingCreateChatRoomAllInOneUI.getString(R.l.dHc), true, new 5(facingCreateChatRoomAllInOneUI));
        facingCreateChatRoomAllInOneUI.bjQ();
        ar.CG().a(new com.tencent.mm.plugin.pwdgroup.a.a(1, facingCreateChatRoomAllInOneUI.plE, facingCreateChatRoomAllInOneUI.lcJ, facingCreateChatRoomAllInOneUI.plD.hxF, facingCreateChatRoomAllInOneUI.plD.hxG, facingCreateChatRoomAllInOneUI.plD.accuracy, facingCreateChatRoomAllInOneUI.plD.fBe, facingCreateChatRoomAllInOneUI.plD.mac, facingCreateChatRoomAllInOneUI.plD.fBg), 0);
    }

    static /* synthetic */ void e(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryGetChatRoomUser]");
        if (facingCreateChatRoomAllInOneUI.pmm != null) {
            facingCreateChatRoomAllInOneUI.pmm.TG();
        }
        if (facingCreateChatRoomAllInOneUI.plA) {
            if (facingCreateChatRoomAllInOneUI.plz) {
                facingCreateChatRoomAllInOneUI.uV(a.pms);
            }
            if (facingCreateChatRoomAllInOneUI.plA && facingCreateChatRoomAllInOneUI.plz && !facingCreateChatRoomAllInOneUI.plB) {
                x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "do tryGetChatRoomUser");
                facingCreateChatRoomAllInOneUI.plB = true;
                facingCreateChatRoomAllInOneUI.plz = false;
                facingCreateChatRoomAllInOneUI.pmd = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.plE, "", facingCreateChatRoomAllInOneUI.plD.hxF, facingCreateChatRoomAllInOneUI.plD.hxG, facingCreateChatRoomAllInOneUI.plD.accuracy, facingCreateChatRoomAllInOneUI.plD.fBe, facingCreateChatRoomAllInOneUI.plD.mac, facingCreateChatRoomAllInOneUI.plD.fBg);
                ar.CG().a(facingCreateChatRoomAllInOneUI.pmd, 0);
                return;
            }
            return;
        }
        x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "tryGetChatRoomUser location is no ready.");
        facingCreateChatRoomAllInOneUI.uV(a.pms);
        if (facingCreateChatRoomAllInOneUI.pmm != null) {
            facingCreateChatRoomAllInOneUI.pmm.J(15000, 15000);
        }
    }

    protected final int getLayoutId() {
        return R.i.dhp;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
            bjO();
        }
    }

    private void bjO() {
        this.plx = c.OP();
        this.plx.a(this.gyF, true);
        ar.CG().a(653, this);
        initView();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    bjO();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

                        {
                            this.pmn = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.pmn.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            this.pmn.finish();
                        }
                    }, new 2(this));
                    return;
                }
            default:
                return;
        }
    }

    protected void onResume() {
        if (this.plx != null) {
            this.plx.a(this.gyF, true);
        }
        if (this.plZ) {
            bjP();
        }
        super.onResume();
    }

    protected void onPause() {
        if (this.plx != null) {
            this.plx.c(this.gyF);
        }
        if (this.plZ) {
            bjQ();
        }
        super.onPause();
    }

    protected void onDestroy() {
        ar.CG().b(653, this);
        if (this.plx != null) {
            this.plx.c(this.gyF);
        }
        if (!this.plM) {
            ar.CG().cancel(653);
            if (this.plD != null) {
                this.pmd = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.plE, "", this.plD.hxF, this.plD.hxG, this.plD.accuracy, this.plD.fBe, this.plD.mac, this.plD.fBg);
                ar.CG().a(this.pmd, 0);
            }
        }
        if (this.plZ) {
            bjQ();
        }
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        setMMTitle(R.l.ehw);
        setBackBtn(this.pmi);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.g.bEQ));
        }
        this.plG = findViewById(R.h.cgc);
        this.plH = (ProgressBar) findViewById(R.h.cgb);
        this.plI = (TextView) findViewById(R.h.cgd);
        this.plJ = (MMKeyBoardView) findViewById(R.h.cga);
        this.plK = (TextView) findViewById(R.h.cfZ);
        this.plF = (MMPwdInputView) findViewById(R.h.cfX);
        this.plF.pnk = this.pmj;
        this.plF.requestFocus();
        this.plJ.pml = this.pml;
        uV(a.pmr);
        this.plR = findViewById(R.h.cfQ);
        this.plS = (TextView) findViewById(R.h.cfS);
        this.plT = (MMScrollGridView) findViewById(R.h.cfR);
        this.plT.setVisibility(4);
        this.plW = (Button) findViewById(R.h.cfT);
        this.plW.setOnClickListener(this.pmk);
        this.plU = findViewById(R.h.cfU);
        this.plV = findViewById(R.h.cfV);
        this.plS.setText(R.l.eev);
        this.plX = (MMCallBackScrollView) findViewById(R.h.cge);
        this.plY = (TextView) findViewById(R.h.cfY);
        this.plX.pmB = new 3(this);
        this.plQ = new a(this);
        this.plT.setAdapter(this.plQ);
        this.plQ.H(this.plN);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 653:
                com.tencent.mm.plugin.pwdgroup.a.a aVar = (com.tencent.mm.plugin.pwdgroup.a.a) kVar;
                int i3 = aVar.plw;
                if (i3 == 0) {
                    this.plB = false;
                    if (this.plZ) {
                        if (this.pmb != null) {
                            this.pmb.J(3000, 3000);
                        }
                        if (i == 0 && i2 == 0) {
                            final LinkedList linkedList = aVar.bjN().vGF;
                            this.pma.F(new Runnable(this) {
                                final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

                                public final void run() {
                                    int size;
                                    int i;
                                    un unVar;
                                    if (this.pmn.plP != null) {
                                        this.pmn.plP.clear();
                                    }
                                    if (this.pmn.plO != null) {
                                        this.pmn.plO.clear();
                                    }
                                    if (linkedList != null && linkedList.size() > 0) {
                                        size = linkedList.size();
                                        for (i = 0; i < size; i++) {
                                            unVar = (un) linkedList.get(i);
                                            if (!bh.ov(unVar.wcv)) {
                                                this.pmn.plO.put(unVar.wcv, unVar);
                                            }
                                        }
                                    }
                                    size = this.pmn.plN.size();
                                    for (i = 0; i < size; i++) {
                                        unVar = (un) this.pmn.plN.get(i);
                                        if (this.pmn.plO.containsKey(unVar.wcv)) {
                                            this.pmn.plO.remove(unVar.wcv);
                                        } else {
                                            x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[]{unVar.wcv});
                                        }
                                    }
                                    if (this.pmn.plO != null && this.pmn.plO.size() > 0) {
                                        for (Entry value : this.pmn.plO.entrySet()) {
                                            this.pmn.plP.add((un) value.getValue());
                                            x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[]{unVar.wcv});
                                        }
                                    }
                                    this.pmn.plN.addAll(this.pmn.plP);
                                    this.pmn.mHandler.sendEmptyMessage(10001);
                                }
                            });
                            this.lcJ = aVar.bjN().vZK;
                            return;
                        }
                        return;
                    } else if (i == 0 && i2 == 0) {
                        uV(a.pmr);
                        this.pme = this.plK.getHeight();
                        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[]{Integer.valueOf(this.pme)});
                        this.pmf = AnimationUtils.loadAnimation(this, R.a.bpY);
                        this.pmh = AnimationUtils.loadAnimation(this, R.a.bpW);
                        this.pmg = new AnimationSet(true);
                        this.pmg.addAnimation(AnimationUtils.loadAnimation(this, R.a.bqs));
                        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-this.pme));
                        translateAnimation.setDuration(300);
                        this.pmg.addAnimation(translateAnimation);
                        this.pmf.setDuration(200);
                        this.pmg.setDuration(300);
                        this.pmh.setDuration(300);
                        this.pmf.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.pmg.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.pmh.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.pmg.setFillAfter(true);
                        translateAnimation.setFillAfter(true);
                        this.pmg.setAnimationListener(new 4(this));
                        this.plF.setVisibility(4);
                        this.plF.setAnimation(translateAnimation);
                        this.plJ.startAnimation(this.pmf);
                        this.plG.startAnimation(this.pmf);
                        this.plK.startAnimation(this.pmf);
                        this.plU.startAnimation(this.pmh);
                        this.plR.startAnimation(this.pmg);
                        this.plU.setVisibility(4);
                        this.plJ.setVisibility(8);
                        this.plK.setVisibility(8);
                        this.plZ = true;
                        bjP();
                        return;
                    } else if (i2 == -431) {
                        this.ply = true;
                        uV(a.pmt);
                        return;
                    } else {
                        this.ply = true;
                        uV(a.pmu);
                        return;
                    }
                } else if (i3 == 3) {
                    if (i != 0 || i2 != 0) {
                        if (i2 == -431) {
                            uV(a.pmt);
                            this.ply = true;
                            return;
                        }
                        uV(a.pmu);
                        return;
                    }
                    return;
                } else if (i3 != 1) {
                    aUZ();
                    return;
                } else if (i == 0 && i2 == 0) {
                    aUZ();
                    x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[]{aVar.bjN().vYJ});
                    this.plM = true;
                    finish();
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", r0);
                    com.tencent.mm.plugin.pwdgroup.a.ifs.e(intent, (Context) this);
                    return;
                } else if (i2 == -432 && !this.plL) {
                    this.plL = true;
                    this.mHandler.sendEmptyMessageDelayed(10002, 3000);
                    return;
                } else if (i2 == -23) {
                    aUZ();
                    yE(getString(R.l.eew));
                    if (this.pmb != null) {
                        this.pmb.J(3000, 3000);
                        return;
                    }
                    return;
                } else {
                    aUZ();
                    com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                    if (eA != null) {
                        eA.a(this.mController.xIM, null, null);
                    } else {
                        yE(getString(R.l.eBG));
                    }
                    if (this.pmb != null) {
                        this.pmb.J(3000, 3000);
                        return;
                    }
                    return;
                }
            default:
                x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
                return;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void hl(boolean z) {
        if (this.plJ != null) {
            this.plJ.hm(z);
        }
    }

    private void uV(int i) {
        if (this.plI != null) {
            switch (10.pmq[i - 1]) {
                case 1:
                    hl(true);
                    this.ply = false;
                    this.plC = false;
                    this.plH.setVisibility(8);
                    this.plI.setVisibility(8);
                    return;
                case 2:
                    hl(false);
                    this.plI.setText(R.l.eBH);
                    this.plH.setVisibility(0);
                    this.plI.setVisibility(8);
                    return;
                case 3:
                    hl(true);
                    this.plH.setVisibility(8);
                    this.plI.setVisibility(0);
                    this.plI.setText(R.l.eBF);
                    bjR();
                    return;
                case 4:
                    hl(true);
                    this.plH.setVisibility(8);
                    this.plI.setVisibility(0);
                    this.plI.setText(R.l.eBG);
                    bjR();
                    return;
                default:
                    x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
                    return;
            }
        }
    }

    private void aUZ() {
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
    }

    private void yE(String str) {
        h.a((Context) this, str, "", getString(R.l.dFU), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

            {
                this.pmn = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void bjP() {
        this.kAd = false;
        if (this.pmb != null) {
            this.pmb.J(0, 0);
        }
    }

    private void bjQ() {
        this.kAd = true;
        if (this.pmb != null) {
            this.pmb.TG();
        }
        ar.CG().c(this.pmc);
    }

    private void bjR() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.a.bpP);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.a.bpO);
        loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.pmn.plF.Tt();
                this.pmn.plF.startAnimation(loadAnimation2);
            }
        });
        loadAnimation2.setAnimationListener(new 9(this));
        if (this.plF != null) {
            this.plF.startAnimation(loadAnimation);
        }
        if (this.plJ != null) {
            this.plJ.hm(false);
        }
    }
}
