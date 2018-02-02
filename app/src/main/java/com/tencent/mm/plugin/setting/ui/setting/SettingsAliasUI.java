package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.modelsimple.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

public class SettingsAliasUI extends MMActivity implements e {
    private String gfN;
    private ImageView iip;
    private ProgressDialog iln = null;
    private TextView kBH;
    private EditText qiY;
    private c qiZ;
    private e qid = null;
    private boolean qja = false;
    private TextView qjb;
    private TextView qjc;

    static /* synthetic */ void e(SettingsAliasUI settingsAliasUI) {
        if (settingsAliasUI.gfN.equals(q.FS())) {
            h.h(settingsAliasUI.mController.xIM, R.l.evz, R.l.evx);
        } else if (bh.Vu(settingsAliasUI.gfN)) {
            Context context = settingsAliasUI.mController.xIM;
            settingsAliasUI.getString(R.l.evx);
            settingsAliasUI.iln = h.a(context, settingsAliasUI.getString(R.l.evw), true, new 4(settingsAliasUI));
            if (settingsAliasUI.qiZ != null) {
                ar.CG().c(settingsAliasUI.qiZ);
            }
            settingsAliasUI.qiZ = new c(settingsAliasUI.gfN);
            ar.CG().a(settingsAliasUI.qiZ, 0);
        } else {
            h.h(settingsAliasUI.mController.xIM, R.l.eSG, R.l.eCX);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qja = getIntent().getBooleanExtra("KFromSetAliasTips", false);
        initView();
        ar.CG().a(177, this);
    }

    protected final int getLayoutId() {
        return R.i.drX;
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        if (this.qiZ != null) {
            ar.CG().c(this.qiZ);
        }
        ar.CG().b(177, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.evx);
        this.iip = (ImageView) findViewById(R.h.bLL);
        this.kBH = (TextView) findViewById(R.h.cAn);
        this.qjb = (TextView) findViewById(R.h.cUq);
        this.qjc = (TextView) findViewById(R.h.cxc);
        this.qiY = (EditText) findViewById(R.h.cHv);
        String FS = q.FS();
        if (!x.WB(FS)) {
            this.qiY.setText(q.FS());
            this.qjb.setText(getString(R.l.dDJ, new Object[]{FS}));
        }
        this.qiY.setSelection(this.qiY.getText().length());
        this.qiY.setFocusable(true);
        this.qiY.setFocusableInTouchMode(true);
        this.qiY.addTextChangedListener(new 1(this));
        this.kBH.setText(i.b(this, bh.ou(q.FU()), this.kBH.getTextSize()));
        b.a(this.iip, FS);
        setBackBtn(new 2(this));
        a(0, getString(R.l.dGx), new 3(this), p.b.xJz);
        enableOptionMenu(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 1;
        if (i == 0 && i2 == 0) {
            if (this.qja) {
                g.pQN.k(10358, "1");
            }
            aWs();
            ar.Hg();
            com.tencent.mm.z.c.CU().set(42, this.gfN);
            n CG = ar.CG();
            e 5 = new 5(this);
            this.qid = 5;
            CG.a(255, 5);
            ar.CG().a(new com.tencent.mm.modelsimple.x(1), 0);
            return;
        }
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (!a.ift.a(this.mController.xIM, i, i2, str)) {
            switch (i) {
                case 4:
                    if (i2 == -7 || i2 == -10) {
                        h.h(this.mController.xIM, R.l.eCV, R.l.evB);
                        break;
                    }
                default:
                    i3 = 0;
                    break;
            }
        }
        if (i3 == 0) {
        }
    }
}
