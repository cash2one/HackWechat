package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.MMAutoAdjustTextView;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CleanChattingDetailUI extends MMActivity implements h {
    private ProgressDialog iln;
    private int index;
    private View kmh;
    CheckBox kmj;
    private GridHeadersGridView lgA;
    MMAutoAdjustTextView lgC;
    private Button lgD;
    private b lhK;
    private b lhL;
    private e lhM;

    static /* synthetic */ void b(CleanChattingDetailUI cleanChattingDetailUI) {
        if (d.ayi() != null) {
            Object arrayList = new ArrayList();
            arrayList.addAll(cleanChattingDetailUI.lhK.kmb);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                arrayList2.add(cleanChattingDetailUI.lhL.lfg.get(intValue));
                cleanChattingDetailUI.lhL.lfg.remove(intValue);
            }
            if (!cleanChattingDetailUI.lhL.aya()) {
                d.ayk().remove(cleanChattingDetailUI.index);
                x.i("MicroMsg.CleanChattingDetailUI", "Delete username=%s", new Object[]{cleanChattingDetailUI.lhL.username});
            }
            cleanChattingDetailUI.lhK.ayy();
            cleanChattingDetailUI.lhK.notifyDataSetChanged();
            if (cleanChattingDetailUI.lhM != null) {
                cleanChattingDetailUI.lhM.ayt();
            }
            cleanChattingDetailUI.lhM = new e(d.ayi(), cleanChattingDetailUI, arrayList2);
            cleanChattingDetailUI.lhM.start();
            cleanChattingDetailUI.iln.show();
            cleanChattingDetailUI.iln.setMessage(cleanChattingDetailUI.getString(R.l.dTM, new Object[]{"0%"}));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.ayr();
        this.index = getIntent().getIntExtra("key_position", -1);
        if (this.index < 0) {
            finish();
        } else if (d.ayk() == null) {
            finish();
        } else {
            this.kmh = findViewById(R.h.bKe);
            this.kmj = (CheckBox) findViewById(R.h.bKd);
            this.lgC = (MMAutoAdjustTextView) findViewById(R.h.caN);
            this.lgD = (Button) findViewById(R.h.bBE);
            on(0);
            this.lhL = (b) d.ayk().get(this.index);
            if (s.eV(this.lhL.username)) {
                setMMTitle(r.L(this.lhL.username, this.lhL.username));
            } else {
                setMMTitle(r.gu(this.lhL.username));
            }
            this.lgA = (GridHeadersGridView) findViewById(R.h.bWb);
            this.lgA.setNumColumns(3);
            this.lhK = new b(this, this.lhL.lfg);
            this.lgA.zeX = this.lhK.lgo;
            this.lgA.setOnItemClickListener(this.lhK.kGC);
            this.lgA.setOnScrollListener(this.lhK.lgq);
            this.lgA.setAdapter(this.lhK);
            setBackBtn(new 1(this));
            this.kmh.setOnClickListener(new 2(this));
            this.lgD.setOnClickListener(new 3(this));
            getString(R.l.dGO);
            this.iln = com.tencent.mm.ui.base.h.a(this, getString(R.l.dTB), false, new 4(this));
            this.iln.dismiss();
        }
    }

    protected final int getLayoutId() {
        return R.i.dev;
    }

    public final void on(int i) {
        this.lgD.setEnabled(i > 0);
    }

    protected void onDestroy() {
        if (this.iln.isShowing()) {
            this.iln.dismiss();
        }
        if (this.lhM != null) {
            this.lhM.ayt();
        }
        d.ays();
        d.ayq();
        super.onDestroy();
    }

    public final void cl(int i, int i2) {
        this.iln.setMessage(getString(R.l.dTM, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void bW(long j) {
        this.iln.dismiss();
        d.bU(d.ayo() + j);
        d.bR(d.ayl() - j);
        com.tencent.mm.ui.base.h.a(this, getString(R.l.dTC, new Object[]{bh.bx(j)}), "", new OnClickListener(this) {
            final /* synthetic */ CleanChattingDetailUI lhN;

            {
                this.lhN = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.lhN.lhL.lfg.size() == 0) {
                    this.lhN.finish();
                }
            }
        });
    }
}
