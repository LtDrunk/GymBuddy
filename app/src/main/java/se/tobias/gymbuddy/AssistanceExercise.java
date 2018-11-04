package se.tobias.gymbuddy;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AssistanceExercise extends LinearLayout {
    private Context _context;
    private TextView exerciseHeader = null;
    private TextView firstSetTotalRepetitions = null;
    private TextView secondSetTotalRepetitions = null;
    private TextView thirdSetTotalRepetitions = null;

    public AssistanceExercise(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);

        _context = context;

        init();
    }

    private void init() {
        inflate(_context, R.layout.assistance_exercise, this);
        exerciseHeader = findViewById(R.id.exerciseName);
        firstSetTotalRepetitions = findViewById(R.id.firstSetTotalRepetitions);
        secondSetTotalRepetitions = findViewById(R.id.secondSetTotalRepetitions);
        thirdSetTotalRepetitions = findViewById(R.id.thirdSetTotalRepetitions);
    }

    public void setExerciseHeader(String exerciseName){
        exerciseHeader.setText(exerciseName);
    }

    public void setExerciseSets(String exerciseSets){
        firstSetTotalRepetitions.setText(exerciseSets);
        secondSetTotalRepetitions.setText(exerciseSets);
        thirdSetTotalRepetitions.setText(exerciseSets);
    }
}
