package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.voip.model.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.pb.talkroom.sdk.b;
import com.tencent.pb.talkroom.sdk.e;

class c$1 implements e {
    final /* synthetic */ c oFW;

    c$1(c cVar) {
        this.oFW = cVar;
    }

    public final boolean m(int i, String str, String str2) {
        switch (i) {
            case 0:
                x.v(str, str2);
                break;
            case 1:
                x.d(str, str2);
                break;
            case 2:
                x.i(str, str2);
                break;
            case 3:
                x.w(str, str2);
                break;
            case 4:
                x.e(str, str2);
                break;
            case 5:
                x.f(str, str2);
                break;
            default:
                x.v(str, str2);
                break;
        }
        return false;
    }

    public final boolean b(int i, int i2, byte[] bArr) {
        x.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + i + " cmdid " + i2);
        ar.CG().a(new n(i, i2, bArr), 0);
        return false;
    }

    public final boolean bbV() {
        int yp = m.yp();
        x.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:" + yp);
        if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            d.t(ac.getContext(), "libvoipCodec_v7a.so");
        } else if ((yp & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            d.t(ac.getContext(), "libvoipCodec.so");
        } else {
            d.t(ac.getContext(), "libvoipCodec_v5.so");
        }
        return true;
    }

    public final int yp() {
        return m.yp();
    }

    public final int bbW() {
        ar.Hg();
        String cjU = c.CV().cjU();
        q.eI(cjU);
        x.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: " + cjU);
        c.a(this.oFW);
        return 0;
    }

    public final boolean gO(boolean z) {
        x.i("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[]{Boolean.valueOf(z)});
        this.oFW.oFR.fW(z);
        return true;
    }

    public final int a(int i, int i2, b bVar) {
        int i3;
        this.oFW.oFU = bVar;
        Object obj = this.oFW.oFR;
        a aVar = this.oFW.oFV;
        if (obj.fAs) {
            x.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
            i3 = -1;
        } else {
            x.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay");
            if (obj.nEe == null) {
                obj.nEe = new com.tencent.mm.plugin.voip.model.b();
                obj.nEe.Y(i, i2, 0);
            }
            obj.nEe.l(ac.getContext(), false);
            obj.nEe.siT = aVar;
            ar.Hh().a(obj);
            obj.nEs = ar.Hh().xR();
            obj.nEr = ar.Hh().xL();
            x.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[]{Boolean.valueOf(obj.nEs), Boolean.valueOf(obj.nEr)});
            i3 = obj.nEe.bGd();
            obj.hXN.requestFocus();
            obj.nEn.a(ac.getContext(), obj);
            obj.fAs = true;
        }
        x.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[]{Boolean.valueOf(ar.Hh().xQ()), Boolean.valueOf(o.bcV().oGd)});
        if (ar.Hh().xQ() != o.bcV().oGd && o.bcV().nDg.aip()) {
            this.oFW.oFR.fW(o.bcV().oGd);
        }
        return i3;
    }

    public final int a(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
        this.oFW.oFT = cVar;
        this.oFW.oFS = new com.tencent.mm.e.b.c(i, 1, 7);
        this.oFW.oFS.et(i2);
        this.oFW.oFS.aP(true);
        this.oFW.oFS.vq();
        this.oFW.oFS.fkz = -19;
        this.oFW.oFS.n(1, false);
        this.oFW.oFS.aO(true);
        this.oFW.oFS.fkK = this.oFW.flb;
        if (this.oFW.oFS.vr()) {
            return 1;
        }
        return -1;
    }

    public final boolean bbX() {
        x.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
        Object obj = this.oFW.oFR;
        if (obj.fAs) {
            x.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay");
            synchronized (obj.nEf) {
                com.tencent.mm.sdk.f.e.post(new b.a(obj, obj.nEe), "MultiTalkAudioPlayer_stop");
                obj.fAs = false;
                obj.nEe = null;
            }
            obj.nEn.dA(ac.getContext());
            ar.Hh().b(obj);
            obj.hXN.zd();
        }
        return true;
    }

    public final boolean bbY() {
        x.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
        try {
            if (this.oFW.oFS != null) {
                this.oFW.oFS.fkK = null;
                this.oFW.oFS.vi();
            }
            this.oFW.oFS = null;
            return true;
        } catch (Exception e) {
            x.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :" + e);
            return false;
        }
    }

    public final int bbZ() {
        int i = 0;
        x.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
        if (this.oFW.oFR != null) {
            b bVar = this.oFW.oFR;
            if (bVar.nEe != null) {
                i = bVar.nEe.bGh();
            }
        }
        return (int) ((((float) ar.Hh().getStreamVolume(i)) / ((float) ar.Hh().getStreamMaxVolume(i))) * 100.0f);
    }

    public final int bca() {
        x.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
        if (this.oFW.oFS != null) {
            return this.oFW.oFS.vt();
        }
        return -2;
    }

    public final int bcb() {
        x.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
        if (this.oFW.oFS != null) {
            return this.oFW.oFS.fkp;
        }
        return 0;
    }

    public final int bcc() {
        x.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
        if (this.oFW.oFR == null) {
            return 0;
        }
        b bVar = this.oFW.oFR;
        if (bVar.nEe != null) {
            return bVar.nEe.bGg();
        }
        return 0;
    }
}
