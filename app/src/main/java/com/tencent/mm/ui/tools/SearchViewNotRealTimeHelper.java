package com.tencent.mm.ui.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.v;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper extends LinearLayout implements f {
    public EditText yig;
    public View zgk;
    private ImageButton zgm;
    private com.tencent.mm.ui.tools.ActionBarSearchView.a zgr;
    public Button zmE;
    public a zmF;

    public interface a {
        void asB();

        boolean oK(String str);

        void vR(String str);
    }

    public SearchViewNotRealTimeHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SearchViewNotRealTimeHelper(Context context) {
        super(context);
        init();
    }

    private void init() {
        v.fv(getContext()).inflate(h.gWX, this, true);
        this.yig = (EditText) findViewById(g.cdj);
        this.zgm = (ImageButton) findViewById(g.cPl);
        this.zgk = findViewById(g.bIb);
        this.zmE = (Button) findViewById(g.button);
        this.zmE.setEnabled(false);
        this.yig.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper zmG;

            {
                this.zmG = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable == null || editable.length() <= 0) {
                    this.zmG.zgm.setVisibility(8);
                    this.zmG.zmE.setEnabled(false);
                    return;
                }
                this.zmG.zgm.setVisibility(0);
                this.zmG.zmE.setEnabled(true);
            }
        });
        this.yig.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper zmG;

            {
                this.zmG = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || this.zmG.zmF == null) {
                    return false;
                }
                return this.zmG.zmF.oK(this.zmG.bUS());
            }
        });
        c.d(this.yig).GN(100).a(null);
        this.zgm.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper zmG;

            {
                this.zmG = r1;
            }

            public final void onClick(View view) {
                this.zmG.yig.setText("");
                if (this.zmG.zmF != null) {
                    this.zmG.zmF.asB();
                }
            }
        });
        this.zgk.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper zmG;

            {
                this.zmG = r1;
            }

            public final void onClick(View view) {
                x.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
                if (this.zmG.zgr != null) {
                    this.zmG.zgr.aWA();
                }
            }
        });
        this.zmE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper zmG;

            {
                this.zmG = r1;
            }

            public final void onClick(View view) {
                if (this.zmG.zmF != null) {
                    this.zmG.zmF.vR(this.zmG.bUS());
                }
            }
        });
    }

    public final void U(CharSequence charSequence) {
        this.yig.setHint(charSequence);
    }

    public final void nr(boolean z) {
        this.yig.setText("");
    }

    public final void cxw() {
        this.yig.clearFocus();
    }

    public final String bUS() {
        Editable editableText = this.yig.getEditableText();
        return editableText == null ? "" : editableText.toString();
    }

    public final void ZR(String str) {
        this.yig.setText("");
        this.yig.append(str);
    }

    public final void setHint(CharSequence charSequence) {
        U(charSequence);
    }

    public final void a(b bVar) {
    }

    public final void no(boolean z) {
    }

    public final void np(boolean z) {
    }

    public final void nq(boolean z) {
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
    }

    public final void a(a aVar) {
        this.zmF = aVar;
    }

    public boolean hasFocus() {
        return false;
    }

    public final boolean cxy() {
        return false;
    }

    public final boolean cxx() {
        return false;
    }

    public final void a(com.tencent.mm.ui.tools.ActionBarSearchView.a aVar) {
        this.zgr = aVar;
    }

    public final void ak(ArrayList<String> arrayList) {
    }

    public final void ns(boolean z) {
    }

    public final void GJ(int i) {
    }

    public final void ZS(String str) {
    }
}
