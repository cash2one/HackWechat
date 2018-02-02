package com.tencent.mm.plugin.favorite.a;

import android.os.Looper;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.vo;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.protocal.c.vq;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class f {
    public HashMap<String, WeakReference<a>> hxK = new HashMap();
    public vq mpI = new vq();
    private HashSet<Integer> mpJ = new HashSet();
    private boolean mpK = true;
    private List<vo> mpL = new LinkedList();

    public f() {
        ar.Hg();
        try {
            this.mpI.aF(bh.VD((String) c.CU().get(225283, "")));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            x.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[]{e.getMessage()});
            this.mpI = new vq();
        }
        x.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[]{this.mpI.wfh});
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.hxK.put(aVar.toString(), new WeakReference(aVar));
        }
    }

    private void eW(boolean z) {
        for (WeakReference weakReference : this.hxK.values()) {
            if (!(weakReference == null || weakReference.get() == null)) {
                if (z) {
                    ((a) weakReference.get()).aIy();
                } else {
                    ((a) weakReference.get()).aIz();
                }
            }
        }
    }

    private void save() {
        byte[] toByteArray;
        try {
            toByteArray = this.mpI.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            x.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", new Object[]{e.getMessage()});
            toByteArray = null;
        }
        ar.Dm().F(new Runnable(this) {
            final /* synthetic */ f mpN;

            public final void run() {
                String by = bh.by(toByteArray);
                ar.Hg();
                c.CU().set(225283, by);
            }

            public final String toString() {
                return super.toString() + "|save";
            }
        });
        this.mpK = true;
    }

    public final List<vo> pI(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        if (this.mpK) {
            x.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
            this.mpL.clear();
            Iterator it = this.mpI.wfh.iterator();
            while (it.hasNext()) {
                this.mpL.addAll(((vp) it.next()).wfg);
            }
            this.mpK = false;
        }
        x.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[]{Integer.valueOf(this.mpL.size())});
        return this.mpL;
    }

    public final int aIx() {
        Iterator it = this.mpI.wfh.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((vp) it.next()).wfg.size() + i;
        }
        return i;
    }

    public final void zX(final String str) {
        if (!bh.ov(str)) {
            if (this.mpJ.contains(Integer.valueOf(str.hashCode()))) {
                x.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[]{str});
                return;
            }
            this.mpJ.add(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                x.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[]{str});
                ag.y(new Runnable(this) {
                    final /* synthetic */ f mpN;

                    public final void run() {
                        this.mpN.zY(str);
                    }
                });
                return;
            }
            x.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[]{str});
            zY(str);
        }
    }

    final void zY(String str) {
        int i;
        vp vpVar;
        vp vpVar2;
        vo voVar;
        int i2 = 0;
        String ol = com.tencent.mm.platformtools.c.ol(str.toLowerCase());
        if (ol == null || ol.length() <= 0) {
            i = 35;
        } else {
            i = ol.charAt(0);
        }
        Iterator it = this.mpI.wfh.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            vpVar = (vp) it.next();
            if (vpVar.wff == i) {
                break;
            } else if (vpVar.wff > i) {
                vpVar = new vp();
                vpVar.wff = i;
                this.mpI.wfh.add(i3, vpVar);
                break;
            } else {
                i3++;
            }
        }
        vpVar = null;
        if (vpVar == null) {
            vpVar = new vp();
            vpVar.wff = i;
            this.mpI.wfh.add(vpVar);
            vpVar2 = vpVar;
        } else {
            vpVar2 = vpVar;
        }
        Iterator it2 = vpVar2.wfg.iterator();
        while (it2.hasNext()) {
            int compareTo;
            voVar = (vo) it2.next();
            i3 = voVar.wfe.compareTo(ol);
            if (i3 == 0) {
                compareTo = voVar.tCr.compareTo(str);
            } else {
                compareTo = i3;
            }
            if (compareTo != 0) {
                if (compareTo > 0) {
                    voVar = new vo();
                    voVar.tCr = str;
                    voVar.wfe = ol;
                    vpVar2.wfg.add(i2, voVar);
                    save();
                    eW(true);
                    return;
                }
                i2++;
            } else {
                return;
            }
        }
        voVar = new vo();
        voVar.tCr = str;
        voVar.wfe = ol;
        vpVar2.wfg.add(voVar);
        eW(true);
        save();
    }

    public final void l(com.tencent.mm.plugin.fav.a.f fVar) {
        if (fVar != null) {
            for (String removeTag : fVar.field_tagProto.wfj) {
                removeTag(removeTag);
            }
        }
    }

    public final void c(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            x.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", new Object[]{set});
            for (String removeTag : set) {
                removeTag(removeTag);
            }
        }
    }

    private void removeTag(final String str) {
        if (!bh.ov(str)) {
            this.mpJ.remove(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                x.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[]{str});
                ag.y(new Runnable(this) {
                    final /* synthetic */ f mpN;

                    public final void run() {
                        this.mpN.zZ(str);
                    }
                });
                return;
            }
            x.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[]{str});
            zZ(str);
        }
    }

    final void zZ(String str) {
        char c;
        vp vpVar;
        String ol = com.tencent.mm.platformtools.c.ol(str.toLowerCase());
        if (ol == null || ol.length() <= 0) {
            c = '#';
        } else {
            c = ol.charAt(0);
        }
        Iterator it = this.mpI.wfh.iterator();
        int i = 0;
        while (it.hasNext()) {
            vp vpVar2 = (vp) it.next();
            if (vpVar2.wff == c) {
                vpVar = vpVar2;
                break;
            } else if (vpVar2.wff <= c) {
                i++;
            } else {
                return;
            }
        }
        vpVar = null;
        if (vpVar != null) {
            Iterator it2 = vpVar.wfg.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                vo voVar = (vo) it2.next();
                int compareTo = voVar.wfe.compareTo(ol);
                if (compareTo == 0) {
                    compareTo = voVar.tCr.compareTo(str);
                }
                if (compareTo == 0) {
                    if (!h.aIv().zV(voVar.tCr)) {
                        vpVar.wfg.remove(i2);
                        if (vpVar.wfg.isEmpty()) {
                            this.mpI.wfh.remove(i);
                        }
                        eW(false);
                        save();
                        return;
                    }
                    return;
                } else if (compareTo <= 0) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
