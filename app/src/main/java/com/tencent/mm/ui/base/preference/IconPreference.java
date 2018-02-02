package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class IconPreference extends Preference {
    private Context context;
    private String desc;
    public Drawable drawable;
    private int height;
    private TextView iXX;
    public ImageView olD;
    private String qhm;
    private int qhn;
    private int qho;
    private View yiA;
    LayoutParams yiB;
    private TextView yiC;
    private TextView yiD;
    private ImageView yiE;
    private boolean yiF;
    public boolean yiG;
    private int yiH;
    public boolean yiI;
    private int yij;
    private int yik;
    private int yil;
    private ImageView yim;
    private ViewGroup yin;
    private TextView yio;
    private int yiq;
    private String yir;
    private int yis;
    private int yit;
    private int yiu;
    private Bitmap yiv;
    public int yiw;
    private int yix;
    private int yiy;
    private View yiz;

    public IconPreference(Context context) {
        this(context, null);
    }

    public IconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qhm = "";
        this.qhn = -1;
        this.qho = 8;
        this.yij = 8;
        this.yiq = 8;
        this.desc = "";
        this.yir = "";
        this.yis = -1;
        this.yit = 8;
        this.yiu = -1;
        this.yiv = null;
        this.yiw = -1;
        this.yix = 8;
        this.yik = 0;
        this.yil = 8;
        this.yiy = 8;
        this.olD = null;
        this.yim = null;
        this.yin = null;
        this.yiz = null;
        this.yiA = null;
        this.height = -1;
        this.yiF = false;
        this.yiG = false;
        this.yiH = -1;
        this.yiI = false;
        this.context = context;
        setLayoutResource(h.dnt);
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.gXG, viewGroup2);
        return onCreateView;
    }

    public final void dh(String str, int i) {
        this.qhm = str;
        this.qhn = i;
    }

    public final void di(String str, int i) {
        ac(str, i, this.yiu);
    }

    public final void YQ(String str) {
        this.desc = str;
        if (this.iXX != null) {
            this.iXX.setText(str);
        }
    }

    public final void ac(String str, int i, int i2) {
        this.yir = str;
        this.yis = i;
        this.yiu = i2;
        if (this.yiC != null) {
            this.yiC.setText(str);
            if (i != -1) {
                this.yiC.setBackgroundDrawable(a.b(this.context, i));
            }
            if (i2 != -1) {
                this.yiC.setTextColor(i2);
            }
        }
    }

    public final void EX(int i) {
        this.qho = i;
        if (this.yiD != null) {
            this.yiD.setVisibility(i);
        }
    }

    public final void EY(int i) {
        this.yit = i;
        if (this.yiC != null) {
            this.yiC.setVisibility(i);
        }
    }

    public final void cqn() {
        this.yiq = 0;
        if (this.iXX != null) {
            this.iXX.setVisibility(0);
        }
    }

    public final void mw(boolean z) {
        this.yiF = z;
        if (this.yiC == null) {
            return;
        }
        if (z) {
            this.yiC.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.gVe, 0);
            this.yiC.setCompoundDrawablePadding((int) this.context.getResources().getDimension(e.bvS));
            return;
        }
        this.yiC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public final void EZ(int i) {
        this.yij = i;
        if (this.yim != null) {
            this.yim.setVisibility(i);
        }
    }

    public final void eW(int i, int i2) {
        this.yij = i;
        this.yiH = i2;
    }

    public final void V(Bitmap bitmap) {
        this.yiv = bitmap;
        this.yiw = -1;
        if (this.olD != null) {
            this.olD.setImageBitmap(bitmap);
        }
    }

    public final void Fa(int i) {
        this.yiw = i;
        this.yiv = null;
        if (this.olD != null) {
            this.olD.setImageResource(i);
        }
    }

    public final void Fb(int i) {
        this.yix = i;
        if (this.olD != null) {
            this.olD.setVisibility(this.yix);
        }
    }

    public final void Fc(int i) {
        this.yik = i;
        if (this.yin != null) {
            this.yin.setVisibility(this.yik);
        }
    }

    public final void Fd(int i) {
        this.yil = i;
        if (this.yiz != null) {
            this.yiz.setVisibility(this.yil);
        }
    }

    public final void eX(int i, int i2) {
        this.yiB = new LayoutParams(i, i2);
        this.yiB.addRule(13);
        if (this.olD != null) {
            this.olD.setLayoutParams(this.yiB);
        }
    }

    public void onBindView(View view) {
        boolean z;
        super.onBindView(view);
        this.yiE = (ImageView) view.findViewById(g.cpk);
        if (this.yiE != null) {
            if (this.drawable != null) {
                this.yiE.setImageDrawable(this.drawable);
                this.yiE.setVisibility(0);
            } else if (this.Kw != 0) {
                ImageView imageView = this.yiE;
                Drawable drawable = this.mContext.getResources().getDrawable(this.Kw);
                this.drawable = drawable;
                imageView.setImageDrawable(drawable);
                this.yiE.setVisibility(0);
            } else {
                this.yiE.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(g.cwo);
        linearLayout.setMinimumHeight((int) (((float) view.getResources().getDimensionPixelSize(e.bvR)) * a.ex(this.context)));
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        this.yiD = (TextView) view.findViewById(g.cQE);
        if (this.yiD != null) {
            if (this.yiG) {
                this.yiD.setCompoundDrawablesWithIntrinsicBounds(f.gVe, 0, 0, 0);
                this.yiD.setCompoundDrawablePadding((int) this.context.getResources().getDimension(e.bvS));
            } else {
                this.yiD.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            this.yiD.setVisibility(this.qho);
            this.yiD.setText(this.qhm);
            if (this.qhn != -1) {
                this.yiD.setBackgroundDrawable(a.b(this.context, this.qhn));
            }
        }
        this.yiC = (TextView) view.findViewById(g.gWy);
        if (this.yiC != null) {
            this.yiC.setVisibility(this.yit);
            this.yiC.setText(this.yir);
            if (this.yis != -1) {
                this.yiC.setBackgroundDrawable(a.b(this.context, this.yis));
            }
            if (this.yiu != -1) {
                this.yiC.setTextColor(this.yiu);
            }
            if (this.yiF) {
                this.yiC.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.gVe, 0);
                this.yiC.setCompoundDrawablePadding((int) this.context.getResources().getDimension(e.bvS));
            } else {
                this.yiC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        this.yim = (ImageView) view.findViewById(g.gWw);
        this.yim.setVisibility(this.yij);
        if (this.yiH != -1) {
            this.yim.setImageResource(this.yiH);
        }
        this.olD = (ImageView) view.findViewById(g.gVC);
        this.yin = (ViewGroup) view.findViewById(g.gWh);
        this.yiA = view.findViewById(g.gWg);
        this.yiA.setVisibility(this.yiy);
        this.yiz = view.findViewById(g.cIe);
        this.yiz.setVisibility(this.yil);
        if (this.yiv != null) {
            this.olD.setImageBitmap(this.yiv);
        } else if (this.yiw != -1) {
            this.olD.setImageResource(this.yiw);
        }
        this.olD.setVisibility(this.yix);
        this.yin.setVisibility(this.yik);
        if (this.yiB != null) {
            this.olD.setLayoutParams(this.yiB);
        }
        this.yio = (TextView) view.findViewById(16908310);
        this.iXX = (TextView) view.findViewById(g.caP);
        if (this.iXX != null) {
            this.iXX.setVisibility(this.yiq);
            this.iXX.setText(this.desc);
            if (this.yiI) {
                this.iXX.setTextColor(this.context.getResources().getColor(d.gUx));
            } else {
                this.iXX.setTextColor(this.context.getResources().getColor(d.bsO));
            }
        }
        if (this.yio != null) {
            if (this.yiI) {
                this.yio.setTextColor(this.context.getResources().getColor(d.gUx));
            } else {
                this.yio.setTextColor(this.context.getResources().getColor(d.btv));
            }
        }
        if (this.yiI) {
            z = false;
        } else {
            z = true;
        }
        view.setEnabled(z);
    }
}
