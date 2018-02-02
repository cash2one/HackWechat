package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class c extends b implements k {
    public String fDj;
    public HashSet<String> mLX = new HashSet();
    private a mMa;
    public List<i.a> mOA = Collections.synchronizedList(new LinkedList());

    public abstract a a(af afVar, HashSet<String> hashSet);

    public abstract b a(int i, i.a aVar);

    public abstract void a(h hVar, HashSet<String> hashSet);

    public c(Context context, i.b bVar, int i) {
        super(context, bVar, i);
    }

    public final void a(String str, af afVar, HashSet<String> hashSet) {
        aNm();
        aaS();
        this.fDj = str;
        this.mMa = a(afVar, (HashSet) hashSet);
    }

    public final void aNm() {
        if (this.mMa != null) {
            ((m) g.k(m.class)).cancelSearchTask(this.mMa);
            this.mMa = null;
        }
    }

    public int qe(int i) {
        int size = this.mOA.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            int i4;
            i.a aVar = (i.a) this.mOA.get(i2);
            aVar.mOR = i3;
            if (aVar.mOS) {
                i3++;
            }
            i3 += aVar.mOV.size() + aVar.mOY;
            aVar.mOT = i3;
            if (aVar.mOU) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        return i3;
    }

    public final b qf(int i) {
        int size = this.mOA.size();
        for (int i2 = 0; i2 < size; i2++) {
            b b;
            i.a aVar = (i.a) this.mOA.get(i2);
            if (aVar.mOR == i && aVar.mOS) {
                b = b(i, aVar);
            } else if (aVar.mOT == i && aVar.mOU) {
                b = c(i, aVar);
            } else if (i <= aVar.mOT) {
                b = a(i, aVar);
            } else {
                b = null;
            }
            if (b != null) {
                if (b.position == aVar.mOT) {
                    b.mPw = false;
                }
                b.mOz = this.mOz;
                b.mMb = aVar.mMb;
                b.mPx = aVar.hKY;
                return b;
            }
        }
        return null;
    }

    public com.tencent.mm.plugin.fts.d.a.c b(int i, i.a aVar) {
        return new com.tencent.mm.plugin.fts.d.a.c(i);
    }

    public e c(int i, i.a aVar) {
        e eVar = new e(i);
        eVar.mPz = aVar.mOT - aVar.mOR;
        return eVar;
    }

    public final void aaS() {
        this.fDj = null;
        this.mLX.clear();
        this.mOA.clear();
    }

    public final void b(h hVar) {
        switch (hVar.bjW) {
            case -3:
            case -2:
            case -1:
                x.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(hVar.bjW), hVar.mJc.fDj});
                if (!hVar.mJc.fDj.equals(this.fDj)) {
                    x.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
                    return;
                }
                break;
            case 0:
                x.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[]{Integer.valueOf(getType()), Integer.valueOf(hVar.mMc.size())});
                if (this.fDj != null && this.fDj.equals(hVar.mJc.fDj)) {
                    this.mLX = hVar.mJc.mLX;
                    a(hVar, this.mLX);
                    break;
                }
                x.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[]{hVar.mJc.fDj, this.fDj});
                return;
            default:
                return;
        }
        this.mOy.a(this, hVar.mJc.fDj);
    }

    public final LinkedList<Integer> aNn() {
        LinkedList<Integer> linkedList = new LinkedList();
        int size = this.mOA.size();
        for (int i = 0; i < size; i++) {
            i.a aVar = (i.a) this.mOA.get(i);
            if (aVar.mOR != Integer.MAX_VALUE) {
                linkedList.add(Integer.valueOf(aVar.mOR));
            }
        }
        return linkedList;
    }

    public b a(int i, j jVar, i.a aVar) {
        return null;
    }

    public final int aNo() {
        int size = this.mOA.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            for (j jVar : ((i.a) this.mOA.get(i2)).mOV) {
                String az = bh.az(jVar.mLs, "");
                Object obj = -1;
                switch (az.hashCode()) {
                    case -19329355:
                        if (az.equals("create_chatroom​")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 255180560:
                        if (az.equals("no_result​")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 541269703:
                        if (az.equals("create_talker_message​")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                    case 1:
                    case 2:
                        break;
                    default:
                        i++;
                        break;
                }
            }
        }
        return i;
    }

    public final int aNp() {
        return aNo();
    }
}
