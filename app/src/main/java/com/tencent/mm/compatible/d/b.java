package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public boolean gCG = false;
    public int gCH;
    public int gCI;
    public int gCJ;
    public int gCK;
    public int gCL;
    public int gCM;
    public int gCN;
    public int gCO;
    public int gCP;
    public int gCQ;
    public int gCR;
    public int gCS;
    public int gCT;
    public int gCU;
    public int gCV;
    public int gCW;
    public int gCX;
    public int gCY;
    public int gCZ;
    public int gDA;
    public short[] gDB = new short[15];
    public short[] gDC = new short[2];
    public boolean gDD;
    public int gDE;
    public boolean gDF = false;
    public int gDG;
    public int gDH;
    public int gDI;
    public int gDJ;
    public int gDK;
    public int gDL;
    public int gDM;
    public int gDN;
    public int gDO;
    public int gDP;
    public int gDa;
    public int gDb;
    public int gDc;
    public int gDd;
    public int gDe;
    public int gDf;
    public int gDg;
    public int gDh;
    public int gDi;
    public int gDj;
    public int gDk;
    public boolean gDl;
    public int gDm;
    public int gDn;
    public int gDo;
    public int gDp;
    public int gDq;
    public int gDr;
    public int gDs;
    public int gDt;
    public int gDu;
    public int gDv;
    public int gDw;
    public int gDx;
    public int gDy;
    public int gDz;

    public b() {
        reset();
    }

    public final void reset() {
        this.gCG = false;
        this.gCH = -1;
        this.gCI = -1;
        this.gCJ = -1;
        this.gCK = -1;
        this.gCL = -1;
        this.gCM = -1;
        this.gCN = -1;
        this.gCP = -1;
        this.gCO = -1;
        this.gDt = -1;
        this.gCQ = -1;
        this.gCR = -1;
        this.gCS = -1;
        this.gDe = -1;
        this.gDf = -1;
        this.gDg = -1;
        this.gDh = -1;
        this.gDi = -1;
        this.gDj = -1;
        this.gDk = -1;
        this.gDl = false;
        this.gDm = -1;
        this.gDn = -1;
        this.gDp = -1;
        this.gDo = -1;
        this.gDs = -1;
        this.gDq = -1;
        this.gDr = -1;
        this.gDu = -1;
        this.gDv = -1;
        this.gDw = -1;
        this.gDx = -1;
        this.gCT = -1;
        this.gCU = -1;
        this.gCV = -1;
        this.gCW = -1;
        this.gCZ = -1;
        this.gDa = -1;
        this.gDb = -1;
        this.gDc = -1;
        this.gDy = 0;
        this.gDz = 0;
        this.gDA = -1;
        this.gCY = -1;
        this.gCX = -1;
        this.gDD = false;
        this.gDC[0] = (short) -1;
        this.gDC[1] = (short) -1;
        this.gDE = -1;
        this.gDM = -1;
        this.gDN = -1;
        this.gDO = -1;
        this.gDP = -1;
        this.gDd = -1;
    }

    public final boolean yb() {
        if ((this.gCI < 0 || this.gCJ >= 0) && ((this.gCI >= 0 || this.gCJ < 0) && this.gCK <= 0)) {
            return false;
        }
        return true;
    }

    public final boolean yc() {
        return this.gCL >= 0;
    }

    public final boolean yd() {
        return this.gCM >= 0;
    }

    public final int ye() {
        if (!yc()) {
            return -1;
        }
        int i = (this.gCL & 224) >> 5;
        x.d("VoipAudioInfo", "getEnableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final boolean yf() {
        if (!yc()) {
            return false;
        }
        boolean z;
        int i = this.gCL & 16;
        String str = "VoipAudioInfo";
        StringBuilder stringBuilder = new StringBuilder("enableSpeaker ");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        x.d(str, stringBuilder.append(z).toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final int yg() {
        if (!yc()) {
            return -1;
        }
        int i = (this.gCL & 14) >> 1;
        x.d("VoipAudioInfo", "getDisableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final boolean yh() {
        if (!yc()) {
            return false;
        }
        boolean z;
        int i = this.gCL & 1;
        String str = "VoipAudioInfo";
        StringBuilder stringBuilder = new StringBuilder("disableSpeaker ");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        x.d(str, stringBuilder.append(z).toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final int yi() {
        if (!yd()) {
            return -1;
        }
        int i = (this.gCM & 224) >> 5;
        x.d("VoipAudioInfo", "getEnableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final int yj() {
        if (!yd()) {
            return -1;
        }
        int i = (this.gCM & 14) >> 1;
        x.d("VoipAudioInfo", "getDisableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final void dump() {
        x.d("VoipAudioInfo", "streamtype " + this.gCH);
        x.d("VoipAudioInfo", "smode " + this.gCI);
        x.d("VoipAudioInfo", "omode " + this.gCJ);
        x.d("VoipAudioInfo", "ospeaker " + this.gCK);
        x.d("VoipAudioInfo", "operating" + this.gCL);
        x.d("VoipAudioInfo", "moperating" + this.gCM);
        x.d("VoipAudioInfo", "mstreamtype" + this.gCN);
        x.d("VoipAudioInfo", "mVoiceRecordMode" + this.gCO);
        x.d("VoipAudioInfo", "agcMode :" + this.gDt);
        x.d("VoipAudioInfo", "nsMode:" + this.gCR);
        x.d("VoipAudioInfo", "aecMode:" + this.gCQ);
        x.d("VoipAudioInfo", "volumMode:" + this.gCS);
        x.d("VoipAudioInfo", "micMode:" + this.gDe);
        x.d("VoipAudioInfo", "sourceMode:" + this.gDf);
        x.d("VoipAudioInfo", "speakerMode:" + this.gDg);
        x.d("VoipAudioInfo", "phoneMode:" + this.gDh);
        x.d("VoipAudioInfo", "voipstreamType:" + this.gDi);
        x.d("VoipAudioInfo", "speakerstreamtype:" + this.gDj);
        x.d("VoipAudioInfo", "phonestreamtype:" + this.gDk);
        x.d("VoipAudioInfo", "ringphonestream:" + this.gDm);
        x.d("VoipAudioInfo", "ringphonemode:" + this.gDn);
        x.d("VoipAudioInfo", "ringspeakerstream:" + this.gDo);
        x.d("VoipAudioInfo", "ringspeakermode:" + this.gDp);
        x.d("VoipAudioInfo", "agcModeNew :" + this.gDs);
        x.d("VoipAudioInfo", "nsModeNew:" + this.gDr);
        x.d("VoipAudioInfo", "aecModeNew:" + this.gDq);
        x.d("VoipAudioInfo", "agctargetdb:" + this.gDu);
        x.d("VoipAudioInfo", "agcgaindb:" + this.gDv);
        x.d("VoipAudioInfo", "agcflag:" + this.gDw);
        x.d("VoipAudioInfo", "agclimiter:" + this.gDx);
        x.d("VoipAudioInfo", "inputVolumeScale:" + this.gCT);
        x.d("VoipAudioInfo", "outputVolumeScale:" + this.gCU);
        x.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.gCV);
        x.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.gCW);
        x.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.gCZ);
        x.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.gDa);
        x.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.gDb);
        x.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.gDc);
        x.d("VoipAudioInfo", "enableRecTimer:" + this.gDy);
        x.d("VoipAudioInfo", "enablePlayTimer:" + this.gDz);
        x.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.gDA);
        x.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.gCX);
        x.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.gCY);
        x.d("VoipAudioInfo", "noisegateon" + this.gDD);
        x.d("VoipAudioInfo", "noisegatestrength[0]" + this.gDC[0]);
        x.d("VoipAudioInfo", "noisegatestrength[1]" + this.gDC[1]);
        x.d("VoipAudioInfo", "spkecenable:" + this.gDE);
        x.d("VoipAudioInfo", "agcRxFlag:" + this.gDM);
        x.d("VoipAudioInfo", "agcRxTargetdb:" + this.gDN);
        x.d("VoipAudioInfo", "agcRxGaindb:" + this.gDO);
        x.d("VoipAudioInfo", "agcRxLimiter:" + this.gDP);
        x.d("VoipAudioInfo", "enableXnoiseSup:" + this.gDd);
    }
}
