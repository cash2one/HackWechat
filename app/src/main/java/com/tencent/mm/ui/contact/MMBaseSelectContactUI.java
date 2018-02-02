package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.contact.a.a$b;
import com.tencent.mm.ui.tools.p;
import java.util.ArrayList;
import java.util.List;

public abstract class MMBaseSelectContactUI extends MMActivity implements OnItemClickListener, a, b, c, VerticalScrollBar.a, l, p.b {
    public p lcZ;
    public MultiSelectContactView ooa;
    public ListView prJ;
    private View qvO;
    public int scene;
    private AlphabetScrollBar ySY;
    private o ySZ;
    public m yTa;
    private q yTb;
    private View yTc;
    private View yTd;
    private TextView yTe;
    private LabelContainerView yTf;
    private TextView yTg;
    private MMTagPanel yTh;
    private boolean yTi = true;
    private List<String> yTj = new ArrayList();

    public abstract boolean WU();

    public abstract boolean WV();

    public abstract String WW();

    public abstract o WX();

    public abstract m WY();

    static /* synthetic */ void b(MMBaseSelectContactUI mMBaseSelectContactUI) {
        mMBaseSelectContactUI.cwe();
        mMBaseSelectContactUI.yTd.setVisibility(0);
        if (!bh.ov(mMBaseSelectContactUI.cwb()) && mMBaseSelectContactUI.yTe != null) {
            mMBaseSelectContactUI.yTe.setText(f.a(mMBaseSelectContactUI.getString(h.eIE), mMBaseSelectContactUI.getString(h.eID), com.tencent.mm.plugin.fts.d.b.a.d(mMBaseSelectContactUI.cwb(), mMBaseSelectContactUI.cwb())).mQk);
        }
    }

    static /* synthetic */ void c(MMBaseSelectContactUI mMBaseSelectContactUI) {
        x.i("MicroMsg.MMBaseSelectContactUI", "setSearchStatus");
        mMBaseSelectContactUI.a(mMBaseSelectContactUI.prJ, 8);
        mMBaseSelectContactUI.prJ.setAdapter(mMBaseSelectContactUI.yTa);
        mMBaseSelectContactUI.yTa.notifyDataSetChanged();
        if (mMBaseSelectContactUI.WV() && mMBaseSelectContactUI.ySY != null) {
            mMBaseSelectContactUI.ySY.setVisibility(8);
        }
        mMBaseSelectContactUI.yTd.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
        if (g.Dh().Cy()) {
            WT();
            x.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
            initView();
            x.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
            return;
        }
        x.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
        x.cfl();
        finish();
    }

    public final n cvZ() {
        if (this.prJ.getHeaderViewsCount() > 0) {
            return (n) ((HeaderViewListAdapter) this.prJ.getAdapter()).getWrappedAdapter();
        }
        return (n) this.prJ.getAdapter();
    }

    public final ListView btG() {
        return this.prJ;
    }

    public o cwa() {
        return this.ySZ;
    }

    public void WT() {
        this.scene = getIntent().getIntExtra("scene", 0);
    }

