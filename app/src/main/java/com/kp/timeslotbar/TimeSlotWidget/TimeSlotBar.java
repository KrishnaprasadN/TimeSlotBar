package com.kp.timeslotbar.TimeSlotWidget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.kp.timeslotbar.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Krishnaprasad.n on 2/13/2017.
 */

public class TimeSlotBar extends LinearLayout implements View.OnClickListener {

    private View mRootView;
    private Context mContext;
    private ArrayList<TimeUnit> mTimeUnitSlots = new ArrayList<>(20); //Contains 20 units from 9:00 to 6:30
    private TimeUnit mStartUnit = null;
    private TimeUnit mEndUnit = null;

    private ArrayList<TimeUnit> mBookedSlots = new ArrayList<>();
    private ArrayList<TimeUnit> mClickedSlots = new ArrayList<>();

    public static final int START_MINUTES = 540;
    public static final int END_MINUTES = 1110;

    public TimeSlotBar(Context context) {
        super(context);
        init(context);
    }

    public TimeSlotBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mRootView = inflate(context, R.layout.timeslotbar, this);

        RelativeLayout unitOne = (RelativeLayout) mRootView.findViewById(R.id.unit_one);
        RelativeLayout unitTwo = (RelativeLayout) mRootView.findViewById(R.id.unit_two);
        RelativeLayout unitThree = (RelativeLayout) mRootView.findViewById(R.id.unit_three);
        RelativeLayout unitFour = (RelativeLayout) mRootView.findViewById(R.id.unit_four);
        RelativeLayout unitFive = (RelativeLayout) mRootView.findViewById(R.id.unit_five);
        RelativeLayout unitSix = (RelativeLayout) mRootView.findViewById(R.id.unit_six);
        RelativeLayout unitSeven = (RelativeLayout) mRootView.findViewById(R.id.unit_seven);
        RelativeLayout unitEight = (RelativeLayout) mRootView.findViewById(R.id.unit_eight);
        RelativeLayout unitNine = (RelativeLayout) mRootView.findViewById(R.id.unit_nine);
        RelativeLayout unitTen = (RelativeLayout) mRootView.findViewById(R.id.unit_ten);
        RelativeLayout unitEleven = (RelativeLayout) mRootView.findViewById(R.id.unit_eleven);
        RelativeLayout unitTwelve = (RelativeLayout) mRootView.findViewById(R.id.unit_twelve);
        RelativeLayout unitThirteen = (RelativeLayout) mRootView.findViewById(R.id.unit_thirteen);
        RelativeLayout unitFourteen = (RelativeLayout) mRootView.findViewById(R.id.unit_fourteen);
        RelativeLayout unitFifteen = (RelativeLayout) mRootView.findViewById(R.id.unit_fifteen);
        RelativeLayout unitSixteen = (RelativeLayout) mRootView.findViewById(R.id.unit_sixteen);
        RelativeLayout unitSeventeen = (RelativeLayout) mRootView.findViewById(R.id.unit_seventeen);
        RelativeLayout unitEighteen = (RelativeLayout) mRootView.findViewById(R.id.unit_eighteen);
        RelativeLayout unitNineteen = (RelativeLayout) mRootView.findViewById(R.id.unit_nineteen);
        RelativeLayout unitTwenty = (RelativeLayout) mRootView.findViewById(R.id.unit_twenty);

        unitOne.setOnClickListener(this);
        unitTwo.setOnClickListener(this);
        unitThree.setOnClickListener(this);
        unitFour.setOnClickListener(this);
        unitFive.setOnClickListener(this);
        unitSix.setOnClickListener(this);
        unitSeven.setOnClickListener(this);
        unitEight.setOnClickListener(this);
        unitNine.setOnClickListener(this);
        unitTen.setOnClickListener(this);
        unitEleven.setOnClickListener(this);
        unitTwelve.setOnClickListener(this);
        unitThirteen.setOnClickListener(this);
        unitFourteen.setOnClickListener(this);
        unitFifteen.setOnClickListener(this);
        unitSixteen.setOnClickListener(this);
        unitSeventeen.setOnClickListener(this);
        unitEighteen.setOnClickListener(this);
        unitNineteen.setOnClickListener(this);
        unitTwenty.setOnClickListener(this);

        mTimeUnitSlots.add(new TimeUnit(unitOne, R.id.cell_one, R.id.nine, 540)); // 9*60 = 540
        mTimeUnitSlots.add(new TimeUnit(unitTwo, R.id.cell_two, R.id.nine_1, 570));
        mTimeUnitSlots.add(new TimeUnit(unitThree, R.id.cell_three, R.id.ten, 600)); // 10*60 = 540
        mTimeUnitSlots.add(new TimeUnit(unitFour, R.id.cell_four, R.id.ten_1, 630));

