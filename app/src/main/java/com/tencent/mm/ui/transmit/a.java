package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public final class a extends o {
    private int count = 0;
    af handler = new af(Looper.getMainLooper());
    HashSet<String> iiv;
    k phA = new 1(this);
    List<String> znS;
    List<com.tencent.mm.plugin.fts.a.a.a> znT;
    List<a> znU;

    private class a {
        String fDj;
        e mMb;
        List<j> mMc;
        int mOR;
        int mOT;
        boolean mOW;
        final /* synthetic */ a znV;
        String znX;

        private a(a aVar) {
            this.znV = aVar;
            this.mOR = Integer.MAX_VALUE;
            this.mOT = Integer.MAX_VALUE;
            this.mOW = true;
        }
    }

    public a(l lVar, List<String> list, int i) {
        super(lVar, null, true, true, i);
        this.znS = list;
        this.znU = new ArrayList();
        this.iiv = new HashSet();
    }

    public final void finish() {
        super.finish();
        for (com.tencent.mm.plugin.fts.a.a.a cancelSearchTask : this.znT) {
            ((m) g.k(m.class)).cancelSearchTask(cancelSearchTask);
        }
    }

    protected final com.tencent.mm.ui.contact.a.a jb(int i) {
        com.tencent.mm.ui.contact.a.a aVar = null;
        int size = this.znU.size() - 1;
        while (size >= 0) {
            com.tencent.mm.ui.contact.a.a gVar;
            a aVar2 = (a) this.znU.get(size);
            if (aVar2.mOR == i) {
                gVar = new com.tencent.mm.ui.contact.a.g(i);
                gVar.mPH = this.ySV.getActivity().getString(R.l.eJo, new Object[]{aVar2.fDj});
            } else if (aVar2.mOT == i) {
                gVar = new i(i);
                gVar.mPo = R.l.ekt;
                gVar.mPp = aVar2.mOW;
            } else if (i > aVar2.mOR) {
                int i2 = (i - aVar2.mOR) - 1;
                j jVar = (j) aVar2.mMc.get(i2);
                if (jVar.mLs.equals("no_result​")) {
                    gVar = new h(i);
                } else {
                    aVar = new d(i);
                    aVar.iVU = jVar;
                    aVar.mMb = aVar2.mMb;
                    aVar.rVq = true;
                    aVar.mPy = i2 + 1;
                    aVar.cC(aVar.iVU.type, aVar.iVU.mLr);
                    gVar = aVar;
                }
            } else {
                gVar = aVar;
            }
            if (gVar != null) {
                gVar.fDj = aVar2.fDj;
                gVar.scene = this.scene;
                gVar.ySW = true;
                return gVar;
            }
            size--;
            aVar = gVar;
        }
        return aVar;
    }

    final void cyg() {
        int i = 0;
        for (a aVar : this.znU) {
            int size;
            if (aVar.mMc.size() > 0) {
                aVar.mOR = i;
                i++;
                if (aVar.mMc.size() > 3) {
                    if (aVar.mOW) {
                        i += 3;
                    } else {
                        i += aVar.mMc.size();
                    }
                    aVar.mOT = i;
                    i++;
                } else {
                    size = aVar.mMc.size() + i;
                }
            } else {
                size = i;
            }
            i = size;
        }
        this.count = i;
        clearCache();
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean Gn(int i) {
        return GO(i);
    }

    private boolean GO(int i) {
        int headerViewsCount = i - this.ySV.btG().getHeaderViewsCount();
        int size = this.znU.size() - 1;
        while (size >= 0) {
            a aVar = (a) this.znU.get(size);
            if (aVar.mOT == headerViewsCount) {
                if (aVar.mOW) {
                    size = this.ySV.btG().getSelectedItemPosition();
                    aVar.mOW = false;
                    cyg();
                    this.ySV.btG().setSelection(size);
                } else {
                    Object obj;
                    aVar.mOW = true;
                    headerViewsCount = 0;
                    while (headerViewsCount < aVar.mMc.size()) {
                        obj = (j) aVar.mMc.get(headerViewsCount);
                        if (obj.mLs.equals(aVar.znX) && headerViewsCount > 2) {
                            break;
                        }
                        headerViewsCount++;
                    }
                    obj = null;
                    headerViewsCount = 0;
                    if (obj != null) {
                        aVar.mMc.remove(headerViewsCount);
                        aVar.mMc.add(0, obj);
                    }
                    cyg();
                    this.ySV.btG().setSelection(i);
                }
                notifyDataSetChanged();
                return true;
            } else if (headerViewsCount == aVar.mOR) {
                return true;
            } else {
                if (i > aVar.mOR) {
                    j jVar = (j) aVar.mMc.get((headerViewsCount - aVar.mOR) - 1);
                    if (!jVar.mLs.equals("no_result​")) {
                        MMCreateChatroomUI mMCreateChatroomUI = (MMCreateChatroomUI) this.ySV;
                        if (t.ov(aVar.znX)) {
                            if (!this.iiv.contains(jVar.mLs)) {
                                mMCreateChatroomUI.ooa.ba(jVar.mLs, false);
                                aVar.znX = jVar.mLs;
                                this.iiv.add(aVar.znX);
                            }
                        } else if (aVar.znX.equals(jVar.mLs)) {
                            mMCreateChatroomUI.ooa.Sh(aVar.znX);
                            this.iiv.remove(aVar.znX);
                            aVar.znX = null;
                        } else if (!this.iiv.contains(jVar.mLs)) {
                            this.iiv.remove(aVar.znX);
                            mMCreateChatroomUI.ooa.Sh(aVar.znX);
                            aVar.znX = jVar.mLs;
                            mMCreateChatroomUI.ooa.ba(aVar.znX, false);
                            this.iiv.add(aVar.znX);
                        }
                        mMCreateChatroomUI.WZ();
                        notifyDataSetChanged();
                        return true;
                    }
                    return true;
                }
                size--;
            }
        }
        return false;
    }

    public final List<String> cyh() {
        Collection hashSet = new HashSet();
        for (a aVar : this.znU) {
            if (!t.ov(aVar.znX)) {
                hashSet.add(aVar.znX);
            }
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        return arrayList;
    }
}
