package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave$RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class g implements e, c {
    public String gOs;
    public HashSet<k> ilQ = new HashSet();
    public HashSet<k> ilR = new HashSet();
    public Dialog ilS = null;
    private Set<Integer> img = new HashSet();
    public Context mContext;
    private d ocw = null;
    public Bundle vf;
    private a zHX;
    private b zHY;

    public g(Context context, d dVar) {
        this.mContext = context;
        this.ocw = dVar;
        this.zHX = new a(this);
        this.zHY = new b(this);
    }

    public final void a(k kVar, boolean z) {
        q(kVar);
        this.ilQ.add(kVar);
        if (z && (this.ilS == null || !(this.ilS == null || this.ilS.isShowing()))) {
            if (this.ilS != null) {
                this.ilS.dismiss();
            }
            if (this.mContext == null) {
                x.w("MicroMsg.WalletNetSceneMgr", "%s activity has destroyed!!!", new Object[]{this});
                return;
            }
            this.ilS = com.tencent.mm.wallet_core.ui.g.a(this.mContext, false, new OnCancelListener(this) {
                final /* synthetic */ g zHZ;

                {
                    this.zHZ = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.zHZ.aXc();
                }
            });
        }
        if (r.ieo && (kVar instanceof i) && (((i) kVar).getUri().contains("authen") || ((i) kVar).getUri().contains("verify"))) {
            ((i) kVar).cBQ();
        }
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(kVar, 0);
    }

    public final void a(k kVar, boolean z, int i) {
        x.d("MicroMsg.WalletNetSceneMgr", "isShowProgress %s %s %s ", new Object[]{this, Boolean.valueOf(z), kVar});
        q(kVar);
        this.ilR.add(kVar);
        if (z && (this.ilS == null || !(this.ilS == null || this.ilS.isShowing()))) {
            if (this.ilS != null) {
                this.ilS.dismiss();
            }
            if (this.mContext == null) {
                x.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                return;
            } else if (i == 1) {
                this.ilS = com.tencent.mm.wallet_core.ui.g.a(this.mContext, false, new OnCancelListener(this) {
                    final /* synthetic */ g zHZ;

                    {
                        this.zHZ = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (this.zHZ.ilS != null && this.zHZ.ilQ.isEmpty()) {
                            this.zHZ.ilS.dismiss();
                            Iterator it = this.zHZ.ilR.iterator();
                            while (it.hasNext()) {
                                k kVar = (k) it.next();
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Di().gPJ.c(kVar);
                            }
                            this.zHZ.ilR.clear();
                        }
                    }
                });
            } else if (i == 2) {
                this.ilS = com.tencent.mm.wallet_core.ui.g.a(this.mContext, this.mContext.getString(a.i.uUT), false, new 3(this));
            } else if (i == 3) {
                this.ilS = com.tencent.mm.wallet_core.ui.g.b(this.mContext, "验证中", new 4(this));
            } else {
                x.i("MicroMsg.WalletNetSceneMgr", "unknown dialog type: %d", new Object[]{Integer.valueOf(i)});
                this.ilS = com.tencent.mm.wallet_core.ui.g.a(this.mContext, false, new 5(this));
            }
        }
        if (r.ieo && (kVar instanceof i) && (((i) kVar).getUri().contains("authen") || ((i) kVar).getUri().contains("verify"))) {
            ((i) kVar).cBQ();
        }
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(kVar, 0);
    }

    public final void aXc() {
        if (this.ilS != null) {
            this.ilS.dismiss();
            this.ilS = null;
        }
        Iterator it = this.ilQ.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.c(kVar);
        }
        it = this.ilR.iterator();
        while (it.hasNext()) {
            kVar = (k) it.next();
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.c(kVar);
        }
        this.ilQ.clear();
        this.ilR.clear();
    }

    public final void ji(int i) {
        this.img.add(Integer.valueOf(i));
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(i, this);
    }

    public final void jj(int i) {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(i, this);
        this.img.remove(Integer.valueOf(i));
        if (this.img.isEmpty()) {
            aXc();
            this.ocw = null;
            this.mContext = null;
            e eVar = this.zHX;
            eVar.zHT = null;
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.b(385, eVar);
            eVar = this.zHY;
            eVar.zHT = null;
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.b(385, eVar);
        }
    }

    public final void aXe() {
        bJV();
    }

    private boolean l(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is %s %s", new Object[]{this, kVar.toString()});
        x.d("MicroMsg.WalletNetSceneMgr", "tofutest: %s errType: %d, errCode: %d, errMsg: %s, %s", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(r.ieo)});
        j jVar;
        if (!r.ieo || !(kVar instanceof j) || ((j) kVar).zIw || ((j) kVar).bJT()) {
            if (kVar instanceof ITenpaySave) {
                ITenpaySave iTenpaySave = (ITenpaySave) kVar;
                if (iTenpaySave instanceof ITenpaySave) {
                    ITenpaySave$RetryPayInfo bJl = iTenpaySave.bJl();
                    if (bJl != null && bJl.cBO()) {
                        b.syh = bJl;
                    }
                }
            }
            if (kVar instanceof j) {
                if (((j) kVar).zIw) {
                    x.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass %s", new Object[]{kVar});
                    return false;
                } else if (((j) kVar).bJT() && (kVar instanceof com.tencent.mm.wallet_core.tenpay.model.a)) {
                    x.d("MicroMsg.WalletNetSceneMgr", "%s save or fetch shouldRetry, network: %B, server: %B", new Object[]{this, Boolean.valueOf(!((j) kVar).zHx), Boolean.valueOf(((j) kVar).zIy)});
                    if ((((j) kVar).zIy || r0) && this.zHY.d((j) kVar)) {
                        return true;
                    }
                    return false;
                }
            }
            if (!(kVar instanceof j) || ((j) kVar).bJT()) {
                return false;
            }
            if (((j) kVar).zIw) {
                x.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
                return false;
            }
            jVar = (j) kVar;
            x.d("MicroMsg.WalletNetSceneMgr", "%s shouldRetry, network: %B, server: %B", new Object[]{this, Boolean.valueOf(!jVar.zHx), Boolean.valueOf(this.zHX.a(jVar))});
            if (!this.zHX.a(jVar) && !r0) {
                return false;
            }
            x.i("MicroMsg.WalletNetSceneMgr", "%s doing delay order query retry", new Object[]{this});
            this.zHX.b(jVar);
            return true;
        }
        jVar = (j) kVar;
        x.i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
        this.zHX.b(jVar);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3;
        boolean z;
        if (this.ilR.contains(kVar)) {
            x.d("MicroMsg.WalletNetSceneMgr", "%s has find scene ", new Object[]{this});
            if (l(i, i2, str, kVar)) {
                x.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[]{this});
                return;
            }
            x.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[]{this});
            this.ilR.remove(kVar);
            i3 = 1;
        } else if (this.ilQ.contains(kVar)) {
            x.d("MicroMsg.WalletNetSceneMgr", "%s has find forcescenes ", new Object[]{this});
            if (l(i, i2, str, kVar)) {
                x.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", new Object[]{this});
                return;
            }
            this.ilQ.remove(kVar);
            x.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", new Object[]{this});
            i3 = 1;
        } else {
            i3 = 0;
        }
        x.i("MicroMsg.WalletNetSceneMgr", "%s onSceneEnd scenes %s forcescenes %s", new Object[]{this, Integer.valueOf(this.ilR.size()), Integer.valueOf(this.ilQ.size())});
        if (this.ilR.isEmpty() && this.ilQ.isEmpty()) {
            bJV();
            z = true;
        } else {
            z = false;
        }
        if (i3 != 0 && this.ocw != null) {
            this.ocw.b(i, i2, str, kVar, z);
        }
    }

    public final void bJV() {
        if (this.ilS != null) {
            this.ilS.dismiss();
            this.ilS = null;
        }
    }

    public final boolean aXd() {
        if (this.ilR.isEmpty() && this.ilQ.isEmpty()) {
            return false;
        }
        return true;
    }

    private void q(k kVar) {
        if (kVar != null && (kVar instanceof l)) {
            ((l) kVar).gOs = this.gOs;
            if (this.vf != null) {
                ((l) kVar).vf = this.vf;
            } else if (this.mContext instanceof WalletBaseUI) {
                ((l) kVar).vf = ((WalletBaseUI) this.mContext).vf;
            }
        }
    }
}
