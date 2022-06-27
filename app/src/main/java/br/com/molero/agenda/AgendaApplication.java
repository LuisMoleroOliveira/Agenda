package br.com.molero.agenda;

import android.app.Application;

import br.com.molero.agenda.dao.AlunoDAO;
import br.com.molero.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosTeste();
    }

    private void criaAlunosTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Luis", "1122223333", "luis@gmail.com.br"));
        dao.salva(new Aluno("Karen", "1122223333", "karen@gmail.com"));
    }
}
