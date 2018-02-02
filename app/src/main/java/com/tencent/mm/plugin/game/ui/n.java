package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

abstract class n extends b<d> {
    protected Context mContext;
    protected int ndn = 0;
    private a nmi;
    protected int nnA;
    protected int noD = 14;
    private b noH = new 3(this);
    protected e noI;
    private OnClickListener nps = new 5(this);
    protected View.OnClickListener npt = new 4(this);
    protected int nsA;
    protected boolean nsB = true;
    protected boolean nsC = false;
    protected boolean nsD = false;
    protected ConcurrentHashMap<String, o> nsE;
    protected SparseArray<View> nsF;

    public interface a {
        void qQ(int i);
    }

    abstract void a(d dVar, b bVar);

    abstract void a(d dVar, b bVar, int i);

    static /* synthetic */ void a(n nVar, LinkedList linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!(nVar.nsE.containsKey(dVar.field_appId) || dVar.type == 1 || dVar == null)) {
                o oVar = (o) nVar.nsE.get(dVar.field_appId);
                if (oVar == null) {
                    oVar = new o(dVar);
                    nVar.nsE.put(dVar.field_appId, oVar);
                }
                oVar.cP(nVar.mContext);
                oVar.aQj();
            }
        }
    }

    public n(Context context) {
        super(context);
        this.mContext = context;
        this.nsE = new ConcurrentHashMap();
        com.tencent.mm.plugin.game.model.n.a(this.noH);
        this.nsF = new SparseArray();
        this.noI = new e(context);
        this.noI.nlx = this.nps;
    }

    public void qO(int i) {
        this.ndn = i;
    }

    public void qR(int i) {
        this.nnA = i;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public void O(LinkedList<d> linkedList) {
        if (linkedList != null) {
            ar.Dm().F(new 1(this, linkedList));
        }
    }

    public void P(LinkedList<d> linkedList) {
        if (linkedList != null) {
            e.post(new 2(this, linkedList), "game_get_download_info");
        }
    }

    public int getItemViewType(int i) {
        return ((d) getItem(i)).type;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        d dVar = (d) getItem(i);
        if (view == null) {
            int i2;
            Context context = this.mContext;
            switch (dVar.type) {
                case 0:
                    i2 = this.nsA;
                    break;
                case 1:
                    i2 = R.i.ckE;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            b bVar2 = new b();
            bVar2.nlZ = (ViewGroup) view.findViewById(R.h.cuR);
            bVar2.nsK = (TextView) view.findViewById(R.h.cmX);
            bVar2.nkH = (ImageView) view.findViewById(R.h.cml);
            bVar2.nkI = (TextView) view.findViewById(R.h.cmV);
            bVar2.nsL = (TextView) view.findViewById(R.h.czX);
            bVar2.nsM = (TextView) view.findViewById(R.h.cmp);
            bVar2.nsN = (TextView) view.findViewById(R.h.ckT);
            bVar2.nsO = (Button) view.findViewById(R.h.clX);
            bVar2.nsP = (TextProgressBar) view.findViewById(R.h.clZ);
            bVar2.nsS = (LinearLayout) view.findViewById(R.h.ckE);
            bVar2.nsQ = (GameListSocialView) view.findViewById(R.h.cnk);
            bVar2.nsR = (ViewGroup) view.findViewById(R.h.cak);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (dVar.type) {
            case 0:
                a(dVar, bVar, i);
                if (this.nnA == 2 && !dVar.nbi) {
                    ap.a(this.mContext, 10, 1004, dVar.position, dVar.field_appId, this.ndn, dVar.nbh);
                    dVar.nbi = true;
                    break;
                }
            case 1:
                a(dVar, bVar);
                break;
        }
        return view;
    }

    public void b(SparseArray<View> sparseArray) {
        if (sparseArray != null) {
            this.nsF = sparseArray;
        } else {
            this.nsF = new SparseArray();
        }
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.nmi = aVar;
    }

    public void x(View view, int i) {
        b bVar = (b) view.getTag();
        d dVar = (d) this.ndF.get(i);
        if (bVar != null) {
            this.noI.a(bVar.nsP, bVar.nsO, dVar, (o) this.nsE.get(dVar.field_appId));
            return;
        }
        x.e("MicroMsg.GameListAdapter", "holder should not be null, %d", new Object[]{Integer.valueOf(i)});
    }

    public void clear() {
        super.clear();
        com.tencent.mm.plugin.game.model.n.b(this.noH);
    }

    public void Cg(String str) {
        d dVar;
        for (int i = 0; i < this.ndF.size(); i++) {
            if (((d) this.ndF.get(i)).field_appId.equals(str)) {
                dVar = (d) this.ndF.get(i);
                break;
            }
        }
        dVar = null;
        if (dVar != null) {
            if (this.nsE.containsKey(dVar.field_appId)) {
                this.noI.a(dVar, (o) this.nsE.get(dVar.field_appId));
                return;
            }
            x.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
        }
    }

    public void Cf(String str) {
        if (!bh.ov(str) && this.nsE.containsKey(str)) {
            o oVar = (o) this.nsE.get(str);
            if (oVar != null) {
                oVar.aQj();
            }
        }
    }

    public void Ce(String str) {
        if (!bh.ov(str) && this.nsE.containsKey(str)) {
            o oVar = (o) this.nsE.get(str);
            if (oVar != null) {
                oVar.aQk();
            }
        }
    }
}
