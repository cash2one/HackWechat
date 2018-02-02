package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.exdevice.model.p;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.bej;
import com.tencent.mm.protocal.c.bfk;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import junit.framework.Assert;
import org.json.JSONObject;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI extends MMActivity implements e, b {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExdeviceBindDeviceUI.class.desiredAssertionStatus());
    private ListView Fv;
    private ProgressDialog iln;
    private ScrollView jjn;
    private TextView kTr;
    private String lLR;
    private a lME;
    private TextView lRF;
    private TextView lRG;
    private String lRh;
    private String lSA;
    private boolean lSB = false;
    private a lSC;
    private boolean lSD = false;
    private boolean lSE = false;
    private a lSt;
    private View lSu;
    private TextView lSv;
    private ImageView lSw;
    private View lSx;
    private int lSy;
    private String lSz;

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, int i, int i2, String str, k kVar) {
        if (kVar instanceof p) {
            if (exdeviceBindDeviceUI.iln != null && exdeviceBindDeviceUI.iln.isShowing()) {
                exdeviceBindDeviceUI.iln.dismiss();
            }
            exdeviceBindDeviceUI.lSB = false;
            p pVar = (p) kVar;
            if (!(i == 0 && i2 == 0)) {
                x.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneGetHardDeviceHelpUrl onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            }
            exdeviceBindDeviceUI.lSA = ((acr) pVar.gJQ.hmh.hmo).wlo;
            String str2 = exdeviceBindDeviceUI.lSA;
            if (bh.ov(str2)) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "Jump to webview failed, url is null or nil.");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            d.b(exdeviceBindDeviceUI, "webview", ".ui.tools.WebViewUI", intent);
        } else if (kVar instanceof t) {
            bej aEg = ((t) kVar).aEg();
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            } else if (aEg.vLS == null) {
                x.e("MicroMsg.ExdeviceBindDeviceUI", "HardDeviceAttr is null");
            } else {
                r1 = exdeviceBindDeviceUI.lSt.zn(aEg.vLS.vLs);
                if (r1 == null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                } else if (r1.lTc != null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                } else {
                    r1.lTd = aEg.vLS;
                    r1.lTc = aEg.vLR;
                    r1.lSh = aEg.vLx;
                    r1.lTf = aEg.vLy;
                    exdeviceBindDeviceUI.lSt.b(r1);
                    exdeviceBindDeviceUI.lSt.notifyDataSetChanged();
                    x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), mac(%s), isEnterMainDevice(%d).", new Object[]{aEg.vLR.vJA, aEg.vLR.ksX, aEg.vLS.wqQ, aEg.vLS.vLs, Integer.valueOf(aEg.vLS.gfR)});
                }
            }
        } else if (!(kVar instanceof v)) {
        } else {
            if (i == 0 && i2 == 0) {
                bfk com_tencent_mm_protocal_c_bfk = (bfk) ((v) kVar).gJQ.hmh.hmo;
                if (com_tencent_mm_protocal_c_bfk.vLR == null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "HardDevice info is null");
                    return;
                }
                a aVar = exdeviceBindDeviceUI.lSt;
                String str3 = com_tencent_mm_protocal_c_bfk.vLR.vJA;
                String str4 = com_tencent_mm_protocal_c_bfk.vLR.ksX;
                if (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) {
                    r1 = null;
                } else {
                    int cr = aVar.cr(str3, str4);
                    r1 = cr < 0 ? null : (f) aVar.lSM.get(cr);
                }
                if (r1 == null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                    return;
                } else if (r1.lTc != null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                    return;
                } else {
                    r1.lTd = com_tencent_mm_protocal_c_bfk.vLS;
                    r1.lTc = com_tencent_mm_protocal_c_bfk.vLR;
                    r1.lSh = com_tencent_mm_protocal_c_bfk.vLx;
                    r1.lTf = com_tencent_mm_protocal_c_bfk.vLy;
                    exdeviceBindDeviceUI.lSt.b(r1);
                    exdeviceBindDeviceUI.lSt.notifyDataSetChanged();
                    x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), isEnterMainDevice(%d).", new Object[]{com_tencent_mm_protocal_c_bfk.vLR.vJA, com_tencent_mm_protocal_c_bfk.vLR.ksX, com_tencent_mm_protocal_c_bfk.vLS.wqQ, Integer.valueOf(com_tencent_mm_protocal_c_bfk.vLS.gfR)});
                    return;
                }
            }
            x.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        Intent intent = new Intent(exdeviceBindDeviceUI, ExdeviceDeviceProfileUI.class);
        ajs com_tencent_mm_protocal_c_ajs = fVar.lTd;
        intent.putExtra("device_mac", com_tencent_mm_protocal_c_ajs.vLs);
        intent.putExtra("device_brand_name", com_tencent_mm_protocal_c_ajs.wqJ);
        intent.putExtra("device_desc", com_tencent_mm_protocal_c_ajs.wqR);
        intent.putExtra("device_title", com_tencent_mm_protocal_c_ajs.wqQ);
        intent.putExtra("device_icon_url", com_tencent_mm_protocal_c_ajs.nfT);
        intent.putExtra("device_alias", com_tencent_mm_protocal_c_ajs.hvy);
        intent.putExtra("device_jump_url", com_tencent_mm_protocal_c_ajs.nfg);
        intent.putExtra("bind_ticket", fVar.lSh);
        intent.putExtra("device_type", fVar.lTc.vJA);
        intent.putExtra("device_id", fVar.lTc.ksX);
        intent.putExtra("hide_device_panel", true);
        intent.putExtra("subscribe_flag", fVar.lTe);
        if (fVar.lSZ == b.lSR) {
            intent.putExtra("device_ble_simple_proto", com_tencent_mm_protocal_c_ajs.gfS);
        } else if (fVar.lSZ != b.lSQ) {
            Assert.assertTrue(false);
            return;
        }
        exdeviceBindDeviceUI.startActivityForResult(intent, 0);
    }

    static /* synthetic */ void b(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "Device == null");
        } else if (fVar.lTf == null) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "Device.contact == null");
        } else {
            arp com_tencent_mm_protocal_c_arp = fVar.lTf;
            ar.Hg();
            af WO = c.EY().WO(n.a(com_tencent_mm_protocal_c_arp.vYI));
            Intent intent = new Intent();
            intent.putExtra("device_id", fVar.lTc.ksX);
            intent.putExtra("device_type", fVar.lTc.vJA);
            intent.putExtra("Contact_User", n.a(com_tencent_mm_protocal_c_arp.vYI));
            intent.putExtra("Contact_Scene", com_tencent_mm_protocal_c_arp.vXX);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", fVar.lSh);
            if (WO != null) {
                if (!com.tencent.mm.l.a.fZ(WO.field_type)) {
                    intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_arp.hvy);
                    intent.putExtra("Contact_Nick", com_tencent_mm_protocal_c_arp.wsB.toString());
                    intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_arp.hvw);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(com_tencent_mm_protocal_c_arp.hvC, com_tencent_mm_protocal_c_arp.hvu, com_tencent_mm_protocal_c_arp.hvv));
                    intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_arp.hvt);
                    intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_arp.wvg);
                    intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_arp.wvf);
                    intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_arp.wvj);
                    intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_arp.wvh);
                    intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_arp.wvi);
                    if (com_tencent_mm_protocal_c_arp.wvm != null) {
                        try {
                            intent.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_arp.wvm.toByteArray());
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        }
                    }
                }
                d.b(exdeviceBindDeviceUI.mController.xIM, "profile", ".ui.ContactInfoUI", intent);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dgF;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceBindDeviceUI lSF;

            {
                this.lSF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lSF.finish();
                return true;
            }
        });
        Intent intent = getIntent();
        this.lSz = intent.getStringExtra("device_category_id");
        this.lLR = intent.getStringExtra("device_brand_name");
        this.lRh = intent.getStringExtra("device_type");
        if (this.lRh == null || this.lRh.length() == 0) {
            this.lRh = this.lLR;
        }
        String stringExtra = intent.getStringExtra("device_scan_conn_proto");
        String stringExtra2 = intent.getStringExtra("device_scan_mode");
        String str = "";
        String stringExtra3 = intent.getStringExtra("device_title");
        if (bh.ov(stringExtra3)) {
            stringExtra3 = this.mController.xIM.getString(R.l.ecZ);
        }
        if (stringExtra2.contains("SCAN_MY_DEVICE")) {
            this.lSy = e.lSV;
            str = this.mController.xIM.getString(R.l.ecq);
        } else if (stringExtra2.compareTo("SCAN_CATALOG") == 0) {
            this.lSy = e.lSW;
            str = this.mController.xIM.getString(R.l.eco);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.lSy == e.lSW) {
            this.lSD = stringExtra.contains("wifi");
            this.lSE = stringExtra.contains("blue");
            x.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[]{Boolean.valueOf(this.lSD), Boolean.valueOf(this.lSE)});
        } else if (this.lSy == e.lSV) {
            this.lSE = true;
            this.lSD = true;
        }
        this.lME = new a(this) {
            final /* synthetic */ ExdeviceBindDeviceUI lSF;

            {
                this.lSF = r1;
            }

            public final void e(int i, Object... objArr) {
                String string;
                Throwable e;
                if (i == 10 && objArr != null) {
                    String str;
                    String string2;
                    try {
                        JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                        string = jSONObject2.getString("deviceType");
                        try {
                            string2 = jSONObject2.getString("deviceId");
                        } catch (Exception e2) {
                            e = e2;
                            string2 = null;
                            x.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                            x.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                            str = null;
                            if (string != null) {
                            }
                        }
                        try {
                            if (!jSONObject.isNull("manufacturerData")) {
                                str = jSONObject.getString("manufacturerData");
                                if (string != null && string2 != null) {
                                    f fVar = new f(this.lSF, (byte) 0);
                                    fVar.lSZ = b.lSQ;
                                    fVar.lTb = new d(this.lSF, (byte) 0);
                                    fVar.lTb.lRh = string;
                                    fVar.lTb.lLS = string2;
                                    if (bh.ov(str)) {
                                        fVar.lTg = null;
                                    } else {
                                        fVar.lTg = Base64.encodeToString(str.getBytes(), 2);
                                        x.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[]{fVar.lTg});
                                    }
                                    ag.y(new 1(this, fVar));
                                    return;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            x.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                            x.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                            str = null;
                            if (string != null) {
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        string2 = null;
                        string = null;
                        x.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        x.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                        str = null;
                        if (string != null) {
                        }
                    }
                    str = null;
                    if (string != null) {
                    }
                }
            }
        };
        this.lSC = new 4(this);
        initView();
        this.kTr.setText(this.mController.xIM.getString(R.l.edJ, new Object[]{stringExtra3}));
        ar.CG().a(1264, this);
        ar.CG().a(1706, this);
        ar.CG().a(1270, this);
        ar.CG().a(1719, this);
        if (this.lSE) {
            ad.aEv().a(this);
        }
        if (this.lSD) {
            j.aEb().a(10, this.lME);
            j.aEb().a(11, this.lSC);
            Java2CExDevice.initWCLanDeviceLib();
        }
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
        if (this.lSE) {
            ad.aEv();
            com.tencent.mm.plugin.exdevice.model.e.aDX();
        }
        if (this.lSD) {
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
        }
        this.lSt.aES();
        this.lSt.notifyDataSetChanged();
    }

    protected final void initView() {
        this.Fv = (ListView) findViewById(R.h.ctf);
        View inflate = View.inflate(this, R.i.dgH, null);
        this.lSx = View.inflate(this, R.i.dhj, null);
        this.lSu = this.lSx.findViewById(R.h.cKg);
        this.kTr = (TextView) this.lSx.findViewById(R.h.cRZ);
        this.lSv = (TextView) findViewById(R.h.cIO);
        this.lSw = (ImageView) findViewById(R.h.cuw);
        this.lRF = (TextView) findViewById(R.h.ceJ);
        this.lRG = (TextView) findViewById(R.h.ceK);
        this.jjn = (ScrollView) findViewById(R.h.cbs);
        this.Fv.addHeaderView(inflate, null, false);
        this.Fv.addFooterView(this.lSx, null, false);
        this.lSt = new a(this.lLR, this.lSy, this.lSz);
        this.Fv.setAdapter(this.lSt);
        this.Fv.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ExdeviceBindDeviceUI lSF;

            {
                this.lSF = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                f pf = this.lSF.lSt.pf(i - ((ListView) adapterView).getHeaderViewsCount());
                if (pf.lTd.gfR != 0) {
                    ExdeviceBindDeviceUI.a(this.lSF, pf);
                } else {
                    ExdeviceBindDeviceUI.b(this.lSF, pf);
                }
            }
        });
        if (this.lSE && !this.lSD) {
            if (!com.tencent.mm.plugin.g.a.e.a.co(this.mController.xIM)) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                pd(4);
                return;
            } else if (!com.tencent.mm.plugin.g.a.e.a.arv()) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
                pd(3);
                return;
            }
        }
        if (!this.lSE && this.lSD && !an.isWifi(this.mController.xIM)) {
            x.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
            pd(5);
        } else if (this.lSy == e.lSV) {
            pd(0);
        } else if (this.lSy != e.lSW) {
            int i = e.lSU;
            Assert.assertTrue(false);
        } else if (this.lSE && this.lSD) {
            Assert.assertTrue(false);
            pd(1);
        } else if (this.lSE) {
            pd(2);
        } else if (this.lSD) {
            pd(1);
        }
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
        if (this.lSD) {
            Java2CExDevice.stopScanWCLanDevice();
        }
        if (this.lSE) {
            ad.aEw().arf();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lSD) {
            ar.Dm().F(new 6(this));
            j.aEb().b(10, this.lME);
            j.aEb().b(11, this.lSC);
        }
        if (this.lSE) {
            ad.aEv().b(this);
            ad.aEw().arf();
        }
        ar.CG().b(1264, this);
        ar.CG().b(1706, this);
        ar.CG().b(1270, this);
        ar.CG().b(1719, this);
    }

    public final void j(String str, String str2, boolean z) {
        x.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bh.ov(str2)) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
            return;
        }
        f fVar = new f(this, (byte) 0);
        fVar.lSZ = b.lSR;
        fVar.lTa = new c(this, (byte) 0);
        fVar.lTa.lST = str;
        fVar.lTa.bpq = com.tencent.mm.plugin.exdevice.j.b.cL(com.tencent.mm.plugin.exdevice.j.b.zu(str2));
        ag.y(new 7(this, fVar));
    }

    public final void c(String str, int i, long j) {
    }

    public final void b(String str, byte[] bArr, boolean z) {
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
        } else {
            ag.y(new 8(this, i, i2, str, kVar));
        }
    }

    final void a(f fVar) {
        if (!this.lSt.zm(fVar.getKey())) {
            x.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + fVar.aET());
            a aVar = this.lSt;
            if (!(fVar == null || aVar.zm(fVar.getKey()))) {
                fVar.lSY = aVar.c(fVar);
                aVar.lSM.add(fVar);
            }
            this.lSt.notifyDataSetChanged();
            if (fVar.lSZ == b.lSR) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[]{fVar.lTa.bpq, this.lLR, this.lSz});
                ar.CG().a(new t(fVar.lTa.bpq, this.lLR, this.lSz), 0);
            } else if (fVar.lSZ == b.lSQ) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[]{fVar.lTb.lRh, fVar.lTb.lLS});
                ar.CG().a(new v(fVar.lTb.lRh, fVar.lTb.lLS, fVar.lTg), 0);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.lSt.aES();
        this.lSt.notifyDataSetChanged();
    }

    private void pd(int i) {
        String string;
        String string2;
        CharSequence spannableString;
        switch (i) {
            case 0:
                string = getString(R.l.ecw);
                CharSequence spannableString2 = new SpannableString(string);
                spannableString2.setSpan(new ForegroundColorSpan(R.e.btd), 0, string.length(), 33);
                spannableString2.setSpan(new 9(this), 0, string.length(), 33);
                this.lSv.setMovementMethod(LinkMovementMethod.getInstance());
                this.lSv.setText(spannableString2);
                break;
            case 1:
                string = getString(R.l.ecz);
                string2 = getString(R.l.dgI);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(R.e.btd), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new ClickableSpan(this) {
                    final /* synthetic */ ExdeviceBindDeviceUI lSF;

                    {
                        this.lSF = r1;
                    }

                    public final void onClick(View view) {
                        this.lSF.finish();
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.lSv.setMovementMethod(LinkMovementMethod.getInstance());
                this.lSv.setText(spannableString);
                break;
            case 2:
                string = getString(R.l.ecy);
                string2 = getString(R.l.ecx);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(R.e.btd), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new 10(this), string.length(), string.length() + string2.length(), 33);
                this.lSv.setMovementMethod(LinkMovementMethod.getInstance());
                this.lSv.setText(spannableString);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.lSw.setImageResource(R.k.dwj);
                this.lRF.setText(R.l.ecF);
                this.lRG.setText(R.l.ecu);
                break;
            case 4:
                this.lSw.setImageResource(R.k.dwj);
                this.lRF.setText(R.l.ecD);
                this.lRG.setText("");
                break;
            case 5:
                this.lSw.setImageResource(R.k.dBL);
                this.lRF.setText(R.l.ecF);
                this.lRG.setText(R.l.ecB);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                this.lSu.setVisibility(0);
                this.Fv.setVisibility(0);
                this.lSv.setVisibility(0);
                this.lSw.setVisibility(8);
                this.lRF.setVisibility(8);
                this.lRG.setVisibility(8);
                return;
            case 3:
            case 4:
            case 5:
                this.jjn.setVisibility(8);
                this.lSu.setVisibility(8);
                this.Fv.setVisibility(8);
                this.lSv.setVisibility(8);
                this.lSw.setVisibility(0);
                this.lRF.setVisibility(0);
                if (i == 4) {
                    this.lRG.setVisibility(8);
                    return;
                } else {
                    this.lRG.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }
}