    public void initView() {
        setMMTitle(WW());
        this.prJ = (ListView) findViewById(e.cKN);
        this.ySZ = WX();
        this.yTa = WY();
        this.qvO = findViewById(e.qfu);
        if (cwh()) {
            this.yTd = findViewById(e.cAy);
            this.yTe = (TextView) findViewById(e.cAx);
            this.yTd.setOnTouchListener(new 1(this));
            if (WU()) {
                this.lcZ = new p(true, true);
                this.lcZ.zms = this;
                a(this.lcZ);
            } else {
                this.ooa = (MultiSelectContactView) findViewById(e.qfn);
                this.ooa.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
                this.ooa.vkA = this;
                this.ooa.vkB = this;
                this.ooa.vkz = this;
                this.ooa.setVisibility(0);
                this.yTc = new View(this.mController.xIM);
                this.yTc.setLayoutParams(new LayoutParams(-1, this.ooa.getMeasuredHeight()));
                this.yTc.setVisibility(4);
                this.prJ.addHeaderView(this.yTc);
                findViewById(e.cCk).setVisibility(0);
            }
        }
        a(this.prJ, 0);
        this.prJ.setAdapter(this.ySZ);
        setBackBtn(new 2(this));
        if (this.yTa != null) {
            this.yTa.a(new 3(this));
        }
        this.prJ.setOnScrollListener(new 4(this));
        this.prJ.setOnItemClickListener(this);
        if (WV()) {
            this.ySY = (AlphabetScrollBar) findViewById(e.qfs);
            this.ySY.setVisibility(0);
            this.ySY.yhE = this;
        }
        if (aZc()) {
            this.yTf = (LabelContainerView) findViewById(e.cKM);
            this.yTg = (TextView) this.yTf.findViewById(16908310);
            this.yTg.setText(h.qfJ);
            this.yTh = (MMTagPanel) this.yTf.findViewById(e.bYk);
            this.yTh.nKq = d.gVc;
            this.yTh.nKr = com.tencent.mm.plugin.selectcontact.a.b.btv;
            this.yTf.yST = new 5(this);
            this.yTh.ydL = new 6(this);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.prJ.getHeaderViewsCount();
        if (headerViewsCount >= 0) {
            com.tencent.mm.ui.contact.a.a Gm = cvZ().Gm(headerViewsCount);
            a$b WQ = Gm.WQ();
            ActionBarActivity actionBarActivity = this.mController.xIM;
            WQ.WS();
            if (Gm.rVq) {
                headerViewsCount = Gm.mPD;
                int i2 = Gm.mPE;
                if (Gm.aNz()) {
                    headerViewsCount = 15;
                } else if (headerViewsCount == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    switch (i2) {
                        case 1:
                            headerViewsCount = 1;
                            break;
                        case 2:
                            headerViewsCount = 2;
                            break;
                        case 3:
                            headerViewsCount = 3;
                            break;
                        case 4:
                            headerViewsCount = 4;
                            break;
                        case 5:
                            headerViewsCount = 5;
                            break;
                        case 6:
                            headerViewsCount = 6;
                            break;
                        case 7:
                            headerViewsCount = 7;
                            break;
                        case 11:
                            headerViewsCount = 8;
                            break;
                        case 15:
                            headerViewsCount = 16;
                            break;
                        case 16:
                            headerViewsCount = 10;
                            break;
                        case 17:
                        case 18:
                            headerViewsCount = 9;
                            break;
                        default:
                            headerViewsCount = 0;
                            break;
                    }
                } else if (headerViewsCount == 131075) {
                    switch (i2) {
                        case 1:
                        case 5:
                            headerViewsCount = 12;
                            break;
                        case 2:
                        case 6:
                            headerViewsCount = 13;
                            break;
                        case 3:
                        case 7:
                            headerViewsCount = 14;
                            break;
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                            headerViewsCount = 11;
                            break;
                        default:
                            headerViewsCount = 0;
                            break;
                    }
                } else {
                    headerViewsCount = headerViewsCount == 65536 ? 17 : 0;
                }
                switch (Gm.mPD) {
                    case 65536:
                        i2 = 5;
                        break;
                    case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                        i2 = 2;
                        break;
                    case 131075:
                        i2 = 3;
                        break;
                    case 131076:
                        i2 = 4;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                if (Gm.yVc) {
                    i2 = 1;
                }
                if (Gm.kTK == 5) {
                    i2 = 7;
                }
                x.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[]{String.format("%s,%d,%d,%d,%d", new Object[]{Gm.fDj, Integer.valueOf(Gm.scene), Integer.valueOf(i2), Integer.valueOf(Gm.mPy), Integer.valueOf(headerViewsCount)})});
                com.tencent.mm.plugin.report.service.g.pQN.k(13234, r0);
            }
        }
        if (!cvZ().Gn(i)) {
            ja(i);
        }
    }

    public void ja(int i) {
    }

    private String cwb() {
        if (this.lcZ != null) {
            return this.lcZ.bUS();
        }
        if (this.ooa != null) {
            return this.ooa.bUS();
        }
        return "";
    }

    private void cwc() {
        boolean cxx = this.lcZ != null ? this.lcZ.cxx() : this.ooa != null ? this.ooa.hasFocus() : false;
        if (cxx && bh.ov(cwb())) {
            if (this.yTj == null || this.yTj.size() <= 0) {
                this.yTf.setVisibility(8);
                return;
            }
            this.yTf.setVisibility(0);
            this.yTh.a(null, this.yTj);
        } else if (this.yTf != null) {
            this.yTf.setVisibility(8);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.yTb != null) {
            this.yTb.dismiss();
        }
    }

    protected void onResume() {
        super.onResume();
        if (aZc() && this.yTi) {
            this.yTi = false;
            g.Dm().F(new 7(this));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.ySY != null) {
            this.ySY.yhE = null;
        }
        if (this.ySZ != null) {
            this.ySZ.finish();
        }
        if (this.yTa != null) {
            this.yTa.finish();
        }
        if (this.yTb != null) {
            this.yTb.dismiss();
        }
    }

    public int getLayoutId() {
        return com.tencent.mm.plugin.selectcontact.a.f.qfv;
    }

    public final void DO(String str) {
        x.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[]{str});
        if (aZc()) {
            cwc();
        }
        if (this.yTa == null) {
            return;
        }
        if (bh.ov(str)) {
            this.yTa.aaS();
            this.yTa.notifyDataSetChanged();
            cwe();
            return;
        }
        this.yTa.a(str, aXV(), cwd());
    }

