package se.tobias.gymbuddy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;
import static se.tobias.gymbuddy.ExerciseTable.DAY_ONE;
import static se.tobias.gymbuddy.ExerciseTable.DAY_THREE;
import static se.tobias.gymbuddy.ExerciseTable.DAY_TWO;
import static se.tobias.gymbuddy.ExerciseTable.WEEK_ONE;
import static se.tobias.gymbuddy.ExerciseTable.WEEK_THREE;
import static se.tobias.gymbuddy.ExerciseTable.WEEK_TWO;

public class TrainingForTheDayFragment extends Fragment {
    private Context _context;
    private SharedPreferences sharedPreferences = null;
    private RadioGroup weekChoiceGroup = null;
    private RadioButton firstWeekRadioButton = null;
    private RadioGroup dayChoiceGroup = null;
    private RadioButton firstDayRadioButton = null;
    private ExerciseTable firstExercise = null;
    private ExerciseTable secondExercise = null;
    private TrainingMax _trainingMax = null;
    private String _chosenWeek = WEEK_ONE;
    private String _chosenDay = DAY_ONE;

    private static final String TRAINING_MAX_KEY = "TrainingMaxKey";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_training_for_the_day, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _context = getContext();
        firstExercise = view.findViewById(R.id.firstExercise);
        secondExercise = view.findViewById(R.id.secondExercise);

        if (_context != null) {
            sharedPreferences = _context.getSharedPreferences("SetupTrainingMax", MODE_PRIVATE);
            TrainingMax trainingMaxFromDisk = LoadTrainingMaxFromSharedPreferences();
            if (trainingMaxFromDisk != null) {
                _trainingMax = trainingMaxFromDisk;
            }
        }


