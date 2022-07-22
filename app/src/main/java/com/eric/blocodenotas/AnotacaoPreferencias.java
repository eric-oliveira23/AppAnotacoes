package com.eric.blocodenotas;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private final String nome_arquivo = "anotacao.preferencias";
    private final String chave_nome = "nome";
    private SharedPreferences.Editor editor;

    public AnotacaoPreferencias(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(nome_arquivo,0);
        editor = preferences.edit();
    }

    public void SalvarAnotacao(String anotacao){

        editor.putString(chave_nome, anotacao);
        editor.commit();

    }

    public String RecuperarAnotacao(){
        return preferences.getString(chave_nome,"");
    }

}
