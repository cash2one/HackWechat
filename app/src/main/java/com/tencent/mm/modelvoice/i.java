package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class i implements d {
    private static Object hWS = new Object();
    private static int hWT = -1;
    private static int hWU;
    private static int hWZ = 100;
    public int fkO;
    private a hWL;
    private b hWM;
    private com.tencent.mm.modelvoice.d.a hWN;
    private d.b hWO;
    private volatile boolean hWP;
    private String hWQ;
    private String hWR;
    private int hWV;
    private int hWW;
    private com.tencent.mm.e.c.b hWX;
    private int hWY;
    private OnCompletionListener hXa;
    private OnErrorListener hXb;
    private AudioTrack mAudioTrack;
    private String mFileName;
    public int mSampleRate;
    private int mStatus;

    private class a implements Runnable {
        final /* synthetic */ i hXc;

        private a(i iVar) {
            this.hXc = iVar;
        }

        public final void run() {
            Process.setThreadPriority(-16);
            byte[] bArr = new byte[(AudioTrack.getMinBufferSize(this.hXc.mSampleRate, 2, 2) * 2)];
            short f = (short) ((this.hXc.mSampleRate * 20) / 1000);
            x.d("MicroMsg.SilkPlayer", "frameLen: %d, playBufferSize: %d", new Object[]{Short.valueOf(f), Integer.valueOf(AudioTrack.getMinBufferSize(this.hXc.mSampleRate, 2, 2) * 2)});
            x.i("MicroMsg.SilkPlayer", "Thread start");
            while (true) {
                if (this.hXc.mStatus != 1 && this.hXc.mStatus != 2) {
                    break;
                }
                synchronized (i.hWS) {
                    if (i.hWU != this.hXc.hWV) {
                        x.i("MicroMsg.SilkPlayer", "[%d] diff id, useDeocder: %d", new Object[]{Integer.valueOf(this.hXc.hWV), Integer.valueOf(i.hWU)});
                        this.hXc.nN(this.hXc.mFileName);
                    }
                }
                while (this.hXc.hWP) {
                    x.d("MicroMsg.SilkPlayer", "waitting for switching complete");
                    Thread.sleep(20);
                }
                int SilkDoDec = MediaRecorder.SilkDoDec(bArr, f);
                if (SilkDoDec < 0) {
                    this.hXc.mStatus = 0;
                    g.pQN.a(161, 0, 1, false);
                    g.pQN.a(161, 4, 1, false);
                    x.e("MicroMsg.SilkPlayer", "[%d] SilkDoDec failed: %d", new Object[]{Integer.valueOf(this.hXc.hWV), Integer.valueOf(SilkDoDec)});
                    if (this.hXc.hWX != null && r.idX) {
                        this.hXc.hWX.vG();
                    }
                } else {
                    if (r.idX && this.hXc.hWX != null) {
                        this.hXc.hWX.u(bArr, f * 2);
                    }
                    try {
                        this.hXc.mAudioTrack.write(bArr, 0, f * 2);
                    } catch (Exception e) {
                        x.e("MicroMsg.SilkPlayer", "write audio track failed: %s", new Object[]{e.getMessage()});
                        g.pQN.a(161, 0, 1, false);
                        g.pQN.a(161, 5, 1, false);
                    }
                    this.hXc.hWW = this.hXc.hWW + 1;
                    if (SilkDoDec == 0) {
                        this.hXc.mStatus = 0;
                        x.i("MicroMsg.SilkPlayer", "[%d] play completed", new Object[]{Integer.valueOf(this.hXc.hWV)});
                        if (this.hXc.hWX != null && r.idX) {
                            this.hXc.hWX.vG();
                            ag.y(new Runnable(this) {
                                final /* synthetic */ a hXd;

                                {
                                    this.hXd = r1;
                                }

                                public final void run() {
                                    Toast.makeText(ac.getContext(), "Save to: " + this.hXd.hXc.hWX.mFilePath, 1).show();
                                }
                            });
                        }
                    } else if (this.hXc.mStatus == 2) {
                        synchronized (this.hXc.hWR) {
                            try {
                                x.v("MicroMsg.SilkPlayer", "before mOk.notify");
                                this.hXc.hWR.notify();
                                x.v("MicroMsg.SilkPlayer", "after mOk.notify");
                            } catch (Throwable e2) {
                                x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e2)});
                            }
                        }
                        try {
                            synchronized (this.hXc.hWQ) {
                                try {
                                    x.v("MicroMsg.SilkPlayer", "before mpause.wait");
                                    this.hXc.hWQ.wait();
                                    x.v("MicroMsg.SilkPlayer", "after mpause.wait");
                                } catch (Throwable e22) {
                                    x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e22)});
                                }
                            }
                        } catch (Throwable e222) {
                            g.pQN.a(161, 0, 1, false);
                            x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e222)});
                            if (this.hXc.hXb != null) {
                                this.hXc.hXb.onError(null, 0, 0);
                            }
                            this.hXc.mStatus = 0;
                        }
                    } else {
                        synchronized (this.hXc.hWR) {
                            try {
                                this.hXc.hWR.notify();
                            } catch (Throwable e2222) {
                                x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e2222)});
                            }
                        }
                    }
                }
            }
            if (this.hXc.mStatus != 3) {
                Thread.sleep(1000);
            }
            synchronized (i.hWS) {
                if (i.hWU == this.hXc.hWV) {
                    MediaRecorder.SilkDecUnInit();
                    x.i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit", new Object[]{Integer.valueOf(this.hXc.hWV)});
                    i.hWU = -1;
                }
            }
            if (this.hXc.mStatus != 3) {
                if (this.hXc.hWN != null) {
                    this.hXc.hWN.vh();
                }
                if (this.hXc.hXa != null) {
                    this.hXc.hXa.onCompletion(null);
                }
            } else if (this.hXc.mAudioTrack != null) {
                x.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                this.hXc.mAudioTrack.stop();
                this.hXc.mAudioTrack.release();
                this.hXc.mAudioTrack = null;
            }
        }
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public i() {
        this.hWN = null;
        this.hWO = null;
        this.fkO = 2;
        this.mSampleRate = 16000;
        this.mFileName = "";
        this.mStatus = 0;
        this.hWP = false;
        this.hWQ = "";
        this.hWR = "";
        this.hWW = 0;
        this.hWX = null;
        this.hWY = 8;
        this.hXa = new 1(this);
        this.hXb = new 2(this);
        hWT++;
        this.hWV = hWT;
        x.i("MicroMsg.SilkPlayer", "[%d] new Instance", new Object[]{Integer.valueOf(this.hWV)});
    }

    public i(Context context) {
        this();
        this.hWM = new b(context);
    }

    public final void a(com.tencent.mm.modelvoice.d.a aVar) {
        this.hWN = aVar;
    }

    public final void a(d.b bVar) {
        this.hWO = bVar;
    }

    public final void aM(boolean z) {
        x.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", new Object[]{Boolean.valueOf(z)});
        this.hWP = true;
        this.fkO = 2;
        ca(z);
        try {
            this.mAudioTrack.play();
        } catch (Exception e) {
            g.pQN.a(161, 0, 1, false);
            g.pQN.a(161, 3, 1, false);
            x.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[]{e.getMessage()});
        }
        this.hWP = false;
    }

    private void ca(boolean z) {
        int i;
        int i2;
        int minBufferSize;
        AudioTrack dVar;
        if (this.mAudioTrack != null) {
            x.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            try {
                this.mAudioTrack.stop();
                this.mAudioTrack.release();
            } catch (Exception e) {
                x.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", new Object[]{e.getMessage()});
            }
            this.mAudioTrack = null;
        }
        int i3 = this.mSampleRate;
        int i4 = this.fkO;
        int i5 = this.hWY;
        if (z) {
            i = 3;
        } else {
            boolean z2 = false;
        }
        if (q.gFV.gCG) {
            q.gFV.dump();
            if (z && q.gFV.gDj >= 0) {
                i2 = q.gFV.gDj;
                minBufferSize = AudioTrack.getMinBufferSize(i3, i4, 2);
                x.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minBufferSize), Integer.valueOf(i5)});
                dVar = new d(i2, i3, i4, 2, i5 * minBufferSize);
                if (dVar.getState() == 0) {
                    dVar.release();
                    x.i("AudioDeviceFactory", "reconstruct AudioTrack");
                    if (i2 == 0) {
                    }
                    dVar = new d(i2 == 0 ? 3 : 0, i3, i4, 2, i5 * minBufferSize);
                }
                x.i("AudioDeviceFactory", "AudioTrack state: " + dVar.getState());
                this.mAudioTrack = dVar;
                if (this.mAudioTrack != null) {
                }
                g.pQN.a(161, 0, 1, false);
                g.pQN.a(161, 2, 1, false);
                if (this.mAudioTrack == null) {
                    this.mAudioTrack.release();
                    this.mAudioTrack = null;
                }
            } else if (!z && q.gFV.gDk >= 0) {
                i2 = q.gFV.gDk;
                minBufferSize = AudioTrack.getMinBufferSize(i3, i4, 2);
                x.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minBufferSize), Integer.valueOf(i5)});
                dVar = new d(i2, i3, i4, 2, i5 * minBufferSize);
                if (dVar.getState() == 0) {
                    dVar.release();
                    x.i("AudioDeviceFactory", "reconstruct AudioTrack");
                    dVar = new d(i2 == 0 ? 3 : 0, i3, i4, 2, i5 * minBufferSize);
                }
                x.i("AudioDeviceFactory", "AudioTrack state: " + dVar.getState());
                this.mAudioTrack = dVar;
                if (this.mAudioTrack != null || this.mAudioTrack.getState() == 0) {
                    g.pQN.a(161, 0, 1, false);
                    g.pQN.a(161, 2, 1, false);
                    if (this.mAudioTrack == null) {
                        this.mAudioTrack.release();
                        this.mAudioTrack = null;
                    }
                }
                return;
            }
        }
        i2 = i;
        minBufferSize = AudioTrack.getMinBufferSize(i3, i4, 2);
        x.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minBufferSize), Integer.valueOf(i5)});
        dVar = new d(i2, i3, i4, 2, i5 * minBufferSize);
        if (dVar.getState() == 0) {
            dVar.release();
            x.i("AudioDeviceFactory", "reconstruct AudioTrack");
            if (i2 == 0) {
            }
            dVar = new d(i2 == 0 ? 3 : 0, i3, i4, 2, i5 * minBufferSize);
        }
        x.i("AudioDeviceFactory", "AudioTrack state: " + dVar.getState());
        this.mAudioTrack = dVar;
        if (this.mAudioTrack != null) {
        }
        g.pQN.a(161, 0, 1, false);
        g.pQN.a(161, 2, 1, false);
        try {
            if (this.mAudioTrack == null) {
                this.mAudioTrack.release();
                this.mAudioTrack = null;
            }
        } catch (Exception e2) {
        }
    }

    public final boolean K(String str, boolean z) {
        return L(str, z);
    }

    public final boolean c(String str, boolean z, int i) {
        return L(str, z);
    }

    private boolean L(String str, boolean z) {
        int i = 2;
        if (this.mStatus != 0) {
            x.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            return false;
        }
        if (r.idX) {
            ax(str, com.tencent.mm.e.b.g.flo);
        }
        x.i("MicroMsg.SilkPlayer", "startPlay");
        this.mStatus = 1;
        this.mFileName = str;
        synchronized (hWS) {
            nN(str);
        }
        if (r.idX) {
            int i2;
            String str2 = com.tencent.mm.e.b.g.fln;
            if (this.fkO == 2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.hWX = new com.tencent.mm.e.c.b(str2, i2, this.mSampleRate);
        }
        String str3 = "MicroMsg.SilkPlayer";
        String str4 = "startPlay, sampleRate: %d, channelCnt: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mSampleRate);
        if (this.fkO == 2) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        x.d(str3, str4, objArr);
        try {
            return cb(z);
        } catch (Throwable e) {
            try {
                return cb(true);
            } catch (Exception e2) {
                x.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
                x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e)});
                this.mStatus = -1;
                return false;
            }
        }
    }

    private void nN(String str) {
        int available;
        hWU = this.hWV;
        x.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", new Object[]{Integer.valueOf(this.hWV)});
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            available = fileInputStream.available();
            x.d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", new Object[]{Integer.valueOf(available)});
            if (!f.xG().xL() || available >= 5000) {
                this.hWY = 8;
            } else {
                this.hWY = 1;
            }
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr, 0, available);
            this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
            MediaRecorder.SilkDecUnInit();
            MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
            available = -1;
            c fn = com.tencent.mm.z.c.c.IF().fn("100268");
            if (fn.isValid()) {
                available = bh.getInt((String) fn.chI().get("SilkAudioPlayerAgcOn"), 0);
            }
            if (1 == available || available == 0) {
                MediaRecorder.SetVoiceSilkDecControl(hWZ, new byte[]{(byte) available}, 1);
            }
            fileInputStream.close();
        } catch (Throwable e) {
            g.pQN.a(161, 0, 1, false);
            g.pQN.a(161, 1, 1, false);
            x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e)});
        }
        x.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", new Object[]{Integer.valueOf(this.hWV), Integer.valueOf(this.hWW)});
        byte[] bArr2 = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2)];
        short s = (short) ((this.mSampleRate * 20) / 1000);
        for (available = 0; available < this.hWW; available++) {
            if (MediaRecorder.SilkDoDec(bArr2, s) <= 0) {
                x.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", new Object[]{Integer.valueOf(this.hWV), Integer.valueOf(MediaRecorder.SilkDoDec(bArr2, s))});
                return;
            }
        }
    }

    private boolean cb(boolean z) {
        boolean z2 = false;
        if (e.bO(this.mFileName)) {
            try {
                ca(z);
                if (this.mAudioTrack != null) {
                    if (this.hWM != null) {
                        this.hWM.requestFocus();
                    }
                    z2 = Ux();
                }
            } catch (Throwable e) {
                if (this.hWM != null) {
                    this.hWM.zd();
                }
                x.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + e.getMessage());
                x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return z2;
    }

    private boolean Ux() {
        if (this.mAudioTrack == null) {
            return false;
        }
        try {
            x.i("MicroMsg.SilkPlayer", "play");
            this.mAudioTrack.play();
            this.hWL = new a();
            com.tencent.mm.sdk.f.e.b(this.hWL, "SilkPlayer_play_" + this.hWV, 10);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[]{e.getMessage()});
            g.pQN.a(161, 0, 1, false);
            g.pQN.a(161, 3, 1, false);
            return false;
        }
    }

    public final boolean aK(boolean z) {
        if (this.mStatus != 1) {
            return false;
        }
        this.mStatus = 2;
        synchronized (this.hWR) {
            try {
                x.v("MicroMsg.SilkPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.hWR.wait();
                x.v("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable e) {
                x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e)});
                return false;
            }
        }
        if (this.hWM != null && z) {
            this.hWM.zd();
        }
        return true;
    }

    public final boolean vc() {
        if (this.mStatus != 2) {
            return false;
        }
        this.mStatus = 1;
        synchronized (this.hWQ) {
            try {
                x.v("MicroMsg.SilkPlayer", "before mpause.notify");
                this.hWQ.notify();
                x.v("MicroMsg.SilkPlayer", "after mpause.notify");
            } catch (Throwable e) {
                x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e)});
                return false;
            }
        }
        if (this.hWM != null) {
            this.hWM.requestFocus();
        }
        return true;
    }

    public final boolean isPlaying() {
        return this.mStatus == 1;
    }

    public final boolean vo() {
        x.i("MicroMsg.SilkPlayer", "stop  status:" + this.mStatus);
        if (this.mStatus == 1 || this.mStatus == 2) {
            this.mStatus = 3;
            synchronized (this.hWQ) {
                try {
                    this.hWQ.notify();
                    if (this.hWM != null) {
                        this.hWM.zd();
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e)});
                    if (this.hWM != null) {
                        this.hWM.zd();
                    }
                    return false;
                } catch (Throwable th) {
                    if (this.hWM != null) {
                        this.hWM.zd();
                    }
                }
            }
            return true;
        }
        x.e("MicroMsg.SilkPlayer", "stop  error status:" + this.mStatus);
        return false;
    }

    public final double vf() {
        return 0.0d;
    }

    public final void b(com.tencent.mm.compatible.util.b.a aVar) {
        if (aVar != null && this.hWM != null) {
            this.hWM.a(aVar);
        }
    }

    public final String ax(String str, String str2) {
        Throwable e;
        String str3 = null;
        if (this.mStatus != 0) {
            x.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
        } else {
            this.mStatus = 1;
            this.mFileName = str;
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    int available = fileInputStream.available();
                    byte[] bArr = new byte[available];
                    fileInputStream.read(bArr, 0, available);
                    this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
                    MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
                    x.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit in silkToPcm", new Object[]{Integer.valueOf(this.hWV)});
                    fileInputStream.close();
                    str3 = nO(str2);
                } catch (Exception e2) {
                    e = e2;
                    x.e("MicroMsg.SilkPlayer", "silkToPcm, file[%s], exception: %s", new Object[]{this.mFileName, e.getMessage()});
                    x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e)});
                    this.mStatus = -1;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.SilkPlayer", e3, "", new Object[0]);
                        }
                    }
                    return str3;
                }
            } catch (Exception e4) {
                e3 = e4;
                fileInputStream = str3;
                x.e("MicroMsg.SilkPlayer", "silkToPcm, file[%s], exception: %s", new Object[]{this.mFileName, e3.getMessage()});
                x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e3)});
                this.mStatus = -1;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str3;
            }
        }
        return str3;
    }

    private String nO(String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        x.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl()");
        if (e.bO(this.mFileName)) {
            try {
                x.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread start");
                Process.setThreadPriority(-16);
                byte[] bArr = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) << 1)];
                short s = (short) ((this.mSampleRate * 20) / 1000);
                nP(str);
                fileOutputStream = new FileOutputStream(str);
                while (true) {
                    if (this.mStatus != 1 && this.mStatus != 2) {
                        break;
                    }
                    int SilkDoDec = MediaRecorder.SilkDoDec(bArr, s);
                    if (SilkDoDec < 0) {
                        this.mStatus = 0;
                    } else {
                        while (this.hWP) {
                            try {
                                Thread.sleep(20);
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        fileOutputStream.write(bArr, 0, s * 2);
                        fileOutputStream.flush();
                        if (SilkDoDec == 0) {
                            this.mStatus = 0;
                        }
                    }
                }
                x.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread end");
                fileOutputStream.close();
                int SilkDecUnInit = MediaRecorder.SilkDecUnInit();
                x.i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit in silkToPcmImpl", new Object[]{Integer.valueOf(this.hWV)});
                if (SilkDecUnInit == 0) {
                    return str;
                }
                x.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl res: " + SilkDecUnInit);
                return str;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                try {
                    x.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread exception: " + e.getMessage());
                    x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e)});
                    this.mStatus = 0;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.SilkPlayer", e4, "", new Object[0]);
                        }
                    }
                    return null;
                } catch (Throwable e42) {
                    x.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl exception: " + e42.getMessage());
                    x.e("MicroMsg.SilkPlayer", "exception:%s", new Object[]{bh.i(e42)});
                    return null;
                }
            }
        }
        x.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl(), file not exist, fileName = %s", new Object[]{this.mFileName});
        return null;
    }

    private static boolean nP(String str) {
        if (str == null) {
            return false;
        }
        try {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf == -1) {
                x.w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
                return false;
            }
            File file = new File(str.substring(0, lastIndexOf + 1));
            if (!file.exists()) {
                boolean z = file.mkdirs() || file.isDirectory();
                x.i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", new Object[]{r3, Boolean.valueOf(z)});
            }
            return true;
        } catch (Exception e) {
            x.w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", new Object[]{e.getMessage()});
            return false;
        }
    }
}
