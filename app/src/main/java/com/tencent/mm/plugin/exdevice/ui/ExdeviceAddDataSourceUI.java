package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e$b;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.g.a.e.a;
import com.tencent.mm.protocal.c.bej;
import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI extends MMActivity implements e, e$b {
    private ListView Fv;
    private final BroadcastReceiver jhN = new 4(this);
    private r jmO;
    private View lBB;
    private a lRC;
    private List<b> lRD;
    private TextView lRE;
    private TextView lRF;
    private TextView lRG;
    private RelativeLayout lRH;
    private LocationManager lRI;
    private boolean lRJ = false;
    private l lRK;

    protected final int getLayoutId() {
        return R.i.dgz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI lRL;

            {
                this.lRL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lRL.finish();
                return true;
            }
        });
        setMMTitle(R.l.ecp);
        if (!(!f.fM(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            this.lRJ = true;
        }
        this.lRD = new LinkedList();
        this.lRI = (LocationManager) this.mController.xIM.getSystemService("location");
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.location.MODE_CHANGED");
        this.mController.xIM.registerReceiver(this.jhN, intentFilter);
        ar.CG().a(536, this);
        ar.CG().a(1706, this);
        ad.aEv().a(this);
        if (!a.co(this.mController.xIM)) {
            x.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            pd(2);
        } else if (!a.arv()) {
            x.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
            pd(1);
        } else if (this.lRI == null || !this.lRJ || this.lRI.isProviderEnabled("gps")) {
            ad.aEv();
            com.tencent.mm.plugin.exdevice.model.e.aDX();
        } else {
            x.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
            pd(4);
        }
    }

    private void pd(int i) {
        switch (i) {
            case 1:
                this.lRH.setVisibility(8);
                this.lRF.setText(R.l.ecF);
                this.lRG.setText(R.l.ecu);
                return;
            case 2:
                this.lRH.setVisibility(8);
                this.lRF.setText(R.l.ecD);
                this.lRG.setText("");
                return;
            case 3:
                this.lRH.setVisibility(0);
                this.lBB.setVisibility(0);
                return;
            case 4:
                this.lRH.setVisibility(8);
                this.lRF.setText(R.l.ecF);
                this.lRG.setText(R.l.edg);
                return;
            default:
                return;
        }
    }

    protected final void initView() {
        this.Fv = (ListView) findViewById(R.h.ctf);
        View inflate = View.inflate(this, R.i.dgB, null);
        this.lRH = (RelativeLayout) findViewById(R.h.cJl);
        this.lBB = View.inflate(this, R.i.dgA, null);
        this.lRE = (TextView) findViewById(R.h.cIO);
        this.lRF = (TextView) findViewById(R.h.ceJ);
        this.lRG = (TextView) findViewById(R.h.ceK);
        String string = getString(R.l.edI);
        String string2 = getString(R.l.ecK);
        CharSequence spannableString = new SpannableString(string + string2);
        spannableString.setSpan(new ForegroundColorSpan(R.e.btd), string.length(), string.length() + string2.length(), 33);
        spannableString.setSpan(new ClickableSpan(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI lRL;

            {
                this.lRL = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.exdevice.model.f.V(this.lRL.mController.xIM, "https://hw.weixin.qq.com/steprank/step/connect-help.html");
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(false);
            }
        }, string.length(), string.length() + string2.length(), 33);
        this.lRE.setMovementMethod(LinkMovementMethod.getInstance());
        this.lRE.setText(spannableString);
        this.Fv.addHeaderView(inflate, null, false);
        this.Fv.addFooterView(this.lBB, null, false);
        this.lRC = new a();
        this.Fv.setAdapter(this.lRC);
        this.Fv.setOnItemClickListener(new 6(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.Dm().F(new Runnable(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI lRL;

            {
                this.lRL = r1;
            }

            public final void run() {
                x.d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
                com.tencent.mm.sdk.b.a.xef.m(new qx());
            }
        });
        ar.CG().b(536, this);
        ar.CG().b(1706, this);
        this.mController.xIM.unregisterReceiver(this.jhN);
        ad.aEv().b(this);
        ad.aEw().arf();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            x.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
        } else if (kVar.getType() == 536) {
            aER();
            this.lRK = null;
            gu aEd = ((l) kVar).aEd();
            if (i == 0 && i2 == 0) {
                Intent intent = new Intent();
                intent.putExtra("device_mac", b.zu(b.zv(aEd.vLS.vLs)));
                aj(b.zv(aEd.vLS.vLs), false);
                setResult(-1, intent);
                finish();
                return;
            }
            b zl = this.lRC.zl(b.zv(aEd.vLS.vLs));
            if (zl != null) {
                zl.lRS = c.lRT;
                aj(zl.mac, false);
            }
            x.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
        } else if (kVar.getType() == 1706) {
            bej aEg = ((t) kVar).aEg();
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[]{Long.valueOf(aEg.vLS.gfS)});
                if (0 == (aEg.vLS.gfS & 1)) {
                    return;
                }
                if (ad.aEk().co(aEg.vLR.ksX, aEg.vLR.vJA) != null) {
                    x.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[]{aEg.vLS.vLs});
                    return;
                }
                b bVar = new b((byte) 0);
                bVar.name = aEg.vLy.wsB == null ? "" : n.a(aEg.vLy.wsB);
                bVar.mac = b.zv(aEg.vLS.vLs);
                bVar.frP = aEg.vLx;
                bVar.iconUrl = aEg.vLS.nfT;
                this.lRD.add(bVar);
                x.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[]{bVar.mac, bVar.name});
                runOnUiThread(new 8(this));
                return;
            }
            x.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    public final void j(String str, String str2, boolean z) {
        x.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
        if (z) {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceAddDataSourceUI lRL;

                {
                    this.lRL = r1;
                }

                public final void run() {
                    this.lRL.lBB.setVisibility(8);
                    this.lRL.lRC.notifyDataSetChanged();
                }
            });
        }
        if (bh.ov(str2)) {
            x.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
            return;
        }
        int i = 0;
        while (i < this.lRD.size()) {
            int i2;
            b bVar = (b) this.lRD.get(i);
            if (bVar == null || bh.ov(bVar.mac)) {
                i2 = i - 1;
                this.lRD.remove(i);
            } else if (bVar.mac.equalsIgnoreCase(str2)) {
                x.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", new Object[]{str2});
                return;
            } else {
                i2 = i;
            }
            i = i2 + 1;
        }
        boolean a = ar.CG().a(new t(str2.replaceAll(":", ""), null, null), 0);
        x.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[]{Boolean.valueOf(a), str2});
    }

    public final void c(String str, int i, long j) {
        if (bh.ov(str)) {
            x.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
            return;
        }
        final b zl = this.lRC.zl(str);
        if (zl == null) {
            x.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[]{str});
            return;
        }
        if (zl.lRS == c.lRU && i == 4) {
            zl.lRS = c.lRT;
            aER();
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceAddDataSourceUI lRL;

                public final void run() {
                    h.a(this.lRL, R.l.ecN, R.l.ecL, R.l.ecM, R.l.ecO, false, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass10 lRQ;

                        {
                            this.lRQ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.lRQ.lRL.lRD.remove(zl);
                            this.lRQ.lRL.lRC.aD(this.lRQ.lRL.lRD);
                            this.lRQ.lRL.lRC.notifyDataSetChanged();
                        }
                    }, new 2(this)).show();
                }
            });
        } else if (i == 2) {
            if (zl.lRS == c.lRU) {
                zl.lRS = c.lRV;
                x.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[]{zl.mac, zl.name});
                if (zl.frP != null) {
                    this.lRK = new l(zl.frP, 0);
                    ar.CG().a(this.lRK, 0);
                }
            } else {
                x.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[]{str});
                aj(str, false);
            }
        } else if (i != 1 && i != 2) {
            zl.lRS = c.lRT;
        } else {
            return;
        }
        runOnUiThread(new 11(this));
    }

    public final void b(String str, byte[] bArr, boolean z) {
    }

    private static boolean aj(String str, boolean z) {
        com.tencent.mm.sdk.b.b efVar = new ef();
        efVar.fsS.mac = str;
        efVar.fsS.fro = z;
        if (com.tencent.mm.sdk.b.a.xef.m(efVar)) {
            return true;
        }
        x.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[]{str});
        return false;
    }

    private void aER() {
        runOnUiThread(new 2(this));
    }
}
