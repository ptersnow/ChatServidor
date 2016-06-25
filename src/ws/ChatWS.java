package ws;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import dao.ChatDAO;
import model.Chat;

public class  ChatWS{
	
	public String getListaChat(){
		List<Chat> listaChat = new ArrayList<Chat>();
		ChatDAO chDao = new ChatDAO();
		listaChat = chDao.recuperaTodos();
		Gson gson=new Gson();
		String json=gson.toJson(listaChat);
		return json;
	}
	public String inserirChat(String Chat){
		Gson gson=new Gson();
		Chat chatGson=gson.fromJson(Chat, Chat.class);
		ChatDAO chDao = new ChatDAO();
		Chat ch = new Chat();
		ch.setNome(chatGson.getNome());
		ch.setMensagem(chatGson.getMensagem());
		chDao.salva(ch);
		return "";
	}
}
