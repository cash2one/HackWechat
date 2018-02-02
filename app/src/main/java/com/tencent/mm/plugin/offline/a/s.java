package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s {
    private List<WeakReference<a>> kIv = new ArrayList();
    public ArrayList<Long> oUk = new ArrayList();
    public b oXc = null;
    private HashSet<String> oXd = new HashSet();

    public s() {
        Object bhQ = a.bhQ();
        if (!TextUtils.isEmpty(bhQ)) {
            Map y = bi.y(bhQ, "sysmsg");
            if (y != null) {
                int i = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                if (i >= 0 && i == 4) {
                    x.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
                    b(J(y));
                }
            }
        }
        this.oUk.clear();
    }

    public final boolean dX(long j) {
        if (this.oUk == null || this.oUk.size() == 0) {
            x.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
            return false;
        }
        for (int i = 0; i < this.oUk.size(); i++) {
            if (((Long) this.oUk.get(i)).longValue() == j) {
                return true;
            }
        }
        return false;
    }

    private void b(c cVar) {
        if (this.kIv != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null && aVar.a(cVar)) {
                        return;
                    }
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.kIv == null) {
            this.kIv = new ArrayList();
        }
        if (aVar != null) {
            this.kIv.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.kIv != null && aVar != null) {
            for (int i = 0; i < this.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kIv.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.kIv.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    public final void GP(String str) {
        a.Hc("");
        a.He("");
        a.Hd("");
        Map y = bi.y(str, "sysmsg");
        if (y != null) {
            int i = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            int i2 = bh.getInt((String) y.get(".sysmsg.paymsg.pay_cmd"), -1);
            String str2 = (String) y.get(".sysmsg.paymsg.req_key");
            a.Hc((String) y.get(".sysmsg.paymsg.ack_key"));
            a.uu(i);
            a.Hd(str2);
            int i3 = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            x.i("MicroMsg.WalletOfflineMsgManager", "msg type is " + i3);
            x.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[]{Integer.valueOf(i3), str});
            if (i3 >= 0 && i3 == 4) {
                b(J(y));
                a.GT(str);
            } else if (i3 >= 0 && i3 == 5) {
                boolean z;
                if (i2 == 1) {
                    x.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
                    k.bgX();
                    k.bha().dc(4, 4);
                    z = false;
                } else {
                    z = true;
                }
                c eVar = new e(this);
                eVar.oXj = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                eVar.oXk = (String) y.get(".sysmsg.paymsg.cftretcode");
                eVar.oXl = (String) y.get(".sysmsg.paymsg.cftretmsg");
                eVar.oXm = (String) y.get(".sysmsg.paymsg.wxretcode");
                eVar.oXn = (String) y.get(".sysmsg.paymsg.wxretmsg");
                eVar.oXo = (String) y.get(".sysmsg.paymsg.error_detail_url");
                eVar.oXp = true;
                eVar.oXp = z;
                b(eVar);
            } else if (i3 >= 0 && i3 == 6) {
                str2 = (String) y.get(".sysmsg.paymsg.transid");
                x.i("helios", "MSG_TYPE_ORDER trasid=" + str2);
                if (!bh.ov(str2)) {
                    g.Dk();
                    g.Dj().CU().a(w.a.xsv, Boolean.valueOf(true));
                }
                r1 = new f(this);
                r1.oXj = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                r1.oXq = (String) y.get(".sysmsg.paymsg.transid");
                r1.oXr = a.K(y);
                if (r1.oXr.sNW.size() > 0) {
                    a.He(((Commodity) r1.oXr.sNW.get(0)).fuI);
                }
                if (y.containsKey(".sysmsg.paymsg.real_name_info")) {
                    r1.fLm = new h(this, y);
                }
                b(r1);
            } else if (i3 >= 0 && i3 == 7) {
                o.bLq().aJh();
            } else if (i3 >= 0 && i3 == 8) {
                r1 = new g(this);
                r1.oXj = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                r1.oXs = (String) y.get(".sysmsg.paymsg.good_name");
                r1.oXt = (String) y.get(".sysmsg.paymsg.total_fee");
                r1.fwY = (String) y.get(".sysmsg.paymsg.req_key");
                r1.id = (String) y.get(".sysmsg.paymsg.id");
                str2 = (String) y.get(".sysmsg.paymsg.confirm_type");
                x.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + r1.oXu);
                if (TextUtils.isEmpty(str2) || !str2.equals("1")) {
                    r1.oXu = 0;
                } else {
                    r1.oXu = 1;
                }
                b(r1);
            } else if (i3 >= 0 && i3 == 10) {
                k.bgX();
                k.bha().dc(4, 4);
            } else if (i3 >= 0 && i3 == 20) {
                b swVar = new sw();
                swVar.fLl.fLm = new h(this, y);
                com.tencent.mm.sdk.b.a.xef.m(swVar);
            } else if (i3 >= 0 && i3 == 23) {
                r1 = new d(this);
                r1.oXj = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                r1.fwY = (String) y.get(".sysmsg.paymsg.req_key");
                synchronized (this.oXd) {
                    if (this.oXd.contains(r1.fwY)) {
                        x.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[]{r1.fwY});
                        return;
                    }
                    this.oXd.add(r1.fwY);
                    b(r1);
                }
            } else if (i3 >= 0 && i3 == 24) {
                r1 = new d(this);
                r1.oXj = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                r1.fwY = (String) y.get(".sysmsg.paymsg.req_key");
                b(r1);
            }
        }
    }

    private b J(Map<String, String> map) {
        if (this.oXc == null) {
            this.oXc = new b(this);
        }
        this.oXc.oXj = bh.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        this.oXc.oXg = (String) map.get(".sysmsg.paymsg.isfreeze");
        this.oXc.oXh = (String) map.get(".sysmsg.paymsg.freezetype");
        this.oXc.oXi = (String) map.get(".sysmsg.paymsg.freezemsg");
        return this.oXc;
    }

    public final void GQ(String str) {
        int i = bh.getInt((String) bi.y(str, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
        Set hashSet = new HashSet();
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.oVx));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.oVw));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.oVy));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.oVv));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.oVs));
        if (hashSet.contains(Integer.valueOf(i))) {
            g.Dm().F(new 1(this, false));
        }
    }
}
