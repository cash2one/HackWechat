package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import java.util.LinkedList;

public class SettingSnsBackgroundUI extends MMPreference {
    protected String filePath;
    private SharedPreferences gZO;
    private f ilB;

    public final int XB() {
        return m.qNj;
    }

    public void onCreate(Bundle bundle) {
        x.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
        super.onCreate(bundle);
        this.ilB = this.yjd;
        this.gZO = getSharedPreferences(ac.cfs(), 0);
        initView();
    }

    protected void onNewIntent(Intent intent) {
        x.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        setResult(-1);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        x.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
    }

    public void onResume() {
        super.onResume();
        if (this.ilB != null) {
            this.ilB.notifyDataSetChanged();
        }
    }

    private void b(int i, Intent intent) {
        String str;
        switch (i) {
            case 2:
                x.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
                this.filePath = k.b(getApplicationContext(), intent, ae.getAccSnsTmpPath());
                if (this.filePath != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_ImgPath", this.filePath);
                    str = "CropImage_OutputPath";
                    intent2.putExtra(str, ae.getAccSnsTmpPath() + g.s((this.filePath + System.currentTimeMillis()).getBytes()));
                    a.ifs.a((Activity) this, intent2, 6);
                    return;
                }
                return;
            case 5:
                x.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
                if (intent != null) {
                    this.filePath = k.b(getApplicationContext(), intent, ae.getAccSnsTmpPath());
                    if (this.filePath != null) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("CropImageMode", 1);
                        intent3.putExtra("CropImage_ImgPath", this.filePath);
                        a.ifs.a((Activity) this, intent, intent3, ae.getAccSnsTmpPath(), 6, new 1(this));
                        return;
                    }
                    return;
                }
                return;
            case 6:
                x.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
                new af(Looper.getMainLooper()).post(new 2(this));
                if (intent != null) {
                    this.filePath = intent.getStringExtra("CropImage_OutputPath");
                    if (this.filePath != null) {
                        x.d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
                        av bvr = ae.bvr();
                        String str2 = this.filePath;
                        new LinkedList().add(new h(str2, 2));
                        if (!(bvr.bvb() == null || bvr.bvb().equals(""))) {
                            str = am.r(ae.getAccSnsPath(), bvr.bvb());
                            FileOp.mh(str);
                            FileOp.deleteFile(str + bvr.bvb() + "bg_");
                            FileOp.x(str2, str + bvr.bvb() + "bg_");
                            l bvz = ae.bvz();
                            com.tencent.mm.plugin.sns.storage.k Lq = bvz.Lq(bvr.bvb());
                            Lq.field_bgId = "";
                            bvz.c(Lq);
                        }
                        bvr.bwd();
                        bvr.bvb();
                        aw awVar = new aw(7);
                        awVar.ee(str2, "");
                        awVar.wN(1);
                        awVar.commit();
                        setResult(-1);
                        finish();
                        return;
                    }
                    return;
                }
                return;
            default:
                x.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
                return;
        }
    }

    protected void onActivityResult(final int i, final int i2, final Intent intent) {
        x.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + i + " " + i2);
        if (i2 == -1) {
            StringBuilder stringBuilder = new StringBuilder("result ok ");
            com.tencent.mm.kernel.g.Dk();
            x.d("MicroMsg.SettingSnsBackgroundUI", stringBuilder.append(com.tencent.mm.kernel.g.Dh().Cy()).toString());
            if (ae.bve()) {
                new af(Looper.myLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ SettingSnsBackgroundUI rwG;

                    public final void run() {
                        this.rwG.b(i, intent);
                    }
                }, 2000);
                return;
            }
            x.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
            b(i, intent);
        } else if (i == 2 || i == 5 || i == 6) {
            new af(Looper.getMainLooper()).post(new 3(this));
        }
    }

    protected final void initView() {
        setMMTitle(j.qJP);
        SnsArtistPreference snsArtistPreference = (SnsArtistPreference) this.ilB.YN("settings_sns_bg_select_bg");
        if (snsArtistPreference != null) {
            String string = this.gZO.getString("artist_name", "");
            x.d("MicroMsg.SettingSnsBackgroundUI", "artistName" + string);
            snsArtistPreference.ryR = string;
            snsArtistPreference.bAu();
            this.ilB.notifyDataSetChanged();
        }
        setBackBtn(new 5(this));
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        x.i("MicroMsg.SettingSnsBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_sns_bg_select_from_album")) {
            com.tencent.mm.kernel.g.Dk();
            if (com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
                k.a(this, 5, null);
                return true;
            }
            u.fI(this);
            return false;
        } else if (str.equals("settings_sns_bg_take_photo")) {
            com.tencent.mm.kernel.g.Dk();
            if (com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
                x.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.mController.xIM, "android.permission.CAMERA", 16, "", "")), bh.cgy(), this.mController.xIM});
                if (!com.tencent.mm.pluginsdk.g.a.a(this.mController.xIM, "android.permission.CAMERA", 16, "", "")) {
                    return false;
                }
                arQ();
                return true;
            }
            u.fI(this);
            return false;
        } else if (!str.equals("settings_sns_bg_select_bg")) {
            return false;
        } else {
            startActivity(new Intent(this, ArtistUI.class));
            return true;
        }
    }

    private void arQ() {
        if (!k.c(this, e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(j.eJu), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            x.i("MicroMsg.SettingSnsBackgroundUI", "summerper onRequestPermissionsResult grantResults[%s] invalid", new Object[]{iArr});
            return;
        }
        x.i("MicroMsg.SettingSnsBackgroundUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    arQ();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(j.ezM), getString(j.ezT), getString(j.est), getString(j.dEn), false, new 6(this), null);
                    return;
                }
            default:
                return;
        }
    }
}
