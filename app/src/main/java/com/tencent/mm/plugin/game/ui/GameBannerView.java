package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.z.ar;
import com.tencent.rtmp.TXLiveConstants;
import java.util.LinkedList;

public class GameBannerView extends LinearLayout implements e, OnClickListener {
    private float kCe = 0.0f;
    private MMDotView kba;
    private ViewPager lDX;
    private Context mContext;
    int ndn = 0;
    private b nlB;
    LinkedList<a> nlC;
    ak nlD = new ak(new com.tencent.mm.sdk.platformtools.ak.a(this) {
        final /* synthetic */ GameBannerView nlF;

        {
            this.nlF = r1;
        }

        public final boolean uF() {
            if (this.nlF.lDX == null || this.nlF.nlC.size() <= 1) {
                this.nlF.nlD.TG();
                return false;
            }
            this.nlF.lDX.d(this.nlF.lDX.yF + 1, true);
            return true;
        }
    }, true);
    private float nlE = 0.0f;

    public static class a {
        public String hkg;
        public int index;
        public String naS;
        public f nlG;
    }

    public GameBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        inflate(context, R.i.djq, this);
        this.nlC = new LinkedList();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.kba = (MMDotView) findViewById(R.h.ckB);
        this.lDX = (ViewPager) findViewById(R.h.ckC);
        this.lDX.zo = this;
        this.nlB = new b(this, (byte) 0);
    }

    public final void Q(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.GameBannerView", "Empty banner list");
            setVisibility(8);
            return;
        }
        x.i("MicroMsg.GameBannerView", "bannerList size", new Object[]{Integer.valueOf(linkedList.size())});
        this.nlD.TG();
        this.nlC.clear();
        this.nlC.addAll(linkedList);
        this.lDX.a(this.nlB);
        this.lDX.d(linkedList.size() * 1000, false);
        if (this.nlC.size() > 1) {
            this.nlD.J(5000, 5000);
        }
        this.kba.setVisibility(8);
        setVisibility(0);
    }

    public final void af(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        int size = i % this.nlC.size();
        x.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", new Object[]{Integer.valueOf(i), Integer.valueOf(size)});
        if (((a) this.nlC.get(size)).nlG != null && ar.Hj()) {
            ap.a(this.mContext, 11, TXLiveConstants.PUSH_WARNING_NET_BUSY, size + 1, 1, this.ndn, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action) {
            case 0:
                this.nlE = rawX;
                this.kCe = rawY;
                break;
            case 1:
            case 3:
                fF(false);
                this.nlE = 0.0f;
                this.kCe = 0.0f;
                break;
            case 2:
                if (Math.abs((int) (rawX - this.nlE)) > Math.abs((int) (rawY - this.kCe))) {
                    fF(true);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.nlD.TG();
                break;
            case 1:
            case 3:
                this.nlD.J(5000, 5000);
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void fF(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            f fVar = aVar.nlG;
            if (bh.ov(aVar.naS)) {
                x.i("MicroMsg.GameBannerView", "null or nil url");
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", fVar.field_appId);
                bundle.putInt("game_report_from_scene", 5);
                ap.a(this.mContext, 11, TXLiveConstants.PUSH_WARNING_NET_BUSY, 1, c.a(this.mContext, fVar.field_appId, null, bundle), this.ndn, null);
                return;
            }
            ap.a(this.mContext, 11, TXLiveConstants.PUSH_WARNING_NET_BUSY, 1, c.ac(this.mContext, aVar.naS), this.ndn, null);
        }
    }
}
