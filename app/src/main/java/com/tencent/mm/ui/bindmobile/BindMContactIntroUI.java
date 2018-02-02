package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ar.b;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i$b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.wcdb.FileUtils;

public class BindMContactIntroUI extends MMWizardActivity implements e {
    private String fAf;
    private boolean kmx = false;
    private String qjS = null;
    private String qjT = null;
    private r tipDialog = null;
    private ImageView xSW;
    private boolean xTC = false;
    private i xTn;
    private TextView ylB;
    private TextView ylC;
    private Button ylD;
    private Button ylE;
    private a ylF;
    private boolean ylG = false;
    private int ylH = 0;

    static /* synthetic */ void a(BindMContactIntroUI bindMContactIntroUI) {
        boolean z = true;
        switch (20.ylK[bindMContactIntroUI.ylF.ordinal()]) {
            case 1:
                bindMContactIntroUI.mB(false);
                return;
            case 2:
                String str = bindMContactIntroUI.fAf;
                if (bindMContactIntroUI.xTn == null) {
                    bindMContactIntroUI.xTn = new i(i$b.zdM, bindMContactIntroUI, new 25(bindMContactIntroUI, str));
                    bindMContactIntroUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMContactIntroUI.xTn);
                }
                i iVar = bindMContactIntroUI.xTn;
                if (bindMContactIntroUI.xTC || bindMContactIntroUI.ylG) {
                    z = false;
                }
                iVar.zdI = z;
                bindMContactIntroUI.xTn.ZQ(str);
                return;
            case 3:
                ar.Hg();
                c.CU().set(12322, Boolean.valueOf(false));
                m.a(bindMContactIntroUI, new Runnable(bindMContactIntroUI) {
                    final /* synthetic */ BindMContactIntroUI ylI;

                    {
                        this.ylI = r1;
                    }

                    public final void run() {
                        if (com.tencent.mm.modelfriend.m.NL()) {
                            BindMContactIntroUI.cqz();
                            this.ylI.ylD.setText(this.ylI.getString(R.l.dLb));
                            this.ylI.ylF = a.hwi;
                            ar.Hg();
                            boolean a = bh.a((Boolean) c.CU().get(12322, Boolean.valueOf(false)), false);
                            if (this.ylI.kmx && a) {
                                g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
                            }
                        }
                    }
                }, true, bindMContactIntroUI.ylH);
                return;
            case 4:
                bindMContactIntroUI.startActivity(new Intent(bindMContactIntroUI, MobileFriendUI.class));
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void b(BindMContactIntroUI bindMContactIntroUI) {
        switch (20.ylK[bindMContactIntroUI.ylF.ordinal()]) {
            case 2:
                com.tencent.mm.modelfriend.m.NO();
                bindMContactIntroUI.initView();
                return;
            case 3:
                bindMContactIntroUI.mB(true);
                return;
            case 4:
                bindMContactIntroUI.mB(true);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void cqz() {
        int FW = q.FW();
        com.tencent.mm.modelfriend.m.NK();
        FW &= -131073;
        ar.Hg();
        c.CU().set(7, Integer.valueOf(FW));
        com.tencent.mm.plugin.c.a.ift.um();
    }

    protected final int getLayoutId() {
        return R.i.dbg;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(132, this);
        ar.CG().a(255, this);
        ar.CG().a(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, this);
        setMMTitle(R.l.dLm);
    }

    public void onDestroy() {
        ar.CG().b(132, this);
        ar.CG().b(255, this);
        ar.CG().b(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, this);
        if (this.xTn != null) {
            getContentResolver().unregisterContentObserver(this.xTn);
            this.xTn.recycle();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final void initView() {
        this.xTC = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.ylG = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.kmx = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.ylH = getIntent().getIntExtra("key_upload_scene", 0);
        this.ylF = com.tencent.mm.modelfriend.m.NN();
        x.d("MicroMsg.BindMContactIntroUI", "state " + this.ylF);
        ar.Hg();
        this.fAf = (String) c.CU().get(6, null);
        if (this.fAf == null || this.fAf.equals("")) {
            ar.Hg();
            this.fAf = (String) c.CU().get(4097, null);
        }
        this.xSW = (ImageView) findViewById(R.h.cMa);
        this.ylB = (TextView) findViewById(R.h.cLY);
        this.ylC = (TextView) findViewById(R.h.cLX);
        this.ylD = (Button) findViewById(R.h.cLW);
        this.ylE = (Button) findViewById(R.h.cLZ);
        this.ylD.setOnClickListener(new 1(this));
        this.ylE.setOnClickListener(new 12(this));
        if (getIntent().getBooleanExtra("skip", false)) {
            addTextOptionMenu(0, getString(R.l.dFu), new 21(this));
        } else {
            setBackBtn(new 22(this));
        }
        if (this.ylF == a.hwj || this.ylF == a.hwi) {
            String value = com.tencent.mm.k.g.zY().getValue("ShowUnbindPhone");
            int i = 2;
            if (!bh.ov(value)) {
                i = bh.VI(value);
            }
            if (i != 0) {
                addIconOptionMenu(1, R.g.bDI, new 23(this, i));
            }
        }
        switch (20.ylK[this.ylF.ordinal()]) {
            case 1:
                showOptionMenu(1, false);
                this.xSW.setImageResource(R.k.dza);
                this.ylC.setVisibility(0);
                this.ylE.setVisibility(8);
                this.ylB.setText(R.l.dLd);
                this.ylC.setText(R.l.dLc);
                this.ylD.setText(R.l.dKF);
                return;
            case 2:
                showOptionMenu(1, false);
                this.xSW.setImageResource(R.k.dza);
                this.ylC.setVisibility(0);
                this.ylE.setVisibility(0);
                this.ylB.setText(String.format(getString(R.l.dLD), new Object[]{this.fAf}));
                this.ylC.setText(R.l.dLv);
                this.ylD.setText(R.l.dLy);
                this.ylE.setText(R.l.dKO);
                return;
            case 3:
                showOptionMenu(1, true);
                this.xSW.setImageResource(R.k.dyZ);
                this.ylC.setVisibility(0);
                this.ylE.setVisibility(0);
                this.ylB.setText(String.format(getString(R.l.dLD), new Object[]{this.fAf}));
                this.ylC.setText(R.l.dKK);
                this.ylD.setText(R.l.dLw);
                this.ylE.setText(R.l.dKM);
                return;
            case 4:
                showOptionMenu(1, true);
                this.xSW.setImageResource(R.k.dyZ);
                this.ylC.setVisibility(0);
                this.ylE.setVisibility(0);
                this.ylB.setText(String.format(getString(R.l.dLD), new Object[]{this.fAf}));
                this.ylC.setText(R.l.dKK);
                this.ylD.setText(R.l.dLb);
                this.ylE.setText(R.l.dKM);
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bov();
        return true;
    }

    private void bov() {
        aWs();
        if (this.ylG) {
            cancel();
            finish();
            return;
        }
        DU(1);
    }

    private void mB(boolean z) {
        Intent intent = new Intent(this, BindMContactUI.class);
        intent.putExtra("is_bind_for_safe_device", this.xTC);
        intent.putExtra("is_bind_for_contact_sync", this.ylG);
        intent.putExtra("is_bind_for_change_mobile", z);
        String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
        if (!bh.ov(simCountryIso)) {
            b.a h = b.h(this, simCountryIso, getString(R.l.bZb));
            if (h != null) {
                intent.putExtra("country_name", h.hEx);
                intent.putExtra("couttry_code", h.hEw);
            }
        }
        A(this, intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + kVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 132 && i == 0 && i2 == 0) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (((t) kVar).IS() == 3) {
                d.br(this);
                if (bh.ov(this.qjT)) {
                    A(this, new Intent(this, BindMContactStatusUI.class));
                    return;
                } else {
                    h.a((Context) this, this.qjT, "", getString(R.l.dBP), new OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ylI;

                        {
                            this.ylI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MMWizardActivity.A(this.ylI, new Intent(this.ylI, BindMContactStatusUI.class));
                        }
                    });
                    return;
                }
            }
            return;
        }
        Object obj;
        if (!com.tencent.mm.plugin.c.a.ift.a(this, i, i2, str)) {
            obj = null;
            switch (i2) {
                case -214:
                    com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                    if (eA != null) {
                        eA.a(this, null, null);
                    }
                    obj = 1;
                    break;
                case -43:
                    Toast.makeText(this, R.l.dKQ, 0).show();
                    obj = 1;
                    break;
                case -41:
                    Toast.makeText(this, R.l.dKS, 0).show();
                    obj = 1;
                    break;
                case -36:
                    Toast.makeText(this, R.l.dKV, 0).show();
                    obj = 1;
                    break;
                case -35:
                    Toast.makeText(this, R.l.dKR, 0).show();
                    obj = 1;
                    break;
                case -34:
                    Toast.makeText(this, R.l.dKT, 0).show();
                    obj = 1;
                    break;
                default:
                    break;
            }
        }
        obj = 1;
        if (obj == null) {
            k tVar;
            Context context;
            if (kVar.getType() == com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE) {
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (i == 0 && i2 == 0) {
                    this.qjT = ((com.tencent.mm.modelsimple.h) kVar).RD().vWy;
                    this.qjS = ((com.tencent.mm.modelsimple.h) kVar).RC();
                    if (bh.ov(this.qjT)) {
                        ar.CG().a(new com.tencent.mm.modelsimple.x(2), 0);
                        return;
                    }
                    tVar = new t(this.fAf, 3, "", 0, "");
                    ar.CG().a(tVar, 0);
                    context = this.mController.xIM;
                    getString(R.l.dGO);
                    this.tipDialog = h.a(context, getString(R.l.dLu), true, new 27(this, tVar));
                    return;
                } else if (i2 == -3) {
                    x.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                    h.a(this.mController.xIM, getString(R.l.eNI), null, getString(R.l.eNJ), getString(R.l.eNH), true, new 2(this), new 3(this));
                } else if (i2 == -81) {
                    h.a((Context) this, R.l.eKz, R.l.dGO, new 4(this));
                } else if (i2 == -82) {
                    h.a((Context) this, R.l.eKA, R.l.dGO, new 5(this));
                } else if (i2 == -83) {
                    h.a((Context) this, R.l.eKx, R.l.dGO, new 6(this));
                } else if (i2 == -84) {
                    h.a((Context) this, R.l.eKy, R.l.dGO, new 7(this));
                } else if (i2 == -85) {
                    h.a((Context) this, R.l.eKv, R.l.dGO, new 8(this));
                } else if (i2 == -86) {
                    h.a((Context) this, R.l.eKB, R.l.dGO, new 9(this));
                }
            }
            if (kVar.getType() == 255) {
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (i2 == 0) {
                    tVar = new t(this.fAf, 3, "", 0, "");
                    ar.CG().a(tVar, 0);
                    context = this.mController.xIM;
                    getString(R.l.dGO);
                    this.tipDialog = h.a(context, getString(R.l.dLu), true, new 10(this, tVar));
                } else {
                    x.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
                    h.a(this.mController.xIM, getString(R.l.eNI), null, getString(R.l.eNJ), getString(R.l.eNH), true, new 11(this), new 13(this));
                }
            }
            if (kVar.getType() == 132) {
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (((t) kVar).IS() != 3) {
                    return;
                }
                if (i2 == -82) {
                    h.a((Context) this, R.l.eKA, R.l.dGO, new OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ylI;

                        {
                            this.ylI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    h.a((Context) this, R.l.eKx, R.l.dGO, new OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ylI;

                        {
                            this.ylI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -84) {
                    h.a((Context) this, R.l.eKy, R.l.dGO, new OnClickListener(this) {
                        final /* synthetic */ BindMContactIntroUI ylI;

                        {
                            this.ylI = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    h.a((Context) this, R.l.eKv, R.l.dGO, new 17(this));
                } else {
                    Toast.makeText(this, getString(R.l.dLr, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.fAf);
                    ar.CG().a(new com.tencent.mm.modelsimple.h(com.tencent.mm.modelsimple.h.hMH), 0);
                    getString(R.l.dGO);
                    this.tipDialog = h.a((Context) this, getString(R.l.eLF), true, new 19(this));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.BindMContactIntroUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.BindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.xTn != null) {
                    this.xTn.cos();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
