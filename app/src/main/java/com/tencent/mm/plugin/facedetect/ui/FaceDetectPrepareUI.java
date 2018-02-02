package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.plugin.facedetect.b.p;
import com.tencent.mm.plugin.facedetect.c.b;
import com.tencent.mm.plugin.facedetect.c.e;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.ui.b.1;
import com.tencent.mm.plugin.facedetect.ui.b.2;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import java.security.InvalidParameterException;
import java.util.ArrayList;

@a(3)
public class FaceDetectPrepareUI extends MMFragmentActivity implements android.support.v4.app.a.a, e {
    private String gAb;
    private boolean hnr = false;
    private boolean joQ = false;
    private String mAppId;
    private int meK;
    private d meL = null;
    private long mgb;
    private com.tencent.mm.plugin.facedetect.c.a mjA = null;
    private a mjB = null;
    private b mjC = null;
    private boolean mjD;
    private byte[] mjE;
    private boolean mjF = false;
    private boolean mjG = false;
    private b mjH;
    private boolean mjI = false;
    private boolean mjJ = false;
    private String mjK = null;
    private long mjL = -1;
    private Messenger mjM = null;
    private a mjN = null;
    private int mjO = -1;
    private boolean mjP = false;

    static /* synthetic */ void a(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onInitDone result: %d", new Object[]{Integer.valueOf(message.arg1)});
        if (message.arg1 != 0) {
            faceDetectPrepareUI.agh();
            return;
        }
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo start FaceDetectUI");
        faceDetectPrepareUI.mjO = 2;
        Intent intent = new Intent(faceDetectPrepareUI, FaceDetectUI.class);
        intent.putExtra("k_user_name", faceDetectPrepareUI.gAb);
        intent.putExtra("k_server_scene", faceDetectPrepareUI.meK);
        intent.putExtra("k_need_signature", faceDetectPrepareUI.mjD);
        intent.putExtra("k_bio_id", faceDetectPrepareUI.mgb);
        intent.putExtra("k_bio_config", faceDetectPrepareUI.mjE);
        x.v("MicroMsg.FaceDetectPrepareUI", "alvinluo FaceDetectReporter info: %s", new Object[]{Long.valueOf(FaceDetectReporter.aGK().mgu)});
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.aGK());
        intent.putExtra("key_reporter_bundle", bundle);
        if (faceDetectPrepareUI.mjB != null) {
            a aVar = faceDetectPrepareUI.mjB;
            if (a.miX != null) {
                a.miX.cancel();
            }
            aVar.miR.setVisibility(4);
            aVar.miN.setVisibility(4);
            aVar.miS.setVisibility(4);
            aVar.miQ.setVisibility(4);
            aVar.miP.setVisibility(4);
        }
        faceDetectPrepareUI.startActivityForResult(intent, 1);
    }

    static /* synthetic */ boolean a(FaceDetectPrepareUI faceDetectPrepareUI, long j, byte[] bArr) {
        FaceContextData.aGt().mgb = j;
        Bundle bundle = new Bundle();
        bundle.putString("k_bio_id", String.valueOf(j));
        bundle.putByteArray("k_bio_config", bArr);
        bundle.putInt("k_server_scene", faceDetectPrepareUI.meK);
        bundle.putParcelable("k_ontext_data", FaceContextData.aGt());
        faceDetectPrepareUI.j(0, bundle);
        return true;
    }

    static /* synthetic */ void b(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        Bundle data = message.getData();
        if (data == null) {
            faceDetectPrepareUI.aHj();
        } else if (data.getInt("key_face_result_code", -1) != 0) {
            faceDetectPrepareUI.aHj();
        } else {
            faceDetectPrepareUI.mjO = 3;
            String string = data.getString("key_face_result_file_path");
            if (string != null) {
                com.tencent.mm.sdk.f.e.post(new 10(faceDetectPrepareUI, string), "face_upload");
            }
        }
    }

    static /* synthetic */ int pB(int i) {
        if (i == 1 || i == 2) {
            return 3;
        }
        if (i == 4) {
            return 2;
        }
        return i != 0 ? 4 : i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.mdI);
        getWindow().addFlags(2097280);
        this.mAppId = getIntent().getStringExtra("k_app_id");
        this.gAb = getIntent().getStringExtra("k_user_name");
        this.meK = getIntent().getIntExtra("k_server_scene", -1);
        this.mjD = getIntent().getBooleanExtra("k_need_signature", false);
        boolean z = com.tencent.mm.plugin.facedetect.model.e.aGv() || getIntent().getBooleanExtra("key_is_need_video", false);
        this.mjI = z;
        this.mjK = getIntent().getStringExtra("key_feedback_url");
        this.mjN = new a(this, (byte) 0);
        this.mjM = new Messenger(this.mjN);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("k_messenger", this.mjM);
        startService(intent);
        FaceContextData.a(new FaceContextData());
        n.p(this);
        int i = b.mfE;
        this.mjA = b.a(this, this, this.meK, getIntent().getExtras());
        if (this.mjA == null) {
            agh();
        } else {
            this.mjA.a(new 8(this));
            this.meL = new 9(this);
            this.mjA.a(this.meL);
        }
        if (this.mjH != null) {
            b bVar = this.mjH;
            bVar.errType = -1;
            bVar.errCode = -1;
            bVar.fnL = "";
            if (bVar.extras != null) {
                bVar.extras.clear();
            }
        }
        this.mjF = false;
        if (this.meK == 2 || this.meK == 5) {
            if (com.tencent.mm.kernel.g.Dj().CU().getBoolean(w.a.xtP, false)) {
                z = false;
            }
            z = true;
        } else {
            if (this.meK != 3 && this.meK == 4) {
                z = false;
            }
            z = true;
        }
        if (z) {
            x.i("MicroMsg.FaceDetectPrepareUI", "hy: need tutorial. show tutorial first");
            this.mjC = new b();
            this.mjO = 0;
            b bVar2 = this.mjC;
            if (this == null) {
                throw new InvalidParameterException("hy: tutorial context is null");
            }
            bVar2.ltB = findViewById(com.tencent.mm.plugin.facedetect.a.e.mdq);
            bVar2.miR = (Button) bVar2.ltB.findViewById(com.tencent.mm.plugin.facedetect.a.e.csK);
            bVar2.xS = (ViewPager) bVar2.ltB.findViewById(com.tencent.mm.plugin.facedetect.a.e.cCl);
            bVar2.mkG = new b.b(bVar2, getSupportFragmentManager());
            bVar2.xS.a(bVar2.mkG);
            bVar2.miR.setOnClickListener(new 1(bVar2));
            ViewPager viewPager = bVar2.xS;
            2 2 = new 2(bVar2);
            if (viewPager.zn == null) {
                viewPager.zn = new ArrayList();
            }
            viewPager.zn.add(2);
            this.mjC.mkH = new b.a(this) {
                final /* synthetic */ FaceDetectPrepareUI mjQ;

                {
                    this.mjQ = r1;
                }

                public final void onCancel() {
                    x.i("MicroMsg.FaceDetectPrepareUI", "hy: user cancel in tutorial");
                    this.mjQ.ab(90002, "user cancel in tutorial");
                }

                public final void aHm() {
                    x.i("MicroMsg.FaceDetectPrepareUI", "hy: tutorial confirmed. start");
                    this.mjQ.aHi();
                }
            };
            com.tencent.mm.kernel.g.Dh();
            if (com.tencent.mm.kernel.a.Cx()) {
                com.tencent.mm.kernel.g.Dj().CU().a(w.a.xtP, Boolean.valueOf(true));
            }
            this.mjC.ltB.setVisibility(0);
            return;
        }
        View findViewById = findViewById(com.tencent.mm.plugin.facedetect.a.e.mdq);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        aHi();
    }

    private void aHi() {
        this.mjO = 1;
        this.mjB = new a(this);
        a aVar = this.mjB;
        synchronized (((FaceDetectPrepareUI) aVar.miW.get())) {
            if (aVar.miW.get() != null) {
                aVar.miM = (RelativeLayout) ((FaceDetectPrepareUI) aVar.miW.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mdw);
                aVar.miN = (Button) ((FaceDetectPrepareUI) aVar.miW.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.cAg);
                aVar.miO = (ImageView) ((FaceDetectPrepareUI) aVar.miW.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mdz);
                aVar.miP = (TextView) ((FaceDetectPrepareUI) aVar.miW.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.cSe);
                aVar.miU = AnimationUtils.loadAnimation((Context) aVar.miW.get(), com.tencent.mm.plugin.facedetect.a.a.bpO);
                aVar.miV = AnimationUtils.loadAnimation((Context) aVar.miW.get(), com.tencent.mm.plugin.facedetect.a.a.bpP);
                aVar.miR = (Button) ((FaceDetectPrepareUI) aVar.miW.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mdv);
                aVar.miS = (Button) ((FaceDetectPrepareUI) aVar.miW.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mdy);
                aVar.miQ = (TextView) ((FaceDetectPrepareUI) aVar.miW.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mdA);
                aVar.miT = (TextView) ((FaceDetectPrepareUI) aVar.miW.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mdr);
                aVar.miU.setDuration(500);
                aVar.miV.setDuration(500);
            }
        }
        if (n.o(this)) {
            x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
            aHl();
        } else {
            x.i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
        }
        if (this.mjI) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_need_video", this.mjI);
            j(4, bundle);
        }
        aHk();
    }

    private void j(int i, Bundle bundle) {
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "hy: sending msg: cmd: %d, data: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = bundle != null ? bundle.toString() : "null";
        x.i(str, str2, objArr);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("k_cmd", i);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtras(bundle);
        startService(intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.mjJ) {
            stopService(new Intent(this, FaceDetectProcessService.class));
        }
    }

    public final void aGq() {
        this.mjP = false;
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        this.mjP = true;
    }

    public void onStop() {
        super.onStop();
        if (!this.mjP) {
            return;
        }
        if (this.joQ || !hasError()) {
            finish();
        } else {
            b(this.mjH.errType, this.mjH.errCode, this.mjH.fnL, this.mjH.extras);
        }
    }

    public void finish() {
        if (this.mjB != null && this.mjB.aHh()) {
            this.mjB.dismiss();
        }
        if (this.mjC != null) {
            this.mjC.dismiss();
        }
        x.v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
        if (this.mjA != null) {
            this.mjA.aGn();
        }
        super.finish();
        this.joQ = true;
    }

    private void aHj() {
        b(4, 90011, "get image failed", getString(h.mdT));
    }

    private void agh() {
        b(4, 90013, "init lib failed", getString(h.mdY));
    }

    private void b(int i, int i2, String str, String str2) {
        x.i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        g(i, i2, str, null);
        this.mjG = true;
        a(i, i2, str, str2, false, new 11(this));
    }

    public void onBackPressed() {
        if (hasError()) {
            if (this.mjA != null) {
                this.mjA.f(this.mjH.errType, this.mjH.errCode, this.mjH.fnL, this.mjH.extras);
            }
        } else if (this.mjO == 1) {
            ab(90003, "user cancel in init");
        } else if (this.mjO == 3) {
            ab(90005, "user cancel in uploading");
        } else if (this.mjO == 0) {
            ab(90002, "user cancel in tutorial");
        } else {
            ab(90050, "user cancel unknown");
        }
    }

    private void ab(int i, String str) {
        if (hasError()) {
            if (this.mjA != null) {
                this.mjA.f(this.mjH.errType, this.mjH.errCode, this.mjH.fnL, this.mjH.extras);
            }
        } else if (this.mjA != null) {
            this.mjA.Z(i, str);
        }
        this.hnr = true;
        finish();
    }

    private boolean hasError() {
        boolean z;
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "alvinluo hasLastError: %b, lastError == null: %b, hashCode: %d";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.mjF);
        if (this.mjH == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(hashCode());
        x.i(str, str2, objArr);
        return this.mjF && this.mjH != null;
    }

    public final void g(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo saveError errType: %d, errCode: %d, errMsg: %s, hashCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(hashCode())});
        if (this.mjH == null) {
            this.mjH = new b(this, (byte) 0);
        }
        this.mjF = true;
        b bVar = this.mjH;
        bVar.errType = i;
        bVar.errCode = i2;
        bVar.fnL = str;
        bVar.extras = bundle;
    }

    private void aHk() {
        x.i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", new Object[]{Boolean.valueOf(true)});
        this.mjL = bh.Wq();
        com.tencent.mm.sdk.f.e.post(new 12(this), "face_prepareInit");
    }

    private void a(final int i, final int i2, final String str, String str2, boolean z, c cVar) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", new Object[]{str2});
        a$b a = a.a(com.tencent.mm.plugin.facedetect.a.d.mcD, str2, z ? getResources().getString(h.mem) : getString(h.mel), z ? getResources().getString(h.dEn) : null, new 14(this, z, cVar, i, i2, str), new OnClickListener(this) {
            final /* synthetic */ FaceDetectPrepareUI mjQ;

            public final void onClick(View view) {
                this.mjQ.b(i, i2, str, null);
            }
        });
        a.a(a, getString(h.mdS), new 3(this, i2));
        ag.y(new 4(this, true, a));
    }

    private void aHl() {
        if (this.mjA != null) {
            this.mjA.aGl();
        }
    }

    public final void aGl() {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
        if (this.mjA != null) {
            String string = getIntent().getExtras().getString("k_ticket");
            if (!bh.ov(string)) {
                x.i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
                p.zI(string);
            }
        }
        aHk();
        if (this.mjA != null) {
            this.mjA.aGk();
        }
        this.mjP = true;
    }

    public final void aGn() {
    }

    public final void a(boolean z, boolean z2, a$b com_tencent_mm_plugin_facedetect_ui_a_b) {
        if (z2) {
            x.i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
            com.tencent.mm.sdk.f.e.post(new 5(this), "face_refresh_background");
        }
        this.mjB.a(com_tencent_mm_plugin_facedetect_ui_a_b);
    }

    public final void b(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_code", k.pv(i2));
        bundle2.putString("err_msg", str);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        setResult(-1, intent);
        if (this.mjI) {
            this.mjJ = true;
            j(5, this.mjA.aGp());
        }
        finish();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 90008;
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
        if (iArr != null && iArr.length > 0) {
            switch (i) {
                case 23:
                    int i3;
                    String str = "";
                    String str2 = "";
                    if (iArr.length != 1) {
                        if (iArr.length == 2) {
                            if (iArr[0] == 0 && iArr[1] == 0) {
                                i3 = 1;
                            } else {
                                if (iArr[0] != 0) {
                                    str = "camera permission not granted";
                                    str2 = getString(h.ezM);
                                } else {
                                    i2 = -1;
                                }
                                if (iArr[1] != 0) {
                                    str = "audio permission not granted";
                                    str2 = getString(h.ezQ);
                                    i2 = 90009;
                                }
                                if (!(iArr[0] == 0 || iArr[1] == 0)) {
                                    i2 = 90010;
                                    str = "both camera and audio permission not granted";
                                    str2 = getString(h.ezM);
                                }
                                b(1, i2, str, str2);
                                i3 = 0;
                            }
                        }
                        i2 = -1;
                        b(1, i2, str, str2);
                        i3 = 0;
                    } else if (iArr[0] == 0) {
                        i3 = 1;
                    } else {
                        if (strArr[0].equals("android.permission.CAMERA")) {
                            str = "camera permission not granted";
                            str2 = getString(h.ezM);
                        } else {
                            if (strArr[0].equals("android.permission.RECORD_AUDIO")) {
                                str = "audio permission not granted";
                                str2 = getString(h.ezQ);
                                i2 = 90009;
                            }
                            i2 = -1;
                        }
                        b(1, i2, str, str2);
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        aHl();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.mjO = 1;
        if (intent == null) {
            x.e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
            a(4, 90018, "system error", getString(h.meb), false, new 6(this));
            return;
        }
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) intent.getParcelableExtra("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.aGK().a(faceDetectReporter);
        }
        int intExtra = intent.getIntExtra("err_type", -1);
        int intExtra2 = intent.getIntExtra("err_code", -1);
        String stringExtra = intent.getStringExtra("err_msg");
        if (this.mjA != null) {
            com.tencent.mm.plugin.facedetect.c.a aVar = this.mjA;
            intent.getExtras();
            aVar.h(intExtra, intExtra2, stringExtra);
        }
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), Integer.valueOf(intExtra2), stringExtra});
        if (intExtra == 0 && intExtra2 == 0) {
            String string = getString(h.mea);
            a$b a = a.a(com.tencent.mm.plugin.facedetect.a.d.mcC, string, null, null, getString(h.dEn), null, new OnClickListener(this) {
                final /* synthetic */ FaceDetectPrepareUI mjQ;

                {
                    this.mjQ = r1;
                }

                public final void onClick(View view) {
                    this.mjQ.ab(90005, "user cancel in uploading");
                }
            });
            a.mjg = true;
            a.mji = string.length() - 3;
            a(false, true, a);
            j(1, null);
        } else if (intExtra != 1) {
            String stringExtra2 = intent.getStringExtra("show_err_msg");
            if (intExtra2 == 90013) {
                stringExtra2 = getString(h.mdY);
            } else if (intExtra2 == 90008 || intExtra2 == 90010) {
                stringExtra2 = getString(h.ezM);
            } else if (intExtra2 == 90009) {
                stringExtra2 = getString(h.ezQ);
            } else if (bh.ov(stringExtra2)) {
                stringExtra2 = getString(h.meA);
            }
            g(intExtra, intExtra2, stringExtra, null);
            a(intExtra, intExtra2, stringExtra, stringExtra2, intExtra2 == 90023, new c(this) {
                final /* synthetic */ FaceDetectPrepareUI mjQ;

                {
                    this.mjQ = r1;
                }

                public final void i(int i, int i2, String str) {
                    if (this.mjQ.mjA != null) {
                        this.mjQ.mjA.f(i, i2, str, null);
                    }
                }
            });
        } else if (intExtra2 == 90004 || intExtra2 == 90025) {
            ab(intExtra2, stringExtra);
        }
    }
}
