package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.ay.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.preference.HeadImgPreference;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.Map.Entry;

public class BottlePersonalInfoUI extends MMPreference implements a {
    private SharedPreferences gZO;
    private f ilB;
    private c kCl;
    private HashMap<Integer, Integer> kCm = new HashMap();
    private int status;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n.Jz().d(this);
        initView();
    }

    public void onDestroy() {
        com.tencent.mm.plugin.bottle.a.ift.um();
        n.Jz().e(this);
        super.onDestroy();
    }

    protected final void initView() {
        boolean z = true;
        setMMTitle(R.l.eNt);
        this.ilB = this.yjd;
        this.ilB.addPreferencesFromResource(R.o.fbk);
        this.gZO = this.gZO;
        this.status = q.FW();
        if (getIntent().getBooleanExtra("is_allow_set", true)) {
            this.kCl = new c(this, this.ilB);
        } else {
            f fVar = this.ilB;
            fVar.YO("settings_sex");
            fVar.YO("settings_district");
            fVar.YO("settings_signature");
            fVar.YO("bottle_settings_change_avatar_alert");
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("bottle_settings_show_at_main");
        if ((this.status & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            z = false;
        }
        checkBoxPreference.tSw = z;
        setBackBtn(new 1(this));
    }

    public void onResume() {
        HeadImgPreference headImgPreference = (HeadImgPreference) this.ilB.YN("bottle_settings_change_avatar");
        Bitmap a = b.a(x.WD(q.FS()), false, -1);
        if (a == null) {
            a = b.a(q.FS(), false, -1);
        }
        if (a != null) {
            headImgPreference.O(a);
        }
        headImgPreference.tZZ = new 3(this);
        if (this.kCl != null) {
            this.kCl.update();
        }
        super.onResume();
    }

    public void onPause() {
        c.arM();
        ar.Hg();
        c.CU().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.kCm.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            ar.Hg();
            c.EX().b(new g(intValue, intValue2));
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch  " + intValue + " " + intValue2);
        }
        this.kCm.clear();
        super.onPause();
    }

    public final int XB() {
        return R.o.fbj;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        String str = preference.ibD;
        if (str.equals("bottle_settings_change_avatar")) {
            ar.Hg();
            if (c.isSDCardAvailable()) {
                k.a(this, 2, null);
                return true;
            }
            u.fI(this);
            return false;
        } else if (str.equals("settings_district")) {
            return this.kCl.arO();
        } else {
            if (str.equals("settings_signature")) {
                return this.kCl.arN();
            }
            if (str.equals("bottle_settings_show_at_main")) {
                boolean z = this.gZO.getBoolean("bottle_settings_show_at_main", true);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BottleSettignsPersonalInfoUI", "switch change : open = " + z + " item value = 32768 functionId = 14");
                if (z) {
                    this.status |= WXMediaMessage.THUMB_LENGTH_LIMIT;
                } else {
                    this.status &= -32769;
                }
                if (z) {
                    i = 1;
                }
                this.kCm.put(Integer.valueOf(14), Integer.valueOf(i));
                return true;
            } else if (!str.equals("bottle_settings_clear_data")) {
                return false;
            } else {
                h.a(this.mController.xIM, this.mController.xIM.getString(R.l.dUG), "", this.mController.xIM.getString(R.l.dEo), this.mController.xIM.getString(R.l.dEn), new 2(this), null);
                return true;
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Context applicationContext;
        String b;
        Intent intent2;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    ar.Hg();
                    b = k.b(applicationContext, intent, c.Fi());
                    if (b != null) {
                        intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        n.Jz();
                        intent2.putExtra("CropImage_OutputPath", d.x(x.WD(q.FS()), true));
                        intent2.putExtra("CropImage_ImgPath", b);
                        com.tencent.mm.plugin.bottle.a.ifs.a(intent2, 4, this, intent);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                ar.Hg();
                b = k.b(applicationContext, intent, c.Fi());
                if (b != null) {
                    intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_OutputPath", b);
                    intent2.putExtra("CropImage_ImgPath", b);
                    com.tencent.mm.plugin.bottle.a.ifs.a(this, intent2, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    b = intent.getStringExtra("CropImage_OutputPath");
                    if (b == null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BottleSettignsPersonalInfoUI", "crop picture failed");
                        return;
                    } else {
                        new p(this.mController.xIM, b).c(2, null);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void jh(String str) {
        if (str != null && str.equals(x.WD(q.FS()))) {
            Bitmap decodeResource;
            Bitmap a = b.a(str, false, -1);
            if (a == null) {
                a = b.a(q.FS(), false, -1);
            }
            if (a == null) {
                decodeResource = BitmapFactory.decodeResource(getResources(), R.g.bBB);
            } else {
                decodeResource = a;
            }
            ((HeadImgPreference) this.ilB.YN("bottle_settings_change_avatar")).O(decodeResource);
        }
    }
}
