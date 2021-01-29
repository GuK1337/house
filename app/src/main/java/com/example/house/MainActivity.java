package com.example.house;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View toolBox;
    private ImageView imageview,door;
    private CheckBox checkbox;
    private RadioGroup radiogroup;
    public EditText stage_num;
    private RelativeLayout first_stage,second_stage,third_stage,fourth_stage,fifth_stage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBox = findViewById(R.id.toolbox);
        imageview = findViewById(R.id.roof_window);
        door = findViewById(R.id.door);
        checkbox = findViewById(R.id.roof_window_checkbox);
        radiogroup = findViewById(R.id.radio_group_door_orientation);
        stage_num =  findViewById(R.id.stage_num);
        first_stage = findViewById(R.id.first_stage);
        second_stage = findViewById(R.id.second_stage);
        third_stage = findViewById(R.id.third_stage);
        fourth_stage = findViewById(R.id.fourth_stage);
        fifth_stage = findViewById(R.id.fifth_stage);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageview.setVisibility(isChecked ? View.VISIBLE: View.GONE);
            }
        });

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_door_left){
                    door.setImageResource(R.drawable.door2); }
                else{  door.setImageResource(R.drawable.door); }

            }
        });
        stage_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")){

                }
                else {
                    int numStage = Integer.valueOf(s.toString());
                    if (numStage == 1) {
                        second_stage.setVisibility(View.GONE);
                        third_stage.setVisibility(View.GONE);
                        fourth_stage.setVisibility(View.GONE);
                        fifth_stage.setVisibility(View.GONE);
                    } else if (numStage == 2) {
                        second_stage.setVisibility(View.VISIBLE);
                        third_stage.setVisibility(View.GONE);
                        fourth_stage.setVisibility(View.GONE);
                        fifth_stage.setVisibility(View.GONE);
                    } else if (numStage == 3) {
                        second_stage.setVisibility(View.VISIBLE);
                        third_stage.setVisibility(View.VISIBLE);
                        fourth_stage.setVisibility(View.GONE);
                        fifth_stage.setVisibility(View.GONE);
                    } else if (numStage == 4) {
                        second_stage.setVisibility(View.VISIBLE);
                        third_stage.setVisibility(View.VISIBLE);
                        fourth_stage.setVisibility(View.VISIBLE);
                        fifth_stage.setVisibility(View.GONE);
                    } else if (numStage == 5) {
                        second_stage.setVisibility(View.VISIBLE);
                        third_stage.setVisibility(View.VISIBLE);
                        fourth_stage.setVisibility(View.VISIBLE);
                        fifth_stage.setVisibility(View.VISIBLE);
                    }
                }
            }

        });


    }

    public void showSettings(View v){
        if (toolBox.getVisibility() == View.GONE)
            toolBox.setVisibility(View.VISIBLE);
        else
            toolBox.setVisibility(View.GONE);
    }


}