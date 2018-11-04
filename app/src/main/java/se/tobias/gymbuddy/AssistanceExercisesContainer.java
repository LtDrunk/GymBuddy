package se.tobias.gymbuddy;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class AssistanceExercisesContainer extends LinearLayout {
    private Context _context;
    private AssistanceExercise firstAssistanceExercise = null;

    public AssistanceExercisesContainer(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);

        _context = context;

        init();
    }

    private void init() {
        inflate(_context, R.layout.assistance_exercises_container, this);

        firstAssistanceExercise = findViewById(R.id.firstAssistanceExercise);
        firstAssistanceExercise.setExerciseHeader("Sidoplanka");
        firstAssistanceExercise.setExerciseSets("10 sekunder");

    }



}
