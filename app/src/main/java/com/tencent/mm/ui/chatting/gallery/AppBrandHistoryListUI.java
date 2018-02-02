package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.c.b.a;
import com.tencent.mm.ui.chatting.c.b.b;
import com.tencent.mm.ui.chatting.e.c;
import com.tencent.mm.z.s;

public class AppBrandHistoryListUI extends MMActivity implements b {
    private RecyclerView Va;
    private String jRw;
    private TextView ldn;
    private ProgressDialog nAp;
    private a yCP;

    public final /* bridge */ /* synthetic */ void a(c cVar) {
        this.yCP = (a) cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jRw = getIntent().getStringExtra("Chat_User");
        new com.tencent.mm.ui.chatting.e.a(this).a(this);
        initView();
        this.yCP.cur();
        if (s.eV(this.jRw)) {
            g.pQN.h(14562, this.jRw, Integer.valueOf(0));
            return;
        }
        g.pQN.h(14562, this.jRw, Integer.valueOf(1));
    }

    protected final void initView() {
        setMMTitle(getString(R.l.dPT));
        this.ldn = (TextView) findViewById(R.h.cJR);
        this.Va = (RecyclerView) findViewById(R.h.coE);
        this.Va.setBackgroundColor(-1);
        this.Va.a(this.yCP.fM(this));
        this.Va.a(this.yCP.Zm(this.jRw));
        this.Va.Ub = true;
        setBackBtn(new 1(this));
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dax;
    }

    public final void cuv() {
        dY(true);
    }

    public final void z(boolean z, int i) {
        dY(false);
        x.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i));
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
        x.i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
        finish();
    }

    public final void bn(String str, boolean z) {
    }

    private void dY(boolean z) {
        x.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.nAp = r.b(this, getString(R.l.ctB), true, 0, null);
        } else if (this.nAp != null && this.nAp.isShowing()) {
            this.nAp.dismiss();
            this.nAp = null;
        }
    }
}
