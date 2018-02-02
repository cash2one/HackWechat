package com.tencent.mm.plugin.i.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.List;

public abstract class a {
    protected abstract List<com.tencent.mm.plugin.i.b.a> J(au auVar);

    protected abstract String asP();

    public final void I(au auVar) {
        int i = 0;
        if (auVar != null) {
            List L = b.asG().asH().L(auVar);
            List J = J(auVar);
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int a = a(L, J, arrayList, arrayList2);
            String str = "MicroMsg.AbstractMsgHandler";
            String str2 = "%s handle compare[%d] db[%d] create[%d] insert[%d] update[%d]";
            Object[] objArr = new Object[6];
            objArr[0] = asP();
            objArr[1] = Integer.valueOf(a);
            objArr[2] = Integer.valueOf(L != null ? L.size() : 0);
            if (J != null) {
                i = J.size();
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(arrayList.size());
            objArr[5] = Integer.valueOf(arrayList2.size());
            x.i(str, str2, objArr);
            if (a >= 0) {
                if (!arrayList.isEmpty()) {
                    b.asG().asH().aj(arrayList);
                }
                if (!arrayList2.isEmpty()) {
                    b.asG().asH().ak(arrayList2);
                }
            }
        }
    }

    private static int a(List<com.tencent.mm.plugin.i.b.a> list, List<com.tencent.mm.plugin.i.b.a> list2, List<com.tencent.mm.plugin.i.b.a> list3, List<com.tencent.mm.plugin.i.b.a> list4) {
        if (list2 == null || list2.isEmpty()) {
            return -1;
        }
        com.tencent.mm.plugin.i.b.a aVar;
        if (list == null || list.isEmpty()) {
            for (com.tencent.mm.plugin.i.b.a aVar2 : list2) {
                list3.add(aVar2);
            }
            return 0;
        }
        int size = list.size();
        int size2 = list2.size();
        int i = 0;
        int i2 = 0;
        while (i < size2) {
            aVar2 = (com.tencent.mm.plugin.i.b.a) list2.get(i);
            if (aVar2 != null) {
                com.tencent.mm.plugin.i.b.a aVar3 = i2 < size ? (com.tencent.mm.plugin.i.b.a) list.get(i2) : null;
                if (aVar3 != null) {
                    if (aVar2.field_msgSubType != aVar3.field_msgSubType) {
                        if (aVar2.field_msgSubType >= aVar3.field_msgSubType) {
                            break;
                        }
                        int i3 = i + 1;
                        list3.add(aVar2);
                        i = i3;
                    } else {
                        if (!bh.fu(aVar2.field_path, aVar3.field_path)) {
                            aVar2.xjy = aVar3.xjy;
                            list4.add(aVar2);
                        } else if (!bh.K(aVar2.field_size, aVar3.field_size)) {
                            aVar2.xjy = aVar3.xjy;
                            list4.add(aVar2);
                        }
                        i++;
                        i2++;
                    }
                } else {
                    break;
                }
            }
            break;
        }
        return 1;
    }

    protected static com.tencent.mm.plugin.i.b.a K(au auVar) {
        com.tencent.mm.plugin.i.b.a aVar = new com.tencent.mm.plugin.i.b.a();
        aVar.field_msgId = auVar.field_msgId;
        aVar.field_msgType = auVar.getType();
        aVar.field_username = auVar.field_talker;
        aVar.field_msgtime = auVar.field_createTime;
        return aVar;
    }

    protected final String vS(String str) {
        if (bh.ov(str)) {
            return "";
        }
        String str2 = g.Dj().gQh;
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            return str;
        }
        x.d("MicroMsg.AbstractMsgHandler", "%s cut down result[%s] root[%s] path[%s]", new Object[]{asP(), str.substring(indexOf + str2.length()), str2, str});
        return str.substring(indexOf + str2.length());
    }
}
