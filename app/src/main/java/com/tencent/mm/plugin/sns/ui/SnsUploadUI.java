package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ar.b;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter.1;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(17)
public class SnsUploadUI extends MMActivity implements LocationWidget.a {
    private String desc;
    private SnsAdClick fFe = null;
    private AtContactWidget rLH;
    private LocationWidget rLI;
    private RangeWidget rLJ;
    private SnsUploadSayFooter rLK;
    private KeyboardLinearLayout rLL;
    private boolean rLM = false;
    private boolean rLN = false;
    private String rLO = null;
    private FrameLayout rLP = null;
    private long rLQ = 0;
    private SnsUploadConfigView rrm;
    private int rtM = 0;
    private boolean ruz = false;
    private SnsEditText rwP;
    private z rwQ = null;
    private LinearLayout rwR;
    private int rwT = 0;
    private int rwU = 0;
    private ArrayList<String> rwV;
    private boolean rwW = false;
    private boolean rwY = false;
    private long rwZ = 0;
    private String rwv = "";
    private String rww = "";

    static /* synthetic */ boolean b(SnsUploadUI snsUploadUI) {
        snsUploadUI.aWs();
        if (!snsUploadUI.rLK.bCe()) {
            return false;
        }
        snsUploadUI.rLK.bCf();
        return true;
    }

