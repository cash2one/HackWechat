package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.pluginsdk.i.a.d.o.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class m$a<Req extends k> extends d<Req> implements e {
    private static final ThreadLocal<j> vhR = new 1();
    private final int vgn;
    private final AtomicInteger vhS = new AtomicInteger(this.vgn);
    public volatile c vhT;

    public m$a(Req req) {
        super(req);
        this.vgn = req.vgn;
    }

    public l a(j jVar) {
        if (!aaf()) {
            return jVar.a(this);
        }
        q RW = a.bZC().RW(bZj());
        if (RW != null) {
            RW.field_status = 1;
            a.bZC().e(RW);
        }
        return jVar.a(this);
    }

    public boolean aaf() {
        return true;
    }

    public final void run() {
        l a = a((j) vhR.get());
        if (a != null) {
            this.vhT.a(this, a);
            return;
        }
        x.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[]{aab()});
    }

    public boolean aac() {
        return false;
    }

    public boolean aad() {
        return true;
    }

    public boolean aae() {
        return false;
    }

    public boolean aag() {
        return true;
    }

    public String getURL() {
        return ((k) aai()).url;
    }

    public final String bZw() {
        return "GET";
    }

    public final Collection<b> bZx() {
        Map requestHeaders = ((k) aai()).getRequestHeaders();
        if (requestHeaders == null || requestHeaders.size() == 0) {
            return null;
        }
        Set<String> keySet = requestHeaders.keySet();
        if (keySet == null || keySet.size() == 0) {
            return null;
        }
        Collection<b> linkedList = new LinkedList();
        for (String str : keySet) {
            String str2 = (String) requestHeaders.get(str);
            if (!bh.ov(str2)) {
                linkedList.add(new b(str, str2));
            }
        }
        return linkedList;
    }

    public final int getConnectTimeout() {
        return ((k) aai()).getConnectTimeout();
    }

    public final int getReadTimeout() {
        return ((k) aai()).getReadTimeout();
    }

    public final int bZy() {
        return ((k) aai()).bZy();
    }

    public final String bZz() {
        return "application/x-www-form-urlencoded;charset=utf-8";
    }

    public final String bZj() {
        return ((k) aai()).vgd;
    }

    public final String getFilePath() {
        return ((k) aai()).getFilePath();
    }

    public boolean aah() {
        boolean z = this.vhS.decrementAndGet() > 0;
        this.vhT.o(bZj(), this.vgn, this.vhS.get());
        return z;
    }

    public boolean bD(long j) {
        this.vhT.s(bZj(), j);
        x.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[]{bZj(), Long.valueOf(aw.cgd())});
        if (aw.cgd() >= j) {
            return true;
        }
        return false;
    }
}
