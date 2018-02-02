package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.ay.j;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.chatroom.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.p$a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bg;
import com.tencent.mm.z.ag;
import com.tencent.mm.z.bs;
import com.tencent.mm.z.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation extends f implements a, c, d, n, ag {
    private e hfY = new e();
    private d ooD;
    private e ooE;
    private bs ooF = new bs();
    private b ooG = new b();
    private ag ooH;

    public void installed() {
        alias(n.class);
    }

    public void dependency() {
        dependsOn(PluginZero.class);
    }

    public void configure(g gVar) {
        x.i("MicroMsg.TAG", "init thread pool[%s] current tid[%d] priority[%d] process[%s]", new Object[]{com.tencent.mm.sdk.f.e.cgR(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(Thread.currentThread().getPriority()), ((h) com.tencent.mm.kernel.g.Dg().CN()).gOs});
        com.tencent.mm.plugin.zero.c.vaR = new com.tencent.mm.cd.c<com.tencent.mm.plugin.zero.a.f>(this) {
            final /* synthetic */ PluginMessengerFoundation ooI;

            {
                this.ooI = r1;
            }

            public final /* synthetic */ Object get() {
                return new f();
            }
        };
        p aVar = new a();
        p$a.a(2, aVar);
        p$a.a(17, aVar);
        p$a.a(4, aVar);
        p$a.a(7, new b());
        aVar = new c();
        p$a.a(5, aVar);
        p$a.a(8, aVar);
        p$a.a(9, aVar);
        p$a.a(1, new g());
        com.tencent.mm.kernel.g.Df().a(o.class, new com.tencent.mm.kernel.c.d(new com.tencent.mm.modelmulti.o()));
        com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.zero.a.d.class);
        if (gVar.DS()) {
            new com.tencent.mm.plugin.zero.tasks.b().before(this);
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.foundation.a.c.class, new com.tencent.mm.plugin.messenger.foundation.a.c(this) {
                final /* synthetic */ PluginMessengerFoundation ooI;

                {
                    this.ooI = r1;
                }

                public final void a(arp com_tencent_mm_protocal_c_arp, String str, byte[] bArr, boolean z, boolean z2) {
                    a.a(com_tencent_mm_protocal_c_arp, str, null, true, false);
                }

                public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.b bVar) {
                    return a.a(bVar);
                }
            });
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.foundation.a.g.class, new com.tencent.mm.plugin.messenger.foundation.a.g(this) {
                final /* synthetic */ PluginMessengerFoundation ooI;

                {
                    this.ooI = r1;
                }

                public final void a(com.tencent.mm.ae.d.a aVar, r rVar) {
                    c.a(aVar, rVar);
                }
            });
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.chatroom.b.b.class, this.ooG);
        }
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            this.ooD = new d();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.foundation.a.h.class, new com.tencent.mm.kernel.c.d(this.ooD));
            this.ooE = new e();
            com.tencent.mm.kernel.g.a(i.class, new com.tencent.mm.kernel.c.d(this.ooE));
        }
    }

    public String toString() {
        return "plugin-messenger-foundation";
    }

    public HashMap<Integer, com.tencent.mm.by.h.d> collectDatabaseFactory() {
        HashMap<Integer, com.tencent.mm.by.h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new 5(this));
        hashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new com.tencent.mm.by.h.d(this) {
            final /* synthetic */ PluginMessengerFoundation ooI;

            {
                this.ooI = r1;
            }

            public final String[] wg() {
                return ad.gJN;
            }
        });
        hashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new 7(this));
        hashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new com.tencent.mm.by.h.d(this) {
            final /* synthetic */ PluginMessengerFoundation ooI;

            {
                this.ooI = r1;
            }

            public final String[] wg() {
                return af.gJN;
            }
        });
        hashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new 9(this));
        hashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new 10(this));
        hashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new 2(this));
        return hashMap;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        com.tencent.mm.ae.d.c.a(Integer.valueOf(10000), this.hfY);
        com.tencent.mm.ae.d.c.a(Integer.valueOf(1), this.hfY);
        com.tencent.mm.ae.d.c.a(Integer.valueOf(10001), this.ooF);
        com.tencent.mm.ae.d.c.a(Integer.valueOf(10002), this.ooF);
    }

    public void onAccountRelease() {
        com.tencent.mm.ae.d.c.b(Integer.valueOf(10000), this.hfY);
        com.tencent.mm.ae.d.c.b(Integer.valueOf(1), this.hfY);
        com.tencent.mm.ae.d.c.b(Integer.valueOf(10001), this.ooF);
        com.tencent.mm.ae.d.c.b(Integer.valueOf(10002), this.ooF);
    }

    public void onDataBaseOpened(com.tencent.mm.by.h hVar, com.tencent.mm.by.h hVar2) {
        com.tencent.mm.z.p.FQ();
        d dVar = this.ooD;
        com.tencent.mm.by.h hVar3 = com.tencent.mm.kernel.g.Dj().gQj;
        com.tencent.mm.by.h hVar4 = com.tencent.mm.kernel.g.Dj().gQk;
        dVar.ooA = new com.tencent.mm.ay.r(new j(hVar3));
        dVar.oow = new ad(hVar3);
        dVar.oox = new bg(hVar3);
        dVar.ooz = new af(hVar3);
        dVar.ooy = new av(hVar3, dVar.oow, dVar.ooz);
        dVar.ooB = new bd(hVar3);
        dVar.ooC = new ai(hVar3);
    }

    public void onDataBaseClosed(com.tencent.mm.by.h hVar, com.tencent.mm.by.h hVar2) {
    }

    public bs getSysCmdMsgExtension() {
        return this.ooF;
    }

    public void setIDataTransferFactoryDelegate(ag agVar) {
        this.ooH = agVar;
    }

    public List<com.tencent.mm.z.af> getDataTransferList() {
        if (this.ooH == null) {
            return new ArrayList();
        }
        List<com.tencent.mm.z.af> dataTransferList = this.ooH.getDataTransferList();
        if (dataTransferList.size() <= 7) {
            return dataTransferList;
        }
        Assert.assertTrue("Do not add more IDataTransfer from mIDataTransferFactoryDelegate!!!!!!!!!!!", false);
        return dataTransferList;
    }
}
