module com.github.cataratoru_fara_cap {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.fasterxml.jackson.databind;
    opens com.github.cataratoru_fara_cap to javafx.fxml;
    exports com.github.cataratoru_fara_cap;
}