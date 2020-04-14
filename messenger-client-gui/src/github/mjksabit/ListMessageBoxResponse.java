package github.mjksabit;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListMessageBoxResponse extends Response {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() throws JSONException {
        JSONArray list = new JSONArray(arg);
        JSONObject line;

        // System.out.println("Message Box List: ");

        // System.out.println("======================");

        ObservableList<String> observableList = ServerConnect.controller.msgboxDataProvider;
        Platform.runLater(observableList::clear);

        for (int i=list.length()-1; i>=0; i--) {
            line = list.getJSONObject(i);

            int id = line.getInt("id");
            String name = line.getString("name");
            int newMsg = line.getInt("unread");

            Platform.runLater(() -> observableList.add(id+" "+name+
                    (newMsg!=0 ? " ("+newMsg+")" : "" ))); // Do not show ( 0 )
            ;

//            System.out.println(line.getInt("id")+
//                    line.getString("name")+
//                    " ("+line.getInt("unread")+")");
        }
//        System.out.println("=====================");



        return null;
    }
}
