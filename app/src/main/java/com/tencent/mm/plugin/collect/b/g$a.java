package com.tencent.mm.plugin.collect.b;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.x;

class g$a {
    public static MediaPlayer a(Context context, int i, OnCompletionListener onCompletionListener, OnErrorListener onErrorListener) {
        Throwable e;
        AssetFileDescriptor assetFileDescriptor;
        Throwable e2;
        if (context == null) {
            x.e("MicroMsg.F2fRcvVoiceListener", "play Err context:%s pathId:%d", new Object[]{context, Integer.valueOf(i)});
            return null;
        }
        String string = context.getString(i);
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        x.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s context:%s pathId:%d", new Object[]{Integer.valueOf(mediaPlayer.hashCode()), string, context, Integer.valueOf(i)});
        AssetFileDescriptor openFd;
        try {
            openFd = context.getAssets().openFd(string);
            try {
                mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                mediaPlayer.setLooping(false);
                mediaPlayer.setOnErrorListener(new 1(mediaPlayer, onErrorListener));
                mediaPlayer.setOnCompletionListener(new 2(string, mediaPlayer, onCompletionListener));
                mediaPlayer.prepare();
                mediaPlayer.start();
                String str = "MicroMsg.F2fRcvVoiceListener";
                String str2 = "play start mp finish [%d], myLooper[%b] mainLooper[%b]";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
                objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                x.i(str, str2, objArr);
                if (openFd == null) {
                    return mediaPlayer;
                }
                try {
                    openFd.close();
                    return mediaPlayer;
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e3, "", new Object[0]);
                    return mediaPlayer;
                }
            } catch (Exception e4) {
                e3 = e4;
                assetFileDescriptor = openFd;
                try {
                    x.e("MicroMsg.F2fRcvVoiceListener", "play failed pathId:%d e:%s", new Object[]{Integer.valueOf(i), e3.getMessage()});
                    x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e3, "", new Object[0]);
                    mediaPlayer.release();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e22, "", new Object[0]);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e22 = th;
                    openFd = assetFileDescriptor;
                    if (openFd != null) {
                        try {
                            openFd.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                if (openFd != null) {
                    openFd.close();
                }
                throw e22;
            }
        } catch (Exception e5) {
            e32 = e5;
            assetFileDescriptor = null;
            x.e("MicroMsg.F2fRcvVoiceListener", "play failed pathId:%d e:%s", new Object[]{Integer.valueOf(i), e32.getMessage()});
            x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e32, "", new Object[0]);
            mediaPlayer.release();
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
            return null;
        } catch (Throwable th3) {
            e22 = th3;
            openFd = null;
            if (openFd != null) {
                openFd.close();
            }
            throw e22;
        }
    }

    public static MediaPlayer a(String str, OnCompletionListener onCompletionListener, OnErrorListener onErrorListener) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        x.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", new Object[]{Integer.valueOf(mediaPlayer.hashCode()), str});
        try {
            mediaPlayer.setDataSource(str);
            mediaPlayer.setLooping(false);
            mediaPlayer.setOnErrorListener(new 3(mediaPlayer, onErrorListener));
            mediaPlayer.setOnCompletionListener(new 4(str, mediaPlayer, onCompletionListener));
            mediaPlayer.prepare();
            mediaPlayer.start();
            String str2 = "MicroMsg.F2fRcvVoiceListener";
            String str3 = "play start mp finish [%d], myLooper[%b] mainLooper[%b]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
            objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
            objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
            x.i(str2, str3, objArr);
            return mediaPlayer;
        } catch (Throwable e) {
            x.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", new Object[]{str, e.getMessage()});
            x.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e, "", new Object[0]);
            mediaPlayer.release();
            return null;
        }
    }
}
