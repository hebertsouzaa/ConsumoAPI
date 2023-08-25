package projeto_sam;

// ============================ABA IMPORTS==========================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.*;


//============================ABA HELPERS==========================
public static JSONObject AtividadeProgramada(String token, String API_URL) throws IOException {
    // Cria uma URL a partir da string da URL da API fornecida
    URL url = new URL(API_URL);
    
    // Abre uma conexão HTTP para a URL
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    
    // Configura o método de requisição como GET
    conn.setRequestMethod("GET");
    
    // Define o cabeçalho de autorização com o token fornecido
    conn.setRequestProperty("Authorization", "Bearer " + token);

    try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
        StringBuilder response = new StringBuilder();
        String line;
        
        // Lê a resposta da API linha por linha e a adiciona ao StringBuilder
        while ((line = br.readLine()) != null) {
            response.append(line);
        }

        // Converte a resposta em formato de string para um objeto JSONObject
        JSONObject obj = new JSONObject(response.toString());
        
        // Retorna o objeto JSONObject resultante
        return obj;
    }
}
















//============================ABA ON INPUT=========================
try {
// Chama o método AtividadeProgramada para fazer a requisição à API
	JSONObject response = AtividadeProgramada(token,"site");
// Obtém o array "Retorno" do objeto JSON de resposta
     JSONArray retornoArray = response.getJSONArray("Retorno");
      for (int i = 0; i < retornoArray.length(); i++) {
	            JSONObject item = retornoArray.getJSONObject(i);
// Extrai os valores dos campos do JSON
CodTipoManutencao=item.getString("Id");
MdaIntervencaoSGI=item.getString("CodSGI");
DatAtivacaoAtividade=item.getString("DataAtivacaoAtividade");
DatAtivacaoAtividadeNoPlan=item.getString("DataAtivacaoAtividadeNoPlanejamento");
DatAtivacaoPlanoManutencao=item.getString("DataAtivacaoPlanoManutencao");
DatCadastroDeCorrente=item.getString("DataCadastroDeCorrente");
DatDesativacaoAtividade=item.getString("DataDesativacaoAtividade");
DatDesativacaoAtividadeNoPlan=item.getString("DataDesativacaoAtividadeNoPlanejamento");
DatDesativacaoPlanoManutencao=item.getString("DataDesativacaoPlanoManutencao");
DatTolerancia=item.getString("DataTolerancia");
DatIntervencaoSGI=item.getString("DataIntervencaoSGI");
DatLaudo=item.getString("DataLaudo");
DatPrevista=item.getString("DataPrevista");
DatRealizacao=item.getString("DataRealizacao");
DatUltimaRealizacao=item.getString("DataUltimaRealizacao");
TxtDescricaoAtividadeCondicao=item.getString("DescricaoAtividadeCondicao");
TxtDescricaoLaudo=item.getString("DescricaoLaudo");
CodAgente=item.getString("IdAgente");
CodEquipamento=item.getString("IdEquipamento");
CodInstalacao=item.getString("IdInstalacao");
CodSistemaSGI=item.getString("IdSGI");
CodTipoEquipamento=item.getString("IdTipoEquipamento");
IdcManutencaoDecorrente=item.getString("IndicaDecorrente");
TxtJustificativa=item.getString("TextoDescricaoJustificativaLaudo");
NomAtividadeManutencao=item.getString("NomeAtividadeManutencao");
NomCurtoAgente=item.getString("NomeCurtoAgente");
NomLongoAgente=item.getString("NomeLongoAgente");
CodTipoAtividadeManutencao=item.getString("TipoAtividaDeManutencao");
CodTipoLaudo=item.getString("TipoJustificativaLaudo");
DthAtualizacao=item.getString("DataAlteracaoProgramacao");
CodMRIDAtividadeManutencao=item.getString("MRIDAtividadeManutencao");
CodMRIDInstalacao=item.getString("MRIDInstalacao");
NomFamiliaEquipamento=item.getString("FamiliaEquipamentoNome");
CodMRIDEquipamento=item.getString("MRIDEquipamento");
IdcLaudoSubstitutivo=item.getString("LaudoSubstitutivoFlag");
DscLaudoSubstituicao=item.getString("LaudoSubstituicaoDescricao");
// Converte os valores booleanos em strings "true" ou "false"
boolean atividadeForaDoPlano = item.getBoolean("AtividadeForaDoPlano");          
String atividadeForaDoPlanoStrteste = atividadeForaDoPlano ? "true" : "false";
IdcAtividadeForaPlano=atividadeForaDoPlanoStrteste;
boolean flgSubstituiRequisito = item.getBoolean("FlgSubstituiRequisito");
String flgSubstituiRequisitoStrteste = flgSubstituiRequisito ? "true" : "false";
IdcSubstituiRequisito=flgSubstituiRequisitoStrteste;
Data_Insercao=Dt_Insert;
// Chama o método generateRow() para criar uma linha de dados
	            generateRow();
	            }
} catch (IOException e) {
// Em caso de exceção de I/O (IOException), imprime o rastreamento do erro
    e.printStackTrace();
}


