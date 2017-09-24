package com.example.rafael.registropresenca.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rafael.registropresenca.R;
import com.example.rafael.registropresenca.model.Produto;
import com.example.rafael.registropresenca.model.Registro;
import com.example.rafael.registropresenca.model.Usuario;
import com.example.rafael.registropresenca.util.Config;
import com.example.rafael.registropresenca.util.DadosUsuario;
import com.example.rafael.registropresenca.util.ListaAdapterRegistro;
import com.example.rafael.registropresenca.util.RequestHelper;
import com.example.rafael.registropresenca.view.ConsultaActivity;
import com.example.rafael.registropresenca.view.FuncActivity;
import com.example.rafael.registropresenca.view.HomeActivity;
import com.example.rafael.registropresenca.view.MainActivity;
import com.example.rafael.registropresenca.view.PromoterActivity;
import com.example.rafael.registropresenca.view.RegistroActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

/**
 * Created by RAFAEL on 04/05/2017.
 */

public class UsuarioThread extends AsyncTask<String, Void, Boolean> {

    private Context contexto;
    private ProgressDialog dialog;
    private String acao;
    private Usuario user;
    private Produto produto;
    private Registro registro;
    List<Registro> listaRegistro;
    int[] ttHorasAux = {00,00,00};
    String hora,minuto,segundo;

    public UsuarioThread(Context contexto, ProgressDialog dialog) {
        this.contexto = contexto;
        this.dialog = dialog;
    }

