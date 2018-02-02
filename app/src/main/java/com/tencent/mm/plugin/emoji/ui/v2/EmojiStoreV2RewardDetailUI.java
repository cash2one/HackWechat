package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;
import com.tencent.mm.z.ar;

public class EmojiStoreV2RewardDetailUI extends MMActivity implements OnScrollListener, e {
    private ListView Fv;
    private View Lr;
    private boolean acS = false;
    private int lAw = -1;
    private acb lCN;
    private af lFk = new 1(this);
    private String lGd;
    private String lGe;
    private ImageView lGf;
    private TextView lGg;
    private TextView lGh;
    private TextView lGi;
    private View lGj;
    private View lGk;
    private a lGl;
    private abx lGm;
    private byte[] lGn;
    private m lGo;
    private a lGp = new 2(this);
    private String lyI;
    private String lyx;

    protected final int getLayoutId() {
        return R.i.dfW;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lyx = getIntent().getStringExtra("extra_id");
        this.lyI = getIntent().getStringExtra("extra_name");
        this.lGd = getIntent().getStringExtra("extra_iconurl");
        this.lGe = getIntent().getStringExtra("name");
        initView();
        this.lCN = i.aBE().lwQ.Yb(this.lyx);
        aDu();
        o.PA().a(this.lGd, this.lGf, f.cg(this.lyx, this.lGd));
        this.lGg.setText(this.lyI);
        this.lGh.setText(this.lGe);
        if (this.lGm != null) {
            this.lGl.I(this.lGm.wkF);
            this.lGl.lGs = true;
        }
        if (this.lCN != null) {
            this.lGi.setText(getString(R.l.eaL, new Object[]{Integer.valueOf(this.lCN.wkE)}));
        }
        ar.CG().a(299, this);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(299, this);
        o.PA().bp(0);
    }

    protected final void initView() {
        setMMTitle(R.l.eaK);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2RewardDetailUI lGq;

            {
                this.lGq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lGq.finish();
                return false;
            }
        });
        this.Lr = v.fv(this.mController.xIM).inflate(R.i.dfX, null);
        this.lGf = (ImageView) this.Lr.findViewById(R.h.caZ);
        this.lGg = (TextView) this.Lr.findViewById(R.h.cDI);
        this.lGh = (TextView) this.Lr.findViewById(R.h.cba);
        this.lGi = (TextView) this.Lr.findViewById(R.h.cHW);
        this.lGj = findViewById(R.h.cIu);
        this.Fv = (ListView) findViewById(R.h.cop);
        this.lGk = v.fv(this.mController.xIM).inflate(R.i.dfK, null);
        this.lGk.setVisibility(8);
        this.Fv.addHeaderView(this.Lr);
        this.Fv.addFooterView(this.lGk);
        this.lGl = new a(this, this);
        this.Fv.setAdapter(this.lGl);
        this.Fv.setOnScrollListener(this);
    }

    private void aDu() {
        this.lGo = new m(this.lyx, this.lGn);
        ar.CG().a(this.lGo, 0);
    }

    private void eD(boolean z) {
        if (!this.acS && this.lAw != 0) {
            aDu();
            this.acS = true;
            if (z) {
                this.lFk.sendEmptyMessageDelayed(1002, 200);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        this.acS = false;
        if (this.lGk != null) {
            this.lGk.setVisibility(8);
            this.lFk.removeMessages(1002);
            this.lFk.sendEmptyMessageDelayed(1001, 200);
        }
        switch (kVar.getType()) {
            case 299:
                m mVar = (m) kVar;
                if (i == 0 || i == 4) {
                    this.lGn = mVar.lyZ;
                    if (i2 == 0) {
                        this.lAw = 0;
                        if (mVar.aBT() != null) {
                            this.lGl.I(mVar.aBT().wkF);
                            return;
                        }
                        return;
                    } else if (i2 == 2) {
                        this.lAw = 2;
                        if (mVar.aBT() != null) {
                            this.lGl.I(mVar.aBT().wkF);
                        }
                        if (!(this.lGl == null || this.Lr == null)) {
                            a aVar = this.lGl;
                            x.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[]{Integer.valueOf(aVar.luj + aVar.lFb), Integer.valueOf(this.Lr.getHeight()), Integer.valueOf(com.tencent.mm.bv.a.eB(this))});
                            if (com.tencent.mm.bv.a.eB(this) > ((aVar.luj + aVar.lFb) * this.lGl.getCount()) + this.Lr.getHeight()) {
                                z = false;
                            }
                        }
                        if (!z) {
                            eD(false);
                            return;
                        }
                        return;
                    } else if (i2 == 3) {
                        this.lAw = 1;
                        this.lGn = null;
                        this.lGl.lGs = true;
                        eD(false);
                        return;
                    } else {
                        return;
                    }
                }
                x.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", new Object[]{Integer.valueOf(i)});
                return;
            default:
                return;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.lAw == 0 || this.acS) {
            x.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
            return;
        }
        eD(true);
        x.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
        o.PA().bp(i);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
