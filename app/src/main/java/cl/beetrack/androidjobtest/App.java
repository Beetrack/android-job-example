package cl.beetrack.androidjobtest;

import android.app.Application;

import com.evernote.android.job.JobManager;

/**
 * Created by danielsantamaria on 10/2/17.
 */

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    JobManager.create(this).addJobCreator(new CustomJobCreator());
  }

}