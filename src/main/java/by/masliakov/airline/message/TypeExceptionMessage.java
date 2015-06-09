package by.masliakov.airline.message;

import java.util.ResourceBundle;

/**
 * Created by mrstark on 9.6.15.
 */
public enum TypeExceptionMessage {
    WRONG_CONFIGURE("fileconf.wrong_configure"),
    FILE_NOT_FOUND("fileconnect.file_not_found");

    private String description;

    private ResourceBundle bundle = ResourceBundle.getBundle("src.main.message");

    private TypeExceptionMessage(String key) {

        this.description = bundle.getString(key);

    }

    public String getDescription() {
        return description;
    }
}
