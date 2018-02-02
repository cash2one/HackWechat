package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.f;
import com.tencent.mm.plugin.sns.a.b.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.z.q;
import java.util.List;

@a(3)
public class SnsBrowseUI extends SnsBaseGalleryUI implements t$a {
    private String fus;
    private int fwA = 0;
    private int kDP = 0;
    private int kDQ = 0;
    Bundle kRZ;
    private boolean kSa = false;
    g kSb;
    private int kSc = 0;
    private int kSd = 0;
    private int kSe = 0;
    private int kSf = 0;
    private af mHandler = new af();
    private ImageView mxv;
    private int rza = 0;
    private boolean rzb = false;
    private boolean rzc = false;
    private boolean rzd = false;
    private w rze;
    private int rzf;
    private int rzg;
    private int rzh = 0;
    private float rzi = 1.0f;
    private int rzj = 0;
    private int rzk = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        initView();
        this.kRZ = bundle;
    }

    public void onDestroy() {
        b iu;
        if (this.ryY != null) {
            int intExtra = getIntent().getIntExtra("K_ad_scene", -1);
            SnsInfoFlip snsInfoFlip = this.ryY;
            String str = this.fus;
            if (snsInfoFlip.qQH) {
                if (intExtra < 0) {
                    x.i("MicroMsg.SnsInfoFlip", "pass by scene " + intExtra);
                } else {
                    m Lm = ae.bvv().Lm(str);
                    if (Lm != null) {
                        if (snsInfoFlip.rCv >= 0) {
                            long longValue = snsInfoFlip.rBX.containsKey(Integer.valueOf(snsInfoFlip.rCv)) ? ((Long) snsInfoFlip.rBX.get(Integer.valueOf(snsInfoFlip.rCv))).longValue() : 0;
                            if (longValue > 0) {
                                long longValue2 = snsInfoFlip.rBY.containsKey(Integer.valueOf(snsInfoFlip.rCv)) ? ((Long) snsInfoFlip.rBY.get(Integer.valueOf(snsInfoFlip.rCv))).longValue() : 0;
                                longValue = bh.bA(longValue);
                                longValue2 += longValue;
                                snsInfoFlip.rBY.put(Integer.valueOf(snsInfoFlip.rCv), Long.valueOf(longValue2));
                                x.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + snsInfoFlip.rCv + " curtime " + longValue2 + " passtime " + longValue);
                            }
                        }
                        e byB = Lm.byB();
                        StringBuffer stringBuffer = new StringBuffer();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer.append("<desc>");
                        String str2 = "<item><id>%d</id><duration>%d</duration><count>%d</count></item>";
                        String str3 = "%d|%d|%d";
                        for (Integer num : snsInfoFlip.rBW.keySet()) {
                            int intValue = ((Integer) snsInfoFlip.rBW.get(num)).intValue();
                            int longValue3 = snsInfoFlip.rBY.containsKey(num) ? (int) (((Long) snsInfoFlip.rBY.get(num)).longValue() * 1) : 0;
                            stringBuffer.append(String.format(str2, new Object[]{num, Integer.valueOf(longValue3), Integer.valueOf(intValue)}));
                            stringBuffer2.append(String.format(str3, new Object[]{num, Integer.valueOf(longValue3), Integer.valueOf(intValue)}) + "&");
                        }
                        stringBuffer.append("</desc>");
                        str = stringBuffer2.toString();
                        str3 = str.endsWith("&") ? str.substring(0, str.length() - 1) : str;
                        if (Lm == null || !Lm.bwE()) {
                            i bvp = ae.bvp();
                            Object[] objArr = new Object[1];
                            objArr[0] = f.a(Lm.field_snsId, new Object[]{com.tencent.mm.plugin.sns.data.i.eq(Lm.field_snsId), Lm.byA(), Integer.valueOf(intExtra), Long.valueOf(snsInfoFlip.rCn), Long.valueOf(System.currentTimeMillis()), str3, Integer.valueOf(snsInfoFlip.getCount())});
                            bvp.h(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_WRITE_FAILED, objArr);
                        }
                        if (byB.bxR().rfi != 1) {
                            k cVar = new c(Lm.byz(), 6, intExtra, stringBuffer.toString(), Lm.byD(), Lm.bxW());
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Di().gPJ.a(cVar, 0);
                        }
                        iu = b.iu(729);
                        iu.mB(com.tencent.mm.plugin.sns.data.i.eq(Lm.field_snsId)).mB(Lm.byA()).ix(intExtra).mB(snsInfoFlip.rCn).mB(System.currentTimeMillis()).mB(str3).ix(snsInfoFlip.getCount());
                        iu.Sx();
                    }
                }
            }
        }
        iu = b.q(getIntent());
        if (iu != null) {
            this.ryY.rCw.size();
            iu.ix(this.ryY.getCount()).ix(this.ryY.bBa());
            iu.update();
            iu.Sx();
        }
        this.ryY.bAY();
        this.ryY.onDestroy();
        ae.bvs().K(this);
        if (this.rzb) {
            this.ryY.bBc();
        }
        if (this.rze != null) {
            this.rze.stop();
        }
        super.onDestroy();
    }

    protected void onPause() {
        if (this.ryY != null) {
            this.ryY.onPause();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.ryY != null) {
            this.ryY.aHq();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qHe;
    }

    public void onStart() {
        Bundle bundle = this.kRZ;
        if (!this.kSa) {
            this.kSa = true;
            if (VERSION.SDK_INT >= 12) {
                this.kSc = getIntent().getIntExtra("img_gallery_top", 0);
                this.kSd = getIntent().getIntExtra("img_gallery_left", 0);
                this.kSe = getIntent().getIntExtra("img_gallery_width", 0);
                this.kSf = getIntent().getIntExtra("img_gallery_height", 0);
                this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
                if (bundle == null) {
                    this.ryY.getViewTreeObserver().addOnPreDrawListener(new 3(this));
                }
            }
        }
        super.onStart();
        x.d("MicroMsg.SnsPopMediasUI", "onStart ");
    }

    public final void arJ() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
        setResult(-1, new Intent());
        avV();
        return true;
    }

    protected final void initView() {
        this.kSb = new g(this.mController.xIM);
        this.kSa = false;
        String az = bh.az(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.fus = bh.az(getIntent().getStringExtra("sns_gallery_localId"), "");
        this.rza = getIntent().getIntExtra("sns_gallery_position", 0);
        this.fwA = getIntent().getIntExtra("sns_position", 0);
        this.rzb = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
        this.rzc = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
        this.rzd = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
        m Lm = ae.bvv().Lm(this.fus);
        this.mxv = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.ckv);
        this.mxv.setLayerType(2, null);
        this.ryY = new SnsInfoFlip(this);
        this.ryY.setLayerType(2, null);
        this.ryY.rzb = this.rzb;
        this.ryY.rsA = true;
        List Ko = ai.Ko(this.fus);
        this.ryY.rBZ = true;
        this.ryY.rCb = true;
        this.ryY.xC(Lm.field_type);
        this.ryY.rzd = this.rzd;
        this.ryY.a(Ko, az, this.rza, this.ryT, this);
        SnsInfoFlip snsInfoFlip = this.ryY;
        an ciO = an.ciO();
        ciO.time = Lm.field_createTime;
        snsInfoFlip.qQS = ciO;
        addView(this.ryY);
        if (Lm != null && Lm.xl(32)) {
            this.ryY.qQH = true;
        }
        this.ryZ = (Button) findViewById(com.tencent.mm.plugin.sns.i.f.qCi);
        bnp bxV = Lm.bxV();
        at atVar = bxV != null ? bxV.qYu : null;
        ay ayVar = new ay();
        ag.a(this, ayVar, bxV.qYu);
        if (ayVar.rKy) {
            this.ryZ.setVisibility(0);
            this.ryZ.setText(ayVar.rKz);
            this.ryZ.setOnClickListener(new 2(this, atVar, bxV));
        } else {
            this.ryZ.setVisibility(8);
        }
        if (!com.tencent.mm.plugin.sns.lucky.a.m.h(Lm)) {
            x.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + Lm.field_userName + " " + Lm.field_snsId);
            finish();
        } else if (Lm.field_type == 21 && !Lm.field_userName.equals(q.FS())) {
            this.rze = new w(com.tencent.mm.compatible.util.e.bnD + "/Pictures/Screenshots/", new 1(this));
            this.rze.start();
        }
    }

    public final void avV() {
        int i = this.kSe;
        int i2 = this.kSf;
        int i3 = this.kSd;
        int i4 = this.kSc;
        if (!this.rzc) {
            com.tencent.mm.sdk.b.b glVar = new gl();
            glVar.fwy.fwB = this.ryY.rBU.getSelectedItemPosition();
            glVar.fwy.fwA = this.fwA;
            com.tencent.mm.sdk.b.a.xef.m(glVar);
            i = glVar.fwz.foN;
            i2 = glVar.fwz.foO;
            i3 = glVar.fwz.foL;
            i4 = glVar.fwz.foM;
        }
        this.rzf = this.ryY.getWidth();
        this.rzg = this.ryY.getHeight();
        ae.bvs();
        String C = com.tencent.mm.plugin.sns.model.g.C(this.ryY.bzo());
        if (C != null) {
            Options UL = d.UL(C);
            this.rzg = (int) (((float) UL.outHeight) * (((float) this.rzf) / ((float) UL.outWidth)));
            if (this.rzg > this.ryY.getHeight()) {
                if (((double) this.rzg) < ((double) this.ryY.getHeight()) * 2.5d) {
                    this.rzh = this.rzg - this.ryY.getHeight();
                    if (this.ryY.getCount() == 1) {
                        i2 = (i2 * this.ryY.getHeight()) / this.rzg;
                        this.rzh = 0;
                    }
                }
                this.rzg = this.ryY.getHeight();
            }
        }
        this.kSb.fg(this.rzf, this.rzg);
        this.kSb.r(i3, i4, i, i2);
        if (((double) this.rzi) != 1.0d) {
            this.kSb.zkM = 1.0f / this.rzi;
            if (!(this.rzj == 0 && this.rzk == 0)) {
                this.kSb.fh(((int) (((float) (this.ryY.getWidth() / 2)) * (1.0f - this.rzi))) + this.rzj, (int) (((float) ((this.ryY.getHeight() / 2) + this.rzk)) - (((float) (this.rzg / 2)) * this.rzi)));
            }
        }
        this.kSb.rpH = this.rzh;
        this.kSb.a(this.ryY, this.mxv, new 4(this), new 5(this));
    }

    public final void bAz() {
        Gallery gallery = this.ryY.rBU;
        if (gallery instanceof MMGestureGallery) {
            ((MMGestureGallery) gallery).zlj = new 6(this, gallery);
        }
    }

    public final void ch(String str, int i) {
        x.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(true), str});
        if (this.ryY != null) {
            this.ryY.aHq();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsPopMediasUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
        }
    }

    protected final int getForceOrientation() {
        return 2;
    }

    public final void ci(String str, int i) {
        this.rza = i;
    }
}
