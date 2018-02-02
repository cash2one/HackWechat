package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.ape.ApeDecoder;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegPlayer;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;

class PCMDataCut {
    private static final String TAG = "PCMDataCut";
    private AudioCut mAudioCut = null;
    private BaseDecoder mDecoder = null;
    private String mFileName = null;

    public PCMDataCut(String str) {
        this.mFileName = str;
        prepareDecoder();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean cutPCMData(String str, int i, int i2, int i3, boolean z) {
        File file;
        Throwable e;
        Throwable th;
        WaveWriter waveWriter;
        boolean z2 = false;
        WaveWriter waveWriter2 = null;
        File file2 = null;
        boolean reSamplerTo8K;
        try {
            WaveWriter waveWriter3;
            z2 = initDecoder();
            if (z2) {
                z2 = getAudioFormation();
            }
            if (z2) {
                z2 = calculateBufferSize();
            }
            if (this.mAudioCut.information == null || this.mAudioCut.information.getDuration() < 30000) {
                Logger.d(TAG, "cutPCMData 歌曲时长小于30S，不适用音频指纹");
                Logger.i("MatchManager.Finger", "[cutPCMData] too short");
                z2 = false;
            }
            int i4 = i * 1000;
            int i5 = i2 * 1000;
            if (z2) {
                int sampleRate = (int) ((((long) ((i5 - i4) / 1000)) * this.mAudioCut.information.getSampleRate()) * ((long) this.mAudioCut.information.getChannels()));
                short[] sArr = new short[this.mAudioCut.bufferSize];
                if (this.mDecoder instanceof ApeDecoder) {
                    ((ApeDecoder) this.mDecoder).nSeekToExactly(i4 / 1000);
                } else {
                    this.mDecoder.seekTo(i4);
                }
                int i6 = 0;
                file = new File(str);
                try {
                    waveWriter3 = new WaveWriter(file, (int) this.mAudioCut.information.getSampleRate(), this.mAudioCut.information.getChannels(), this.mAudioCut.sampleBit);
                    try {
                        waveWriter3.createWaveFile();
                        int i7 = 0;
                        int i8 = sampleRate;
                        sampleRate = -1;
                        while (i7 <= i8 && this.mDecoder.getCurrentTime() < ((long) (i5 + MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN))) {
                            try {
                                int decodeData = this.mDecoder.decodeData(this.mAudioCut.bufferSize * 2, sArr);
                                if (decodeData > 0) {
                                    i6 = decodeData;
                                    if (this.mDecoder.getCurrentTime() <= ((long) ((i4 + i5) / 2)) || sampleRate != -1) {
                                        decodeData = i8;
                                        i8 = sampleRate;
                                    } else {
                                        float currentTime = ((float) (this.mDecoder.getCurrentTime() - ((long) i4))) / 1000.0f;
                                        Logger.d(TAG, "speedtime=" + currentTime + ",size=" + i7);
                                        this.mAudioCut.sampleBit = Math.round((2.0f * ((float) i7)) / ((currentTime * ((float) this.mAudioCut.information.getSampleRate())) * ((float) this.mAudioCut.information.getChannels()))) * 8;
                                        Logger.d(TAG, "sampleBit=" + this.mAudioCut.sampleBit);
                                        if (this.mAudioCut.sampleBit < 8) {
                                            Logger.e(TAG, "sampleBit=" + this.mAudioCut.sampleBit);
                                            if (this.mDecoder != null) {
                                                this.mDecoder.release();
                                                this.mDecoder = null;
                                            }
                                            try {
                                                waveWriter3.closeWaveFile();
                                                if (!z2 && file.exists()) {
                                                    file.delete();
                                                }
                                            } catch (Throwable e2) {
                                                Logger.e(TAG, e2);
                                            }
                                            return false;
                                        }
                                        decodeData = (int) ((((((long) ((i5 - i4) / 1000)) * this.mAudioCut.information.getSampleRate()) * ((long) this.mAudioCut.information.getChannels())) * ((long) this.mAudioCut.sampleBit)) / 16);
                                        waveWriter3.setSampleByte(this.mAudioCut.sampleBit);
                                        i8 = decodeData;
                                    }
                                    sampleRate = (i6 / 2) + i7;
                                    i7 = i6 / 2;
                                    if (i8 != -1 && sampleRate >= i8) {
                                        waveWriter3.write(sArr, 0, i7 - (sampleRate - i8));
                                        break;
                                    }
                                    waveWriter3.write(sArr, 0, i7);
                                    i7 = sampleRate;
                                    sampleRate = i8;
                                    i8 = decodeData;
                                } else {
                                    if (this.mDecoder != null) {
                                        this.mDecoder.release();
                                        this.mDecoder = null;
                                    }
                                    try {
                                        waveWriter3.closeWaveFile();
                                        if (!z2 && file.exists()) {
                                            file.delete();
                                        }
                                    } catch (Throwable e22) {
                                        Logger.e(TAG, e22);
                                    }
                                    return false;
                                }
                            } catch (Throwable e3) {
                                Logger.e(TAG, e3);
                            }
                        }
                        if (z) {
                            reSamplerTo8K = waveWriter3.reSamplerTo8K();
                        } else {
                            reSamplerTo8K = waveWriter3.reSampler();
                        }
                    } catch (Throwable e32) {
                        th = e32;
                        reSamplerTo8K = z2;
                        waveWriter = waveWriter3;
                        file2 = file;
                        e22 = th;
                    } catch (Throwable e322) {
                        th = e322;
                        waveWriter2 = waveWriter3;
                        file2 = file;
                        e22 = th;
                    }
                } catch (Throwable e4) {
                    th = e4;
                    file2 = file;
                    e22 = th;
                    reSamplerTo8K = z2;
                    waveWriter = null;
                    try {
                        Logger.e(TAG, e22);
                        if (this.mDecoder != null) {
                            this.mDecoder.release();
                            this.mDecoder = null;
                        }
                        if (waveWriter != null) {
                            try {
                                waveWriter.closeWaveFile();
                            } catch (Throwable e222) {
                                Logger.e(TAG, e222);
                                return false;
                            }
                        }
                        return file2 == null ? false : false;
                    } catch (Throwable th2) {
                        e222 = th2;
                        WaveWriter waveWriter4 = waveWriter;
                        z2 = reSamplerTo8K;
                        waveWriter2 = waveWriter4;
                        if (this.mDecoder != null) {
                            this.mDecoder.release();
                            this.mDecoder = null;
                        }
                        if (waveWriter2 != null) {
                            try {
                                waveWriter2.closeWaveFile();
                            } catch (Throwable e42) {
                                Logger.e(TAG, e42);
                                throw e222;
                            }
                        }
                        file2.delete();
                        throw e222;
                    }
                } catch (Throwable e422) {
                    th = e422;
                    file2 = file;
                    e222 = th;
                    if (this.mDecoder != null) {
                        this.mDecoder.release();
                        this.mDecoder = null;
                    }
                    if (waveWriter2 != null) {
                        waveWriter2.closeWaveFile();
                    }
                    file2.delete();
                    throw e222;
                }
            }
            file = null;
            waveWriter3 = null;
            reSamplerTo8K = z2;
            if (this.mDecoder != null) {
                this.mDecoder.release();
                this.mDecoder = null;
            }
            if (waveWriter3 != null) {
                try {
                    waveWriter3.closeWaveFile();
                } catch (Throwable e2222) {
                    Logger.e(TAG, e2222);
                    return false;
                }
            }
            if (reSamplerTo8K || file == null || !file.exists()) {
                return reSamplerTo8K;
            }
            file.delete();
            return reSamplerTo8K;
        } catch (Exception e5) {
            e2222 = e5;
            reSamplerTo8K = z2;
            waveWriter = null;
            Logger.e(TAG, e2222);
            if (this.mDecoder != null) {
                this.mDecoder.release();
                this.mDecoder = null;
            }
            if (waveWriter != null) {
                waveWriter.closeWaveFile();
            }
            if (file2 == null) {
            }
        } catch (Throwable th3) {
            e2222 = th3;
            if (this.mDecoder != null) {
                this.mDecoder.release();
                this.mDecoder = null;
            }
            if (waveWriter2 != null) {
                waveWriter2.closeWaveFile();
            }
            file2.delete();
            throw e2222;
        }
    }

    private boolean initDecoder() {
        if (this.mDecoder == null) {
            return false;
        }
        try {
            int init = this.mDecoder.init(this.mFileName, false);
            Logger.i(TAG, "nativeOpen return=" + init);
            if (init != 0) {
                init = this.mDecoder.init(this.mFileName, false);
            }
            if (init == 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            Logger.e(TAG, e);
            return false;
        }
    }

    private boolean getAudioFormation() {
        if (this.mDecoder != null) {
            try {
                this.mAudioCut.information = this.mDecoder.getAudioInformation();
            } catch (Throwable e) {
                Logger.e(TAG, e);
            }
        }
        if (this.mAudioCut.information != null) {
            return true;
        }
        return false;
    }

    private boolean calculateBufferSize() {
        if (this.mDecoder == null) {
            return false;
        }
        int i;
        int minBufferSize = AudioTrack.getMinBufferSize((int) this.mAudioCut.information.getSampleRate(), this.mAudioCut.information.getChannels() == 1 ? 4 : 12, 2);
        try {
            if (this.mDecoder instanceof FLACDecoder) {
                i = ((FLACDecoder) this.mDecoder).getminBufferSize();
                Logger.i(TAG, "decoder_buf_size = " + i + ", playback_buf_size = " + minBufferSize);
                if (AudioType.FLAC.equals(this.mAudioCut.audioType)) {
                    this.mAudioCut.bufferSize = minBufferSize;
                } else {
                    this.mAudioCut.bufferSize = i;
                }
                if (this.mDecoder instanceof FfmpegPlayer) {
                    this.mAudioCut.bufferSize = Math.max(Downloads.RECV_BUFFER_SIZE, minBufferSize);
                }
                return true;
            }
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
        i = 0;
        Logger.i(TAG, "decoder_buf_size = " + i + ", playback_buf_size = " + minBufferSize);
        if (AudioType.FLAC.equals(this.mAudioCut.audioType)) {
            this.mAudioCut.bufferSize = minBufferSize;
        } else {
            this.mAudioCut.bufferSize = i;
        }
        if (this.mDecoder instanceof FfmpegPlayer) {
            this.mAudioCut.bufferSize = Math.max(Downloads.RECV_BUFFER_SIZE, minBufferSize);
        }
        return true;
    }

    private void prepareDecoder() {
        if (this.mFileName == null) {
            throw new NullPointerException("the path is null!");
        }
        this.mAudioCut = new AudioCut(null);
        try {
            this.mAudioCut.audioType = AudioRecognition.recognitionAudioFormatExactly(this.mFileName);
        } catch (Throwable e) {
            Logger.e(TAG, e);
        }
        this.mDecoder = MediaCodecFactory.createDecoderByType(this.mAudioCut.audioType);
    }
}
