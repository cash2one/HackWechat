package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class CleanChattingUI extends MMActivity implements h {
    private ProgressDialog iln;
    private View kmh;
    private CheckBox kmj;
    private TextView kmk;
    private Button lgD;
    private ListView lgJ;
    private TextView lgK;
    private e lhM;
    private a lhP;

    static /* synthetic */ void a(CleanChattingUI cleanChattingUI) {
        if (d.ayi() != null) {
            Object arrayList = new ArrayList();
            arrayList.addAll(cleanChattingUI.lhP.kmb);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (intValue < d.ayk().size()) {
                    arrayList2.addAll(((b) d.ayk().get(intValue)).lfg);
                    d.ayk().remove(intValue);
                }
            }
            cleanChattingUI.lhP.ayy();
            cleanChattingUI.lhP.notifyDataSetChanged();
            if (cleanChattingUI.lhM != null) {
                cleanChattingUI.lhM.ayt();
            }
            cleanChattingUI.lhM = new e(d.ayi(), cleanChattingUI, arrayList2);
            cleanChattingUI.lhM.start();
            cleanChattingUI.iln.show();
            cleanChattingUI.iln.setMessage(cleanChattingUI.getString(R.l.dTM, new Object[]{"0%"}));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.ayr();
        x.i("MicroMsg.CleanChattingUI", "Create!!");
        setMMTitle(R.l.dTO);
        this.lgJ = (ListView) findViewById(R.h.bWc);
        this.lhP = new a(this);
        this.lgJ.setAdapter(this.lhP);
        this.lgJ.setEmptyView(findViewById(R.h.ceu));
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
        this.lgJ.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CleanChattingUI lhQ;

            {
                this.lhQ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(this.lhQ, CleanChattingDetailUI.class);
                intent.putExtra("key_position", i);
                this.lhQ.startActivityForResult(intent, 0);
            }
        });
        this.lgD.setOnClickListener(new 3(this));
        this.kmh.setOnClickListener(new 4(this));
        getString(R.l.dGO);
        this.iln = com.tencent.mm.ui.base.h.a(this, getString(R.l.dTB), false, new 5(this));
        this.iln.dismiss();
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < d.ayk().size()) {
                i = (int) (((b) d.ayk().get(intValue)).fwg + ((long) i));
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || i > 0) {
            this.lgK.setText(getString(R.l.dYs, new Object[]{bh.bx((long) i)}));
            this.lgD.setEnabled(true);
            if (hashSet.size() == this.lhP.getCount()) {
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
        if (this.lhM != null) {
            this.lhM.ayt();
        }
        d.ays();
        d.ayq();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dex;
    }

    public final void cl(int i, int i2) {
        this.iln.setMessage(getString(R.l.dTM, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void bW(long j) {
        this.iln.dismiss();
        d.bU(d.ayo() + j);
        d.bR(d.ayl() - j);
        com.tencent.mm.ui.base.h.a(this, getString(R.l.dTC, new Object[]{bh.bx(j)}), "", new 6(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.lhP.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
    }
}