        mTimeUnitSlots.add(new TimeUnit(unitFive, R.id.cell_five, R.id.eleven, 660));
        mTimeUnitSlots.add(new TimeUnit(unitSix, R.id.cell_six, R.id.eleven_1, 690));
        mTimeUnitSlots.add(new TimeUnit(unitSeven, R.id.cell_seven, R.id.twelve, 720));
        mTimeUnitSlots.add(new TimeUnit(unitEight, R.id.cell_eight, R.id.twelve_1, 750));

        mTimeUnitSlots.add(new TimeUnit(unitNine, R.id.cell_nine, R.id.thirteen, 780));
        mTimeUnitSlots.add(new TimeUnit(unitTen, R.id.cell_ten, R.id.thirteen_1, 810));
        mTimeUnitSlots.add(new TimeUnit(unitEleven, R.id.cell_eleven, R.id.fourteen, 840));
        mTimeUnitSlots.add(new TimeUnit(unitTwelve, R.id.cell_twelve, R.id.fourteen_1, 870));

        mTimeUnitSlots.add(new TimeUnit(unitThirteen, R.id.cell_thirteen, R.id.fifteen, 900));
        mTimeUnitSlots.add(new TimeUnit(unitFourteen, R.id.cell_fourteen, R.id.fifteen_1, 930));
        mTimeUnitSlots.add(new TimeUnit(unitFifteen, R.id.cell_fifteen, R.id.sixteen, 960));
        mTimeUnitSlots.add(new TimeUnit(unitSixteen, R.id.cell_sixteen, R.id.sixteen_1, 990));

