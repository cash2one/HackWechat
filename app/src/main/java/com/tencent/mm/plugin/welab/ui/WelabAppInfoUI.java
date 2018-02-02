package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.welab.a$d;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.b;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.c.anv;
import com.tencent.mm.protocal.c.anw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.List;

public class WelabAppInfoUI extends MMActivity {
    private String fFm;
    private TextView ihS;
    private TextView jNW;
    private Button mvX;
    private TextView pjN;
    private a tPF;
    private int tPG;
    private boolean tPH;
    private WelabRoundCornerImageView tPI;
    private RecyclerView tPJ;
    private View tPK;
    private View tPL;
    private MMSwitchBtn tPM;
    private View tPN;
    private View tPO;
    private a tPP;
    private OnClickListener tPQ = new 5(this);

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.fFm = intent.getStringExtra("para_appid");
            this.tPF = b.bVu().Qw(this.fFm);
            this.tPG = this.tPF.field_Switch;
            if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
                z = false;
            }
            this.tPH = z;
        }
        initView();
        e.o(this.fFm, 2, this.tPH);
    }

    protected final int getLayoutId() {
        return c.tPp;
    }

    protected final void initView() {
        super.initView();
        if (this.tPF == null) {
            x.e("WelabAppInfoUI", "info is null");
            return;
        }
        cmS();
        DP(8);
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.tOY));
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.tOY));
        }
        setBackBtn(new 1(this));
        this.tPI = (WelabRoundCornerImageView) findViewById(com.tencent.mm.plugin.welab.a.b.tOZ);
        this.ihS = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.title);
        this.pjN = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.summary);
        this.tPJ = (RecyclerView) findViewById(com.tencent.mm.plugin.welab.a.b.tPd);
        this.tPK = findViewById(com.tencent.mm.plugin.welab.a.b.tPa);
        this.mvX = (Button) findViewById(com.tencent.mm.plugin.welab.a.b.cBI);
        this.tPL = findViewById(com.tencent.mm.plugin.welab.a.b.tPb);
        this.tPM = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.welab.a.b.checkbox);
        this.jNW = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.tPl);
        this.tPN = findViewById(com.tencent.mm.plugin.welab.a.b.tPk);
        this.tPO = findViewById(com.tencent.mm.plugin.welab.a.b.tPh);
        this.tPJ.a(new LinearLayoutManager(0, false));
        this.tPJ.setOverScrollMode(2);
        this.tPP = new a(this);
        this.tPJ.a(this.tPP);
    }

    protected void onPause() {
        super.onPause();
        if (this.tPG != this.tPF.field_Switch) {
            b.bVu().tPx.c(this.tPF, new String[0]);
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_anw = new anw();
            anv com_tencent_mm_protocal_c_anv = new anv();
            com_tencent_mm_protocal_c_anv.wuJ = bh.VI(this.tPF.field_expId);
            com_tencent_mm_protocal_c_anv.wuK = this.tPF.field_LabsAppId;
            com_tencent_mm_protocal_c_anv.wgQ = this.tPF.field_Switch == 2 ? 1 : 2;
            com_tencent_mm_protocal_c_anw.gBH.add(com_tencent_mm_protocal_c_anv);
            ((h) g.h(h.class)).EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(207, com_tencent_mm_protocal_c_anw));
            e.o(this.fFm, this.tPF.field_Switch == 2 ? 4 : 5, this.tPH);
        }
    }

    protected void onResume() {
        TextView textView;
        com.tencent.mm.aq.a.a PH;
        super.onResume();
        if (this.tPF.bVF() && this.tPF.field_Type == 1) {
            this.tPK.setVisibility(0);
            this.jNW.setText(getResources().getString(a$d.tPu) + this.tPF.QD("field_Title"));
            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
            this.tPM.setEnabled(true);
            if (this.tPF.field_Switch == 2) {
                sharedPreferences.edit().putBoolean(bVG(), true).commit();
                this.tPM.nB(true);
            } else {
                sharedPreferences.edit().putBoolean(bVG(), false).commit();
                this.tPM.nB(false);
            }
            this.tPM.zvp = new 2(this);
        } else {
            this.tPK.setVisibility(8);
        }
        if (this.tPF.bVF()) {
            this.mvX.setText(getResources().getString(a$d.tPs) + this.tPF.QD("field_Title"));
            if (this.tPF.field_Type != 1) {
                this.mvX.setVisibility(0);
                this.mvX.setOnClickListener(new 3(this));
                textView = this.ihS;
                b.bVu();
                textView.setText(b.a(this.tPF));
                this.pjN.setText(this.tPF.QD("field_Introduce"));
                if (this.tPF.bVF()) {
                    this.tPL.setVisibility(8);
                } else {
                    this.tPL.setVisibility(0);
                    this.tPL.setOnClickListener(new 4(this));
                }
                if (this.tPF.bVF()) {
                    this.tPN.setVisibility(0);
                    this.tPO.setVisibility(8);
                } else {
                    this.tPN.setVisibility(8);
                    this.tPO.setVisibility(0);
                }
                bVH();
                this.tPI.tQd = 0.5f;
                PH = com.tencent.mm.aq.a.a.PH();
                b.bVu();
                PH.a(b.b(this.tPF), this.tPI, b.bVu().tlo);
            }
        }
        this.mvX.setVisibility(8);
        textView = this.ihS;
        b.bVu();
        textView.setText(b.a(this.tPF));
        this.pjN.setText(this.tPF.QD("field_Introduce"));
        if (this.tPF.bVF()) {
            this.tPL.setVisibility(8);
        } else {
            this.tPL.setVisibility(0);
            this.tPL.setOnClickListener(new 4(this));
        }
        if (this.tPF.bVF()) {
            this.tPN.setVisibility(0);
            this.tPO.setVisibility(8);
        } else {
            this.tPN.setVisibility(8);
            this.tPO.setVisibility(0);
        }
        bVH();
        this.tPI.tQd = 0.5f;
        PH = com.tencent.mm.aq.a.a.PH();
        b.bVu();
        PH.a(b.b(this.tPF), this.tPI, b.bVu().tlo);
    }

    private String bVG() {
        return "switch_" + this.tPF.field_LabsAppId;
    }

    private void bVH() {
        String QD = this.tPF.QD("field_ImgUrl_android");
        if (TextUtils.isEmpty(QD)) {
            QD = this.tPF.QD("field_ImgUrl");
        }
        List Qz = com.tencent.mm.plugin.welab.g.Qz(QD);
        Iterator it = Qz.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty((String) it.next())) {
                it.remove();
            }
        }
        if (Qz.isEmpty()) {
            this.tPJ.setVisibility(8);
            return;
        }
        this.tPJ.setVisibility(0);
        this.tPP.lli = Qz;
        this.tPP.UR.notifyChanged();
    }
}