    public final void cam() {
        if (aZc()) {
            cwc();
        }
    }

    public int[] aXV() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
    }

    public void a(ListView listView, int i) {
    }

    public void aXW() {
        aWs();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            aXW();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void xh(String str) {
        if (this.ySZ != null) {
            int Zy = this.ySZ.Zy(str);
            if (Zy == 0) {
                this.prJ.setSelection(0);
            } else if (Zy <= 0) {
                x.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[]{Integer.valueOf(Zy), str});
            } else if (WU()) {
                this.prJ.setSelection(Zy);
            } else if (this.ooa != null) {
                this.prJ.setSelectionFromTop(Zy, this.ooa.getMeasuredHeight());
            }
        }
    }

    public final boolean oK(String str) {
        return false;
    }

    public final void oL(String str) {
        x.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[]{str});
        if (aZc()) {
            if (this.lcZ != null) {
                this.lcZ.cxy();
            }
            cwc();
        }
        if (bh.ov(str)) {
            this.yTa.aaS();
            this.yTa.notifyDataSetChanged();
            cwe();
            return;
        }
        this.yTa.a(str, aXV(), cwd());
    }

    public boolean cwd() {
        return false;
    }

    public final void Xr() {
        cwe();
        if (aZc()) {
            cwc();
        }
    }

    public final void Xs() {
    }

    private void cwe() {
        x.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
        a(this.prJ, 0);
        this.prJ.setAdapter(this.ySZ);
        this.ySZ.notifyDataSetChanged();
        if (WV() && this.ySY != null) {
            this.ySY.setVisibility(0);
        }
        this.yTd.setVisibility(8);
    }

    public void oE(String str) {
    }

    public boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    public boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    public final Activity getActivity() {
        return this;
    }

    public boolean aZc() {
        return false;
    }

    public void En(String str) {
        x.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[]{str});
    }

    public final void cwf() {
        if (this.lcZ != null) {
            if (!bh.ov(this.lcZ.bUS())) {
                p pVar = this.lcZ;
                if (pVar.zmr != null) {
                    pVar.zmr.nr(true);
                }
            }
        } else if (this.ooa != null && !bh.ov(this.ooa.bUS())) {
            this.ooa.vkv.setText("");
        }
    }

    public final void cwg() {
        if (this.lcZ != null) {
            if (this.lcZ.cxx()) {
                this.lcZ.clearFocus();
            }
        } else if (this.ooa != null && this.ooa.hasFocus()) {
            this.ooa.clearFocus();
        }
    }

    public final void Xt() {
    }

    public final void Xu() {
    }

    public boolean cwh() {
        return this.yTa != null;
    }
}
