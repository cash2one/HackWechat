package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView$t;
import android.text.Editable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ParagraphStyle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView.BufferType;
import com.tencent.mm.bx.g;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.c.b;
import com.tencent.mm.plugin.wenote.model.nativenote.c.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.i;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.PasterEditText;

public class WXRTEditText extends PasterEditText implements SpanWatcher {
    private ak ikI = null;
    public int mTL = 0;
    public boolean tRB = false;
    public int tRD = 0;
    private boolean tTA;
    private boolean tTB;
    private boolean tTC;
    private boolean tTD;
    private boolean tTE = false;
    private boolean tTF;
    private j tTG;
    public boolean tTH = false;
    public boolean tTI = false;
    public int tTJ = -1;
    private Paint tTK = null;
    private b tTL = null;
    public boolean tTM = false;
    private Path tTN = null;
    private int tTO = -1;
    private int tTP = -1;
    private int tTQ = -1;
    private boolean tTR = false;
    TextWatcher tTS = new 2(this);
    int tTT = 0;
    c tTm;
    private int tTn = -1;
    private int tTo = -1;
    private boolean tTp = false;
    private boolean tTq;
    private int tTr;
    private int tTs;
    private String tTt;
    public String tTu = "";
    private Spannable tTv;
    public int tTw = 0;
    private WXRTEditText tTx = null;
    public RecyclerView$t tTy;
    private boolean tTz;

    public WXRTEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WXRTEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setMaxHeight(int i) {
        super.setMaxHeight(i);
    }

    private void init() {
        this.tTx = this;
        removeTextChangedListener(this.tTS);
        addTextChangedListener(this.tTS);
        setMovementMethod(i.bXx());
        this.tTJ = -1;
        this.tTK = new Paint(1);
        this.tTK.setColor(1347529272);
        this.tTL = new b();
        this.tTN = new Path();
        this.tTO = -1;
        this.tTP = -1;
        this.tTQ = -1;
        if (e.isEnabled()) {
            setHighlightColor(0);
            setCustomSelectionActionModeCallback(new 1(this));
        }
    }

    public final void QR(String str) {
        bWP();
        if (bh.ov(str)) {
            setText("");
        } else {
            b(a.QN(str));
        }
        bWQ();
    }

    private void b(Spanned spanned) {
        bWP();
        bWR();
        super.setText(spanned, BufferType.EDITABLE);
        bWS();
        bWT();
        u.a(this, new t[0]);
        bWQ();
    }

    public final void setText(String str) {
        bWP();
        super.setText(str);
        bWQ();
    }

    public final void bWL() {
        if (this.tTm != null) {
            this.tTm.f(true, 50);
            this.tTm.Bq(1);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        this.tTR = false;
        this.tTn = -1;
        this.tTo = -1;
        super.onFocusChanged(z, i, rect);
        if (this.tTm != null) {
            this.tTm.a(this, z, bWO());
        }
        if (z && !this.tTR) {
            onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onSelectionChanged(int i, int i2) {
        synchronized (this) {
            if (this.tTp) {
            }
        }
    }

    public final Spannable bWM() {
        CharSequence text = super.getText();
        if (text == null) {
            text = "";
        }
        return new a(text);
    }

    public final e bWN() {
        return new e(getSelectionStart(), getSelectionEnd());
    }

    public final String a(i iVar) {
        if (iVar == i.tTW) {
            return getText().toString();
        }
        if (iVar == i.tTX) {
            return com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(getText());
        }
        return "";
    }

    public final int bWO() {
        if (this.tTy.gd() == -1) {
            return 0;
        }
        return this.tTy.gd();
    }

    public boolean onTextContextMenuItem(int i) {
        if (i == 16908319) {
            this.tTm.bWl();
            return true;
        }
        if (i == 16908321 || i == 16908320) {
            f.aaS();
        } else if (i == 16908322) {
            int dU = f.dU(getContext());
            if (dU == 2) {
                f.aaS();
            } else if (dU == 3) {
                this.tTm.b(this);
                return true;
            }
        }
        try {
            boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
            if (i == 16908322) {
                this.tTT = 0;
                try {
                    b(getText());
                } catch (IndexOutOfBoundsException e) {
                    x.e("noteeditor.WXRTEditText", "!!MMEditText Exception %d", Integer.valueOf(this.tTT));
                    if (this.tTT < 3) {
                        this.tTT++;
                        b(new SpannableStringBuilder(TextUtils.concat(new CharSequence[]{" ", r3})));
                    } else {
                        throw e;
                    }
                }
            }
            if (i == 16908322 && this.tRB) {
                if (this.tTm != null) {
                    this.tTm.f(false, 0);
                    this.tTm.Bq(0);
                }
                this.tRB = false;
            }
            return onTextContextMenuItem;
        } catch (NullPointerException e2) {
            x.e("noteeditor.WXRTEditText", "!!MMEditText NullPointerException %s", e2);
            return false;
        }
    }

    private void b(Spannable spannable) {
        int selectionStart = getSelectionStart();
        b(g.chg().a(getContext(), spannable, getTextSize()));
        int length = getText().length() - spannable.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public final synchronized void bWP() {
        this.tTq = true;
    }

    public final synchronized void bWQ() {
        this.tTq = false;
    }

    public final synchronized void bWR() {
        this.tTp = true;
    }

    public final synchronized void bWS() {
        this.tTp = false;
    }

    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        this.tTz = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            kL(false);
        }
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        this.tTz = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            kL(false);
        }
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        this.tTz = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            kL(false);
        }
    }

