package com.kp.timeslotbar.TimeSlotWidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kp.timeslotbar.R;


/**
 * Created by Krishnaprasad.n on 2/14/2017.
 */

public class TimeUnit {

    private RelativeLayout mUnit;
    private ImageView mCell;
    private TextView mTime;
    private int mState;
    private int mMinutes;

    public TimeUnit(RelativeLayout unit, int cellId, int timeId, int minutes) {
        if (unit != null && cellId != -1) {
            mUnit = unit;

            mCell = (ImageView) unit.findViewById(cellId);
            mTime = (TextView) unit.findViewById(timeId);

            mState = TimeUnitState.STATE_FREE;
            mMinutes = minutes;
        }
    }

    public void setState(Context context, int state) {
        mState = state;

        switch (state) {
            case TimeUnitState.STATE_DISABLED:
                //mCell.setBackgroundColor((ContextCompat.getColor(context, R.color.colorCellDisabled)));
                mCell.setBackgroundDrawable(getDrawable(context, R.drawable.repeat_img));
                break;
            case TimeUnitState.STATE_FREE:
                //mCell.setBackgroundColor((ContextCompat.getColor(context, R.color.colorCellFree)));
                mCell.setBackgroundDrawable(getDrawable(context, R.drawable.repeat_img));
                break;
            case TimeUnitState.STATE_BOOKED:
                mCell.setBackgroundColor((ContextCompat.getColor(context, R.color.colorCellBooked)));
                break;
            case TimeUnitState.STATE_CLICKED:
                mCell.setBackgroundColor((ContextCompat.getColor(context, R.color.colorCellClicked)));
                break;
            default:
                //mCell.setBackgroundColor((ContextCompat.getColor(context, R.color.colorCellFree)));
                mCell.setBackgroundDrawable(getDrawable(context, R.drawable.repeat_img));
                break;
        }
    }

    public int getState() {
        return mState;
    }

    public String getTime() {
        return mTime.getText().toString();
    }

    public int getId() {
        return mUnit.getId();
    }

    public int getMinutes() {
        return mMinutes;
    }

    public static final Drawable getDrawable(Context context, int id) {
        return ContextCompat.getDrawable(context, id);
    }
}
