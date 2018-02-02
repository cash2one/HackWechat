package com.tencent.tinker.loader.shareutil;

public final class ShareOatUtil {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Alt = new int[InstructionSet.values().length];

        static {
            try {
                Alt[InstructionSet.kArm.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Alt[InstructionSet.kThumb2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Alt[InstructionSet.kArm64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Alt[InstructionSet.kX86.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Alt[InstructionSet.kX86_64.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                Alt[InstructionSet.kMips.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                Alt[InstructionSet.kMips64.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                Alt[InstructionSet.kNone.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private enum InstructionSet {
        kNone,
        kArm,
        kArm64,
        kThumb2,
        kX86,
        kX86_64,
        kMips,
        kMips64
    }

    private ShareOatUtil() {
        throw new UnsupportedOperationException();
    }
}
