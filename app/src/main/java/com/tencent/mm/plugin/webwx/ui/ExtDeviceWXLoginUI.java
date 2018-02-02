package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.plugin.webwx.a.c;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

@a(3)
public class ExtDeviceWXLoginUI extends MMActivity implements e {
    private boolean fAp = false;
    private String fGw = null;
    private int hNr = 0;
    private ProgressDialog nMb = null;
    private boolean tOA = false;
    private Button tOB;
    private TextView tOC;
    private boolean tOn = false;
    private String tOx = null;
    private int tOy;
    private int tOz;
    private int type = 0;

    static /* synthetic */ boolean a(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        final k cVar = new c(extDeviceWXLoginUI.fGw);
        ar.CG().a(cVar, 0);
        extDeviceWXLoginUI.nMb = h.a(extDeviceWXLoginUI.mController.xIM, extDeviceWXLoginUI.getString(R.l.ctB), true, new OnCancelListener(extDeviceWXLoginUI) {
            final /* synthetic */ ExtDeviceWXLoginUI tOD;

            public final void onCancel(DialogInterface dialogInterface) {
                ar.CG().c(cVar);
                if (this.tOD.nMb != null) {
                    this.tOD.nMb.cancel();
                }
            }
        });
        return true;
    }

    static /* synthetic */ boolean b(ExtDeviceWXLoginUI extDeviceWXLoginUI, boolean z) {
        k eVar = new com.tencent.mm.plugin.webwx.a.e(extDeviceWXLoginUI.fGw, extDeviceWXLoginUI.tOx, z);
        ar.CG().a(eVar, 0);
        extDeviceWXLoginUI.nMb = h.a(extDeviceWXLoginUI.mController.xIM, extDeviceWXLoginUI.getString(R.l.ctB), true, new 5(extDeviceWXLoginUI, eVar));
        return true;
    }