        weekChoiceGroup = view.findViewById(R.id.weekChoiceGroup);
        weekChoiceGroup.setOnCheckedChangeListener(onWeekCheckedChangeListener);
        firstWeekRadioButton = view.findViewById(R.id.firstWeekRadioButton);
        firstWeekRadioButton.setChecked(true);
        dayChoiceGroup = view.findViewById(R.id.dayChoiceGroup);
        dayChoiceGroup.setOnCheckedChangeListener(onDayCheckedChangeListener);
        firstDayRadioButton = view.findViewById(R.id.firstDayRadioButton);
        firstDayRadioButton.setChecked(true);
    }

    private RadioGroup.OnCheckedChangeListener onWeekCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (_trainingMax != null) {
                switch (checkedId) {
                    case R.id.firstWeekRadioButton:
                        _chosenWeek = WEEK_ONE;
                        switch (_chosenDay) {
                            case DAY_ONE:
                                firstExercise.setupDetailsForWeekOne(_trainingMax.getSquatMax());
                                secondExercise.setupDetailsForWeekOne(_trainingMax.getBenchPressMax());
                                break;
                            case DAY_TWO:
                                firstExercise.setupDetailsForWeekOne(_trainingMax.getDeadliftMax());
                                secondExercise.setupDetailsForWeekOne(_trainingMax.getOverheadPressMax());
                                break;
                            default:
                                firstExercise.setupDetailsForWeekOne(_trainingMax.getBenchPressMax());
                                secondExercise.setupDetailsForWeekOne(_trainingMax.getSquatMax());
                                break;
                        }
                        break;
                    case R.id.secondWeekRadioButton:
                        _chosenWeek = WEEK_TWO;
                        switch (_chosenDay) {
                            case DAY_ONE:
                                firstExercise.setupDetailsForWeekTwo(_trainingMax.getSquatMax());
                                secondExercise.setupDetailsForWeekTwo(_trainingMax.getBenchPressMax());
                                break;
                            case DAY_TWO:
                                firstExercise.setupDetailsForWeekTwo(_trainingMax.getDeadliftMax());
                                secondExercise.setupDetailsForWeekTwo(_trainingMax.getOverheadPressMax());
                                break;
                            default:
                                firstExercise.setupDetailsForWeekTwo(_trainingMax.getBenchPressMax());
                                secondExercise.setupDetailsForWeekTwo(_trainingMax.getSquatMax());
                                break;
                        }
                        break;
                    case R.id.thirdWeekRadioButton:
                        _chosenWeek = WEEK_THREE;
                        switch (_chosenDay) {
                            case DAY_ONE:
                                firstExercise.setupDetailsForWeekThree(_trainingMax.getSquatMax());
                                secondExercise.setupDetailsForWeekThree(_trainingMax.getBenchPressMax());
                                break;
                            case DAY_TWO:
                                firstExercise.setupDetailsForWeekThree(_trainingMax.getDeadliftMax());
                                secondExercise.setupDetailsForWeekThree(_trainingMax.getOverheadPressMax());
                                break;
                            default:
                                firstExercise.setupDetailsForWeekThree(_trainingMax.getBenchPressMax());
                                secondExercise.setupDetailsForWeekThree(_trainingMax.getSquatMax());
                                break;
                        }
                        break;
                }
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener onDayCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.firstDayRadioButton:
                    _chosenDay = DAY_ONE;
                    firstExercise.setExerciseHeader(_context.getString(R.string.squat));
                    secondExercise.setExerciseHeader(_context.getString(R.string.bench_press));
                    switch (_chosenWeek) {
                        case WEEK_ONE:
                            firstExercise.setupDetailsForWeekOne(_trainingMax.getSquatMax());
                            secondExercise.setupDetailsForWeekOne(_trainingMax.getBenchPressMax());
                            break;
                        case WEEK_TWO:
                            firstExercise.setupDetailsForWeekTwo(_trainingMax.getSquatMax());
                            secondExercise.setupDetailsForWeekTwo(_trainingMax.getBenchPressMax());
                            break;
                        case WEEK_THREE:
                            firstExercise.setupDetailsForWeekThree(_trainingMax.getSquatMax());
                            secondExercise.setupDetailsForWeekThree(_trainingMax.getBenchPressMax());
                            break;
                    }
                    break;
                case R.id.secondDayRadioButton:
                    _chosenDay = DAY_TWO;
                    firstExercise.setExerciseHeader(_context.getString(R.string.deadlift));
                    secondExercise.setExerciseHeader(_context.getString(R.string.overhead_press));
                    switch (_chosenWeek) {
                        case WEEK_ONE:
                            firstExercise.setupDetailsForWeekOne(_trainingMax.getDeadliftMax());
                            secondExercise.setupDetailsForWeekOne(_trainingMax.getOverheadPressMax());
                            break;
                        case WEEK_TWO:
                            firstExercise.setupDetailsForWeekTwo(_trainingMax.getDeadliftMax());
                            secondExercise.setupDetailsForWeekTwo(_trainingMax.getOverheadPressMax());
                            break;
                        case WEEK_THREE:
                            firstExercise.setupDetailsForWeekThree(_trainingMax.getDeadliftMax());
                            secondExercise.setupDetailsForWeekThree(_trainingMax.getOverheadPressMax());
                            break;
                    }
                    break;
                case R.id.thirdDayRadioButton:
                    _chosenDay = DAY_THREE;
                    firstExercise.setExerciseHeader(_context.getString(R.string.bench_press));
                    secondExercise.setExerciseHeader(_context.getString(R.string.squat));
                    switch (_chosenWeek) {
                        case WEEK_ONE:
                            firstExercise.setupDetailsForWeekOne(_trainingMax.getBenchPressMax());
                            secondExercise.setupDetailsForWeekOne(_trainingMax.getSquatMax());
                            break;
                        case WEEK_TWO:
                            firstExercise.setupDetailsForWeekTwo(_trainingMax.getBenchPressMax());
                            secondExercise.setupDetailsForWeekTwo(_trainingMax.getSquatMax());
                            break;
                        case WEEK_THREE:
                            firstExercise.setupDetailsForWeekThree(_trainingMax.getBenchPressMax());
                            secondExercise.setupDetailsForWeekThree(_trainingMax.getSquatMax());
                            break;
                    }
                    break;
            }
        }
    };

    private TrainingMax LoadTrainingMaxFromSharedPreferences() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(TRAINING_MAX_KEY, "");
        if (json.equals("")) {
            return null;
        }
        return gson.fromJson(json, TrainingMax.class);
    }
}
