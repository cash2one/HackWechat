package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n extends k implements e, Serializable {
    private View rjA;
    Button rjB;
    SnsTextProgressBar rjC;
    a rjD = new a(this, "apkStateMachine");
    b rjE;
    private OnClickListener rjF = new 1(this);
    a rjG = new 2(this);

    public n(Context context, b bVar, ViewGroup viewGroup) {
        super(context, bVar, viewGroup);
    }

    protected final void bxa() {
        Map hashMap = new HashMap();
        hashMap.put("fontNormalColor", eh(((b) this.rji).rfQ, "#FFFFFF"));
        hashMap.put("fontDisableColor", eh(((b) this.rji).rfR, "#4CFFFFFF"));
        hashMap.put("fontPressedColor", eh(((b) this.rji).rfS, "#99FFFFFF"));
        hashMap.put("NormalColor", eh(((b) this.rji).rfK, "#1AAD19"));
        hashMap.put("PressedColor", eh(((b) this.rji).rfM, "#179B16"));
        hashMap.put("DisableColor", eh(((b) this.rji).rfL, "#661AAD19"));
        hashMap.put("borderNormalColor", eh(((b) this.rji).rfN, "#179E16"));
        hashMap.put("borderPressedColor", eh(((b) this.rji).rfP, "#158E14"));
        hashMap.put("borderDisableColor", eh(((b) this.rji).rfO, "#00179E16"));
        int parseColor = Color.parseColor((String) hashMap.get("fontNormalColor"));
        int parseColor2 = Color.parseColor((String) hashMap.get("fontDisableColor"));
        int parseColor3 = Color.parseColor((String) hashMap.get("fontPressedColor"));
        int parseColor4 = Color.parseColor((String) hashMap.get("NormalColor"));
        int parseColor5 = Color.parseColor((String) hashMap.get("PressedColor"));
        int parseColor6 = Color.parseColor((String) hashMap.get("DisableColor"));
        int i = (int) ((b) this.rji).rgj;
        int parseColor7 = Color.parseColor((String) hashMap.get("borderNormalColor"));
        int parseColor8 = Color.parseColor((String) hashMap.get("borderPressedColor"));
        int parseColor9 = Color.parseColor((String) hashMap.get("borderDisableColor"));
        int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(d.qyI);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable.setColor(parseColor6);
        gradientDrawable.setStroke(i, parseColor9);
        Drawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable2.setColor(parseColor5);
        gradientDrawable2.setStroke(i, parseColor8);
        Drawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable3.setColor(parseColor4);
        gradientDrawable3.setStroke(i, parseColor7);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{16842910}, gradientDrawable3);
        this.rjB.setBackground(stateListDrawable);
        int[] iArr = new int[]{parseColor2, parseColor3, parseColor};
        r2 = new int[3][];
        r2[0] = new int[]{-16842910};
        r2[1] = new int[]{16842919};
        r2[2] = new int[]{16842910};
        this.rjB.setTextColor(new ColorStateList(r2, iArr));
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable4.setColor(parseColor5);
        gradientDrawable4.setStroke(i, parseColor8);
        Drawable gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setShape(0);
        gradientDrawable5.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable5.setColor(parseColor4);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable5, 3, 1);
        gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setShape(0);
        gradientDrawable5.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable5.setColor(parseColor4);
        ClipDrawable clipDrawable2 = new ClipDrawable(gradientDrawable5, 3, 1);
        gradientDrawable5 = new LayerDrawable(new Drawable[]{gradientDrawable4, clipDrawable, clipDrawable2});
        gradientDrawable5.setId(0, 16908288);
        gradientDrawable5.setId(1, 16908303);
        gradientDrawable5.setId(2, 16908301);
        this.rjC.setProgressDrawable(gradientDrawable5);
        this.rjC.rRQ = ((b) this.rji).rfS;
        if (((b) this.rji).height > 0.0f) {
            LayoutParams layoutParams = (LayoutParams) this.rjA.getLayoutParams();
            layoutParams.height = (int) ((b) this.rji).height;
            this.rjA.setLayoutParams(layoutParams);
        }
        this.rjB.setText(((b) this.rji).title);
        this.rjD.Dh(11);
    }

    @TargetApi(17)
    public final View bwW() {
        this.riW = 0;
        View view = this.contentView;
        this.rjA = view.findViewById(f.qBZ);
        this.rjB = (Button) view.findViewById(f.ccw);
        this.rjB.setOnClickListener(this.rjF);
        this.rjC = (SnsTextProgressBar) view.findViewById(f.qBY);
        this.rjC.setProgress(0);
        this.rjC.setVisibility(8);
        this.rjC.setOnClickListener(this.rjF);
        this.rjD.start();
        return view;
    }

    protected final int bjK() {
        return g.qGI;
    }

    public final void bwH() {
        super.bwH();
        this.rjD.Dh(2);
    }

    public final void bwG() {
        super.bwG();
        if (this.rjE != null) {
            this.context.unregisterReceiver(this.rjE);
            this.rjE = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    public final boolean bxn() {
        if (this.context == null || TextUtils.isEmpty(((b) this.rji).fFm) || TextUtils.isEmpty(((b) this.rji).uC)) {
            return false;
        }
        if (TextUtils.isEmpty(((b) this.rji).rfT)) {
            com.tencent.mm.bz.a.post(new 4(this));
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((b) this.rji).rfT));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            List y = bh.y(this.context, intent);
            if (!(y == null || y.isEmpty())) {
                Object b;
                if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                    b = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo) y.get(0));
                } else {
                    b = intent.getPackage();
                }
                if (!bh.ou(ac.getPackageName()).equals(b)) {
                    com.tencent.mm.bz.a.post(new 3(this, intent));
                }
            }
        }
        AdLandingPagesProxy.getInstance().reportDownloadInfo(9, ((b) this.rji).fFm, ((b) this.rji).uC, ((b) this.rji).fqR, ((b) this.rji).downloadUrl);
        return true;
    }

    public final void bxo() {
        x.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
        AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((b) this.rji).uC, ((b) this.rji).rfT);
    }

    private static String eh(String str, String str2) {
        return (!bh.ov(str) && str.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?")) ? str : str2;
    }
}
