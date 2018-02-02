package com.tencent.mm.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.w.a.a;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.j;
import com.tencent.mm.w.a.l;
import java.util.List;

public class i extends Dialog implements DialogInterface {
    private CheckBox KR;
    private View jVx;
    private View kK;
    public EditText kT;
    private TextView lVg;
    private Context mContext;
    private Button miR;
    private boolean needEdit = false;
    private ImageView nrq;
    private boolean qoX;
    public Button sVn;
    private LinearLayout xHY;
    private TextView xHZ;
    private TextView xIa;
    private LinearLayout xIb;
    private LinearLayout xIc;
    private TextView xYX;
    private TextView xYY;
    private View xYZ;
    private ViewStub xZa;
    private ViewGroup xZb;
    private ViewGroup xZc;
    private View xZd;
    private boolean xZe = false;
    private Animation xZf;
    private Animation xZg;
    private Animation xZh;
    private Animation xZi;
    private c xZj;
    private int[] xZk = new int[]{g.gWG, g.gWH, g.gWI, g.gWJ, g.gWK, g.gWL, g.gWM, g.gWN, g.gWO};

    static /* synthetic */ void a(i iVar, Animation animation) {
        if (iVar.xIb != null) {
            iVar.xIb.startAnimation(animation);
        }
        if (iVar.xIc != null) {
            iVar.xIc.startAnimation(animation);
        }
        if (iVar.xYY != null && iVar.xZe) {
            iVar.xYY.startAnimation(animation);
        }
        if (iVar.kT == null) {
            return;
        }
        if (iVar.needEdit) {
            iVar.kT.startAnimation(animation);
        } else {
            iVar.kT.setVisibility(8);
        }
    }

