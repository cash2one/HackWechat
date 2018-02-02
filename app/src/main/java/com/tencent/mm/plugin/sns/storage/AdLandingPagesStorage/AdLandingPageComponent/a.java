package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a extends i {
    public boolean rfC;
    protected boolean rfD = SnsAdNativeLandingPagesUI.rxR;
    public boolean rfE;
    private BroadcastReceiver tP = new BroadcastReceiver(this) {
        final /* synthetic */ a rfF;

        {
            this.rfF = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("com.tencent.mm.adlanding.close_exposure_voice".equals(intent.getAction()) && !this.rfF.bxe().rgK.equals(intent.getStringExtra("para_id"))) {
                a aVar = this.rfF;
                if (aVar.rfE) {
                    aVar.bwF();
                }
            }
        }
    };

    public a(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
        d.m(this.context).a(this.tP, new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice"));
        x.v("AbsVideoPlayComp", "register receiver " + this.tP);
    }

    public void bwF() {
        this.rfC = false;
    }

    public void bwG() {
        super.bwG();
        d.m(this.context).unregisterReceiver(this.tP);
        this.rfE = true;
        x.v("AbsVideoPlayComp", "unregister receiver " + this.tP);
    }

    public void bwH() {
        super.bwH();
        this.rfE = true;
    }

    public void bwI() {
        super.bwI();
        this.rfE = false;
    }

    public void X(int i, int i2, int i3) {
        super.X(i, i2, i3);
    }

    public void bwJ() {
        this.rfC = true;
    }

    public final void bwK() {
        Intent intent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
        intent.putExtra("para_id", bxe().rgK);
        d.m(this.context).a(intent);
    }

    protected final void bwL() {
        super.bwL();
        if (this.rfD) {
            bwJ();
        } else {
            bwF();
        }
    }
}
