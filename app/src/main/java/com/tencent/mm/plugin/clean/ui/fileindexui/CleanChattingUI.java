package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanChattingUI extends MMActivity implements h {
    private List<c> dataList = new ArrayList();
    private ProgressDialog iln;
    private View kmh;
    private CheckBox kmj;
    private TextView kmk;
    private Button lgD;
    private a lgI;
    private ListView lgJ;
    private TextView lgK;
    private TextView lgL;
    private boolean lgM = false;

    static /* synthetic */ void b(CleanChattingUI cleanChattingUI) {
        Object arrayList = new ArrayList();
        arrayList.addAll(cleanChattingUI.lgI.kmb);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            c ok = cleanChattingUI.lgI.ok(intValue);
            if (ok != null) {
                arrayList2.add(ok.username);
                cleanChattingUI.dataList.remove(intValue);
            }
        }
        cleanChattingUI.lgI.ayy();
        cleanChattingUI.lgI.notifyDataSetChanged();
        e.post(new b(arrayList2, null, cleanChattingUI), "delete-clean");
        cleanChattingUI.iln.setMessage(cleanChattingUI.getString(R.l.dTM, new Object[]{"0%"}));
        cleanChattingUI.iln.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle(R.l.dTI);
        this.lgJ = (ListView) findViewById(R.h.bWc);
        this.lgI = new a(this, this.dataList);
        this.lgJ.setAdapter(this.lgI);
        this.lgJ.setEmptyView(findViewById(R.h.ceu));
        this.lgL = (TextView) findViewById(R.h.ceq);
        this.kmh = findViewById(R.h.bKe);
        this.lgK = (TextView) findViewById(R.h.caN);
        this.kmj = (CheckBox) findViewById(R.h.bKd);
        this.kmk = (TextView) findViewById(R.h.bKc);
        if (!w.cfe()) {
            this.lgK.setTextSize(1, 14.0f);
            this.kmk.setTextSize(1, 14.0f);
        }
        this.lgD = (Button) findViewById(R.h.bBE);
        this.lgD.setEnabled(false);
        setBackBtn(new 1(this));
        this.lgJ.setOnItemClickListener(new 2(this));
        this.lgD.setOnClickListener(new 3(this));
        this.kmh.setOnClickListener(new 4(this));
        getString(R.l.dGO);
        this.iln = com.tencent.mm.ui.base.h.a(this, getString(R.l.dTB), false, new 5(this));
        this.iln.dismiss();
        g.pQN.a(714, 20, 1, false);
    }

    public final void a(HashSet<Integer> hashSet) {
        if (this.lgI == null) {
            x.w("MicroMsg.CleanChattingUI", "on click check box but adapter is null");
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            c ok = this.lgI.ok(intValue);
            if (ok != null) {
                j = ok.size + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            this.lgK.setText(getString(R.l.dYs, new Object[]{bh.bx(j)}));
            this.lgD.setEnabled(true);
            if (hashSet.size() == this.lgI.getCount()) {
                this.kmj.setChecked(true);
                return;
            } else {
                this.kmj.setChecked(false);
                return;
            }
        }
        this.lgK.setText("");
        this.lgD.setEnabled(false);
        this.kmj.setChecked(false);
    }

    protected void onDestroy() {
        if (this.iln.isShowing()) {
            this.iln.dismiss();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.lgI != null && this.dataList.isEmpty()) {
            com.tencent.mm.kernel.g.Dm().F(new 6(this));
        }
    }

    protected final int getLayoutId() {
        return R.i.dex;
    }

    public final void cl(final int i, final int i2) {
        ag.y(new Runnable(this) {
            final /* synthetic */ CleanChattingUI lgN;

            public final void run() {
                this.lgN.iln.setMessage(this.lgN.getString(R.l.dTM, new Object[]{((i * 100) / i2) + "%"}));
            }
        });
    }

    public final void bW(long j) {
        x.i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", new Object[]{hashCode(), Long.valueOf(j)});
        j.ayv().leX -= j;
        j.ayv().leW -= j;
        ag.y(new 8(this, j));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_pos", -1);
            long longExtra = intent.getLongExtra("key_delete_size", 0);
            if (intExtra > 0 && intExtra < this.dataList.size()) {
                c cVar = (c) this.dataList.get(intExtra);
                if (cVar != null) {
                    if (cVar.size == longExtra) {
                        this.dataList.remove(intExtra);
                    } else {
                        cVar.size -= longExtra;
                    }
                }
            }
        }
        this.lgI.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
    }
}
