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
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;
import org.xwalk.core.R$styleable;

public class FindMContactLearmMoreUI extends MMWizardActivity {
    private String fAf;
    private e hPs = null;
    private List<String[]> hvQ = null;
    private ProgressDialog iln = null;
    private String lcJ = null;
    private String xUI = "";
    private int xUJ = 2;
    private y yma;
    private Button yml;
    private TextView ymm;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lcJ = getIntent().getStringExtra("regsetinfo_ticket");
        this.xUI = getIntent().getStringExtra("regsetinfo_NextStep");
        this.xUJ = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        initView();
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
        b.oG("R300_100_phone");
        b.b(true, ar.CB() + "," + getClass().getName() + ",RE300_600," + ar.fH("RE300_600") + ",1");
    }

    protected void onPause() {
        super.onPause();
        b.b(false, ar.CB() + "," + getClass().getName() + ",RE300_600," + ar.fH("RE300_600") + ",2");
    }

    protected final void initView() {
        setMMTitle(R.l.ehZ);
        this.yml = (Button) findViewById(R.h.cBC);
        this.ymm = (TextView) findViewById(R.h.bPo);
        this.yml.setOnClickListener(new 1(this));
        this.ymm.setOnClickListener(new 2(this));
        ar.Hg();
        c.CU().set(12323, Boolean.valueOf(true));
        ar.Hg();
        this.fAf = (String) c.CU().get(6, null);
        if (this.fAf == null || this.fAf.equals("")) {
            ar.Hg();
            this.fAf = (String) c.CU().get(4097, null);
        }
    }

    private void cqD() {
        x.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bh.cgy()});
        if (a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            n CG = ar.CG();
            e 3 = new 3(this);
            this.hPs = 3;
            CG.a(d.CTRL_INDEX, 3);
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.iln = h.a(context, getString(R.l.eYu), true, new 4(this));
            ar.Dm().a(new 5(this));
            m.k(true, false);
            com.tencent.mm.modelfriend.a.Nm();
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
        aWs();
        DU(1);
    }

    protected final int getLayoutId() {
        return R.i.dii;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactLearmMoreUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    cqD();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezO), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 6(this), new 7(this));
                    return;
                }
            default:
                return;
        }
    }
}
