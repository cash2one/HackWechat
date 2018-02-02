package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ar.b;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.h.a;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class BindMContactVerifyUI extends MMWizardActivity implements e {
    private String fAf;
    private int fromScene = 0;
    private SharedPreferences gZO;
    private boolean kmx = false;
    private int status;
    private r tipDialog = null;
    private Button xTB;
    private boolean xTC = false;
    private boolean xTE = false;
    private EditText xTy;
    private TextView xUr;
    private boolean ylG = false;
    private boolean ylS = false;
    private boolean ylU = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(132, (e) this);
        setMMTitle(R.l.dLn);
        this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = q.FW();
        initView();
    }

    public void onDestroy() {
        ar.CG().b(132, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dbi;
    }

    protected final void initView() {
        ar.Hg();
        this.fAf = (String) c.CU().get(4097, null);
        this.xTy = (EditText) findViewById(R.h.bNA);
        this.xTC = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.ylG = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.xTE = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        this.ylU = getIntent().getBooleanExtra("BIND_FIND_ME_BY_MOBILE", false);
        this.ylS = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
        this.kmx = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        Button button = (Button) findViewById(R.h.bNx);
        if (this.fAf == null || this.fAf.equals("")) {
            ar.Hg();
            this.fAf = (String) c.CU().get(6, null);
        }
        this.xTy.setFilters(new InputFilter[]{new 1(this)});
        this.xTB = (Button) findViewById(R.h.bNC);
        this.xUr = (TextView) findViewById(R.h.bNy);
        boolean z = this.ylU;
        if (z) {
            this.status &= -513;
        } else {
            this.status |= WXMediaMessage.TITLE_LENGTH_LIMIT;
        }
        this.gZO.edit().putBoolean("settings_find_me_by_mobile", z).commit();
        x.d("MicroMsg.BindMContactVerifyUI", "Bind mobile update = " + this.status);
        this.xUr.setText(getString(R.l.dLe, new Object[]{this.fAf}));
        button.setOnClickListener(new 2(this));
        setBackBtn(new 3(this));
        this.xTB.setVisibility(b.lG(this.fAf) ? 0 : 8);
        this.xTB.setOnClickListener(new 4(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        DU(1);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BindMContactVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((t) kVar).IS() == 2 || ((t) kVar).IS() == 19) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            boolean z;
            if (i != 0 || i2 != 0) {
                a eA = a.eA(str);
                if (eA != null) {
                    eA.a(this, null, null);
                    return;
                }
                if (!com.tencent.mm.plugin.c.a.ift.a(this, i, i2, str)) {
                    switch (i2) {
                        case -214:
                            eA = a.eA(str);
                            if (eA != null) {
                                eA.a(this, null, null);
                            }
                            z = true;
                            break;
                        case -43:
                            Toast.makeText(this, R.l.dKQ, 0).show();
                            z = true;
                            break;
                        case -41:
                            Toast.makeText(this, R.l.dKS, 0).show();
                            z = true;
                            break;
                        case -36:
                            Toast.makeText(this, R.l.dKV, 0).show();
                            z = true;
                            break;
                        case -35:
                            Toast.makeText(this, R.l.dKR, 0).show();
                            z = true;
                            break;
                        case -34:
                            Toast.makeText(this, R.l.dKT, 0).show();
                            z = true;
                            break;
                        case -33:
                            h.a(this, R.l.dLA, R.l.bNB, null);
                            z = true;
                            break;
                        case -32:
                            h.a(this, R.l.dLB, R.l.bNB, null);
                            z = true;
                            break;
                        default:
                            z = false;
                            break;
                    }
                }
                z = true;
                if (!z) {
                    Toast.makeText(this, getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (((t) kVar).IS() != 2 && ((t) kVar).IS() != 19) {
            } else {
                if (this.fromScene == 5) {
                    x.i("MicroMsg.BindMContactVerifyUI", "onScene end, finish wizard from app brand reg phone");
                    DU(-1);
                } else if (this.xTC) {
                    if (!q.Ga()) {
                        com.tencent.mm.sdk.b.b saVar = new sa();
                        saVar.fJK.fJL = true;
                        saVar.fJK.fJM = true;
                        com.tencent.mm.sdk.b.a.xef.m(saVar);
                    }
                    DU(1);
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.c.a.ifs.e(this, intent);
                } else if (this.xTE) {
                    DU(1);
                    startActivity(new Intent(this, FindMContactAddUI.class));
                } else {
                    int i3;
                    z = (this.status & WXMediaMessage.TITLE_LENGTH_LIMIT) > 0;
                    ar.Hg();
                    c.CU().set(7, Integer.valueOf(this.status));
                    com.tencent.mm.bq.a wlVar = new wl();
                    wlVar.wgL = 8;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    wlVar.wgM = i3;
                    ar.Hg();
                    c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wlVar));
                    com.tencent.mm.plugin.c.a.ift.um();
                    if (!this.ylG) {
                        getApplicationContext();
                        com.tencent.mm.modelfriend.a.Nm();
                    }
                    if (this.ylS) {
                        h.bu(this, getString(R.l.dKJ));
                    }
                    if (this.kmx) {
                        if (this.ylG) {
                            g.pQN.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                        } else {
                            g.pQN.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(2));
                        }
                    }
                    A(this, new Intent(this, BindMContactStatusUI.class));
                }
            }
        }
    }
}