    public i(Context context) {
        super(context, l.eYV);
        this.mContext = context;
        this.xHY = (LinearLayout) v.fv(this.mContext).inflate(h.gXo, null);
        this.sVn = (Button) this.xHY.findViewById(g.cwl);
        this.miR = (Button) this.xHY.findViewById(g.cwb);
        this.lVg = (TextView) this.xHY.findViewById(g.gVM);
        this.xHZ = (TextView) this.xHY.findViewById(g.cwf);
        this.xIa = (TextView) this.xHY.findViewById(g.gVL);
        this.xYX = (TextView) this.xHY.findViewById(g.cwj);
        this.xYY = (TextView) this.xHY.findViewById(g.bWQ);
        this.kT = (EditText) this.xHY.findViewById(g.bWU);
        this.KR = (CheckBox) this.xHY.findViewById(g.gVq);
        this.nrq = (ImageView) this.xHY.findViewById(g.cwi);
        this.jVx = this.xHY.findViewById(g.gVN);
        this.xZa = (ViewStub) this.xHY.findViewById(g.gWQ);
        this.xIb = (LinearLayout) this.xHY.findViewById(g.cwg);
        this.xZb = (ViewGroup) this.xHY.findViewById(g.gVI);
        this.xZd = this.xHY.findViewById(g.gVJ);
        this.xIc = (LinearLayout) this.xHY.findViewById(g.gVK);
        this.xZc = (ViewGroup) this.xHY.findViewById(g.gWP);
        setCanceledOnTouchOutside(true);
        this.xZf = AnimationUtils.loadAnimation(ac.getContext(), a.bpO);
        this.xZg = AnimationUtils.loadAnimation(ac.getContext(), a.bpO);
        this.xZh = AnimationUtils.loadAnimation(ac.getContext(), a.bpP);
        this.xZi = AnimationUtils.loadAnimation(ac.getContext(), a.bpP);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.xHY);
    }

    public View getContentView() {
        return this.xHY;
    }

    public void setTitle(CharSequence charSequence) {
        this.jVx.setVisibility(0);
        this.lVg.setVisibility(0);
        if (this.xZj != null) {
            charSequence = this.xZj.a(charSequence.toString(), this.lVg.getTextSize());
        }
        this.lVg.setMaxLines(2);
        this.lVg.setText(charSequence);
        DO(d.gUw);
    }

    public void setTitle(int i) {
        this.jVx.setVisibility(0);
        this.lVg.setVisibility(0);
        this.lVg.setMaxLines(2);
        this.lVg.setText(i);
        DO(d.gUw);
    }

    private void DO(int i) {
        if (this.xHZ != null) {
            this.xHZ.setTextColor(this.xHZ.getContext().getResources().getColor(i));
        }
    }

    public final void setMessage(CharSequence charSequence) {
        this.xIb.setVisibility(0);
        this.xHZ.setVisibility(0);
        if (this.xZj != null) {
            c cVar = this.xZj;
            this.xHZ.getContext();
            charSequence = cVar.a(charSequence.toString(), this.xHZ.getTextSize());
        }
        this.xHZ.setText(charSequence);
    }

    private void mf(boolean z) {
        if (z) {
            int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 8);
            this.xIb.setVisibility(0);
            this.xIb.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            this.xIb.setBackgroundResource(f.gUT);
        }
    }

    public final String coS() {
        return this.kT == null ? null : this.kT.getText().toString();
    }

    private void Ew(int i) {
        if (this.xIb != null) {
            this.xIb.setVisibility(i);
        }
        if (this.xIc != null) {
            this.xIc.setVisibility(i);
        }
        if (this.xYY != null && this.xZe) {
            this.xYY.setVisibility(i);
        }
        if (this.kT == null) {
            return;
        }
        if (this.needEdit) {
            this.kT.setVisibility(i);
        } else {
            this.kT.setVisibility(8);
        }
    }

    private void cY(List<String> list) {
        LinearLayout linearLayout;
        this.xZa.setLayoutResource(h.gXg);
        try {
            linearLayout = (LinearLayout) this.xZa.inflate();
        } catch (Exception e) {
            this.xZa.setVisibility(0);
            linearLayout = null;
        }
        if (list != null) {
            int i = 0;
            for (String str : list) {
                if (i <= 8) {
                    int i2;
                    if (linearLayout != null) {
                        ImageView imageView = (ImageView) linearLayout.findViewById(this.xZk[i]);
                        if (str != null) {
                            imageView.setVisibility(0);
                            com.tencent.mm.ui.e.a.a.a(imageView, str);
                            i2 = i + 1;
                            i = i2;
                        }
                    }
                    i2 = i;
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    private void J(View view, int i) {
        this.kK = view;
        if (this.kK != null) {
            this.xIb.setVisibility(0);
            this.xIc.setVisibility(0);
            this.xIc.removeAllViews();
            this.xIc.setGravity(1);
            this.xIc.addView(this.kK, new LayoutParams(i, i));
        }
    }

    public final void a(CharSequence charSequence, boolean z, OnClickListener onClickListener) {
        if (this.sVn != null) {
            this.sVn.setVisibility(0);
            this.sVn.setText(charSequence);
            this.sVn.setOnClickListener(new 4(this, onClickListener, z));
        }
    }

    public final void Ex(int i) {
        this.sVn.setTextColor(i);
    }

    public final void Ey(int i) {
        this.miR.setTextColor(i);
    }

    public final void a(int i, OnClickListener onClickListener) {
        a(this.mContext.getString(i), true, onClickListener);
    }

    public final void b(CharSequence charSequence, boolean z, OnClickListener onClickListener) {
        if (this.miR != null) {
            this.miR.setVisibility(0);
            this.miR.setText(charSequence);
            this.miR.setOnClickListener(new 5(this, onClickListener, z));
        }
    }

    public final void b(int i, OnClickListener onClickListener) {
        b(this.mContext.getString(i), true, onClickListener);
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.qoX = z;
        setCanceledOnTouchOutside(this.qoX);
    }

    public final void mg(boolean z) {
        super.setCancelable(false);
    }

    public final Button getButton(int i) {
        switch (i) {
            case -2:
                return this.miR;
            case -1:
                return this.sVn;
            default:
                return null;
        }
    }

    public final void a(c cVar) {
        CharSequence charSequence;
        CharSequence charSequence2;
        ImageView imageView;
        TextView textView;
        if (cVar.title != null && cVar.title.length() > 0) {
            setTitle(cVar.title);
        }
        if (cVar.vim != 0) {
            this.lVg.setTextColor(ColorStateList.valueOf(cVar.vim));
        }
        if (cVar.xXi != 0) {
            this.lVg.setMaxLines(cVar.xXi);
        }
        if (cVar.xXj != 0) {
            this.xHZ.setMaxLines(cVar.xXj);
        }
        if (cVar.tyZ != null) {
            J(cVar.tyZ, -1);
        }
        if (cVar.xXh != null) {
            this.xYZ = cVar.xXh;
            if (this.xYZ != null) {
                this.xIb.setVisibility(8);
                this.xYY.setVisibility(8);
                this.kT.setVisibility(8);
                this.xZc.removeAllViews();
                this.xZc.addView(this.xYZ, new LayoutParams(-1, -1));
                this.xZc.setVisibility(8);
            }
        }
        if (cVar.xWU != null) {
            Drawable drawable = cVar.xWU;
            if (this.kK == null) {
                this.xIb.setVisibility(0);
                this.nrq.setVisibility(0);
                this.nrq.setBackgroundDrawable(drawable);
            }
        }
        if (cVar.xWX != null && cVar.xWX.length() > 0) {
            setMessage(cVar.xWX);
        }
        mf(cVar.xXd);
        if (cVar.fvC != null) {
            String str = cVar.fvC;
            int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 120);
            this.xIb.setVisibility(0);
            this.nrq.setVisibility(0);
            if (this.nrq instanceof com.tencent.mm.ui.e.a) {
                ((com.tencent.mm.ui.e.a) this.nrq).V(str, fromDPToPix, fromDPToPix);
            }
            int i = cVar.xXm;
            this.xIb.setVisibility(i);
            this.nrq.setVisibility(i);
        }
        if (!(cVar.xXo || cVar.xXp)) {
            if (cVar.xWX != null && cVar.xWX.length() > 0) {
                setMessage(cVar.xWX);
            }
            if (cVar.xWY == null || cVar.xWY.length() <= 0) {
                mf(false);
            } else {
                charSequence = cVar.xWY;
                this.xIb.setVisibility(0);
                this.xIa.setVisibility(0);
                this.xIa.setMaxLines(2);
                this.xIa.setText(charSequence);
            }
            if (cVar.xWZ != null && cVar.xWZ.length() > 0) {
                charSequence = cVar.xWZ;
                if (charSequence != null) {
                    this.xIb.setVisibility(0);
                    this.xYX.setVisibility(0);
                    if (this.xZj != null) {
                        c cVar2 = this.xZj;
                        this.xYX.getContext();
                        charSequence = cVar2.a(charSequence.toString(), this.xYX.getTextSize());
                    }
                    this.xYX.setText(charSequence);
                }
            }
            if (cVar.xWV != null) {
                Bitmap bitmap = cVar.xWV;
                if (this.kK == null) {
                    this.xIb.setVisibility(0);
                    this.nrq.setVisibility(0);
                    this.nrq.setImageBitmap(bitmap);
                }
            }
        }
        Bitmap bitmap2;
        CharSequence charSequence3;
        View inflate;
        if (cVar.xXo) {
            bitmap2 = cVar.xWV;
            charSequence2 = cVar.xWY;
            charSequence3 = cVar.xWZ;
            inflate = v.fv(this.mContext).inflate(h.gXc, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(g.cwi);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(g.gVL);
                textView.setVisibility(0);
                if (this.xZj != null) {
                    charSequence2 = this.xZj.a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(g.cwj);
                textView.setVisibility(0);
                if (this.xZj != null) {
                    charSequence2 = this.xZj.a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            J(inflate, -1);
        } else if (cVar.xXp) {
            bitmap2 = cVar.xWV;
            charSequence2 = cVar.xWY;
            charSequence3 = cVar.xWZ;
            inflate = v.fv(this.mContext).inflate(h.gXd, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(g.cwi);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(g.gVL);
                textView.setVisibility(0);
                if (this.xZj != null) {
                    charSequence2 = this.xZj.a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(g.cwj);
                textView.setVisibility(0);
                if (this.xZj != null) {
                    charSequence2 = this.xZj.a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            J(inflate, -1);
        }
        if (!(cVar.xWM == null && cVar.xWO == null)) {
            String str2 = cVar.xWM;
            charSequence2 = cVar.xWO;
            Boolean valueOf = Boolean.valueOf(cVar.xWP);
            b bVar = cVar.xWR;
            this.xZa.setLayoutResource(h.gXf);
            LinearLayout linearLayout = null;
            try {
                linearLayout = (LinearLayout) this.xZa.inflate();
            } catch (Exception e) {
                this.xZa.setVisibility(0);
            }
            if (!(linearLayout == null || str2 == null)) {
                imageView = (ImageView) linearLayout.findViewById(g.gWF);
                imageView.setVisibility(0);
                com.tencent.mm.ui.e.a.a.a(imageView, str2);
            }
            if (!(linearLayout == null || charSequence2 == null)) {
                textView = (TextView) linearLayout.findViewById(g.gWR);
                textView.setVisibility(0);
                if (this.xZj != null) {
                    charSequence2 = this.xZj.a(charSequence2.toString(), this.lVg.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (valueOf.booleanValue() && linearLayout != null) {
                imageView = (ImageView) linearLayout.findViewById(g.gVE);
                imageView.setVisibility(0);
                Ew(0);
                linearLayout.setOnClickListener(new 1(this, bVar, imageView));
            }
        }
        if (cVar.xWS != null) {
            i$a$a com_tencent_mm_ui_base_i_a_a = cVar.xWS;
            if (this.xIb != null && this.xIb.getVisibility() == 0) {
                this.xIb.setOnClickListener(new 2(this, com_tencent_mm_ui_base_i_a_a));
            } else if (this.xIc != null) {
                this.xIc.setOnClickListener(new 3(this, com_tencent_mm_ui_base_i_a_a));
            }
        }
        if (cVar.xWN != null) {
            cY(cVar.xWN);
        }
        if (!(cVar.xWW == null || cVar.xWW.isRecycled())) {
            Bitmap bitmap3 = cVar.xWW;
            boolean z = cVar.xXe;
            int i2 = cVar.xXl;
            if (bitmap3 != null) {
                Bitmap bitmap4;
                mf(false);
                this.xIb.setVisibility(0);
                this.xIb.setGravity(1);
                this.xIb.setPadding(0, 0, 0, 0);
                View inflate2 = View.inflate(this.mContext, h.gXe, null);
                imageView = (ImageView) inflate2.findViewById(g.cwi);
                if (z) {
                    int i3;
                    int i4;
                    bitmap4 = null;
                    float height = ((float) bitmap3.getHeight()) / ((float) bitmap3.getWidth());
                    int ab = com.tencent.mm.bv.a.ab(this.mContext, e.gUL);
                    int ab2 = com.tencent.mm.bv.a.ab(this.mContext, e.gUK);
                    if (height > 0.0f && ((double) height) < 0.5d) {
                        i3 = (int) (((float) ab) / height);
                        i4 = ab;
                    } else if (((double) height) >= 0.5d && height < 1.0f) {
                        ab = (int) (((float) ab2) * height);
                        i3 = ab2;
                        i4 = ab;
                    } else if (height >= 1.0f && height < 2.0f) {
                        ab = (int) (((float) ab2) / height);
                        i3 = ab;
                        i4 = ab2;
                        r18 = ab2;
                        ab2 = ab;
                        ab = r18;
                    } else if (height >= 2.0f) {
                        i4 = (int) (((float) ab) * height);
                        i3 = ab;
                        r18 = ab;
                        ab = ab2;
                        ab2 = r18;
                    } else {
                        ab = 0;
                        ab2 = 0;
                        i3 = 0;
                        i4 = 0;
                    }
                    if (i4 > 0 && i3 > 0 && bitmap3 != null) {
                        bitmap4 = Bitmap.createScaledBitmap(bitmap3, i3, i4, true);
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(ab2, ab));
                    }
                    bitmap4 = com.tencent.mm.sdk.platformtools.d.a(bitmap4, true, (float) com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 3));
                } else {
                    bitmap4 = bitmap3;
                }
                imageView.setImageBitmap(bitmap4);
                imageView = (ImageView) inflate2.findViewById(g.gVD);
                if (i2 == 0) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                    if (i2 == 1) {
                        imageView.setImageResource(j.gYn);
                    } else if (i2 == 2) {
                        imageView.setImageResource(j.dvB);
                    }
                }
                J(inflate2, -2);
            }
        }
        if (cVar.xWI != null && cVar.xWI.length() > 0) {
            charSequence = cVar.xWI;
            if (charSequence != null) {
                this.xYY.setVisibility(0);
                this.xYY.setText(charSequence);
            }
            this.xZe = true;
            i = cVar.xXk;
            if (this.xYY != null) {
                this.xYY.setGravity(i);
            }
        }
        if (cVar.xWJ != null && cVar.xWJ.length() > 0) {
            charSequence = cVar.xWJ;
            this.kT.setVisibility(0);
            this.kT.setHint(charSequence);
        }
        if (cVar.xWK != null && cVar.xWK.length() > 0) {
            charSequence = cVar.xWK;
            this.KR.setVisibility(0);
            this.KR.setText(charSequence);
        }
        if (cVar.xWL) {
            this.needEdit = cVar.xWL;
            if (cVar.xWL) {
                this.kT.setVisibility(0);
            } else {
                this.kT.setVisibility(8);
            }
        }
        if (cVar.xXa != null && cVar.xXa.length() > 0) {
            a(cVar.xXa, cVar.xXn, cVar.xXf);
        }
        if (cVar.xXb != null && cVar.xXb.length() > 0) {
            b(cVar.xXb, true, cVar.xXg);
        }
        if (cVar.Gj != null) {
            setOnCancelListener(cVar.Gj);
        }
        if (cVar.Gk != null) {
            setOnDismissListener(cVar.Gk);
        }
        if (cVar.xWT != null) {
            this.xZj = cVar.xWT;
        }
        setCancelable(cVar.qoX);
        this.qoX = cVar.qoX;
        if (!this.qoX) {
            super.setCancelable(cVar.xXc);
        }
        if (cVar.xWQ) {
            View inflate3 = v.fv(getContext()).inflate(h.gXb, null);
            this.miR = (Button) inflate3.findViewById(g.cwb);
            this.sVn = (Button) inflate3.findViewById(g.cwl);
            if (cVar.xXa != null && cVar.xXa.length() > 0) {
                a(cVar.xXa, cVar.xXn, cVar.xXf);
            }
            if (cVar.xXb != null && cVar.xXb.length() > 0) {
                b(cVar.xXb, true, cVar.xXg);
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.xZd.setVisibility(8);
            this.xZb.removeAllViews();
            this.xZb.addView(inflate3, layoutParams);
        }
    }

    public void show() {
        try {
            super.show();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMAlertDialog", e, "", new Object[0]);
        }
    }

    public void dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ag.y(new 6(this));
            x.e("MicroMsg.MMAlertDialog", bh.cgy().toString());
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
