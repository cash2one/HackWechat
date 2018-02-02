package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public abstract class FTSBaseVoiceSearchUI extends MMActivity implements b.a, c, p.a {
    String fDj;
    private p kGa;
    TextView nvA;
    ListView qbX;
    private b qbY;
    private boolean qbZ = false;
    private af qbw = new 3(this);
    private VoiceSearchLayout qcc;
    private RelativeLayout qcd;

    protected abstract b a(c cVar);

    protected abstract boolean bqf();

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.xIM;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cmW();
        setMMTitle("");
        bpY();
        this.kGa = new p();
        this.kGa.nu(true);
        this.kGa.a(this);
        this.kGa.vyU = bqf();
        this.qbX = (ListView) findViewById(R.h.cKa);
        if (avu() != null) {
            x.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView");
            this.qbX.addFooterView(avu());
        }
        this.qbY = a((c) this);
        this.qbY.qbW = this;
        this.qbX.setAdapter(this.qbY);
        this.qbX.setOnScrollListener(this.qbY);
        this.qbX.setOnItemClickListener(this.qbY);
        this.qbX.setOnTouchListener(new 1(this));
        if (bqf()) {
            this.qcc = new VoiceSearchLayout(this);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14);
            this.qcc.setLayoutParams(layoutParams);
            this.qcc.BV(b.b(this, 100.0f));
            this.qcc.lWv.findViewById(R.h.cWU).setBackgroundResource(0);
            this.qcc.setVisibility(8);
            this.kGa.o(this.qcc);
            this.qcd = (RelativeLayout) findViewById(R.h.cWZ);
            this.qcd.addView(this.qcc);
        }
        this.nvA = (TextView) findViewById(R.h.cAy);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ FTSBaseVoiceSearchUI qce;

            {
                this.qce = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qce.finish();
                return true;
            }
        });
    }

    protected void bpY() {
    }

    protected View avu() {
        return null;
    }

    public final void ass() {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onVoiceSearchStart");
        bqg();
    }

    public final void ast() {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onVoiceSearchCancel");
        bqh();
    }

    public void a(boolean z, String[] strArr, long j, int i) {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onVoiceReturn");
        bqh();
    }

    public final void Xs() {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
    }

    public final void Xr() {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
        finish();
    }

    public final void oL(String str) {
        x.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", new Object[]{str});
        if (bh.ov(str)) {
            if (!this.kGa.cxx()) {
                this.kGa.cxy();
                showVKB();
            }
            bqe();
        }
        String Be = d.Be(str);
        if (bh.ov(this.fDj) || !this.fDj.equals(Be)) {
            this.fDj = Be;
            if (bh.ov(this.fDj)) {
                this.qbw.removeMessages(1);
                this.qbZ = false;
                this.qbY.stopSearch();
                bqe();
                return;
            }
            this.qbw.removeMessages(1);
            this.qbw.sendEmptyMessageDelayed(1, 300);
            return;
        }
        x.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", new Object[]{this.fDj, Be});
    }

    public final void Xt() {
    }

    public boolean oK(String str) {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", new Object[]{str});
        aWs();
        if (this.kGa != null) {
            this.kGa.clearFocus();
        }
        return false;
    }

    protected void bpV() {
        this.qbZ = true;
        this.qbY.IT(this.fDj);
        bqb();
    }

    protected void bqg() {
        this.nvA.setVisibility(8);
        if (this.qcd != null) {
            this.qcd.setVisibility(0);
        }
        this.qbX.setVisibility(8);
    }

    protected void bqh() {
        this.nvA.setVisibility(8);
        if (this.qcd != null) {
            this.qcd.setVisibility(8);
        }
        this.qbX.setVisibility(8);
    }

    protected void bqb() {
        this.nvA.setVisibility(8);
        if (this.qcd != null) {
            this.qcd.setVisibility(8);
        }
        this.qbX.setVisibility(8);
    }

    protected void bqc() {
        this.nvA.setVisibility(0);
        this.nvA.setText(f.a(getString(R.l.eIE), getString(R.l.eID), com.tencent.mm.plugin.fts.d.b.a.d(this.fDj, this.fDj)).mQk);
        if (this.qcd != null) {
            this.qcd.setVisibility(8);
        }
        this.qbX.setVisibility(8);
    }

    protected void bqd() {
        this.nvA.setVisibility(8);
        if (this.qcd != null) {
            this.qcd.setVisibility(8);
        }
        this.qbX.setVisibility(0);
    }

    protected void bqe() {
        this.nvA.setVisibility(8);
        if (this.qcd != null) {
            this.qcd.setVisibility(8);
        }
        this.qbX.setVisibility(8);
    }

    protected void onPause() {
        super.onPause();
        this.kGa.cancel();
        this.kGa.clearFocus();
    }

    protected void onDestroy() {
        this.qbw.removeMessages(1);
        this.qbY.finish();
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.kGa.a(this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.kGa.a(this, menu);
        return true;
    }

    public void H(int i, boolean z) {
        x.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (z) {
            bqj();
            if (i > 0) {
                bqd();
            } else {
                bqc();
            }
        } else if (i > 0) {
            bqd();
            bqi();
        } else {
            bqb();
            bqj();
        }
        if (this.qbZ) {
            this.qbZ = false;
            this.qbX.setSelection(0);
        }
    }

    protected void bqi() {
    }

    protected void bqj() {
    }

    public final void Xu() {
    }
}