        mTimeUnitSlots.add(new TimeUnit(unitSeventeen, R.id.cell_seventeen, R.id.seventeen, 1020));
        mTimeUnitSlots.add(new TimeUnit(unitEighteen, R.id.cell_eighteen, R.id.seventeen_1, 1050));
        mTimeUnitSlots.add(new TimeUnit(unitNineteen, R.id.cell_nineteen, R.id.eighteen, 1080)); // 18*60 = 540
        mTimeUnitSlots.add(new TimeUnit(unitTwenty, R.id.cell_twenty, R.id.eighteen_1, 1110));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        handleClick(id);
    }

    private TimeUnit getTimeUnit(int id) {
        for (TimeUnit unit: mTimeUnitSlots) {
            if (unit.getId() == id) {
                return unit;
            }
        }
        return null;
    }

    private void handleClick(int id) {
        TimeUnit unit = getTimeUnit(id);

        if (unit != null) {

            int state = unit.getState();

            switch (state) {
                case TimeUnitState.STATE_DISABLED:
                    //Do nothing
                    break;
                case TimeUnitState.STATE_FREE:
                    if (mStartUnit == null) {
                        mStartUnit = unit;
                        mClickedSlots.add(unit);
                    } else {
                        // If the slots between start and end are booked, mark all the clicked slot as free
                        // then set this as startUnit
                        // else set this as end unit
                        if (isSlotBooked(mStartUnit, unit)) {
                            for (TimeUnit clickedUnit: mClickedSlots) {
                                clickedUnit.setState(mContext, TimeUnitState.STATE_FREE);
                            }
                            mClickedSlots.clear();

                            mStartUnit = unit;
                        } else {
                            // mark in between units as clicked
                           // markInbetweenUnitsAsClicked(mStartUnit, unit);
                            mEndUnit = unit;
                        }

                        mClickedSlots.add(unit);
                    }

                    unit.setState(mContext, TimeUnitState.STATE_CLICKED);
                    break;
                case TimeUnitState.STATE_BOOKED:
                    //Do nothing
                    break;
                case TimeUnitState.STATE_CLICKED:
                    unit.setState(mContext, TimeUnitState.STATE_FREE);
                    mClickedSlots.remove(unit);
                    break;
            }
        }
    }

    public void setBooking(String start, String end) {

        // convert time to unit and set the state as booked
        //TODO: Need a map to identify unit based on time
        start = start.replace("/Date(", "");
        start = start.replace("+0530)/", "");

        end = end.replace("/Date(", "");
        end = end.replace("+0530)/", "");

        int startMinutes = getMinutes(Long.parseLong(start));
        int endMinutes = getMinutes(Long.parseLong(end));

        Log.d("KP", "***** startMinutes - " + startMinutes + ", endMinutes = " + endMinutes);

        if (startMinutes <= END_MINUTES) {
            // mark start cell
            markCell(startMinutes);
            // mark end cell
            markEndCell(endMinutes);
            // mark in between cell
            markInbetweenCells(startMinutes, endMinutes);
        }
    }

    public String getBookingTimeSlot() {
        return null;
    }

    private int getMinutes(long mills) {
        int minutes = 0;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mills);
        Date date = calendar.getTime();
        int hour = date.getHours();
        minutes = date.getMinutes();

        Log.d("Kp", "***** minutes");
        return hour * 60 + minutes;
    }

    private void markCell(int minutes) {
        if (mTimeUnitSlots != null) {
            for (TimeUnit unit: mTimeUnitSlots) {
                int unitMinutes = unit.getMinutes();

                if (minutes >= unitMinutes && minutes <= unitMinutes + 29) {
                    //mark it
                    unit.setState(mContext, TimeUnitState.STATE_BOOKED);
                    mBookedSlots.add(unit);

                    break;
                }
            }
        }
    }

    private void markEndCell(int minutes) {
        if (mTimeUnitSlots != null) {
            for (TimeUnit unit: mTimeUnitSlots) {
                int unitMinutes = unit.getMinutes();

                if (minutes > unitMinutes && minutes <= unitMinutes + 30) {
                    //mark it
                    unit.setState(mContext, TimeUnitState.STATE_BOOKED);
                    mBookedSlots.add(unit);

                    break;
                }
            }
        }
    }

    private void markInbetweenCells(int startMinutes, int endMinutes) {
        if (mTimeUnitSlots != null) {
            for (TimeUnit unit: mTimeUnitSlots) {
                int unitMinutes = unit.getMinutes();
                if (unitMinutes > startMinutes && unitMinutes < endMinutes) {
                    unit.setState(mContext, TimeUnitState.STATE_BOOKED);
                    mBookedSlots.add(unit);
                }
            }
        }
    }

    private boolean isSlotBooked(TimeUnit startUnit, TimeUnit endUnit) {
        boolean booked = false;
        int startMinutes = startUnit.getMinutes();
        int endMinutes = endUnit.getMinutes();

        //incase of the start minutes is more than end minute, just swap it
        if (startMinutes > endMinutes) {
            int temp = endMinutes;
            endMinutes = startMinutes;
            startMinutes = temp;
        }


        for (TimeUnit bookedUnit: mBookedSlots) {
            if (bookedUnit.getMinutes() > startMinutes && bookedUnit.getMinutes() <= endMinutes) {
                return true;
            }
        }

        return booked;
    }

    public int getStartTime()   {

        /*if (mStartUnit != null) {
            return mStartUnit.getMinutes();
        } else {
            return  0;
        }*/

        int min = 0;
        for (TimeUnit slot: mClickedSlots) {
            if (min == 0) {
                min = slot.getMinutes();
            }

            if (min > slot.getMinutes()) {
                min = slot.getMinutes();
            }
        }

        return min;
    }

    public int getEndTime() {
        /*if (mEndUnit != null) {
            return mEndUnit.getMinutes();
        } else {
            return 0;
        }*/

        int min = 0;
        for (TimeUnit slot: mClickedSlots) {
            if (min == 0) {
                min = slot.getMinutes();
            }

            if (min < slot.getMinutes()) {
                min = slot.getMinutes();
            }
        }

        return min + 30;
    }

    /*private void markInbetweenUnitsAsClicked(TimeUnit startUnit, TimeUnit endUnit) {
        int startMinutes = startUnit.getMinutes();
        int endMinutes = endUnit.getMinutes();

        if (startMinutes > endMinutes) {
            int temp = endMinutes;
            endMinutes = startMinutes;
            startMinutes = temp;
        }

        for (TimeUnit unitSlot: mTimeUnitSlots) {

            if (unitSlot.getMinutes() > startMinutes && unitSlot.getMinutes() <= endMinutes ) {
                unitSlot.setState(mContext, TimeUnitState.STATE_CLICKED);
            }

        }
    }*/

    public void clearAllEvent(Context context) {
        clearClickedEvents(context);
        clearBookedEvents(context);

        mTimeUnitSlots.clear();
        init(context);
    }

    public void clearClickedEvents(Context context) {
        for (TimeUnit slot: mClickedSlots) {
            slot.setState(context, TimeUnitState.STATE_FREE);
        }

        mClickedSlots.clear();
    }

    public void clearBookedEvents(Context context) {
        for (TimeUnit slot: mBookedSlots) {
            slot.setState(context, TimeUnitState.STATE_FREE);
        }

        mBookedSlots.clear();
    }
}
