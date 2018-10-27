package cliente;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class ListadeChat extends AbstractListModel {
	
	ArrayList<String> chat;
	
	@Override
	public String getElementAt(int index) {
		return chat.get(index);
	}

	@Override
	public int getSize() {
		return chat.size();
	}

}