    protected Boolean doInBackground(String... values) {
//        String url = Config.urlServidorWampCasaVirus;// wamp casa "virus"
//        String url = Config.urlServidorWampCasaWifi;// wamp casa "wifi"
//        String url = Config.urlServidorWampLoja;// wamp local loja paulistinha
        String url = Config.urlServidorWebLoja; // servidor web loja
//        String url = Config.urlServidorCasaNetWork;

        JSONArray jsonArray;
        JSONObject jsonObject;
        RequestHelper requestHelper;
        String[] params;

        acao = values[0];

        switch (acao){

            case "C" :
                //cadastrar novo funcionario
//                params = new String[] {"acao", "nome", "sobreNome", "dataAdmissao", "dataCadastro",
//                        "tipoFuncionario", "rg", "cpf", "endereco", "numero", "bairro",
//                        "cep", "dataNasc", "senha"};
//
//                requestHelper = new RequestHelper();
//                jsonObject = requestHelper.getJSONOject(url, params, values);
//
//                try {
//                    return jsonObject.getBoolean("flag");
//                } catch (Exception e) {
//                    Log.e("ERRO", "Problema ao atualizar os dados");
//                    e.printStackTrace();
//                }
                break;
            case "R" :
                //fazer um selectAll
//                params= new String[] {"acao"};
//                requestHelper = new RequestHelper();
//                jsonArray = requestHelper.getJSONArray(url, params, values);
//                if(jsonArray != null) {
//                    try {
//                        listaFuncionario = new ArrayList<Funcionario>();
//
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            jsonObject = (JSONObject) jsonArray.get(i);
//                            Funcionario f = new Funcionario();
//                            f.setCodigo(jsonObject.getInt("CODIGO"));
//                            f.setNome(jsonObject.getString("NOME"));
//                            f.setSobreNome(jsonObject.getString("SOBRENOME"));
//                            f.setDataAdmissao(formatDateToApp(jsonObject.getString("DATA_ADMISSAO").replace("-", "")));
//                            f.setDataCadastro(formatDateToApp(jsonObject.getString("DATA_CADASTRO").toString().replace("-", "")));
//                            f.setTipoFuncionario(jsonObject.getString("TIPO_FUNC"));
//                            f.setRg(jsonObject.getInt("RG"));
//                            f.setCpf(jsonObject.getString("CPF"));
//                            f.setEndereco(jsonObject.getString("ENDERECO"));
//                            f.setNumero(jsonObject.getInt("NUMERO"));
//                            f.setBairro(jsonObject.getString("BAIRRO"));
//                            f.setCep(jsonObject.getInt("CEP"));
//                            f.setDataNascimento(formatDateToApp(jsonObject.getString("DATA_NASC").toString().replace("-", "")));
//                            //f.setSenha(jsonObject.getString("SENHA"));
//
//                            listaFuncionario.add(f);
//                            // aqui eu imprimo no console a lista pra testes(excluir ao terminar os testes)
//                            //                        System.out.println("id -> " + f.getCodigo() + "\nnome -> " + f.getNome() + "\nsobrenome -> " + f.getSobreNome() + "\ndataAdm -> " + f.getDataAdmissao() +
//                            //                                            "\ndataCad -> " + f.getDataCadastro() + "\ntipoFunc -> " + f.getTipoFuncionario() + "\nRg -> " + f.getRg() + "\nCpf -> " + f.getCpf() +
//                            //                                            "\nEnd -> " + f.getEndereco() + "\nNum -> " + f.getNumero() + "\nBairro -> " + f.getBairro() + "\nCep -> " + f.getCep() + "\ndataNasc -> " + f.getDataNascimento() +
//                            //                                            "\nSenha -> " + f.getSenha());
//                            //
//                        }
//                        return true;
//
//                    } catch (Exception e) {
//                        Log.e("ERRO", "Lista de Funcionario não carregada!");
//                    }
//                }else{
//                    return false;
//                }
                break;
            case "U" :
                //atualizar um funcionario
//                params = new String[] {"acao", "id", "nome", "sobreNome", "dataAdmissao", "dataCadastro", "tipoFuncionario", "rg", "cpf", "endereco", "numero", "bairro", "cep", "dataNasc"};
//                for(int i=0; i < values.length; i++){
//                    System.out.println("\n->" + values[i].toString());
//                }
//
//                requestHelper = new RequestHelper();
//                jsonObject = requestHelper.getJSONOject(url, params, values);
//
//                try {
//                    return jsonObject.getBoolean("flag");
//                } catch (Exception e) {
//                    Log.e("ERRO", "Problema ao atualizar os dados");
//                    e.printStackTrace();
//                }
//                break;
            case "D" :
                //deletar um funcionario
//                params = new String[] {"acao", "id"};
////                for(int i=0; i < values.length; i++){
////                    System.out.println("\n->" + values[i].toString());
////                }
//
//                requestHelper = new RequestHelper();
//                jsonObject = requestHelper.getJSONOject(url, params, values);
//
//                try {
//                    return jsonObject.getBoolean("flag");
//                } catch (Exception e) {
//                    Log.e("ERRO", "Problema ao excluir o registro");
//                    e.printStackTrace();
//                }
//                break;
            case "S" :
//                //fazer um selectPorId
                params= new String[] {"acao","colaborador", "data"};
                requestHelper = new RequestHelper();
                jsonArray = requestHelper.getJSONArray(url, params, values);
                if (jsonArray != null) {
                    try {
                        listaRegistro = new ArrayList<Registro>();

                        for (int i = 0; i < jsonArray.length(); i++) {

                            jsonObject = (JSONObject) jsonArray.get(i);
                            registro = new Registro();
                            registro.setId(jsonObject.getInt("ID"));
                            registro.setEmpresa(jsonObject.getLong("EMPRESA"));
                            registro.setColaborador(jsonObject.getLong("COLABORADOR"));
                            registro.setData(formatDateToApp(jsonObject.getString("DATA_REG").replace("-","")));
                            registro.setData_reuniao(formatDateToApp(jsonObject.getString("DATA_REUNIAO").replace("-","")));
                            registro.setOperacao(jsonObject.getString("OPERACAO"));
                            registro.setMotivo(jsonObject.getString("MOTIVO"));
                            registro.setHorario(jsonObject.getString("HORA"));
                            registro.setStatus(jsonObject.getString("STATUS"));

                            registro.setTrabalhado(jsonObject.getString("TRABALHADO"));

                            registro.setCoordenadas(jsonObject.getString("COORDENADAS"));

                            registro.setTtTrabalhado(somarTotalHoras(jsonObject.getString("TRABALHADO")));

                            listaRegistro.add(registro);


                            DadosUsuario.setUltOperacao(jsonObject.getString("OPERACAO"));
                            DadosUsuario.setUltStatus(jsonObject.getString("STATUS"));

                            //System.out.println("TRABALHADO ->>>>>> "+registro.getTtTrabalhado());

//                            System.out.println("--------------------------------------------------------------");
//                            System.out.println("STATUS:  "+ registro.getStatus());
//                            System.out.println("--------------------------------------------------------------");
//                            System.out.println("DATA_REG:  "+ registro.getData());
//                            System.out.println("--------------------------------------------------------------");
//                            System.out.println("DATA_REUNIAO:  " + registro.getData_reuniao());
//                            System.out.println("--------------------------------------------------------------");
//                            System.out.println("HORARIO:  "+registro.getHorario());
//                            System.out.println("--------------------------------------------------------------");
//                            System.out.println("TRABALHADO:  "+registro.getTrabalhado());
//                            System.out.println("--------------------------------------------------------------");
                        }
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("ERRO", "Lista de registros!");
                    }
                }else{
                    DadosUsuario.setUltOperacao("S");
                    DadosUsuario.setUltStatus("S");
                    return false;
                }
                break;
            case "L":
                params = new  String[] { "acao", "uId","userName"};

                requestHelper = new RequestHelper();
                jsonArray = requestHelper.getJSONArray(url, params, values);

                if (jsonArray != null) {
                    try {
                        user = new Usuario();
                        jsonObject =  (JSONObject) jsonArray.getJSONObject(0);
                        user.setCodigo(jsonObject.getInt("UID"));
                        user.setNome(jsonObject.getString("UNAME"));
                        user.setCpf(jsonObject.getLong("CPF"));
//                      if(jsonObject.getLong("FONE1") != null) {
//                        user.setFone(jsonObject.getLong("FONE1"));
//                      }
                        user.setForma(jsonObject.getString("FORMA"));
                        user.setForma_titulo(jsonObject.getString("FORMA_TITUL"));
                        user.setCnpjEmpresa(jsonObject.getLong("CNPJCLIENTE"));
                        user.setCep(jsonObject.getLong("CEP"));
                        user.setNumero(jsonObject.getInt("NUMERO"));
                        //user.setSenha(jsonObject.getString(""));
                        //user.setNivel(jsonObject.getInt("UPASS"));

                        DadosUsuario.setUsuarioCorrente(user);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return true;
                }else{
                    return false;
                }

            case "M":
                    break;

            case "P":// registrar "P"resença ou "P"onto
                //'$acao','tabela','$empresa', '$colaborador', '$data_reuniao, '$operacao', '$motivo', '$status', '$coordenadas'
                params = new String[] {"acao", "tabela" ,"empresa", "cpf", "data_reuniao", "operacao", "motivo", "status", "coordenadas"};

                requestHelper = new RequestHelper();
                jsonObject = requestHelper.getJSONOject(url, params,values);

                if(jsonObject != null) {
                    try {
                        jsonObject.getBoolean("flag");

                    } catch (Exception e) {
                        Log.i("<<<<<  TAG  >>>>>  ", e.getMessage());
                    }
                }else{
                    return false;
                }

                break;
            case "PR":
                params = new  String[] { "acao", "codbar"};

                requestHelper = new RequestHelper();
                jsonArray = requestHelper.getJSONArray(url, params, values);

                if (jsonArray != null) {
                    try {

                        produto = new Produto();
                        jsonObject =  (JSONObject) jsonArray.getJSONObject(0);
                        produto.setCodigo(jsonObject.getInt("codigo"));
                        produto.setCodbar(jsonObject.getString("codbar"));
                        produto.setDescricao(jsonObject.getString("descricao"));
                        produto.setVenda(jsonObject.getDouble("venda"));
                        produto.setSd_atu(jsonObject.getInt("sd_atu"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return true;
                }else{
                    return false;
                }
//                params= new String[] {"acao"};
//                requestHelper = new RequestHelper();
//                jsonArray = requestHelper.getJSONArray(url, params, values);
//                if(jsonArray != null) {
//                    try {
//                        listaFuncionario = new ArrayList<Funcionario>();
//
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            jsonObject = (JSONObject) jsonArray.get(i);
//                            f = new Funcionario();
//                            f.setCodigo(jsonObject.getInt("maxId"));
//                            f.setNome(jsonObject.getString("nomeFunc"));
//
//                            listaFuncionario.add(f);
//                            // aqui eu imprimo no console a lista pra testes(excluir ao terminar os testes)
//                            //                        System.out.println("id -> " + f.getCodigo() + "\nnome -> " + f.getNome() + "\nsobrenome -> " + f.getSobreNome() + "\ndataAdm -> " + f.getDataAdmissao() +
//                            //                                            "\ndataCad -> " + f.getDataCadastro() + "\ntipoFunc -> " + f.getTipoFuncionario() + "\nRg -> " + f.getRg() + "\nCpf -> " + f.getCpf() +
//                            //                                            "\nEnd -> " + f.getEndereco() + "\nNum -> " + f.getNumero() + "\nBairro -> " + f.getBairro() + "\nCep -> " + f.getCep() + "\ndataNasc -> " + f.getDataNascimento() +
//                            //                                            "\nSenha -> " + f.getSenha());
//                            //
//                        }
//                        return true;
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Log.e("ERRO", "Lista de Funcionario não carregada!");
//                    }
//                }else{
//                    return false;
//                }
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean flag) {
        switch (acao) {
            case "C":
                //insert()
//                dialog.dismiss();
//                if (flag) {
//                    mensagem.msgToast(contexto, "Cadastrado com Sucesso");
//                    adicionarSetor();
////                    Intent intent = (new Intent(contexto, FuncionarioListActivity.class));
////                    contexto.startActivity(intent);
//                }else {
//                    mensagem.msgToast(contexto, "Problema ao persistir os dados");
//                }
                break;
            case "R":
                //selectAll()
//                if (flag) {
//                    //System.out.println(flag);
//                    FuncionarioListViewAdapter adapter = new FuncionarioListViewAdapter(contexto, listaFuncionario);
//                    ListView listFuncionario = (ListView) ((FuncionarioListActivity) contexto).findViewById(R.id.listaFuncionario);
//                    listFuncionario.setAdapter(adapter);
//                    listFuncionario.setOnItemClickListener(verDetalhes());
//                    listFuncionario.setOnItemLongClickListener(ConfirmarExclusao());
//                    dialog.dismiss();
//                }else{
//                    mensagem.msgToast(contexto, "Lista Vazia!");
//                }
                break;
            case "U":
                //update()
//                if (flag){
//                    dialog.dismiss();
//                    mensagem.msgToast(contexto,"Dados atualizados com sucesso!");
//                    Intent intent = (new Intent(contexto, FuncionarioListActivity.class));
//                    contexto.startActivity(intent);
//                    ((FuncionarioDetailActivity) contexto).finish();
//                }else{
//                    mensagem.msgToast(contexto,"Problema ao atualizar os dados!");
//                }

                break;
            case "D":
                //delete()
//                if (flag){
//                    dialog.dismiss();
//                    mensagem.msgToast(contexto,"Registro Excluido com sucesso!");
//                    Intent intent = (new Intent(contexto, FuncionarioListActivity.class));
//                    contexto.startActivity(intent);
//
//                }else{
//                    mensagem.msgToast(contexto,"Problema ao excluir o registro!" );
//                }

                break;
            case "S":
                //selectPorId()
                dialog.dismiss();
                if (flag) {
                    ListaAdapterRegistro adapter = new ListaAdapterRegistro(contexto, listaRegistro);
                    ListView listRegistro = (ListView) ((FuncActivity) contexto).findViewById(R.id.lista_registro);
                    listRegistro.setAdapter(adapter);
                    if (!registro.getTtTrabalhado().equals("null:null:null")) {
                        Log.i("TAG",registro.getTtTrabalhado());
                        ((FuncActivity) contexto).lblTotalHoras.setVisibility(View.VISIBLE);

                        ((FuncActivity) contexto).lblTotalHoras.setText(((FuncActivity) contexto).lblTotalHoras.getText().toString().substring(0, 11) +
                                " | " + registro.getTtTrabalhado() + " |");
                    }
                    // lblNomeFunc.setText(getIntent().getStringExtra("username").substring(0, 1).toUpperCase().concat(getIntent().getStringExtra("username").substring(1).toLowerCase()));

//                    listRegistro.setOnItemClickListener(verDetalhes());
//                    listRegistro.setOnItemLongClickListener(ConfirmarExclusao());
//                    contexto.setText(lblTotalHoras.getText() +"  "+ DadosUsuario.getTotalTrabalhado());
//
                }else{

                    Log.i("TAG: ", "Lista ainda está vazia!");
                }

                break;
            case "L":
                dialog.dismiss();
                if (flag) {
                    //Define o nome e função no menu lateral.
//                    shared = contexto.getSharedPreferences(LoginActivity.LOGIN, contexto.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = shared.edit();
//
//                    editor.putString("usuario", Usuario.getNome());
//                    editor.putString("funcao", Usuario.getFuncao());
//                    editor.commit();

                    //salvo os dados na variavel global
                    // System.out.println("User: "+ shared.getString("usuario","Desconectado") +"\n Funcao: "+ shared.getString("funcao", ""));
                    Toast.makeText(contexto, "Bem Vindo(a) \"" + user.getNome().toUpperCase() + "\"", Toast.LENGTH_LONG).show();
                    if(DadosUsuario.getUsuario().getForma().equals("D1") || DadosUsuario.getUsuario().getForma().equals("L1")){

                        Intent intent = new Intent(contexto, FuncActivity.class);
                        intent.putExtra("username",DadosUsuario.getUsuario().getNome());
                        contexto.startActivity(intent);

                    }else if(DadosUsuario.getUsuario().getForma().equals("M1")) {
                        Intent intent = new Intent(contexto, MainActivity.class);
                        //intent.putExtra("username",DadosUsuario.getUsuario().getNome().toString());
                        contexto.startActivity(intent);

                    }else if(DadosUsuario.getUsuario().getForma().equals("M2")){
                            Intent intent = new Intent(contexto, PromoterActivity.class);
//                        Intent intent = new Intent(contexto, RegistroActivity.class);
//                        intent.putExtra("username",DadosUsuario.getUsuario().getNome().toString());
                        contexto.startActivity(intent);

                    }else if(DadosUsuario.getUsuario().getForma().equals("P2")){

                    }else if(DadosUsuario.getUsuario().getForma().equals("F1")){

                        Intent intent = new Intent(contexto, HomeActivity.class);
                        intent.putExtra("username",DadosUsuario.getUsuario().getNome());
                        contexto.startActivity(intent);
                    }

                    //                    nome.setText(Usuario.getNome());
//                    fucao.setText(Usuario.getFuncao());
//                      ***************************************************
                    //Fazer um if para saber qual interface abrir: caixa ou garçom
//                      ***************************************************

////                    intent.putExtra("nome", nome.getText().toString());
////                    intent.putExtra("funcao", fucao.getText().toString());
//                    contexto.startActivity(intent);
//                    ((LoginActivity) contexto).finish();
//
//                    Toast.makeText(contexto, "Bem vindo "+ Usuario.getNome() +"! ;)", Toast.LENGTH_LONG).show();
//
                }else {
                    Toast.makeText(contexto, "Usuário não encontrado. =(", Toast.LENGTH_LONG).show();
                }
                    break;
                    case "M":
                        //if (flag) {
//                    maxId = f.getCodigo();
//                    ultimoFunc = f.getNome();
//
//                    Intent intent = new Intent(contexto, SetorListActivity.class);
//                    intent.putExtra("codFunc", Integer.toString(maxId));
//                    intent.putExtra("nomeFunc", ultimoFunc);
//                    contexto.startActivity(intent);
//                    ((FuncionarioDetailActivity) contexto).finish();
               // }
                    break;
            case "P":
                dialog.dismiss();
                if (flag){

                    Toast.makeText(contexto,"Registrado com sucesso",Toast.LENGTH_LONG).show();
                    ((FuncActivity) contexto).carregaRegistros();

//                  ((FuncActivity) contexto).finish();

//                    Intent intent = new Intent(contexto, FuncActivity.class);
//                    intent.putExtra("username",DadosUsuario.getUsuario().getNome());
//                    contexto.startActivity(intent);

                }else{
                    Toast.makeText(contexto,"Problema ao tentar registrar",Toast.LENGTH_LONG).show();
                }
                break;
            case "PR":
                dialog.dismiss();
                if(flag){

                }else{

                }
                break;
        }
    }
public String formatDateToApp(String data){

    data = (data.toString().substring(6) + "/" +
            data.toString().substring(4,6) + "/" +
            data.toString().substring(0,4));//19880810

    return data;

}
    public String formatDateToDB(String data){

        data = (data.toString().substring(4) + "-" +
                data.toString().substring(2,4) + "-" +
                data.toString().substring(0,2));//10081988

        return data;
    }
    public Date parseDate(String dataStr, String tipo) {
        Date date;
        try {
            DateFormat formatter = new SimpleDateFormat(tipo);
            date = formatter.parse(dataStr);
            return date;
        }catch (ParseException e){
            return null;
        }
    }
    public String somarTotalHoras(String trabalhado){
        if(!trabalhado.equals("00:00:00")) {

            String[] aux = trabalhado.split(":");
            int[] ttHoras = {Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2])};

            //segundos
            ttHorasAux[2] = ttHorasAux[2] + ttHoras[2];
            if (ttHorasAux[2] > 60) {
                ttHorasAux[2] = ttHorasAux[2] - 60;
                ttHorasAux[1] = ttHorasAux[1] + 1;
            }
            System.out.println("SEGUNDOS: " + String.valueOf(ttHorasAux[2]));
            //minutos
            ttHorasAux[1] = ttHorasAux[1] + ttHoras[1];
            if (ttHorasAux[1] > 60) {
                ttHorasAux[1] = ttHorasAux[1] - 60;
                ttHorasAux[0] = ttHorasAux[0] + 1;
            }
            System.out.println("MINUTOS: " + String.valueOf(ttHorasAux[1]));
            //horas
            ttHorasAux[0] = ttHorasAux[0] + ttHoras[0];
            System.out.println("HORAS: " + String.valueOf(ttHorasAux[0]));

            hora = String.valueOf(ttHorasAux[0]);
            minuto = String.valueOf(ttHorasAux[1]);
            segundo = String.valueOf(ttHorasAux[2]);

            if (hora.length() == 1) {
                hora = "0" + hora;
            }
            if (minuto.length() == 1) {
                minuto = "0" + minuto;
            }
            if (segundo.length() == 1) {
                segundo = "0" + segundo;
            }
        }

       return String.valueOf(hora+":"+minuto+":"+segundo);

    }
}
