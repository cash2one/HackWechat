package com.tencent.mm.plugin.location.ui;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.protocal.c.axm;
import com.tencent.mm.protocal.c.brr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class m$4 implements a {
    final /* synthetic */ m nVm;

    m$4(m mVar) {
        this.nVm = mVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        m mVar = this.nVm;
        double d4 = (double) f2;
        double d5 = (double) f;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[refreshMyLocation] ");
        stringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[]{Double.valueOf(d4), Double.valueOf(d5)}));
        if (mVar.nRM == null) {
            mVar.nRM = new brr();
            mVar.nRM.wTo = new axm();
            mVar.nRM.vIy = q.FS();
            mVar.nRM.wTo.vNP = d4;
            mVar.nRM.wTo.vNO = d5;
            if (mVar.nSM && mVar.nUX) {
                mVar.aWl();
            }
        }
        mVar.nRM.wTo.vNP = d4;
        mVar.nRM.wTo.vNO = d5;
        View viewByItag = mVar.nSL.getViewByItag(mVar.nRM.vIy);
        if (viewByItag != null) {
            stringBuffer.append("[ view is not null hasCode: " + viewByItag.hashCode() + " ] ");
        } else {
            viewByItag = new TrackPoint(mVar.mContext);
            if (mVar.nVc) {
                ((TrackPoint) viewByItag).h(null);
                ((TrackPoint) viewByItag).g(null);
                ((TrackPoint) viewByItag).aWI();
            } else {
                ((TrackPoint) viewByItag).h(mVar.nVk);
                ((TrackPoint) viewByItag).g(mVar.nVj);
            }
            if (!mVar.nUZ) {
                ((TrackPoint) viewByItag).aWK();
            }
            stringBuffer.append("[view is null new one: " + viewByItag.hashCode() + " ] ");
            mVar.nSL.addView(viewByItag, d4, d5, mVar.nRM.vIy);
            mVar.nUW = new TrackPointAnimAvatar(mVar.mContext);
        }
        x.d("MicroMsg.TrackPointViewMgrImpl", stringBuffer.toString());
        if (viewByItag instanceof TrackPoint) {
            mVar.nUV = (TrackPoint) viewByItag;
            x.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
            mVar.nSL.updateViewLayout(viewByItag, d4, d5);
            mVar.nUV.DR(mVar.nRM.vIy);
            TrackPoint trackPoint = mVar.nUV;
            trackPoint.nYo.setImageResource(R.g.bDy);
            trackPoint = mVar.nUV;
            if (trackPoint.jlR == -1.0d && trackPoint.jlS == -1.0d) {
                trackPoint.jlR = d4;
                trackPoint.jlP = d4;
                trackPoint.jlS = d5;
                trackPoint.jlQ = d5;
            } else {
                trackPoint.jlR = trackPoint.jlP;
                trackPoint.jlS = trackPoint.jlQ;
                trackPoint.jlQ = d5;
                trackPoint.jlP = d4;
            }
            if (mVar.nUZ) {
                mVar.nUV.nYp.setVisibility(0);
            } else {
                mVar.nUV.aWK();
            }
        }
        if (mVar.nVe) {
            mVar.nSL.getIController().setCenter(mVar.nRM.wTo.vNP, mVar.nRM.wTo.vNO);
        }
        return true;
    }
}
