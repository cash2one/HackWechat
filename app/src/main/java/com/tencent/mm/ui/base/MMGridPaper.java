package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import junit.framework.Assert;

public final class MMGridPaper extends LinearLayout {
    protected View Lr;
    protected MMDotView kba;
    protected int leO = 0;
    protected int mNumColumns = 0;
    protected af pFW = new af(Looper.getMainLooper());
    protected int xXL = 10;
    protected int xXM = 10;
    protected MMFlipper yaH;
    protected l yaI;
    protected int yaJ;
    protected int yaK;
    protected int yaL = 0;
    protected int yaM = 0;
    protected int yaN = 3;
    protected int yaO = 0;
    protected int yaP = (this.yaN - 1);
    protected int yaQ = 0;
    protected boolean yaR = false;
    protected int yaS = 9;
    protected int yaT = -1;
    protected int yaU = -1;
    protected int yaV = 96;
    protected int yaW = 96;
    protected boolean yaX = false;
    protected boolean yaY = false;
    protected int yaZ = -1;
    final b yak = new 5(this);
    final a yal = new 4(this);
    protected int yba = -1;
    protected int ybb = 0;
    protected int ybc = -1;
    protected int ybd = -1;
    protected boolean ybe = false;
    protected int ybf = 0;
    protected int ybg = 0;

    static /* synthetic */ void a(MMGridPaper mMGridPaper, int i) {
        mMGridPaper.yaO += i;
        if (mMGridPaper.yaO < 0) {
            mMGridPaper.yaO = 0;
        } else if (mMGridPaper.yaO > mMGridPaper.yaQ - mMGridPaper.yaN) {
            mMGridPaper.yaO = mMGridPaper.yaQ - mMGridPaper.yaN;
        }
        mMGridPaper.yaP = (mMGridPaper.yaO + mMGridPaper.yaN) - 1;
    }

