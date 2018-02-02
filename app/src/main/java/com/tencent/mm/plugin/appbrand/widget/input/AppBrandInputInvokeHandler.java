package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Looper;
import android.support.v4.view.z;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;
import com.tencent.mm.plugin.appbrand.widget.input.b.h;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.appbrand.widget.input.u.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.a.c.a;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class AppBrandInputInvokeHandler implements y<w> {
    private static final String TAG = "MicroMsg.AppBrandInputInvokeHandler";
    private final af H = new af(Looper.getMainLooper());
    private final a inputExceedMaxLengthCallback = new 7(this);
    private final Runnable mAutoScrollForMultiLineRunnerAfterSmileyPanelSettle = new 8(this);
    private w mInput;
    final OnFocusChangeListener mInputFocusChangeListenerImpl = new 1(this);
    private int mInputId;
    private int mLastContentHeight = -1;
    private int mLastLineCount = -1;
    private t mNumberKeyboard;
    private volatile a mOnInputFocusChangeListener;
    private volatile b mOnLineHeightChangeListener;
    protected WeakReference<p> mPageRef;
    private e mParams;
    private boolean mPerformingDelete = false;
    private final Runnable mResetPerformingDelete = new 9(this);
    private final d mSmileyChosenListener = new d(this) {
        final /* synthetic */ AppBrandInputInvokeHandler jXc;

        {
            this.jXc = r1;
        }

        public final boolean uX(String str) {
            if (this.jXc.mInput != null) {
                w access$200;
                if ("[DELETE_EMOTION]".equalsIgnoreCase(str)) {
                    access$200 = this.jXc.mInput;
                    if (access$200.jYM == null) {
                        access$200.dispatchKeyEvent(new KeyEvent(0, 67));
                        access$200.dispatchKeyEvent(new KeyEvent(1, 67));
                    } else if (!bh.M(access$200.getEditableText())) {
                        access$200.jYM.deleteSurroundingText(access$200.getEditableText().length(), access$200.getEditableText().length() - 1);
                    }
                } else {
                    access$200 = this.jXc.mInput;
                    if (access$200.getEditableText() == null) {
                        access$200.setText(str, BufferType.EDITABLE);
                    } else {
                        access$200.getEditableText().append(str);
                    }
                    access$200.setSelection(access$200.getEditableText().length());
                }
            }
            return true;
        }
    };
    private final c mSmileyOnDoneListener = new 2(this);
    private u mSmileyPanel;
    private final u.e mSmileyVisibilityListener = new 3(this);
    private int mTextDoneReason$25f24e96 = 0;
    private final com.tencent.mm.plugin.appbrand.widget.input.a.a mValueChangeNotify = new com.tencent.mm.plugin.appbrand.widget.input.a.a();

    public interface b {
        void bI(int i, int i2);
    }

    public abstract void onInputDone(String str, int i, boolean z, boolean z2);

    public abstract void onInputInitialized();

    public abstract void onRuntimeFail();

    public void setOnValueChangeListener(com.tencent.mm.plugin.appbrand.widget.input.a.c cVar) {
        this.mValueChangeNotify.kaI = cVar;
    }

    public void setOnLineHeightChangeListener(b bVar) {
        this.mOnLineHeightChangeListener = bVar;
    }

    public void setOnInputFocusChangeListener(a aVar) {
        this.mOnInputFocusChangeListener = aVar;
    }

    public final void insertInput(e eVar, int i, int i2) {
        com.tencent.mm.plugin.appbrand.q.c.bj(this);
        this.mParams = eVar;
        insertInputImpl(i, i2);
    }

    final boolean updateInput(h hVar) {
        if (this.mParams == null || this.mInput == null) {
            return false;
        }
        this.mParams.a(hVar);
        if (!this.mParams.kbF && (this.mParams.kbJ == null || this.mParams.kbJ.intValue() <= 0)) {
            return false;
        }
        this.mInput.setWillNotDraw(true);
        resetInputAttributes();
        if (this.mParams.kbH != null) {
            this.mInput.r(bh.ou(this.mParams.kbH));
        }
        if (af.e(this.mParams.kcc)) {
            mayAutoResizeInputHeight();
            lineHeightMaybeChanged();
        } else {
            updateInputPosition(this.mInput, this.mParams);
        }
        this.mInput.setWillNotDraw(false);
        this.mInput.invalidate();
        return true;
    }

    public boolean isAttachedTo(p pVar) {
        return (pVar == null || this.mPageRef == null || pVar != this.mPageRef.get()) ? false : true;
    }

    public boolean showKeyboard(int i, int i2) {
        doShowKeyboard();
        setInputSelection(i, i2);
        return true;
    }

    public boolean hideKeyboard() {
        doHideKeyboard();
        return true;
    }

    public void updateValue(String str, Integer num) {
        if (this.mInput != null) {
            this.mInput.r((CharSequence) str);
            Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
            setInputSelection(valueOf.intValue(), valueOf.intValue());
            lineHeightMaybeChanged();
        }
    }

    public boolean isFocused() {
        return this.mInput != null && (this.mInput.isFocused() || (findSmileyPanel() != null && findSmileyPanel().aeY() == this.mInput));
    }

    @Deprecated
    private void doHideKeyboard() {
        if (isFocused()) {
            u findSmileyPanel = findSmileyPanel();
            if (findSmileyPanel != null) {
                findSmileyPanel.setVisibility(8);
                return;
            }
            return;
        }
        x.d(TAG, "doHideKeyboard, not focused, return");
    }

    @Deprecated
    private void doShowKeyboard() {
        if (this.mInput != null && this.mPageRef != null && this.mPageRef.get() != null) {
            this.mInput.performClick();
        }
    }

    public boolean removeSelf() {
        if (!removeInput()) {
            return false;
        }
        onDestroy();
        return true;
    }

    @Deprecated
    private boolean removeInput() {
        if (this.mInput == null || this.mPageRef == null || this.mPageRef.get() == null) {
            return false;
        }
        this.mInput.destroy();
        f fVar = ((p) this.mPageRef.get()).jDR;
        if (fVar == null) {
            return false;
        }
        if (this.mInput.hasFocus()) {
            if (this.mNumberKeyboard != null) {
                this.mNumberKeyboard.setVisibility(8);
            }
            findSmileyPanel();
            if (this.mSmileyPanel != null) {
                this.mSmileyPanel.setVisibility(8);
            }
        }
        fVar.bR(this.mInput);
        return true;
    }

    public View getInputPanel() {
        return this.mSmileyPanel;
    }

    public w getWidget() {
        return this.mInput;
    }

    public boolean adjustPositionOnFocused() {
        return this.mParams != null && af.e(this.mParams.kch);
    }

    public int getInputPanelMarginBottom() {
        if (this.mParams != null && this.mParams.kce != null) {
            return this.mParams.kce.intValue();
        }
        if (this.mInput == null || !this.mInput.amK()) {
            return 0;
        }
        return 5;
    }

    private void onDestroy() {
        this.mInput = null;
        com.tencent.mm.plugin.appbrand.q.c.bk(this);
    }

    public final int getInputId() {
        return this.mInputId;
    }

    private void mayAutoResizeInputHeight() {
        if (this.mInput != null && af.e(this.mParams.kcc) && af.e(this.mParams.kca)) {
            ((o) this.mInput).du(true);
            int lineHeight = this.mInput.getLineHeight();
            int anb = this.mInput.anb();
            int intValue = (this.mParams.kbM == null || this.mParams.kbM.intValue() <= 0) ? lineHeight : this.mParams.kbM.intValue();
            lineHeight = (this.mParams.kbN == null || this.mParams.kbN.intValue() <= 0) ? Integer.MAX_VALUE : Math.max(this.mParams.kbN.intValue(), lineHeight);
            this.mInput.setMinHeight(intValue);
            this.mInput.setMaxHeight(lineHeight);
            this.mParams.kbJ = Integer.valueOf(Math.max(intValue, Math.min(anb, lineHeight)));
            updateInputPosition(this.mInput, this.mParams);
        }
    }

    private void resetInputAttributes() {
        b.a(this.mInput, this.mParams);
        if (this.mParams.kbT == null) {
            this.mParams.kbT = Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
        } else if (this.mParams.kbT.intValue() <= 0) {
            this.mParams.kbT = Integer.valueOf(Integer.MAX_VALUE);
        }
        com.tencent.mm.ui.tools.a.c GN = n.a(this.mInput).GN(this.mParams.kbT.intValue());
        GN.znM = false;
        GN.jXW = com.tencent.mm.ui.tools.h.a.zkT;
        GN.a(this.inputExceedMaxLengthCallback);
        this.mInput.dv(this.mParams.kbD);
        if (af.e(this.mParams.kbY)) {
            this.mInput.setEnabled(false);
            this.mInput.setFocusable(false);
            this.mInput.setFocusableInTouchMode(false);
            this.mInput.setClickable(false);
        } else {
            this.mInput.setEnabled(true);
            this.mInput.setClickable(true);
        }
        if (this.mInput instanceof o) {
            o oVar;
            if (this.mParams.kci != null) {
                oVar = (o) this.mInput;
                oVar.setLineSpacing((float) this.mParams.kci.intValue(), oVar.jYc);
            }
            if (this.mParams.kcj != null) {
                oVar = (o) this.mInput;
                float intValue = (float) this.mParams.kcj.intValue();
                if (intValue > 0.0f) {
                    oVar.a(intValue, true);
                }
            }
        }
    }

    private void setInputSelection(int i, int i2) {
        b.a(this.mInput, i, i2);
        mayAutoScrollIfMultiLine();
    }

    private void lineHeightMaybeChanged() {
        if (this.mInput != null) {
            if (this.mInput.getLineCount() != this.mLastLineCount || this.mInput.anb() != this.mLastContentHeight) {
                Object obj = this.mLastLineCount == -1 ? 1 : null;
                this.mLastLineCount = this.mInput.getLineCount();
                this.mLastContentHeight = this.mInput.anb();
                if (this.mOnLineHeightChangeListener != null) {
                    this.mOnLineHeightChangeListener.bI(this.mLastLineCount, this.mLastContentHeight);
                }
                if (this.mParams.kca.booleanValue() && obj == null) {
                    mayAutoResizeInputHeight();
                    mayAutoScrollIfMultiLine();
                }
            }
        }
    }

    private void mayAutoScrollIfMultiLine() {
        if (this.mParams.kca.booleanValue() && this.mSmileyPanel != null && this.mSmileyPanel.isShown() && this.mInput != null && this.mInput == this.mSmileyPanel.aeY()) {
            i.a(this.mPageRef).amC();
        }
    }

    private void setupSmileyFocus() {
        if (this.mParams.kca.booleanValue()) {
            findSmileyPanel();
        }
        if (this.mSmileyPanel != null && this.mInput != null) {
            this.mSmileyPanel.jYF = this.mInput;
            this.mSmileyPanel.dx(af.e(this.mParams.kcb));
            setupSmileyPanelListeners();
            if (j.bK(this.mInput) && this.mInput.hasFocus()) {
                this.mSmileyPanel.show();
            }
        }
    }

    private void notifyInputFocusChange(boolean z) {
        if (z) {
            setupSmileyFocus();
        }
        if (this.mSmileyPanel == null) {
            this.mSmileyPanel = findSmileyPanel();
        }
        if (this.mOnInputFocusChangeListener != null) {
            this.mOnInputFocusChangeListener.cL(z);
        }
        if (this.mInput != null && z && this.mParams.kca.booleanValue()) {
            ag.h(this.mAutoScrollForMultiLineRunnerAfterSmileyPanelSettle, 100);
        }
        if (!(this.mInput == null || z || this.mParams.kbE)) {
            if (this.mTextDoneReason$25f24e96 == 0) {
                dispatchKeyboardComplete(false);
            }
            this.mInput.setFocusable(false);
            this.mInput.setFocusableInTouchMode(false);
            if (this.mSmileyPanel.aeY() == this.mInput) {
                this.mSmileyPanel.hide();
                this.mSmileyPanel.b(this.mInput);
            }
        }
        if (this.mSmileyPanel != null && this.mInput != null && !z && this.mParams.kbE) {
            removeInputWhenFocusLoss();
        }
    }

    private void removeInputWhenFocusLoss() {
        dispatchKeyboardComplete(false);
        if (this.mParams.kbE) {
            removeInputImpl(this.mInput);
            onDestroy();
        }
    }

    private void insertInputImpl(int i, int i2) {
        this.mPageRef = this.mParams.jWK;
        p pVar = this.mPageRef == null ? null : (p) this.mPageRef.get();
        if (pVar == null || pVar.jDS == null) {
            x.e(TAG, "insertInputImpl, view not ready, return fail");
            onRuntimeFail();
            return;
        }
        w oVar;
        if (af.e(this.mParams.kca)) {
            oVar = new o(pVar.mContext);
        } else {
            oVar = new r(pVar.mContext);
        }
        this.mInput = oVar;
        resetInputAttributes();
        this.mInput.setText(bh.ou(this.mParams.kbH));
        if (af.e(this.mParams.kcc)) {
            lineHeightMaybeChanged();
        }
        this.mInput.addTextChangedListener(new 10(this));
        this.mInput.jYV.jZh = new 11(this);
        if (addInputImpl(this.mInput, this.mParams)) {
            if (!(this.mParams.kbG == null || bh.cA(this.mParams.kbG.kbq))) {
                com.tencent.mm.plugin.appbrand.widget.input.autofill.d.a(pVar, this.mInput, this.mParams.kbG);
            }
            if (!af.e(this.mParams.kca)) {
                b.a(this.mInput, i, i2);
            }
            if (af.e(this.mParams.kca)) {
                this.mInput.post(new 12(this));
            }
            if ("text".equalsIgnoreCase(this.mParams.kbC) || "emoji".equalsIgnoreCase(this.mParams.kbC)) {
                initSmileyPanelAndShow();
            } else {
                Assert.assertTrue("Number type implementation removed from here", false);
            }
            this.mInputId = this.mParams.jWO;
            this.mInput.mInputId = this.mInputId;
            this.mInput.setOnClickListener(new 13(this));
            m.a(this.mInputId, this);
            onInputInitialized();
            return;
        }
        x.e(TAG, "add custom view into webView failed");
        onRuntimeFail();
    }

    boolean addInputImpl(w wVar, e eVar) {
        if (wVar == null || this.mPageRef == null || this.mPageRef.get() == null) {
            return false;
        }
        f fVar = ((p) this.mPageRef.get()).jDR;
        if (fVar != null) {
            if (fVar.a(((p) this.mPageRef.get()).jDS, wVar, eVar.kbI.intValue(), eVar.kbJ.intValue(), eVar.kbL.intValue(), eVar.kbK.intValue())) {
                return true;
            }
        }
        return false;
    }

    boolean updateInputPosition(w wVar, e eVar) {
        if (wVar == null || this.mPageRef == null || this.mPageRef.get() == null) {
            return false;
        }
        f fVar = ((p) this.mPageRef.get()).jDR;
        if (fVar != null) {
            if (fVar.b(((p) this.mPageRef.get()).jDS, wVar, eVar.kbI.intValue(), eVar.kbJ.intValue(), eVar.kbL.intValue(), eVar.kbK.intValue())) {
                return true;
            }
        }
        return false;
    }

    void removeInputImpl(w wVar) {
        if (wVar != null) {
            wVar.b(this.mInputFocusChangeListenerImpl);
            p pVar = this.mPageRef == null ? null : (p) this.mPageRef.get();
            if (pVar != null) {
                f fVar = pVar.jDR;
                if (fVar != null) {
                    fVar.bR(wVar);
                }
            }
        }
    }

    private void setupSmileyPanelListeners() {
        if (this.mSmileyPanel != null) {
            this.mSmileyPanel.jYv = this.mSmileyChosenListener;
            this.mSmileyPanel.jYw = this.mSmileyOnDoneListener;
            this.mSmileyPanel.jYy = this.mSmileyVisibilityListener;
        }
    }

    private void initSmileyPanelAndShow() {
        p pVar = (p) this.mPageRef.get();
        if (z.ak(pVar.getContentView())) {
            this.mSmileyPanel = u.bZ(pVar.getContentView());
            setupSmileyPanelListeners();
            hideNumberKeyboard();
            this.mInput.a(this.mInputFocusChangeListenerImpl);
            this.mInput.setOnKeyListener(new 4(this));
            m.a((p) this.mPageRef.get(), this.mInput);
            u uVar = this.mSmileyPanel;
            if (!this.mParams.kbD) {
                "emoji".equals(this.mParams.kbC);
            }
            uVar.amX();
            if (this.mParams.kca.booleanValue()) {
                this.mInput.setOnEditorActionListener(null);
                this.mInput.setImeOptions(0);
            } else {
                com.tencent.mm.plugin.appbrand.widget.input.b.b anA;
                if (this.mParams.kcf == null) {
                    anA = com.tencent.mm.plugin.appbrand.widget.input.b.b.anA();
                } else {
                    anA = this.mParams.kcf;
                }
                int i = anA.kbw;
                this.mInput.setImeOptions(i);
                this.mInput.setOnEditorActionListener(new 5(this, i));
            }
            this.mSmileyPanel.dx(this.mParams.kcb.booleanValue());
            this.mSmileyPanel.jYF = this.mInput;
            if (this.mParams.kca.booleanValue()) {
                this.mInput.setFocusable(false);
                this.mInput.setFocusableInTouchMode(false);
                this.mSmileyPanel.hide();
            } else {
                this.mInput.requestFocus();
                this.mSmileyPanel.show();
            }
            if (!this.mParams.kca.booleanValue()) {
                i.a(this.mPageRef).amC();
            }
            ((p) this.mPageRef.get()).a(new 6(this));
        }
    }

    private void dispatchKeyboardComplete(boolean z) {
        if (this.mInput != null) {
            onInputDone(this.mInput.getText().toString(), this.mInput.getSelectionEnd(), this.mTextDoneReason$25f24e96 == c.jXf, z);
        }
    }

    private void doneTextInput() {
        boolean z = this.mTextDoneReason$25f24e96 == c.jXf && af.e(this.mParams.kcg);
        if (!z) {
            hideSmileyPanel();
        }
        if (this.mInput != null) {
            if (this.mInput.hasFocus()) {
                dispatchKeyboardComplete(z);
            }
            if (!z) {
                if (this.mSmileyPanel != null) {
                    this.mSmileyPanel.b(this.mInput);
                }
                if (this.mParams.kbE) {
                    removeInputImpl(this.mInput);
                    onDestroy();
                    return;
                }
                this.mInput.setFocusable(false);
                this.mInput.setFocusableInTouchMode(false);
            }
        }
    }

    private u findSmileyPanel() {
        if (this.mSmileyPanel != null) {
            return this.mSmileyPanel;
        }
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                u bY = u.bY(pVar.getContentView());
                this.mSmileyPanel = bY;
                return bY;
            }
        }
        return null;
    }

    private void hideSmileyPanel() {
        if (findSmileyPanel() != null) {
            this.mSmileyPanel.hide();
        } else if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                Activity cg = j.cg(pVar.mContext);
                if (cg instanceof MMActivity) {
                    ((MMActivity) cg).aWs();
                }
            } else {
                return;
            }
        }
        i.a(this.mPageRef).amD();
    }

    private t findNumberKeyboard() {
        if (this.mNumberKeyboard != null) {
            return this.mNumberKeyboard;
        }
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                t bW = t.bW(pVar.getContentView());
                this.mNumberKeyboard = bW;
                return bW;
            }
        }
        return null;
    }

    private void hideNumberKeyboard() {
        if (findNumberKeyboard() != null) {
            this.mNumberKeyboard.setVisibility(8);
        }
    }
}
