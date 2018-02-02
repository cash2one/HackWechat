package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

class h$3 implements a {
    final /* synthetic */ h ouI;

    h$3(h hVar) {
        this.ouI = hVar;
    }

    public final void q(byte[] bArr, int i) {
        int i2 = 0;
        this.ouI.ouz.sendEmptyMessage(0);
        if (!this.ouI.ouv) {
            i2 = 1;
        }
        if (i2 == 0) {
            this.ouI.jzK += FileUtils.S_IWUSR;
        }
        boolean z = this.ouI.ouA;
        if (i2 == 0) {
            h hVar = this.ouI;
            if (0 == hVar.ouo) {
                hVar.ouo = System.nanoTime();
            }
            if (hVar.ouy != null && hVar.ouy.ovU <= 0) {
                hVar.ouy.ovU = System.nanoTime();
            }
            if (hVar.oul != null) {
                if (hVar.oul == null) {
                    x.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + z);
                } else {
                    try {
                        ByteBuffer[] inputBuffers = hVar.oul.getInputBuffers();
                        int dequeueInputBuffer = hVar.oul.dequeueInputBuffer(100);
                        hVar.oup = dequeueInputBuffer;
                        if (dequeueInputBuffer < 0) {
                            x.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                            hVar.gD(false);
                        }
                        if (hVar.oul == null) {
                            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + z);
                        } else if (hVar.oup >= 0) {
                            ByteBuffer byteBuffer = inputBuffers[hVar.oup];
                            byteBuffer.clear();
                            byteBuffer.put(bArr);
                            byteBuffer.position(0);
                            hVar.ouq = bArr.length;
                            hVar.our = System.nanoTime();
                            hVar.our -= (long) ((hVar.ouq / hVar.audioSampleRate) / 1000000000);
                            if (hVar.ouq == -3) {
                                x.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                            }
                            hVar.ous = (hVar.our - (hVar.ouy != null ? hVar.ouy.ovU : hVar.ouo)) / 1000;
                            x.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + hVar.ouq + " audio bytes with pts " + hVar.ous + ", end:" + z + ", enqueue:" + hVar.oup);
                            if (z) {
                                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                                hVar.oul.queueInputBuffer(hVar.oup, 0, hVar.ouq, hVar.ous, 4);
                            } else {
                                hVar.oul.queueInputBuffer(hVar.oup, 0, hVar.ouq, hVar.ous, 0);
                            }
                        }
                    } catch (Throwable th) {
                        x.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + th.getMessage());
                    }
                }
                hVar.gD(z);
            }
        }
        if (z && !this.ouI.ouE) {
            synchronized (this.ouI.ouC) {
                if (this.ouI.ouD != null) {
                    x.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
                    this.ouI.ouD.bau();
                    this.ouI.ouD = null;
                } else {
                    x.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
                }
                this.ouI.ouB = true;
            }
            this.ouI.ouE = true;
            this.ouI.ouF.removeCallbacks(this.ouI.ouG);
            this.ouI.ouF.post(this.ouI.ouG);
        }
    }

    public final void aK(int i, int i2) {
        x.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
