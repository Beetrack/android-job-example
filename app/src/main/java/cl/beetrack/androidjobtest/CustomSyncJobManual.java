package cl.beetrack.androidjobtest;

import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by danielsantamaria on 10/2/17.
 */

public class CustomSyncJobManual extends Job {

  public static final String TAG = "CustomSyncJobManual";
  private static final SimpleDateFormat DISPLAY_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  @NonNull
  @Override
  protected Result onRunJob(Params params) {
    LogUtils.append(getContext(), "Manual Job at " + DISPLAY_FORMAT.format(new Date()));
    return Result.SUCCESS;
  }

  public static void scheduleJob() {
    new JobRequest.Builder(TAG)
        .setExact(1000)
        .build()
        .schedule();
  }

}
