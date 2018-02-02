package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.f;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.HashSet;

public class CleanMsgUI extends MMActivity {
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
    private TextView lha;
    private TextView lhb;
    private TextView lhc;
    private TextView lhd;
    private TextView lhe;
    private TextView lhf;
    private LinearLayout lhg;

    static /* synthetic */ void a(CleanMsgUI cleanMsgUI, HashSet hashSet) {
        x.i("MicroMsg.CleanMsgUI", "%d begin deleteOtherAcc", new Object[]{Integer.valueOf(cleanMsgUI.hashCode())});
        g.pQN.a(714, 11, 1, false);
        new f(hashSet, new 5(cleanMsgUI)).start();
        cleanMsgUI.iln.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.pQN.a(714, 10, 1, false);
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
        this.lhf = (TextView) findViewById(R.h.cap);
        this.lhg = (LinearLayout) findViewById(R.h.caq);
        this.lhc = (TextView) findViewById(R.h.cZp);
        this.lhd = (TextView) findViewById(R.h.cBT);
        this.lhe = (TextView) findViewById(R.h.cBX);
        this.lgZ = findViewById(R.h.cBR);
        setMMTitle(R.l.dTI);
        setBackBtn(new 1(this));
        this.lgU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CleanMsgUI lhh;

            {
                this.lhh = r1;
            }

            public final void onClick(View view) {
                h.a(this.lhh, this.lhh.getString(R.l.dTK, new Object[]{bh.fK(j.ayv().leY)}), "", this.lhh.getString(R.l.dFU), this.lhh.getString(R.l.dEn), new 1(this), null, R.e.btB);
            }
        });
        this.lgT.setEnabled(true);
        this.lgT.setOnClickListener(new 3(this));
        getString(R.l.dGO);
        this.iln = h.a((Context) this, getString(R.l.dTB), false, new 4(this));
        this.iln.dismiss();
        c(j.ayv().leW, j.ayv().leX, j.ayv().leY);
    }

    protected final int getLayoutId() {
        return R.i.dez;
    }

    private void c(long j, long j2, long j3) {
        int i;
        if (j <= 0) {
            j = 1;
            g.pQN.a(714, 61, 1, false);
        }
        int i2 = (int) ((360 * j2) / j);
        if (j2 <= 0 || i2 >= 5) {
            i = i2;
        } else {
            i = 5;
        }
        i2 = 0;
        if (j3 > 0) {
            i2 = (int) ((360 * j3) / j);
            if (i2 < 5) {
                i2 = 5;
            }
        }
        long j4 = (j - j2) - j3;
        int i3 = (int) ((100 * j2) / j);
        int i4 = (int) ((100 * j3) / j);
        int i5 = (int) ((100 * j4) / j);
        x.i("MicroMsg.CleanMsgUI", "update acc[%d %d] otherAcc[%d %d] other[%d %d] wechat[%d] stack[%s]", new Object[]{Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j), bh.cgy()});
        this.lgR.lgg = i;
        this.lgR.lgi = i2;
        this.lgR.fBs = 1;
        this.lgQ.setVisibility(0);
        this.lgV.setText(bh.bx(j2));
        this.lgW.setText(bh.bx(j3));
        this.lgX.setText(bh.bx(j4));
        if (j3 > 0) {
            this.lgZ.setVisibility(0);
            this.lgU.setEnabled(true);
        } else {
            this.lgU.setEnabled(false);
            this.lgZ.setVisibility(0);
        }
        this.lhc.setText(getString(R.l.dTz));
        this.lhd.setText(getString(R.l.dTJ));
        this.lhe.setText(getString(R.l.dTL));
        if (((Integer) com.tencent.mm.kernel.g.Dj().CU().get(a.xwp, Integer.valueOf(0))).intValue() > 0) {
            this.lhg.setVisibility(0);
            this.lhf.setVisibility(0);
            TextView textView = this.lhf;
            HashMap hashMap = j.ayv().lfJ;
            StringBuffer stringBuffer = new StringBuffer();
            if (!hashMap.isEmpty()) {
                for (String str : hashMap.keySet()) {
                    stringBuffer.append(str).append(" : ").append(bh.bx(((Long) hashMap.get(str)).longValue())).append("\n");
                }
            }
            textView.setText(stringBuffer.toString());
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        c(j.ayv().leW, j.ayv().leX, j.ayv().leY);
    }
}
