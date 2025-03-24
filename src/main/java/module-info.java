module All.the.way.UP {
    requires hanyaeger;
    requires javafx.media;

    exports org.example;

    opens audio;
    opens afbeeldingen;
    opens video;
}