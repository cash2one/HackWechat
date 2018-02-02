package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.b;
import com.tencent.mm.z.ar;
import java.util.ArrayList;

public class ModRemarkNameUI extends MMActivity implements e {
    private String fDC;
    private String iIj = "";
    private x jLe;
    private int phF = 9;
    private ArrayList<String> phO;
    private String pix;
    private MMTagPanel pli;
    private bf pyg;
    private TextView yRM;
    private View yRN;
    private View yRO;
    private TextView yRW;
    private EditText yTM;
    private int yTN;
    private String yTO = "";
    private TextView yTP = null;
    private EditText yTQ = null;
    private TextView yTR = null;
    private String yTS = "";
    private boolean yTT = false;
    private a yTU = new a(this, (byte) 0);
    private View yTV;

    static /* synthetic */ void c(ModRemarkNameUI modRemarkNameUI) {
        if (!ar.Hj()) {
            com.tencent.mm.sdk.platformtools.x.e("MiroMsg.ModRemarkName", "!MMCore.hasSetUin()");
        } else if (modRemarkNameUI.yTM == null) {
            com.tencent.mm.sdk.platformtools.x.e("MiroMsg.ModRemarkName", "remarkName == null in dealModNickName(), return");
        } else {
            String trim = modRemarkNameUI.yTM.getText().toString().trim();
            com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ModRemarkName", "Set New RemarkName : " + trim + ", Report kvStat, addContactScene = " + modRemarkNameUI.phF);
            g.pQN.h(10448, new Object[]{Integer.valueOf(modRemarkNameUI.phF)});
            if (modRemarkNameUI.yTT) {
                modRemarkNameUI.jLe.da(trim);
                c bfVar = new bf(modRemarkNameUI.jLe.field_username, trim);
                bfVar.field_conDescription = modRemarkNameUI.yTQ.getText().toString().trim();
                if (!t.ov(modRemarkNameUI.pix)) {
                    bfVar.field_contactLabels = modRemarkNameUI.pix;
                }
                ar.Hg();
                com.tencent.mm.z.c.EZ().a(bfVar);
                if (modRemarkNameUI.jLe != null) {
                    ar.Hg();
                    com.tencent.mm.z.c.EY().Q(modRemarkNameUI.jLe);
                }
            }
            modRemarkNameUI.finish();
        }
    }

