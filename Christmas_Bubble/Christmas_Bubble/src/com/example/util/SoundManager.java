package com.example.util;

import com.application.christmasbubble.R;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundManager
{
  private SoundPool soundPool;
  private int[] sm;
  Context context;

  public SoundManager(Context context) {
    this.context = context;
    soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
    sm = new int[FrozenBubble.NUM_SOUNDS];
    sm[FrozenBubble.SOUND_WON] = soundPool.load(context, R.raw.applause, 1);
    sm[FrozenBubble.SOUND_LOST] = soundPool.load(context, R.raw.lose, 1);
    sm[FrozenBubble.SOUND_LAUNCH] = soundPool.load(context, R.raw.launch, 1);
    sm[FrozenBubble.SOUND_DESTROY] =
        soundPool.load(context, R.raw.destroy_group, 1);
    sm[FrozenBubble.SOUND_REBOUND] =
        soundPool.load(context, R.raw.rebound, 1);
    sm[FrozenBubble.SOUND_STICK] = soundPool.load(context, R.raw.stick, 1);
    sm[FrozenBubble.SOUND_HURRY] = soundPool.load(context, R.raw.hurry, 1);
    sm[FrozenBubble.SOUND_NEWROOT] =
        soundPool.load(context, R.raw.newroot_solo, 1);
    sm[FrozenBubble.SOUND_NOH] = soundPool.load(context, R.raw.noh, 1);
  }

  public final void playSound(int sound) {
    if (FrozenBubble.getSoundOn()) {
      AudioManager mgr = (AudioManager)context.getSystemService(
          Context.AUDIO_SERVICE);  
      float streamVolumeCurrent =
          mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
      float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
      float volume = streamVolumeCurrent / streamVolumeMax;
      soundPool.play(sm[sound], volume, volume, 1, 0, 1f);
    }
  }

  public final void cleanUp() {
    sm = null;
    context = null;
    soundPool.release();
    soundPool = null;
  }
}
