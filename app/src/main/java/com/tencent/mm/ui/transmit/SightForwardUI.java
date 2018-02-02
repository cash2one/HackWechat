package com.tencent.mm.ui.transmit;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.1;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.2;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.3;
import com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView;
import com.tencent.mm.plugin.sight.encode.ui.c;
import com.tencent.mm.pluginsdk.k.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.z.ar;
import java.util.HashSet;

public class SightForwardUI extends MMActivity {
    private String beo;
    private MainSightForwardContainerView zpS;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getSupportActionBar().hide();
        this.beo = getIntent().getStringExtra("sight_local_path");
        if (!d.Jr(this.beo)) {
            x.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[]{this.beo});
            finish();
        } else if (ar.Hj()) {
            String ns = s.ns(String.valueOf(SystemClock.elapsedRealtime()));
            o.TU();
            ns = s.nt(ns);
            if (e.x(this.beo, ns) <= 0) {
                x.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[]{this.beo, ns});
                finish();
                return;
            }
            this.beo = ns;
            x.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[]{this.beo});
            this.zpS = (MainSightForwardContainerView) findViewById(R.h.cjd);
            this.zpS.qww = new 1(this);
            MainSightForwardContainerView mainSightForwardContainerView = this.zpS;
            ns = this.beo;
            mainSightForwardContainerView.qwI = this;
            mainSightForwardContainerView.qwE = ns;
            mainSightForwardContainerView.qwC = g.bV(ns);
            long currentTimeMillis = System.currentTimeMillis();
            mainSightForwardContainerView.qwF = 1.3333334f;
            mainSightForwardContainerView.qwv = (SightCameraView) ((ViewStub) mainSightForwardContainerView.findViewById(R.h.bPm)).inflate();
            mainSightForwardContainerView.qwv.wp(a.otm);
            mainSightForwardContainerView.qwv.at(mainSightForwardContainerView.qwF);
            mainSightForwardContainerView.qwv.setVisibility(0);
            mainSightForwardContainerView.qwz = mainSightForwardContainerView.findViewById(R.h.cSE);
            mainSightForwardContainerView.qwz.setLayoutParams(new LayoutParams(-1, getSupportActionBar().getHeight()));
            mainSightForwardContainerView.qwy = mainSightForwardContainerView.findViewById(R.h.cuP);
            mainSightForwardContainerView.oiS = mainSightForwardContainerView.findViewById(R.h.cuQ);
            mainSightForwardContainerView.qwx = mainSightForwardContainerView.findViewById(R.h.bPl);
            mainSightForwardContainerView.qwy.setOnClickListener(new 1(mainSightForwardContainerView));
            mainSightForwardContainerView.oiS.setOnClickListener(new 2(mainSightForwardContainerView));
            mainSightForwardContainerView.btx();
            x.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            this.zpS.btw();
            mainSightForwardContainerView = this.zpS;
            if (mainSightForwardContainerView.qwu == null) {
                DisplayMetrics displayMetrics = mainSightForwardContainerView.getResources().getDisplayMetrics();
                float f = ((float) displayMetrics.widthPixels) / mainSightForwardContainerView.qwF;
                mainSightForwardContainerView.qwu = (MainSightSelectContactView) mainSightForwardContainerView.findViewById(R.h.cKO);
                com.tencent.mm.plugin.sight.encode.ui.d.a aVar = mainSightForwardContainerView.qwu;
                MMFragmentActivity mMFragmentActivity = mainSightForwardContainerView.qwI;
                int i = (int) (((float) displayMetrics.heightPixels) - f);
                int i2 = displayMetrics.heightPixels;
                aVar.qwI = mMFragmentActivity;
                aVar.qxh = i;
                aVar.qxm = mainSightForwardContainerView;
                aVar.addView(View.inflate(aVar.getContext(), R.i.dmU, null), -1, -2);
                aVar.Fv = (ListView) aVar.findViewById(R.h.cKN);
                aVar.qxk = new c(aVar);
                aVar.qxn = new LinearLayout(aVar.getContext());
                aVar.qxn.addView(new View(aVar.getContext()), -1, aVar.qxm.btt() - aVar.qxh);
                aVar.qxn.getChildAt(0).setBackgroundColor(0);
                aVar.Fv.addHeaderView(aVar.qxn);
                aVar.Fv.setAdapter(aVar.qxk);
                aVar.Fv.setOnItemClickListener(mainSightForwardContainerView);
                aVar.qxr = new HashSet();
                aVar.qxs = new HashSet();
                aVar.Fv.setOnScrollListener(aVar);
                aVar.qxi = new com.tencent.mm.plugin.sight.encode.ui.d();
                aVar.qxi.qxd = aVar;
                MainSightSelectContactView mainSightSelectContactView = mainSightForwardContainerView.qwu;
                View findViewById = mainSightForwardContainerView.findViewById(R.h.cKe);
                Object obj = mainSightSelectContactView.qxi;
                obj.qwZ = findViewById;
                obj.qwX = (EditText) findViewById.findViewById(R.h.cdj);
                obj.qwY = (TextView) findViewById.findViewById(R.h.cJp);
                obj.qwX.setOnFocusChangeListener(obj);
                obj.qwX.addTextChangedListener(obj);
                obj.qwY.setOnClickListener(obj);
                obj.qxb = (InputMethodManager) findViewById.getContext().getSystemService("input_method");
                mainSightForwardContainerView.qwu.qxl = mainSightForwardContainerView.findViewById(R.h.ced);
                mainSightForwardContainerView.qwu.qxm = mainSightForwardContainerView;
            }
            mainSightForwardContainerView.ii(true);
            mainSightForwardContainerView.qwv.postDelayed(new 3(mainSightForwardContainerView), 50);
        } else {
            x.e("MicroMsg.SightForwardUI", "acc not ready");
            finish();
        }
    }

    protected final int getLayoutId() {
        return R.i.dmT;
    }

    protected void onResume() {
        super.onResume();
        this.zpS.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.zpS.onPause();
    }
}
