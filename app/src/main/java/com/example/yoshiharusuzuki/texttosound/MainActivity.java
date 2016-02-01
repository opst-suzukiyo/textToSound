package com.example.yoshiharusuzuki.texttosound;

import android.app.Activity;
import android.media.AudioTrack;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.yoshiharusuzuki.texttosound.common.SoundSetting;
import com.example.yoshiharusuzuki.texttosound.sound.SoundDto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements Runnable {

    // Sound生成クラス
    private DigitalSoundGenerator soundGenerator;
    // Sound再生クラス
    private AudioTrack audioTrack;

    // 譜面データ
    private List<SoundDto> soundList = new ArrayList<>();

    /**
     * 譜面データを作成
     */
    private void initScoreData(String text) {

        for (int i = 0; i < text.length(); i++) {
            soundList.add(new SoundDto(generateSound(soundGenerator, SoundSetting.getCharIndex().get(text.charAt(i)))));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SoundGeneratorクラスを作成
        soundGenerator = new DigitalSoundGenerator();

        // 再生用AudioTrackは、同じサンプルレートで初期化したものを利用する
        audioTrack = soundGenerator.getAudioTrack();

        findViewById(R.id.startMelody).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText editText = (EditText) findViewById(R.id.editText);
                String text = editText.getText().toString();

                initScoreData(text);

                Thread th = new Thread(MainActivity.this);
                th.start();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 再生中だったら停止してリリース
        if (audioTrack.getPlayState() == AudioTrack.PLAYSTATE_PLAYING) {
            audioTrack.stop();
            audioTrack.release();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * @param gen  Generator
     * @param text 入力文字
     * @return 音データ
     */
    public short[] generateSound(DigitalSoundGenerator gen, String text) {

        return gen.getSound(text);
    }

    @Override
    public void run() {

        // 再生中なら一旦止める
        if (audioTrack.getPlayState() == AudioTrack.PLAYSTATE_PLAYING) {
            audioTrack.stop();
            audioTrack.reloadStaticData();
        }
        // 再生開始
        audioTrack.play();

        // スコアデータを書き込む
        for (SoundDto dto : soundList) {
            audioTrack.write(dto.getSound(), 0, dto.getSound().length);
        }
        // 再生停止
        audioTrack.stop();
        soundList = new ArrayList<>();
    }
}


