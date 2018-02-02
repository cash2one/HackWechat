package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class aq$3 implements Runnable {
    final /* synthetic */ aq qXH;

    aq$3(aq aqVar) {
        this.qXH = aqVar;
    }

    public final void run() {
        if (this.qXH.qXC == null && this.qXH.qXD.isEmpty() && this.qXH.hUJ == null && !this.qXH.hUF && !this.qXH.hUG) {
            m mVar;
            m mVar2 = null;
            j jVar = null;
            PBool pBool = new PBool();
            PInt pInt = new PInt();
            PString pString = new PString();
            synchronized (this.qXH.qXF) {
                Iterator it = this.qXH.qXF.iterator();
                while (it.hasNext()) {
                    Object obj;
                    mVar2 = (m) it.next();
                    aq aqVar = this.qXH;
                    if (mVar2 == null) {
                        pBool.value = true;
                        obj = null;
                    } else if (bh.by((long) mVar2.field_createTime) >= 86400) {
                        pBool.value = true;
                        obj = null;
                    } else if (o.TW().bZ(false)) {
                        pBool.value = true;
                        obj = null;
                    } else {
                        bjv m = ai.m(mVar2);
                        if (m == null || m.wNp == null) {
                            x.i("MicroMsg.SnsVideoService", "sns obj is null or sns obj PreDownloadInfo is null");
                            pBool.value = true;
                            obj = null;
                        } else {
                            x.i("MicroMsg.SnsVideoService", "%d check sns video[%s] preload [%d %d %s]", new Object[]{Integer.valueOf(aqVar.hashCode()), mVar2.byq(), Integer.valueOf(m.wNp.wEL), Integer.valueOf(m.wNp.wEM), m.wNp.wEN});
                            if (m.wNp.wEL <= 0) {
                                x.i("MicroMsg.SnsVideoService", "%d can not preload because percent <= 0", new Object[]{Integer.valueOf(aqVar.hashCode())});
                                pBool.value = true;
                                obj = null;
                            } else {
                                pString.value = m.vPO;
                                pInt.value = m.wNp.wEL;
                                if (!b.kK(m.wNp.wEN)) {
                                    int i;
                                    if (an.isWifi(ac.getContext())) {
                                        i = m.wNp.wEM & 1;
                                    } else if (an.is4G(ac.getContext())) {
                                        i = m.wNp.wEM & 2;
                                    } else if (an.is3G(ac.getContext())) {
                                        i = m.wNp.wEM & 4;
                                    } else {
                                        pBool.value = false;
                                        obj = null;
                                    }
                                    if (i > 0) {
                                        pBool.value = false;
                                        obj = 1;
                                    }
                                }
                                pBool.value = false;
                                obj = null;
                            }
                        }
                    }
                    if (pBool.value) {
                        it.remove();
                    }
                    if (obj != null) {
                        jVar = aq.b(mVar2, pInt.value, pString.value);
                        if (jVar != null) {
                            break;
                        }
                        it.remove();
                    } else {
                        mVar2 = null;
                    }
                }
                mVar = mVar2;
            }
            if (mVar != null && jVar != null) {
                Object obj2 = null;
                if (jVar != null) {
                    try {
                        this.qXH.hUJ = new f(jVar, mVar.byq());
                        if (this.qXH.hUJ.a(this.qXH) < 0) {
                            x.w("MicroMsg.SnsVideoService", "%s curr preload task do scene error.", new Object[]{Integer.valueOf(this.qXH.hashCode())});
                            obj2 = 1;
                            this.qXH.hUJ = null;
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SnsVideoService", e, "", new Object[0]);
                        return;
                    }
                }
                obj2 = 1;
                if (obj2 != null) {
                    synchronized (this.qXH.qXF) {
                        Iterator it2 = this.qXH.qXF.iterator();
                        while (it2.hasNext()) {
                            mVar2 = (m) it2.next();
                            if (mVar2 != null && bh.fu(mVar2.byq(), mVar.byq())) {
                                x.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", new Object[]{Integer.valueOf(this.qXH.hashCode()), mVar.byq()});
                                it2.remove();
                            }
                        }
                    }
                }
            }
        }
    }
}
