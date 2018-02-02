package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoTransPara implements Parcelable {
    public static final Creator<VideoTransPara> CREATOR = new Creator<VideoTransPara>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VideoTransPara(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VideoTransPara[i];
        }
    };
    public int audioSampleRate;
    public int duration;
    public int fps;
    public int height;
    public int huc;
    public int hud;
    public int hue;
    public int huf;
    public int hup = 0;
    public boolean isDefault;
    public int videoBitrate;
    public int width;

    protected VideoTransPara(Parcel parcel) {
        boolean z = false;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.fps = parcel.readInt();
        this.videoBitrate = parcel.readInt();
        this.duration = parcel.readInt();
        this.hud = parcel.readInt();
        this.huc = parcel.readInt();
        this.audioSampleRate = parcel.readInt();
        this.hue = parcel.readInt();
        this.huf = parcel.readInt();
        if (parcel.readInt() > 0) {
            z = true;
        }
        this.isDefault = z;
        this.hup = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.fps);
        parcel.writeInt(this.videoBitrate);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.hud);
        parcel.writeInt(this.huc);
        parcel.writeInt(this.audioSampleRate);
        parcel.writeInt(this.hue);
        parcel.writeInt(this.huf);
        parcel.writeInt(this.isDefault ? 1 : 0);
        parcel.writeInt(this.hup);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[isDefault " + this.isDefault + "width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.hud + " audio bitrate " + this.huc + " audioSampleRate " + this.audioSampleRate + " duration " + this.duration + " profile index " + this.hue + " preset index " + this.huf + " thumbSize " + this.hup + "]";
    }
}
