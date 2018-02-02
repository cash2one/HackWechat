package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.j;
import com.tencent.mm.w.a.k;
import java.util.ArrayList;

public class ActionBarSearchView extends LinearLayout implements f {
    private TextWatcher vri = new TextWatcher(this) {
        final /* synthetic */ ActionBarSearchView zgw;

        {
            this.zgw = r1;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.zgw.cxv();
            t b = this.zgw.zgp;
            if (b.znu) {
                EditText editText = (EditText) b.zns.get();
                if (editText != null) {
                    if (((charSequence == null || charSequence.toString() == null || charSequence.toString().length() == 0) && (b.jUJ == null || b.jUJ.length() == 0)) || !(b.jUJ == null || charSequence == null || !b.jUJ.equals(charSequence.toString()))) {
                        x.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", charSequence, b.jUJ);
                    } else {
                        b.jUJ = charSequence != null ? charSequence.toString() : "";
                        b.znr = t.k(b.jUJ, b.znt);
                        if (t.a(editText, b.znt)) {
                            x.d("MicroMsg.WordsChecker", "decorate text succ.");
                        }
                    }
                }
            }
            if (this.zgw.zgq != null) {
                this.zgw.zgq.DO(charSequence == null ? "" : charSequence.toString());
            }
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private View zgk;
    private ActionBarEditText zgl;
    private ImageButton zgm;
    private int zgn = c.zgy;
    private boolean zgo = false;
    private t zgp;
    public b zgq;
    public a zgr;
    private OnFocusChangeListener zgs = new OnFocusChangeListener(this) {
        final /* synthetic */ ActionBarSearchView zgw;

        {
            this.zgw = r1;
        }

        public final void onFocusChange(View view, boolean z) {
            x.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", Boolean.valueOf(z));
            if (this.zgw.zgt != null) {
                this.zgw.zgt.onFocusChange(view, z);
            }
        }
    };
    public OnFocusChangeListener zgt;
    private OnClickListener zgu = new OnClickListener(this) {
        final /* synthetic */ ActionBarSearchView zgw;

        {
            this.zgw = r1;
        }

        public final void onClick(View view) {
            if (c.zgy == this.zgw.zgn) {
                x.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
                this.zgw.nr(true);
                if (this.zgw.zgq != null) {
                    this.zgw.zgq.Xt();
                    return;
                }
                return;
            }
            x.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
            if (this.zgw.zgq != null) {
                this.zgw.zgq.aWz();
            }
        }
    };
    private OnClickListener zgv = new OnClickListener(this) {
        final /* synthetic */ ActionBarSearchView zgw;

        {
            this.zgw = r1;
        }

        public final void onClick(View view) {
            if (this.zgw.zgr != null) {
                this.zgw.zgr.aWA();
            }
        }
    };

    public interface a {
        void aWA();
    }

    public interface b {
        void DO(String str);

        void Xt();

        void aWy();

        void aWz();
    }

    private enum c {
        ;

        static {
            zgy = 1;
            zgz = 2;
            zgA = new int[]{zgy, zgz};
        }
    }

    class d extends Drawable {
        private RectF fE;
        private String jUJ;
        private Paint zgB;
        private int zgC = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(ac.getContext(), 2.0f);
        private float zgD;
        private float zgE;
        private Bitmap zgF;
        final /* synthetic */ ActionBarSearchView zgw;

        d(ActionBarSearchView actionBarSearchView, EditText editText, String str) {
            this.zgw = actionBarSearchView;
            this.zgB = new Paint(editText.getPaint());
            this.jUJ = str;
            this.zgB.setColor(ac.getResources().getColor(com.tencent.mm.w.a.d.bsE));
            this.zgF = com.tencent.mm.sdk.platformtools.d.u(actionBarSearchView.getResources().getDrawable(j.dva));
            this.zgD = this.zgB.measureText(this.jUJ);
            FontMetrics fontMetrics = this.zgB.getFontMetrics();
            this.zgE = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) ((((this.zgD + ((float) (this.zgC * 2))) + ((float) (this.zgC * 2))) + ((float) this.zgF.getWidth())) + 2.0f), (int) (((float) this.zgF.getHeight()) > this.zgE ? (float) this.zgF.getHeight() : this.zgE));
        }

        public final void draw(Canvas canvas) {
            FontMetricsInt fontMetricsInt = this.zgB.getFontMetricsInt();
            Rect bounds = getBounds();
            int i = (bounds.top + ((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top;
            canvas.drawBitmap(this.zgF, (float) ((int) ((((float) (bounds.right - bounds.left)) - (this.fE.right - this.fE.left)) / 2.0f)), (float) bounds.top, null);
            canvas.drawText(this.jUJ, (float) ((bounds.left + this.zgF.getWidth()) + 2), (float) i, this.zgB);
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.zgB.getFontMetrics();
            this.fE = new RectF((float) (this.zgC + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - this.zgC), (float) i4);
            invalidateSelf();
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -3;
        }
    }

    public static class ActionBarEditText extends AutoMatchKeywordEditText {
        ActionBarSearchView zgx;

        public ActionBarEditText(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public ActionBarEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
                        this.zgx.clearFocus();
                        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        }
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    public ActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ActionBarSearchView(Context context) {
        super(context);
        init();
    }

    private void init() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.gWW, this, true);
        this.zgk = findViewById(g.bIb);
        this.zgk.setOnClickListener(this.zgv);
        this.zgl = (ActionBarEditText) findViewById(g.cdj);
        this.zgp = new t(this.zgl);
        this.zgl.zgx = this;
        this.zgl.post(new Runnable(this) {
            final /* synthetic */ ActionBarSearchView zgw;

            {
                this.zgw = r1;
            }

            public final void run() {
                this.zgw.zgl.setText("");
                if (this.zgw.zgq != null) {
                    this.zgw.zgq.aWy();
                }
            }
        });
        this.zgm = (ImageButton) findViewById(g.cPl);
        this.zgl.addTextChangedListener(this.vri);
        this.zgl.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ ActionBarSearchView zgw;

            {
                this.zgw = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 67) {
                    return false;
                }
                x.d("MicroMsg.ActionBarSearchView", "on back key click.");
                t b = this.zgw.zgp;
                if (b.znu) {
                    EditText editText = (EditText) b.zns.get();
                    if (!(editText == null || b.znr == null)) {
                        CharSequence text = editText.getText();
                        int selectionStart = editText.getSelectionStart();
                        if (selectionStart == editText.getSelectionEnd()) {
                            b GL = b.GL(selectionStart);
                            if (GL != null && GL.znx) {
                                text.delete(GL.start, GL.start + GL.length);
                                editText.setTextKeepState(text);
                                editText.setSelection(GL.start);
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return false;
            }
        });
        this.zgl.zqM = new com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a(this) {
            final /* synthetic */ ActionBarSearchView zgw;

            {
                this.zgw = r1;
            }

            public final void b(EditText editText, int i, int i2) {
                x.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", Integer.valueOf(i), Integer.valueOf(i2));
                t b = this.zgw.zgp;
                if (b.znu) {
                    EditText editText2 = (EditText) b.zns.get();
                    if (editText2 != null && editText == editText2) {
                        CharSequence text = editText2.getText();
                        int selectionStart = editText2.getSelectionStart();
                        int selectionEnd = editText2.getSelectionEnd();
                        if (selectionStart >= 0 && selectionEnd >= selectionStart) {
                            if (selectionStart == selectionEnd) {
                                b GL = b.GL(selectionStart);
                                if (GL != null && GL.znx) {
                                    editText2.setTextKeepState(text);
                                    editText2.setSelection(GL.length + GL.start);
                                    return;
                                }
                                return;
                            }
                            b GL2 = b.GL(selectionStart);
                            if (GL2 != null && GL2.znx) {
                                selectionStart = GL2.start + GL2.length;
                            }
                            if (selectionStart >= selectionEnd) {
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart);
                                return;
                            }
                            b GL3 = b.GL(selectionEnd);
                            if (GL3 != null && GL3.znx) {
                                int i3 = GL3.start;
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart, i3);
                            }
                        }
                    }
                }
            }
        };
        this.zgl.setOnFocusChangeListener(this.zgs);
        com.tencent.mm.ui.tools.a.c.d(this.zgl).GN(100).a(null);
        this.zgm.setOnClickListener(this.zgu);
    }

    public final String bUS() {
        if (this.zgl.getEditableText() != null) {
            return this.zgl.getEditableText().toString();
        }
        return "";
    }

    public final void a(b bVar) {
        this.zgq = bVar;
    }

    public final void a(a aVar) {
        this.zgr = aVar;
    }

    public final void ZR(String str) {
        if (str == null) {
            str = "";
        }
        this.zgl.setText(str);
        this.zgl.setSelection(str.length());
    }

    public final void setHint(CharSequence charSequence) {
        this.zgl.setHint(charSequence);
    }

    public final void no(boolean z) {
        this.zgo = z;
        cxv();
    }

    public final void np(boolean z) {
        this.zgl.setEnabled(z);
    }

    public final void nq(boolean z) {
        this.zgm.setEnabled(z);
    }

    private void fe(int i, int i2) {
        this.zgm.setImageResource(i);
        this.zgm.setBackgroundResource(0);
        if (i == f.gVf) {
            this.zgm.setContentDescription(getContext().getString(k.gYM));
        } else {
            this.zgm.setContentDescription(getContext().getString(k.bWg));
        }
        LayoutParams layoutParams = this.zgm.getLayoutParams();
        layoutParams.width = i2;
        this.zgm.setLayoutParams(layoutParams);
    }

    private void cxv() {
        if (this.zgl.getEditableText() != null && !bh.ov(this.zgl.getEditableText().toString())) {
            fe(f.gUW, getResources().getDimensionPixelSize(e.bvH));
            this.zgn = c.zgy;
        } else if (this.zgo) {
            fe(f.gVf, getResources().getDimensionPixelSize(e.bvH));
            this.zgn = c.zgz;
        } else {
            fe(0, 0);
            this.zgn = c.zgy;
        }
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.zgl.setOnEditorActionListener(onEditorActionListener);
    }

    public final void nr(boolean z) {
        if (z) {
            this.zgl.setText("");
            return;
        }
        this.zgl.removeTextChangedListener(this.vri);
        this.zgl.setText("");
        this.zgl.addTextChangedListener(this.vri);
    }

    public final void cxw() {
        this.zgl.clearFocus();
    }

    public final void a(com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a aVar) {
    }

    public final boolean cxx() {
        if (this.zgl != null) {
            return this.zgl.hasFocus();
        }
        return false;
    }

    public final boolean cxy() {
        if (this.zgl != null) {
            return this.zgl.requestFocus();
        }
        return false;
    }

    public final void ak(ArrayList<String> arrayList) {
        if (this.zgp != null) {
            t tVar = this.zgp;
            tVar.znt = arrayList;
            if (tVar.znu) {
                EditText editText = (EditText) tVar.zns.get();
                if (editText != null) {
                    t.a(editText, tVar.znt);
                }
            }
        }
    }

    public final void ns(boolean z) {
        if (this.zgp != null) {
            this.zgp.znu = z;
        }
    }

    public final void GJ(int i) {
        if (this.zgl != null) {
            this.zgl.setCompoundDrawables(ac.getResources().getDrawable(i), null, null, null);
        }
    }

    public final void ZS(String str) {
        if (this.zgl != null) {
            this.zgl.setCompoundDrawables(new d(this, this.zgl, str), null, null, null);
            this.zgl.setHint("");
        }
    }
}
