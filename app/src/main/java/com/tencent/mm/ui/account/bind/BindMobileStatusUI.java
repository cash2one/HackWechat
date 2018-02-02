package com.tencent.mm.ui.account.bind;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.Map.Entry;

public class BindMobileStatusUI extends MMWizardActivity {
    private SharedPreferences gZO;
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Integer> kCm = new HashMap();
    private Button krY;
    private int status;
    private ImageView xSW;
    private TextView xSX;
    private TextView xSY;
    private ImageView xSZ;
    private ImageView xTa;
    private Boolean xTb = Boolean.valueOf(true);
    private Boolean xTc = Boolean.valueOf(true);
    private RelativeLayout xTd;
    private RelativeLayout xTe;
    private BindWordingContent xTf;
    private int xTg;
    private boolean xTh;
    private boolean xTi;
    private SparseArray<String> xTj = new SparseArray(3);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = q.FW();
        this.xTj.put(8, "settings_find_me_by_mobile");
        this.xTj.put(7, "settings_recommend_mobilefriends_to_me");
        this.xTj.put(32, "settings_autoadd_mobilefriends");
        e(false, WXMediaMessage.TITLE_LENGTH_LIMIT, 8);
        e(false, 256, 7);
        setMMTitle(R.l.dLl);
        this.xTf = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.xTg = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.xTh = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.xTi = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dba;
    }

    protected void onPause() {
        ar.Hg();
        c.CU().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.kCm.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            a wlVar = new wl();
            wlVar.wgL = intValue;
            wlVar.wgM = intValue2;
            ar.Hg();
            c.EX().b(new e.a(23, wlVar));
            x.d("MicroMsg.BindMobileStatusUI", "switch  " + intValue + " " + intValue2);
        }
        this.kCm.clear();
        super.onPause();
    }

    private boolean e(boolean z, int i, int i2) {
        x.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.kCm.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        String str = (String) this.xTj.get(i2);
        if (!(this.gZO == null || str == null || str.length() <= 0)) {
            Boolean valueOf = Boolean.valueOf(z);
            if (i2 == 8 || i2 == 7) {
                valueOf = Boolean.valueOf(!z);
            }
            this.gZO.edit().putBoolean(str, valueOf.booleanValue()).commit();
        }
        return true;
    }

    protected final void initView() {
        boolean z = true;
        this.xSW = (ImageView) findViewById(R.h.bNm);
        this.xSY = (TextView) findViewById(R.h.bNk);
        this.xSX = (TextView) findViewById(R.h.bNj);
        this.krY = (Button) findViewById(R.h.bNl);
        this.xSZ = (ImageView) findViewById(R.h.bNI);
        this.xTa = (ImageView) findViewById(R.h.bNH);
        this.xTd = (RelativeLayout) findViewById(R.h.bNg);
        this.xTe = (RelativeLayout) findViewById(R.h.bNh);
        switch (this.xTg) {
            case 0:
                boolean z2;
                this.xTd.setVisibility(8);
                this.xTe.setVisibility(8);
                if (this.xTh) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                e(z2, WXMediaMessage.TITLE_LENGTH_LIMIT, 8);
                if (this.xTi) {
                    z = false;
                }
                e(z, 256, 7);
                break;
            case 1:
                this.xTd.setVisibility(0);
                this.xTd.setBackgroundResource(R.g.bzr);
                this.xTe.setVisibility(8);
                break;
        }
        if (this.xTf != null) {
            switch (this.xTf.hMv.intValue()) {
                case 2:
                    this.xSX.setVisibility(8);
                    break;
            }
        }
        this.krY.setVisibility(8);
        addTextOptionMenu(0, getString(R.l.dFl), new 1(this));
        if (m.NN() == m.a.hwi || m.NN() == m.a.hwj) {
            this.xSW.setImageResource(R.g.bzp);
            ar.Hg();
            String str = (String) c.CU().get(6, null);
            if (str == null || str.equals("")) {
                ar.Hg();
                c.CU().get(4097, null);
            }
        } else {
            this.xSW.setImageResource(R.g.bzm);
            this.xSX.setVisibility(8);
            this.xSY.setText(getString(R.l.dKG));
        }
        this.xSZ.setOnClickListener(new 2(this));
        this.xTa.setOnClickListener(new 3(this));
        this.krY.setOnClickListener(new 4(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        DU(1);
        return true;
    }

    public static void c(Context context, boolean z, boolean z2) {
        boolean z3 = false;
        int i = 1;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        sharedPreferences.edit().putBoolean("settings_find_me_by_mobile", !z).commit();
        Editor edit = sharedPreferences.edit();
        String str = "settings_recommend_mobilefriends_to_me";
        if (!z2) {
            z3 = true;
        }
        edit.putBoolean(str, z3).commit();
        int FW = q.FW();
        FW = z ? FW | WXMediaMessage.TITLE_LENGTH_LIMIT : FW & -513;
        FW = z2 ? FW | 256 : FW & -257;
        ar.Hg();
        c.CU().set(7, Integer.valueOf(FW));
        a wlVar = new wl();
        wlVar.wgL = 8;
        if (z2) {
            FW = 1;
        } else {
            FW = 2;
        }
        wlVar.wgM = FW;
        ar.Hg();
        c.EX().b(new e.a(23, wlVar));
        a wlVar2 = new wl();
        wlVar2.wgL = 7;
        if (!z) {
            i = 2;
        }
        wlVar.wgM = i;
        ar.Hg();
        c.EX().b(new e.a(23, wlVar2));
        com.tencent.mm.plugin.c.a.ift.um();
    }
}
