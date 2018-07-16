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
    private Button saveOneRepMaxButton = null;
    private EditText benchPressTextInput = null;
    private EditText squatTextInput = null;
    private EditText deadliftTextInput = null;
    private EditText overheadPressTextInput = null;

    private static final String ONE_REP_MAX_KEY = "OneRepMaxKey";
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
        saveOneRepMaxButton = view.findViewById(R.id.saveOneRepMaxButton);
        benchPressTextInput = view.findViewById(R.id.benchPressTextInput);
        squatTextInput = view.findViewById(R.id.squatTextInput);
        deadliftTextInput = view.findViewById(R.id.deadliftTextInput);
        overheadPressTextInput = view.findViewById(R.id.overheadPressTextInput);

        saveOneRepMaxButton.setOnClickListener(saveOneRepMaxButtonClickListener);

        if (_context != null) {
            sharedPreferences = _context.getSharedPreferences("SetupOneRepMax", MODE_PRIVATE);
            OneRepMax oneRepMaxFromDisk = LoadOneRepMaxFromSharedPreferences();
            if(oneRepMaxFromDisk != null){
                SetValuesInAllTextInputs(oneRepMaxFromDisk);
            }
        }
    }

    private void SetValuesInAllTextInputs(OneRepMax oneRepMaxFromDisk){
        //TODO gör om från int to string
        String benchPressMaxString = String.valueOf(oneRepMaxFromDisk.getBenchPressMax());
        String squatMaxString = String.valueOf(oneRepMaxFromDisk.getSquatMax());
        String deadliftMaxString = String.valueOf(oneRepMaxFromDisk.getDeadliftMax());
        String overheadPressMaxString = String.valueOf(oneRepMaxFromDisk.getOverheadPressMax());

        benchPressTextInput.setText(benchPressMaxString, TextView.BufferType.EDITABLE);
        squatTextInput.setText(squatMaxString, TextView.BufferType.EDITABLE);
        deadliftTextInput.setText(deadliftMaxString, TextView.BufferType.EDITABLE);
        overheadPressTextInput.setText(overheadPressMaxString, TextView.BufferType.EDITABLE);
    }

    private void SaveOneRepMaxToSharedPreferences(OneRepMax oneRepMax) {
        Gson gson = new Gson();
        String json = gson.toJson(oneRepMax);

        if (_context != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(ONE_REP_MAX_KEY, json);
            editor.apply();
        } else {
            //TODO: ERROR HANDLING
        }
    }

    private OneRepMax LoadOneRepMaxFromSharedPreferences() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(ONE_REP_MAX_KEY, "");
        if(json.equals("")){
            return null;
        }
        return gson.fromJson(json, OneRepMax.class);
    }


    private View.OnClickListener saveOneRepMaxButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String benchPressOneRepMax = benchPressTextInput.getText().toString();
            String squatOneRepMax = squatTextInput.getText().toString();
            String deadliftOneRepMax = deadliftTextInput.getText().toString();
            String overheadPressOneRepMax = overheadPressTextInput.getText().toString();

            if(benchPressOneRepMax.equals("") || squatOneRepMax.equals("") || deadliftOneRepMax.equals("") || overheadPressOneRepMax.equals("")){
                //TODO: Change to a text field with red text instead, like a classic form error?
                Toast.makeText(_context, "Please fill in all the values before saving", Toast.LENGTH_LONG).show();
                return;
            }

            int benchPressOneRepMaxAsInteger = Integer.parseInt(benchPressOneRepMax);
            int squatOneRepMaxAsInteger = Integer.parseInt(squatOneRepMax);
            int deadliftOneRepMaxAsInteger = Integer.parseInt(deadliftOneRepMax);
            int overheadPressOneRepMaxAsInteger = Integer.parseInt(overheadPressOneRepMax);

            OneRepMax oneRepMax = new OneRepMax(benchPressOneRepMaxAsInteger, squatOneRepMaxAsInteger, deadliftOneRepMaxAsInteger, overheadPressOneRepMaxAsInteger);
            SaveOneRepMaxToSharedPreferences(oneRepMax);

            Toast.makeText(_context, "Values has been saved", Toast.LENGTH_LONG).show();
        }
    };
}
