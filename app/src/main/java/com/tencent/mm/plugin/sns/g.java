package com.tencent.mm.plugin.sns;

import com.tencent.mm.ay.i;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class g extends c<lu> {
    public g() {
        this.xen = lu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(((lu) bVar) instanceof lu)) {
            x.f("MicroMsg.PostSnsAsyncTaskListener", "mismatched event");
            return false;
        } else if (ae.bve()) {
            return false;
        } else {
            int i;
            List linkedList;
            int a;
            x.d("MicroMsg.PostSnsAsyncTask", "check PostTaskSnsPost ");
            if (ae.bvr() != null) {
                ae.bvr().buj();
            }
            x.d("MicroMsg.PostSnsAsyncTask", "check AsyncQueue");
            if (ae.bvl() != null) {
                ae.bvu().buW();
            }
            com.tencent.mm.kernel.g.Dk();
            if (com.tencent.mm.kernel.g.Dh().Cy()) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dh();
                if (!a.Cs()) {
                    i = 1;
                    if (i != 0) {
                        com.tencent.mm.kernel.g.Dk();
                        if ((bh.by(bh.a((Long) com.tencent.mm.kernel.g.Dj().CU().get(68390, null), 0)) * 1000 <= 3600000 ? 1 : 0) != 0) {
                            linkedList = new LinkedList();
                            com.tencent.mm.kernel.g.Dk();
                            a = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68388, null), 0);
                            com.tencent.mm.kernel.g.Dk();
                            i = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68389, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new i.a(10077, a + "," + i));
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Dj().CU().set(68388, Integer.valueOf(0));
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Dj().CU().set(68389, Integer.valueOf(0));
                            }
                            com.tencent.mm.kernel.g.Dk();
                            i = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68391, null), 0);
                            if (i > 0) {
                                linkedList.add(new i.a(28, String.valueOf(i)));
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Dj().CU().set(68391, Integer.valueOf(0));
                            }
                            com.tencent.mm.kernel.g.Dk();
                            a = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68392, null), 0);
                            com.tencent.mm.kernel.g.Dk();
                            i = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68393, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new i.a(10072, a + "," + i));
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Dj().CU().set(68392, Integer.valueOf(0));
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Dj().CU().set(68393, Integer.valueOf(0));
                            }
                            if (!linkedList.isEmpty()) {
                                com.tencent.mm.kernel.g.Dk();
                                ((h) com.tencent.mm.kernel.g.h(h.class)).EX().b(new i(linkedList));
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Dj().CU().set(68390, Long.valueOf(bh.Wo()));
                            }
                        }
                    }
                    return true;
                }
            }
            i = 0;
            if (i != 0) {
                com.tencent.mm.kernel.g.Dk();
                if (bh.by(bh.a((Long) com.tencent.mm.kernel.g.Dj().CU().get(68390, null), 0)) * 1000 <= 3600000) {
                }
                if ((bh.by(bh.a((Long) com.tencent.mm.kernel.g.Dj().CU().get(68390, null), 0)) * 1000 <= 3600000 ? 1 : 0) != 0) {
                    linkedList = new LinkedList();
                    com.tencent.mm.kernel.g.Dk();
                    a = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68388, null), 0);
                    com.tencent.mm.kernel.g.Dk();
                    i = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68389, null), 0);
                    linkedList.add(new i.a(10077, a + "," + i));
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Dj().CU().set(68388, Integer.valueOf(0));
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Dj().CU().set(68389, Integer.valueOf(0));
                    com.tencent.mm.kernel.g.Dk();
                    i = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68391, null), 0);
                    if (i > 0) {
                        linkedList.add(new i.a(28, String.valueOf(i)));
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().CU().set(68391, Integer.valueOf(0));
                    }
                    com.tencent.mm.kernel.g.Dk();
                    a = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68392, null), 0);
                    com.tencent.mm.kernel.g.Dk();
                    i = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68393, null), 0);
                    linkedList.add(new i.a(10072, a + "," + i));
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Dj().CU().set(68392, Integer.valueOf(0));
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Dj().CU().set(68393, Integer.valueOf(0));
                    if (linkedList.isEmpty()) {
                        com.tencent.mm.kernel.g.Dk();
                        ((h) com.tencent.mm.kernel.g.h(h.class)).EX().b(new i(linkedList));
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().CU().set(68390, Long.valueOf(bh.Wo()));
                    }
                }
            }
            return true;
        }
    }
}
