package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.ui.c;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a extends com.tencent.mm.plugin.p.a {
    public Activity activity;
    protected int fuA = 0;
    af handler = new af(Looper.getMainLooper());
    protected ProgressDialog iln = null;
    protected float kCe = 0.0f;
    protected String nRR = "";
    protected String nSE;
    protected String nTe = "";
    public String nVN = "";
    protected boolean nVO = false;
    public boolean nVP = false;
    protected Addr nVQ = null;
    protected d nVR;
    protected LocationInfo nVS = new LocationInfo((byte) 0);
    protected LocationInfo nVT = new LocationInfo((byte) 0);
    protected a nVU;
    protected boolean nVV = false;
    protected HashMap<String, c> nVW = new HashMap();
    protected b nVX;
    protected boolean nVY = false;
    protected ArrayList<String> nVZ = new ArrayList();
    protected boolean nWa = false;
    protected boolean nWb = false;
    protected com.tencent.mm.plugin.location.model.c nWc = null;
    protected com.tencent.mm.modelgeo.c nWd;
    public com.tencent.mm.modelgeo.b.a nWe = new 3(this);
    protected float nlE = 0.0f;
    DisplayMetrics nrR = null;
    protected int type = 0;
    int zoom;

    protected abstract String WW();

    protected abstract void aWq();

    abstract void aWr();

    public a(Activity activity) {
        this.activity = activity;
        this.nVX = b.ON();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onBackPressed() {
        this.activity.finish();
    }

    protected final void a(n nVar) {
        this.nVU.nTd.addLocationPin(nVar.nTc);
    }

    public void onCreate(Bundle bundle) {
        this.nWd = com.tencent.mm.modelgeo.c.OP();
        LocationInfo locationInfo = this.nVT;
        LocationInfo locationInfo2 = this.nVS;
        String d = w.d(ac.cft());
        x.d("MicroMsg.BaseMapUI", " initLanguage " + d);
        if (d.equals("language_default")) {
            w.a(this.activity, Locale.ENGLISH);
            d = "en";
        } else {
            w.a(this.activity, w.UX(d));
        }
        locationInfo2.nQA = d;
        locationInfo.nQA = d;
        x.d("MicroMsg.BaseMapUI", "sosomap " + this.nVS.nQA);
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(R.i.dlv);
        ((FrameLayout) findViewById(R.h.cuV)).addView(d.cY(this.activity));
        this.nVR = new d(this.activity);
        this.nVU = new a(this);
        this.nSE = this.activity.getIntent().getStringExtra("kRemark");
        this.nVZ = this.activity.getIntent().getStringArrayListExtra("kTags");
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        this.nVP = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
        x.i("MicroMsg.BaseMapUI", "isPickPoi " + this.nVP);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        x.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
        aWq();
        this.activity.finish();
        return true;
    }

    public void onResume() {
        com.tencent.mm.ui.base.ac.a(true, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onPause() {
        com.tencent.mm.ui.base.ac.a(false, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onDestroy() {
        this.nVX.a(this.nWe);
        x.d("MicroMsg.BaseMapUI", "destory");
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        System.gc();
    }

    public final String getString(int i) {
        return this.activity.getString(i);
    }

    protected final void aWn() {
        if (this.nVU.nWn != null && this.nVU.nWo != null) {
            this.nVU.nWn.setText(i.b(this.nVU.nWn.getContext(), this.nSE, this.nVU.nWn.getTextSize()));
            if (this.nVZ == null || this.nVZ.isEmpty()) {
                this.nVU.nWo.setText("");
                return;
            }
            CharSequence charSequence = (String) this.nVZ.get(0);
            String string = this.activity.getResources().getString(R.l.egK);
            int i = 1;
            while (i < this.nVZ.size()) {
                String str = charSequence + string + ((String) this.nVZ.get(i));
                i++;
                Object obj = str;
            }
            this.nVU.nWo.setText(i.b(this.nVU.nWo.getContext(), charSequence, this.nVU.nWo.getTextSize()));
        }
    }

    protected final void aWo() {
        this.nVU.nWh.removeAllViews();
        View inflate = View.inflate(this.activity, R.i.dmH, null);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.nVU.nWh.addView(inflate, layoutParams);
        this.nVU.nWn = (TextView) inflate.findViewById(R.h.ctY);
        this.nVU.nWn.setOnClickListener(new 1(this));
        this.nVU.nWo = (TextView) inflate.findViewById(R.h.cuc);
        this.nVU.nWo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a nWf;

            {
                this.nWf = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_fav_item_id", this.nWf.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("key_fav_result_list", this.nWf.activity.getIntent().getStringArrayListExtra("kTags"));
                com.tencent.mm.bm.d.b(this.nWf.activity, "favorite", ".ui.FavTagEditUI", intent, 4100);
            }
        });
        aWn();
    }

    protected final String aWp() {
        return bh.az(this.nSE, "");
    }

    protected final boolean c(LocationInfo locationInfo) {
        if (this.nVU.nTd.getIController() == null || !e.h(locationInfo.nQx, locationInfo.nQy)) {
            return false;
        }
        this.nVU.nTd.getIController().animateTo(locationInfo.nQx, locationInfo.nQy);
        return true;
    }

    public final View findViewById(int i) {
        return this.activity.findViewById(i);
    }

    protected final void initView() {
        x.d("MicroMsg.BaseMapUI", "initView");
        this.nVU.nTd = (com.tencent.mm.plugin.p.d) findViewById(R.h.cks);
        this.nVU.nWg = (FrameLayout) findViewById(R.h.bYV);
        this.nVU.nWh = (RelativeLayout) findViewById(R.h.cSa);
        this.nVU.nWi = findViewById(R.h.cSj);
        this.nVU.nWj = (ImageButton) findViewById(R.h.cSk);
        this.nVU.nWk = findViewById(R.h.cSl);
        this.nVU.nWl = (TextView) findViewById(R.h.bIK);
        this.nVU.titleView = (TextView) findViewById(R.h.cvZ);
        this.nVU.nWp = (TextView) findViewById(R.h.cxp);
        this.nVU.titleView.setText(WW());
        this.nVU.nTd.getIController().setZoom(d.gm(false));
        if (!(this.type == 0 || this.type == 3)) {
            this.nVU.nWj.setVisibility(0);
            this.nVU.nWk.setVisibility(8);
            this.nVU.nWj.setEnabled(false);
            this.nVU.nWj.setImageResource(R.g.bDI);
        }
        this.nVU.nTd.setBuiltInZoomControls(false);
        this.nVU.nWi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a nWf;

            {
                this.nWf = r1;
            }

            public final void onClick(View view) {
                this.nWf.aWq();
                this.nWf.aWs();
                this.nWf.activity.finish();
            }
        });
        this.nVU.nWl.setOnClickListener(new 5(this));
        aWr();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2) {
            if (Downloads.RECV_BUFFER_SIZE == i) {
                if (this.nVU.nWn != null) {
                    CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                    this.nSE = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                    aWn();
                }
            } else if (4100 == i && this.nVU.nWo != null) {
                this.nVZ = intent.getStringArrayListExtra("key_fav_result_list");
                aWn();
            }
        }
    }

    protected final void aWs() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    public boolean aWt() {
        return true;
    }
}
