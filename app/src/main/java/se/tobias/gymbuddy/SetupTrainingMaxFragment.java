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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

public class SetupTrainingMaxFragment extends Fragment {
    private Context _context;
    private Button saveTrainingMaxButton = null;
    private EditText benchPressTextInput = null;
    private EditText squatTextInput = null;
    private EditText deadliftTextInput = null;
    private EditText overheadPressTextInput = null;

    private static final String TRAINING_MAX_KEY = "TrainingMaxKey";
    private SharedPreferences sharedPreferences = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setup_training_max, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        _context = getContext();
        saveTrainingMaxButton = view.findViewById(R.id.saveTrainingMaxButton);
        benchPressTextInput = view.findViewById(R.id.benchPressTextInput);
        squatTextInput = view.findViewById(R.id.squatTextInput);
        deadliftTextInput = view.findViewById(R.id.deadliftTextInput);
        overheadPressTextInput = view.findViewById(R.id.overheadPressTextInput);

        saveTrainingMaxButton.setOnClickListener(saveTrainingMaxButtonClickListener);

        if (_context != null) {
            sharedPreferences = _context.getSharedPreferences("SetupTrainingMax", MODE_PRIVATE);
            TrainingMax trainingMaxFromDisk = LoadTrainingMaxFromSharedPreferences();
            if(trainingMaxFromDisk != null){
                SetValuesInAllTextInputs(trainingMaxFromDisk);
            }
        }
    }

    private void SetValuesInAllTextInputs(TrainingMax trainingMaxFromDisk){
        //TODO gör om från int to string
        String benchPressMaxString = String.valueOf(trainingMaxFromDisk.getBenchPressMax());
        String squatMaxString = String.valueOf(trainingMaxFromDisk.getSquatMax());
        String deadliftMaxString = String.valueOf(trainingMaxFromDisk.getDeadliftMax());
        String overheadPressMaxString = String.valueOf(trainingMaxFromDisk.getOverheadPressMax());

        benchPressTextInput.setText(benchPressMaxString, TextView.BufferType.EDITABLE);
        squatTextInput.setText(squatMaxString, TextView.BufferType.EDITABLE);
        deadliftTextInput.setText(deadliftMaxString, TextView.BufferType.EDITABLE);
        overheadPressTextInput.setText(overheadPressMaxString, TextView.BufferType.EDITABLE);
    }

    private void SaveTrainingMaxToSharedPreferences(TrainingMax trainingMax) {
        Gson gson = new Gson();
        String json = gson.toJson(trainingMax);

        if (_context != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(TRAINING_MAX_KEY, json);
            editor.apply();
        } else {
            //TODO: ERROR HANDLING
        }
    }

    private TrainingMax LoadTrainingMaxFromSharedPreferences() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(TRAINING_MAX_KEY, "");
        if(json.equals("")){
            return null;
        }
        return gson.fromJson(json, TrainingMax.class);
    }


    private View.OnClickListener saveTrainingMaxButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String benchPressTrainingMax = benchPressTextInput.getText().toString();
            String squatTrainingMax = squatTextInput.getText().toString();
            String deadliftTrainingMax = deadliftTextInput.getText().toString();
            String overheadPressTrainingMax = overheadPressTextInput.getText().toString();

            if(benchPressTrainingMax.equals("") || squatTrainingMax.equals("") || deadliftTrainingMax.equals("") || overheadPressTrainingMax.equals("")){
                //TODO: Change to a text field with red text instead, like a classic form error?
                Toast.makeText(_context, "Please fill in all the values before saving", Toast.LENGTH_LONG).show();
                return;
            }

            int benchPressTrainingMaxAsInteger = Integer.parseInt(benchPressTrainingMax);
            int squatTrainingMaxAsInteger = Integer.parseInt(squatTrainingMax);
            int deadliftTrainingMaxAsInteger = Integer.parseInt(deadliftTrainingMax);
            int overheadPressTrainingMaxAsInteger = Integer.parseInt(overheadPressTrainingMax);

            TrainingMax trainingMax = new TrainingMax(benchPressTrainingMaxAsInteger, squatTrainingMaxAsInteger, deadliftTrainingMaxAsInteger, overheadPressTrainingMaxAsInteger);
            SaveTrainingMaxToSharedPreferences(trainingMax);

            Toast.makeText(_context, "Values has been saved", Toast.LENGTH_LONG).show();
        }
    };
}
