package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bf.f;
import com.tencent.mm.bf.l;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

public class SayHiWithSnsPermissionUI extends MMActivity implements e {
    private String bgo;
    private String bgp;
    private String chatroomName;
    private ProgressDialog iln = null;
    private String nPP;
    private int[] nZZ = new int[8];
    private String oNZ;
    private int phF;
    private EditText pkZ;
    private EditText pla;
    private View plb;
    private TextView plc;
    private MMSwitchBtn pld;
    private boolean ple;
    private boolean plf;
    private boolean plg;
    private TextView plh;
    private MMTagPanel pli;
    private List<String> plj;
    private b plk = new 1(this);
    private CharSequence pll = null;
    private String userName;

    static /* synthetic */ void c(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        Intent intent = new Intent();
        intent.putExtra("label_id_list", sayHiWithSnsPermissionUI.nPP);
        if (sayHiWithSnsPermissionUI.plj != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) sayHiWithSnsPermissionUI.plj);
        }
        intent.putExtra("label_username", sayHiWithSnsPermissionUI.userName);
        intent.putExtra("is_stranger", true);
        d.b(sayHiWithSnsPermissionUI, "label", ".ui.ContactLabelUI", intent);
    }

    static /* synthetic */ String g(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        String trim = sayHiWithSnsPermissionUI.pkZ.getText().toString().trim();
        return trim.length() <= 50 ? trim : trim.substring(0, 50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dqU;
    }

    protected void onResume() {
        if (this.plg) {
            ar.Hg();
            c.EY().a(this.plk);
            bjM();
        }
        ar.CG().a(30, this);
        super.onResume();
    }

    public void onStop() {
        ar.CG().b(30, this);
        if (this.plg) {
            ar.Hg();
            c.EY().b(this.plk);
        }
        super.onStop();
    }

    protected void onDestroy() {
        g.pQN.h(14036, new Object[]{Integer.valueOf(this.nZZ[0]), Integer.valueOf(this.nZZ[1]), Integer.valueOf(this.nZZ[2]), Integer.valueOf(this.nZZ[3]), Integer.valueOf(this.nZZ[4]), Integer.valueOf(this.nZZ[5]), Integer.valueOf(this.nZZ[6]), Integer.valueOf(this.nZZ[7])});
        super.onDestroy();
    }

    protected final void initView() {
        String str;
        String string;
        this.pld = (MMSwitchBtn) findViewById(R.h.cAE).findViewById(R.h.checkbox);
        this.pld.nB(false);
        this.ple = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
        this.plf = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
        this.plg = getIntent().getBooleanExtra("sayhi_with_sns_perm_set_label", false);
        this.userName = getIntent().getStringExtra("Contact_User");
        this.phF = getIntent().getIntExtra("Contact_Scene", 9);
        this.chatroomName = getIntent().getStringExtra("room_name");
        this.bgp = getIntent().getStringExtra("Contact_RemarkName");
        this.bgo = getIntent().getStringExtra("Contact_Nick");
        this.oNZ = getIntent().getStringExtra("Contact_RoomNickname");
        this.plb = findViewById(R.h.cwW);
        this.plc = (TextView) findViewById(R.h.cwX);
        setMMTitle(getString(R.l.app_name));
        if (this.ple) {
            setMMTitle(getString(R.l.eKf));
            this.pkZ = (EditText) findViewById(R.h.cIG);
            this.pkZ.setMinHeight(this.mController.xIM.getResources().getDimensionPixelSize(R.f.bvA));
            com.tencent.mm.ui.tools.a.c.d(this.pkZ).GN(100).a(null);
            this.pkZ.setFilters(h.vxH);
            ((LinearLayout) this.pkZ.getParent()).setVisibility(0);
            ar.Hg();
            str = (String) c.CU().get(294913, null);
            String FU = q.FU();
            if (FU == null) {
                FU = "";
            }
            string = getString(R.l.eJZ);
            if (string.length() + FU.length() > 50) {
                FU = FU.substring(0, 50 - string.length());
            }
            this.pll = i.b(this.mController.xIM, String.format(string, new Object[]{FU}), this.pkZ.getTextSize());
            if (bh.ov(str)) {
                this.pkZ.setText(this.pll);
            } else {
                this.pkZ.setText(i.b(this.mController.xIM, str, this.pkZ.getTextSize()));
            }
            this.pkZ.requestFocus();
            this.pkZ.postDelayed(new 2(this), 100);
        }
        if (this.plf) {
            this.pla = (EditText) findViewById(R.h.cIJ);
            ((LinearLayout) this.pla.getParent()).setVisibility(0);
            if (!this.ple) {
                this.pla.clearFocus();
            }
            this.pla.setMinHeight(this.mController.xIM.getResources().getDimensionPixelSize(R.f.bvA));
            com.tencent.mm.ui.tools.a.c.d(this.pla).GN(100).a(null);
            this.pla.setFilters(h.vxH);
            if (!this.ple) {
                this.nZZ[0] = 1;
                setMMTitle(getString(R.l.dXx));
                LayoutParams layoutParams = (LayoutParams) ((View) this.pla.getParent()).getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
            if (bh.ov(this.bgp)) {
                CharSequence jVar;
                if (!bh.ov(this.bgo)) {
                    this.pla.setHint(i.b(this.mController.xIM, this.bgo, this.pla.getTextSize()));
                    this.pla.setOnFocusChangeListener(new 3(this));
                }
                boolean z;
                switch (this.phF) {
                    case 8:
                    case 14:
                        if (!bh.ov(this.oNZ) && !this.oNZ.equals(this.pla.getText().toString())) {
                            this.plb.setVisibility(0);
                            this.plc.setText(i.b(this, bh.ou(getString(R.l.dWs, new Object[]{this.oNZ})), this.plc.getTextSize()));
                            CharSequence jVar2 = new j(getString(R.l.eXQ));
                            jVar2.setSpan(new a(this, this.oNZ), 0, jVar2.length(), 17);
                            this.plc.append(" ");
                            this.plc.append(jVar2);
                            this.plc.setMovementMethod(LinkMovementMethod.getInstance());
                            this.nZZ[3] = 2;
                            z = true;
                            break;
                        }
                        z = false;
                        break;
                        break;
                    case 10:
                    case 11:
                    case 13:
                        com.tencent.mm.modelfriend.b kR = af.OD().kR(this.userName);
                        if (kR != null && !bh.ov(kR.Nt()) && !kR.Nt().equals(this.pla.getText().toString())) {
                            this.plb.setVisibility(0);
                            this.plc.setText(i.b(this, bh.ou(getString(R.l.dWt, new Object[]{kR.Nt()})), this.plc.getTextSize()));
                            jVar = new j(getString(R.l.eXQ));
                            jVar.setSpan(new a(this, kR.Nt()), 0, jVar.length(), 17);
                            this.plc.append(" ");
                            this.plc.append(jVar);
                            this.plc.setMovementMethod(LinkMovementMethod.getInstance());
                            this.nZZ[3] = 1;
                            z = true;
                            break;
                        }
                        z = false;
                        break;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (!(this.ple || r0)) {
                    f mX = l.Tw().mX(this.userName);
                    if (mX != null) {
                        com.tencent.mm.pluginsdk.ui.preference.b a = com.tencent.mm.pluginsdk.ui.preference.b.a(this, mX);
                        if (!(bh.ov(a.hef) || a.hef.equals(getString(R.l.eig)))) {
                            string = getString(R.l.eJZ).substring(0, getString(R.l.eJZ).indexOf("%s"));
                            str = a.hef;
                            if (a.hef.startsWith(string)) {
                                str = a.hef.substring(string.length());
                            }
                            this.plb.setVisibility(0);
                            this.plc.setText(i.b(this, bh.ou(getString(R.l.dWu, new Object[]{a.hef})), this.plc.getTextSize()));
                            jVar = new j(getString(R.l.eXQ));
                            jVar.setSpan(new a(this, str), 0, jVar.length(), 17);
                            this.plc.append(" ");
                            this.plc.append(jVar);
                            this.plc.setMovementMethod(LinkMovementMethod.getInstance());
                            this.nZZ[3] = 3;
                        }
                    }
                }
            } else {
                this.pla.setText(i.b(this.mController.xIM, this.bgp, this.pla.getTextSize()));
                this.nZZ[6] = 1;
            }
        }
        if (this.plg) {
            this.plh = (TextView) findViewById(R.h.cwS);
            this.pli = (MMTagPanel) findViewById(R.h.bYi);
            this.pli.ndg = false;
            ((LinearLayout) ((FrameLayout) this.pli.getParent()).getParent()).setVisibility(0);
            this.plh.setOnClickListener(new 4(this));
            this.pli.setOnClickListener(new 5(this));
        }
        bjM();
        if (!bh.ov(this.nPP)) {
            this.nZZ[7] = 1;
        }
        str = getString(R.l.dGA);
        if (!this.ple) {
            str = getString(R.l.dFl);
        }
        a(0, str, new 6(this), p.b.xJz);
        setBackBtn(new 7(this));
    }

    private void bjM() {
        ar.Hg();
        bf EZ = c.EZ().EZ(this.userName);
        if (EZ != null) {
            this.nPP = EZ.field_contactLabels;
            this.plj = (ArrayList) a.aUX().Dp(this.nPP);
        }
        if (!this.plg) {
            return;
        }
        if (bh.ov(this.nPP)) {
            this.pli.setVisibility(4);
            this.plh.setVisibility(0);
            return;
        }
        this.pli.setVisibility(0);
        this.plh.setVisibility(4);
        this.pli.a(this.plj, this.plj);
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        x.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (this.ple) {
                String trim = this.pkZ.getText().toString().trim();
                if (bh.ov(trim) || trim.equals(this.pll)) {
                    ar.Hg();
                    c.CU().set(294913, "");
                } else {
                    ar.Hg();
                    c.CU().set(294913, trim);
                }
                switch (i2) {
                    case -34:
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        Toast.makeText(this, R.l.eik, 0).show();
                        break;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        Toast.makeText(this, R.l.eKc, 0).show();
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    return;
                }
            }
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.h.bu(this, getString(R.l.eKd));
                int i3 = ((o) kVar).fuL;
                if (this.plf) {
                    String str2 = "";
                    if (this.pla.getText() != null) {
                        str2 = this.pla.getText().toString();
                    }
                    if (!bh.ov(str2) && str2.length() > 50) {
                        str2 = str2.substring(0, 50);
                    }
                    if (!bh.ov(str2)) {
                        ar.Hg();
                        com.tencent.mm.storage.x WO = c.EY().WO(this.userName);
                        WO.da(str2);
                        ar.Hg();
                        com.tencent.mm.sdk.e.c EZ = c.EZ().EZ(this.userName);
                        EZ.field_encryptUsername = this.userName;
                        EZ.field_conRemark = str2;
                        ar.Hg();
                        c.EZ().a(EZ);
                        ar.Hg();
                        c.EY().Q(WO);
                        this.nZZ[2] = 1;
                        if (!(bh.ov(this.bgo) || str2.equals(this.bgo))) {
                            this.nZZ[5] = 1;
                        }
                    } else if (bh.ov(this.bgo)) {
                        this.nZZ[2] = 2;
                    } else {
                        this.nZZ[2] = 0;
                    }
                    if (i3 == 3) {
                        List list = ((o) kVar).vdy;
                        f mX = l.Tw().mX(this.userName);
                        ar.Hg();
                        com.tencent.mm.storage.x WO2 = c.EY().WO(this.userName);
                        if (list != null && list.contains(this.userName)) {
                            if (((int) WO2.gJd) == 0) {
                                WO2 = com.tencent.mm.pluginsdk.ui.preference.b.b(mX);
                                ar.Hg();
                                if (!c.EY().R(WO2)) {
                                    x.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
                                }
                            }
                            s.p(WO2);
                            ar.getNotification().wY();
                            l.Tx().T(this.userName, 1);
                            com.tencent.mm.pluginsdk.ui.preference.b.aT(this.userName, this.phF);
                        }
                        ar.Hg();
                        WO2 = c.EY().WO(this.userName);
                        com.tencent.mm.sdk.b.b qbVar = new qb();
                        qbVar.fHH.fHJ = true;
                        qbVar.fHH.fHI = false;
                        qbVar.fHH.username = this.userName;
                        com.tencent.mm.sdk.b.a.xef.m(qbVar);
                        if (this.pld.zvg) {
                            s.j(WO2);
                        } else {
                            s.k(WO2);
                        }
                        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false)) {
                            Intent intent = new Intent();
                            intent.putExtra("friend_message_transfer_username", this.userName);
                            intent.setAction("friend_message_accept_" + this.userName);
                            intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bqB);
                            intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqA);
                            d.b(this, "subapp", ".ui.friend.FMessageTransferUI", intent);
                        }
                    }
                }
                setResult(-1, getIntent());
                finish();
            } else if (i == 4 && i2 == -24 && !bh.ov(str)) {
                Toast.makeText(this, str, 1).show();
            } else if (i != 4 || (!(i2 == -2 || i2 == XWalkUpdater.ERROR_SET_VERNUM) || bh.ov(str))) {
                Toast.makeText(this, R.l.eKc, 0).show();
            } else {
                com.tencent.mm.ui.base.h.a((Context) this, str, getString(R.l.dGO), getString(R.l.dFU), null);
            }
        } catch (Exception e) {
            x.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + e.getMessage());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.nZZ[0] = 1;
        finish();
        return true;
    }
}
