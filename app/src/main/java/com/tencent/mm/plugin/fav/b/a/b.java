package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.uv;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    l gJk;
    private i mol;
    a mom;
    com.tencent.mm.sdk.e.e mon;
    private a moo = new 1(this);

    private class c {
        ve fEH;
        String fzO;
        long gLl;
        long hzP;
        final /* synthetic */ b mop;
        vr mov;
        int type;

        private c(b bVar) {
            this.mop = bVar;
        }

        public final void b(Cursor cursor) {
            this.hzP = cursor.getLong(0);
            this.type = cursor.getInt(1);
            this.gLl = cursor.getLong(2);
            this.fzO = cursor.getString(3);
            byte[] blob = cursor.getBlob(4);
            if (blob == null || blob.length == 0) {
                x.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
                this.fEH = new ve();
            } else {
                this.fEH = (ve) new ve().aF(blob);
            }
            blob = cursor.getBlob(5);
            if (blob == null || blob.length == 0) {
                this.mov = null;
            } else {
                this.mov = (vr) new vr().aF(blob);
            }
        }
    }

    private class e extends f {
        final /* synthetic */ b mop;

        e(b bVar, g gVar) {
            this.mop = bVar;
            super(gVar);
        }

        protected final void a(h hVar) {
            hVar.mMb = com.tencent.mm.plugin.fts.a.a.e.an(this.mLN.fDj, true);
            HashMap hashMap = new HashMap();
            Cursor a = this.mop.mom.a(hVar.mMb, com.tencent.mm.plugin.fts.a.c.mKb, null, false, false);
            while (a.moveToNext()) {
                k h = new k().h(a);
                j jVar = (j) hashMap.get(Long.valueOf(h.mMf));
                if (jVar == null || d.c(com.tencent.mm.plugin.fts.a.c.mKu, h.mLr, jVar.mLr) < 0) {
                    hashMap.put(Long.valueOf(h.mMf), h);
                }
                if (Thread.interrupted()) {
                    a.close();
                    throw new InterruptedException();
                }
            }
            a.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            hVar.mMc = new ArrayList(hashMap.size());
            for (k add : hashMap.values()) {
                hVar.mMc.add(add);
            }
            if (this.mLN.mLY != null) {
                Collections.sort(hVar.mMc, this.mLN.mLY);
            }
        }

        public final String getName() {
            return "SearchFavoriteTask";
        }
    }

    static /* synthetic */ int a(b bVar, c cVar) {
        uv uvVar;
        long j = cVar.hzP;
        int i = cVar.type;
        long j2 = cVar.gLl;
        String str = cVar.fzO;
        ve veVar = cVar.fEH;
        vr vrVar = cVar.mov;
        int i2 = 0;
        if (veVar != null) {
            uv uvVar2 = new uv();
            vk vkVar = veVar.weS;
            if (vkVar != null) {
                uvVar2.fzO = vkVar.fzO;
                uvVar2.weE = vkVar.wet;
                uvVar2.appId = vkVar.appId;
                uvVar2.fnl = vkVar.fnl;
            }
            if (vrVar != null) {
                if (vrVar.wfi != null) {
                    uvVar2.weF.addAll(vrVar.wfi);
                }
                if (vrVar.wfj != null) {
                    uvVar2.weF.addAll(vrVar.wfj);
                }
            }
            uvVar2.fEH = veVar;
            uvVar2.type = i;
            switch (i) {
                case 1:
                    uvVar2.title = "";
                    uvVar2.desc = veVar.desc;
                    uvVar = uvVar2;
                    break;
                case 2:
                    if (veVar.weU != null && veVar.weU.size() > 0) {
                        uvVar2.title = ((uq) veVar.weU.get(0)).title;
                    }
                    uvVar = uvVar2;
                    break;
                case 4:
                    if (!(veVar.weU == null || veVar.weU.isEmpty())) {
                        uvVar2.title = ((uq) veVar.weU.get(0)).title;
                    }
                    uvVar = uvVar2;
                    break;
                case 5:
                    if (veVar.web != null) {
                        uvVar2.title = veVar.web.title;
                        uvVar2.desc = veVar.web.wfz;
                    }
                    if (!(!bh.ov(uvVar2.title) || veVar.weU == null || veVar.weU.isEmpty())) {
                        uvVar2.title = ((uq) veVar.weU.get(0)).title;
                    }
                    if (bh.ov(uvVar2.desc) && vkVar != null) {
                        uvVar2.desc = vkVar.hOf;
                    }
                    uvVar = uvVar2;
                    break;
                case 6:
                    uvVar2.title = veVar.iIj;
                    if (bh.ov(uvVar2.title)) {
                        if (veVar.wdZ != null) {
                            uvVar2.title = veVar.wdZ.fDu;
                            uvVar2.desc = veVar.wdZ.label;
                        }
                    } else if (veVar.wdZ != null) {
                        uvVar2.desc = veVar.wdZ.fDu;
                    }
                    uvVar = uvVar2;
                    break;
                case 7:
                    if (!(veVar.weU == null || veVar.weU.isEmpty())) {
                        uvVar2.title = ((uq) veVar.weU.get(0)).title;
                        uvVar2.desc = ((uq) veVar.weU.get(0)).desc;
                    }
                    uvVar = uvVar2;
                    break;
                case 8:
                    uvVar2.title = veVar.title;
                    if (!(!bh.ov(uvVar2.title) || veVar.weU == null || veVar.weU.isEmpty())) {
                        uvVar2.title = ((uq) veVar.weU.get(0)).title;
                    }
                    uvVar = uvVar2;
                    break;
                case 10:
                case 11:
                    if (veVar.wed != null) {
                        uvVar2.title = veVar.wed.title;
                        uvVar2.desc = veVar.wed.desc;
                    }
                    uvVar = uvVar2;
                    break;
                case 12:
                case 15:
                    if (veVar.wef != null) {
                        uvVar2.title = veVar.wef.title;
                        uvVar2.desc = veVar.wef.desc;
                    }
                    uvVar = uvVar2;
                    break;
                case 14:
                case 18:
                    List<uq> list = veVar.weU;
                    if (list == null) {
                        uvVar = null;
                        break;
                    }
                    for (uq uqVar : list) {
                        if (1 == uqVar.bjS) {
                            uvVar2.title = uqVar.desc;
                            uvVar = uvVar2;
                            break;
                        }
                    }
                    uvVar = uvVar2;
                default:
                    x.w("MicroMsg.Fav.FavApiLogic", "unknown type %d", new Object[]{Integer.valueOf(i)});
                    uvVar = uvVar2;
                    break;
            }
        }
        x.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
        uvVar = null;
        if (uvVar == null) {
            x.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Fav info is null");
            return 0;
        }
        String str2;
        String am;
        String am2;
        int a;
        af AW;
        int a2;
        List<String> list2;
        StringBuilder stringBuilder;
        String str3;
        int i3;
        StringBuffer stringBuffer;
        Iterator it;
        String str4 = uvVar.weE;
        String str5 = uvVar.fzO;
        if (str4 == null || str4.length() == 0 || str4.equals(str5)) {
            str2 = null;
            str5 = uvVar.fzO;
        } else {
            str2 = str5;
            str5 = str4;
        }
        String str6 = uvVar.fnl;
        String[] strArr = new String[3];
        int[] iArr = new int[3];
        if (str5 != null && str5.length() > 0) {
            af AW2 = bVar.mol.AW(str5);
            if (AW2 != null) {
                String str7 = AW2.field_nickname;
                am = d.am(str7, false);
                am2 = d.am(str7, true);
                String str8 = AW2.field_conRemark;
                str5 = d.am(str8, false);
                String am3 = d.am(str8, true);
                String str9;
                if (str8 == null || str8.length() == 0) {
                    str9 = am;
                    am = null;
                    str5 = str9;
                    str8 = null;
                    am3 = am2;
                    am2 = null;
                } else {
                    str9 = am2;
                    am2 = am;
                    am = str9;
                    String str10 = str7;
                    str7 = str8;
                    str8 = str10;
                }
                strArr[0] = str7;
                strArr[1] = str5;
                strArr[2] = am3;
                iArr[0] = 9;
                iArr[1] = 10;
                iArr[2] = 11;
                int a3 = bVar.a(strArr, iArr, j, i, j2, str) + 0;
                strArr[0] = str8;
                strArr[1] = am2;
                strArr[2] = am;
                iArr[0] = 12;
                iArr[1] = 13;
                iArr[2] = 14;
                i2 = a3 + bVar.a(strArr, iArr, j, i, j2, str);
            }
        }
        if (str2 != null && str2.length() > 0) {
            af AW3 = bVar.mol.AW(str2);
            if (AW3 != null) {
                str5 = AW3.field_conRemark;
                if (str5 == null || str5.length() == 0) {
                    str5 = AW3.field_nickname;
                }
                str2 = d.am(str5, false);
                am2 = d.am(str5, true);
                strArr[0] = str5;
                strArr[1] = str2;
                strArr[2] = am2;
                iArr[0] = 16;
                iArr[1] = 17;
                iArr[2] = 18;
                a = i2 + bVar.a(strArr, iArr, j, i, j2, str);
                if (str6 != null && str6.length() > 0) {
                    AW = bVar.mol.AW(str6);
                    if (AW != null) {
                        str5 = AW.field_conRemark;
                        if (str5 == null || str5.length() == 0) {
                            str5 = AW.field_nickname;
                        }
                        am = d.am(str5, false);
                        am2 = d.am(str5, true);
                        strArr[0] = str5;
                        strArr[1] = am;
                        strArr[2] = am2;
                        iArr[0] = 20;
                        iArr[1] = 21;
                        iArr[2] = 22;
                        a2 = bVar.a(strArr, iArr, j, i, j2, str) + a;
                        list2 = uvVar.weF;
                        stringBuilder = new StringBuilder(256);
                        for (String str52 : list2) {
                            if (str52 != null && str52.length() > 0) {
                                stringBuilder.append(str52).append("​");
                            }
                        }
                        if (stringBuilder.length() > 0) {
                            bVar.mom.a(7, j, str, j2, stringBuilder.toString(), i);
                            a2++;
                        }
                        switch (i) {
                            case 2:
                                str3 = uvVar.title;
                                if (bh.ov(str3)) {
                                    return a2;
                                }
                                bVar.mom.a(23, j, str, j2, str3, i);
                                return a2 + 1;
                            case 5:
                                str3 = uvVar.title;
                                if (bh.ov(str3)) {
                                    return a2;
                                }
                                bVar.mom.a(1, j, str, j2, str3, i);
                                return a2 + 1;
                            case 6:
                                str3 = veVar.iIj;
                                if (bh.ov(str3)) {
                                    bVar.mom.a(4, j, str, j2, str3, i);
                                    i3 = a2 + 1;
                                } else {
                                    i3 = a2;
                                }
                                str3 = veVar.wdZ.fDu;
                                if (!bh.ov(str3)) {
                                    bVar.mom.a(5, j, str, j2, str3, i);
                                    i3++;
                                }
                                str3 = veVar.wdZ.label;
                                if (bh.ov(str3)) {
                                    return i3;
                                }
                                bVar.mom.a(6, j, str, j2, str3, i);
                                return i3 + 1;
                            case 7:
                                str3 = uvVar.title;
                                if (!bh.ov(str3)) {
                                    bVar.mom.a(1, j, str, j2, str3, i);
                                    a2++;
                                }
                                str3 = uvVar.desc;
                                if (bh.ov(str3)) {
                                    return a2;
                                }
                                bVar.mom.a(3, j, str, j2, str3, i);
                                return a2 + 1;
                            case 14:
                                if (veVar.weU == null) {
                                    return a2;
                                }
                                stringBuffer = new StringBuffer();
                                it = veVar.weU.iterator();
                                while (it.hasNext()) {
                                    str52 = com.tencent.mm.plugin.fav.a.b.a((uq) it.next());
                                    if (bh.ov(str52)) {
                                        stringBuilder.append(str52);
                                        stringBuilder.append("​");
                                    }
                                }
                                str3 = stringBuffer.toString();
                                if (bh.ov(str3)) {
                                    return a2;
                                }
                                bVar.mom.a(1, j, str, j2, str3, i);
                                return a2 + 1;
                            default:
                                str3 = uvVar.title;
                                if (!bh.ov(str3)) {
                                    bVar.mom.a(1, j, str, j2, str3, i);
                                    a2++;
                                }
                                str3 = uvVar.desc;
                                if (bh.ov(str3)) {
                                    return a2;
                                }
                                bVar.mom.a(2, j, str, j2, str3, i);
                                return a2 + 1;
                        }
                    }
                }
                a2 = a;
                list2 = uvVar.weF;
                stringBuilder = new StringBuilder(256);
                for (String str522 : list2) {
                    stringBuilder.append(str522).append("​");
                }
                if (stringBuilder.length() > 0) {
                    bVar.mom.a(7, j, str, j2, stringBuilder.toString(), i);
                    a2++;
                }
                switch (i) {
                    case 2:
                        str3 = uvVar.title;
                        if (bh.ov(str3)) {
                            return a2;
                        }
                        bVar.mom.a(23, j, str, j2, str3, i);
                        return a2 + 1;
                    case 5:
                        str3 = uvVar.title;
                        if (bh.ov(str3)) {
                            return a2;
                        }
                        bVar.mom.a(1, j, str, j2, str3, i);
                        return a2 + 1;
                    case 6:
                        str3 = veVar.iIj;
                        if (bh.ov(str3)) {
                            i3 = a2;
                        } else {
                            bVar.mom.a(4, j, str, j2, str3, i);
                            i3 = a2 + 1;
                        }
                        str3 = veVar.wdZ.fDu;
                        if (bh.ov(str3)) {
                            bVar.mom.a(5, j, str, j2, str3, i);
                            i3++;
                        }
                        str3 = veVar.wdZ.label;
                        if (bh.ov(str3)) {
                            return i3;
                        }
                        bVar.mom.a(6, j, str, j2, str3, i);
                        return i3 + 1;
                    case 7:
                        str3 = uvVar.title;
                        if (bh.ov(str3)) {
                            bVar.mom.a(1, j, str, j2, str3, i);
                            a2++;
                        }
                        str3 = uvVar.desc;
                        if (bh.ov(str3)) {
                            return a2;
                        }
                        bVar.mom.a(3, j, str, j2, str3, i);
                        return a2 + 1;
                    case 14:
                        if (veVar.weU == null) {
                            return a2;
                        }
                        stringBuffer = new StringBuffer();
                        it = veVar.weU.iterator();
                        while (it.hasNext()) {
                            str522 = com.tencent.mm.plugin.fav.a.b.a((uq) it.next());
                            if (bh.ov(str522)) {
                                stringBuilder.append(str522);
                                stringBuilder.append("​");
                            }
                        }
                        str3 = stringBuffer.toString();
                        if (bh.ov(str3)) {
                            return a2;
                        }
                        bVar.mom.a(1, j, str, j2, str3, i);
                        return a2 + 1;
                    default:
                        str3 = uvVar.title;
                        if (bh.ov(str3)) {
                            bVar.mom.a(1, j, str, j2, str3, i);
                            a2++;
                        }
                        str3 = uvVar.desc;
                        if (bh.ov(str3)) {
                            return a2;
                        }
                        bVar.mom.a(2, j, str, j2, str3, i);
                        return a2 + 1;
                }
            }
        }
        a = i2;
        AW = bVar.mol.AW(str6);
        if (AW != null) {
            str522 = AW.field_conRemark;
            str522 = AW.field_nickname;
            am = d.am(str522, false);
            am2 = d.am(str522, true);
            strArr[0] = str522;
            strArr[1] = am;
            strArr[2] = am2;
            iArr[0] = 20;
            iArr[1] = 21;
            iArr[2] = 22;
            a2 = bVar.a(strArr, iArr, j, i, j2, str) + a;
            list2 = uvVar.weF;
            stringBuilder = new StringBuilder(256);
            for (String str5222 : list2) {
                stringBuilder.append(str5222).append("​");
            }
            if (stringBuilder.length() > 0) {
                bVar.mom.a(7, j, str, j2, stringBuilder.toString(), i);
                a2++;
            }
            switch (i) {
                case 2:
                    str3 = uvVar.title;
                    if (bh.ov(str3)) {
                        return a2;
                    }
                    bVar.mom.a(23, j, str, j2, str3, i);
                    return a2 + 1;
                case 5:
                    str3 = uvVar.title;
                    if (bh.ov(str3)) {
                        return a2;
                    }
                    bVar.mom.a(1, j, str, j2, str3, i);
                    return a2 + 1;
                case 6:
                    str3 = veVar.iIj;
                    if (bh.ov(str3)) {
                        bVar.mom.a(4, j, str, j2, str3, i);
                        i3 = a2 + 1;
                    } else {
                        i3 = a2;
                    }
                    str3 = veVar.wdZ.fDu;
                    if (bh.ov(str3)) {
                        bVar.mom.a(5, j, str, j2, str3, i);
                        i3++;
                    }
                    str3 = veVar.wdZ.label;
                    if (bh.ov(str3)) {
                        return i3;
                    }
                    bVar.mom.a(6, j, str, j2, str3, i);
                    return i3 + 1;
                case 7:
                    str3 = uvVar.title;
                    if (bh.ov(str3)) {
                        bVar.mom.a(1, j, str, j2, str3, i);
                        a2++;
                    }
                    str3 = uvVar.desc;
                    if (bh.ov(str3)) {
                        return a2;
                    }
                    bVar.mom.a(3, j, str, j2, str3, i);
                    return a2 + 1;
                case 14:
                    if (veVar.weU == null) {
                        return a2;
                    }
                    stringBuffer = new StringBuffer();
                    it = veVar.weU.iterator();
                    while (it.hasNext()) {
                        str5222 = com.tencent.mm.plugin.fav.a.b.a((uq) it.next());
                        if (bh.ov(str5222)) {
                            stringBuilder.append(str5222);
                            stringBuilder.append("​");
                        }
                    }
                    str3 = stringBuffer.toString();
                    if (bh.ov(str3)) {
                        return a2;
                    }
                    bVar.mom.a(1, j, str, j2, str3, i);
                    return a2 + 1;
                default:
                    str3 = uvVar.title;
                    if (bh.ov(str3)) {
                        bVar.mom.a(1, j, str, j2, str3, i);
                        a2++;
                    }
                    str3 = uvVar.desc;
                    if (bh.ov(str3)) {
                        return a2;
                    }
                    bVar.mom.a(2, j, str, j2, str3, i);
                    return a2 + 1;
            }
        }
        a2 = a;
        list2 = uvVar.weF;
        stringBuilder = new StringBuilder(256);
        for (String str52222 : list2) {
            stringBuilder.append(str52222).append("​");
        }
        if (stringBuilder.length() > 0) {
            bVar.mom.a(7, j, str, j2, stringBuilder.toString(), i);
            a2++;
        }
        switch (i) {
            case 2:
                str3 = uvVar.title;
                if (bh.ov(str3)) {
                    return a2;
                }
                bVar.mom.a(23, j, str, j2, str3, i);
                return a2 + 1;
            case 5:
                str3 = uvVar.title;
                if (bh.ov(str3)) {
                    return a2;
                }
                bVar.mom.a(1, j, str, j2, str3, i);
                return a2 + 1;
            case 6:
                str3 = veVar.iIj;
                if (bh.ov(str3)) {
                    i3 = a2;
                } else {
                    bVar.mom.a(4, j, str, j2, str3, i);
                    i3 = a2 + 1;
                }
                str3 = veVar.wdZ.fDu;
                if (bh.ov(str3)) {
                    bVar.mom.a(5, j, str, j2, str3, i);
                    i3++;
                }
                str3 = veVar.wdZ.label;
                if (bh.ov(str3)) {
                    return i3;
                }
                bVar.mom.a(6, j, str, j2, str3, i);
                return i3 + 1;
            case 7:
                str3 = uvVar.title;
                if (bh.ov(str3)) {
                    bVar.mom.a(1, j, str, j2, str3, i);
                    a2++;
                }
                str3 = uvVar.desc;
                if (bh.ov(str3)) {
                    return a2;
                }
                bVar.mom.a(3, j, str, j2, str3, i);
                return a2 + 1;
            case 14:
                if (veVar.weU == null) {
                    return a2;
                }
                stringBuffer = new StringBuffer();
                it = veVar.weU.iterator();
                while (it.hasNext()) {
                    str52222 = com.tencent.mm.plugin.fav.a.b.a((uq) it.next());
                    if (bh.ov(str52222)) {
                        stringBuilder.append(str52222);
                        stringBuilder.append("​");
                    }
                }
                str3 = stringBuffer.toString();
                if (bh.ov(str3)) {
                    return a2;
                }
                bVar.mom.a(1, j, str, j2, str3, i);
                return a2 + 1;
            default:
                str3 = uvVar.title;
                if (bh.ov(str3)) {
                    bVar.mom.a(1, j, str, j2, str3, i);
                    a2++;
                }
                str3 = uvVar.desc;
                if (bh.ov(str3)) {
                    return a2;
                }
                bVar.mom.a(2, j, str, j2, str3, i);
                return a2 + 1;
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(g gVar) {
        com.tencent.mm.plugin.fts.a.a.a fVar;
        if (gVar.mLR == 1) {
            fVar = new f(this, gVar);
        } else {
            fVar = new e(this, gVar);
        }
        return this.gJk.a(-65536, fVar);
    }

    protected final boolean onCreate() {
        if (((m) com.tencent.mm.kernel.g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Success!");
            this.gJk = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon();
            this.mom = (a) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(256);
            this.mol = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSMainDB();
            this.mon = ((r) com.tencent.mm.kernel.g.k(r.class)).getFavItemInfoStorage().aHY();
            this.gJk.a(131122, new a(this, (byte) 0));
            ((r) com.tencent.mm.kernel.g.k(r.class)).getFavItemInfoStorage().c(this.moo);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Fail!");
        return false;
    }

    protected final boolean AZ() {
        ((r) com.tencent.mm.kernel.g.k(r.class)).getFavItemInfoStorage().j(this.moo);
        this.mom = null;
        this.gJk = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchFavoriteLogic";
    }

    private int a(String[] strArr, int[] iArr, long j, int i, long j2, String str) {
        String str2 = strArr[0];
        String str3 = strArr[1];
        String str4 = strArr[2];
        if (str2 == null || str2.length() <= 0) {
            return 0;
        }
        String str5;
        String str6;
        String str7;
        if (str2.equalsIgnoreCase(str3)) {
            str5 = null;
            str6 = null;
        } else {
            str6 = str3;
            str5 = str4;
        }
        if (str6 == null || !str6.equalsIgnoreCase(str5)) {
            str7 = str5;
        } else {
            str7 = null;
        }
        this.mom.a(iArr[0], j, str, j2, str2, i);
        int i2 = 1;
        if (str6 != null && str6.length() > 0) {
            this.mom.a(iArr[1], j, str, j2, str6, i);
            i2 = 2;
        }
        if (str7 == null || str7.length() <= 0) {
            return i2;
        }
        this.mom.a(iArr[2], j, str, j2, str7, i);
        return i2 + 1;
    }
}
