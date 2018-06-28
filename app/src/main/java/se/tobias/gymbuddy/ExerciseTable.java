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
        firstSetPercentageOf1RM = findViewById(R.id.firstSetPercentageOfOneRepMax);
        secondSetTotalRepetitions = findViewById(R.id.secondSetTotalRepetitions);
        secondSetTotalWeight = findViewById(R.id.secondSetTotalWeight);
        secondSetPercentageOf1RM = findViewById(R.id.secondSetPercentageOfOneRepMax);
        thirdSetTotalRepetitions = findViewById(R.id.thirdSetTotalRepetitions);
        thirdSetTotalWeight = findViewById(R.id.thirdSetTotalWeight);
        thirdSetPercentageOf1RM = findViewById(R.id.thirdSetPercentageOfOneRepMax);
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

        setValuesBasedOnTrainingDay();
    }

    private void setValuesBasedOnTrainingDay() {
        exerciseHeader.setText("Squats");
        firstSetTotalRepetitions.setText("1 x 5");
        firstSetTotalWeight.setText("80kg");
        firstSetPercentageOf1RM.setText("(50%)");

        secondSetTotalRepetitions.setText("1 x 5");
        secondSetTotalWeight.setText("90kg");
        secondSetPercentageOf1RM.setText("(60%)");

        thirdSetTotalRepetitions.setText("1 x 5+");
        thirdSetTotalWeight.setText("100kg");
        thirdSetPercentageOf1RM.setText("(70%)");

        firstFslWeight.setText("40kg");
        firstFslPercentage.setText("(40%)");

        secondFslWeight.setText("40kg");
        secondFslPercentage.setText("(40%)");

        thirdFslWeight.setText("40kg");
        thirdFslPercentage.setText("(40%)");

        fourthFslWeight.setText("40kg");
        fourthFslPercentage.setText("(40%)");

        fifthFslWeight.setText("40kg");
        fifthFslPercentage.setText("(40%)");
    }
}
