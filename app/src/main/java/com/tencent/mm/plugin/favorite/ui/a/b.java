package com.tencent.mm.plugin.favorite.ui.a;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a;
import com.tencent.mm.plugin.favorite.ui.b.d;
import com.tencent.mm.plugin.favorite.ui.b.g;
import com.tencent.mm.plugin.favorite.ui.b.i;
import com.tencent.mm.plugin.favorite.ui.b.j;
import com.tencent.mm.plugin.favorite.ui.b.k;
import com.tencent.mm.plugin.favorite.ui.b.l;
import com.tencent.mm.plugin.favorite.ui.b.m;
import com.tencent.mm.plugin.favorite.ui.b.n;
import com.tencent.mm.plugin.favorite.ui.b.o;
import com.tencent.mm.plugin.favorite.ui.b.p;
import com.tencent.mm.plugin.favorite.ui.b.q;
import com.tencent.mm.plugin.favorite.ui.b.r;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class b extends a {
    private c jeX;
    private int moj;
    private boolean muk;
    public List<f> mul;
    private List<f> mum;
    private List<f> mun;
    public List<Long> muo;
    public boolean mup;
    private Map<Long, f> muq;
    private List<Integer> mur;
    private List<String> mus;
    private List<String> mut;
    private SparseArray<a> muu;
    private boolean muv;
    public a.c muw;
    public boolean mux;
    public boolean muy;
    public ListView muz;
    public int scene;

    public final /* synthetic */ Object getItem(int i) {
        return pM(i);
    }

    public b(h hVar, boolean z) {
        this.muk = false;
        this.mul = new ArrayList();
        this.mum = new ArrayList();
        this.mun = new LinkedList();
        this.muo = new ArrayList();
        this.mup = false;
        this.muq = new TreeMap();
        this.mur = new ArrayList();
        this.mus = new LinkedList();
        this.mut = new LinkedList();
        this.muu = new SparseArray();
        this.muv = false;
        this.mux = false;
        this.muy = false;
        this.jeX = new 1(this);
        this.type = -1;
        this.muu.put(1, new n(hVar));
        this.muu.put(2, new d(hVar));
        this.muu.put(3, new r(hVar));
        this.muu.put(4, new q(hVar));
        this.muu.put(5, new p(hVar));
        this.muu.put(6, new com.tencent.mm.plugin.favorite.ui.b.f(hVar));
        this.muu.put(7, new com.tencent.mm.plugin.favorite.ui.b.h(hVar));
        this.muu.put(8, new com.tencent.mm.plugin.favorite.ui.b.c(hVar));
        this.muu.put(10, new j(hVar));
        this.muu.put(12, new m(hVar));
        this.muu.put(15, new m(hVar));
        this.muu.put(11, new g(hVar));
        this.muu.put(14, new k(hVar));
        this.muu.put(16, new l(hVar));
        this.muu.put(17, new com.tencent.mm.plugin.favorite.ui.b.b(hVar));
        this.muu.put(18, new i(hVar));
        this.muu.put(-2, new o(hVar));
        if (z != this.mux) {
            this.mux = z;
            if (z) {
                this.muq.clear();
            }
        }
        if (!this.mux) {
            aJt();
        }
        aJu();
        notifyDataSetChanged();
        com.tencent.mm.sdk.b.a.xef.c(this.jeX);
        com.tencent.mm.sdk.b.a.xef.b(this.jeX);
    }

    public final void finish() {
        com.tencent.mm.sdk.b.a.xef.c(this.jeX);
    }

    private void pL(int i) {
        int i2 = this.moj;
        if (i == 0) {
            this.moj = 0;
        } else if (i2 == 0) {
            this.moj = i;
        } else if (i2 != i) {
            this.moj = 4;
        }
    }

    public final void aJt() {
        if (aJv()) {
            x.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
        } else if (com.tencent.mm.plugin.favorite.a.j.aIH()) {
            x.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
        } else if (this.mux) {
            this.mum = com.tencent.mm.plugin.favorite.a.j.f(this.mul, this.muo);
            this.muk = true;
        } else {
            try {
                this.lastUpdateTime = com.tencent.mm.plugin.favorite.a.j.r(this.lastUpdateTime, this.type);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FavoriteAdapter", e, "", new Object[0]);
            }
        }
    }

    private boolean aJv() {
        return (this.mus.isEmpty() && this.mut.isEmpty() && this.mur.isEmpty()) ? false : true;
    }

    public final void a(boolean z, f fVar) {
        if (z != this.mup) {
            this.mup = z;
            if (z) {
                this.muq.clear();
                if (fVar != null) {
                    f db = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().db(fVar.field_localId);
                    if (db != null) {
                        this.muq.put(Long.valueOf(db.field_localId), db);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public final List<f> fc(boolean z) {
        List<f> linkedList = new LinkedList();
        for (f fVar : this.muq.values()) {
            if (fVar != null) {
                linkedList.add(fVar);
            }
        }
        if (z) {
            this.muq.clear();
        }
        return linkedList;
    }

    public final int aJw() {
        return this.muq.size();
    }

    public final long aJx() {
        long j = 0;
        for (f fVar : this.muq.values()) {
            long j2;
            if (fVar != null) {
                j2 = fVar.field_datatotalsize + j;
            } else {
                j2 = j;
            }
            j = j2;
        }
        return j;
    }

    public final void c(List<Integer> list, List<String> list2, List<String> list3) {
        pL(0);
        this.mur.clear();
        if (list != null) {
            this.mur.addAll(list);
            if (!list.isEmpty()) {
                pL(2);
            }
        }
        this.mus.clear();
        if (list2 != null) {
            this.mus.addAll(list2);
            if (!list2.isEmpty()) {
                pL(3);
            }
        }
        this.mut.clear();
        if (list3 != null) {
            this.mut.addAll(list3);
            if (!list3.isEmpty()) {
                pL(1);
            }
        }
        this.muv = true;
        aJu();
        this.muv = false;
    }

    public final void aJu() {
        x.v("MicroMsg.FavoriteAdapter", "reset data list beg");
        this.muk = false;
        List list = this.mum;
        if (list != null) {
            x.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[]{Integer.valueOf(list.size())});
            x.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[]{Integer.valueOf(this.mun.size())});
            list.clear();
        }
        if (aJv()) {
            x.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[]{this.mus, this.mut, this.mur});
            this.mum = com.tencent.mm.plugin.favorite.a.j.a(this.mus, this.mut, this.mur, this.mun, this.muh, this.mui);
            int size = this.mum == null ? 0 : this.mum.size();
            com.tencent.mm.plugin.report.service.g.pQN.h(10649, new Object[]{Integer.valueOf(size)});
        } else {
            x.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[]{Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type)});
            if (this.mux) {
                pL(0);
                this.muo = com.tencent.mm.plugin.favorite.a.j.aIQ();
                this.mum = com.tencent.mm.plugin.favorite.a.j.f(null, this.muo);
            } else {
                this.mum = com.tencent.mm.plugin.favorite.a.j.b(this.lastUpdateTime, this.type, this.muh, this.mui);
                if (this.mum != null && this.lastUpdateTime == 0 && this.mum.size() > 0) {
                    this.lastUpdateTime = ((f) this.mum.get(this.mum.size() - 1)).field_updateTime;
                }
            }
        }
        if (this.mum == null) {
            x.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
            this.mum = new ArrayList();
        }
        if (!(this.mux || aJv() || this.mum.size() >= 20 || com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().p(this.lastUpdateTime, this.type))) {
            x.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
            aJt();
        }
        this.muk = true;
        x.v("MicroMsg.FavoriteAdapter", "reset data list end");
    }

    public final boolean isEmpty() {
        return this.mul.isEmpty();
    }

    public final void notifyDataSetChanged() {
        x.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[]{Boolean.valueOf(this.muk)});
        if (this.muk) {
            if (this.mux && this.mum != null && this.mul != null && this.mum.size() == this.mul.size()) {
                this.muy = true;
            }
            List list = this.mul;
            this.mul = this.mum;
            this.mum = list;
            this.muk = false;
        }
        x.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
        super.notifyDataSetChanged();
    }

    public final int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        f pM = pM(i - 1);
        switch (pM.field_type) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return pM.field_type;
            default:
                x.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[]{Integer.valueOf(pM.field_type)});
                return -2;
        }
    }

    public final int getViewTypeCount() {
        return this.muu.size() + 3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (i == 0) {
            View view2 = new View(viewGroup.getContext());
            view2.setLayoutParams(new LayoutParams(0, 0));
            view2.setBackgroundResource(R.e.bsl);
            view2.setPadding(0, 0, 0, 0);
            view2.setEnabled(false);
            return view2;
        }
        f pM = pM(i - 1);
        a aVar = (a) this.muu.get(pM.field_type);
        if (aVar == null) {
            x.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[]{Integer.valueOf(pM.field_type)});
            aVar = (a) this.muu.get(-2);
            aJs();
            return aVar.a(view, viewGroup, pM);
        }
        aVar.mxM.kFT = aJv();
        aVar.mxM.lastUpdateTime = this.lastUpdateTime;
        aVar.mxM.mup = this.mup;
        aVar.mxM.muq = this.muq;
        aVar.mxM.mxO = this.muw;
        aVar.mxM.mux = this.mux;
        return aVar.a(view, viewGroup, pM);
    }

    public final f pM(int i) {
        if (i >= 0 && i < this.mul.size()) {
            return (f) this.mul.get(i);
        }
        x.e("MicroMsg.FavoriteAdapter", "get item, but position error");
        return new f();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getCount() {
        return this.mul.size() + 1;
    }

    public final int dr(long j) {
        f db = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().db(j);
        if (db == null) {
            return -1;
        }
        if (this.muq.size() >= 30) {
            x.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[]{Integer.valueOf(30)});
            com.tencent.mm.ui.base.h.bu(ac.getContext(), ac.getContext().getResources().getString(R.l.efP, new Object[]{Integer.valueOf(30)}));
            return -1;
        }
        this.muq.put(Long.valueOf(j), db);
        int i;
        if (db.field_updateTime < this.lastUpdateTime) {
            this.lastUpdateTime = db.field_updateTime;
            aJu();
            i = 0;
            for (f fVar : this.mum) {
                if (fVar.field_localId == j) {
                    notifyDataSetChanged();
                    return i;
                }
                i++;
            }
            notifyDataSetChanged();
        } else {
            i = 0;
            for (f fVar2 : this.mul) {
                if (fVar2.field_localId == j) {
                    notifyDataSetChanged();
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.tencent.mm.plugin.favorite.ui.b.a.b bVar = (com.tencent.mm.plugin.favorite.ui.b.a.b) view.getTag();
        if (bVar == null) {
            x.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
        } else if (bVar.mqC == null) {
            x.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
        } else if (!this.mup && !this.mux) {
            a aVar = (a) this.muu.get(bVar.mqC.field_type);
            if (aVar != null) {
                vg vgVar = new vg();
                vgVar.scene = this.scene;
                vgVar.moj = this.moj;
                if (this.muz != null) {
                    vgVar.index = i - this.muz.getHeaderViewsCount();
                } else {
                    vgVar.index = i;
                }
                aVar.a(view, vgVar);
                x.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[]{Integer.valueOf(bVar.mqC.field_type)});
            }
        } else if (bVar.iis.isChecked() || this.muq.size() < 30) {
            bVar.iis.setChecked(!bVar.iis.isChecked());
        } else {
            x.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[]{Integer.valueOf(30)});
            com.tencent.mm.ui.base.h.bu(ac.getContext(), ac.getContext().getResources().getString(R.l.efP, new Object[]{Integer.valueOf(30)}));
        }
    }
}
