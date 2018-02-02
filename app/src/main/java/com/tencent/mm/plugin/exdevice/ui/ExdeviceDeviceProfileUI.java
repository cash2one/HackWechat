package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.bq;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.m;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class ExdeviceDeviceProfileUI extends MMPreference implements e {
    private String bpq;
    private r jmO;
    private String lLR;
    private String lLS;
    private long lNb;
    private String lRh;
    private String lRz;
    private String lSg;
    private String lSh;
    private int lTe;
    private r lTm = null;
    private String lUj;
    private String lUk;
    private boolean lUl;
    private String lUm;
    private boolean lUn;
    private String lUo;
    private b lUp;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(R.l.ecA);
        this.lUp = new 7(this);
        Intent intent = getIntent();
        this.bpq = intent.getStringExtra("device_mac");
        this.lNb = intent.getLongExtra("device_ble_simple_proto", 0);
        this.lUj = intent.getStringExtra("device_jump_url");
        this.lLR = intent.getStringExtra("device_brand_name");
        this.lLS = intent.getStringExtra("device_id");
        this.lRh = intent.getStringExtra("device_type");
        this.lSh = intent.getStringExtra("bind_ticket");
        this.lTe = intent.getIntExtra("subscribe_flag", 0);
        this.lUl = intent.getBooleanExtra("device_has_bound", false);
        this.lSg = intent.getStringExtra("device_title");
        this.lUk = intent.getStringExtra("device_alias");
        this.lRz = intent.getStringExtra("device_desc");
        this.lUm = intent.getStringExtra("device_icon_url");
        if (bh.ov(this.lLS) || bh.ov(this.lRh)) {
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", this.lLS, this.lRh);
        } else {
            bq co = ad.aEk().co(this.lLS, this.lRh);
            if (co != null) {
                this.lUl = true;
                if (bh.ov(this.lUk)) {
                    this.lUk = bh.ou(co.gfN);
                }
                if (bh.ov(this.lSg)) {
                    this.lSg = bh.ou(co.gfO);
                }
                if (bh.ov(this.lLR)) {
                    this.lLR = bh.ou(co.field_brandName);
                }
                if (bh.ov(this.lRz)) {
                    this.lRz = bh.ou(co.gfP);
                }
                if (bh.ov(this.lUm)) {
                    this.lUm = bh.ou(co.iconUrl);
                }
                if (bh.ov(this.lUj)) {
                    this.lUj = bh.ou(co.jumpUrl);
                }
                if (co.gfR == 2) {
                    this.lUn = true;
                    this.lUo = this.lSg;
                    for (com.tencent.mm.plugin.exdevice.h.b bVar : ad.aEk().aEP()) {
                        if (bVar.field_deviceType.equals(this.lRh)) {
                            String str = bVar.gfW;
                            if (str != null && str.length() > 0) {
                                String[] split = str.split(",");
                                for (String equals : split) {
                                    if (equals.equals(this.lLS)) {
                                        if (bh.ov(bVar.gfN)) {
                                            this.lUo = bVar.gfO;
                                        } else {
                                            this.lUo = bVar.gfN;
                                        }
                                        x.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", this.lUo);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            z = true;
        }
        if (z) {
            aEX();
            return;
        }
        Toast.makeText(this.mController.xIM, R.l.edh, 1).show();
        finish();
    }

    private void aEX() {
        String str;
        f fVar;
        boolean z;
        f fVar2 = this.yjd;
        DeviceProfileHeaderPreference deviceProfileHeaderPreference = (DeviceProfileHeaderPreference) fVar2.YN("device_profile_header");
        deviceProfileHeaderPreference.a(1, new 8(this));
        deviceProfileHeaderPreference.a(4, new 9(this));
        a(deviceProfileHeaderPreference);
        deviceProfileHeaderPreference.dJ(this.lUm);
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar2.YN("connect_setting");
        KeyValuePreference keyValuePreference2 = (KeyValuePreference) fVar2.YN("user_list");
        ((KeyValuePreference) fVar2.YN("message_manage")).mx(true);
        keyValuePreference.mx(true);
        keyValuePreference2.mx(true);
        fVar2.bk("message_manage", true);
        fVar2.bk("connect_setting", true);
        fVar2.bk("user_list", true);
        if (this.lUn) {
            fVar2.bk("sub_device_desc", false);
            fVar2.YN("sub_device_desc").setTitle(getResources().getString(R.l.edN, new Object[]{this.lUo}));
            fVar2.bk("bind_device", true);
            str = "unbind_device";
            fVar = fVar2;
            z = true;
        } else {
            fVar2.bk("sub_device_desc", true);
            fVar2.bk("bind_device", this.lUl);
            String str2 = "unbind_device";
            if (this.lUl) {
                str = str2;
                fVar = fVar2;
                z = false;
            } else {
                str = str2;
                fVar = fVar2;
                z = true;
            }
        }
        fVar.bk(str, z);
        if (bh.ov(this.lUj)) {
            fVar2.bk("open_device_panel", true);
        }
    }

    private void a(DeviceProfileHeaderPreference deviceProfileHeaderPreference) {
        CharSequence charSequence = bh.ov(this.lSg) ? this.lLR : this.lSg;
        if (bh.ov(this.lUk)) {
            deviceProfileHeaderPreference.setName(charSequence);
            deviceProfileHeaderPreference.zj("");
            deviceProfileHeaderPreference.B(3, false);
            deviceProfileHeaderPreference.B(4, false);
            deviceProfileHeaderPreference.B(1, this.lUl);
        } else {
            deviceProfileHeaderPreference.setName(this.lUk);
            deviceProfileHeaderPreference.zj(getString(R.l.eda, new Object[]{charSequence}));
            deviceProfileHeaderPreference.B(3, true);
            deviceProfileHeaderPreference.B(4, true);
            deviceProfileHeaderPreference.B(1, false);
        }
        charSequence = this.lRz;
        deviceProfileHeaderPreference.lRz = charSequence;
        if (deviceProfileHeaderPreference.lRw != null) {
            deviceProfileHeaderPreference.lRw.setText(charSequence);
        }
    }

    public final int XB() {
        return R.o.fbH;
    }

    public final boolean a(f fVar, Preference preference) {
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", preference.ibD);
        String str;
        k kVar;
        if ("bind_device".equals(preference.ibD)) {
            if (bh.ov(this.lSh)) {
                x.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
                k mVar = new m(com.tencent.mm.plugin.exdevice.j.b.zu(this.bpq), this.lLR, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, this.lNb);
                j(mVar);
                ar.CG().a(1262, (e) this);
                ar.CG().a(mVar, 0);
            } else {
                x.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
                str = this.lSh;
                int i = this.lTe;
                ar.CG().a(536, (e) this);
                com.tencent.mm.sdk.b.b ctVar = new ct();
                ctVar.fqX.fqZ = str;
                ctVar.fqX.opType = 1;
                ctVar.fqX.fra = i;
                a.xef.m(ctVar);
                kVar = ctVar.fqY.frb;
                getString(R.l.dGO);
                this.lTm = h.a(this, getString(R.l.ecC), true, new 10(this, kVar));
            }
        } else if ("unbind_device".equals(preference.ibD)) {
            ajr com_tencent_mm_protocal_c_ajr = new ajr();
            com_tencent_mm_protocal_c_ajr.ksX = this.lLS;
            com_tencent_mm_protocal_c_ajr.vJA = this.lRh;
            bq co = ad.aEk().co(this.lLS, this.lRh);
            if (co != null) {
                str = co.gfW;
                if (str != null && str.length() > 0) {
                    String[] split = str.split(",");
                    for (String cq : split) {
                        ad.aEk().cq(cq, this.lRh);
                    }
                }
            }
            kVar = new com.tencent.mm.plugin.exdevice.model.x(com_tencent_mm_protocal_c_ajr, 2);
            j(kVar);
            ar.CG().a(537, (e) this);
            ar.CG().a(kVar, 0);
        } else if ("open_device_panel".equals(preference.ibD)) {
            com.tencent.mm.plugin.exdevice.model.f.V(this.mController.xIM, this.lUj);
        } else if ("contact_info_biz_go_chatting".equals(preference.ibD)) {
            ar.Hg();
            af WO = c.EY().WO(this.lLR);
            Intent intent = new Intent();
            intent.putExtra("device_id", this.lLS);
            intent.putExtra("device_type", this.lRh);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", this.lSh);
            if (WO != null) {
                if (com.tencent.mm.l.a.fZ(WO.field_type) && WO.cia()) {
                    y.Mf().jK(WO.field_username);
                    intent.putExtra("Chat_User", this.lLR);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.exdevice.a.lJS.e(intent, this.mController.xIM);
                } else {
                    intent.putExtra("Contact_User", this.lLR);
                    intent.putExtra("force_get_contact", true);
                    d.b(this.mController.xIM, "profile", ".ui.ContactInfoUI", intent);
                }
            }
        } else if (!("message_manage".equals(preference.ibD) || "connect_setting".equals(preference.ibD) || "user_list".equals(preference.ibD))) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
            return;
        }
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", Integer.valueOf(kVar.getType()));
        if (kVar instanceof l) {
            aER();
            ar.CG().b(kVar.getType(), (e) this);
            if (i == 0 && i2 == 0) {
                aEZ();
                f(ad.aEk().co(this.lLS, this.lRh));
                runOnUiThread(new 11(this));
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType()));
            aEY();
        } else if (kVar instanceof m) {
            aER();
            ar.CG().b(kVar.getType(), (e) this);
            com.tencent.mm.plugin.exdevice.h.b cJ = ad.aEk().cJ(com.tencent.mm.plugin.exdevice.j.b.zu(this.bpq));
            if (i == 0 && i2 == 0 && cJ != null) {
                f(cJ);
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

                    {
                        this.lUq = r1;
                    }

                    public final void run() {
                        this.lUq.lUl = true;
                        this.lUq.aEX();
                        this.lUq.yjd.notifyDataSetChanged();
                    }
                });
                aEZ();
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType()));
            aEY();
        } else if (kVar instanceof com.tencent.mm.plugin.exdevice.model.y) {
            aER();
            ar.CG().b(1263, (e) this);
            if (i == 0 && i2 == 0) {
                this.lUk = ((com.tencent.mm.plugin.exdevice.model.y) kVar).gfN;
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

                    {
                        this.lUq = r1;
                    }

                    public final void run() {
                        this.lUq.a((DeviceProfileHeaderPreference) this.lUq.yjd.YN("device_profile_header"));
                    }
                });
                com.tencent.mm.sdk.e.c co = ad.aEk().co(this.lLS, this.lRh);
                if (co == null) {
                    x.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", this.lLS, this.lRh);
                    return;
                }
                co.cZ(this.lUk);
                ad.aEk().c(co, new String[0]);
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType()));
            Toast.makeText(this.mController.xIM, getString(R.l.ede), 1).show();
        } else if (kVar instanceof com.tencent.mm.plugin.exdevice.model.x) {
            aER();
            if (i == 0 && i2 == 0) {
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

                    {
                        this.lUq = r1;
                    }

                    public final void run() {
                        this.lUq.lUk = null;
                        this.lUq.lUl = false;
                        this.lUq.aEX();
                        this.lUq.yjd.notifyDataSetChanged();
                    }
                });
                finish();
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType()));
            runOnUiThread(new 6(this));
        }
    }

    private void f(com.tencent.mm.plugin.exdevice.h.b bVar) {
        if (bVar != null) {
            this.lLS = bVar.field_deviceID;
            this.lRh = bVar.field_deviceType;
            this.lUk = bh.ou(bVar.gfN);
            this.lSg = bh.ou(bVar.gfO);
            this.lLR = bh.ou(bVar.field_brandName);
            this.lRz = bh.ou(bVar.gfP);
            this.lUm = bh.ou(bVar.iconUrl);
            this.lUj = bh.ou(bVar.jumpUrl);
        }
    }

    private void aER() {
        runOnUiThread(new 2(this));
    }

    private void aEY() {
        runOnUiThread(new 3(this));
    }

    private void aEZ() {
        runOnUiThread(new 4(this));
    }

    private void j(k kVar) {
        runOnUiThread(new 5(this, kVar));
    }
}
