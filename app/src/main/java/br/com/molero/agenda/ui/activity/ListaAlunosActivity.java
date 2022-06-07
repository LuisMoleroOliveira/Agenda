package br.com.molero.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.molero.agenda.R;
import br.com.molero.agenda.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        confifuraFabNovoAluno();
    }


    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void confifuraFabNovoAluno() {
        FloatingActionButton fabNovoAluno = findViewById(R.id.activity_main_fab_novo_aluno);

        fabNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioAlunoACtivity();
            }
        });
    }

    private void abreFormularioAlunoACtivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);

        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }


}
