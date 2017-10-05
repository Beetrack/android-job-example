package cl.beetrack.androidjobtest;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

/**
 * Created by danielsantamaria on 10/2/17.
 */

public class CustomJobCreator implements JobCreator {

  @Override
  public Job create(String tag) {
    switch (tag) {
      case CustomSyncJobPeriodic.TAG:
        return new CustomSyncJobPeriodic();
      case CustomSyncJobManual.TAG:
        return new CustomSyncJobManual();
      default:
        return null;
    }
  }

}
