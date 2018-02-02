package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.c.b.a;
import com.tencent.mm.ui.chatting.c.b.b;
import com.tencent.mm.ui.chatting.e.d;
import com.tencent.mm.ui.chatting.e.f;
import com.tencent.mm.ui.chatting.e.g;
import com.tencent.mm.ui.chatting.e.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public class MediaHistoryListUI extends MMActivity implements b {
    private RecyclerView Va;
    private String jRw;
    private TextView ldn;
    private ProgressDialog nAp;
    private a yCP;
    private p yGR;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jRw = getIntent().getStringExtra("kintent_talker");
        a aVar = null;
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 2:
                aVar = new d(this);
                break;
            case 3:
                aVar = new h(this);
                break;
            case 4:
                aVar = new f(this);
                break;
            case 5:
                aVar = new g(this);
                break;
        }
        if (aVar == null) {
            x.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
            return;
        }
        aVar.a(this);
        initView();
        this.yCP.cur();
        boolean eV = s.eV(this.jRw);
        ar.Hg();
        q hE = c.Fh().hE(this.jRw);
        if (eV) {
            if (this.yCP.getType() == 6) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(hE.Ms().size()), Integer.valueOf(1)});
            } else if (this.yCP.getType() == -1) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(hE.Ms().size()), Integer.valueOf(1)});
            } else if (this.yCP.getType() == 3) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(hE.Ms().size()), Integer.valueOf(1)});
            } else if (this.yCP.getType() == 5) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(hE.Ms().size()), Integer.valueOf(1), Integer.valueOf(1)});
            }
        } else if (this.yCP.getType() == 6) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (this.yCP.getType() == -1) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (this.yCP.getType() == 3) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (this.yCP.getType() == 5) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        }
    }

    protected final void initView() {
        this.yGR = new p();
        this.yGR.nu(false);
        this.yGR.a(this.yCP.cut());
        this.yGR.vyU = false;
        this.ldn = (TextView) findViewById(R.h.cJR);
        this.Va = (RecyclerView) findViewById(R.h.coE);
        findViewById(R.h.bYM).setBackgroundColor(-1);
        this.Va.setBackgroundColor(-1);
        this.Va.a(this.yCP.fM(this));
        this.Va.a(this.yCP.cuq());
        this.Va.a(this.yCP.Zm(this.jRw));
        this.Va.Ub = true;
        setMMTitle(this.yCP.WW());
        setBackBtn(new 1(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.yCP.onDetach();
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        if (this.mController.xJg == 2) {
            this.yGR.clearFocus();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.yGR.a(this, menu);
        com.tencent.mm.ui.tools.p pVar = this.yGR;
        String cuu = this.yCP.cuu();
        if (!(pVar.zmr == null || bh.ov(cuu))) {
            pVar.zmr.ZS(cuu);
        }
        this.mController.contentView.postDelayed(new Runnable(this) {
            final /* synthetic */ MediaHistoryListUI yGS;

            {
                this.yGS = r1;
            }

            public final void run() {
                this.yGS.yGR.clearFocus();
            }
        }, 200);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.yGR.a(this, menu);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dni;
    }

    public final void cuv() {
        dY(true);
    }

    public final void z(boolean z, int i) {
        dY(false);
        x.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (i <= 0) {
            this.ldn.setVisibility(0);
            this.Va.setVisibility(8);
            this.ldn.setText(getString(R.l.dSE));
            return;
        }
        this.ldn.setVisibility(8);
        this.Va.setVisibility(0);
        this.Va.fm().UR.notifyChanged();
    }

    public final void onFinish() {
        x.i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
        finish();
    }

    public final void bn(String str, boolean z) {
        if (z) {
            CharSequence string = getString(R.l.dSG, new Object[]{str});
            this.ldn.setVisibility(0);
            this.Va.setVisibility(8);
            TextView textView = this.ldn;
            this.ldn.getContext();
            textView.setText(com.tencent.mm.bc.b.a(string, str));
            return;
        }
        this.ldn.setVisibility(8);
        this.Va.setVisibility(0);
    }

    private void dY(boolean z) {
        x.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.nAp = r.b(this, getString(R.l.ctB), true, 0, null);
        } else if (this.nAp != null && this.nAp.isShowing()) {
            this.nAp.dismiss();
            this.nAp = null;
        }
    }
}
