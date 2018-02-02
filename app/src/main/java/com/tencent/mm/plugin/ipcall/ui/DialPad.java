package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public class DialPad extends RelativeLayout implements OnClickListener, OnLongClickListener {
    private static final String[] nGW = new String[]{"1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6", "7", "8", "9", "*", "0", "#"};
    private static final String[] nGX = new String[]{"", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", ""};
    boolean nGV = false;
    Map<Integer, DialNumberButton> nGY = new HashMap();
    private Map<String, DialNumberButton> nGZ = new HashMap();
    Map<Integer, View> nHa = new HashMap();
    a nHb;

    public DialPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.i.cbT, this);
        float dimensionPixelSize = (float) getContext().getResources().getDimensionPixelSize(R.f.bxD);
        float dimensionPixelSize2 = (float) getContext().getResources().getDimensionPixelSize(R.f.bxF);
        float dimensionPixelSize3 = (float) getContext().getResources().getDimensionPixelSize(R.f.bxE);
        a(R.h.cbL, nGW[0], nGX[0], dimensionPixelSize);
        a(R.h.cbR, nGW[1], nGX[1], dimensionPixelSize);
        a(R.h.cbQ, nGW[2], nGX[2], dimensionPixelSize);
        a(R.h.cbJ, nGW[3], nGX[3], dimensionPixelSize);
        a(R.h.cbI, nGW[4], nGX[4], dimensionPixelSize);
        a(R.h.cbO, nGW[5], nGX[5], dimensionPixelSize);
        a(R.h.cbM, nGW[6], nGX[6], dimensionPixelSize);
        a(R.h.cbH, nGW[7], nGX[7], dimensionPixelSize);
        a(R.h.cbK, nGW[8], nGX[8], dimensionPixelSize);
        a(R.h.cbP, nGW[9], nGX[9], dimensionPixelSize3);
        a(R.h.cbS, nGW[10], nGX[10], dimensionPixelSize);
        a(R.h.cbN, nGW[11], nGX[11], dimensionPixelSize2);
        this.nHa.put(Integer.valueOf(R.h.ccp), findViewById(R.h.ccp));
        this.nHa.put(Integer.valueOf(R.h.ccr), findViewById(R.h.ccr));
        this.nHa.put(Integer.valueOf(R.h.ccq), findViewById(R.h.ccq));
        this.nHa.put(Integer.valueOf(R.h.ccn), findViewById(R.h.ccn));
        this.nHa.put(Integer.valueOf(R.h.ccm), findViewById(R.h.ccm));
        for (View view : this.nHa.values()) {
            if (this.nGV) {
                view.setBackgroundDrawable(getResources().getDrawable(R.e.btW));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(R.e.bsb));
            }
        }
        setClipToPadding(false);
        setClipChildren(false);
    }

    private void a(int i, String str, String str2, float f) {
        DialNumberButton dialNumberButton = (DialNumberButton) findViewById(i);
        if (!bh.ov(str) && str.length() == 1) {
            dialNumberButton.nGT.setText(str);
        }
        if (!bh.ov(str2) || "1".equals(str)) {
            dialNumberButton.nGU.setText(str2);
            dialNumberButton.nGU.setVisibility(0);
        } else {
            dialNumberButton.nGU.setVisibility(8);
        }
        dialNumberButton.nGT.setTextSize(0, f);
        dialNumberButton.setOnClickListener(this);
        dialNumberButton.setOnLongClickListener(this);
        dialNumberButton.gc(this.nGV);
        this.nGY.put(Integer.valueOf(i), dialNumberButton);
        this.nGZ.put(str, dialNumberButton);
    }

    public void onClick(View view) {
        if (this.nGY.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = (DialNumberButton) this.nGY.get(Integer.valueOf(view.getId()));
            String aUj = dialNumberButton.aUj();
            String aUk = dialNumberButton.aUk();
            d aTI = i.aTI();
            int MH = d.MH(aUj);
            if (MH != -1 && d.bIC()) {
                AudioManager audioManager = ar.Hh().gCe;
                if (audioManager == null) {
                    audioManager = (AudioManager) d.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                int ringerMode = audioManager.getRingerMode();
                if (!(ringerMode == 0 || ringerMode == 1)) {
                    synchronized (aTI.stq) {
                        if (aTI.str == null) {
                        } else {
                            aTI.str.startTone(MH, 250);
                        }
                    }
                }
            }
            if (this.nHb != null) {
                String str;
                a aVar = this.nHb;
                if (bh.ov(aUj)) {
                    str = aUk;
                } else {
                    str = aUj;
                }
                aVar.CI(str);
            }
        }
    }

    public boolean onLongClick(View view) {
        if (!this.nGY.containsKey(Integer.valueOf(view.getId()))) {
            return false;
        }
        DialNumberButton dialNumberButton = (DialNumberButton) this.nGY.get(Integer.valueOf(view.getId()));
        String aUj = dialNumberButton.aUj();
        String aUk = dialNumberButton.aUk();
        if (this.nHb != null) {
            a aVar = this.nHb;
            if (!bh.ov(aUj)) {
                aUk = aUj;
            }
            aVar.CJ(aUk);
        }
        return true;
    }

    public void onViewAdded(View view) {
        x.i("MicroMsg.DialPad", "onViewAdded, class: %s", new Object[]{view.getClass().getSimpleName()});
    }

    public void onViewRemoved(View view) {
        x.i("MicroMsg.DialPad", "onViewRemoved, class: %s", new Object[]{view.getClass().getSimpleName()});
    }
}
