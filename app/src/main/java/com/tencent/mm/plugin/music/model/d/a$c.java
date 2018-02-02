package com.tencent.mm.plugin.music.model.d;

import android.os.Looper;
import com.tencent.mm.g.a.js;
import com.tencent.mm.g.a.js.a;
import com.tencent.mm.plugin.music.model.d.a.b;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.x;

public class a$c implements b {
    final /* synthetic */ a oLJ;

    public a$c(a aVar) {
        this.oLJ = aVar;
    }

    public final void beo() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
        if (this.oLJ.oLu != null) {
            this.oLJ.o(this.oLJ.oLu);
        }
        if (this.oLJ.hkt > 0) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[]{Integer.valueOf(this.oLJ.hkt)});
            this.oLJ.if(this.oLJ.hkt);
        }
        if (this.oLJ.hkt == 0 && !this.oLJ.oLx.ib()) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
            this.oLJ.oLx.ad(true);
        }
    }

    public final void bep() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
        if (this.oLJ.oLu != null) {
            this.oLJ.p(this.oLJ.oLu);
        }
    }

    public final void beq() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
        if (this.oLJ.oLu != null && !this.oLJ.oLx.ib()) {
            this.oLJ.r(this.oLJ.oLu);
        }
    }

    public final void ber() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
        if (this.oLJ.oLu != null) {
            this.oLJ.s(this.oLJ.oLu);
        }
    }

    public final void bes() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
        if (this.oLJ.oLu != null) {
            this.oLJ.t(this.oLJ.oLu);
        }
        if (this.oLJ.hkt > 0 && this.oLJ.oLx != null && !this.oLJ.oLx.ib()) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete, stay play hls");
            this.oLJ.hkt = 0;
            this.oLJ.oLx.ad(true);
        }
    }

    public final void bet() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
        if (this.oLJ.oLu != null) {
            this.oLJ.v(this.oLJ.oLu);
        }
        this.oLJ.oKF = false;
        this.oLJ.oLH.removeMessages(100);
    }

    public final void tD(int i) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[]{Integer.valueOf(i)});
    }

    public final void cW(int i, int i2) {
        a aVar;
        x.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.oLJ.oLu != null) {
            int i3;
            aVar = this.oLJ;
            asv com_tencent_mm_protocal_c_asv = this.oLJ.oLu;
            x.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            aVar.oMe = "error";
            com.tencent.mm.sdk.b.b jsVar = new js();
            jsVar.fAz.action = 4;
            jsVar.fAz.fAv = com_tencent_mm_protocal_c_asv;
            jsVar.fAz.state = "error";
            jsVar.fAz.duration = (long) aVar.getDuration();
            jsVar.fAz.fAB = true;
            a aVar2 = jsVar.fAz;
            x.i("MicroMsg.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[]{Integer.valueOf(i)});
            switch (i) {
                case -4999:
                    i3 = -1;
                    break;
                case -4005:
                case -4004:
                case -4003:
                case -4002:
                    i3 = 10001;
                    break;
                case -4001:
                    i3 = 10004;
                    break;
                case -4000:
                    i3 = 10002;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            aVar2.errCode = i3;
            a aVar3 = jsVar.fAz;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("errCode:" + i2 + ", err:");
            switch (i2) {
                case -4004:
                    stringBuilder.append("load error");
                    break;
                case -4003:
                    stringBuilder.append("MediaCodec decoder init exception");
                    break;
                case -4002:
                    stringBuilder.append("illegal state exception");
                    break;
                case -4001:
                    stringBuilder.append("UnrecognizedInputFormatException");
                    break;
                case -43:
                    stringBuilder.append("error url format");
                    break;
                case -42:
                    stringBuilder.append("stop error");
                    break;
                case -41:
                    stringBuilder.append("prepare error");
                    break;
                case -30:
                    stringBuilder.append(" network error");
                    break;
                case -13:
                    stringBuilder.append(" network respCode 502");
                    break;
                case -12:
                    stringBuilder.append(" network respCode 500");
                    break;
                case -11:
                    stringBuilder.append(" network respCode 404");
                    break;
                case -10:
                    stringBuilder.append(" network respCode 403");
                    break;
                case -3:
                    stringBuilder.append("connect fail");
                    break;
                case -2:
                    stringBuilder.append(" no network");
                    break;
                case -1:
                    stringBuilder.append("unknow exception");
                    break;
            }
            aVar3.fnL = stringBuilder.toString();
            com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
        }
        if (this.oLJ.oLx != null) {
            this.oLJ.oLx.ad(false);
            this.oLJ.oLx.stop();
        }
        this.oLJ.oKF = false;
        this.oLJ.oLH.removeMessages(100);
        aVar = this.oLJ;
        aVar.aBO++;
        if (this.oLJ.aBO == 1) {
            a.a(this.oLJ.fAA, i, i2);
        }
    }
}
