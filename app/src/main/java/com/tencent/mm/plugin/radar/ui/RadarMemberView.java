package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b;
import b.e.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.radar.a;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.s;

public final class RadarMemberView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] pxT = new d[]{b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "avatarHolder", "getAvatarHolder()Landroid/view/View;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "avatarCopy", "getAvatarCopy()Landroid/widget/ImageView;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "avatarCopyContainer", "getAvatarCopyContainer()Landroid/view/View;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "confirmBtn", "getConfirmBtn()Landroid/widget/Button;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "confirmBtnDisabled", "getConfirmBtnDisabled()Landroid/widget/TextView;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "memberNameTv", "getMemberNameTv()Landroid/widget/TextView;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "modifyNameBtn", "getModifyNameBtn()Landroid/widget/Button;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "sayHiTv", "getSayHiTv()Landroid/widget/TextView;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "exposeTv", "getExposeTv()Landroid/widget/TextView;"))};
    private static final int pyn = 0;
    private static final int pyo = 1;
    public static final a pyp = new a((byte) 0);
    private x jLe;
    private TextView mPU;
    private EditText pqM;
    private View pxU;
    private final b pxV = i.C(this, c.pvK);
    private final b pxW = i.C(this, c.pvx);
    private final b pxX = i.C(this, c.pvw);
    private final b pxY = i.C(this, c.pvz);
    private final b pxZ = i.C(this, c.pvA);
    bao pxx;
    e pxy;
    private final b pya = i.C(this, c.pvE);
    private final b pyb = i.C(this, c.pvD);
    private final b pyc = i.C(this, c.pvQ);
    private int[] pyd;
    private final b pye = i.C(this, c.pvv);
    private boolean pyf;
    private bf pyg;
    b pyh;
    private final OnClickListener pyi = new h(this);
    private final d pyj = new d(this);
    private com.tencent.mm.ui.base.i pyk;
    private View pyl;
    private TextView pym;

    public static final class i implements AnimationListener {
        final /* synthetic */ RadarMemberView pyq;

        i(RadarMemberView radarMemberView) {
            this.pyq = radarMemberView;
        }

        public final void onAnimationStart(Animation animation) {
            b.c.b.e.i(animation, "animation");
        }

        public final void onAnimationRepeat(Animation animation) {
            b.c.b.e.i(animation, "animation");
        }

        public final void onAnimationEnd(Animation animation) {
            b.c.b.e.i(animation, "animation");
            a aVar = RadarMemberView.pyp;
            com.tencent.mm.sdk.platformtools.x.d(RadarMemberView.TAG, "popup animation end");
            d d = this.pyq.pyj;
            a aVar2 = RadarMemberView.pyp;
            d.sendEmptyMessage(RadarMemberView.pyn);
        }
    }

    public static final class j implements TextWatcher {
        final /* synthetic */ RadarMemberView pyq;

        j(RadarMemberView radarMemberView) {
            this.pyq = radarMemberView;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            b.c.b.e.i(charSequence, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            b.c.b.e.i(charSequence, "s");
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = false;
            b.c.b.e.i(editable, "s");
            int length = 50 - editable.length();
            if (length < 0) {
                length = 0;
            }
            TextView f = this.pyq.pym;
            if (f != null) {
                f.setText(String.valueOf(length));
            }
            com.tencent.mm.ui.base.i g = this.pyq.pyk;
            if (g != null) {
                Button button = g.getButton(-1);
                if (button != null) {
                    if (editable.length() > 0) {
                        z = true;
                    }
                    button.setEnabled(z);
                }
            }
        }
    }

    static final class l implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarMemberView pyq;

        l(RadarMemberView radarMemberView) {
            this.pyq = radarMemberView;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            com.tencent.mm.ui.base.i g = this.pyq.pyk;
            if (g != null) {
                g.dismiss();
            }
            this.pyq.pyk = null;
        }
    }

    private final View blA() {
        return (View) this.pxX.getValue();
    }

    private final Button blB() {
        return (Button) this.pxY.getValue();
    }

    private final TextView blC() {
        return (TextView) this.pxZ.getValue();
    }

    private final TextView blD() {
        return (TextView) this.pya.getValue();
    }

    private final Button blE() {
        return (Button) this.pyb.getValue();
    }

    private final TextView blF() {
        return (TextView) this.pyc.getValue();
    }

    private final TextView blG() {
        return (TextView) this.pye.getValue();
    }

    private final View blz() {
        return (View) this.pxV.getValue();
    }

    public static final /* synthetic */ void a(RadarMemberView radarMemberView, String str) {
        radarMemberView.pyl = View.inflate(radarMemberView.getContext(), a.d.drP, null);
        View view = radarMemberView.pyl;
        radarMemberView.mPU = view != null ? (TextView) view.findViewById(c.cLB) : null;
        TextView textView = radarMemberView.mPU;
        if (textView != null) {
            textView.setText("");
        }
        view = radarMemberView.pyl;
        radarMemberView.pqM = view != null ? (EditText) view.findViewById(c.cLA) : null;
        view = radarMemberView.pyl;
        radarMemberView.pym = view != null ? (TextView) view.findViewById(c.cZH) : null;
        TextView textView2 = radarMemberView.pym;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        EditText editText = radarMemberView.pqM;
        if (editText != null) {
            editText.setText(str);
        }
        TextView textView3 = radarMemberView.pym;
        if (textView3 != null) {
            textView3.setText("50");
        }
        editText = radarMemberView.pqM;
        if (editText != null) {
            editText.setFilters(h.vxH);
        }
        EditText editText2 = radarMemberView.pqM;
        if (editText2 != null) {
            editText2.addTextChangedListener(new j(radarMemberView));
        }
        radarMemberView.pyk = com.tencent.mm.ui.base.h.a(radarMemberView.getContext(), radarMemberView.getContext().getString(f.pwl), radarMemberView.pyl, new m(radarMemberView), new l(radarMemberView));
        editText2 = radarMemberView.pqM;
        if (editText2 != null) {
            editText2.post(new k(radarMemberView));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ boolean i(RadarMemberView radarMemberView) {
        String str = null;
        Object obj = null;
        if (radarMemberView.pqM == null) {
            return false;
        }
        String str2;
        x xVar;
        Object h;
        TextView blD;
        EditText editText = radarMemberView.pqM;
        CharSequence valueOf = String.valueOf(editText != null ? editText.getText() : null);
        int length = valueOf.length() - 1;
        Object obj2 = null;
        int i = 0;
        while (i <= length) {
            Object obj3 = valueOf.charAt(obj2 == null ? i : length) <= ' ' ? 1 : null;
            if (obj2 != null) {
                if (obj3 == null) {
                    break;
                }
                length--;
            } else if (obj3 == null) {
                obj2 = 1;
            } else {
                i++;
            }
        }
        String obj4 = valueOf.subSequence(i, length + 1).toString();
        bao com_tencent_mm_protocal_c_bao = radarMemberView.pxx;
        if (com_tencent_mm_protocal_c_bao != null) {
            g gVar = g.pzC;
            String b = g.b(com_tencent_mm_protocal_c_bao);
            if (b != null) {
                str2 = b;
                if (bh.ov(str2)) {
                    return false;
                }
                xVar = radarMemberView.jLe;
                if (xVar == null && xVar.AC()) {
                    bf EZ;
                    h = g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
                    b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                    com.tencent.mm.plugin.messenger.foundation.a.a.g EZ2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).EZ();
                    xVar = radarMemberView.jLe;
                    bf EZ3 = EZ2.EZ(xVar != null ? xVar.getUsername() : null);
                    if (EZ3 != null) {
                        valueOf = EZ3.vS();
                        h = (valueOf == null || b.f.a.X(valueOf)) ? 1 : null;
                    }
                    xVar = radarMemberView.jLe;
                    valueOf = xVar != null ? xVar.vS() : null;
                    h = (valueOf == null || b.f.a.X(valueOf)) ? 1 : null;
                    if (h == null) {
                        h = g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
                        b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                        com.tencent.mm.plugin.messenger.foundation.a.a.g EZ4 = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).EZ();
                        x xVar2 = radarMemberView.jLe;
                        if (xVar2 != null) {
                            str = xVar2.vS();
                        }
                        EZ = EZ4.EZ(str);
                        if (EZ != null) {
                            valueOf = EZ.vS();
                            if (valueOf == null || b.f.a.X(valueOf)) {
                                obj = 1;
                            }
                            if (obj == null) {
                                h = g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
                                b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) h).EZ().Fa(EZ.vS());
                            }
                        }
                        xVar = radarMemberView.jLe;
                        if (xVar != null) {
                            xVar.da(obj4);
                        }
                        s.b(radarMemberView.jLe, obj4);
                    }
                    EZ = EZ3;
                    if (EZ != null) {
                        valueOf = EZ.vS();
                        obj = 1;
                        if (obj == null) {
                            h = g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
                            b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                            ((com.tencent.mm.plugin.messenger.foundation.a.h) h).EZ().Fa(EZ.vS());
                        }
                    }
                    xVar = radarMemberView.jLe;
                    if (xVar != null) {
                        xVar.da(obj4);
                    }
                    s.b(radarMemberView.jLe, obj4);
                } else {
                    xVar = radarMemberView.jLe;
                    if (xVar != null) {
                        xVar.da(obj4);
                    }
                    h = g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
                    b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) h).EZ().a(new bf(str2, obj4));
                }
                blD = radarMemberView.blD();
                if (blD != null) {
                    blD.setText(obj4);
                }
                return true;
            }
        }
        str2 = "";
        if (bh.ov(str2)) {
            return false;
        }
        xVar = radarMemberView.jLe;
        if (xVar == null) {
        }
        xVar = radarMemberView.jLe;
        if (xVar != null) {
            xVar.da(obj4);
        }
        h = g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
        b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h).EZ().a(new bf(str2, obj4));
        blD = radarMemberView.blD();
        if (blD != null) {
            blD.setText(obj4);
        }
        return true;
    }

    public final boolean isShowing() {
        return getVisibility() == 0;
    }

    public RadarMemberView(Context context, AttributeSet attributeSet) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarMemberView(Context context, AttributeSet attributeSet, int i) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    public final void c(String str, e eVar) {
        Object obj = null;
        b.c.b.e.i(str, "username");
        b.c.b.e.i(eVar, "state");
        if (isShowing() && !this.pyf) {
            Object obj2;
            bao com_tencent_mm_protocal_c_bao = this.pxx;
            if (com_tencent_mm_protocal_c_bao != null) {
                obj2 = com_tencent_mm_protocal_c_bao.wcv;
            } else {
                obj2 = null;
            }
            if (!b.c.b.e.h((Object) str, obj2)) {
                com_tencent_mm_protocal_c_bao = this.pxx;
                if (com_tencent_mm_protocal_c_bao != null) {
                    obj = com_tencent_mm_protocal_c_bao.ksU;
                }
                if (!b.c.b.e.h((Object) str, obj)) {
                    return;
                }
            }
            a(eVar);
        }
    }

    private final void a(e eVar) {
        blG().setVisibility(0);
        if (eVar != null) {
            switch (c.pxK[eVar.ordinal()]) {
                case 1:
                    blD().setVisibility(0);
                    blE().setVisibility(0);
                    blB().setText(f.pwo);
                    blB().setVisibility(0);
                    blC().setVisibility(8);
                    blF().setVisibility(8);
                    return;
                case 2:
                    blD().setVisibility(0);
                    blE().setVisibility(0);
                    blC().setText(f.pwr);
                    blB().setVisibility(8);
                    blC().setVisibility(0);
                    blF().setVisibility(8);
                    return;
                case 3:
                    blD().setVisibility(0);
                    blE().setVisibility(0);
                    blC().setText(f.pwi);
                    blB().setVisibility(8);
                    blC().setVisibility(0);
                    blF().setVisibility(8);
                    return;
                case 4:
                    blD().setVisibility(0);
                    blE().setVisibility(0);
                    blB().setText(f.pwh);
                    blB().setVisibility(0);
                    blC().setVisibility(8);
                    blF().setText(getContext().getString(f.pvQ));
                    blF().setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(View view, bao com_tencent_mm_protocal_c_bao, e eVar) {
        Object h;
        String vO;
        b.c.b.e.i(view, "view");
        b.c.b.e.i(com_tencent_mm_protocal_c_bao, "member");
        com.tencent.mm.sdk.platformtools.x.d(TAG, "popup");
        this.pxy = eVar;
        this.pxx = com_tencent_mm_protocal_c_bao;
        Button blB = blB();
        if (blB != null) {
            blB.setOnClickListener(new e(this, com_tencent_mm_protocal_c_bao));
        }
        blE().setOnClickListener(this.pyi);
        setOnTouchListener(new f(this));
        blG().setOnClickListener(new g(this));
        g gVar = g.pzC;
        String b = g.b(com_tencent_mm_protocal_c_bao);
        if (!b.f.a.X(b)) {
            h = g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
            b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
            this.jLe = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).EY().WO(b);
        }
        x xVar = this.jLe;
        if (xVar == null || !xVar.AC()) {
            h = g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
            b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
            this.pyg = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).EZ().EZ(b);
            bf bfVar = this.pyg;
            vO = bfVar != null ? bfVar.vO() : null;
        } else {
            xVar = this.jLe;
            vO = xVar != null ? xVar.vO() : null;
        }
        TextView blD = blD();
        CharSequence b2 = (this.jLe == null || bh.ov(vO)) ? com.tencent.mm.pluginsdk.ui.d.i.b(getContext(), com_tencent_mm_protocal_c_bao.kub, blD().getTextSize()) : com.tencent.mm.pluginsdk.ui.d.i.b(getContext(), vO, blD().getTextSize());
        blD.setText(b2);
        blD().setVisibility(4);
        blE().setVisibility(4);
        reset();
        this.pxU = view;
        View view2 = this.pxU;
        if (view2 == null) {
            b.c.b.e.cJy();
        }
        h = view2.findViewById(c.pvM);
        b.c.b.e.h(h, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
        ImageView imageView = (ImageView) h;
        View view3 = this.pxU;
        if (view3 == null) {
            b.c.b.e.cJy();
        }
        Object findViewById = view3.findViewById(c.pvw);
        b.c.b.e.h(findViewById, "avatarItem!!.findViewByI…d.radar_avatar_container)");
        view3 = this.pxU;
        if (view3 == null) {
            b.c.b.e.cJy();
        }
        view3.setVisibility(4);
        ((ImageView) this.pxW.getValue()).setImageDrawable(imageView.getDrawable());
        blA().setVisibility(0);
        int[] iArr = new int[2];
        findViewById.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        blz().getLocationInWindow(iArr2);
        this.pyd = iArr2;
        setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        animationSet.setDuration(500);
        float height = ((float) blz().getHeight()) / ((float) findViewById.getHeight());
        TranslateAnimation translateAnimation = new TranslateAnimation((float) iArr[0], ((float) iArr2[0]) - (((float) ((findViewById.getWidth() - findViewById.getHeight()) / 2)) * height), (float) iArr[1], (float) iArr2[1]);
        animationSet.addAnimation(new ScaleAnimation(1.0f, height, 1.0f, height));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new i(this));
        blA().startAnimation(animationSet);
    }

    public final void dismiss() {
        com.tencent.mm.sdk.platformtools.x.d(TAG, "dismiss");
        if (!this.pyf) {
            this.pyf = true;
            View view = this.pxU;
            if (view == null) {
                b.c.b.e.cJy();
            }
            Object findViewById = view.findViewById(c.pvw);
            b.c.b.e.h(findViewById, "avatarItem!!.findViewByI…d.radar_avatar_container)");
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setFillAfter(true);
            animationSet.setRepeatCount(1);
            animationSet.setDuration(500);
            int[] iArr = this.pyd;
            int[] iArr2 = new int[2];
            findViewById.getLocationInWindow(iArr2);
            float height = ((float) blz().getHeight()) / ((float) findViewById.getHeight());
            float width = ((float) ((findViewById.getWidth() - findViewById.getHeight()) / 2)) * height;
            if (iArr == null) {
                b.c.b.e.cJy();
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(((float) iArr[0]) - width, (float) iArr2[0], (float) iArr[1], (float) iArr2[1]);
            animationSet.addAnimation(new ScaleAnimation(height, 1.0f, height, 1.0f));
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new c(this));
            blD().setVisibility(4);
            blE().setVisibility(4);
            blB().setVisibility(8);
            blC().setVisibility(8);
            blF().setVisibility(8);
            blG().setVisibility(8);
            blA().startAnimation(animationSet);
        }
    }

    private final void reset() {
        blA().setVisibility(8);
        blD().setVisibility(4);
        blE().setVisibility(4);
        blB().setVisibility(8);
        blC().setVisibility(8);
        blF().setVisibility(8);
        blG().setVisibility(8);
    }
}
