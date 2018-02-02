package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.g.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import junit.framework.Assert;

public class MassSendHistoryUI extends MMActivity implements a, b, SensorController.a {
    private static SensorController kCP;
    private com.tencent.mm.e.a.a fhH;
    private boolean kCS = true;
    private View nKI;
    private ListView onD;
    private c onE;
    private Button onF;
    private Button onG;
    private MMPullDownView onH;
    private boolean onI = false;
    private LinearLayout onJ;
    private d onK = new 4(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.euJ);
        if (kCP == null) {
            kCP = new SensorController(getApplicationContext());
        }
        initView();
        this.fhH = new com.tencent.mm.e.a.a(this);
        this.fhH.fjG = this;
        this.fhH.fjF = this;
        this.onE.ont = new 1(this);
        if (this.mController != null) {
            this.mController.ad(3, false);
        }
    }

    protected void onResume() {
        super.onResume();
        h.aYD().c(this.onE);
        this.onE.a(null, null);
        this.onD.setSelection(this.onE.getCount() - 1);
    }

    protected void onPause() {
        super.onPause();
        ar.Hh().xV();
        h.aYD().j(this.onE);
        kCP.cgf();
    }

    protected void onDestroy() {
        this.onE.aUn();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dmZ;
    }

    protected final void initView() {
        this.onI = getIntent().getBooleanExtra("finish_direct", false);
        x.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.onI);
        this.onJ = (LinearLayout) findViewById(R.h.cvq);
        this.onD = (ListView) findViewById(R.h.cva);
        this.onD.setTranscriptMode(0);
        this.onH = (MMPullDownView) findViewById(R.h.cvb);
        this.onH.ycp = new 5(this);
        this.onH.mp(true);
        this.onH.ycB = new 6(this);
        this.onH.ycC = new 7(this);
        this.onH.mn(true);
        this.onE = new c(this);
        this.onE.xIi = new 8(this);
        this.nKI = findViewById(R.h.cuZ);
        this.onD.setAdapter(this.onE);
        this.onD.setOnItemClickListener(new 9(this));
        this.onD.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MassSendHistoryUI onL;

            {
                this.onL = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                x.v("MicroMsg.MassSendHistoryUI", "onTouch");
                return false;
            }
        });
        this.onF = (Button) findViewById(R.h.cvp);
        this.onF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MassSendHistoryUI onL;

            {
                this.onL = r1;
            }

            public final void onClick(View view) {
                this.onL.startActivity(new Intent(this.onL, MassSendSelectContactUI.class));
            }
        });
        this.onG = (Button) findViewById(R.h.cvr);
        this.onG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MassSendHistoryUI onL;

            {
                this.onL = r1;
            }

            public final void onClick(View view) {
                this.onL.startActivity(new Intent(this.onL, MassSendSelectContactUI.class));
            }
        });
        setBackBtn(new 2(this));
        addIconOptionMenu(0, R.l.dGD, R.k.dvc, new 3(this));
        new l(this).a(this.onD, this, this.onK);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.onI) {
            finish();
        } else {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.plugin.masssend.a.ifs.s(intent, this);
            finish();
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        x.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        String[] split = ((com.tencent.mm.plugin.masssend.a.a) this.onE.getItem(adapterContextMenuInfo.position)).aYy().split(";");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : split) {
            ar.Hg();
            com.tencent.mm.storage.x WO = c.EY().WO(str);
            if (WO != null) {
                stringBuilder.append(WO.AQ() + ";");
            }
        }
        contextMenu.setHeaderTitle(stringBuilder.toString());
        contextMenu.add(adapterContextMenuInfo.position, 1, 0, getString(R.l.dRH));
    }

    protected final void releaseWakeLock() {
        this.onD.setKeepScreenOn(false);
    }

    public final void dT(boolean z) {
        if (this.fhH != null) {
            if (this.fhH.isPlaying()) {
                this.fhH.aM(z);
                ar.Hh().h(z, false);
                this.kCS = z;
                if (!z) {
                    if (Ej(this.onE.ons)) {
                        this.onE.Eh(this.onE.ons);
                        return;
                    } else {
                        this.onE.Eh("");
                        return;
                    }
                }
                return;
            }
            this.fhH.aM(true);
            ar.Hh().h(true, false);
            this.kCS = true;
        }
    }

    private boolean Ej(String str) {
        Assert.assertTrue(str != null);
        kCP.a(this);
        com.tencent.mm.plugin.masssend.a.a Ee = h.aYD().Ee(str);
        ar.Hg();
        if (c.isSDCardAvailable() || bh.ov(Ee.aYw())) {
            if (this.fhH == null) {
                this.fhH = new com.tencent.mm.e.a.a(this);
            }
            this.fhH.aL(false);
            if (this.fhH.k(Ee.aYw(), this.kCS)) {
                ar.Hh().h(this.kCS, false);
                this.fhH.fjG = this;
                this.fhH.fjF = this;
                return true;
            }
            Toast.makeText(this, getString(R.l.dSB), 0).show();
            return false;
        }
        u.fI(this);
        return false;
    }

    private void stopPlay() {
        kCP.cgf();
        this.fhH.aL(false);
        this.onE.Eh("");
        releaseWakeLock();
    }

    public final void vh() {
        stopPlay();
    }

    public final void onError() {
        stopPlay();
    }
}
