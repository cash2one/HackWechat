package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.a;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.f;
import com.tencent.mm.plugin.clean.c.g;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanMsgUI extends MMActivity implements g, h {
    private ProgressDialog iln;
    private View lgQ;
    private PieView lgR;
    private TextView lgS;
    private Button lgT;
    private Button lgU;
    private TextView lgV;
    private TextView lgW;
    private TextView lgX;
    private TextView lgY;
    private View lgZ;
    private e lhM;
    private c lhS;
    private TextView lha;
    private TextView lhb;
    private TextView lhc;
    private TextView lhd;
    private TextView lhe;

    static /* synthetic */ void a(CleanMsgUI cleanMsgUI) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.add(cleanMsgUI.getString(R.l.eBE));
        arrayList2.add(Integer.valueOf(0));
        com.tencent.mm.ui.base.h.a(cleanMsgUI, null, arrayList, arrayList2, null, false, new 6(cleanMsgUI));
    }

    static /* synthetic */ void a(CleanMsgUI cleanMsgUI, HashSet hashSet) {
        x.i("MicroMsg.CleanMsgUI", "%d begin deleteOtherAcc", new Object[]{Integer.valueOf(cleanMsgUI.hashCode())});
        com.tencent.mm.plugin.report.service.g.pQN.a(282, 11, 1, false);
        new f(hashSet, new 7(cleanMsgUI)).start();
        cleanMsgUI.iln.show();
    }

    static /* synthetic */ long ayC() {
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        if (d.ayk() == null) {
            return 0;
        }
        Iterator it = d.ayk().iterator();
        long j = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.lfg != null) {
                Iterator it2 = bVar.lfg.iterator();
                while (it2.hasNext()) {
                    a aVar = (a) it2.next();
                    if (aVar.hVF < timeInMillis) {
                        j += aVar.size;
                    }
                }
            }
            j = j;
        }
        return j;
    }

    static /* synthetic */ ArrayList ayD() {
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        for (int size = d.ayk().size() - 1; size >= 0; size--) {
            b bVar = (b) d.ayk().get(size);
            for (int size2 = bVar.lfg.size() - 1; size2 >= 0; size2--) {
                if (((a) bVar.lfg.get(size2)).hVF < timeInMillis) {
                    arrayList.add(bVar.lfg.get(size2));
                    bVar.lfg.remove(size2);
                }
            }
            if (!bVar.aya()) {
                d.ayk().remove(size);
            }
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.pQN.a(282, 3, 1, false);
        d.ayr();
        this.lgS = (TextView) findViewById(R.h.cDt);
        this.lgR = (PieView) findViewById(R.h.cCC);
        this.lgT = (Button) findViewById(R.h.bWa);
        this.lgU = (Button) findViewById(R.h.bWe);
        this.lgQ = findViewById(R.h.bKf);
        this.lgV = (TextView) findViewById(R.h.cZl);
        this.lgV.setTextSize(1, 16.0f);
        this.lgW = (TextView) findViewById(R.h.cBS);
        this.lgW.setTextSize(1, 16.0f);
        this.lgX = (TextView) findViewById(R.h.cBV);
        this.lgX.setTextSize(1, 16.0f);
        this.lgY = (TextView) findViewById(R.h.cjg);
        this.lgY.setTextSize(1, 16.0f);
        this.lha = (TextView) findViewById(R.h.bWd);
        this.lhb = (TextView) findViewById(R.h.bWf);
        this.lhc = (TextView) findViewById(R.h.cZp);
        this.lhd = (TextView) findViewById(R.h.cBT);
        this.lhe = (TextView) findViewById(R.h.cBX);
        this.lgZ = findViewById(R.h.cBR);
        setMMTitle(R.l.dTO);
        d.a(new com.tencent.mm.plugin.clean.c.a.b());
        setBackBtn(new 1(this));
        this.lgU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CleanMsgUI lhT;

            {
                this.lhT = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.base.h.a(this.lhT, this.lhT.getString(R.l.dTK, new Object[]{bh.fK(d.ayn())}), "", this.lhT.getString(R.l.dFU), this.lhT.getString(R.l.dEn), new 1(this), null);
            }
        });
        this.lgT.setOnClickListener(new 3(this));
        addIconOptionMenu(0, R.k.duY, new 4(this));
        enableOptionMenu(0, false);
        getString(R.l.dGO);
        this.iln = com.tencent.mm.ui.base.h.a(this, getString(R.l.dTB), false, new 5(this));
        this.iln.dismiss();
        if (d.ayk() != null) {
            this.lgS.setVisibility(8);
            this.lgT.setEnabled(true);
            enableOptionMenu(0, true);
            d.ayo();
            d(d.ayl(), d.ayn(), d.aym());
            return;
        }
        com.tencent.mm.plugin.clean.c.a.b ayi = d.ayi();
        if (ayi != null) {
            this.lhS = new c(ayi, this);
            com.tencent.mm.sdk.f.e.post(this.lhS, "CleanUI_clean");
            this.lgS.setText(getString(R.l.dDH, new Object[]{"0%"}));
        }
    }

    protected final int getLayoutId() {
        return R.i.dez;
    }

    private void d(long j, long j2, long j3) {
        int i;
        int i2 = (int) ((360 * j3) / j);
        if (i2 < 5) {
            i = 5;
        } else {
            i = i2;
        }
        i2 = 0;
        if (j2 > 0) {
            i2 = (int) ((360 * j2) / j);
            if (i2 < 5) {
                i2 = 5;
            }
        }
        long j4 = (j - j3) - j2;
        int i3 = (int) ((360 * j4) / j);
        x.i("MicroMsg.CleanMsgUI", "update [%d %d] [%d %d] [%d %d] wechatSize[%d]", new Object[]{Long.valueOf(j3), Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j4), Integer.valueOf(i3), Long.valueOf(j)});
        this.lgR.lgg = i;
        this.lgR.lgi = i2;
        this.lgR.fBs = 1;
        this.lgQ.setVisibility(0);
        this.lgV.setText(bh.bx(j3));
        this.lgW.setText(bh.bx(j2));
        this.lgX.setText(bh.bx(j4));
        if (j2 > 0) {
            this.lgZ.setVisibility(0);
            this.lgU.setVisibility(0);
        } else {
            this.lgU.setVisibility(8);
            this.lgZ.setVisibility(8);
        }
        i2 = (int) ((100 * j3) / j);
        this.lhc.setText(getString(R.l.dTz, new Object[]{i2 + "%"}));
        i2 = (int) ((100 * j2) / j);
        this.lhd.setText(getString(R.l.dTJ, new Object[]{i2 + "%"}));
        i2 = (int) ((100 * j4) / j);
        this.lhe.setText(getString(R.l.dTL, new Object[]{i2 + "%"}));
    }

    protected void onDestroy() {
        if (this.lhS != null) {
            Runnable runnable = this.lhS;
            x.i("MicroMsg.CleanController", "stop CleanController [%d]", new Object[]{Integer.valueOf(runnable.hashCode())});
            runnable.isStop = true;
            com.tencent.mm.sdk.f.e.Q(runnable);
        }
        if (this.lhM != null) {
            this.lhM.ayt();
        }
        if (d.ayi() != null) {
            com.tencent.mm.plugin.clean.c.a.b ayi = d.ayi();
            for (af removeCallbacksAndMessages : ayi.lfN.values()) {
                removeCallbacksAndMessages.removeCallbacksAndMessages(null);
            }
            for (af removeCallbacksAndMessages2 : ayi.lfN.values()) {
                removeCallbacksAndMessages2.getLooper().getThread().interrupt();
                removeCallbacksAndMessages2.getLooper().quit();
            }
            x.i("MicroMsg.ThreadController", "finish thread controller [%d]", new Object[]{Integer.valueOf(ayi.hashCode())});
        }
        d.ays();
        d.ayq();
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        d.ayo();
        d(d.ayl(), d.ayn(), d.aym());
    }

    public final void ck(int i, int i2) {
        this.lgS.setText(getString(R.l.dDH, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void a(long j, long j2, long j3, ArrayList<b> arrayList, long j4, HashSet<String> hashSet) {
        x.i("MicroMsg.CleanMsgUI", "%d on clean result cleanDataSize[%d] wechatSize[%d] otherAccSize[%d]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j4)});
        this.lgS.setVisibility(8);
        this.lgT.setEnabled(true);
        enableOptionMenu(0, true);
        d(j2, j4, j3);
        if (j > 0) {
            this.lha.setVisibility(0);
            this.lha.setText(getString(R.l.dTD, new Object[]{bh.bx(j)}));
        } else {
            this.lha.setVisibility(8);
            this.lha.setText("");
        }
        d.bU(j);
        d.bR(j2);
        d.bT(j4);
        d.b(hashSet);
        d.bS(j3);
        d.m(arrayList);
        if (j4 > 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(282, 9, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(282, 10, 1, false);
        }
    }

    public final void cl(int i, int i2) {
        this.iln.setMessage(getString(R.l.dTM, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void bW(long j) {
        this.iln.dismiss();
        d.bR(d.ayl() - j);
        d.bU(d.ayo() + j);
        d.ayo();
        d(d.ayl(), d.ayn(), d.aym());
    }
}
