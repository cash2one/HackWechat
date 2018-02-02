package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.selectcontact.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends o implements b {
    private Cursor iiG;
    private int pOu;
    private a yQN;
    private int yQO;
    private int yQP;
    private int yQQ;
    private int yQR;
    private int yQS;
    private int yQT;
    private HashMap<String, Integer> yQU;
    private SparseArray<String> yQV;

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, a aVar, boolean z3) {
        super(mMBaseSelectContactUI, list, z, z2, z3);
        this.yQO = Integer.MAX_VALUE;
        this.pOu = Integer.MAX_VALUE;
        this.yQP = Integer.MAX_VALUE;
        this.yQQ = Integer.MAX_VALUE;
        this.yQR = Integer.MAX_VALUE;
        this.yQS = Integer.MAX_VALUE;
        this.yQT = Integer.MAX_VALUE;
        this.yQU = null;
        this.yQV = null;
        x.i("MicroMsg.AlphabetContactAdapter", "create!");
        if (aVar != null) {
            this.yQN = aVar;
        } else {
            this.yQN = new a();
        }
        g.Dk();
        ((h) g.h(h.class)).EY().a(this);
        aJh();
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, a aVar) {
        this(mMBaseSelectContactUI, list, true, z, aVar, false);
    }

    private void aJh() {
        this.yQO = Integer.MAX_VALUE;
        this.pOu = Integer.MAX_VALUE;
        this.yQP = Integer.MAX_VALUE;
        this.yQQ = Integer.MAX_VALUE;
        this.yQR = Integer.MAX_VALUE;
        this.yQT = Integer.MAX_VALUE;
        if (this.yQU != null) {
            this.yQU.clear();
        } else {
            this.yQU = new HashMap();
        }
        if (this.yQV != null) {
            this.yQV.clear();
        } else {
            this.yQV = new SparseArray();
        }
        List arrayList = new ArrayList();
        Cursor j;
        int count;
        int i;
        Cursor cO;
        List F;
        if (this.yQN.yRa) {
            g.Dk();
            j = ((h) g.h(h.class)).EY().j(bh.F(this.yQN.yRd.split(",")), false);
            arrayList.add(j);
            count = j.getCount();
            x.d("MicroMsg.AlphabetContactAdapter", "ap: recent like count %d", new Object[]{Integer.valueOf(count)});
            if (count > 0) {
                this.yQT = 0;
                count = (count + 1) + 0;
                aU(this.yQT, "☆");
                i = count;
            } else {
                this.yQT = Integer.MAX_VALUE;
                i = 0;
            }
            g.Dk();
            cO = ((h) g.h(h.class)).EY().cO(bh.F(this.yQN.yRc.split(",")));
            arrayList.add(cO);
            count = cO.getCount();
            if (count > 0) {
                this.yQP = i;
                i += count + 1;
                aU(this.yQP, "☆");
            } else {
                this.yQP = Integer.MAX_VALUE;
            }
            F = bh.F(this.yQN.yRc.split(","));
            g.Dk();
            arrayList.add(((h) g.h(h.class)).EY().j(F, true));
            String[] D = s.D(F);
            int[] C = s.C(F);
            if (!(D == null || C == null)) {
                for (count = 0; count < D.length; count++) {
                    if (count < C.length) {
                        aU(C[count] + i, D[count]);
                        i++;
                    }
                }
                j.getCount();
            }
        } else {
            int i2;
            ar EY;
            String str;
            String str2;
            boolean z;
            String[] a;
            int[] b;
            if (this.yQN.yRb) {
                this.yQS = 0;
                aU(this.yQS, "nonLimit");
                i = 1;
            } else {
                i = 0;
            }
            List F2;
            if (this.yQN.yRe && this.yQN.yRf != null) {
                F2 = bh.F(this.yQN.yRf.split(";"));
                g.Dk();
                cO = ((h) g.h(h.class)).EY().cK(F2);
                arrayList.add(cO);
                count = cO.getCount();
                if (count > 0) {
                    this.yQO = i;
                    i += count + 1;
                    aU(this.yQO, "↑");
                } else {
                    this.yQO = Integer.MAX_VALUE;
                }
            } else if (this.yQN.yQW) {
                F2 = g.ds(this.kiU);
                if (F2.size() == 0) {
                    g.Dk();
                    cO = ((h) g.h(h.class)).EY().aZs();
                } else {
                    g.Dk();
                    cO = ((h) g.h(h.class)).EY().cK(F2);
                }
                arrayList.add(cO);
                count = cO.getCount();
                if (count > 0) {
                    this.pOu = i;
                    i += count + 1;
                    aU(this.pOu, "↑");
                } else {
                    this.pOu = Integer.MAX_VALUE;
                }
            }
            if (this.yQN.yQX) {
                g.Dk();
                cO = ((h) g.h(h.class)).EY().cP(this.kiU);
                arrayList.add(cO);
                count = cO.getCount();
                if (count > 0) {
                    this.yQP = i;
                    i += count + 1;
                    aU(this.yQP, "☆");
                    i2 = i;
                    g.Dk();
                    EY = ((h) g.h(h.class)).EY();
                    str = this.yQN.yPI;
                    str2 = "";
                    F = this.kiU;
                    if (this.yTm) {
                        z = true;
                    } else {
                        z = false;
                    }
                    j = EY.a(str, str2, F, false, z);
                    arrayList.add(j);
                    a = s.a(this.yQN.yPI, "", "", this.kiU);
                    b = s.b(this.yQN.yPI, "", this.kiU, "");
                    if (!(a == null || b == null)) {
                        i = i2;
                        for (count = 0; count < a.length; count++) {
                            if (count < b.length) {
                                aU(b[count] + i, a[count]);
                                i++;
                            }
                        }
                        i2 += j.getCount() + a.length;
                    }
                    if (this.yQN.yQY) {
                        g.Dk();
                        cO = ((h) g.h(h.class)).EY().b("@all.chatroom.contact", "", this.kiU);
                        arrayList.add(cO);
                        count = cO.getCount();
                        if (count <= 0) {
                            this.yQQ = i2;
                            i2 += count + 1;
                            aU(this.yQQ, this.ySV.getActivity().getString(a.h.dCN));
                        } else {
                            this.yQQ = Integer.MAX_VALUE;
                        }
                    }
                    if (this.yQN.yQZ) {
                        g.Dk();
                        cO = ((h) g.h(h.class)).EY().b("@verify.contact", "", this.kiU);
                        arrayList.add(cO);
                        if (cO.getCount() <= 0) {
                            this.yQR = i2;
                            aU(this.yQR, this.ySV.getActivity().getString(a.h.qfP));
                        } else {
                            this.yQR = Integer.MAX_VALUE;
                        }
                    }
                } else {
                    this.yQP = Integer.MAX_VALUE;
                }
            }
            i2 = i;
            g.Dk();
            EY = ((h) g.h(h.class)).EY();
            str = this.yQN.yPI;
            str2 = "";
            F = this.kiU;
            if (this.yTm) {
                z = false;
            } else {
                z = true;
            }
            j = EY.a(str, str2, F, false, z);
            arrayList.add(j);
            a = s.a(this.yQN.yPI, "", "", this.kiU);
            b = s.b(this.yQN.yPI, "", this.kiU, "");
            i = i2;
            for (count = 0; count < a.length; count++) {
                if (count < b.length) {
                    aU(b[count] + i, a[count]);
                    i++;
                }
            }
            i2 += j.getCount() + a.length;
            if (this.yQN.yQY) {
                g.Dk();
                cO = ((h) g.h(h.class)).EY().b("@all.chatroom.contact", "", this.kiU);
                arrayList.add(cO);
                count = cO.getCount();
                if (count <= 0) {
                    this.yQQ = Integer.MAX_VALUE;
                } else {
                    this.yQQ = i2;
                    i2 += count + 1;
                    aU(this.yQQ, this.ySV.getActivity().getString(a.h.dCN));
                }
            }
            if (this.yQN.yQZ) {
                g.Dk();
                cO = ((h) g.h(h.class)).EY().b("@verify.contact", "", this.kiU);
                arrayList.add(cO);
                if (cO.getCount() <= 0) {
                    this.yQR = Integer.MAX_VALUE;
                } else {
                    this.yQR = i2;
                    aU(this.yQR, this.ySV.getActivity().getString(a.h.qfP));
                }
            }
        }
        x.d("MicroMsg.AlphabetContactAdapter", "headerPosMap=%s", new Object[]{this.yQU.toString()});
        this.iiG = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
    }

    private void aU(int i, String str) {
        this.yQU.put(str, Integer.valueOf(i));
        this.yQV.put(i, str);
    }

    public final int Zy(String str) {
        if (str.equals("↑")) {
            return 0;
        }
        if (this.yQU == null || !this.yQU.containsKey(str)) {
            return -1;
        }
        return ((Integer) this.yQU.get(str)).intValue() + this.ySV.btG().getHeaderViewsCount();
    }

    public final int getCount() {
        return this.iiG.getCount() + this.yQU.size();
    }

    protected final com.tencent.mm.ui.contact.a.a jb(int i) {
        if (i == this.yQT) {
            return aV(i, this.ySV.getActivity().getString(a.h.qfR));
        }
        if (i == this.yQO) {
            return aV(i, this.yQN.yRg);
        }
        if (i == this.pOu) {
            return aV(i, this.ySV.getActivity().getString(a.h.qfN));
        }
        if (i == this.yQP) {
            return aV(i, this.ySV.getActivity().getString(a.h.qfM));
        }
        if (i == this.yQQ) {
            return aV(i, this.ySV.getActivity().getString(a.h.dCN));
        }
        if (i == this.yQR) {
            return aV(i, this.ySV.getActivity().getString(a.h.qfP));
        }
        if (i == this.yQS) {
            return new j(i);
        }
        if (this.yQV.indexOfKey(i) >= 0) {
            return aV(i, (String) this.yQV.get(i));
        }
        int i2 = i;
        int i3 = 0;
        while (i3 <= this.yQV.size()) {
            if (this.yQV.indexOfKey(i2) >= 0) {
                i3++;
            }
            i2--;
            if (i2 < 0) {
                break;
            }
        }
        if (this.iiG.moveToPosition(i - i3)) {
            x.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i - i3)});
            com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
            xVar.b(this.iiG);
            com.tencent.mm.ui.contact.a.a dVar = new d(i);
            dVar.jLe = xVar;
            dVar.ySW = btz();
            dVar.ySX = this.ySX;
            return dVar;
        }
        x.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i - i3)});
        return null;
    }

    private static com.tencent.mm.ui.contact.a.a aV(int i, String str) {
        com.tencent.mm.ui.contact.a.a gVar = new com.tencent.mm.ui.contact.a.g(i);
        gVar.mPH = str;
        return gVar;
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.AlphabetContactAdapter", "finish!");
        if (this.iiG != null) {
            this.iiG.close();
            this.iiG = null;
        }
        g.Dk();
        ((h) g.h(h.class)).EY().b(this);
    }

    public final void a(int i, m mVar, Object obj) {
        aJh();
        notifyDataSetChanged();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.yQT, this.yQO, this.pOu, this.yQP, this.yQQ, this.yQR};
        for (int i2 = 0; i2 < 6; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        if (this.yQV.indexOfKey(i) < 0) {
            return false;
        }
        return true;
    }
}
