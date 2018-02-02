package com.tencent.mm.ui.bindmobile;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.n;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m$a;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;
import org.xwalk.core.R$styleable;

public class FindMContactAlertUI extends MMWizardActivity {
    private int X = 0;
    private int Y = 0;
    private String fAf;
    private e hPs = null;
    private List<String[]> hvQ = null;
    private ProgressDialog iln = null;
    private String jwG;
    private String jwH;
    private String lcJ = null;
    private String pRQ;
    private int rne = 0;
    private String xUI = "";
    private int xUJ = 2;
    private String ylX = null;
    private String ylY = null;
    private boolean ylZ = false;
    private y yma;
    private int ymb = 0;
    private final int ymc = 200;
    private int ymd = 0;
    private int yme = 0;
    private int ymf = 0;

    static /* synthetic */ void a(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        findMContactAlertUI.ymd = i;
        findMContactAlertUI.yme = i2;
        if (findMContactAlertUI.ymf > 0 && findMContactAlertUI.rne > 0) {
            findMContactAlertUI.cqC();
        }
    }

    static /* synthetic */ void b(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        findMContactAlertUI.ymf = i;
        findMContactAlertUI.rne = i2;
        if (findMContactAlertUI.ymd > 0 && findMContactAlertUI.yme > 0) {
            findMContactAlertUI.cqC();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.chT);
        a.ift.up();
        this.lcJ = getIntent().getStringExtra("regsetinfo_ticket");
        this.xUI = getIntent().getStringExtra("regsetinfo_NextStep");
        this.xUJ = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.ylX = getIntent().getStringExtra("alert_title");
        this.ylY = getIntent().getStringExtra("alert_message");
        this.ylZ = m.NN() != m$a.SUCC;
        this.pRQ = b.Xn();
        x.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", this.xUI, Integer.valueOf(this.xUJ));
        if (!isFinishing()) {
            initView();
            cqB();
        }
    }

    public void onDestroy() {
        x.d("MicroMsg.FindMContactAlertUI", "ondestroy");
        if (this.hPs != null) {
            ar.CG().b((int) d.CTRL_INDEX, this.hPs);
            this.hPs = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.ylZ) {
            b.oG("R300_100_QQ");
            b.b(true, ar.CB() + "," + getClass().getName() + ",R300_100_QQ," + ar.fH("R300_100_QQ") + ",1");
            return;
        }
        b.oG("R300_100_phone");
        b.b(true, ar.CB() + "," + getClass().getName() + ",RE300_100," + ar.fH("RE300_100") + ",1");
    }

