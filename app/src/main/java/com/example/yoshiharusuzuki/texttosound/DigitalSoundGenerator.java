package com.example.yoshiharusuzuki.texttosound;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

import com.example.yoshiharusuzuki.texttosound.common.SoundSetting;

public class DigitalSoundGenerator {

    private AudioTrack audioTrack;

    protected static final double SOUNDLENGTH = 0.25;
    protected static final int SAMPLERATE = 44100; // [Hz]
    protected static final int CHANNEL = 1;     // 1:MONO, 2:STEREO
    protected static final int BITRATE = 16;    // [bit/sec]

    /**
     * コンストラクタ
     */
    public DigitalSoundGenerator() {

        int bufferSize = (int) (SOUNDLENGTH * SAMPLERATE) * CHANNEL * BITRATE / 8;

        // AudioTrackを作成
        this.audioTrack = new AudioTrack(
                AudioManager.STREAM_MUSIC,  // 音楽ストリームを設定
                SAMPLERATE, // サンプルレート
                AudioFormat.CHANNEL_OUT_MONO,   // モノラル
                AudioFormat.ENCODING_PCM_16BIT,   // オーディオデータフォーマットPCM16とかPCM8とか
                bufferSize, // バッファ・サイズ
                AudioTrack.MODE_STREAM); // Streamモード。データを書きながら再生する
    }

    /**
     * サウンド生成
     *
     * @param text 文字列
     * @return 音声データ
     */
    public short[] getSound(String text) {
        int SAMPLES = (int) (SOUNDLENGTH * 44100);

        short[] buffer = new short[SAMPLES * CHANNEL];
        String[] textArray = text.split(",", 0);
        double[] signalArray = new double[textArray.length];

        for (int i = 0; i < SAMPLES; i++) {

            double signal = 0;

            for (int j = 0; j < signalArray.length; j++) {
                signalArray[j] = generateSignal(i, SoundSetting.getFreqMap().get(textArray[j]));
                signal += signalArray[j];
            }
            buffer[i] = (short) (signal * Short.MAX_VALUE);
        }
        return buffer;
    }

    public double generateSignal(int sample, double frequency) {
        double t = (double) (sample) / SAMPLERATE;
        // y = a * sin (2PI * f * t), t = i/fs, 0 <= i < TotalSamples
        return SOUNDLENGTH * Math.sin(2.0 * Math.PI * frequency * t);
    }

    public AudioTrack getAudioTrack() {
        return this.audioTrack;
    }
}