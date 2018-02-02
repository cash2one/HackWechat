package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.v;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class SnsHeader extends LinearLayout {
    Context context;
    boolean fuf = false;
    String gze;
    private Dialog mZK;
    b rBF;
    a rBG;
    private boolean rBH = false;
    private Map<Integer, View> rBI = new HashMap();
    private String rBJ = "";
    Bitmap rBK = null;
    int type;
    String userName;

    static /* synthetic */ boolean a(SnsHeader snsHeader, long j) {
        if (snsHeader.rBG != null) {
            snsHeader.rBG.eV(j);
        }
        return true;
    }

    public SnsHeader(Context context) {
        super(context);
        init(context);
    }

    public SnsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        View inflate = v.fv(context).inflate(g.qHr, this, true);
        this.rBF = new b(this);
        this.rBF.ksb = (TextView) inflate.findViewById(f.cAn);
        this.rBF.ihQ = (ImageView) inflate.findViewById(f.bLL);
        this.rBF.rqT = (TextView) inflate.findViewById(f.qDv);
        this.rBF.rBP = (ImageView) inflate.findViewById(f.qEc);
        this.rBF.rBQ = (LinearLayout) inflate.findViewById(f.qDt);
        this.rBF.rBR = (LinearLayout) inflate.findViewById(f.qEt);
        this.rBF.rBP.setContentDescription(context.getString(j.qKk));
        this.rBF.rBP.setOnClickListener(new 1(this, context));
        this.rBF.ihQ.setOnClickListener(new 2(this, context));
    }

    public final void bAT() {
        Bitmap a;
        String str = this.userName;
        if (this.type == 1) {
            str = this.gze;
        }
        String accSnsPath = ae.getAccSnsPath();
        x.d("MicroMsg.SnsHeader", "MagicAsyncTask " + str);
        k Lq = ae.bvz().Lq(str);
        String str2 = Lq.field_bgId;
        x.d("MicroMsg.SnsHeader", "showName " + str + " get bgId : " + str2 + "  olderBgId：　" + Lq.field_older_bgId);
        String JF = i.JF(str2);
        String str3 = str + "bg_";
        String str4 = str + "tbg_";
        String r = am.r(accSnsPath, str);
        FileOp.mh(r);
        if ((Lq.field_local_flag & 1) > 0) {
            x.d("MicroMsg.SnsHeader", "bg is change");
            ae.bvz().Lp(str);
            if (FileOp.bO(am.r(accSnsPath, str) + str3)) {
                FileOp.deleteFile(am.r(accSnsPath, str) + str4);
                FileOp.g(am.r(accSnsPath, str), str3, str4);
            }
            Lq.field_local_flag &= -2;
            ae.bvz().c(Lq);
        }
        if (FileOp.bO(am.r(ae.getAccSnsPath(), str2) + JF) && !FileOp.bO(am.r(accSnsPath, str) + str3)) {
            FileOp.x(am.r(accSnsPath, str2) + JF, am.r(accSnsPath, str) + str3);
            x.d("MicroMsg.SnsHeader", "nwer id Name update");
        }
        accSnsPath = Lq.field_bgUrl;
        if (str2 != null) {
            ae.bvs();
            String str5 = r + str3;
            this.context.hashCode();
            a = com.tencent.mm.plugin.sns.model.g.a(str5, accSnsPath, str2, true, an.xyY);
            x.d("MicroMsg.SnsHeader", "set a new bg");
            if (a == null) {
                FileOp.deleteFile(r + str3);
            }
        } else {
            a = null;
        }
        if (a == null && str2 != null) {
            ae.bvs();
            str5 = r + str4;
            this.context.hashCode();
            a = com.tencent.mm.plugin.sns.model.g.a(str5, accSnsPath, str2, false, an.xyY);
        }
        if (this.rBF.rBP != null) {
            this.rBF.rBP.setImageBitmap(a);
            if (a != null) {
                this.rBF.rBP.setBackgroundDrawable(null);
            } else {
                try {
                    if (this.rBK == null || this.rBK.isRecycled()) {
                        x.i("MicroMsg.SnsHeader", "decode bitmap by self");
                        this.rBK = d.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
                    }
                    this.rBF.rBP.setBackgroundDrawable(new BitmapDrawable(this.rBK));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsHeader", e, "", new Object[0]);
                }
            }
        }
        this.rBF.rBQ.setVisibility(8);
        if (a == null && (this.type == 1 || this.gze.equals(str))) {
            this.rBF.rBQ.setVisibility(0);
        }
        this.rBH = Lq.byf();
    }

    public final boolean bAU() {
        if (this.rBF.rBR == null) {
            return false;
        }
        int i;
        List bvP = ai.bvP();
        List linkedList = new LinkedList();
        for (i = 0; i < bvP.size(); i++) {
            m mVar = (m) bvP.get(i);
            try {
                if (((aqs) new aqs().aF(mVar.field_postBuf)).wys) {
                }
            } catch (Exception e) {
            }
            linkedList.add(mVar);
        }
        String str = "";
        i = 0;
        while (i < linkedList.size()) {
            String str2;
            try {
                if (((aqs) new aqs().aF(((m) linkedList.get(i)).field_postBuf)).wys) {
                    str2 = str;
                    i++;
                    str = str2;
                }
            } catch (Exception e2) {
            }
            str2 = str + ((m) linkedList.get(i)).byq() + " ";
            i++;
            str = str2;
        }
        x.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[]{Integer.valueOf(linkedList.size()), str, this.rBJ});
        if (!str.equals(this.rBJ)) {
            this.rBJ = str;
            this.rBF.rBR.removeAllViews();
            this.rBF.rBR.setVisibility(linkedList.size() > 0 ? 0 : 8);
            Collections.sort(linkedList, new c(this));
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                LinearLayout linearLayout;
                View view;
                int i3 = ((m) linkedList.get(i2)).roJ;
                i = linkedList.size();
                if (!this.rBI.containsKey(Integer.valueOf(i3)) || this.rBI.get(Integer.valueOf(i3)) == null) {
                    linearLayout = (LinearLayout) v.fv(this.context).inflate(g.qGv, null);
                    linearLayout.getChildAt(0).setOnClickListener(new 3(this, i, i2));
                    this.rBI.put(Integer.valueOf(i3), linearLayout);
                } else {
                    view = (View) this.rBI.get(Integer.valueOf(i3));
                }
                linearLayout = (LinearLayout) view;
                linearLayout.getChildAt(0).setTag(((m) linkedList.get(i2)).byq());
                TextView textView = (TextView) linearLayout.findViewById(f.qFe);
                if (((m) linkedList.get(i2)).field_type == 15) {
                    textView.setText(j.qLW);
                } else {
                    textView.setTag(Integer.valueOf(j.qLR));
                }
                this.rBF.rBR.addView(linearLayout);
            }
            if (linkedList.size() > 0) {
                return true;
            }
            return false;
        } else if (linkedList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
