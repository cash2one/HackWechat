package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.p;
import org.xwalk.core.R$styleable;

public class IPCallContactUI extends MMActivity {
    private af hae = new af(this, Looper.getMainLooper()) {
        final /* synthetic */ IPCallContactUI nIW;

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (this.nIW.nIK != null) {
                    this.nIW.nIK.dismiss();
                }
                this.nIW.nIM.setVisibility(0);
                this.nIW.nIL;
                c.nGG = b.aUe();
                this.nIW.nIL.Xy();
                this.nIW.nIL.notifyDataSetChanged();
                this.nIW.nIv.invalidateViews();
                this.nIW.nIO.rx(this.nIW.nIL.getCount());
                a.aSN().Wa();
            } else if (message.what == 2) {
                if (this.nIW.nIL.getCount() == 0) {
                    this.nIW.nIQ.setVisibility(0);
                } else {
                    this.nIW.nIQ.setVisibility(8);
                }
                if (this.nIW.nIL.getCount() != 0 && this.nIW.nIV) {
                    this.nIW.nIL.notifyDataSetChanged();
                }
            }
        }
    };
    private String ilo;
    private p lcZ = new p(true, true);
    private Runnable nIC = new 8(this);
    private ProgressDialog nIK = null;
    private c nIL;
    private RelativeLayout nIM;
    private LinearLayout nIN;
    private IPCallAddressCountView nIO = null;
    private VerticalScrollBar nIP;
    private LinearLayout nIQ;
    private int nIR = -1;
    private int nIS = -1;
    private com.tencent.mm.plugin.ipcall.a.a.a nIT = new 7(this);
    private Runnable nIU = new 10(this);
    private boolean nIV = true;
    private ListView nIv;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eqt);
        setBackBtn(new 1(this));
        x.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bh.cgy()});
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            this.nIM = (RelativeLayout) findViewById(R.h.layout);
            this.nIN = (LinearLayout) findViewById(R.h.bJq);
            this.nIv = (ListView) findViewById(R.h.bJd);
            this.nIP = (VerticalScrollBar) findViewById(R.h.bJn);
            this.nIQ = (LinearLayout) findViewById(R.h.bJp);
            this.lcZ.zms = new 5(this);
            this.lcZ.zmx = R.l.dGz;
            a(this.lcZ);
            this.nIL = new c(this.mController.xIM);
            c.nGG = b.aUe();
            this.nIO = new IPCallAddressCountView(this.mController.xIM, this.nIL.aUm());
            this.nIv.addFooterView(this.nIO, null, false);
            this.nIv.setAdapter(this.nIL);
            this.nIv.setOnItemClickListener(new 6(this));
            this.nIP.setVisibility(0);
            this.nIv.setOnScrollListener(new 11(this));
            this.nIP.yhE = new VerticalScrollBar.a(this) {
                final /* synthetic */ IPCallContactUI nIW;

                {
                    this.nIW = r1;
                }

                public final void xh(String str) {
                    if ("↑".equals(str)) {
                        this.nIW.nIv.setSelection(0);
                        return;
                    }
                    int intValue;
                    c d = this.nIW.nIL;
                    if (d.ldT.containsKey(str)) {
                        intValue = ((Integer) d.ldT.get(str)).intValue();
                    } else {
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        this.nIW.nIv.setSelection(intValue);
                    }
                }
            };
            if (this.nIL.aUm() <= 0) {
                this.nIM.setVisibility(8);
                Context context = this.mController.xIM;
                this.mController.xIM.getString(R.l.dGO);
                this.nIK = h.a(context, this.mController.xIM.getString(R.l.eqH), true, new 9(this));
                e.post(this.nIC, "IPCall_LoadSystemAddressBook");
                return;
            }
            a.aSN().Wa();
        }
    }

    public final void CN(String str) {
        this.ilo = str;
        this.hae.removeCallbacks(this.nIU);
        this.hae.postDelayed(this.nIU, 200);
    }

    public final void gd(boolean z) {
        this.nIV = z;
        if (this.nIV) {
            this.nIL.notifyDataSetChanged();
        }
    }

    protected final int getLayoutId() {
        return R.i.dlW;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.ipcall.a.a aTi = com.tencent.mm.plugin.ipcall.a.a.aTi();
        com.tencent.mm.plugin.ipcall.a.a.a aVar = this.nIT;
        if (aTi.nCl.contains(aVar)) {
            aTi.nCl.remove(aVar);
        }
        this.hae.removeMessages(1);
    }

    protected void onResume() {
        super.onResume();
        supportInvalidateOptionsMenu();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.IPCallContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] != 0) {
                    h.a(this, getString(R.l.ezO), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 3(this), new OnClickListener(this) {
                        final /* synthetic */ IPCallContactUI nIW;

                        {
                            this.nIW = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.nIW.finish();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
