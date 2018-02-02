package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrandServiceSortView extends BaseSortView implements OnCreateContextMenuListener, OnItemLongClickListener, com.tencent.mm.plugin.brandservice.a.d.a, com.tencent.mm.ui.base.sortview.BaseSortView.a {
    private boolean OQ;
    private String jKk;
    public boolean kFY;
    private int kGp = 0;
    private int kGq = 0;
    private i kGt;
    private HashMap<String, SpannableString> kHg = new HashMap();
    private d kHh = new d();
    private int kHi = 251658241;
    private boolean kHj = false;
    private ListView kHk;
    public a kHl;
    private String kHm;
    private View kHn;
    private TextView kHo;
    private p$d kHp = new 3(this);

    public interface a {
        boolean asu();
    }

    static /* synthetic */ void a(BrandServiceSortView brandServiceSortView, TextView textView, Context context, String str, int i) {
        if (textView == null) {
            x.w("MicroMsg.BrandServiceSortView", "display area is null");
        } else if (bh.ov(str)) {
            x.w("MicroMsg.BrandServiceSortView", "remark is null");
        } else {
            SpannableString spannableString = (SpannableString) brandServiceSortView.kHg.get(str);
            if (spannableString == null) {
                try {
                    x.d("MicroMsg.BrandServiceSortView", "new one %s", new Object[]{str});
                    CharSequence spannableString2 = new SpannableString(com.tencent.mm.pluginsdk.ui.d.i.c(context, str, i));
                    brandServiceSortView.kHg.put(str, spannableString2);
                    textView.setText(spannableString2);
                    return;
                } catch (Exception e) {
                    x.w("MicroMsg.BrandServiceSortView", "error, set empty str");
                    textView.setText("");
                    return;
                }
            }
            x.v("MicroMsg.BrandServiceSortView", "match one %s", new Object[]{str});
            textView.setText(spannableString);
        }
    }

    static /* synthetic */ void a(BrandServiceSortView brandServiceSortView, com.tencent.mm.ag.d dVar, Context context, com.tencent.mm.storage.x xVar, int i) {
        x.i("MicroMsg.BrandServiceSortView", "showRemoveBizAlertDialog");
        if (dVar == null || context == null || !(context instanceof Activity) || xVar == null) {
            x.e("MicroMsg.BrandServiceSortView", "bizInfo(%s) or context(%s) or contact(%s) is null", new Object[]{dVar, context, xVar});
            return;
        }
        ar.Dm().F(new 4(brandServiceSortView, xVar.field_username, context, i));
    }

    public BrandServiceSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        K(false);
        refresh();
        d dVar = this.kHh;
        if (!(this == null || dVar.kEE.contains(this))) {
            x.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
            dVar.kEE.add(this);
        }
        this.kGt = new i(getContext());
        this.yke = this;
        this.XC = new 1(this);
        this.yka = this;
    }

    public final void refresh() {
        List list;
        List list2;
        this.kHh.init();
        d dVar = this.kHh;
        switch (this.kHi) {
            case 2:
                list = dVar.kEG;
                break;
            default:
                list = dVar.kEH;
                break;
        }
        if (list != null) {
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                b bVar = (b) list.get(i);
                if (!(bVar == null || bVar.jLe == null)) {
                    com.tencent.mm.ui.base.sortview.d dVar2 = new com.tencent.mm.ui.base.sortview.d();
                    dVar2.data = bVar;
                    int i2 = bVar.jLe.field_showHead;
                    if (i2 >= 97 && i2 <= 122) {
                        i2 -= 32;
                    }
                    if (i2 < 65 || i2 > 90) {
                        dVar2.ykk = "#";
                    } else {
                        dVar2.ykk = ((char) i2);
                    }
                    arrayList.add(dVar2);
                }
            }
            list2 = arrayList;
        } else {
            list2 = null;
        }
        cZ(list2);
        super.refresh();
    }

    public final void release() {
        if (ar.Hj()) {
            y.Mn().LZ();
        }
        d dVar = this.kHh;
        if (this == null) {
            x.w("MicroMsg.BrandService.BrandServiceMgr", "removeListener:onChange is null");
            dVar.kEE.remove(null);
        }
        d dVar2 = this.kHh;
        ar.CG().b(387, dVar2);
        if (dVar2.kEF) {
            List arrayList = new ArrayList(dVar2.kEG.size() + dVar2.kEH.size());
            for (b add : dVar2.kEG) {
                arrayList.add(add);
            }
            for (b add2 : dVar2.kEH) {
                arrayList.add(add2);
            }
            ar.CG().a(new k(arrayList), 0);
        }
    }

    public final boolean a(String str, com.tencent.mm.ui.base.sortview.d dVar) {
        if (!(bh.ov(str) || dVar == null)) {
            this.kHm = str;
            b bVar = (b) dVar.data;
            if (bVar == null || bVar.jLe == null) {
                x.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
                return false;
            }
            com.tencent.mm.storage.x xVar = bVar.jLe;
            String AQ = xVar.AQ();
            String vQ = xVar.vQ();
            String vR = xVar.vR();
            String toUpperCase = str.toUpperCase();
            if (!(bh.ov(AQ) || AQ.toUpperCase().indexOf(toUpperCase) == -1) || (!(bh.ov(vQ) || vQ.toUpperCase().indexOf(toUpperCase) == -1) || (!bh.ov(vR) && vR.toUpperCase().startsWith(toUpperCase)))) {
                return true;
            }
        }
        return false;
    }

    public final View inflate() {
        return View.inflate(getContext(), R.i.dbE, this);
    }

    public final VerticalScrollBar asw() {
        return (VerticalScrollBar) findViewById(R.h.cOn);
    }

    public final ListView getListView() {
        this.kHk = (ListView) findViewById(R.h.ctf);
        if (this.kHn == null) {
            this.kHn = inflate(getContext(), R.i.dfg, null);
            if (!(this.kHk == null || this.kHn == null)) {
                this.kHo = (TextView) this.kHn.findViewById(R.h.bZa);
                this.kHk.addFooterView(this.kHn, null, false);
            }
        }
        return this.kHk;
    }

    public final View asx() {
        return findViewById(R.h.cAw);
    }

    public final com.tencent.mm.ui.base.sortview.c.a asy() {
        return new 2(this);
    }

    public final void asi() {
        refresh();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.kGp = (int) motionEvent.getRawX();
            this.kGq = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.kGt.zul = view;
        this.kGt.a(adapterView, i, j, this, this.kHp, this.kGp, this.kGq);
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (contextMenuInfo == null) {
            x.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
            return;
        }
        x.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        com.tencent.mm.ui.base.sortview.d dVar = (com.tencent.mm.ui.base.sortview.d) ((AdapterView) view).getItemAtPosition(adapterContextMenuInfo.position);
        if (dVar == null || dVar.data == null) {
            x.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[]{dVar});
            return;
        }
        af afVar = ((b) dVar.data).jLe;
        if (afVar == null) {
            x.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
            return;
        }
        this.jKk = afVar.field_username;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(getContext(), afVar.AQ()));
        com.tencent.mm.ag.d jS = f.jS(afVar.field_username);
        if (jS != null && !jS.Ld()) {
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.eui);
        }
    }

    public final void ai(List<com.tencent.mm.ui.base.sortview.d> list) {
        if (this.kHo != null && list != null) {
            this.kHo.setText(getContext().getString(R.l.dNc, new Object[]{Integer.valueOf(list.size())}));
        }
    }

    public final void K(boolean z) {
        this.OQ = z;
        n(this.kHo, z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.kHl != null) {
            this.kHl.asu();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