    public final <V, C extends com.tencent.mm.plugin.wenote.model.nativenote.spans.g<V>> void a(t<V, C> tVar, V v) {
        if (!this.tTE && !this.tTB) {
            Spannable bWM = this.tTq ? null : bWM();
            tVar.a(this, v);
            synchronized (this) {
                if (!(this.tTm == null || this.tTq)) {
                    Spannable bWM2 = bWM();
                    c cVar = this.tTm;
                    getSelectionStart();
                    getSelectionEnd();
                    getSelectionStart();
                    cVar.a(this, bWM, bWM2, getSelectionEnd());
                }
                this.tTF = true;
            }
        }
    }

    private void bWT() {
        Spannable text = getText();
        if (text.getSpans(0, text.length(), getClass()) != null) {
            text.setSpan(this, 0, text.length(), 18);
        }
    }

    private synchronized void kL(boolean z) {
        if (!this.tTD) {
            this.tTC = z;
        }
    }

    public final e bWU() {
        int i = 0;
        j bWV = bWV();
        e eVar = new e(this);
        int lineForOffset = bWV.getLineForOffset(eVar.Ww);
        int lineForOffset2 = bWV.getLineForOffset(eVar.isEmpty() ? eVar.wq : eVar.wq - 1);
        lineForOffset = (bWV.tTZ == 0 || lineForOffset < 0) ? 0 : lineForOffset < bWV.tTZ ? ((n) bWV.tUa.get(lineForOffset)).Ww : ((n) bWV.tUa.get(bWV.tTZ - 1)).wq - 1;
        if (bWV.tTZ != 0 && lineForOffset2 >= 0) {
            i = lineForOffset2 < bWV.tTZ ? ((n) bWV.tUa.get(lineForOffset2)).wq : ((n) bWV.tUa.get(bWV.tTZ - 1)).wq - 1;
        }
        return new e(lineForOffset, i);
    }

