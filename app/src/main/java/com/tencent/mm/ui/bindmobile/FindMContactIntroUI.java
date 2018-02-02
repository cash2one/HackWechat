package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.n;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;
import org.xwalk.core.R$styleable;

public class FindMContactIntroUI extends MMWizardActivity {
    private String fAf;
    private e hPs = null;
    private List<String[]> hvQ = null;
    private ProgressDialog iln = null;
    private String lcJ = null;
    private String pRQ;
    private TextView pVW;
    private String xUI = "";
    private int xUJ = 2;
    private boolean ylZ = false;
    private y yma;
    private Button ymh;
    private TextView ymi;

    static /* synthetic */ void a(FindMContactIntroUI findMContactIntroUI) {
        if (findMContactIntroUI.ylZ) {
            b.oI(ar.CB() + "," + findMContactIntroUI.getClass().getName() + ",R300_200_phone," + ar.fH("R300_200_phone") + ",1");
            h.a(findMContactIntroUI, R.l.ehK, R.l.dGO, R.l.dFU, R.l.dEn, new 5(findMContactIntroUI), new 6(findMContactIntroUI));
        } else if (m.NM()) {
            b.oI(ar.CB() + "," + findMContactIntroUI.getClass().getName() + ",R300_200_phone," + ar.fH("R300_200_phone") + ",1");
            h.a(findMContactIntroUI, R.l.ehK, R.l.dGO, R.l.dFU, R.l.dEn, new 7(findMContactIntroUI), new 8(findMContactIntroUI));
        } else {
            findMContactIntroUI.cqD();
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        setMMTitle(R.l.chT);
        a.ift.up();
        this.lcJ = getIntent().getStringExtra("regsetinfo_ticket");
        this.xUI = getIntent().getStringExtra("regsetinfo_NextStep");
        this.xUJ = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        if (m.NN() != m.a.hwi) {
            z = true;
        } else {
            z = false;
        }
        this.ylZ = z;
        this.pRQ = b.Xn();
        x.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[]{this.xUI, Integer.valueOf(this.xUJ)});
    }

    public void onDestroy() {
        if (this.hPs != null) {
            ar.CG().b(d.CTRL_INDEX, this.hPs);
            this.hPs = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
        if (this.ylZ) {
            b.b(true, ar.CB() + "," + getClass().getName() + ",R300_100_QQ," + ar.fH("R300_100_QQ") + ",1");
            b.oG("R300_100_QQ");
            return;
        }
        b.b(true, ar.CB() + "," + getClass().getName() + ",R300_100_phone," + ar.fH("R300_100_phone") + ",1");
        b.oG("R300_100_phone");
    }

    protected void onPause() {
        super.onPause();
        b.oH("RE900_100");
        if (this.ylZ) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R300_100_QQ," + ar.fH("R300_100_QQ") + ",4");
        } else {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R300_100_phone," + ar.fH("R300_100_phone") + ",4");
        }
    }

    protected final void initView() {
        this.ymh = (Button) findViewById(R.h.cLV);
        this.ymi = (TextView) findViewById(R.h.chX);
        this.pVW = (TextView) findViewById(R.h.chW);
        if (this.xUI == null || !this.xUI.contains("2")) {
            this.pVW.setText(getString(R.l.ehI));
        } else {
            this.pVW.setText(getString(R.l.ehH));
        }
        ar.Hg();
        this.fAf = (String) c.CU().get(6, null);
        if (this.fAf == null || this.fAf.equals("")) {
            ar.Hg();
            this.fAf = (String) c.CU().get(4097, null);
        }
        this.ymh.setOnClickListener(new 1(this));
        this.ymi.setOnClickListener(new 4(this));
    }

    private void cqD() {
        x.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bh.cgy()});
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            n CG = ar.CG();
            e 9 = new 9(this);
            this.hPs = 9;
            CG.a(d.CTRL_INDEX, 9);
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.iln = h.a(context, getString(R.l.eYu), true, new 10(this));
            ar.Dm().a(new 11(this));
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
        return R.i.dih;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    cqD();
                    return;
                } else {
                    h.a(this, getString(R.l.ezO), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 2(this), new 3(this));
                    return;
                }
            default:
                return;
        }
    }
}
