package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.preference.HeadImgNewPreference;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.io.File;

public class SettingsPersonalInfoUI extends MMPreference implements e, b {
    private f ilB;
    private boolean kmx;
    private com.tencent.mm.plugin.setting.modelsimple.f qkn;

    public final int XB() {
        return R.o.fcs;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        if (getIntent().getBooleanExtra("intent_set_avatar", false)) {
            this.kmx = getIntent().getBooleanExtra("KEnterFromBanner", false);
            a.ift.d(this);
        }
        ar.CG().a(1191, this);
    }

    public void onDestroy() {
        x.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
        if (ar.Hj()) {
            ar.Hg();
            c.CU().b(this);
        }
        if (this.qkn != null) {
            ar.CG().c(this.qkn);
        }
        ar.CG().b(1191, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eMj);
        ar.Hg();
        c.CU().a(this);
        this.ilB = this.yjd;
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPersonalInfoUI qko;

            {
                this.qko = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qko.aWs();
                this.qko.finish();
                return true;
            }
        });
    }

    public void onResume() {
        bqC();
        arP();
        ar.Hg();
        String str = (String) c.CU().get(4, null);
        if (str != null && str.length() > 0) {
            this.ilB.YN("settings_name").setSummary(i.a(this, str));
        }
        this.ilB.bk("settings_address", bh.PT());
        ar.Hg();
        if (bh.c(Boolean.valueOf(c.CU().getBoolean(w.a.xus, false)))) {
            this.ilB.bk("settings_invoice", false);
        } else {
            this.ilB.bk("settings_invoice", true);
            this.qkn = new com.tencent.mm.plugin.setting.modelsimple.f();
            ar.CG().a(this.qkn, 0);
        }
        super.onResume();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        x.d("MicroMsg.SettingsPersonalInfoUI", "key = " + str);
        if (str.equals("settings_change_avatar")) {
            return a.ift.d(this);
        }
        if (str.equals("settings_username")) {
            if (!bh.ov(q.FT()) || !com.tencent.mm.storage.x.WC(q.FS())) {
                return true;
            }
            G(SettingsAliasUI.class);
            return true;
        } else if (str.equals("settings_name")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsModifyNameUI.class);
            startActivity(intent);
            return true;
        } else {
            if (str.equals("settings_qrcode")) {
                g.pQN.h(11264, new Object[]{Integer.valueOf(2)});
                this.mController.xIM.startActivity(new Intent(this, SelfQRCodeUI.class));
            } else if (str.equals("settings_more_info")) {
                startActivity(new Intent(this, SettingsPersonalMoreUI.class));
            } else if (str.equals("settings_address")) {
                r2 = new Intent();
                r2.putExtra("launch_from_webview", false);
                d.a(this.mController.xIM, "address", ".ui.WalletSelectAddrUI", r2, true);
                return true;
            } else if (str.equals("settings_invoice")) {
                g.pQN.h(14199, new Object[]{Integer.valueOf(1)});
                r2 = new Intent();
                r2.putExtra("launch_from_webview", false);
                d.a(this.mController.xIM, "address", ".ui.InvoiceListUI", r2, true);
                return true;
            }
            return false;
        }
    }

    private void bqC() {
        Preference YN = this.ilB.YN("settings_username");
        CharSequence FT = q.FT();
        CharSequence FS = q.FS();
        if (!bh.ov(FT)) {
            YN.setSummary(FT);
        } else if (com.tencent.mm.storage.x.WB(FS)) {
            YN.setSummary(getString(R.l.eMh));
        } else {
            YN.setSummary(FS);
        }
    }

    private void arP() {
        HeadImgNewPreference headImgNewPreference = (HeadImgNewPreference) this.ilB.YN("settings_change_avatar");
        String FS = q.FS();
        headImgNewPreference.vto = null;
        if (headImgNewPreference.jMv != null) {
            com.tencent.mm.pluginsdk.ui.a.b.a(headImgNewPreference.jMv, FS);
        } else {
            headImgNewPreference.vto = FS;
        }
        if (FS == null) {
            headImgNewPreference.vtp = false;
        } else {
            headImgNewPreference.vtp = true;
        }
        headImgNewPreference.tZZ = new OnClickListener(this) {
            final /* synthetic */ SettingsPersonalInfoUI qko;

            {
                this.qko = r1;
            }

            public final void onClick(View view) {
                this.qko.mController.xIM.startActivity(new Intent(this.qko, PreviewHdHeadImg.class));
            }
        };
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            String b;
            switch (i) {
                case 2:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_Filter", true);
                        n.Jz();
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.ad.d.x(q.FS() + ".crop", true));
                        intent2.putExtra("CropImage_ImgPath", null);
                        com.tencent.mm.pluginsdk.n nVar = com.tencent.mm.plugin.setting.a.ifs;
                        ar.Hg();
                        nVar.a((Activity) this, intent, intent2, c.Fi(), 4, null);
                        return;
                    }
                    return;
                case 3:
                    Context applicationContext = getApplicationContext();
                    ar.Hg();
                    b = k.b(applicationContext, intent, c.Fi());
                    if (b != null) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("CropImageMode", 1);
                        intent3.putExtra("CropImage_OutputPath", b);
                        intent3.putExtra("CropImage_ImgPath", b);
                        com.tencent.mm.plugin.setting.a.ifs.a((Activity) this, intent3, 4);
                        return;
                    }
                    return;
                case 4:
                    new af(Looper.getMainLooper()).post(new 4(this));
                    if (intent != null) {
                        b = intent.getStringExtra("CropImage_OutputPath");
                        if (b == null) {
                            x.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
                            return;
                        }
                        x.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", new Object[]{b, Long.valueOf(new File(b).length())});
                        new p(this.mController.xIM, b).c(1, new Runnable(this) {
                            final /* synthetic */ SettingsPersonalInfoUI qko;

                            {
                                this.qko = r1;
                            }

                            public final void run() {
                                x.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[]{Boolean.valueOf(ar.Hj()), q.FS()});
                                if (ar.Hj()) {
                                    aq.hfP.hM(com.tencent.mm.ad.b.iW(q.FS()));
                                }
                                this.qko.arP();
                                if (this.qko.kmx) {
                                    g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(4), Integer.valueOf(4)});
                                }
                            }
                        });
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 3 || i == 2 || i == 4) {
            new af(Looper.getMainLooper()).post(new 3(this));
        }
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(bh.o(obj, 0)), mVar});
        ar.Hg();
        if (mVar != c.CU() || r0 <= 0) {
            x.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(r0), mVar});
            return;
        }
        bqC();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        ar.Hg();
        if (bh.c(Boolean.valueOf(c.CU().getBoolean(w.a.xus, false)))) {
            this.ilB.bk("settings_invoice", false);
        } else {
            this.ilB.bk("settings_invoice", true);
        }
    }
}