    public j bWV() {
        j jVar;
        synchronized (this) {
            if (this.tTG == null || this.tTF) {
                this.tTG = new j(getText());
                this.tTF = false;
            }
            jVar = this.tTG;
        }
        return jVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onDraw(Canvas canvas) {
        if (e.isEnabled() && this.tTw == 0) {
            Editable text = getText();
            if (text != null) {
                int i;
                Object obj;
                int i2;
                Layout layout;
                int lineForOffset;
                int lineForOffset2;
                int width;
                float primaryHorizontal;
                float lineTop;
                float lineBottom;
                float primaryHorizontal2;
                float lineTop2;
                float lineBottom2;
                d bXh = e.bXf().bXh();
                Object obj2 = null;
                int i3;
                int i4;
                switch (e.bXf().Bv(this.tTJ)) {
                    case 1:
                        if (bXh.startOffset != bXh.tUN) {
                            i = bXh.startOffset;
                            i3 = bXh.tUN;
                            obj = null;
                            i2 = i;
                            i = i3;
                        }
                        break;
                    case 2:
                        obj2 = 1;
                        i4 = 1;
                        i2 = 0;
                        i = text.length();
                        if (i2 >= 0 && i <= text.length() && i2 <= i) {
                            layout = getLayout();
                            if (layout != null) {
                                if (this.tTO == -1) {
                                    this.tTO = getPaddingLeft();
                                }
                                if (this.tTP == -1) {
                                    this.tTP = getPaddingTop();
                                }
                                if (this.tTQ == -1) {
                                    this.tTQ = getPaddingBottom();
                                }
                                if (this.tTN == null) {
                                    this.tTN = new Path();
                                }
                                this.tTN.reset();
                                try {
                                    lineForOffset = layout.getLineForOffset(i2);
                                    lineForOffset2 = layout.getLineForOffset(i);
                                    if (lineForOffset <= lineForOffset2) {
                                        width = layout.getWidth();
                                        primaryHorizontal = layout.getPrimaryHorizontal(i2) + ((float) this.tTO);
                                        lineTop = (float) (layout.getLineTop(lineForOffset) + this.tTP);
                                        lineBottom = (float) (layout.getLineBottom(lineForOffset) + this.tTP);
                                        primaryHorizontal2 = layout.getPrimaryHorizontal(i) + ((float) this.tTO);
                                        lineTop2 = (float) (layout.getLineTop(lineForOffset2) + this.tTP);
                                        lineBottom2 = (float) (layout.getLineBottom(lineForOffset2) + this.tTP);
                                        if (obj == null && obj2 != null) {
                                            this.tTN.addRect((float) this.tTO, 0.0f, (float) (this.tTO + width), lineBottom2 + ((float) this.tTQ), Direction.CW);
                                        } else if (lineForOffset != lineForOffset2) {
                                            if (obj == null) {
                                                this.tTN.addRect((float) this.tTO, 0.0f, (float) (this.tTO + width), lineBottom, Direction.CW);
                                                this.tTN.addRect((float) this.tTO, lineTop2, primaryHorizontal2, lineBottom2, Direction.CW);
                                            } else if (obj2 == null) {
                                                this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom, Direction.CW);
                                                this.tTN.addRect((float) this.tTO, lineTop2, (float) (this.tTO + width), lineBottom2 + ((float) this.tTQ), Direction.CW);
                                            } else {
                                                this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom, Direction.CW);
                                                this.tTN.addRect((float) this.tTO, lineTop2, primaryHorizontal2, lineBottom2, Direction.CW);
                                            }
                                            if (lineForOffset2 - lineForOffset > 1) {
                                                this.tTN.addRect((float) this.tTO, lineBottom, (float) (this.tTO + width), lineTop2, Direction.CW);
                                            }
                                        } else if (obj == null) {
                                            this.tTN.addRect((float) this.tTO, 0.0f, primaryHorizontal2, lineBottom2, Direction.CW);
                                        } else if (obj2 == null) {
                                            this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom2 + ((float) this.tTQ), Direction.CW);
                                        } else {
                                            this.tTN.addRect(primaryHorizontal, lineTop, primaryHorizontal2, lineBottom2, Direction.CW);
                                        }
                                        if (!this.tTN.isEmpty()) {
                                            if (this.tTK == null) {
                                                this.tTK = new Paint(1);
                                                this.tTK.setColor(1347529272);
                                            }
                                            canvas.drawPath(this.tTN, this.tTK);
                                            break;
                                        }
                                    }
                                } catch (Exception e) {
                                    x.e("noteeditor.WXRTEditText", "tryDrawCover: ", e);
                                    break;
                                }
                            }
                        }
                        break;
                    case 3:
                        i3 = bXh.tUN;
                        i4 = 1;
                        i2 = 0;
                        i = i3;
                        layout = getLayout();
                        if (layout != null) {
                            if (this.tTO == -1) {
                                this.tTO = getPaddingLeft();
                            }
                            if (this.tTP == -1) {
                                this.tTP = getPaddingTop();
                            }
                            if (this.tTQ == -1) {
                                this.tTQ = getPaddingBottom();
                            }
                            if (this.tTN == null) {
                                this.tTN = new Path();
                            }
                            this.tTN.reset();
                            lineForOffset = layout.getLineForOffset(i2);
                            lineForOffset2 = layout.getLineForOffset(i);
                            if (lineForOffset <= lineForOffset2) {
                                width = layout.getWidth();
                                primaryHorizontal = layout.getPrimaryHorizontal(i2) + ((float) this.tTO);
                                lineTop = (float) (layout.getLineTop(lineForOffset) + this.tTP);
                                lineBottom = (float) (layout.getLineBottom(lineForOffset) + this.tTP);
                                primaryHorizontal2 = layout.getPrimaryHorizontal(i) + ((float) this.tTO);
                                lineTop2 = (float) (layout.getLineTop(lineForOffset2) + this.tTP);
                                lineBottom2 = (float) (layout.getLineBottom(lineForOffset2) + this.tTP);
                                if (obj == null) {
                                }
                                if (lineForOffset != lineForOffset2) {
                                    if (obj == null) {
                                        this.tTN.addRect((float) this.tTO, 0.0f, (float) (this.tTO + width), lineBottom, Direction.CW);
                                        this.tTN.addRect((float) this.tTO, lineTop2, primaryHorizontal2, lineBottom2, Direction.CW);
                                    } else if (obj2 == null) {
                                        this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom, Direction.CW);
                                        this.tTN.addRect((float) this.tTO, lineTop2, primaryHorizontal2, lineBottom2, Direction.CW);
                                    } else {
                                        this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom, Direction.CW);
                                        this.tTN.addRect((float) this.tTO, lineTop2, (float) (this.tTO + width), lineBottom2 + ((float) this.tTQ), Direction.CW);
                                    }
                                    if (lineForOffset2 - lineForOffset > 1) {
                                        this.tTN.addRect((float) this.tTO, lineBottom, (float) (this.tTO + width), lineTop2, Direction.CW);
                                    }
                                } else if (obj == null) {
                                    this.tTN.addRect((float) this.tTO, 0.0f, primaryHorizontal2, lineBottom2, Direction.CW);
                                } else if (obj2 == null) {
                                    this.tTN.addRect(primaryHorizontal, lineTop, primaryHorizontal2, lineBottom2, Direction.CW);
                                } else {
                                    this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom2 + ((float) this.tTQ), Direction.CW);
                                }
                                if (this.tTN.isEmpty()) {
                                    if (this.tTK == null) {
                                        this.tTK = new Paint(1);
                                        this.tTK.setColor(1347529272);
                                    }
                                    canvas.drawPath(this.tTN, this.tTK);
                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        i = bXh.startOffset;
                        obj2 = 1;
                        obj = null;
                        i2 = i;
                        i = text.length();
                        layout = getLayout();
                        if (layout != null) {
                            if (this.tTO == -1) {
                                this.tTO = getPaddingLeft();
                            }
                            if (this.tTP == -1) {
                                this.tTP = getPaddingTop();
                            }
                            if (this.tTQ == -1) {
                                this.tTQ = getPaddingBottom();
                            }
                            if (this.tTN == null) {
                                this.tTN = new Path();
                            }
                            this.tTN.reset();
                            lineForOffset = layout.getLineForOffset(i2);
                            lineForOffset2 = layout.getLineForOffset(i);
                            if (lineForOffset <= lineForOffset2) {
                                width = layout.getWidth();
                                primaryHorizontal = layout.getPrimaryHorizontal(i2) + ((float) this.tTO);
                                lineTop = (float) (layout.getLineTop(lineForOffset) + this.tTP);
                                lineBottom = (float) (layout.getLineBottom(lineForOffset) + this.tTP);
                                primaryHorizontal2 = layout.getPrimaryHorizontal(i) + ((float) this.tTO);
                                lineTop2 = (float) (layout.getLineTop(lineForOffset2) + this.tTP);
                                lineBottom2 = (float) (layout.getLineBottom(lineForOffset2) + this.tTP);
                                if (obj == null) {
                                }
                                if (lineForOffset != lineForOffset2) {
                                    if (obj == null) {
                                        this.tTN.addRect((float) this.tTO, 0.0f, (float) (this.tTO + width), lineBottom, Direction.CW);
                                        this.tTN.addRect((float) this.tTO, lineTop2, primaryHorizontal2, lineBottom2, Direction.CW);
                                    } else if (obj2 == null) {
                                        this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom, Direction.CW);
                                        this.tTN.addRect((float) this.tTO, lineTop2, (float) (this.tTO + width), lineBottom2 + ((float) this.tTQ), Direction.CW);
                                    } else {
                                        this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom, Direction.CW);
                                        this.tTN.addRect((float) this.tTO, lineTop2, primaryHorizontal2, lineBottom2, Direction.CW);
                                    }
                                    if (lineForOffset2 - lineForOffset > 1) {
                                        this.tTN.addRect((float) this.tTO, lineBottom, (float) (this.tTO + width), lineTop2, Direction.CW);
                                    }
                                } else if (obj == null) {
                                    this.tTN.addRect((float) this.tTO, 0.0f, primaryHorizontal2, lineBottom2, Direction.CW);
                                } else if (obj2 == null) {
                                    this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom2 + ((float) this.tTQ), Direction.CW);
                                } else {
                                    this.tTN.addRect(primaryHorizontal, lineTop, primaryHorizontal2, lineBottom2, Direction.CW);
                                }
                                if (this.tTN.isEmpty()) {
                                    if (this.tTK == null) {
                                        this.tTK = new Paint(1);
                                        this.tTK.setColor(1347529272);
                                    }
                                    canvas.drawPath(this.tTN, this.tTK);
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        obj = null;
                        i2 = -1;
                        i = 0;
                }
                layout = getLayout();
                if (layout != null) {
                    if (this.tTO == -1) {
                        this.tTO = getPaddingLeft();
                    }
                    if (this.tTP == -1) {
                        this.tTP = getPaddingTop();
                    }
                    if (this.tTQ == -1) {
                        this.tTQ = getPaddingBottom();
                    }
                    if (this.tTN == null) {
                        this.tTN = new Path();
                    }
                    this.tTN.reset();
                    lineForOffset = layout.getLineForOffset(i2);
                    lineForOffset2 = layout.getLineForOffset(i);
                    if (lineForOffset <= lineForOffset2) {
                        width = layout.getWidth();
                        primaryHorizontal = layout.getPrimaryHorizontal(i2) + ((float) this.tTO);
                        lineTop = (float) (layout.getLineTop(lineForOffset) + this.tTP);
                        lineBottom = (float) (layout.getLineBottom(lineForOffset) + this.tTP);
                        primaryHorizontal2 = layout.getPrimaryHorizontal(i) + ((float) this.tTO);
                        lineTop2 = (float) (layout.getLineTop(lineForOffset2) + this.tTP);
                        lineBottom2 = (float) (layout.getLineBottom(lineForOffset2) + this.tTP);
                        if (obj == null) {
                        }
                        if (lineForOffset != lineForOffset2) {
                            if (obj == null) {
                                this.tTN.addRect((float) this.tTO, 0.0f, (float) (this.tTO + width), lineBottom, Direction.CW);
                                this.tTN.addRect((float) this.tTO, lineTop2, primaryHorizontal2, lineBottom2, Direction.CW);
                            } else if (obj2 == null) {
                                this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom, Direction.CW);
                                this.tTN.addRect((float) this.tTO, lineTop2, primaryHorizontal2, lineBottom2, Direction.CW);
                            } else {
                                this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom, Direction.CW);
                                this.tTN.addRect((float) this.tTO, lineTop2, (float) (this.tTO + width), lineBottom2 + ((float) this.tTQ), Direction.CW);
                            }
                            if (lineForOffset2 - lineForOffset > 1) {
                                this.tTN.addRect((float) this.tTO, lineBottom, (float) (this.tTO + width), lineTop2, Direction.CW);
                            }
                        } else if (obj == null) {
                            this.tTN.addRect((float) this.tTO, 0.0f, primaryHorizontal2, lineBottom2, Direction.CW);
                        } else if (obj2 == null) {
                            this.tTN.addRect(primaryHorizontal, lineTop, primaryHorizontal2, lineBottom2, Direction.CW);
                        } else {
                            this.tTN.addRect(primaryHorizontal, lineTop, (float) (this.tTO + width), lineBottom2 + ((float) this.tTQ), Direction.CW);
                        }
                        if (this.tTN.isEmpty()) {
                            if (this.tTK == null) {
                                this.tTK = new Paint(1);
                                this.tTK.setColor(1347529272);
                            }
                            canvas.drawPath(this.tTN, this.tTK);
                        }
                    }
                }
            }
        }
        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (e.isEnabled()) {
            Spannable text = getText();
            if (text == null) {
                bWX();
                return true;
            }
            int length = text.length();
            int offsetForPosition = getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            if (length < 0 || offsetForPosition < 0 || offsetForPosition > length) {
                bWX();
                return true;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    length = (int) motionEvent.getY();
                    Layout layout = getLayout();
                    length = layout.getOffsetForHorizontal(layout.getLineForVertical(length), (float) x);
                    k[] kVarArr = (k[]) getText().getSpans(length, length + 1, k.class);
                    if (!e.bXf().isEditable() || x >= b.bWo() || kVarArr.length == 0) {
                        bWX();
                        this.tTL.a(1, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), offsetForPosition);
                        bWW();
                        this.ikI.J(500, 0);
                        return true;
                    }
                    x.i("noteeditor.WXRTEditText", "clicked todo");
                    this.tTm.bWj();
                    kVarArr[0].a(this, text, motionEvent, kVarArr[0]);
                    return true;
                case 1:
                    bWW();
                    if (this.tTL == null) {
                        return true;
                    }
                    b bVar = this.tTL;
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float x2 = motionEvent.getX();
                    float y = motionEvent.getY();
                    bVar.tUF = rawX;
                    bVar.tUG = rawY;
                    bVar.tUH = x2;
                    bVar.tUI = y;
                    if (bVar.kTK == 1) {
                        bVar.tUJ = offsetForPosition;
                    } else {
                        bVar.tUJ = 0;
                    }
                    length = this.tTL.getType();
                    bWX();
                    if (length != 2) {
                        return true;
                    }
                    if (e.bXf().isEditable()) {
                        boolean z2;
                        boolean z3;
                        if (!hasFocus()) {
                            requestFocus();
                            z2 = false;
                            z3 = false;
                        } else if (getSelectionStart() == getSelectionEnd() && offsetForPosition == getSelectionStart()) {
                            z2 = true;
                            z3 = true;
                        } else {
                            z2 = false;
                            z3 = true;
                        }
                        this.tTM = true;
                        setSelection(offsetForPosition);
                        this.tTM = false;
                        if (this.tTm != null) {
                            this.tTm.f(true, 50);
                            this.tTm.Bq(1);
                        }
                        et(offsetForPosition, offsetForPosition);
                        e.bXf().N(z3, z2);
                        return true;
                    }
                    d bXh = e.bXf().bXh();
                    if (e.bXf().bXm() && bXh.bXe() == 1 && bXh.hlq == this.tTJ && bXh.startOffset == offsetForPosition) {
                        z = true;
                    }
                    et(offsetForPosition, offsetForPosition);
                    e bXf = e.bXf();
                    if (!e.mHasInit) {
                        return true;
                    }
                    bXf.bXn();
                    bXf.bXl();
                    bXf.g(true, 50);
                    bXf.kN(true);
                    bXf.kM(z);
                    return true;
                case 3:
                    bWX();
                    bWW();
                    return true;
                default:
                    return true;
            }
        }
        if (motionEvent.getAction() == 1 && this.tTm != null) {
            this.tTm.f(true, 300);
            this.tTm.Bq(1);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bWW() {
        if (this.ikI == null) {
            this.ikI = new ak(new 3(this), false);
        } else {
            this.ikI.TG();
        }
    }

    public final void Y(int i, boolean z) {
        Editable text = getText();
        if (text != null) {
            Layout layout = getLayout();
            if (layout != null) {
                int length = text.length();
                if (i >= 0 && i <= length) {
                    int i2;
                    if (length == 0) {
                        i = 0;
                        i2 = 0;
                    } else {
                        if (i < length) {
                            if (z || text.charAt(i) != '\n') {
                                i2 = i;
                                i = layout.getOffsetToRightOf(i);
                            }
                        } else if (i == length && z) {
                            i2 = layout.getOffsetToLeftOf(i);
                        }
                        i2 = i;
                    }
                    if (i2 >= 0 && i2 <= length && i >= 0 && i <= length) {
                        if (e.bXf().isEditable()) {
                            requestFocus();
                            this.tTM = true;
                            setSelection(i2, i);
                            this.tTM = false;
                            if (this.tTm != null) {
                                this.tTm.f(true, 50);
                                this.tTm.Bq(1);
                            }
                        }
                        et(i2, i);
                        e.bXf().N(true, true);
                    }
                }
            }
        }
    }

    private void bWX() {
        if (this.tTL == null) {
            this.tTL = new b();
        } else {
            this.tTL.reset();
        }
    }

    private void et(int i, int i2) {
        if (this.tTw == 2) {
            e.bXf().t(this.tTJ, 1, this.tTJ, 1);
        } else if (this.tTw == 1) {
            e.bXf().t(this.tTJ, 0, this.tTJ, 0);
        } else {
            e.bXf().t(this.tTJ, i, this.tTJ, i2);
        }
    }
}
