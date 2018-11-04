package se.tobias.gymbuddy;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExerciseTable extends LinearLayout{
    private Context _context;

    private TextView exerciseHeader;
    private TextView firstSetTotalRepetitions;
    private TextView firstSetTotalWeight;
    private TextView firstSetPercentageOf1RM;
    private TextView secondSetTotalRepetitions;
    private TextView secondSetTotalWeight;
    private TextView secondSetPercentageOf1RM;
    private TextView thirdSetTotalRepetitions;
    private TextView thirdSetTotalWeight;
    private TextView thirdSetPercentageOf1RM;
    private TextView firstFslWeight;
    private TextView firstFslPercentage;
    private TextView secondFslWeight;
    private TextView secondFslPercentage;
    private TextView thirdFslWeight;
    private TextView thirdFslPercentage;
    private TextView fourthFslWeight;
    private TextView fourthFslPercentage;
    private TextView fifthFslWeight;
    private TextView fifthFslPercentage;

    public static final String WEEK_ONE = "Week One";
    public static final String WEEK_TWO = "Week Two";
    public static final String WEEK_THREE = "Week Three";
    public static final String DAY_ONE = "Day One";
    public static final String DAY_TWO = "Day Two";
    public static final String DAY_THREE = "Day Three";
    private static final double FIRST_SET_OF_WEEK_ONE_MULTIPLIER = 0.65;
    private static final double SECOND_SET_OF_WEEK_ONE_MULTIPLIER = 0.75;
    private static final double THIRD_SET_OF_WEEK_ONE_MULTIPLIER = 0.85;
    private static final double FIRST_SET_OF_WEEK_TWO_MULTIPLIER = 0.7;
    private static final double SECOND_SET_OF_WEEK_TWO_MULTIPLIER = 0.8;
    private static final double THIRD_SET_OF_WEEK_TWO_MULTIPLIER = 0.9;
    private static final double FIRST_SET_OF_WEEK_THREE_MULTIPLIER = 0.75;
    private static final double SECOND_SET_OF_WEEK_THREE_MULTIPLIER = 0.85;
    private static final double THIRD_SET_OF_WEEK_THREE_MULTIPLIER = 0.95;


    public ExerciseTable(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        _context = context;

        init();
    }

    private void init() {
        inflate(getContext(), R.layout.exercise_table, this);

        exerciseHeader = findViewById(R.id.exerciseHeader);
        firstSetTotalRepetitions = findViewById(R.id.firstSetTotalRepetitions);
        firstSetTotalWeight = findViewById(R.id.firstSetTotalWeight);
        firstSetPercentageOf1RM = findViewById(R.id.firstSetPercentageOfTrainingMax);
        secondSetTotalRepetitions = findViewById(R.id.secondSetTotalRepetitions);
        secondSetTotalWeight = findViewById(R.id.secondSetTotalWeight);
        secondSetPercentageOf1RM = findViewById(R.id.secondSetPercentageOfTrainingMax);
        thirdSetTotalRepetitions = findViewById(R.id.thirdSetTotalRepetitions);
        thirdSetTotalWeight = findViewById(R.id.thirdSetTotalWeight);
        thirdSetPercentageOf1RM = findViewById(R.id.thirdSetPercentageOfTrainingMax);
        firstFslWeight = findViewById(R.id.firstFslWeight);
        firstFslPercentage = findViewById(R.id.firstFslPercentage);
        secondFslWeight = findViewById(R.id.secondFslWeight);
        secondFslPercentage = findViewById(R.id.secondFslPercentage);
        thirdFslWeight = findViewById(R.id.thirdFslWeight);
        thirdFslPercentage = findViewById(R.id.thirdFslPercentage);
        fourthFslWeight = findViewById(R.id.fourthFslWeight);
        fourthFslPercentage = findViewById(R.id.fourthFslPercentage);
        fifthFslWeight = findViewById(R.id.fifthFslWeight);
        fifthFslPercentage = findViewById(R.id.fifthFslPercentage);
    }

    public void setupDetailsForWeekOne(double exerciseTrainingMax){
        String firstSetWeightAsStringWithSuffix = getSetWeightAsStringWithWeightSuffix(exerciseTrainingMax, FIRST_SET_OF_WEEK_ONE_MULTIPLIER);
        String secondSetWeightAsStringWithSuffix = getSetWeightAsStringWithWeightSuffix(exerciseTrainingMax, SECOND_SET_OF_WEEK_ONE_MULTIPLIER);
        String thirdSetWeightAsStringWithSuffix = getSetWeightAsStringWithWeightSuffix(exerciseTrainingMax, THIRD_SET_OF_WEEK_ONE_MULTIPLIER);

        firstSetTotalRepetitions.setText(R.string.one_by_five);
        firstSetPercentageOf1RM.setText(R.string.percent_65);
        firstSetTotalWeight.setText(firstSetWeightAsStringWithSuffix);

        secondSetTotalRepetitions.setText(_context.getString(R.string.one_by_five));
        secondSetPercentageOf1RM.setText(R.string.percent_75);
        secondSetTotalWeight.setText(secondSetWeightAsStringWithSuffix);

        thirdSetTotalRepetitions.setText(_context.getString(R.string.one_by_five_plus));
        thirdSetPercentageOf1RM.setText(R.string.percent_85);
        thirdSetTotalWeight.setText(thirdSetWeightAsStringWithSuffix);


        firstFslPercentage.setText(R.string.percent_65);
        firstFslWeight.setText(firstSetWeightAsStringWithSuffix);

        secondFslPercentage.setText(R.string.percent_65);
        secondFslWeight.setText(firstSetWeightAsStringWithSuffix);

        thirdFslPercentage.setText(R.string.percent_65);
        thirdFslWeight.setText(firstSetWeightAsStringWithSuffix);

        fourthFslPercentage.setText(R.string.percent_65);
        fourthFslWeight.setText(firstSetWeightAsStringWithSuffix);

        fifthFslPercentage.setText(R.string.percent_65);
        fifthFslWeight.setText(firstSetWeightAsStringWithSuffix);
    }

    public void setupDetailsForWeekTwo(double exerciseTrainingMax){
        String firstSetWeightAsStringWithSuffix = getSetWeightAsStringWithWeightSuffix(exerciseTrainingMax, FIRST_SET_OF_WEEK_TWO_MULTIPLIER);
        String secondSetWeightAsStringWithSuffix = getSetWeightAsStringWithWeightSuffix(exerciseTrainingMax, SECOND_SET_OF_WEEK_TWO_MULTIPLIER);
        String thirdSetWeightAsStringWithSuffix = getSetWeightAsStringWithWeightSuffix(exerciseTrainingMax, THIRD_SET_OF_WEEK_TWO_MULTIPLIER);

        firstSetTotalRepetitions.setText(_context.getString(R.string.one_by_three));
        firstSetPercentageOf1RM.setText(R.string.percent_70);
        firstSetTotalWeight.setText(firstSetWeightAsStringWithSuffix);

        secondSetTotalRepetitions.setText(_context.getString(R.string.one_by_three));
        secondSetPercentageOf1RM.setText(R.string.percent_80);
        secondSetTotalWeight.setText(secondSetWeightAsStringWithSuffix);

        thirdSetTotalRepetitions.setText(_context.getString(R.string.one_by_three_plus));
        thirdSetPercentageOf1RM.setText(R.string.percent_90);
        thirdSetTotalWeight.setText(thirdSetWeightAsStringWithSuffix);

        firstFslPercentage.setText(R.string.percent_70);
        firstFslWeight.setText(firstSetWeightAsStringWithSuffix);

        secondFslPercentage.setText(R.string.percent_70);
        secondFslWeight.setText(firstSetWeightAsStringWithSuffix);

        thirdFslPercentage.setText(R.string.percent_70);
        thirdFslWeight.setText(firstSetWeightAsStringWithSuffix);

        fourthFslPercentage.setText(R.string.percent_70);
        fourthFslWeight.setText(firstSetWeightAsStringWithSuffix);

        fifthFslPercentage.setText(R.string.percent_70);
        fifthFslWeight.setText(firstSetWeightAsStringWithSuffix);
    }

    public void setupDetailsForWeekThree(double exerciseTrainingMax){
        String firstSetWeightAsStringWithSuffix = getSetWeightAsStringWithWeightSuffix(exerciseTrainingMax, FIRST_SET_OF_WEEK_THREE_MULTIPLIER);
        String secondSetWeightAsStringWithSuffix = getSetWeightAsStringWithWeightSuffix(exerciseTrainingMax, SECOND_SET_OF_WEEK_THREE_MULTIPLIER);
        String thirdSetWeightAsStringWithSuffix = getSetWeightAsStringWithWeightSuffix(exerciseTrainingMax, THIRD_SET_OF_WEEK_THREE_MULTIPLIER);

        firstSetTotalRepetitions.setText(_context.getString(R.string.one_by_five));
        firstSetPercentageOf1RM.setText(R.string.percent_75);
        firstSetTotalWeight.setText(firstSetWeightAsStringWithSuffix);

        secondSetTotalRepetitions.setText(_context.getString(R.string.one_by_three));
        secondSetPercentageOf1RM.setText(R.string.percent_85);
        secondSetTotalWeight.setText(secondSetWeightAsStringWithSuffix);

        thirdSetTotalRepetitions.setText(_context.getString(R.string.one_by_one_plus));
        thirdSetPercentageOf1RM.setText(R.string.percent_95);
        thirdSetTotalWeight.setText(thirdSetWeightAsStringWithSuffix);

        firstFslPercentage.setText(R.string.percent_75);
        firstFslWeight.setText(firstSetWeightAsStringWithSuffix);

        secondFslPercentage.setText(R.string.percent_75);
        secondFslWeight.setText(firstSetWeightAsStringWithSuffix);

        thirdFslPercentage.setText(R.string.percent_75);
        thirdFslWeight.setText(firstSetWeightAsStringWithSuffix);

        fourthFslPercentage.setText(R.string.percent_75);
        fourthFslWeight.setText(firstSetWeightAsStringWithSuffix);

        fifthFslPercentage.setText(R.string.percent_75);
        fifthFslWeight.setText(firstSetWeightAsStringWithSuffix);
    }

    private String getSetWeightAsStringWithWeightSuffix(double exerciseTrainingMax, double set){
        double tempSetWeight;
        String tempSetWeightAsString;
        String tempSetWeightAsStringWithWeightSuffix;
        int remainder;

        tempSetWeight = exerciseTrainingMax / 2;
        tempSetWeight = tempSetWeight * set;
        tempSetWeight = tempSetWeight / 1.25d;
        remainder = (int)(tempSetWeight + 0.5);
        tempSetWeight = remainder * 1.25d;
        tempSetWeightAsString = String.valueOf(tempSetWeight);
        tempSetWeightAsStringWithWeightSuffix = tempSetWeightAsString + _context.getString(R.string.kg);

        return tempSetWeightAsStringWithWeightSuffix;
    }

    public void setExerciseHeader(String exerciseName) {
        exerciseHeader.setText(exerciseName);
    }
}
