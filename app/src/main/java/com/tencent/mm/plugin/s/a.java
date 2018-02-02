package com.tencent.mm.plugin.s;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class a extends h {
    private AudioTrack afZ;
    private int channels;
    private boolean kTc = false;
    private int sampleRate;

    public a(g gVar, af afVar) {
        super(gVar, afVar);
    }

    final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        x.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", asP(), Integer.valueOf(this.state), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        if (d.sB(this.state)) {
            if (this.afZ == null) {
                Object obj;
                x.i("MicroMsg.AudioTrackDataSource", "%s init audio track", asP());
                if (this.channels == 0) {
                    this.channels = this.opI.getInteger("channel-count");
                }
                int i2 = this.channels == 1 ? 4 : 12;
                this.afZ = new d(3, getSampleRate(), i2, 2, AudioTrack.getMinBufferSize(getSampleRate(), i2, 2));
                if (this.afZ == null || this.afZ.getState() == 1) {
                    setMute(this.kTc);
                    obj = 1;
                } else {
                    x.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", asP(), Integer.valueOf(this.afZ.getState()));
                    this.afZ.release();
                    this.afZ = null;
                    obj = null;
                }
                if (obj == null) {
                    return false;
                }
            }
            if (d.sw(this.state) && (this.afZ.getPlayState() == 2 || this.afZ.getPlayState() == 1)) {
                onStart();
            }
            if ((this.state == 4 ? 1 : null) != null && this.afZ.getPlayState() == 3) {
                onPause();
            }
            try {
                this.opD.opu = bufferInfo.presentationTimeUs;
                byte[] bArr = new byte[bufferInfo.size];
                byteBuffer.get(bArr);
                byteBuffer.clear();
                if (bArr.length > 0) {
                    this.afZ.write(bArr, 0, bArr.length);
                }
                x.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track", asP(), Integer.valueOf(i), Long.valueOf(this.opD.opu));
                mediaCodec.releaseOutputBuffer(i, false);
            } catch (Exception e) {
                x.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", asP(), e.toString());
            }
            return true;
        }
        x.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", asP(), Integer.valueOf(this.state));
        return false;
    }

    protected final void onStart() {
        x.i("MicroMsg.AudioTrackDataSource", "%s on start", asP());
        if (this.afZ != null && this.afZ.getState() == 1) {
            this.afZ.play();
        }
    }

    protected final void onPause() {
        x.i("MicroMsg.AudioTrackDataSource", "%s on pause", asP());
        if (this.afZ != null && this.afZ.getState() == 1) {
            this.afZ.pause();
        }
    }

    public final void release() {
        try {
            this.afZ.flush();
            this.afZ.release();
        } catch (Exception e) {
        }
        super.release();
    }

    public final void setMute(boolean z) {
        if (this.afZ == null) {
            x.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", asP(), Boolean.valueOf(z));
            this.kTc = z;
        } else if (com.tencent.mm.compatible.util.d.fN(21)) {
            x.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", asP(), Boolean.valueOf(z));
            if (z) {
                this.afZ.setStereoVolume(0.0f, 0.0f);
            } else {
                this.afZ.setStereoVolume(1.0f, 1.0f);
            }
        } else {
            x.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", asP(), Boolean.valueOf(z));
            if (z) {
                this.afZ.setVolume(0.0f);
            } else {
                this.afZ.setVolume(1.0f);
            }
        }
    }

    final boolean a(MediaCodec mediaCodec) {
        x.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", asP());
        mediaCodec.configure(this.opI, null, null, 0);
        return false;
    }

    private int getSampleRate() {
        if (this.sampleRate == 0) {
            this.sampleRate = this.opI.getInteger("sample-rate");
        }
        return this.sampleRate;
    }

    protected final void b(MediaCodec mediaCodec) {
        x.i("MicroMsg.AudioTrackDataSource", "%s on output format changed", asP());
        this.sampleRate = 0;
        this.channels = 0;
        if (this.afZ != null) {
            try {
                this.afZ.flush();
                this.afZ.release();
            } catch (Exception e) {
            }
        }
        this.afZ = null;
    }

    final String aZy() {
        return SlookAirButtonRecentMediaAdapter.AUDIO_TYPE;
    }
}