    static /* synthetic */ void d(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        int[] iArr = new int[2];
        View findViewById = extDeviceWXLoginUI.findViewById(R.h.cZb);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        x.i("MicroMsg.ExtDeviceWXLoginUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height)});
        extDeviceWXLoginUI.findViewById(R.h.cPp).setPadding(0, (((int) (((double) r1) / 4.0d)) - i) - height, 0, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        initView();
        overridePendingTransition(R.a.bqo, R.a.bpQ);
    }

    protected void onResume() {
        super.onResume();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void initView() {
        this.fGw = getIntent().getStringExtra("intent.key.login.url");
        this.type = getIntent().getIntExtra("intent.key.type", 0);
        CharSequence stringExtra = getIntent().getStringExtra("intent.key.title.string");
        this.hNr = getIntent().getIntExtra("intent.key.icon.type", 0);
        CharSequence stringExtra2 = getIntent().getStringExtra("intent.key.ok.string");
        CharSequence stringExtra3 = getIntent().getStringExtra("intent.key.cancel.string");
        CharSequence stringExtra4 = getIntent().getStringExtra("intent.key.content.string");
        this.tOx = getIntent().getStringExtra("intent.key.ok.session.list");
        this.tOy = getIntent().getIntExtra("intent.key.login.client.version", 0);
        this.tOz = getIntent().getIntExtra("intent.key.function.control", 0);
        x.i("MicroMsg.ExtDeviceWXLoginUI", "type:%s title:%s ok:%s content:%s", new Object[]{Integer.valueOf(this.type), stringExtra, stringExtra2, stringExtra4});
        setMMTitle("");
        if (!bh.ov(stringExtra)) {
            ((TextView) findViewById(R.h.cPt)).setText(stringExtra);
        }
        b joVar = new jo();
        com.tencent.mm.sdk.b.a.xef.m(joVar);
        int i = joVar.fAi.fAj;
        int i2 = joVar.fAi.fAk;
        int i3 = joVar.fAi.fAl;
        switch (this.hNr) {
            case 1:
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xtc, Integer.valueOf(3));
                break;
            case 2:
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xtc, Integer.valueOf(4));
                break;
            default:
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xtc, Integer.valueOf(0));
                break;
        }
        if (!bh.ov(stringExtra4)) {
            ((CheckBox) findViewById(R.h.cPn)).setVisibility(8);
            ((TextView) findViewById(R.h.cPm)).setVisibility(0);
            ((TextView) findViewById(R.h.cPm)).setText(stringExtra4);
        } else if (i >= 0) {
            boolean z = (this.tOz & 1) > 0;
            x.i("MicroMsg.ExtDeviceWXLoginUI", "msgsynchronize needCheckedSync[%b], iconType[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.hNr)});
            if (this.hNr == 1 && this.tOy >= i2) {
                this.tOn = true;
                ((TextView) findViewById(R.h.cPm)).setVisibility(8);
                ((CheckBox) findViewById(R.h.cPn)).setVisibility(0);
                ((CheckBox) findViewById(R.h.cPn)).setText(R.l.eXi);
                if (z) {
                    ar.Hg();
                }
                ((CheckBox) findViewById(R.h.cPn)).setChecked(false);
            } else if (this.hNr == 2 && this.tOy >= i3) {
                this.tOn = true;
                ((TextView) findViewById(R.h.cPm)).setVisibility(8);
                ((CheckBox) findViewById(R.h.cPn)).setVisibility(0);
                ((CheckBox) findViewById(R.h.cPn)).setText(R.l.eXh);
                if (z) {
                    ar.Hg();
                }
                ((CheckBox) findViewById(R.h.cPn)).setChecked(false);
            }
        }
        ImageView imageView = (ImageView) findViewById(R.h.cPp);
        if (this.hNr != 1) {
            if (this.hNr == 2) {
                imageView.setImageResource(R.k.dxV);
            } else if (this.hNr == 3) {
                imageView.setImageResource(R.k.dxU);
            } else if (this.hNr == 5) {
                imageView.setImageResource(R.k.dyb);
            }
            this.tOC = (TextView) findViewById(R.h.cZd);
            this.tOC.setText(stringExtra3);
            this.tOC.setOnClickListener(new 1(this));
            this.tOB = (Button) findViewById(R.h.cZa);
            if (bh.ov(stringExtra2)) {
                this.tOB.setText(stringExtra2);
                if (this.type == 0) {
                    this.tOB.setEnabled(true);
                } else if (this.type == -1) {
                    this.tOB.setEnabled(false);
                    if (this.hNr == 5) {
                        this.tOC.setVisibility(8);
                    }
                } else if (this.type == -2) {
                    this.tOB.setEnabled(true);
                }
            } else {
                this.tOB.setVisibility(4);
            }
            this.tOB.setOnClickListener(new 2(this));
            this.mController.contentView.post(new 3(this));
            ((TextView) findViewById(R.h.cZc)).setOnClickListener(new 4(this));
            ar.CG().a(972, this);
            ar.CG().a(973, this);
        }
        imageView.setImageResource(R.k.dxZ);
        this.tOC = (TextView) findViewById(R.h.cZd);
        this.tOC.setText(stringExtra3);
        this.tOC.setOnClickListener(new 1(this));
        this.tOB = (Button) findViewById(R.h.cZa);
        if (bh.ov(stringExtra2)) {
            this.tOB.setVisibility(4);
        } else {
            this.tOB.setText(stringExtra2);
            if (this.type == 0) {
                this.tOB.setEnabled(true);
            } else if (this.type == -1) {
                this.tOB.setEnabled(false);
                if (this.hNr == 5) {
                    this.tOC.setVisibility(8);
                }
            } else if (this.type == -2) {
                this.tOB.setEnabled(true);
            }
        }
        this.tOB.setOnClickListener(new 2(this));
        this.mController.contentView.post(new 3(this));
        ((TextView) findViewById(R.h.cZc)).setOnClickListener(new 4(this));
        ar.CG().a(972, this);
        ar.CG().a(973, this);
    }

    protected void onPause() {
        super.onPause();
        if (this.tOA && ar.Hj()) {
            com.tencent.mm.bq.a wlVar = new wl();
            wlVar.wgL = 27;
            wlVar.wgM = q.gL(q.FY()) ? 1 : 2;
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wlVar));
            this.tOA = false;
        }
    }

    protected final int getLayoutId() {
        return R.i.dft;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bqm);
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(972, this);
        ar.CG().b(973, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.nMb != null) {
            this.nMb.dismiss();
            this.nMb = null;
        }
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i2), Integer.valueOf(i)});
            ar.CG().b(972, this);
            if (kVar.getType() == 972) {
                com.tencent.mm.plugin.webwx.a.e eVar = (com.tencent.mm.plugin.webwx.a.e) kVar;
                if (eVar.tOn || this.fAp) {
                    ts tsVar = (ts) eVar.hFi.hmh.hmo;
                    byte[] toByteArray = (tsVar == null || tsVar.wbL == null) ? null : tsVar.wbL.toByteArray();
                    b jpVar = new jp();
                    jpVar.fAm.fAn = toByteArray;
                    jpVar.fAm.fAo = this.hNr;
                    jpVar.fAm.fAp = this.fAp;
                    com.tencent.mm.sdk.b.a.xef.m(jpVar);
                }
            } else {
                kVar.getType();
            }
            this.type = 0;
            finish();
            return;
        }
        if (i2 == -1) {
            this.type = -1;
        } else if (i2 == -2) {
            this.type = -2;
        }
        if (!bh.ov(str)) {
            ((CheckBox) findViewById(R.h.cPn)).setVisibility(8);
            ((TextView) findViewById(R.h.cPm)).setVisibility(0);
            ((TextView) findViewById(R.h.cPm)).setText(str);
        }
        if (this.type == -1) {
            if (this.tOB != null) {
                this.tOB.setEnabled(false);
            }
        } else if (this.type == -2) {
            if (this.tOB != null) {
                this.tOB.setEnabled(true);
                this.tOB.setText(R.l.eXj);
            }
            if (this.tOC != null) {
                this.tOC.setVisibility(4);
            }
        }
        x.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }
}
