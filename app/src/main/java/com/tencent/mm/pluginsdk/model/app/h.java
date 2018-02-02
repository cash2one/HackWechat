package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ab.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class h implements e, t, b {
    Map<String, Integer> iUO;
    private List<String> qkX;
    private List<String> vec;
    private ak ved;
    private List<String> vem;
    private List<String> ven;
    private volatile boolean veo;

    public h() {
        this.vec = null;
        this.qkX = null;
        this.iUO = null;
        this.veo = false;
        this.ved = new ak(Looper.getMainLooper(), new 1(this), false);
        this.vec = new ArrayList();
        this.qkX = new ArrayList();
        this.iUO = new HashMap();
        this.vem = new Vector();
        this.ven = new ArrayList();
        this.ved.J(600000, 600000);
        g.Di().gPJ.a(231, this);
        a.aRi().a(7, (t) this);
    }

    public final String l(Context context, String str) {
        return g.l(context, str);
    }

    public final void at(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.AppInfoService", "batch push appinfo err: null or nil applist");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            RC((String) it.next());
        }
        bYH();
    }

    private synchronized void RC(String str) {
        if (bh.ov(str) || this.vem.contains(str)) {
            x.i("MicroMsg.AppInfoService", "should not add this appid:[%s], it is already runing", new Object[]{str});
        } else if (RE(str)) {
            x.i("MicroMsg.AppInfoService", "add appid:[%s]", new Object[]{str});
            this.vem.add(str);
        } else {
            x.e("MicroMsg.AppInfoService", "this app has reach the max retry count, appid is %s", new Object[]{str});
        }
    }

    public final void RD(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoService", "push fail, appId is null");
            return;
        }
        x.i("MicroMsg.AppInfoService", "push appid : " + str);
        RC(str);
        bYH();
    }

    private void bYH() {
        int i = 20;
        if (this.veo) {
            x.d("MicroMsg.AppInfoService", " batch get appinfo doing now");
        } else if (this.vem == null || this.vem.isEmpty()) {
            x.d("MicroMsg.AppInfoService", "batchwaitinglist is empty, no need to doscene");
        } else {
            int size = this.vem.size();
            if (size <= 20) {
                i = size;
            }
            synchronized (this) {
                this.ven.addAll(this.vem.subList(0, i));
            }
            if (this.ven != null && !this.ven.isEmpty()) {
                this.veo = true;
                g.Di().gPJ.a(new x(7, new ad(this.ven)), 0);
            }
        }
    }

    private boolean RE(String str) {
        if (str == null) {
            x.e("MicroMsg.AppInfoService", "increaseCounter fail, appId is null");
            return false;
        }
        Integer valueOf = Integer.valueOf(bh.a((Integer) this.iUO.get(str), 0));
        if (valueOf.intValue() >= 5) {
            x.e("MicroMsg.AppInfoService", "increaseCounter fail, has reached the max try count");
            return false;
        }
        this.iUO.put(str, Integer.valueOf(valueOf.intValue() + 1));
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        switch (type) {
            case 231:
                String str2 = ((ac) kVar).appId;
                if (this.vec.contains(str2)) {
                    this.vec.remove(str2);
                }
                while (this.qkX.size() > 0) {
                    boolean z;
                    str2 = (String) this.qkX.remove(0);
                    if (str2 == null || str2.length() == 0) {
                        x.e("MicroMsg.AppInfoService", "startDownload fail, appId is null");
                        z = false;
                        continue;
                    } else if (RE(str2)) {
                        g.Di().gPJ.a(new ac(str2), 0);
                        z = true;
                        continue;
                    } else {
                        x.e("MicroMsg.AppInfoService", "increaseCounter fail");
                        z = false;
                        continue;
                    }
                    if (z) {
                        this.vec.add(str2);
                        return;
                    }
                }
                return;
            case 451:
                synchronized (this) {
                    if (!(this.ven == null || this.ven.isEmpty())) {
                        this.vem.removeAll(this.ven);
                        this.ven.clear();
                    }
                }
                this.veo = false;
                bYH();
                return;
            default:
                x.e("MicroMsg.AppInfoService", "error type: " + type);
                return;
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (wVar.getType() != 7) {
            x.d("MicroMsg.AppInfoService", "not the getappinfolist scene, ignore");
            return;
        }
        synchronized (this) {
            if (!(this.ven == null || this.ven.isEmpty())) {
                this.vem.removeAll(this.ven);
                this.ven.clear();
            }
        }
        this.veo = false;
        bYH();
    }
}
