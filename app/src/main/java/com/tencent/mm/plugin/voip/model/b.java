package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioTrack;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Timer;

public final class b {
    private static float agB = 0.0f;
    AudioTrack afZ = null;
    Context context;
    private Timer flf = null;
    private boolean flg = false;
    private int gDg = 3;
    int hXg = 2;
    private int hXh = 0;
    private int hXi = 0;
    private Runnable hXj;
    private int hXl = 0;
    int hXm = 20;
    private boolean hXn = false;
    public boolean siI = false;
    boolean siJ = false;
    boolean siK = true;
    e siL = null;
    private int siM = 0;
    private byte[] siN = null;
    private byte[] siO = null;
    private byte[] siP = null;
    private byte[] siQ = null;
    private byte[] siR = null;
    private int siS = 0;
    public a siT = null;
    private int siU = 1;
    private int siV = 1;
    private int siW = 0;
    private int siX = 0;
    private int siY = 0;
    private int siZ = 0;
    private int sja = 0;
    private int sjb = 0;
    private int sjc = 1;
    private int sjd = 0;
    private long sje = 0;
    private long sjf = 0;
    private int sjg = 1;
    private int sjh = 0;
    private int sji = -1;
    private int sjj = 0;
    private long sjk = 0;
    private int sjl = 1;
    private int sjm = 0;
    private final Object sjn = new Object();
    private int sjo = 0;
    private int sjp = 0;
    private int sjq = 0;
    private int sjr = 0;
    private int sjs = 0;

    static /* synthetic */ void j(b bVar, int i) {
        if (bVar.sjp != -1 && i < 0) {
            bVar.sjp++;
            if (bVar.sjp >= 50) {
                bVar.sjo = 5;
                bVar.sjp = -1;
            }
        }
    }

    public final int bGb() {
        return (this.sjm / this.hXm) * this.hXi;
    }

    public final int l(Context context, boolean z) {
        x.d("MicroMsg.Voip.AudioPlayer", "enter to Init...");
        this.context = context;
        if (this.siS == 2) {
            this.hXg = 3;
        } else {
            this.hXg = 2;
        }
        this.hXl = AudioTrack.getMinBufferSize(this.hXh, this.hXg, 2);
        if (this.hXl == -2 || this.hXl == -1) {
            this.sjo = 1;
            return -1;
        }
        this.sjb = this.hXl;
        this.sjh = this.sjb * this.sjg;
        this.hXl *= this.sjl;
        float f = ((float) (this.sjb >> 1)) / ((float) this.hXh);
        int yp = m.yp();
        int i = q.gFV.gDz;
        if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            x.i("MicroMsg.Voip.AudioPlayer", "CPU ARMv7, ablePlayTimer: " + i);
        } else {
            i = 0;
        }
        if (1000.0f * f < 60.0f || this.sjq != 0) {
            i = 0;
        }
        this.siK = i != 0;
        x.d("MicroMsg.Voip.AudioPlayer", "playBufSize:" + this.hXl + "  MinBufSizeInMs:" + f + ",bPlayTimer:" + this.siK);
        int je = je(z);
        try {
            if (this.afZ != null) {
                try {
                    this.afZ.release();
                } catch (Exception e) {
                }
            }
            this.afZ = new d(je, this.hXh, this.hXg, 2, this.hXl);
        } catch (Exception e2) {
            x.w("MicroMsg.Voip.AudioPlayer", "new AudioTrack:", new Object[]{e2});
            this.sjo = 6;
        }
        if (this.afZ == null || this.afZ.getState() == 0) {
            this.sjo = 2;
            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer audioTrack.getState() == AudioTrack.STATE_UNINITIALIZED");
            if (this.afZ != null) {
                this.afZ.release();
            }
            if (je == 0) {
                this.afZ = new d(3, this.hXh, this.hXg, 2, this.hXl);
            } else {
                this.afZ = new d(0, this.hXh, this.hXg, 2, this.hXl);
            }
        }
        if (this.afZ == null) {
            this.sjo = 3;
            x.e("MicroMsg.Voip.AudioPlayer", "null == audioTrack return");
            return -1;
        } else if (this.afZ.getState() == 0) {
            this.sjo = 3;
            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.afZ.release();
            this.afZ = null;
            return -1;
        } else {
            this.siN = new byte[this.hXl];
            if (this.siN == null) {
                x.e("MicroMsg.Voip.AudioPlayer", "null == playBuffer return");
                return -1;
            }
            this.siQ = new byte[this.hXm];
            if (this.siQ == null) {
                x.e("MicroMsg.Voip.AudioPlayer", "null == frmBuffer return");
                return -1;
            }
            if (this.siK) {
                this.siM = this.hXl;
                this.siO = new byte[this.siM];
                if (this.siO == null) {
                    x.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBuffer return");
                    return -1;
                }
                this.siP = new byte[this.siM];
                if (this.siP == null) {
                    x.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBufferTmp return");
                    return -1;
                }
                this.siR = new byte[this.hXm];
                if (this.siR == null) {
                    x.e("MicroMsg.Voip.AudioPlayer", "null == frmTaskBuffer return");
                    return -1;
                }
            }
            this.siI = false;
            this.siJ = false;
            x.i("MicroMsg.Voip.AudioPlayer", "dkbt AudioTrack init ok, mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[]{Integer.valueOf(ar.Hh().gCe.getMode()), Boolean.valueOf(ar.Hh().gCe.isSpeakerphoneOn()), Integer.valueOf(je), Integer.valueOf(this.hXl), Integer.valueOf(this.hXh)});
            return (this.hXl * 1000) / (this.hXh * 2);
        }
    }

