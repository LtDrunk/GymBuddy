package se.tobias.gymbuddy;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class AssistanceExercisesContainer extends LinearLayout {
    private Context _context;
    private AssistanceExercise firstAssistanceExercise = null;
    private AssistanceExercise secondAssistanceExercise = null;
    private AssistanceExercise thirdAssistanceExercise = null;
    private AssistanceExercise fourthAssistanceExercise = null;
    private AssistanceExercise fifthAssistanceExercise = null;

    public AssistanceExercisesContainer(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);

        _context = context;

        init();
    }

    private void init() {
        inflate(_context, R.layout.assistance_exercises_container, this);

        firstAssistanceExercise = findViewById(R.id.firstAssistanceExercise);
        firstAssistanceExercise.setExerciseHeader("Gymnast Abs");
        firstAssistanceExercise.setExerciseSets("10 lyft");

        secondAssistanceExercise = findViewById(R.id.secondAssistanceExercise);
        secondAssistanceExercise.setExerciseHeader("Sidoplanka med höjd arm");
        secondAssistanceExercise.setExerciseSets("10 lyft");

        thirdAssistanceExercise = findViewById(R.id.thirdAssistanceExercise);
        thirdAssistanceExercise.setExerciseHeader("Luta framåt med vikt");
        thirdAssistanceExercise.setExerciseSets("1 X 10 @ 10kg");

        fourthAssistanceExercise = findViewById(R.id.fourthAssistanceExercise);
        fourthAssistanceExercise.setExerciseHeader("Bicep curl");
        fourthAssistanceExercise.setExerciseSets("1 X 10 @ 10kg");

        fifthAssistanceExercise = findViewById(R.id.fifthAssistanceExercise);
        fifthAssistanceExercise.setExerciseHeader("Inclined dumbell bench press");
        fifthAssistanceExercise.setExerciseSets("1 X 10 @ 10kg");

    }



}
