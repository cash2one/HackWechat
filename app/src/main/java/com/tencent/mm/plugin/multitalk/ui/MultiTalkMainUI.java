package com.tencent.mm.plugin.multitalk.ui;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.m;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.widget.c;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MultiTalkMainUI extends MMActivity implements com.tencent.mm.plugin.multitalk.a.a {
    protected af lFk;
    private c oHE;
    private f oHF;
    private boolean oHG;
    private boolean oHH = true;
    private boolean oHI = false;
    private Runnable oHJ = new Runnable(this) {
        final /* synthetic */ MultiTalkMainUI oHM;

        {
            this.oHM = r1;
        }

        public final void run() {
            o.bcV().bcD();
        }
    };
    private boolean oHK;
    private BroadcastReceiver oHL = new 3(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        int intExtra = getIntent().getIntExtra("enterMainUiSource", 0);
        if (intExtra == 1 || intExtra == 2) {
            overridePendingTransition(R.a.bqk, R.a.bpQ);
        } else {
            overridePendingTransition(R.a.bqD, R.a.bqE);
        }
        getWindow().addFlags(6946944);
        o.bcV().aSZ();
        if (o.bcV().bct()) {
            this.oHE = new c(this);
            this.oHF = new f(this);
            o.bcV().gS(o.bcV().oGd);
            o.bcV().oGq = this;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            registerReceiver(this.oHL, intentFilter);
            this.oHI = true;
            this.lFk = new af();
            ar.Hh().xI();
            if (!com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
                x.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
                return;
            }
            return;
        }
        finish();
        if (intExtra == 2) {
            getIntent().getStringExtra("enterMainUiWxGroupId");
        }
    }

    protected final int getLayoutId() {
        return R.i.dox;
    }

    protected void onResume() {
        super.onResume();
        switch (6.oHN[o.bcV().oGh.ordinal()]) {
            case 1:
                this.oHF.oIE.setVisibility(8);
                this.oHE.n(o.bcV().oGi);
                if (an.is4G(this)) {
                    o.bcT().z(this);
                } else if (an.is2G(this) || an.is3G(this)) {
                    o.bcT().y(this);
                }
                if (this.oHH) {
                    o.bcV().gT(false);
                    break;
                }
                break;
            case 2:
            case 3:
                this.oHE.bdb();
                this.oHF.o(o.bcV().oGi);
                if (an.is4G(this)) {
                    o.bcT().z(this);
                } else if (an.is2G(this) || an.is3G(this)) {
                    o.bcT().y(this);
                }
                o.bcV().gT(true);
                break;
            case 4:
                this.oHE.bdb();
                this.oHF.o(o.bcV().oGi);
                break;
        }
        if (o.bcV().bcu()) {
            if (o.bcV().bcr()) {
                this.oHF.a(null, true);
            }
            this.lFk.postDelayed(this.oHJ, 2000);
        }
    }

    protected void onPause() {
        PowerManager powerManager = (PowerManager) ac.getContext().getSystemService("power");
        boolean z = (hasWindowFocus() || !((KeyguardManager) ac.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && powerManager.isScreenOn();
        this.oHG = z;
        x.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[]{Boolean.valueOf(this.oHG)});
        if (o.bcV().bcu()) {
            o.bcV().bcE();
            this.oHF.gU(true);
        }
        super.onPause();
    }

    protected void onDestroy() {
        if (this.oHK) {
            o.bcV().gR(false);
        }
        if (this.oHI) {
            unregisterReceiver(this.oHL);
        }
        super.onDestroy();
    }

    protected void onStop() {
        if (!this.oHK && this.oHG) {
            o.bcV().gR(false);
        }
        super.onStop();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            h.a(this, R.l.ewo, R.l.evT, R.l.dDM, R.l.dEn, new 2(this), null);
            return true;
        }
        if (o.bcV().oGh == e.oIx) {
            if (i == 25 || i == 24) {
                o.bcV().stopRing();
                this.oHH = false;
                return true;
            }
        } else if (i == 25) {
            ar.Hh().fz(aTR());
            return true;
        } else if (i == 24) {
            ar.Hh().fy(aTR());
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static int aTR() {
        if (ar.Hh().xL()) {
            return ar.Hh().xX();
        }
        if (o.bcV().nDg.aip()) {
            return 0;
        }
        return 3;
    }

    public final void bda() {
        this.oHK = true;
        Intent intent = new Intent(this, MultiTalkAddMembersUI.class);
        List arrayList = new ArrayList();
        for (MultiTalkGroupMember multiTalkGroupMember : o.bcV().oGi.zQu) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                arrayList.add(multiTalkGroupMember.zQv);
            }
        }
        intent.putExtra("titile", getString(R.l.evU));
        intent.putExtra("chatroomName", o.bcV().oGi.zQs);
        intent.putExtra("always_select_contact", bh.d(arrayList, ","));
        intent.putExtra("key_need_gallery", false);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + i + " resultCode " + i2);
        super.onActivityResult(i, i2, intent);
        this.oHK = false;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            x.i("MicroMsg.MT.MultiTalkMainUI", "add member " + stringExtra);
            List F = bh.F(stringExtra.split(","));
            if (F != null) {
                com.tencent.mm.plugin.multitalk.a.e bcV = o.bcV();
                if (bcV.bct()) {
                    stringExtra = bcV.oGi.zQq;
                    if (bh.ov(stringExtra)) {
                        stringExtra = bcV.oGi.zQr;
                    }
                    o.bcU().oFQ.u(stringExtra, F);
                }
            }
        }
    }

    public final void bbR() {
        switch (6.oHN[o.bcV().oGh.ordinal()]) {
            case 1:
                this.oHE.n(o.bcV().oGi);
                return;
            case 2:
            case 3:
            case 4:
                this.oHF.o(o.bcV().oGi);
                return;
            default:
                return;
        }
    }

    public final void aYX() {
        this.oHE.bdb();
        this.oHF.o(o.bcV().oGi);
    }

    public final void aTg() {
        b jqVar = new jq();
        jqVar.fAq.action = 0;
        com.tencent.mm.sdk.b.a.xef.m(jqVar);
        this.oHF.gV(true);
        o.bcV().oGq = null;
        o.bcV().stopRing();
        finish();
    }

    public final void bbQ() {
        ar.Hh().xJ();
        com.tencent.mm.sdk.f.e.post(new e$6(o.bcV()), "MultiTalkManager_play_end_sound");
        b jqVar = new jq();
        jqVar.fAq.action = 0;
        com.tencent.mm.sdk.b.a.xef.m(jqVar);
        this.oHF.gV(false);
        o.bcV().oGq = null;
        o.bcV().stopRing();
        finish();
    }

    public final void onError(int i) {
        if (i == -1700) {
            f fVar = this.oHF;
            x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
            fVar.gU(false);
            o.bcV().tg(1);
            fVar.oII.setChecked(false);
        }
    }

    public final void bbS() {
        x.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + o.bcV().oGg.size());
        if (o.bcV().bcu()) {
            if (o.bcV().oGg.size() > 0) {
                i.bcM();
                o.bcV().bcD();
            } else {
                o.bcV().bcE();
            }
            f fVar = this.oHF;
            HashSet hashSet = new HashSet();
            hashSet.addAll(o.bcV().oGg);
            if (o.bcV().bcs()) {
                fVar.c(hashSet);
            }
        }
    }

    public final void gM(boolean z) {
        if (o.bcV().bcu()) {
            this.oHF.oIJ.setChecked(z);
        }
    }

    public final void gN(boolean z) {
        if (o.bcV().bcu()) {
            this.oHF.oIK.setChecked(z);
        }
    }

    public final void cQ(int i, int i2) {
        if (o.bcV().bcu()) {
            f fVar = this.oHF;
            f.a aVar = (f.a) fVar.FH(q.FS()).getTag();
            if (!i.th(i2)) {
                if (i.th(i)) {
                    fVar.oII.setChecked(false);
                    aVar.oIX.bdf();
                    fVar.oIH.setVisibility(8);
                    if (fVar.oIS.equals(q.FS()) && fVar.oID.getVisibility() == 0) {
                        fVar.oIS = "";
                        fVar.oIC.setVisibility(0);
                        fVar.oID.setVisibility(8);
                    }
                }
                fVar.gU(false);
            } else if (i.th(i2) && !i.th(i)) {
                fVar.oII.setChecked(true);
                aVar.oIX.bdg();
                aVar.oJa.setVisibility(8);
                ag.h(new b(fVar, aVar), 1500);
                fVar.oIH.setVisibility(0);
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(o.bcV().oGg);
            if (i.ti(i2)) {
                if (i.ti(i2) && !i.ti(i)) {
                    fVar.c(hashSet);
                }
            } else if (i.ti(i)) {
                fVar.bdc();
            }
        }
    }

    public final void a(String str, int[] iArr, int i, int i2, int i3) {
        if (o.bcV().bcu()) {
            this.oHF.a(str, iArr, i, i2, 0, i3);
        }
    }

    public final void a(String str, Bitmap bitmap, int i, int i2) {
        this.oHF.a(str, bitmap, i, i2);
    }

    public final int Fn(String str) {
        RelativeLayout FH = this.oHF.FH(str);
        return FH == null ? -1 : ((f.a) FH.getTag()).oIX.position;
    }

    public final void a(e eVar) {
        if (eVar == e.oIA) {
            f fVar = this.oHF;
            if (fVar.oIU > 0) {
                fVar.oIU = System.currentTimeMillis();
            }
        }
    }

    public final void a(i.a aVar) {
        if (aVar == i.a.oGQ) {
            o.bcT().z(this);
        } else if (aVar == i.a.oGR) {
            o.bcT().y(this);
        } else if (aVar == i.a.oGS) {
            com.tencent.mm.au.a.a(this, R.l.eVz, null);
        }
    }

    public final void aTh() {
        f.a aVar;
        f fVar = this.oHF;
        long j = (long) o.bcV().oGk;
        fVar.ldK.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        com.tencent.mm.plugin.multitalk.a.e bcV = o.bcV();
        String str = bcV.oGi.zQq;
        if (bh.ov(str)) {
            str = bcV.oGi.zQr;
        }
        List aaL = o.bcU().oFQ.aaL(str);
        if (aaL != null) {
            Iterator it = fVar.oIN.iterator();
            while (it.hasNext()) {
                aVar = (f.a) ((RelativeLayout) it.next()).getTag();
                if (aaL.contains(aVar.oIX.username)) {
                    aVar.oIY.setVisibility(0);
                } else {
                    aVar.oIY.setVisibility(8);
                }
            }
        }
        bcV = o.bcV();
        str = bcV.oGi.zQq;
        if (bh.ov(str)) {
            str = bcV.oGi.zQr;
        }
        if (m.oHs == null) {
            m.oHs = new m();
        }
        m mVar = m.oHs;
        List arrayList = new ArrayList();
        mVar.oHt = com.tencent.wecall.talkroom.model.c.cHH().abU(str);
        if (mVar.oHt != null) {
            for (av avVar : mVar.oHt.cHE()) {
                int i = avVar.nEd;
                if (i >= 0) {
                    byte[] bArr = new byte[4];
                    if (o.bcU().oFQ.setAppCmd(10, bArr, i) < 0) {
                        x.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", new Object[]{Integer.valueOf(i)});
                        i = -1;
                    } else {
                        i = bh.aG(bArr);
                        x.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[]{Integer.valueOf(i)});
                    }
                    Object obj = (i == -1 || i >= 5) ? null : 1;
                    if (obj != null) {
                        arrayList.add(avVar.zOC);
                    }
                }
            }
        }
        Iterator it2 = fVar.oIN.iterator();
        while (it2.hasNext()) {
            aVar = (f.a) ((RelativeLayout) it2.next()).getTag();
            if (arrayList.contains(aVar.oIX.username)) {
                aVar.oIZ.setVisibility(0);
            } else {
                aVar.oIZ.setVisibility(8);
            }
        }
    }

    public final boolean bbT() {
        if (this.oHF == null || this.oHF.oIP == null) {
            return false;
        }
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            x.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        x.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 82:
                if (iArr[0] == 0) {
                    x.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
                    return;
                } else {
                    h.a(this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 4(this), new 5(this));
                    return;
                }
            default:
                return;
        }
    }
}
