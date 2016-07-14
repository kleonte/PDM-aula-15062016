package com.mycompany.mysecondapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity implements OnClickListener {

    private static final int VER_NOTAS = 0;
    private static final int DASHBOARD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Realça as bordas da tabela
        ShapeDrawable border = new ShapeDrawable(new RectShape());
        border.getPaint().setStyle(Paint.Style.STROKE);
        border.getPaint().setColor(Color.BLACK);

        // Layout principal
        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams textViewParams =
                new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText("Tarefas");
        tv.setTextSize(27);
        tv.setTextColor(Color.BLACK);
        textViewParams.setMargins(0, 100, 0, 0);
        textViewParams.gravity = Gravity.CENTER;
        tv.setLayoutParams(textViewParams);
        myLayout.addView(tv);

        // Layout da tabela
        TableLayout table = new TableLayout(this);
        table.setPadding(100, 100, 100, 0);
        table.setStretchAllColumns(true);
        table.setShrinkAllColumns(true);

        // Linha do cabeçalho
        TableRow rowTitle = new TableRow(this);
        rowTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        TableRow.LayoutParams trparams
                = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                            TableRow.LayoutParams.WRAP_CONTENT);
        trparams.setMargins(10, 40, 10, 10);
        rowTitle.setLayoutParams(trparams);
        rowTitle.setGravity(Gravity.CENTER_HORIZONTAL);

        rowTitle.setBackgroundColor(Color.GRAY);

        TextView empty = new TextView(this);
        empty.setText("Descrição da tarefa");
        TextView title = new TextView(this);
        empty.setLayoutParams(trparams);
        title.setLayoutParams(trparams);
        table.setLayoutParams(trparams);
        title.setText("OK");
        rowTitle.addView(title);
        rowTitle.addView(empty);
        table.addView(rowTitle);

        // Linha 1
        TableRow row2 = new TableRow(this);
        row2.setLayoutParams(trparams);

        CheckBox checkBox0 = new CheckBox(this);
        checkBox0.setLayoutParams(trparams);
        checkBox0.setChecked(true);
        row2.addView(checkBox0);
        row2.setGravity(Gravity.CENTER_HORIZONTAL);
        row2.setBackgroundDrawable(border);
        table.addView(row2);

        TextView number3 = new TextView(this);
        number3.setLayoutParams(trparams);
        number3.setText("Leitura de texto sobre Android");
        row2.addView(number3);
        row2.setGravity(Gravity.CENTER_HORIZONTAL);

        // Linha 2
        TableRow row3 = new TableRow(this);
        row3.setLayoutParams(trparams);

        CheckBox checkBox1 = new CheckBox(this);
        checkBox1.setLayoutParams(trparams);
        row3.addView(checkBox1);
        row3.setGravity(Gravity.CENTER_HORIZONTAL);
        row3.setBackgroundDrawable(border);
        table.addView(row3);

        TextView number5 = new TextView(this);
        number5.setLayoutParams(trparams);
        number5.setText("Responder Quiz 1");
        row3.addView(number5);
        row3.setGravity(Gravity.CENTER_HORIZONTAL);

        // Linha 3
        TableRow row4 = new TableRow(this);
        row4.setLayoutParams(trparams);

        CheckBox checkBox2 = new CheckBox(this);
        checkBox2.setLayoutParams(trparams);
        row4.addView(checkBox2);
        row4.setGravity(Gravity.CENTER_HORIZONTAL);
        row4.setBackgroundDrawable(border);
        table.addView(row4);

        TextView number7 = new TextView(this);
        number7.setLayoutParams(trparams);
        number7.setText("Implementar a prática 1");
        row4.addView(number7);
        row4.setGravity(Gravity.CENTER_HORIZONTAL);

        myLayout.addView(table);

        // LinearLayout para os botões
        LinearLayout buttonLayout = new LinearLayout(this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams buttonLayoutParams =
                    new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
        buttonLayoutParams.setMargins(186, 40, 186, 0);
        myLayout.addView(buttonLayout, buttonLayoutParams);

        // Botão "ver notas"
        Button button0 = new Button(this);
        button0.setText("ver notas");
        button0.setId(VER_NOTAS);
        button0.setOnClickListener(this);
        button0.setPadding(60, 60, 60, 60);
        buttonLayout.addView(button0);

        // Botão "dashboard"
        Button button1 = new Button(this);
        button1.setText("dashboard");
        button1.setId(DASHBOARD);
        button1.setOnClickListener(this);
        button1.setPadding(60, 60, 60, 60);
        buttonLayout.addView(button1);

        setContentView(myLayout);
    }

    // Método que captura o clique do usuário
    public void onClick (View v) {
        Toast toast;
        switch (v.getId()) {
            case VER_NOTAS:
                toast = Toast.makeText(MyActivity.this,
                        "As notas ainda não estão disponíveis",
                        Toast.LENGTH_SHORT);
                toast.show();
                break;

            case DASHBOARD:
                toast = Toast.makeText(MyActivity.this, "Acesso negado", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}