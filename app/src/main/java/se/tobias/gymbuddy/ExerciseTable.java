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
        double tempSetWeight;
        String tempSetWeightAsString;
        String tempSetWeightAsStringWithWeightSuffix;
        int remainder;

        firstSetTotalRepetitions.setText(_context.getString(R.string.one_by_five));
        firstSetPercentageOf1RM.setText(R.string.percent_65);
        tempSetWeight = exerciseTrainingMax * 0.65f;
        tempSetWeight = tempSetWeight / 1.25;
        remainder = (int)(tempSetWeight + 0.5);
        tempSetWeight = remainder * 1.25;
        tempSetWeightAsString = String.valueOf(tempSetWeight);
        tempSetWeightAsStringWithWeightSuffix = tempSetWeightAsString + _context.getString(R.string.kg);
        firstSetTotalWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        firstFslPercentage.setText(R.string.percent_65);
        firstFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        secondFslPercentage.setText(R.string.percent_65);
        secondFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        thirdFslPercentage.setText(R.string.percent_65);
        thirdFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        fourthFslPercentage.setText(R.string.percent_65);
        fourthFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        fifthFslPercentage.setText(R.string.percent_65);
        fifthFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        secondSetTotalRepetitions.setText(_context.getString(R.string.one_by_five));
        secondSetPercentageOf1RM.setText(R.string.percent_75);
        tempSetWeight = exerciseTrainingMax * 0.75f;
        tempSetWeight = tempSetWeight / 1.25;
        remainder = (int)(tempSetWeight + 0.5);
        tempSetWeight = remainder * 1.25;
        tempSetWeightAsString = String.valueOf(tempSetWeight);
        tempSetWeightAsStringWithWeightSuffix = tempSetWeightAsString + _context.getString(R.string.kg);
        secondSetTotalWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        thirdSetTotalRepetitions.setText(_context.getString(R.string.one_by_five_plus));
        thirdSetPercentageOf1RM.setText(R.string.percent_85);
        tempSetWeight = exerciseTrainingMax * 0.85f;
        tempSetWeight = tempSetWeight / 1.25;
        remainder = (int)(tempSetWeight + 0.5);
        tempSetWeight = remainder * 1.25;
        tempSetWeightAsString = String.valueOf(tempSetWeight);
        tempSetWeightAsStringWithWeightSuffix = tempSetWeightAsString + _context.getString(R.string.kg);
        thirdSetTotalWeight.setText(tempSetWeightAsStringWithWeightSuffix);
    }

    public void setupDetailsForWeekTwo(double exerciseTrainingMax){
        double tempSetWeight;
        String tempSetWeightAsString;
        String tempSetWeightAsStringWithWeightSuffix;
        int remainder;

        firstSetTotalRepetitions.setText(_context.getString(R.string.one_by_three));
        firstSetPercentageOf1RM.setText(R.string.percent_70);
        tempSetWeight = exerciseTrainingMax * 0.7f;
        tempSetWeight = tempSetWeight / 1.25;
        remainder = (int)(tempSetWeight + 0.5);
        tempSetWeight = remainder * 1.25;
        tempSetWeightAsString = String.valueOf(tempSetWeight);
        tempSetWeightAsStringWithWeightSuffix = tempSetWeightAsString + _context.getString(R.string.kg);
        firstSetTotalWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        firstFslPercentage.setText(R.string.percent_70);
        firstFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        secondFslPercentage.setText(R.string.percent_70);
        secondFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        thirdFslPercentage.setText(R.string.percent_70);
        thirdFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        fourthFslPercentage.setText(R.string.percent_70);
        fourthFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        fifthFslPercentage.setText(R.string.percent_70);
        fifthFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        secondSetTotalRepetitions.setText(_context.getString(R.string.one_by_three));
        secondSetPercentageOf1RM.setText(R.string.percent_80);
        tempSetWeight = exerciseTrainingMax * 0.8f;
        tempSetWeight = tempSetWeight / 1.25;
        remainder = (int)(tempSetWeight + 0.5);
        tempSetWeight = remainder * 1.25;
        tempSetWeightAsString = String.valueOf(tempSetWeight);
        tempSetWeightAsStringWithWeightSuffix = tempSetWeightAsString + _context.getString(R.string.kg);
        secondSetTotalWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        thirdSetTotalRepetitions.setText(_context.getString(R.string.one_by_three_plus));
        thirdSetPercentageOf1RM.setText(R.string.percent_90);
        tempSetWeight = exerciseTrainingMax * 0.9f;
        tempSetWeight = tempSetWeight / 1.25;
        remainder = (int)(tempSetWeight + 0.5);
        tempSetWeight = remainder * 1.25;
        tempSetWeightAsString = String.valueOf(tempSetWeight);
        tempSetWeightAsStringWithWeightSuffix = tempSetWeightAsString + _context.getString(R.string.kg);
        thirdSetTotalWeight.setText(tempSetWeightAsStringWithWeightSuffix);
    }

    public void setupDetailsForWeekThree(double exerciseTrainingMax){
        double tempSetWeight;
        String tempSetWeightAsString;
        String tempSetWeightAsStringWithWeightSuffix;
        int remainder;

        firstSetTotalRepetitions.setText(_context.getString(R.string.one_by_five));
        firstSetPercentageOf1RM.setText(R.string.percent_75);
        tempSetWeight = exerciseTrainingMax * 0.75f;
        tempSetWeight = tempSetWeight / 1.25;
        remainder = (int)(tempSetWeight + 0.5);
        tempSetWeight = remainder * 1.25;
        tempSetWeightAsString = String.valueOf(tempSetWeight);
        tempSetWeightAsStringWithWeightSuffix = tempSetWeightAsString + _context.getString(R.string.kg);
        firstSetTotalWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        firstFslPercentage.setText(R.string.percent_75);
        firstFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        secondFslPercentage.setText(R.string.percent_75);
        secondFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        thirdFslPercentage.setText(R.string.percent_75);
        thirdFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        fourthFslPercentage.setText(R.string.percent_75);
        fourthFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        fifthFslPercentage.setText(R.string.percent_75);
        fifthFslWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        secondSetTotalRepetitions.setText(_context.getString(R.string.one_by_three));
        secondSetPercentageOf1RM.setText(R.string.percent_85);
        tempSetWeight = exerciseTrainingMax * 0.85f;
        tempSetWeight = tempSetWeight / 1.25;
        remainder = (int)(tempSetWeight + 0.5);
        tempSetWeight = remainder * 1.25;
        tempSetWeightAsString = String.valueOf(tempSetWeight);
        tempSetWeightAsStringWithWeightSuffix = tempSetWeightAsString + _context.getString(R.string.kg);
        secondSetTotalWeight.setText(tempSetWeightAsStringWithWeightSuffix);

        thirdSetTotalRepetitions.setText(_context.getString(R.string.one_by_one_plus));
        thirdSetPercentageOf1RM.setText(R.string.percent_95);
        tempSetWeight = exerciseTrainingMax * 0.95f;
        tempSetWeight = tempSetWeight / 1.25;
        remainder = (int)(tempSetWeight + 0.5);
        tempSetWeight = remainder * 1.25;
        tempSetWeightAsString = String.valueOf(tempSetWeight);
        tempSetWeightAsStringWithWeightSuffix = tempSetWeightAsString + _context.getString(R.string.kg);
        thirdSetTotalWeight.setText(tempSetWeightAsStringWithWeightSuffix);
    }

    public void setExerciseHeader(String exerciseName) {
        exerciseHeader.setText(exerciseName);
    }
}
