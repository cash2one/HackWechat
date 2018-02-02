package com.tencent.mm.d;

public enum a {
    DEFAULT(0),
    DOODLE(2),
    MOSAIC(1),
    EMOJI_AND_TEXT(3),
    CROP_PHOTO(Integer.MAX_VALUE),
    CROP_VIDEO(Integer.MAX_VALUE);
    
    public int value;

    private a(int i) {
        this.value = i;
    }
}
