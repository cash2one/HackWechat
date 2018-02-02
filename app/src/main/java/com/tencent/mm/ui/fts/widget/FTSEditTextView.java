package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.a.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.ArrayList;
import java.util.List;

public class FTSEditTextView extends LinearLayout {
    public ImageView jCP;
    public List<b> rGZ;
    private String vtt;
    protected OnFocusChangeListener yaq = new 7(this);
    public EditText yig;
    public View zdP;
    private TextView zdQ;
    private TextView zdR;
    private TextView zdS;
    private View zdT;
    public boolean zdU = true;
    private String zdV = "";
    private OnClickListener zdW = new 6(this);
    public a zdX;
    private b zdY = b.zea;

    static /* synthetic */ void e(FTSEditTextView fTSEditTextView) {
        String bTE = fTSEditTextView.bTE();
        if (fTSEditTextView.zdX != null) {
            fTSEditTextView.zdX.a(fTSEditTextView.bTC(), bTE, fTSEditTextView.rGZ, fTSEditTextView.zdY);
        }
        if (bTE.length() == 0) {
            fTSEditTextView.yig.setHint(fTSEditTextView.vtt);
        }
        if (bTE.length() > 0 || fTSEditTextView.rGZ.size() > 0) {
            fTSEditTextView.zdP.setVisibility(0);
        } else {
            fTSEditTextView.zdP.setVisibility(8);
        }
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void cwY() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.gXk, this, true);
    }

    protected void init() {
        cwY();
        this.zdT = findViewById(g.gWu);
        this.jCP = (ImageView) findViewById(g.icon);
        this.yig = (EditText) findViewById(g.cdj);
        this.zdP = findViewById(g.bWg);
        this.zdQ = (TextView) findViewById(g.gWr);
        this.zdR = (TextView) findViewById(g.gWs);
        this.zdS = (TextView) findViewById(g.gWt);
        this.rGZ = new ArrayList();
        this.yig.setOnKeyListener(new 1(this));
        this.yig.addTextChangedListener(new 2(this));
        this.yig.setOnFocusChangeListener(this.yaq);
        this.yig.setOnEditorActionListener(new 3(this));
        this.zdQ.setOnClickListener(this.zdW);
        this.zdR.setOnClickListener(this.zdW);
        this.zdS.setOnClickListener(this.zdW);
        this.zdP.setOnClickListener(new 4(this));
        c.d(this.yig).GN(100).a(null);
    }

    public final void clearText() {
        this.zdY = b.zeb;
        if (this.zdU) {
            this.rGZ.clear();
        }
        this.yig.setText("");
        this.yig.setHint(this.vtt);
        this.zdP.setVisibility(8);
        cxb();
        this.zdY = b.zea;
    }

    public final void cwZ() {
        postDelayed(new 5(this), 128);
    }

    public final void t(String str, List<b> list) {
        b bVar = b.zea;
        this.rGZ.clear();
        if (list != null) {
            this.rGZ.addAll(list);
        }
        x.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[]{str, Integer.valueOf(this.rGZ.size())});
        this.zdY = b.zec;
        this.yig.setText(str);
        Selection.setSelection(this.yig.getText(), this.yig.getText().length());
        cxb();
        this.zdY = bVar;
    }

    public final void cxa() {
        this.yig.requestFocus();
    }

    public final void LW(String str) {
        this.yig.setHint(str);
        this.vtt = str;
    }

    private void cxb() {
        x.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[]{Integer.valueOf(this.rGZ.size())});
        float aa = (float) a.aa(getContext(), e.bvK);
        if (this.rGZ.size() > 0) {
            this.zdQ.setVisibility(0);
            this.zdQ.setText(com.tencent.mm.ui.e.c.b.c(getContext(), ((b) this.rGZ.get(0)).getTagName(), aa));
        } else {
            this.zdQ.setVisibility(8);
        }
        if (this.rGZ.size() >= 2) {
            this.zdR.setVisibility(0);
            this.zdR.setText(com.tencent.mm.ui.e.c.b.c(getContext(), ((b) this.rGZ.get(1)).getTagName(), aa));
        } else {
            this.zdR.setVisibility(8);
        }
        if (this.rGZ.size() >= 3) {
            this.zdS.setVisibility(0);
            this.zdS.setText(com.tencent.mm.ui.e.c.b.c(getContext(), ((b) this.rGZ.get(2)).getTagName(), aa));
            return;
        }
        this.zdS.setVisibility(8);
    }

    public final String bTE() {
        return this.yig.getText().toString().trim();
    }

    public final String bTC() {
        StringBuffer stringBuffer = new StringBuffer();
        for (b tagName : this.rGZ) {
            stringBuffer.append(tagName.getTagName());
            stringBuffer.append(" ");
        }
        stringBuffer.append(this.yig.getText().toString());
        return stringBuffer.toString().trim();
    }

    public final void cxc() {
        this.jCP.setVisibility(0);
    }

    public final void cxd() {
        this.zdP.setVisibility(8);
    }
}
