package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.g;
import android.support.v4.widget.e;
import android.support.v7.a.a.a;
import android.support.v7.a.a.d;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements android.support.v7.view.c {
    private static final boolean WM;
    static final a Xv = new a();
    private final OnItemSelectedListener Gu;
    private final h Pc;
    private final SearchAutoComplete WN;
    private final View WO;
    private final View WP;
    private final View WQ;
    private final ImageView WR;
    private final ImageView WS;
    private final ImageView WT;
    private final ImageView WU;
    private final View WV;
    private final ImageView WW;
    private final Drawable WX;
    private final int WY;
    private final int WZ;
    OnKeyListener XA;
    private final OnEditorActionListener XB;
    private final OnItemClickListener XC;
    private TextWatcher XD;
    private final Intent Xa;
    private final Intent Xb;
    private final CharSequence Xc;
    private c Xd;
    private b Xe;
    private OnFocusChangeListener Xf;
    private d Xg;
    private OnClickListener Xh;
    private boolean Xi;
    private boolean Xj;
    private e Xk;
    private boolean Xl;
    private CharSequence Xm;
    private boolean Xn;
    private boolean Xo;
    private CharSequence Xp;
    private CharSequence Xq;
    private boolean Xr;
    private int Xs;
    private SearchableInfo Xt;
    private Bundle Xu;
    private Runnable Xw;
    private final Runnable Xx;
    private Runnable Xy;
    private final WeakHashMap<String, ConstantState> Xz;
    private int iX;
    private final OnClickListener mOnClickListener;

    public interface c {
        boolean gD();
    }

    static /* synthetic */ void a(SearchView searchView) {
        int[] iArr = searchView.WN.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = searchView.WP.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = searchView.WQ.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        searchView.invalidate();
    }

    static /* synthetic */ void a(SearchView searchView, CharSequence charSequence) {
        boolean z = true;
        CharSequence text = searchView.WN.getText();
        searchView.Xq = text;
        boolean z2 = !TextUtils.isEmpty(text);
        searchView.V(z2);
        if (z2) {
            z = false;
        }
        searchView.X(z);
        searchView.gx();
        searchView.gw();
        if (!(searchView.Xd == null || TextUtils.equals(charSequence, searchView.Xp))) {
            charSequence.toString();
        }
        searchView.Xp = charSequence.toString();
    }

    static /* synthetic */ boolean b(SearchView searchView, int i) {
        if (searchView.Xg != null && searchView.Xg.gE()) {
            return false;
        }
        CharSequence text = searchView.WN.getText();
        Cursor cursor = searchView.Xk.BA;
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = searchView.Xk.convertToString(cursor);
                if (convertToString != null) {
                    searchView.h(convertToString);
                } else {
                    searchView.h(text);
                }
            } else {
                searchView.h(text);
            }
        }
        return true;
    }

    static /* synthetic */ void d(SearchView searchView) {
        if (searchView.WV.getWidth() > 1) {
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.WP.getPaddingLeft();
            Rect rect = new Rect();
            boolean bv = at.bv(searchView);
            int dimensionPixelSize = searchView.Xi ? resources.getDimensionPixelSize(d.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(d.abc_dropdownitem_icon_width) : 0;
            searchView.WN.getDropDownBackground().getPadding(rect);
            searchView.WN.setDropDownHorizontalOffset(bv ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            searchView.WN.setDropDownWidth((dimensionPixelSize + ((searchView.WV.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    static /* synthetic */ void h(SearchView searchView) {
        if (!TextUtils.isEmpty(searchView.WN.getText())) {
            searchView.WN.setText("");
            searchView.WN.requestFocus();
            searchView.W(true);
        } else if (!searchView.Xi) {
        } else {
            if (searchView.Xe == null || !searchView.Xe.onClose()) {
                searchView.clearFocus();
                searchView.U(true);
            }
        }
    }

    static /* synthetic */ void j(SearchView searchView) {
        CharSequence text = searchView.WN.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (searchView.Xd != null) {
                c cVar = searchView.Xd;
                text.toString();
                if (cVar.gD()) {
                    return;
                }
            }
            if (searchView.Xt != null) {
                searchView.b(0, null, text.toString());
            }
            searchView.W(false);
            searchView.WN.dismissDropDown();
        }
    }

    static /* synthetic */ void l(SearchView searchView) {
        String str = null;
        if (searchView.Xt != null) {
            SearchableInfo searchableInfo = searchView.Xt;
            try {
                Intent intent;
                String str2;
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    intent = new Intent(searchView.Xa);
                    ComponentName searchActivity = searchableInfo.getSearchActivity();
                    str2 = "calling_package";
                    if (searchActivity != null) {
                        str = searchActivity.flattenToShortString();
                    }
                    intent.putExtra(str2, str);
                    searchView.getContext().startActivity(intent);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    String string;
                    Intent intent2 = searchView.Xb;
                    ComponentName searchActivity2 = searchableInfo.getSearchActivity();
                    intent = new Intent("android.intent.action.SEARCH");
                    intent.setComponent(searchActivity2);
                    Parcelable activity = PendingIntent.getActivity(searchView.getContext(), 0, intent, 1073741824);
                    Bundle bundle = new Bundle();
                    if (searchView.Xu != null) {
                        bundle.putParcelable("app_data", searchView.Xu);
                    }
                    Intent intent3 = new Intent(intent2);
                    String str3 = "free_form";
                    int i = 1;
                    if (VERSION.SDK_INT >= 8) {
                        Resources resources = searchView.getResources();
                        string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : str3;
                        str2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
                        str3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
                        if (searchableInfo.getVoiceMaxResults() != 0) {
                            i = searchableInfo.getVoiceMaxResults();
                        }
                    } else {
                        str2 = null;
                        string = str3;
                        str3 = null;
                    }
                    intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
                    intent3.putExtra("android.speech.extra.PROMPT", str2);
                    intent3.putExtra("android.speech.extra.LANGUAGE", str3);
                    intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
                    String str4 = "calling_package";
                    if (searchActivity2 != null) {
                        str = searchActivity2.flattenToShortString();
                    }
                    intent3.putExtra(str4, str);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
                    searchView.getContext().startActivity(intent3);
                }
            } catch (ActivityNotFoundException e) {
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        WM = z;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xw = new 1(this);
        this.Xx = new Runnable(this) {
            final /* synthetic */ SearchView XE;

            {
                this.XE = r1;
            }

            public final void run() {
                SearchView.a(this.XE);
            }
        };
        this.Xy = new 6(this);
        this.Xz = new WeakHashMap();
        this.mOnClickListener = new 10(this);
        this.XA = new 11(this);
        this.XB = new OnEditorActionListener(this) {
            final /* synthetic */ SearchView XE;

            {
                this.XE = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.j(this.XE);
                return true;
            }
        };
        this.XC = new 2(this);
        this.Gu = new OnItemSelectedListener(this) {
            final /* synthetic */ SearchView XE;

            {
                this.XE = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.b(this.XE, i);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.XD = new 4(this);
        this.Pc = h.ey();
        ap a = ap.a(context, attributeSet, k.SearchView, i);
        LayoutInflater.from(context).inflate(a.getResourceId(k.SearchView_layout, h.abc_search_view), this, true);
        this.WN = (SearchAutoComplete) findViewById(f.search_src_text);
        this.WN.XK = this;
        this.WO = findViewById(f.search_edit_frame);
        this.WP = findViewById(f.search_plate);
        this.WQ = findViewById(f.submit_area);
        this.WR = (ImageView) findViewById(f.search_button);
        this.WS = (ImageView) findViewById(f.search_go_btn);
        this.WT = (ImageView) findViewById(f.search_close_btn);
        this.WU = (ImageView) findViewById(f.search_voice_btn);
        this.WW = (ImageView) findViewById(f.search_mag_icon);
        this.WP.setBackgroundDrawable(a.getDrawable(k.SearchView_queryBackground));
        this.WQ.setBackgroundDrawable(a.getDrawable(k.SearchView_submitBackground));
        this.WR.setImageDrawable(a.getDrawable(k.SearchView_searchIcon));
        this.WS.setImageDrawable(a.getDrawable(k.SearchView_goIcon));
        this.WT.setImageDrawable(a.getDrawable(k.SearchView_closeIcon));
        this.WU.setImageDrawable(a.getDrawable(k.SearchView_voiceIcon));
        this.WW.setImageDrawable(a.getDrawable(k.SearchView_searchIcon));
        this.WX = a.getDrawable(k.SearchView_searchHintIcon);
        this.WY = a.getResourceId(k.SearchView_suggestionRowLayout, h.abc_search_dropdown_item_icons_2line);
        this.WZ = a.getResourceId(k.SearchView_commitIcon, 0);
        this.WR.setOnClickListener(this.mOnClickListener);
        this.WT.setOnClickListener(this.mOnClickListener);
        this.WS.setOnClickListener(this.mOnClickListener);
        this.WU.setOnClickListener(this.mOnClickListener);
        this.WN.setOnClickListener(this.mOnClickListener);
        this.WN.addTextChangedListener(this.XD);
        this.WN.setOnEditorActionListener(this.XB);
        this.WN.setOnItemClickListener(this.XC);
        this.WN.setOnItemSelectedListener(this.Gu);
        this.WN.setOnKeyListener(this.XA);
        this.WN.setOnFocusChangeListener(new 7(this));
        boolean z = a.getBoolean(k.SearchView_iconifiedByDefault, true);
        if (this.Xi != z) {
            this.Xi = z;
            U(z);
            gz();
        }
        int dimensionPixelSize = a.getDimensionPixelSize(k.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            this.iX = dimensionPixelSize;
            requestLayout();
        }
        this.Xc = a.getText(k.SearchView_defaultQueryHint);
        this.Xm = a.getText(k.SearchView_queryHint);
        dimensionPixelSize = a.getInt(k.SearchView_android_imeOptions, -1);
        if (dimensionPixelSize != -1) {
            this.WN.setImeOptions(dimensionPixelSize);
        }
        dimensionPixelSize = a.getInt(k.SearchView_android_inputType, -1);
        if (dimensionPixelSize != -1) {
            this.WN.setInputType(dimensionPixelSize);
        }
        setFocusable(a.getBoolean(k.SearchView_android_focusable, true));
        a.Zu.recycle();
        this.Xa = new Intent("android.speech.action.WEB_SEARCH");
        this.Xa.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.Xa.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.Xb = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.Xb.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.WV = findViewById(this.WN.getDropDownAnchor());
        if (this.WV != null) {
            if (VERSION.SDK_INT >= 11) {
                this.WV.addOnLayoutChangeListener(new 8(this));
            } else {
                this.WV.getViewTreeObserver().addOnGlobalLayoutListener(new 9(this));
            }
        }
        U(this.Xi);
        gz();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.Xn || !isFocusable()) {
            return false;
        }
        if (this.Xj) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.WN.requestFocus(i, rect);
        if (requestFocus) {
            U(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.Xn = true;
        W(false);
        super.clearFocus();
        this.WN.clearFocus();
        this.Xn = false;
    }

    protected void onMeasure(int i, int i2) {
        if (this.Xj) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.iX <= 0) {
                    size = Math.min(gu(), size);
                    break;
                } else {
                    size = Math.min(this.iX, size);
                    break;
                }
            case 0:
                if (this.iX <= 0) {
                    size = gu();
                    break;
                } else {
                    size = this.iX;
                    break;
                }
            case 1073741824:
                if (this.iX > 0) {
                    size = Math.min(this.iX, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int gu() {
        return getContext().getResources().getDimensionPixelSize(d.abc_search_view_preferred_width);
    }

    private void U(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.Xj = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.WN.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.WR.setVisibility(i2);
        V(z2);
        View view = this.WO;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.WW.getDrawable() == null || this.Xi)) {
            i = 0;
        }
        this.WW.setVisibility(i);
        gx();
        if (z2) {
            z3 = false;
        }
        X(z3);
        gw();
    }

    private boolean gv() {
        return (this.Xl || this.Xo) && !this.Xj;
    }

    private void V(boolean z) {
        int i = 8;
        if (this.Xl && gv() && hasFocus() && (z || !this.Xo)) {
            i = 0;
        }
        this.WS.setVisibility(i);
    }

    private void gw() {
        int i = 8;
        if (gv() && (this.WS.getVisibility() == 0 || this.WU.getVisibility() == 0)) {
            i = 0;
        }
        this.WQ.setVisibility(i);
    }

    private void gx() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.WN.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.Xi || this.Xr)) {
            i = 0;
        }
        ImageView imageView = this.WT;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.WT.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void gy() {
        post(this.Xx);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.Xx);
        post(this.Xy);
        super.onDetachedFromWindow();
    }

    private void W(boolean z) {
        if (z) {
            post(this.Xw);
            return;
        }
        removeCallbacks(this.Xw);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private boolean b(int i, KeyEvent keyEvent) {
        if (this.Xt == null || this.Xk == null || keyEvent.getAction() != 0 || !g.a(keyEvent)) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return bx(this.WN.getListSelection());
        }
        if (i != 21 && i != 22) {
            return (i == 19 && this.WN.getListSelection() == 0) ? false : false;
        } else {
            int i2;
            if (i == 21) {
                i2 = 0;
            } else {
                i2 = this.WN.length();
            }
            this.WN.setSelection(i2);
            this.WN.setListSelection(0);
            this.WN.clearListSelection();
            Xv.a(this.WN);
            return true;
        }
    }

    private void gz() {
        CharSequence text = this.Xm != null ? this.Xm : (!WM || this.Xt == null || this.Xt.getHintId() == 0) ? this.Xc : getContext().getText(this.Xt.getHintId());
        SearchAutoComplete searchAutoComplete = this.WN;
        if (text == null) {
            text = "";
        }
        if (this.Xi && this.WX != null) {
            int textSize = (int) (((double) this.WN.getTextSize()) * 1.25d);
            this.WX.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.WX), 1, 2, 33);
            spannableStringBuilder.append(text);
            Object obj = spannableStringBuilder;
        }
        searchAutoComplete.setHint(text);
    }

    private void X(boolean z) {
        int i;
        if (this.Xo && !this.Xj && z) {
            i = 0;
            this.WS.setVisibility(8);
        } else {
            i = 8;
        }
        this.WU.setVisibility(i);
    }

    private void gA() {
        U(false);
        this.WN.requestFocus();
        W(true);
        if (this.Xh != null) {
            this.Xh.onClick(this);
        }
    }

    final void gB() {
        U(this.Xj);
        gy();
        if (this.WN.hasFocus()) {
            gC();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        gy();
    }

    public final void onActionViewCollapsed() {
        CharSequence charSequence = "";
        this.WN.setText(charSequence);
        this.WN.setSelection(this.WN.length());
        this.Xq = charSequence;
        clearFocus();
        U(true);
        this.WN.setImeOptions(this.Xs);
        this.Xr = false;
    }

    public final void onActionViewExpanded() {
        if (!this.Xr) {
            this.Xr = true;
            this.Xs = this.WN.getImeOptions();
            this.WN.setImeOptions(this.Xs | 33554432);
            this.WN.setText("");
            gA();
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.XJ = this.Xj;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            U(savedState.XJ);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private boolean bx(int i) {
        if (this.Xg != null && this.Xg.gF()) {
            return false;
        }
        Cursor cursor = this.Xk.BA;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent a = a(cursor, 0, null);
            if (a != null) {
                try {
                    getContext().startActivity(a);
                } catch (RuntimeException e) {
                    new StringBuilder("Failed launch activity: ").append(a);
                }
            }
        }
        W(false);
        this.WN.dismissDropDown();
        return true;
    }

    final void h(CharSequence charSequence) {
        this.WN.setText(charSequence);
        this.WN.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void b(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, 0, null));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.Xq);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.Xu != null) {
            intent.putExtra("app_data", this.Xu);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (WM) {
            intent.setComponent(this.Xt.getSearchActivity());
        }
        return intent;
    }

    private Intent a(Cursor cursor, int i, String str) {
        try {
            String a = ak.a(cursor, "suggest_intent_action");
            if (a == null && VERSION.SDK_INT >= 8) {
                a = this.Xt.getSuggestIntentAction();
            }
            if (a == null) {
                a = "android.intent.action.SEARCH";
            }
            String a2 = ak.a(cursor, "suggest_intent_data");
            if (WM && a2 == null) {
                a2 = this.Xt.getSuggestIntentData();
            }
            if (a2 != null) {
                String a3 = ak.a(cursor, "suggest_intent_data_id");
                if (a3 != null) {
                    a2 = a2 + "/" + Uri.encode(a3);
                }
            }
            return a(a, a2 == null ? null : Uri.parse(a2), ak.a(cursor, "suggest_intent_extra_data"), ak.a(cursor, "suggest_intent_query"), 0, null);
        } catch (RuntimeException e) {
            int position;
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e2) {
                position = -1;
            }
            new StringBuilder("Search suggestions cursor at row ").append(position).append(" returned exception.");
            return null;
        }
    }

    private void gC() {
        a aVar = Xv;
        SearchAutoComplete searchAutoComplete = this.WN;
        if (aVar.XF != null) {
            try {
                aVar.XF.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception e) {
            }
        }
        aVar = Xv;
        searchAutoComplete = this.WN;
        if (aVar.XG != null) {
            try {
                aVar.XG.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception e2) {
            }
        }
    }

    static boolean q(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
