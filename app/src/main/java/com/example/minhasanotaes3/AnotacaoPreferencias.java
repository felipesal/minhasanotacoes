package com.example.minhasanotaes3;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String ARQUIVO_ANOTACOES = "anotacoes.preferencias";
    private final String CHAVE_NOME = "nome";

    public AnotacaoPreferencias(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(ARQUIVO_ANOTACOES, 0);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    public String recuperarAnotacao(){
        return preferences.getString(CHAVE_NOME, "");
    }

}
