package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c$a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterpriseBizContactListView extends BaseSortView {
    String kGd;
    boolean kGk;
    private ListView kGl;
    int kGm = -1;
    b kGn;
    private a kGo;
    private int kGp = 0;
    private int kGq = 0;

    private class d implements Comparator<com.tencent.mm.ui.base.sortview.d> {
        final /* synthetic */ EnterpriseBizContactListView kGr;

        private d(EnterpriseBizContactListView enterpriseBizContactListView) {
            this.kGr = enterpriseBizContactListView;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            com.tencent.mm.ui.base.sortview.d dVar = (com.tencent.mm.ui.base.sortview.d) obj;
            com.tencent.mm.ui.base.sortview.d dVar2 = (com.tencent.mm.ui.base.sortview.d) obj2;
            String str = dVar.ykk;
            String str2 = dVar2.ykk;
            int compareToIgnoreCase = (str == null || str2 == null) ? 0 : str.compareToIgnoreCase(str2);
            if (compareToIgnoreCase != 0) {
                if (str.equalsIgnoreCase("#")) {
                    compareToIgnoreCase = 1;
                }
                return str2.equalsIgnoreCase("#") ? -1 : compareToIgnoreCase;
            } else {
                b bVar = (b) dVar.data;
                b bVar2 = (b) dVar2.data;
                if (!(str == null || str2 == null || (!str.equalsIgnoreCase("!2") && !str.equalsIgnoreCase("!1")))) {
                    int Ad = bVar.jLe.Ad();
                    int Ad2 = bVar2.jLe.Ad();
                    Object obj3 = ((Ad < 97 || Ad > 122) && (Ad < 65 || Ad > 90)) ? 1 : null;
                    Object obj4 = ((Ad2 < 97 || Ad2 > 122) && (Ad2 < 65 || Ad2 > 90)) ? 1 : null;
                    if (obj3 != null && obj4 == null) {
                        return 1;
                    }
                    if (obj3 == null && obj4 != null) {
                        return -1;
                    }
                }
                int compareToIgnoreCase2 = (bVar.jLe == null || bVar.jLe.vR() == null || bVar.jLe.vR().length() <= 0 || bVar2.jLe == null || bVar2.jLe.vR() == null || bVar2.jLe.vR().length() <= 0) ? 0 : bVar.jLe.vR().compareToIgnoreCase(bVar2.jLe.vR());
                if (compareToIgnoreCase2 != 0) {
                    return compareToIgnoreCase2;
                }
                compareToIgnoreCase2 = (bVar.jLe == null || bVar.jLe.field_nickname == null || bVar.jLe.field_nickname.length() <= 0 || bVar2.jLe == null || bVar2.jLe.field_nickname == null || bVar2.jLe.field_nickname.length() <= 0) ? 0 : bVar.jLe.field_nickname.compareToIgnoreCase(bVar2.jLe.field_nickname);
                if (compareToIgnoreCase2 != 0) {
                    return compareToIgnoreCase2;
                }
                compareToIgnoreCase = (bVar.jLe == null || bVar.jLe.field_username == null || bVar.jLe.field_username.length() <= 0 || bVar2.jLe == null || bVar2.jLe.field_username == null || bVar2.jLe.field_username.length() <= 0) ? 0 : bVar.jLe.field_username.compareToIgnoreCase(bVar2.jLe.field_username);
                return compareToIgnoreCase == 0 ? 0 : compareToIgnoreCase;
            }
        }
    }

    static /* synthetic */ void a(TextView textView, Context context, String str, int i) {
        if (textView != null && !bh.ov(str)) {
            try {
                textView.setText(new SpannableString(i.c(context, str, i)));
            } catch (Exception e) {
                textView.setText("");
            }
        }
    }

    static /* synthetic */ void a(EnterpriseBizContactListView enterpriseBizContactListView, com.tencent.mm.ag.d dVar, int i) {
        com.tencent.mm.ag.b jx = y.Mm().jx(enterpriseBizContactListView.kGd);
        long j = jx != null ? jx.field_wwCorpId : 0;
        long j2 = jx != null ? jx.field_wwUserVid : 0;
        long Lj = dVar.Lj();
        g.pQN.h(14507, new Object[]{Long.valueOf(j), Long.valueOf(Lj), Long.valueOf(j2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i)});
        x.d("MicroMsg.BrandService.EnterpriseBizContactListView", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[]{Long.valueOf(j), Long.valueOf(Lj), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i)});
    }

    public EnterpriseBizContactListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void refresh() {
        List arrayList = new ArrayList();
        y.Mf();
        Cursor z = e.z(this.kGd, this.kGk);
        while (z.moveToNext()) {
            b bVar = new b();
            if (z != null) {
                af xVar = new com.tencent.mm.storage.x();
                xVar.b(z);
                com.tencent.mm.ag.d dVar = new com.tencent.mm.ag.d();
                dVar.b(z);
                bVar.userName = xVar.field_username;
                bVar.jLe = xVar;
                bVar.kEC = dVar;
            }
            if (bVar.jLe != null) {
                com.tencent.mm.ui.base.sortview.d dVar2 = new com.tencent.mm.ui.base.sortview.d();
                dVar2.data = bVar;
                if (bVar.kEC.Lg()) {
                    dVar2.ykk = "!1";
                } else if (bVar.jLe.AL()) {
                    dVar2.ykk = "!2";
                } else {
                    int Ad = bVar.jLe.Ad();
                    if (Ad >= 97 && Ad <= 122) {
                        Ad -= 32;
                    }
                    if (Ad < 65 || Ad > 90) {
                        dVar2.ykk = "#";
                    } else {
                        dVar2.ykk = ((char) Ad);
                    }
                }
                arrayList.add(dVar2);
            }
        }
        z.close();
        this.kGm = arrayList.size();
        Collections.sort(arrayList, new d());
        cZ(arrayList);
        super.refresh();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.kGp = (int) motionEvent.getRawX();
            this.kGq = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void asv() {
        this.XC = new 1(this);
        if (this.mMode == 0) {
            this.yka = new 2(this);
        }
    }

    public static void release() {
        y.Mn().LZ();
    }

    public final boolean a(String str, com.tencent.mm.ui.base.sortview.d dVar) {
        if (!(bh.ov(str) || dVar == null)) {
            b bVar = (b) dVar.data;
            if (bVar == null) {
                return false;
            }
            String AQ = bVar.jLe.AQ();
            String vQ = bVar.jLe.vQ();
            String vR = bVar.jLe.vR();
            String toUpperCase = str.toUpperCase();
            if (!(bh.ov(AQ) || AQ.toUpperCase().indexOf(toUpperCase) == -1) || (!(bh.ov(vQ) || vQ.toUpperCase().indexOf(toUpperCase) == -1) || (!bh.ov(vR) && vR.toUpperCase().startsWith(toUpperCase)))) {
                return true;
            }
        }
        return false;
    }

    public final View inflate() {
        return View.inflate(getContext(), R.i.dgq, this);
    }

    public final VerticalScrollBar asw() {
        return (VerticalScrollBar) findViewById(R.h.cOn);
    }

    public final ListView getListView() {
        this.kGl = (ListView) findViewById(R.h.ctf);
        return this.kGl;
    }

    public final View asx() {
        TextView textView = (TextView) findViewById(R.h.cAw);
        textView.setText(R.l.ebV);
        return textView;
    }

    public final c$a asy() {
        return new 3(this);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.kGn != null) {
            this.kGn.asu();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
