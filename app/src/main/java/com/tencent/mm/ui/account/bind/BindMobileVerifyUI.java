package com.tencent.mm.ui.account.bind;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ar.b;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI extends MMWizardActivity implements e {
    private Timer bnp;
    private String fAf;
    private r tipDialog = null;
    private TextView xTA;
    private Button xTB;
    private boolean xTC = false;
    private boolean xTD = false;
    private boolean xTE = false;
    private Integer xTF = Integer.valueOf(15);
    private BindWordingContent xTf;
    private int xTg;
    private boolean xTh;
    private boolean xTi;
    private boolean xTv = false;
    private EditText xTy;
    private TextView xTz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(132, this);
        setMMTitle(R.l.dLn);
        this.xTf = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.xTg = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.xTh = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.xTi = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        this.xTv = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
        initView();
    }

    public void onDestroy() {
        ar.CG().b(132, this);
        super.onDestroy();
    }

    protected void onStop() {
        cou();
        super.onStop();
    }

    protected final int getLayoutId() {
        return R.i.dbi;
    }

    protected final void initView() {
        ar.Hg();
        this.fAf = (String) c.CU().get(4097, null);
        this.xTy = (EditText) findViewById(R.h.bNA);
        this.xTz = (TextView) findViewById(R.h.bNz);
        this.xTA = (TextView) findViewById(R.h.bNu);
        this.xTC = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.xTD = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.xTE = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        Button button = (Button) findViewById(R.h.bNx);
        if (this.fAf == null || this.fAf.equals("")) {
            ar.Hg();
            this.fAf = (String) c.CU().get(6, null);
        }
        if (this.fAf != null && this.fAf.length() > 0) {
            this.xTz.setVisibility(0);
            this.xTz.setText(this.fAf);
        }
        this.xTy.setFilters(new InputFilter[]{new 1(this)});
        this.xTB = (Button) findViewById(R.h.bNC);
        button.setVisibility(8);
        this.xTA.setText(getResources().getQuantityString(R.j.duC, this.xTF.intValue(), new Object[]{this.xTF}));
        if (this.bnp == null) {
            this.bnp = new Timer();
            TimerTask 5 = new 5(this);
            if (this.bnp != null) {
                this.bnp.schedule(5, 1000, 1000);
            }
        }
        addTextOptionMenu(0, getString(R.l.dFQ), new 2(this));
        setBackBtn(new 3(this));
        this.xTB.setVisibility(b.lG(this.fAf) ? 0 : 8);
        this.xTB.setOnClickListener(new 4(this));
    }

    private void cou() {
        if (this.bnp != null) {
            this.bnp.cancel();
            this.bnp = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        x.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((t) kVar).IS() == 2) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            boolean z2;
            if (i != 0 || i2 != 0) {
                if (!a.ift.a(this, i, i2, str)) {
                    switch (i2) {
                        case -214:
                            com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                            if (eA != null) {
                                eA.a(this, null, null);
                            }
                            z2 = true;
                            break;
                        case -43:
                            Toast.makeText(this, R.l.dKQ, 0).show();
                            z2 = true;
                            break;
                        case -41:
                            Toast.makeText(this, R.l.dKS, 0).show();
                            z2 = true;
                            break;
                        case -36:
                            Toast.makeText(this, R.l.dKV, 0).show();
                            z2 = true;
                            break;
                        case -35:
                            Toast.makeText(this, R.l.dKR, 0).show();
                            z2 = true;
                            break;
                        case -34:
                            Toast.makeText(this, R.l.dKT, 0).show();
                            z2 = true;
                            break;
                        case -33:
                            h.a(this, R.l.dLA, R.l.bNB, null);
                            z2 = true;
                            break;
                        case -32:
                            h.a(this, R.l.dLB, R.l.bNB, null);
                            z2 = true;
                            break;
                        default:
                            z2 = false;
                            break;
                    }
                }
                z2 = true;
                if (!z2) {
                    Toast.makeText(this, getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (((t) kVar).IS() != 2) {
            } else {
                Intent intent;
                if (this.xTC) {
                    if (!q.Ga()) {
                        com.tencent.mm.sdk.b.b saVar = new sa();
                        saVar.fJK.fJL = true;
                        saVar.fJK.fJM = true;
                        com.tencent.mm.sdk.b.a.xef.m(saVar);
                    }
                    DU(1);
                    intent = new Intent();
                    intent.addFlags(67108864);
                    a.ifs.e(this, intent);
                } else if (this.xTE) {
                    DU(1);
                    startActivity(new Intent(this, FindMContactAddUI.class));
                } else if (this.xTv) {
                    if (this.xTh) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (this.xTi) {
                        z = false;
                    }
                    BindMobileStatusUI.c(this, z2, z);
                    exit(-1);
                } else {
                    if (!this.xTD) {
                        getApplicationContext();
                        com.tencent.mm.modelfriend.a.Nm();
                    }
                    intent = new Intent(this, BindMobileStatusUI.class);
                    intent.putExtra("kstyle_bind_wording", this.xTf);
                    intent.putExtra("kstyle_bind_recommend_show", this.xTg);
                    intent.putExtra("Kfind_friend_by_mobile_flag", this.xTh);
                    intent.putExtra("Krecom_friends_by_mobile_flag", this.xTi);
                    MMWizardActivity.A(this, intent);
                }
            }
        }
    }
}
