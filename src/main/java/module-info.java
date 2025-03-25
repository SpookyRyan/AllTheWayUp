module All.the.way.UP {
    requires hanyaeger;
    requires javafx.media;
    requires com.google.guice;
    requires jdk.jfr;

    exports org.example;

    opens audio;
    opens afbeeldingen;
    opens video;
    opens Sprites;
}