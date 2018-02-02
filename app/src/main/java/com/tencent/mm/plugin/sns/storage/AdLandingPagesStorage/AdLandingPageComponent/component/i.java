package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {
    protected int backgroundColor;
    protected View contentView = null;
    public Context context;
    private long jIb = 0;
    protected int kDP;
    protected int kDQ;
    protected s rji;
    private int rjj = 0;
    private long rjk = 0;
    boolean rjl = false;
    protected ViewGroup rjm;

    public i(Context context, s sVar, ViewGroup viewGroup) {
        this.context = context;
        this.rji = sVar;
        this.rjm = viewGroup;
        int[] dv = ac.dv(context);
        this.kDP = dv[0];
        this.kDQ = dv[1];
    }

    public void a(s sVar) {
        s sVar2 = this.rji;
        if (sVar2 != sVar) {
            if (sVar2 == null || !sVar2.equals(sVar)) {
                this.rji = sVar;
                bxa();
                bwU();
            }
        }
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final View getView() {
        if (this.contentView != null) {
            return this.contentView;
        }
        if (this.contentView == null) {
            int bjK = bjK();
            if (bjK != Integer.MAX_VALUE) {
                this.contentView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(bjK, this.rjm, false);
            } else {
                this.contentView = bxb();
                if (this.contentView != null && this.contentView.getLayoutParams() == null) {
                    this.rjm.addView(this.contentView);
                    LayoutParams layoutParams = this.contentView.getLayoutParams();
                    this.rjm.removeView(this.contentView);
                    this.contentView.setLayoutParams(layoutParams);
                }
            }
            if (this.contentView == null) {
                throw new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
            }
        }
        bwW();
        bwL();
        bxa();
        bwU();
        return this.contentView;
    }

    public final s bxe() {
        return this.rji;
    }

    public void bwL() {
    }

    public View bwW() {
        return this.contentView;
    }

    protected void bxa() {
        x.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    }

    protected int bjK() {
        return Integer.MAX_VALUE;
    }

    protected View bxb() {
        return null;
    }

    public void bwH() {
        if (!this.rjl) {
            this.rjl = true;
            this.rjk = System.currentTimeMillis();
            this.rjj++;
        }
    }

    public void bwI() {
        if (this.rjl) {
            this.rjl = false;
            if (this.rjk > 0) {
                this.jIb += System.currentTimeMillis() - this.rjk;
            }
            this.rjk = 0;
        }
    }

    public void X(int i, int i2, int i3) {
    }

    public void bwG() {
        bwI();
    }

    public final String bxf() {
        return this.rji.rgK;
    }

    public boolean s(JSONArray jSONArray) {
        return false;
    }

    public boolean S(JSONObject jSONObject) {
        if (this.jIb == 0 || this.rji.rgX) {
            return false;
        }
        try {
            jSONObject.put("cid", this.rji.rgK);
            jSONObject.put("exposureCount", this.rjj);
            jSONObject.put("stayTime", this.jIb);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", e, "", new Object[0]);
            return false;
        }
    }

    protected void bwU() {
        iC(false);
    }

    protected final void iC(boolean z) {
        if (this.contentView == null) {
            throw new IllegalStateException("set field contentView first");
        } else if (this.rji != null) {
            LayoutParams layoutParams = this.contentView.getLayoutParams();
            if (layoutParams != null) {
                if (this.rji.rgQ != 2.14748365E9f) {
                    layoutParams.width = (int) this.rji.rgQ;
                }
                if (this.rji.rgR != 2.14748365E9f) {
                    layoutParams.height = (int) this.rji.rgR;
                }
                if (z && (layoutParams instanceof MarginLayoutParams)) {
                    ((MarginLayoutParams) layoutParams).setMargins((int) this.rji.rgO, (int) this.rji.rgM, (int) this.rji.rgP, (int) this.rji.rgN);
                }
                int gravity;
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams2.gravity = gravity;
                    } else {
                        layoutParams2.gravity = -1;
                    }
                } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
                    gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams3.gravity = gravity;
                    } else {
                        layoutParams3.gravity = -1;
                    }
                }
                this.contentView.setLayoutParams(layoutParams);
                return;
            }
            x.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.rjm);
        }
    }

    private int getGravity() {
        int i = 0;
        switch (this.rji.rgU) {
            case 0:
                i = 48;
                break;
            case 1:
                i = 16;
                break;
            case 2:
                i = 80;
                break;
        }
        switch (this.rji.rgV) {
            case 0:
                return i | 3;
            case 1:
                return i | 1;
            case 2:
                return i | 5;
            default:
                return i;
        }
    }

    public void Q(Map<String, Object> map) {
    }

    public void bxg() {
    }
}
