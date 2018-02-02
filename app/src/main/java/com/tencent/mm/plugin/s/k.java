package com.tencent.mm.plugin.s;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class k extends h {
    public Surface aeI;
    boolean oql = false;
    private boolean oqm = false;
    boolean oqn = false;
    private long oqo = 0;
    long oqp = -1;
    private int videoHeight;
    private int videoWidth;

    public k(g gVar, af afVar) {
        super(gVar, afVar);
    }

    final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        x.d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[]{asP(), Integer.valueOf(this.state), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)});
        if (d.sA(this.state)) {
            x.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", new Object[]{asP()});
            mediaCodec.releaseOutputBuffer(i, true);
            setState(4);
            return true;
        } else if (d.sz(this.state)) {
            x.d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", new Object[]{asP(), Long.valueOf(bufferInfo.presentationTimeUs / 1000), Long.valueOf(j), Long.valueOf(j - (bufferInfo.presentationTimeUs / 1000))});
            if ((j - (bufferInfo.presentationTimeUs / 1000) <= 30 ? 1 : null) != null) {
                x.i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", new Object[]{asP()});
                mediaCodec.releaseOutputBuffer(i, true);
                if (this.oqm) {
                    setState(7);
                    this.oqm = false;
                }
                this.oqm = true;
            } else {
                mediaCodec.releaseOutputBuffer(i, false);
            }
            return true;
        } else if (d.sB(this.state)) {
            long j3 = bufferInfo.presentationTimeUs / 1000;
            long elapsedRealtime = (j3 - j) - (SystemClock.elapsedRealtime() - j2);
            x.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", new Object[]{asP(), Long.valueOf(elapsedRealtime), Long.valueOf(SystemClock.elapsedRealtime() - j2), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3)});
            if (elapsedRealtime < -30) {
                x.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", new Object[]{asP()});
                mediaCodec.releaseOutputBuffer(i, false);
                this.opD.opw = 0;
                return true;
            } else if (elapsedRealtime < 30) {
                this.opD.opt = bufferInfo.presentationTimeUs;
                if (elapsedRealtime > 11) {
                    try {
                        Thread.sleep(elapsedRealtime - 10);
                    } catch (Exception e) {
                    }
                }
                if (d.sB(this.state)) {
                    if (Math.abs(j3 - this.oqo) > 1000) {
                        x.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", new Object[]{asP(), Integer.valueOf(i), Long.valueOf(j3)});
                        this.oqo = j3;
                    }
                    mediaCodec.releaseOutputBuffer(i, true);
                    return true;
                }
                x.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[]{asP(), Integer.valueOf(this.state)});
                return false;
            } else {
                x.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", new Object[]{asP()});
                return false;
            }
        } else {
            x.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[]{asP(), Integer.valueOf(this.state)});
            return false;
        }
    }

    final String aZy() {
        return SlookAirButtonRecentMediaAdapter.VIDEO_TYPE;
    }

    final boolean a(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            MediaFormat mediaFormat;
            if (this.aeI == null) {
                x.w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", new Object[]{asP()});
                this.oql = false;
            } else {
                this.oql = true;
            }
            x.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", new Object[]{asP()});
            if (this.opL == null) {
                mediaFormat = this.opI;
            } else {
                mediaFormat = this.opL.getTrackFormat(this.opK);
            }
            mediaCodec.configure(mediaFormat, this.aeI, null, 0);
        }
        return false;
    }

    protected final void b(MediaCodec mediaCodec) {
        x.i("MicroMsg.VideoTrackDataSource", "%s output format changed", new Object[]{asP()});
        mediaCodec.setVideoScalingMode(1);
    }

    @TargetApi(23)
    public final void aZN() {
        try {
            if (this.opN != null) {
                this.opN.setOutputSurface(this.aeI);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoTrackDataSource", e, "%s change surface23 error [%s]", new Object[]{asP(), e.toString()});
            aZO();
        }
    }

    public final void aZO() {
        x.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", new Object[]{asP()});
        if (this.opN != null) {
            kL();
            w(this.opD.opt, -1);
            aZI();
        }
    }

    protected final void b(MediaFormat mediaFormat, String str, int i) {
        int integer;
        int i2;
        super.b(mediaFormat, str, i);
        this.videoHeight = mediaFormat.getInteger("height");
        this.videoWidth = mediaFormat.getInteger("width");
        if (mediaFormat.containsKey("rotation-degrees")) {
            integer = mediaFormat.getInteger("rotation-degrees");
            i2 = 1;
        } else {
            integer = SightVideoJNI.getMp4Rotate(this.path);
            x.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", new Object[]{asP(), Integer.valueOf(integer)});
            i2 = 0;
        }
        if (Math.abs(integer) == 90 || Math.abs(integer) == 270) {
            int i3 = this.videoWidth;
            this.videoWidth = this.videoHeight;
            this.videoHeight = i3;
        }
        if (i2 != 0) {
            integer = 0;
        }
        this.opE.obtainMessage(4, this.videoWidth, this.videoHeight, Integer.valueOf(integer)).sendToTarget();
        x.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", new Object[]{asP(), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(integer)});
    }

    protected final boolean A(int i, long j) {
        x.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", new Object[]{asP(), Integer.valueOf(i), Boolean.valueOf(this.opD.opy)});
        if (!this.opD.opy || i != 1 || this.oqp == j) {
            return false;
        }
        boolean w = w(j, -1);
        this.oqp = j;
        return w;
    }
}
