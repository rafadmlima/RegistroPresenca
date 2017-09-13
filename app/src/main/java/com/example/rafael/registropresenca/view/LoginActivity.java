package com.example.rafael.registropresenca.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.rafael.registropresenca.R;
import com.example.rafael.registropresenca.control.UsuarioControle;
import com.example.rafael.registropresenca.model.Usuario;
import com.example.rafael.registropresenca.task.UsuarioThread;
import com.example.rafael.registropresenca.util.Conexao;
import com.example.rafael.registropresenca.util.Mensagem;

public class LoginActivity extends AppCompatActivity {
    private ProgressDialog dialog;
    private Conexao conexao;
    private Mensagem mensagem;
    private UsuarioControle uControl;
    private Usuario usuario;

    private EditText txtNome;
    private EditText txtCodigo;
    private Button btnEntrar;
    private Button btnCadastrar;
    private long rowid;
    private boolean result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uControl = new UsuarioControle();

        initComponents();

    }
    public void  initComponents(){

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        //System.out.println(System.currentTimeMillis());;


//        PARA TESTAR TELA ADMINISTRATIVA
//        txtCodigo.setText("46");
//        txtNome.setText("PEDRO TESSAROLLI");
//
//        PARA TESTAR TELA DE REGISTRO DE PONTO
        txtCodigo.setText("86");
        txtNome.setText("FATIMA");

//        txtCodigo.setText("84");
//        txtNome.setText("GIOVANNI");
//
//        PARA TESTAR SCANNER
//        txtCodigo.setText("85");
//        txtNome.setText("RAFAEL");


        //PARA TESTAR LEITOR DE PRECO
//        txtCodigo.setText("50");
//        txtNome.setText("RAFA");



        //Local local = new Local(this);
    }

    public void setDialog(String msg){
       // dialog = mensagem.dialog("Aguarde",msg);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Aguarde");
        dialog.setMessage(msg);
        dialog.show();
    }

    public void entrar(View view) {
        //implementar verificacao de dados para permissao do acesso
        if(conexao == null){
            conexao = new Conexao(this);
        }

        if(conexao.conectado()) {

            if (!txtNome.getText().toString().isEmpty() || !txtNome.getText().toString().isEmpty()) {
                setDialog("Verificando...");
                UsuarioThread thread = new UsuarioThread(this, dialog);
                thread.execute("L", txtCodigo.getText().toString(), txtNome.getText().toString());
//                            txtSenha.getText().toString());
            } else {
                Snackbar.make(view, "Campo(s) Nome/Codigo vazio(s)!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }else{
            /*caso esteja sem internet será salvo em um bd local*/
            //Toast.makeText(this, "Modo OffLine", Toast.LENGTH_LONG).show();
            uControl =  new UsuarioControle(this);
//            if(usuario == null){
//                usuario = new Usuario();
//            }
//           usuario = uControl.login(Long.parseLong(txtCodigo.getText().toString()), txtNome.getText().toString());

            result = uControl.login(this, Long.parseLong(txtCodigo.getText().toString()), txtNome.getText().toString());
            mensagem = new Mensagem(this);
            if(result){
                mensagem.toast("OK");
            }else{
                mensagem.alertDialog(this, "Ops! Você ainda não é cadastrado solicite o seu cadastro enviando um email para: ptessarolli@gmail.com com o titulo #CADASTRO APP TS_SOLUTIONS");
//                btnCadastrar.setVisibility(View.VISIBLE);
//                btnEntrar.setEnabled(false);
            }

//            rowid = UControl.inserir(txtCodigo.getText().toString(), txtNome.getText().toString());
//            if(rowid > 0){
//                mensagem = new Mensagem(this);
//                mensagem.toast("Cadastro realizado");
//            }else{
//                mensagem = new Mensagem(this);
//                mensagem.toast("Cadastro NÃO realizado");
//            }


        }
    }

    public void cadastrar(View view) {
        if(mensagem == null){
            mensagem = new Mensagem(this);
        }
        mensagem.toast("Cadastrando...");
        btnCadastrar.setEnabled(false);
        btnEntrar.setEnabled(true);
    }
}
