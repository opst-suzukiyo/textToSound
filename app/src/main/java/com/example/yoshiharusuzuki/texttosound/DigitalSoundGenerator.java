package com.example.yoshiharusuzuki.texttosound;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DigitalSoundGenerator {

    //音階を確保
    public static final double FREQ_C  = 523.251131;
    public static final double FREQ_D  = 587.329536;
    public static final double FREQ_E  = 659.255114;
    public static final double FREQ_F  = 698.456463;
    public static final double FREQ_G  = 783.990872;
    public static final double FREQ_A  = 880.000000;
    public static final double FREQ_B  = 987.766602;
    public static final double FREQ_H  = 1046.502262;

    private static final Map<String, Double> FREQ_MAP;
    static {
        Map<String, Double> freq_map = new HashMap<>();
            freq_map.put("C", FREQ_C);
            freq_map.put("D", FREQ_D);
            freq_map.put("E", FREQ_E);
            freq_map.put("F", FREQ_F);
            freq_map.put("G", FREQ_G);
            freq_map.put("A", FREQ_A);
            freq_map.put("B", FREQ_B);
            freq_map.put("H", FREQ_H);
        FREQ_MAP = Collections.unmodifiableMap(freq_map);
    }

    private AudioTrack audioTrack;

    protected static final double SOUNDLENGTH = 0.25;
    protected static final int    SAMPLERATE  = 44100; // [Hz]
    protected static final int    CHANNEL     = 1;     // 1:MONO, 2:STEREO
    protected static final int    BITRATE     = 16;    // [bit/sec]

    /**
     * コンストラクタ
     */
    public DigitalSoundGenerator() {

        int bufferSize = (int)(SOUNDLENGTH * SAMPLERATE) * CHANNEL * BITRATE / 8;

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
     * @param text 文字列
     * @return 音声データ
     */
    public short[] getSound(String text) {
        int SAMPLES = (int) (SOUNDLENGTH * 44100);

        short[] buffer = new short[ SAMPLES * CHANNEL ];
        String[] textArray = text.split(",", 0);
        double[] signalArray = new double[textArray.length];

        for (int i = 0; i < SAMPLES; i++) {

            double signal = 0;

            for(int j=0; j<signalArray.length; j++) {
                signalArray[j] = generateSignal(i, FREQ_MAP.get(textArray[j]));
                signal += signalArray[j];
            }
            buffer[i] = (short)( signal * Short.MAX_VALUE );
        }
        return buffer;
    }

    public double generateSignal(int sample, double frequency){
        double t = (double)(sample) / SAMPLERATE;
        // y = a * sin (2PI * f * t), t = i/fs, 0 <= i < TotalSamples
        return SOUNDLENGTH * Math.sin(2.0 * Math.PI * frequency * t);
    }

    /**
     *
     * @return
     */
    public AudioTrack getAudioTrack() {
        return this.audioTrack;
    }
}