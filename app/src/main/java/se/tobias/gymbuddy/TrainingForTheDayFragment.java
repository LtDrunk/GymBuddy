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
import android.widget.TextView;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

public class TrainingForTheDayFragment extends Fragment {
    private Context _context;
    private SharedPreferences sharedPreferences = null;
    private RadioGroup weekChoiceGroup = null;
    private RadioButton firstWeekRadioButton = null;
    private RadioGroup dayChoiceGroup = null;
    private RadioButton firstDayRadioButton = null;
    private ExerciseTable firstExercise = null;
    private ExerciseTable secondExercise = null;

    private static final String ONE_REP_MAX_KEY = "OneRepMaxKey";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_training_for_the_day, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weekChoiceGroup = view.findViewById(R.id.weekChoiceGroup);
        weekChoiceGroup.setOnCheckedChangeListener(onWeekCheckedChangeListener);
        firstWeekRadioButton = view.findViewById(R.id.firstWeekRadioButton);
        firstWeekRadioButton.setChecked(true);
        dayChoiceGroup = view.findViewById(R.id.dayChoiceGroup);
        dayChoiceGroup.setOnCheckedChangeListener(onDayCheckedChangeListener);
        firstDayRadioButton = view.findViewById(R.id.firstDayRadioButton);
        firstDayRadioButton.setChecked(true);
        firstExercise = view.findViewById(R.id.firstExercise);
        secondExercise = view.findViewById(R.id.secondExercise);

        _context = getContext();

        if (_context != null) {
            sharedPreferences = _context.getSharedPreferences("SetupOneRepMax", MODE_PRIVATE);
            OneRepMax oneRepMaxFromDisk = LoadOneRepMaxFromSharedPreferences();
            if(oneRepMaxFromDisk != null){
                CalculateTheWeightsForEachRep(oneRepMaxFromDisk);
            }
        }
    }

    private void CalculateTheWeightsForEachRep(OneRepMax oneRepMaxFromDisk) {

        /**
         * 1) Calculate Train Max (TM) from 1RM, this is done with 1RM * 0.9 (90%)
         * 2) Check where in cycle we are (First, second or third week). This will give different percentages to multiply with.
         * 3) Check which training day it is (First, second or third. Alt, Monday, Wednesday or Friday) this will decide which excercises are relevant
         * 4) Populate the now hard coded fields with info.
         */



    }

    private RadioGroup.OnCheckedChangeListener onWeekCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.firstWeekRadioButton:

                    break;
                case R.id.secondWeekRadioButton:
                    break;
                case R.id.thirdWeekRadioButton:
                    break;
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener onDayCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.firstDayRadioButton:
                    break;
                case R.id.secondDayRadioButton:
                    break;
                case R.id.thirdDayRadioButton:
                    break;
            }
        }
    };

    private OneRepMax LoadOneRepMaxFromSharedPreferences() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(ONE_REP_MAX_KEY, "");
        if(json.equals("")){
            return null;
        }
        return gson.fromJson(json, OneRepMax.class);
    }
}
