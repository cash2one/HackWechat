package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.IBinder;
import android.text.InputFilter;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMTagPanel extends FlowLayout {
    private boolean mtG = false;
    public int muB = d.btv;
    public int muC = f.gVc;
    public int nKq = f.bGC;
    public int nKr = d.bui;
    public boolean ndg = true;
    public LinkedList<d> wfh = new LinkedList();
    public boolean ydA = true;
    private boolean ydB = false;
    public boolean ydC = true;
    public boolean ydD = false;
    public boolean ydE = false;
    public int ydF = f.gVa;
    private int ydG = 0;
    public int ydH = f.gVb;
    private int ydI = d.white;
    private d ydJ = null;
    private LinkedList<d> ydK = new LinkedList();
    public a ydL;
    private int ydM;
    private View ydN;
    public MMEditText ydO;
    public boolean ydP = false;
    private OnClickListener ydQ = new 8(this);

    static /* synthetic */ d a(MMTagPanel mMTagPanel, String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.MMTagPanel", "want to get tag info, but it is null or empty");
            return null;
        }
        Iterator it = mMTagPanel.wfh.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.yec)) {
                return dVar;
            }
        }
        x.w("MicroMsg.MMTagPanel", "want to get tag %s, but it not exsited!", new Object[]{str});
        return null;
    }

    public MMTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void aJB() {
    }

    private void init() {
        this.ydM = getContext().getResources().getDimensionPixelSize(e.bvs);
        this.ydN = LayoutInflater.from(getContext()).inflate(h.gXZ, null);
        this.ydO = (MMEditText) this.ydN.findViewById(g.cdj);
        this.ydO.setOnKeyListener(new 1(this));
        this.ydO.addTextChangedListener(new 2(this));
        this.ydO.setOnFocusChangeListener(new 3(this));
        this.ydO.setOnClickListener(new 4(this));
        this.ydO.setOnEditorActionListener(new 5(this));
        c cVar = new c(this);
        b bVar = new b(this);
        this.ydO.setFilters(new InputFilter[]{cVar, bVar});
        cpG();
        setOnClickListener(new 6(this));
        setOnTouchListener(new 7(this, cVar));
    }

    public final void EP(int i) {
        this.ydG = i;
        if (this.ydO != null) {
            a.fromDPToPix(getContext(), 6);
            getResources().getDimensionPixelSize(e.bvJ);
            this.ydO.setBackgroundResource(this.ydG);
        }
    }

    public final void YL(String str) {
        if (this.ydO != null) {
            this.ydO.setHint(str);
        }
    }

    public final String cpC() {
        if (this.ydO != null) {
            return this.ydO.getText().toString();
        }
        return "";
    }

    public final void cpD() {
        if (this.ydO != null) {
            this.ydO.setText("");
        }
    }

    public final boolean cpE() {
        if (this.ydO == null) {
            return false;
        }
        return this.ydO.isFocused();
    }

    public final void cpF() {
        if (this.ydO != null && !this.ydO.isFocused()) {
            this.ydO.requestFocus();
        }
    }

    public final void cpG() {
        if (this.ydO != null && this.ydO.isFocused()) {
            x.d("MicroMsg.MMTagPanel", "do clear edit focus");
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                IBinder windowToken = this.ydO.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                    this.ydO.clearFocus();
                }
            }
        }
    }

    public final void ms(boolean z) {
        if (z != this.ydB) {
            this.ydB = z;
            removeView(this.ydN);
            if (this.ydB) {
                addView(this.ydN);
                cpG();
            }
        }
    }

    public final ArrayList<String> cpH() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.wfh.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!bh.ov(dVar.yec)) {
                arrayList.add(dVar.yec);
            }
        }
        return arrayList;
    }

    public void cpv() {
        this.wfh.clear();
        removeAllViews();
        Iterator it = this.wfh.iterator();
        while (it.hasNext()) {
            a((d) it.next());
        }
    }

    public final void a(Collection<String> collection, List<String> list) {
        cpv();
        if (this.ydB) {
            addView(this.ydN);
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                bi(str, collection == null ? false : collection.contains(str));
            }
        }
    }

    public final d cpI() {
        if (!this.ydK.isEmpty()) {
            return (d) this.ydK.removeFirst();
        }
        d dVar = new d();
        TextView textView = new TextView(getContext());
        textView.setBackgroundResource(this.muC);
        textView.setTextColor(getResources().getColor(this.muB));
        textView.setTag(Integer.valueOf(0));
        textView.setGravity(17);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.ydF, 0);
        textView.setOnClickListener(this.ydA ? this.ydQ : null);
        textView.setEllipsize(TruncateAt.END);
        textView.setSingleLine();
        dVar.yed = textView;
        return dVar;
    }

    public final void a(d dVar) {
        dVar.yed.setOnClickListener(null);
        if (this.ydK.size() < 16) {
            this.ydK.add(dVar);
        }
    }

    public final void a(d dVar, String str, boolean z) {
        dVar.yec = str;
        dVar.yed.setText(b.a(getContext(), str, this.ydM));
        dVar.yed.setOnClickListener(this.ydA ? this.ydQ : null);
        a(dVar.yed, z, false);
    }

    public final void cpJ() {
        if (this.ydO != null) {
            x.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", new Object[]{Boolean.valueOf(this.ydO.isFocused())});
            this.ydO.setCursorVisible(true);
        }
        if (this.ydJ != null) {
            boolean z;
            TextView textView = this.ydJ.yed;
            if (((Integer) this.ydJ.yed.getTag()).intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            a(textView, z, false);
            this.ydJ = null;
        }
    }

    public final void a(TextView textView, boolean z, boolean z2) {
        textView.setTextSize(0, getContext().getResources().getDimension(e.bvs) * a.eu(getContext()));
        if (z2) {
            textView.setBackgroundResource(this.ydH);
            textView.setTextColor(getResources().getColor(this.ydI));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.ydF, 0);
        } else if (z) {
            textView.setTag(Integer.valueOf(1));
            textView.setBackgroundResource(this.nKq);
            textView.setTextColor(getResources().getColor(this.nKr));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textView.setTag(Integer.valueOf(0));
            textView.setBackgroundResource(this.muC);
            textView.setTextColor(getResources().getColor(this.muB));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public final void bi(String str, boolean z) {
        if (bh.ov(str)) {
            x.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
            return;
        }
        String trim = str.trim();
        x.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", new Object[]{trim});
        removeTag(trim);
        Iterator it = this.wfh.iterator();
        while (it.hasNext()) {
            if (trim.equals(((d) it.next()).yec)) {
                x.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", new Object[]{trim});
                return;
            }
        }
        d cpI = cpI();
        a(cpI, trim, z);
        this.wfh.add(cpI);
        if (this.ydB) {
            addView(cpI.yed, getChildCount() - 1);
        } else {
            addView(cpI.yed);
        }
        cpJ();
    }

    public final void removeTag(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
            return;
        }
        Iterator it = this.wfh.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.yec)) {
                this.wfh.remove(dVar);
                removeView(dVar.yed);
                a(dVar);
                cpJ();
                return;
            }
        }
        x.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", new Object[]{str});
    }

    public final void bj(String str, boolean z) {
        if (bh.ov(str)) {
            x.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
            return;
        }
        Iterator it = this.wfh.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.yec)) {
                a(dVar, str, z);
                cpJ();
                return;
            }
        }
        x.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", new Object[]{str});
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ndg) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
