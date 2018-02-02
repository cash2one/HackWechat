package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import java.util.ArrayList;
import java.util.List;

public class SelectScanModePanel extends LinearLayout {
    private static int pYV = 85;
    private static int pYW = 85;
    private Context context;
    private final int pYX = 0;
    private int pYY = 0;
    protected List<SelectScanModeGrid> pYZ;
    private int[] pZa = new int[]{R.l.eHy, R.l.eHw, R.l.eHB, R.l.eHx};
    private int[] pZb = new int[]{R.g.bFv, R.g.bFt, R.g.bFy, R.g.bFA};
    private int[] pZc = new int[]{R.g.bFw, R.g.bFu, R.g.bFz, R.g.bFB};
    private int[] pZd = new int[]{1, 2, 5, 3};
    private OnItemClickListener pZe;
    private int pZf = 0;
    private boolean pZg = false;
    private int pZh;
    private int pZi;
    private MMFlipper pZj;
    private MMDotView pZk;
    a pZl;

    public interface a {
        void vH(int i);
    }

    static /* synthetic */ void c(SelectScanModePanel selectScanModePanel) {
        if (selectScanModePanel.pZe == null) {
            selectScanModePanel.pZe = new 3(selectScanModePanel);
        }
        selectScanModePanel.pYZ = new ArrayList();
        if (selectScanModePanel.pZh != 0 && selectScanModePanel.pZi != 0) {
            selectScanModePanel.pZj.removeAllViews();
            int b = b.b(selectScanModePanel.context, 64.0f);
            int i = selectScanModePanel.pZh / b;
            b = selectScanModePanel.pZi / b.b(selectScanModePanel.context, 78.0f);
            if (i == 0) {
                i = 1;
            } else if (i > selectScanModePanel.pZd.length) {
                i = selectScanModePanel.pZd.length;
            }
            if (b == 0) {
                b = 1;
            }
            int i2 = i * b;
            selectScanModePanel.pZf = 0;
            b = 5;
            while (b > 0) {
                b -= i2;
                selectScanModePanel.pZf++;
            }
            for (i = 0; i < selectScanModePanel.pZf; i++) {
                List arrayList = new ArrayList();
                int i3 = i * i2;
                b = i3;
                while (b < selectScanModePanel.pZa.length && b < i3 + i2) {
                    arrayList.add(new SelectScanModeGrid.b(selectScanModePanel.pZa[b], selectScanModePanel.pZb[b], selectScanModePanel.pZc[b], selectScanModePanel.pZd[b]));
                    b++;
                }
                if (arrayList.size() > 0) {
                    SelectScanModeGrid selectScanModeGrid = (SelectScanModeGrid) inflate(selectScanModePanel.context, R.i.drJ, null);
                    selectScanModeGrid.setNumColumns(i2);
                    ListAdapter aVar = new com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a(selectScanModePanel.context, arrayList);
                    aVar.pYO = selectScanModePanel.pYY;
                    selectScanModeGrid.setAdapter(aVar);
                    selectScanModePanel.pZj.addView(selectScanModeGrid, new LayoutParams(-1, -1));
                    selectScanModeGrid.setOnItemClickListener(selectScanModePanel.pZe);
                    selectScanModePanel.pYZ.add(selectScanModeGrid);
                }
            }
            if (selectScanModePanel.pYZ.size() <= 1) {
                selectScanModePanel.pZk.setVisibility(4);
                return;
            }
            selectScanModePanel.pZk.setVisibility(0);
            selectScanModePanel.pZk.EH(selectScanModePanel.pYZ.size());
            b = selectScanModePanel.pZj.coY();
            selectScanModePanel.pZj.EL(b);
            selectScanModePanel.pZk.EI(b);
        }
    }

    public SelectScanModePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View.inflate(this.context, R.i.drL, this);
        this.pZk = (MMDotView) findViewById(R.h.cLf);
        x.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
        this.pZj = (MMFlipper) findViewById(R.h.cLg);
        View findViewById = findViewById(R.h.cLe);
        LayoutParams layoutParams;
        if (this.context.getResources().getConfiguration().orientation == 2) {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = b.b(this.context, (float) pYW);
            findViewById.setLayoutParams(layoutParams);
        } else {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = b.b(this.context, (float) pYV);
            findViewById.setLayoutParams(layoutParams);
        }
        this.pZj.removeAllViews();
        this.pZj.yal = new 1(this);
        this.pZj.yak = new 2(this);
    }

    public final void vI(int i) {
        for (int i2 = 0; i2 < this.pZd.length; i2++) {
            if (this.pZd[i2] == i) {
                this.pYY = i2;
            }
        }
        if (this.pYZ != null) {
            for (int i3 = 0; i3 < this.pYZ.size(); i3++) {
                com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a aVar = (com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a) ((SelectScanModeGrid) this.pYZ.get(i3)).getAdapter();
                if (aVar != null) {
                    for (int i4 = 0; i4 < aVar.getCount(); i4++) {
                        SelectScanModeGrid.b bVar = (SelectScanModeGrid.b) aVar.getItem(i4);
                        if (!(bVar == null || bVar.pYU == null)) {
                            if (bVar.pYT == i) {
                                bVar.pYU.setBackgroundResource(bVar.pYS);
                                if (i3 > 0) {
                                    this.pZj.EL(i3);
                                    this.pZk.EI(i3);
                                }
                            } else {
                                bVar.pYU.setBackgroundResource(bVar.pYR);
                            }
                        }
                    }
                }
            }
        }
    }
}
