package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.safedevice.a.b;
import com.tencent.mm.plugin.safedevice.a.c;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI extends MMPreference implements e, a {
    private af handler = new 4(this);
    private f ilB;
    private ProgressDialog iln = null;
    private int pRu = -2;
    private List<SafeDeviceListPreference> pRv;
    private a pRw;
    private boolean pRx = true;
    private List<c> pRy;
    private OnMenuItemClickListener pRz = new 1(this);

    static /* synthetic */ void a(MySafeDeviceListUI mySafeDeviceListUI) {
        if (mySafeDeviceListUI.pRv != null && mySafeDeviceListUI.pRv.size() > 0) {
            mySafeDeviceListUI.pRu ^= -1;
            for (SafeDeviceListPreference vC : mySafeDeviceListUI.pRv) {
                vC.vC(mySafeDeviceListUI.pRu);
            }
            mySafeDeviceListUI.ilB.notifyDataSetChanged();
        }
        if (mySafeDeviceListUI.pRu == 1) {
            mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(R.l.dFl), mySafeDeviceListUI.pRz);
        } else {
            mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(R.l.eGN), mySafeDeviceListUI.pRz);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(HardCoderJNI.SCENE_QUIT_CHATTING, this);
        ar.CG().a(361, this);
        com.tencent.mm.plugin.safedevice.a.f.bos().c(this);
        initView();
        k rVar = new r(q.FS());
        ar.CG().a(rVar, 0);
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.dHc), true, new 3(this, rVar));
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(HardCoderJNI.SCENE_QUIT_CHATTING, this);
        ar.CG().b(361, this);
        com.tencent.mm.plugin.safedevice.a.f.bos().j(this);
    }

    protected void onResume() {
        super.onResume();
        this.pRx = q.Ga();
        hE(this.pRx);
    }

    public final int XB() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (bh.ov(str)) {
            x.e("MicroMsg.MySafeDeviceListUI", "null key");
            return false;
        }
        if (str.equals("safe_device_verify_check")) {
            boolean isChecked = ((CheckBoxPreference) preference).isChecked();
            if (!isChecked) {
                h.b(this, R.l.eGJ, R.l.eGI, new 5(this, isChecked), new OnClickListener(this) {
                    final /* synthetic */ MySafeDeviceListUI pRA;

                    {
                        this.pRA = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.pRA.hE(this.pRA.pRx);
                        if (this.pRA.pRu == 1) {
                            for (SafeDeviceListPreference vC : this.pRA.pRv) {
                                vC.vC(this.pRA.pRu);
                            }
                            this.pRA.handler.sendEmptyMessage(0);
                        }
                    }
                });
            } else if (!this.pRx) {
                ar.Hg();
                if (((Integer) com.tencent.mm.z.c.CU().get(64, Integer.valueOf(-1))).intValue() != 1) {
                    h.b(this, R.l.eHa, R.l.eHb, new 7(this), new 8(this));
                } else {
                    this.pRx = isChecked;
                    hE(this.pRx);
                    com.tencent.mm.plugin.safedevice.a.e.x(true, true);
                }
            }
        } else if (str.startsWith("mysafedevice_")) {
            SafeDeviceListPreference safeDeviceListPreference = (SafeDeviceListPreference) preference;
            if (safeDeviceListPreference != null) {
                c cVar = safeDeviceListPreference.pRF;
                h.a(this.mController.xIM, getString(R.l.eGP), cVar.field_name, getString(R.l.eGS), -1, new 9(this, cVar));
            }
        }
        return true;
    }

    protected final void initView() {
        setBackBtn(new 10(this));
        this.ilB = this.yjd;
        this.pRv = new LinkedList();
        this.pRw = new a(this, (byte) 0);
        addTextOptionMenu(0, getString(R.l.eGN), this.pRz);
        setMMTitle(R.l.eGA);
    }

    private void hE(boolean z) {
        this.pRv.clear();
        this.pRy = com.tencent.mm.plugin.safedevice.a.f.bos().bop();
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fcb);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("safe_device_verify_check");
        if (checkBoxPreference != null) {
            checkBoxPreference.tSw = z;
        }
        if (this.pRy.size() == 0) {
            this.ilB.YO("my_safe_device_list_tip");
            showOptionMenu(false);
            return;
        }
        if (this.pRu == 1) {
            addTextOptionMenu(0, getString(R.l.eGN), this.pRz);
            this.pRu ^= -1;
        }
        for (c cVar : this.pRy) {
            Preference safeDeviceListPreference = new SafeDeviceListPreference(this);
            safeDeviceListPreference.setKey("mysafedevice_" + cVar.field_uid);
            safeDeviceListPreference.setTitle(i.a(this, cVar.field_name));
            if (!com.tencent.mm.sdk.platformtools.f.xeD) {
                safeDeviceListPreference.setSummary(cVar.field_devicetype);
            }
            safeDeviceListPreference.pRH = this.pRw;
            safeDeviceListPreference.pRI = this.pRw;
            safeDeviceListPreference.pRF = cVar;
            this.ilB.a(safeDeviceListPreference, -1);
            this.pRv.add(safeDeviceListPreference);
        }
        showOptionMenu(true);
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.MySafeDeviceListUI", "notify " + str);
        this.handler.post(new 2(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (kVar.getType() == HardCoderJNI.SCENE_QUIT_CHATTING) {
            if (i == 0 && i2 == 0) {
                this.pRx = q.Ga();
                hE(this.pRx);
            } else if (!com.tencent.mm.plugin.c.a.ift.a((Context) this, i, i2, str)) {
                Toast.makeText(this, getString(R.l.eGQ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        } else if (kVar.getType() != 361) {
        } else {
            if (i == 0 && i2 == 0) {
                b bVar = (b) kVar;
                com.tencent.mm.sdk.e.c cVar = new c();
                cVar.field_devicetype = bVar.frg;
                cVar.field_name = bVar.deviceName;
                cVar.field_uid = bVar.ffq;
                cVar.field_createtime = 0;
                com.tencent.mm.plugin.safedevice.a.f.bos().c(cVar, new String[0]);
                h.bu(this, com.tencent.mm.bv.a.ac(this, R.l.eGT));
            } else if (!com.tencent.mm.plugin.c.a.ift.a((Context) this, i, i2, str)) {
            }
        }
    }
}
