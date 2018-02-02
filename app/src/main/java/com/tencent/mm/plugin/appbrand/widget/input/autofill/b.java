package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Filter.FilterListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.c.2;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.widget.j;

public final class b {
    final z kaa;
    public final e kab;
    private final FilterListener kac;
    public final c kad;
    final a kae;
    int kaf = f.kaC;
    public a kag;
    private int kah;
    private int kai;

    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] kal = new int[f.anr().length];

        static {
            try {
                kal[f.kaB - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kal[f.kaC - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public b(z zVar) {
        this.kaa = zVar;
        this.kab = new e(zVar.getContext());
        this.kad = new c(zVar, this.kab);
        this.kaa.a(new 1(this));
        this.kaa.a(new 2(this));
        this.kaa.a(new OnFocusChangeListener(this) {
            final /* synthetic */ b kaj;

            {
                this.kaj = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.kaj.anp();
                    return;
                }
                b bVar = this.kaj;
                if (bVar.kab.inJ.isShowing()) {
                    g gVar = (g) bVar.kab.kau.getAdapter();
                    bVar.kab.dismiss();
                    gVar.ann();
                }
            }
        });
        this.kaa.addTextChangedListener(new j(this) {
            final /* synthetic */ b kaj;
            private boolean kak = false;

            {
                this.kaj = r2;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.kak = this.kaj.kab.inJ.isShowing();
            }

            public final void afterTextChanged(Editable editable) {
                if (!this.kak || this.kaj.kab.inJ.isShowing()) {
                    if (!this.kaj.kab.inJ.isShowing()) {
                        this.kaj.anp();
                    }
                    this.kaj.u(editable);
                }
            }
        });
        this.kac = new FilterListener(this) {
            final /* synthetic */ b kaj;

            {
                this.kaj = r1;
            }

            public final void onFilterComplete(int i) {
                if (i <= 0) {
                    this.kaj.kab.dismiss();
                } else if (this.kaj.kab.inJ.isShowing()) {
                    this.kaj.kab.show();
                }
            }
        };
        this.kae = new 6(this);
    }

    final void u(CharSequence charSequence) {
        if (this.kag != null) {
            this.kag.getFilter().filter(charSequence, this.kac);
        }
    }

    final void ano() {
        switch (AnonymousClass7.kal[this.kaf - 1]) {
            case 1:
                this.kab.PV = com.tencent.mm.plugin.appbrand.ui.j.akV()[0];
                break;
            case 2:
                this.kab.PV = this.kaa.getView().getMeasuredWidth();
                break;
        }
        if (this.kah != 0) {
            this.kab.SN = this.kah;
            this.kab.PV -= this.kah;
        }
        if (this.kai != 0) {
            this.kab.PV -= this.kai;
        }
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.kab.inJ.setOnDismissListener(onDismissListener);
    }

    final void anp() {
        if (this.kag != null) {
            CharSequence text = this.kaa.getText();
            if (!bh.M(text)) {
                u(text);
            }
            this.kab.SW = this.kaa.getView();
            this.kab.show();
            ((g) this.kab.kau.getAdapter()).a(this);
            c cVar = this.kad;
            cVar.mi(2);
            cVar.kap = Integer.MIN_VALUE;
            if (!bh.M(text)) {
                cVar.kaq = true;
            }
            ListView listView = cVar.kab.kau;
            if (listView != null) {
                listView.getAdapter().registerDataSetObserver(new 2(cVar));
            }
        }
    }
}