    protected void onPause() {
        super.onPause();
        if (this.ylZ) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R300_100_QQ," + ar.fH("R300_100_QQ") + ",2");
        } else {
            b.b(false, ar.CB() + "," + getClass().getName() + ",RE300_100," + ar.fH("RE300_100") + ",2");
        }
    }

    protected final void initView() {
        this.jwG = getString(R.l.ehL);
        this.jwH = getString(R.l.ehK);
        if (!bh.ov(this.ylX)) {
            this.jwG = this.ylX;
        }
        if (!bh.ov(this.ylY)) {
            this.jwH = this.ylY;
        }
        ar.Hg();
        this.fAf = (String) c.CU().get(6, null);
        if (this.fAf == null || this.fAf.equals("")) {
            ar.Hg();
            this.fAf = (String) c.CU().get(4097, null);
        }
    }

    private void cqB() {
        if (this.ylZ) {
            b.oI(ar.CB() + "," + getClass().getName() + ",R300_200_phone," + ar.fH("R300_200_phone") + ",1");
            h.a(this, false, getString(R.l.ehK), getString(R.l.dGO), getString(R.l.dFU), getString(R.l.dEn), new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI ymg;

                {
                    this.ymg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ar.Hg();
                    c.CU().set(12322, Boolean.valueOf(true));
                    b.oH("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", this.ymg.lcJ);
                    intent.putExtra("regsetinfo_NextStep", this.ymg.xUI);
                    intent.putExtra("regsetinfo_NextStyle", this.ymg.xUJ);
                    a.ifs.a(this.ymg, intent);
                    b.oH("R300_300_phone");
                    b.b(false, ar.CB() + "," + this.ymg.getClass().getName() + ",R300_200_phone," + ar.fH("R300_200_phone") + ",2");
                }
            }, new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI ymg;

                {
                    this.ymg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ar.Hg();
                    c.CU().set(12322, Boolean.valueOf(false));
                    b.oI(ar.CB() + "," + this.ymg.getClass().getName() + ",R300_200_phone," + ar.fH("R300_200_phone") + ",2");
                    this.ymg.bov();
                }
            });
        } else if (m.NM()) {
            CharSequence charSequence = this.jwH;
            CharSequence charSequence2 = this.jwG;
            int i = R.l.ehY;
            int i2 = R.l.ehX;
            OnClickListener anonymousClass5 = new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI ymg;

                {
                    this.ymg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ar.Hg();
                    c.CU().set(12322, Boolean.valueOf(true));
                    this.ymg.cqD();
                    dialogInterface.dismiss();
                }
            };
            OnClickListener 6 = new 6(this);
            Dialog iVar = new i(this);
            iVar.setTitle(charSequence2);
            iVar.setMessage(charSequence);
            iVar.a(i, anonymousClass5);
            iVar.b(i2, 6);
            iVar.sVn.setVisibility(0);
            iVar.setCancelable(false);
            iVar.show();
            iVar.getWindow().clearFlags(2);
            addDialog(iVar);
            iVar.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new 7(this, iVar));
            View findViewById = findViewById(R.h.background);
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new 8(this, findViewById));
        } else {
            cqD();
        }
    }

    private View j(ViewGroup viewGroup) {
        if (this.ymb >= 200) {
            return null;
        }
        this.ymb++;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Button) {
                return childAt;
            }
            if (childAt instanceof ViewGroup) {
                childAt = j((ViewGroup) childAt);
                if (childAt != null) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private void cqC() {
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = this.ymf - (getResources().getDimensionPixelSize(R.f.bvM) + com.tencent.mm.bv.a.fromDPToPix(this, 48));
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this, 20) + (((height / 2) + (this.yme / 2)) - (height - this.rne));
        if (dimensionPixelSize != this.X || fromDPToPix != this.Y) {
            this.X = dimensionPixelSize;
            this.Y = fromDPToPix;
            View findViewById = findViewById(R.h.chU);
            findViewById.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.setMargins(dimensionPixelSize - (findViewById.getMeasuredWidth() / 2), fromDPToPix, 0, 0);
            x.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", Integer.valueOf(dimensionPixelSize), Integer.valueOf(fromDPToPix), Integer.valueOf(findViewById.getMeasuredWidth()));
            findViewById.setLayoutParams(layoutParams);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.bpR));
        }
    }

    private void cqD() {
        x.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bh.cgy());
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            View findViewById = findViewById(R.h.chU);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            n CG = ar.CG();
            e 9 = new 9(this);
            this.hPs = 9;
            CG.a((int) d.CTRL_INDEX, 9);
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.iln = h.a(context, getString(R.l.eYu), true, new 10(this));
            ar.Dm().a(new 11(this));
            com.tencent.mm.platformtools.m.k(true, false);
            com.tencent.mm.modelfriend.a.Nm();
            g.pQN.h(11438, Integer.valueOf(1));
            x.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(1));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bov();
        return true;
    }

    private void bov() {
        b.oH(this.pRQ);
        aWs();
        DU(1);
    }

    protected final int getLayoutId() {
        return R.i.dij;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactAlertUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    cqD();
                    return;
                } else {
                    h.a(this, getString(R.l.ezO), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ FindMContactAlertUI ymg;

                        {
                            this.ymg = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.ymg.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new 3(this));
                    return;
                }
            default:
                return;
        }
    }
}
