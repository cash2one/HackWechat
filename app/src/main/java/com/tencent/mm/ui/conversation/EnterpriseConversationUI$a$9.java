package com.tencent.mm.ui.conversation;

import android.os.Message;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.LinkedList;

class EnterpriseConversationUI$a$9 extends af {
    final /* synthetic */ a yZh;

    EnterpriseConversationUI$a$9(a aVar) {
        this.yZh = aVar;
    }

    public final void handleMessage(Message message) {
        if (message != null && message.what == 1 && this.yZh.thisActivity() != null && !this.yZh.thisActivity().isFinishing()) {
            int i;
            int count = a.f(this.yZh).getCount();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i5 < count) {
                int i6;
                ae aeVar = (ae) a.f(this.yZh).getItem(i5);
                if (aeVar != null) {
                    String str = aeVar.field_username;
                    if (str != null) {
                        if (s.gE(str) && f.jZ(str)) {
                            com.tencent.mm.g.b.af WO = ((h) g.h(h.class)).EY().WO(str);
                            boolean Xf = ((h) g.h(h.class)).Fd().Xf(str);
                            Object obj = (WO == null || (WO.field_type & 2048) == 0) ? null : 1;
                            if (obj != null && !Xf) {
                                ((h) g.h(h.class)).Fd().Xd(str);
                            } else if (obj == null && Xf) {
                                ((h) g.h(h.class)).Fd().Xe(str);
                            }
                            if (f.jY(str)) {
                                linkedList2.add(str);
                            }
                            if (aeVar.field_unReadCount > 0) {
                                if (s.hs(str)) {
                                    i = i3;
                                    int i7 = i4;
                                    i4 = i2 + 1;
                                    i6 = i7;
                                } else {
                                    i = i3 + 1;
                                    i6 = aeVar.field_unReadCount + i4;
                                    i4 = i2;
                                }
                                i5++;
                                i2 = i4;
                                i3 = i;
                                i4 = i6;
                            }
                        } else {
                            x.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", new Object[]{str});
                            linkedList.add(str);
                            i6 = i4;
                            i = i3;
                            i4 = i2;
                            i5++;
                            i2 = i4;
                            i3 = i;
                            i4 = i6;
                        }
                    }
                }
                i6 = i4;
                i = i3;
                i4 = i2;
                i5++;
                i2 = i4;
                i3 = i;
                i4 = i6;
            }
            b jx = y.Mm().jx(a.c(this.yZh));
            int i8 = jx != null ? jx.field_qyUin : 0;
            long j = jx != null ? jx.field_wwCorpId : 0;
            long j2 = jx != null ? jx.field_wwUserVid : 0;
            i5 = 0;
            if (!bh.ov(a.l(this.yZh))) {
                i5 = y.Mm().jz(a.l(this.yZh));
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(12892, new Object[]{a.c(this.yZh), Integer.valueOf(a.m(this.yZh)), Integer.valueOf(count), "", Integer.valueOf(a.n(this.yZh)), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(a.o(this.yZh)), Integer.valueOf(i5), Integer.valueOf(i8), Long.valueOf(j), Long.valueOf(j2)});
            x.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{a.c(this.yZh), Integer.valueOf(a.m(this.yZh)), Integer.valueOf(count), "", Integer.valueOf(a.n(this.yZh)), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(a.o(this.yZh)), Integer.valueOf(i5), Integer.valueOf(i8), Long.valueOf(j), Long.valueOf(j2)});
            if (linkedList.size() > 0) {
                ar.Hg();
                c.Fd().aw(linkedList);
                a.f(this.yZh).Xy();
            }
            if (y.Mp().jw(a.c(this.yZh))) {
                y.Mm();
                com.tencent.mm.ag.c.a(a.c(this.yZh), null);
            }
            y.Mp().jw(a.p(this.yZh));
            if (linkedList2.size() > 0) {
                for (i = 0; i < linkedList2.size(); i++) {
                    y.Mp().jw((String) linkedList2.get(i));
                }
            }
        }
    }
}
