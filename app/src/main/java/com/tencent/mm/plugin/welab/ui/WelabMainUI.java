package com.tencent.mm.plugin.welab.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class WelabMainUI extends MMActivity {
    private boolean tPH = false;
    private LinearLayout tPT;
    private LinearLayout tPU;
    private LinearLayout tPV;
    private LinearLayout tPW;
    private View tPX;
    private View tPY;
    private List<String> tPZ;
    private Comparator<a> tQa = new 3(this);
    private OnClickListener tQb = new 4(this);

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        if (getIntent() != null) {
            if (getIntent().getIntExtra("para_from_with_red_point", 0) == 1) {
                z = true;
            }
            this.tPH = z;
            this.tPZ = getIntent().getStringArrayListExtra("key_exclude_apps");
        }
        initView();
        b.bVJ();
        ac.cft().edit().putBoolean("key_has_enter_welab", true).commit();
        b.bVK();
        e.o("", 1, this.tPH);
    }

    protected final int getLayoutId() {
        return c.tPq;
    }

    protected final void initView() {
        setMMTitle(d.tPt);
        int i = com.tencent.mm.plugin.welab.a.a.white;
        p pVar = this.mController;
        if (pVar.xIS != null) {
            pVar.xIS.setBackgroundColor(i);
        }
        cmS();
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.tOY));
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.tOY));
        }
        this.tPT = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.tPf);
        this.tPV = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.tPg);
        this.tPU = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.tPi);
        this.tPW = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.tPj);
        this.tPX = findViewById(com.tencent.mm.plugin.welab.a.b.eAW);
        this.tPY = findViewById(com.tencent.mm.plugin.welab.a.b.tPe);
        this.tPX.setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
    }

    public void onResume() {
        super.onResume();
        this.tPV.removeAllViews();
        this.tPW.removeAllViews();
        List<a> bVv = com.tencent.mm.plugin.welab.b.bVu().bVv();
        if (bVv == null || bVv.isEmpty()) {
            this.tPT.setVisibility(8);
        } else {
            a aVar;
            Iterator it = bVv.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (!bh.ov(aVar.field_LabsAppId) && this.tPZ.contains(aVar.field_LabsAppId)) {
                    it.remove();
                }
            }
            if (bVv.isEmpty()) {
                this.tPT.setVisibility(8);
            } else {
                this.tPT.setVisibility(0);
                Collections.sort(bVv, this.tQa);
                for (a aVar2 : bVv) {
                    a(aVar2, this.tPV);
                }
                x.d("MicroMsg.WelabMainUI", "get online app count " + this.tPV.getChildCount());
            }
        }
        bVI();
        if (this.tPT.getVisibility() == 0 || this.tPU.getVisibility() == 0) {
            this.tPY.setVisibility(8);
        } else {
            this.tPY.setVisibility(0);
        }
    }

    public void onPause() {
        super.onPause();
    }

    private void bVI() {
        List<a> bVE = com.tencent.mm.plugin.welab.b.bVu().tPx.bVE();
        Iterator it = bVE.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if ((System.currentTimeMillis() / 1000) - aVar.field_endtime >= 2592000 || "labs1de6f3".equals(aVar.field_LabsAppId)) {
                it.remove();
                com.tencent.mm.plugin.welab.b.bVu().tPx.a((com.tencent.mm.sdk.e.c) aVar, new String[0]);
            } else if (aVar.bPi() && aVar.field_Switch != 3) {
                aVar.field_Switch = 3;
                com.tencent.mm.plugin.welab.b.bVu().tPx.c(aVar, new String[0]);
            } else if (aVar.field_Switch != 3) {
                it.remove();
            }
        }
        if (bVE.isEmpty()) {
            this.tPU.setVisibility(8);
            return;
        }
        this.tPU.setVisibility(0);
        Collections.sort(bVE, this.tQa);
        for (a aVar2 : bVE) {
            a(aVar2, this.tPW);
        }
        x.d("MicroMsg.WelabMainUI", "get online app count " + this.tPW.getChildCount());
    }

    private void a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(c.tPo, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.tPm);
        ImageView imageView2 = (ImageView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.tOZ);
        TextView textView = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.title);
        TextView textView2 = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.summary);
        if (b.bVJ().e(aVar)) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        com.tencent.mm.aq.a.a.PH().a(aVar.QD("field_ThumbUrl"), imageView2, com.tencent.mm.plugin.welab.b.bVu().tlo);
        com.tencent.mm.plugin.welab.b.bVu();
        textView.setText(com.tencent.mm.plugin.welab.b.a(aVar));
        textView2.setText(aVar.QD("field_Desc"));
        linearLayout2.setTag(aVar);
        linearLayout2.setOnClickListener(this.tQb);
        linearLayout.addView(linearLayout2);
    }
}
