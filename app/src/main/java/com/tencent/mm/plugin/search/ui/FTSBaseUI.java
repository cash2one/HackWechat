package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.search.ui.b.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.FTSEditTextView$a;
import java.util.List;

public abstract class FTSBaseUI extends MMActivity implements a, c, FTSEditTextView$a, com.tencent.mm.ui.fts.widget.a.a {
    String fDj;
    private TextView nvA;
    ListView qbX;
    private b qbY;
    private boolean qbZ = false;
    private af qbw = new 3(this);
    com.tencent.mm.ui.fts.widget.a qca;

    protected abstract b a(c cVar);

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.xIM;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cmW();
        setMMTitle("");
        bpY();
        this.qca = new com.tencent.mm.ui.fts.widget.a(this);
        this.qca.zeu = this;
        this.qca.zet.LW(getHint());
        this.qca.zet.zdX = this;
        this.qca.zet.zdU = false;
        getSupportActionBar().setCustomView(this.qca);
        this.qbX = (ListView) findViewById(R.h.cKa);
        this.qbY = a((c) this);
        this.qbY.qbW = this;
        this.qbX.setAdapter(this.qbY);
        this.qbX.setOnScrollListener(this.qbY);
        this.qbX.setOnItemClickListener(this.qbY);
        this.qbX.setOnTouchListener(new 1(this));
        this.nvA = (TextView) findViewById(R.h.cAy);
        setBackBtn(new 2(this));
    }

    protected void bpY() {
    }

    public String getHint() {
        return getString(R.l.dGz);
    }

    public void a(b bVar) {
    }

    public final void bpZ() {
        finish();
    }

    public final void bqa() {
    }

    protected final void l(String str, List<com.tencent.mm.ui.fts.widget.a.b> list) {
        this.fDj = str;
        this.qca.zet.t(str, list);
    }

    public void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, FTSEditTextView.b bVar) {
        if (bVar == FTSEditTextView.b.zea) {
            String Be = d.Be(str);
            if (bh.ov(this.fDj) || !this.fDj.equals(Be)) {
                IU(Be);
                return;
            }
            x.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[]{this.fDj, Be});
        }
    }

    protected void IU(String str) {
        if (bh.ov(str)) {
            stopSearch();
            return;
        }
        this.fDj = str;
        this.qbw.removeMessages(1);
        this.qbw.sendEmptyMessageDelayed(1, 300);
    }

    protected void stopSearch() {
        this.fDj = "";
        this.qbw.removeMessages(1);
        this.qbZ = false;
        this.qbY.stopSearch();
        this.qca.zet.LW(getHint());
        bqe();
    }

    public final void hL(boolean z) {
    }

    public void cs(View view) {
        stopSearch();
        this.qca.zet.cxa();
        showVKB();
    }

    public boolean akL() {
        aWs();
        this.qca.zet.yig.clearFocus();
        return false;
    }

    protected void onDestroy() {
        this.qbw.removeMessages(1);
        this.qbY.finish();
        super.onDestroy();
    }

    protected void bpV() {
        this.qbZ = true;
        this.qbY.IT(this.fDj);
        bqb();
    }

    protected void bqb() {
        this.nvA.setVisibility(8);
        this.qbX.setVisibility(8);
    }

    protected void bqc() {
        this.nvA.setVisibility(0);
        this.nvA.setText(f.a(getString(R.l.eIE), getString(R.l.eID), com.tencent.mm.plugin.fts.d.b.a.d(this.fDj, this.fDj)).mQk);
        this.qbX.setVisibility(8);
    }

    protected void bqd() {
        this.nvA.setVisibility(8);
        this.qbX.setVisibility(0);
    }

    protected void bqe() {
        this.nvA.setVisibility(8);
        this.qbX.setVisibility(8);
    }

    public final void H(int i, boolean z) {
        x.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (z) {
            if (i > 0) {
                bqd();
            } else {
                bqc();
            }
        } else if (i > 0) {
            bqd();
        } else {
            bqb();
        }
        if (this.qbZ) {
            this.qbZ = false;
            this.qbX.setSelection(0);
        }
    }
}