    public final boolean jd(boolean z) {
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
        int je = je(z);
        if (ar.Hh().xL()) {
            je = 0;
        }
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + z + ":streamtype:" + je);
        if (this.afZ == null || je != this.afZ.getStreamType()) {
            bGf();
            this.hXn = true;
            if (this.siS == 2) {
                this.hXg = 3;
            } else {
                this.hXg = 2;
            }
            this.hXl = AudioTrack.getMinBufferSize(this.hXh, this.hXg, 2);
            if (this.hXl == -2 || this.hXl == -1) {
                this.hXn = false;
                return false;
            }
            this.siX = 0;
            this.sja = 0;
            this.sjc = 1;
            this.sjd = 0;
            this.sje = 0;
            this.sjf = 0;
            this.sjg = 1;
            this.sji = -1;
            this.sjj = 0;
            this.sjb = this.hXl;
            this.sjh = this.sjb * this.sjg;
            this.hXl *= this.sjl;
            x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.hXl + "  MinBufSizeInMs:" + (((float) this.sjb) / 16.0f));
            if (this.afZ != null) {
                try {
                    this.afZ.stop();
                } catch (Exception e) {
                    x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", new Object[]{e.getMessage()});
                }
                this.afZ.release();
                this.afZ = null;
            }
            x.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[]{Integer.valueOf(ar.Hh().gCe.getMode()), Boolean.valueOf(ar.Hh().gCe.isSpeakerphoneOn()), Integer.valueOf(je), Integer.valueOf(this.hXl), Integer.valueOf(this.hXh)});
            this.afZ = new d(je, this.hXh, this.hXg, 2, this.hXl);
            if (this.afZ == null || this.afZ.getState() != 0) {
                x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
                if (this.afZ != null) {
                    this.hXn = false;
                    bGd();
                    return true;
                }
                this.hXn = false;
                return false;
            }
            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.afZ.release();
            this.afZ = null;
            return false;
        }
        x.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
        return false;
    }

    private int je(boolean z) {
        int i = 0;
        if (q.gFV.gCH > 0) {
            i = ar.Hh().ba(z);
        } else if (q.gFV.gDi >= 0) {
            i = q.gFV.gDi;
        }
        if (z && q.gFV.gDj >= 0) {
            i = q.gFV.gDj;
        } else if (!z && q.gFV.gDk >= 0) {
            i = q.gFV.gDk;
        }
        if (1 != this.sjq) {
            return i;
        }
        if (q.gFV.gDJ >= 0) {
            i = q.gFV.gDJ;
        }
        if (z && q.gFV.gDK >= 0) {
            return q.gFV.gDK;
        }
        if (z || q.gFV.gDL < 0) {
            return i;
        }
        return q.gFV.gDL;
    }

    public final int bGc() {
        if (this.afZ != null) {
            this.afZ.release();
            this.afZ = null;
        }
        this.siI = false;
        this.siJ = false;
        return 1;
    }

    public final int Y(int i, int i2, int i3) {
        if (true == this.siI) {
            return 0;
        }
        this.hXh = i;
        this.siS = 1;
        this.hXi = i2;
        this.sjq = i3;
        this.hXm = (((this.hXh / 1000) * 1) * this.hXi) * 2;
        this.sjj = (this.hXh * 60) / 1000;
        return 1;
    }

    public final int bGd() {
        if (true == this.siI) {
            return 1;
        }
        if (this.afZ == null) {
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
            return 0;
        }
        this.siI = true;
        try {
            this.afZ.play();
        } catch (Exception e) {
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", new Object[]{e.getMessage()});
        }
        if (this.afZ.getPlayState() != 3) {
            this.sjo = 4;
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
            return 0;
        } else if (this.afZ.getState() == 0) {
            x.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
            return 0;
        } else {
            if (this.siK) {
                int i;
                if (this.flg || this.flf != null) {
                    x.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.flg);
                    i = -1;
                } else {
                    this.flf = new Timer();
                    i = this.flf == null ? -1 : 0;
                }
                if (i != 0) {
                    x.e("MicroMsg.Voip.AudioPlayer", new StringBuilder("InitAudioRecTimer failed, error code = -1").toString());
                    return 0;
                }
                this.flf.scheduleAtFixedRate(new a(this), 0, 20);
                this.flg = true;
            }
            this.hXj = new 1(this);
            e.b(this.hXj, "AudioPlayer_play", 10);
            return 1;
        }
    }

    public final int bGe() {
        if (this.afZ == null) {
            x.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.sjb + ",nSamplerate:" + this.hXh);
            return (this.sjb * 1000) / this.hXh;
        } else if (!this.siI || this.afZ.getState() == 0) {
            return (this.sjb * 1000) / this.hXh;
        } else {
            try {
                return ((this.siX - this.afZ.getPlaybackHeadPosition()) * 1000) / this.hXh;
            } catch (Exception e) {
                x.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[]{e.getMessage()});
                return (this.sjb * 1000) / this.hXh;
            }
        }
    }

    public final int bGf() {
        if (this.flg && this.flf != null) {
            this.flf.cancel();
            this.flg = false;
        }
        if (this.siI) {
            this.siI = false;
            this.sjm = 0;
            try {
                if (this.hXj != null) {
                    e.S(this.hXj);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Voip.AudioPlayer", e, "", new Object[0]);
            }
            try {
                if (this.afZ != null) {
                    this.afZ.stop();
                    this.afZ.release();
                    x.i("MicroMsg.Voip.AudioPlayer", "StopPlay stop audioTrack");
                }
            } catch (Exception e2) {
                x.e("MicroMsg.Voip.AudioPlayer", "StopPlay audioTrack.stop Exception:%s", new Object[]{e2.getMessage()});
            }
        }
        return 1;
    }

    public final int bGg() {
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.sjo);
        return this.sjo;
    }

    public final int bGh() {
        if (this.afZ != null) {
            return this.afZ.getStreamType();
        }
        return je(true);
    }
}