    public MMGridPaper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(getContext(), h.gXy, this);
        this.ybb = cbf();
    }

    public final void cpb() {
        this.yaV = 70;
    }

    public final void cpc() {
        this.yaW = 70;
    }

    public final void cpd() {
        this.ybd = 3;
    }

    public final void EM(int i) {
        this.ybc = i;
    }

    public final void cpe() {
        this.yaY = true;
    }

    public final void cpf() {
        this.yba = 3;
        this.yaZ = 3;
    }

    public final void cpg() {
        this.xXL = 8;
        this.xXM = 15;
    }

    public final void cph() {
        this.Lr = null;
        ViewGroup viewGroup = (ViewGroup) findViewById(g.gVA);
        viewGroup.removeAllViews();
        if (this.Lr != null) {
            viewGroup.addView(this.Lr);
        }
    }

    public final void a(l lVar) {
        boolean z = true;
        this.yaI = lVar;
        String str = "MicroMsg.MMGridPaper";
        String str2 = "setGridPaperAdapter:adapter is null[%B]";
        Object[] objArr = new Object[1];
        if (lVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (this.yaI != null) {
            this.yaI.ybk = new l.a(this) {
                final /* synthetic */ MMGridPaper ybh;

                {
                    this.ybh = r1;
                }

                public final void cpl() {
                    this.ybh.refresh();
                }
            };
        }
        cbg();
    }

    public final void refresh() {
        this.yaL = (this.yaM * this.mNumColumns) * this.leO;
        x.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[]{Integer.valueOf(this.yaM), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.leO), Integer.valueOf(this.yaL)});
        cbg();
    }

    private int cbf() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    private void cpi() {
        View findViewById;
        LayoutParams layoutParams;
        int fromDPToPix;
        if (-1 != this.yaT && cbf() == 2) {
            findViewById = findViewById(g.gVx);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(getContext(), this.yaT);
            if (fromDPToPix != layoutParams.height) {
                x.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[]{Integer.valueOf(this.yaT)});
                layoutParams.height = fromDPToPix;
                findViewById.setLayoutParams(layoutParams);
                this.pFW.post(new 2(this));
            }
        } else if (-1 != this.yaU && cbf() == 1) {
            findViewById = findViewById(g.gVx);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(getContext(), this.yaU);
            if (fromDPToPix != layoutParams.height) {
                x.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[]{Integer.valueOf(this.yaU)});
                layoutParams.height = fromDPToPix;
                findViewById.setLayoutParams(layoutParams);
                this.pFW.post(new 3(this));
            }
        }
    }

    private void cbg() {
        x.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
        if (this.kba == null) {
            this.kba = (MMDotView) findViewById(g.gVy);
            MMDotView mMDotView = this.kba;
            x.d("MicroMsg.MMDotView", "setMaxCount:%d", new Object[]{Integer.valueOf(this.yaS)});
            mMDotView.gBI = r1;
        }
        if (this.yaH == null) {
            this.yaH = (MMFlipper) findViewById(g.gVz);
            this.yaH.yal = this.yal;
            this.yaH.yak = this.yak;
        }
        cpi();
        cpj();
    }

    private void cpj() {
        x.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[]{Integer.valueOf(this.yaJ), Integer.valueOf(this.yaK)});
        if (this.yaJ == 0 || this.yaK == 0) {
            x.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
            return;
        }
        boolean z;
        int min;
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(getContext(), this.yaV);
        int fromDPToPix2 = com.tencent.mm.bv.a.fromDPToPix(getContext(), this.yaW);
        fromDPToPix = Math.max(this.yaJ / fromDPToPix, 1);
        fromDPToPix2 = Math.max(this.yaK / fromDPToPix2, 1);
        if (!(fromDPToPix == this.mNumColumns && fromDPToPix2 == this.leO)) {
            this.yaR = true;
        }
        this.mNumColumns = fromDPToPix;
        if (this.ybc != -1) {
            this.mNumColumns = Math.min(this.mNumColumns, this.ybc);
        }
        this.leO = fromDPToPix2;
        if (this.ybd != -1) {
            this.leO = Math.min(this.leO, this.ybd);
        }
        int i = this.mNumColumns * this.leO;
        this.yaQ = 0;
        fromDPToPix2 = (this.yaI == null ? 0 : this.yaI.getCount()) + 0;
        x.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[]{Integer.valueOf(fromDPToPix2), Boolean.valueOf(this.yaY)});
        if (fromDPToPix2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.yaY) {
            fromDPToPix = eP(fromDPToPix2, this.mNumColumns);
            switch (cbf()) {
                case 1:
                    min = ((this.yaW + 10) * Math.min(fromDPToPix, this.yaZ)) + 8;
                    x.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[]{Integer.valueOf(cbf()), Integer.valueOf(Math.min(fromDPToPix, this.yaZ)), Integer.valueOf(min), Integer.valueOf(this.yaU), Boolean.valueOf(this.yaX)});
                    if (this.yaU == min) {
                        z = true;
                        break;
                    }
                    this.yaU = min;
                    z = false;
                    break;
                case 2:
                    min = ((this.yaW + 10) * Math.min(fromDPToPix, this.yba)) + 8;
                    x.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[]{Integer.valueOf(cbf()), Integer.valueOf(Math.min(fromDPToPix, this.yba)), Integer.valueOf(min), Integer.valueOf(this.yaT), Boolean.valueOf(this.yaX)});
                    if (this.yaT == min) {
                        z = true;
                        break;
                    }
                    this.yaT = min;
                    z = false;
                    break;
            }
        }
        z = true;
        if (z) {
            this.yaQ = eP(fromDPToPix2, i);
            min = this.yaQ - 1;
            int i2 = this.yaL;
            if (i2 == 0 || i <= 0) {
                x.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                fromDPToPix = 0;
            } else {
                fromDPToPix2 = i2;
                fromDPToPix = 0;
                while (fromDPToPix2 >= i) {
                    fromDPToPix2 -= i;
                    fromDPToPix++;
                }
                x.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(fromDPToPix)});
            }
            this.yaM = Math.min(min, fromDPToPix);
            this.yaN = Math.min(3, this.yaQ);
            this.yaO = Math.min(this.yaQ - this.yaN, Math.max(0, this.yaM - (this.yaN >> 1)));
            this.yaP = (this.yaO + this.yaN) - 1;
            x.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[]{Integer.valueOf(this.yaV), Integer.valueOf(this.yaW), Integer.valueOf(this.leO), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.yaN), Integer.valueOf(this.yaQ), Integer.valueOf(this.yaM), Integer.valueOf(this.yaO), Integer.valueOf(this.yaP)});
            MMGridPaperGridView mMGridPaperGridView;
            if (this.yaH.getChildCount() != this.yaN || this.yaR) {
                x.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[]{Boolean.valueOf(this.yaR)});
                this.yaR = false;
                this.yaH.removeAllViews();
                for (int i3 = this.yaO; i3 <= this.yaP; i3++) {
                    mMGridPaperGridView = (MMGridPaperGridView) inflate(getContext(), h.gXw, null);
                    mMGridPaperGridView.a(i3, this.leO, this.mNumColumns, this.yaI);
                    mMGridPaperGridView.setHorizontalSpacing(com.tencent.mm.bv.a.fromDPToPix(getContext(), this.xXL));
                    mMGridPaperGridView.setVerticalSpacing(com.tencent.mm.bv.a.fromDPToPix(getContext(), this.xXM));
                    this.yaH.addView(mMGridPaperGridView, new LayoutParams(-1, -1));
                }
            } else {
                for (fromDPToPix2 = this.yaO; fromDPToPix2 <= this.yaP; fromDPToPix2++) {
                    mMGridPaperGridView = (MMGridPaperGridView) this.yaH.getChildAt(fromDPToPix2 - this.yaO);
                    if (mMGridPaperGridView.mIndex != fromDPToPix2) {
                        x.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[]{Integer.valueOf(mMGridPaperGridView.mIndex), Integer.valueOf(fromDPToPix2)});
                        mMGridPaperGridView.a(fromDPToPix2, this.leO, this.mNumColumns, this.yaI);
                        if (mMGridPaperGridView.ybq != null) {
                            mMGridPaperGridView.ybq.notifyDataSetChanged();
                        }
                    } else {
                        x.v("MicroMsg.MMGridPaper", "same grid index, continus");
                    }
                }
            }
            cpk();
            return;
        }
        cpi();
    }

    private static int eP(int i, int i2) {
        if (i2 <= 0) {
            x.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return 0;
        }
        int i3 = i;
        int i4 = 0;
        while (i3 > 0) {
            i3 -= i2;
            i4++;
        }
        x.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)});
        return i4;
    }

    private void cpk() {
        x.v("MicroMsg.MMGridPaper", "set DotView");
        Assert.assertTrue(this.yaQ >= 0);
        this.kba.EH(this.yaQ);
        if (this.yaI == null || this.yaQ <= 1) {
            this.kba.setVisibility(8);
            x.v("MicroMsg.MMGridPaper", "set DotView gone");
        } else {
            this.kba.setVisibility(0);
            x.v("MicroMsg.MMGridPaper", "set DotView visible");
        }
        if (this.yaM >= this.yaQ) {
            this.yaM = this.yaQ - 1;
        }
        this.yaH.EJ(this.yaM - this.yaO);
        this.yaH.EK(this.yaM);
        this.kba.EI(this.yaM);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (this.ybb != cbf()) {
            this.ybb = cbf();
            x.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
            this.yaX = true;
            clearAnimation();
            cpi();
            cpj();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @TargetApi(8)
    public final void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            x.d("MicroMsg.MMGridPaper", "onConfigChanged:" + configuration.orientation);
            this.yaX = true;
        }
    }
}
