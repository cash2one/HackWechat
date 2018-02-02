package com.tencent.mm.plugin.bottle.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class BottleWizardStep1 extends MMActivity {
    private ImageView kCp = null;

    static /* synthetic */ boolean a(BottleWizardStep1 bottleWizardStep1) {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            h.a((Context) bottleWizardStep1, "", bottleWizardStep1.getResources().getStringArray(R.c.bqN), "", new 4(bottleWizardStep1));
            return true;
        }
        u.fI(bottleWizardStep1);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void arP() {
        Bitmap a;
        Bitmap a2 = b.a(x.WD(q.FS()), false, -1);
        if (a2 == null) {
            a = b.a(q.FS(), false, -1);
        } else {
            a = a2;
        }
        this.kCp = (ImageView) findViewById(R.h.cpi);
        if (a != null) {
            this.kCp.setImageBitmap(a);
        }
    }

    protected void onResume() {
        super.onResume();
        initView();
        arP();
    }

    protected final int getLayoutId() {
        return R.i.dbA;
    }

    protected final void initView() {
        setMMTitle(R.l.dMD);
        ((LinearLayout) findViewById(R.h.cpj)).setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
        addTextOptionMenu(0, getString(R.l.dFQ), new 3(this));
    }

    private void arQ() {
        if (!k.c(this, e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(R.l.eJu), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BottleWizardStep1", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    arQ();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezM), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 5(this), null);
                    return;
                }
            default:
                return;
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
                        intent2.putExtra("CropImage_ImgPath", b);
                        StringBuilder stringBuilder = new StringBuilder();
                        n.Jz();
                        intent2.putExtra("CropImage_OutputPath", stringBuilder.append(d.x(x.WD(q.FS()), true)).append(".crop").toString());
                        a.ifs.a(intent2, 4, this, intent);
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
                    a.ifs.a((Activity) this, intent2, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    b = intent.getStringExtra("CropImage_OutputPath");
                    if (b == null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BottleWizardStep1", "crop picture failed");
                        return;
                    } else {
                        new p(this.mController.xIM, b).c(2, new 6(this));
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
