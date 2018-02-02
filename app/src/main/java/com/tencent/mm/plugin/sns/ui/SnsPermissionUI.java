package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import java.util.LinkedList;
import java.util.List;

public class SnsPermissionUI extends MMPreference implements e {
    private f ilB;
    private boolean rEJ = false;
    private x rEK = null;
    private boolean rEL = false;
    private boolean rEM = false;
    private long rEN = 0;
    private int scene = 0;
    public r tipDialog = null;
    private String userName = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Dk();
        g.Di().gPJ.a(JsApiCreateAudioInstance.CTRL_INDEX, this);
        this.userName = getIntent().getStringExtra("sns_permission_userName");
        this.rEJ = getIntent().getBooleanExtra("sns_permission_anim", false);
        this.rEN = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0);
        this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[]{Integer.valueOf(this.scene)});
        g.Dk();
        this.rEK = ((h) g.h(h.class)).EY().WO(this.userName);
        if (this.rEK == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[]{this.userName});
            finish();
        }
        this.rEK.setUsername(this.userName);
        initView();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
        setResult(-1, new Intent());
        finish();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        a.ift.um();
        g.Dk();
        g.Di().gPJ.b(JsApiCreateAudioInstance.CTRL_INDEX, this);
        if (this.rEN != 0 && this.rEN != -1) {
            b pqVar = new pq();
            pqVar.fHs.fHt = this.rEM;
            pqVar.fHs.fwn = this.rEN;
            com.tencent.mm.sdk.b.a.xef.m(pqVar);
        }
    }

    public final int XB() {
        return m.qNk;
    }

    protected final void initView() {
        this.ilB = this.yjd;
        setMMTitle(j.qLN);
        setBackBtn(new 1(this));
        bqU();
    }

    private void bqU() {
        g.Dk();
        this.rEK = ((h) g.h(h.class)).EY().WO(this.userName);
        this.rEK.setUsername(this.userName);
        boolean AK = this.rEK.AK();
        boolean LZ = LZ(this.userName);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("sns_outside_permiss");
        checkBoxPreference.tSw = AK;
        int i = this.rEK.fWf;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[]{Integer.valueOf(i)});
        if (i == 1) {
            checkBoxPreference.setTitle(j.qLM);
        } else if (i == 2) {
            checkBoxPreference.setTitle(j.qLL);
        }
        checkBoxPreference = (CheckBoxPreference) this.ilB.YN("sns_black_permiss");
        if (i == 1) {
            checkBoxPreference.setTitle(j.qKm);
        } else if (i == 2) {
            checkBoxPreference.setTitle(j.qKl);
        }
        checkBoxPreference.tSw = LZ;
        if (!com.tencent.mm.l.a.fZ(this.rEK.field_type)) {
            this.ilB.YO("sns_black_permiss");
        }
        this.ilB.notifyDataSetChanged();
    }

    private static boolean LZ(String str) {
        s eT = ae.bvB().eT(5);
        if (bh.ov(eT.field_memberList)) {
            return false;
        }
        return bh.F(eT.field_memberList.split(",")).contains(str);
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + kVar.getType());
        if (kVar.getType() == JsApiCreateAudioInstance.CTRL_INDEX) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SnsPermissionUI", "tipDialog " + (this.tipDialog == null));
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            bqU();
            if (this.rEL) {
                this.rEM = true;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        b qbVar;
        if (str.equals("sns_outside_permiss")) {
            qbVar = new qb();
            qbVar.fHH.fHJ = true;
            qbVar.fHH.fHI = false;
            qbVar.fHH.username = this.userName;
            com.tencent.mm.sdk.b.a.xef.m(qbVar);
            if (this.rEK.AK()) {
                com.tencent.mm.z.s.k(this.rEK);
            } else {
                com.tencent.mm.z.s.j(this.rEK);
            }
            return true;
        } else if (!str.equals("sns_black_permiss")) {
            return false;
        } else {
            int i;
            qbVar = new qb();
            qbVar.fHH.fHJ = false;
            qbVar.fHH.fHI = true;
            qbVar.fHH.username = this.userName;
            com.tencent.mm.sdk.b.a.xef.m(qbVar);
            boolean LZ = LZ(this.userName);
            String str2 = this.userName;
            if (LZ) {
                i = 2;
            } else {
                i = 1;
            }
            if (i == 1 && 5 == 5) {
                this.rEL = true;
                this.rEM = false;
            } else {
                this.rEL = false;
                this.rEM = false;
            }
            List linkedList = new LinkedList();
            linkedList.add(str2);
            k vVar = new v(i, 5, "", linkedList.size(), linkedList, this.scene);
            g.Dk();
            g.Di().gPJ.a(vVar, 0);
            getString(j.dGO);
            this.tipDialog = com.tencent.mm.ui.base.h.a((Context) this, getString(j.qMp), true, new 2(this, vVar));
            return true;
        }
    }
}
