package coatocl.exaatocl.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;
import androidx.annotation.Nullable;


//this class is for life cycle of service
public class MusicService extends Service
{
    MediaPlayer mp;

    @Nullable
    @Override
//    this on is for bind service method
    public IBinder onBind(Intent intent) {
        return null;
    }

//    create unbind services

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        this will be played user ringtone at background
        mp=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
//        this is for continuous looping.
        mp.setLooping(true);
        mp.start();

//        this for continuos done without destroy,automatic destroy after sometimes,when we want previous intent related data.
//        return START_STICKY; return START_NOT_STICKY; return START_REDELIVER_INTENT;
        return START_NOT_STICKY;
//        we write all set of command which we want to execute at background without load of ui that we write in this command
    }

    @Override
    public void onDestroy() {
//        when service is close then stop playing music.
        mp.stop();
        super.onDestroy();
    }
}