    static /* synthetic */ void d(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.yTM.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("k_sns_tag_name", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
    }

    static /* synthetic */ void e(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.yTM.getText().toString().trim();
        if (trim.length() > 50) {
            h.a(modRemarkNameUI.mController.xIM, modRemarkNameUI.getString(R.l.eEU), modRemarkNameUI.getString(R.l.eGf), modRemarkNameUI.getString(R.l.dEn), null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Nick", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
        a.xef.m(new sc());
    }

    static /* synthetic */ void j(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.yTQ.getText().toString().trim();
        boolean z = (modRemarkNameUI.yTS == null || !modRemarkNameUI.yTS.equals(trim)) && !(t.ov(modRemarkNameUI.yTS) && t.ov(trim));
        if (!z) {
            trim = modRemarkNameUI.yTM.getText().toString().trim();
            z = (modRemarkNameUI.yTM == null || !modRemarkNameUI.yTM.equals(trim)) && !(t.ov(modRemarkNameUI.iIj) && t.ov(trim));
            if (!z) {
                modRemarkNameUI.enableOptionMenu(false);
                return;
            }
        }
        modRemarkNameUI.enableOptionMenu(true);
    }

    static /* synthetic */ void k(ModRemarkNameUI modRemarkNameUI) {
        Intent intent = new Intent();
        if (modRemarkNameUI.phO != null) {
            intent.putStringArrayListExtra("label_str_list", modRemarkNameUI.phO);
        }
        intent.putExtra("is_stranger", true);
        intent.putExtra("label_username", modRemarkNameUI.fDC);
        d.b(modRemarkNameUI, "label", ".ui.ContactLabelUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.phF = getIntent().getIntExtra("Contact_Scene", 9);
        this.yTN = getIntent().getIntExtra("Contact_mode_name_type", 0);
        this.yTO = t.ou(getIntent().getStringExtra("Contact_Nick"));
        this.iIj = t.ou(getIntent().getStringExtra("Contact_RemarkName"));
        this.yTT = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
        initView();
        this.yTV = findViewById(R.h.bXC);
        if (this.yTN != 0) {
            this.yTV.setVisibility(8);
        } else {
            this.yTV.setVisibility(0);
        }
        this.pli = (MMTagPanel) findViewById(R.h.bXD);
        this.pli.ndg = false;
        this.yRW = (TextView) findViewById(R.h.bXB);
        this.yRW.setText(R.l.evu);
        this.pli.setOnClickListener(this.yTU);
        this.yRW.setOnClickListener(this.yTU);
    }

    protected final int getLayoutId() {
        return R.i.doq;
    }

    protected final void initView() {
        this.fDC = getIntent().getStringExtra("Contact_User");
        if (this.fDC != null && this.fDC.length() > 0) {
            ar.Hg();
            this.jLe = com.tencent.mm.z.c.EY().WO(this.fDC);
            ar.Hg();
            this.pyg = com.tencent.mm.z.c.EZ().EZ(this.fDC);
            if (this.jLe == null || t.ov(this.jLe.field_username)) {
                this.jLe = new x(this.fDC);
                this.jLe.dc(t.ou(this.yTO));
                this.jLe.da(t.ou(this.iIj));
            }
        }
        this.yTM = (EditText) findViewById(R.h.bXG);
        b 1 = new 1(this);
        TextWatcher aVar = new com.tencent.mm.pluginsdk.ui.tools.h.a();
        aVar.vxI = 1;
        this.yTM.addTextChangedListener(aVar);
        com.tencent.mm.ui.tools.a.c.d(this.yTM).GN(100).a(null);
        if (!(this.jLe == null || this.yTN == 3)) {
            if (this.yTN == 4) {
                this.yTM.setText(i.b(this, t.ou(this.yTO), this.yTM.getTextSize()));
            } else if (!t.ov(this.jLe.field_conRemark)) {
                this.yTM.setText(i.b(this, t.ou(this.jLe.field_conRemark), this.yTM.getTextSize()));
            } else if (!t.ov(this.iIj)) {
                this.yTM.setText(i.b(this, t.ou(this.iIj), this.yTM.getTextSize()));
            } else if (!t.ov(this.jLe.field_nickname)) {
                this.yTM.setText(i.b(this, t.ou(this.jLe.field_nickname), this.yTM.getTextSize()));
            } else if (t.ov(this.yTO)) {
                boolean z;
                String str = this.jLe.field_nickname;
                if (t.ov(str) || str.length() > 50) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    this.yTM.setText(i.b(this, t.ou(this.jLe.AQ()), this.yTM.getTextSize()));
                } else {
                    this.yTM.setText("");
                }
            } else {
                this.yTM.setText(i.b(this, t.ou(this.yTO), this.yTM.getTextSize()));
            }
            this.yTM.setSelection(this.yTM.getText().length());
        }
        if (this.yTN == 0) {
            setMMTitle(R.l.dVG);
            com.tencent.mm.modelfriend.b kR = af.OD().kR(this.jLe.field_username);
            if (!(kR == null || t.ov(kR.Nt()) || kR.Nt().equals(this.yTM.getText()))) {
                this.yRM = (TextView) findViewById(R.h.cwZ);
                this.yRN = findViewById(R.h.cwU);
                this.yRN.setVisibility(0);
                this.yRM.setText(t.ou(getString(R.l.dWt, new Object[]{kR.Nt()})));
                CharSequence jVar = new j(getString(R.l.eXQ));
                jVar.setSpan(new c(this, kR.Nt()), 0, jVar.length(), 17);
                this.yRM.append(" ");
                this.yRM.append(jVar);
                this.yRM.setMovementMethod(LinkMovementMethod.getInstance());
            }
        } else if (this.yTN == 3) {
            setMMTitle(R.l.eQt);
            this.yTM.setHint("");
            if (!t.ov(this.yTO)) {
                this.yTM.setText(this.yTO);
            }
            r0 = (TextView) findViewById(R.h.bXH);
            r0.setText(R.l.eKi);
            r0.setVisibility(0);
            findViewById(R.h.cwV).setVisibility(8);
        } else if (this.yTN == 4) {
            setMMTitle(R.l.eFL);
            this.yTM.setHint("");
            r0 = (TextView) findViewById(R.h.bXH);
            r0.setText(R.l.eGe);
            r0.setVisibility(0);
        }
        addTextOptionMenu(0, getString(R.l.dGx), new 2(this));
        if (this.yTM == null || this.yTM.getText().toString().trim().length() <= 0) {
            enableOptionMenu(false);
        } else {
            enableOptionMenu(true);
        }
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkNameUI yTW;

            {
                this.yTW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.yTW.finish();
                return true;
            }
        });
        this.yTP = (TextView) findViewById(R.h.bXN);
        this.yTQ = (EditText) findViewById(R.h.bXF);
        this.yTR = (TextView) findViewById(R.h.cZH);
        this.yRO = findViewById(R.h.bXE);
        com.tencent.mm.ui.tools.a.c.d(this.yTQ).GN(800).a(null);
        this.yTR.setText(com.tencent.mm.ui.tools.h.aY(800, this.yTQ.getEditableText().toString()));
        this.yTQ.append(i.b(this, t.ou(this.yTS), this.yTQ.getTextSize()));
        this.yTP.append(i.b(this, t.ou(this.yTS), this.yTP.getTextSize()));
        if (this.pyg != null) {
            this.yTQ.setText(i.b(this, t.ou(this.pyg.field_conDescription), this.yTQ.getTextSize()));
            this.yTP.setText(i.b(this, t.ou(this.pyg.field_conDescription), this.yTQ.getTextSize()));
        }
        this.yTQ.addTextChangedListener(new b(this, (byte) 0));
        this.yTP.setOnClickListener(new 4(this));
    }

    protected void onResume() {
        super.onResume();
        ar.Hg();
        this.pyg = com.tencent.mm.z.c.EZ().EZ(this.fDC);
        if (this.pyg != null) {
            this.pix = this.pyg.field_contactLabels;
            this.phO = (ArrayList) com.tencent.mm.plugin.label.a.a.aUX().Dp(this.pix);
        }
        if (t.ov(this.pix)) {
            this.pli.setVisibility(8);
            this.yRW.setVisibility(0);
            return;
        }
        this.pli.setVisibility(0);
        this.yRW.setVisibility(8);
        if (this.phO != null && !this.phO.isEmpty()) {
            this.pli.a(this.phO, this.phO);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 44) {
            if (i != 0 && i2 < 0) {
                com.tencent.mm.sdk.platformtools.x.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
                Toast.makeText(this, getString(R.l.eFY, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            finish();
        }
    }
}
