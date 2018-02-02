package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI.d;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.contact.AddressUI$a;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;
import java.util.HashMap;
import java.util.HashSet;

public final class w {
    private static HashMap<String, Integer> xKG;
    private final long hTf = 180000;
    private int mAs = -1;
    public int mnk = -1;
    MMFragmentActivity xFE;
    private HashSet<l> xKA = new HashSet();
    CustomViewPager xKB;
    a xKC;
    private int xKD = -1;
    private int xKE = -1;
    c xKF = new 1(this);
    public HashMap<Integer, u> xKH = new HashMap();
    public x xKx = new x();
    d xKy;
    boolean xKz;

    public final u cng() {
        return (u) this.xKH.get(Integer.valueOf(this.mnk));
    }

    public final void cmD() {
        j jVar = (j) this.xKH.get(Integer.valueOf(0));
        if (jVar != null) {
            jVar.cvI();
            jVar.cwK();
        }
    }

    public final void cnh() {
        j jVar = (j) this.xKH.get(Integer.valueOf(0));
        if (jVar != null) {
            jVar.cwL();
        }
    }

    public final void eL(int i, int i2) {
        if (i != i2) {
            u DX = DX(i);
            if (DX != null && (DX instanceof l)) {
                ((l) DX).cms();
            }
            DX = DX(i2);
            if (DX != null && (DX instanceof l)) {
                ((l) DX).cmr();
            }
            k.a(this.xFE, 4, i, "deliverOnTabChange");
            k.a(this.xFE, 3, i2, "deliverOnTabChange");
        }
    }

    public final void DV(int i) {
        u DX = DX(i);
        if (DX != null) {
            if (DX instanceof l) {
                ((l) DX).clF();
                this.xKy.clu();
            }
            this.xKC.xKM[i] = true;
        }
    }

    public final void cni() {
        j jVar = (j) this.xKH.get(Integer.valueOf(0));
        ViewGroup viewGroup = (ViewGroup) this.xFE.findViewById(R.h.csz);
        if (viewGroup != null) {
            viewGroup.setImportantForAccessibility(4);
        }
        if (jVar != null) {
            jVar.onHiddenChanged(true);
        }
        k.a(this.xFE, 4, this.mnk, "prepareStartChatting");
        cnh();
        this.xKx.cnk();
    }

    static {
        HashMap hashMap = new HashMap();
        xKG = hashMap;
        hashMap.put("tab_main", Integer.valueOf(0));
        xKG.put("tab_address", Integer.valueOf(1));
        xKG.put("tab_find_friend", Integer.valueOf(2));
        xKG.put("tab_settings", Integer.valueOf(3));
    }

    public final void Yp(String str) {
        if (str != null && !str.equals("")) {
            DW(((Integer) xKG.get(str)).intValue());
        }
    }

    public final void DW(int i) {
        String str = "MicroMsg.LauncherUI.MainTabUI";
        String str2 = "change tab to %d, cur tab %d, has init tab %B, tab cache size %d";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.mnk);
        objArr[2] = Boolean.valueOf(this.xKB != null);
        objArr[3] = Integer.valueOf(this.xKH.size());
        x.i(str, str2, objArr);
        if (this.xKB != null && i >= 0) {
            if (this.xKC != null && i > this.xKC.getCount() - 1) {
                return;
            }
            if (this.mnk != i || this.xKH.size() == 0) {
                this.mnk = i;
                this.xKx.DZ(this.mnk);
                if (this.xKB != null) {
                    this.xKB.d(this.mnk, false);
                    DV(this.mnk);
                }
                if (this.mnk == 0 && g.Di().gPJ.foreground) {
                    ar.getNotification().aU(true);
                } else {
                    ar.getNotification().aU(false);
                }
            }
        }
    }

    public final u DX(int i) {
        u uVar = null;
        x.d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", new Object[]{Integer.valueOf(i)});
        if (i < 0) {
            return null;
        }
        if (this.xKH.containsKey(Integer.valueOf(i))) {
            return (u) this.xKH.get(Integer.valueOf(i));
        }
        Bundle bundle = new Bundle();
        switch (i) {
            case 0:
                bundle.putInt(j.class.getName(), 0);
                uVar = (u) Fragment.instantiate(this.xFE, j.class.getName(), bundle);
                ar.getNotification().aU(true);
                break;
            case 1:
                bundle.putInt(AddressUI$a.class.getName(), 1);
                bundle.putBoolean("Need_Voice_Search", true);
                bundle.putBoolean("favour_include_biz", true);
                uVar = (u) Fragment.instantiate(this.xFE, AddressUI$a.class.getName(), bundle);
                break;
            case 2:
                bundle.putInt(h.class.getName(), 2);
                uVar = (u) Fragment.instantiate(this.xFE, h.class.getName(), bundle);
                break;
            case 3:
                bundle.putInt(y.class.getName(), 3);
                uVar = (u) Fragment.instantiate(this.xFE, y.class.getName(), bundle);
                break;
        }
        x.v("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", new Object[]{Integer.valueOf(i)});
        if (uVar != null) {
            uVar.setParent(this.xFE);
        }
        this.xKH.put(Integer.valueOf(i), uVar);
        return uVar;
    }

    public final int cnj() {
        x xVar = this.xKx;
        return (xVar.xKP == null || xVar.xKP.clH() <= 0) ? 0 : xVar.xKP.clH();
    }

    protected final void cnk() {
        this.xKx.cnk();
    }

    protected final void cnl() {
        this.xKx.cnl();
    }

    protected final void cnm() {
        this.xKx.cnm();
    }

    public final int cnn() {
        int a;
        x xVar = this.xKx;
        long currentTimeMillis = System.currentTimeMillis();
        if (ar.Hj()) {
            a = t.a(s.hfk, af.cnG());
            x.d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", new Object[]{Integer.valueOf(a)});
        } else {
            x.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
            a = 0;
        }
        xVar.DY(a);
        x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(a)});
        return a;
    }
}