    static /* synthetic */ void i(SnsUploadUI snsUploadUI) {
        snsUploadUI.rwP.requestFocus();
        x.d("MicroMsg.SnsUploadUI", "request fouces");
        if (snsUploadUI.rLK.bCe()) {
            snsUploadUI.rLK.bCf();
        }
        snsUploadUI.mController.contentView.postInvalidate();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.rwP != null) {
            bundle.putString("contentdesc", this.rwP.getText().toString());
        }
        bundle.getString("contentdesc");
        this.rwQ.G(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void onCreate(Bundle bundle) {
        View a;
        boolean z = true;
        e.h(this);
        super.onCreate(bundle);
        setMMTitle("");
        getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        this.rwY = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.rwZ = getIntent().getLongExtra("KTouchCameraTime", 0);
        this.rtM = getIntent().getIntExtra("Ksnsupload_type", 0);
        this.fFe = (SnsAdClick) getIntent().getParcelableExtra("KsnsAdTag");
        this.ruz = getIntent().getBooleanExtra("Kis_take_photo", false);
        this.rLM = getIntent().getBooleanExtra("need_result", false);
        this.rLN = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
        this.rLO = getIntent().getStringExtra("Ksnsupload_canvas_info");
        this.rwP = (SnsEditText) findViewById(f.qEs);
        this.rwP.setTextSize(1, (ac.eu(this.mController.xIM) * this.rwP.getTextSize()) / com.tencent.mm.bv.a.getDensity(this.mController.xIM));
        if (!bh.ov(getIntent().getStringExtra("Kdescription"))) {
            this.rwP.setText(getIntent().getStringExtra("Kdescription"));
        } else if (!(this.rwP == null || bundle == null)) {
            CharSequence string = bundle.getString("contentdesc");
            if (string != null) {
                this.rwP.setText(string);
            }
        }
        if (this.rtM == 8) {
            this.rwP.setText(getIntent().getStringExtra("Kdescription"));
            this.rwP.setEnabled(false);
        }
        this.rLL = (KeyboardLinearLayout) findViewById(f.cIu);
        this.rLK = (SnsUploadSayFooter) findViewById(f.cIF);
        SnsUploadSayFooter snsUploadSayFooter = this.rLK;
        MMEditText mMEditText = this.rwP;
        snsUploadSayFooter.rGA = mMEditText;
        mMEditText.setOnClickListener(new 1(snsUploadSayFooter));
        mMEditText.setOnEditorActionListener(new SnsUploadSayFooter$2(snsUploadSayFooter));
        this.rLK.setVisibility(8);
        this.rLP = (FrameLayout) findViewById(f.qDk);
        this.rLP.post(new 13(this));
        this.rwP.setOnClickListener(new 14(this));
        this.rwP.setOnLongClickListener(new 15(this));
        WrapScollview wrapScollview = (WrapScollview) findViewById(f.cJg);
        wrapScollview.contentView = this.rwP;
        wrapScollview.rNA = false;
        this.rrm = (SnsUploadConfigView) findViewById(f.qBK);
        com.tencent.mm.ui.i.a.a aVar = this.rrm;
        aVar.rLB.vQu = -1000.0f;
        aVar.rLB.vQt = -1000.0f;
        if (!aVar.rFQ) {
            g.Dk();
            int e = bh.e((Integer) g.Dj().CU().get(68404, null));
            aVar.rLw = (e & 2) != 0;
            aVar.rLx = (e & 8) != 0;
            if (!b.PT()) {
                aVar.rLx = false;
            }
            if (!q.Gr()) {
                aVar.rLw = false;
            }
        }
        aVar.iM(false);
        aVar.bCa();
        aVar.bCb();
        if (aVar.rLx) {
            aVar.rLC.a(aVar);
        }
        if (this.rtM != 0) {
            SnsUploadConfigView snsUploadConfigView = this.rrm;
            snsUploadConfigView.rLs.setVisibility(8);
            snsUploadConfigView.rLt.setVisibility(8);
            snsUploadConfigView.rLu.setVisibility(8);
        }
        if (this.rtM == 9) {
            this.rrm.rLu.setVisibility(0);
        }
        setBackBtn(new 2(this));
        a(0, getString(j.dGA), new 3(this), p.b.xJz);
        findViewById(f.qGb).setOnTouchListener(new 4(this));
        this.rLH = (AtContactWidget) findViewById(f.qBs);
        this.rLH.rrm = this.rrm;
        this.rLI = (LocationWidget) findViewById(f.qCO);
        this.rLI.ruj = this;
        switch (this.rtM) {
            case 0:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
                this.rLJ = (RangeWidget) findViewById(f.qDc);
                findViewById(f.qDd).setVisibility(8);
                break;
            case 1:
            case 11:
            case 15:
            case 16:
                this.rLJ = (RangeWidget) findViewById(f.qDc);
                findViewById(f.qDd).setVisibility(8);
                break;
            case 2:
            case 8:
                this.rLJ = (RangeWidget) findViewById(f.qDc);
                findViewById(f.qDd).setVisibility(8);
                this.rLH.setVisibility(8);
                break;
        }
        this.rLJ.rrm = this.rrm;
        aWs();
        x.d("MicroMsg.SnsUploadUI", "share type %d, isManuSnsPost:%b", new Object[]{Integer.valueOf(this.rtM), Boolean.valueOf(this.rwY)});
        switch (this.rtM) {
            case 0:
                this.rwQ = new ah(this);
                this.rwP.addTextChangedListener(new 1(this));
                break;
            case 1:
            case 11:
            case 15:
            case 16:
                this.rwQ = new aa(this);
                break;
            case 2:
                this.rwQ = new ac(this);
                break;
            case 3:
                this.rwQ = new ai(this, 9);
                break;
            case 4:
                this.rwQ = new p(this);
                break;
            case 5:
                this.rwQ = new ai(this, 14);
                break;
            case 6:
                this.rwQ = new ai(this, 12);
                break;
            case 7:
                this.rwQ = new ai(this, 13);
                break;
            case 8:
                this.rwQ = new be(this);
                break;
            case 9:
                g.Dk();
                CharSequence az = bh.az((String) g.Dj().CU().get(68408, ""), "");
                g.Dk();
                int a2 = bh.a((Integer) g.Dj().CU().get(7489, Integer.valueOf(0)), 0);
                if (bh.ov(az)) {
                    z = false;
                }
                this.rwQ = new ae(this, z);
                this.rwP.rBy = a2;
                this.rwP.append(az);
                this.rwP.addTextChangedListener(new 8(this));
                break;
            case 10:
                this.rwQ = new n(this);
                break;
            case 12:
                this.rwQ = new o(this);
                break;
            case 13:
                this.rwQ = new q(this);
                break;
            case 14:
                this.rwQ = new ad(this);
                break;
        }
        this.rwQ.F(bundle);
        if (this.rwQ instanceof a) {
            View findViewById = findViewById(f.qEr);
            View findViewById2 = findViewById(f.qEy);
            DynamicGridView dynamicGridView = (DynamicGridView) findViewById(f.qFm);
            dynamicGridView.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ SnsUploadUI rLR;

                {
                    this.rLR = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return SnsUploadUI.b(this.rLR);
                }
            });
            a = ((a) this.rwQ).a(findViewById, findViewById(f.qBN), dynamicGridView, findViewById2);
            dynamicGridView.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.rLI.getLayoutParams();
            layoutParams.addRule(3, f.qFm);
            this.rLI.setLayoutParams(layoutParams);
        } else {
            a = this.rwQ.bzk();
            this.rwR = (LinearLayout) findViewById(f.qGj);
            this.rwR.setVisibility(0);
            this.rwR.setClipChildren(false);
            if (a != null) {
                this.rwR.addView(a);
            } else {
                this.rwR.setVisibility(8);
            }
        }
        if (this.rwQ instanceof aa) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) a.getLayoutParams();
            layoutParams2.width = -1;
            a.setLayoutParams(layoutParams2);
        }
        bCg();
        this.rLL.xGO = new KeyboardLinearLayout.a(this) {
            final /* synthetic */ SnsUploadUI rLR;

            {
                this.rLR = r1;
            }

            public final void qI(int i) {
                if (i == -3) {
                    x.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_SHOW");
                    new af().postDelayed(new 1(this), 100);
                    return;
                }
                new af().postDelayed(new 2(this), 200);
                x.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_HIDE");
            }
        };
        if (this.rtM == 0) {
            if (!(this.rwQ instanceof ah)) {
                x.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
            } else if (VERSION.SDK_INT < 11) {
                x.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
            } else {
                new 11(this).run();
            }
        }
        e.i(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        SnsUploadSayFooter snsUploadSayFooter = this.rLK;
        int i2 = (snsUploadSayFooter.bCe() || snsUploadSayFooter.getVisibility() == 0) ? 1 : 0;
        if (i2 != 0) {
            this.rLK.bCf();
            return true;
        } else if (this.rtM == 9) {
            setResult(0, new Intent());
            finish();
            return true;
        } else {
            h.a(this, j.qMF, 0, j.dDM, j.dEn, new OnClickListener(this) {
                final /* synthetic */ SnsUploadUI rLR;

                {
                    this.rLR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.rLR.fFe != null) {
                        this.rLR.fFe.it(10);
                    }
                    this.rLR.setResult(0, new Intent());
                    this.rLR.finish();
                }
            }, null, c.brm);
            return true;
        }
    }

    public final void bCg() {
        if (this.rwQ.bzj()) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    protected void onPause() {
        if (this.rtM == 9) {
            String trim = this.rwP.getText().toString().trim();
            g.Dk();
            g.Dj().CU().set(68408, trim);
            if (bh.ov(trim)) {
                g.Dk();
                g.Dj().CU().set(7489, Integer.valueOf(0));
            } else {
                g.Dk();
                g.Dj().CU().set(7489, Integer.valueOf(this.rwP.rBy));
            }
        }
        super.aWs();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.rLK.post(new 5(this));
        if (this.rwQ != null && (this.rwQ instanceof ad)) {
            ad adVar = (ad) this.rwQ;
            if (adVar.ruv != null && !bh.ov(adVar.videoPath)) {
                adVar.ruv.aA(adVar.videoPath, false);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.rwQ != null) {
            this.rwQ.bzl();
        }
        if (this.rLI != null) {
            this.rLI.stop();
        }
        if (this.rLK != null) {
            SnsUploadSayFooter snsUploadSayFooter = this.rLK;
            if (snsUploadSayFooter.okx != null) {
                snsUploadSayFooter.okx.ti();
                snsUploadSayFooter.okx.destroy();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.rwP != null) {
            this.rwP.clearFocus();
        }
        if (i2 == -1) {
            if (this.rwQ.a(i, intent)) {
                bCg();
            }
            switch (i) {
                case 5:
                    if (intent != null) {
                        this.rLJ.a(i, i2, intent, this.rLH);
                        int intExtra = intent.getIntExtra("Ktag_range_index", 0);
                        if (intExtra >= 2) {
                            this.rwv = intent.getStringExtra("Klabel_name_list");
                            this.rww = intent.getStringExtra("Kother_user_name_list");
                            List list;
                            if (bh.ov(this.rwv)) {
                                list = null;
                            } else {
                                list = Arrays.asList(this.rwv.split(","));
                            }
                            List list2;
                            if (bh.ov(this.rww)) {
                                list2 = null;
                            } else {
                                list2 = Arrays.asList(this.rww.split(","));
                            }
                            this.rwV = new ArrayList();
                            this.rwT = 0;
                            if (r1 != null && r1.size() > 0) {
                                Collection hashSet = new HashSet();
                                for (String Do : r1) {
                                    List<String> Dr = com.tencent.mm.plugin.label.a.a.aUX().Dr(com.tencent.mm.plugin.label.a.a.aUX().Do(Do));
                                    if (Dr == null || Dr.size() == 0) {
                                        x.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
                                        this.rwV = new ArrayList(hashSet);
                                    } else {
                                        for (String Do2 : Dr) {
                                            hashSet.add(Do2);
                                            this.rwT++;
                                            x.d("MicroMsg.SnsUploadUI", "dz:name : %s", new Object[]{Do2});
                                        }
                                    }
                                }
                                this.rwV = new ArrayList(hashSet);
                            }
                            if (r1 != null) {
                                int i3 = 0;
                                for (String Do22 : r1) {
                                    int i4;
                                    if (bh.ov(Do22)) {
                                        i4 = i3;
                                    } else {
                                        i4 = i3 + 1;
                                    }
                                    i3 = i4;
                                }
                                this.rwT = i3;
                            }
                            this.rwU = 0;
                            if (r2 != null && r2.size() > 0) {
                                for (String Do222 : r2) {
                                    if (!this.rwV.contains(Do222)) {
                                        this.rwV.add(Do222);
                                        this.rwU++;
                                    }
                                }
                            }
                            if (intExtra == 2) {
                                this.rwW = false;
                                return;
                            } else {
                                this.rwW = true;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                case 6:
                    if (intent != null) {
                        this.rLH.U(intent);
                        return;
                    }
                    return;
                case 8:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra("bind_facebook_succ", false);
                        SnsUploadConfigView snsUploadConfigView = this.rrm;
                        if (booleanExtra) {
                            snsUploadConfigView.rLw = true;
                            snsUploadConfigView.iM(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 10:
                    if (intent != null) {
                        this.rLI.U(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return i$g.qIj;
    }

    public final ArrayList<Exif.a> bzC() {
        if (!(this.rwQ instanceof ah)) {
            return null;
        }
        ah ahVar = (ah) this.rwQ;
        ArrayList arrayList = ahVar.rvD.rvO;
        ArrayList<Exif.a> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Exif.a aVar = (Exif.a) ahVar.rvF.get((String) it.next());
            if (aVar != null) {
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    public final boolean bzD() {
        return this.ruz;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SnsUploadUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    this.rLI.bzw();
                    return;
                } else {
                    h.a(this, getString(j.ezP), getString(j.ezT), getString(j.est), getString(j.dEn), false, new 6(this), new 7(this));
                    return;
                }
            default:
                return;
        }
    }
}
