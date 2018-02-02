package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
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
import java.util.List;

public class CleanChattingDetailUI extends MMActivity implements h {
    private ProgressDialog iln;
    private View kmh;
    CheckBox kmj;
    private long leZ;
    private GridHeadersGridView lgA;
    private b lgB;
    MMAutoAdjustTextView lgC;
    private Button lgD;
    private b lgE;
    private int pos;
    private String username;

    static /* synthetic */ void b(CleanChattingDetailUI cleanChattingDetailUI) {
        Object arrayList = new ArrayList();
        arrayList.addAll(cleanChattingDetailUI.lgB.kmb);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            i ol = cleanChattingDetailUI.lgB.ol(intValue);
            if (ol != null) {
                arrayList2.add(ol);
                cleanChattingDetailUI.lgB.jMd.remove(intValue);
            }
        }
        cleanChattingDetailUI.lgB.ayy();
        cleanChattingDetailUI.lgB.notifyDataSetChanged();
        cleanChattingDetailUI.lgE = new b(null, arrayList2, cleanChattingDetailUI);
        e.post(cleanChattingDetailUI.lgE, "delete-clean");
        cleanChattingDetailUI.iln.show();
        cleanChattingDetailUI.iln.setMessage(cleanChattingDetailUI.getString(R.l.dTM, new Object[]{"0%"}));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("key_username");
        this.pos = getIntent().getIntExtra("key_pos", 0);
        if (bh.ov(this.username)) {
            x.w("MicroMsg.CleanChattingDetailUI", "username is null");
            finish();
            return;
        }
        this.kmh = findViewById(R.h.bKe);
        this.kmj = (CheckBox) findViewById(R.h.bKd);
        this.lgC = (MMAutoAdjustTextView) findViewById(R.h.caN);
        this.lgD = (Button) findViewById(R.h.bBE);
        on(0);
        if (s.eV(this.username)) {
            setMMTitle(r.L(this.username, this.username));
        } else {
            setMMTitle(r.gu(this.username));
        }
        this.lgA = (GridHeadersGridView) findViewById(R.h.bWb);
        this.lgA.setNumColumns(3);
        this.lgB = new b(this, this.username);
        this.lgA.zeX = this.lgB.lgo;
        this.lgA.setOnItemClickListener(this.lgB.kGC);
        this.lgA.setOnScrollListener(this.lgB.lgq);
        this.lgA.setAdapter(this.lgB);
        setBackBtn(new 1(this));
        this.kmh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CleanChattingDetailUI lgF;

            {
                this.lgF = r1;
            }

            public final void onClick(View view) {
                b a = this.lgF.lgB;
                if (a.kmb.size() == a.jMd.size()) {
                    a.kmb.clear();
                } else {
                    for (int i = 0; i < a.jMd.size(); i++) {
                        a.kmb.add(Integer.valueOf(i));
                    }
                }
                a.ayz();
                this.lgF.lgB.notifyDataSetChanged();
            }
        });
        this.lgD.setOnClickListener(new 3(this));
        getString(R.l.dGO);
        this.iln = com.tencent.mm.ui.base.h.a(this, getString(R.l.dTB), false, new 4(this));
        this.iln.dismiss();
        if (this.lgB != null) {
            e.post(new b.b(this.lgB, (byte) 0), "load_clean_detail");
        }
        g.pQN.a(714, 30, 1, false);
    }

    protected final int getLayoutId() {
        return R.i.dev;
    }

    public final void on(int i) {
        this.lgD.setEnabled(i > 0);
    }

    protected void onDestroy() {
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
        if (this.lgB != null) {
            this.lgB.isStop = true;
        }
        super.onDestroy();
    }

    public final void cl(int i, int i2) {
        ag.y(new 5(this, i, i2));
    }

    public final void bW(long j) {
        x.i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", new Object[]{hashCode(), Long.valueOf(j)});
        j.ayv().leX -= j;
        j.ayv().leW -= j;
        this.leZ += j;
        ag.y(new 6(this, j));
    }
}
