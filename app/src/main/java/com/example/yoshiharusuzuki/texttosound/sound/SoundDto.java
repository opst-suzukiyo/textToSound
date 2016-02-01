package com.example.yoshiharusuzuki.texttosound.sound;

public class SoundDto {

    // 音声データ
    private short[] sound;

    /**
     * 引数付きコンストラクタ
     */
    public SoundDto(short[] source) {
        this.sound = source;
    }

    public short[] getSound() {
        return sound;
    }
}
