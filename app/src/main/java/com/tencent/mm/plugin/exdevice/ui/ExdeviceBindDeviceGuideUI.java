package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI extends MMActivity implements e {
    private ListView Fv;
    BroadcastReceiver jhN = new 4(this);
    private String lLR;
    private String lLS;
    private String lRA;
    private TextView lRF;
    private LocationManager lRI;
    private boolean lRJ = false;
    private a lRX;
    private Button lRY;
    private Button lRZ;
    private String lRh;
    private String lRz;
    private TextView lSa;
    private ScrollView lSb;
    private ImageView lSc;
    private TextView lSd;
    private String lSe;
    private String lSf;
    private String lSg;
    private String lSh;
    private long lSi;
    private ArrayList<String> lSj;
    private String lSk;
    private boolean lSl = false;
    private boolean lSm = false;
    private String mTitle;
    private String st;

    private static final class a extends BaseAdapter {
        private ArrayList<String> lSo;

        private static class a {
            TextView lSp;
            TextView lSq;
            View lSr;
            View lSs;

            private a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return kC(i);
        }

        public a(ArrayList<String> arrayList) {
            this.lSo = arrayList;
        }

        public final int getCount() {
            if (this.lSo != null) {
                return this.lSo.size();
            }
            return 0;
        }

        private String kC(int i) {
            if (this.lSo == null || this.lSo.size() <= 0) {
                return null;
            }
            return (String) this.lSo.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.lSo == null || this.lSo.size() <= 0) {
                return null;
            }
            a aVar;
            CharSequence kC = kC(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.dgC, null);
                aVar2.lSq = (TextView) view.findViewById(R.h.bYJ);
                aVar2.lSp = (TextView) view.findViewById(R.h.cPv);
                aVar2.lSr = view.findViewById(R.h.cSA);
                aVar2.lSs = view.findViewById(R.h.bOO);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.lSp.setText(Integer.toString(i + 1));
            aVar.lSq.setText(kC);
            if (i == 0 && this.lSo.size() == 1) {
                aVar.lSr.setVisibility(4);
                aVar.lSs.setVisibility(4);
                return view;
            } else if (i == 0) {
                aVar.lSr.setVisibility(4);
                aVar.lSs.setVisibility(0);
                return view;
            } else if (i != this.lSo.size() - 1) {
                return view;
            } else {
                aVar.lSs.setVisibility(4);
                aVar.lSr.setVisibility(0);
                return view;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dgD;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        if (!(!f.fM(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[]{VERSION.RELEASE});
            this.lRJ = true;
        }
        Intent intent = getIntent();
        this.lSe = intent.getStringExtra("device_scan_mode");
        this.lSf = intent.getStringExtra("device_scan_conn_proto");
        this.lLS = intent.getStringExtra("device_id");
        this.lRh = intent.getStringExtra("device_type");
        this.lSg = intent.getStringExtra("device_title");
        this.lRz = intent.getStringExtra("device_desc");
        this.lRA = intent.getStringExtra("device_icon_url");
        this.st = intent.getStringExtra("device_category_id");
        this.lLR = intent.getStringExtra("device_brand_name");
        this.lSh = intent.getStringExtra("bind_ticket");
        this.lSi = intent.getLongExtra("device_ble_simple_proto", -1);
        this.lSj = intent.getStringArrayListExtra("device_airkiss_steps");
        this.lSk = intent.getStringExtra("device_airkiss_key");
        this.mTitle = intent.getStringExtra("device_airkiss_title");
        x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[]{Integer.valueOf(this.lSj.size())});
        this.lRI = (LocationManager) this.mController.xIM.getSystemService("location");
        this.Fv = (ListView) findViewById(R.h.bYI);
        View inflate = View.inflate(this, R.i.dgx, null);
        this.lSa = (TextView) inflate.findViewById(R.h.cSg);
        this.lRX = new a(this.lSj);
        this.Fv.addHeaderView(inflate);
        this.Fv.setDividerHeight(0);
        this.Fv.setClickable(false);
        this.Fv.setFooterDividersEnabled(false);
        this.Fv.setAdapter(this.lRX);
        this.lSc = (ImageView) findViewById(R.h.cuw);
        this.lSb = (ScrollView) findViewById(R.h.coc);
        this.lRY = (Button) findViewById(R.h.bWY);
        this.lRZ = (Button) findViewById(R.h.cAf);
        this.lRF = (TextView) findViewById(R.h.ceJ);
        this.lSd = (TextView) findViewById(R.h.ceK);
        String str = "";
        if (this.lSe.compareTo("SCAN_CATALOG") != 0) {
            Assert.assertTrue(false);
        } else if (this.lSf.contains("wifi")) {
            this.lSl = true;
            str = this.mController.xIM.getString(R.l.dgI);
        } else if (this.lSf.contains("blue")) {
            this.lSm = true;
            str = this.mController.xIM.getString(R.l.ecx);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.lSm && !this.lSl) {
            if (!com.tencent.mm.plugin.g.a.e.a.co(this.mController.xIM)) {
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                pd(4);
            } else if (!com.tencent.mm.plugin.g.a.e.a.arv()) {
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
                pd(3);
            } else if (!(this.lRI == null || !this.lRJ || this.lRI.isProviderEnabled("gps"))) {
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
                pd(6);
            }
            this.lRY.setOnClickListener(new 2(this));
            this.lRZ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ExdeviceBindDeviceGuideUI lSn;

                {
                    this.lSn = r1;
                }

                public final void onClick(View view) {
                    if (this.lSn.lSl && !this.lSn.lSm) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", this.lSn.lSe);
                        intent.putExtra("device_scan_conn_proto", this.lSn.lSf);
                        intent.putExtra("device_id", this.lSn.lLS);
                        intent.putExtra("device_type", this.lSn.lRh);
                        intent.putExtra("device_title", this.lSn.lSg);
                        intent.putExtra("device_desc", this.lSn.lRz);
                        intent.putExtra("device_icon_url", this.lSn.lRA);
                        intent.putExtra("device_category_id", this.lSn.st);
                        intent.putExtra("device_brand_name", this.lSn.lLR);
                        intent.putExtra("bind_ticket", this.lSn.lSh);
                        d.b(this.lSn.mController.xIM, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                }
            });
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.xIM.registerReceiver(this.jhN, intentFilter);
        }
        if (!this.lSm && this.lSl && !an.isWifi(this.mController.xIM)) {
            x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
            pd(5);
            this.lRY.setOnClickListener(new 2(this));
            this.lRZ.setOnClickListener(/* anonymous class already generated */);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter2.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter2.addAction("android.location.MODE_CHANGED");
            this.mController.xIM.registerReceiver(this.jhN, intentFilter2);
        } else if (!this.lSl || this.lSm) {
            if (this.lSm && !this.lSl) {
                pd(2);
            }
            this.lRY.setOnClickListener(new 2(this));
            this.lRZ.setOnClickListener(/* anonymous class already generated */);
            IntentFilter intentFilter22 = new IntentFilter();
            intentFilter22.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter22.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter22.addAction("android.location.MODE_CHANGED");
            this.mController.xIM.registerReceiver(this.jhN, intentFilter22);
        } else {
            pd(1);
            this.lRY.setOnClickListener(new 2(this));
            this.lRZ.setOnClickListener(/* anonymous class already generated */);
            IntentFilter intentFilter222 = new IntentFilter();
            intentFilter222.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter222.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter222.addAction("android.location.MODE_CHANGED");
            this.mController.xIM.registerReceiver(this.jhN, intentFilter222);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mController.xIM.unregisterReceiver(this.jhN);
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    private void pd(int i) {
        switch (i) {
            case 1:
                this.lRY.setText(this.mController.xIM.getString(R.l.dgI));
                this.lRZ.setText(this.mController.xIM.getString(R.l.ect));
                this.lSa.setText(this.mController.xIM.getString(R.l.ecP));
                break;
            case 2:
                this.lRY.setText(this.mController.xIM.getString(R.l.ecJ));
                this.lRZ.setVisibility(8);
                this.lSa.setText(this.mController.xIM.getString(R.l.ecI));
                break;
            case 3:
                this.lSc.setImageResource(R.k.dwj);
                this.lRF.setText(R.l.ecF);
                this.lSd.setText(R.l.ecu);
                break;
            case 4:
                this.lSc.setImageResource(R.k.dwj);
                this.lRF.setText(R.l.ecD);
                this.lSd.setText("");
                break;
            case 5:
                this.lSc.setImageResource(R.k.dBL);
                this.lRF.setText(R.l.ecF);
                this.lSd.setText(R.l.ecB);
                break;
            case 6:
                this.lSc.setImageResource(R.k.dwj);
                this.lRF.setText(R.l.ecF);
                this.lSd.setText(R.l.edg);
                break;
        }
        switch (i) {
            case 1:
            case 2:
                this.lSc.setVisibility(8);
                this.lRF.setVisibility(8);
                this.lSd.setVisibility(8);
                this.Fv.setVisibility(0);
                this.lSb.setVisibility(0);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.lSc.setVisibility(0);
                this.lRF.setVisibility(0);
                this.Fv.setVisibility(8);
                this.lSb.setVisibility(8);
                if (i == 4) {
                    this.lSd.setVisibility(8);
                    return;
                } else {
                    this.lSd.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }
}
